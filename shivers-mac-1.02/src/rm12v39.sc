;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12390)
(include sci.sh)
(use Main)

(public
	rm12v39 0
)

(instance rm12v39 of ShiversRoom
	(properties
		picture 12390
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12400
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12370
	)
)

