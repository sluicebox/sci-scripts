;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1111)
(include sci.sh)
(use Main)
(use n951)

(public
	rm1v111 0
)

(instance rm1v111 of ShiversRoom
	(properties
		picture 1111
	)

	(method (init)
		(proc951_9 10124)
		(gSounds play: 10124 -1 0 0)
		(gSounds fade: 10124 98 1 40 0 0)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(efExitForwardLeft init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1110
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1110
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1094
	)

	(method (init)
		(self createPoly: 74 142 169 107 197 107 211 142)
		(super init: &rest)
	)
)

(instance efExitForwardLeft of ExitFeature
	(properties
		nextRoom 1113
	)

	(method (init)
		(self createPoly: 79 117 95 100 110 100 119 117)
		(super init: &rest)
	)
)

