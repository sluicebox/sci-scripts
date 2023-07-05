;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13001)
(include sci.sh)
(use Main)

(public
	rm13v001 0
)

(instance rm13v001 of ShiversRoom
	(properties
		picture 13000
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13000
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13000
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13519
	)

	(method (init)
		(self createPoly: 55 143 109 1 153 1 212 143)
		(super init: &rest)
	)
)

