;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35190)
(include sci.sh)
(use Main)

(public
	rm35v190 0
)

(instance rm35v190 of ShiversRoom
	(properties
		picture 35190
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 35300
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 35310
	)
)

