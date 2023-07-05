;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42305)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use BorderWindow)

(public
	rm2305 0
)

(instance rm2305 of P2Room
	(properties
		picture 2305
		north 42302
		south 42302
		east 42302
		west 42302
	)

	(method (init)
		(super init: &rest)
		(if (not (IsFlag 767))
			(slime2F init: 200 100 500 320)
			(slime2 init:)
		)
		(gGame handsOn: 1)
	)
)

(instance slime2F of P2Feature
	(properties)

	(method (handleEvent event)
		(if (and (& (event type:) evMOUSERELEASE) (self seesVerb: gVerb))
			(slime2 hide:)
			(slime2 setScript: delayIt)
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
				(gEgo get: 33) ; slime2I
				(SetFlag 767)
				(SetFlag 719)
				(gCurRoom newRoom: 42302)
			)
		)
	)
)

(instance slime2 of P2Fidget
	(properties
		x 253
		y 160
		view 2305
	)
)

