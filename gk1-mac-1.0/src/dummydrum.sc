;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 814)
(include sci.sh)
(use Main)
(use Game)
(use System)

(public
	dummydrum 0
)

(instance dummydrum of Room
	(properties
		modNum 814
		picture 9561
		style 14
		exitStyle 13
	)

	(method (init)
		(super init: &rest)
		(self setScript: doInset)
	)
)

(instance doInset of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gCurRoom setInset: (ScriptID 815 0) self gCurRoom) ; drumInset
			)
			(2
				(= cycles 10)
			)
			(3
				(DisposeScript 815)
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

