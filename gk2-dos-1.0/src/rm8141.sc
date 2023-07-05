;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8141)
(include sci.sh)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm8141 0
)

(instance rm8141 of ExitRoom
	(properties
		picture 8141
		south 810 ; rm810
	)

	(method (init)
		(super init: &rest)
		(topF init:)
		(bottomF init:)
	)
)

(instance topF of GKFeature
	(properties
		nextRoomNum 8151 ; rm8151
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 167 30 167 185 474 185 474 30
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance bottomF of GKFeature
	(properties
		nextRoomNum 8152 ; rm8152
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 169 189 169 306 476 306 476 189
					yourself:
				)
		)
		(super init: &rest)
	)
)

