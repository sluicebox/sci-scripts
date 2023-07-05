;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10480)
(include sci.sh)
(use Main)

(public
	rm10v480 0
)

(instance rm10v480 of ShiversRoom
	(properties
		picture 10480
	)

	(method (init)
		(if (== gPrevRoomNum 10142) ; rm10v142
			(gSounds play: 11020 0 82 0)
		)
		(super init: &rest)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(efReport init: 3)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10430
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10430
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10160
	)

	(method (init)
		(self
			createPoly:
				31
				143
				20
				132
				20
				1
				192
				1
				225
				32
				245
				80
				244
				115
				236
				134
				220
				142
				115
				143
				115
				132
				131
				125
				109
				115
				94
				122
				114
				130
				114
				144
		)
		(super init: &rest)
	)
)

(instance efReport of ExitFeature
	(properties
		nextRoom 10142
	)

	(method (init)
		(self createPoly: 116 131 94 122 108 115 131 125)
		(super init: &rest)
	)
)

