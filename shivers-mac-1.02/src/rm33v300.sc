;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33300)
(include sci.sh)
(use Main)

(public
	rm33v300 0
)

(instance rm33v300 of ShiversRoom
	(properties
		picture 33300
	)

	(method (init)
		(efExitRight init: 6)
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
		nextRoom 33090
	)
)

