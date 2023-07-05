;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29120)
(include sci.sh)
(use Main)

(public
	rm29v120 0
)

(instance rm29v120 of ShiversRoom
	(properties
		picture 29120
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitPlaque init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 29110
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 29130
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 29830
	)

	(method (init)
		(self createPoly: 170 117 200 117 202 128 169 128 170 118)
		(super init: &rest)
	)
)

