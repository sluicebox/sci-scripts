;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39300)
(include sci.sh)
(use Main)
(use n951)
(use RandCycle)
(use Motion)
(use Actor)
(use System)

(public
	rm39v300 0
)

(instance rm39v300 of ShiversRoom
	(properties
		picture 39300
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(breakerSwitch init:)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 39130
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 39150
	)
)

(instance breakerSwitch of ShiversProp
	(properties
		priority 75
		fixPriority 1
		view 39300
		cel 1
	)

	(method (init)
		(if (IsFlag 80)
			(= cel 2)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(if (not (IsFlag 80))
			(if (== cel 0)
				(= cel 2)
				(gCurRoom setScript: sTripBreaker)
			else
				(gSounds play: 13912 0 82 0)
				(= cel 0)
			)
		)
	)
)

(instance pZap of Prop
	(properties
		priority 10
		fixPriority 1
		view 39141
		cycleSpeed 4
	)
)

(instance pDoor of Prop
	(properties
		priority 5
		fixPriority 1
		view 39141
		loop 1
		cycleSpeed 8
	)
)

(instance sTripBreaker of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds stop: 13912)
				(gSounds play: 13913 0 82 self)
				((Prop new:)
					view: 39300
					loop: 1
					setPri: 76 1
					setCycle: RandCycle
					init:
				)
			)
			(1
				(gCurRoom drawPic: 39141)
				(gCast eachElementDo: #dispose)
				(pDoor init:)
				(pZap cycleSpeed: 3 setCycle: End self init:)
				(= cycles 1)
			)
			(2
				(gSounds play: 13904 0 82 0)
			)
			(3
				(pZap dispose:)
				(pDoor setCycle: End self)
			)
			(4
				(SetFlag 80)
				(gCurRoom newRoom: 39310) ; rm39v310
			)
		)
	)
)

