;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 977)
(include sci.sh)
(use Main)
(use Sight)
(use Motion)
(use System)

(local
	[local0 8] = [2 6 4 0 3 5 1 7]
	[local8 8] = [3 6 0 4 2 5 1 7]
	[local16 8] = [0 45 90 135 180 225 270 315]
	[local24 8] = [15 30 15 30 15 30 15 30]
)

(class Grooper of Code
	(properties
		client 0
		oldCycler 0
		oldMover 0
		caller 0
	)

	(method (doit c h whoCares dontGroop &tmp temp0 temp1 temp2)
		(if (not client)
			(= client c)
		)
		(if (& (client signal:) $0800)
			(if caller
				(caller cue:)
			)
			(= caller 0)
			(return)
		)
		(if (>= argc 3)
			(= caller whoCares)
		)
		(= temp1 (if (< (NumLoops client) 8) 4 else 8))
		(if (or (not (gCast contains: client)) (and (>= argc 4) dontGroop))
			(client
				loop:
					[local8
						(*
							(if (== temp1 4) 2 else 1)
							(/
								(umod
									(+ (client heading:) (/ 180 temp1))
									360
								)
								(/ 360 temp1)
							)
						)
					]
			)
			(if caller
				(caller cue:)
			)
			(= caller 0)
			(return)
		)
		(= temp0 [local0 (client loop:)])
		(if oldMover
			(oldMover dispose:)
			(= oldMover 0)
		)
		(if
			(and
				(IsObject oldCycler)
				(or
					(oldCycler isMemberOf: Grycler)
					(not ((client cycler:) isMemberOf: Grycler))
				)
			)
			(oldCycler dispose:)
			(= oldCycler 0)
		)
		(if (not oldCycler)
			(= oldCycler (client cycler:))
		)
		(if (and (client cycler:) ((client cycler:) isMemberOf: Grycler))
			((client cycler:) dispose:)
		)
		(= oldMover (client mover:))
		(client cycler: 0 mover: 0 setMotion: 0 setCycle: Grycler self temp0)
	)

	(method (cue &tmp oldCaller)
		(if (not (IsObject (client mover:)))
			(client mover: oldMover)
		)
		(if (IsObject oldCycler)
			(client cycler: oldCycler)
		)
		(= oldCaller caller)
		(= caller (= oldMover (= oldCycler 0)))
		(if oldCaller
			(oldCaller cue: &rest)
		)
	)

	(method (dispose)
		(if (IsObject oldCycler)
			(oldCycler dispose:)
			(= oldCycler 0)
		)
		(if (IsObject oldMover)
			(oldMover dispose:)
			(= oldMover 0)
		)
		(if client
			(client looper: 0)
		)
		(super dispose:)
	)
)

(class Grycler of Cycle
	(properties
		loopIndex 0
		numOfLoops 0
	)

	(method (init act whoCares oldDir)
		(super init: act)
		(= caller whoCares)
		(= numOfLoops (if (< (NumLoops client) 8) 4 else 8))
		(= cycleDir (- (sign (AngleDiff (* oldDir 45) (act heading:)))))
		(= loopIndex oldDir)
		(if (self loopIsCorrect:)
			(self cycleDone:)
		)
	)

	(method (doit)
		(client loop: (self nextCel:))
		(if (self loopIsCorrect:)
			(self cycleDone:)
		)
	)

	(method (cycleDone)
		(= gDoMotionCue (= completed 1))
	)

	(method (loopIsCorrect &tmp temp0)
		(cond
			((== numOfLoops 4)
				(if
					(<=
						(Abs (AngleDiff (* loopIndex 45) (client heading:)))
						(+ (/ 180 numOfLoops) 1)
					)
					(return 1)
				)
			)
			(
				(<=
					(Abs (AngleDiff [local16 loopIndex] (client heading:)))
					[local24 loopIndex]
				)
				(return 1)
			)
		)
		(return 0)
	)

	(method (nextCel)
		(return
			(if
				(or
					(< (Abs (- gGameTime cycleCnt)) (client cycleSpeed:))
					(self loopIsCorrect:)
				)
				(client loop:)
			else
				(= cycleCnt gGameTime)
				(+= loopIndex (* cycleDir (/ 8 numOfLoops)))
				(= loopIndex (umod loopIndex 8))
				[local8 loopIndex]
			)
		)
	)
)

