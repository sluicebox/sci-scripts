;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10340)
(include sci.sh)
(use Main)

(public
	rm10v340 0
)

(instance rm10v340 of ShiversRoom
	(properties
		picture 10340
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 2)
		(efExitRight init: 1)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10350
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10240
	)
)

