;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3064)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)
(use System)

(public
	mainHallRoomCH4SR6 0
)

(instance mainHallRoomCH4SR6 of P2Room
	(properties
		picture 112
		north 3014
		south 3024
	)

	(method (init)
		(gP2SongPlyr fadeIn: (if (IsFlag 521) 3041 else 3042))
		(super init: &rest)
		(exitDoorFeature init: (proc63002_10 246 215 238 73 375 78 374 204))
		(netRoomDoorFeature init: (proc63002_10 62 1 111 18 133 333 86 333))
		(paulsDoorFeature
			init: (proc63002_10 522 14 585 0 563 333 511 333)
			whoDoit: paulsDoorCode
		)
		(officeDoorFea init: (proc63002_10 446 35 460 23 457 333 441 318))
		(gGame handsOn: 1)
	)
)

(instance exitDoorFeature of ExitFeature
	(properties
		nextRoom 900
		exitScene 3370
	)
)

(instance netRoomDoorFeature of ExitFeature
	(properties
		nextRoom 3134
		exitScene 3321
	)
)

(instance paulsDoorFeature of P2Feature
	(properties)

	(method (init)
		(super init: &rest)
		(if (not (IsFlag 520))
			(self addVerb: 15)
		)
		(if (not (IsFlag 521))
			(self addVerb: 25)
		)
	)
)

(instance paulsDoorCode of Code
	(properties)

	(method (doit)
		(switch gVerb
			(15 ; screwdriverI
				(if (not (SetFlag 520))
					(proc63002_7 4742)
					(paulsDoorFeature delVerb: 15)
				)
			)
			(25 ; hairpinI
				(if (not (SetFlag 521))
					(= global209 4743)
					(gCurRoom newRoom: 4614) ; paulsOfficeRoomCH4SR1
				)
			)
			(else
				(if (IsFlag 521)
					(= global209 4371)
					(gCurRoom newRoom: 4614) ; paulsOfficeRoomCH4SR1
				else
					(proc63002_7 3322)
				)
			)
		)
	)
)

(instance officeDoorFea of ExitFeature
	(properties
		nextRoom 3314
		exitScene 3340
	)
)

