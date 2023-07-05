;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6414)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use System)

(public
	blBackCH4SR1 0
)

(instance blBackCH4SR1 of P2Room
	(properties
		picture 461
		south 6214
	)

	(method (init)
		(super init: &rest)
		(backDoor init:)
		(if (IsFlag 547)
			(if (not (IsFlag 549))
				(bouncerRope init:)
				(bouncer init:)
			)
		else
			(bouncerNoRope init:)
		)
		(gP2SongPlyr fadeTo: 75)
		(gGame handsOn: 1)
	)
)

(instance backDoor of P2Feature
	(properties)

	(method (init)
		(cond
			((IsFlag 545)
				(cond
					((IsFlag 549)
						(= global209 8195)
						(= exitDir 0)
						(= nextRoom 6424)
						(super init: 373 42 477 216)
					)
					((not (IsFlag 547))
						(= doneFlag 547)
						(= scene 8040)
						(= exitDir 0)
						(= whoDoit stoppedCode)
						(super init: 373 42 477 216)
					)
				)
			)
			((not (IsFlag 546))
				(= doneFlag 546)
				(= scene 8190)
				(= exitDir 0)
				(super init: 373 42 477 216)
			)
		)
	)
)

(instance bouncer of P2Feature
	(properties)

	(method (init)
		(if (not (IsFlag 549))
			(super init: (proc63002_10 419 299 459 136 518 93 538 96 551 296))
			(= whoDoit bouncerCode)
			(self addVerb: 34)
			(if (not (IsFlag 548))
				(self addVerb: 12 11)
			)
			(self delVerb: 4)
		else
			(return 0)
		)
	)
)

(instance bouncerCode of Code
	(properties)

	(method (doit)
		(switch gVerb
			(34 ; thereseNoteI
				(SetFlag 549)
				(= global209 8070)
				(gCurRoom newRoom: 6424) ; blBackCH4SR2
			)
			(12 ; bondageCardI
				(SetFlag 548)
				(proc63002_7 8050)
				(bouncer delVerb: 12 11)
			)
			(11 ; sexyCardI
				(SetFlag 548)
				(proc63002_7 8050)
				(bouncer delVerb: 12 11)
			)
		)
	)
)

(instance stoppedCode of Code
	(properties)

	(method (doit)
		(bouncer init:)
		(bouncerNoRope dispose:)
		(bouncerRope init:)
	)
)

(instance bouncerRope of P2Fidget
	(properties
		x 409
		y 339
		view 14602
		initStart 2
		initFinish 3
		cycleStart 5
		cycleFinish 9
	)

	(method (init)
		(super init: &rest)
		(self setPri: 15)
	)
)

(instance bouncerNoRope of P2Fidget
	(properties
		x 467
		y 331
		view 14601
		initStart 2
		initFinish 3
		cycleStart 5
		cycleFinish 9
	)

	(method (init)
		(super init: &rest)
		(self setPri: 15)
	)
)

