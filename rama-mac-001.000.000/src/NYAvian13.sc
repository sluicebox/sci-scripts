;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5013)
(include sci.sh)
(use Location)
(use Polygon)
(use Feature)

(public
	NYAvian13 0
)

(instance NYAvian13 of CloseupLocation
	(properties
		heading 90
	)

	(method (init)
		(super init: 5051)
		(self edgeN: 0 edgeE: 0 edgeW: 0)
		(tetrahedron_90 init:)
	)
)

(instance tetrahedron_90 of Feature
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
					init: 119 3 21 292 564 291 467 -3
					yourself:
				)
		)
	)
)

