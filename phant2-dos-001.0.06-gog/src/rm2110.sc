;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42110)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use BorderWindow)

(public
	rm2110 0
)

(instance rm2110 of P2Room
	(properties
		picture 2110
		north 42080
		south 42080
		east 42080
		west 42080
	)

	(method (init)
		(super init: &rest)
		(alien3F init:)
		(alien3 init: setPri: 100)
		(gGame handsOn: 1)
	)
)

(instance alien3 of P2Fidget
	(properties
		x 232
		view 2110
		initStart 0
		initFinish 0
		cycleStart 0
		cycleFinish 3
	)
)

(instance alien3F of P2Feature
	(properties
		doneFlag 766
		invItem 36
		nextRoom 42080
	)

	(method (handleEvent event)
		(if (and (& (event type:) evMOUSERELEASE) (self seesVerb: gVerb))
			(event claimed: 1)
			(alien3 hide:)
			(alien3 setScript: delayIt)
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
				(gEgo get: 36) ; alien3I
				(SetFlag 766)
				(gCurRoom newRoom: 42080)
			)
		)
	)
)

