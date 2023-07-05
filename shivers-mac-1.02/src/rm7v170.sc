;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7170)
(include sci.sh)
(use Main)
(use n951)

(public
	rm7v170 0
)

(instance rm7v170 of ShiversRoom
	(properties
		picture 7170
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
		(if (proc951_11 5 7000)
			(proc951_7 20702)
			(gSounds play: 20702 -1 50 0)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (!= newRoomNumber 7180) (proc951_11 5 7000)) ; rm7v180
			(gSounds fade: 20702 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 7200
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 7160
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 7180
	)

	(method (init)
		(self createPoly: 108 85 92 102 92 140 158 141 159 90 153 85)
		(super init: &rest)
	)
)

