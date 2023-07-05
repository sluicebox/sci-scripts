;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 911)
(include sci.sh)
(use Main)
(use Interface)
(use n913)
(use Print)
(use PolyEdit)
(use DialogEditor)
(use WriteFeature)
(use Feature)
(use Window)
(use Ego)
(use User)
(use Actor)
(use System)

(public
	debugHandler 0
	proc911_1 1
)

(local
	local0
	local1
)

(procedure (proc911_1 &tmp temp0 temp1 [temp2 5])
	(= temp2 0)
	(= temp1 0)
	(gGame setCursor: gNormalCursor)
	(repeat
		(breakif
			(!=
				(= temp1
					(Print
						font: gSmallFont
						addText: {Where to, STUD?}
						addEdit: @temp2 5 80
						addButton: 100 {      Opening        } 0 20
						addButton: 200 { Isle of the Crown } 101 20
						addButton: 300 {  Isle Sacred Mtn  } 0 34
						addButton: 405 {     Labyrinth     } 101 34
						addButton: 450 {  Isle of Wonder   } 0 48
						addButton: 500 {   Isle of Beast   } 101 48
						addButton: 550 { Isle of the Mists } 0 62
						addButton: 600 { Realm of the Dead } 101 62
						addButton: 730 {  Castle - Beauty  } 0 76
						addButton: 710 {Castle - Magic Door} 101 76
						addButton: -100 {     < Restore >     } 0 90
						addButton: 205 {     Tutorial      } 101 90
						init:
					)
				)
				0
			)
		)
	)
	(if temp2
		(= temp1 (ReadNumber @temp2))
	)
	(if (== temp1 -100)
		(gGame restore:)
	)
	(if (< gHowFast 100)
		(+= gHowFast temp1)
	else
		(+= gHowFast 1000)
	)
	(if (OneOf temp1 200 300 450 500 550)
		(SetFlag 103)
	)
	(gCurRoom newRoom: temp1)
)

(procedure (localproc_0 param1 param2 &tmp [temp0 40])
	(= temp0 0)
	(if (> argc 1)
		(Format @temp0 911 0 param2)
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

	(method (handleEvent event &tmp [temp0 200] temp200 temp201 temp202 temp203 temp204 [temp205 4] temp209 temp210 temp211 temp212 temp213 temp214 temp215 temp216 temp217)
		(switch (event type:)
			(evKEYBOARD
				(event claimed: 1)
				(switch (event message:)
					(KEY_ALT_a
						(for
							((= temp203 (gCast first:)))
							temp203
							((= temp203 (gCast next: temp203)))
							
							(= temp204 (NodeValue temp203))
							(Format
								@temp0
								{name: %s\nclass: %s\nview: %d\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npri: %d\nsignal: $%x\nscaleSignal: $%x\nscaleX: %d\nscaleY: %d\nillBits: $%x\n}
								(temp204 name:)
								((temp204 -super-:) name:)
								(temp204 view:)
								(temp204 loop:)
								(temp204 cel:)
								(temp204 x:)
								(temp204 y:)
								(temp204 z:)
								(temp204 heading:)
								(temp204 priority:)
								(temp204 signal:)
								(temp204 scaleSignal:)
								(temp204 scaleX:)
								(temp204 scaleY:)
								(if
									(or
										(== (temp204 -super-:) Actor)
										(== (temp204 -super-:) Ego)
									)
									(temp204 illegalBits:)
								else
									-1
								)
							)
							(if (not (temp204 scaleSignal:))
								(Print
									addIcon:
										(temp204 view:)
										(temp204 loop:)
										(temp204 cel:)
										0
										0
									font: gSmallFont
									addText:
										@temp0
										(CelWide
											(temp204 view:)
											(temp204 loop:)
											(temp204 cel:)
										)
										0
									init:
								)
							else
								(Print font: gSmallFont addText: @temp0 0 0 init:)
							)
						)
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
						(DialogEditor doit:)
					)
					(KEY_ALT_f
						(= temp209 0)
						(= temp209 (GetNumber {Flag #:}))
						(if (IsFlag temp209)
							(Prints {cleared})
							(ClearFlag temp209)
						else
							(Prints {set})
							(SetFlag temp209)
						)
					)
					(KEY_ALT_g
						(= temp0 0)
						(GetInput @temp0 5 {Variable No.})
						(if (not (= temp203 (ReadNumber @temp0)))
							(return)
						)
						(= temp0 0)
						(GetInput @temp0 5 {Value})
						(= [gEgo temp203] (ReadNumber @temp0))
						(= temp0 0)
					)
					(KEY_ALT_i
						(repeat
							(if
								(==
									(= temp203
										(Print
											font: gSmallFont
											addText: {Enter Inv#:} 0 0
											addEdit: @temp0 5 80
											addButton: 100 {Outta here!} 0 17
											init:
										)
									)
									100
								)
								(break)
							)
							(if temp0
								(= temp203 (ReadNumber @temp0))
								(gEgo get: temp203)
								(= temp0 0)
							)
							(if (== temp203 20)
								(= global157 (GetTime 1)) ; SysTime12
							)
						)
					)
					(KEY_ALT_k
						(= temp200 (GetPort))
						(SetPort 0)
						(= temp216 5)
						(= temp217 16)
						(= temp212 15)
						(= temp213 80)
						(= temp215 (+ temp212 (* 34 temp216)))
						(= temp214 (+ temp213 (* 10 temp217)))
						(= temp210 (Graph grSAVE_BOX temp212 temp213 temp215 temp214 1))
						(Graph grFILL_BOX temp212 temp213 temp215 temp214 1 255)
						(for ((= temp211 0)) (< temp211 256) ((++ temp211))
							(Graph
								grFILL_BOX
								(+ temp212 temp216 (* temp216 (/ temp211 8)))
								(+ temp213 temp217 (* 16 (mod temp211 8)))
								(+
									temp212
									temp216
									temp216
									(* temp216 (/ temp211 8))
								)
								(+
									temp213
									temp217
									temp217
									(* temp217 (mod temp211 8))
								)
								1
								temp211
							)
						)
						(Graph grUPDATE_BOX temp212 temp213 temp215 temp214 1)
						(repeat
							(= temp201 (Event new:))
							(if
								(or
									(== (temp201 type:) evMOUSEBUTTON)
									(== (temp201 type:) evKEYBOARD)
								)
								(break)
							)
							(temp201 dispose:)
						)
						(temp201 dispose:)
						(Graph grRESTORE_BOX temp210)
						(Graph grUPDATE_BOX temp212 temp213 temp215 temp214 1)
						(SetPort temp200)
					)
					(KEY_ALT_m
						(gGame showMem:)
					)
					(KEY_ALT_l
						(if (u> (MemoryInfo 1) 1536) ; FreeHeap
							((ScriptID 952) doit:) ; sysLogger
						else
							(Prints {No Memory!!})
						)
					)
					(KEY_ALT_p
						(localproc_1)
						(Show 2)
					)
					(KEY_ALT_q
						(Print
							font: gSmallFont
							addTextF: {Cur X: %d,Y: %d} (event x:) (event y:)
							init:
						)
					)
					(KEY_ALT_r
						(Print
							font: gSmallFont
							addTextF:
								{name: %s\nscript: %s\nhorizon: %d\nvanishingX: %d\nvanishingY: %d\npicAngle: %d\nnorth: %d\nsouth: %d\neast: %d\nwest: %d\nstyle: %d\ncurPic: %d }
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
							window: SysWindow
							width: 170
							title: {Current Room}
							init:
						)
					)
					(KEY_ALT_t
						(proc911_1)
					)
					(KEY_ALT_s
						(for
							((= temp203 (gCast first:)))
							temp203
							((= temp203 (gCast next: temp203)))
							
							(= temp204 (NodeValue temp203))
							(if
								(and
									(not (& (temp204 signal:) $0004))
									(not (& (temp204 signal:) $0080))
								)
								(Format
									@temp0
									{Updating cast members\nname: %s\nclass: %s\nview: %d\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npri: %d\nsignal: $%x\nillBits: $%x\n}
									(temp204 name:)
									((temp204 -super-:) name:)
									(temp204 view:)
									(temp204 loop:)
									(temp204 cel:)
									(temp204 x:)
									(temp204 y:)
									(temp204 z:)
									(temp204 heading:)
									(temp204 priority:)
									(temp204 signal:)
									(if
										(or
											(== (temp204 -super-:) Actor)
											(== (temp204 -super-:) Ego)
										)
										(temp204 illegalBits:)
									else
										-1
									)
								)
								(if (not (temp204 scaleSignal:))
									(Print
										addIcon:
											(temp204 view:)
											(temp204 loop:)
											(temp204 cel:)
											0
											0
										font: gSmallFont
										addText:
											@temp0
											(CelWide
												(temp204 view:)
												(temp204 loop:)
												(temp204 cel:)
											)
											0
										window: SysWindow
										init:
									)
								else
									(Print
										font: gSmallFont
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
						(Print
							font: gSmallFont
							addTextF:
								{vanishing x: %d,y: %d}
								(gCurRoom vanishingX:)
								(gCurRoom vanishingY:)
							init:
						)
						(= temp203 (localproc_0 {vanishingX:}))
						(or
							(OneOf temp203 -1 0)
							(gCurRoom vanishingX: temp203)
						)
						(= temp203 (localproc_0 {vanishingY:}))
						(or
							(OneOf temp203 -1 0)
							(gCurRoom vanishingY: temp203)
						)
						(Print
							font: gSmallFont
							addTextF:
								{vanishing x: %d,y: %d}
								(gCurRoom vanishingX:)
								(gCurRoom vanishingY:)
							init:
						)
						(= temp0 0)
					)
					(KEY_ALT_z
						(= gQuit 1)
					)
					(KEY_ALT_h
						(Print
							font: gSmallFont
							addText:
								{ALT-A show Cast\nALT-B Polygon Editor\nALT-C Control map\nALT-D DebugOn toggle\nALT-F Flag set/clr\nALT-G Global set\nALT-I Inv items\nALT-L Log file\nALT-M Memory\nALT-P Priority map\nALT-Q show Cursor Coords\nALT-R Room info\nALT-S Updating cast elements\nALT-T Teleport\nALT-U return User control\nALT-V Visual map\nALT-W feature Writer\nALT-Y Vanishing point adj\nALT-Z QUICK QUIT}
							init:
						)
					)
					(else
						(event claimed: 0)
					)
				)
			)
			(evMOUSEBUTTON
				(cond
					((== (event modifiers:) emCTRL)
						(event claimed: 1)
						(while (!= evMOUSERELEASE ((= temp201 (Event new:)) type:))
							((User alterEgo:)
								posn: (temp201 x:) (- (temp201 y:) 10)
								setMotion: 0
							)
							(Animate (gCast elements:) 0)
							(temp201 dispose:)
						)
						(temp201 dispose:)
					)
					((& (event modifiers:) emALT)
						(event claimed: 1)
						(= temp200
							(Print
								font: 999
								addTextF: {%d/%d} (event x:) (event y:)
								posn:
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
								modeless: 1
								init:
							)
						)
						(while (!= evMOUSERELEASE ((= temp201 (Event new:)) type:))
							(temp201 dispose:)
						)
						(temp201 dispose:)
						(temp200 dispose:)
					)
				)
			)
		)
	)
)

