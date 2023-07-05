;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26310)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use System)

(public
	rm26v310 0
)

(local
	local0
)

(instance rm26v310 of ShiversRoom
	(properties
		picture 26310
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(spDoor init:)
		(spRags init:)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(cond
			((== newRoomNumber 25010) ; rm25v1
				(gSounds fade: 22601 0 4 15 1 0)
			)
			(local0
				(gSounds play: 12501 0 82 0)
			)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 26300
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 26280
	)
)

(instance efExitForward of ExitFeature
	(properties
		nsLeft 95
		nsTop 3
		nsRight 183
		nsBottom 143
		nextRoom 25010
	)

	(method (init)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)
)

(instance spRags of ShiversProp
	(properties
		priority 26
		fixPriority 1
		view 26310
		loop 1
		cycleSpeed 10
	)
)

(instance spDoor of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 26310
		cycleSpeed 10
	)

	(method (init)
		(self createPoly: 105 11 105 142 172 142 172 11 105 11)
		(super init: &rest)
	)

	(method (doVerb)
		(= local0 1)
		(self setScript: sOpenDoor)
	)
)

(instance sOpenDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 12502 0 82 0)
				(if (not (IsFlag 25))
					(spRags setCycle: End)
				)
				(spDoor setCycle: End self)
			)
			(1
				(= seconds 2)
			)
			(2
				(efExitForward init: 3)
				(= cycles 1)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

