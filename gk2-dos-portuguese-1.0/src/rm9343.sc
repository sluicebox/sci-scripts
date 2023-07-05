;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9343)
(include sci.sh)
(use n011)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm9343 0
)

(instance rm9343 of ExitRoom
	(properties
		picture 9343
		south 930 ; rm930
	)

	(method (init)
		(super init: &rest)
		(desk init:)
		(cabinet init:)
	)
)

(instance desk of GKFeature
	(properties
		modNum 930
	)

	(method (doVerb)
		(if (IsFlag 583)
			(= noun 10)
		else
			(= noun 9)
		)
		(super doVerb: &rest)
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 35 233 42 49 112 -5 202 71 201 164 353 156 494 174 495 184 210 275
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance cabinet of GKFeature
	(properties
		BAD_SELECTOR 9310
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 397 -5 402 161 443 203 443 253 622 283 619 -2
					yourself:
				)
		)
		(super init: &rest)
	)
)

