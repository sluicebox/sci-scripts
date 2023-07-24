;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20530)
(include sci.sh)
(use Main)

(public
	rm20v530 0
)

(instance rm20v530 of ShiversRoom
	(properties
		picture 20530
	)

	(method (init)
		(efForwardLeft init: 3)
		(efForwardRight init: 3)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 20570
	)

	(method (init)
		(self
			createPoly: 116 132 112 109 104 95 101 58 93 44 109 15 156 14 177 42 167 57 164 98 151 131
		)
		(super init: &rest)
	)
)

(instance efForwardLeft of ExitFeature
	(properties
		nextRoom 20920
	)

	(method (init)
		(self
			createPoly: 51 77 68 77 61 105 66 115 43 116 42 113 54 107 54 87 46 87 51 78
		)
		(super init: &rest)
	)
)

(instance efForwardRight of ExitFeature
	(properties
		nextRoom 20760
	)

	(method (init)
		(self createPoly: 209 134 184 100 177 68 179 42 243 55 242 137)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20500
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20585
	)
)

