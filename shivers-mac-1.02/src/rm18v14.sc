;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18140)
(include sci.sh)
(use Main)
(use n951)

(public
	rm18v14 0
)

(instance rm18v14 of ShiversRoom
	(properties
		picture 18140
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(ClearFlag 43)
		(efExitForward init: 9)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 18130
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 18130
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 18170
	)

	(method (init)
		(self createPoly: 51 143 68 128 68 43 189 43 189 120 214 142)
		(super init: &rest)
	)
)

