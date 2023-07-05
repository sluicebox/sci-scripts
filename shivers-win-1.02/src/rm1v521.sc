;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1521)
(include sci.sh)
(use Main)

(public
	rm1v521 0
)

(instance rm1v521 of ShiversRoom
	(properties
		picture 1521
	)

	(method (init)
		(gSounds stop: 30110)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1520
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1520
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1511
	)

	(method (init)
		(self
			createPoly: 1 142 1 130 80 123 78 87 169 87 169 120 252 127 261 139
		)
		(super init: &rest)
	)
)

