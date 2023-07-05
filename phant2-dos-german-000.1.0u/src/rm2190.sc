;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42190)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use BorderWindow)
(use Cycle)
(use Jump)

(public
	rm2190 0
)

(instance rm2190 of P2Room
	(properties
		picture 2190
		west 42200
	)

	(method (init)
		(super init: &rest)
		(if (== gPrevRoomNum 42070)
			(gP2SongPlyr fadeIn: (if (IsFlag 725) 10211 else 10120))
		)
		(bigMessOlights init: setPri: 10 setCycle: Fwd)
		(stream init: 232 0 405 85)
		(barrier init: 106 140 550 397)
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

(instance bigMessOlights of Prop
	(properties
		x 124
		y 113
		view 12195
	)
)

(instance stream of P2Feature
	(properties
		scene 10320
	)
)

(instance barrier of P2Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self addVerb: 43)
	)

	(method (handleEvent event)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(not (& (event modifiers:) emSHIFT))
				(self seesVerb: gVerb)
			)
			(event claimed: 1)
			(cond
				((== gVerb 43) ; alienKeyI
					(gEgo put: 34) ; alienKeyI
					(= gVerb 4) ; Do
					(gTheCursor normalize:)
					(proc63002_7 10350)
					(gCurRoom newRoom: 42191)
				)
				((IsFlag 720)
					(proc63002_7 10340)
					(gCurRoom newRoom: 999) ; poorSadDeadCrazyAlienSucker
				)
				(else
					(proc63002_7 10330)
					(SetFlag 720)
				)
			)
		)
	)
)

(instance curtis of P2Fidget
	(properties
		x 239
		y 313
		view 12190
	)
)

