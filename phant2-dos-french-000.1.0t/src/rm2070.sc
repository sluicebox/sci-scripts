;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42070)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)
(use P2Fidget)
(use BorderWindow)

(public
	rm2070 0
)

(instance rm2070 of P2Room
	(properties
		picture 2060
		east 42010
		west 42080
	)

	(method (init)
		(super init: &rest)
		(door init: 194 157 236 230)
		(if (not (IsFlag 719))
			(alien2 init:)
			(a2F init: 75 265 150 302)
		)
		(curtis init: setScript: eatHimS)
		(topOfPlatform init: 374 0 640 110)
		(gGame handsOn: 1)
	)
)

(instance alien2 of P2Fidget
	(properties
		x 86
		y 273
		view 2060
		initStart 0
		initFinish 0
		cycleStart 0
		cycleFinish 3
	)
)

(instance a2F of P2Feature
	(properties
		nextRoom 42111
	)
)

(instance door of ExitFeature
	(properties
		nextRoom 42190
		exitDir 7
		exitScene 10120
	)
)

(instance topOfPlatform of ExitFeature
	(properties
		nextRoom 42020
		exitDir 1
		exitScene 10210
	)
)

(instance curtis of P2Fidget
	(properties
		x 219
		y 337
		view 12060
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

