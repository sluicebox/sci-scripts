;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10150)
(include sci.sh)
(use Main)

(public
	rm10v150 0
)

(instance rm10v150 of ShiversRoom
	(properties
		picture 10150
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 2)
		(efExitRight init: 1)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10160
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10420
	)
)

