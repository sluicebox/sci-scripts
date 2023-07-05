;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8220)
(include sci.sh)
(use Main)

(public
	rm8v220 0
)

(instance rm8v220 of ShiversRoom
	(properties
		picture 8220
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitDownLeft init: 5)
		(efExitDownRight init: 5)
		(efBookOne init: 0)
		(efBookTwo init: 0)
		(efBookThree init: 0)
		(efBookFour init: 0)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nsBottom 113
		nextRoom 8210
	)
)

(instance efExitRight of ExitFeature
	(properties
		nsBottom 117
		nextRoom 8180
	)
)

(instance efExitDownLeft of ExitFeature
	(properties
		nextRoom 8230
	)

	(method (init)
		(self createPoly: 0 143 0 113 135 113 135 142)
		(super init: &rest)
	)
)

(instance efExitDownRight of ExitFeature
	(properties
		nextRoom 8240
	)

	(method (init)
		(self createPoly: 151 143 151 117 263 117 263 142)
		(super init: &rest)
	)
)

(instance efBookOne of ExitFeature
	(properties
		nextRoom 8221
	)

	(method (init)
		(self createPoly: 140 11 145 9 145 14 136 41 128 38 139 11)
		(super init: &rest)
	)
)

(instance efBookTwo of ExitFeature
	(properties
		nextRoom 8222
	)

	(method (init)
		(self createPoly: 157 4 165 4 165 41 155 41 155 4 157 4)
		(super init: &rest)
	)
)

(instance efBookThree of ExitFeature
	(properties
		nextRoom 8223
	)

	(method (init)
		(self createPoly: 189 7 198 7 198 39 196 41 187 41 187 7 188 7)
		(super init: &rest)
	)
)

(instance efBookFour of ExitFeature
	(properties
		nextRoom 8224
	)

	(method (init)
		(self createPoly: 158 47 166 47 166 72 157 72 157 47)
		(super init: &rest)
	)
)

