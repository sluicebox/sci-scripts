;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3100)
(include sci.sh)
(use Main)

(public
	rm3v100 0
)

(instance rm3v100 of ShiversRoom
	(properties
		picture 3100
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
		nextRoom 3080
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3090
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 3110
	)

	(method (init)
		(self createPoly: 155 145 60 65 144 57 266 124 266 127 232 134)
		(super init: &rest)
	)
)

