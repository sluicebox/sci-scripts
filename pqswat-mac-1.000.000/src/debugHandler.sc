;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3)
(include sci.sh)
(use Main)
(use EditablePolygon)
(use Interface)
(use DButton)
(use DText)
(use Plane)
(use Str)
(use Array)
(use Print)
(use Dialog)
(use Polygon)
(use Feature)
(use Ego)
(use Sound)
(use File)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	debugHandler 0
	proc3_1 1
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	[local10 17] = [-1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
)

(procedure (localproc_0 param1 param2 &tmp temp0)
	(= temp0 (Str newWith: 80 {}))
	(if (> argc 1)
		(temp0 format: {%d} param2)
	)
	(return
		(if (GetInput (temp0 data:) 10 param1)
			(temp0 asInteger:)
		else
			-1
		)
	)
)

(procedure (localproc_1) ; UNUSED
	(Print
		addText: {Flag Object?} 0 0
		addButton: 1 {yes} 10 20
		addButton: 0 {no} 10 40
		init:
	)
)

(procedure (localproc_2 param1 &tmp temp0 temp1 temp2 temp3)
	(for ((= temp0 0)) (<= temp0 (- (gFeatures size:) 1)) ((++ temp0))
		(if ((gFeatures at: temp0) onMeCheck:)
			(if (((gFeatures at: temp0) onMeCheck:) isKindOf: Polygon)
				(= temp2 (IntArray new:))
				(= temp3
					(- ((((gFeatures at: temp0) onMeCheck:) points:) size:) 1)
				)
				(for ((= temp1 0)) (<= temp1 temp3) ((++ temp1))
					(temp2
						at:
							temp1
							((((gFeatures at: temp0) onMeCheck:) points:)
								at: temp1
							)
					)
				)
				(param1
					add:
						((Polygon new:)
							size: (/ (+ temp3 1) 2)
							points: temp2
							dynamic: 1
							yourself:
						)
				)
			else
				(Prints
					{A feature in this room cannot be displayed due to it being a list of polygons (and that part in debug hasn't been coded yet).}
				)
			)
		else
			(param1
				add:
					((Polygon new:)
						init:
							((gFeatures at: temp0) nsLeft:)
							((gFeatures at: temp0) nsTop:)
							((gFeatures at: temp0) nsRight:)
							((gFeatures at: temp0) nsTop:)
							((gFeatures at: temp0) nsRight:)
							((gFeatures at: temp0) nsBottom:)
							((gFeatures at: temp0) nsLeft:)
							((gFeatures at: temp0) nsBottom:)
						yourself:
					)
			)
		)
	)
	(AddPolygon gThePlane param1 250 255 0 0 1 1)
)

(procedure (localproc_3 param1 param2)
	(DeletePolygon param2 gThePlane)
	(if param1
		(param1 dispose:)
	)
)

(procedure (localproc_4 &tmp temp0 temp1 [temp2 3])
	(= temp1 (Str format: {%03d.BMP} gCurRoomNum))
	(= temp0 (Str new: 12))
	(Font 1 640 480) ; SetFontRes
	(Print addTitle: {Output File Name:} addEdit: temp0 12 0 0 temp1 init:)
	(FrameOut)
	(SaveScreen (temp0 data:))
	(if (FileIO fiEXISTS (temp0 data:))
		(Printf {%s SUCCESSFULLY CREATED} (temp0 data:))
	else
		(Printf {ERROR CREATING %s} (temp0 data:))
	)
	(FrameOut)
)

(procedure (localproc_5)
	(if (Print dialog:)
		((Print dialog:) dispose:)
		(Print dialog: 0)
		(FrameOut)
	)
)

(procedure (proc3_1 &tmp temp0 temp1 temp2 [temp3 2] temp5 [temp6 2])
	(= temp2 (Str newWith: 10 {}))
	((= temp5 (Print new:))
		font: gSmallFont
		fore: 255
		back: 0
		addText: {Where to?}
		addEdit: temp2 5 50 0
	)
	(= temp1 (temp5 init:))
	(if (temp2 size:)
		(= temp1 (temp2 asInteger:))
		(temp2 dispose:)
		(= temp2 0)
		(if (ResCheck rsSCRIPT temp1)
			(gCurRoom newRoom: temp1)
		)
	else
		(temp2 dispose:)
	)
)

(instance debugSound of Sound
	(properties)
)

(instance debugHandler of Feature
	(properties
		y -1
	)

	(method (init)
		(super init:)
		(self y: -1)
		(= local3 0)
		(= local4 0)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 [temp13 2] temp15 [temp16 3] temp19 temp20 temp21 temp22 temp23 temp24 temp25 temp26 temp27 temp28 temp29 temp30 temp31 [temp32 4] temp36)
		(if (event claimed:)
			(return)
		)
		(= temp0 (Str new:))
		(switch (event type:)
			(evKEYBOARD
				(event claimed: 1)
				(switch (event message:)
					(KEY_QUESTION
						(Prints
							{ ALT-A - show cAst\nALT-B - polygon editor\nCTRL-B - save screen to Bitmap\nALT-D - toggle debug at room change\nALT-E - show Ego\nALT-F - Flag set/clear\nALT-G - show/set Global variable\nALT-H - help on commands\nALT-I - get Inventory Item\nALT-J - Load picture\nALT-K - show palette\nALT-L - Log file\nALT-M - show memory\nALT-O - Scaler tool\nALT-P - Position actor\nALT-Q - screen cursor coordinates\nALT-R - show Room info\nALT-S - show all non-stopupd actors\nCTRL-S - test a sound\nALT-T - Teleport\nALT-U - HandsOn\nALT-V - Show Room polys\nALT-W - feature Writer\nALT-Y - Vanishing point adj\nALT-X - exit the game\n}
						)
					)
					($001a
						(= temp36 (gGame masterVolume:))
						(gGame masterVolume: (/ (* temp36 2) 3))
						(DoAudio 12 0) ; AudMixCheck
					)
					(KEY_J
						(if
							(and
								(>
									(= temp4
										(GetNumber
											{Pic #?}
											(gCurRoom picture:)
										)
									)
									0
								)
								(ResCheck rsPIC temp4)
							)
							(gCurRoom picture: temp4)
							(gCurRoom drawPic: temp4)
							(FrameOut)
						else
							(Printf
								{Picture number %d not available}
								temp4
							)
						)
					)
					(KEY_ALT_a
						(for
							((= temp15 (gCast first:)))
							temp15
							((= temp15 (gCast next: temp15)))
							
							(= temp10 (KList 8 temp15)) ; NodeValue
							(temp0
								format:
									{class: %s\nname: %s\nview: %d\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npriority: %d\nsignal: $%x\nscaleSignal: $%x\nscaleX: %d\nscaleY: %d\ncycleSpeed: %d\n}
									((temp10 -super-:) name:)
									(temp10 name:)
									(temp10 view:)
									(temp10 loop:)
									(temp10 cel:)
									(temp10 x:)
									(temp10 y:)
									(temp10 z:)
									(temp10 heading:)
									(temp10 priority:)
									(temp10 signal:)
									(temp10 scaleSignal:)
									(temp10 scaleX:)
									(temp10 scaleY:)
									(if (temp10 respondsTo: #cycler)
										(temp10 cycleSpeed:)
									else
										-1
									)
							)
							(localproc_5)
							(if (not (temp10 scaleSignal:))
								(Print
									x: -1
									y: -1
									font: gSmallFont
									fore: 0
									back: 255
									addText: (temp0 data:)
									addIcon:
										(temp10 view:)
										(temp10 loop:)
										(temp10 cel:)
										(+ (Print x:) 90)
										(+ (Print y:) 70)
									init:
								)
							else
								(Print
									x: -1
									y: -1
									font: gSmallFont
									fore: 0
									back: 255
									addText: (temp0 data:) 0 0
									init:
								)
							)
						)
					)
					(JOY_UPRIGHT
						(localproc_4)
					)
					(KEY_ALT_o
						(if (= local1 (gCast contains: gEgo))
							(gEgo hide:)
						)
						(PEditor init:)
						(if (gCurRoom obstacles:)
							(PEditor readPolygonsFromList: (gCurRoom obstacles:))
						)
						(PEditor doit:)
						(= temp10 (Str new: 13))
						(= temp26 (Str new: 13))
						(temp26 format: {%d.pol} gCurRoomNum)
						(Print
							addTitle: {Output File Name:}
							addEdit: temp10 12 0 0 temp26
							init:
						)
						(FrameOut)
						(poly_pol name: (temp10 data:) open: 2)
						(poly_pol writeString: {\t\t(curRoom addObstacle:\0d\n})
						(if (PEditor size:)
							(PEditor eachElementDo: #writeToFile poly_pol)
							(if (gCurRoom obstacles:)
								((gCurRoom obstacles:) dispose:)
								(gCurRoom obstacles: 0)
							)
							(for
								((= temp12 (KList 3 (PEditor elements:)))) ; FirstNode
								temp12
								((= temp12 temp31))
								
								(= temp31 (KList 6 temp12)) ; NextNode
								(= temp26 (KList 8 temp12)) ; NodeValue
								(gCurRoom
									addObstacle:
										((Polygon new:)
											type: (temp26 type:)
											size: (temp26 size:)
											dynamic: 1
											points:
												((IntArray new:)
													copy: (temp26 points:)
												)
											yourself:
										)
								)
							)
						)
						(poly_pol writeString: {\t\t)\0d\n})
						(poly_pol close:)
						(temp10 dispose:)
						(PEditor dispose:)
						(if local1
							(gEgo show:)
						)
					)
					(KEY_D
						(if (= gDebugOn (not gDebugOn))
							(Prints {On})
						else
							(Prints {Off})
						)
					)
					(KEY_E
						(= temp10
							(cond
								(local9 local9)
								((gCast contains: (gUser alterEgo:))
									(gUser alterEgo:)
								)
								(else
									(Prints {no ego!})
									(return)
								)
							)
						)
						(= temp0 (Str newWith: 75 {}))
						(temp0
							format:
								{name: %s\nview: %d\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npri: %d\nsignal: $%x\nscript: %s\n}
								(temp10 name:)
								(temp10 view:)
								(temp10 loop:)
								(temp10 cel:)
								(temp10 x:)
								(temp10 y:)
								(temp10 z:)
								(temp10 heading:)
								(temp10 priority:)
								(temp10 signal:)
								(if (temp10 script:)
									((temp10 script:) name:)
								else
									{..none..}
								)
						)
						(Print
							addText: (temp0 data:)
							addIcon:
								(temp10 view:)
								(temp10 loop:)
								(temp10 cel:)
								(+ (Print x:) 80)
								(+ (Print y:) 80)
							init:
						)
					)
					(KEY_F
						(= temp15 0)
						(= temp15 (GetNumber {Flag #:}))
						(if (IsFlag temp15)
							(Prints {cleared})
							(ClearFlag temp15)
						else
							(Prints {set})
							(SetFlag temp15)
						)
					)
					(JOY_DOWNLEFT
						(cond
							(local4
								(gTheDoits delete: featureCheck)
								(if local6
									(local6 dispose:)
									(= local6 0)
									(= local8 0)
								)
								(localproc_3 local5 local4)
								(= local4 0)
								(= local5 0)
							)
							((gFeatures size:)
								(= local5 (List new:))
								(gTheDoits add: featureCheck)
								(= local4 (localproc_2 local5))
							)
						)
					)
					(KEY_G
						(GetInput temp0 5 {Variable No.})
						(if (not (= temp4 (temp0 asInteger:)))
							(return)
						)
						(GetInput temp0 5 {Value})
						(= [gEgo temp4] (temp0 asInteger:))
					)
					(KEY_I
						(repeat
							(= temp5 (gInventory first:))
							(= temp6 (= temp7 (= temp8 (= temp28 0))))
							(Print font: gSmallFont)
							(repeat
								(breakif (not temp5))
								(Print
									addButton:
										temp8
										((KList 8 temp5) name:) ; NodeValue
										temp7
										temp6
								)
								((Print dialog:) setSize:)
								(if (> temp6 150)
									(= temp28 temp6)
									(= temp6 0)
									(= temp7
										(-
											((Print dialog:) nsRight:)
											((Print dialog:) nsLeft:)
										)
									)
								else
									(+= temp6 10)
								)
								(= temp5 (gInventory next: temp5))
								(++ temp8)
							)
							(Print
								addButton:
									temp8
									{Outta Here}
									temp7
									(if temp28 temp28 else temp6)
							)
							(breakif (== (= temp9 (Print init:)) temp8))
							(gEgo get: temp9)
						)
						(Print font: gUserFont)
					)
					(KEY_K
						(= temp23 5)
						(= temp24 16)
						(= temp19 15)
						(= temp20 80)
						(= temp22 (+ temp19 (* 34 temp23)))
						(= temp21 (+ temp20 (* 10 temp24)))
						(repeat
							(= temp2 (Event new:))
							(if (or (== (temp2 type:) evMOUSEBUTTON) (== (temp2 type:) evKEYBOARD))
								(break)
							)
							(temp2 dispose:)
						)
						(temp2 dispose:)
					)
					(KEY_M
						(gGame showMem:)
					)
					(KEY_L
						((ScriptID 64952) doit:) ; sysLogger
					)
					(KEY_B
						((ScriptID 14 0) doit:) ; scalerCode
					)
					(KEY_P
						(= temp29 (GetNumber {x:} (gEgo x:)))
						(= temp30 (GetNumber {y:} (gEgo y:)))
						(gEgo posn: temp29 temp30)
					)
					(KEY_Q
						(Print
							font: gSmallFont
							addTextF: {Cur X: %d,Y: %d} (event x:) (event y:)
							init:
						)
					)
					(KEY_R
						(temp0
							format:
								{Current Room\nname: %s\nscript: %s\nhorizon: %d\nvanishingX: %d\nvanishingY: %d\npicAngle: %d\nnorth: %d\nsouth: %d\neast: %d\nwest: %d\nstyle: %d\ncurPic: %d}
								(gCurRoom name:)
								(if (gCurRoom script:)
									((gCurRoom script:) name:)
								else
									{none}
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
						(Print font: gSmallFont addText: temp0 0 0 init:)
					)
					(KEY_MENU
						(if gAutoRobot
							(temp0
								format:
									{Current robot number: %hu\nposn: %d, %d\npriority: %d\n}
									(gAutoRobot robot:)
									(gAutoRobot x:)
									(gAutoRobot y:)
									(gAutoRobot priority:)
							)
							(Print
								font: gSmallFont
								addText: (temp0 data:) 0 0
								init:
							)
						else
							(Prints {There is no robot playing right now.})
						)
					)
					(KEY_T
						(proc3_1)
					)
					(KEY_S
						(for
							((= temp4 (gCast first:)))
							temp4
							((= temp4 (gCast next: temp4)))
							
							(= temp10 (KList 8 temp4)) ; NodeValue
							(temp0
								format:
									{Updating cast members\nname: %s\nclass: %s\nview: %d\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npri: %d\nsignal: $%x\nillBits: $%x\n}
									(temp10 name:)
									((temp10 -super-:) name:)
									(temp10 view:)
									(temp10 loop:)
									(temp10 cel:)
									(temp10 x:)
									(temp10 y:)
									(temp10 z:)
									(temp10 heading:)
									(temp10 priority:)
									(temp10 signal:)
									(if
										(or
											(== (temp10 -super-:) Actor)
											(== (temp10 -super-:) Ego)
										)
										(temp10 illegalBits:)
									else
										-1
									)
							)
							(if (not (temp10 scaleSignal:))
								(Print
									addIcon:
										(temp10 view:)
										(temp10 loop:)
										(temp10 cel:)
										(+ (Print x:) 80)
										(+ (Print y:) 80)
									font: gSmallFont
									addText:
										temp0
										(CelWide
											(temp10 view:)
											(temp10 loop:)
											(temp10 cel:)
										)
										0
									init:
								)
							else
								(Print font: gSmallFont addText: temp0 0 0 init:)
							)
						)
					)
					(KEY_PAUSE
						(= temp15 (GetNumber {setLoop?}))
						(= temp10 (GetNumber {which sound number?}))
						(debugSound setLoop: temp15 number: temp10 play:)
					)
					(KEY_W
						(if (not (gFeatures size:))
							(return)
						)
						(PEditor init:)
						(for
							((= temp15 0))
							(< temp15 (gFeatures size:))
							((++ temp15))
							
							(= temp10 (gFeatures at: temp15))
							(if (temp10 onMeCheck:)
								(if ((temp10 onMeCheck:) isKindOf: List)
									(for
										((= temp25 0))
										(< temp25 ((temp10 onMeCheck:) size:))
										((++ temp25))
										
										(= temp12
											((temp10 onMeCheck:) at: temp25)
										)
										(PEditor addPolygon: temp12)
									)
								else
									(PEditor addPolygon: (temp10 onMeCheck:))
								)
								((PEditor at: (- (PEditor size:) 1))
									name: (temp10 name:)
								)
							)
						)
						(PEditor show: 1 scratch: 1)
						(FrameOut)
						(PEditor doit:)
						(= temp10 (Str new: 13))
						(= temp26 (Str new: 13))
						(temp26 format: {%d.fea} gCurRoomNum)
						(Print
							addTitle: {Output File Name:}
							addEdit: temp10 12 0 0 temp26
							init:
						)
						(FrameOut)
						(poly_pol name: (temp10 data:) open: 0)
						(poly_pol
							writeString:
								{\t\t\t;***************************\0d\n}
						)
						(if (PEditor size:)
							(PEditor eachElementDo: #writeToFile poly_pol 1)
						)
						(poly_pol close:)
						(temp10 dispose:)
						(PEditor scratch: 0 dispose:)
					)
					(KEY_U
						(gGame handsOn:)
					)
					(KEY_V
						(cond
							(local3 0)
							((gCurRoom obstacles:)
								(= local3
									(AddPolygon gThePlane (gCurRoom obstacles:))
								)
								(FrameOut)
							)
							(else
								(Prints
									{Sorry, this room has no polygons.}
								)
							)
						)
					)
					(KEY_X
						(= gQuit 1)
					)
					(KEY_Y
						(Print
							font: gSmallFont
							addTextF:
								{vanishing x: %d,y: %d}
								(gCurRoom vanishingX:)
								(gCurRoom vanishingY:)
							init:
						)
						(= temp4 (localproc_0 {vanishingX:}))
						(or
							(OneOf temp4 -1 0)
							(gCurRoom vanishingX: temp4)
						)
						(= temp4 (localproc_0 {vanishingY:}))
						(or
							(OneOf temp4 -1 0)
							(gCurRoom vanishingY: temp4)
						)
						(Print
							font: gSmallFont
							addTextF:
								{vanishing x: %d,y: %d}
								(gCurRoom vanishingX:)
								(gCurRoom vanishingY:)
							init:
						)
					)
					(KEY_Z
						(= temp2 (Event new:))
						((User alterEgo:)
							posn: (temp2 x:) (- (temp2 y:) 10)
							setMotion: 0
						)
						(temp2 dispose:)
					)
					($0019
						(if (IsFlag 118)
							(ClearFlag 118)
							(Prints {VMD number WILL NOT be shown.})
						else
							(SetFlag 118)
							(Prints {VMD number WILL be shown.})
						)
					)
					(KEY_H
						(Print
							font: gSmallFont
							addText:
								{ ALT-A - show cAst\nALT-B - polygon editor\nCTRL-B - save screen to Bitmap\nALT-D - toggle debug at room change\nALT-E - show Ego\nALT-F - Flag set/clear\nALT-G - show/set Global variable\nALT-H - help on commands\nALT-I - get Inventory Item\nALT-J - Load picture\nALT-K - show palette\nALT-L - Log file\nALT-M - show memory\nALT-O - Scaler tool\nALT-P - Position actor\nALT-Q - screen cursor coordinates\nALT-R - show Room info\nALT-S - show all non-stopupd actors\nCTRL-S - test a sound\nALT-T - Teleport\nALT-U - HandsOn\nALT-V - Show Room polys\nALT-W - feature Writer\nALT-Y - Vanishing point adj\nALT-X - exit the game\n}
							init:
						)
					)
					(else
						(event claimed: 0)
					)
				)
			)
			(evMOUSEBUTTON
				(if (== (event modifiers:) emALT)
					(event claimed: 1)
					(while (!= evMOUSERELEASE ((= temp2 (Event new:)) type:))
						((User alterEgo:)
							posn: (temp2 x:) (- (temp2 y:) 10)
							setMotion: 0
						)
						(temp2 dispose:)
					)
					(temp2 dispose:)
				)
			)
		)
		(temp0 dispose:)
	)

	(method (dispose &tmp temp0)
		(if local4
			(DeletePolygon local4 gThePlane)
			(= local4 0)
		)
		(if (gTheDoits contains: featureCheck)
			(gTheDoits delete: featureCheck)
		)
		(if local6
			(local6 dispose:)
			(= local6 0)
			(= local8 0)
		)
		(if local5
			(local5 dispose:)
			(= local5 0)
		)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)
)

(instance dInvD of Dialog ; UNUSED
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp2 (= temp0 (= temp1 4)))
		(= temp3 0)
		(for
			((= temp5 (gInventory first:)))
			temp5
			((= temp5 (gInventory next: temp5)))
			
			(= temp6 (KList 8 temp5)) ; NodeValue
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
							font: 30
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
		(= plane ourPlane)
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
			(gEgo get: (gInventory indexOf: (temp0 value:)))
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
			($0010 ; direction
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

(instance featureCheck of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		((gUser curEvent:) localize: (gCast plane:))
		(= temp0 ((gUser curEvent:) x:))
		(= temp1 ((gUser curEvent:) y:))
		(cond
			((= local7 (gFeatures firstTrue: #onMe temp0 temp1))
				(if (!= local8 local7)
					(if local6
						(local6 dispose:)
						(= local6 0)
					)
					((= local6 (DText new:))
						text: (KString 8 (local7 name:)) ; StrDup
						fore: 0
						back: 255
						setSize: 240
						setPri: 255
					)
					(if (< temp0 145)
						(local6 posn: 188 30 init:)
					else
						(local6 posn: 65 30 init:)
					)
					(= local8 local7)
					(= local7 0)
				)
			)
			(local6
				(local6 dispose:)
				(= local6 0)
				(= local8 0)
			)
		)
	)
)

(instance poly_pol of File
	(properties
		name {poly.pol}
	)
)

(instance ourPlane of Plane
	(properties
		resX -1
		resY -1
	)
)

