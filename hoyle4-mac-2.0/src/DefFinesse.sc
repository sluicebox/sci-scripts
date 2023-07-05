;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 760)
(include sci.sh)
(use Main)
(use Piles)
(use n726)
(use Bid)
(use System)

(class DefFinesse of Code
	(properties
		curPlyr 0
		whichSuit 0
		initialized 0
	)

	(method (init &tmp [temp0 5])
		(= curPlyr (Dealer curPlayer:))
		(proc726_0)
		(= initialized 1)
	)

	(method (doit param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(if (not initialized)
			(self init:)
		)
		(= whichSuit param1)
		(self loadFinArray:)
		(if (< argc 2)
			(= param2 global431)
			(= temp7 curPlyr)
		)
		(= temp2 (self countBid: global429))
		(= temp1 (self countBid: (curPlyr partner:)))
		(cond
			((> (global117 at: global431) (global117 at: curPlyr))
				(cond
					(
						(and
							(== (self hasCard: param2 14 12 10) 3)
							(not (self hasCard: temp7 13 11))
							(not temp2)
						)
						(return 18)
					)
					(
						(and
							(== (self hasCard: param2 13 11 9) 3)
							(not (self hasCard: temp7 14 12 10))
							temp1
						)
						(return 21)
					)
					(
						(and
							(== (self hasCard: param2 12 10 8) 3)
							(not (self hasCard: temp7 11 9))
							(not (== (self hasCard: temp7 14 13) 2))
							temp1
						)
						(return 24)
					)
					(
						(and
							(== (self hasCard: param2 14 12) 2)
							(not (self hasCard: temp7 13))
							(not temp2)
						)
						(return 1)
					)
					(
						(and
							(== (self hasCard: param2 13 11) 2)
							(not (self hasCard: temp7 14 12))
							temp1
						)
						(return 1)
					)
					(
						(and
							(self hasCard: param2 13)
							(not (self hasCard: param2 11))
							(not (self hasCard: temp7 14 13))
							temp1
						)
						(return 1)
					)
					(
						(and
							(== (self hasCard: param2 12 11) 2)
							(not (self hasCard: param2 10))
							(or
								(and
									(= temp0 (self hasCard: param2 9))
									(not (self hasCard: temp7 10))
								)
								(not temp0)
							)
							(not (self hasCard: temp7 14 13))
							temp1
						)
						(return 1)
					)
					(
						(and
							(self hasCard: temp7 14)
							(self hasCard: param2 13)
							(not (self hasCard: temp7 12))
							(not temp2)
						)
						(return 1)
					)
					(
						(and
							(self hasCard: param2 13)
							(not (self hasCard: temp7 14))
							(or
								(self hasCard: temp7 12)
								(self hasCard: temp7 11)
							)
							temp1
						)
						(return (self setFinCard: 12))
					)
					(else
						(return 0)
					)
				)
			)
			(
				(and
					(= temp3 (not (param2 hasCard: whichSuit 3850)))
					(not (temp7 hasCard: whichSuit 3850))
					(< temp2 2)
				)
				(return 1)
			)
			(
				(and
					temp3
					temp1
					(or
						(and
							(= temp4 (not (self hasCard: temp7 14)))
							(= temp5 (not (self hasCard: temp7 13)))
						)
						(and temp4 (= temp6 (not (self hasCard: temp7 12))))
						(and temp5 temp6 (not (self hasCard: temp7 11)))
					)
				)
				(return 1)
			)
			(
				(and
					(not (param2 hasCard: whichSuit 3850))
					(== (self hasCard: temp7 12 11) 2)
					(or temp1 (not temp2))
				)
				(return (self setFinCard: 12))
			)
			(
				(and
					(or (self hasCard: temp7 13) (self hasCard: temp7 12))
					(self hasCard: temp7 10)
					(self countSpots: temp7)
					(self hasCard: param2 11)
					(or temp1 (not temp2))
				)
				(return 1)
			)
			(
				(and
					(== (self hasCard: temp7 13 11) 2)
					(self countSpots: temp7)
					(self hasCard: param2 12)
					temp1
				)
				(return 1)
			)
			(else
				(return 0)
			)
		)
	)

	(method (loadFinArray param1 &tmp temp0 temp1)
		(= temp1 (if argc param1 else whichSuit))
		(for ((= temp0 0)) (< temp0 13) ((++ temp0))
			(= [global201 temp0]
				(switch temp1
					(1 [global162 (- 12 temp0)])
					(2 [global149 (- 12 temp0)])
					(3 [global136 (- 12 temp0)])
					(4 [global123 (- 12 temp0)])
				)
			)
		)
	)

	(method (hasCard param1 &tmp temp0 temp1 temp2)
		(= temp1 (+ 1 (== param1 global431)))
		(for ((= temp0 0)) (< temp0 (- argc 1)) ((++ temp0))
			(if (== [global201 (- 14 temp0)] temp1)
				(++ temp2) ; UNINIT
			)
		)
		(return temp2) ; UNINIT
	)

	(method (setFinCard param1 &tmp temp0 temp1 temp2)
		(= temp2 (Dealer curPlayer:))
		(= temp1 0)
		(if argc
			(for ((= temp0 0)) (< temp0 (temp2 size:)) ((++ temp0))
				(= temp1 (temp2 at: temp0))
				(if (and (== (temp1 suit:) whichSuit) (== (temp1 rank:) param1))
					(break)
				)
			)
		else
			(= temp1
				(if (> (temp2 countSuit: whichSuit) 2)
					(self getLowest: whichSuit)
				else
					(self getHighest: whichSuit)
				)
			)
		)
		(temp2 finCard: temp1)
	)

	(method (getHighest param1 &tmp temp0 temp1 temp2 temp3)
		(= temp3 (Dealer curPlayer:))
		(= temp1 (= temp2 (= temp0 0)))
		(while (< temp0 (temp3 size:))
			(if
				(and
					(== ((= temp2 (temp3 at: temp0)) suit:) param1)
					(> (temp2 rank:) temp1)
				)
				(= temp1 (temp2 rank:))
			)
			(++ temp0)
		)
		(return temp2)
	)

	(method (getLowest param1 &tmp temp0 temp1 temp2 temp3)
		(= temp3 (Dealer curPlayer:))
		(= temp1 40)
		(= temp2 (= temp0 0))
		(while (< temp0 (temp3 size:))
			(if
				(and
					(== ((= temp2 (temp3 at: temp0)) suit:) param1)
					(< (temp2 rank:) temp1)
				)
				(= temp1 (temp2 rank:))
			)
			(++ temp0)
		)
		(return temp2)
	)

	(method (countBid param1 param2 &tmp temp0 temp1 temp2 temp3)
		(= temp1 (param1 location:))
		(= temp2 0)
		(for ((= temp0 0)) (< temp0 (BidBox size:)) ((++ temp0))
			(if (== ((BidBox at: temp0) location:) temp1)
				(break)
			)
		)
		(if (< argc 2)
			(= param2 whichSuit)
		)
		0
		(while (< temp0 (BidBox size:))
			(= temp3 (BidBox at: temp0))
			(if (== (temp3 suit:) param2)
				(++ temp2)
			)
			(+= temp0 4)
		)
		(return temp2)
	)

	(method (countSpots param1 &tmp temp0 temp1 temp2 temp3)
		(= temp2 1)
		(= temp3 0)
		(while (<= temp2 4)
			(if (= temp0 (param1 couldPlay: temp2))
				(= temp1 (param1 hasCard: 3848))
			)
			(+= temp3 (- temp0 temp1))
			(++ temp2)
		)
		(return temp3)
	)
)

