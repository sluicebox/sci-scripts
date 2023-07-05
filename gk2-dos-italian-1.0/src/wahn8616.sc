;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8616)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Polygon)
(use Feature)

(public
	wahn8616 0
)

(instance wahn8616 of ExitRoom
	(properties
		picture 8616
		south 8615 ; wahn8615
	)

	(method (init)
		(super init: &rest)
		(painting init:)
	)
)

(instance painting of GKFeature
	(properties
		noun 22
		modNum 860
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 122 41 301 41 300 311 67 315
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 318 40 489 42 553 308 326 311
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (IsFlag 625)
			(gMessager say: noun theVerb 0 0 0 modNum)
		else
			(gMessager say: noun theVerb 0 1 0 modNum)
		)
	)
)

