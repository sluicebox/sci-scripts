;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13471)
(include sci.sh)
(use Main)

(public
	rm13v471 0
)

(instance rm13v471 of ShiversRoom
	(properties
		picture 13560
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13472
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13470
	)
)

