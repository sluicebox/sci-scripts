;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10330)
(include sci.sh)
(use Main)

(public
	rm10v330 0
)

(instance rm10v330 of ShiversRoom
	(properties
		picture 10330
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10260
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10260
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10340
	)

	(method (init)
		(self
			createPoly:
				64
				140
				30
				123
				20
				101
				20
				42
				41
				17
				65
				5
				103
				0
				201
				0
				227
				14
				236
				29
				243
				47
				243
				110
				231
				125
				217
				135
				198
				142
		)
		(super init: &rest)
	)
)

