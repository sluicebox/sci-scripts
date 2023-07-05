;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37350)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm37v350 0
)

(instance rm37v350 of ShiversRoom
	(properties
		picture 37350
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
		(if (== gPrevRoomNum 38010) ; rm38v010
			(self setScript: sEnter)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37340
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37320
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 37360
	)

	(method (init)
		(self createPoly: 60 71 4 71 4 24 61 24)
		(super init: &rest)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 6)
					(gSounds play: 10407 0 90 0)
				else
					(gSounds play: 10503 0 90 0)
				)
				(= cycles 1)
			)
			(1
				(= seconds 2)
			)
			(2
				(proc951_9 23701)
				(gSounds play: 23701 -1 74 0)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

