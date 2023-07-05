;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27152)
(include sci.sh)
(use Main)

(public
	rm27v152 0
)

(instance rm27v152 of ShiversRoom
	(properties
		picture 27152
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
		nextRoom 27151
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27153
	)
)

