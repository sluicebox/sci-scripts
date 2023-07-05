;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22170)
(include sci.sh)
(use Main)

(public
	rm22v170 0
)

(instance rm22v170 of ShiversRoom
	(properties
		picture 22170
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 22160
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 22280
	)
)

