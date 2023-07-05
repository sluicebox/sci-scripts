;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 38011)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use System)

(public
	rm38v011 0
)

(local
	local0
)

(instance rm38v011 of ShiversRoom
	(properties
		picture 38011
	)

	(method (init)
		(if (== gPrevRoomNum 37330) ; rm37v330
			(= global348 2)
			(proc951_7 23401)
			(proc951_9 23401)
			(gSounds play: 23401 -1 34 0)
		)
		(if (== global348 1)
			(= local0 1)
			(spDownButton init: cel: 0)
			(spDoor init: cel: 4)
			(efExitForward init: 3)
		else
			(spDownButton init:)
			(spDoorWindow init:)
		)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 38100) ; rm38v100
			(gSounds fadeChain:)
			(gSounds fade: 23401 0 3 40 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 38030
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 38031
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 38100
	)

	(method (init)
		(self createPoly: 56 1 214 1 212 142 58 142 56 2)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)
)

(instance spDownButton of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 38020
		loop 2
		cel 1
	)

	(method (init)
		(self createPoly: 227 133 227 113 240 113 240 133)
		(super init: &rest)
	)

	(method (doVerb)
		(if (not local0)
			(= local0 1)
			(proc951_7 23402)
			(proc951_9 23402)
			(gSounds playChain: -1 -2 23402 -1)
			(gSounds adjChainVol: 90)
			(self setScript: sGoDown)
		)
	)
)

(instance spDoor of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 38020
		loop 1
		cycleSpeed 15
	)
)

(instance spDoorWindow of ShiversProp
	(properties
		priority 24
		fixPriority 1
		view 38052
		loop 2
		cel 4
	)
)

(instance sGoDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSounds play: 10501 0 40 0)
				(gGame handsOff:)
				(gSounds play: 10505 0 75 self)
				(spDownButton cel: 0)
			)
			(1
				(spDownButton cel: 1)
				(gSounds fade: 10403 0 15 20 1 0)
				(gSounds play: 10504 0 75 self)
				(spDoorWindow cycleSpeed: 22 setCycle: Beg self)
			)
			(2
				(spDoorWindow cel: 19 loop: 1 cycleSpeed: 18 setCycle: Beg self)
			)
			(3
				(spDoorWindow cel: 4 loop: 0 cycleSpeed: 22 setCycle: Beg)
				(= seconds 6)
			)
			(4
				(spDownButton cel: 0)
				(gSounds play: 11007 0 75 0)
				(spDoorWindow
					view: 38020
					loop: 0
					cel: 0
					cycleSpeed: 18
					init:
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
				(= global348 1)
				(efExitForward init: 3)
				(ClearFlag 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

