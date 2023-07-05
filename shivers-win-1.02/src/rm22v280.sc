;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22280)
(include sci.sh)
(use Main)
(use n951)

(public
	rm22v280 0
)

(instance rm22v280 of ShiversRoom
	(properties
		picture 22280
	)

	(method (init)
		(efDrummer init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(efExitForward init: 3)
		(if (IsFlag 22)
			(self picture: 22281)
		)
		(super init: &rest)
	)
)

(instance efDrummer of ExitFeature
	(properties
		nextRoom 22180
	)

	(method (init)
		(self createPoly: 0 129 20 129 57 122 59 97 54 86 44 83 20 83 0 83)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 22170
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 22150
	)

	(method (init)
		(self createPoly: 0 0 20 0 20 83 0 83 0 129 20 129 20 143 0 143)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 22250
	)

	(method (init)
		(self createPoly: 95 55 166 55 166 111 200 143 64 143 94 112)
		(super init: &rest)
	)
)

