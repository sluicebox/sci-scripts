;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23080)
(include sci.sh)
(use Main)

(public
	rm23v080 0
)

(instance rm23v080 of ShiversRoom
	(properties
		picture 23080
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23050
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23070
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23140
	)

	(method (init)
		(self
			createPoly: 126 11 125 33 106 48 83 116 83 132 219 132 219 110 192 94 182 45 170 39 168 9 127 9
		)
		(super init: &rest)
	)
)

