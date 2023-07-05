;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8500)
(include sci.sh)
(use Main)
(use n951)

(public
	rm8v500 0
)

(instance rm8v500 of ShiversRoom
	(properties)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if (IsFlag 34)
			(= picture 8500)
		else
			(= picture 8510)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8550
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8520
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 8410
	)

	(method (init)
		(self createPoly: 21 143 21 0 171 0 171 96 209 143 21 143)
		(super init: &rest)
	)
)

