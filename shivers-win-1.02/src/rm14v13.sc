;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14130)
(include sci.sh)
(use Main)

(public
	rm14v13 0
)

(instance rm14v13 of ShiversRoom
	(properties
		picture 14130
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 14140
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 14160
	)
)

