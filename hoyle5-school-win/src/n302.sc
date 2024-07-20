;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 302)
(include sci.sh)
(use Main)
(use Piles)

(public
	proc302_0 0
)

(procedure (proc302_0 param1)
	(= global501 param1)
	(= global521 (localproc_13))
	(= global500 50)
	(global501 spadeDanger: (localproc_14))
	(= global522 (localproc_12))
	(= global523 (localproc_5))
	(= global500 52)
	(localproc_9)
	(= global500 53)
	(= global506 (localproc_0 global501))
	(= global500 54)
	(= global508 (localproc_1))
	(= global500 55)
	(= global524 (localproc_6))
	(= global500 56)
	(= global509 (localproc_10))
	(= global500 57)
	(= global510 (localproc_2))
	(= global500 58)
)

(procedure (localproc_0)
	(return
		(or
			(and
				(!= (global501 cardList:) (gTheHands at: 1))
				(== ((gTheHands at: 1) takeAllPlayer:) (global501 cardList:))
			)
			(and
				(!= (global501 cardList:) (gTheHands at: 2))
				(== ((gTheHands at: 2) takeAllPlayer:) (global501 cardList:))
			)
			(and
				(!= (global501 cardList:) (gTheHands at: 3))
				(== ((gTheHands at: 3) takeAllPlayer:) (global501 cardList:))
			)
		)
	)
)

(procedure (localproc_1)
	(return
		(if ((global501 spadesList:) size:)
			(((global501 spadesList:) at: (- ((global501 spadesList:) size:) 1))
				rank:
			)
		else
			0
		)
	)
)

(procedure (localproc_2 &tmp temp0 temp1 temp2 temp3)
	(= temp1 (= temp2 -1))
	(for ((= temp0 0)) (<= temp0 3) ((++ temp0))
		(if (> (= temp3 (localproc_3 temp0)) temp1)
			(switch temp0
				(0
					(if
						(and
							(not global503)
							(>=
								(((global501 spadesList:)
										at:
											(-
												((global501 spadesList:) size:)
												1
											)
									)
									rank:
								)
								12
							)
						)
						(continue)
					)
				)
				(3
					(if
						(or
							(>=
								(((global501 heartsList:)
										at:
											(-
												((global501 heartsList:) size:)
												1
											)
									)
									rank:
								)
								7
							)
							(not global521)
						)
						(continue)
					)
				)
			)
			(= temp1 temp3)
			(= temp2 temp0)
		)
	)
	(return temp2)
)

(procedure (localproc_3 param1 &tmp temp0 temp1 temp2)
	(= global526 -1)
	(= temp1 ((global501 cardList:) howManyOfSuit: param1))
	(= temp0 (gTrick remaining: param1))
	(if (> (= temp2 (- global527 (localproc_4 param1))) temp0)
		(= temp2 temp0)
	)
	(if temp1
		(= global526 (- temp0 (* temp1 temp2)))
	)
	(return global526)
)

(procedure (localproc_4 param1 &tmp temp0 temp1)
	(= temp0 (= temp1 0))
	(while (< temp1 global527)
		(if
			(and
				(!= temp1 (gTheHands indexOf: (global501 cardList:)))
				(global501 playerOutOf: param1 temp1)
				(global520 outOf: 3)
				(or (global501 queenSpades:) global503 (global520 outOf: 0))
			)
			(++ temp0)
		)
		(++ temp1)
	)
	(return temp0)
)

(procedure (localproc_5 &tmp temp0 temp1 temp2)
	(= temp0 0)
	(for
		((= temp1 (+ (gTheHands indexOf: (Dealer curPlayer:)) 1)))
		(<= temp1 (+ (gTheHands indexOf: (Dealer curPlayer:)) 3))
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
				((gTheHands at: temp2) outOf: 3)
				(or
					(global501 queenSpades:)
					global503
					((gTheHands at: temp2) outOf: 0)
				)
			)
			(++ temp0)
		)
	)
	(return temp0)
)

(procedure (localproc_6 &tmp temp0 temp1 temp2)
	(= temp0 -1)
	(= temp1 -1)
	(if (> (= temp2 (localproc_8 1)) temp1)
		(= temp1 temp2)
		(= temp0 1)
	)
	(if (> (= temp2 (localproc_8 2)) temp1)
		(= temp1 temp2)
		(= temp0 2)
	)
	(if
		(and
			(or global503 (< global508 12))
			(> (= temp2 (localproc_8 0)) temp1)
		)
		(= temp1 temp2)
		(= temp0 0)
	)
	(if (and global521 (== temp0 -1) ((global501 heartsList:) size:))
		(= temp0 3)
	else
		(= temp0 global522)
	)
	(return temp0)
)

(procedure (localproc_7 param1 param2 &tmp temp0 temp1 temp2 temp3)
	(= temp3 param2)
	(for ((= temp0 (= temp1 0))) (< temp0 global504) ((++ temp0))
		(if (< (= temp2 ((global507 at: temp0) rank:)) temp3)
			(++ temp1)
		)
	)
	(return temp1)
)

(procedure (localproc_8 param1 &tmp temp0 temp1 temp2 [temp3 4])
	(= global500 520)
	(global501 getSuitList: param1)
	(= global500 521)
	(if global504
		(= global500 522)
		(= temp0
			(-
				(gTrick remaining: param1)
				((global501 cardList:) howManyOfSuit: param1)
			)
		)
		(= global500 523)
		(= temp1 (/ temp0 (- global527 global523)))
		(= global500 524)
		(if (== temp1 0)
			(= temp1 1)
		)
		(if (> temp1 global504)
			(return 0)
		)
		(= global500 525)
		(= temp2
			(-
				(global501
					howManyLower: param1 ((global507 at: (- temp1 1)) rank:)
				)
				(localproc_7 param1 ((global507 at: (- temp1 1)) rank:))
			)
		)
		(= global500 526)
		(return temp2)
	else
		(= global500 527)
		(return -1)
	)
)

(procedure (localproc_9 &tmp temp0 temp1 temp2 [temp3 4] temp7 temp8)
	(= [temp3 0]
		(if (== (global501 spadesStrength:) 11)
			-99
		else
			(global501 spadesStrength:)
		)
	)
	(= [temp3 1]
		(if (== (global501 clubsStrength:) 11)
			-99
		else
			(global501 clubsStrength:)
		)
	)
	(= [temp3 2]
		(if (== (global501 diamondsStrength:) 11)
			-99
		else
			(global501 diamondsStrength:)
		)
	)
	(= [temp3 3]
		(if (== (global501 heartsStrength:) 11)
			-99
		else
			(global501 heartsStrength:)
		)
	)
	(if (not global521)
		(= [temp3 3] -99)
	)
	(= [global513 0] 0)
	(= [global513 1] 1)
	(= [global513 2] 2)
	(= [global513 3] 3)
	(for ((= temp0 0)) (< temp0 3) ((++ temp0))
		(for ((= temp1 (+ temp0 1))) (< temp1 4) ((++ temp1))
			(if (> [temp3 temp0] [temp3 temp1])
				(= temp8 [temp3 temp1])
				(= [temp3 temp1] [temp3 temp0])
				(= [temp3 temp0] temp8)
				(= temp7 [global513 temp1])
				(= [global513 temp1] [global513 temp0])
				(= [global513 temp0] temp7)
			)
		)
	)
	(for ((= temp0 0)) (< temp0 4) ((++ temp0))
		(if (!= [temp3 temp0] -99)
			(= global511 [global513 temp0])
			(= global512 (if (== temp0 3) -1 else [global513 (+ temp0 1)]))
			(break)
		)
	)
)

(procedure (localproc_10)
	(if (and (or (< global508 12) global503) (localproc_11 0))
		(return 0)
	)
	(if (localproc_11 1)
		(return 1)
	)
	(if (localproc_11 2)
		(return 2)
	)
	(return -1)
)

(procedure (localproc_11 param1)
	(global501 getSuitList: param1)
	(return
		(if global504
			(not
				(global501
					howManyHigher: param1 ((global507 at: global505) rank:)
				)
			)
		else
			0
		)
	)
)

(procedure (localproc_12 &tmp temp0 temp1 temp2 temp3)
	(= global479 -1)
	(= temp1 ((global501 spadesList:) size:))
	(= temp2 0)
	(for ((= temp0 1)) (<= temp0 (if global521 3 else 2)) ((++ temp0))
		(if
			(>
				(= temp3
					(switch temp0
						(1
							((global501 clubsList:) size:)
						)
						(2
							((global501 diamondsList:) size:)
						)
						(3
							((global501 heartsList:) size:)
						)
					)
				)
				temp1
			)
			(= global479 temp2)
			(= temp2 temp0)
			(= temp1 temp3)
		)
	)
	(if (not global479)
		(= global479 -1)
	)
	(return temp2)
)

(procedure (localproc_13)
	(return
		(or
			global481
			(== ((global501 heartsList:) size:) ((global501 cardList:) size:))
		)
	)
)

(procedure (localproc_14 &tmp temp0 temp1 temp2)
	(if
		(or
			global503
			(and
				(not (global501 queenSpades:))
				(not (global501 kingSpades:))
				(not (global501 aceSpades:))
			)
		)
		(return 0)
	)
	(= global229 1)
	(for ((= temp2 0)) (< temp2 global527) ((++ temp2))
		(if
			(and
				(!= (= global520 (gTheHands at: temp2)) global501)
				global520
				(not (global520 outOf: 0))
			)
			(++ global229)
		)
	)
	(= temp1 (- (gTrick remaining: 0) ((global501 spadesList:) size:)))
	(if (> (- global229 1) temp1)
		(= global229 (+ temp1 1))
	)
	(= temp0 0)
	(if (global501 queenSpades:)
		(= temp0 (+ (global501 kingSpades:) (global501 aceSpades:)))
	)
	(if
		(>
			(+ (global501 lowSpades:) temp0)
			(/ (gTrick remaining: 0) global229)
		)
		(return 0)
	else
		(return 1)
	)
)

