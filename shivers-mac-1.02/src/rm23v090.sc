;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23090)
(include sci.sh)
(use Main)
(use n951)

(public
	rm23v090 0
)

(instance rm23v090 of ShiversRoom
	(properties
		picture 23090
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (proc951_11 5 23000)
			(proc951_9 22313)
			(gSounds play: 22313 -1 114 0)
			(gSounds fade: 22301 0 5 16 1 0)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 5 23000) (!= newRoomNumber 23050)) ; rm23v050
			(proc951_9 22301)
			(gSounds play: 22301 -1 0 0)
			(gSounds fade: 22301 82 5 16 0 0)
			(gSounds play: 22313 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23100
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23120
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23050
	)

	(method (init)
		(self createPoly: 106 50 156 50 156 103 200 142 75 142 106 106 106 50)
		(super init: &rest)
	)
)

