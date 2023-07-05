;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23690)
(include sci.sh)
(use Main)
(use n951)

(public
	rm23v690 0
)

(instance rm23v690 of ShiversRoom
	(properties
		picture 23690
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
		(if (== gPrevRoomNum 24760) ; rm24v760
			(proc951_7 22301)
			(proc951_9 22301)
			(gSounds play: 22301 -1 0 0)
			(gSounds fade: 22301 82 5 8 0 0)
		)
		(if (IsFlag 43)
			(gSounds play: 12316 0 90 0)
			(ClearFlag 43)
		)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 1)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23630
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23610
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23620
	)

	(method (init)
		(self createPoly: 64 1 200 1 200 142 64 142 64 1)
		(super init: &rest)
	)
)

