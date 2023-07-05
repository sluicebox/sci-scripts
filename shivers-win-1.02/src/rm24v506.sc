;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24506)
(include sci.sh)
(use Main)
(use n951)

(public
	rm24v506 0
)

(instance rm24v506 of ShiversRoom
	(properties
		picture 24506
	)

	(method (init)
		(proc951_16 108)
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
		(self createPoly: 55 9 55 133 208 133 208 9 55 9)
		(super init: &rest)
	)
)

