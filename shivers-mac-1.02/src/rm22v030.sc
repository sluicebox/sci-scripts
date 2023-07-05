;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22030)
(include sci.sh)
(use Main)
(use n951)
(use n22001)
(use Motion)
(use System)

(public
	rm22v030 0
)

(local
	local0
)

(instance rm22v030 of ShiversRoom
	(properties
		picture 22030
	)

	(method (init)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(spDoor init:)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 5)
		(cond
			((== newRoomNumber 21020) ; rm21v020
				(gSounds fade: 22201 0 3 10 1 0)
				(proc22001_1)
			)
			(local0
				(gSounds play: 12207 0 82 0)
			)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 21020
	)

	(method (init)
		(self createPoly: 81 142 201 142 201 26 81 26 81 141)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 22020
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 22020
	)
)

(instance spDoor of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 22030
		cycleSpeed 27
	)

	(method (init)
		(self createPoly: 81 142 201 142 201 26 81 26 81 141)
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
				(gSounds play: 12206 0 82 0)
				(spDoor setCycle: End)
				(= cycles 1)
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

