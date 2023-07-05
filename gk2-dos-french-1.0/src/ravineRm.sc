;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 650)
(include sci.sh)
(use Main)
(use northExit)
(use Scaler)
(use Feature)

(public
	ravineRm 0
)

(instance ravineRm of ExitRoom
	(properties
		picture 6501
	)

	(method (init)
		(gEgo
			posn: 252 238
			heading: 180
			normalize:
			setScaler: Scaler 86 19 329 177
			init:
		)
		(super init: &rest)
		(fNorthExit init:)
		(fRavine init:)
		(gGame handsOn:)
	)
)

(instance fNorthExit of ExitFeature
	(properties
		approachX 250
		exitDir 0
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 137 198 111 -3 507 -1 448 217)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gCurRoom newRoom: 610) ; woods3Rm
		else
			(super doVerb: &rest)
		)
	)
)

(instance fRavine of GKFeature
	(properties
		noun 6
		modNum 600
		sightAngle 360
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 101 278 221 297 390 299 499 273 477 332 111 331)
	)
)

