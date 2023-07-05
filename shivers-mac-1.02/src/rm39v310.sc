;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39310)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm39v310 0
)

(instance rm39v310 of ShiversRoom
	(properties
		picture 39310
	)

	(method (init)
		(proc951_16 166)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitUp init: 4)
		(efExitNote init: 0)
		((View new:) view: 39310 setPri: 1 1 init:)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 39130
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 39150
	)
)

(instance efExitUp of ExitFeature
	(properties
		nextRoom 39300
	)

	(method (init)
		(self createPoly: 70 0 74 16 86 26 155 26 170 16 174 0)
		(super init: &rest)
	)
)

(instance efExitNote of ExitFeature
	(properties
		nextRoom 39311
	)

	(method (init)
		(self createPoly: 115 84 127 79 143 83 141 101 132 109 120 102 115 84)
		(super init: &rest)
	)
)

