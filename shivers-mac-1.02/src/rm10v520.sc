;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10520)
(include sci.sh)
(use Main)

(public
	rm10v520 0
)

(instance rm10v520 of ShiversRoom
	(properties
		picture 10520
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
		nextRoom 10530
	)

	(method (init)
		(self createPoly: 0 0 40 0 40 144 0 144 0 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10540
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10550
	)

	(method (init)
		(self
			createPoly: 90 128 77 115 65 92 70 54 84 41 107 29 160 28 190 47 200 64 200 78 199 93 196 109 183 118 176 125
		)
		(super init: &rest)
	)
)

