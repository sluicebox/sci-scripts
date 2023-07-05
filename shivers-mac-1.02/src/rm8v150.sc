;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8150)
(include sci.sh)
(use Main)
(use n951)

(public
	rm8v150 0
)

(instance rm8v150 of ShiversRoom
	(properties
		picture 8150
	)

	(method (init)
		(if (proc951_11 1 8000)
			(proc951_7 20803)
			(proc951_9 20803)
			(gSounds play: 20803 -1 50 0)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 1 8000) (!= newRoomNumber 8160)) ; rm8v160
			(gSounds fade: 20803 0 5 8 0 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8140
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8170
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 8160
	)

	(method (init)
		(self createPoly: 94 133 94 0 176 0 176 132)
		(super init: &rest)
	)
)

