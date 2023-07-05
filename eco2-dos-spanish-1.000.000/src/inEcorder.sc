;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50)
(include sci.sh)
(use Main)
(use Print)
(use Inset)
(use IconBar)
(use Polygon)
(use Feature)
(use Flags)
(use Sound)
(use Motion)
(use File)
(use User)
(use Actor)
(use System)

(public
	inEcorder 0
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
	local10
	local11
	local12
	local13
	local14
	local15
	[local16 100]
	local116
	local117
	local118
	local119
	local120
	local121
	local122
	local123
	local124
	local125
	local126
	local127
	local128
	local129
)

(procedure (localproc_0)
	(box hide:)
	(DrawCel 9 1 0 115 29 2)
	(Message msgGET 50 15 0 0 2 @local16) ; "Item not recorded."
	(Display @local16 dsWIDTH 100 dsFONT 9777 dsCOORD 116 (proc0_13 60 60 54 60 60) dsCOLOR 8)
	(= local6 1)
)

(procedure (localproc_1 &tmp temp0 temp1 temp2 temp3)
	(= temp0 47)
	(= temp1 117)
	(= temp2 59)
	(= temp3 213)
	(Graph grDRAW_LINE temp0 temp1 temp0 213 14 2 -1)
	(Graph grDRAW_LINE temp0 temp3 temp2 temp3 14 2 -1)
	(Graph grDRAW_LINE temp2 temp3 temp2 temp1 14 2 -1)
	(Graph grDRAW_LINE temp2 temp1 temp0 temp1 14 2 -1)
	(Graph grUPDATE_BOX (- temp0 1) (- temp1 1) (+ temp2 1) (+ temp3 1) 1)
)

(procedure (localproc_2 param1 param2 param3 param4 param5 param6)
	(Message msgGET 50 13 0 param5 param6 @local16)
	(Display @local16 dsFONT 9777 dsCOORD param1 param2 dsCOLOR param3 dsWIDTH param4)
)

(procedure (localproc_3 &tmp temp0 temp1)
	(= local8 1)
	(= temp1 30)
	(for ((= temp0 1)) (< temp0 5) ((++ temp0))
		(localproc_2 116 temp1 8 100 3 temp0)
		(+= temp1 11)
	)
)

(procedure (localproc_4 &tmp temp0 temp1)
	(= local8 2)
	(= temp1 30)
	(for ((= temp0 1)) (< temp0 6) ((++ temp0))
		(localproc_2 116 temp1 8 100 4 temp0)
		(+= temp1 11)
	)
	(= local116 1)
)

(procedure (localproc_5 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(= temp2 local116)
	(= temp5 local116)
	(= temp4 30)
	(= local8 3)
	(+=
		temp2
		(switch local7
			(1 18)
			(3 44)
			(4 55)
			(5 72)
		)
	)
	(for ((= temp3 1)) (< temp3 7) ((++ temp3))
		(if (not (IsEcorderFlag temp2))
			(switch temp3
				(1
					(= local117 1)
				)
				(2
					(= local118 1)
				)
				(3
					(= local119 1)
				)
				(4
					(= local120 1)
				)
				(5
					(= local121 1)
				)
				(6
					(= local122 1)
				)
			)
			(= temp1 22)
		else
			(switch temp3
				(1
					(= local117 0)
				)
				(2
					(= local118 0)
				)
				(3
					(= local119 0)
				)
				(4
					(= local120 0)
				)
				(5
					(= local121 0)
				)
				(6
					(= local122 0)
				)
			)
			(= temp1 8)
		)
		(localproc_2 116 temp4 temp1 100 local9 temp5)
		(++ temp5)
		(++ temp2)
		(+= temp4 11)
	)
	(= local6 0)
)

(procedure (localproc_6 param1)
	(switch local7
		(1
			(= local3 23)
			(= local9 2)
			(= local15 10)
		)
		(2
			(= local3 22)
			(= local9 5)
			(= local15 12)
		)
		(3
			(= local3 24)
			(= local9 6)
			(= local15 13)
		)
		(4
			(= local3 25)
			(= local9 7)
			(= local15 11)
		)
		(5
			(= local9 8)
			(= local3 26)
			(= local15 9)
		)
	)
	(if (not param1)
		(localproc_5)
	)
)

(procedure (localproc_7)
	(return
		(if local6
			0
		else
			(switch (box y:)
				(29
					(= local2 local116)
					(switch local8
						(1
							(inEcorder setScript: enterMyName)
						)
						(2
							(DrawCel 9 1 0 115 29 2)
							(= local7 1)
							(localproc_6 0)
						)
						(else
							(= local2 local116)
							(if (not local117)
								(inEcorder setScript: displayText)
							else
								(localproc_0)
								(= local6 1)
							)
						)
					)
				)
				(40
					(= local2 (+ (= local2 local116) 1))
					(switch local8
						(1
							(DrawCel 9 1 0 115 29 2)
							(localproc_4)
						)
						(2
							(DrawCel 9 1 0 115 29 2)
							(= local7 2)
							(localproc_6 0)
						)
						(else
							(if (not local118)
								(inEcorder setScript: displayText)
							else
								(localproc_0)
							)
						)
					)
				)
				(51
					(= local2 (+ (= local2 local116) 2))
					(switch local8
						(1
							(inEcorder setScript: printFacts)
						)
						(2
							(DrawCel 9 1 0 115 29 2)
							(= local7 3)
							(localproc_6 0)
						)
						(else
							(if (not local119)
								(inEcorder setScript: displayText)
							else
								(localproc_0)
							)
						)
					)
				)
				(62
					(= local2 (+ (= local2 local116) 3))
					(switch local8
						(1
							(inEcorder setScript: testMyself)
						)
						(2
							(DrawCel 9 1 0 115 29 2)
							(= local7 4)
							(localproc_6 0)
						)
						(else
							(if (not local120)
								(inEcorder setScript: displayText)
							else
								(localproc_0)
							)
						)
					)
				)
				(73
					(= local2 (+ (= local2 local116) 4))
					(switch local8
						(2
							(DrawCel 9 1 0 115 29 2)
							(localproc_6 0)
							(= local7 5)
						)
						(else
							(DrawCel 9 1 0 115 29 2)
							(if (not local121)
								(inEcorder setScript: displayText)
							else
								(localproc_0)
							)
						)
					)
				)
				(84
					(= local2 (+ (= local2 local116) 5))
					(if (not local122)
						(inEcorder setScript: displayText)
					else
						(localproc_0)
					)
				)
			)
		)
	)
)

(procedure (localproc_8)
	(= local5 local2)
	(cond
		((<= local2 9)
			(= local4 0)
		)
		((<= local2 19)
			(-= local5 10)
			(= local4 1)
		)
		(else
			(-= local5 20)
			(= local4 2)
		)
	)
	(pictureSquare
		view: local3
		setLoop: local4
		setCel: local5
		setPri: 3
		x:
			(if argc
				148
			else
				(proc0_13 116 116 116 116 118)
			)
		init:
	)
)

(instance saveIcon of Code
	(properties)

	(method (doit param1)
		(if (and (param1 isKindOf: IconI) (& (param1 signal:) $0004))
			(|= local129 (>> $8000 (gTheIconBar indexOf: param1)))
		)
	)
)

(instance restoreIcon of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(if
			(and
				(param1 isKindOf: IconI)
				(& local129 (>> $8000 (= temp0 (gTheIconBar indexOf: param1))))
			)
			(gTheIconBar disable: temp0)
		)
	)
)

(class inEcorder of Inset
	(properties
		picture 50
		modNum 50
		noun 13
		oldDoits 0
	)

	(method (init)
		(if (FileIO fiEXISTS {abc123})
			(SetEcorderFlag 1)
			(SetEcorderFlag 2)
			(SetEcorderFlag 3)
			(SetEcorderFlag 6)
			(SetEcorderFlag 4)
			(SetEcorderFlag 5)
			(SetEcorderFlag 11)
			(SetEcorderFlag 7)
			(SetEcorderFlag 8)
			(SetEcorderFlag 9)
			(SetEcorderFlag 10)
			(SetEcorderFlag 12)
			(SetEcorderFlag 13)
			(SetEcorderFlag 14)
			(SetEcorderFlag 15)
			(SetEcorderFlag 16)
			(SetEcorderFlag 17)
			(SetEcorderFlag 18)
			(SetEcorderFlag 19)
			(SetEcorderFlag 20)
			(SetEcorderFlag 21)
			(SetEcorderFlag 43)
			(SetEcorderFlag 22)
			(SetEcorderFlag 23)
			(SetEcorderFlag 24)
			(SetEcorderFlag 25)
			(SetEcorderFlag 26)
			(SetEcorderFlag 27)
			(SetEcorderFlag 28)
			(SetEcorderFlag 29)
			(SetEcorderFlag 30)
			(SetEcorderFlag 31)
			(SetEcorderFlag 32)
			(SetEcorderFlag 33)
			(SetEcorderFlag 34)
			(SetEcorderFlag 35)
			(SetEcorderFlag 36)
			(SetEcorderFlag 37)
			(SetEcorderFlag 38)
			(SetEcorderFlag 39)
			(SetEcorderFlag 40)
			(SetEcorderFlag 41)
			(SetEcorderFlag 42)
			(SetEcorderFlag 44)
			(SetEcorderFlag 46)
			(SetEcorderFlag 45)
			(SetEcorderFlag 47)
			(SetEcorderFlag 48)
			(SetEcorderFlag 49)
			(SetEcorderFlag 50)
			(SetEcorderFlag 51)
			(SetEcorderFlag 52)
			(SetEcorderFlag 53)
			(SetEcorderFlag 54)
			(SetEcorderFlag 55)
			(SetEcorderFlag 64)
			(SetEcorderFlag 56)
			(SetEcorderFlag 57)
			(SetEcorderFlag 67)
			(SetEcorderFlag 58)
			(SetEcorderFlag 59)
			(SetEcorderFlag 60)
			(SetEcorderFlag 61)
			(SetEcorderFlag 62)
			(SetEcorderFlag 63)
			(SetEcorderFlag 65)
			(SetEcorderFlag 66)
			(SetEcorderFlag 68)
			(SetEcorderFlag 69)
			(SetEcorderFlag 70)
			(SetEcorderFlag 71)
			(SetEcorderFlag 72)
			(SetEcorderFlag 73)
			(SetEcorderFlag 75)
			(SetEcorderFlag 76)
			(SetEcorderFlag 77)
			(SetEcorderFlag 78)
			(SetEcorderFlag 79)
			(SetEcorderFlag 80)
			(SetEcorderFlag 81)
			(SetEcorderFlag 82)
			(SetEcorderFlag 74)
		)
		(SetFlag 5)
		(SetFlag 7)
		(Load rsVIEW 9)
		(= local129 0)
		(gTheIconBar eachElementDo: #perform saveIcon)
		(if (not (IsFlag 2))
			(Message msgGET 50 13 0 16 1 @global137) ; "Adam"
			(SetFlag 2)
		)
		(= local128 (StrLen @global137))
		(= local11 (Palette palSAVE))
		(super init: &rest)
		(= oldDoits gTheDoits)
		((= gTheDoits (EventHandler new:)) name: {newDoits} add: self)
		(ecorderFlags init:)
		(escButton init:)
		(talkButton init:)
		(questionButton init:)
		(enterButton init:)
		(light init:)
		(upArrow init:)
		(leftArrow init:)
		(downArrow init:)
		(rightArrow init:)
		(powerButton init:)
		(fullRoom init: setOnMeCheck: 1 16384)
		(myEcorder init:)
		(gTheIconBar disable: 0 3 4 5 6 7 8)
		((gTheIconBar at: 2) cursor: 15)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(gDirectionHandler addToFront: self)
		(gTheIconBar select: (gTheIconBar at: 2))
		(proc0_10 2)
		(gUser canInput: 1)
		(gTheDoits add: fullRoom)
		(self doit:)
	)

	(method (refresh &tmp temp0)
		(= temp0 (gCurRoom picture:))
		(DrawPic temp0 oldStyle)
		(Palette palRESTORE local11)
		(DrawPic temp0 oldStyle)
		(if (!= gOverlays -1)
			(DrawPic gOverlays 100 0)
		)
		(if (gCurRoom inset:)
			((gCurRoom inset:) restore:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator y: 160)
				(gMessager say: 13 1 0 1 0 50) ; "The Ecorder will scan the forest and record facts."
			)
			(4 ; Do
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit &tmp temp0)
		(while (not local1)
			(= gGameTime (+ gTickOffset (GetTime)))
			(if gFastCast
				(while gFastCast
					(gFastCast eachElementDo: #doit)
					(if (and ((= temp0 (Event new:)) type:) gFastCast)
						(gFastCast firstTrue: #handleEvent temp0)
					)
					(temp0 dispose:)
					(= gGameTime (+ gTickOffset (GetTime)))
					(gSounds eachElementDo: #check)
				)
			)
			(Animate (gCast elements:) 1)
			(if gDoMotionCue
				(= gDoMotionCue 0)
				(gCast eachElementDo: #motionCue)
			)
			(if script
				(script doit:)
			)
			(gUser doit:)
			(return local1)
		)
	)

	(method (dispose)
		(ecorderFlags dispose:)
		(powerOn dispose:)
		(powerOff dispose:)
		(keyPress dispose:)
		(theWords dispose:)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(gDirectionHandler delete: self)
		(gTheDoits delete: self fullRoom)
		(gTheDoits dispose:)
		(= gTheDoits oldDoits)
		(super dispose: &rest)
		(Animate (gCast elements:) 0)
		(= gGameTime (+ gTickOffset (GetTime)))
		(gGame handsOn: 1)
		(gNarrator x: -1 y: -1 color: 57 back: 68 talkWidth: 0 font: gUserFont)
		(gGame handsOn:)
		((gTheIconBar at: 2) cursor: 2)
		(gTheIconBar eachElementDo: #perform restoreIcon)
		(ClearFlag 5)
		(ClearFlag 7)
		(DisposeScript 50)
	)
)

(instance doMyThing of Script
	(properties)

	(method (changeState newState &tmp [temp0 30] [temp30 30])
		(switch (= state newState)
			(0
				(gGame setCursor: gWaitCursor)
				(gUser canInput: 0)
				(= local8 1)
				(= ticks 30)
			)
			(1
				(powerButton setCel: 0)
				(Message msgGET 50 13 0 1 1 @temp0) ; "Welcome to the  Rainforest, %s!"
				(Format @temp30 @temp0 @global137)
				(Display @temp30 dsCOORD 125 50 dsCOLOR 8 dsFONT 9777 dsWIDTH 100)
				(theWords number: 912 loop: 1 play:)
				(= ticks 150)
			)
			(2
				(Display @temp30 dsCOORD 125 50 dsCOLOR 23 dsFONT 9777 dsWIDTH 100)
				(= ticks 10)
			)
			(3
				(localproc_3)
				(gUser canInput: 1)
				(box y: 29 init:)
				(light stopUpd:)
				(gGame setCursor: 15)
				(self dispose:)
			)
		)
	)
)

(instance enterMyName of Script
	(properties)

	(method (handleEvent event &tmp temp0 temp1 [temp2 24])
		(= temp0 (= temp1 evNULL))
		(= temp0 (event message:))
		(if (== (= temp1 (event type:)) evMOUSEBUTTON)
			(= temp0 JOY_NULL)
		)
		(if (and (== state 1) (or (& temp1 evMOUSEBUTTON) (& temp1 evKEYBOARD)))
			(event claimed: 1)
			(cond
				(
					(or
						(<= KEY_a temp0 KEY_z)
						(<= KEY_A temp0 KEY_Z)
						(<= KEY_0 temp0 KEY_9)
						(== temp0 KEY_SUBTRACT)
						(OneOf temp0 KEY_SPACE JOY_UPLEFT)
					)
					(TextSize @[temp2 0] @global137 1207 0)
					(cond
						((== temp0 JOY_UPLEFT)
							(if local128
								(StrAt @global137 (-- local128) 0)
								(DrawCel 9 9 0 115 50 2)
								(Display @global137 dsFONT 1207 dsCOORD 120 50 dsCOLOR 8)
								(localproc_1)
							)
						)
						((> local128 25) 0)
						((<= [temp2 3] 85)
							(StrAt @global137 local128 temp0)
							(StrAt @global137 (++ local128) 0)
							(DrawCel 9 9 0 115 50 2)
							(Display @global137 dsFONT 1207 dsCOORD 120 50 dsCOLOR 8)
							(localproc_1)
						)
					)
				)
				((OneOf temp0 KEY_RETURN KEY_ESCAPE)
					(self cue:)
				)
				((and (== temp1 evMOUSEBUTTON) (enterButton onMe: event))
					(enterButton setScript: buttonPush self enterButton)
				)
				((and (== temp1 evMOUSEBUTTON) (escButton onMe: event))
					(escButton setScript: buttonPush self escButton)
				)
				(else
					(event claimed: 0)
				)
			)
		)
	)

	(method (changeState newState &tmp [temp0 5])
		(switch (= state newState)
			(0
				(gGame setCursor: gWaitCursor)
				(gUser canInput: 0)
				(DrawCel 9 1 0 115 29 2)
				(box hide:)
				(Message msgGET 50 13 0 22 1 @temp0) ; "Name?"
				(Display @temp0 dsFONT 9777 dsCOORD 152 37 dsCOLOR 8)
				(Display @global137 dsFONT 1207 dsCOORD 120 50 dsCOLOR 8)
				(localproc_1)
				(= ticks 30)
			)
			(1
				(gGame setCursor: 15)
				(gTheIconBar disable: 1)
				(gUser canInput: 1)
				(gMouseDownHandler addToFront: self)
				(gKeyDownHandler addToFront: self)
			)
			(2
				(DrawCel 9 1 0 115 29 2)
				(gMouseDownHandler delete: self)
				(gKeyDownHandler delete: self)
				(gTheIconBar enable: 1)
				(if (not global137)
					(Message msgGET 50 13 0 16 1 @global137) ; "Adam"
				)
				(localproc_3)
				(box show:)
				(self dispose:)
			)
		)
	)
)

(instance testMyself of Script
	(properties)

	(method (handleEvent event &tmp temp0)
		(= temp0 evNULL)
		(if
			(and
				(== state 3)
				(or (& (= temp0 (event type:)) evMOUSEBUTTON) (& temp0 evKEYBOARD))
			)
			(switch (event message:)
				(KEY_ESCAPE
					(event claimed: 1)
					(gMouseDownHandler delete: self)
					(gKeyDownHandler delete: self)
					(= local123 10)
					(= local126 1)
					(self changeState: 5)
				)
			)
		)
	)

	(method (changeState newState &tmp temp0 temp1 temp2 [temp3 20] [temp23 20])
		(switch (= state newState)
			(0
				(= local8 4)
				(gGame setCursor: gWaitCursor)
				(gUser canInput: 0)
				(DrawCel 9 1 0 115 29 2)
				(box hide:)
				(= ticks 5)
			)
			(1
				(= local7 (Random 1 5))
				(localproc_6 1)
				(switch local7
					(1
						(= local2 (Random 1 26))
						(= local10 (Random 1 26))
					)
					(2
						(= local2 (Random 1 18))
						(= local10 (Random 1 18))
					)
					(3
						(= local2 (Random 1 11))
						(= local10 (Random 1 11))
					)
					(4
						(= local2 (Random 1 17))
						(= local10 (Random 1 17))
					)
					(5
						(= local2 (Random 1 10))
						(= local10 (Random 1 10))
					)
				)
				(= temp1
					(+
						local2
						(switch local7
							(1 0)
							(2 18)
							(3 44)
							(4 55)
							(5 72)
						)
					)
				)
				(= temp2
					(+
						local10
						(switch local7
							(1 0)
							(2 18)
							(3 44)
							(4 55)
							(5 72)
						)
					)
				)
				(if
					(or
						(== local2 local10)
						(ecorderFlags test: temp1)
						(and (== temp1 7) (== temp2 11))
						(and (== temp1 11) (== temp2 7))
						(and (== temp1 75) (== temp2 78))
						(and (== temp1 78) (== temp2 75))
					)
					(if (> (++ local127) 8)
						(for ((= temp0 0)) (<= temp0 82) ((++ temp0))
							(ecorderFlags clear: temp0)
						)
					)
					(= state -1)
				else
					(ecorderFlags set: temp1)
				)
				(self cue:)
			)
			(2
				(localproc_8 1)
				(= ticks 5)
			)
			(3
				(gMouseDownHandler addToFront: self)
				(gKeyDownHandler addToFront: self)
				(gUser canInput: 1)
				(gGame setCursor: 15)
				(DrawCel 9 9 0 116 74 2)
				(DrawCel 9 9 0 116 85 2)
				(Message msgGET 50 13 0 local9 local10 @temp3)
				(Message msgGET 50 13 0 local9 local2 @temp23)
				(Display
					@temp3
					dsFONT
					9777
					dsCOORD
					116
					(if (= local13 (Random 0 1)) 74 else 85)
					dsCOLOR
					8
				)
				(Display @temp23 dsFONT 9777 dsCOORD 116 (if local13 85 else 74) dsCOLOR 8)
				(box y: (if (Random 0 1) 73 else 84) show:)
			)
			(4
				(DrawCel 9 9 0 116 74 2)
				(DrawCel 9 9 0 116 85 2)
				(box hide:)
				(if register
					(Message msgGET 50 13 0 17 1 @temp3) ; "Congratulations!"
					(Message msgGET 50 13 0 17 2 @temp23) ; "That's right!"
					(Display @temp3 dsFONT 9777 dsCOORD 116 74 dsCOLOR 8)
					(Display @temp23 dsFONT 9777 dsCOORD 116 85 dsCOLOR 8)
				else
					(Message msgGET 50 13 0 18 1 @temp3) ; "Sorry, please try again."
					(Message msgGET 50 13 0 18 2 @temp23)
					(Display @temp3 dsFONT 9777 dsCOORD 116 74 dsCOLOR 8)
					(Display @temp23 dsFONT 9777 dsCOORD 116 85 dsCOLOR 8)
					(-= state 3)
				)
			)
			(5
				(pictureSquare dispose:)
				(DrawCel 9 1 0 115 29 2)
				(box y: 62 show:)
				(if (< (++ local123) 10)
					(self changeState: 0)
				else
					(= local123 0)
					(= ticks 5)
				)
			)
			(6
				(if (and (not local126) (not (IsFlag 6)))
					(gGame points: 46)
					(SetFlag 6)
				)
				(localproc_3)
				(= local126 0)
				(gUser canInput: 1)
				(self dispose:)
			)
		)
	)
)

(instance printFacts of Script
	(properties)

	(method (handleEvent event &tmp temp0)
		(= temp0 evNULL)
		(if
			(and
				(not state)
				(or (& (= temp0 (event type:)) evMOUSEBUTTON) (& temp0 evKEYBOARD))
			)
			(switch (event message:)
				(KEY_ESCAPE
					(event claimed: 1)
					(gMouseDownHandler delete: self)
					(gKeyDownHandler delete: self)
					(= local13 1)
					(self changeState: 5)
				)
			)
		)
	)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(switch (= state newState)
			(0
				(DrawCel 9 1 0 115 29 2)
				(= temp2 (Memory memALLOC_CRIT 100))
				(= temp3 (Memory memALLOC_CRIT 80))
				(= temp4 (Memory memALLOC_CRIT 80))
				(Message msgGET 50 14 0 23 1 temp2) ; "In order to print your Fact Sheet, you must have a printer, and it must be turned on."
				(Message msgGET 50 14 0 23 2 temp3) ; "Go ahead and print."
				(Message msgGET 50 14 0 23 3 temp4) ; "Maybe I'd better not."
				(Display temp2 dsCOORD 116 31 dsFONT 9777 dsCOLOR 14 dsWIDTH 100)
				(Display temp3 dsCOORD 116 74 dsFONT 9777 dsCOLOR 19)
				(Display temp4 dsCOORD 116 85 dsFONT 9777 dsCOLOR 19)
				(Memory memFREE temp2)
				(Memory memFREE temp3)
				(Memory memFREE temp4)
				(box y: 84 show:)
				(gMouseDownHandler addToFront: self)
				(gKeyDownHandler addToFront: self)
				(= local8 5)
			)
			(1
				(gGame handsOff:)
				(= local7 1)
				(= local10 26)
				(= local15 10)
				(= local9 2)
				(box hide:)
				(DrawCel 9 1 0 115 29 2)
				(light setScript: displayFlasher)
				(if (= temp1 (Message msgSIZE 50 14 0 0 1)) ; "RAINFOREST FACT SHEET"
					(= temp2 (Memory memALLOC_CRIT temp1))
					(if (Message msgGET 50 14 0 0 1 temp2) ; "RAINFOREST FACT SHEET"
						(prn
							writeString: {\n\n}
							writeString: @global137
							writeString: {\n\r\n}
							writeString: temp2
							writeString: {\n\r\n}
							close:
						)
					)
					(Memory memFREE temp2)
				else
					(Prints {Not a Valid Message})
				)
				(= ticks 5)
			)
			(2
				(if (and local14 (not local124))
					(= local7 2)
					(= local9 5)
					(= local15 12)
					(= local10 18)
				)
				(= local2 1)
				(switch local7
					(1
						(= local14 1)
					)
					(2
						(if (not local124)
							(= local124 1)
						else
							(= local7 3)
							(= local10 11)
							(= local9 6)
							(= local15 13)
						)
					)
					(3
						(= local10 17)
						(= local7 4)
						(= local9 7)
						(= local15 11)
					)
					(4
						(= local10 10)
						(= local7 5)
						(= local9 8)
						(= local15 9)
					)
					(5
						(= local13 1)
						(self changeState: 4)
					)
				)
				(if (not local13)
					(if (= temp1 (Message msgSIZE 50 13 0 4 local7))
						(= temp2 (Memory memALLOC_CRIT temp1))
						(= temp3 (Memory memALLOC_CRIT 100))
						(Message msgGET 50 16 0 0 1 temp3) ; "**************************************************"
						(if (Message msgGET 50 13 0 4 local7 temp2)
							(prn
								writeString: {\n\n}
								writeString: temp3
								writeString: {\r\n}
								writeString: temp2
								writeString: {\r\n}
								writeString: temp3
								writeString: {\n\n\r\n}
								close:
							)
						)
						(Memory memFREE temp2)
						(Memory memFREE temp3)
					else
						(Prints {Not a Valid Message})
					)
					(= ticks 3)
				)
			)
			(3
				(for ((= temp0 0)) (< temp0 local10) ((++ temp0))
					(if (= temp1 (Message msgSIZE 50 13 0 local9 local2))
						(= temp2 (Memory memALLOC_CRIT temp1))
						(if (Message msgGET 50 13 0 local9 local2 temp2)
							(if (not (prn writeString: temp2))
								(= temp0 local10)
								(= local13 1)
								(DrawCel 9 1 0 115 29 2)
								(localproc_2 119 31 8 100 21 1)
								(Memory memFREE temp2)
								(break)
							)
							(prn writeString: {\r\n} close:)
						)
						(Memory memFREE temp2)
					else
						(Prints {Not a Valid Message})
					)
					(if (= temp1 (Message msgSIZE 50 13 0 local15 local2))
						(= temp2 (Memory memALLOC_CRIT temp1))
						(if (Message msgGET 50 13 0 local15 local2 temp2)
							(if (> (StrLen temp2) 80)
								(for
									((= temp5 80))
									(!= (StrAt temp2 temp5) 32)
									((-- temp5))
								)
								(StrAt temp2 temp5 0)
								(+= temp5 1)
								(prn
									writeString: temp2
									writeString: {\r\n}
									writeString: (+ temp2 temp5)
									writeString: {\r\n}
									writeString: {\r\n}
									close:
								)
							else
								(prn
									writeString: temp2
									writeString: {\r\n}
									writeString: {\r\n}
									close:
								)
							)
							(Memory memFREE temp2)
						)
					else
						(Prints {Not a Valid Message})
					)
					(++ local2)
				)
				(= ticks 60)
			)
			(4
				(= ticks 3)
			)
			(5
				(if (not local13)
					(self changeState: 2)
				else
					(light setScript: 0)
					(DrawCel 9 1 0 115 29 2)
					(= local13 0)
					(= local124 0)
					(= local14 0)
					(gGame handsOn:)
					(gTheIconBar disable: 0 3 5 4 6 7 8)
					(gTheIconBar select: (gTheIconBar at: 2))
					(gGame setCursor: 15)
					(localproc_3)
					(box y: 51 show:)
					(self dispose:)
				)
			)
		)
	)
)

(instance displayFlasher of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_2 129 56 14 100 20 1)
				(= ticks 30)
			)
			(1
				(DrawCel 9 1 0 115 29 2)
				(-= state 2)
				(= ticks 6)
			)
		)
	)
)

(instance buttonPush of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gUser canInput: 0)
				(keyPress play:)
				(register setCel: (+ (register cel:) 1))
				(= ticks 10)
			)
			(1
				(register setCel: (- (register cel:) 1))
				(= ticks 2)
			)
			(2
				(gUser canInput: 1)
				(self dispose:)
			)
		)
	)
)

(instance displayText of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(box hide:)
				(DrawCel 9 1 0 115 29 2)
				(= local6 1)
				(= ticks 5)
			)
			(1
				(localproc_6 1)
				(localproc_8)
				(localproc_2
					(proc0_13 115 115 115 115 117)
					(proc0_13 60 60 60 60 62)
					8
					(proc0_13 101 100 100 100 98)
					local15
					local2
				)
				(localproc_2
					(proc0_13 151 151 151 151 160)
					32
					8
					(proc0_13 65 64 64 64 48)
					local9
					local2
				)
				(= ticks 30)
			)
			(2
				(gUser canInput: 1)
				(gGame setCursor: 15)
				(self dispose:)
			)
		)
	)
)

(instance disposeInText of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gUser canInput: 0)
				(pictureSquare dispose:)
				(= ticks 12)
			)
			(1
				(box show:)
				(= local8 3)
				(= local6 0)
				(localproc_6 0)
				(gUser canInput: 1)
			)
		)
	)
)

(instance light of Prop
	(properties
		x 211
		y 7
		noun 4
		modNum 50
		view 9
		loop 7
		signal 1
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 1 4) ; Look, Do
			(gNarrator y: 160)
			(gMessager say: 4 1 0 1 0 50) ; "If this light is off, turn the Ecorder on by pressing the Power Button."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance escButton of Prop
	(properties
		x 85
		y 48
		noun 1
		modNum 50
		view 9
		loop 2
		signal 1
	)

	(method (cue)
		(switch local8
			(2
				(DrawCel 9 1 0 115 29 2)
				(box y: 29)
				(localproc_3)
			)
			(3
				(DrawCel 9 1 0 115 29 2)
				(if local6
					(inEcorder setScript: disposeInText)
				else
					(switch local7
						(1
							(box y: 29)
						)
						(2
							(box y: 40)
						)
						(4
							(box y: 62)
						)
						(3
							(box y: 51)
						)
						(5
							(box y: 73)
						)
					)
					(box show:)
					(= local14 0)
					(localproc_4)
				)
			)
			(4
				(= local123 10)
				(= local126 1)
				(testMyself changeState: 5)
			)
			(5
				(= local13 1)
				(printFacts changeState: 5)
			)
		)
		(super cue:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator y: 160)
				(gMessager say: 1 1 0 1 0 50) ; "The Escape Button returns you to the previous menu."
			)
			(4 ; Do
				(if local12
					(self setScript: buttonPush self self)
				else
					(gNarrator y: 160)
					(gMessager say: 13 0 19 1 0 50) ; "The Ecorder is turned off."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance talkButton of Prop
	(properties
		x 85
		y 73
		noun 2
		modNum 50
		view 9
		loop 2
		cel 2
		signal 1
	)

	(method (cue &tmp temp0)
		(switch local8
			(1
				(= temp0
					(switch (box y:)
						(29 903)
						(40 904)
						(51 905)
						(62 906)
					)
				)
			)
			(2
				(= temp0
					(switch (box y:)
						(29 907)
						(40 908)
						(51 909)
						(62 910)
						(73 911)
					)
				)
			)
			(3
				(= local2 local116)
				(switch (box y:)
					(29
						(localproc_6 1)
					)
					(40
						(+= local2 1)
						(localproc_6 1)
					)
					(51
						(+= local2 2)
						(localproc_6 1)
					)
					(62
						(+= local2 3)
						(localproc_6 1)
					)
					(73
						(+= local2 4)
						(localproc_6 1)
					)
					(84
						(+= local2 5)
						(localproc_6 1)
					)
				)
				(switch local7
					(2
						(= temp0 914)
					)
					(1
						(= temp0 932)
					)
					(3
						(= temp0 958)
					)
					(4
						(= temp0 969)
					)
					(5
						(= temp0 986)
					)
				)
				(+= temp0 local2)
			)
			(4
				(switch local7
					(2
						(= temp0 914)
					)
					(1
						(= temp0 932)
					)
					(3
						(= temp0 958)
					)
					(4
						(= temp0 969)
					)
					(5
						(= temp0 986)
					)
				)
				(+=
					temp0
					(cond
						((== (box y:) 73)
							(if local13 local10 else local2)
						)
						(local13 local2)
						(else local10)
					)
				)
			)
		)
		(theWords number: temp0 loop: 1 play:)
		(super cue:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator y: 160)
				(gMessager say: 2 1 0 1 0 50) ; "The Voice Button pronounces the vocabulary label."
			)
			(4 ; Do
				(if local12
					(if (and (DoSound sndGET_AUDIO_CAPABILITY) (not (theWords handle:)) (!= local8 5))
						(self setScript: buttonPush self self)
					)
				else
					(gNarrator y: 160)
					(gMessager say: 13 0 19 1 self 50) ; "The Ecorder is turned off."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance questionButton of Prop
	(properties
		x 85
		y 100
		noun 3
		modNum 50
		view 9
		loop 2
		cel 4
		signal 1
	)

	(method (cue)
		(gNarrator y: 10)
		(gMessager say: 3 4 0 0 0 50) ; "Click on sections of the Directional Dial to scroll up and down the menu. Use the Enter Button to select your choice."
		(super cue:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator y: 160)
				(gMessager say: 3 1 0 1 0 50) ; "The Question Button explains how to use the device."
			)
			(4 ; Do
				(if local12
					(self setScript: buttonPush self self)
				else
					(gNarrator y: 160)
					(gMessager say: 13 0 19 1 0 50) ; "The Ecorder is turned off."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance enterButton of Prop
	(properties
		x 181
		y 106
		noun 5
		modNum 50
		view 9
		signal 1
	)

	(method (cue)
		(switch local8
			(1
				(switch (box y:)
					(29
						(box y: 29)
						(DrawCel 9 1 0 115 29 2)
						(localproc_4)
					)
					(40
						(inEcorder setScript: enterMyName)
					)
					(51
						(inEcorder setScript: printFacts)
					)
					(62
						(inEcorder setScript: testMyself)
					)
				)
			)
			(2
				(DrawCel 9 1 0 115 29 2)
				(switch (box y:)
					(29
						(if local6
							(= local6 0)
							(localproc_4)
						else
							(box y: 29)
							(= local7 1)
							(localproc_6 0)
						)
					)
					(40
						(box y: 29)
						(= local7 2)
						(localproc_6 0)
					)
					(51
						(box y: 29)
						(= local7 3)
						(localproc_6 0)
					)
					(62
						(box y: 29)
						(DrawCel 9 1 0 115 29 2)
						(= local7 4)
						(localproc_6 0)
					)
					(73
						(box y: 29)
						(= local7 5)
						(localproc_6 0)
					)
				)
			)
			(3
				(DrawCel 9 1 0 115 29 2)
				(if local6
					(inEcorder setScript: disposeInText)
				else
					(localproc_7)
				)
			)
			(4
				(switch (box y:)
					(73
						(testMyself register: (if local13 0 else 1) cue:)
					)
					(84
						(testMyself register: (if local13 1 else 0) cue:)
					)
				)
			)
			(5
				(switch (box y:)
					(73
						(printFacts cue:)
					)
					(84
						(= local13 1)
						(printFacts changeState: 5)
					)
				)
			)
		)
		(super cue:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator y: 160)
				(gMessager say: 5 1 0 1 0 50) ; "The Enter Button takes you to the screen of the selected item."
			)
			(4 ; Do
				(if local12
					(self setScript: buttonPush self self)
				else
					(gNarrator y: 160)
					(gMessager say: 13 0 19 1 0 50) ; "The Ecorder is turned off."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance upArrow of Prop
	(properties
		x 100
		y 129
		noun 6
		modNum 50
		view 9
		loop 4
		signal 1
	)

	(method (cue)
		(if (not local6)
			(if (> local116 1)
				(if (== (box y:) 29)
					(-= local116 1)
				)
				(DrawCel 9 1 0 115 29 2)
				(localproc_6 0)
			)
			(switch (box y:)
				(29
					(box y: 29)
				)
				(40
					(box y: 29)
				)
				(51
					(box y: 40)
				)
				(62
					(box y: 51)
				)
				(73
					(if (OneOf local8 4 5)
						(box y: 73)
					else
						(box y: 62)
					)
				)
				(84
					(box y: 73)
				)
			)
		)
		(super cue:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator y: 170)
				(gMessager say: 6 1 0 1 0 50) ; "Go up an item."
			)
			(4 ; Do
				(if local12
					(self setScript: buttonPush self self)
				else
					(gNarrator y: 170)
					(gMessager say: 7 4 14 1 0 50) ; "You cannot use that button at this time."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftArrow of Prop
	(properties
		x 95
		y 136
		noun 8
		modNum 50
		view 9
		loop 3
		signal 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator y: 170)
				(gMessager say: 8 1 0 1 0 50) ; "Go up an item."
			)
			(4 ; Do
				(if local12
					(self setScript: buttonPush upArrow self)
				else
					(gNarrator y: 170)
					(gMessager say: 7 4 14 1 0 50) ; "You cannot use that button at this time."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance downArrow of Prop
	(properties
		x 101
		y 150
		noun 7
		modNum 50
		view 9
		loop 6
		signal 1
	)

	(method (cue)
		(if (not local6)
			(if (and (== (box y:) 84) (not (OneOf local8 4 5)))
				(DrawCel 9 1 0 115 29 2)
				(switch local7
					(1
						(if (< local116 21)
							(++ local116)
						)
						(localproc_6 0)
					)
					(2
						(if (< local116 13)
							(++ local116)
						)
						(localproc_6 0)
					)
					(3
						(if (< local116 6)
							(++ local116)
						)
						(localproc_6 0)
					)
					(4
						(if (< local116 12)
							(++ local116)
						)
						(localproc_6 0)
					)
					(5
						(if (< local116 5)
							(++ local116)
						)
						(localproc_6 0)
					)
				)
			)
			(switch (box y:)
				(29
					(box y: 40)
				)
				(40
					(box y: 51)
				)
				(51
					(box y: 62)
				)
				(62
					(if (== local8 1)
						(box y: 62)
					else
						(box y: 73)
					)
				)
				(73
					(if (== local8 2)
						(box y: 73)
					else
						(box y: 84)
					)
				)
				(84
					(box y: 84)
				)
			)
		else
			(gMessager say: 7 4 14 1 0 50) ; "You cannot use that button at this time."
		)
		(super cue:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator y: 170)
				(gMessager say: 7 1 0 1 0 50) ; "Go down an item."
			)
			(4 ; Do
				(if local12
					(self setScript: buttonPush self self)
				else
					(gNarrator y: 170)
					(gMessager say: 7 4 14 1 0 50) ; "You cannot use that button at this time."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rightArrow of Prop
	(properties
		x 123
		y 136
		noun 12
		modNum 50
		view 9
		loop 5
		signal 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator y: 170)
				(gMessager say: 12 1 0 1 0 50) ; "Go down an item."
			)
			(4 ; Do
				(if local12
					(self setScript: buttonPush downArrow self)
				else
					(gNarrator y: 170)
					(gMessager say: 7 4 14 1 0 50) ; "You cannot use that button at this time."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance powerButton of Prop
	(properties
		x 107
		y 141
		noun 11
		modNum 50
		view 9
		loop 8
		signal 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator y: 160)
				(gMessager say: 11 1 0 1 0 50) ; "The Power Button turns the device on and off."
			)
			(4 ; Do
				(if (not local12)
					(powerOn play:)
					(DrawCel 9 1 0 115 29 2)
					(= local12 1)
					(powerButton setCel: 1)
					(light setCycle: End)
					(inEcorder setScript: doMyThing)
				else
					(return 1)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pictureSquare of View
	(properties
		x 118
		y 31
		noun 10
		modNum 50
		view 9
		loop 10
		priority 3
		signal 1
	)

	(method (init)
		(= y (proc0_13 30 30 30 30 31))
		(super init: &rest)
	)
)

(instance box of View
	(properties
		x 118
		y 30
		noun 13
		modNum 50
		view 9
		loop 1
		cel 1
		priority 2
		signal 16
	)

	(method (doVerb theVerb)
		(myEcorder doVerb: theVerb)
	)
)

(instance fullRoom of Feature
	(properties
		x 1
		y 1
		noun 13
		modNum 50
		onMeCheck 16384
	)

	(method (doit)
		(super doit: &rest)
		(cond
			((not (User canInput:)) 0)
			((self onMe: gMouseX (- gMouseY 10))
				(if (not local125)
					(gTheCursor loop: 11 cel: 0 init:)
					(= local125 1)
				)
			)
			(local125
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				(= local125 0)
			)
		)
	)

	(method (doVerb theVerb)
		(gGame handsOff:)
		(if (not local0)
			(= local0 -1)
		)
		(= local1 local0)
		(inEcorder dispose: &rest)
	)
)

(instance myEcorder of Feature
	(properties
		x 1
		y 4
		noun 13
		modNum 50
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 240 4 241 130 223 154 243 189 152 189 153 169 100 162 78 130 78 5
					yourself:
				)
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 1 4) ; Look, Do
			(gNarrator y: 160)
			(gMessager say: 13 1 0 1 0 50) ; "The Ecorder will scan the forest and record facts."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance prn of File
	(properties)
)

(instance keyPress of Sound
	(properties
		number 15
	)
)

(instance powerOff of Sound
	(properties
		number 3
	)
)

(instance powerOn of Sound
	(properties
		number 2
	)
)

(instance theWords of Sound
	(properties)
)

(instance ecorderFlags of Flags
	(properties
		size 96
	)
)

