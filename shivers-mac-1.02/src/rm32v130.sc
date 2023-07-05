;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32130)
(include sci.sh)
(use Main)

(public
	rm32v130 0
)

(instance rm32v130 of ShiversRoom
	(properties
		picture 32130
	)

	(method (init)
		(efExitForward init: 3)
		(efExitHeadRack init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32120
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32140
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32150
	)

	(method (init)
		(self
			createPoly:
				179
				79
				194
				80
				208
				112
				208
				115
				110
				115
				115
				80
				114
				15
				179
				15
				179
				77
		)
		(super init: &rest)
	)
)

(instance efExitHeadRack of ExitFeature
	(properties
		nextRoom 32630
	)

	(method (init)
		(self
			createPoly:
				55
				137
				58
				84
				109
				76
				108
				68
				76
				26
				34
				26
				21
				72
				21
				141
				55
				141
				54
				137
		)
		(super init: &rest)
	)
)

