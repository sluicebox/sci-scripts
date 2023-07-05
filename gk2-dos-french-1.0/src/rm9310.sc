;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9310)
(include sci.sh)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm9310 0
)

(instance rm9310 of ExitRoom
	(properties
		picture 9310
		south 930 ; rm930
	)

	(method (init)
		(super init: &rest)
		(cabinet init:)
	)
)

(instance cabinet of GKFeature
	(properties
		noun 8
		modNum 930
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 140 83 139 268 100 274 100 337 505 343 508 67
					yourself:
				)
		)
		(super init: &rest)
	)
)

