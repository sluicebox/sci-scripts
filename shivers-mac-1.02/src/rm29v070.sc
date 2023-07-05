;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29070)
(include sci.sh)
(use Main)

(public
	rm29v070 0
)

(instance rm29v070 of ShiversRoom
	(properties
		picture 29070
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
		nextRoom 29100
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 29080
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 29110
	)

	(method (init)
		(self
			createPoly:
				129
				115
				131
				72
				137
				62
				146
				61
				156
				63
				159
				70
				163
				114
				129
				115
		)
		(super init: &rest)
	)
)

