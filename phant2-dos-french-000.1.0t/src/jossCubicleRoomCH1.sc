;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4401)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use System)

(public
	jossCubicleRoomCH1 0
)

(instance jossCubicleRoomCH1 of P2Room
	(properties
		picture 270
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
			(jossProp init: setPri: 1)
			(jossFeature init: whoDoit: jossCode)
		else
			(= picture 271)
		)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

(instance jossProp of P2Fidget
	(properties
		x 325
		y 339
		view 12700
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

	(method (onMe)
		(return (jossProp onMe: &rest))
	)

	(method (init)
		(if (super init: &rest)
			(if (not (IsFlag 60))
				(self addVerb: 10)
			)
			(if (not (IsFlag 61))
				(self addVerb: 9)
			)
			(if (and (not (IsFlag 34)) (not (IsFlag 62)))
				(self addVerb: 11)
			)
			(if (IsFlag 64)
				(self delVerb: 4)
			)
		)
	)
)

(instance jossCode of Code
	(properties)

	(method (doit)
		(switch gVerb
			(10 ; xmasPhotoI
				(if (not (SetFlag 60))
					(proc63002_7 3660)
					(jossFeature delVerb: 10)
				)
			)
			(9 ; parentPhotoI
				(if (not (SetFlag 61))
					(proc63002_7 3650)
					(jossFeature delVerb: 9)
				)
			)
			(11 ; sexyCardI
				(if (and (not (IsFlag 34)) (not (SetFlag 62)))
					(proc63002_7 3670)
					(jossFeature delVerb: 11)
				)
			)
			(else
				(cond
					((not (SetFlag 63))
						(proc63002_7 4160)
					)
					((not (SetFlag 64))
						(proc63002_7 3610)
						(jossFeature delVerb: 4)
					)
				)
			)
		)
	)
)

