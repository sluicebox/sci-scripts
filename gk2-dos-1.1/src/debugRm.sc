;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 99)
(include sci.sh)
(use Main)
(use n011)
(use EditablePolygon)
(use Interface)
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
)

(procedure (localproc_0 &tmp temp0) ; UNUSED
	(if ((gCurRoom obstacles:) size:)
		(= local2
			(AddPolygon (gCurRoom plane:) (gCurRoom obstacles:) 2000 255 0 0 1 1)
		)
	)
)

(procedure (localproc_1) ; UNUSED
	(Print
		addText: {Flag Object?} 0 0
		addButton: 1 {yes} 20 48
		addButton: 0 {no} 20 96
		init:
	)
)

(instance debugSound of Sound
	(properties)
)

(instance debugRm of Feature
	(properties)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(self y: -1)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 temp22)
		(if (or (event claimed:) (not (OneOf (event type:) evKEYBOARD evMOUSEBUTTON)))
			(return)
		)
		(if (== (event type:) evKEYBOARD)
			(event claimed: 1)
			(switch (event message:)
				(KEY_QUESTION
					(Prints
						{ALT-A - reload room\nALT-B - caputure BMP\nALT-C - show Cast\nALT-E - show Ego\nALT-F - edit Features\nALT-G - show/set/clear Flag\nALT-I - get Inventory Item\nALT-P - edit Polygons\nALT-R - show Room info\nALT-S - scaler tool\nALT-T - teleport\nALT-U - handsOn\nALT-M - report free memory\nALT-X - exit the Game\nCTRL-S - test a sound }
					)
				)
				(KEY_ALT_a
					(gCurRoom newRoom: 6)
				)
				(KEY_ALT_b
					(if (!= (Platform) 1)
						(Prints
							{The "Save Screen" option is not supported in the Windows Interpreter. However, you can save this screen by typing <alt-PrintScreen> and then paste it into Paint Brush.}
						)
					else
						(while
							(and
								(< local1 999)
								(= temp5 (Str format: {GK2%03d.BMP} local1))
								(FileIO fiEXISTS (temp5 data:))
							)
							(++ local1)
						)
						(if (< local1 999)
							(SaveScreen (temp5 data:))
							(Printf {Screen saved as\n___%s} (temp5 data:))
						else
							(Prints
								{Sorry, no can do. How did you get so many files?}
							)
						)
					)
				)
				(KEY_ALT_c
					(if (gCast size:)
						(= temp6 (Str newWith: 75 {}))
						(for
							((= temp4 (gCast first:)))
							temp4
							((= temp4 (gCast next: temp4)))
							
							(= temp3 (KList 8 temp4)) ; NodeValue
							(temp6
								format:
									{class: %s\nname: %s\nview: %d\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npri: %d\nsignal: $%x\n}
									((temp3 -super-:) name:)
									(temp3 name:)
									(temp3 view:)
									(temp3 loop:)
									(temp3 cel:)
									(temp3 x:)
									(temp3 y:)
									(temp3 z:)
									(temp3 heading:)
									(temp3 priority:)
									(temp3 signal:)
							)
							(if
								(not
									(Print
										addText: (temp6 data:)
										addIcon:
											(temp3 view:)
											(temp3 loop:)
											(temp3 cel:)
											(+ (Print x:) 160)
											(+ (Print y:) 192)
										init:
									)
								)
								(break)
							)
						)
						(temp6 dispose:)
					else
						(Prints {No One Home!})
						(return)
					)
				)
				(KEY_ALT_e
					(= temp3
						(if (gCast contains: (gUser alterEgo:))
							(gUser alterEgo:)
						else
							(Prints {no ego!})
							(return)
						)
					)
					(= temp6 (Str newWith: 75 {}))
					(temp6
						format:
							{name: %s\nview: %d\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npri: %d\nsignal: $%x\nscript: %s\n}
							(temp3 name:)
							(temp3 view:)
							(temp3 loop:)
							(temp3 cel:)
							(temp3 x:)
							(temp3 y:)
							(temp3 z:)
							(temp3 heading:)
							(temp3 priority:)
							(temp3 signal:)
							(if (temp3 script:)
								((temp3 script:) name:)
							else
								{..none..}
							)
					)
					(Print
						addText: (temp6 data:)
						addIcon:
							(temp3 view:)
							(temp3 loop:)
							(temp3 cel:)
							(+ (Print x:) 160)
							(+ (Print y:) 192)
						init:
					)
					(temp6 dispose:)
				)
				(KEY_ALT_f
					(PEditor init:)
					(if (gFeatures size:)
						(for
							((= temp4 0))
							(< temp4 (gFeatures size:))
							((++ temp4))
							
							(= temp3 (gFeatures at: temp4))
							(if (temp3 onMeCheck:)
								(if ((temp3 onMeCheck:) isKindOf: List)
									(for
										((= temp11 0))
										(< temp11 ((temp3 onMeCheck:) size:))
										((++ temp11))
										
										(= temp9
											((temp3 onMeCheck:) at: temp11)
										)
										(PEditor addPolygon: temp9)
									)
								else
									(PEditor addPolygon: (temp3 onMeCheck:))
								)
								((PEditor at: (- (PEditor size:) 1))
									name: (temp3 name:)
								)
							)
						)
					)
					(PEditor show: 1 scratch: 1)
					(FrameOut)
					(PEditor doit:)
					(= temp3 (Str new: 13))
					(= temp12 (Str new: 13))
					(temp12 format: {%d.fea} gCurRoomNum)
					(Print
						addTitle: {Output File Name:}
						addEdit: temp3 12 0 0 temp12
						init:
					)
					(FrameOut)
					(poly_pol name: (temp3 data:) open: 0)
					(poly_pol writeString: {;***************************\0d\n})
					(= temp6 0)
					(if (PEditor size:)
						(= temp6 (Str newWith: 5 {}))
						(for
							((= temp9 (KList 3 (PEditor elements:)))) ; FirstNode
							temp9
							((= temp9 temp10))
							
							(= temp10 (KList 6 temp9)) ; NextNode
							(= temp12 (KList 8 temp9)) ; NodeValue
							(poly_pol writeString: {\0d\n})
							(poly_pol writeString: {(instance })
							(poly_pol writeString: (temp12 name:))
							(poly_pol writeString: { of Feature\0d\n})
							(poly_pol writeString: {\t(properties\0d\n})
							(poly_pol writeString: {\t\tx})
							(= temp13 (= temp15 1000))
							(= temp14 (= temp16 0))
							(for
								((= temp4 0))
								(< temp4 (temp12 size:))
								((++ temp4))
								
								(temp12 indexToCoor: temp4)
								(if (< (temp12 currentX:) temp13)
									(= temp13 (temp12 currentX:))
								)
								(if (> (temp12 currentX:) temp14)
									(= temp14 (temp12 currentX:))
								)
								(if (< (temp12 currentY:) temp15)
									(= temp15 (temp12 currentY:))
								)
								(if (> (temp12 currentY:) temp16)
									(= temp16 (temp12 currentY:))
								)
							)
							(= temp0 (+ (/ (- temp14 temp13) 2) temp13))
							(= temp1 (+ (/ (- temp16 temp15) 2) temp15))
							(poly_pol writeString: {\t\t\t\t})
							(temp6 format: {%d} temp0)
							(poly_pol writeString: (temp6 data:))
							(poly_pol writeString: {\0d\n})
							(poly_pol writeString: {\t\ty})
							(poly_pol writeString: {\t\t\t\t})
							(temp6 format: {%d} temp1)
							(poly_pol writeString: (temp6 data:))
							(poly_pol writeString: {\0d\n})
							(poly_pol writeString: {\t\tsightAngle\t40\0d\n})
							(poly_pol writeString: {\t\tnoun\0d\n})
							(poly_pol writeString: {\t)\0d\n})
							(poly_pol writeString: {\t(method (init)\0d\n})
							(poly_pol writeString: {\t\t(self setPolygon:\0d\n})
							(temp12 writeToFile: poly_pol)
							(poly_pol writeString: {\t\t)\0d\n})
							(poly_pol
								writeString: {\t\t(super init: &rest)\0d\n}
							)
							(poly_pol writeString: {\t)\0d\n})
							(poly_pol writeString: {);})
							(poly_pol writeString: (temp12 name:))
							(poly_pol writeString: {\0d\n})
						)
					)
					(poly_pol close:)
					(if temp6
						(temp6 dispose:)
					)
					(temp3 dispose:)
					(PEditor scratch: 0 dispose:)
				)
				(KEY_ALT_g
					(= temp6 (Str newWith: 75 {}))
					(Print
						font: gUserFont
						y: 240
						addText: {Flag num?}
						addEdit: temp6 10 120
						init:
					)
					(= temp4 (temp6 asInteger:))
					(temp6 dispose:)
					(switch
						(Print
							font: gUserFont
							y: 120
							addText:
								(if (IsFlag temp4)
									{flag is SET}
								else
									{flag is CLEARED}
								)
							addButton: 1 { set } 0 28
							addButton: 2 {clear} 0 62
							addButton: -1 {cancel} 0 96
							init:
						)
						(1
							(SetFlag temp4)
						)
						(2
							(ClearFlag temp4)
						)
					)
				)
				(KEY_ALT_i
					(gGame setCursor: gNormalCursor 1)
					(repeat
						(= temp17 (gInventory first:))
						(= temp18 (= temp19 (= temp20 (= temp21 0))))
						(Print font: gUserFont)
						(repeat
							(breakif (or (not temp17) (>= temp20 100)))
							(Print
								addButton:
									temp20
									((KList 8 temp17) name:) ; NodeValue
									temp19
									temp18
							)
							((Print dialog:) setSize:)
							(if (> temp18 410)
								(= temp21 temp18)
								(= temp18 0)
								(= temp19
									(-
										((Print dialog:) nsRight:)
										((Print dialog:) nsLeft:)
									)
								)
							else
								(+= temp18 20)
							)
							(= temp17 (gInventory next: temp17))
							(++ temp20)
						)
						(Print
							addButton: -100 {Get it ALL} temp19 (+= temp18 20)
						)
						(Print
							addButton: temp20 {Outta Here} temp19 (+ temp18 20)
						)
						(breakif (== (= temp22 (Print init:)) temp20))
						(switch temp22
							(-100
								(for
									((= temp22 0))
									(< temp22 temp20)
									((++ temp22))
									
									(gEgo get: temp22)
								)
								(break)
							)
							(else
								(gEgo get: temp22)
							)
						)
					)
					(Print font: gUserFont)
				)
				(KEY_ALT_p
					(PEditor init:)
					(if (gCurRoom obstacles:)
						(PEditor readPolygonsFromList: (gCurRoom obstacles:))
					)
					(PEditor doit:)
					(= temp3 (Str new: 13))
					(= temp12 (Str new: 13))
					(temp12 format: {%d.pol} gCurRoomNum)
					(Print
						addTitle: {Output File Name:}
						addEdit: temp3 12 0 0 temp12
						init:
					)
					(FrameOut)
					(poly_pol name: (temp3 data:) open: 0)
					(poly_pol writeString: {\t\t;********************\0d\n})
					(poly_pol writeString: {\t\t(curRoom addObstacle:\0d\n})
					(if (PEditor size:)
						(PEditor eachElementDo: #writeToFile poly_pol)
						(if (gCurRoom obstacles:)
							((gCurRoom obstacles:) dispose:)
							(gCurRoom obstacles: 0)
						)
						(for
							((= temp9 (KList 3 (PEditor elements:)))) ; FirstNode
							temp9
							((= temp9 temp10))
							
							(= temp10 (KList 6 temp9)) ; NextNode
							(= temp12 (KList 8 temp9)) ; NodeValue
							(gCurRoom
								addObstacle:
									((Polygon new:)
										type: (temp12 type:)
										size: (temp12 size:)
										dynamic: 1
										points:
											((IntArray new:)
												copy: (temp12 points:)
											)
										yourself:
									)
							)
						)
					)
					(poly_pol writeString: {\t\t)\0d\n})
					(poly_pol close:)
					(temp3 dispose:)
					(PEditor dispose:)
				)
				(KEY_ALT_r
					(Printf
						{name: %s\nnumber: %u\npicture: %u\nstyle: %d\nhorizon: %d\nnorth: %u\nsouth: %u\neast: %u\nwest: %u\nscript: %s }
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
						78
						240
					)
				)
				(KEY_ALT_s
					((ScriptID 29 0) doit:) ; scalerCode
				)
				(KEY_PAUSE
					(= temp4 (GetNumber {setLoop?}))
					(= temp3 (GetNumber {which sound number?}))
					(debugSound setLoop: temp4 number: temp3 play:)
				)
				(KEY_ALT_t
					(gCurRoom newRoom: 24) ; whereTo
				)
				(KEY_ALT_u
					(gGame handsOn:)
				)
				(KEY_ALT_m
					(Printf
						{Free RAM (current): %u}
						(- (MemoryInfo 0) 500)
					)
				)
				(KEY_ALT_x
					(= gQuit 1)
				)
				(else
					(event claimed: 0)
				)
			)
		else
			(switch (event modifiers:)
				($000d 0) ; emALT | emCTRL | emRIGHT_SHIFT
				($000e 0) ; emALT | emCTRL | emLEFT_SHIFT
				($000c ; emALT | emCTRL
					(event claimed: 1)
					(event globalize:)
					(= temp0 (event x:))
					(= temp1 (event y:))
					(event localize: (gCast plane:))
					(Printf
						{global: %d/%d\n_local: %d/%d}
						temp0
						temp1
						(event x:)
						(event y:)
						75
						320
						24
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
					(= temp8 (User alterEgo:))
					(gEgo setMotion: 0)
					(while (!= ((= temp2 (Event new:)) type:) evMOUSERELEASE)
						(temp2 localize: (gCast plane:))
						(temp8 x: (temp2 x:) y: (temp2 y:))
						(if (temp8 scaler:)
							((temp8 scaler:) doit:)
						)
						(UpdateScreenItem temp8)
						(FrameOut)
						(temp2 dispose:)
					)
					(temp2 dispose:)
				)
			)
		)
	)
)

(instance poly_pol of File
	(properties
		name {poly.pol}
	)
)

