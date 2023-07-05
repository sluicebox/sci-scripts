;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30070)
(include sci.sh)
(use Main)
(use n951)

(public
	rm30v070 0
)

(instance rm30v070 of ShiversRoom
	(properties
		picture 30071
	)

	(method (init)
		(proc951_16 111)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 30090
	)

	(method (init)
		(self
			createPoly:
				0
				0
				0
				40
				220
				40
				220
				100
				40
				100
				40
				40
				0
				40
				0
				142
				262
				142
				262
				0
				0
				0
		)
		(super init: &rest)
	)
)

