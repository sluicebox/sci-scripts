;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24370)
(include sci.sh)
(use Main)
(use n951)

(public
	rm24v370 0
)

(instance rm24v370 of ShiversRoom
	(properties
		picture 24370
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (== newRoomNumber 24400) (proc951_11 1 24000)) ; rm24v400
			(proc951_9 22401)
			(gSounds play: 22401 -1 0 0)
			(gSounds fade: 22401 98 15 15 0 0)
			(gSounds fade: 22404 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 24400
	)

	(method (init)
		(self createPoly: 100 55 100 110 168 110 168 54 101 54 100 54)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24355
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24360
	)
)

