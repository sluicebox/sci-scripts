;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16260)
(include sci.sh)
(use Main)

(public
	rm16v260 0
)

(instance rm16v260 of ShiversRoom
	(properties
		picture 16260
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16250
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16250
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16530
	)

	(method (init)
		(self
			createPoly:
				109
				143
				117
				139
				117
				97
				20
				94
				21
				12
				212
				12
				213
				107
				241
				145
		)
		(super init: &rest)
	)
)

