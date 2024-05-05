;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 911)
(include sci.sh)
(use Main)
(use fileScr)
(use EditablePolygon)
(use Str)
(use Print)
(use Feature)
(use File)
(use System)

(public
	debugHandler 0
)

(local
	[local0 7]
	local7
)

(procedure (localproc_0 param1 &tmp temp0 temp1 temp2)
	(= temp2 (Str new: 6))
	(= temp1 0)
	(gGame setCursor: gNormalCursor)
	(if
		(==
			(= temp1
				(Print
					font: gUserFont
					addText: {Your destination: }
					addEdit: temp2 5 115 0
					addButton: 100 {____Opening_____} 19 20
					addButton: 800 { Hotel Exterior } 19 38
					addButton: 200 {_____Lobby______} 19 56
					init:
				)
			)
			-100
		)
		(gGame restore:)
		(= temp1 0)
	)
	(if (temp2 size:)
		(= temp1 (temp2 asInteger:))
	)
	(if (or (< temp1 99) (> temp1 900))
		(= temp1 200)
	)
	(temp2 dispose:)
	(gGame handsOff:)
	(if (and argc param1)
		(return temp1)
	else
		(gCurRoom newRoom: temp1)
	)
)

(procedure (localproc_1 param1 param2 &tmp temp0 temp1) ; UNUSED
	(= temp0 (Str new:))
	(if (> argc 1)
		(temp0 format: {%d} param2)
	)
	(= temp1
		(if (GetInput temp0 10 param1)
			(temp0 asInteger:)
		else
			-1
		)
	)
	(temp0 dispose:)
	(return temp1)
)

(procedure (localproc_2) ; UNUSED
	(if (OneOf (gCurRoom style:) 16 15 17 18)
		(gCurRoom drawPic: (gCurRoom picture:) 0 style: 0)
	)
)

(instance debugHandler of Feature
	(properties
		y -1
	)

	(method (handleEvent event &tmp temp0 [temp1 3] temp4 temp5 [temp6 4] temp10 [temp11 8] temp19 temp20 temp21 temp22 temp23 temp24 temp25 temp26)
		(switch (event type:)
			(evKEYBOARD
				(event claimed: 1)
				(switch (event message:)
					(KEY_A
						(if (gCast size:)
							(= temp0 (Str newWith: 75 {}))
							(for
								((= temp10 (gCast first:)))
								temp10
								((= temp10 (gCast next: temp10)))
								
								(= temp5 (NodeValue temp10))
								(if (temp5 respondsTo: #cycler)
									(temp0
										format:
											{class: %s\nview: %d\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npriority: %d\nfixPriority: %d\nsignal: $%x\ncycler: %s\nscript: %s }
											((temp5 -super-:) name:)
											(temp5 view:)
											(temp5 loop:)
											(temp5 cel:)
											(temp5 x:)
											(temp5 y:)
											(temp5 z:)
											(temp5 heading:)
											(temp5 priority:)
											(temp5 fixPriority:)
											(temp5 signal:)
											(and
												(temp5 cycler:)
												((temp5 cycler:) name:)
											)
											(and
												(temp5 script:)
												((temp5 script:) name:)
											)
									)
								else
									(temp0
										format:
											{class: %s\nview: %d\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npriority: %d\nfixPriority: %d\nsignal: $%x\n}
											((temp5 -super-:) name:)
											(temp5 view:)
											(temp5 loop:)
											(temp5 cel:)
											(temp5 x:)
											(temp5 y:)
											(temp5 z:)
											(temp5 heading:)
											(temp5 priority:)
											(temp5 fixPriority:)
											(temp5 signal:)
									)
								)
								(if
									(not
										(Print
											width: 200
											addText: (temp0 data:)
											addTitle: (temp5 name:)
											addIcon:
												(temp5 view:)
												(temp5 loop:)
												(temp5 cel:)
												(+ (Print x:) 120)
												(+ (Print y:) 85)
											init:
										)
									)
									(break)
								)
							)
							(temp0 dispose:)
						else
							(Prints {== (cast size?) 0})
							(return)
						)
					)
					(JOY_UPRIGHT
						(= local7 (Str format: {%03d.BMP} gCurRoomNum))
						(SaveScreen (local7 data:))
						(if (FileIO fiEXISTS (local7 data:))
							(Printf
								{%03d.BMP SUCCESSFULLY CREATED}
								gCurRoomNum
							)
						else
							(Printf {ERROR CREATING %03d.BMP} gCurRoomNum)
						)
					)
					(JOY_DOWN
						(if (not (gFeatures size:))
							(return)
						)
						(PEditor init:)
						(for
							((= temp10 0))
							(< temp10 (gFeatures size:))
							((++ temp10))
							
							(= temp5 (gFeatures at: temp10))
							(if (temp5 onMeCheck:)
								(if ((temp5 onMeCheck:) isKindOf: List)
									(for
										((= temp19 0))
										(< temp19 ((temp5 onMeCheck:) size:))
										((++ temp19))
										
										(= temp5
											((temp5 onMeCheck:) at: temp19)
										)
										(PEditor addPolygon: temp5)
									)
								else
									(PEditor addPolygon: (temp5 onMeCheck:))
								)
								((PEditor at: (- (PEditor size:) 1))
									name: (temp5 name:)
								)
							)
						)
						(PEditor show: 1)
						(FrameOut)
						(PEditor doit:)
						(= temp5 (Str new: 13))
						(Print
							addTitle: {Output File Name:}
							addEdit: temp5 12 0 0 {FEATURE.POL}
							init:
						)
						(poly_pol name: (temp5 data:) open: 0)
						(if (PEditor size:)
							(PEditor eachElementDo: #writeToFile poly_pol 1)
						)
						(poly_pol close:)
						(temp5 dispose:)
						(PEditor dispose:)
					)
					(KEY_B
						(PEditor init:)
						(if (gCurRoom obstacles:)
							(PEditor readPolygonsFromList: (gCurRoom obstacles:))
						)
						(PEditor doit:)
						(= temp5 (Str new: 13))
						(Print
							addTitle: {Output File Name:}
							addEdit: temp5 12 0 0 {ROOM.POL}
							init:
						)
						(poly_pol name: (temp5 data:) open: 0)
						(poly_pol writeString: {\t\t(curRoom addObstacle:\0d\n})
						(if (PEditor size:)
							(PEditor eachElementDo: #writeToFile poly_pol)
						)
						(poly_pol writeString: {\t\t)\0d\n})
						(poly_pol close:)
						(temp5 dispose:)
						(PEditor dispose:)
					)
					(KEY_D
						(if (= gDebugOn (not gDebugOn))
							(Prints {On})
						else
							(Prints {Off})
						)
					)
					(KEY_E
						(= temp5 (gUser alterEgo:))
						(= temp0 (Str newWith: 75 {}))
						(temp0
							format:
								{name: %s\nview: %d\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npri: %d\nsignal: $%x\nscaleSignal: $%x\nscaleX: %d\nscaleY: %d\nmaxScale: %d\nscaleType: %d\nscript: %s\n}
								(temp5 name:)
								(temp5 view:)
								(temp5 loop:)
								(temp5 cel:)
								(temp5 x:)
								(temp5 y:)
								(temp5 z:)
								(temp5 heading:)
								(temp5 priority:)
								(temp5 signal:)
								(temp5 scaleSignal:)
								(temp5 scaleX:)
								(temp5 scaleY:)
								(temp5 maxScale:)
								(temp5 scaleType:)
								(if (temp5 script:)
									((temp5 script:) name:)
								else
									{..none..}
								)
						)
						(Print
							addText: (temp0 data:)
							addIcon:
								(temp5 view:)
								(temp5 loop:)
								(temp5 cel:)
								(+ (Print x:) 90)
								(+ (Print y:) 80)
							init:
						)
						(temp0 dispose:)
					)
					(KEY_F
						(= temp0 (Str newWith: 75 {}))
						(Print
							font: gUserFont
							y: 100
							addText: {Flag num?}
							addEdit: temp0 3 70 -1
							init:
						)
						(= temp10 (temp0 asInteger:))
						(temp0 dispose:)
						(if (gFlags test: temp10)
							(Printf {set})
							(SetFlag temp10)
						else
							(Printf {cleared})
							(ClearFlag temp10)
						)
					)
					(KEY_G
						(= temp0 (Str newWith: 75 {}))
						(Print
							font: gUserFont
							y: 100
							addText: {Global num?}
							addEdit: temp0 3 70 -1
							init:
						)
						(= temp4 (temp0 asInteger:))
						(temp0 dispose:)
						(if (not temp4)
							(return)
						)
						(= temp0 (Str newWith: 75 {}))
						(Print
							font: gUserFont
							y: 100
							addText: {Set to?}
							addEdit: temp0 3 70 -1
							init:
						)
						(= [gEgo temp4] (temp0 asInteger:))
						(temp0 dispose:)
					)
					(KEY_I
						(= temp26 gTheCursor)
						(gGame setCursor: gNormalCursor)
						(repeat
							(= temp22 (gInventory first:))
							(= temp21 (= temp20 (= temp23 (= temp24 0))))
							(Print font: gSmallFont)
							(repeat
								(breakif (not temp22))
								(Print
									addButton:
										temp23
										((NodeValue temp22) name:)
										temp20
										temp21
								)
								((Print dialog:) setSize:)
								(if (> temp21 130)
									(= temp24 temp21)
									(= temp21 0)
									(= temp20
										(-
											((Print dialog:) nsRight:)
											((Print dialog:) nsLeft:)
										)
									)
								else
									(+= temp21 15)
								)
								(= temp22 (gInventory next: temp22))
								(++ temp23)
							)
							(Print
								addButton:
									temp23
									{Outta Here}
									temp20
									(if temp24 temp24 else temp21)
							)
							(breakif (== (= temp25 (Print init:)) temp23))
							(if (== temp25 23)
								(switch
									(Print
										addButton: 2 {Empty} 0 0
										addButton: 0 {Full} 0 12
										addButton: 1 {Lit} 0 24
										init:
									)
									(0
										((gInventory at: 23) noun: 13 message: 40) ; lamp
									)
									(1
										((gInventory at: 23) noun: 20 message: 41) ; lamp
									)
									(2
										((gInventory at: 23) noun: 19 message: 39) ; lamp
									)
								)
							)
							(if (== temp25 39)
								(switch
									(Print
										addButton: 0 {Dry} 0 0
										addButton: 1 {Wet} 0 12
										addButton: 2 {Cold} 0 24
										init:
									)
									(0
										((gInventory at: 39) noun: 25 message: 35) ; washcloth
									)
									(1
										((gInventory at: 39) noun: 50 message: 36) ; washcloth
									)
									(2
										((gInventory at: 39) noun: 52 message: 37) ; washcloth
									)
								)
							)
							(gEgo get: temp25)
						)
						(Print font: gUserFont)
						(gGame setCursor: temp26)
					)
					(KEY_M
						(Printf
							{Current free memory: %u kBytes\nMax available: %u kBytes\nmachineSpeed: %d}
							(MemoryInfo 0)
							global260
							gHowFast
						)
					)
					(KEY_L
						(= temp26 gTheCursor)
						(gGame setCursor: gNormalCursor)
						((ScriptID 64952) doit:) ; sysLogger
						(gGame setCursor: temp26)
					)
					(KEY_Q
						(Print
							font: gUserFont
							addTextF: {Cur X: %d,Y: %d} (event x:) (event y:)
							init:
						)
					)
					(KEY_R
						(= temp0 (Str newWith: 75 {}))
						(temp0
							format:
								{name: %s\nscript: %s\nhorizon: %d\nvanishingX: %d\nvanishingY: %d\npicAngle: %d\nnorth: %d\nsouth: %d\neast: %d\nwest: %d\nstyle: %d\ncurPic: %d}
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
						(Print
							font: gUserFont
							addText: (temp0 data:) 0 0
							addTitle: {Room info}
							init:
						)
						(temp0 dispose:)
					)
					(KEY_T
						(localproc_0)
					)
					(KEY_U
						(gGame handsOn:)
					)
					(KEY_Z
						(= gQuit 1)
					)
					(KEY_X
						(= gQuit 1)
					)
					(KEY_QUESTION
						(Print
							font: gUserFont
							addText:
								{Debug Help\n\nALT-A Show Cast\nALT-B Polygon Editor\nALT-C Control map\nALT-D DebugOn toggle\nALT-F Flag set/clr\nALT-G Global set\nALT-H Show Features\nALT-I Inv items\nALT-L Log file\nALT-M Memory\n... }
							init:
						)
						(Print
							font: gUserFont
							addText:
								{ALT-P Priority map\nALT-Q show Cursor Coords\nALT-R Room info\nALT-S Updating cast elements\nALT-T Teleport\nALT-U return User control\nALT-V Visual map\nALT-W feature Writer\nALT-Y Vanishing point adj\nALT-X I'm outta here }
							init:
						)
					)
					($005c ; \
						(= temp0 (Str newWith: 75 {}))
						(Print
							font: gUserFont
							y: 100
							addText: {Flag num?}
							addEdit: temp0 5 50
							init:
						)
						(= temp10 (temp0 asInteger:))
						(temp0 dispose:)
						(if (gFlags test: temp10)
							(Prints {Flag Currently Set})
						else
							(Prints {Flag Currently Clear})
						)
					)
					(else
						(event claimed: 0)
					)
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

