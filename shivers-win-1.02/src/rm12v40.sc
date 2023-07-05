;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12400)
(include sci.sh)
(use Main)

(public
	rm12v40 0
)

(instance rm12v40 of ShiversRoom
	(properties
		picture 12400
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efForward init: 3)
		(efExitMermaid init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12380
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12390
	)
)

(instance efExitMermaid of ExitFeature
	(properties
		nextRoom 12330
	)

	(method (init)
		(self
			createPoly:
				135
				20
				112
				50
				108
				96
				117
				110
				138
				111
				178
				76
				152
				10
				135
				20
		)
		(super init: &rest)
	)
)

(instance efForward of ExitFeature
	(properties
		nextRoom 12590
	)

	(method (init)
		(self createPoly: 74 143 72 103 86 88 105 89 105 144 74 143)
		(super init: &rest)
	)
)

