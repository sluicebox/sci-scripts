;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16200)
(include sci.sh)
(use Main)

(public
	rm16v200 0
)

(instance rm16v200 of ShiversRoom
	(properties
		picture 16200
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 1)
		(efStairs init: 2)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16190
	)

	(method (init)
		(self createPoly: 0 90 20 88 20 143 0 143)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16190
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16180
	)

	(method (init)
		(self
			createPoly: 103 143 103 80 102 66 93 64 93 0 221 0 212 92 167 111 164 143
		)
		(super init: &rest)
	)
)

(instance efStairs of ExitFeature
	(properties
		nextRoom 16620
	)

	(method (init)
		(self createPoly: 82 80 78 69 83 63 92 63 92 0 0 0 0 90)
		(super init: &rest)
	)
)

