;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14310)
(include sci.sh)
(use Main)

(public
	rm14v310 0
)

(instance rm14v310 of ShiversRoom
	(properties
		picture 14310
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(efExitStatue init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 14300
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 14020
	)

	(method (init)
		(self
			createPoly:
				219
				103
				223
				78
				243
				67
				243
				0
				263
				0
				263
				143
				243
				143
				243
				111
		)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 14120
	)

	(method (init)
		(self createPoly: 77 120 79 105 90 102 93 70 136 70 143 120)
		(super init: &rest)
	)
)

(instance efExitStatue of ExitFeature
	(properties
		nextRoom 14110
	)

	(method (init)
		(self createPoly: 144 120 136 70 179 54 198 54 214 70 222 78 218 102)
		(super init: &rest)
	)
)

