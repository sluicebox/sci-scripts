;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8645)
(include sci.sh)
(use northExit)
(use Polygon)
(use Feature)

(public
	wahn8645 0
)

(instance wahn8645 of ExitRoom
	(properties
		picture 8645
		south 8603 ; wahnDisp3Rm
	)

	(method (init)
		(super init: &rest)
		(leftPlaque init:)
		(rightPlaque init:)
		(leftF init:)
		(rightF init:)
	)
)

(instance leftPlaque of GKFeature
	(properties
		BAD_SELECTOR 8646
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 159 264 146 320 280 320 280 264
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rightPlaque of GKFeature
	(properties
		BAD_SELECTOR 8647
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 297 264 417 264 429 318 297 318
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance leftF of GKFeature
	(properties
		BAD_SELECTOR 8650
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 39 221 22 261 102 261 115 221
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rightF of GKFeature
	(properties
		BAD_SELECTOR 8651
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 462 222 537 222 555 261 473 261
					yourself:
				)
		)
		(super init: &rest)
	)
)

