;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1301)
(include sci.sh)
(use Main)

(public
	rm1v301 0
)

(instance rm1v301 of ShiversRoom
	(properties
		picture 1301
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1300
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1300
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1291
	)

	(method (init)
		(self
			createPoly:
				116
				129
				113
				60
				138
				57
				160
				68
				263
				128
				263
				142
				108
				142
				81
				115
		)
		(super init: &rest)
	)
)

