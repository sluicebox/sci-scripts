;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32400)
(include sci.sh)
(use Main)

(public
	rm32v400 0
)

(instance rm32v400 of ShiversRoom
	(properties
		picture 32400
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32320
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32330
	)
)

