;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13137)
(include sci.sh)
(use Main)

(public
	rm13v137 0
)

(instance rm13v137 of ShiversRoom
	(properties
		picture 13420
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
		nextRoom 13138
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13139
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13031
	)

	(method (init)
		(self createPoly: 70 142 79 131 79 28 187 28 187 130 197 142)
		(super init: &rest)
	)
)

