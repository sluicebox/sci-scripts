;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4)
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
(use Sound)
(use File)
(use Inventory)
(use User)
(use System)

(public
	debugHandler 0
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
	[local9 17] = [-1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
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

(procedure (localproc_4 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
	(= temp6 0)
	(= temp1 (Str format: {%03d.BMP} gCurRoomNum))
	(= temp0 (Str new: 13))
	(= temp3 (Str new: 60))
	(= temp4 (Str format: {%d} gCurRoomNum))
	(Font 1 640 480) ; SetFontRes
	(if (Print addTitle: {Output File Name:} addEdit: temp0 12 0 0 temp1 init:)
		(if
			(Print
				addTitle: {Room #/Room Description}
				addEdit: temp3 60 30 0 temp4
				init:
			)
			(= temp6 1)
		)
		(if
			(= temp7
				(Print
					addText: {What do you want to discard\nfrom the bitmap?} 0 0
					addButton: 0 {Nothing} 10 20
					addButton: 1 {Interface} 60 20
					addButton: 2 {All but pic} 10 40
					init:
				)
			)
			(switch temp7
				(1
					(gInventory dispose:)
				)
				(2
					(if gPanels
						(gPanels eachElementDo: #dispose)
						(gPanels dispose:)
						(= gPanels 0)
					)
				)
				(else
					(= temp6 0)
				)
			)
			(if temp6
				(= temp2
					(Print
						addText: temp3
						posn: 11 155
						modeless: 2
						init:
						yourself:
					)
				)
			)
			(FrameOut)
			(SaveScreen (temp0 data:))
			(if temp2
				((temp2 dialog:) dispose:)
			)
			(if (FileIO fiEXISTS (temp0 data:))
				(Printf {%03d.BMP SUCCESSFULLY CREATED} gCurRoomNum)
			else
				(Printf {ERROR CREATING %03d.BMP} gCurRoomNum)
			)
		)
	)
	(FrameOut)
	(temp1 dispose:)
	(temp0 dispose:)
	(temp4 dispose:)
	(temp3 dispose:)
	(if (not gPanels)
		((= gInventory (ScriptID 0 11)) init:) ; blackPlane
	)
	(Font 1 320 200) ; SetFontRes
	(FrameOut)
)

(procedure (localproc_5)
	(if (Print dialog:)
		((Print dialog:) dispose:)
		(Print dialog: 0)
		(FrameOut)
	)
)

(class InvCast of Set
	(properties)
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
		(= local2 0)
		(= local3 0)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
		(InvCast
			add:
				(ScriptID 9 37) ; invAlanWrench
				(ScriptID 9 69) ; invAlarmClock
				(ScriptID 9 10) ; invBabyBottle
				(ScriptID 9 7) ; invBag
				(ScriptID 9 62) ; invBarrel
				(ScriptID 9 34) ; invBatKey
				(ScriptID 9 41) ; invBaubles
				(ScriptID 9 28) ; invBedroomNotes
				(ScriptID 9 89) ; invBeingInBottle
				(ScriptID 9 63) ; invBluePrints
				(ScriptID 9 38) ; invBottleNote
				(ScriptID 9 64) ; invCannon
				(ScriptID 9 8) ; invCarKeys
				(ScriptID 9 51) ; invCD
				(ScriptID 9 56) ; invCircuitBoard
				(ScriptID 9 54) ; invCoal
				(ScriptID 9 13) ; invCompass
				(ScriptID 9 43) ; invCrank
				(ScriptID 9 17) ; invCrowbar
				(ScriptID 9 57) ; invCrystalBottle
				(ScriptID 9 33) ; invDeskKey
				(ScriptID 9 9) ; invDrawbridgeKey
				(ScriptID 9 65) ; invDynamite
				(ScriptID 9 25) ; invEnvelope
				(ScriptID 9 61) ; invFiringMechanism
				(ScriptID 9 68) ; invFish
				(ScriptID 9 44) ; invGears
				(ScriptID 9 53) ; invIngots
				(ScriptID 9 31) ; invIonizer
				(ScriptID 9 42) ; invJems
				(ScriptID 9 29) ; invKitchenNotes
				(ScriptID 9 30) ; invLabNotes
				(ScriptID 9 72) ; invLargePlanks
				(ScriptID 9 5) ; invLighter
				(ScriptID 9 14) ; invLightHouseKey
				(ScriptID 9 12) ; invLetter
				(ScriptID 9 15) ; invLetterOpener
				(ScriptID 9 52) ; invLogs
				(ScriptID 9 50) ; invMachineBox
				(ScriptID 9 48) ; invMachinePart
				(ScriptID 9 49) ; invMachineTube
				(ScriptID 9 39) ; invModulator
				(ScriptID 9 55) ; invMold
				(ScriptID 9 26) ; invNotebook
				(ScriptID 9 47) ; invOrnithopterPart
				(ScriptID 9 90) ; invPlans
				(ScriptID 9 60) ; invPowerSupply
				(ScriptID 9 73) ; invPuzzleAmulet
				(ScriptID 9 16) ; invPuzzleBoxKey
				(ScriptID 9 46) ; invRadioBroke
				(ScriptID 9 45) ; invRadioControl
				(ScriptID 9 36) ; invAmanda
				(ScriptID 9 67) ; invRockHammer
				(ScriptID 9 11) ; invRocks
				(ScriptID 9 22) ; invShedKey
				(ScriptID 9 71) ; invSmallPlanks
				(ScriptID 9 18) ; invSolderingIron
				(ScriptID 9 40) ; invSparrow
				(ScriptID 9 23) ; invSpring
				(ScriptID 9 59) ; invStock
				(ScriptID 9 27) ; invStudyNotes
				(ScriptID 9 32) ; invThrottle
				(ScriptID 9 66) ; invTimeBomb
				(ScriptID 9 24) ; invToySoldier
				(ScriptID 9 19) ; invTube
				(ScriptID 9 6) ; invUmbrella
				(ScriptID 9 58) ; invVacuumPump
				(ScriptID 9 35) ; invWhistle
				(ScriptID 9 20) ; invWire
				(ScriptID 9 74) ; invWindGear
				(ScriptID 9 21) ; invWindUpKey
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 [temp13 2] temp15 [temp16 3] temp19 temp20 temp21 temp22 temp23 temp24 temp25 temp26 temp27 temp28 temp29 temp30 temp31 [temp32 4] temp36 temp37 temp38 temp39 temp40 temp41)
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
					(KEY_ALT_j
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
									{;\7f\7f class: %s\nname: %s\nview: %d\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npriority: %d\nsignal: $%x\nscaleSignal: $%x\nscaleX: %d\nscaleY: %d\ncycleSpeed: %d\n}
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
					(KEY_ALT_p
						(if (and gPanels (> (gPanels size:) 1))
							(Print
								addTitle: {Choose who's plane:}
								addButton: 1 {The main window} 0 10
							)
							(for
								((= temp15 0))
								(< temp15 (- (gPanels size:) 1))
								((++ temp15))
								
								(Print
									addButton:
										(+ temp15 2)
										((gPanels at: temp15) name:)
										0
										(+ (* (+ temp15 1) 20) 10)
								)
							)
							(if (== (= temp37 (Print init:)) 1)
								(= global107 (gCast plane:))
							else
								(= global107 (gPanels at: (- temp37 2)))
							)
						else
							(= global107 (gCast plane:))
						)
						(PEditor init:)
						(if (gCurRoom obstacles:)
							(PEditor readPolygonsFromList: (gCurRoom obstacles:))
						)
						(PEditor doit:)
						(= temp10 (Str new: 13))
						(= temp26 (Str new: 13))
						(temp26 format: {%d.pol} (gCurRoom scene:))
						(Print
							addTitle: {Output File Name:}
							addEdit: temp10 12 0 0 temp26
							init:
						)
						(FrameOut)
						(poly_pol name: (temp10 data:) open: 2)
						(poly_pol writeString: {\t\t(curRoom addObstacle:\r\n})
						(if (PEditor size:)
							(PEditor eachElementDo: #writeToFile poly_pol 1)
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
						(poly_pol writeString: {\t\t)\r\n})
						(poly_pol close:)
						(temp10 dispose:)
						(PEditor dispose:)
					)
					(KEY_ALT_d
						(if (= gDebugOn (not gDebugOn))
							(Prints {On})
						else
							(Prints {Off})
						)
					)
					(KEY_ALT_e
						(= temp10
							(cond
								(local8 local8)
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
					(KEY_ALT_f
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
							(local3
								(gTheDoits delete: featureCheck)
								(if local5
									(local5 dispose:)
									(= local5 0)
									(= local7 0)
								)
								(localproc_3 local4 local3)
								(= local3 0)
								(= local4 0)
							)
							((gFeatures size:)
								(= local4 (List new:))
								(gTheDoits add: featureCheck)
								(= local3 (localproc_2 local4))
							)
						)
					)
					(KEY_ALT_g
						(GetInput temp0 5 {Variable No.})
						(if (not (= temp4 (temp0 asInteger:)))
							(return)
						)
						(GetInput temp0 5 {Value})
						(= [gEgo temp4] (temp0 asInteger:))
					)
					(KEY_TAB
						(for
							((= temp15 0))
							(< temp15 (InvCast size:))
							((++ temp15))
							
							(gInventory addItem: (InvCast at: temp15))
						)
					)
					(KEY_ALT_c
						(if
							(Print
								addTitle: {Change Scene}
								addEdit: temp0 4 0 0
								init:
							)
							(gCurRoom changeScene: (temp0 asInteger:))
						)
					)
					(KEY_ALT_i
						(gGame setCursor: gNormalCursor 1)
						(repeat
							(= temp5 (InvCast first:))
							(= temp6 (= temp7 (= temp8 (= temp28 0))))
							(Print
								addTitle: {Inventory O-Matic}
								fore: 0
								back: 255
								font: gUserFont
							)
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
								(if (> temp6 250)
									(= temp28 temp6)
									(= temp6 0)
									(= temp7
										(-
											((Print dialog:) nsRight:)
											((Print dialog:) nsLeft:)
										)
									)
								else
									(+= temp6 20)
								)
								(= temp5 (InvCast next: temp5))
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
							(if (gInventory contains: (InvCast at: temp9))
								(if (== (InvCast at: temp9) (ScriptID 9 11)) ; invRocks
									((ScriptID 9 11) ; invRocks
										cel: (+ ((ScriptID 9 11) cel:) 1) ; invRocks
									)
									(gInventory draw:)
								else
									(gInventory deleteItem: (InvCast at: temp9))
								)
							else
								(gInventory addItem: (InvCast at: temp9))
							)
						)
					)
					(KEY_ALT_k
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
					(KEY_ALT_m
						(gGame showMem:)
					)
					(KEY_ALT_l
						((ScriptID 64952) doit:) ; sysLogger
					)
					(KEY_ALT_b
						((ScriptID 2 0) doit:) ; MISSING SCRIPT
					)
					(KEY_ALT_q
						(Print
							font: gSmallFont
							addTextF: {Cur X: %d,Y: %d} (event x:) (event y:)
							init:
						)
					)
					(KEY_ALT_r
						(temp0
							format:
								{Current Room\nname: %s\nscript: %s\nhorizon: %d\nvanishingX: %d\nvanishingY: %d\npicAngle: %d\nnorth: %d\nsouth: %d\neast: %d\nwest: %d\nstyle: %d\ncurPic: %d\nscene: %d}
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
								(gCurRoom scene:)
						)
						(Print font: gSmallFont addText: temp0 0 0 init:)
					)
					(KEY_MENU
						(if (or gAutoRobot global208)
							(if gAutoRobot
								(temp0
									format:
										{Current robot number: %hu\nposn: %d, %d\npriority: %d\n}
										(gAutoRobot robot:)
										(gAutoRobot x:)
										(gAutoRobot y:)
										(gAutoRobot priority:)
								)
							else
								(temp0
									format:
										{Current robot number: %hu\nposn: %d, %d\npriority: %d\nframe: %d\n}
										(global208 robot:)
										(global208 x:)
										(global208 y:)
										(global208 priority:)
										(global208 curFrame:)
								)
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
					(KEY_ALT_t
						(gCurRoom newRoom: 6) ; whereTo
					)
					(KEY_ALT_s
						(for
							((= temp4 (gCast first:)))
							temp4
							((= temp4 (gCast next: temp4)))
							
							(= temp10 (KList 8 temp4)) ; NodeValue
							(temp0
								format:
									{Updating cast members\nname: %s\n;\7f\7f class: %s\nview: %d\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npri: %d\nsignal: $%x\nillBits: $%x\n}
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
									-1
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
					(KEY_ALT_w
						(if (and gPanels (> (gPanels size:) 1))
							(Print
								addTitle: {Choose who's plane:}
								addButton: 1 {The main window} 0 10
							)
							(for
								((= temp15 0))
								(< temp15 (- (gPanels size:) 1))
								((++ temp15))
								
								(Print
									addButton:
										(+ temp15 2)
										((gPanels at: temp15) name:)
										0
										(+ (* (+ temp15 1) 20) 10)
								)
							)
							(if (== (= temp37 (Print init:)) 1)
								(= global107 (gCast plane:))
							else
								(= global107 (gPanels at: (- temp37 2)))
							)
						else
							(= global107 (gCast plane:))
						)
						(PEditor init:)
						(if (gFeatures size:)
							(for
								((= temp15 0))
								(< temp15 (gFeatures size:))
								((++ temp15))
								
								(= temp10 (gFeatures at: temp15))
								(if (temp10 onMeCheck:)
									(if ((temp10 onMeCheck:) isKindOf: List)
										(for
											((= temp25 0))
											(<
												temp25
												((temp10 onMeCheck:) size:)
											)
											((++ temp25))
											
											(= temp12
												((temp10 onMeCheck:) at: temp25)
											)
											(PEditor addPolygon: temp12)
										)
									else
										(PEditor
											addPolygon: (temp10 onMeCheck:)
										)
									)
									((PEditor at: (- (PEditor size:) 1))
										name: (temp10 name:)
									)
								)
							)
						)
						(PEditor show: 1 scratch: 1)
						(FrameOut)
						(PEditor doit:)
						(= temp10 (Str new: 13))
						(= temp26 (Str new: 13))
						(temp26 format: {%d.fea} (gCurRoom scene:))
						(Print
							addTitle: {Output File Name:}
							addEdit: temp10 12 0 0 temp26
							init:
						)
						(FrameOut)
						(poly_pol name: (temp10 data:) open: 0)
						(poly_pol
							writeString: {;***************************\r\n}
						)
						(= temp0 0)
						(if (PEditor size:)
							(= temp0 (Str newWith: 5 {}))
							(for
								((= temp12 (KList 3 (PEditor elements:)))) ; FirstNode
								temp12
								((= temp12 temp31))
								
								(= temp31 (KList 6 temp12)) ; NextNode
								(= temp26 (KList 8 temp12)) ; NodeValue
								(poly_pol writeString: {\r\n})
								(poly_pol writeString: {(instance })
								(poly_pol writeString: (temp26 name:))
								(poly_pol writeString: { of Feature\r\n})
								(poly_pol writeString: {\t(properties\r\n})
								(poly_pol writeString: {\t\tx})
								(= temp38 (= temp40 1000))
								(= temp39 (= temp41 0))
								(for
									((= temp15 0))
									(< temp15 (temp26 size:))
									((++ temp15))
									
									(temp26 indexToCoor: temp15)
									(if (< (temp26 currentX:) temp38)
										(= temp38 (temp26 currentX:))
									)
									(if (> (temp26 currentX:) temp39)
										(= temp39 (temp26 currentX:))
									)
									(if (< (temp26 currentY:) temp40)
										(= temp40 (temp26 currentY:))
									)
									(if (> (temp26 currentY:) temp41)
										(= temp41 (temp26 currentY:))
									)
								)
								(= temp29 (+ (/ (- temp39 temp38) 2) temp38))
								(= temp30 (+ (/ (- temp41 temp40) 2) temp40))
								(poly_pol writeString: {\t\t\t\t})
								(temp0 format: {%d} temp29)
								(poly_pol writeString: (temp0 data:))
								(poly_pol writeString: {\r\n})
								(poly_pol writeString: {\t\ty})
								(poly_pol writeString: {\t\t\t\t})
								(temp0 format: {%d} temp30)
								(poly_pol writeString: (temp0 data:))
								(poly_pol writeString: {\r\n})
								(poly_pol writeString: {\t)\r\n})
								(poly_pol writeString: {\t(method (init)\r\n})
								(poly_pol
									writeString: {\t\t(self setPolygon:\r\n}
								)
								(temp26 writeToFile: poly_pol 0)
								(poly_pol writeString: {\t\t)\r\n})
								(poly_pol
									writeString: {\t\t(super init: &rest)\r\n}
								)
								(poly_pol writeString: {\t)\r\n})
								(poly_pol writeString: {);})
								(poly_pol writeString: (temp26 name:))
								(poly_pol writeString: {\r\n})
							)
						)
						(poly_pol close:)
						(temp10 dispose:)
						(PEditor scratch: 0 dispose:)
					)
					(KEY_ALT_u
						(gGame handsOn:)
					)
					(KEY_ALT_v
						(cond
							(local2 0)
							((gCurRoom obstacles:)
								(= local2
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
					(KEY_ALT_x
						(= gQuit 1)
					)
					(KEY_ALT_y
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
					(KEY_ALT_z
						(= temp2 (Event new:))
						((User alterEgo:)
							posn: (temp2 x:) (- (temp2 y:) 10)
							setMotion: 0
						)
						(temp2 dispose:)
					)
					(KEY_ALT_h
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
		(if local3
			(DeletePolygon local3 gThePlane)
			(= local3 0)
		)
		(if (gTheDoits contains: featureCheck)
			(gTheDoits delete: featureCheck)
		)
		(if local5
			(local5 dispose:)
			(= local5 0)
			(= local7 0)
		)
		(if local4
			(local4 dispose:)
			(= local4 0)
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
			((= local6 (gFeatures firstTrue: #onMe temp0 temp1))
				(if (!= local7 local6)
					(if local5
						(local5 dispose:)
						(= local5 0)
					)
					((= local5 (DText new:))
						text: (KArray 8 (local6 name:)) ; ArrayDup
						fore: 0
						back: 255
						setSize: 240
						setPri: 255
					)
					(if (< temp0 145)
						(local5 posn: 188 30 init:)
					else
						(local5 posn: 65 30 init:)
					)
					(= local7 local6)
					(= local6 0)
				)
			)
			(local5
				(local5 dispose:)
				(= local5 0)
				(= local7 0)
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
	(properties)
)

