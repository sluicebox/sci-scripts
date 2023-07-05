;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8140)
(include sci.sh)
(use Main)
(use n951)

(public
	rm8v140 0
)

(instance rm8v140 of ShiversRoom
	(properties
		picture 8140
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(efExitDoor init: 3)
		(super init: &rest)
		(if (proc951_11 1 8000)
			(if (!= gPrevRoomNum 8160) ; rm8v160
				(gSounds stop: 20803)
			)
			(proc951_7 20803)
			(proc951_9 20803)
			(gSounds play: 20803 -1 50 0)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 1 8000) (!= newRoomNumber 8160)) ; rm8v160
			(gSounds fade: 20803 0 5 8 1 0)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8120
	)

	(method (init)
		(self createPoly: 0 0 37 0 37 26 1 26 1 132 33 132 33 143 0 143 0 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8160
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 8080
	)

	(method (init)
		(self createPoly: 52 142 52 49 224 49 224 141)
		(super init: &rest)
	)
)

(instance efExitDoor of ExitFeature
	(properties
		nextRoom 8030
	)

	(method (init)
		(self createPoly: 2 28 34 29 39 127 1 127 1 28)
		(super init: &rest)
	)
)

