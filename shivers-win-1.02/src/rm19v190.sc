;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19190)
(include sci.sh)
(use Main)

(public
	rm19v190 0
)

(instance rm19v190 of ShiversRoom
	(properties
		picture 19190
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 19180
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 19200
	)
)

