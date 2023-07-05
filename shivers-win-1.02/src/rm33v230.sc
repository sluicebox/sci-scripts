;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33230)
(include sci.sh)
(use Main)

(public
	rm33v230 0
)

(instance rm33v230 of ShiversRoom
	(properties
		picture 33230
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 33130
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 33220
	)
)

