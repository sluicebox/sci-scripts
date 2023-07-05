;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17)
(include sci.sh)
(use Main)

(public
	proc17_0 0
	proc17_1 1
	proc17_2 2
)

(procedure (proc17_0)
	(if
		(and
			(== global449 (global859 handPoints:))
			(or
				(and (>= (global859 heartsStrength:) 0) (localproc_0))
				(>= (global859 handPoints:) 20)
			)
		)
		(return 1)
	)
	(return 0)
)

(procedure (proc17_1 &tmp temp0 temp1)
	(= temp0 0)
	(if (and (!= gPlayer1 global859) (== (gPlayer1 handPoints:) global449))
		(= temp0 gPlayer1)
	)
	(if (and (!= gPlayer2 global859) (== (gPlayer2 handPoints:) global449))
		(= temp0 gPlayer2)
	)
	(if
		(and
			(not (gPlayer3 sittingOut:))
			(!= gPlayer3 global859)
			(== (gPlayer3 handPoints:) global449)
		)
		(= temp0 gPlayer3)
	)
	(if (== (gPlayer0 handPoints:) global449)
		(= temp0 gPlayer0)
	)
	(cond
		((< global449 13)
			(= temp1 global449)
		)
		((> global449 13)
			(= temp1 (- global449 12))
		)
		(else
			(= temp1 (if ((gDeck workingDeck:) hasCard: 12 0) 1 else 13))
		)
	)
	(if (and temp0 (>= temp1 6))
		(return temp0)
	)
	(return 0)
)

(procedure (localproc_0 &tmp temp0)
	(if (or (< (= temp0 (global859 heartsStrength:)) 0) (>= temp0 9))
		(= temp0 0)
	)
	(*= temp0 2)
	(return
		(and
			(>= (global859 clubsStrength:) (- -2 temp0))
			(>= (global859 diamondsStrength:) (- -2 temp0))
			(>= (global859 spadesStrength:) (- -2 temp0))
		)
	)
)

(procedure (proc17_2 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11)
	(= global306 ((global859 cardList:) howManyOfSuit: param1))
	(= temp11 (+ (gDeck remaining: param1) [global441 param1]))
	(cond
		((and (!= param1 3) global306 (>= (/ temp11 global306) global448))
			(= temp10 9)
		)
		(global306
			(if (= temp1 (- (= temp0 (gDeck remaining: param1)) global306))
				(= temp2 (- (- global448 (localproc_1 param1)) 1))
				(if (< temp1 temp2)
					(= temp2 temp1)
				)
				(= temp3 (/ temp1 temp2))
				(= temp4 (if (> global306 temp3) temp3 else global306))
				(= temp5 (= temp6 (= temp7 0)))
				(= temp8 1)
				(for ((= temp9 14)) (> temp9 1) ((-- temp9))
					(if
						(==
							(gDeck
								hasCard: (if (== temp9 14) 1 else temp9) param1
							)
							-1
						)
						(if
							(>=
								((global859 cardList:)
									hasCard:
										(if (== temp9 14) 1 else temp9)
										param1
								)
								0
							)
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
			(global859 spadesStrength: temp10)
		)
		(1
			(global859 clubsStrength: temp10)
		)
		(2
			(global859 diamondsStrength: temp10)
		)
		(3
			(global859 heartsStrength: temp10)
		)
	)
	(return temp10)
)

(procedure (localproc_1 param1 &tmp temp0 temp1)
	(= temp0 (= temp1 0))
	(while (< temp1 global448)
		(if (global859 playerOutOf: param1 temp1)
			(++ temp0)
		)
		(++ temp1)
	)
	(return temp0)
)

