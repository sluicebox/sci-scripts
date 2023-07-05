;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3474)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2View)
(use P2Fidget)

(public
	undergroundHallway9 0
)

(local
	[local0 8] = [380 50 420 200 100 230 150 270]
)

(instance undergroundHallway9 of P2Room
	(properties
		picture 780
		south 3484
	)

	(method (init &tmp temp0 temp1)
		(= temp0 global209)
		(= temp1 (gP2SongPlyr volPercent:))
		(if (== temp0 6370)
			(gP2SongPlyr fadeTo: 66)
		)
		(super init: &rest)
		(if (== temp0 6370)
			(gP2SongPlyr fadeTo: temp1)
		)
		(northF init: [local0 0] [local0 1] [local0 2] [local0 3])
		(blanketF init:)
		(curtis init:)
		(gGame handsOn: 1)
	)
)

(instance curtis of P2Fidget
	(properties
		x 284
		y 336
		view 17800
		initStart 1
		initFinish 2
	)
)

(instance northF of P2Feature
	(properties
		nextRoom 3485
	)
)

(instance blanketF of P2View
	(properties
		x 137
		y 307
		view 780
		scene 6475
		fadeToVol 66
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 739)
			(self delVerb: 4)
		)
	)

	(method (handleEvent)
		(super handleEvent: &rest)
		(SetFlag 739)
		(self delVerb: 4)
	)
)

