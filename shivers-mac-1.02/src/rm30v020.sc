;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30020)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm30v020 0
)

(instance rm30v020 of ShiversRoom
	(properties
		picture 30020
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
		(if (<= 29000 gPrevRoomNum 30000)
			(gCurRoom setScript: sEnter)
		)
		(if (IsFlag 43)
			(gSounds play: 13014 0 82 0)
			(ClearFlag 43)
		)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 7)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 30010
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 30010
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 30050
	)

	(method (init)
		(self createPoly: 155 50 37 50 37 140 156 140 156 50)
		(super init: &rest)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds fade: 22901 0 4 10 1 self)
			)
			(1
				(proc951_10 22901)
				(= cycles 1)
			)
			(2
				(proc951_7 23001)
				(proc951_9 23001)
				(gSounds play: 23001 -1 82 0)
				(gGame handsOn:)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

