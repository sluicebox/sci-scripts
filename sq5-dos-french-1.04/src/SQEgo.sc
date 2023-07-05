;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18)
(include sci.sh)
(use Main)
(use Smopper)
(use Ego)
(use Motion)
(use System)

(class SQEgo of Ego
	(properties
		noun 22
		modNum 0
		state 2
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(= temp1 (event type:))
		(= temp2 (event message:))
		(cond
			((and script (script handleEvent: event)) 1)
			((& temp1 $0040) ; direction
				(return 0)
			)
			(else
				(super handleEvent: event &rest)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 22)
					(gMessager say: 30 1 0 (Random 1 2) 0 0)
				else
					(gMessager say: 22 1 0 (Random 1 2) 0 0)
				)
			)
			(4 ; Do
				(gMessager say: 22 4 0 (Random 1 2) 0 0)
			)
			(2 ; Talk
				(gMessager say: 22 2 0 (Random 1 2) 0 0)
			)
			(32 ; Communicator
				(cond
					((gCurRoom script:)
						(super doVerb: theVerb &rest)
					)
					((OneOf gCurRoomNum 730 740 760 790 620 640 400 410 420)
						(gCurRoom setScript: (ScriptID gCurRoomNum 20))
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(39 ; Oxygen_Mask
				(if (and (== gCurRoomNum 240) (== global113 6))
					(gCurRoom setScript: (ScriptID 243 22)) ; putOnMask
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (setSpeed param1)
		(= global123 (super setSpeed: param1))
	)
)

(class FiddleStopWalk of Smopper
	(properties
		lCel 0
		ticks 1200
		curTicks -1
		lastTicks 0
		oldControl 0
		oldCycSpeed 0
	)

	(method (cue)
		(gEgo view: 0 cel: lCel cycleSpeed: oldCycSpeed cycler: self)
		(gEgo loop: (- (NumLoops gEgo) 1))
		(self client: gEgo)
	)

	(method (doit &tmp [temp0 2])
		(if (client isStopped:)
			(cond
				((!= (gEgo loop:) 8)
					(if (OneOf vInMotion 0 1)
						(= oldCycSpeed global123)
						(cond
							((== vInMotion 1)
								(= vSlow 3)
							)
							((OneOf (gEgo loop:) 2 4 5)
								(= vSlow (if (Random 0 1) 12 else 2))
							)
							(else
								(= vSlow 12)
							)
						)
						(= curTicks ticks)
					else
						(= vSlow 0)
					)
					(super doit: &rest)
				)
				(
					(and
						(== (gEgo loop:) 8)
						(!= curTicks -1)
						(<= (-= curTicks (Abs (- gGameTime lastTicks))) 0)
					)
					(= curTicks -1)
					(super doit: &rest)
				)
				(
					(and
						(== curTicks -1)
						(not (gCurRoom script:))
						(not (gEgo script:))
						(gUser canControl:)
						(== (gEgo view:) 0)
						(== (gEgo loop:) (- (NumLoops gEgo) 1))
					)
					(= curTicks ticks)
					(= lCel (gEgo cel:))
					(= oldCycSpeed (gEgo cycleSpeed:))
					(if (OneOf (gEgo cel:) 2 4 5)
						(gEgo view: (if (Random 0 1) 10 else 2))
					else
						(gEgo view: 10)
					)
					(gEgo
						loop: lCel
						cel: 0
						cycleSpeed: 15
						setCycle: End self
					)
				)
				(else
					(super doit: &rest)
				)
			)
		else
			(super doit: &rest)
		)
		(= lastTicks gGameTime)
	)
)

