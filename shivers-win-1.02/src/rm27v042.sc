;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27042)
(include sci.sh)
(use Main)

(public
	rm27v042 0
)

(instance rm27v042 of ShiversRoom
	(properties
		picture 27042
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
		nextRoom 27041
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nsRight 50
		nextRoom 27043
	)
)

