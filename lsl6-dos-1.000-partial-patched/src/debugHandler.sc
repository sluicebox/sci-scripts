;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 911)
(include sci.sh)
(use Main)
(use n079)
(use Interface)
(use Print)
(use PolyEdit)
(use WriteFeature)
(use Feature)
(use Window)
(use Ego_988)
(use Actor)
(use System)

(public
	debugHandler 0
	proc911_1 1
)

(local
	local0
	local1
	[local2 4]
)

(procedure (proc911_1 &tmp temp0 temp1 [temp2 5])
	(proc0_2)
	(= temp2 0)
	(= temp1 0)
	(gGame setCursor: gNormalCursor)
	(if
		(==
			(= temp1
				(Print
					font: gUserFont
					addText: {Your destination: }
					addEdit: @temp2 5 115 0
					addButton: 100 {____Opening_____} 19 20
					addButton: 800 { Hotel Exterior } 19 34
					addButton: 200 {_____Lobby______} 25 48
					addButton: -100 {____Restore_____} 19 62
					init:
				)
			)
			-100
		)
		(gGame restore:)
		(= temp1 0)
	)
	(if temp2
		(= temp1 (ReadNumber @temp2))
	)
	(if (or (< temp1 99) (> temp1 900))
		(= temp1 200)
	)
	(proc0_1)
	(gGame handsOff:)
	(gCurRoom newRoom: temp1)
)

(procedure (localproc_0 param1 param2 &tmp [temp0 40]) ; UNUSED
	(= temp0 0)
	(if (> argc 1)
		(Format @temp0 911 0 param2) ; "%d"
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
	(properties
		y -1
	)

	(method (handleEvent event &tmp [temp0 300] temp300 temp301 temp302 temp303 temp304 [temp305 4] temp309 temp310 temp311 temp312 temp313 temp314 temp315 temp316 temp317 temp318 temp319 temp320 temp321 temp322 temp323 temp324 temp325)
		(switch (event type:)
			(evKEYBOARD
				(event claimed: 1)
				(switch (event message:)
					(KEY_ALT_a
						(for
							((= temp303 (gCast first:)))
							temp303
							((= temp303 (gCast next: temp303)))
							
							(= temp304 (NodeValue temp303))
							(Format
								@temp0
								{name: %s\nclass: %s\nview: %d\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npri: %d\nsignal: $%x\ncycleSpeed: %d\nscaleSignal: $%x\nscaleX: %d\nscaleY: %d\nillBits: $%x\n}
								(temp304 name:)
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
								(if
									(OneOf
										(temp304 -super-:)
										Actor
										Ego
										Prop
									)
									(temp304 cycleSpeed:)
								else
									-1
								)
								(temp304 scaleSignal:)
								(temp304 scaleX:)
								(temp304 scaleY:)
								(if
									(or
										(== (temp304 -super-:) Actor)
										(== (temp304 -super-:) Ego)
									)
									(temp304 illegalBits:)
								else
									-1
								)
							)
							(if (== (temp304 scaleX:) 128)
								(Print
									addIcon:
										(temp304 view:)
										(temp304 loop:)
										(temp304 cel:)
										0
										0
									font: gUserFont
									addText:
										@temp0
										(CelWide
											(temp304 view:)
											(temp304 loop:)
											(temp304 cel:)
										)
										0
									init:
								)
							else
								(Print font: gUserFont addText: @temp0 0 0 init:)
							)
						)
					)
					(KEY_ALT_h
						(SetFlag 22)
						(gFeatures eachElementDo: #perform showFeatures)
					)
					(KEY_ALT_b
						(if (= local1 (gCast contains: gEgo))
							(gEgo hide:)
						)
						(PolyEdit doit:)
						(if local1
							(gEgo show:)
						)
					)
					(KEY_ALT_c
						(localproc_1)
						(Show 4)
						(Animate (gCast elements:))
						(repeat
							(= event (Event new:))
							(if (or (== (event type:) evMOUSEBUTTON) (== (event type:) evKEYBOARD))
								(break)
							)
							(event dispose:)
						)
						(event dispose:)
						(Show 1)
					)
					(KEY_ALT_d
						(if (= gDebugOn (not gDebugOn))
							(Prints {On})
						else
							(Prints {Off})
						)
					)
					(KEY_ALT_e
						(Format
							@temp0
							{name: %s\nclass: %s\nview: %d\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npri: %d\nsignal: $%x\ncycleSpeed: %d\nscaleSignal: $%x\nscaleX: %d\nscaleY: %d\nillBits: $%x\n}
							(gEgo name:)
							((gEgo -super-:) name:)
							(gEgo view:)
							(gEgo loop:)
							(gEgo cel:)
							(gEgo x:)
							(gEgo y:)
							(gEgo z:)
							(gEgo heading:)
							(gEgo priority:)
							(gEgo signal:)
							(gEgo cycleSpeed:)
							(gEgo scaleSignal:)
							(gEgo scaleX:)
							(gEgo scaleY:)
							(gEgo illegalBits:)
						)
						(if (== (gEgo scaleX:) 128)
							(Print
								addIcon:
									(gEgo view:)
									(gEgo loop:)
									(gEgo cel:)
									0
									0
								font: gUserFont
								addText:
									@temp0
									(CelWide
										(gEgo view:)
										(gEgo loop:)
										(gEgo cel:)
									)
									0
								init:
							)
						else
							(Print font: gUserFont addText: @temp0 0 0 init:)
						)
					)
					(KEY_ALT_f
						(= temp309 0)
						(= temp309 (GetNumber {Flag #:}))
						(if (IsFlag temp309)
							(Prints {cleared})
							(ClearFlag temp309)
						else
							(Prints {set})
							(SetFlag temp309)
						)
					)
					(KEY_ALT_g
						(= temp0 0)
						(GetInput @temp0 5 {Variable No.})
						(if (not (= temp303 (ReadNumber @temp0)))
							(return)
						)
						(= temp0 0)
						(GetInput @temp0 5 {Value})
						(= [gEgo temp303] (ReadNumber @temp0))
						(= temp0 0)
					)
					(KEY_ALT_i
						(= temp325 gTheCursor)
						(gGame setCursor: gNormalCursor)
						(proc0_2)
						(repeat
							(if (not global110)
								(SetPort 0 0 190 320 10 0)
							)
							(= temp321 (gInventory first:))
							(= temp320 (= temp319 (= temp322 (= temp323 0))))
							(Print font: gSmallFont)
							(repeat
								(breakif (not (IsObject (NodeValue temp321))))
								(Print
									addButton:
										temp322
										((NodeValue temp321) name:)
										temp319
										temp320
								)
								(if (> temp320 130)
									(= temp323 temp320)
									(= temp320 0)
									(= temp319
										(-
											((Print dialog:) nsRight:)
											((Print dialog:) nsLeft:)
										)
									)
								else
									(+= temp320 12)
								)
								(= temp321 (gInventory next: temp321))
								(++ temp322)
							)
							(Print
								addButton:
									temp322
									{Outta Here}
									temp319
									(if temp323 temp323 else temp320)
							)
							(breakif (== (= temp324 (Print init:)) temp322))
							(if (== temp324 23)
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
							(if (== temp324 39)
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
							(gEgo get: temp324)
						)
						(proc0_1)
						(if (not global110)
							(SetPort 0)
							(SetPort 0 0 139 320 10 0)
						)
						(Print font: gUserFont)
						(gGame setCursor: temp325)
					)
					(KEY_ALT_k
						(= temp300 (GetPort))
						(SetPort 0)
						(= temp316 5)
						(= temp317 16)
						(= temp312 15)
						(= temp313 80)
						(= temp315 (+ temp312 (* 34 temp316)))
						(= temp314 (+ temp313 (* 10 temp317)))
						(= temp310 (Graph grSAVE_BOX temp312 temp313 temp315 temp314 1))
						(Graph grFILL_BOX temp312 temp313 temp315 temp314 1 255)
						(for ((= temp311 0)) (< temp311 256) ((++ temp311))
							(Graph
								grFILL_BOX
								(+ temp312 temp316 (* temp316 (/ temp311 8)))
								(+ temp313 temp317 (* 16 (mod temp311 8)))
								(+
									temp312
									temp316
									temp316
									(* temp316 (/ temp311 8))
								)
								(+
									temp313
									temp317
									temp317
									(* temp317 (mod temp311 8))
								)
								1
								temp311
							)
						)
						(Graph grUPDATE_BOX temp312 temp313 temp315 temp314 1)
						(repeat
							(= temp301 (Event new:))
							(if
								(or
									(== (temp301 type:) evMOUSEBUTTON)
									(== (temp301 type:) evKEYBOARD)
								)
								(break)
							)
							(temp301 dispose:)
						)
						(temp301 dispose:)
						(Graph grRESTORE_BOX temp310)
						(Graph grUPDATE_BOX temp312 temp313 temp315 temp314 1)
						(SetPort temp300)
					)
					(KEY_ALT_m
						(gGame showMem:)
					)
					(KEY_ALT_l
						(= temp325 gTheCursor)
						(gGame setCursor: gNormalCursor)
						(if (u> (MemoryInfo 1) 1536) ; FreeHeap
							((ScriptID 952) doit:) ; sysLogger
						else
							(Prints {No Memory!!})
						)
						(gGame setCursor: temp325)
					)
					(KEY_ALT_p
						(localproc_1)
						(Show 2)
					)
					(KEY_ALT_q
						(Print
							font: gUserFont
							addTextF: {Cur X: %d,Y: %d} (event x:) (event y:)
							init:
						)
					)
					(KEY_ALT_r
						(Format
							@temp0
							{name: %s\nscript: %s\nhorizon: %d\nvanishingX: %d\nvanishingY: %d\npicAngle: %d\nnorth: %d\nsouth: %d\neast: %d\nwest: %d\nstyle: %d\ncurPic: %d}
							(gCurRoom name:)
							(if (IsObject (gCurRoom script:))
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
							addText: @temp0 0 0
							addTitle: {Room info}
							init:
						)
					)
					(KEY_ALT_t
						(proc911_1)
					)
					(KEY_ALT_s
						(for
							((= temp303 (gCast first:)))
							temp303
							((= temp303 (gCast next: temp303)))
							
							(= temp304 (NodeValue temp303))
							(if
								(and
									(not (& (temp304 signal:) $0004))
									(not (& (temp304 signal:) $0080))
								)
								(Format
									@temp0
									{Updating cast members\nname: %s\nclass: %s\nview: %d\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npri: %d\nsignal: $%x\nillBits: $%x\n}
									(temp304 name:)
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
									(if
										(or
											(== (temp304 -super-:) Actor)
											(== (temp304 -super-:) Ego)
										)
										(temp304 illegalBits:)
									else
										-1
									)
								)
								(if (== (temp304 scaleX:) 128)
									(Print
										addIcon:
											(temp304 view:)
											(temp304 loop:)
											(temp304 cel:)
											0
											0
										font: gUserFont
										addText:
											@temp0
											(CelWide
												(temp304 view:)
												(temp304 loop:)
												(temp304 cel:)
											)
											0
										window: SysWindow
										init:
									)
								else
									(Print
										font: gUserFont
										addText: @temp0 0 0
										window: SysWindow
										init:
									)
								)
							)
						)
					)
					(KEY_ALT_u
						(gGame handsOn:)
					)
					(KEY_ALT_v
						(Show 1)
					)
					(KEY_ALT_w
						(WriteCode doit:)
					)
					(KEY_ALT_y
						(if (= local1 (gCast contains: gEgo))
							(gEgo hide:)
						)
						(PolyEdit doit:)
						(if local1
							(gEgo show:)
						)
					)
					(KEY_ALT_z
						(= gQuit 1)
					)
					(KEY_ALT_x
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
						(= temp309 0)
						(= temp309 (GetNumber {Flag #:}))
						(if (IsFlag temp309)
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

(instance showFeatures of Code
	(properties)

	(method (doit param1 &tmp temp0 [temp1 2] temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10)
		(cond
			((not (param1 isKindOf: Feature)) 0)
			((IsObject (= temp0 (param1 onMeCheck:)))
				(= temp6 -1)
				(= temp7 -1)
				(= temp10 0)
				(for
					((= temp3 (temp0 points:)))
					(< temp10 (temp0 size:))
					((+= temp3 4))
					
					(= temp5 (Memory memPEEK (+ temp3 2)))
					(= temp4 (Memory memPEEK temp3))
					(if (and (!= temp6 -1) (!= temp7 -1))
						(Graph grDRAW_LINE temp7 temp6 temp5 temp4 15 -1)
					else
						(= temp8 temp4)
						(= temp9 temp5)
					)
					(= temp6 temp4)
					(= temp7 temp5)
					(++ temp10)
				)
				(Graph grDRAW_LINE temp9 temp8 temp5 temp4 15 -1)
			)
			((!= (param1 onMeCheck:) 0)
				(Graph
					grDRAW_LINE
					(param1 nsTop:)
					(param1 nsLeft:)
					(param1 nsTop:)
					(param1 nsRight:)
					15
					-1
				)
				(Graph
					grDRAW_LINE
					(param1 nsBottom:)
					(param1 nsLeft:)
					(param1 nsBottom:)
					(param1 nsRight:)
					15
					-1
				)
				(Graph
					grDRAW_LINE
					(param1 nsTop:)
					(param1 nsLeft:)
					(param1 nsBottom:)
					(param1 nsLeft:)
					15
					-1
				)
				(Graph
					grDRAW_LINE
					(param1 nsTop:)
					(param1 nsRight:)
					(param1 nsBottom:)
					(param1 nsRight:)
					15
					-1
				)
			)
		)
		(Graph grUPDATE_BOX 0 0 190 320 1)
	)
)

