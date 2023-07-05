;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26040)
(include sci.sh)
(use Main)

(public
	rm26v040 0
)

(instance rm26v040 of ShiversRoom
	(properties
		picture 26040
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
		nextRoom 26050
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 26050
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 26020
	)

	(method (init)
		(self
			createPoly:
				94
				143
				117
				118
				117
				44
				124
				37
				151
				32
				170
				32
				192
				35
				203
				43
				203
				118
				229
				145
		)
		(super init: &rest)
	)
)

