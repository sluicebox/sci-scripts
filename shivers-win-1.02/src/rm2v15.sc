;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2150)
(include sci.sh)
(use Main)
(use n951)

(public
	rm2v15 0
)

(instance rm2v15 of ShiversRoom
	(properties
		picture 2150
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
		nextRoom 2140
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2140
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2460
	)

	(method (init)
		(if (not (IsFlag 2))
			(= nextRoom 2710)
		)
		(self createPoly: 64 142 123 71 131 63 139 70 197 142)
		(super init: &rest)
	)
)

