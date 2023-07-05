;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1096)
(include sci.sh)
(use Main)

(public
	rm1v96 0
)

(instance rm1v96 of ShiversRoom
	(properties
		picture 1096
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1091
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1090
	)
)

