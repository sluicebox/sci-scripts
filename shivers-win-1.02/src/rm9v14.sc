;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9140)
(include sci.sh)
(use Main)
(use n951)

(public
	rm9v14 0
)

(instance rm9v14 of ShiversRoom
	(properties
		picture 9140
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)

	(method (newRoom)
		(proc951_1 2)
		(super newRoom: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9130
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9150
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9180
	)

	(method (init)
		(self createPoly: 62 143 79 73 79 40 192 40 192 77 227 140)
		(super init: &rest)
	)
)

