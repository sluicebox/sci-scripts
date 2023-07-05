;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5317)
(include sci.sh)
(use Location)
(use Polygon)
(use Feature)

(public
	NY_Octospider_Plaza_17 0
)

(instance NY_Octospider_Plaza_17 of CloseupLocation
	(properties
		picture 5367
		heading 45
	)

	(method (init)
		(super init: picture)
		(self edgeW: 0 edgeE: 0)
		(lock_45 init:)
		(fliter_45 init:)
		(clamps_45 init:)
	)
)

(instance lock_45 of Feature
	(properties
		noun 6
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 117 119 162 84 186 85 236 118 237 141 191 173 167 173 118 139
					yourself:
				)
		)
	)
)

(instance fliter_45 of Feature
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
					init: 277 134 277 100 311 102 312 133 304 134 299 168 292 168 287 134
					yourself:
				)
		)
	)
)

(instance clamps_45 of Feature
	(properties
		noun 5
		nsLeft 274
		nsTop 169
		nsRight 315
		nsBottom 197
		x 294
		y 183
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

