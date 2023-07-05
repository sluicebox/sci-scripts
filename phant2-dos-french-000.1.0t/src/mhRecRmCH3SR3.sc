;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1033)
(include sci.sh)
(use Main)
(use nExit)
(use invItems)
(use n63002)
(use P2Feature)
(use P2Timer)
(use P2Fidget)
(use System)

(public
	mhRecRmCH3SR3 0
)

(instance mhRecRmCH3SR3 of P2Room
	(properties
		picture 520
		south 1013
		east 1013
		west 1013
	)

	(method (init)
		(ClearFlag 1001)
		(if (IsFlag 350)
			(door init:)
			(fidget init:)
		)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

(instance door of P2Feature
	(properties
		exitDir 1
	)

	(method (init)
		(= whoDoit doorCode)
		(super init: 356 2 461 214)
	)
)

(instance doorCode of Code
	(properties)

	(method (doit)
		(NurseTimer dispose:)
		(gGame handsOff:)
		(SetFlag 370)
		(SetFlag 371)
		(SetFlag 372)
		(gP2SongPlyr fadeOut: 0)
		(= global209 380)
		(gCurRoom newRoom: 900) ; mapRoom
		(InvPlane recalc: 1)
	)
)

(instance fidget of P2Fidget
	(properties
		x 349
		y 336
		view 15200
		cycleSpeed 8
		wiggler 1
		delay 1
		zone1aLeft 3
		zone1aRight 6
		zone1bLeft 7
		zone1bRight 12
		zone2aLeft 13
		zone2aRight 15
		zone2bLeft 16
		zone2bRight 18
		origin 320
	)

	(method (init)
		(super init:)
		(self setPri: 10)
	)
)

