;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4201)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use System)

(public
	theresesCubicleRoomCH1 0
)

(instance theresesCubicleRoomCH1 of P2Room
	(properties
		picture 250
		south 3341
	)

	(method (init)
		(if (gRoboGary isPlaying:)
			(gRoboGary fadeTo: 80)
		else
			(gP2SongPlyr fadeTo: 80)
		)
		(= global241 60)
		(if (not (IsFlag 70))
			(thereseProp init: setPri: 1)
			(therese init: whoDoit: thereseCode)
		else
			(= picture 251)
		)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

(instance thereseProp of P2Fidget
	(properties
		x 219
		y 338
		view 12500
		initStart 0
		initFinish 0
		cycleStart 7
	)

	(method (handleEvent)
		(therese handleEvent: &rest)
	)
)

(instance therese of P2Feature
	(properties
		priority 2
	)

	(method (onMe)
		(return (thereseProp onMe: &rest))
	)

	(method (init)
		(if (super init: &rest)
			(if (not (IsFlag 34))
				(self addVerb: 11)
			)
			(if (not (thereseUsesDo doit:))
				(self delVerb: 4)
			)
		)
	)
)

(instance thereseUsesDo of Code
	(properties)

	(method (doit)
		(if
			(or
				(and (IsFlag 24) (not (IsFlag 35)))
				(and (IsFlag 26) (not (IsFlag 36)))
				(not (IsFlag 37))
			)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance thereseCode of Code
	(properties)

	(method (doit)
		(cond
			((== gVerb 11) ; sexyCardI
				(if (not (SetFlag 34))
					(proc63002_7 3750)
				)
				(therese delVerb: 11)
			)
			((and (IsFlag 24) (not (SetFlag 35)))
				(proc63002_7 4280)
			)
			((and (IsFlag 26) (not (SetFlag 36)))
				(proc63002_7 4260)
			)
			((not (SetFlag 37))
				(proc63002_7 3690)
				((gWynNet findItem: 6301 3 0 33 2) availableTo: 16 1)
			)
		)
		(if (not (thereseUsesDo doit:))
			(therese delVerb: 4)
		)
	)
)

