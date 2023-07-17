;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8602)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Polygon)
(use Feature)

(public
	wahnDisp2Rm 0
)

(instance wahnDisp2Rm of ExitRoom
	(properties
		picture 8602
		south 8601 ; wahnDispRm
	)

	(method (init)
		(gEgo
			posn: 316 293
			heading: 45
			sel_737:
			setScaler: Scaler 100 69 334 254
			init:
		)
		(super init: &rest)
		(couchPlaque init:)
		(couch init:)
		(deathCase init:)
		(case2 init:)
		(d3Exit init:)
	)
)

(instance couchPlaque of GKFeature
	(properties
		nsLeft 208
		nsTop 62
		nsRight 250
		nsBottom 79
		BAD_SELECTOR 8643
	)
)

(instance couch of GKFeature
	(properties
		noun 7
		modNum 860
		x 112
		y 219
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 2 143 157 139 223 168 217 252 4 299
					yourself:
				)
		)
		(if (IsFlag 808)
			(= noun 7)
		else
			(= noun 25)
		)
		(super init: &rest)
	)
)

(instance case2 of GKFeature
	(properties
		approachX 456
		approachY 388
		BAD_SELECTOR 8611
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 413 217 618 218 618 336 354 342
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance deathCase of GKFeature
	(properties
		nsLeft 418
		nsTop 129
		nsRight 528
		nsBottom 160
		approachX 444
		approachY 249
		BAD_SELECTOR 8642
	)
)

(instance d3Exit of ExitFeature
	(properties
		nsLeft 304
		nsTop 31
		nsRight 376
		nsBottom 228
		approachX 350
		approachY 253
		BAD_SELECTOR 8603
		BAD_SELECTOR 7
	)
)

(instance d1Exit of ExitFeature ; UNUSED
	(properties
		nsLeft 588
		nsRight 634
		nsBottom 225
		approachX 585
		approachY 270
		BAD_SELECTOR 8601
		BAD_SELECTOR 1
	)
)

