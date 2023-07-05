;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27290)
(include sci.sh)
(use Main)

(public
	rm27v290 0
)

(instance rm27v290 of ShiversRoom
	(properties
		picture 27290
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27292
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27291
	)
)

