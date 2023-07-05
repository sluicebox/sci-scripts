;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23030)
(include sci.sh)
(use Main)
(use n951)

(public
	rm23v030 0
)

(instance rm23v030 of ShiversRoom
	(properties
		picture 23030
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
		(if (proc951_11 5 23000)
			(proc951_9 22313)
			(gSounds play: 22313 -1 114 0)
			(gSounds fade: 22301 0 5 16 1 0)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 5 23000) (!= newRoomNumber 23070)) ; rm23v070
			(proc951_9 22301)
			(gSounds play: 22301 -1 0 0)
			(gSounds fade: 22301 82 5 16 0 0)
			(gSounds fade: 22313 0 5 16 1 0)
			(gSounds fade: 20702 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23040
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23020
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23070
	)

	(method (init)
		(self createPoly: 49 131 55 101 48 86 75 32 189 31 195 115 209 137)
		(super init: &rest)
	)
)

