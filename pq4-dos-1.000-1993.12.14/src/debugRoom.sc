;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use dCastD)
(use Interface)
(use Str)
(use Print)
(use Feature)
(use Sound)
(use Inventory)
(use User)
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

(instance debugSound of Sound
	(properties)
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

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 [temp4 7] temp11)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evKEYBOARD
				(event claimed: 1)
				(switch (event message:)
					(KEY_QUESTION
						(gThePlane setRect: 0 0 320 199)
						(Prints
							{Key commands:\nALT-A show cAst\nALT-D dialog editor\nALT-E show Ego\nALT-F show Features\nALT-I get inventory\nALT-J justify text\nALT-K show palette\nALT-O create Obstacles\nALT-P priority map\n}
						)
						(Prints
							{ALT-R room info\nALT-S switch alterego\nALT-T teleport\nALT-U handsOn\nALT-V visual map\nALT-W write features\nALT-X eXit game\nALT-Y toggle CD flag\nALT-Z reverse palette\n\nCTRL-L note logger\nCTRL-S sound test\n}
						)
						(gThePlane setRect: 0 0 320 152)
					)
					(KEY_ALT_a
						(if (gCast size:)
							(= temp3 (Str newWith: 75 {}))
							(for
								((= temp2 (gCast first:)))
								temp2
								((= temp2 (gCast next: temp2)))
								
								(= temp1 (NodeValue temp2))
								(temp3
									format:
										{class: %s\nview: %d\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npri: %d\nsignal: $%x\n}
										((temp1 -super-:) name:)
										(temp1 view:)
										(temp1 loop:)
										(temp1 cel:)
										(temp1 x:)
										(temp1 y:)
										(temp1 z:)
										(temp1 heading:)
										(temp1 priority:)
										(temp1 signal:)
								)
								(if
									(not
										(Print
											addText: (temp3 data:)
											addTitle: (temp1 name:)
											addIcon:
												(temp1 view:)
												(temp1 loop:)
												(temp1 cel:)
												(+ (Print x:) 80)
												(+ (Print y:) 80)
											init:
										)
									)
									(break)
								)
							)
							(temp3 dispose:)
						else
							(Prints {No One Home!})
							(return)
						)
					)
					(KEY_ALT_e
						(= temp1
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
						(= temp3 (Str newWith: 75 {}))
						(temp3
							format:
								{name: %s\nview: %d\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npri: %d\nsignal: $%x\nscript: %s\n}
								(temp1 name:)
								(temp1 view:)
								(temp1 loop:)
								(temp1 cel:)
								(temp1 x:)
								(temp1 y:)
								(temp1 z:)
								(temp1 heading:)
								(temp1 priority:)
								(temp1 signal:)
								(if (temp1 script:)
									((temp1 script:) name:)
								else
									{..none..}
								)
						)
						(Print
							addText: (temp3 data:)
							addIcon:
								(temp1 view:)
								(temp1 loop:)
								(temp1 cel:)
								(+ (Print x:) 80)
								(+ (Print y:) 80)
							init:
						)
						(temp3 dispose:)
					)
					(KEY_ALT_g
						(= temp3 (Str newWith: 75 {}))
						(Print
							font: gUserFont
							y: 100
							addText: {Flag num?}
							addEdit: temp3 5 50
							init:
						)
						(= temp2 (temp3 asInteger:))
						(temp3 dispose:)
						(switch
							(Print
								font: gUserFont
								y: 50
								addText:
									(if (gPqFlags test: temp2)
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
								(gPqFlags set: temp2)
							)
							(2
								(gPqFlags clear: temp2)
							)
						)
					)
					(KEY_ALT_i
						(gThePlane setRect: 0 0 320 199)
						(while 1
							(= temp3 (Str newWith: 5 {}))
							(= temp0
								(Print
									font: gUserFont
									y: 25
									addText: {inv number:}
									addEdit: temp3 5 50 0
									addButton: -1 {all} 0 20
									addButton: -2 {done} 20 20
									init:
								)
							)
							(if (temp3 size:)
								(= temp0 (temp3 asInteger:))
							)
							(cond
								((== temp0 -1)
									(for
										((= temp11 (gInventory first:)))
										temp11
										((= temp11 (gInventory next: temp11)))
										
										(if
											((= temp1 (NodeValue temp11))
												isKindOf: InvI
											)
											(temp1 owner: gEgo)
										)
									)
									(break)
								)
								((== temp0 -2)
									(break)
								)
								(else
									(gEgo get: temp0)
									(temp3 dispose:)
								)
							)
						)
						(temp3 dispose:)
						(gThePlane setRect: 0 0 320 152)
					)
					(KEY_ALT_j
						(JustifyText init:)
					)
					(KEY_ALT_o
						(Unknown_Class_110 doit:)
					)
					(KEY_ALT_r
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
					(KEY_ALT_s
						(if (gCast size:)
							((ScriptID 10 0) doit:) ; dCastD
						else
							(Prints {No One Home!})
							(return)
						)
					)
					(KEY_ALT_t
						(if (> (= temp2 (GetNumber {Which room number?})) 0)
							(gCurRoom newRoom: temp2)
						)
					)
					(KEY_ALT_u
						(gGame handsOn:)
					)
					(KEY_ALT_x
						(= gQuit 1)
					)
					(KEY_ALT_y
						(if (gPqFlags test: 0)
							(gPqFlags clear: 0)
							(Prints {Now using floppy rooms})
						else
							(gPqFlags set: 0)
							(Prints {Now using CD rooms})
						)
					)
					(KEY_ALT_z
						(Prints
							{Debug: CLEAR THE CURRENT PALETTE. Note: This is a one-way trip.}
						)
						(PalVary 1 0) ; PalVaryReverse
					)
					(KEY_PAUSE
						(= temp2 (GetNumber {setLoop?}))
						(= temp1 (GetNumber {which sound number?}))
						(debugSound setLoop: temp2 number: temp1 play:)
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
						(= temp3 (Str newWith: 75 {}))
						(temp3 format: {%d/%d} (event x:) (event y:))
						(Print
							addText: (temp3 data:)
							posn: 160 10
							font: 999
							modeless: 1
							init:
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
						(= temp1
							(if global106
								global106
							else
								(User alterEgo:)
							)
						)
						(gEgo setMotion: 0)
						(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
							(temp1 x: (temp0 x:) y: (temp0 y:))
							(if (temp1 scaler:)
								((temp1 scaler:) doit:)
							)
							(UpdateScreenItem temp1)
							(FrameOut)
							(temp0 dispose:)
						)
						(temp0 dispose:)
					)
				)
			)
		)
	)
)

