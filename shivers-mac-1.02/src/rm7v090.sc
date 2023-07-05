;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7090)
(include sci.sh)
(use Main)

(public
	rm7v090 0
)

(instance rm7v090 of ShiversRoom
	(properties
		picture 7090
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitDrawing init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 7070
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 7080
	)
)

(instance efExitDrawing of ExitFeature
	(properties
		nextRoom 7162
	)

	(method (init)
		(self createPoly: 152 120 191 132 218 117 182 109 152 120)
		(super init: &rest)
	)
)

