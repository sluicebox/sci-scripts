;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20060)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm20v060 0
)

(instance rm20v060 of ShiversRoom
	(properties
		picture 20060
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
		(if (== gPrevRoomNum 9570) ; rm9v57
			(gSounds play: 12020 0 82 0)
			(gCurRoom setScript: sEnter)
		)
	)

	(method (newRoom)
		(proc951_1 0)
		(super newRoom: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 20080
	)

	(method (init)
		(self createPoly: 73 24 57 24 57 128 212 128 213 24 73 24)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20020
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20010
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds fade: 20903 0 1 30 1 self)
			)
			(1
				(proc951_10 20903)
				(= cycles 1)
			)
			(2
				(proc951_9 22001)
				(gSounds play: 22001 -1 0 0)
				(gSounds fade: 22001 98 1 30 0 0)
				(gGame handsOn:)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

