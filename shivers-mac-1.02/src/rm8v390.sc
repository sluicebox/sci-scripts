;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8390)
(include sci.sh)
(use Main)
(use n951)

(public
	rm8v390 0
)

(instance rm8v390 of ShiversRoom
	(properties)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if (IsFlag 34)
			(= picture 8400)
		else
			(= picture 8390)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8380
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8410
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 8330
	)

	(method (init)
		(self createPoly: 75 143 89 120 87 67 187 67 187 142)
		(super init: &rest)
	)
)

