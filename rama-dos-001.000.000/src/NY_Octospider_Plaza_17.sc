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
		heading 45
		picture 5367
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
		x 294
		y 183
		nsBottom 197
		nsLeft 274
		nsRight 315
		nsTop 169
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

