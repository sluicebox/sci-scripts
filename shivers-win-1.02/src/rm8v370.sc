;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8370)
(include sci.sh)
(use Main)

(public
	rm8v370 0
)

(instance rm8v370 of ShiversRoom
	(properties
		picture 8370
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8410
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8380
	)
)

