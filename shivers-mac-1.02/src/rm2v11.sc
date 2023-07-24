;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2110)
(include sci.sh)
(use Main)
(use n951)

(public
	rm2v11 0
)

(instance rm2v11 of ShiversRoom
	(properties
		picture 2070
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
		nextRoom 2100
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2100
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2510
	)

	(method (init)
		(self
			createPoly: 41 143 101 92 103 59 115 47 143 47 172 79 172 104 216 143
		)
		(super init: &rest)
	)
)

