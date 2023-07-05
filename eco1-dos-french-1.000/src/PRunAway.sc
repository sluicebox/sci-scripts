;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 818)
(include sci.sh)
(use Main)
(use PolyPath)
(use System)

(class PRunAway of PolyPath
	(properties
		who 0
		distance 0
		triedOpposite 0
		oldDistance 999
		targetX 0
		targetY 0
		moveDistance 0
	)

	(method (init param1 param2 param3 param4 param5)
		(cond
			((>= argc 5)
				(= obstacles param5)
			)
			((not (IsObject obstacles))
				(= obstacles (gCurRoom obstacles:))
			)
		)
		(if (>= argc 1)
			(= client param1)
			(if (>= argc 2)
				(= who param2)
				(if (>= argc 3)
					(= distance param3)
					(if (>= argc 4)
						(= moveDistance param4)
					)
				)
			)
		)
		(= completed 0)
		(super init: client (client x:) (client y:) 0 1 obstacles)
	)

	(method (doit &tmp temp0 temp1)
		(= temp0 (client distanceTo: who))
		(cond
			((and (client isBlocked:) (not completed))
				(if (not triedOpposite)
					(= triedOpposite 1)
					(= temp1
						(-
							(GetAngle (who x:) (who x:) (client x:) (client y:))
							45
						)
					)
				else
					(= temp1 (client heading:))
				)
				(= temp1 (mod (* (+ (/ temp1 45) (Random 1 3)) 45) 360))
				(client signal: (& (client signal:) $fbff) heading: temp1)
				(switch temp1
					(0
						(= targetY (- (client y:) moveDistance))
						(= targetX (client x:))
					)
					(45
						(= targetY (- (client y:) moveDistance))
						(= targetX (+ (client x:) moveDistance))
					)
					(90
						(= targetY (client y:))
						(= targetX (+ (client x:) moveDistance))
					)
					(135
						(= targetY (+ (client y:) moveDistance))
						(= targetX (+ (client x:) moveDistance))
					)
					(180
						(= targetY (client x:))
						(= targetX (+ (client y:) moveDistance))
					)
					(225
						(= targetY (+ (client y:) moveDistance))
						(= targetX (- (client x:) moveDistance))
					)
					(270
						(= targetY (client y:))
						(= targetX (- (client x:) moveDistance))
					)
					(315
						(= targetY (- (client y:) moveDistance))
						(= targetX (- (client x:) moveDistance))
					)
				)
				(if points
					(Memory memFREE points)
				)
				(= points 0)
				(= value 2)
				(super init: client targetX targetY 0 1 obstacles)
			)
			((> temp0 distance)
				(= triedOpposite 0)
				(super doit:)
			)
			((and (<= temp0 distance) completed)
				(= completed 0)
				(client signal: (| (client signal:) $0400))
				(= triedOpposite 0)
				(self doit:)
			)
			(else
				(super doit:)
			)
		)
	)

	(method (motionCue)
		(if (and completed (<= (client distanceTo: who) distance))
			(client signal: (| (client signal:) $0400))
			(= completed 0)
		)
	)

	(method (moveDone &tmp temp0)
		(cond
			((> (= temp0 (client distanceTo: who)) moveDistance))
			((<= temp0 distance)
				(client signal: (| (client signal:) $0400))
				(= completed 0)
			)
			((== (WordAt points value) 30583)
				(if points
					(Memory memFREE points)
				)
				(= points 0)
				(= value 2)
				(self init: client who)
			)
			(else
				(self init:)
			)
		)
	)
)

