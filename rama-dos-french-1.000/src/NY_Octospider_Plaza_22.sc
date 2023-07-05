;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5322)
(include sci.sh)
(use Location)
(use Polygon)
(use Feature)

(public
	NY_Octospider_Plaza_22 0
)

(instance NY_Octospider_Plaza_22 of CloseupLocation
	(properties
		heading 225
		picture 5363
	)

	(method (init)
		(super init: picture)
		(self edgeW: 0 edgeE: 0)
		(myrmCup_225 init:)
		(lock_225 init:)
		(clamps_225 init:)
	)
)

(instance myrmCup_225 of Feature
	(properties
		noun 13
		x 289
		y 142
		nsBottom 176
		nsLeft 259
		nsRight 320
		nsTop 109
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
					init: 112 120 158 84 178 85 230 120 233 140 183 174 160 172 112 141
					yourself:
				)
		)
	)
)

(instance clamps_225 of Feature
	(properties
		noun 5
		x 287
		y 183
		nsBottom 197
		nsLeft 263
		nsRight 312
		nsTop 169
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

