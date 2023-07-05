;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 302)
(include sci.sh)
(use Main)
(use Card)
(use Column)
(use System)

(class Deck of Set
	(properties)

	(method (init &tmp [temp0 56])
		(for ((= global301 4)) (< global301 56) ((++ global301))
			(= [temp0 global301] (Clone Card))
			([temp0 global301]
				rank: (/ global301 4)
				suit: (mod global301 4)
				color: (if (<= (mod global301 4) 1) 0 else 1)
			)
		)
		(for ((= global301 4)) (< global301 56) ((++ global301))
			(self add: [temp0 global301])
		)
		(self shuffle:)
	)

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

	(method (reShuffle &tmp temp0)
		(for ((= temp0 (- (gTheWorkingDeck size:) 1))) (>= temp0 0) ((-- temp0))
			(= global302 (gTheWorkingDeck at: temp0))
			(global302 faceUp: 0)
			(self add: global302)
			(gTheWorkingDeck delete: global302)
		)
		(self shuffle:)
	)

	(method (shuffle &tmp [temp0 2])
		(if global404
			(self restoreDeckOrder:)
			(return)
		)
		(if global405
			(= global405 0)
		else
			(self restoreDeckOrder:)
		)
		(for ((= global301 0)) (< global301 1) ((++ global301))
			(while (>= (- size 1) 0)
				(= global302 (self at: (Random 0 (- size 1))))
				(gTheWorkingDeck add: global302)
				(self delete: global302)
			)
			(while (>= (- (gTheWorkingDeck size:) 1) 0)
				(= global302 (gTheWorkingDeck at: (Random 0 (- (gTheWorkingDeck size:) 1))))
				(global302 dimmed: 0)
				(self add: global302)
				(gTheWorkingDeck delete: global302)
			)
		)
		(self saveDeckOrder:)
	)

	(method (saveDeckOrder)
		(for ((= global301 0)) (< global301 52) ((++ global301))
			(= [global496 global301] ((self at: global301) rank:))
			(= [global548 global301] ((self at: global301) suit:))
		)
	)

	(method (restoreDeckOrder)
		(for ((= global301 0)) (< global301 52) ((++ global301))
			((self at: global301) rank: [global496 global301])
			((self at: global301) suit: [global548 global301])
			((self at: global301)
				color: (if (<= [global548 global301] 1) 0 else 1)
			)
		)
		(= global404 0)
	)

	(method (getCard)
		(= global302 (self at: 0))
		(self delete: global302)
		(return global302)
	)

	(method (addCard param1)
		(gTheWorkingDeck add: param1)
	)

	(method (endHand)
		(gTheWorkingDeck eachElementDo: #dimmed 0 eachElementDo: #faceUp 0)
	)
)

