;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13267)
(include sci.sh)
(use Main)

(public
	rm13v267 0
)

(instance rm13v267 of ShiversRoom
	(properties
		picture 13400
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13265
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13264
	)
)

