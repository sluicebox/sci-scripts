;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2015)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)
(use P2Fidget)
(use Polygon)
(use System)

(public
	bedRoomCH5SR1 0
)

(instance bedRoomCH5SR1 of P2Room
	(properties
		picture 10
		style 0
		east 2025
	)

	(method (init)
		(hallFeat init: (hallPoly init:))
		(livingRoomFeat init: (lroomPoly init:))
		(mirrorFeat init:)
		(fidget init:)
		(super init: &rest)
		(if (and (IsFlag 705) (not (IsFlag 732)))
			(gP2SongPlyr start: 2950 70)
			(SetFlag 732)
			(ClearFlag 1001)
		)
		(gGame handsOn: 1)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance hallFeat of ExitFeature
	(properties
		nextRoom 2215
		exitDir 1
		exitScene 800
	)
)

(instance livingRoomFeat of ExitFeature
	(properties
		nextRoom 2125
		exitDir 7
		exitScene 1504
	)
)

(instance mirrorFeat of P2Feature
	(properties)

	(method (init)
		(if (IsFlag 700)
			(return 0)
		else
			(super init: (mirrorPoly init:))
			(if (IsFlag 702)
				(self delVerb: 4)
				(self addVerb: 23)
			)
			(= whoDoit mirrorCode)
		)
	)
)

(instance mirrorCode of Code
	(properties)

	(method (doit)
		(switch gVerb
			(4 ; Do
				(if (not (IsFlag 701))
					(= global211 1)
					(proc63002_7 1240)
					(SetFlag 701)
				else
					(= global211 1)
					(proc63002_7 1250)
					(SetFlag 702)
					(mirrorFeat delVerb: 4)
					(mirrorFeat addVerb: 23)
				)
			)
			(23 ; hammerI
				(mirrorFeat delVerb: 23)
				(= global211 1)
				(proc63002_7 1290)
				(SetFlag 700)
				(gEgo put: 14) ; hammerI
			)
		)
	)
)

(instance mirrorPoly of Polygon
	(properties)

	(method (init)
		(super init: 17 65 140 70 150 242 26 258)
		(return self)
	)
)

(instance lroomPoly of Polygon
	(properties)

	(method (init)
		(super init: 405 33 483 24 483 307 405 289)
		(return self)
	)
)

(instance hallPoly of Polygon
	(properties)

	(method (init)
		(super init: 484 24 530 16 534 297 484 307)
		(return self)
	)
)

(instance fidget of P2Fidget
	(properties
		x 315
		y 29
		view 10100
		cycleSpeed 8
		wiggler 1
		delay 1
		zone1aLeft 12
		zone1aRight 5
		zone1bLeft 4
		zone1bRight 0
		zone2aLeft 21
		zone2aRight 19
		zone2bLeft 18
		zone2bRight 15
	)

	(method (init)
		(super init:)
		(self setPri: 1)
		(curtisFeat init:)
	)
)

(instance curtisFeat of P2Feature
	(properties
		priority 100
	)

	(method (init)
		(super init: 240 7 380 317)
		(self delVerb: 4)
		(self addVerb: 21 28)
		(= whoDoit itemsOnCurtis)
	)
)

(instance itemsOnCurtis of Code
	(properties)

	(method (doit)
		(switch gVerb
			(21 ; lockerI
				(= global209 1801)
				(gCurRoom newRoom: 2180) ; livingRoomFootL
			)
			(28 ; dadLetterI
				(= global209 2145)
				(= global211 1)
				(SetFlag 315)
				(gCurRoom newRoom: 2125) ; livingRoomCH5SR2
			)
		)
	)
)

