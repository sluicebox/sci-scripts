;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13390)
(include sci.sh)
(use Main)

(public
	rm13v390 0
)

(instance rm13v390 of ShiversRoom
	(properties
		picture 13340
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13393
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13391
	)
)

