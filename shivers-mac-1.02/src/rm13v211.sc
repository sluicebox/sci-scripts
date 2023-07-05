;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13211)
(include sci.sh)
(use Main)

(public
	rm13v211 0
)

(instance rm13v211 of ShiversRoom
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
		nextRoom 13212
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13210
	)
)

