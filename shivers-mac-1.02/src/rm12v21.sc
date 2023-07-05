;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12210)
(include sci.sh)
(use Main)

(public
	rm12v21 0
)

(instance rm12v21 of ShiversRoom
	(properties
		picture 12210
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12140
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12170
	)
)

