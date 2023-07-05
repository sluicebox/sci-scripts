;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42290)
(include sci.sh)
(use Main)
(use nExit)
(use invItems)
(use ExitFeature)
(use P2Fidget)
(use BorderWindow)

(public
	rm2290 0
)

(instance rm2290 of P2Room
	(properties
		picture 2290
	)

	(method (init)
		(super init: &rest)
		(humanF init: 427 56 530 200)
		(exitF init: 0 285 400 406)
		(curtis init: setScript: eatHimS)
		(gGame handsOn: 1)
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
		doneFlag 725
		nextRoom 1006
		exitScene 10505
	)

	(method (handleEvent event)
		(if (and (& (event type:) evMOUSEBUTTON) (self seesVerb: gVerb))
			(gP2SongPlyr fadeOut:)
			(InvPlane recalc: 0)
			(super handleEvent: event &rest)
		)
	)
)

(instance exitF of ExitFeature
	(properties
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

