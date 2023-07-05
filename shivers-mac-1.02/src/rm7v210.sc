;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7210)
(include sci.sh)
(use Main)

(public
	rm7v210 0
)

(instance rm7v210 of ShiversRoom
	(properties
		picture 7210
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 7110
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 7400
	)
)

