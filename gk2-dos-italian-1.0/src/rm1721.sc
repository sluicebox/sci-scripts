;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1721)
(include sci.sh)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm1721 0
)

(instance rm1721 of ExitRoom
	(properties
		picture 1721
		east 170 ; srExtWallRoom
	)

	(method (init)
		(super init: &rest)
		(doorFeat init:)
		(castleFeat init:)
	)
)

(instance doorFeat of GKFeature
	(properties
		noun 10
		modNum 160
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 62 275 56 319 -3 326 -4 337 139 334 117 307 108 275
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance castleFeat of GKFeature
	(properties
		noun 11
		modNum 160
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 132 41 66 50 16 31 0 114 -3 326 56 320 62 276 109 276 118 310 136 332 308 332 363 270 618 176 618 -5 141 -5
					yourself:
				)
		)
		(super init: &rest)
	)
)

