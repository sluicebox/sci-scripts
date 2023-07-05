;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21170)
(include sci.sh)
(use Main)
(use n951)

(public
	rm21v170 0
)

(instance rm21v170 of ShiversRoom
	(properties
		picture 21170
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(if (proc951_11 4 21000)
			(gSounds fade: 22101 0 5 16 1 0)
			(proc951_9 22102)
			(gSounds play: 22102 -1 50 0)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 4 21000) (!= newRoomNumber 21390)) ; rm21v390
			(gSounds fade: 22102 0 5 16 1 0)
			(proc951_9 22101)
			(gSounds play: 22101 -1 0 0)
			(gSounds fade: 22101 98 5 16 0 0)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21160
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21190
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 21390
	)

	(method (init)
		(self createPoly: 82 142 124 35 163 35 207 144 83 144)
		(super init: &rest)
	)
)

