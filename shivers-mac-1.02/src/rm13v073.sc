;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13073)
(include sci.sh)
(use Main)

(public
	rm13v073 0
)

(instance rm13v073 of ShiversRoom
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
		nextRoom 13074
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13072
	)
)

