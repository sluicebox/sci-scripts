;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16190)
(include sci.sh)
(use Main)
(use n951)

(public
	rm16v190 0
)

(instance rm16v190 of ShiversRoom
	(properties
		picture 16190
	)

	(method (init)
		(if (IsFlag 13)
			(= picture 16194)
		)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16200
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16200
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16090
	)

	(method (init)
		(self createPoly: 48 145 98 79 98 31 130 31 130 84 168 146)
		(super init: &rest)
	)
)

