;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16020)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm16v20 0
)

(instance rm16v20 of ShiversRoom
	(properties
		picture 16020
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (< gPrevRoomNum 1000) ; rm1v00
			(ClearFlag 43)
		)
		(hsDoor init:)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (< 1000 newRoomNumber 16000) ; rm1v00, rm16v00
			(gSounds fade: 21602 0 6 6 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16010
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16030
	)
)

(instance efExitForward of ExitFeature
	(properties
		nsLeft 70
		nsTop 42
		nsRight 196
		nsBottom 143
		nextRoom 9680
	)
)

(instance hsDoor of HotSpot
	(properties
		nsLeft 70
		nsTop 42
		nsRight 196
		nsBottom 143
	)

	(method (doVerb)
		(gCurRoom setScript: sOpenDoor)
	)
)

(instance pDoor of Prop
	(properties
		view 16020
		cycleSpeed 12
	)
)

(instance sOpenDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(hsDoor dispose:)
				(pDoor init: setPri: 25 1 setCycle: End)
				(gSounds play: 11601 0 82 self)
			)
			(1
				(efExitForward init: 3)
				(SetFlag 43)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

