;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33290)
(include sci.sh)
(use Main)

(public
	rm33v290 0
)

(instance rm33v290 of ShiversRoom
	(properties
		picture 33290
	)

	(method (init)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 33010
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 33010
	)
)

