;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1161)
(include sci.sh)
(use Main)

(public
	rm1v161 0
)

(instance rm1v161 of ShiversRoom
	(properties
		picture 1161
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1162
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1162
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1163
	)

	(method (init)
		(self createPoly: 30 0 65 142 150 142 163 1 31 0)
		(super init: &rest)
	)
)

