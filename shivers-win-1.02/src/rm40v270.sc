;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40270)
(include sci.sh)
(use Main)

(public
	rm40v270 0
)

(instance rm40v270 of ShiversRoom
	(properties
		picture 40320
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 40290
	)

	(method (init)
		(self
			createPoly: 42 142 63 113 62 14 126 20 129 82 157 86 180 99 207 122 207 142 42 142
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 40260
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 40280
	)
)

