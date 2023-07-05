;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13285)
(include sci.sh)
(use Main)

(public
	rm13v285 0
)

(instance rm13v285 of ShiversRoom
	(properties
		picture 13350
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13284
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13282
	)
)

