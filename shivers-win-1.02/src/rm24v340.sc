;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24340)
(include sci.sh)
(use Main)

(public
	rm24v340 0
)

(instance rm24v340 of ShiversRoom
	(properties
		picture 24340
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24350
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24330
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 24400
	)

	(method (init)
		(self
			createPoly: 121 123 64 126 84 105 75 105 73 56 133 56 133 98 121 99
		)
		(super init: &rest)
	)
)

