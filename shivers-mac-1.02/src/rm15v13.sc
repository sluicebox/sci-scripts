;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15130)
(include sci.sh)
(use Main)

(public
	rm15v13 0
)

(instance rm15v13 of ShiversRoom
	(properties
		picture 15130
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nsRight 52
		nextRoom 15140
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 15110
	)
)

