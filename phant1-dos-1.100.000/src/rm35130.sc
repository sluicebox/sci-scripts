;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35130)
(include sci.sh)
(use Main)
(use ExitFeature)
(use Scaler)

(public
	rm35130 0
)

(instance rm35130 of ScaryRoom
	(properties
		picture 35130
	)

	(method (init)
		((ScriptID 30) init:) ; FidgetCode
		(super init: &rest)
		(gEgo init: setScaler: Scaler 66 31 115 74 normalize:)
		(northExit init: 1)
		(southExit init: 3)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(35120
				(gEgo normalize: 3 posn: 180 125)
				(northExit approachX: 180 approachY: 95)
				(southExit approachX: 180 approachY: 155)
				(gGame setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(else
				(gEgo normalize: 2 posn: 202 86)
				(gGame setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script 0)
			((> (gEgo y:) 130)
				(gCurRoom newRoom: (southExit nextRoom:))
			)
			((northExit onMe: gEgo)
				(gCurRoom newRoom: (northExit nextRoom:))
			)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 116
		nsRight 227
		approachX 202
		approachY 116
		nextRoom 35120
	)
)

(instance northExit of ExitFeature
	(properties
		nsLeft 187
		nsTop 38
		nsRight 215
		nsBottom 83
		approachX 202
		approachY 36
		nextRoom 35140
	)
)

