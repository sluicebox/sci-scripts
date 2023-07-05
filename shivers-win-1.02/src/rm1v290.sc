;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1290)
(include sci.sh)
(use Main)

(public
	rm1v290 0
)

(instance rm1v290 of ShiversRoom
	(properties
		picture 1290
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
		nextRoom 1291
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1291
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1300
	)

	(method (init)
		(self createPoly: 25 142 35 78 98 62 98 23 174 23 173 42 182 141)
		(super init: &rest)
	)
)

