;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5016)
(include sci.sh)
(use MazeController)
(use Polygon)
(use Feature)

(public
	NYAvian16 0
)

(instance NYAvian16 of MazeController
	(properties
		noun 2
		heading 2
	)

	(method (init)
		(MCPiston posn: 144 173 view: 5057)
		(Lights posn: 195 67 view: 5057)
		(LeftButton posn: 20 120 view: 5057)
		(RightButton posn: 50 122 view: 5057)
		(MazeCtrlCard posn: 280 212 view: 5057)
		(super init: 5057)
		(mazeController_90 init:)
		(CARD_SLOT_N_90 init:)
	)
)

(instance mazeController_90 of Feature
	(properties
		noun 36
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 21 108 55 109 63 94 98 95 96 110 123 114 169 13 169 0 438 0 428 18 477 109 498 93 536 94 541 106 581 110 589 198 567 198 556 227 574 280 14 281 38 229 11 227 6 150 19 114 63 96
					yourself:
				)
		)
	)
)

(instance CARD_SLOT_N_90 of Feature
	(properties
		noun 14
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 280 185 311 187 316 211 281 211
					yourself:
				)
		)
	)
)

