;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1002)
(include sci.sh)
(use Main)
(use PQRoom)
(use HotSpot)

(public
	s_1002 0
)

(instance s_1002 of PQRoom
	(properties
		picture 1020
	)

	(method (init)
		(super init: &rest)
		(p1001 init:)
		(p1004 init:)
		(p1003 init:)
		(gGame handsOn:)
	)
)

(instance p1001 of HotSpot
	(properties
		nsLeft 72
		nsTop 38
		nsRight 191
		nsBottom 88
		type 1
		curView 986
	)

	(method (doVerb)
		(gCurRoom newRoom: 1001) ; s_1001
	)
)

(instance p1004 of HotSpot
	(properties
		nsLeft 310
		nsRight 320
		nsBottom 150
		type 1
		curView 986
		curLoop 1
	)

	(method (doVerb)
		(gCurRoom newRoom: 1004) ; s_1004
	)
)

(instance p1003 of HotSpot
	(properties
		nsTop 140
		nsRight 218
		nsBottom 150
		type 1
		curView 986
		curLoop 2
	)

	(method (doVerb)
		(gCurRoom newRoom: 1003) ; s_1003
	)
)

