;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19070)
(include sci.sh)
(use Main)

(public
	rm19v070 0
)

(instance rm19v070 of ShiversRoom
	(properties
		picture 19070
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
		nextRoom 19060
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 19080
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 19030
	)

	(method (init)
		(self
			createPoly:
				112
				142
				119
				109
				113
				109
				115
				65
				156
				65
				162
				59
				174
				75
				192
				75
				187
				105
				214
				143
		)
		(super init: &rest)
	)
)

