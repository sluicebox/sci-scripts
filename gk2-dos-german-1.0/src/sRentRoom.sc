;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 110)
(include sci.sh)
(use Main)
(use northExit)
(use System)

(public
	sRentRoom 0
)

(instance sRentRoom of ExitRoom
	(properties
		picture 1101
	)

	(method (init)
		(super init: &rest)
		(self setScript: timeOut)
	)
)

(instance timeOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 12)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: 24) ; whereTo
			)
		)
	)
)

