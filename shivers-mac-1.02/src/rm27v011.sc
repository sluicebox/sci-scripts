;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27011)
(include sci.sh)
(use Main)

(public
	rm27v011 0
)

(instance rm27v011 of ShiversRoom
	(properties
		picture 27011
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nsLeft 210
		nextRoom 27010
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27012
	)
)

