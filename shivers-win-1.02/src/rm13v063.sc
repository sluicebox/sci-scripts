;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13063)
(include sci.sh)
(use Main)

(public
	rm13v063 0
)

(instance rm13v063 of ShiversRoom
	(properties
		picture 13650
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(efExitForwardLeft init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13062
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13065
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13059
	)

	(method (init)
		(self createPoly: 38 142 81 126 81 20 181 20 181 127 191 141)
		(super init: &rest)
	)
)

(instance efExitForwardLeft of ExitFeature
	(properties
		nextRoom 13047
	)

	(method (init)
		(self createPoly: 36 142 36 0 81 19 81 126)
		(super init: &rest)
	)
)

