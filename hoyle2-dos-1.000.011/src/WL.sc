;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 310)
(include sci.sh)
(use Main)
(use Column)
(use System)

(class WL of List
	(properties)

	(method (empty param1 &tmp temp0)
		(= temp0 (if argc param1 else self))
		(if (temp0 size:)
			(for
				((= global301 (- (temp0 size:) 1)))
				(>= global301 0)
				((-- global301))
				
				(temp0 delete: (temp0 at: global301))
			)
		)
	)

	(method (hasCard param1 param2)
		(for ((= global301 0)) (< global301 size) ((++ global301))
			(if
				(and
					(== ((self at: global301) cardRank:) param1)
					(== ((self at: global301) cardSuit:) param2)
				)
				(return global301)
			)
		)
		(return -1)
	)

	(method (handleEvent))

	(method (endHand)
		(for ((= global301 0)) (< global301 size) ((++ global301))
			((self at: global301) faceUp: 0)
			(gTheDeck add: (self at: global301))
		)
	)

	(method (lastTrue param1 &tmp temp0 temp1)
		(for ((= temp0 (- size 1))) (>= temp0 0) ((-- temp0))
			(cond
				((proc0_6 124)
					(if
						(and
							(or
								((self at: temp0) size:)
								(not (proc304_0 (self at: temp0)))
							)
							(= temp1 ((self at: temp0) handleEvent: param1))
						)
						(return temp1)
					)
				)
				(
					(and
						(proc0_6 126)
						(= temp1 ((self at: temp0) handleEvent: param1))
					)
					(return temp1)
				)
			)
		)
		(return 0)
	)
)

