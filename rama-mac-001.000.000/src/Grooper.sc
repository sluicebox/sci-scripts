;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64977)
(include sci.sh)
(use Main)
(use StopWalk)
(use Sight)
(use Motion)
(use System)

(local
	[trans1 8] = [2 6 4 0 3 5 1 7]
	[trans2 8] = [3 6 0 4 2 5 1 7]
)

(class Grooper of Code
	(properties
		client 0
		oldCycler 0
		oldMover 0
		caller 0
	)

	(method (doit c h whoCares dontGroop &tmp lastDir numLoops oldL newL cc)
		(if (not client)
			(= client c)
		)
		(= cc (client cycler:))
		(= oldL (client loop:))
		(if (>= argc 3)
			(= caller whoCares)
		)
		(if (& (client signal:) $0800)
			(if caller
				(caller cue:)
			)
			(= caller 0)
			(return)
		)
		(= numLoops (if (< (NumLoops client) 8) 4 else 8))
		(if (or (not (gCast contains: client)) (and (>= argc 4) dontGroop))
			(if
				(!=
					(= newL
						[trans2
							(*
								(if (== numLoops 4) 2 else 1)
								(/
									(umod
										(+ (client heading:) (/ 180 numLoops))
										360
									)
									(/ 360 numLoops)
								)
							)
						]
					)
					oldL
				)
				(client setLoop: newL)
				(if cc
					(cc clientLastCel: (client lastCel:))
				)
			)
			(if caller
				(caller cue:)
			)
			(= caller 0)
			(return)
		)
		(= lastDir
			(if
				(and
					(== (client loop:) (- (NumLoops client) 1))
					cc
					(cc isKindOf: StopWalk)
					(== (cc vStopped:) -1)
				)
				[trans1 (client cel:)]
			else
				[trans1 (client loop:)]
			)
		)
		(if oldMover
			(oldMover dispose:)
			(= oldMover 0)
		)
		(if
			(and
				oldCycler
				(or
					(oldCycler isMemberOf: Grycler)
					(not (cc isMemberOf: Grycler))
				)
			)
			(oldCycler dispose:)
			(= oldCycler 0)
		)
		(if (not oldCycler)
			(= oldCycler cc)
		)
		(if (and cc (cc isMemberOf: Grycler))
			(cc dispose:)
		)
		(= oldMover (client mover:))
		(client cycler: 0 mover: 0 setMotion: 0 setCycle: Grycler self lastDir)
	)

	(method (cue &tmp oldCaller)
		(if (not (client mover:))
			(client mover: oldMover)
		)
		(if oldCycler
			(client cycler: oldCycler)
		)
		(= oldCaller caller)
		(= caller (= oldMover (= oldCycler 0)))
		(if oldCaller
			(oldCaller cue: &rest)
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

(class Grycler of Cycle
	(properties
		loopIndex 0
		numOfLoops 0
	)

	(method (init act whoCares oldDir)
		(super init: act)
		(= caller whoCares)
		(= numOfLoops (if (< (NumLoops client) 8) 4 else 8))
		(= cycleDir
			(- (sign (AngleDiff (* oldDir 45) (act heading:))))
		)
		(= loopIndex oldDir)
		(if (self loopIsCorrect:)
			(if
				(and
					(((client looper:) oldCycler:) isKindOf: StopWalk)
					(== (((client looper:) oldCycler:) vStopped:) -1)
				)
				(client setLoop: [trans2 loopIndex])
				(= clientLastCel (client lastCel:))
			)
			(self cycleDone:)
		)
	)

	(method (doit &tmp newLoop)
		(if (!= (= newLoop (self nextCel:)) (client loop:))
			(client setLoop: newLoop)
			(= clientLastCel (client lastCel:))
			(if (self loopIsCorrect:)
				(self cycleDone:)
			)
		)
	)

	(method (cycleDone)
		(= completed 1)
		(self motionCue:)
	)

	(method (loopIsCorrect)
		(return
			(<
				(Abs (AngleDiff (* loopIndex 45) (client heading:)))
				(+ (/ 180 numOfLoops) 1)
			)
		)
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
				[trans2 loopIndex]
			)
		)
	)
)

