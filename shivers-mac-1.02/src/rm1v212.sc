;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1212)
(include sci.sh)
(use Main)

(public
	rm1v212 0
)

(instance rm1v212 of ShiversRoom
	(properties
		picture 1212
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1210
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1202
	)
)

