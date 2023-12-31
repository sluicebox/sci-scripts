;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 313)
(include sci.sh)
(use Main)
(use System)

(class CountPoker of Obj
	(properties
		total 0
	)

	(method (init &tmp temp0 temp1 temp2)
		(for ((= temp1 (= temp2 0))) (< temp1 25) ((++ temp1))
			(+= temp2 ((gTheColumns at: temp1) size:))
		)
		(= temp0 0)
		(for ((= temp1 0)) (< temp1 5) ((++ temp1))
			(= total 0)
			(if ((gTheColumns at: (* temp1 5)) size:)
				(gATempList add: ((gTheColumns at: (* temp1 5)) at: 0))
			)
			(if ((gTheColumns at: (+ (* temp1 5) 1)) size:)
				(gATempList add: ((gTheColumns at: (+ (* temp1 5) 1)) at: 0))
			)
			(if ((gTheColumns at: (+ (* temp1 5) 2)) size:)
				(gATempList add: ((gTheColumns at: (+ (* temp1 5) 2)) at: 0))
			)
			(if ((gTheColumns at: (+ (* temp1 5) 3)) size:)
				(gATempList add: ((gTheColumns at: (+ (* temp1 5) 3)) at: 0))
			)
			(if ((gTheColumns at: (+ (* temp1 5) 4)) size:)
				(gATempList add: ((gTheColumns at: (+ (* temp1 5) 4)) at: 0))
			)
			(if (>= (gATempList size:) 2)
				(+= temp0 (self doit:))
			)
			(gATempList empty:)
		)
		(for ((= temp1 0)) (< temp1 5) ((++ temp1))
			(= total 0)
			(if ((gTheColumns at: temp1) size:)
				(gATempList add: ((gTheColumns at: temp1) at: 0))
			)
			(if ((gTheColumns at: (+ temp1 5)) size:)
				(gATempList add: ((gTheColumns at: (+ temp1 5)) at: 0))
			)
			(if ((gTheColumns at: (+ temp1 10)) size:)
				(gATempList add: ((gTheColumns at: (+ temp1 10)) at: 0))
			)
			(if ((gTheColumns at: (+ temp1 15)) size:)
				(gATempList add: ((gTheColumns at: (+ temp1 15)) at: 0))
			)
			(if ((gTheColumns at: (+ temp1 20)) size:)
				(gATempList add: ((gTheColumns at: (+ temp1 20)) at: 0))
			)
			(if (>= (gATempList size:) 2)
				(+= temp0 (self doit:))
			)
			(gATempList empty:)
		)
		(gATempList dispose:)
		(return temp0)
	)

	(method (doit &tmp temp0)
		(for ((= temp0 (= total 0))) (< temp0 (gATempList size:)) ((++ temp0))
			(= [global600 temp0] ((gATempList at: temp0) rank:))
			(= [global605 temp0] ((gATempList at: temp0) suit:))
		)
		(cond
			((self royalFlush:)
				(self addPoints: 1)
			)
			((self straightFlush:)
				(self addPoints: 2)
			)
			((self straight:)
				(self addPoints: 3)
			)
			((self flush:)
				(self addPoints: 4)
			)
			((self fullHouse:)
				(self addPoints: 5)
			)
			((self fourOfAKind:)
				(self addPoints: 6)
			)
			((self twoPair:)
				(self addPoints: 7)
			)
			((self threeOfAKind:)
				(self addPoints: 8)
			)
			((self onePair: 0)
				(self addPoints: 9)
			)
		)
		(return total)
	)

	(method (addPoints param1)
		(+=
			total
			(switch param1
				(1 100)
				(2 75)
				(6 50)
				(5 25)
				(4 20)
				(3 15)
				(8 10)
				(7 5)
				(9 2)
			)
		)
	)

	(method (royalFlush)
		(= global414 1)
		(return
			(and
				(== (gATempList size:) 5)
				(self flush:)
				(self straight:)
				(or
					(== [global600 0] 1)
					(== [global600 1] 1)
					(== [global600 2] 1)
					(== [global600 3] 1)
					(== [global600 4] 1)
				)
				(or
					(== [global600 0] 13)
					(== [global600 1] 13)
					(== [global600 2] 13)
					(== [global600 3] 13)
					(== [global600 4] 13)
				)
			)
		)
	)

	(method (straightFlush)
		(= global414 2)
		(if (self straight:)
			(self flush:)
		)
	)

	(method (straight)
		(= global414 3)
		(if (== (gATempList size:) 5)
			(self
				order:
					[global600 0]
					[global600 1]
					[global600 2]
					[global600 3]
					[global600 4]
			)
			(if
				(and
					(== (+ [global625 0] 1) [global625 1])
					(== (+ [global625 1] 1) [global625 2])
					(== (+ [global625 2] 1) [global625 3])
					(== (+ [global625 3] 1) [global625 4])
				)
				(return 1)
			)
			(if (== [global600 0] 1)
				(= [global600 0] 14)
			)
			(if (== [global600 1] 1)
				(= [global600 1] 14)
			)
			(if (== [global600 2] 1)
				(= [global600 2] 14)
			)
			(if (== [global600 3] 1)
				(= [global600 3] 14)
			)
			(if (== [global600 4] 1)
				(= [global600 4] 14)
			)
			(self
				order:
					[global600 0]
					[global600 1]
					[global600 2]
					[global600 3]
					[global600 4]
			)
			(if
				(and
					(== (+ [global625 0] 1) [global625 1])
					(== (+ [global625 1] 1) [global625 2])
					(== (+ [global625 2] 1) [global625 3])
					(== (+ [global625 3] 1) [global625 4])
				)
				(return 1)
			)
			(if (== [global600 0] 14)
				(= [global600 0] 1)
			)
			(if (== [global600 1] 14)
				(= [global600 1] 1)
			)
			(if (== [global600 2] 14)
				(= [global600 2] 1)
			)
			(if (== [global600 3] 14)
				(= [global600 3] 1)
			)
			(if (== [global600 4] 14)
				(= [global600 4] 1)
			)
		)
		(return 0)
	)

	(method (flush)
		(= global414 4)
		(return
			(and
				(== (gATempList size:) 5)
				(== [global605 0] [global605 1])
				(== [global605 1] [global605 2])
				(== [global605 2] [global605 3])
				(== [global605 3] [global605 4])
			)
		)
	)

	(method (fullHouse &tmp temp0)
		(= global414 5)
		(if (and (== (gATempList size:) 5) (= temp0 (self threeOfAKind:)))
			(self onePair: temp0)
		)
	)

	(method (fourOfAKind &tmp temp0 temp1 temp2)
		(= global414 6)
		(if (>= (gATempList size:) 4)
			(cond
				((== [global600 0] [global600 1])
					(= temp0 [global600 0])
				)
				((== [global600 0] [global600 2])
					(= temp0 [global600 0])
				)
				(else
					(= temp0 [global600 1])
				)
			)
			(for
				((= temp2 (= temp1 0)))
				(< temp2 (gATempList size:))
				((++ temp2))
				
				(if (== [global600 temp2] temp0)
					(++ temp1)
				)
			)
			(if (== temp1 4)
				(return 1)
			)
		)
		(return 0)
	)

	(method (twoPair &tmp temp0)
		(= global414 7)
		(if (and (>= (gATempList size:) 4) (= temp0 (self onePair:)))
			(self onePair: temp0)
		)
	)

	(method (threeOfAKind &tmp temp0 temp1 temp2)
		(= global414 8)
		(if (>= (gATempList size:) 3)
			(for ((= temp0 0)) (< temp0 (- (gATempList size:) 2)) ((++ temp0))
				(for
					((= temp1 (+ temp0 1)))
					(< temp1 (- (gATempList size:) 1))
					((++ temp1))
					
					(for
						((= temp2 (+ temp1 1)))
						(< temp2 (gATempList size:))
						((++ temp2))
						
						(if
							(and
								(== [global600 temp0] [global600 temp1])
								(== [global600 temp1] [global600 temp2])
							)
							(return [global600 temp0])
						)
					)
				)
			)
		)
		(return 0)
	)

	(method (onePair param1 &tmp temp0 temp1)
		(= global414 10)
		(if (>= (gATempList size:) 2)
			(for ((= temp0 0)) (< temp0 (- (gATempList size:) 1)) ((++ temp0))
				(for
					((= temp1 (+ temp0 1)))
					(< temp1 (gATempList size:))
					((++ temp1))
					
					(if
						(and
							(== [global600 temp0] [global600 temp1])
							(!= [global600 temp0] param1)
						)
						(return [global600 temp0])
					)
				)
			)
		)
		(return 0)
	)

	(method (order param1 &tmp temp0 temp1 temp2 [temp3 5])
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(= [temp3 temp0] [param1 temp0])
		)
		(for ((= temp0 0)) (< temp0 (- argc 1)) ((++ temp0))
			(for ((= temp1 0)) (< temp1 (- argc 1)) ((++ temp1))
				(if (> [temp3 temp1] [temp3 (+ temp1 1)])
					(= temp2 [temp3 (+ temp1 1)])
					(= [temp3 (+ temp1 1)] [temp3 temp1])
					(= [temp3 temp1] temp2)
				)
			)
		)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(= [global625 temp0] [temp3 temp0])
		)
	)
)

