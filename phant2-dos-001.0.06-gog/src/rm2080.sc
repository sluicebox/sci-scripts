;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42080)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)
(use P2Fidget)
(use BorderWindow)

(public
	rm2080 0
)

(instance rm2080 of P2Room
	(properties
		picture 2080
		south 42010
		east 42070
		west 42060
	)

	(method (init)
		(super init: &rest)
		(if (not (IsFlag 766))
			(alien3 init:)
			(a3F init: 490 241 600 270)
		)
		(if (not (IsFlag 717))
			(eFood init:)
			(eF init: 215 197 331 231)
		)
		(curtis init: setScript: eatHimS)
		(gGame handsOn: 1)
	)
)

(instance eFood of P2Fidget
	(properties
		x 231
		y 205
		view 2080
		initStart 0
		initFinish 0
		cycleStart 0
		cycleFinish 3
	)
)

(instance eF of ExitFeature
	(properties
		nextRoom 42091
		exitScene 10190
	)
)

(instance alien3 of P2Fidget
	(properties
		x 511
		y 244
		view 2080
		loop 1
		initStart 0
		initFinish 0
		cycleStart 0
		cycleFinish 3
	)
)

(instance a3F of P2Feature
	(properties
		nextRoom 42110
	)
)

(instance curtis of P2Fidget
	(properties
		x 345
		y 338
		view 12191
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

