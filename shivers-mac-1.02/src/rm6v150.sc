;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6150)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm6v150 0
)

(local
	local0
)

(instance rm6v150 of ShiversRoom
	(properties
		picture 6150
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(hsDoor init:)
		(= local0 0)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and local0 (or (== newRoomNumber 6140) (== newRoomNumber 6120))) ; rm6v140, rm6v120
			(gSounds play: 10614 0 40 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 6120
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 6140
	)
)

(instance efExitDoor of ExitFeature
	(properties
		nextRoom 6290
	)

	(method (init)
		(self createPoly: 95 143 95 34 172 34 172 143)
		(super init: &rest)
	)
)

(instance pDoor of Prop
	(properties
		priority 25
		fixPriority 1
		view 6150
		cycleSpeed 18
	)
)

(instance hsDoor of HotSpot
	(properties)

	(method (init)
		(self createPoly: 95 143 95 34 172 34 172 143)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom setScript: sDoorOpens)
	)
)

(instance sDoorOpens of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(pDoor init:)
				(proc951_7 10613)
				(= cycles 1)
			)
			(1
				(pDoor setCycle: End)
				(gSounds play: 10613 0 40 self)
			)
			(2
				(gGame handsOn:)
				(efExitDoor init: 3)
				(= local0 1)
				(hsDoor dispose:)
				(self dispose:)
			)
		)
	)
)

