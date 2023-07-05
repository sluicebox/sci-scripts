;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23070)
(include sci.sh)
(use Main)
(use n951)

(public
	rm23v070 0
)

(instance rm23v070 of ShiversRoom
	(properties
		picture 23070
	)

	(method (init)
		(if (proc951_11 5 23000)
			(gSounds fade: 32350 0 6 16 1 0)
		else
			(gSounds fade: 32350 66 6 6 0 0)
		)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 5 23000) (>= newRoomNumber 23090)) ; rm23v090
			(proc951_9 22301)
			(gSounds play: 22301 -1 0 0)
			(gSounds fade: 22301 82 5 16 0 0)
			(gSounds fade: 22313 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23080
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23060
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23110
	)

	(method (init)
		(self createPoly: 64 1 200 1 200 142 64 142 64 1)
		(super init: &rest)
	)
)

