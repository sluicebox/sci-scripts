;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8610)
(include sci.sh)
(use Main)
(use n951)

(public
	rm8v610 0
)

(instance rm8v610 of ShiversRoom
	(properties
		picture 8610
	)

	(method (init)
		(ClearFlag 43)
		(efExitDoor init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8590
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8560
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 8040
	)

	(method (init)
		(self
			createPoly:
				69
				144
				74
				134
				69
				106
				80
				92
				99
				92
				110
				73
				107
				23
				144
				23
				140
				74
				140
				100
				158
				106
				163
				141
		)
		(super init: &rest)
	)
)

(instance efExitDoor of ExitFeature
	(properties
		nextRoom 8030
	)

	(method (init)
		(self createPoly: 69 103 79 90 71 20 50 13)
		(super init: &rest)
	)
)

