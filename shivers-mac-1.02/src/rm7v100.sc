;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7100)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm7v100 0
)

(instance rm7v100 of ShiversRoom
	(properties
		picture 7100
	)

	(method (init)
		(efExitRight init: 1)
		(efExitDrawer init: 2)
		(if (IsFlag 8)
			(vOpenCupboard init:)
		)
		(super init: &rest)
	)
)

(instance vOpenCupboard of View
	(properties
		priority 10
		fixPriority 1
		view 7100
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 7120
	)
)

(instance efExitDrawer of ExitFeature
	(properties
		nsRight 80
		nextRoom 7111
	)
)

