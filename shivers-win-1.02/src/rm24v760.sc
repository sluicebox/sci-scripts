;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24760)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use System)

(public
	rm24v760 0
)

(local
	local0
)

(instance rm24v760 of ShiversRoom
	(properties
		picture 24760
	)

	(method (init)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(spDoor init:)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 5)
		(if (== newRoomNumber 23690) ; rm23v690
			(gSounds fade: 22401 0 6 30 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23690
	)

	(method (init)
		(self createPoly: 92 38 172 38 172 126 92 126 92 39)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24750
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24750
	)
)

(instance spDoor of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 24761
		cycleSpeed 12
	)

	(method (init)
		(self createPoly: 92 38 172 38 172 126 92 126 92 39)
		(super init: &rest)
	)

	(method (doVerb)
		(if (IsFlag 24)
			(gSounds play: 12309 0 90 0)
			(self setCycle: End)
			(SetFlag 43)
			(efExitForward init: 3)
		else
			(self setScript: sNarrative)
		)
	)
)

(instance sNarrative of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds stop: 32401)
				(= cycles 1)
			)
			(1
				(gSounds play: 32401 0 82 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

