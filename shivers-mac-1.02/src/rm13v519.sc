;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13519)
(include sci.sh)
(use Main)
(use n951)

(public
	rm13v519 0
)

(instance rm13v519 of ShiversRoom
	(properties
		picture 13940
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 8)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13518
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13518
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13521
	)

	(method (init)
		(self
			createPoly:
				58
				55
				25
				88
				25
				143
				236
				143
				236
				91
				199
				53
				183
				15
				87
				15
				58
				55
		)
		(super init: &rest)
	)
)

