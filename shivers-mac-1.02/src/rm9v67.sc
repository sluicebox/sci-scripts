;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9670)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use System)

(public
	rm9v67 0
)

(instance rm9v67 of ShiversRoom
	(properties
		picture 9670
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(hsDoorHandle init:)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 1551) ; rm1v551
			(gSounds fade: 20903 0 5 16 0 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9660
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9660
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 9670
	)

	(method (init)
		(self createPoly: 44 143 30 1 233 1 215 141)
		(super init: &rest)
	)
)

(instance hsDoorHandle of ShiversProp
	(properties
		view 9670
	)

	(method (init)
		(self setPri: 100 1)
		(super init:)
	)

	(method (doVerb)
		(self setScript: sJiggle)
	)
)

(instance sJiggle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds stop: 10916)
				(hsDoorHandle cel: 0)
				(self cue:)
			)
			(1
				(gSounds play: 10916 0 90 0)
				(hsDoorHandle setCycle: End self)
			)
			(2
				(hsDoorHandle setCycle: Beg self)
			)
			(3
				(if (IsFlag 87)
					(gCurRoom newRoom: 1551) ; rm1v551
				)
				(= cycles 1)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

