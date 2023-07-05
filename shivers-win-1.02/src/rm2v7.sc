;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2070)
(include sci.sh)
(use Main)
(use n951)

(public
	rm2v7 0
)

(instance rm2v7 of ShiversRoom
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
		nextRoom 2060
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2060
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2490
	)

	(method (init)
		(self
			createPoly: 41 142 104 89 104 61 116 48 141 48 164 77 165 98 218 143
		)
		(super init: &rest)
	)
)

