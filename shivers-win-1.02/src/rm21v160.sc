;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21160)
(include sci.sh)
(use Main)

(public
	rm21v160 0
)

(instance rm21v160 of ShiversRoom
	(properties
		picture 21160
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(efExitForwardLeft init: 3)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21170
	)

	(method (init)
		(self
			createPoly:
				205
				135
				205
				115
				211
				114
				211
				101
				217
				101
				217
				85
				225
				85
				225
				70
				232
				68
				232
				51
				241
				51
				241
				31
				249
				31
				249
				10
				260
				7
				261
				139
				216
				139
				205
				135
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21180
	)

	(method (init)
		(self createPoly: 1 1 50 1 50 136 1 136 1 1)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 21400
	)

	(method (init)
		(self
			createPoly: 89 83 100 83 112 71 112 64 98 54 89 54 76 66 76 73 88 82
		)
		(super init: &rest)
	)
)

(instance efExitForwardLeft of ExitFeature
	(properties
		nextRoom 21181
	)

	(method (init)
		(self
			createPoly:
				96
				132
				96
				126
				91
				122
				91
				102
				93
				102
				93
				99
				84
				91
				79
				91
				67
				93
				65
				100
				65
				122
				61
				124
				61
				130
				64
				134
				72
				136
				80
				136
				91
				135
				96
				132
		)
		(super init: &rest)
	)
)

