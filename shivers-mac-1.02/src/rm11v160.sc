;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11160)
(include sci.sh)
(use Main)

(public
	rm11v160 0
)

(instance rm11v160 of ShiversRoom
	(properties
		picture 11160
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 11150
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 11170
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 11040
	)

	(method (init)
		(self
			createPoly: 89 135 88 77 72 77 73 45 132 45 133 82 116 97 117 102 137 107 137 134
		)
		(super init: &rest)
	)
)

