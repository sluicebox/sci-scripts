;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 600)
(include sci.sh)
(use Main)
(use ADRoom)
(use Print)
(use Scaler)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm600 0
)

(local
	local0 = 1
	local1 = 1
	local2 = 1
	local3 = 1
	[local4 60]
	[local64 60]
	[local124 60]
	[local184 60]
	[local244 60]
	[local304 60]
	[local364 60]
	[local424 60]
	local484
	local485
	local486
	local487
	local488
	local489
	[local490 36] = [0 3 2 4 1 3 0 4 2 2 4 3 0 4 3 2 4 2 0 3 4 2 1 3 0 3 2 1 4 3 0 1 3 2 4 3]
	local526
	local527
)

(procedure (localproc_0 param1 param2 &tmp [temp0 4] temp4)
	(= temp4 (if param2 11 else 0))
	(switch param1
		(fA
			(TextSize @[temp0 0] @local4 11 0 0)
			(Display @local4 dsCOORD 105 92 dsFONT 11 dsCOLOR temp4)
			(Display @local64 dsCOORD 121 99 dsFONT 11 dsCOLOR temp4)
		)
		(fB
			(TextSize @[temp0 0] @local124 11 0 0)
			(Display @local124 dsCOORD 105 107 dsFONT 11 dsCOLOR temp4)
			(Display @local184 dsCOORD 121 114 dsFONT 11 dsCOLOR temp4)
		)
		(fC
			(TextSize @[temp0 0] @local244 11 0 0)
			(Display @local244 dsCOORD 105 122 dsFONT 11 dsCOLOR temp4)
			(Display @local304 dsCOORD 121 129 dsFONT 11 dsCOLOR temp4)
		)
		(fD
			(TextSize @[temp0 0] @local364 11 0 0)
			(Display @local364 dsCOORD 105 137 dsFONT 11 dsCOLOR temp4)
			(Display @local424 dsCOORD 121 144 dsFONT 11 dsCOLOR temp4)
		)
	)
)

(procedure (localproc_1 &tmp [temp0 40] [temp40 40] temp80 temp81)
	(= local484 (+ 1 (* 3 (- local0 1))))
	(= temp80 92)
	(= temp81 99)
	(for ((= local1 1)) (< local1 5) ((++ local1))
		(= local485 (+ 130 local1))
		(if (Message msgGET local487 local484 local485 1 1 @temp0)
			(Display @temp0 dsCOORD 105 temp80 dsCOLOR 0 dsFONT 11)
		else
			(Printf {Didn't find Answer %d..L1.. :-} local1)
		)
		(if (Message msgGET local487 local484 local485 2 1 @temp40)
			(Display @temp40 dsCOORD 121 temp81 dsCOLOR 0 dsFONT 11)
		else
			(Printf {Didn't find Answer %d..L2.. :-} local1)
		)
		(switch local1
			(1
				(StrCpy @local4 @temp0)
				(StrCpy @local64 @temp40)
			)
			(2
				(StrCpy @local124 @temp0)
				(StrCpy @local184 @temp40)
			)
			(3
				(StrCpy @local244 @temp0)
				(StrCpy @local304 @temp40)
			)
			(4
				(StrCpy @local364 @temp0)
				(StrCpy @local424 @temp40)
			)
		)
		(+= temp80 15)
		(+= temp81 15)
	)
)

(procedure (localproc_2 param1 &tmp [temp0 100])
	(= local484 (+ 2 (* 3 (- local0 1))))
	(= local485 0)
	(if (Message msgGET local487 local484 0 1 1 @temp0)
		(Display @temp0 dsCOORD 105 60 dsCOLOR 0 dsFONT 69)
	else
		(Prints {Didn't find question..L1.. :-})
	)
	(if (Message msgGET local487 local484 local485 2 1 @temp0)
		(Display @temp0 dsCOORD 105 72 dsCOLOR 0 dsFONT 69)
	else
		(Prints {Didn't find question..L2.. :-})
	)
	(localproc_1)
	(++ local0)
	(param1 cue:)
)

(instance rm600 of ADRoom
	(properties
		picture 600
		style 9
		horizon 75
		vanishingY -60
	)

	(method (init)
		(LoadMany rsVIEW 827 822 823 600)
		(SetFlag 2)
		(if (== gAct 0)
			(= gAct 1)
			(Printf {ACT %d questions } gAct)
		)
		(super init: &rest)
		(gGame handsOn:)
		(gTheIconBar disable:)
		(switch gPrevRoomNum
			(345
				(= gPrevRoomNum 330)
			)
			(340
				(= gPrevRoomNum 320)
			)
		)
		(fA init:)
		(fB init:)
		(fC init:)
		(fD init:)
		(whiteOut1 init:)
		(whiteOut2 init:)
		(whiteOut3 init:)
		(whiteOut4 init:)
		(whiteOut5 init:)
		(whiteOut6 init:)
		(therm1 init: stopUpd:)
		(therm2 init: stopUpd:)
		(therm3 init: stopUpd:)
		(ben init: stopUpd:)
		(lj init: stopUpd:)
		(kite init: setCycle: Fwd)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(gDirectionHandler addToFront: self)
		(= local487 (+ gAct 600))
		(gUser canInput: 1 canControl: 1)
		(if (> global214 0)
			(self setScript: sPutUpTherm)
		else
			(self setScript: sDoQuestions)
		)
	)

	(method (newRoom)
		(ClearFlag 2)
		(+= global214 local488)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(gDirectionHandler delete: self)
		(gUser canInput: 0 canControl: 0)
		(super newRoom: &rest)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(= temp1 (event type:))
		(= temp0 (event message:))
		(cond
			(
				(and
					local3
					(or
						(and (== temp1 evMOUSEBUTTON) (not (event modifiers:)))
						(and (== temp1 evKEYBOARD) (== temp0 KEY_RETURN))
					)
				)
				(event claimed: 1)
				(switch local489
					(fA
						(= local2 1)
						(= local489 fA)
					)
					(fB
						(= local2 2)
						(= local489 fB)
					)
					(fC
						(= local2 3)
						(= local489 fC)
					)
					(fD
						(= local2 4)
						(= local489 fD)
					)
				)
				(gCurRoom setScript: replys)
			)
			(
				(and
					(or (== temp0 JOY_UP) (and (== temp1 evKEYBOARD) (== temp0 KEY_SHIFTTAB)))
					(not script)
				)
				(localproc_0 local489 0)
				(if (>= (= temp2 (- (gFeatures indexOf: local489) 1)) 0)
					(gGame setCursor: 999 1 109 (+ 94 (* temp2 15)))
					(= local489 (gFeatures at: temp2))
				else
					(gGame setCursor: 999 1 109 139)
					(= local489 (gFeatures at: (- (gFeatures size:) 1)))
				)
				(localproc_0 local489 1)
				(event claimed: 1)
			)
			(
				(and
					(or (== temp0 JOY_DOWN) (and (== temp1 evKEYBOARD) (== temp0 KEY_TAB)))
					(not script)
				)
				(localproc_0 local489 0)
				(if
					(<
						(= temp2 (+ (gFeatures indexOf: local489) 1))
						(gFeatures size:)
					)
					(gGame setCursor: 999 1 109 (+ 94 (* temp2 15)))
					(= local489 (gFeatures at: temp2))
				else
					(gGame setCursor: 999 1 109 94)
					(= local489 (gFeatures at: 0))
				)
				(localproc_0 local489 1)
				(event claimed: 1)
			)
			((& temp1 $0040) ; direction
				(event claimed: 1)
			)
			(else
				(not (& temp1 $0040)) ; direction
			)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if script
		else
			(= temp0 (gFeatures firstTrue: #onMe gMouseX (- gMouseY 10)))
			(if (and (IsObject temp0) (!= temp0 local489))
				(localproc_0 local489 0)
				(localproc_0 temp0 1)
				(= local489 temp0)
			)
		)
	)
)

(instance replys of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local3 0)
				(= cycles 1)
			)
			(1
				(whiteOut1 hide:)
				(whiteOut2 hide:)
				(whiteOut3 hide:)
				(whiteOut4 hide:)
				(whiteOut5 hide:)
				(whiteOut6 hide:)
				(= local526
					[local490
						(= local527 (+ (* (- gAct 1) 6) (- local0 1)))
					]
				)
				(= local484 (* (- local0 1) 3))
				(= local485 (+ local2 130))
				(if (== local2 local526)
					(++ local488)
				)
				(= cycles 1)
			)
			(2
				(gGame setCursor: 996 1)
				(gMessager say: local484 local485 1 0 self local487)
			)
			(3
				(gGame setCursor: 999 1)
				(if (== local2 local526)
					(if (== local488 5)
						(self setScript: sDoZap)
					else
						(self setScript: sDoHappyAnimation self)
					)
				else
					(self setScript: sDoSadAnimation self)
				)
			)
			(4
				(if (> local0 5)
					(if (== gAct 6)
						(gCurRoom newRoom: 381)
					else
						(++ gAct)
						(gCurRoom newRoom: 601)
					)
				else
					(gCurRoom setScript: sDoQuestions)
				)
			)
		)
	)
)

(instance sPutUpTherm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(therm1 setCycle: CT global214 1 self)
			)
			(1
				(if (> global214 10)
					(therm2 setCycle: CT (- global214 10) 1 self)
				else
					(= cycles 1)
				)
			)
			(2
				(if (> global214 20)
					(therm3 setCycle: CT (- global214 20) 1 self)
				else
					(= cycles 1)
				)
			)
			(3
				(client setScript: sDoQuestions)
			)
		)
	)
)

(instance sDoQuestions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(whiteOut1 show:)
				(whiteOut2 show:)
				(whiteOut3 show:)
				(whiteOut4 show:)
				(whiteOut5 show:)
				(whiteOut6 show:)
				(= ticks 5)
			)
			(1
				(localproc_2 self)
			)
			(2
				(localproc_0 fA 1)
				(= local489 fA)
				(gGame handsOn:)
				(= local3 1)
				(gGame setCursor: 999 1 109 146)
				(self dispose:)
			)
		)
	)
)

(instance sDoZap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(+= gScore 5)
				(sPointsSnd play:)
				((ScriptID 0 9) doit:) ; statusCode
				(gGame handsOff:)
				(= local3 0)
				(= cycles 1)
			)
			(1
				(lightning
					setScale: Scaler 100 205 189 15
					init:
					setPri: 15
					setCycle: Fwd
				)
				(= ticks 3)
			)
			(2
				(sFX number: 3452 play:)
				(Palette palSET_INTENSITY 0 255 (Random 300 500))
				(= ticks 3)
			)
			(3
				(Palette palSET_INTENSITY 0 255 100)
				(= ticks 30)
			)
			(4
				(lightning setCycle: 0 hide:)
				(lj view: 823 loop: 2 setCycle: End self)
				(ben view: 823 loop: 0 setCycle: End self)
			)
			(5 0)
			(6
				(lightning show: setCycle: Fwd)
				(= ticks 3)
			)
			(7
				(sFX number: 3452 play:)
				(Palette palSET_INTENSITY 0 255 (Random 300 500))
				(= ticks 3)
			)
			(8
				(Palette palSET_INTENSITY 0 255 100)
				(= ticks 30)
			)
			(9
				(lightning dispose:)
				(lj view: 823 loop: 2 setCycle: End self)
				(ben view: 823 loop: 0 setCycle: End self)
			)
			(10 0)
			(11
				(lj stopUpd:)
				(ben stopUpd:)
				(= cycles 1)
			)
			(12
				(self setScript: sIncreaseTherm self)
			)
			(13
				(if (== gAct 6)
					(gCurRoom newRoom: 381)
				else
					(++ gAct)
					(gCurRoom newRoom: 601)
				)
			)
		)
	)
)

(instance sIncreaseTherm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((< (therm1 cel:) 10)
						(therm1 cel: (+ (therm1 cel:) 1))
						(therm1 stopUpd:)
					)
					((< (therm2 cel:) 10)
						(therm2 cel: (+ (therm2 cel:) 1))
						(therm2 stopUpd:)
					)
					((< (therm3 cel:) 10)
						(therm3 cel: (+ (therm3 cel:) 1))
						(therm3 stopUpd:)
					)
				)
				(= cycles 1)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sDoSadAnimation of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sFX number: 951 play: self)
			)
			(1
				(= ticks 60)
			)
			(2
				(ben view: 822 loop: 0 cel: 0 setCycle: End self)
				(sFX number: 905 play:)
				(lj view: 822 loop: 1 cel: 0 setCycle: End self)
			)
			(3 0)
			(4
				(= ticks 60)
			)
			(5
				(ben setCycle: Beg self)
			)
			(6
				(lj cel: 0 stopUpd:)
				(ben loop: 2 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance sDoHappyAnimation of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(+= gScore 5)
				(sPointsSnd play:)
				((ScriptID 0 9) doit:) ; statusCode
				(ben view: 827 loop: 0 cel: 0 setCycle: End self)
				(lj view: 827 loop: 1 cel: 0 setCycle: CT 3 1 self)
			)
			(1
				(sFX number: 950 play:)
				0
			)
			(2
				(lj setCycle: CT 11 1 self)
			)
			(3
				(sFX number: 909 loop: -1 play:)
				(lj setCycle: End self)
			)
			(4
				(ben setCycle: Beg self)
			)
			(5
				(lj setCycle: CT 11 -1 self)
			)
			(6
				(lj setCycle: CT 7 -1 self)
			)
			(7
				(sFX number: 950 loop: 1 play:)
				(lj setCycle: CT 0 -1 self)
			)
			(8
				(lj stopUpd:)
				(ben loop: 2 stopUpd:)
				(= cycles 1)
			)
			(9
				(self setScript: sIncreaseTherm self)
			)
			(10
				(self dispose:)
			)
		)
	)
)

(instance therm1 of Prop
	(properties
		x 16
		y 150
		view 824
	)
)

(instance therm2 of Prop
	(properties
		x 16
		y 110
		view 824
	)
)

(instance therm3 of Prop
	(properties
		x 16
		y 70
		view 824
		priority 5
		signal 16
	)
)

(instance lj of Prop
	(properties
		x 61
		y 188
		view 822
		loop 1
		cel 12
	)
)

(instance ben of Prop
	(properties
		x 297
		y 188
		view 822
		cel 12
	)
)

(instance kite of Prop
	(properties
		x 44
		y 160
		view 824
		loop 1
	)
)

(instance zap of Prop ; UNUSED
	(properties
		x 92
		y 135
		view 850
	)
)

(instance lightning of Prop
	(properties
		x 11
		y -4
		view 346
		scaleSignal 1
	)
)

(instance fA of Feature
	(properties
		y 170
		nsTop 92
		nsLeft 101
		nsBottom 106
		nsRight 276
		sightAngle 40
	)
)

(instance fB of Feature
	(properties
		y 170
		nsTop 106
		nsLeft 101
		nsBottom 121
		nsRight 276
	)
)

(instance fC of Feature
	(properties
		y 170
		nsTop 121
		nsLeft 101
		nsBottom 136
		nsRight 276
		sightAngle 40
	)
)

(instance fD of Feature
	(properties
		y 170
		nsTop 136
		nsLeft 101
		nsBottom 154
		nsRight 276
		sightAngle 40
	)
)

(instance whiteOut1 of View
	(properties
		x 101
		y 74
		view 600
	)
)

(instance whiteOut2 of View
	(properties
		x 101
		y 93
		view 600
	)
)

(instance whiteOut3 of View
	(properties
		x 101
		y 112
		view 600
	)
)

(instance whiteOut4 of View
	(properties
		x 101
		y 131
		view 600
	)
)

(instance whiteOut5 of View
	(properties
		x 101
		y 144
		view 600
	)
)

(instance whiteOut6 of View
	(properties
		x 109
		y 152
		view 600
		loop 1
	)
)

(instance sFX of Sound
	(properties
		flags 1
	)
)

(instance sPointsSnd of Sound
	(properties
		flags 1
		number 938
	)
)

