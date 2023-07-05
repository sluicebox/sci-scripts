;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22340)
(include sci.sh)
(use Main)

(public
	rm22v340 0
)

(instance rm22v340 of ShiversRoom
	(properties
		picture 22340
	)

	(method (init)
		(efExitPlaque init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 22330
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 22180
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 22810
	)

	(method (init)
		(self createPoly: 121 104 151 104 152 117 120 117 120 104)
		(super init: &rest)
	)
)

