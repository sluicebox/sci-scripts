;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16620)
(include sci.sh)
(use Main)
(use n951)

(public
	rm16v620 0
)

(instance rm16v620 of ShiversRoom
	(properties
		picture 16620
	)

	(method (init)
		(if (IsFlag 13)
			(= picture 16624)
		)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16630
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16630
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16310
	)

	(method (init)
		(self
			createPoly: 78 143 87 122 85 94 66 79 68 60 117 54 124 12 133 1 139 13 140 81 194 143
		)
		(super init: &rest)
	)
)

