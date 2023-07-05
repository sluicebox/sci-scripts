;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26120)
(include sci.sh)
(use Main)

(public
	rm26v120 0
)

(instance rm26v120 of ShiversRoom
	(properties
		picture 26120
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 26100
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 26130
	)

	(method (init)
		(self createPoly: 200 0 262 0 262 144 200 144 200 0)
		(super init: &rest)
	)
)

