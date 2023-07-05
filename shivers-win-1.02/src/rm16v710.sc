;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16710)
(include sci.sh)
(use Main)
(use n951)

(public
	rm16v710 0
)

(instance rm16v710 of ShiversRoom
	(properties
		picture 16710
	)

	(method (init)
		(if (IsFlag 13)
			(= picture 16714)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16140
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16500
	)
)

