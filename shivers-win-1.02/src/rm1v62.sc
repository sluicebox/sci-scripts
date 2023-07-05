;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1062)
(include sci.sh)
(use Main)

(public
	rm1v62 0
)

(instance rm1v62 of ShiversRoom
	(properties
		picture 1062
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1060
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1020
	)
)

