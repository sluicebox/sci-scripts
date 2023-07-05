;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2380)
(include sci.sh)
(use Main)
(use n951)

(public
	rm02v38 0
)

(instance rm02v38 of ShiversRoom
	(properties
		picture 2090
	)

	(method (init)
		(if (not (IsFlag 2))
			(self picture: 2081)
		)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nsRight 40
		nextRoom 2390
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2530
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2360
	)

	(method (init)
		(if (not (IsFlag 2))
			(= nextRoom 2650)
		)
		(self
			createPoly: 48 142 118 77 118 65 128 52 145 52 149 62 149 77 226 142
		)
		(super init: &rest)
	)
)

