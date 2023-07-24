;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23300)
(include sci.sh)
(use Main)
(use n951)

(public
	rm23v300 0
)

(instance rm23v300 of ShiversRoom
	(properties
		picture 23300
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
		(if (IsFlag 43)
			(gSounds stop: 12310)
			(gSounds play: 12311 0 90 0)
			(ClearFlag 43)
		)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 1)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23310
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23290
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23260
	)

	(method (init)
		(self
			createPoly: 54 128 72 124 72 65 170 66 180 123 215 125 215 135 54 135 54 129
		)
		(super init: &rest)
	)
)

