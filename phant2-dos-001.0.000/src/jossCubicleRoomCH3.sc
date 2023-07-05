;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4403)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use System)

(public
	jossCubicleRoomCH3 0
)

(instance jossCubicleRoomCH3 of P2Room
	(properties
		picture 270
		south 3353
	)

	(method (init)
		((if (gRoboGary isPlaying:) gRoboGary else gP2SongPlyr) fadeTo: 80)
		(= global241 60)
		(jossProp init: setPri: 1)
		(super init: &rest)
		(jossFeature init: whoDoit: jossCode)
		(gGame handsOn: 1)
	)
)

(instance jossProp of P2Fidget
	(properties
		x 331
		y 339
		view 12701
		initStart 0
		initFinish 0
		cycleStart 7
	)

	(method (handleEvent)
		(jossFeature handleEvent: &rest)
	)
)

(instance jossFeature of P2Feature
	(properties
		priority 2
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 403)
			(self delVerb: 4)
		)
	)

	(method (onMe)
		(return (jossProp onMe: &rest))
	)
)

(instance jossCode of Code
	(properties)

	(method (doit)
		(if (not (SetFlag 402))
			(proc63002_7 4560)
		else
			(proc63002_7 4570)
			(SetFlag 403)
			(jossFeature delVerb: 4)
		)
	)
)

