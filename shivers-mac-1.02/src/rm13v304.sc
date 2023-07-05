;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13304)
(include sci.sh)
(use Main)

(public
	rm13v304 0
)

(instance rm13v304 of ShiversRoom
	(properties
		picture 13440
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(efExitForwardLeft init: 9)
		(efExitForwardRight init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13305
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13305
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13332
	)

	(method (init)
		(self createPoly: 53 143 88 123 88 20 180 20 180 123 219 142)
		(super init: &rest)
	)
)

(instance efExitForwardLeft of ExitFeature
	(properties
		nextRoom 13308
	)

	(method (init)
		(self createPoly: 51 143 51 0 87 19 87 122)
		(super init: &rest)
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 13328
	)

	(method (init)
		(self createPoly: 180 122 179 20 220 0 220 141)
		(super init: &rest)
	)
)

