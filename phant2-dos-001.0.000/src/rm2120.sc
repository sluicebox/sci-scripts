;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42120)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use BorderWindow)

(public
	rm2120 0
)

(instance rm2120 of P2Room
	(properties
		picture 2120
		north 42060
		south 42060
		east 42060
		west 42060
	)

	(method (init)
		(super init: &rest)
		(alien2F init: 200 100 500 300)
		(alien2 init:)
		(gGame handsOn: 1)
	)
)

(instance alien2 of P2Fidget
	(properties
		x 242
		y 73
		view 2120
		initStart 0
		initFinish 0
		cycleStart 0
		cycleFinish 3
	)
)

(instance alien2F of P2Feature
	(properties)

	(method (handleEvent event)
		(if (and (& (event type:) evMOUSERELEASE) (self seesVerb: gVerb))
			(event claimed: 1)
			(alien2 hide:)
			(alien2 setScript: delayIt)
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
				(gEgo get: 32) ; alien2I
				(SetFlag 718)
				(gCurRoom newRoom: 42060)
			)
		)
	)
)

