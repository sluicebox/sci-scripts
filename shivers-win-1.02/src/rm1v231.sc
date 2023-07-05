;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1231)
(include sci.sh)
(use Main)
(use n951)

(public
	rm1v231 0
)

(instance rm1v231 of ShiversRoom
	(properties
		picture 1231
	)

	(method (init)
		(proc951_9 10111)
		(gSounds play: 10111 -1 0 0)
		(gSounds fade: 10111 58 1 40 0 0)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1230
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1230
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1212
	)

	(method (init)
		(self createPoly: 23 143 14 51 73 52 131 60 175 77 205 102 221 142)
		(super init: &rest)
	)
)

