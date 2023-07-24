;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1121)
(include sci.sh)
(use Main)
(use n951)

(public
	rm1v121 0
)

(instance rm1v121 of ShiversRoom
	(properties
		picture 1121
	)

	(method (init)
		(efExitLeft init: 3)
		(efExitRight init: 1)
		(proc951_16 84)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1123
	)

	(method (init)
		(self
			createPoly: 1 1 33 1 33 19 49 18 69 18 91 24 116 39 135 60 151 82 153 88 78 85 78 143 1 143
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1120
	)
)

