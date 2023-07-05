;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9620)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm9v62 0
)

(instance rm9v62 of ShiversRoom
	(properties
		picture 9620
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
		(cond
			((== gPrevRoomNum 15260) ; rm15v26
				(gCurRoom setScript: sEnter)
				(ClearFlag 43)
			)
			((IsFlag 43)
				(gSounds play: 11503 0 82 0)
				(ClearFlag 43)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 6)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9630
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9870
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9170
	)

	(method (init)
		(self createPoly: 33 141 53 82 141 82 167 142)
		(super init: &rest)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds fade: 21501 0 1 30 1 self)
				(gSounds play: 11503 0 98 0)
			)
			(1
				(proc951_10 21501)
				(= cycles 1)
			)
			(2
				(proc951_7 20903)
				(proc951_9 20903)
				(gSounds play: 20903 -1 0 0)
				(gSounds fade: 20903 42 15 5 0 0)
				(gGame handsOn:)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

