;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2720)
(include sci.sh)
(use Main)
(use n951)

(public
	rm2v72 0
)

(instance rm2v72 of ShiversRoom
	(properties
		picture 2720
	)

	(method (init)
		(if (not (IsFlag 2))
			(self picture: 2351)
		)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 2710
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2710
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2160
	)

	(method (init)
		(if (not (IsFlag 2))
			(= nextRoom 2140)
		)
		(self createPoly: 67 143 123 72 140 72 198 142)
		(super init: &rest)
	)
)

