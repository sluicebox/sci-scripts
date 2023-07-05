;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3310)
(include sci.sh)
(use Main)
(use PQRoom)
(use HotSpot)

(public
	s2_3310 0
)

(instance s2_3310 of PQRoom
	(properties
		picture 3310
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
		nsRight 320
		nsBottom 20
		type 4097
	)

	(method (doVerb))
)

(instance eastE of HotSpot
	(properties
		nsLeft 300
		nsRight 320
		nsBottom 150
		type 8193
	)

	(method (doVerb))
)

(instance southE of HotSpot
	(properties
		nsTop 130
		nsRight 320
		nsBottom 150
		type 16385
	)

	(method (doVerb))
)

(instance westE of HotSpot
	(properties
		nsRight 20
		nsBottom 150
		type 32769
	)

	(method (doVerb))
)

