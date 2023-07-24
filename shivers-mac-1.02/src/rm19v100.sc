;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19100)
(include sci.sh)
(use Main)
(use n951)

(public
	rm19v100 0
)

(instance rm19v100 of ShiversRoom
	(properties
		picture 19100
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(efExitSand init: 9)
		(super init: &rest)
		(if (proc951_11 8 19000)
			(gSounds play: 21910 -1 42 0)
		)
	)

	(method (newRoom newRoomNumber)
		(if (<= newRoomNumber 19110) ; rm19v110
			(gSounds fade: 21910 0 15 8 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 19090
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 19110
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 19260
	)

	(method (init)
		(self
			createPoly: 49 145 94 116 96 90 117 49 137 45 154 47 169 58 168 128 196 145
		)
		(super init: &rest)
	)
)

(instance efExitSand of ExitFeature
	(properties
		nextRoom 19250
	)

	(method (init)
		(self createPoly: 32 141 31 107 31 106 36 100 80 114)
		(super init: &rest)
	)
)

