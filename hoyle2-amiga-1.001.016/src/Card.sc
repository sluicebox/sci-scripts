;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use System)

(class Card of Obj
	(properties
		x 0
		y 0
		rank 0
		suit 0
		color 0
		faceUp 0
		dimmed 0
		changed 0
		height 43
		width 35
		force 0
	)

	(method (dim)
		(= dimmed (= changed 1))
	)

	(method (whiten)
		(= dimmed 0)
		(= changed 1)
	)

	(method (flip)
		(= faceUp (= changed 1))
	)

	(method (inRect param1 param2)
		(return
			(and
				(<= x param1 (- (+ x width) 1))
				(<= y param2 (- (+ y height) 1))
			)
		)
	)

	(method (forceFullCard)
		(= force (= changed 1))
	)

	(method (update)
		(if changed
			(proc0_1
				(if faceUp suit else 200)
				(cond
					((or (and (== width 35) (== height 43)) force) 1)
					(dimmed
						(if (== width 7) 3 else 5)
					)
					((== width 7)
						(if faceUp 2 else 1)
					)
					(faceUp 4)
					(else 2)
				)
				(if faceUp rank else global300)
				x
				y
			)
			(= changed (= force 0))
		)
	)

	(method (motionCue)
		(return self)
	)
)

