;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 99)
(include sci.sh)
(use Main)
(use n013)
(use Interface)
(use DButton)
(use DText)
(use Plane)
(use Str)
(use Print)
(use Dialog)
(use PolyEdit)
(use Feature)
(use Ego)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	debugHandler 0
	proc99_1 1
)

(local
	local0
	local1
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

(procedure (proc99_1 &tmp temp0 temp1 temp2 [temp3 2])
	(= temp2 (Str newWith: 10 {}))
	(Print font: gSmallFont addText: {Where to, Gabriel?} addEdit: temp2 5 85 0)
	(= temp1 (Print init:))
	(if (temp2 size:)
		(= temp1 (temp2 asInteger:))
	)
	(temp2 dispose:)
	(= global181 0)
	(cond
		((== temp1 0)
			(return)
		)
		((== temp1 -100)
			(gGame restore:)
			(return)
		)
		((== temp1 999)
			(= temp1 375)
			(= gDay 1)
			(return)
		)
		(else
			(= gDay
				(Print
					addText: {Which day?}
					addButton: 1 {Day 1} 0 12
					addButton: 2 {Day 2} 0 26
					addButton: 3 {Day 3} 0 40
					addButton: 4 {Day 4} 0 54
					addButton: 5 {Day 5} 0 68
					addButton: 6 {Day 6} 0 82
					addButton: 7 {Day 7} 50 12
					addButton: 8 {Day 8} 50 26
					addButton: 9 {Day 9} 50 40
					addButton: 10 {Day 10} 50 54
					addButton: 11 {Day 11} 50 68
					init:
				)
			)
		)
	)
	(switch gDay
		(2
			(gEgo get: 1) ; murderPhoto
			(gEgo get: 2) ; gradPhoto
			(gEgo get: 3) ; tweezers
			(gEgo get: 4) ; magGlass
			(gEgo get: 5) ; giftCert
			(gEgo get: 12) ; ritLetter
			(gEgo get: 15) ; veveCopy
			(gEgo get: 24) ; lakeScale
			(gEgo get: 13) ; clay
			(gEgo get: 6) ; sketchBook
			(gEgo get: 31) ; sLakePatter
			(gEgo get: 34) ; ritPhoto
		)
		(3
			(gEgo get: 1) ; murderPhoto
			(gEgo get: 2) ; gradPhoto
			(gEgo get: 3) ; tweezers
			(gEgo get: 4) ; magGlass
			(gEgo get: 5) ; giftCert
			(gEgo get: 12) ; ritLetter
			(gEgo get: 24) ; lakeScale
			(gEgo get: 13) ; clay
			(gEgo get: 6) ; sketchBook
			(gEgo get: 34) ; ritPhoto
			(gEgo get: 44) ; brick
			(gEgo get: 37) ; snakeSkin
			(gEgo get: 32) ; VoodooCode1
		)
		(4
			(gEgo get: 1) ; murderPhoto
			(gEgo get: 2) ; gradPhoto
			(gEgo get: 3) ; tweezers
			(gEgo get: 4) ; magGlass
			(gEgo get: 24) ; lakeScale
			(gEgo get: 13) ; clay
			(gEgo get: 6) ; sketchBook
			(gEgo get: 34) ; ritPhoto
			(gEgo get: 44) ; brick
			(gEgo get: 37) ; snakeSkin
			(gEgo get: 32) ; VoodooCode1
			(gEgo get: 7) ; phonePage
			(gEgo get: 8) ; wolfPhone
			(gEgo get: 21) ; crocMask
			(gEgo get: 38) ; reconVeve
			(gEgo get: 43) ; fortScale
			(gEgo get: 48) ; disguise
			(gEgo get: 46) ; hair_gel
		)
		(5
			(gEgo get: 1) ; murderPhoto
			(gEgo get: 2) ; gradPhoto
			(gEgo get: 3) ; tweezers
			(gEgo get: 4) ; magGlass
			(gEgo get: 12) ; ritLetter
			(gEgo get: 24) ; lakeScale
			(gEgo get: 13) ; clay
			(gEgo get: 6) ; sketchBook
			(gEgo get: 34) ; ritPhoto
			(gEgo get: 44) ; brick
			(gEgo get: 37) ; snakeSkin
			(gEgo get: 32) ; VoodooCode1
			(gEgo get: 7) ; phonePage
			(gEgo get: 8) ; wolfPhone
			(gEgo get: 21) ; crocMask
			(gEgo get: 38) ; reconVeve
			(gEgo get: 43) ; fortScale
			(gEgo get: 48) ; disguise
			(gEgo get: 46) ; hair_gel
			(gEgo get: 26) ; tatooTrace
			(gEgo get: 41) ; braceRep
			(gEgo get: 9) ; news1810
		)
		(6
			(gEgo get: 1) ; murderPhoto
			(gEgo get: 2) ; gradPhoto
			(gEgo get: 3) ; tweezers
			(gEgo get: 4) ; magGlass
			(gEgo get: 12) ; ritLetter
			(gEgo get: 13) ; clay
			(gEgo get: 6) ; sketchBook
			(gEgo get: 34) ; ritPhoto
			(gEgo get: 44) ; brick
			(gEgo get: 37) ; snakeSkin
			(gEgo get: 32) ; VoodooCode1
			(gEgo get: 7) ; phonePage
			(gEgo get: 8) ; wolfPhone
			(gEgo get: 21) ; crocMask
			(gEgo get: 38) ; reconVeve
			(gEgo get: 43) ; fortScale
			(gEgo get: 48) ; disguise
			(gEgo get: 46) ; hair_gel
			(gEgo get: 26) ; tatooTrace
			(gEgo get: 41) ; braceRep
			(gEgo get: 9) ; news1810
			(gEgo get: 12) ; ritLetter
			(gEgo get: 10) ; guntJournal
			(gEgo get: 45) ; hartNotes
			(gEgo get: 25) ; twoScales
		)
		(7
			(gEgo get: 1) ; murderPhoto
			(gEgo get: 2) ; gradPhoto
			(gEgo get: 3) ; tweezers
			(gEgo get: 4) ; magGlass
			(gEgo get: 12) ; ritLetter
			(gEgo get: 13) ; clay
			(gEgo get: 6) ; sketchBook
			(gEgo get: 34) ; ritPhoto
			(gEgo get: 44) ; brick
			(gEgo get: 37) ; snakeSkin
			(gEgo get: 32) ; VoodooCode1
			(gEgo get: 7) ; phonePage
			(gEgo get: 8) ; wolfPhone
			(gEgo get: 21) ; crocMask
			(gEgo get: 38) ; reconVeve
			(gEgo get: 43) ; fortScale
			(gEgo get: 48) ; disguise
			(gEgo get: 46) ; hair_gel
			(gEgo get: 26) ; tatooTrace
			(gEgo get: 41) ; braceRep
			(gEgo get: 9) ; news1810
			(gEgo get: 12) ; ritLetter
			(gEgo get: 10) ; guntJournal
			(gEgo get: 45) ; hartNotes
			(gEgo get: 25) ; twoScales
			(gEgo get: 18) ; tracker
			(gEgo get: 19) ; signalDev
			(gEgo get: 20) ; signalDev2
		)
	)
	(ClearFlag 10)
	(if (> gDay 1)
		(SetFlag 118)
		(SetFlag 117)
		(SetFlag 119)
		(SetFlag 120)
		(SetFlag 121)
		(SetFlag 53)
		(SetFlag 122)
		(SetFlag 101)
		(SetFlag 63)
		(SetFlag 116)
		(SetFlag 254)
		(SetFlag 98)
		(SetFlag 66)
		(SetFlag 76)
		(SetFlag 123)
		(SetFlag 95)
		(SetFlag 12)
		(SetFlag 61)
		(SetFlag 125)
		(SetFlag 109)
		(SetFlag 126)
		(SetFlag 64)
		(SetFlag 203)
		(SetFlag 202)
		(SetFlag 204)
		(SetFlag 206)
		(SetFlag 207)
		(SetFlag 50)
		(SetFlag 69)
		(SetFlag 77)
		(SetFlag 282)
		(SetFlag 11)
		(SetFlag 110)
		(SetFlag 40)
		(SetFlag 129)
		(SetFlag 128)
		(SetFlag 41)
		(SetFlag 42)
		(SetFlag 108)
		(SetFlag 75)
		(SetFlag 13)
		(SetFlag 2)
		(SetFlag 240)
		(SetFlag 130)
	)
	(if (> gDay 2)
		(SetFlag 24)
		(SetFlag 239)
		(SetFlag 112)
		(SetFlag 230)
		(SetFlag 232)
		(SetFlag 231)
		(SetFlag 243)
		(SetFlag 251)
		(SetFlag 264)
		(SetFlag 107)
		(SetFlag 278)
		(SetFlag 290)
		(SetFlag 43)
		(SetFlag 267)
		(SetFlag 60)
		(SetFlag 205)
		(SetFlag 45)
		(SetFlag 210)
		(SetFlag 208)
		(SetFlag 248)
		(SetFlag 35)
		(SetFlag 72)
		(SetFlag 248)
	)
	(if (> gDay 3)
		(SetFlag 270)
		(SetFlag 240)
		(SetFlag 289)
		(SetFlag 55)
		(SetFlag 14)
		(SetFlag 312)
		(SetFlag 313)
		(SetFlag 315)
		(SetFlag 266)
		(SetFlag 254)
		(SetFlag 233)
		(SetFlag 309)
		(SetFlag 310)
		(SetFlag 223)
		(SetFlag 36)
		(SetFlag 21)
		(SetFlag 46)
		(SetFlag 45)
		(SetFlag 227)
		(SetFlag 225)
		(SetFlag 49)
		(SetFlag 283)
		(SetFlag 284)
		(SetFlag 221)
		(SetFlag 44)
		(SetFlag 67)
		(SetFlag 258)
		(SetFlag 255)
		(SetFlag 256)
		(SetFlag 305)
		(SetFlag 447)
	)
	(if (> gDay 4)
		(SetFlag 314)
		(SetFlag 257)
		(SetFlag 51)
		(SetFlag 74)
		(SetFlag 322)
		(SetFlag 323)
	)
	(if (> gDay 5)
		(SetFlag 224)
		(SetFlag 96)
		(SetFlag 320)
		(SetFlag 319)
		(SetFlag 249)
		(SetFlag 22)
		(SetFlag 31)
		(SetFlag 28)
		(SetFlag 27)
		(SetFlag 106)
		(SetFlag 25)
		(SetFlag 16)
		(SetFlag 73)
		(SetFlag 246)
	)
	(= global163 1)
	(SetCursor 0 0 319 155)
	(gCurRoom newRoom: temp1)
)

(instance debugHandler of Feature
	(properties
		y -1
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 [temp6 4] temp10 [temp11 2] temp13 temp14 temp15 temp16 temp17 temp18)
		(= gSysLogPath (Str new: 1000))
		(= temp0 (Str new:))
		(SetCursor -2)
		(switch (event type:)
			(evKEYBOARD
				(event claimed: 1)
				(switch (event message:)
					(KEY_ALT_a
						(for
							((= temp4 (gCast first:)))
							temp4
							((= temp4 (gCast next: temp4)))
							
							(= temp5 (NodeValue temp4))
							(temp0
								format:
									{name: %s\nclass: %s\nview: %d\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npri: %d\nsignal: $%x\nscaleSignal: $%x\nscaleX: %d\nscaleY: %d\nillBits: $%x\n}
									(temp5 name:)
									((temp5 -super-:) name:)
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
									(if
										(or
											(== (temp5 -super-:) Actor)
											(== (temp5 -super-:) Ego)
										)
										(temp5 illegalBits:)
									else
										-1
									)
							)
							(if (not (temp5 scaleSignal:))
								(Print
									addIcon:
										(temp5 view:)
										(temp5 loop:)
										(temp5 cel:)
										0
										0
									font: gSmallFont
									addText:
										temp0
										(CelWide
											(temp5 view:)
											(temp5 loop:)
											(temp5 cel:)
										)
										0
									init:
								)
							else
								(Print font: gSmallFont addText: temp0 0 0 init:)
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
						(repeat
							(= event (Event new:))
							(if (or (== (event type:) evMOUSEBUTTON) (== (event type:) evKEYBOARD))
								(break)
							)
							(event dispose:)
						)
						(event dispose:)
					)
					(KEY_ALT_d
						(if (= gDebugOn (not gDebugOn))
							(Prints {On})
						else
							(Prints {Off})
						)
					)
					(KEY_ALT_f
						(= temp10 0)
						(= temp10 (GetNumber {Flag #:}))
						(if (IsFlag temp10)
							(Prints {cleared})
							(ClearFlag temp10)
						else
							(Prints {set})
							(SetFlag temp10)
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
					(KEY_ALT_i
						(gEgo get: (GetNumber temp0))
					)
					(KEY_ALT_k
						(= temp17 5)
						(= temp18 16)
						(= temp13 15)
						(= temp14 80)
						(= temp16 (+ temp13 (* 34 temp17)))
						(= temp15 (+ temp14 (* 10 temp18)))
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
					(KEY_ALT_p)
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
					(KEY_ALT_t
						(proc99_1)
					)
					(KEY_ALT_s
						(for
							((= temp4 (gCast first:)))
							temp4
							((= temp4 (gCast next: temp4)))
							
							(= temp5 (NodeValue temp4))
							(temp0
								format:
									{Updating cast members\nname: %s\nclass: %s\nview: %d\nloop: %d\ncel: %d\nposn: %d %d %d\nheading: %d\npri: %d\nsignal: $%x\nillBits: $%x\n}
									(temp5 name:)
									((temp5 -super-:) name:)
									(temp5 view:)
									(temp5 loop:)
									(temp5 cel:)
									(temp5 x:)
									(temp5 y:)
									(temp5 z:)
									(temp5 heading:)
									(temp5 priority:)
									(temp5 signal:)
									(if
										(or
											(== (temp5 -super-:) Actor)
											(== (temp5 -super-:) Ego)
										)
										(temp5 illegalBits:)
									else
										-1
									)
							)
							(if (not (temp5 scaleSignal:))
								(Print
									addIcon:
										(temp5 view:)
										(temp5 loop:)
										(temp5 cel:)
										0
										0
									font: gSmallFont
									addText:
										temp0
										(CelWide
											(temp5 view:)
											(temp5 loop:)
											(temp5 cel:)
										)
										0
									init:
								)
							else
								(Print font: gSmallFont addText: temp0 0 0 init:)
							)
						)
					)
					(KEY_ALT_u
						(gGame handsOn:)
					)
					(KEY_ALT_v)
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
								{ALT-A show Cast\nALT-B Polygon Editor\nALT-C Control map\nALT-D DebugOn toggle\nALT-F Flag set/clr\nALT-G Global set\nALT-I Inv items\nALT-L Log file\nALT-M Memory\nALT-P Priority map\nALT-Q show Cursor Coords\nALT-R Room info\nALT-S Updating cast elements\nALT-T Teleport\nALT-U return User control\nALT-V Visual map\nALT-W feature Writer\nALT-Y Vanishing point adj\nALT-Z position ego at cursor}
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

	(method (dispose)
		(gSysLogPath dispose:)
		(if (!= gCurRoomNum 375) ; titleRoom
			(SetCursor 0 0 319 153)
		)
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

(instance ourPlane of Plane
	(properties)
)

