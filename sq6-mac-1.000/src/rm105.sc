;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 105)
(include sci.sh)
(use Main)
(use SQRoom)
(use System)

(public
	rm105 0
)

(instance rm105 of SQRoom
	(properties
		style 0
	)

	(method (init)
		(super init: &rest)
		(self setScript: doRestoreScript)
	)
)

(instance doRestoreScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= ticks 120)
			)
			(1
				(Save 1 name temp0 gVersion) ; RestoreGame, UNINIT
				(= cycles 10)
			)
			(2
				(gCurRoom newRoom: gPrevRoomNum)
				(self dispose:)
			)
		)
	)
)

