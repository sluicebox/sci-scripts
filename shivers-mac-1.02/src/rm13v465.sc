;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13465)
(include sci.sh)
(use Main)

(public
	rm13v465 0
)

(instance rm13v465 of ShiversRoom
	(properties
		picture 13510
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13464
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13467
	)
)

