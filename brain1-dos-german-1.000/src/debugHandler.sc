;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 800)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use Interface)
(use WriteFeature)
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

(procedure (localproc_0 param1 param2 &tmp [temp0 120])
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

	(method (handleEvent event &tmp [temp0 75] temp75 temp76 temp77 temp78 temp79 temp80 temp81 temp82 temp83 temp84)
		(switch (event type:)
			(evKEYBOARD
				(event claimed: 1)
				(switch (event message:)
					(KEY_ALT_f
						(gGame showMem:)
					)
					(KEY_ALT_g
						(= temp0 0)
						(GetInput @temp0 4 {Variable No.})
						(= temp79 (ReadNumber @temp0))
						(= temp0 0)
						(GetInput @temp0 4 {Value})
						(= [temp75 (- temp79 100)] (ReadNumber @temp0))
						(= temp0 0)
					)
					(KEY_ALT_v
						(Show 1)
					)
					(KEY_ALT_o
						(= temp81 (List new:))
						(for
							((= temp82 (FirstNode (gCast elements:))))
							temp82
							((= temp82 (NextNode temp82)))
							
							(= temp83 (NodeValue temp82))
							(if
								(and
									(IsObject temp83)
									(not (& (temp83 signal:) $0080))
								)
								(temp81
									add:
										((LineBox new:)
											drawBox:
												(temp83 nsTop:)
												(temp83 nsLeft:)
												(temp83 nsBottom:)
												(temp83 nsRight:)
												0
												7
											yourself:
										)
										((LineBox new:)
											drawBox:
												(temp83 brTop:)
												(temp83 brLeft:)
												(temp83 brBottom:)
												(temp83 brRight:)
												12
												31
											yourself:
										)
										((LineBox new:)
											drawBox:
												(temp83 y:)
												(temp83 x:)
												(temp83 y:)
												(temp83 x:)
												32
												63
											yourself:
										)
								)
							)
						)
						(while (== ((= temp84 (Event new:)) type:) evNULL)
							(temp84 dispose:)
						)
						(temp84 dispose:)
						(temp81 dispose:)
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
					(KEY_ALT_a
						(for
							((= temp79 (gCast first:)))
							temp79
							((= temp79 (gCast next: temp79)))
							
							(= temp80 (NodeValue temp79))
							(proc5_9
								(Format ; "class: %s view: %d loop: %d cel: %d posn: %d %d %d heading: %d pri: %d signal: $%x illBits: $%x"
									@temp0
									800
									1
									((temp80 superClass:) name:)
									(temp80 view:)
									(temp80 loop:)
									(temp80 cel:)
									(temp80 x:)
									(temp80 y:)
									(temp80 z:)
									(temp80 heading:)
									(temp80 priority:)
									(temp80 signal:)
									(if
										(or
											(== (temp80 superClass:) Actor)
											(== (temp80 superClass:) Ego)
										)
										(temp80 illegalBits:)
									else
										-1
									)
								)
								35
								SysWindow
								80
								(temp80 name:)
								82
								(temp80 view:)
								(temp80 loop:)
								(temp80 cel:)
							)
						)
					)
					(JOY_RIGHT
						(repeat
							(breakif
								(!= (= temp79 (GetNumber {Clear Flag#: })) -1)
							)
						)
						(ClearFlag temp79)
					)
					(KEY_PAUSE
						(repeat
							(breakif
								(!= (= temp79 (GetNumber {Set Flag#: })) -1)
							)
						)
						(SetFlag temp79)
					)
					(JOY_DOWNLEFT
						(= temp79 (GetNumber {Enter Flag Number:}))
						(if (IsFlag temp79)
							(Print 800 2) ; "Flag is set."
						else
							(Print 800 3) ; "Flag is clear."
						)
					)
					(KEY_ALT_t
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(gCMusic stop:)
						(if (> (= temp79 (GetNumber {Teleport to:})) 0)
							(gCurRoom newRoom: temp79)
						)
					)
					(KEY_ALT_d
						(if (= gDebugOn (not gDebugOn))
							(proc5_9 800 4) ; "Debug On"
						else
							(proc5_9 800 5) ; "Debug Off"
						)
					)
					(KEY_ALT_r
						(Printf ; "Current Room: %d name: %s script: %s horizon: %d vanishing X: %d vanishing Y: %d pic angle: %d north: %d south: %d east: %d west: %d style: %d current pic: %d"
							800
							6
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
							7
							(gCurRoom vanishingX:)
							(gCurRoom vanishingY:)
						)
						(= temp79 (localproc_0 {vanishingX:}))
						(or
							(OneOf temp79 -1 0)
							(gCurRoom vanishingX: temp79)
						)
						(= temp79 (localproc_0 {vanishingY:}))
						(or
							(OneOf temp79 -1 0)
							(gCurRoom vanishingY: temp79)
						)
						(Printf ; "vanishing x: %d y: %d"
							800
							7
							(gCurRoom vanishingX:)
							(gCurRoom vanishingY:)
						)
					)
					(KEY_ALT_w
						(CreateObject doit:)
					)
					(KEY_ALT_u
						(User canInput: 1 canControl: 1)
					)
					(KEY_ALT_z
						(= gQuit 1)
					)
					(KEY_ALT_i
						(dInvD doit:)
					)
					(KEY_ALT_b
						(Print 800 8) ; "Sorry, polygon editor is unavailable."
					)
					(KEY_ALT_h
						(Print 800 9) ; "Alt - A = Actor Cast Alt - B = polygon editor Alt - C = ControlMap Alt - D = toggle debug at room change Alt - F = memory Alt - G = setGlobal Alt - H = help screen Alt - I = get an inv item Alt - M = give yourself some money Alt - O = Show origin/now seen/base rectangles Alt - P = PriorityMap Alt - R = RoomNum Alt - T = Teleport Alt - U = set user control to true Alt - V = VisualMap Alt - Y = adjust vanishing point Alt - W = load feature writer Alt - Z = quick quit"
						(Print 800 10) ; "Control - c = clear bit flag Control - s = set bit flag Control - f = check bit flag"
					)
					(else
						(event claimed: 0)
					)
				)
			)
			(evMOUSEBUTTON
				(if (& (event modifiers:) emALT)
					(event claimed: 1)
					(= temp76
						(proc5_9
							(Format @temp0 800 11 (event x:) (event y:)) ; "%d/%d"
							67
							(cond
								((< (event x:) 20)
									(event x:)
								)
								((< 300 (event x:))
									(- (event x:) 40)
								)
								(else
									(- (event x:) 20)
								)
							)
							(if (< (event y:) 16)
								(event y:)
							else
								(- (event y:) 6)
							)
							33
							999
							108
						)
					)
					(while (!= evMOUSERELEASE ((= temp77 (Event new:)) type:))
						(temp77 dispose:)
					)
					(temp77 dispose:)
					(temp76 dispose:)
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

