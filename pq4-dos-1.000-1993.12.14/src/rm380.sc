;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 380)
(include sci.sh)
(use Main)
(use Game)
(use System)

(public
	rm380 0
)

(instance rm380 of Room
	(properties
		picture 380
	)

	(method (init)
		(gGame intensity: 0)
		(gGame handsOff:)
		(if (== gPrevRoomNum 17) ; MapRoom
			(= style 9)
		else
			(= style 0)
		)
		(gGlobalSound0 number: 380 loop: 1 play:)
		(gTheIconBar disable:)
		(super init: &rest)
		(self setScript: showExtScript)
	)

	(method (dispose)
		(gTheIconBar enable:)
		(super dispose:)
	)
)

(instance showExtScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(gGame intensity: 100 fade: 0 100 7)
				(= seconds 5)
			)
			(2
				(if (gPqFlags test: 100)
					(self cue:)
				else
					(gMessager say: 1 0 0 1 self) ; "Wednesday 9:00 AM City Hall, Los Angeles"
				)
			)
			(3
				(gCurRoom newRoom: 385)
			)
		)
	)
)

