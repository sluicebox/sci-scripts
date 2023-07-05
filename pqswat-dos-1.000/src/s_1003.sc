;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1003)
(include sci.sh)
(use Main)
(use PQRoom)
(use HotSpot)

(public
	s_1003 0
)

(instance s_1003 of PQRoom
	(properties
		picture 1030
	)

	(method (init)
		(super init: &rest)
		(p1002 init:)
		(p1000 init:)
		(gGame handsOn:)
	)
)

(instance p1002 of HotSpot
	(properties
		nsLeft 45
		nsTop 75
		nsRight 87
		nsBottom 122
		type 1
		curView 986
	)

	(method (doVerb)
		(gCurRoom newRoom: 1002) ; s_1002
	)
)

(instance p1000 of HotSpot
	(properties
		nsRight 10
		nsBottom 150
		type 1
		curView 986
		curLoop 3
	)

	(method (doVerb)
		(gCurRoom newRoom: 1000) ; s_1000
	)
)

