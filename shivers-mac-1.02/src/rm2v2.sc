;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2020)
(include sci.sh)
(use Main)
(use n951)
(use n2001)

(public
	rm2v2 0
)

(instance rm2v2 of ShiversRoom
	(properties
		picture 2020
	)

	(method (init)
		(if (not (IsFlag 2))
			(self picture: 2022)
			(proc2001_1)
		)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 2030
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2030
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2000
	)

	(method (init)
		(self
			createPoly: 42 143 93 89 112 89 112 55 118 47 125 44 132 44 137 48 144 57 144 88 163 88 212 142
		)
		(super init: &rest)
	)
)

