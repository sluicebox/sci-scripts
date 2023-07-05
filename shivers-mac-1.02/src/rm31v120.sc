;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31120)
(include sci.sh)
(use Main)

(public
	rm31v120 0
)

(instance rm31v120 of ShiversRoom
	(properties
		picture 31120
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31420
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31110
	)
)

