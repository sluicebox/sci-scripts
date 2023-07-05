;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31220)
(include sci.sh)
(use Main)

(public
	rm31v220 0
)

(instance rm31v220 of ShiversRoom
	(properties
		picture 31220
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31190
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31210
	)
)

