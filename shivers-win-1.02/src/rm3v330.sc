;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3330)
(include sci.sh)
(use Main)

(public
	rm3v330 0
)

(instance rm3v330 of ShiversRoom
	(properties
		picture 3330
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 3320
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3340
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 3430
	)

	(method (init)
		(self
			createPoly:
				216
				122
				143
				121
				114
				109
				132
				95
				131
				88
				140
				58
				185
				60
				221
				70
				185
				92
				201
				106
				217
				112
		)
		(super init: &rest)
	)
)

