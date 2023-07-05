;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22350)
(include sci.sh)
(use Main)

(public
	rm22v350 0
)

(instance rm22v350 of ShiversRoom
	(properties
		picture 22350
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 22140
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 22360
	)
)

