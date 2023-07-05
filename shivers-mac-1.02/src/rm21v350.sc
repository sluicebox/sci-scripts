;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21350)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use System)

(public
	rm21v350 0
)

(local
	local0
)

(instance rm21v350 of ShiversRoom
	(properties
		picture 21350
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(spDoorButton init:)
		(spDoor init:)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (<= 1000 newRoomNumber 21000) ; rm1v00
			(gSounds fade: 22101 0 5 16 1 0)
			(gSounds fade: 22101 0 5 16 1 0)
			(gSounds fade: 22512 0 5 16 1 0)
		)
		(proc951_1 2)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21360
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21360
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 20320
	)

	(method (init)
		(self createPoly: 121 42 164 42 164 121 122 121 121 43)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)
)

(instance spDoorButton of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 21351
	)

	(method (init)
		(self createPoly: 197 70 204 70 204 75 196 75 196 70)
		(super init: &rest)
	)

	(method (doVerb)
		(if (and (IsFlag 18) (not local0))
			(self setScript: sDoorOpen)
		)
	)
)

(instance spDoor of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 21350
		cycleSpeed 36
	)
)

(instance sDoorOpen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 43)
				(spDoorButton setCycle: End)
				(gSounds play: 12001 0 82 0)
				(spDoor setCycle: End self)
			)
			(1
				(= local0 1)
				(spDoorButton setCycle: Beg)
				(efExitForward init: 3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

