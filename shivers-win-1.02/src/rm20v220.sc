;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20220)
(include sci.sh)
(use Main)

(public
	rm20v220 0
)

(instance rm20v220 of ShiversRoom
	(properties
		picture 20220
	)

	(method (init)
		(efExitDownCenter init: 3)
		(efExitUpCenter init: 3)
		(efExitDownLeft init: 3)
		(efExitUpLeft init: 3)
		(efExitDownRight init: 3)
		(efExitUpRight init: 3)
		(efExitDown init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitDownCenter of ExitFeature
	(properties
		nextRoom 20740
	)

	(method (init)
		(self createPoly: 95 57 95 121 169 121 169 57 96 57)
		(super init: &rest)
	)
)

(instance efExitUpCenter of ExitFeature
	(properties
		nextRoom 20290
	)

	(method (init)
		(self createPoly: 62 2 62 55 169 55 169 2 63 2)
		(super init: &rest)
	)
)

(instance efExitDownLeft of ExitFeature
	(properties
		nextRoom 20730
	)

	(method (init)
		(self createPoly: 24 57 24 140 86 140 86 57 25 57)
		(super init: &rest)
	)
)

(instance efExitUpLeft of ExitFeature
	(properties
		nextRoom 20280
	)

	(method (init)
		(self createPoly: 3 55 54 55 54 0 3 0 3 55)
		(super init: &rest)
	)
)

(instance efExitDownRight of ExitFeature
	(properties
		nextRoom 20750
	)

	(method (init)
		(self createPoly: 183 56 183 127 239 127 239 56 183 56)
		(super init: &rest)
	)
)

(instance efExitUpRight of ExitFeature
	(properties
		nextRoom 20300
	)

	(method (init)
		(self createPoly: 173 1 173 55 257 55 257 2 173 2)
		(super init: &rest)
	)
)

(instance efExitDown of ExitFeature
	(properties
		nextRoom 20260
	)

	(method (init)
		(self
			createPoly:
				87
				142
				101
				132
				122
				128
				142
				126
				162
				126
				193
				133
				209
				143
				87
				143
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20200
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20200
	)
)

