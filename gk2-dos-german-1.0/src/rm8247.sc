;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8247)
(include sci.sh)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm8247 0
)

(instance rm8247 of ExitRoom
	(properties
		picture 8247
		south 820 ; rm820
	)

	(method (init)
		(super init: &rest)
		(robe init:)
		(plaque init:)
	)
)

(instance robe of GKFeature
	(properties
		noun 14
		modNum 820
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 349 11 313 25 214 230 20 290 22 333 527 333 511 289 445 252 438 205 408 94 428 61 391 17
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance plaque of GKFeature
	(properties
		modNum 820
		nextRoomNum 8252 ; rm8252
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 170 66 101 66 101 102 170 102
					yourself:
				)
		)
		(super init: &rest)
	)
)

