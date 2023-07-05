;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2013)
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
	bedRoomCH3SR1 0
)

(instance bedRoomCH3SR1 of P2Room
	(properties
		picture 10
		style 0
		east 2023
	)

	(method (init)
		(hallFeat init: (hallPoly init:))
		(livingRoomFeat init: (lroomPoly init:))
		(MirrorFeat init: (mirrorPoly init:))
		(fidget init:)
		(super init: &rest)
		(if (not (IsFlag 328))
			(ClearFlag 1001)
			(SetFlag 328)
			(gP2SongPlyr start: 2805 70)
		)
		(gGame handsOn: 1)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance hallFeat of ExitFeature
	(properties
		nextRoom 2213
		exitDir 1
		exitScene 800
	)
)

(instance livingRoomFeat of ExitFeature
	(properties
		nextRoom 2123
		exitDir 7
		exitScene 1504
	)
)

(instance MirrorFeat of P2Feature
	(properties)

	(method (init)
		(if (IsFlag 308)
			(= scene 1020)
			(= sceneScored 1)
			(= doneFlag 302)
		else
			(= scene 1010)
			(= doneFlag 303)
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

(instance phoneExit of ExitFeature ; UNUSED
	(properties
		nextRoom 2123
		exitDir 7
		exitScene 1504
	)

	(method (init)
		(super init: (proc63002_10 403 23 498 10 498 304 403 304))
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
				(= global209 2065)
				(gEgo put: 20) ; mailBundleI
				(if (IsFlag 310)
					(SetFlag 1001)
				)
				(gCurRoom newRoom: 2123) ; livingRoomCH3SR2
			)
			(21 ; lockerI
				(= global209 1801)
				(gCurRoom newRoom: 2143) ; livingRoomCH3SR4
			)
			(28 ; dadLetterI
				(= global209 2145)
				(= global211 1)
				(SetFlag 315)
				(gCurRoom newRoom: 2123) ; livingRoomCH3SR2
			)
		)
	)
)

