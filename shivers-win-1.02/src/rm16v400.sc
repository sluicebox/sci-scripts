;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16400)
(include sci.sh)
(use Main)

(public
	rm16v400 0
)

(instance rm16v400 of ShiversRoom
	(properties
		picture 16400
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16410
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16420
	)
)

