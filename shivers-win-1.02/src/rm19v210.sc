;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19210)
(include sci.sh)
(use Main)

(public
	rm19v210 0
)

(instance rm19v210 of ShiversRoom
	(properties
		picture 19210
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
		nextRoom 19240
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 19220
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 19010
	)

	(method (init)
		(self
			createPoly: 68 143 102 108 102 85 128 85 140 68 145 75 185 75 185 116 185 128 199 129 215 147
		)
		(super init: &rest)
	)
)

