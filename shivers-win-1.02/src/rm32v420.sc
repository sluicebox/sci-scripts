;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32420)
(include sci.sh)
(use Main)
(use n951)

(public
	rm32v420 0
)

(instance rm32v420 of ShiversRoom
	(properties
		picture 32420
	)

	(method (init)
		(if (IsFlag 81)
			(= picture 32421)
		else
			(= picture 32420)
		)
		(efExitForward init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32430
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32370
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32410
	)

	(method (init)
		(self
			createPoly: 165 101 165 20 105 19 105 100 71 112 71 120 209 120 209 111 166 101
		)
		(super init: &rest)
	)
)

