;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42060)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)
(use P2Fidget)
(use BorderWindow)

(public
	rm2060 0
)

(instance rm2060 of P2Room
	(properties
		picture 2070
		east 42080
		west 42010
	)

	(method (init)
		(super init: &rest)
		(if (not (IsFlag 718))
			(alien1 init:)
			(a1F init: 520 262 610 301)
		)
		(curtis init:)
		(if (IsFlag 725)
			(door init: 440 121 534 240)
		else
			(curtis setScript: eatHimS)
		)
		(gGame handsOn: 1)
	)
)

(instance alien1 of P2Fidget
	(properties
		x 535
		y 271
		view 2070
		initStart 0
		initFinish 0
		cycleStart 0
		cycleFinish 3
	)
)

(instance a1F of P2Feature
	(properties
		nextRoom 42120
	)
)

(instance door of ExitFeature
	(properties
		nextRoom 42302
		exitScene 10010
	)
)

(instance curtis of P2Fidget
	(properties
		x 137
		y 338
		view 12070
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

