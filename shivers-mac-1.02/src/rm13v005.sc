;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13005)
(include sci.sh)
(use Main)

(public
	rm13v005 0
)

(instance rm13v005 of ShiversRoom
	(properties
		picture 13050
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13004
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13007
	)
)

