;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22050)
(include sci.sh)
(use Main)
(use n951)
(use n22001)

(public
	rm22v050 0
)

(instance rm22v050 of ShiversRoom
	(properties
		picture 22050
	)

	(method (init)
		(efExitDrummer init: 3)
		(efExitForwardR init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(if (IsFlag 22)
			(self picture: 22051)
		)
		(proc22001_0)
		(super init: &rest)
	)
)

(instance efExitDrummer of ExitFeature
	(properties
		nextRoom 22180
	)

	(method (init)
		(self createPoly: 1 79 0 112 48 105 74 105 74 81 20 46)
		(super init: &rest)
	)
)

(instance efExitForwardR of ExitFeature
	(properties
		nextRoom 22280
	)

	(method (init)
		(self createPoly: 114 142 169 142 169 27 115 27 112 27 112 142 115 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 22060
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 22070
	)
)

