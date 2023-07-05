;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11180)
(include sci.sh)
(use Main)

(public
	rm11v180 0
)

(instance rm11v180 of ShiversRoom
	(properties
		picture 11180
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efPlaque init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 11170
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 11150
	)

	(method (init)
		(self createPoly: 218 1 220 142 252 142 237 102 239 95 264 94 261 0)
		(super init: &rest)
	)
)

(instance efPlaque of ExitFeature
	(properties
		nextRoom 11410
	)

	(method (init)
		(self createPoly: 262 92 234 94 234 105 251 142 263 143)
		(super init: &rest)
	)
)

