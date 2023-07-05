;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4644)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2View)
(use System)

(public
	paulsOfficeRoomCH4SR4 0
)

(instance paulsOfficeRoomCH4SR4 of P2Room
	(properties
		picture 340
		east 4634
		west 4624
	)

	(method (init)
		(gP2SongPlyr fadeIn: 3041)
		(super init: &rest)
		(paulsComputer
			init:
			addTarget: (proc63002_10 439 54 443 0 592 0 561 104)
		)
		(paulsDrawer init: (proc63002_10 183 283 495 280 493 300 185 302))
		(gGame handsOn: 1)
	)
)

(instance paulsComputer of P2View
	(properties
		x 448
		y 61
		view 342
		nextRoom 4654
	)

	(method (init)
		(super init: &rest)
	)
)

(instance paulsDrawer of P2Feature
	(properties)

	(method (init)
		(super init: &rest)
		(if (not (IsFlag 577))
			(self addVerb: 15)
		)
		(= whoDoit drawerCode)
	)
)

(instance drawerCode of Code
	(properties)

	(method (doit)
		(cond
			((== gVerb 15) ; screwdriverI
				(SetFlag 577)
				(= global209 6895)
				(gCurRoom newRoom: 4650) ; paulsOfficeRoomSR5
			)
			((IsFlag 577)
				(= global209 6776)
				(gCurRoom newRoom: 4650) ; paulsOfficeRoomSR5
			)
			(else
				(proc63002_7 6875)
			)
		)
	)
)

