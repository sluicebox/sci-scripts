;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26100)
(include sci.sh)
(use Main)

(public
	rm26v100 0
)

(instance rm26v100 of ShiversRoom
	(properties
		picture 26100
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 26130
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 26120
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 26080
	)

	(method (init)
		(self createPoly: 99 42 21 82 21 142 243 144 243 65 176 40)
		(super init: &rest)
	)
)

