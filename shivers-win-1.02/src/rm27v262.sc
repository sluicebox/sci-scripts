;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27262)
(include sci.sh)
(use Main)

(public
	rm27v262 0
)

(instance rm27v262 of ShiversRoom
	(properties
		picture 27262
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
		nextRoom 27261
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27263
	)
)

