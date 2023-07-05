;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13064)
(include sci.sh)
(use Main)

(public
	rm13v064 0
)

(instance rm13v064 of ShiversRoom
	(properties
		picture 13660
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nsRight 29
		nextRoom 13062
	)
)

(instance efExitRight of ExitFeature
	(properties
		nsLeft 228
		nextRoom 13063
	)
)

