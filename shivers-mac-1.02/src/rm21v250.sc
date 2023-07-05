;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21250)
(include sci.sh)
(use Main)

(public
	rm21v250 0
)

(instance rm21v250 of ShiversRoom
	(properties
		picture 21250
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForwardLeft init: 3)
		(efExitForwardRight init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21280
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21280
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 21230
	)

	(method (init)
		(self
			createPoly:
				166
				38
				220
				38
				220
				45
				207
				112
				206
				141
				135
				141
				135
				45
				158
				45
				166
				38
		)
		(super init: &rest)
	)
)

(instance efExitForwardLeft of ExitFeature
	(properties
		nextRoom 21220
	)

	(method (init)
		(self
			createPoly:
				130
				45
				129
				142
				54
				142
				48
				70
				54
				52
				52
				46
				63
				32
				123
				32
				124
				37
				130
				44
		)
		(super init: &rest)
	)
)

