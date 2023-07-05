;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9000)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)
(use P2Fidget)
(use Cel)
(use System)

(public
	threshCompRm 0
)

(instance threshCompRm of P2Room
	(properties
		picture 810
	)

	(method (init)
		(super init: &rest)
		(thresholdDoorF init: 233 47 308 131)
		(doorF init: 398 40 485 208)
		(if (IsFlag 747)
			(thresholdDoorF nextRoom: 9400 scene: 6581)
		else
			(cardKeyBoxCel init:)
		)
		(consoleF init: 0 135 160 193)
		(if (or (IsFlag 764) (and (IsFlag 580) (!= gChapter 5)))
			(SetFlag 574)
			(cardKeyBoxF init: 337 78 364 110)
		)
		(if (OneOf gPrevRoomNum 3486 3485) ; threshLock, undergroundHallway11
			(curtis init:)
		else
			(curtis2 init:)
		)
		(gGame handsOn: 1)
	)
)

(instance doorF of ExitFeature
	(properties
		nextRoom 3484
		exitScene 6501
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(ClearFlag 1005)
			(if (== gChapter 4)
				(gP2SongPlyr fadeIn: 4771)
			else
				(gP2SongPlyr fadeIn: 4772)
			)
		)
		(event claimed:)
	)
)

(instance consoleF of ExitFeature
	(properties
		nextRoom 3000
	)

	(method (init)
		(switch gChapter
			(4
				(if (IsFlag 580)
					(return 0)
				)
			)
			(5
				(if (IsFlag 764)
					(return 0)
				)
			)
		)
		(if (IsFlag 740)
			(= exitScene 6510)
		else
			(= exitScene 6500)
			(= doneFlag 740)
		)
		(super init: &rest)
	)
)

(instance curtis of P2Fidget
	(properties
		x 385
		y 247
		view 18100
	)
)

(instance curtis2 of P2Fidget
	(properties
		x 172
		y 319
		view 18101
	)
)

(instance thresholdDoorF of P2Feature
	(properties
		scene 6520
	)
)

(instance cardKeyBoxF of P2Feature
	(properties
		nextRoom 9020
	)
)

(instance cardKeyBoxCel of Cel
	(properties
		priority 10
		x 339
		y 106
		view 810
	)
)

