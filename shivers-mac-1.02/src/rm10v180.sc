;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10180)
(include sci.sh)
(use Main)

(public
	rm10v180 0
)

(instance rm10v180 of ShiversRoom
	(properties
		picture 10180
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10410
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10170
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10200
	)

	(method (init)
		(self createPoly: 173 101 39 118 41 38 243 19 243 90)
		(super init: &rest)
	)
)

