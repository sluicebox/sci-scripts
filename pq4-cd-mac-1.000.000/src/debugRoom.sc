;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use dCastD)
(use n045)
(use Interface)
(use Str)
(use Print)
(use Feature)
(use Sound)
(use File)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	debugRoom 0
)

(local
	[local0 2]
)

(procedure (localproc_0) ; UNUSED
	(if (OneOf (gCurRoom style:) 16 15 17 18)
		(gCurRoom drawPic: (gCurRoom picture:) 0 style: 0)
	)
)

(instance debugRoom of Feature
	(properties)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(DisposeScript 10)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 [temp5 7] temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evKEYBOARD
				(event claimed: 1)
				(proc45_1)
				(switch (event message:)
					(KEY_QUESTION
						(gThePlane setRect: 0 0 320 199)
						(Prints
							{Key commands:\nSHIFT-A show cAst\nSHIFT-D dialog editor\nSHIFT-E show Ego\nSHIFT-F show Features\nSHIFT-I get inventory\nSHIFT-J justify text\nSHIFT-K show palette\nSHIFT-O create Obstacles\nSHIFT-P priority map\n}
						)
						(Prints
							{SHIFT-R room info\nSHIFT-S switch alterego\nSHIFT-T teleport\nSHIFT-U handsOn\nSHIFT-V visual map\nSHIFT-W write features\nSHIFT-X eXit game\nSHIFT-Y toggle CD flag\nSHIFT-Z reverse palette\n\nCTRL-L note logger\nCTRL-S sound test\n}
						)
						(gThePlane setRect: 0 0 320 152)
					)
					(KEY_A
						(if (gCast size:)
							(= temp4 (Str newWith: 75 {}))
							(for
								((= temp3 (gCast first:)))
								temp3
								((= temp3 (gCast next: temp3)))
								
								(= temp2 (NodeValue temp3))
								(if (temp2 respondsTo: #cycler)
									(temp4
										format:
											{class: %s\nview: %d\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npriority: %d\nfixPriority: %d\nsignal: $%x\ncycler: %s\nscript: %s }
											((temp2 -super-:) name:)
											(temp2 view:)
											(temp2 loop:)
											(temp2 cel:)
											(temp2 x:)
											(temp2 y:)
											(temp2 z:)
											(temp2 heading:)
											(temp2 priority:)
											(temp2 fixPriority:)
											(temp2 signal:)
											(and
												(temp2 cycler:)
												((temp2 cycler:) name:)
											)
											(and
												(temp2 script:)
												((temp2 script:) name:)
											)
									)
								else
									(temp4
										format:
											{class: %s\nview: %d\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npriority: %d\nfixPriority: %d\nsignal: $%x\n}
											((temp2 -super-:) name:)
											(temp2 view:)
											(temp2 loop:)
											(temp2 cel:)
											(temp2 x:)
											(temp2 y:)
											(temp2 z:)
											(temp2 heading:)
											(temp2 priority:)
											(temp2 fixPriority:)
											(temp2 signal:)
									)
								)
								(if
									(not
										(Print
											width: 200
											addText: (temp4 data:)
											addTitle: (temp2 name:)
											addIcon:
												(temp2 view:)
												(temp2 loop:)
												(temp2 cel:)
												(+ (Print x:) 120)
												(+ (Print y:) 85)
											init:
										)
									)
									(break)
								)
							)
							(temp4 dispose:)
						else
							(Prints {== (cast size?) 0})
							(return)
						)
					)
					(KEY_B)
					(KEY_E
						(= temp2
							(cond
								(global106 global106)
								((gCast contains: (gUser alterEgo:))
									(gUser alterEgo:)
								)
								(else
									(Prints {no ego!})
									(return)
								)
							)
						)
						(= temp4 (Str newWith: 75 {}))
						(temp4
							format:
								{name: %s\nview: %d\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npri: %d\nsignal: $%x\nscript: %s\n}
								(temp2 name:)
								(temp2 view:)
								(temp2 loop:)
								(temp2 cel:)
								(temp2 x:)
								(temp2 y:)
								(temp2 z:)
								(temp2 heading:)
								(temp2 priority:)
								(temp2 signal:)
								(if (temp2 script:)
									((temp2 script:) name:)
								else
									{..none..}
								)
						)
						(Print
							addText: (temp4 data:)
							addIcon:
								(temp2 view:)
								(temp2 loop:)
								(temp2 cel:)
								(+ (Print x:) 80)
								(+ (Print y:) 80)
							init:
						)
						(temp4 dispose:)
					)
					(KEY_G
						(= temp4 (Str newWith: 75 {}))
						(Print
							font: gUserFont
							y: 100
							addText: {Flag num?}
							addEdit: temp4 5 50
							init:
						)
						(= temp3 (temp4 asInteger:))
						(temp4 dispose:)
						(switch
							(Print
								font: gUserFont
								y: 50
								addText:
									(if (gPqFlags test: temp3)
										{flag is TRUE}
									else
										{flag is FALSE}
									)
								addButton: 1 { set } 0 12
								addButton: 2 {clear} 0 26
								addButton: -1 {cancel} 0 40
								init:
							)
							(1
								(gPqFlags set: temp3)
							)
							(2
								(gPqFlags clear: temp3)
							)
						)
					)
					(KEY_H
						(Palette 2 0 255 100) ; PalIntensity
						(Palette 1 999 2) ; PalLoad
						(palCel x: 90 y: 25 init:)
						(UpdateScreenItem palCel)
						(Print fore: 37 back: 0 x: 130 y: 153)
						(Printf {Press <ENTER> to continue...})
						(palCel dispose:)
					)
					(KEY_I
						(if (IsHiRes)
							(= temp18 gTheCursor)
							(gGame setCursor: gNormalCursor)
							(repeat
								(= temp13 (gInventory first:))
								(= temp16 (= temp17 (= temp14 (= temp19 0))))
								(Print font: gSmallFont)
								(repeat
									(breakif (not temp13))
									(Print
										addButton:
											temp14
											((NodeValue temp13) name:)
											temp17
											temp16
									)
									((Print dialog:) setSize:)
									(if (> temp16 130)
										(= temp19 temp16)
										(= temp16 0)
										(= temp17
											(-
												((Print dialog:) nsRight:)
												((Print dialog:) nsLeft:)
											)
										)
									else
										(+= temp16 15)
									)
									(= temp13 (gInventory next: temp13))
									(++ temp14)
								)
								(Print
									addButton:
										temp14
										{Outta Here}
										temp17
										(if temp19 temp19 else temp16)
								)
								(breakif (== (= temp15 (Print init:)) temp14))
								(gEgo get: temp15)
							)
							(Print font: gUserFont)
						else
							(gThePlane setRect: 0 0 320 199)
							(while 1
								(= temp4 (Str newWith: 5 {}))
								(= temp1
									(Print
										font: gUserFont
										y: 25
										addText: {inv number:}
										addEdit: temp4 5 50 0
										addButton: -1 {all} 0 20
										addButton: -2 {done} 20 20
										init:
									)
								)
								(if (temp4 size:)
									(= temp1 (temp4 asInteger:))
								)
								(cond
									((== temp1 -1)
										(for
											((= temp12 (gInventory first:)))
											temp12
											((= temp12 (gInventory next: temp12)))
											
											(if
												((= temp2 (NodeValue temp12))
													isKindOf: InvI
												)
												(temp2 owner: gEgo)
											)
										)
										(break)
									)
									((== temp1 -2)
										(break)
									)
									(else
										(gEgo get: temp1)
										(temp4 dispose:)
									)
								)
							)
							(temp4 dispose:)
							(gThePlane setRect: 0 0 320 152)
						)
					)
					(KEY_J
						(JustifyText init:)
					)
					(KEY_L
						((ScriptID 64952) doit:) ; sysLogger
					)
					(KEY_M
						(if (gPqFlags test: 1)
							(Printf {DEBUG: Map is now on})
							(gPqFlags clear: 1)
							(gTheIconBar enable: 6)
						else
							(Printf {DEBUG: Map is now off})
							(gPqFlags set: 1)
							(gTheIconBar disable: 6)
						)
					)
					(KEY_R
						(Printf
							{name: %s\nnumber: %d\ncurrent pic: %d\nstyle: %d\nhorizon: %d\nnorth: %d\nsouth: %d\neast: %d\nwest: %d\nscript: %s }
							(gCurRoom name:)
							gCurRoomNum
							(gCurRoom curPic:)
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
							120
						)
						(gGame showMem:)
					)
					(KEY_S
						(if (gCast size:)
							((ScriptID 10 0) doit:) ; dCastD
						else
							(Prints {No One Home!})
							(return)
						)
					)
					(KEY_T
						(if (> (= temp3 (GetNumber {Which room number?})) 0)
							(gCurRoom newRoom: temp3)
						)
					)
					(KEY_U
						(gGame handsOn:)
					)
					(KEY_X
						(= gQuit 1)
					)
					(KEY_Y
						(if (gPqFlags test: 0)
							(gPqFlags clear: 0)
							(Prints {Now using floppy rooms})
						else
							(gPqFlags set: 0)
							(Prints {Now using CD rooms})
						)
					)
					(KEY_Z
						(Prints
							{Debug: CLEAR THE CURRENT PALETTE. Note: This is a one-way trip.}
						)
						(PalVary 1 0) ; PalVaryReverse
					)
					(KEY_PAUSE
						(= temp3 (GetNumber {setLoop?}))
						(= temp2 (GetNumber {which sound number?}))
						(debugSound setLoop: temp3 number: temp2 play:)
					)
					(else
						(event claimed: 0)
					)
				)
				(proc45_2)
			)
			(evMOUSEBUTTON
				(proc45_1)
				(switch (event modifiers:)
					($000d 0) ; emALT | emCTRL | emRIGHT_SHIFT
					($000e 0) ; emALT | emCTRL | emLEFT_SHIFT
					($000c ; emALT | emCTRL
						(event claimed: 1)
						(= temp4 (Str newWith: 75 {}))
						(temp4 format: {%d/%d} (event x:) (event y:))
						(Print
							addText: (temp4 data:)
							posn: 160 10
							font: 999
							modeless: 1
							init:
						)
					)
					($0005 ; emCTRL | emRIGHT_SHIFT
						(event type: evKEYBOARD message: KEY_R)
						(self handleEvent: event)
					)
					($0006 ; emCTRL | emLEFT_SHIFT
						(event type: evKEYBOARD message: KEY_E)
						(self handleEvent: event)
					)
					($0009 0) ; emALT | emRIGHT_SHIFT
					($000a 0) ; emALT | emLEFT_SHIFT
					(emRIGHT_SHIFT 0)
					(emLEFT_SHIFT 0)
					(emCTRL 0)
					(emALT
						(event claimed: 1)
						(= temp2
							(if global106
								global106
							else
								(User alterEgo:)
							)
						)
						(gEgo setMotion: 0)
						(while (!= ((= temp1 (Event new:)) type:) evMOUSERELEASE)
							(temp2 x: (temp1 x:) y: (temp1 y:))
							(if (temp2 scaler:)
								((temp2 scaler:) doit:)
							)
							(UpdateScreenItem temp2)
							(FrameOut)
							(temp1 dispose:)
						)
						(temp1 dispose:)
					)
				)
				(proc45_2)
			)
		)
	)
)

(instance poly_pol of File ; UNUSED
	(properties
		name {poly.pol}
	)
)

(instance palCel of View
	(properties
		priority 250
		fixPriority 1
		view 19
	)
)

(instance debugSound of Sound
	(properties)
)

