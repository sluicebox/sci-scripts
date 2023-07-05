;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1490)
(include sci.sh)
(use Main)

(public
	rm1v490 0
)

(instance rm1v490 of ShiversRoom
	(properties
		picture 1490
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1480
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1502
	)

	(method (init)
		(self
			createPoly: 17 142 92 95 92 67 160 67 161 95 177 85 177 110 216 142
		)
		(super init: &rest)
	)
)

