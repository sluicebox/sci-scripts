;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8151)
(include sci.sh)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm8151 0
)

(instance rm8151 of ExitRoom
	(properties
		picture 8151
		north 8141 ; rm8141
		east 8141 ; rm8141
		west 8141 ; rm8141
	)

	(method (init)
		(super init: &rest)
		(oneF init:)
		(twoF init:)
		(threeF init:)
		(fourF init:)
		(bottomF init:)
	)
)

(instance oneF of GKFeature
	(properties
		nextRoomNum 8145 ; rm8145
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 4 244 136 244 136 332 4 332
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance twoF of GKFeature
	(properties
		nextRoomNum 8146 ; rm8146
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 169 268 295 267 295 333 169 333
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance threeF of GKFeature
	(properties
		nextRoomNum 8143 ; rm8143
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 331 249 456 249 456 334 331 337
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance fourF of GKFeature
	(properties
		nextRoomNum 8144 ; rm8144
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 492 244 492 336 616 337 617 244
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance bottomF of ExitFeature
	(properties
		nextRoomNum 8152 ; rm8152
		exitDir 4
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -4 301 616 301 617 335 -2 336
					yourself:
				)
		)
		(super init: &rest)
	)
)

