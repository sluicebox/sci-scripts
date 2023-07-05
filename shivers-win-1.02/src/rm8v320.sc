;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8320)
(include sci.sh)
(use Main)

(public
	rm8v320 0
)

(instance rm8v320 of ShiversRoom
	(properties
		picture 8320
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8300
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8330
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 8540
	)

	(method (init)
		(self createPoly: 87 143 87 121 103 91 103 6 21 6 21 143)
		(super init: &rest)
	)
)

