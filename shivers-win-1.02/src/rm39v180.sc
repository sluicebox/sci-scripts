;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39180)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use System)

(public
	rm39v180 0
)

(instance rm39v180 of ShiversRoom
	(properties
		picture 39180
	)

	(method (init)
		(ClearFlag 43)
		(door init:)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(cond
			((== newRoomNumber 39260) ; rm39v260
				(if (proc951_11 7 39000)
					(gSounds fade: 23905 82 5 16 0 0)
				else
					(gSounds fade: 23901 0 5 16 1 0)
					(gSounds fade: 23902 0 5 16 1 0)
				)
			)
			((proc951_11 7 39000)
				(gSounds fade: 23905 0 5 16 1 0)
			)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 39090
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 39190
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 39260
	)

	(method (init)
		(self createPoly: 44 143 49 45 70 24 126 0 166 13 211 45 217 143)
		(super init: &rest)
	)
)

(instance door of ShiversProp
	(properties
		priority 255
		fixPriority 1
		view 39180
		cycleSpeed 12
	)

	(method (doVerb)
		(gCurRoom setScript: sDoorOpen)
	)

	(method (init)
		(if (< global547 9)
			(= view 39181)
		)
		(self createPoly: 44 143 49 45 70 24 126 0 166 13 211 45 217 143)
		(super init: &rest)
	)
)

(instance sDoorOpen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 13908 0 82 0)
				(SetFlag 43)
				(= cycles 1)
			)
			(1
				(door setCycle: End self createPoly: -1 -1 -1 -1 -1 -1)
			)
			(2
				(efExitForward init: 3)
				(if (proc951_11 7 39000)
					(proc951_9 23905)
					(gSounds play: 23905 -1 8 0)
					(gSounds fade: 23905 58 5 16 0 0)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

