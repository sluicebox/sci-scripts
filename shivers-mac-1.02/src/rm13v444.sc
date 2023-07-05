;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13444)
(include sci.sh)
(use Main)

(public
	rm13v444 0
)

(instance rm13v444 of ShiversRoom
	(properties
		picture 13720
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13447
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13445
	)
)

