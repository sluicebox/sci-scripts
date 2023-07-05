;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33190)
(include sci.sh)
(use Main)

(public
	rm33v190 0
)

(instance rm33v190 of ShiversRoom
	(properties
		picture 33190
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 33200
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 33300
	)
)

