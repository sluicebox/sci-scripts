;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23460)
(include sci.sh)
(use Main)

(public
	rm23v460 0
)

(instance rm23v460 of ShiversRoom
	(properties
		picture 23460
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23450
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23470
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23510
	)

	(method (init)
		(self
			createPoly:
				138
				39
				126
				39
				116
				45
				114
				57
				113
				127
				113
				132
				153
				132
				153
				52
				150
				47
				139
				39
		)
		(super init: &rest)
	)
)

