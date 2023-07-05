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
		picture 5363
		heading 225
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
		nsLeft 259
		nsTop 109
		nsRight 320
		nsBottom 176
		x 289
		y 142
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
		nsLeft 263
		nsTop 169
		nsRight 312
		nsBottom 197
		x 287
		y 183
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

