;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13189)
(include sci.sh)
(use Main)

(public
	rm13v189 0
)

(instance rm13v189 of ShiversRoom
	(properties
		picture 13770
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
		nextRoom 13187
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13186
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13185
	)

	(method (init)
		(self createPoly: 64 142 104 97 104 47 157 47 157 100 193 142)
		(super init: &rest)
	)
)

