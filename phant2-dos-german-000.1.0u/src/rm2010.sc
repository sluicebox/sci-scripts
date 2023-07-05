;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42010)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)
(use P2Fidget)
(use BorderWindow)
(use Cel)

(public
	rm2010 0
)

(instance rm2010 of P2Room
	(properties
		picture 2010
		south 42080
		east 42060
		west 42070
	)

	(method (init)
		(= picture (if (IsFlag 725) 2011 else 2010))
		(super init: &rest)
		(if (IsFlag 713)
			(pipeFix init:)
		)
		(if (IsFlag 724)
			(ringFix init:)
		)
		(topOfPlatform init: 40 0 320 110)
		(pipeDetail init: 482 203 550 254)
		(if (== gPrevRoomNum 42200)
			(if (IsFlag 725)
				(gP2SongPlyr fadeIn: 10505)
			else
				(gP2SongPlyr fadeIn: 42010)
			)
		)
		(curtis init: setScript: eatHimS)
		(gGame handsOn: 1)
	)
)

(instance pipeFix of Cel
	(properties
		x 461
		y 143
		view 2011
	)
)

(instance ringFix of Cel
	(properties
		x 151
		y 101
		view 2011
		loop 1
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

(instance topOfPlatform of ExitFeature
	(properties
		nextRoom 42020
		exitDir 0
		exitScene 10210
	)
)

(instance pipeDetail of P2Feature
	(properties
		nextRoom 42050
	)
)

(instance curtis of P2Fidget
	(properties
		x 363
		y 338
		view 12010
	)
)

