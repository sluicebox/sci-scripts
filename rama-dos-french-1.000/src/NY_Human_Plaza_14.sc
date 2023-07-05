;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5214)
(include sci.sh)
(use MazeController)
(use Polygon)
(use Feature)

(public
	NY_Human_Plaza_14 0
)

(instance NY_Human_Plaza_14 of MazeController
	(properties
		noun 3
		heading 90
		case 4
	)

	(method (init)
		(MCPiston posn: 144 173 view: 5224)
		(Lights posn: 195 67 view: 5224)
		(LeftButton posn: 20 120 view: 5224)
		(RightButton posn: 50 122 view: 5224)
		(MazeCtrlCard posn: 280 212 view: 5224)
		(slot_90 init:)
		(buttons_90 init:)
		(super init: 5237)
	)
)

(instance slot_90 of Feature
	(properties
		noun 7
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 284 181 307 180 316 185 318 212 278 213 278 187
					yourself:
				)
		)
	)
)

(instance buttons_90 of Feature
	(properties
		noun 8
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 54 123 60 119 81 135 54 149 46 149
					yourself:
				)
				((Polygon new:) type: PTotalAccess init: 51 123 43 149 20 133 yourself:)
		)
	)
)

