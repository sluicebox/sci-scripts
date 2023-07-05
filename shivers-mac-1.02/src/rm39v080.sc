;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39080)
(include sci.sh)
(use Main)

(public
	rm39v080 0
)

(instance rm39v080 of ShiversRoom
	(properties
		picture 39080
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 39050
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 39070
	)
)

(instance efForward of ExitFeature
	(properties
		nextRoom 39110
	)

	(method (init)
		(self createPoly: 152 107 144 120 64 118 51 54 117 53 153 55)
		(super init: &rest)
	)
)

