;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29100)
(include sci.sh)
(use Main)
(use n951)

(public
	rm29v100 0
)

(instance rm29v100 of ShiversRoom
	(properties
		picture 29100
	)

	(method (init)
		(if (IsFlag 61)
			(self picture: 29101)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 29090
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 29070
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 21080
	)

	(method (init)
		(self createPoly: 191 118 191 42 88 42 88 118 191 118)
		(super init: &rest)
	)
)

