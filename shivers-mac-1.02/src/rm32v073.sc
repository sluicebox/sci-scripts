;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32073)
(include sci.sh)
(use Main)

(public
	rm32v073 0
)

(instance rm32v073 of ShiversRoom
	(properties
		picture 32073
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32430
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32420
	)
)

