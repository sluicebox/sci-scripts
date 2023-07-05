;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13186)
(include sci.sh)
(use Main)

(public
	rm13v186 0
)

(instance rm13v186 of ShiversRoom
	(properties
		picture 13600
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(efExitForwardRight init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13189
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13187
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13190
	)

	(method (init)
		(self createPoly: 62 143 71 133 71 12 182 12 182 133 194 142)
		(super init: &rest)
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 13214
	)

	(method (init)
		(self createPoly: 196 142 183 132 183 12 237 0 237 142)
		(super init: &rest)
	)
)

