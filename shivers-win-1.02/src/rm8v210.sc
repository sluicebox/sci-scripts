;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8210)
(include sci.sh)
(use Main)

(public
	rm8v210 0
)

(instance rm8v210 of ShiversRoom
	(properties
		picture 8210
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8200
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8220
	)
)

