;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5316)
(include sci.sh)
(use Location)
(use Polygon)
(use Feature)

(public
	NY_Octospider_Plaza_16 0
)

(instance NY_Octospider_Plaza_16 of CloseupLocation
	(properties
		heading 45
		picture 5366
	)

	(method (init)
		(super init: picture)
		(self edgeW: 0 edgeE: 0)
		(lock_45 init:)
		(matrix_45 init:)
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
					init: 117 119 164 85 186 85 235 117 238 140 190 172 167 173 116 139
					yourself:
				)
		)
	)
)

(instance matrix_45 of Feature
	(properties
		noun 10
		x 297
		y 153
		nsBottom 175
		nsLeft 275
		nsRight 319
		nsTop 131
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance clamps_45 of Feature
	(properties
		noun 5
		x 297
		y 185
		nsBottom 196
		nsLeft 279
		nsRight 316
		nsTop 174
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

