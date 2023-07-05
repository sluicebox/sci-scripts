;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2210)
(include sci.sh)
(use Main)

(public
	rm2v21 0
)

(instance rm2v21 of ShiversRoom
	(properties
		picture 2210
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
		nextRoom 2200
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2200
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2230
	)

	(method (init)
		(self
			createPoly:
				37
				142
				69
				110
				109
				110
				110
				85
				123
				75
				145
				75
				158
				82
				158
				102
				161
				108
				202
				108
				242
				142
		)
		(super init: &rest)
	)
)

