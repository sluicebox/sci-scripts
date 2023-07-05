;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27060)
(include sci.sh)
(use Main)

(public
	rm27v060 0
)

(instance rm27v060 of ShiversRoom
	(properties
		picture 27060
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nsLeft 210
		nextRoom 27063
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27061
	)
)

