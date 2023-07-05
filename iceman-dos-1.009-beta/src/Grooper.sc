;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 977)
(include sci.sh)
(use Sight)
(use Motion)
(use System)

(local
	[trans1 8] = [2 6 4 0 3 5 1 7]
	[trans2 8] = [3 6 0 4 2 5 1 7]
)

(procedure (FindTrans1 ind)
	(return [trans1 ind])
)

(procedure (FindTrans2 ind)
	(return [trans2 ind])
)

(class Grooper of Code
	(properties
		client 0
		oldCycler 0
		oldMover 0
		caller 0
	)

	(method (doit c h whoCares dontGroop &tmp lastDir numLoops)
		(if (not client)
			(= client c)
		)
		(if (& (client signal:) $0800)
			(if caller
				(caller cue:)
			)
			(return)
		)
		(if (>= argc 3)
			(= caller whoCares)
		)
		(if (and (>= argc 4) dontGroop)
			(= numLoops (NumLoops client))
			(client
				loop:
					(FindTrans2
						(/ (+ (client heading:) (/ 180 numLoops)) (/ 360 numLoops))
					)
			)
			(if caller
				(caller cue:)
			)
			(return)
		)
		(= lastDir (FindTrans1 (client loop:)))
		(= numLoops (if (< (NumLoops client) 8) 4 else 8))
		(if oldMover
			(oldMover dispose:)
			(= oldMover 0)
		)
		(if (< (Abs (- (* 45 lastDir) h)) (+ (/ 180 numLoops) 1))
			(if caller
				(caller cue:)
			)
			(return)
		)
		(if (not oldCycler)
			(= oldCycler (client cycler:))
		)
		(if (and (client cycler:) ((client cycler:) isMemberOf: Grycler))
			((client cycler:) dispose:)
		)
		(= oldMover (client mover:))
		(client cycler: 0 mover: 0 setMotion: 0 setCycle: Grycler self lastDir)
	)

	(method (cue &tmp oldCaller)
		(if (not (IsObject (client mover:)))
			(client mover: oldMover)
		)
		(client cycler: oldCycler)
		(= oldCaller caller)
		(= caller (= oldMover (= oldCycler 0)))
		(if oldCaller
			(oldCaller cue: &rest)
		)
	)

	(method (dispose)
		(if (IsObject oldCycler)
			(oldCycler dispose:)
		)
		(if (IsObject oldMover)
			(oldMover dispose:)
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
		(= numOfLoops (NumLoops client))
		(= cycleDir (- (sign (AngleDiff (* oldDir 45) (act heading:)))))
		(= loopIndex oldDir)
	)

	(method (doit)
		(if
			(>=
				(Abs (AngleDiff (* loopIndex 45) (client heading:)))
				(+ (/ 180 numOfLoops) 1)
			)
			(client loop: (self nextCel:))
		else
			(self cycleDone:)
		)
	)

	(method (cycleDone)
		(if caller
			(caller cue:)
			(= caller 0)
		)
		(self dispose:)
	)

	(method (nextCel)
		(++ cycleCnt)
		(if (<= cycleCnt (client cycleSpeed:))
			(client loop:)
		else
			(= cycleCnt 0)
			(+= loopIndex (* cycleDir (/ 8 numOfLoops)))
			(= loopIndex (umod loopIndex 8))
			(FindTrans2 loopIndex)
		)
	)
)

