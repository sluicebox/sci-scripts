;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22)
(include sci.sh)
(use Main)
(use PStopWalk)
(use Sight)
(use Motion)
(use System)

(local
	[local0 16] = [4 12 8 0 6 10 2 14 7 9 5 11 3 13 1 15]
	[local16 16] = [3 14 6 12 0 10 4 8 2 9 5 11 1 13 7 15]
)

(class GrViewer of Code
	(properties
		client 0
		oldCycler 0
		oldMover 0
		caller 0
		numViews 8
		baseView 0
	)

	(method (init param1 param2 param3)
		(= numViews param2)
		(= baseView param3)
	)

	(method (doit param1 param2 param3 param4 &tmp temp0 temp1)
		(if (not client)
			(= client param1)
		)
		(if (>= argc 3)
			(= caller param3)
		)
		(if (& (client signal:) $0800)
			(if caller
				(caller cue:)
			)
			(= caller 0)
			(return)
		)
		(if (or (not (gCast contains: client)) (and (>= argc 4) param4))
			(client
				view:
					(+
						baseView
						[local16
							(*
								(/ 16 numViews)
								(/
									(umod
										(+
											(<< (client heading:) $0002)
											(/ 720 (<< numViews $0002))
										)
										1440
									)
									(/ 1440 (<< numViews $0002))
								)
							)
						]
						(gCurRoom baseView:)
					)
			)
			(if caller
				(caller cue:)
			)
			(= caller 0)
			(return)
		)
		(= temp0 [local0 (- (- (client view:) baseView) (gCurRoom baseView:))])
		(if oldMover
			(oldMover dispose:)
			(= oldMover 0)
		)
		(if (client cycler:)
			(if ((client cycler:) isMemberOf: GrVCycler)
				((client cycler:) dispose:)
			else
				(= oldCycler (client cycler:))
			)
		)
		(= oldMover (client mover:))
		(client
			cycler: 0
			mover: 0
			setMotion: 0
			setCycle: GrVCycler self temp0 numViews baseView
		)
	)

	(method (cue &tmp temp0)
		(if (not (client mover:))
			(client mover: oldMover)
		)
		(if oldCycler
			(client cycler: oldCycler)
		)
		(= temp0 caller)
		(= caller (= oldMover (= oldCycler 0)))
		(if temp0
			(temp0 cue: &rest)
		)
	)

	(method (dispose)
		(if oldCycler
			(oldCycler dispose:)
			(= oldCycler 0)
		)
		(if oldMover
			(oldMover dispose:)
			(= oldMover 0)
		)
		(if client
			(client looper: 0)
		)
		(super dispose:)
	)
)

(class GrVCycler of Cycle
	(properties
		viewIndex 0
		numOfViews 0
		baseView 0
	)

	(method (init param1 param2 param3 param4 param5)
		(super init: param1)
		(= caller param2)
		(= numOfViews param4)
		(= baseView param5)
		(= cycleDir
			(-
				(sign
					(AngleDiff (>> (* param3 45) $0001) (param1 heading:))
				)
			)
		)
		(= viewIndex param3)
		(cond
			((self viewIsCorrect:)
				(self cycleDone:)
			)
			(
				(and
					(((client looper:) oldCycler:) isKindOf: PStopWalk)
					(== (client loop:) 1)
				)
				(client loop: 0)
			)
		)
	)

	(method (doit)
		(client view: (self nextCel:))
		(if (self viewIsCorrect:)
			(self cycleDone:)
		)
	)

	(method (cycleDone)
		(= gDoMotionCue (= completed 1))
	)

	(method (viewIsCorrect)
		(return
			(<
				(Abs
					(AngleDiff (>> (* viewIndex 45) $0001) (client heading:))
				)
				(+ (/ 180 numOfViews) 1)
			)
		)
	)

	(method (nextCel)
		(return
			(if
				(or
					(< (Abs (- gGameTime cycleCnt)) (client cycleSpeed:))
					(self viewIsCorrect:)
				)
				(client view:)
			else
				(= cycleCnt gGameTime)
				(+= viewIndex (* cycleDir (/ 16 numOfViews)))
				(= viewIndex (umod viewIndex 16))
				(+ baseView [local16 viewIndex] (gCurRoom baseView:))
			)
		)
	)
)

