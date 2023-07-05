;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13330)
(include sci.sh)
(use Main)

(public
	rm13v330 0
)

(instance rm13v330 of ShiversRoom
	(properties
		picture 13480
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13333
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13331
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13306
	)

	(method (init)
		(self createPoly: 67 142 83 125 82 17 217 17 217 136 217 142)
		(super init: &rest)
	)
)

