;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23320)
(include sci.sh)
(use Main)

(public
	rm23v320 0
)

(instance rm23v320 of ShiversRoom
	(properties
		picture 23320
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23340
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23340
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23290
	)

	(method (init)
		(self
			createPoly: 158 36 158 117 168 135 82 135 96 120 96 38 95 35 157 35
		)
		(super init: &rest)
	)
)

