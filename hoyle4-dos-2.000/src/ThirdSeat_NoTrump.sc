;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 755)
(include sci.sh)
(use Main)
(use SortArray)
(use BridgeDefense)
(use Discard)
(use System)

(local
	[local0 13]
	local13
)

(class ThirdSeat_NoTrump of BridgeDefense
	(properties
		secondHigh 0
		thirdHigh 0
	)

	(method (think param1 &tmp temp0 temp1 temp2 temp3 [temp4 4] temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18)
		(super think: &rest)
		(= temp3 (if (== LHO global431) global429 else global431))
		(= temp9 (self checkTopTricks: param1))
		(= temp12 (self checkLongTricks: 4))
		(= temp13 (self checkLongTricks: 1))
		(= temp14 (self checkLongTricks: 2))
		(= temp15 (self checkLongTricks: 3))
		(= temp16 (+ temp12 temp13 temp14 temp15))
		(= temp8 (gTrick tricksPlayed:))
		(= temp10 (- (- 14 (- temp8 global433)) (+ global434 6)))
		(= local13 (gTrick suitLead:))
		(cond
			((not (= temp18 (curPlyr countSuit: local13)))
				(= theCard (Discard think:))
			)
			(
				(or
					(== temp18 1)
					(not
						(curPlyr
							hasCard:
								local13
								(| (gTrick highOfSuitLead:) $0f00)
						)
					)
					(and (gTrick highTrump:) (!= local13 trumps))
				)
				(self play: local13)
			)
			(
				(and
					(or (== skill 2) (and (== LHO global431) (== skill 1)))
					(= theCard (self winCheap: local13))
				))
			((= theCard (self coverIfNeeded:)))
			(else
				(self play: local13 12)
			)
		)
		(if
			(and
				temp18
				(or (not (IsObject theCard)) (!= (theCard suit:) local13))
			)
			(self play: local13)
		)
		(= temp1 (self verifiedCard: theCard))
		(self verifiedCard: temp1)
	)

	(method (coverIfNeeded &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10)
		(= temp0 (gTrick highOfSuitLead:))
		(= temp3 (= temp6 0))
		(= temp5 (curPlyr hasCard: local13 (| temp0 $0f00)))
		(= temp7 99)
		(= temp9 0)
		(for ((= temp1 0)) (< temp1 (curPlyr size:)) ((++ temp1))
			(= temp2 (curPlyr at: temp1))
			(if (and (== (temp2 suit:) local13) (> (temp2 rank:) temp9))
				(= temp9 (temp2 rank:))
				(= temp10 temp2)
			)
			(if (and (== (temp2 suit:) local13) (> temp7 (temp2 rank:) temp0))
				(= temp7 (temp2 rank:))
				(= temp3 temp2)
			)
		)
		(if
			(and
				(== (gTrick highPlayer:) pard)
				(or (== temp7 (+ temp0 1)) (== temp7 (+ temp0 temp5)))
			)
			(self play: local13)
			(return (= temp3 theCard))
		)
		(if (== (gTrick highPlayer:) pard)
			(= temp4
				(-
					(+ 1 (SortArray isCurrent: (gTrick highCard:)))
					(SortArray isCurrent: temp3)
				)
			)
		else
			(= temp4 (- temp7 temp0))
		)
		(= temp6 (LHO hasCard: theSuitLead (| (temp3 rank:) $0f00)))
		(= temp8 (LHO hasCard: theSuitLead (| temp9 $0f00)))
		(cond
			(
				(and
					(not (SortArray isCurrent: temp10))
					(== (gTrick highPlayer:) pard)
					(< temp4 2)
				)
				(self play: local13)
				(= temp3 theCard)
			)
			((not (SortArray isCurrent: temp10))
				(= temp3 0)
			)
			((and (== temp6 temp8 1) (== skill 2)))
			(temp6
				(= temp3 0)
			)
			(
				(and
					(< temp4 2)
					(< temp5 (curPlyr countSuit: local13))
					(== (gTrick highPlayer:) pard)
				)
				(self play: local13)
				(= temp3 theCard)
			)
		)
		(return temp3)
	)

	(method (getNextHigher param1 param2 &tmp temp0 temp1 temp2 temp3)
		(= temp1 20)
		(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
			(= temp3 (param1 at: temp0))
			(if
				(and
					(== (temp3 suit:) local13)
					(> (temp3 rank:) param2)
					(< (temp3 rank:) temp1)
				)
				(= temp1 (temp3 rank:))
				(= theCard temp3)
			)
		)
		(return (if (!= temp1 20) temp1 else 0))
	)

	(method (checkCardBetween param1 param2 param3 &tmp temp0 temp1 temp2 temp3)
		(= temp2 (Min param2 param3))
		(= temp3 (Max param2 param3))
		(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
			(= temp1 (param1 at: temp0))
			(if (and (== (temp1 suit:) local13) (> temp3 (temp1 rank:) temp2))
				(return 1)
			)
		)
		(return 0)
	)

	(method (checkLongTricks param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10)
		(= temp10 param1)
		(= temp4 (curPlyr RHO:))
		(switch temp10
			(4
				(= temp0
					(+
						((global117 atLocation: 3) countSuit: 4)
						((global117 atLocation: 2) countSuit: 4)
						((global117 atLocation: 1) countSuit: 4)
						((global117 atLocation: 4) countSuit: 4)
					)
				)
				(= temp1 (curPlyr topSp:))
				(= temp2 (LHO minSpades:))
				(= temp3 (LHO maxSpades:))
				(= temp5 (temp4 minSpades:))
				(= temp6 (temp4 maxSpades:))
				(= temp7 (global429 spades:))
				(= temp8 (global431 spades:))
			)
			(1
				(= temp0
					(+
						((global117 atLocation: 3) countSuit: 1)
						((global117 atLocation: 2) countSuit: 1)
						((global117 atLocation: 1) countSuit: 1)
						((global117 atLocation: 4) countSuit: 1)
					)
				)
				(= temp1 (curPlyr topCl:))
				(= temp2 (LHO minClubs:))
				(= temp3 (LHO maxClubs:))
				(= temp5 (temp4 minClubs:))
				(= temp6 (temp4 maxClubs:))
				(= temp7 (global429 clubs:))
				(= temp8 (global431 clubs:))
			)
			(2
				(= temp0
					(+
						((global117 atLocation: 3) countSuit: 2)
						((global117 atLocation: 2) countSuit: 2)
						((global117 atLocation: 1) countSuit: 2)
						((global117 atLocation: 4) countSuit: 2)
					)
				)
				(= temp1 (curPlyr topDi:))
				(= temp2 (LHO minDiamonds:))
				(= temp3 (LHO maxDiamonds:))
				(= temp5 (temp4 minDiamonds:))
				(= temp6 (temp4 maxDiamonds:))
				(= temp7 (global429 diamonds:))
				(= temp8 (global431 diamonds:))
			)
			(3
				(= temp0
					(+
						((global117 atLocation: 3) countSuit: 3)
						((global117 atLocation: 2) countSuit: 3)
						((global117 atLocation: 1) countSuit: 3)
						((global117 atLocation: 4) countSuit: 3)
					)
				)
				(= temp1 (curPlyr topHt:))
				(= temp2 (LHO minHearts:))
				(= temp3 (LHO maxHearts:))
				(= temp5 (temp4 minHearts:))
				(= temp6 (temp4 maxHearts:))
				(= temp7 (global429 hearts:))
				(= temp8 (global431 hearts:))
			)
		)
		(= temp9 (- temp0 (+ temp8 temp7)))
		(if (>= (- temp1 (Max temp3 temp6)) 0)
			(return (Max temp8 temp7))
		)
		(if (>= temp1 (/ (+ 5 temp9) 2))
			(return (Max temp8 temp7))
		)
		(if (>= temp1 (/ (+ 3 temp9) 2))
			(return (Max temp8 temp7))
		)
		(if (>= temp1 (/ (+ 1 temp9) 2))
			(return (Max temp8 temp7))
		)
		(if (> temp1 (/ (+ 1 temp9) 2))
			(curPlyr LHOChance: 100)
			(return (Max temp8 temp7))
		)
		(return temp1)
	)
)

