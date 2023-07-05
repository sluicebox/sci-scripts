;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 830)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Feature)

(public
	rm830 0
)

(instance rm830 of ExitRoom ; "Herrenchiemsee Museum: Display Room 2"
	(properties
		noun 11
		picture 8301
		south 8122 ; rm8122
	)

	(method (init)
		(gEgo
			posn: 408 365
			heading: 315
			BAD_SELECTOR:
			setScaler: Scaler 97 56 362 264
			init:
		)
		(super init: &rest)
		(medShot init:)
		(displayWall init:)
		(plaque init:)
	)
)

(instance medShot of GKFeature
	(properties
		nsLeft 316
		nsTop 19
		nsRight 636
		nsBottom 333
		approachX 320
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (IsFlag 624)
					(gCurRoom newRoom: 8311)
				else
					(SetFlag 624)
					(PlayScene 496 0 8340) ; rm8340
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance displayWall of GKFeature
	(properties
		nsLeft 12
		nsTop 98
		nsRight 192
		nsBottom 259
		approachX 136
		approachY 326
		BAD_SELECTOR 8342
	)
)

(instance plaque of GKFeature
	(properties
		nsLeft 264
		nsTop 120
		nsRight 316
		nsBottom 218
		approachX 285
		approachY 295
		BAD_SELECTOR 8343
	)
)

