;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31440)
(include sci.sh)
(use Main)
(use n951)
(use n31001)
(use Motion)
(use Actor)
(use System)

(public
	rm31v440 0
)

(instance rm31v440 of ShiversRoom
	(properties
		picture 31440
	)

	(method (init)
		(ClearFlag 43)
		(if (IsFlag 78)
			(if (== gPrevRoomNum 31330) ; rm31v330
				(self setScript: sEnter)
			else
				(hsDoor init:)
			)
		else
			(efExitForward init: 3)
		)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 31360) ; rm31v360
			(proc31001_1)
			(gSounds fade: 23101 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 31330
	)

	(method (init)
		(if (IsFlag 78)
			(= nextRoom 31360)
			(SetFlag 43)
		)
		(self createPoly: 75 142 189 142 189 23 76 23 76 142)
		(super init: &rest)
	)
)

(instance hsDoor of HotSpot
	(properties)

	(method (init)
		(self createPoly: 75 142 189 142 189 23 76 23 76 142)
		(super init: &rest)
	)

	(method (doVerb)
		(self createPoly: -1 -1 -1 -1 -1 -1)
		(gCurRoom setScript: sEnter)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31320
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31320
	)
)

(instance pDoor of Prop
	(properties
		priority 25
		fixPriority 1
		view 31441
		cycleSpeed 18
	)

	(method (init)
		(if (IsFlag 73)
			(= view 31440)
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
				(proc951_15 6750)
				(gSounds play: 13124 0 82 self)
				(= seconds 1)
			)
			(1
				(pDoor init:)
			)
			(2
				(gSounds play: 13121 0 82 0)
				(pDoor setCycle: End self)
			)
			(3
				(gGame handsOn:)
				(efExitForward init: 3)
				(self dispose:)
			)
		)
	)
)

