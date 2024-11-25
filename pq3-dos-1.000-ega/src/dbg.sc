;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 899)
(include sci.sh)
(use Main)
(use Interface)
(use Feature)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	dbg 0
)

(local
	local0
)

(procedure (localproc_0 param1 param2 &tmp [temp0 40])
	(= temp0 0)
	(if (> argc 1)
		(Format @temp0 899 0 param2) ; "%d"
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

(instance dbg of Feature
	(properties)

	(method (handleEvent event &tmp [temp0 75] temp75 temp76 temp77 temp78 temp79 temp80 temp81 temp82 temp83 temp84 temp85 temp86)
		(switch (event type:)
			(evKEYBOARD
				(event claimed: 1)
				(switch (event message:)
					(KEY_ALT_k
						(= temp75 (GetPort))
						(SetPort 0)
						(= temp85 5)
						(= temp86 16)
						(= temp81 15)
						(= temp82 80)
						(= temp84 (+ temp81 (* 34 temp85)))
						(= temp83 (+ temp82 (* 10 temp86)))
						(= temp79 (Graph grSAVE_BOX temp81 temp82 temp84 temp83 1))
						(Graph grFILL_BOX temp81 temp82 temp84 temp83 1 255)
						(for ((= temp80 0)) (< temp80 256) ((++ temp80))
							(Graph
								grFILL_BOX
								(+ temp81 temp85 (* temp85 (/ temp80 8)))
								(+ temp82 temp86 (* 16 (mod temp80 8)))
								(+ temp81 temp85 temp85 (* temp85 (/ temp80 8)))
								(+
									temp82
									temp86
									temp86
									(* temp86 (mod temp80 8))
								)
								1
								temp80
							)
						)
						(Graph grUPDATE_BOX temp81 temp82 temp84 temp83 1)
						(repeat
							(= temp76 (Event new:))
							(if (or (== (temp76 type:) evMOUSEBUTTON) (== (temp76 type:) evKEYBOARD))
								(break)
							)
							(temp76 dispose:)
						)
						(temp76 dispose:)
						(Graph grRESTORE_BOX temp79)
						(Graph grUPDATE_BOX temp81 temp82 temp84 temp83 1)
						(SetPort temp75)
					)
					(KEY_ALT_f
						(gGame showMem:)
					)
					(KEY_ALT_g
						(= temp0 0)
						(GetInput @temp0 4 {Variable No.})
						(= temp77 (ReadNumber @temp0))
						(= temp0 0)
						(GetInput @temp0 4 {Value})
						(= [gEgo temp77] (ReadNumber @temp0))
						(= temp0 0)
					)
					(KEY_ALT_h
						(= temp0 0)
						(GetInput @temp0 4 {Variable No.})
						(= temp77 (ReadNumber @temp0))
						(if (IsObject [gEgo temp77])
							(Printf 899 1 temp77 ([gEgo temp77] name:)) ; "Global %d: %s"
						else
							(Printf 899 2 temp77 [gEgo temp77]) ; "Global %d: %d"
						)
						(= temp0 0)
					)
					(KEY_ALT_v
						(Show 1)
					)
					(KEY_ALT_p
						(localproc_1)
						(Show 2)
					)
					(KEY_ALT_c
						(localproc_1)
						(Show 4)
						(Animate (gCast elements:))
						(while (== evNULL ((= event (Event new: $7ffd)) type:)) ; evVERB | evHELP | evMOVE | evJOYUP | evJOYDOWN | evSAID | direction | evMENUHIT | evMENUSTART | evKEYUP | evMOUSEKEYBOARD | $0c00
							(event dispose:)
						)
						(event dispose:)
						(Show 1)
					)
					(KEY_ALT_e
						(if (gCast contains: gEgo)
							(Print
								(Format ; "view: %d loop: %d cel: %d posn: %d %d %d heading: %d pri: %d signal: $%x illBits: $%x normal: %d OnControl: $%x Origin on: $%x"
									@temp0
									899
									3
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
						else
							(Print 899 4) ; "Sorry, no ego in cast."
						)
					)
					(KEY_ALT_a
						(for
							((= temp77 (gCast first:)))
							temp77
							((= temp77 (gCast next: temp77)))
							
							(= temp78 (NodeValue temp77))
							(Print
								(Format ; "NAME: %s class: %s view: %d loop: %d cel: %d posn: %d %d %d heading: %d pri: %d signal: $%x illBits: $%x"
									@temp0
									899
									5
									(temp78 name:)
									((temp78 superClass:) name:)
									(temp78 view:)
									(temp78 loop:)
									(temp78 cel:)
									(temp78 x:)
									(temp78 y:)
									(temp78 z:)
									(temp78 heading:)
									(temp78 priority:)
									(temp78 signal:)
									(if
										(or
											(== (temp78 superClass:) Actor)
											(== (temp78 superClass:) Ego)
										)
										(temp78 illegalBits:)
									else
										-1
									)
								)
								#icon
								(temp78 view:)
								(temp78 loop:)
								(temp78 cel:)
							)
						)
					)
					(KEY_ALT_t
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(if (> (= temp77 (GetNumber {Teleport to:})) 0)
							(gLongSong stop:)
							(gCurRoom newRoom: temp77)
						)
					)
					(KEY_ALT_d
						(if (= gDebugOn (not gDebugOn))
							(Print 899 6) ; "Debug On"
						else
							(Print 899 7) ; "Debug Off"
						)
					)
					(KEY_ALT_r
						(Printf ; "Current Room: %d name: %s script: %s horizon: %d vanishing X: %d vanishing Y: %d pic angle: %d north: %d south: %d east: %d west: %d style: %d current pic: %d"
							899
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
							899
							9
							(gCurRoom vanishingX:)
							(gCurRoom vanishingY:)
						)
						(= temp77 (localproc_0 {vanishingX:}))
						(or
							(OneOf temp77 -1 0)
							(gCurRoom vanishingX: temp77)
						)
						(= temp77 (localproc_0 {vanishingY:}))
						(or
							(OneOf temp77 -1 0)
							(gCurRoom vanishingY: temp77)
						)
						(Printf ; "vanishing x: %d y: %d"
							899
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
						(gTheIconBar enable: 0 1 2 3 4 5)
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
					(JOY_RIGHT
						(repeat
							(breakif
								(!= (= temp77 (GetNumber {Clear Flag#: })) -1)
							)
						)
						(ClearFlag temp77)
					)
					(KEY_PAUSE
						(repeat
							(breakif
								(!= (= temp77 (GetNumber {Set Flag#: })) -1)
							)
						)
						(SetFlag temp77)
					)
					(JOY_DOWNLEFT
						(= temp77 (GetNumber {Enter Flag Number:}))
						(if (IsFlag temp77)
							(Print 899 10) ; "Flag is set."
						else
							(Print 899 11) ; "Flag is clear."
						)
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
						(= temp75
							(Print
								(Format @temp0 899 12 (event x:) (event y:)) ; "%d %d"
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
						(while (!= evMOUSERELEASE ((= temp76 (Event new:)) type:))
							(temp76 dispose:)
						)
						(temp76 dispose:)
						(temp75 dispose:)
					)
					((== (event modifiers:) $000c) ; emALT | emCTRL
						(event claimed: 1)
						(while (!= evMOUSERELEASE ((= temp76 (Event new:)) type:))
							((User alterEgo:)
								posn: (temp76 x:) (- (temp76 y:) 10)
								setMotion: 0
							)
							(Animate (gCast elements:) 0)
							(temp76 dispose:)
						)
						(temp76 dispose:)
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

