;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31300)
(include sci.sh)
(use Main)

(public
	rm31v300 0
)

(instance rm31v300 of ShiversRoom
	(properties
		picture 31300
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 31280
	)

	(method (init)
		(self
			createPoly: 123 142 120 116 111 111 111 73 123 68 123 55 130 53 137 54 141 60 139 68 151 74 151 110 142 119 142 132 139 142 124 142
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31310
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31310
	)
)

