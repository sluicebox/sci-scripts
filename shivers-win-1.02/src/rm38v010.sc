;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 38010)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm38v010 0
)

(local
	local0
)

(instance rm38v010 of ShiversRoom
	(properties
		picture 38010
	)

	(method (init)
		(if (== gPrevRoomNum 38110) ; rm38v110
			(= global348 1)
			(proc951_7 23401)
			(proc951_9 23401)
			(gSounds play: 23401 -1 34 0)
		)
		(if (== global348 2)
			(= local0 1)
			(spUpButton init: cel: 0)
			(spDoor init: cel: 4)
			(efExitForward init: 3)
		else
			(spUpButton init:)
			(spDoorWindow init:)
		)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 37350) ; rm37v350
			(gSounds fadeChain:)
			(gSounds fade: 23401 0 3 40 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 38031
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 38030
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 37350
	)

	(method (init)
		(self createPoly: 56 1 214 1 212 142 58 142 56 2)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)
)

(instance spUpButton of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 38050
		loop 2
		cel 1
	)

	(method (init)
		(self createPoly: 225 112 241 112 241 134 225 134 225 113)
		(super init: &rest)
	)

	(method (doVerb)
		(if (not local0)
			(proc951_7 23402)
			(proc951_9 23402)
			(gSounds playChain: -1 -2 23402 -1)
			(gSounds adjChainVol: 90)
			(= local0 1)
			(self setScript: sGoUp)
		)
	)
)

(instance spDoor of Prop
	(properties
		priority 25
		fixPriority 1
		view 38050
		loop 1
		cycleSpeed 15
	)

	(method (init)
		(super init: &rest)
	)
)

(instance spDoorWindow of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 38051
	)
)

(instance sGoUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSounds play: 10501 0 40 0)
				(gGame handsOff:)
				(gSounds play: 10505 0 75 self)
				(spUpButton cel: 0)
			)
			(1
				(spUpButton cel: 1)
				(gSounds fade: 10403 0 15 20 1 0)
				(gSounds play: 10504 0 75 self)
				(spDoorWindow cycleSpeed: 23 setCycle: End self)
			)
			(2
				(spDoorWindow cel: 0 loop: 1 cycleSpeed: 18 setCycle: End self)
			)
			(3
				(spDoorWindow cel: 0 loop: 2 cycleSpeed: 23 setCycle: End)
				(= seconds 6)
			)
			(4
				(spUpButton cel: 0)
				(gSounds play: 11007 0 75 0)
				(spDoorWindow
					view: 38050
					loop: 0
					cel: 0
					cycleSpeed: 18
					setCycle: End
				)
				(= seconds 2)
			)
			(5
				(spDoorWindow hide: dispose:)
				(gSounds play: 10406 0 75 0)
				(spDoor init: setCycle: End self)
			)
			(6
				(= global348 2)
				(efExitForward init: 3)
				(ClearFlag 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

