;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27012)
(include sci.sh)
(use Main)
(use n951)

(public
	rm27v012 0
)

(instance rm27v012 of ShiversRoom
	(properties
		picture 27012
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)

	(method (newRoom)
		(proc951_1 5)
		(super newRoom: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27011
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nsRight 50
		nextRoom 27013
	)
)

