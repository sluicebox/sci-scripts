;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use Game)
(use System)

(public
	rm300 0
)

(instance rm300 of Room
	(properties
		picture 300
	)

	(method (init)
		(gTheIconBar disable:)
		(super init: &rest)
		(self setScript: nadaScript)
	)
)

(instance nadaScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound1 number: 300 setLoop: -1 play:)
				(= ticks 400)
			)
			(1
				(gGlobalSound0 fade: 0 15 1 1)
				(gCurRoom newRoom: 310)
				(gTheIconBar enable:)
			)
		)
	)
)

