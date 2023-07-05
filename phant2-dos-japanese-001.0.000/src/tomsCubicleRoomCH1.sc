;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4501)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use System)

(public
	tomsCubicleRoomCH1 0
)

(instance tomsCubicleRoomCH1 of P2Room
	(properties
		picture 280
		south 3351
	)

	(method (init)
		(if (gRoboGary isPlaying:)
			(gRoboGary fadeTo: 80)
		else
			(gP2SongPlyr fadeTo: 80)
		)
		(= global241 60)
		(if (not (IsFlag 70))
			(tomProp init: setPri: 1)
			(tomFeature init: whoDoit: tomCode)
		else
			(= picture 281)
		)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

(instance tomProp of P2Fidget
	(properties
		x 247
		y 338
		view 12800
		initStart 0
		initFinish 0
		cycleStart 7
	)

	(method (handleEvent)
		(tomFeature handleEvent: &rest)
	)
)

(instance tomFeature of P2Feature
	(properties
		priority 2
	)

	(method (onMe)
		(return (tomProp onMe: &rest))
	)

	(method (init)
		(if (super init: &rest)
			(if (not (IsFlag 65))
				(self addVerb: 5)
			)
			(if (not (IsFlag 66))
				(self addVerb: 6)
			)
			(if (IsFlag 67)
				(self delVerb: 4)
			)
		)
	)
)

(instance tomCode of Code
	(properties)

	(method (doit)
		(switch gVerb
			(5 ; walletI
				(if (not (SetFlag 65))
					(proc63002_7 3850)
				)
				(tomFeature delVerb: 5)
			)
			(6 ; cardKeyI
				(if (not (SetFlag 66))
					(proc63002_7 3860)
				)
				(tomFeature delVerb: 6)
			)
			(else
				(if (not (SetFlag 67))
					(proc63002_7 3820)
					(tomFeature delVerb: 4)
				)
			)
		)
	)
)

