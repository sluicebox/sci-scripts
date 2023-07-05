;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28100)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Polygon)
(use Feature)
(use System)

(public
	rm28100 0
)

(instance rm28100 of ScaryRoom
	(properties
		picture 28100
		stepSound 1
	)

	(method (drawPic param1)
		(if (and (ResCheck rsPIC (+ param1 1)) (== gChapter 5))
			(super drawPic: (+ param1 1) &rest)
		else
			(super drawPic: param1 &rest)
		)
	)

	(method (init &tmp temp0 temp1)
		(= temp1 0)
		((ScriptID 30) init:) ; FidgetCode
		(gEgo
			init:
			fadedY: 90
			brightY: 120
			setScaler: Scaler 46 32 116 82
			normalize:
		)
		(if (== gChapter 5)
			(gEgo fadePalette: 28100)
		)
		(frontDoor init: 2)
		(westExit init: 4)
		(southExit init: 3)
		(gateExit init: 1)
		(switch gPrevRoomNum
			(900
				(if (and (== (gEgo x:) 98) (== (gEgo y:) 91))
					(frontDoor approachX: 98 approachY: 150)
				)
				(gGame handsOn:)
			)
			(28300
				(gEgo normalize: 0 posn: 10 110)
				(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(28600
				(gEgo normalize: 6 posn: 67 125)
				(gCurRoom setScript: sToDoor)
			)
			(28700
				(gEgo normalize: 6 posn: 67 125)
				(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(28110
				(gEgo normalize: 6 posn: 127 128)
				(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
				(frontDoor
					approachY: (- (gEgo y:) 30)
					approachX: (+ (gEgo x:) 30)
				)
			)
			(4200
				(= picture 34440)
				(gGame doRemap: 2 253 75)
				(proc1111_6)
				(= stepSound 4)
				(frontDoor approachY: 64)
				(southExit approachX: 123 approachY: 164)
				(westExit approachX: 123 approachY: 164)
				(gateExit approachX: 123 approachY: 164)
				(gCurRoom setScript: sFromDoor)
			)
			(else
				(gGame handsOn:)
				(gEgo normalize: 2 posn: 98 91)
				(frontDoor approachX: 98 approachY: 150)
				(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
		)
		(super init: &rest)
		(cond
			((== gChapter 1)
				(= temp0 904)
			)
			((== gChapter 2)
				(= temp1 915)
				(= temp0 905)
			)
			((== gChapter 3)
				(= temp1 916)
				(= temp0 906)
			)
			((== gChapter 4)
				(= temp1 916)
				(= temp0 906)
			)
			((== gChapter 5)
				(= temp1 917)
				(= temp0 907)
			)
			((== gChapter 6)
				(= temp1 918)
				(= temp0 908)
			)
		)
		(global114 stop: 1)
		(if (== (gGDacSound number:) temp0)
			(if (not (gGDacSound handle:))
				(gGDacSound number: temp0 setLoop: -1 play: setVol: 127)
			else
				(gGDacSound setVol: 127)
			)
		else
			(gGDacSound number: temp0 setLoop: -1 play: setVol: 127)
		)
		(cement init:)
	)
)

(instance sFromDoor of Script
	(properties)

	(method (dispose)
		(gCurRoom drawPic: 28100 picture: 28100)
		(gEgo show: posn: 153 118 normalize: 5)
		(self setScript: (ScriptID 0 5) 0 5) ; takeLastStep
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_7 1571 137 28)
				)
				(1
					(self dispose:)
				)
			)
		else
			(= global115 0)
			(proc1111_6)
			(self dispose:)
		)
	)
)

(instance sToDoor of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(proc1111_8)
					(gCurRoom drawPic: 34440 picture: 34440)
					(proc1111_7 1570 148 29 gEgo 30 1)
				)
				(1
					(gCurRoom newRoom: 4200)
					(self dispose:)
				)
			)
		else
			(= global115 0)
			(proc1111_6)
			(gCurRoom newRoom: 4200)
		)
	)
)

(instance sDrivePan of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= seconds 2)
				)
				(1
					(gEgo hide:)
				)
				(2
					(gEgo show:)
					(if (== gChapter 5)
						(SetFlag 315)
						(gCurRoom drawPic: 28101)
					else
						(SetFlag 314)
						(gCurRoom drawPic: 28100)
					)
					(= seconds 2)
				)
				(3
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(gEgo show:)
					(if (== gChapter 5)
						(SetFlag 315)
						(gCurRoom drawPic: 28101)
					else
						(SetFlag 314)
						(gCurRoom drawPic: 28100)
					)
					(= seconds 2)
				)
				(1
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance frontDoor of ExitFeature
	(properties
		nsLeft 246
		nsTop 55
		nsRight 263
		nsBottom 90
		approachX 249
		approachY 88
		x 254
		y 90
	)

	(method (doVerb theVerb)
		(if (or (== theVerb 21) (== theVerb 4)) ; Exit, Do
			(gGame handsOff:)
			(gGame doRemap: 0)
			(gCurRoom setScript: sToDoor)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance westExit of ExitFeature
	(properties
		approachY 120
		nextRoom 28300
	)
)

(instance southExit of ExitFeature
	(properties
		nsRight 163
		approachX 98
		approachY 179
		nextRoom 28700
	)
)

(instance gateExit of ExitFeature
	(properties
		nsLeft 84
		nsTop 49
		nsRight 120
		nsBottom 79
		approachX 98
		approachY 91
		x 102
		y 79
		nextRoom 28305
	)
)

(instance cement of Feature
	(properties
		nsLeft 181
		nsTop 85
		nsRight 268
		nsBottom 103
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				init: 227 87 268 93 217 109 180 102 185 94
				yourself:
			)
		)
		(super init: &rest)
	)
)

