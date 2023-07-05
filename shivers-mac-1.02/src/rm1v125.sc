;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1125)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm1v125 0
)

(instance rm1v125 of ShiversRoom
	(properties
		picture 1125
	)

	(method (init)
		(if (IsFlag 1)
			(vStonehengeOpen init:)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance vStonehengeOpen of View
	(properties
		priority 20
		fixPriority 1
		view 1125
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1130
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1131
	)
)

