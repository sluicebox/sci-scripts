;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13094)
(include sci.sh)
(use Main)

(public
	rm13v094 0
)

(instance rm13v094 of ShiversRoom
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
		nextRoom 13097
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13095
	)
)

