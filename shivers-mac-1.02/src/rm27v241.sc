;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27241)
(include sci.sh)
(use Main)

(public
	rm27v241 0
)

(instance rm27v241 of ShiversRoom
	(properties
		picture 27241
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
		nextRoom 27240
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nsRight 50
		nextRoom 27242
	)
)

