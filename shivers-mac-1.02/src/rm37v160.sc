;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37160)
(include sci.sh)
(use Main)
(use n951)

(public
	rm37v160 0
)

(instance rm37v160 of ShiversRoom
	(properties
		picture 37160
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(if (proc951_11 9 37000)
			(gSounds fade: 23701 0 5 16 1 0)
			(proc951_9 23702)
			(gSounds play: 23702 -1 66 0)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 9 37000) (!= newRoomNumber 37280)) ; rm37v280
			(gSounds fade: 23702 0 5 16 1 0)
			(proc951_9 23701)
			(gSounds stop: 23701)
			(gSounds play: 23701 -1 74 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37150
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37130
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 37280
	)

	(method (init)
		(self createPoly: 170 137 165 94 174 93 176 70 142 40 90 41 86 137)
		(super init: &rest)
	)
)

