;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37111)
(include sci.sh)
(use Main)

(public
	rm37v111 0
)

(instance rm37v111 of ShiversRoom
	(properties
		picture 37111
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37120
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37110
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 37080
	)

	(method (init)
		(self
			createPoly: 172 115 160 122 85 124 88 70 114 70 117 49 143 40 172 35
		)
		(super init: &rest)
	)
)

