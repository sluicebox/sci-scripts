;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use Game)
(use System)

(public
	rm200 0
)

(instance rm200 of Room
	(properties
		picture 200
	)

	(method (init)
		(gTheIconBar disable:)
		(super init: &rest)
		(if (gPqFlags test: 29)
			(PalVary 8 200) ; PalVaryNewSource
		)
		(self setScript: waitSome)
	)

	(method (dispose)
		(gTheIconBar enable:)
		(super dispose:)
	)
)

(instance waitSome of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound0 number: 200 setLoop: 1 play: self)
			)
			(1
				(gCurRoom newRoom: 210)
			)
		)
	)
)

