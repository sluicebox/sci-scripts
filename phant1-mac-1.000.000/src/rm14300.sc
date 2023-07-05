;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14300)
(include sci.sh)
(use Main)
(use ExitFeature)
(use Print)
(use System)

(public
	rm14300 0
)

(instance rm14300 of ScaryRoom
	(properties
		picture 14110
	)

	(method (init)
		(southExit init: 3)
		(super init: &rest)
		(gCurRoom setScript: sSitInChair)
	)
)

(instance sSitInChair of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Prints {Adrienne sits in the chair.})
				(= cycles 1)
			)
			(1
				(gGame handsOn:)
				(gUser canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 0
		nsRight 293
		nextRoom 14200
		appYOffset 20
	)
)

