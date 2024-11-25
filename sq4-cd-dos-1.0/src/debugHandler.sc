;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 800)
(include sci.sh)
(use Main)
(use Interface)
(use Sq4Dialog)
(use Sq4Feature)
(use Print)
(use Dialog)
(use PolyEdit)
(use WriteFeature)
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

(procedure (localproc_0)
	(if (OneOf (gCurRoom style:) 11 12 13 14)
		(gCurRoom drawPic: (gCurRoom picture:) 100 style: 100)
	)
)

(instance debugHandler of Sq4Feature
	(properties
		x -1
		y -1
	)

	(method (handleEvent event &tmp [temp0 301] temp301 temp302 temp303 temp304 temp305 temp306 temp307 temp308 temp309 temp310 temp311 temp312)
		(switch (event type:)
			(evKEYBOARD
				(event claimed: 1)
				(switch (event message:)
					(KEY_ALT_k
						(= temp301 (GetPort))
						(SetPort 0)
						(= temp311 5)
						(= temp312 16)
						(= temp307 15)
						(= temp308 80)
						(= temp310 (+ temp307 (* 34 temp311)))
						(= temp309 (+ temp308 (* 10 temp312)))
						(= temp305 (Graph grSAVE_BOX temp307 temp308 temp310 temp309 1))
						(Graph grFILL_BOX temp307 temp308 temp310 temp309 1 255)
						(for ((= temp306 0)) (< temp306 256) ((++ temp306))
							(Graph
								grFILL_BOX
								(+ temp307 temp311 (* temp311 (/ temp306 8)))
								(+ temp308 temp312 (* 16 (mod temp306 8)))
								(+
									temp307
									temp311
									temp311
									(* temp311 (/ temp306 8))
								)
								(+
									temp308
									temp312
									temp312
									(* temp312 (mod temp306 8))
								)
								1
								temp306
							)
						)
						(Graph grUPDATE_BOX temp307 temp308 temp310 temp309 1)
						(repeat
							(= temp302 (Event new:))
							(if
								(or
									(== (temp302 type:) evMOUSEBUTTON)
									(== (temp302 type:) evKEYBOARD)
								)
								(break)
							)
							(temp302 dispose:)
						)
						(temp302 dispose:)
						(Graph grRESTORE_BOX temp305)
						(Graph grUPDATE_BOX temp307 temp308 temp310 temp309 1)
						(SetPort temp301)
					)
					(KEY_ALT_f
						(gGame showMem:)
					)
					(KEY_ALT_g
						(= temp0 0)
						(proc816_0 @temp0 6 {Variable No.})
						(= temp303 (ReadNumber @temp0))
						(= temp0 0)
						(proc816_0 @temp0 6 {Value})
						(= [gEgo temp303] (ReadNumber @temp0))
						(= temp0 0)
					)
					(KEY_ALT_h
						(= temp0 0)
						(proc816_0 @temp0 6 {Variable No.})
						(= temp303 (ReadNumber @temp0))
						(if (IsObject [gEgo temp303])
							(proc816_2 800 0 temp303 ([gEgo temp303] name:))
						else
							(proc816_2 800 1 temp303 [gEgo temp303])
						)
						(= temp0 0)
					)
					(KEY_ALT_v
						(Show 1)
					)
					(KEY_ALT_m
						(proc816_2 800 2 (+= gBuckazoidCount 20))
					)
					(KEY_ALT_p
						(localproc_0)
						(Show 2)
					)
					(KEY_ALT_c
						(localproc_0)
						(Show 4)
						(Animate (gCast elements:))
						(while (== evNULL ((= event (Event new: $7ffd)) type:)) ; evVERB | evHELP | evMOVE | evJOYUP | evJOYDOWN | evSAID | direction | evMENUHIT | evMENUSTART | evKEYUP | evMOUSEKEYBOARD | $0c00
							(event dispose:)
						)
						(event dispose:)
						(Show 1)
					)
					(KEY_ALT_e
						(proc816_2
							800
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
							((gEgo _head:) view:)
							(gEgo onControl:)
							(gEgo onControl: 1)
						)
					)
					(KEY_ALT_a
						(for
							((= temp303 (gCast first:)))
							temp303
							((= temp303 (gCast next: temp303)))
							
							(= temp304 (NodeValue temp303))
							(proc816_2
								800
								4
								((temp304 -super-:) name:)
								(temp304 view:)
								(temp304 loop:)
								(temp304 cel:)
								(temp304 x:)
								(temp304 y:)
								(temp304 z:)
								(temp304 heading:)
								(temp304 priority:)
								(temp304 signal:)
								(if (temp304 isKindOf: Actor)
									(temp304 illegalBits:)
								else
									-1
								)
							)
						)
					)
					(KEY_ALT_t
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(if (> (= temp303 (GetNumber {Teleport to:})) 0)
							(gLongSong stop:)
							(++ global171)
							(gCurRoom newRoom: temp303)
						)
					)
					(KEY_ALT_d
						(if (= gDebugOn (not gDebugOn))
							(Prints 800 5)
						else
							(Prints 800 6)
						)
					)
					(KEY_ALT_r
						(proc816_2
							800
							7
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
						(proc816_2
							800
							8
							(gCurRoom vanishingX:)
							(gCurRoom vanishingY:)
						)
						(= temp303 (GetNumber {vanishingX:}))
						(or
							(OneOf temp303 -1 0)
							(gCurRoom vanishingX: temp303)
						)
						(= temp303 (GetNumber {vanishingY:}))
						(or
							(OneOf temp303 -1 0)
							(gCurRoom vanishingY: temp303)
						)
						(proc816_2
							800
							8
							(gCurRoom vanishingX:)
							(gCurRoom vanishingY:)
						)
					)
					(KEY_ALT_w
						(WriteCode doit:)
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
						(PolyEdit doit:)
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
						(= temp301
							(proc816_2
								@temp0
								800
								9
								(event x:)
								(event y:)
								64
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
								30
								999
								111
							)
						)
						(while (!= evMOUSERELEASE ((= temp302 (Event new:)) type:))
							(temp302 dispose:)
						)
						(temp302 dispose:)
						(temp301 dispose:)
					)
					((== (event modifiers:) $000c) ; emALT | emCTRL
						(event claimed: 1)
						(while (!= evMOUSERELEASE ((= temp302 (Event new:)) type:))
							((User alterEgo:)
								posn: (temp302 x:) (- (temp302 y:) 10)
								setMotion: 0
							)
							(Animate (gCast elements:) 0)
							(temp302 dispose:)
						)
						(temp302 dispose:)
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
		(self eachElementDo: #dispose 1 dispose:)
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

