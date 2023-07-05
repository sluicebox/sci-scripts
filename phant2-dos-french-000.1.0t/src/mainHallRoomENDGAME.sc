;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3006)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use BorderWindow)
(use Cycle)
(use Jump)
(use System)

(public
	mainHallRoomENDGAME 0
)

(instance mainHallRoomENDGAME of P2Room
	(properties
		picture 702
	)

	(method (init)
		(= global241 0)
		(Lock rsSCRIPT 30061 1)
		(if (not (IsFlag 1500))
			(= south 3007)
			(gEgo put: 2) ; cardKeyI
			(gEgo put: 26) ; trevCardKeyI
		)
		(super init: &rest)
		(if (and (IsFlag 1500) (not (== (gP2SongPlyr number:) 3062)))
			(gP2SongPlyr start: 3062)
		)
		(if (not (OneOf (gP2SongPlyr number:) 3061 3062))
			(gP2SongPlyr stop:)
			(gP2SongPlyr start: 3061)
		)
		(curtis init:)
		(trev init:)
		(deadTrevF init: trev whoDoit: checkForAllClickedCode)
		(tom init: setPri: 20)
		(deadTomF init: tom whoDoit: checkForAllClickedCode)
		(bob init: setPri: 1)
		(deadBobF init: bob whoDoit: checkForAllClickedCode)
		(elevatorF
			init: (proc63002_10 450 79 493 26 549 88 629 335 506 335 461 235)
			addVerb: 6
		)
		((ScriptID 30061 0) start:) ; zombiesTimer
		(sTomNBob startState: (* 2 (Random 0 1)))
		(sTomNBob init:)
		(checkForAllClickedCode doit:)
		(gGame handsOn: 1)
	)

	(method (dispose)
		(sTomNBob dispose:)
		(super dispose:)
	)
)

(instance elevatorF of P2Feature
	(properties
		nextRoom 3008
	)
)

(instance curtis of P2Fidget
	(properties
		y 335
		view 17020
		initStart 0
		initFinish 0
	)
)

(instance trev of P2Fidget
	(properties
		x 212
		y 338
		view 17022
		initStart 0
		initFinish 0
		cycleStart 0
		cycleFinish 0
	)
)

(instance deadTrevF of P2Feature
	(properties
		scene 4960
		doneFlag 1501
	)

	(method (dispose)
		(= target 0)
		(super dispose:)
	)
)

(instance tom of Prop
	(properties
		x 362
		y 322
		view 17021
	)
)

(instance deadTomF of P2Feature
	(properties
		scene 4980
		doneFlag 1503
	)

	(method (dispose)
		(= target 0)
		(super dispose:)
	)
)

(instance bob of Prop
	(properties
		x 341
		y 335
		view 17023
	)
)

(instance deadBobF of P2Feature
	(properties
		scene 4970
		doneFlag 1502
	)

	(method (dispose)
		(= target 0)
		(super dispose:)
	)
)

(instance sTomNBob of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(tom setCycle: End self)
			)
			(1
				(tom setCycle: Beg self)
			)
			(2
				(bob setCycle: End self)
			)
			(3
				(bob setCycle: Beg self)
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance checkForAllClickedCode of Code
	(properties)

	(method (doit &tmp temp0)
		(= temp0 0)
		(if (IsFlag 1501)
			(++ temp0)
		)
		(if (IsFlag 1503)
			(++ temp0)
		)
		(if (IsFlag 1502)
			(++ temp0)
		)
		(switch temp0
			(0 0)
			(1
				(trev view: 17025 setCel: 1 posn: 196 338 update:)
				(tom view: 17024 setCel: 1 posn: 372 322 update:)
				(bob view: 17028 setCel: 0 update:)
				(sTomNBob changeState: (* 2 (Random 0 1)))
			)
			(2
				(trev view: 17027 setCel: 1 posn: 170 338 update:)
				(tom view: 17026 setCel: 1 posn: 341 329 update:)
				(bob view: 17029 setCel: 0 update:)
				(sTomNBob changeState: (* 2 (Random 0 1)))
			)
			(3 0)
		)
		(if (== temp0 3)
			((ScriptID 30061 0) cue: dispose:) ; zombiesTimer
		)
	)
)

