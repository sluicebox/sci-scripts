;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13259)
(include sci.sh)
(use Main)

(public
	rm13v259 0
)

(instance rm13v259 of ShiversRoom
	(properties
		picture 13360
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13258
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13261
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13263
	)

	(method (init)
		(self createPoly: 47 142 103 95 103 48 149 48 149 95 175 142)
		(super init: &rest)
	)
)

