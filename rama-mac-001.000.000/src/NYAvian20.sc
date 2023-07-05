;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5020)
(include sci.sh)
(use Location)
(use Feature)

(public
	NYAvian20 0
)

(instance NYAvian20 of CloseupLocation
	(properties
		heading 225
	)

	(method (init)
		(super init: 5066)
		(self edgeN: 0 edgeE: 0 edgeW: 0)
		(melon_mural_225 init:)
		(mural_tet_225 init:)
	)
)

(instance melon_mural_225 of Feature
	(properties
		noun 16
		case 6
		nsLeft 181
		nsTop 11
		nsRight 432
		nsBottom 287
		x 306
		y 149
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance mural_tet_225 of Feature
	(properties
		noun 16
		case 3
		nsLeft 249
		nsTop 217
		nsRight 337
		nsBottom 250
		x 293
		y 233
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

