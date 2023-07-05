;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42280)
(include sci.sh)
(use Main)
(use nExit)
(use ExitFeature)
(use P2Fidget)
(use BorderWindow)

(public
	rm2280 0
)

(instance rm2280 of P2Room
	(properties
		picture 2280
	)

	(method (init)
		(super init: &rest)
		(humanF init: 300 110 450 240)
		(curtis init: setScript: eatHimS)
		(gGame handsOn: 1)
		(gP2SongPlyr fadeIn: 42280)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 42290)
			(= global211 1)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance humanF of ExitFeature
	(properties
		nextRoom 42290
		exitScene 10500
	)
)

(instance curtis of P2Fidget
	(properties
		x 42
		y 338
		view 12280
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

