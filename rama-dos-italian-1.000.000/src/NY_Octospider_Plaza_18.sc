;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5318)
(include sci.sh)
(use Location)
(use Polygon)
(use Feature)

(public
	NY_Octospider_Plaza_18 0
)

(instance NY_Octospider_Plaza_18 of CloseupLocation
	(properties
		heading 45
		picture 5368
	)

	(method (init)
		(super init: picture)
		(self edgeW: 0 edgeE: 0)
		(corn_45 init:)
		(clamps_45 init:)
		(lock_45 init:)
	)
)

(instance corn_45 of Feature
	(properties
		noun 8
		x 297
		y 110
		nsBottom 174
		nsLeft 284
		nsRight 311
		nsTop 47
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance clamps_45 of Feature
	(properties
		noun 5
		x 296
		y 184
		nsBottom 196
		nsLeft 275
		nsRight 318
		nsTop 173
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
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
					init: 118 119 163 83 189 83 238 118 240 141 194 172 166 170 120 138
					yourself:
				)
		)
	)
)

