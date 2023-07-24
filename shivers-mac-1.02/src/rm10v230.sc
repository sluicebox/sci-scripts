;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10230)
(include sci.sh)
(use Main)

(public
	rm10v230 0
)

(instance rm10v230 of ShiversRoom
	(properties
		picture 10230
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10360
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10360
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10240
	)

	(method (init)
		(self
			createPoly: 93 22 162 24 210 33 243 49 243 143 21 143 21 35 39 31 62 26
		)
		(super init: &rest)
	)
)

