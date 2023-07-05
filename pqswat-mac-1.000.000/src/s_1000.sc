;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1000)
(include sci.sh)
(use Main)
(use PQRoom)
(use HotSpot)

(public
	s_1000 0
)

(instance s_1000 of PQRoom
	(properties
		picture 1000
	)

	(method (init)
		(SetFlag 12)
		(super init: &rest)
		(p1001 init:)
		(p1003 init:)
		(testHotspot1 init:)
		(testHotspot2 init:)
		(gGame handsOn:)
	)
)

(instance p1001 of HotSpot
	(properties
		nsTop 63
		nsRight 163
		nsBottom 128
		type 1
		curView 986
	)

	(method (doVerb)
		(gCurRoom newRoom: 1001) ; s_1001
	)
)

(instance p1003 of HotSpot
	(properties
		nsLeft 291
		nsTop 63
		nsRight 319
		nsBottom 150
		type 1
		curView 986
		curLoop 1
	)

	(method (doVerb)
		(gCurRoom newRoom: 1003) ; s_1003
	)
)

(instance testHotspot1 of HotSpot
	(properties
		nsRight 100
		nsBottom 150
		type 6
	)

	(method (setupCursor param1)
		(if (== param1 2)
			(gTheHotspotCursor view: 987 loop: 0 cel: 1)
		else
			(gTheHotspotCursor view: 988 loop: 1 cel: 0)
		)
	)
)

(instance testHotspot2 of HotSpot
	(properties
		nsLeft 200
		nsRight 320
		nsBottom 150
		type 6
	)

	(method (setupCursor param1)
		(if (== param1 2)
			(gTheHotspotCursor view: 987 loop: 0 cel: 0)
		else
			(gTheHotspotCursor view: 988 loop: 0 cel: 0)
		)
	)
)

