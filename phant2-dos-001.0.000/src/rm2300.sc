;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42300)
(include sci.sh)
(use Main)
(use nExit)
(use invItems)
(use ExitFeature)
(use P2Fidget)
(use BorderWindow)
(use Cycle)
(use Jump)

(public
	rm2300 0
)

(instance rm2300 of P2Room
	(properties
		picture 2300
	)

	(method (init)
		(super init: &rest)
		(curtis init: setScript: eatHimS)
		(hec init: setCycle: Fwd)
		(humanF init: 427 56 530 200)
		(exitF init: 0 285 400 406)
		(gGame handsOn: 1)
		(gEgo put: 2) ; cardKeyI
		(InvPlane recalc: 1)
		(gP2SongPlyr start: 5006)
		(= global212 0)
	)
)

(instance hec of Prop
	(properties
		x 294
		y 332
		view 12294
	)
)

(instance curtis of P2Fidget
	(properties
		x 52
		y 338
		view 12293
	)
)

(instance humanF of ExitFeature
	(properties
		sceneScored 1
		nextRoom 42302
		exitScene 10520
	)
)

(instance exitF of ExitFeature
	(properties
		sceneScored 1
		nextRoom 999
		exitDir 5
		exitScene 10510
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

