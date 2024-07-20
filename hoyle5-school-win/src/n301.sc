;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 301)
(include sci.sh)
(use Main)
(use Piles)

(public
	proc301_0 0
)

(procedure (proc301_0 param1)
	(= global501 param1)
	(cond
		((== (global501 takeAllPlayer:) (global501 cardList:))
			(cond
				(
					(and
						(localproc_2)
						(or
							(and (== global236 1) (gTrick tricksPlayed:))
							(== global236 0)
						)
					)
					(= global500 201)
					(localproc_0 3 3)
				)
				(global506
					(cond
						((localproc_3 global513)
							(cond
								((!= global513 3)
									(= global500 1)
									(localproc_0 global513 1)
								)
								((localproc_3 global517)
									(= global500 2)
									(localproc_0 global517 1)
								)
								(else
									(= global500 3)
									(localproc_0 3 3)
								)
							)
						)
						((localproc_3 global517)
							(cond
								((!= global517 3)
									(= global500 4)
									(localproc_0 global517 1)
								)
								((localproc_3 global518)
									(= global500 5)
									(localproc_0 global518 1)
								)
								(else
									(= global500 6)
									(localproc_0 3 3)
								)
							)
						)
						((localproc_3 global518)
							(cond
								((!= global518 3)
									(= global500 7)
									(localproc_0 global518 1)
								)
								((localproc_3 global519)
									(= global500 8)
									(localproc_0 global519 1)
								)
								(else
									(= global500 9)
									(localproc_0 3 3)
								)
							)
						)
						((localproc_3 global519)
							(if (!= global519 3)
								(= global500 10)
								(localproc_0 global519 1)
							else
								(= global500 11)
								(localproc_0 3 3)
							)
						)
						(else
							(= global500 12)
							(localproc_0 global519 3)
						)
					)
				)
				((== global511 3)
					(if (and (!= global512 -1) (localproc_3 global512))
						(= global500 13)
						(localproc_0 global512 1 2 6)
					else
						(= global500 14)
						(localproc_0 3 4)
					)
				)
				((localproc_3 global511)
					(= global500 15)
					(localproc_0 global511 1 2 6)
				)
				(else
					(= global500 16)
					(localproc_0 global511 3 4 6)
				)
			)
		)
		((global501 takeAllPlayer:)
			(cond
				((>= global509 0)
					(if global503
						(= global500 17)
						(localproc_0 global509 3)
					else
						(= global500 18)
						(localproc_0 global509 4 3)
					)
				)
				((>= global510 0)
					(if (localproc_3 global510)
						(= global500 19)
						(localproc_0 global510 3)
					else
						(= global500 20)
						(localproc_0 global510 1)
					)
				)
				((== global524 3)
					(if
						(==
							((global501 heartsList:) size:)
							((global501 cardList:) size:)
						)
						(= global500 21)
						(localproc_0 global524 1)
					else
						(= global500 22)
						(localproc_0 0 5)
					)
				)
				((and (== global524 0) (>= global508 12))
					(= global500 23)
					(localproc_0 global524 1 1 6)
				)
				((localproc_3 global524)
					(= global500 24)
					(localproc_0 global524 3)
				)
				(else
					(= global500 25)
					(localproc_0 0 5)
				)
			)
		)
		((>= global510 0)
			(if (localproc_3 global510)
				(if (!= global510 3)
					(= global500 26)
					(localproc_0 global510 3)
				else
					(= global500 27)
					(localproc_0 global510 1)
				)
			else
				(= global500 28)
				(localproc_0 global510 1)
			)
		)
		((== global524 3)
			(if
				(==
					((global501 heartsList:) size:)
					((global501 cardList:) size:)
				)
				(= global500 29)
				(localproc_0 global524 1)
			else
				(= global500 30)
				(localproc_0 0 5)
			)
		)
		((and (== global524 0) (>= global508 12))
			(= global500 31)
			(localproc_0 global524 1 1 6)
		)
		((localproc_3 global524)
			(= global500 32)
			(localproc_0 global524 3)
		)
		(else
			(= global500 33)
			(localproc_0 0 5)
		)
	)
	(return global502)
)

(procedure (localproc_0 param1 param2 param3 &tmp temp0)
	(global501 getSuitList: param1)
	(if
		(and
			(= temp0 (localproc_1 param2))
			(or (!= argc 4) (!= (temp0 rank:) 12) (!= (temp0 suit:) 0))
		)
		(= global502 temp0)
		(return temp0)
	)
	(return (= global502 (= temp0 (localproc_1 param3))))
)

(procedure (localproc_1 param1)
	(switch param1
		(3
			(return (global507 at: global505))
		)
		(1
			(return (global507 at: 0))
		)
		(4
			(if (>= global504 2)
				(return (global507 at: (- global504 2)))
			else
				(return (global507 at: 0))
			)
		)
		(2
			(if (>= global504 2)
				(return (global507 at: 1))
			else
				(return (global507 at: 0))
			)
		)
		(5
			(return (localproc_6))
		)
		(else
			(return 0)
		)
	)
)

(procedure (localproc_2 &tmp temp0 temp1 temp2 temp3 temp4)
	(= global500 60)
	(if (and ((global501 heartsList:) size:) global521)
		(= global500 61)
		(if
			(and
				(not global503)
				(((global501 cardList:) spadesList:) size:)
				(!=
					(global501
						howManyLower:
							0
							((((global501 carList:) spadesList:) at: 0) rank:)
					)
					(-
						(gTrick remaining: 0)
						(((global501 cardList:) spadesList:) size:)
					)
				)
			)
			(return 0)
		)
		(= global500 62)
		(= temp0
			(-
				(gTrick remaining: 3)
				(((global501 cardList:) heartsList:) size:)
			)
		)
		(= global500 63)
		(= temp1 (localproc_5 3))
		(= global500 64)
		(if
			(= temp2
				(if (- (- global527 temp1) 1)
					(+ (/ temp0 (- (- global527 temp1) 1)) 1)
				else
					0
				)
			)
			(= global500 65)
			(if (> temp2 (((global501 cardList:) heartsList:) size:))
				(= temp2 (((global501 cardList:) heartsList:) size:))
			)
			(= global500 66)
			(= temp4
				(global501
					howManyHigher:
						3
						(((global501 heartsList:)
								at: (- ((global501 heartsList:) size:) temp2)
							)
							rank:
						)
				)
			)
			(= global500 67)
			(= temp3
				(global501
					howManyHigherInHand:
						3
						(((global501 heartsList:)
								at: (- ((global501 heartsList:) size:) temp2)
							)
							rank:
						)
				)
			)
			(= global500 68)
			(if (== temp4 temp3)
				(return 1)
			)
		else
			(return 1)
		)
	)
	(= global500 69)
	(return 0)
)

(procedure (localproc_3 param1 &tmp [temp0 2] temp2)
	(if
		(or
			(not
				(= temp2
					(switch param1
						(0
							((global501 spadesList:) size:)
						)
						(1
							((global501 clubsList:) size:)
						)
						(2
							((global501 diamondsList:) size:)
						)
						(3
							((global501 heartsList:) size:)
						)
						(else 0)
					)
				)
			)
			(and (== param1 3) (not global521))
		)
		(return 0)
	)
	(if
		(and
			(>=
				(-
					(gTrick remaining: param1)
					((global501 cardList:) howManyOfSuit: param1)
				)
				(+ (- (- global527 global523) (gTrick size:)) 1)
			)
			(localproc_4 param1)
		)
		(return 1)
	)
	(return 0)
)

(procedure (localproc_4 param1 &tmp temp0 temp1 temp2 temp3)
	(for
		((= temp1 (+ (= temp3 (gTheHands indexOf: (Dealer curPlayer:))) 1)))
		(<= temp1 (+ temp3 3))
		((++ temp1))
		
		(= temp2
			(if (>= temp1 global527)
				(- temp1 global527)
			else
				temp1
			)
		)
		(if
			(and
				((gTheHands at: temp2) outOf: param1)
				(or
					(not ((gTheHands at: temp2) outOf: 3))
					(and
						(not (global501 queenSpades:))
						(not global503)
						(not ((gTheHands at: temp2) outOf: 0))
					)
				)
			)
			(return 0)
		)
	)
	(return 1)
)

(procedure (localproc_5 param1 &tmp temp0 temp1)
	(= temp0 (= temp1 0))
	(while (< temp1 global527)
		(if (global501 playerOutOf: param1 temp1)
			(++ temp0)
		)
		(++ temp1)
	)
	(return temp0)
)

(procedure (localproc_6 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
	(= temp4 -1)
	(= temp0 -99)
	(for ((= temp6 0)) (<= temp6 (if global521 3 else 2)) ((++ temp6))
		(global501 getSuitList: temp6)
		(cond
			(
				(or
					(== (gTrick remaining: temp6) global504)
					(and
						global504
						(== temp6 0)
						(not global503)
						(global501 spadeDanger:)
					)
				))
			(global504
				(= temp1
					(-
						(global501
							howManyLower: temp6 ((global507 at: 0) rank:)
						)
						(localproc_7 temp6 ((global507 at: 0) rank:))
					)
				)
				(= temp2 (- global527 1))
				(for
					((= temp7 (+ (gTheHands indexOf: (Dealer curPlayer:)) 1)))
					(<= temp7 (+ (gTheHands indexOf: (Dealer curPlayer:)) 3))
					((++ temp7))
					
					(= temp3
						(if (>= temp7 global527)
							(- temp7 global527)
						else
							temp7
						)
					)
					(if ((gTheHands at: temp3) outOf: temp6)
						(-- temp2)
					)
				)
				(if (> temp2 temp1)
					(= temp2 temp1)
				)
				(if (> (= temp5 (- temp2 temp1)) temp0)
					(= temp0 temp5)
					(= temp4 temp6)
				)
			)
		)
	)
	(if (== temp4 -1)
		(= global507 (global501 cardList:))
		(= temp0 99)
		(for ((= temp6 0)) (< temp6 (global507 size:)) ((++ temp6))
			(if (< (= temp9 ((global507 at: temp6) rank:)) temp0)
				(= temp0 temp9)
				(= temp8 (global507 at: temp6))
			)
		)
		(= temp4 (temp8 suit:))
	)
	(global501 getSuitList: temp4)
	(global507 at: 0)
)

(procedure (localproc_7 param1 param2 &tmp temp0 temp1 temp2)
	(for ((= temp0 (= temp1 0))) (< temp0 global504) ((++ temp0))
		(if (< (= temp2 ((global507 at: temp0) rank:)) param2)
			(++ temp1)
		)
	)
	(return temp1)
)

