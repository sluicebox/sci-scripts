;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2500)
(include sci.sh)
(use Main)
(use ExitFeature)

(public
	rm2500 0
)

(instance rm2500 of ScaryRoom
	(properties
		picture 2500
	)

	(method (init)
		(if (== gChapter 5)
			(= picture 2501)
		)
		(super init:)
		(southExit init: 3)
		(westExit init: 4)
		(gGame handsOn:)
		(gUser canControl: 0)
	)
)

(instance southExit of ExitFeature
	(properties
		x 159
		y 133
		nextRoom 2200
	)
)

(instance westExit of ExitFeature
	(properties
		x 22
		y 67
		nextRoom 2200
	)
)

