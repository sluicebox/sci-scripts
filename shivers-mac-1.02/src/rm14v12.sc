;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14120)
(include sci.sh)
(use Main)
(use n951)

(public
	rm14v12 0
)

(instance rm14v12 of ShiversRoom
	(properties
		picture 14120
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitCamera init: 9)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 3 14000) (> newRoomNumber 14120)) ; rm14v12
			(gSounds fade: 21402 0 5 16 1 0)
			(proc951_9 21401)
			(gSounds play: 21401 -1 34 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 14090
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 14110
	)
)

(instance efExitCamera of ExitFeature
	(properties
		nextRoom 14160
	)

	(method (init)
		(self
			createPoly: 106 119 106 88 87 84 86 53 92 26 112 26 112 44 170 61 170 124
		)
		(super init: &rest)
	)
)

