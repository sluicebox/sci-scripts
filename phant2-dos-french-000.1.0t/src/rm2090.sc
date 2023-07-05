;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42090)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use BorderWindow)
(use Jump)

(public
	rm2090 0
)

(instance rm2090 of P2Room
	(properties
		picture 2090
		north 42020
		south 42020
		east 42020
		west 42020
	)

	(method (init)
		(super init: &rest)
		(if (not (IsFlag 716))
			(glop init:)
			(gF init: 349 0 552 406)
		)
		(gGame handsOn: 1)
	)
)

(instance gF of P2Feature
	(properties)

	(method (handleEvent event)
		(if (and (& (event type:) evMOUSERELEASE) (self seesVerb: gVerb))
			(glop hide:)
			(glop setScript: delayIt)
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
				(gEgo get: 31) ; slimeI
				(SetFlag 716)
				(gCurRoom newRoom: 42020)
			)
		)
	)
)

(instance glop of Prop
	(properties
		x 382
		y 135
		view 2090
	)
)

