;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3300)
(include sci.sh)
(use Main)
(use PQRoom)
(use System)

(public
	s2_3300 0
)

(instance s2_3300 of PQRoom
	(properties
		picture 0
	)

	(method (init)
		(super init: &rest)
		(global112 stopPath:)
		(self setScript: enterBasement)
	)
)

(instance enterBasement of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gGame showCloseUp: 33000 -1 -1 self 1)
			)
			(2
				(gCurRoom newRoom: 3330) ; s2_3330
			)
		)
	)
)

