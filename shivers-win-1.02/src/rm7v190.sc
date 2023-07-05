;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7190)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm7v190 0
)

(instance rm7v190 of ShiversRoom
	(properties
		picture 7181
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(if (IsFlag 8)
			(vOpenCupboard init:)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (== newRoomNumber 7200) (proc951_11 5 7000)) ; rm7v200
			(gSounds fade: 20702 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance vOpenCupboard of View
	(properties
		priority 10
		fixPriority 1
		view 7190
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 7180
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 7180
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 7200
	)

	(method (init)
		(self
			createPoly: 39 12 39 84 88 101 44 142 208 142 156 99 126 82 123 11
		)
		(super init: &rest)
	)
)

