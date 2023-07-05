;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3484)
(include sci.sh)
(use Main)
(use nExit)
(use ExitFeature)

(public
	undergroundHallway10 0
)

(local
	[local0 4] = [235 50 400 192]
)

(instance undergroundHallway10 of P2Room
	(properties
		picture 790
		south 3474
	)

	(method (init)
		(super init: &rest)
		(if (== gPrevRoomNum 9000) ; threshCompRm
			(if (== gChapter 4)
				(gP2SongPlyr fadeIn: 4771)
			else
				(gP2SongPlyr fadeIn: 4772)
			)
		)
		(doorF init: [local0 0] [local0 1] [local0 2] [local0 3])
		(gGame handsOn: 1)
	)
)

(instance doorF of ExitFeature
	(properties
		nextRoom 3461
		exitScene 6342
	)
)

