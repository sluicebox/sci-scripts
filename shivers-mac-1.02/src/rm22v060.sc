;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22060)
(include sci.sh)
(use Main)

(public
	rm22v060 0
)

(instance rm22v060 of ShiversRoom
	(properties
		picture 22060
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 22090
	)

	(method (init)
		(self createPoly: 93 45 29 92 29 142 203 142 203 85 167 46 94 45)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 22080
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 22050
	)
)

