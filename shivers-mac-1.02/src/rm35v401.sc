;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35401)
(include sci.sh)
(use Main)

(public
	rm35v401 0
)

(instance rm35v401 of ShiversRoom
	(properties
		picture 35401
	)

	(method (init)
		(efExitBack init: 8)
		(efExitDown init: 3)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 35320
	)

	(method (init)
		(self
			createPoly:
				0
				0
				72
				11
				210
				11
				229
				127
				231
				130
				221
				140
				212
				140
				195
				132
				70
				132
				34
				137
				30
				130
				34
				118
				57
				115
				72
				11
				0
				0
				262
				0
				262
				144
				0
				144
				0
				0
		)
		(super init: &rest)
	)
)

(instance efExitDown of ExitFeature
	(properties
		nextRoom 40380
	)

	(method (init)
		(self
			createPoly:
				72
				11
				210
				11
				229
				127
				220
				121
				155
				101
				107
				100
				57
				115
				72
				11
		)
		(super init: &rest)
	)
)

