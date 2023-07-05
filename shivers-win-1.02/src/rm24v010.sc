;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24010)
(include sci.sh)
(use Main)
(use n951)

(public
	rm24v010 0
)

(instance rm24v010 of ShiversRoom
	(properties
		picture 24010
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(if (proc951_11 5 24000)
			(gSounds fade: 22403 0 6 30 1 0)
			(proc951_9 22404)
			(gSounds play: 22404 -1 50 0)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 24180) ; rm24v180
			(gSounds fade: 22403 0 6 30 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 24180
	)

	(method (init)
		(self createPoly: 104 51 104 137 156 137 156 51 104 51)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24060
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24090
	)
)

