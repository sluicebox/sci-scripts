;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15220)
(include sci.sh)
(use Main)
(use Osc)

(public
	rm15v22 0
)

(instance rm15v22 of ShiversRoom
	(properties
		picture 15220
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(if (not (Random 0 3))
			(eye init:)
		)
		(super init: &rest)
	)
)

(instance eye of ShiversProp
	(properties
		x 100
		y 50
		view 15220
	)

	(method (init)
		(super init: &rest)
		(gSounds play: 11502 0 98 0)
		(self setCycle: Osc 1)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 15190
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 15210
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 15250
	)

	(method (init)
		(self createPoly: 75 143 94 115 94 35 170 35 170 123 184 142)
		(super init: &rest)
	)
)

