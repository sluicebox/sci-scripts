;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1202)
(include sci.sh)
(use Main)
(use n951)

(public
	rm1v202 0
)

(instance rm1v202 of ShiversRoom
	(properties
		picture 1202
	)

	(method (init)
		(gSounds fade: 10111 0 1 40 1 0)
		(proc951_9 10114)
		(gSounds play: 10114 -1 0 0)
		(gSounds fade: 10114 98 1 40 0 0)
		(efExitLeft init: 2)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1212
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1200
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1191
	)

	(method (init)
		(self
			createPoly: 65 102 82 80 110 65 166 65 122 84 118 110 142 117 142 142 41 142
		)
		(super init: &rest)
	)
)

