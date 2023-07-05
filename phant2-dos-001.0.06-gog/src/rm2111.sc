;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42111)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use BorderWindow)

(public
	rm2111 0
)

(instance rm2111 of P2Room
	(properties
		picture 2111
		north 42070
		south 42070
		east 42070
		west 42070
	)

	(method (init)
		(super init: &rest)
		(alienF init: 318 78 574 273)
		(alien init:)
		(gGame handsOn: 1)
	)
)

(instance alien of P2Fidget
	(properties
		x 318
		y 71
		view 2111
		initStart 0
		initFinish 0
		cycleStart 0
		cycleFinish 3
	)
)

(instance alienF of P2Feature
	(properties)

	(method (handleEvent event)
		(if (and (& (event type:) evMOUSERELEASE) (self seesVerb: gVerb))
			(alien hide:)
			(alien setScript: delayIt)
		)
	)
)

(instance delayIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 30)
			)
			(1
				(gEgo get: 30) ; alienI
				(SetFlag 719)
				(gCurRoom newRoom: 42070)
			)
		)
	)
)

