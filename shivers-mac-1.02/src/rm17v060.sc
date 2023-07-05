;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17060)
(include sci.sh)
(use Main)

(public
	rm17v060 0
)

(instance rm17v060 of ShiversRoom
	(properties
		picture 17060
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 17050
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 17050
	)
)

