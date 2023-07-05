;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13455)
(include sci.sh)
(use Main)

(public
	rm13v455 0
)

(instance rm13v455 of ShiversRoom
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
		nextRoom 13456
	)
)

(instance efExitRight of ExitFeature
	(properties
		nsLeft 228
		nextRoom 13457
	)
)

