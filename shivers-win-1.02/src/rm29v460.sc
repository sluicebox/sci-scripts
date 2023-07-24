;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29460)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm29v460 0
)

(instance rm29v460 of ShiversRoom
	(properties
		picture 29460
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(if (IsFlag 43)
			(gSounds play: 13014 0 82 0)
			(ClearFlag 43)
		)
		(super init: &rest)
		(if (== gPrevRoomNum 30010) ; rm30v010
			(gCurRoom setScript: sEnter)
		)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 7)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 29450
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 29450
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 29010
	)

	(method (init)
		(self
			createPoly: 102 130 106 58 112 45 125 36 138 37 151 45 156 58 161 130 102 130
		)
		(super init: &rest)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds stop: 33050)
				(gSounds fade: 23001 0 15 8 1 self)
			)
			(1
				(proc951_10 23001)
				(= cycles 1)
			)
			(2
				(proc951_9 22901)
				(gSounds play: 22901 -1 90 0)
				(gGame handsOn:)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

