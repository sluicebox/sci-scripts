;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6424)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)
(use PolyEdit)

(public
	blBackCH4SR2 0
)

(instance blBackCH4SR2 of P2Room
	(properties
		picture 830
	)

	(method (init)
		(super init: &rest)
		(gP2SongPlyr fadeIn: 6940 75)
		(if (!= gPrevRoomNum 6434) ; blBackCH4SR3
			(= global246 (Random 1 2))
			(= global247 (Random 2 3))
			(= global248 (Random 0 1))
			(= global249 (Random 2 3))
		)
		(topDoor init:)
		(botDoor init:)
		(exitFeat init:)
		(piece1 init:)
		(piece2 init:)
		(piece3 init:)
		(piece4 init:)
		(gGame handsOn: 1)
	)
)

(instance topDoor of ExitFeature
	(properties)

	(method (init)
		(if (IsFlag 555)
			(= exitScene 8196)
			(= nextRoom 6454)
		else
			(= doneFlag 550)
			(= scene 8198)
		)
		(super init: 238 6 548 255)
	)
)

(instance botDoor of P2Feature
	(properties
		priority 500
		nextRoom 6434
	)

	(method (init)
		(if (not (IsFlag 555))
			(super init: (proc63002_10 369 261 419 264 419 318 365 316))
		)
	)
)

(instance exitFeat of ExitFeature
	(properties
		nextRoom 6414
		exitDir 4
		exitScene 8197
	)

	(method (init)
		(super init: 64 298 580 334)
	)
)

(instance piece1 of View
	(properties
		view 830
	)

	(method (init)
		(if (IsFlag 555)
			(= x 374)
			(= y 286)
			(= cel 0)
		else
			(= x 369)
			(= y 279)
			(= cel global246)
		)
		(super init: &rest)
	)
)

(instance piece2 of View
	(properties
		view 830
		loop 1
	)

	(method (init)
		(if (IsFlag 555)
			(= x 393)
			(= y 289)
			(= cel 0)
		else
			(= x 401)
			(= y 281)
			(= cel global247)
		)
		(super init: &rest)
	)
)

(instance piece3 of View
	(properties
		view 830
		loop 2
	)

	(method (init)
		(if (IsFlag 555)
			(= x 392)
			(= y 310)
			(= cel 0)
		else
			(= x 400)
			(= y 314)
			(= cel global248)
		)
		(super init: &rest)
	)
)

(instance piece4 of View
	(properties
		view 830
		loop 3
	)

	(method (init)
		(if (IsFlag 555)
			(= x 373)
			(= y 308)
			(= cel 0)
		else
			(= x 368)
			(= y 311)
			(= cel global249)
		)
		(super init: &rest)
	)
)

