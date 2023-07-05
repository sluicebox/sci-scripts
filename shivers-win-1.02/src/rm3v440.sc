;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3440)
(include sci.sh)
(use Main)

(public
	rm3v440 0
)

(instance rm3v440 of ShiversRoom
	(properties
		picture 3440
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 3430
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3450
	)
)

