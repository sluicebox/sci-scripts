;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8380)
(include sci.sh)
(use Main)

(public
	rm8v380 0
)

(instance rm8v380 of ShiversRoom
	(properties
		picture 8380
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(efExitDoor init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8370
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8390
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 8540
	)

	(method (init)
		(self createPoly: 78 143 96 109 95 79 207 79 207 102 228 141)
		(super init: &rest)
	)
)

(instance efExitDoor of ExitFeature
	(properties
		nextRoom 8030
	)

	(method (init)
		(self createPoly: 207 102 212 35 243 35 243 98 226 98 226 102)
		(super init: &rest)
	)
)

