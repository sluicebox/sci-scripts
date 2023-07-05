;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16290)
(include sci.sh)
(use Main)
(use n951)

(public
	rm16v290 0
)

(instance rm16v290 of ShiversRoom
	(properties
		picture 16290
	)

	(method (init)
		(if (IsFlag 13)
			(= picture 16294)
		)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16300
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16300
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16070
	)

	(method (init)
		(self createPoly: 96 142 133 84 133 35 170 35 169 80 214 146)
		(super init: &rest)
	)
)

