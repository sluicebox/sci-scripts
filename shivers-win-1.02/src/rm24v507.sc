;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24507)
(include sci.sh)
(use Main)

(public
	rm24v507 0
)

(instance rm24v507 of ShiversRoom
	(properties
		picture 24507
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
		(self createPoly: 55 7 55 136 208 136 208 7 55 7)
		(super init: &rest)
	)
)

