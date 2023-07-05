;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 306)
(include sci.sh)
(use Main)

(public
	proc306_0 0
	proc306_1 1
	proc306_2 2
)

(procedure (proc306_0)
	(if
		(and
			(== global237 ((global501 cardList:) tempTotal:))
			(or
				(and (>= (global501 heartsStrength:) 0) (localproc_0))
				(>= ((global501 cardList:) tempTotal:) 20)
			)
		)
		(return 1)
	)
	(return 0)
)

(procedure (proc306_1 &tmp temp0 temp1)
	(= temp0 0)
	(if
		(and
			(!= (global117 at: 1) global501)
			(== ((global117 at: 1) tempTotal:) global237)
		)
		(= temp0 (global117 at: 1))
	)
	(if
		(and
			(!= (global117 at: 2) global501)
			(== ((global117 at: 2) tempTotal:) global237)
		)
		(= temp0 (global117 at: 2))
	)
	(if
		(and
			(!= (global117 at: 3) global501)
			(== ((global117 at: 3) tempTotal:) global237)
		)
		(= temp0 (global117 at: 3))
	)
	(if (== ((global117 at: 0) tempTotal:) global237)
		(= temp0 (global117 at: 0))
	)
	(cond
		((< global237 13)
			(= temp1 global237)
		)
		((> global237 13)
			(= temp1 (- global237 12))
		)
		(else
			(= temp1 (if (gTrick playedCard: 12 0) 1 else 13))
		)
	)
	(if (and temp0 (>= temp1 6))
		(return temp0)
	)
	(return 0)
)

(procedure (localproc_0 &tmp temp0)
	(if (or (< (= temp0 (global501 heartsStrength:)) 0) (>= temp0 9))
		(= temp0 0)
	)
	(*= temp0 2)
	(return
		(and
			(>= (global501 clubsStrength:) (- -2 temp0))
			(>= (global501 diamondsStrength:) (- -2 temp0))
			(>= (global501 spadesStrength:) (- -2 temp0))
		)
	)
)

(procedure (proc306_2 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11)
	(= global504 ((global501 cardList:) howManyOfSuit: param1))
	(= temp11 (- 13 (gTrick remaining: param1)))
	(cond
		((and (!= param1 3) global504 (>= (/ temp11 global504) global527))
			(= temp10 9)
		)
		(global504
			(if (= temp1 (- (= temp0 (gTrick remaining: param1)) global504))
				(= temp2 (- (- global527 (localproc_1 param1)) 1))
				(if (< temp1 temp2)
					(= temp2 temp1)
				)
				(= temp3 (/ temp1 temp2))
				(= temp4 (if (> global504 temp3) temp3 else global504))
				(= temp5 (= temp6 (= temp7 0)))
				(= temp8 1)
				(for ((= temp9 14)) (>= temp9 2) ((-- temp9))
					(if (== (gTrick playedCard: temp9 param1) -1)
						(if (not ((global501 cardList:) hasCard: temp9 param1))
							(+= temp5 temp8)
							(if (== (++ temp7) temp4)
								(break)
							)
						else
							(++ temp6)
							(= temp8 0)
						)
					)
				)
				(= temp10 (- temp5 temp6))
			else
				(= temp10 10)
			)
		)
		(else
			(= temp10 11)
		)
	)
	(switch param1
		(0
			(global501 spadesStrength: temp10)
		)
		(1
			(global501 clubsStrength: temp10)
		)
		(2
			(global501 diamondsStrength: temp10)
		)
		(3
			(global501 heartsStrength: temp10)
		)
	)
	(return temp10)
)

(procedure (localproc_1 param1 &tmp temp0 temp1)
	(= temp0 (= temp1 0))
	(while (< temp1 global527)
		(if (global501 playerOutOf: param1 temp1)
			(++ temp0)
		)
		(++ temp1)
	)
	(return temp0)
)

