;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35110)
(include sci.sh)
(use Main)
(use ExitFeature)
(use Scaler)

(public
	rm35110 0
)

(instance rm35110 of ScaryRoom
	(properties
		picture 35110
	)

	(method (init)
		((ScriptID 30) init:) ; FidgetCode
		(super init: &rest)
		(gGame handsOff:)
		(gEgo init: setScaler: Scaler 94 45 141 92 normalize:)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(35120
				(gEgo view: 3 posn: 156 125)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(else
				(gEgo view: 2 posn: 165 104)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
		)
		(southExit approachX: (gEgo x:) approachY: 150 init: 3)
		(northExit approachX: (gEgo x:) approachY: 80 init: 4)
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 88
		nsRight 221
		nextRoom 35120
	)
)

(instance northExit of ExitFeature
	(properties
		nsLeft 40
		nsRight 80
		nsBottom 100
		nextRoom 22200
	)

	(method (init)
		(self
			createPoly:
				171
				34
				182
				38
				189
				51
				192
				69
				192
				97
				150
				95
				149
				54
				156
				43
				164
				37
				172
				34
		)
		(super init: &rest)
	)
)

