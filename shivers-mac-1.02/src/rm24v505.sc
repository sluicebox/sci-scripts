;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24505)
(include sci.sh)
(use Main)

(public
	rm24v505 0
)

(instance rm24v505 of ShiversRoom
	(properties
		picture 24505
	)

	(method (init)
		(efExitBack init: 0)
		(gSounds play: 12418 0 82 0)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 24501
	)

	(method (init)
		(self createPoly: 55 9 55 133 207 133 207 9 55 9)
		(super init: &rest)
	)
)

