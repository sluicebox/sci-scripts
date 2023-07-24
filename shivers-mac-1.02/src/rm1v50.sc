;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1050)
(include sci.sh)
(use Main)

(public
	rm1v50 0
)

(instance rm1v50 of ShiversRoom
	(properties
		picture 1050
	)

	(method (init)
		(gSounds fade: 10111 26 1 40 0 0)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1051
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1051
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1260
	)

	(method (init)
		(self
			createPoly: 95 142 102 94 112 70 112 0 155 0 155 69 157 85 170 93 181 142
		)
		(super init: &rest)
	)
)

