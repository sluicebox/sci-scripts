;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42191)
(include sci.sh)
(use Main)
(use nExit)
(use P2Feature)
(use ExitFeature)
(use P2Fidget)
(use BorderWindow)
(use Cycle)
(use Jump)

(public
	rm2191 0
)

(instance rm2191 of P2Room
	(properties
		picture 0
	)

	(method (init)
		(super init: &rest)
		(stream init: setPri: 200 setCycle: Fwd)
		(streamF init: 230 70 640 406)
		(curtis init:)
		(barrier init: 0 70 160 406)
		(gGame handsOn: 1)
	)
)

(instance eatHimS of Script ; UNUSED
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
				(gP2SoundFX play: 5003)
				(= seconds 5)
			)
			(3
				(= global209 10510)
				(gCurRoom newRoom: 999) ; poorSadDeadCrazyAlienSucker
			)
		)
	)
)

(instance stream of Prop
	(properties
		view 12191
	)
)

(instance streamF of ExitFeature
	(properties
		nextRoom 42280
		exitScene 10370
	)
)

(instance barrier of P2Feature
	(properties
		scene 10375
		nextRoom 999
		exitDir 6
	)
)

(instance curtis of P2Fidget
	(properties
		x 345
		y 338
		view 12191
	)
)

