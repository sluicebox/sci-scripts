;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35140)
(include sci.sh)
(use Main)
(use ExitFeature)
(use Scaler)

(public
	rm35140 0
)

(instance rm35140 of ScaryRoom
	(properties
		picture 35140
	)

	(method (init)
		(super init: &rest)
		(gEgo init: setScaler: Scaler 115 35 129 108 normalize:)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(35150
				(gEgo normalize: 3 posn: 156 126)
				(gCurRoom setScript: (ScriptID 0 5) 0 5) ; takeLastStep
			)
			(else
				(gEgo normalize: 2 posn: 156 126)
				(gCurRoom setScript: (ScriptID 0 5) 0 5) ; takeLastStep
			)
		)
		(gGame handsOn:)
		(northExit init: 1)
		(southExit init: 3)
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
		nsLeft 109
		nsRight 191
		approachX 156
		approachY 156
		nextRoom 35150
	)
)

(instance northExit of ExitFeature
	(properties
		nsLeft 132
		nsTop 27
		nsRight 175
		nsBottom 118
		approachX 156
		approachY 96
		nextRoom 35130
	)
)

