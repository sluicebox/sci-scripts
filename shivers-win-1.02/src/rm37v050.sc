;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37050)
(include sci.sh)
(use Main)

(public
	rm37v050 0
)

(instance rm37v050 of ShiversRoom
	(properties
		picture 37050
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(efExitDoor init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37060
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37060
	)

	(method (init)
		(self
			createPoly:
				263
				0
				263
				142
				243
				142
				243
				111
				248
				109
				264
				109
				263
				25
				243
				31
				243
				0
		)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 37100
	)

	(method (init)
		(self createPoly: 87 117 87 85 99 52 142 47 141 68 154 68 165 120)
		(super init: &rest)
	)
)

(instance efExitDoor of ExitFeature
	(properties
		nextRoom 37030
	)

	(method (init)
		(self createPoly: 241 110 240 32 264 25 264 109 249 108)
		(super init: &rest)
	)
)

