;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35120)
(include sci.sh)
(use Main)
(use ExitFeature)
(use Scaler)

(public
	rm35120 0
)

(instance rm35120 of ScaryRoom
	(properties
		picture 35120
	)

	(method (init)
		((ScriptID 30) init:) ; FidgetCode
		(northExit init: 1)
		(southExit init: 3)
		(gGame handsOff:)
		(super init: &rest)
		(gEgo init: setScaler: Scaler 100 14 140 82 normalize:)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(35110
				(gEgo view: 2 posn: 205 95)
				(southExit approachX: 205 approachY: 135)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(else
				(gEgo view: 3 posn: 188 125)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 121
		nsRight 237
		approachX 188
		approachY 155
		nextRoom 35130
	)
)

(instance northExit of ExitFeature
	(properties
		nsLeft 182
		nsTop 57
		nsRight 216
		nsBottom 94
		approachX 204
		approachY 74
		nextRoom 35110
	)
)

