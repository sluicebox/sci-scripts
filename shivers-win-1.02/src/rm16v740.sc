;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16740)
(include sci.sh)
(use Main)

(public
	rm16v740 0
)

(instance rm16v740 of ShiversRoom
	(properties
		picture 16740
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16330
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16310
	)
)

