;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40180)
(include sci.sh)
(use Main)

(public
	rm40v180 0
)

(instance rm40v180 of ShiversRoom
	(properties
		picture 40020
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 40200
	)

	(method (init)
		(self createPoly: 57 127 223 127 171 94 132 83 116 1 58 1 58 127)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 40190
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 40190
	)
)

