;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32450)
(include sci.sh)
(use Main)
(use n951)
(use n32001)
(use Motion)
(use Actor)
(use System)

(public
	rm32v450 0
)

(local
	local0
)

(instance rm32v450 of ShiversRoom
	(properties
		picture 32450
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(hsDoor init:)
		(super init: &rest)
		(if (and (IsFlag 43) (== gPrevRoomNum 32460)) ; rm32v460
			(gSounds play: 13202 0 82 0)
			(ClearFlag 43)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 31020) ; rm31v020
			(proc32001_1)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32460
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32670
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 31020
	)

	(method (init)
		(self createPoly: 170 139 170 42 100 42 100 139 169 139)
		(super init: &rest)
	)
)

(instance pDoor of Prop
	(properties
		view 32450
		cycleSpeed 18
	)
)

(instance hsDoor of HotSpot
	(properties)

	(method (init)
		(self createPoly: 89 30 184 30 184 143 88 143 88 30)
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
				(pDoor init: setPri: 25 1)
				(= cycles 1)
			)
			(1
				(gSounds play: 13217 0 82 0)
				(pDoor setCycle: End self)
			)
			(2
				(gGame handsOn:)
				(efExitForward init: 3)
				(= local0 1)
				(SetFlag 43)
				(hsDoor dispose:)
				(self dispose:)
			)
		)
	)
)

