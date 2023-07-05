;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19200)
(include sci.sh)
(use Main)

(public
	rm19v200 0
)

(instance rm19v200 of ShiversRoom
	(properties
		picture 19200
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 19190
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 19170
	)
)

