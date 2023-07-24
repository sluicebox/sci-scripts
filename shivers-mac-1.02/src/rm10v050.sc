;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10050)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(public
	rm10v050 0
)

(instance rm10v050 of ShiversRoom
	(properties
		picture 10052
	)

	(method (init)
		(super init: &rest)
		(efExitBack init: 8)
		(pCamera init:)
		(self setScript: sCameraPan)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 10040
	)

	(method (init)
		(self
			createPoly: 0 0 94 69 94 118 166 118 166 69 94 69 0 0 262 0 262 144 0 144 0 0
		)
		(super init: &rest)
	)
)

(instance pCamera of Prop
	(properties
		priority 1
		fixPriority 1
		view 10051
		cycleSpeed 12
	)
)

(instance sCameraPan of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pCamera setCycle: End self)
				(gSounds play: 15003 0 122 0)
			)
			(1
				(= seconds (Random 2 10))
			)
			(2
				(pCamera setCycle: Beg self)
				(gSounds play: 15004 0 122 0)
			)
			(3
				(= state -1)
				(= seconds (Random 2 10))
			)
		)
	)
)

