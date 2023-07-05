;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9020)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use System)

(public
	humanThresholdKeyEntry 0
)

(instance humanThresholdKeyEntry of P2Room
	(properties
		picture 910
		east 9000
		west 9000
	)

	(method (init)
		(super init: &rest)
		(cardSlotF init: 216 230 424 317)
		(gGame handsOn: 1)
	)
)

(instance cardSlotF of P2Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self delVerb: 4)
		(self addVerb: 6)
		(self addVerb: 36)
		(= whoDoit slotCode)
	)
)

(instance slotCode of Code
	(properties)

	(method (doit)
		(switch gVerb
			(36 ; trevCardKeyI
				(SetFlag 750)
				(proc63002_7 6570)
				(gCurRoom newRoom: 9021) ; puzRm
			)
			(6 ; cardKeyI
				(= global209 6530)
				(gCurRoom newRoom: 999) ; poorSadDeadCrazyAlienSucker
			)
		)
	)
)

