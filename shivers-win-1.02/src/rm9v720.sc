;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9720)
(include sci.sh)
(use Main)

(public
	rm9v720 0
)

(instance rm9v720 of ShiversRoom
	(properties
		picture 9720
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(efExitSecret init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9730
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9710
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9470
	)

	(method (init)
		(self createPoly: 76 97 77 9 173 9 176 97)
		(super init: &rest)
	)
)

(instance efExitSecret of ExitFeature
	(properties
		nextRoom 9420
	)

	(method (init)
		(self createPoly: 189 65 189 97 226 97 226 65 191 65)
		(super init: &rest)
	)
)

