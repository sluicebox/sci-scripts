;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19110)
(include sci.sh)
(use Main)

(public
	rm19v110 0
)

(instance rm19v110 of ShiversRoom
	(properties
		picture 19110
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 19100
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 19120
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 19150
	)

	(method (init)
		(self
			createPoly:
				89
				142
				68
				113
				72
				103
				73
				79
				111
				78
				123
				61
				131
				67
				146
				67
				130
				98
				169
				142
		)
		(super init: &rest)
	)
)

