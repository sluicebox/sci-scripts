;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2230)
(include sci.sh)
(use Main)

(public
	rm2v23 0
)

(instance rm2v23 of ShiversRoom
	(properties
		picture 2230
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 2220
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2220
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2250
	)

	(method (init)
		(self
			createPoly:
				17
				142
				32
				121
				86
				96
				108
				34
				108
				17
				126
				12
				156
				13
				157
				22
				187
				99
				254
				123
				262
				142
		)
		(super init: &rest)
	)
)

