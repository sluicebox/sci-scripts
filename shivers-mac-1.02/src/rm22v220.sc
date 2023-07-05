;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22220)
(include sci.sh)
(use Main)

(public
	rm22v220 0
)

(instance rm22v220 of ShiversRoom
	(properties
		picture 22220
	)

	(method (init)
		(efExitDrummer init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitDrummer of ExitFeature
	(properties
		nextRoom 22180
	)

	(method (init)
		(self
			createPoly:
				100
				143
				88
				121
				84
				101
				86
				83
				113
				79
				119
				64
				141
				42
				153
				42
				168
				83
				215
				96
				217
				106
				216
				143
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 22250
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 22270
	)
)

