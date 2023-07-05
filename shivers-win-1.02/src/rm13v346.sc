;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13346)
(include sci.sh)
(use Main)

(public
	rm13v346 0
)

(instance rm13v346 of ShiversRoom
	(properties
		picture 13560
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13349
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13347
	)
)

