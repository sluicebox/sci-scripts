;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13104)
(include sci.sh)
(use Main)

(public
	rm13v104 0
)

(instance rm13v104 of ShiversRoom
	(properties
		picture 13620
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13102
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13105
	)
)

