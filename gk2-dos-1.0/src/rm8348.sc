;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8348)
(include sci.sh)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm8348 0
)

(instance rm8348 of ExitRoom
	(properties
		picture 8348
		south 830 ; rm830
	)

	(method (init)
		(super init: &rest)
		(leftPlaque init:)
		(rightPlaque init:)
		(midPlaque init:)
	)
)

(instance leftPlaque of GKFeature
	(properties
		nextRoomNum 8350 ; rm8350
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 189 105 189 99 243 -2 243
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rightPlaque of GKFeature
	(properties
		nextRoomNum 8351 ; rm8351
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 509 190 609 190 616 244 515 244
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance midPlaque of GKFeature
	(properties
		nextRoomNum 8352 ; rm8352
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 255 189 358 189 358 245 255 245
					yourself:
				)
		)
		(super init: &rest)
	)
)

