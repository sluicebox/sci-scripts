;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2260)
(include sci.sh)
(use Main)

(public
	rm2v26 0
)

(instance rm2v26 of ShiversRoom
	(properties
		picture 2260
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 2570
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2270
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2240
	)

	(method (init)
		(self
			createPoly:
				38
				142
				84
				109
				84
				97
				88
				92
				88
				84
				103
				53
				117
				35
				125
				33
				137
				33
				142
				35
				157
				54
				173
				108
				212
				143
		)
		(super init: &rest)
	)
)

