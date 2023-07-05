;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13247)
(include sci.sh)
(use Main)

(public
	rm13v247 0
)

(instance rm13v247 of ShiversRoom
	(properties
		picture 13450
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
		nextRoom 13248
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13249
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13255
	)

	(method (init)
		(self createPoly: 67 142 78 127 78 33 183 34 183 126 198 142)
		(super init: &rest)
	)
)

