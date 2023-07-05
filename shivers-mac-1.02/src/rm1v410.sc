;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1410)
(include sci.sh)
(use Main)
(use n951)

(public
	rm1v410 0
)

(instance rm1v410 of ShiversRoom
	(properties
		picture 1410
	)

	(method (init)
		(proc951_9 10111)
		(gSounds play: 10111 -1 0 0)
		(gSounds fade: 10111 98 1 40 0 0)
		(gSounds fade: 10112 0 1 40 1 0)
		(efExitForward init: 9)
		(efExitForwardRight init: 1)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1422
	)

	(method (init)
		(self createPoly: 29 142 95 97 201 97 263 134 263 142)
		(super init: &rest)
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 1423
	)

	(method (init)
		(self createPoly: 222 109 225 5 264 5 263 133)
		(super init: &rest)
	)
)

