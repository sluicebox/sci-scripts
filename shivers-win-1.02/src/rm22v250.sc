;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22250)
(include sci.sh)
(use Main)
(use n951)
(use n22001)
(use Motion)
(use System)

(public
	rm22v250 0
)

(instance rm22v250 of ShiversRoom
	(properties
		picture 22250
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(if (IsFlag 22)
			(spSecretDoor init: setCel: 4)
			(efExitForward init: 3)
		)
		(super init: &rest)
		(if (and (== gPrevRoomNum 22180) (not (IsFlag 22))) ; rm22v180
			(spSecretDoor init:)
			(self setScript: sOpenDoor)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 23800) ; rm23v800
			(gSounds fade: 22201 0 2 40 1 0)
			(proc22001_1)
			(gSounds fade: 20803 0 1 30 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 22210
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 22220
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23800
	)

	(method (init)
		(self createPoly: 71 12 178 12 176 129 73 129 71 13)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)
)

(instance spSecretDoor of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 22250
		cycleSpeed 35
	)

	(method (init)
		(self createPoly: 71 12 178 12 176 129 73 129 71 13)
		(super init: &rest)
	)

	(method (doVerb)
		(self setScript: sOpenDoor)
	)
)

(instance sOpenDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 12205 0 40 0)
				(spSecretDoor setCycle: End self)
			)
			(1
				(efExitForward init: 3)
				(= cycles 1)
			)
			(2
				(SetFlag 22)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

