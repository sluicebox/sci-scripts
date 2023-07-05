;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3260)
(include sci.sh)
(use Main)
(use PQRoom)
(use HotSpot)

(public
	s2_3260 0
)

(instance s2_3260 of PQRoom
	(properties
		picture 3260
	)

	(method (init)
		(super init: &rest)
		(gGame handsOn:)
	)
)

(instance northE of HotSpot ; UNUSED
	(properties
		nsRight 320
		nsBottom 20
		type 4097
	)

	(method (doVerb))
)

(instance eastE of HotSpot ; UNUSED
	(properties
		nsLeft 300
		nsRight 320
		nsBottom 150
		type 8193
	)

	(method (doVerb))
)

(instance southE of HotSpot ; UNUSED
	(properties
		nsTop 130
		nsRight 320
		nsBottom 150
		type 16385
	)

	(method (doVerb))
)

(instance westE of HotSpot ; UNUSED
	(properties
		nsRight 20
		nsBottom 150
		type 32769
	)

	(method (doVerb))
)

