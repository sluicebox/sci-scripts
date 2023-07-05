;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42040)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use BorderWindow)

(public
	rm2040 0
)

(instance rm2040 of P2Room
	(properties
		picture 2040
		north 42020
		south 42020
		east 42020
		west 42020
	)

	(method (init)
		(if (IsFlag 725)
			(= picture 2041)
		)
		(super init: &rest)
		(if (IsFlag 725)
			(if (IsFlag 724)
				(eAlien init:)
			else
				(damageF init: 247 207 373 290)
			)
		)
		(gGame handsOn: 1)
	)
)

(instance eAlien of P2Fidget
	(properties
		x 211
		y 191
		view 2041
	)
)

(instance damageF of P2Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self delVerb: 4)
		(self addVerb: 146)
	)

	(method (handleEvent event)
		(if (and (& (event type:) evMOUSERELEASE) (self seesVerb: gVerb))
			(event claimed: 1)
			(gP2SoundFX play: 42040)
			(gEgo put: 35) ; electricAlienI
			(= gVerb 4) ; Do
			(gTheCursor normalize:)
			(eAlien init:)
			(SetFlag 724)
			(eAlien setScript: delayIt)
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
				(gCurRoom newRoom: 42020)
			)
		)
	)
)

