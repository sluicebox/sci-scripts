;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12321)
(include sci.sh)
(use Main)

(public
	rm12v321 0
)

(instance rm12v321 of ShiversRoom
	(properties
		picture 12321
	)

	(method (init)
		(efExitRight init: 6)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12050
	)

	(method (init)
		(self createPoly: 263 0 263 143 189 143 189 0 262 0)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12060
	)

	(method (init)
		(self createPoly: 0 0 72 0 72 142 0 142 0 1)
		(super init: &rest)
	)
)

