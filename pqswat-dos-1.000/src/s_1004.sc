;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1004)
(include sci.sh)
(use Main)
(use PQRoom)
(use HotSpot)

(public
	s_1004 0
)

(instance s_1004 of PQRoom
	(properties
		picture 1040
	)

	(method (init)
		(super init: &rest)
		(p1010 init:)
		(p1002 init:)
		(p1001 init:)
		(gGame handsOn:)
	)
)

(instance p1010 of HotSpot
	(properties
		nsLeft 108
		nsTop 55
		nsRight 247
		nsBottom 118
		type 1
		curView 986
	)

	(method (doVerb)
		(gCurRoom newRoom: 1010)
	)
)

(instance p1002 of HotSpot
	(properties
		nsLeft 264
		nsTop 60
		nsRight 295
		nsBottom 106
		type 1
		curView 986
	)

	(method (doVerb)
		(gCurRoom newRoom: 1002) ; s_1002
	)
)

(instance p1001 of HotSpot
	(properties
		nsLeft 310
		nsRight 320
		nsBottom 150
		type 1
		curView 986
		curLoop 1
	)

	(method (doVerb)
		(gCurRoom newRoom: 1001) ; s_1001
	)
)

