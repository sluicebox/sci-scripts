;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3040)
(include sci.sh)
(use Main)

(public
	rm3v040 0
)

(instance rm3v040 of ShiversRoom
	(properties
		picture 3040
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 3050
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3070
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 3010
	)

	(method (init)
		(self
			createPoly:
				89
				109
				90
				54
				101
				42
				116
				35
				128
				35
				140
				40
				151
				51
				153
				61
				153
				112
		)
		(super init: &rest)
	)
)

