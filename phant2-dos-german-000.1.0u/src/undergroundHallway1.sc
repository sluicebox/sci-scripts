;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3414)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)

(public
	undergroundHallway1 0
)

(local
	[local0 4] = [269 85 401 205]
)

(instance undergroundHallway1 of P2Room
	(properties
		picture 730
		south 3425
		east 3424
	)

	(method (init)
		(if (< 3000 gPrevRoomNum 3414) ; humanThresholdScreen, undergroundHallway1
			(if (IsFlag 582)
				(proc63002_7 4773)
			else
				(SetFlag 582)
				(proc63002_7 4770)
			)
			(proc63002_7 4771)
			(if (== gChapter 4)
				(gP2SongPlyr fadeIn: 4771)
			else
				(gP2SongPlyr fadeIn: 4772)
			)
		)
		(super init: &rest)
		(doorF init: [local0 0] [local0 1] [local0 2] [local0 3])
		(curtis init:)
		(gGame handsOn: 1)
	)
)

(instance doorF of P2Feature
	(properties
		nextRoom 3434
	)

	(method (handleEvent)
		(if (super handleEvent: &rest)
			(= global209
				(cond
					((not (SetFlag 529))
						(SetFlag 529)
						6340
					)
					((== gChapter 4) 6341)
					((not (IsFlag 738))
						(SetFlag 738)
						6450
					)
					(else 6341)
				)
			)
		)
	)
)

(instance curtis of P2Fidget
	(properties
		x 345
		y 338
		view 17300
		initStart 1
		initFinish 2
		cycleStart 2
		cycleFinish 5
	)
)

