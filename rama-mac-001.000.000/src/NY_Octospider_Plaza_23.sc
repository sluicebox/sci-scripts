;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5323)
(include sci.sh)
(use Location)
(use Polygon)
(use Feature)

(public
	NY_Octospider_Plaza_23 0
)

(instance NY_Octospider_Plaza_23 of CloseupLocation
	(properties
		picture 5364
		heading 225
	)

	(method (init)
		(super init: picture)
		(self edgeW: 0 edgeE: 0)
		(mapPiece_225 init:)
		(clamps_225 init:)
		(lock_225 init:)
	)
)

(instance mapPiece_225 of Feature
	(properties
		noun 11
		nsLeft 220
		nsTop 129
		nsRight 371
		nsBottom 179
		x 295
		y 154
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance clamps_225 of Feature
	(properties
		noun 5
		nsLeft 273
		nsTop 172
		nsRight 317
		nsBottom 197
		x 295
		y 184
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
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
					init: 116 120 162 84 185 84 236 120 235 139 189 171 164 171 117 138
					yourself:
				)
		)
	)
)

