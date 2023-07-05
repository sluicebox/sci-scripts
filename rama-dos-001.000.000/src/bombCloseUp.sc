;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2108)
(include sci.sh)
(use Main)
(use Location)
(use n1111)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)

(public
	bombCloseUp 0
)

(instance bombCloseUp of CloseupLocation
	(properties
		heading 270
		picture 2434
	)

	(method (init)
		(super init: picture)
		(SetFlag 72)
		(bombLight init: global117)
		(bomb_270 init:)
		(sea_270 init:)
	)
)

(instance bombLight of Prop
	(properties
		x 285
		y 126
		cycleSpeed 45
		view 2434
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance bomb_270 of Feature
	(properties
		noun 11
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 138 38 111 93 107 97 62 194 65 223 52 241 55 248 73 352 61 358 47 375 44 405 57 450 56 457 47 483 47 591 78 591 292 197 296 189 287 111 271 53 273 26 273 2 240
					yourself:
				)
		)
	)
)

(instance sea_270 of Feature
	(properties
		noun 9
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 442 -1 590 -1 591 75 484 45 467 46 458 43
					yourself:
				)
		)
	)
)

