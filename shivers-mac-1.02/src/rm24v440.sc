;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24440)
(include sci.sh)
(use Main)
(use n951)
(use ROsc)
(use ForwardCounter)
(use System)

(public
	rm24v440 0
)

(instance rm24v440 of ShiversRoom
	(properties
		picture 24440
	)

	(method (init)
		(pWind init:)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 24380
	)

	(method (init)
		(self
			createPoly: 0 0 265 0 265 144 186 144 186 63 105 63 105 144 0 144 0 0
		)
		(super init: &rest)
	)
)

(instance pWind of ShiversProp
	(properties
		priority 10
		fixPriority 1
		view 24440
	)

	(method (init)
		(self
			createPoly: 157 133 185 89 185 69 157 64 133 64 106 75 106 100 135 137 155 137 157 133
		)
		(super init: &rest)
	)

	(method (doVerb)
		(self setScript: sWindUp)
	)
)

(instance sWindUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 66)
					(SetFlag 84)
					(gSounds play: 12413 -1 82 0)
					(pWind setCycle: ForwardCounter 5 self)
				else
					(gSounds stop: 12412)
					(gSounds play: 12412 0 82 self)
					(pWind setCycle: ROsc 1 0 1 0)
				)
			)
			(1
				(gSounds stop: 12413)
				(if (IsFlag 66)
					(pWind setCycle: 0)
					(gCurRoom newRoom: 24380) ; rm24v380
				)
				(= cycles 1)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

