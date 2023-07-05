;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16720)
(include sci.sh)
(use Main)
(use n951)

(public
	rm16v720 0
)

(instance rm16v720 of ShiversRoom
	(properties
		picture 16720
	)

	(method (init)
		(if (IsFlag 13)
			(= picture 16724)
		)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16190
	)

	(method (init)
		(self createPoly: 217 142 1 85 0 144)
		(super init: &rest)
	)
)

