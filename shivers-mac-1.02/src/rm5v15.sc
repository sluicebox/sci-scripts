;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5150)
(include sci.sh)
(use Main)

(public
	rm5v15 0
)

(instance rm5v15 of ShiversRoom
	(properties
		picture 5020
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 5110
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 5130
	)
)

