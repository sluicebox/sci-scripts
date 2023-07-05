;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5015)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use PolyEdit)
(use System)

(public
	harburgCH5SR1 0
)

(instance harburgCH5SR1 of P2Room
	(properties
		picture 960
	)

	(method (init)
		(ClearFlag 1001)
		(curtisOTS init:)
		(phoneFeat init:)
		(desk init:)
		(super init: &rest)
		(gP2SongPlyr start: 5960 65)
		(gGame handsOn: 1)
	)
)

(instance phoneFeat of P2Feature
	(properties
		priority 30
		scene 7640
		sceneScored 1
		doneFlag 728
	)

	(method (init)
		(super init: 246 151 296 203)
		(= whoDoit phoneCode)
	)
)

(instance phoneCode of Code
	(properties)

	(method (doit)
		(curtisOTS dispose:)
		(curtisDesk init:)
		(phoneView init: setPri: 10)
	)
)

(instance desk of P2Feature
	(properties
		priority 10
		exitDir 4
	)

	(method (init)
		(super init: (proc63002_10 54 167 236 125 288 165 108 231))
		(= whoDoit deskCode)
	)
)

(instance deskCode of Code
	(properties)

	(method (doit)
		(gP2SongPlyr fadeOut: 0)
		(= global209 7650)
		(gCurRoom newRoom: 5025) ; harburgCH5SR2
	)
)

(instance curtisOTS of P2Fidget
	(properties
		x 369
		y 335
		view 19600
		cycleSpeed 8
		wiggler 1
		delay 1
		zone1aLeft 7
		zone1aRight 11
		zone1bLeft 12
		zone1bRight 16
		zone2aLeft 17
		zone2aRight 20
		zone2bLeft 21
		zone2bRight 25
	)

	(method (init)
		(super init:)
		(self setPri: 1)
	)
)

(instance curtisDesk of P2Fidget
	(properties
		x 297
		y 298
		view 19601
		cycleSpeed 8
		initStart 0
		initFinish 0
		cycleStart 3
		cycleFinish 6
	)

	(method (init)
		(super init:)
		(self setPri: 1)
	)
)

(instance phoneView of View
	(properties
		x 225
		y 220
		view 960
	)
)

