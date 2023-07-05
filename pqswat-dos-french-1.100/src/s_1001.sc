;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1001)
(include sci.sh)
(use Main)
(use PQRoom)
(use HotSpot)

(public
	s_1001 0
)

(instance s_1001 of PQRoom
	(properties
		picture 1010
	)

	(method (init)
		(super init: &rest)
		(p1010 init:)
		(p1002 init:)
		(p1003 init:)
		(p1000 init:)
		(gGame handsOn:)
	)
)

(instance p1010 of HotSpot
	(properties
		nsLeft 183
		nsTop 69
		nsRight 218
		nsBottom 113
		type 1
		curView 986
	)

	(method (doVerb)
		(gCurRoom newRoom: 1010)
	)
)

(instance p1002 of HotSpot
	(properties
		nsLeft 234
		nsTop 67
		nsRight 267
		nsBottom 108
		type 1
		curView 986
	)

	(method (doVerb)
		(gCurRoom newRoom: 1002) ; s_1002
	)
)

(instance p1003 of HotSpot
	(properties
		nsLeft 271
		nsTop 61
		nsRight 299
		nsBottom 103
		type 1
		curView 986
	)

	(method (doVerb)
		(gCurRoom newRoom: 1003) ; s_1003
	)
)

(instance p1000 of HotSpot
	(properties
		nsLeft 310
		nsRight 320
		nsBottom 150
		type 1
		curView 986
		curLoop 1
	)

	(method (doVerb)
		(gCurRoom newRoom: 1000) ; s_1000
	)
)

