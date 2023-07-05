;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24509)
(include sci.sh)
(use Main)

(public
	rm24v509 0
)

(instance rm24v509 of ShiversRoom
	(properties
		picture 24509
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
		(self createPoly: 55 9 55 133 208 133 208 9 56 9)
		(super init: &rest)
	)
)

