;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26080)
(include sci.sh)
(use Main)

(public
	rm26v080 0
)

(instance rm26v080 of ShiversRoom
	(properties
		picture 26080
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 26090
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 26090
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 26060
	)

	(method (init)
		(self createPoly: 209 27 63 27 21 59 20 144 243 144 243 51)
		(super init: &rest)
	)
)

