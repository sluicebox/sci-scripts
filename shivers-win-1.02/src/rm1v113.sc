;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1113)
(include sci.sh)
(use Main)
(use n951)

(public
	rm1v113 0
)

(instance rm1v113 of ShiversRoom
	(properties
		picture 1113
	)

	(method (init)
		(gSounds fade: 10114 0 1 40 1 0)
		(efExitLeft180 init: 7)
		(efExitForward init: 3)
		(proc951_16 83)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1094
	)

	(method (init)
		(self createPoly: 215 142 234 70 233 0 262 0 262 142 216 142)
		(super init: &rest)
	)
)

(instance efExitLeft180 of ExitFeature
	(properties
		nextRoom 1093
	)
)

