;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42050)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use BorderWindow)

(public
	rm2050 0
)

(instance rm2050 of P2Room
	(properties
		picture 2050
		north 42010
		south 42010
		east 42010
		west 42010
	)

	(method (init)
		(if (IsFlag 725)
			(= picture 2051)
		)
		(super init: &rest)
		(if (IsFlag 725)
			(if (IsFlag 713)
				(slime init:)
			else
				(damage init: 262 52 462 282)
			)
		)
		(gGame handsOn: 1)
	)
)

(instance slime of P2Fidget
	(properties
		x 226
		y 29
		view 2051
	)
)

(instance damage of P2Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self delVerb: 4)
		(self addVerb: 151)
	)

	(method (handleEvent event)
		(if (and (& (event type:) evMOUSERELEASE) (self seesVerb: gVerb))
			(event claimed: 1)
			(gP2SoundFX play: 42050)
			(gEgo put: 37) ; glopI
			(SetFlag 713)
			(= gVerb 4) ; Do
			(gTheCursor normalize:)
			(slime init: update:)
			(slime setScript: delayIt)
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
				(gCurRoom newRoom: 42010)
			)
		)
	)
)

