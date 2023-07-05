;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3060)
(include sci.sh)
(use Main)

(public
	rm3v060 0
)

(instance rm3v060 of ShiversRoom
	(properties
		picture 3060
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 3070
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3050
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 3140
	)

	(method (init)
		(self createPoly: 74 141 74 47 85 43 206 48 205 134 153 145)
		(super init: &rest)
	)
)

