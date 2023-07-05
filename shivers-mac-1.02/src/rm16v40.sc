;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16040)
(include sci.sh)
(use Main)
(use n951)

(public
	rm16v40 0
)

(instance rm16v40 of ShiversRoom
	(properties
		picture 16040
	)

	(method (init)
		(if (IsFlag 13)
			(= picture 16044)
		)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16050
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16050
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16060
	)

	(method (init)
		(self createPoly: 60 145 92 112 92 66 164 66 164 112 192 144)
		(super init: &rest)
	)
)

