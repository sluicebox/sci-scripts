;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10190)
(include sci.sh)
(use Main)

(public
	rm10v190 0
)

(instance rm10v190 of ShiversRoom
	(properties
		picture 10190
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitPurse init: 5)
		(efExitForward init: 3)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10380
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10380
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10200
	)

	(method (init)
		(self
			createPoly:
				195
				133
				178
				111
				141
				110
				125
				130
				55
				130
				48
				115
				49
				34
				228
				33
				238
				92
				210
				127
		)
		(super init: &rest)
	)
)

(instance efExitPurse of ExitFeature
	(properties
		nextRoom 10201
	)

	(method (init)
		(self createPoly: 115 142 141 110 178 111 202 143)
		(super init: &rest)
	)
)

