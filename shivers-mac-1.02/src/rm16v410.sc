;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16410)
(include sci.sh)
(use Main)
(use n951)

(public
	rm16v410 0
)

(instance rm16v410 of ShiversRoom
	(properties
		picture 16410
	)

	(method (init)
		(if (IsFlag 13)
			(= picture 16414)
		)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16420
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16400
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16440
	)

	(method (init)
		(self createPoly: 83 144 85 33 123 33 130 55 136 90 120 97 125 144)
		(super init: &rest)
	)
)

