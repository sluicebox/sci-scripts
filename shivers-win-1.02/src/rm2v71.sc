;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2710)
(include sci.sh)
(use Main)
(use n951)

(public
	rm2v71 0
)

(instance rm2v71 of ShiversRoom
	(properties
		picture 2060
	)

	(method (init)
		(if (not (IsFlag 2))
			(self picture: 2071)
		)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 2720
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2720
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2440
	)

	(method (init)
		(if (not (IsFlag 2))
			(= nextRoom 2540)
		)
		(self
			createPoly: 49 144 108 78 108 60 120 49 141 49 154 59 154 80 212 142
		)
		(super init: &rest)
	)
)

