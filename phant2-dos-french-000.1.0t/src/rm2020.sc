;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42020)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)
(use P2Fidget)
(use BorderWindow)
(use Cel)
(use Cycle)
(use Jump)

(public
	rm2020 0
)

(instance rm2020 of P2Room
	(properties
		picture 2020
	)

	(method (init)
		(= picture (if (IsFlag 725) 2021 else 2020))
		(super init: &rest)
		(bottomOfPlatform init: 1 290 639 360)
		(ringDetail init: 76 130 138 208)
		(console init: 469 94 523 119)
		(glopDetail init: 317 45 344 103)
		(if (IsFlag 724)
			(eAlien init:)
		)
		(if (or (not (IsFlag 725)) (IsFlag 715))
			(bubble init: setCycle: Fwd)
		)
		(if (== gPrevRoomNum 9400) ; humanThresholdRm
			(gP2SongPlyr fadeIn: 42010)
		)
		(if (IsFlag 725)
			(curtis view: 12021)
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

(instance bubble of Prop
	(properties
		x 99
		y 44
		view 2020
	)
)

(instance eAlien of Cel
	(properties
		x 80
		y 119
		view 2021
	)
)

(instance ringDetail of P2Feature
	(properties
		nextRoom 42040
	)
)

(instance console of ExitFeature
	(properties
		nextRoom 42030
		exitScene 10180
	)
)

(instance bottomOfPlatform of ExitFeature
	(properties
		nextRoom 42070
		exitDir 5
		exitScene 10200
	)
)

(instance glopDetail of P2Feature
	(properties
		nextRoom 42090
	)
)

(instance curtis of P2Fidget
	(properties
		x 419
		y 184
		view 12020
		cycleSpeed 11
	)
)

