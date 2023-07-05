;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3434)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2View)
(use ExitFeature)
(use P2Fidget)

(public
	undergroundHallway4 0
)

(local
	[local0 4] = [291 99 392 197]
)

(instance undergroundHallway4 of P2Room
	(properties
		picture 750
		south 3454
	)

	(method (init &tmp temp0 temp1)
		(= temp0 global209)
		(= temp1 (gP2SongPlyr volPercent:))
		(if (== temp0 6450)
			(gP2SongPlyr fadeTo: 66)
		)
		(super init: &rest)
		(if (== temp0 6450)
			(gP2SongPlyr fadeTo: temp1)
		)
		(jacketF init:)
		(northF init: [local0 0] [local0 1] [local0 2] [local0 3])
		(curtis init:)
		(gGame handsOn: 1)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 3425) ; undergroundHallway3
			(= global209 6341)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance jacketF of P2View
	(properties
		x 385
		y 305
		view 750
		scene 6350
		fadeToVol 66
		nextRoom 3444
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 530)
			(self delVerb: 4)
		)
	)

	(method (handleEvent)
		(super handleEvent: &rest)
		(SetFlag 530)
		(self delVerb: 4)
	)
)

(instance northF of ExitFeature
	(properties
		nextRoom 3444
		exitDir 0
	)
)

(instance curtis of P2Fidget
	(properties
		x 249
		y 338
		view 17500
		initStart 1
		initFinish 2
		cycleStart 2
		cycleFinish 5
	)
)

