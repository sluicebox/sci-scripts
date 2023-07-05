;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1320)
(include sci.sh)
(use Main)

(public
	rm1v320 0
)

(instance rm1v320 of ShiversRoom
	(properties
		picture 1320
	)

	(method (init)
		(efExitForward init: 9)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1330
	)

	(method (init)
		(self
			createPoly: 0 110 58 105 58 33 167 33 167 104 235 109 254 141 1 141
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1311
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1311
	)
)

