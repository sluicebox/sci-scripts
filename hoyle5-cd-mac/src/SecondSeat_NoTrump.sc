;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 754)
(include sci.sh)
(use Main)
(use BridgeDefense)
(use Discard)
(use System)

(class SecondSeat_NoTrump of BridgeDefense
	(properties)

	(method (think param1 &tmp temp0 temp1 temp2 [temp3 2] temp5 temp6 temp7 temp8 temp9 temp10)
		(super think: &rest)
		(= temp5
			(- (- 14 (- (gTrick tricksPlayed:) global433)) (+ global434 6))
		)
		(= temp0 (if (== LHO global431) global429 else global431))
		(= temp6 (gTrick suitLead:))
		(= temp1 (curPlyr countSuit: temp6))
		(= temp2 (pard countSuit: temp6))
		(= temp7 ((gTrick highCard:) rank:))
		(if (== curPlyr (global429 LHO:))
			(= temp10 3)
			(= temp9 4)
		else
			(= temp10 4)
			(= temp9 3)
		)
		(= temp8 0)
		(if
			(==
				temp10
				(switch temp6
					(1 [global162 0])
					(2 [global149 0])
					(3 [global136 0])
					(4 [global123 0])
				)
			)
			(= temp8 1)
		)
		(if
			(and
				temp8
				(>= skill 1)
				(or
					(and
						(or (== temp2 1) (and (== temp2 2) (> temp1 2)))
						(==
							temp9
							(switch temp6
								(1 [global162 1])
								(2 [global149 1])
								(3 [global136 1])
								(4 [global123 1])
							)
						)
					)
					(and
						(==
							temp9
							(switch temp6
								(1 [global162 2])
								(2 [global149 2])
								(3 [global136 2])
								(4 [global123 2])
							)
						)
						(<= temp2 2)
						(or
							(> (global429 countSuit: temp6) 1)
							(> (global431 countSuit: temp6) 1)
						)
					)
				)
			)
			(= temp8 0)
		)
		(cond
			((not temp1)
				(= theCard (Discard think:))
			)
			(
				(or
					(== temp1 1)
					(not
						(curPlyr
							hasCard: temp6 (| (gTrick highOfSuitLead:) $0f00)
						)
					)
				)
				(self play: temp6)
			)
			(
				(and
					(or (== skill 2) (and (== LHO global431) (== skill 1)))
					(= theCard (self winCheap: temp6))
				))
			(
				(and
					temp8
					(>= skill 1)
					(or
						(>= temp2 temp1)
						(not temp2)
						(and
							(>=
								(Max temp1 temp2)
								(LHO countSuit: temp6)
							)
							(>=
								(Max temp1 temp2)
								(temp0 countSuit: temp6)
							)
						)
					)
				)
				(self play: temp6 12)
			)
			((and temp8 (< skill 1))
				(self play: temp6 12)
			)
			(else
				(self play: temp6)
			)
		)
		(if (and temp1 (or (not theCard) (!= (theCard suit:) temp6)))
			(self play: temp6)
		)
		(self verifiedCard: theCard)
	)

	(method (getHighest param1 &tmp temp0 temp1 temp2 temp3)
		(= temp0
			(if (!= argc 2)
				((gTrick highCard:) suit:)
			else
				[param1 1]
			)
		)
		(= temp2 (= temp1 0))
		(while (< temp1 (param1 size:))
			(if
				(and
					(== ((= temp3 (param1 at: temp1)) suit:) temp0)
					(> (temp3 rank:) temp2)
				)
				(= temp2 (temp3 rank:))
			)
			(++ temp1)
		)
		(return temp2)
	)

	(method (getNumHigher param1 param2 &tmp temp0 temp1 temp2)
		(= temp2 (= temp0 0))
		(while (< temp0 (param1 size:))
			(if
				(and
					(==
						((= temp1 (param1 at: temp0)) suit:)
						((gTrick highCard:) suit:)
					)
					(> (temp1 rank:) param2)
				)
				(++ temp2)
			)
			(++ temp0)
		)
		(return temp2)
	)

	(method (getNumLower param1 param2 param3 &tmp temp0 temp1 temp2)
		(= temp2 (= temp0 0))
		(while (< temp0 (param1 size:))
			(= temp1 (param1 at: temp0))
			(if (and (== (temp1 suit:) param2) (< (temp1 rank:) param3))
				(++ temp2)
			)
			(++ temp0)
		)
		(return temp2)
	)

	(method (getNextHigher param1 param2 param3 &tmp temp0 temp1 temp2 temp3)
		(= temp1 20)
		(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
			(= temp3 (param1 at: temp0))
			(if
				(and
					(== (temp3 suit:) param2)
					(> (temp3 rank:) param3)
					(< (temp3 rank:) temp1)
				)
				(= temp1 (temp3 rank:))
				(= theCard temp3)
			)
		)
		(return (if (!= temp1 20) temp1 else 0))
	)

	(method (getNextLower param1 param2 param3 &tmp temp0 temp1 temp2 temp3)
		(= temp1 0)
		(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
			(= temp3 (param1 at: temp0))
			(if
				(and
					(== (temp3 suit:) param2)
					(< (temp3 rank:) param3)
					(> (temp3 rank:) temp1)
				)
				(= temp1 (temp3 rank:))
				(= theCard temp3)
			)
		)
		(return temp1)
	)

	(method (getNumSpots param1 param2)
		(return (- (param1 countSuit: param2) (param1 calcHonors: param2)))
	)
)

