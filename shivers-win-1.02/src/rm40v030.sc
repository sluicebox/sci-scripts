;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40030)
(include sci.sh)
(use Main)

(public
	rm40v030 0
)

(instance rm40v030 of ShiversRoom
	(properties
		picture 40400
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
		nextRoom 40005
	)

	(method (init)
		(self createPoly: 98 127 106 125 109 128 132 122 132 10 99 4 98 127)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 40020
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 40020
	)
)

