;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9090)
(include sci.sh)
(use Main)
(use n951)

(public
	rm9v09 0
)

(instance rm9v09 of ShiversRoom
	(properties
		picture 9090
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efPole init: 3)
		(efMasks init: 3)
		(efDoor init: 3)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 9)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9080
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9100
	)
)

(instance efDoor of ExitFeature
	(properties
		nextRoom 9470
	)

	(method (init)
		(self createPoly: 167 92 167 22 242 22 240 92)
		(super init: &rest)
	)
)

(instance efMasks of ExitFeature
	(properties
		nextRoom 9040
	)

	(method (init)
		(self createPoly: 84 132 21 132 21 0 88 0)
		(super init: &rest)
	)
)

(instance efPole of ExitFeature
	(properties
		nextRoom 9070
	)

	(method (init)
		(self
			createPoly: 84 133 89 0 130 1 130 53 136 59 146 73 158 84 164 96 162 98 157 99 151 86 140 78 131 69 130 72 129 129 123 132 112 135 94 135
		)
		(super init: &rest)
	)
)

