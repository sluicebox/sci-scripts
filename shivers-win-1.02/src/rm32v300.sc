;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32300)
(include sci.sh)
(use Main)
(use n951)

(public
	rm32v300 0
)

(instance rm32v300 of ShiversRoom
	(properties
		picture 32300
	)

	(method (init)
		(if (IsFlag 81)
			(= picture 32301)
		else
			(= picture 32300)
		)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32310
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32290
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32320
	)

	(method (init)
		(self createPoly: 60 50 180 50 180 140 60 180 60 50)
		(super init: &rest)
	)
)

