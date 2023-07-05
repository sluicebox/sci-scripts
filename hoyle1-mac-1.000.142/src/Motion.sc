;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 992)
(include sci.sh)
(use Main)
(use System)

(class Cycle of Obj
	(properties
		client 0
		caller 0
		cycleDir 1
		cycleCnt 0
		completed 0
	)

	(method (init theObj)
		(= client theObj)
		(= cycleCnt 0)
		(client setCel: -1)
		(client startUpd:)
	)

	(method (nextCel)
		(++ cycleCnt)
		(return
			(if (<= cycleCnt (client cycleSpeed:))
				(client cel:)
			else
				(= cycleCnt 0)
				(if (& (client signal:) $1000)
					(client cel:)
				else
					(+ (client cel:) cycleDir)
				)
			)
		)
	)

	(method (cycleDone))

	(method (motionCue)
		(client cycler: 0)
		(if (and completed (IsObject caller))
			(caller cue:)
		)
		(self dispose:)
	)
)

(class Fwd of Cycle
	(properties)

	(method (doit &tmp newCel)
		(if (> (= newCel (self nextCel:)) (client lastCel:))
			(self cycleDone:)
		else
			(client cel: newCel)
		)
	)

	(method (cycleDone)
		(client cel: 0)
	)
)

(class Motion of Obj
	(properties
		client 0
		caller 0
		x 0
		y 0
		dx 0
		dy 0
		b-moveCnt 0
		b-i1 0
		b-i2 0
		b-di 0
		b-xAxis 0
		b-incr 0
		completed 0
	)

	(method (init actor xTo yTo toCall &tmp [temp0 2])
		(= client actor)
		(= x xTo)
		(= y yTo)
		(if (== argc 4)
			(= caller toCall)
		)
		(= b-moveCnt 0)
		(actor heading: (GetAngle (actor x:) (actor y:) xTo yTo))
		(if (actor looper:)
			((actor looper:) doit: actor (actor heading:))
		else
			(DirLoop actor (actor heading:))
		)
		(InitBresen self)
	)

	(method (onTarget)
		(return (and (== (client x:) x) (== (client y:) y)))
	)

	(method (setTarget xTo yTo)
		(if argc
			(= x xTo)
			(= y yTo)
		)
	)

	(method (doit &tmp [temp0 6])
		(DoBresen self)
		(if (and (== x (client x:)) (== y (client y:)))
			(self moveDone:)
			(return)
		)
	)

	(method (triedToMove)
		(return (== b-moveCnt 0))
	)

	(method (moveDone)
		(= completed 1)
		(if caller
			(= global58 1)
		else
			(self motionCue:)
		)
	)

	(method (motionCue)
		(client mover: 0)
		(if (and completed (IsObject caller))
			(caller cue:)
		)
		(self dispose:)
	)
)

(class MoveTo of Motion
	(properties)

	(method (init)
		(super init: &rest)
	)

	(method (onTarget)
		(return
			(and
				(<= (Abs (- (client x:) x)) (client xStep:))
				(<= (Abs (- (client y:) y)) (client yStep:))
			)
		)
	)
)

