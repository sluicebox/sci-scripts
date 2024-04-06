;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28600)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Actor)
(use System)

(public
	rm28600 0
)

(instance rm28600 of ScaryRoom
	(properties
		picture 28600
		stepSound 1
	)

	(method (init)
		((ScriptID 30) init:) ; FidgetCode
		(if (== gChapter 5)
			(= picture 28601)
			(gEgo fadePalette: 28100)
		)
		(gEgo init: setScaler: Scaler 104 39 124 96)
		(if (and (>= gChapter 4) (!= gChapter 5) (IsFlag 203))
			(truck init:)
		)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(else
				(gEgo posn: 149 116 normalize: 2)
			)
		)
		(if (and (!= gChapter 5) (not (IsFlag 360)))
			(self setScript: noExitScr)
		else
			(to28110 init: 10)
			(to28700 init: 13)
			(gCurRoom setScript: (ScriptID 0 5) 0 5) ; takeLastStep
			(gGame handsOn:)
		)
		(super init: &rest)
	)
)

(instance noExitScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(SetFlag 360)
					(gGame handsOff:)
					(DoRobot 1610 79 24 gEgo -1 1)
				)
				(1
					(gEgo hide:)
					(gCurRoom newRoom: 28700)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(gCurRoom newRoom: 28700)
		)
	)
)

(instance truck of View
	(properties
		x 147
		y 99
		view 28600
	)
)

(instance to28700 of ExitFeature
	(properties
		nsLeft 107
		nsTop 54
		nsRight 142
		nsBottom 105
		approachX 120
		approachY 97
		x 124
		y 79
		nextRoom 28700
	)
)

(instance to28110 of ExitFeature
	(properties
		nsLeft 144
		nsTop 54
		nsRight 187
		nsBottom 108
		approachX 155
		approachY 94
		x 165
		y 81
		nextRoom 28110
	)
)

