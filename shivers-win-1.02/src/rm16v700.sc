;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16700)
(include sci.sh)
(use Main)
(use n951)

(public
	rm16v700 0
)

(instance rm16v700 of ShiversRoom
	(properties
		picture 16700
	)

	(method (init)
		(if (IsFlag 13)
			(= picture 16704)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16520
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16240
	)
)

