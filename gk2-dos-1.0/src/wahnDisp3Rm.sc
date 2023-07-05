;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8603)
(include sci.sh)
(use Main)
(use northExit)
(use Scaler)
(use Polygon)
(use Feature)

(public
	wahnDisp3Rm 0
)

(instance wahnDisp3Rm of ExitRoom
	(properties
		picture 8603
		south 8602 ; wahnDisp2Rm
	)

	(method (init)
		(super init: &rest)
		((ScriptID 22 1) sightAngle: 360) ; southExit
		((ScriptID 22 0) sightAngle: 360) ; northExit
		((ScriptID 22 2) sightAngle: 360) ; eastExit
		((ScriptID 22 3) sightAngle: 360) ; westExit
		(gEgo
			posn: 517 394
			heading: 325
			normalize:
			init:
			setScaler: Scaler 100 67 396 299
		)
		(painting init:)
		(aBust init:)
		(deathCase init:)
		(d4Exit init:)
	)
)

(instance painting of GKFeature
	(properties
		nsLeft 64
		nsTop 31
		nsRight 170
		nsBottom 204
		sightAngle 360
		nextRoomNum 8635 ; wahn8635
	)
)

(instance aBust of GKFeature
	(properties
		nsLeft 314
		nsTop 112
		nsRight 348
		nsBottom 182
		sightAngle 360
		nextRoomNum 8644 ; wahn8644
	)
)

(instance deathCase of GKFeature
	(properties
		nsLeft 386
		nsTop 194
		nsRight 486
		nsBottom 225
		sightAngle 360
		nextRoomNum 8645 ; wahn8645
	)
)

(instance d4Exit of ExitFeature
	(properties
		sightAngle 360
		nextRoomNum 8604 ; wahnDisp4Rm
		exitDir 7
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 543 96 545 319 618 325 615 94
					yourself:
				)
		)
		(super init: &rest)
	)
)

