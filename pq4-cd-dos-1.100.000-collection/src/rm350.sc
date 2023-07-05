;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 350)
(include sci.sh)
(use Main)
(use Game)
(use System)

(public
	rm350 0
)

(instance rm350 of Room
	(properties
		picture 350
	)

	(method (init)
		(if (IsHiRes)
			(= picture 10350)
		)
		(if (== gPrevRoomNum 17) ; MapRoom
			(= style 9)
		else
			(= style 0)
		)
		(gTheIconBar disable:)
		(super init: &rest)
		(gGlobalSound0 number: 190 loop: 1 play:)
		(gGame handsOff:)
		(self setScript: rmScript)
	)

	(method (dispose)
		(gTheIconBar enable:)
		(super dispose:)
	)
)

(instance rmScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(gCurRoom newRoom: 355)
			)
		)
	)
)

