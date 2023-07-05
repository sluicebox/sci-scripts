;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19080)
(include sci.sh)
(use Main)
(use n951)

(public
	rm19v080 0
)

(instance rm19v080 of ShiversRoom
	(properties
		picture 19080
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(efExitSand init: 9)
		(if (proc951_11 8 19000)
			(gSounds play: 21910 -1 42 0)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (<= newRoomNumber 19100) ; rm19v100
			(gSounds fade: 21910 0 15 8 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 19070
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 19050
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 19280
	)

	(method (init)
		(self
			createPoly: 82 143 98 69 110 60 154 58 149 73 146 92 174 99 180 143
		)
		(super init: &rest)
	)
)

(instance efExitSand of ExitFeature
	(properties
		nextRoom 19250
	)

	(method (init)
		(self createPoly: 174 94 219 75 237 75 259 80 259 110)
		(super init: &rest)
	)
)

