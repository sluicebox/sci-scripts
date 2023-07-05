;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33310)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use System)

(public
	rm33v310 0
)

(instance rm33v310 of ShiversRoom
	(properties
		picture 33310
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(if (IsFlag 75)
			(spSecretDoor init:)
		else
			(spPlank init:)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 7)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 30170
	)

	(method (init)
		(self createPoly: 76 142 111 27 169 27 205 142 76 142)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 33250
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 33060
	)
)

(instance spPlank of ShiversProp
	(properties
		priority 30
		fixPriority 1
		view 33310
		loop 1
		cycleSpeed 10
	)

	(method (init)
		(self createPoly: 148 88 224 88 224 143 148 143 148 89)
		(super init: &rest)
	)

	(method (doVerb)
		(proc951_16 158)
		(if (not (IsFlag 75))
			(self setScript: sPlankFalls)
			(self createPoly: 0 0 0 0 0 0 0 0 0 0)
			(SetFlag 75)
		)
	)
)

(instance spSecretDoor of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 33310
		cycleSpeed 17
	)

	(method (init)
		(self createPoly: 111 25 72 142 205 142 168 25 112 25)
		(super init: &rest)
	)

	(method (doVerb)
		(self setScript: sOpenDoor)
		(self createPoly: 0 0 0 0 0 0 0 0 0 0)
	)
)

(instance sPlankFalls of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 13301 0 82 0)
				(spPlank setCycle: End self)
			)
			(1
				(spSecretDoor init:)
				(= cycles 1)
			)
			(2
				(spPlank hide:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 13011 0 82 0)
				(spSecretDoor setCycle: End self)
			)
			(1
				(efExitForward init: 3)
				(= cycles 1)
			)
			(2
				(SetFlag 43)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

