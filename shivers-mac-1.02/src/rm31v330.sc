;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31330)
(include sci.sh)
(use Main)
(use n951)
(use Array)
(use Motion)
(use Actor)
(use System)

(public
	rm31v330 0
)

(local
	local0
	local1
)

(instance rm31v330 of ShiversRoom
	(properties
		picture 31330
	)

	(method (init &tmp temp0)
		(ClearFlag 43)
		(efExitBack init: 8)
		(spButton init:)
		(= local0 (IntArray new:))
		(for ((= temp0 0)) (< temp0 6) ((++ temp0))
			(local0 at: temp0 ((vSkull new:) cel: temp0 init: hide: yourself:))
		)
		(spDial init:)
		(super init: &rest)
	)
)

(instance spButton of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 31330
		loop 1
	)

	(method (doVerb)
		(gCurRoom setScript: sLightSkulls)
	)
)

(instance spDial of ShiversProp
	(properties
		priority 5
		fixPriority 1
		view 31330
		cycleSpeed 18
	)

	(method (doVerb)
		(if local1
			(gCurRoom setScript: sTurnDial)
		else
			(gCurRoom setScript: sNoTurn)
		)
	)
)

(instance vSkull of View
	(properties
		priority 25
		fixPriority 1
		view 31330
		loop 2
	)
)

(instance sLightSkulls of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local1 1)
				(for ((= temp0 0)) (< temp0 6) ((++ temp0))
					(if (== [global328 temp0] [global334 temp0])
						((local0 at: temp0) show:)
					else
						(= local1 0)
					)
				)
				(gSounds play: 15029 0 32 0)
				(= seconds 2)
			)
			(1
				(for ((= temp0 0)) (< temp0 6) ((++ temp0))
					((local0 at: temp0) hide:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTurnDial of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 13118 0 82 0)
				(for ((= temp0 0)) (< temp0 6) ((++ temp0))
					((local0 at: temp0) hide:)
				)
				(spDial setCycle: End self)
			)
			(1
				(spDial loop: 3 cel: 0)
				(SetFlag 78)
				(= seconds 1)
			)
			(2
				(gGame handsOn:)
				(gCurRoom newRoom: 31440) ; rm31v440
			)
		)
	)
)

(instance sNoTurn of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds stop: 13117)
				(gSounds play: 13117 0 82 self)
				(for ((= temp0 0)) (< temp0 6) ((++ temp0))
					((local0 at: temp0) hide:)
				)
			)
			(1
				(gGame handsOn:)
			)
		)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 31440
	)

	(method (init)
		(self
			createPoly:
				0
				0
				20
				20
				20
				123
				243
				123
				243
				20
				20
				20
				0
				0
				263
				0
				263
				143
				0
				143
		)
		(super init: &rest)
	)
)

