;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40300)
(include sci.sh)
(use Main)

(public
	rm40v300 0
)

(instance rm40v300 of ShiversRoom
	(properties
		picture 40240
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
		nextRoom 40280
	)

	(method (init)
		(self
			createPoly:
				39
				125
				68
				104
				80
				104
				100
				97
				109
				97
				124
				93
				135
				27
				227
				27
				214
				125
				39
				125
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 40290
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 40290
	)
)

