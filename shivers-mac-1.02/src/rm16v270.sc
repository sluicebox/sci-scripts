;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16270)
(include sci.sh)
(use Main)
(use n951)

(public
	rm16v270 0
)

(instance rm16v270 of ShiversRoom
	(properties
		picture 16270
	)

	(method (init)
		(if (IsFlag 13)
			(= picture 16274)
		)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(efExitStairs init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16280
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16280
	)
)

(instance efExitStairs of ExitFeature
	(properties
		nextRoom 16640
	)

	(method (init)
		(self
			createPoly:
				28
				141
				52
				16
				126
				4
				156
				4
				156
				47
				198
				53
				147
				55
				144
				44
				122
				42
				114
				45
				112
				57
				119
				74
				119
				146
		)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16290
	)

	(method (init)
		(self createPoly: 133 142 133 73 156 62 242 49 242 104 191 130 191 142)
		(super init: &rest)
	)
)

