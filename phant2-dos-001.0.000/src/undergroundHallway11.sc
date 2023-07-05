;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3485)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)
(use P2Fidget)
(use System)

(public
	undergroundHallway11 0
)

(instance undergroundHallway11 of P2Room
	(properties
		picture 801
		south 3484
	)

	(method (init)
		(if (not (IsFlag 737))
			(SetFlag 737)
		)
		(super init: &rest)
		(if (IsFlag 733)
			(unlockedDoorF init: 93 9 465 250 whoDoit: playTheEnterSong)
		else
			(lockPuzzleF init: 502 210 565 247)
			(doorF init: 93 9 465 292)
		)
		(gGame handsOn: 1)
	)
)

(instance doorF of P2Feature
	(properties
		scene 6420
		doneFlag 736
	)
)

(instance unlockedDoorF of ExitFeature
	(properties
		nextRoom 9000
		exitScene 6442
	)
)

(instance playTheEnterSong of Code
	(properties)

	(method (doit)
		(gP2SongPlyr fadeIn: 811)
	)
)

(instance lockPuzzleF of ExitFeature
	(properties
		nextRoom 3486
	)
)

(instance curtis of P2Fidget ; UNUSED
	(properties
		y 336
		view 18010
	)
)

