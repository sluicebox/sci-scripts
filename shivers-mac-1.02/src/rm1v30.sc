;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1030)
(include sci.sh)
(use Main)

(public
	rm1v30 0
)

(instance rm1v30 of ShiversRoom
	(properties
		picture 1030
	)

	(method (init)
		(gSounds fade: 10111 98 1 40 0 0)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1050
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1051
	)
)

