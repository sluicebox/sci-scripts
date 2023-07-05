;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7010)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm7v010 0
)

(instance rm7v010 of ShiversRoom
	(properties
		picture 7010
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if (IsFlag 8)
			(vOpenCupboard init:)
		)
		(super init: &rest)
		(if (== gPrevRoomNum 6260) ; rm6v260
			(gSounds play: 10712 0 40 0)
		)
	)

	(method (newRoom)
		(proc951_1 0)
		(super newRoom: &rest)
	)
)

(instance vOpenCupboard of View
	(properties
		priority 10
		fixPriority 1
		view 7010
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 7030
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 7020
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 7050
	)

	(method (init)
		(self createPoly: 60 61 63 92 1 118 2 140 59 141 99 98 78 87 78 63)
		(super init: &rest)
	)
)

