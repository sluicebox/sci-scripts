;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26070)
(include sci.sh)
(use Main)

(public
	rm26v070 0
)

(instance rm26v070 of ShiversRoom
	(properties
		picture 26070
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
		nextRoom 26060
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 26060
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 26090
	)

	(method (init)
		(self
			createPoly:
				163
				93
				163
				76
				100
				75
				93
				79
				90
				90
				21
				63
				21
				144
				243
				144
				243
				31
				229
				34
		)
		(super init: &rest)
	)
)

