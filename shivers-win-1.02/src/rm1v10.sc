;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1010)
(include sci.sh)
(use Main)
(use n951)

(public
	rm1v10 0
)

(instance rm1v10 of ShiversRoom
	(properties
		picture 1010
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRightHigh init: 6)
		(efExitRight init: 6)
		(efExitForwardRight init: 3)
		(efExitUp init: 4)
		(super init: &rest)
		(if (IsFlag 43)
			(ClearFlag 43)
			(proc951_9 10128)
			(gSounds play: 10128 0 82 0)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1060
	)

	(method (init)
		(self createPoly: 94 143 97 131 32 113 32 1 1 1 1 143)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1012
	)

	(method (init)
		(self createPoly: 228 104 262 104 262 142 229 142)
		(super init: &rest)
	)
)

(instance efExitRightHigh of ExitFeature
	(properties
		nextRoom 1012
	)

	(method (init)
		(self createPoly: 262 59 262 1 232 1 232 59)
		(super init: &rest)
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 1020
	)

	(method (init)
		(self
			createPoly:
				169
				95
				169
				61
				196
				61
				196
				76
				203
				77
				203
				91
				232
				92
				232
				60
				263
				60
				263
				102
				226
				102
				226
				142
				120
				142
		)
		(super init: &rest)
	)
)

(instance efExitUp of ExitFeature
	(properties
		nsLeft 21
		nsTop 0
		nsRight 243
		nsBottom 30
		nextRoom 1011
	)
)

