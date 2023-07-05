;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1360)
(include sci.sh)
(use Main)
(use PQRoom)
(use HotSpot)

(public
	s3_1360 0
)

(instance s3_1360 of PQRoom
	(properties
		picture 1360
	)

	(method (init)
		(super init: &rest)
		(northE init:)
		(eastE init:)
		(southE init:)
		(westE init:)
		(gGame handsOn:)
	)
)

(instance northE of HotSpot
	(properties
		nsRight 640
		nsBottom 48
		type 4097
	)

	(method (doVerb))
)

(instance eastE of HotSpot
	(properties
		nsLeft 600
		nsRight 640
		nsBottom 360
		type 8193
	)

	(method (doVerb))
)

(instance southE of HotSpot
	(properties
		nsTop 312
		nsRight 640
		nsBottom 360
		type 16385
	)

	(method (doVerb))
)

(instance westE of HotSpot
	(properties
		nsRight 48
		nsBottom 360
		type 32769
	)

	(method (doVerb))
)

