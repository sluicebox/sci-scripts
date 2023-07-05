;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 800)
(include sci.sh)
(use Main)
(use Interface)
(use Feature)
(use Window)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	debugHandler 0
)

(local
	local0
)

(procedure (localproc_0 param1 param2 &tmp [temp0 40])
	(= temp0 0)
	(if (> argc 1)
		(Format @temp0 800 0 param2) ; "%d"
	)
	(return
		(if (GetInput @temp0 10 param1)
			(ReadNumber @temp0)
		else
			-1
		)
	)
)

(procedure (localproc_1)
	(if (OneOf (gCurRoom style:) 11 12 13 14)
		(gCurRoom drawPic: (gCurRoom picture:) 100 style: 100)
	)
)

(instance debugHandler of Feature
	(properties)

	(method (handleEvent event &tmp [temp0 76] temp76 temp77 temp78 temp79 temp80 temp81 temp82 temp83 temp84 temp85 temp86 temp87)
		(switch (event type:)
			(evKEYBOARD
				(event claimed: 1)
				(switch (event message:)
					(KEY_ALT_k
						(= temp76 (GetPort))
						(SetPort 0)
						(= temp86 5)
						(= temp87 16)
						(= temp82 15)
						(= temp83 80)
						(= temp85 (+ temp82 (* 34 temp86)))
						(= temp84 (+ temp83 (* 10 temp87)))
						(= temp80 (Graph grSAVE_BOX temp82 temp83 temp85 temp84 1))
						(Graph grFILL_BOX temp82 temp83 temp85 temp84 1 255)
						(for ((= temp81 0)) (< temp81 256) ((++ temp81))
							(Graph
								grFILL_BOX
								(+ temp82 temp86 (* temp86 (/ temp81 8)))
								(+ temp83 temp87 (* 16 (mod temp81 8)))
								(+ temp82 temp86 temp86 (* temp86 (/ temp81 8)))
								(+
									temp83
									temp87
									temp87
									(* temp87 (mod temp81 8))
								)
								1
								temp81
							)
						)
						(Graph grUPDATE_BOX temp82 temp83 temp85 temp84 1)
						(repeat
							(= temp77 (Event new:))
							(if (or (== (temp77 type:) evMOUSEBUTTON) (== (temp77 type:) evKEYBOARD))
								(break)
							)
							(temp77 dispose:)
						)
						(temp77 dispose:)
						(Graph grRESTORE_BOX temp80)
						(Graph grUPDATE_BOX temp82 temp83 temp85 temp84 1)
						(SetPort temp76)
					)
					(KEY_ALT_f
						(gGame showMem:)
					)
					(KEY_ALT_g
						(= temp0 0)
						(GetInput @temp0 4 {Variable No.})
						(= temp78 (ReadNumber @temp0))
						(= temp0 0)
						(GetInput @temp0 4 {Value})
						(= [gEgo temp78] (ReadNumber @temp0))
						(= temp0 0)
					)
					(KEY_ALT_h
						(= temp0 0)
						(GetInput @temp0 4 {Variable No.})
						(= temp78 (ReadNumber @temp0))
						(if (IsObject [gEgo temp78])
							(Printf 800 1 temp78 ([gEgo temp78] name:)) ; "Global %d: %s"
						else
							(Printf 800 2 temp78 [gEgo temp78]) ; "Global %d: %d"
						)
						(= temp0 0)
					)
					(KEY_ALT_v
						(Show 1)
					)
					(KEY_ALT_m
						(Printf 800 3 (+= gBuckazoidCount 20)) ; "You now have %d Buckazoids."
					)
					(KEY_ALT_p
						(localproc_1)
						(Show 2)
					)
					(KEY_ALT_c
						(localproc_1)
						(Show 4)
						(Animate (gCast elements:))
						(while (== evNULL ((= event (Event new: 32765)) type:))
							(event dispose:)
						)
						(event dispose:)
						(Show 1)
					)
					(KEY_ALT_e
						(Print
							(Format ; "view: %d loop: %d cel: %d posn: %d %d %d heading: %d pri: %d signal: $%x illBits: $%x normal: %d head view: %d OnControl: $%x Origin on: $%x"
								@temp0
								800
								4
								(gEgo view:)
								(gEgo loop:)
								(gEgo cel:)
								(gEgo x:)
								(gEgo y:)
								(gEgo z:)
								(gEgo heading:)
								(gEgo priority:)
								(gEgo signal:)
								(gEgo illegalBits:)
								(gEgo normal:)
								((gEgo _head:) view:)
								(gEgo onControl:)
								(gEgo onControl: 1)
							)
							#title
							(gEgo name:)
							#icon
							(gEgo view:)
							(gEgo loop:)
							(gEgo cel:)
						)
					)
					(KEY_ALT_a
						(for
							((= temp78 (gCast first:)))
							temp78
							((= temp78 (gCast next: temp78)))
							
							(= temp79 (NodeValue temp78))
							(Print
								(Format ; "class: %s view: %d loop: %d cel: %d posn: %d %d %d heading: %d pri: %d signal: $%x illBits: $%x"
									@temp0
									800
									5
									((temp79 superClass:) name:)
									(temp79 view:)
									(temp79 loop:)
									(temp79 cel:)
									(temp79 x:)
									(temp79 y:)
									(temp79 z:)
									(temp79 heading:)
									(temp79 priority:)
									(temp79 signal:)
									(if
										(or
											(== (temp79 superClass:) Actor)
											(== (temp79 superClass:) Ego)
										)
										(temp79 illegalBits:)
									else
										-1
									)
								)
								#window
								SysWindow
								#title
								(temp79 name:)
								#icon
								(temp79 view:)
								(temp79 loop:)
								(temp79 cel:)
							)
						)
					)
					(KEY_ALT_t
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(if (> (= temp78 (GetNumber {Teleport to:})) 0)
							(gLongSong stop:)
							(++ global171)
							(gCurRoom newRoom: temp78)
						)
					)
					(KEY_ALT_d
						(if (= gDebugOn (not gDebugOn))
							(Print 800 6) ; "Debug On"
						else
							(Print 800 7) ; "Debug Off"
						)
					)
					(KEY_ALT_r
						(Printf ; "Current Room: %d name: %s script: %s horizon: %d vanishing X: %d vanishing Y: %d pic angle: %d north: %d south: %d east: %d west: %d style: %d current pic: %d"
							800
							8
							gCurRoomNum
							(gCurRoom name:)
							(if (IsObject (gCurRoom script:))
								((gCurRoom script:) name:)
							else
								{..none..}
							)
							(gCurRoom horizon:)
							(gCurRoom vanishingX:)
							(gCurRoom vanishingY:)
							(gCurRoom picAngle:)
							(gCurRoom north:)
							(gCurRoom south:)
							(gCurRoom east:)
							(gCurRoom west:)
							(gCurRoom style:)
							(gCurRoom curPic:)
						)
					)
					(KEY_ALT_y
						(Printf ; "vanishing x: %d y: %d"
							800
							9
							(gCurRoom vanishingX:)
							(gCurRoom vanishingY:)
						)
						(= temp78 (localproc_0 {vanishingX:}))
						(or
							(OneOf temp78 -1 0)
							(gCurRoom vanishingX: temp78)
						)
						(= temp78 (localproc_0 {vanishingY:}))
						(or
							(OneOf temp78 -1 0)
							(gCurRoom vanishingY: temp78)
						)
						(Printf ; "vanishing x: %d y: %d"
							800
							9
							(gCurRoom vanishingX:)
							(gCurRoom vanishingY:)
						)
					)
					(KEY_ALT_w
						(Unknown_Class_102 doit:)
					)
					(KEY_ALT_u
						(User canInput: 1 canControl: 1)
						(gTheIconBar enable: 0 1 2 3 4 5 6 7)
					)
					(KEY_ALT_z
						(= gQuit 1)
					)
					(KEY_ALT_i
						(dInvD doit:)
					)
					(KEY_ALT_b
						(Unknown_Class_100 doit:)
					)
					(else
						(event claimed: 0)
					)
				)
			)
			(evMOUSEBUTTON
				(cond
					((== (event modifiers:) emALT)
						(event claimed: 1)
						(= temp76
							(Print
								(Format @temp0 800 10 (event x:) (event y:)) ; "%d %d"
								#at
								(cond
									((< (event x:) 23) 3)
									((> (event x:) 292) 273)
									(else
										(- (event x:) 20)
									)
								)
								(cond
									((< (event y:) 9) 3)
									((> (event y:) 175) 170)
									(else
										(- (event y:) 6)
									)
								)
								#font
								999
								#dispose
							)
						)
						(while (!= evMOUSERELEASE ((= temp77 (Event new:)) type:))
							(temp77 dispose:)
						)
						(temp77 dispose:)
						(temp76 dispose:)
					)
					((== (event modifiers:) $000c) ; emALT | emCTRL
						(event claimed: 1)
						(while (!= evMOUSERELEASE ((= temp77 (Event new:)) type:))
							((User alterEgo:)
								posn: (temp77 x:) (- (temp77 y:) 10)
								setMotion: 0
							)
							(Animate (gCast elements:) 0)
							(temp77 dispose:)
						)
						(temp77 dispose:)
					)
				)
			)
		)
	)
)

(instance dInvD of Dialog
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp2 (= temp0 (= temp1 4)))
		(= temp3 0)
		(for
			((= temp5 (gInventory first:)))
			temp5
			((= temp5 (gInventory next: temp5)))
			
			(= temp6 (NodeValue temp5))
			(++ temp3)
			(if (temp6 isKindOf: InvI)
				(self
					add:
						((= temp4 (DText new:))
							value: temp6
							text: (temp6 name:)
							nsLeft: temp0
							nsTop: temp1
							state: 3
							font: gSmallFont
							setSize:
							yourself:
						)
				)
			)
			(if (< temp2 (- (temp4 nsRight:) (temp4 nsLeft:)))
				(= temp2 (- (temp4 nsRight:) (temp4 nsLeft:)))
			)
			(if (> (+= temp1 (+ (- (temp4 nsBottom:) (temp4 nsTop:)) 1)) 140)
				(= temp1 4)
				(+= temp0 (+ temp2 10))
				(= temp2 0)
			)
		)
		(= window gSystemWindow)
		(self setSize:)
		(= local0 (DButton new:))
		(local0
			text: {Outta here!}
			setSize:
			moveTo: (- nsRight (+ 4 (local0 nsRight:))) nsBottom
		)
		(local0 move: (- (local0 nsLeft:) (local0 nsRight:)) 0)
		(self add: local0 setSize: center:)
		(return temp3)
	)

	(method (doit &tmp temp0)
		(self init:)
		(self open: 4 15)
		(= temp0 local0)
		(repeat
			(if
				(or
					(not (= temp0 (super doit: temp0)))
					(== temp0 -1)
					(== temp0 local0)
				)
				(break)
			)
			((temp0 value:) owner: gEgo)
		)
		(self dispose:)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(= temp0 (event message:))
		(switch (= temp1 (event type:))
			(evKEYBOARD
				(switch temp0
					(KEY_UP
						(= temp0 KEY_SHIFTTAB)
					)
					(KEY_DOWN
						(= temp0 KEY_TAB)
					)
				)
			)
			($0040 ; direction
				(switch temp0
					(JOY_UP
						(= temp0 KEY_SHIFTTAB)
						(= temp1 evKEYBOARD)
					)
					(JOY_DOWN
						(= temp0 KEY_TAB)
						(= temp1 evKEYBOARD)
					)
				)
			)
		)
		(event type: temp1 message: temp0)
		(super handleEvent: event)
	)
)

