;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9680)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm9v68 0
)

(instance rm9v68 of ShiversRoom
	(properties
		picture 9680
	)

	(method (init)
		(if (IsFlag 43)
			(gSounds play: 11602 0 82 0)
			(ClearFlag 43)
		)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
		(if (== gPrevRoomNum 16020) ; rm16v20
			(gCurRoom setScript: sEnter)
		)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 6)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9690
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9690
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9310
	)

	(method (init)
		(self createPoly: 43 128 79 99 83 60 192 60 196 96 232 126)
		(super init: &rest)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds fade: 21602 0 1 30 1 self)
			)
			(1
				(proc951_10 21602)
				(= cycles 1)
			)
			(2
				(proc951_9 20903)
				(gSounds play: 20903 -1 0 0)
				(gSounds fade: 20903 42 1 30 0 0)
				(gGame handsOn:)
			)
			(3
				(self dispose:)
			)
		)
	)
)

