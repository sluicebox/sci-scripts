;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1260)
(include sci.sh)
(use Main)
(use n951)

(public
	rm1v260 0
)

(instance rm1v260 of ShiversRoom
	(properties
		picture 1260
	)

	(method (init)
		(proc951_9 10112)
		(gSounds play: 10112 -1 0 0)
		(gSounds fade: 10112 98 1 40 0 0)
		(gSounds fade: 10111 0 1 40 1 0)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1261
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1261
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1270
	)

	(method (init)
		(self
			createPoly: 45 108 84 85 84 57 90 32 148 32 148 57 152 57 159 82 216 107 229 142 31 142
		)
		(super init: &rest)
	)
)

