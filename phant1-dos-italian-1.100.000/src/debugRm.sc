;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21)
(include sci.sh)
(use Main)
(use n1111)
(use Interface)
(use DText)
(use Str)
(use Array)
(use Print)
(use Polygon)
(use Feature)
(use Sound)
(use File)
(use User)
(use System)

(public
	debugRm 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(procedure (localproc_0) ; UNUSED
	(Print
		addText: {Flag Object?} 0 0
		addButton: 1 {yes} 10 20
		addButton: 0 {no} 10 40
		init:
	)
)

(procedure (localproc_1 param1 &tmp temp0 temp1 temp2 temp3)
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

(procedure (localproc_2 param1 param2)
	(DeletePolygon param2 gThePlane)
	(if param1
		(param1 dispose:)
	)
)

(procedure (localproc_3 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
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
					addButton: 2 {Ego} 10 40
					addButton: 3 {All but pic} 60 40
					init:
				)
			)
			(switch temp7
				(1
					((global116 plane:) priority: -1)
					(UpdatePlane (global116 plane:))
				)
				(2
					(= temp6 0)
					(gEgo hide:)
				)
				(3
					(gEgo hide:)
					((global116 plane:) priority: -1)
					(UpdatePlane (global116 plane:))
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
			(SaveScreen (temp1 data:))
			(if temp2
				((temp2 dialog:) dispose:)
			)
			(if (FileIO fiEXISTS (temp1 data:))
				(Printf {%03d.BMP SUCCESSFULLY CREATED} gCurRoomNum)
			else
				(Printf {ERROR CREATING %03d.BMP} gCurRoomNum)
			)
			(FrameOut)
		)
	)
	(temp1 dispose:)
	(temp0 dispose:)
	(temp4 dispose:)
	(temp3 dispose:)
	(gEgo show:)
	((global116 plane:) priority: 3)
	(UpdatePlane (global116 plane:))
	(Font 1 320 200) ; SetFontRes
	(FrameOut)
)

(instance debugSound of Sound
	(properties)
)

(instance debugRm of Feature
	(properties)

	(method (dispose &tmp temp0)
		(if local1
			(DeletePolygon local1 gThePlane)
			(= local1 0)
		)
		(if local2
			(DeletePolygon local2 gThePlane)
			(= local2 0)
		)
		(if (gTheDoits contains: featureCheck)
			(gTheDoits delete: featureCheck)
		)
		(if local4
			(local4 dispose:)
			(= local4 0)
			(= local6 0)
		)
		(if local3
			(local3 dispose:)
			(= local3 0)
		)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(self y: -1)
		(= local1 0)
		(= local2 0)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 temp22 temp23 temp24 temp25 temp26 temp27 temp28)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evKEYBOARD
				(event claimed: 1)
				(switch (event message:)
					(KEY_QUESTION
						(Prints
							{ALT-A - show cAst\nALT-B - save screen to Bitmap\nALT-D - drop inv item\nALT-E - show Ego\nALT-F - show Features\nALT-G - show/set Flag\nALT-I - get Inventory Item\nALT-L - Load picture\nALT-O - pOlygon editor\nALT-P - Position actor\nALT-Q - Robot complaint form\nALT-R - show Room info\nALT-S - Scaler tool\nALT-T - Teleport\nALT-U - HandsOn\nALT-W - feature Writer\nALT-X - exit the game\nCTL-S - test Sound CTL-I - actor infor}
						)
					)
					(KEY_ALT_a
						(if (gCast size:)
							(= temp15 (Str newWith: 75 {}))
							(for
								((= temp14 (gCast first:)))
								temp14
								((= temp14 (gCast next: temp14)))
								
								(= temp23 (Str new:))
								(= temp12 (KList 8 temp14)) ; NodeValue
								(temp15
									format:
										{class: %s\nview: %d\nrobot: %d\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npri: %d\nsignal: $%x\n}
										((temp12 -super-:) name:)
										(temp12 view:)
										(if
											(and
												(temp12 respondsTo: #robot)
												(temp12 robot:)
											)
											((temp12 robot:) robot:)
										else
											0
										)
										(temp12 loop:)
										(temp12 cel:)
										(temp12 x:)
										(temp12 y:)
										(temp12 z:)
										(temp12 heading:)
										(temp12 priority:)
										(temp12 signal:)
								)
								(temp23 format: {%s} (temp12 name:))
								(if
									(or
										(== (temp12 view:) -1)
										(not
											(Print
												addTitle: (temp23 data:)
												addText: (temp15 data:)
												addIcon:
													(temp12 view:)
													(temp12 loop:)
													(temp12 cel:)
													(+ (Print x:) 80)
													(+ (Print y:) 80)
												init:
											)
										)
									)
									(break)
								)
								(temp23 dispose:)
							)
							(temp15 dispose:)
						else
							(Prints {ERROR: cast empty})
							(return)
						)
					)
					(JOY_LEFT
						(= temp15 (Str new:))
						(GetInput temp15 5 {Variable No.})
						(if (not (= temp9 (temp15 asInteger:)))
							(return)
						)
						(GetInput temp15 5 {Value})
						(= [gEgo temp9] (temp15 asInteger:))
						(temp15 dispose:)
					)
					(KEY_ALT_b
						(localproc_3)
					)
					(KEY_ALT_d
						(gGame setCursor: gNormalCursor)
						(repeat
							(= temp0 (gInventory first:))
							(= temp3 (= temp4 (= temp1 (= temp6 0))))
							(Print font: gSmallFont)
							(repeat
								(breakif (not temp0))
								(Print
									addButton:
										temp1
										((KList 8 temp0) name:) ; NodeValue
										temp4
										temp3
								)
								((Print dialog:) setSize:)
								(if (> temp3 130)
									(= temp6 temp3)
									(= temp3 0)
									(= temp4
										(-
											((Print dialog:) nsRight:)
											((Print dialog:) nsLeft:)
										)
									)
								else
									(+= temp3 15)
								)
								(= temp0 (gInventory next: temp0))
								(++ temp1)
							)
							(Print
								addButton:
									temp1
									{Outta Here}
									temp4
									(if temp6 temp6 else temp3)
							)
							(breakif (== (= temp2 (Print init:)) temp1))
							(gEgo put: temp2)
						)
						(Print font: gUserFont)
					)
					(KEY_ALT_e
						(= temp12
							(cond
								(global102 global102)
								((gCast contains: (gUser alterEgo:))
									(gUser alterEgo:)
								)
								(else
									(Prints {no ego!})
									(return)
								)
							)
						)
						(= temp28 (Str new:))
						(if (and (temp12 respondsTo: #robot) (temp12 robot:))
							(temp28 format: {%hu} ((temp12 robot:) robot:))
						else
							(temp28 format: {%s} {none})
						)
						(= temp26 (Str new:))
						(if (and (temp12 respondsTo: #scaler) (temp12 scaler:))
							(temp26
								format:
									{%s %d %d %d %d}
									((temp12 scaler:) name:)
									((temp12 scaler:) frontSize:)
									((temp12 scaler:) backSize:)
									((temp12 scaler:) frontY:)
									((temp12 scaler:) backY:)
							)
						else
							(temp26 format: {%s} {none})
						)
						(= temp27 (Str new:))
						(if (temp12 script:)
							(temp27
								format:
									{%s\nstate: %d}
									((temp12 script:) name:)
									((temp12 script:) state:)
							)
						else
							(temp27 format: {%s} {none})
						)
						(= temp15 (Str newWith: 100 {}))
						(temp15
							format:
								{name: %s\nview: %d\nloop: %d\ncel: %d\nrobot: %s\nposn: %d %d %d\nheading: %d\npriority: %d\nsignal: $%x\nscaler: %s\nscript: %s\n}
								(temp12 name:)
								(temp12 view:)
								(temp12 loop:)
								(temp12 cel:)
								(temp28 data:)
								(temp12 x:)
								(temp12 y:)
								(temp12 z:)
								(temp12 heading:)
								(temp12 priority:)
								(temp12 signal:)
								(temp26 data:)
								(temp27 data:)
						)
						(Print
							addText: (temp15 data:)
							addIcon:
								(temp12 view:)
								(temp12 loop:)
								(temp12 cel:)
								(+ (Print x:) 95)
								(+ (Print y:) 85)
							init:
						)
						(temp15 dispose:)
						(temp26 dispose:)
						(temp27 dispose:)
						(temp28 dispose:)
					)
					(KEY_ALT_f
						(if local2
							(gTheDoits delete: featureCheck)
							(if local4
								(local4 dispose:)
								(= local4 0)
								(= local6 0)
							)
							(localproc_2 local3 local2)
							(= local2 0)
							(= local3 0)
							(proc1111_11)
						else
							(if (gFeatures size:)
								(= local3 (List new:))
								(gTheDoits add: featureCheck)
								(= local2 (localproc_1 local3))
							)
							(proc1111_12)
						)
					)
					(KEY_ALT_g
						(= temp15 (Str newWith: 75 {}))
						(Print
							font: gUserFont
							y: 100
							addText: {Flag num?}
							addEdit: temp15 5 50
							init:
						)
						(= temp14 (temp15 asInteger:))
						(temp15 dispose:)
						(switch
							(Print
								font: gUserFont
								y: 50
								addText:
									(if (IsFlag temp14)
										{flag is SET}
									else
										{flag is CLEARED}
									)
								addButton: 1 { set } 0 12
								addButton: 2 {clear} 0 26
								addButton: -1 {cancel} 0 40
								init:
							)
							(1
								(SetFlag temp14)
							)
							(2
								(ClearFlag temp14)
							)
						)
					)
					(KEY_ALT_i
						(gGame setCursor: gNormalCursor)
						(repeat
							(= temp0 (gInventory first:))
							(= temp3 (= temp4 (= temp1 (= temp6 0))))
							(Print font: gSmallFont)
							(repeat
								(breakif (not temp0))
								(Print
									addButton:
										temp1
										((KList 8 temp0) name:) ; NodeValue
										temp4
										temp3
								)
								((Print dialog:) setSize:)
								(if (> temp3 130)
									(= temp6 temp3)
									(= temp3 0)
									(= temp4
										(-
											((Print dialog:) nsRight:)
											((Print dialog:) nsLeft:)
										)
									)
								else
									(+= temp3 15)
								)
								(= temp0 (gInventory next: temp0))
								(++ temp1)
							)
							(Print
								addButton:
									temp1
									{Outta Here}
									temp4
									(if temp6 temp6 else temp3)
							)
							(breakif (== (= temp2 (Print init:)) temp1))
							(gEgo get: temp2)
						)
						(Print font: gUserFont)
					)
					(KEY_ALT_j
						(if
							(and
								(>
									(= temp9
										(GetNumber
											{Pic #?}
											(gCurRoom picture:)
										)
									)
									0
								)
								(ResCheck rsPIC temp9)
							)
							(gCurRoom picture: temp9)
							(gCurRoom drawPic: temp9)
							(FrameOut)
						else
							(Printf
								{Picture number %d not available}
								temp9
							)
						)
					)
					(KEY_ALT_o
						(Unknown_Class_151 init:)
						(if (gCurRoom obstacles:)
							(Unknown_Class_151
								readPolygonsFromList: (gCurRoom obstacles:)
							)
						)
						(Unknown_Class_151 doit:)
						(= temp12 (Str new: 13))
						(= temp13 (Str new: 13))
						(temp13 format: {%d.pol} gCurRoomNum)
						(Print
							addTitle: {Output File Name:}
							addEdit: temp12 12 0 0 temp13
							init:
						)
						(FrameOut)
						(poly_pol name: (temp12 data:) open: 2)
						(poly_pol writeString: {\t\t(curRoom addObstacle:\r\n})
						(if (Unknown_Class_151 size:)
							(Unknown_Class_151
								eachElementDo: #writeToFile poly_pol
							)
							(if (gCurRoom obstacles:)
								((gCurRoom obstacles:) dispose:)
								(gCurRoom obstacles: 0)
							)
							(for
								((= temp17
									(KList 3 (Unknown_Class_151 elements:)) ; FirstNode
								))
								temp17
								((= temp17 temp18))
								
								(= temp18 (KList 6 temp17)) ; NextNode
								(= temp13 (KList 8 temp17)) ; NodeValue
								(gCurRoom
									addObstacle:
										((Polygon new:)
											type: (temp13 type:)
											size: (temp13 size:)
											dynamic: 1
											points:
												((IntArray new:)
													copy: (temp13 points:)
												)
											yourself:
										)
								)
							)
						)
						(poly_pol writeString: {\t\t)\r\n})
						(poly_pol close:)
						(temp12 dispose:)
						(Unknown_Class_151 dispose:)
					)
					(KEY_ALT_p
						(= temp7 (GetNumber {x:} (gEgo x:)))
						(= temp8 (GetNumber {y:} (gEgo y:)))
						(gEgo posn: temp7 temp8)
					)
					(KEY_ALT_q
						(= temp24 (= temp25 (= temp15 0)))
						(switch
							(Print
								font: gUserFont
								y: 50
								addText: {Robot complaint form}
								addButton: 1 {Bad Audio} 0 12
								addButton: 2 {Needs Audio} 0 26
								addButton: 3 {Doesn't Need Audio} 0 40
								addButton: 4 {Audio Doesn't Sync} 0 54
								addButton: -1 {cancel} 0 68
								init:
							)
							(1
								(= temp24 (Str newWith: 128 gCurSaveDir))
								(temp24 cat: {robaud})
								((= temp25 (File new:))
									name: (KString 8 (temp24 data:)) ; StrDup
									open: 0
								)
								(= temp15 (Str newWith: 75 {}))
								(temp15
									format: {%d.rbt Bad Audio\r\n} global202
								)
								(temp25 writeString: temp15)
							)
							(2
								(= temp24 (Str newWith: 128 gCurSaveDir))
								(temp24 cat: {robaud})
								((= temp25 (File new:))
									name: (KString 8 (temp24 data:)) ; StrDup
									open: 0
								)
								(= temp15 (Str newWith: 75 {}))
								(temp15
									format: {%d.rbt Needs Audio\r\n} global202
								)
								(temp25 writeString: temp15)
							)
							(3
								(= temp24 (Str newWith: 128 gCurSaveDir))
								(temp24 cat: {robaud})
								((= temp25 (File new:))
									name: (KString 8 (temp24 data:)) ; StrDup
									open: 0
								)
								(= temp15 (Str newWith: 75 {}))
								(temp15
									format:
										{%d.rbt Doesn't Need Audio\r\n}
										global202
								)
								(temp25 writeString: temp15)
							)
							(4
								(= temp24 (Str newWith: 128 gCurSaveDir))
								(temp24 cat: {robaud})
								((= temp25 (File new:))
									name: (KString 8 (temp24 data:)) ; StrDup
									open: 0
								)
								(= temp15 (Str newWith: 75 {}))
								(temp15
									format:
										{%d.rbt Audio Doesn't Sync\r\n}
										global202
								)
								(temp25 writeString: temp15)
							)
						)
						(if temp15
							(temp15 dispose:)
						)
						(if temp24
							(temp24 dispose:)
						)
						(if temp25
							(temp25 dispose:)
						)
					)
					(KEY_ALT_r
						(Printf
							{name: %s\nnumber: %hu\ncurrent pic: %hu\nstyle: %d\nhorizon: %d\nnorth: %hu\nsouth: %hu\neast: %hu\nwest: %hu\nscript: %s\nrobot: %d }
							(gCurRoom name:)
							gCurRoomNum
							(gCurRoom picture:)
							(gCurRoom style:)
							(gCurRoom horizon:)
							(gCurRoom north:)
							(gCurRoom south:)
							(gCurRoom east:)
							(gCurRoom west:)
							(if (gCurRoom script:)
								((gCurRoom script:) name:)
							else
								{..none..}
							)
							(if gAutoRobot
								(gAutoRobot robot:)
							else
								0
							)
							78
							120
						)
					)
					(KEY_ALT_s
						((ScriptID 42 0) doit:) ; scalerCode
					)
					(KEY_ALT_t
						(if
							(ResCheck
								rsSCRIPT
								(= temp9 (GetNumber {Teleport to:}))
							)
							(proc1111_11)
							(gCurRoom newRoom: temp9)
						)
					)
					(KEY_ALT_u
						(gGame handsOn:)
					)
					(KEY_ALT_w
						((ScriptID 64948 0) doit:) ; MISSING SCRIPT
					)
					(KEY_ALT_x
						(= gQuit 1)
					)
					(KEY_ALT_y
						(cond
							(local1 0)
							((gCurRoom obstacles:)
								(= local1
									(AddPolygon gThePlane (gCurRoom obstacles:))
								)
							)
							(else
								(Prints
									{Sorry, this room has no polygons.}
								)
							)
						)
					)
					(KEY_PAUSE
						(= temp14 (GetNumber {setLoop?}))
						(= temp12 (GetNumber {which sound number?}))
						(debugSound setLoop: temp14 number: temp12 play:)
					)
					(KEY_TAB
						(if (not (& (gEgo signal:) $0008))
							(SetNowSeen gEgo)
							(Printf
								{ Name: %s\nPosition: %d %d\nCel: %d %d %d\nCel W H: %d %d\nLeft Top: %d %d\nRight Bot: %d %d\nWidth Height: %d %d\nHiRes W H: %d %d }
								(gEgo name:)
								(gEgo x:)
								(gEgo y:)
								(gEgo view:)
								(gEgo loop:)
								(gEgo cel:)
								(CelWide
									(gEgo view:)
									(gEgo loop:)
									(gEgo cel:)
								)
								(CelHigh
									(gEgo view:)
									(gEgo loop:)
									(gEgo cel:)
								)
								(= temp7 (gEgo nsLeft:))
								(= temp8 (gEgo nsTop:))
								(= temp19 (gEgo nsRight:))
								(= temp20 (gEgo nsBottom:))
								(= temp21 (+ 1 (- temp19 temp7)))
								(= temp22 (+ 1 (- temp20 temp8)))
								(* 2 temp21)
								(/ (+ (* temp22 12) 4) 5)
							)
						)
						(event claimed: 1)
					)
					(else
						(event claimed: 0)
					)
				)
			)
			(evMOUSEBUTTON
				(switch (event modifiers:)
					($000d 0) ; emALT | emCTRL | emRIGHT_SHIFT
					($000e 0) ; emALT | emCTRL | emLEFT_SHIFT
					($000c ; emALT | emCTRL
						(event claimed: 1)
						(event globalize:)
						(= temp7 (event x:))
						(= temp8 (event y:))
						(event localize: (gCast plane:))
						(Printf
							{global: %d/%d\n local: %d/%d}
							temp7
							temp8
							(event x:)
							(event y:)
							75
							160
							10
							42
							999
						)
					)
					($0005 ; emCTRL | emRIGHT_SHIFT
						(event type: evKEYBOARD message: KEY_ALT_r)
						(self handleEvent: event)
					)
					($0006 ; emCTRL | emLEFT_SHIFT
						(event type: evKEYBOARD message: KEY_ALT_e)
						(self handleEvent: event)
					)
					($0009 0) ; emALT | emRIGHT_SHIFT
					($000a 0) ; emALT | emLEFT_SHIFT
					(emRIGHT_SHIFT 0)
					(emLEFT_SHIFT 0)
					(emCTRL 0)
					(emALT
						(event claimed: 1)
						(= temp16
							(if global102
								global102
							else
								(User alterEgo:)
							)
						)
						(gEgo setMotion: 0)
						(while (!= ((= temp11 (Event new:)) type:) evMOUSERELEASE)
							(temp11 localize: (gCast plane:))
							(temp16 x: (temp11 x:) y: (temp11 y:))
							(if (temp16 scaler:)
								((temp16 scaler:) doit:)
							)
							(if (temp16 isNotHidden:)
								(UpdateScreenItem temp16)
							)
							(FrameOut)
							(temp11 dispose:)
						)
						(if (not (temp16 isNotHidden:))
							(= temp26
								(Str
									format:
										{%s repositioned to %d %d}
										(temp16 name:)
										(temp16 x:)
										(temp16 y:)
								)
							)
							(proc1111_0 (temp26 data:))
							(temp26 dispose:)
						)
						(temp11 dispose:)
					)
				)
			)
		)
	)
)

(instance featureCheck of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		((gUser curEvent:) localize: (gCast plane:))
		(= temp0 ((gUser curEvent:) x:))
		(= temp1 ((gUser curEvent:) y:))
		(cond
			((= local5 (gFeatures firstTrue: #onMe temp0 temp1))
				(if (!= local6 local5)
					(if local4
						(local4 dispose:)
						(= local4 0)
					)
					((= local4 (DText new:))
						text: (KString 8 (local5 name:)) ; StrDup
						fore: 24
						back: 0
						setSize: 240
						setPri: 255
					)
					(if (< temp0 145)
						(local4 posn: 188 30 init:)
					else
						(local4 posn: 65 30 init:)
					)
					(= local6 local5)
					(= local5 0)
				)
			)
			(local4
				(local4 dispose:)
				(= local4 0)
				(= local6 0)
			)
		)
	)
)

(instance poly_pol of File
	(properties
		name {poly.pol}
	)
)

