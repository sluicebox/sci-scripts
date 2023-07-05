;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4620)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use System)

(public
	rm4v620 0
)

(instance rm4v620 of ShiversRoom
	(properties
		picture 4190
	)

	(method (init)
		(if (== gPrevRoomNum 4590) ; rm4v590
			(proc951_7 10403)
			(proc951_9 10403)
			(gSounds play: 10403 -1 0 0)
			(gSounds fade: 10403 20 15 15 0 0)
		)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(if (IsFlag 6)
			(spDoor init:)
		)
		(spCCTV init:)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (>= (spDoor cel:) 1) (< newRoomNumber 5000))
			(gSounds play: 10407 0 90 0)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (dispose)
		(sMoveCCTV dispose:)
		(super dispose: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 4600
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 4630
	)

	(method (init)
		(self createPoly: 216 2 206 132 217 143 265 143 265 1)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 5010
	)

	(method (init)
		(self createPoly: 81 121 79 20 181 20 178 120)
		(super init: &rest)
	)
)

(instance spCCTV of ShiversProp
	(properties
		priority 255
		fixPriority 1
		view 4190
	)

	(method (init)
		(self posn: 0 0)
		(self cycleSpeed: 8)
		(self setCycle: End)
		(gSounds play: 15004 0 66 0)
		(self setScript: sMoveCCTV)
		(super init: &rest)
	)

	(method (doVerb))
)

(instance spDoor of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 4192
	)

	(method (init)
		(self createPoly: 81 121 79 20 181 20 178 120)
		(super init: &rest)
		(self cycleSpeed: 10)
	)

	(method (doVerb)
		(self
			setCycle: End
			createPoly: 0 0 0 -5 -5 -5 -5 0
			setScript: sDoorOpen
		)
	)
)

(instance sDoorOpen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 10406 0 90 self)
			)
			(1
				(gGame handsOn:)
				(efExitForward init: 3)
				(self dispose:)
			)
		)
	)
)

(instance sMoveCCTV of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 20))
			)
			(1
				(gSounds play: 15003 0 66 0)
				(spCCTV setCycle: Beg self)
			)
			(2
				(= seconds (Random 5 20))
			)
			(3
				(gSounds play: 15004 0 66 0)
				(spCCTV setCycle: End self)
				(= state -1)
			)
		)
	)
)

