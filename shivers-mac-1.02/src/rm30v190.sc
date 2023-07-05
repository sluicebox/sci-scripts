;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30190)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use System)

(public
	rm30v190 0
)

(instance rm30v190 of ShiversRoom
	(properties
		picture 30190
	)

	(method (init)
		(pDoor init:)
		(spRock init:)
		(hsDoor init:)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 30200
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 30180
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 33320
	)

	(method (init)
		(self createPoly: 85 133 115 39 141 38 144 39 179 133 88 134)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)
)

(instance hsDoor of HotSpot
	(properties)

	(method (init)
		(self
			createPoly:
				61
				112
				18
				112
				16
				127
				60
				127
				60
				120
				86
				120
				80
				135
				178
				135
				143
				38
				115
				38
				87
				118
				85
				120
				61
				120
				61
				112
		)
		(super init: &rest)
	)

	(method (doVerb)
		(spRock setCycle: End)
		(gCurRoom setScript: sOpenDoor)
	)
)

(instance spRock of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 30192
	)

	(method (init)
		(self createPoly: 17 113 60 113 59 128 15 128 17 114)
		(super init: &rest)
	)

	(method (doVerb)
		(proc951_16 155)
		(if (not (IsFlag 43))
			(self setCycle: End)
			(self setScript: sOpenDoor)
		)
	)
)

(instance pDoor of ShiversProp
	(properties
		priority 120
		fixPriority 1
		view 30190
		loop 1
		cycleSpeed 17
	)
)

(instance sOpenDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(hsDoor dispose:)
				(gSounds play: 13011 0 82 0)
				(pDoor setCycle: End self)
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

