;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5324)
(include sci.sh)
(use Location)
(use Polygon)
(use Feature)

(public
	NY_Octospider_Plaza_24 0
)

(instance NY_Octospider_Plaza_24 of CloseupLocation
	(properties
		heading 225
		picture 5365
	)

	(method (init)
		(super init: picture)
		(self edgeW: 0 edgeE: 0)
		(cutters_225 init:)
		(lock_225 init:)
		(clamps_225 init:)
	)
)

(instance cutters_225 of Feature
	(properties
		noun 12
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 200 154 264 144 274 152 375 152 375 177 273 176 273 182 265 184 200 169
					yourself:
				)
		)
	)
)

(instance lock_225 of Feature
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
					init: 114 119 160 84 182 84 233 118 234 139 186 172 164 170 114 139
					yourself:
				)
		)
	)
)

(instance clamps_225 of Feature
	(properties
		noun 5
		x 296
		y 187
		nsBottom 200
		nsLeft 267
		nsRight 326
		nsTop 175
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

