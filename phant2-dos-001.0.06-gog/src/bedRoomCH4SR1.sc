;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2014)
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
	bedRoomCH4SR1 0
)

(instance bedRoomCH4SR1 of P2Room
	(properties
		picture 10
		style 0
		east 2024
	)

	(method (init)
		(hallFeat init: (hallPoly init:))
		(livingRoomFeat init: (lroomPoly init:))
		(MirrorFeat init: (mirrorPoly init:))
		(fidget init:)
		(super init: &rest)
		(if (and (IsFlag 558) (not (IsFlag 562)))
			(gP2SongPlyr start: 2940 70)
			(SetFlag 562)
			(SetFlag 1001)
		)
		(gGame handsOn: 1)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance hallFeat of ExitFeature
	(properties
		nextRoom 2214
		exitDir 1
		exitScene 800
	)
)

(instance livingRoomFeat of ExitFeature
	(properties
		nextRoom 2124
		exitDir 7
		exitScene 1504
	)
)

(instance MirrorFeat of P2Feature
	(properties)

	(method (init)
		(if (IsFlag 500)
			(= scene 1170)
			(= doneFlag 501)
			(= sceneScored 1)
		else
			(= scene 1161)
			(= doneFlag 502)
		)
		(super init: &rest)
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
		(curtisFeat init:)
		(self setPri: 1)
	)
)

(instance curtisFeat of P2Feature
	(properties
		priority 100
	)

	(method (init)
		(super init: 240 7 380 317)
		(self delVerb: 4)
		(self addVerb: 30 21 28)
		(= whoDoit itemsOnCurtis)
	)
)

(instance itemsOnCurtis of Code
	(properties)

	(method (doit)
		(switch gVerb
			(30 ; mailBundleI
				(curtisFeat delVerb: 30)
				(= global211 1)
				(= global209 2425)
				(gEgo put: 20 get: 24) ; mailBundleI, thereseNoteI
				(SetFlag 1001)
				(gCurRoom newRoom: 2124) ; livingRoomCH4SR2
			)
			(21 ; lockerI
				(= global209 1801)
				(gCurRoom newRoom: 2180) ; livingRoomFootL
			)
			(28 ; dadLetterI
				(= global209 2145)
				(= global211 1)
				(SetFlag 315)
				(gCurRoom newRoom: 2124) ; livingRoomCH4SR2
			)
		)
	)
)

