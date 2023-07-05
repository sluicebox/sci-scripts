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

(class Grooper of Code
	(properties
		client 0
		oldCycler 0
		oldMover 0
	)

	(method (doit param1 param2 param3 &tmp temp0 temp1 temp2 temp3)
		(= client param1)
		(= temp1 (* (/ (NumLoops client) 4) 4))
		(= temp2 (/ 360 temp1))
		(= temp3 (client cycler:))
		(if (and (>= argc 3) param3)
			(client
				loop: [trans2 (/ (umod (+ (/ temp2 2) param2) 360) temp2)]
			)
			(return)
		)
		(= temp0 [trans1 (client loop:)])
		(if oldMover
			(oldMover dispose:)
			(= oldMover 0)
		)
		(if (< (Abs (- (* 45 temp0) param2)) (+ (/ temp2 2) 1))
			(return)
		)
		(if (not oldCycler)
			(= oldCycler temp3)
		)
		(if (and temp3 (temp3 isMemberOf: Grycler))
			(temp3 dispose:)
		)
		(= oldMover (client mover:))
		(client cycler: 0 mover: 0 setMotion: 0 setCycle: Grycler self temp0)
	)

	(method (cue)
		((client cycler:) dispose:)
		(if (not (IsObject (client mover:)))
			(client mover: oldMover)
		)
		(client cycler: oldCycler)
		(= oldMover (= oldCycler 0))
	)

	(method (dispose)
		(if (IsObject oldCycler)
			(oldCycler dispose:)
		)
		(if (IsObject oldMover)
			(oldMover dispose:)
		)
		(if (and (IsObject client) (== (client looper:) self))
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
		)
	)

	(method (nextCel)
		(++ cycleCnt)
		(if (<= cycleCnt (client cycleSpeed:))
			(return (client loop:))
		else
			(= cycleCnt 0)
			(+= loopIndex (* cycleDir (/ 8 numOfLoops)))
			(= loopIndex (umod loopIndex 8))
			(return [trans2 loopIndex])
		)
	)
)

