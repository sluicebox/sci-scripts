;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5010)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use System)

(public
	rm5v01 0
)

(instance rm5v01 of ShiversRoom
	(properties
		picture 5010
	)

	(method (init)
		(proc951_7 10501)
		(proc951_7 10504)
		(pUpButton init:)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(pWindow init:)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 5020
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 5050
	)

	(method (init)
		(self
			createPoly: 244 4 244 103 249 103 249 125 242 125 242 142 264 142 264 2
		)
		(super init: &rest)
	)
)

(instance pUpButton of ShiversProp
	(properties
		view 5010
		cel 1
	)

	(method (init)
		(self setPri: 25 cel: 1 createPoly: 234 104 234 114 248 114 248 104)
		(super init: &rest)
	)

	(method (doVerb)
		(ClearFlag 6)
		(self setScript: sGoUp)
	)
)

(instance pWindow of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 5010
		loop 2
	)

	(method (init)
		(super init: &rest)
	)

	(method (doVerb))
)

(instance sGoUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(pUpButton cel: 0)
				(gSounds play: 10501 0 30 self)
			)
			(1
				(pUpButton cel: 1)
				(gSounds play: 10505 0 90 self)
			)
			(2
				(gSounds fade: 10403 0 15 20 1 0)
				(gSounds play: 10504 0 90 self)
				(pWindow cycleSpeed: 22 setCycle: End self)
			)
			(3
				(pWindow cel: 0 loop: 3 cycleSpeed: 16 setCycle: End self)
			)
			(4
				(pWindow cel: 0 loop: 4 cycleSpeed: 22 setCycle: End self)
			)
			(5
				(pUpButton cel: 0)
			)
			(6
				(gGame handsOn:)
				(gCurRoom newRoom: 5110) ; rm5v11
			)
		)
	)
)

