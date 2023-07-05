;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31110)
(include sci.sh)
(use Main)

(public
	rm31v110 0
)

(instance rm31v110 of ShiversRoom
	(properties
		picture 31110
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31120
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31160
	)
)

