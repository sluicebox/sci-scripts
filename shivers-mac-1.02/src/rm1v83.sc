;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1083)
(include sci.sh)
(use Main)

(public
	rm1v83 0
)

(instance rm1v83 of ShiversRoom
	(properties
		picture 1083
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1081
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1080
	)
)

