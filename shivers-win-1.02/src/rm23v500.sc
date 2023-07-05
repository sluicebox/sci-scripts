;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23500)
(include sci.sh)
(use Main)
(use n951)

(public
	rm23v500 0
)

(instance rm23v500 of ShiversRoom
	(properties
		picture 23500
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
		(gSounds fade: 22310 0 15 15 1 0)
		(proc951_7 22301)
		(proc951_9 22301)
		(gSounds play: 22301 -1 0 0)
		(gSounds fade: 22301 82 15 8 0 0)
	)

	(method (newRoom newRoomNumber)
		(if (> newRoomNumber 1000) ; rm1v00
			(gSounds stop: 22310)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23510
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23510
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23480
	)

	(method (init)
		(self createPoly: 81 137 111 97 111 55 149 55 150 94 179 137 83 137)
		(super init: &rest)
	)
)

