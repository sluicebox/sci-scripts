;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1291)
(include sci.sh)
(use Main)

(public
	rm1v291 0
)

(instance rm1v291 of ShiversRoom
	(properties
		picture 1291
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1290
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1290
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1281
	)

	(method (init)
		(self
			createPoly:
				37
				141
				63
				110
				63
				50
				190
				50
				190
				110
				226
				131
				226
				141
				37
				141
		)
		(super init: &rest)
	)
)

