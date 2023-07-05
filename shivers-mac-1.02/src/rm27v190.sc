;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27190)
(include sci.sh)
(use Main)

(public
	rm27v190 0
)

(instance rm27v190 of ShiversRoom
	(properties
		picture 27190
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27193
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nsRight 50
		nextRoom 27191
	)
)

