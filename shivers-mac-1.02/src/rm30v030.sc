;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30030)
(include sci.sh)
(use Main)

(public
	rm30v030 0
)

(instance rm30v030 of ShiversRoom
	(properties
		picture 30030
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
		nextRoom 30040
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 30060
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 30010
	)

	(method (init)
		(self
			createPoly:
				149
				49
				104
				49
				104
				120
				97
				131
				156
				131
				164
				131
				150
				119
				150
				49
		)
		(super init: &rest)
	)
)

