;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 305)
(include sci.sh)
(use Main)
(use Piles)
(use heartsGame)

(public
	proc305_0 0
)

(procedure (proc305_0 param1 &tmp temp0 temp1)
	(= global501 param1)
	(= [global531 0] ((global501 spadesList:) size:))
	(= [global531 1] ((global501 clubsList:) size:))
	(= [global531 2] ((global501 diamondsList:) size:))
	(= [global531 3] ((global501 heartsList:) size:))
	(= global500 100)
	(= global536 [global531 global528])
	(= global247 (= global497 0))
	(for ((= temp0 0)) (< temp0 ((global501 cardList:) size:)) ((++ temp0))
		(= temp1 (((global501 cardList:) at: temp0) rank:))
		(if (== (((global501 cardList:) at: temp0) suit:) global528)
			(if (> temp1 global247)
				(= global247 temp1)
			)
			(if (> temp1 global529)
				(++ global497)
			)
		)
	)
	(= global537 (- (= global536 [global531 global528]) global497))
	(= global500 101)
	(= global499
		(if [global531 global528]
			(localproc_19 global528)
		else
			0
		)
	)
	(= global540 (localproc_20))
	(= global500 102)
	(= global524 (localproc_3))
	(= global500 103)
	(= global245 (localproc_0))
	(= global246 (localproc_4))
	(= global500 106)
	(= global523 (localproc_8))
	(= global248 (localproc_9))
	(= global494 (localproc_6 global528))
	(= global500 107)
	(global501 heartDanger: (localproc_10 3))
	(= global500 108)
	(global501 spadeDanger: (localproc_11))
	(= global500 109)
	(= global522 (localproc_12))
	(= global500 110)
	(= global496 (localproc_13))
	(= global500 111)
	(= global495 (localproc_14))
	(= global500 112)
	(= global239 (localproc_15))
	(= global500 113)
	(= global539 (localproc_17))
	(= global500 114)
	(= global238 (localproc_18))
	(= global500 115)
	(localproc_21)
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3)
	(if (!= (global501 takeAllPlayer:) (global501 cardList:))
		(= global249 (= temp2 -1))
		(for ((= temp0 0)) (<= temp0 3) ((++ temp0))
			(if (and (= temp1 (localproc_1 temp0)) (> temp1 global249))
				(if
					(and
						(== temp0 3)
						(or
							(and (== global236 1) (gTrick tricksPlayed:))
							(== global236 0)
						)
						global540
						(!= global498 (global501 cardList:))
						(<
							(global501
								howManyHigher:
									3
									(((global501 heartsList:)
											at:
												(-
													((global501 heartsList:)
														size:
													)
													1
												)
										)
										rank:
									)
							)
							5
						)
					)
					(break)
				else
					(= global249 temp1)
					(= temp2 temp0)
				)
			)
		)
		(if (== temp2 -1)
			(= temp2 global524)
		)
	else
		(= temp2 3)
		(= temp3 99)
		(if [global531 0]
			(= temp3 (global501 spadesStrength:))
			(= temp2 0)
		)
		(if (and [global531 1] (< (global501 clubsStrength:) temp3))
			(= temp3 (global501 clubsStrength:))
			(= temp2 1)
		)
		(if (and [global531 2] (< (global501 diamondsStrength:) temp3))
			(= temp3 (global501 diamondsStrength:))
			(= temp2 2)
		)
	)
	(return temp2)
)

(procedure (localproc_1 param1 &tmp temp0 temp1)
	(global501 getSuitList: param1)
	(if
		(or
			(not global504)
			(and (== param1 0) (global501 spadeDanger:))
			(and (== param1 3) (global501 heartDanger:))
			(- (localproc_2 param1) (localproc_7 param1))
		)
		(return 0)
	)
	(return (= temp0 (localproc_5 param1)))
)

(procedure (localproc_2 param1 &tmp temp0 temp1)
	(= temp0 (= temp1 0))
	(while (< temp1 global527)
		(if (global501 playerOutOf: param1 temp1)
			(++ temp0)
		)
		(++ temp1)
	)
	(return temp0)
)

(procedure (localproc_3 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(= temp1 (localproc_10 0))
	(= temp2 0)
	(if global504
		(= temp3 ((global507 at: global505) rank:))
	)
	(for ((= temp0 1)) (< temp0 4) ((++ temp0))
		(= temp5 (localproc_10 temp0))
		(if global504
			(= temp4 ((global507 at: global505) rank:))
			(cond
				((> temp5 temp1)
					(= temp1 temp5)
					(= temp2 temp0)
					(= temp3 temp4)
				)
				(
					(and
						(== temp5 temp1)
						(>= temp4 ((global507 at: global505) rank:))
					)
					(= temp1 temp5)
					(= temp2 temp0)
					(= temp3 temp4)
				)
			)
		)
	)
	(return temp2)
)

(procedure (localproc_4 &tmp temp0 temp1)
	(if (global501 takeAllPlayer:)
		(= temp0 (not ((global501 takeAllPlayer:) outOf: global528)))
		(= temp1 (gTrick anyHigherRemaining: global528 global529))
		(return (or temp0 temp1))
	)
	(return 0)
)

(procedure (localproc_5 param1 &tmp temp0 temp1)
	(= temp1 0)
	(if
		(and
			(> (= temp0 (- global527 (localproc_7 param1))) 1)
			(<=
				[global531 param1]
				(/
					(+
						(gTrick remaining: param1)
						(if (== param1 global528) [global184 param1] else 0)
					)
					temp0
				)
			)
		)
		(= temp1
			(-
				(+
					(gTrick remaining: param1)
					(if (== param1 global528) [global184 param1] else 0)
				)
				(* [global531 param1] temp0)
			)
		)
	)
	(return temp1)
)

(procedure (localproc_6 param1 &tmp [temp0 2])
	(if
		(or
			global496
			(and
				(>=
					(- (gTrick remaining: param1) [global531 param1])
					(+ (- (- global527 global523) (gTrick size:)) 1)
				)
				global248
			)
		)
		(return 1)
	)
	(return 0)
)

(procedure (localproc_7 param1 &tmp temp0 temp1)
	(= temp0 (= temp1 0))
	(while (< temp1 global527)
		(if
			(and
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

(procedure (localproc_8 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(= temp0 0)
	(= temp2 (- global527 (gTrick size:)))
	(for
		((= temp1 (+ (= temp4 (global117 indexOf: (Dealer curPlayer:))) 1)))
		(<= temp1 (+ temp4 temp2))
		((++ temp1))
		
		(= temp3
			(if (>= temp1 global527)
				(- temp1 global527)
			else
				temp1
			)
		)
		(if
			(and
				((= temp5 (global117 at: temp3)) outOf: global528)
				(temp5 outOf: 3)
				(or (global501 queenSpades:) global503 (temp5 outOf: 0))
			)
			(++ temp0)
		)
	)
	(return temp0)
)

(procedure (localproc_9 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(= temp2 (- global527 (gTrick size:)))
	(for
		((= temp1 (+ (= temp4 (global117 indexOf: (Dealer curPlayer:))) 1)))
		(<= temp1 (+ temp4 temp2))
		((++ temp1))
		
		(= temp3
			(if (>= temp1 global527)
				(- temp1 global527)
			else
				temp1
			)
		)
		(if
			(and
				((= temp5 (global117 at: temp3)) outOf: global528)
				(or
					(not (temp5 outOf: 3))
					(and
						(not (global501 queenSpades:))
						(not global503)
						(not (temp5 outOf: 0))
					)
				)
			)
			(return 0)
		)
	)
	(return 1)
)

(procedure (localproc_10 param1 &tmp temp0 temp1 temp2 temp3 temp4)
	(global501 getSuitList: param1)
	(= global535 0)
	(if global504
		(for ((= temp0 0)) (< temp0 global504) ((++ temp0))
			(= temp1 (global507 atRank: temp0))
			(= temp2 (- (- global527 1) (localproc_7 param1)))
			(= temp3 (global501 howManyLower: param1 temp1))
			(switch temp0
				(0
					(if (>= temp3 temp2)
						(= global535 (+ (- temp3 temp2) 1))
					)
				)
				(1
					(if (>= (= temp4 (- (- temp3 1) (* 2 temp2))) 0)
						(+= global535 (+ temp4 1))
					)
				)
				(2
					(if (>= (= temp4 (- (- temp3 1) (* 3 temp2))) 0)
						(+= global535 (+ temp4 1))
					)
				)
				(3
					(if (>= (= temp4 (- (- temp3 1) (* 4 temp2))) 0)
						(+= global535 (+ temp4 1))
					)
				)
			)
		)
		(if (== global535 1)
			(= global535 0)
		)
	)
	(return global535)
)

(procedure (localproc_11 &tmp temp0 temp1 temp2)
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
		(proc300_2 temp2)
		(if (and (!= global520 global501) global520 (not (global520 outOf: 0)))
			(++ global229)
		)
	)
	(= temp1 (- (gTrick remaining: 0) [global531 0]))
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

(procedure (localproc_12 &tmp temp0 temp1 temp2)
	(= global479 -1)
	(= temp1 [global531 0])
	(= temp2 0)
	(for ((= temp0 1)) (<= temp0 3) ((++ temp0))
		(if (> [global531 temp0] temp1)
			(= global479 temp2)
			(= temp2 temp0)
			(= temp1 [global531 temp0])
		)
	)
	(if (not global479)
		(= global479 -1)
	)
	(return temp2)
)

(procedure (localproc_13)
	(return (== (- global527 (gTrick size:)) 1))
)

(procedure (localproc_14 &tmp temp0 temp1 temp2 temp3)
	(if (not (- (gTrick remaining: global528) [global531 global528]))
		(return 0)
	)
	(= temp1 (- (- global527 (gTrick size:)) 1))
	(for
		((= temp0 (+ (= temp3 (global117 indexOf: (Dealer curPlayer:))) 1)))
		(<= temp0 (+ temp3 temp1))
		((++ temp0))
		
		(= temp2
			(if (>= temp0 global527)
				(- temp0 global527)
			else
				temp0
			)
		)
		(if (not ((global117 at: temp2) outOf: global528))
			(return 0)
		)
	)
	(return 1)
)

(procedure (localproc_15)
	(if
		(or
			[global531 2]
			[global531 1]
			(>= [global531 0] 2)
			(and (== [global531 0] 1) (not (global501 queenSpades:)))
		)
		(return 1)
	)
	(return 0)
)

(procedure (localproc_16 param1 &tmp temp0 temp1 temp2 temp3)
	(= temp1 (- (- global527 (gTrick size:)) 1))
	(for
		((= temp0 (+ (= temp3 (global117 indexOf: (Dealer curPlayer:))) 1)))
		(<= temp0 (+ temp3 temp1))
		((++ temp0))
		
		(= temp2
			(if (>= temp0 global527)
				(- temp0 global527)
			else
				temp0
			)
		)
		(if (== param1 (global117 at: temp2))
			(return 0)
		)
	)
	(return 1)
)

(procedure (localproc_17 &tmp [temp0 3])
	(localproc_16 (global501 takeAllPlayer:))
)

(procedure (localproc_18)
	(global501 getSuitList: global528)
	(return
		(if global504
			(global501
				howManyHigher: global528 ((global507 at: global505) rank:)
			)
		else
			0
		)
	)
)

(procedure (localproc_19 param1 &tmp temp0 temp1)
	(global501 getSuitList: param1)
	(if (> ((global507 at: 0) rank:) global529)
		(= temp0 (global501 howManyLower: param1 ((global507 at: 0) rank:)))
		(= temp1 (- (- (- global527 1) (gTrick size:)) (localproc_8)))
		(return (> temp0 temp1))
	else
		(return 0)
	)
)

(procedure (localproc_20 &tmp temp0 temp1)
	(= temp0 0)
	(if ((global117 at: 0) tempTotal:)
		(= temp1 (global117 at: 0))
		(++ temp0)
	)
	(if ((global117 at: 1) tempTotal:)
		(= temp1 (global117 at: 1))
		(++ temp0)
	)
	(if ((global117 at: 2) tempTotal:)
		(= temp1 (global117 at: 2))
		(++ temp0)
	)
	(if ((global117 at: 3) tempTotal:)
		(= temp1 (global117 at: 3))
		(++ temp0)
	)
	(= global498 0)
	(if (== temp0 1)
		(= global498 temp1)
	)
	(if (or (not temp0) (and (== temp0 1) (not global530)))
		(return 1)
	)
	(if (and (== temp0 1) global530)
		(cond
			((localproc_16 temp1)
				(if (== global525 (global117 indexOf: temp1))
					(return 1)
				)
			)
			(
				(or
					(temp1 outOf: global528)
					(not (gTrick anyHigherRemaining: global528 global529))
				)
				(return 1)
			)
		)
	)
	(return 0)
)

(procedure (localproc_21)
	(if
		(and
			global540
			(== global525 global228)
			(or
				(and
					(== global528 3)
					(> (global501 howManyLower: 3 global529) (+ global527 2))
				)
				(and (== global528 0) (not global503) (>= global529 12))
			)
		)
		(global501 takeAllPlayer: (proc300_2 global228) obvious: 1)
		(switch (global501 skill:)
			(0
				(global501 takeAllPlayer: 0)
			)
			(1
				(if (== (global501 takeAllPlayer:) (global501 cardList:))
					(global501 takeAllPlayer: 0)
				)
			)
		)
	)
)

