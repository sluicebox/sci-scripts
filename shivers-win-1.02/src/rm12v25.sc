;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12250)
(include sci.sh)
(use Main)

(public
	rm12v25 0
)

(instance rm12v25 of ShiversRoom
	(properties
		picture 12250
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
		nextRoom 12230
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12240
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 12290
	)

	(method (init)
		(self
			createPoly:
				231
				142
				216
				112
				214
				74
				191
				36
				179
				45
				139
				45
				138
				73
				96
				103
				43
				104
				30
				75
				21
				75
				21
				143
		)
		(super init: &rest)
	)
)

