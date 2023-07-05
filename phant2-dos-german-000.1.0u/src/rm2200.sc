;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42200)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use ExitFeature)
(use P2Fidget)
(use BorderWindow)
(use Cel)

(public
	rm2200 0
)

(instance rm2200 of P2Room
	(properties
		picture 2200
		east 42190
		west 42190
	)

	(method (init)
		(super init: &rest)
		(door init: 256 121 310 217)
		(cond
			((IsFlag 721)
				(food init:)
			)
			((IsFlag 765)
				(alien init:)
				(food init:)
				(alienAndFoodF init: 84 231 186 247)
			)
			(else
				(aliens init:)
				(aliensF init: 56 226 220 263)
			)
		)
		(curtis init: setScript: eatHimS)
		(gGame handsOn: 1)
	)
)

(instance eatHimS of Script
	(properties)

	(method (doit &tmp temp0)
		(if (!= scratch (= temp0 (GetTime 1))) ; SysTime12
			(= scratch temp0)
			(if (<= (-- seconds) 0)
				(self cue:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 40)
			)
			(1
				(gP2SoundFX play: 5001)
				(= seconds 20)
			)
			(2
				(= seconds 10)
			)
			(3
				(gP2SoundFX play: 5003)
				(= seconds 5)
			)
			(4
				(= seconds 3)
			)
			(5
				(= global209 10510)
				(gCurRoom newRoom: 999) ; poorSadDeadCrazyAlienSucker
			)
		)
	)
)

(instance door of ExitFeature
	(properties
		nextRoom 42010
		exitDir 7
		exitScene 10405
	)
)

(instance food of Cel
	(properties
		x 93
		y 221
		view 2200
		loop 2
	)
)

(instance aliens of P2Fidget
	(properties
		x 72
		y 221
		view 2200
		initStart 0
		initFinish 0
		cycleStart 0
		cycleFinish 3
	)
)

(instance aliensF of ExitFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self addVerb: 39)
	)

	(method (handleEvent event)
		(if (and (& (event type:) evMOUSERELEASE) (self seesVerb: gVerb))
			(event claimed: 1)
			(switch gVerb
				(4 ; Do
					(proc63002_7 10380)
					(aliens dispose:)
					(alien init:)
					(alienF init: 132 226 220 256)
					(self dispose:)
				)
				(39 ; alienFoodI
					(= gVerb 4) ; Do
					(gGame handsOff:)
					(gEgo put: 29) ; alienFoodI
					(SetFlag 765)
					(SetFlag 1007)
					(= global209 10380)
					(gCurRoom newRoom: 42201)
				)
			)
		)
	)
)

(instance alien of P2Fidget
	(properties
		x 156
		y 225
		view 2200
		loop 1
		initStart 0
		initFinish 0
		cycleStart 0
		cycleFinish 3
	)
)

(instance alienF of ExitFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self delVerb: 4)
		(self addVerb: 39)
	)

	(method (handleEvent event)
		(if (and (& (event type:) evMOUSERELEASE) (self seesVerb: gVerb))
			(event claimed: 1)
			(gEgo put: 29) ; alienFoodI
			(SetFlag 765)
			(SetFlag 1007)
			(gCurRoom newRoom: 42201)
		)
	)
)

(instance alienAndFoodF of ExitFeature
	(properties
		nextRoom 42201
		exitDir 0
	)
)

(instance curtis of P2Fidget
	(properties
		x 368
		y 335
		view 12200
	)
)

