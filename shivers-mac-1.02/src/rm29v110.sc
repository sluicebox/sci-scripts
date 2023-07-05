;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29110)
(include sci.sh)
(use Main)

(public
	rm29v110 0
)

(instance rm29v110 of ShiversRoom
	(properties
		picture 29110
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 29180
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 29120
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 29280
	)

	(method (init)
		(self
			createPoly:
				58
				137
				62
				73
				68
				62
				79
				54
				93
				54
				102
				64
				108
				81
				112
				138
				58
				137
		)
		(super init: &rest)
	)
)

