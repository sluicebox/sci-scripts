;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19230)
(include sci.sh)
(use Main)

(public
	rm19v230 0
)

(instance rm19v230 of ShiversRoom
	(properties
		picture 19230
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 19220
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 19240
	)
)

