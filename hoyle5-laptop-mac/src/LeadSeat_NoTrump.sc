;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 753)
(include sci.sh)
(use Main)
(use BridgeDefense)
(use bidBoxWindow)
(use System)

(local
	[local0 6]
	[local6 6]
	[local12 5]
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(= temp1 (global429 location:))
	(= temp2 (global431 location:))
	(for ((= temp0 0)) (< temp0 6) ((++ temp0))
		(= [local0 temp0] 0)
	)
	(for ((= temp0 0)) (< temp0 (BidBox size:)) ((++ temp0))
		(= temp4 (BidBox at: temp0))
		(= temp3 (temp4 location:))
		(= temp5 (temp4 suit:))
		(if
			(and
				(OneOf temp3 temp1 temp2)
				(not (temp4 artificial:))
				(<= 1 temp5 4)
			)
			(break)
		)
	)
	(if (== temp3 temp2)
		(= [local0 temp5] 3)
	else
		(= [local0 temp5] 1)
	)
	0
	(while (< temp0 (BidBox size:))
		(= temp4 (BidBox at: temp0))
		(= temp3 (temp4 location:))
		(cond
			((and (== [local0 (= temp5 (temp4 suit:))] 1) (== temp3 temp2))
				(= [local0 temp5] 2)
			)
			((and (== [local0 temp5] 3) (== temp3 temp1))
				(= [local0 temp5] 4)
			)
			((and (not [local0 temp5]) (not (temp4 artificial:)) (<= 1 temp5 4))
				(if (== temp3 temp1)
					(= [local0 temp5] 1)
				else
					(= [local0 temp5] 3)
				)
			)
		)
		(+= temp0 2)
	)
)

(procedure (localproc_1 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(= temp1 ((param1 partner:) location:))
	(= temp2 (param1 location:))
	(for ((= temp0 0)) (< temp0 6) ((++ temp0))
		(= [local6 temp0] 0)
	)
	(for ((= temp0 0)) (< temp0 (BidBox size:)) ((++ temp0))
		(= temp5 (BidBox at: temp0))
		(= temp4 (temp5 location:))
		(= temp6 (temp5 suit:))
		(if
			(and
				(OneOf temp4 temp1 temp2)
				(not (temp5 artificial:))
				(<= 1 temp6 4)
			)
			(break)
		)
	)
	(if (== temp4 temp1)
		(= [local6 temp6] 3)
	else
		(= [local6 temp6] 1)
	)
	0
	(while (< temp0 (BidBox size:))
		(= temp5 (BidBox at: temp0))
		(= temp4 (temp5 location:))
		(cond
			((and (== [local6 (= temp6 (temp5 suit:))] 1) (== temp4 temp1))
				(= [local6 temp6] 2)
			)
			((and (== [local6 temp6] 3) (== temp4 temp2))
				(= [local6 temp6] 4)
			)
			((and (not [local6 temp6]) (not (temp5 artificial:)) (<= 1 temp6 4))
				(if (== temp4 temp2)
					(= [local6 temp6] 1)
				else
					(= [local6 temp6] 3)
				)
			)
		)
		(+= temp0 2)
	)
)

(class LeadSeat_NoTrump of BridgeDefense
	(properties
		suffSuit 0
		bidSuit 0
	)

	(method (init &tmp temp0)
		(for ((= temp0 0)) (< temp0 6) ((++ temp0))
			(= [local0 temp0] 0)
			(= [local6 temp0] 0)
		)
		(for ((= temp0 0)) (< temp0 5) ((++ temp0))
			(= [local12 temp0] 0)
		)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
	)

	(method (think param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(super think: &rest)
		(= [local12 2] (curPlyr diamonds:))
		(= [local12 1] (curPlyr clubs:))
		(= [local12 3] (curPlyr hearts:))
		(= [local12 4] (curPlyr spades:))
		(= temp6 (self checkTopTricks:))
		(localproc_1 curPlyr)
		(localproc_0)
		(cond
			((>= temp6 (- 8 global434))
				(switch (= temp5 (Max topCl topDi topHt topSp))
					(topCl
						(= temp0 1)
					)
					(topDi
						(= temp0 2)
					)
					(topHt
						(= temp0 3)
					)
					(topSp
						(= temp0 4)
					)
				)
				(self play: temp0 12)
			)
			((and (self selfSuffCheck:) (self aceNotOfSuit: suffSuit))
				(self play: suffSuit 7 12)
			)
			((param1 raisedSuit:)
				(= temp0 (curPlyr firstBidSuit:))
				(cond
					((self gotSequence: curPlyr temp0 14 1)
						(self play: temp0 11)
					)
					((self gotSequence: curPlyr temp0 13 2)
						(self play: temp0 12)
					)
					((self gotSequence: curPlyr temp0 12 2)
						(if (curPlyr hasCard: temp0 14)
							(self play: temp0 11)
						else
							(self play: temp0 12)
						)
					)
					((self gotSequence: curPlyr temp0 11 2)
						(if (curPlyr hasCard: temp0 3851)
							(self play: temp0 11)
						else
							(self play: temp0 11)
						)
					)
					(else
						(self play: temp0 9)
					)
				)
			)
			(
				(or
					(and (> [local6 4] 2) (curPlyr supports: 4) (= temp0 4))
					(and (> [local6 3] 2) (curPlyr supports: 3) (= temp0 3))
					(and (> [local6 1] 2) (curPlyr supports: 1) (= temp0 1))
					(and (> [local6 2] 2) (curPlyr supports: 2) (= temp0 2))
				)
				(cond
					((self gotSequence: curPlyr temp0 14 1)
						(self play: temp0 11)
					)
					((self gotSequence: curPlyr temp0 13 2)
						(self play: temp0 12)
					)
					((self gotSequence: curPlyr temp0 12 2)
						(if (curPlyr hasCard: temp0 14)
							(self play: temp0 11)
						else
							(self play: temp0 12)
						)
					)
					((self gotSequence: curPlyr temp0 11 2)
						(if (curPlyr hasCard: temp0 3851)
							(self play: temp0 11)
						else
							(self play: temp0 12)
						)
					)
					((self gotSequence: curPlyr temp0 10 2)
						(if (curPlyr hasCard: temp0 3850)
							(self play: temp0 11)
						else
							(self play: temp0 12)
						)
					)
					(else
						(self play: temp0 9)
					)
				)
			)
			(
				(or
					(and (> [local6 4] 2) (= temp0 4) (curPlyr calcHonors: 4 1))
					(and (> [local6 3] 2) (= temp0 3) (curPlyr calcHonors: 3 1))
					(and (> [local6 1] 2) (= temp0 1) (curPlyr calcHonors: 1 1))
					(and (> [local6 2] 2) (= temp0 2) (curPlyr calcHonors: 2 1))
				)
				(self play: temp0 12)
			)
			(
				(and
					(= temp0 (curPlyr longSuit:))
					(switch temp0
						(4
							(> (curPlyr spades:) 4)
						)
						(1
							(> (curPlyr clubs:) 4)
						)
						(2
							(> (curPlyr diamonds:) 4)
						)
						(3
							(> (curPlyr hearts:) 4)
						)
					)
					(or
						(and
							(curPlyr hasCard: temp0 14)
							(>= (curPlyr calcHonors: temp0 3) 2)
						)
						(and
							(>= (curPlyr calcHonors: temp0) 3 5)
							(= temp1 temp0)
						)
						(self sideHCP: temp0 3)
					)
				)
				(cond
					((self gotSequence: curPlyr temp0 14 1)
						(self play: temp0 11)
					)
					((self gotSequence: curPlyr temp0 13 2)
						(self play: temp0 12)
					)
					((self gotSequence: curPlyr temp0 12 2)
						(if (curPlyr hasCard: temp0 14)
							(self play: temp0 11)
						else
							(self play: temp0 12)
						)
					)
					((self gotSequence: curPlyr temp0 11 2)
						(if (curPlyr hasCard: temp0 3851)
							(self play: temp0 11)
						else
							(self play: temp0 12)
						)
					)
					((self gotSequence: curPlyr temp0 10 2)
						(if (curPlyr hasCard: temp0 3850)
							(self play: temp0 11)
						else
							(self play: temp0 12)
						)
					)
					(else
						(self play: temp0 9)
					)
				)
			)
			(
				(or
					(and (> [local6 1] 2) (curPlyr clubs:) (= temp0 1))
					(and (> [local6 2] 2) (curPlyr diamonds:) (= temp0 2))
					(and (> [local6 3] 2) (curPlyr hearts:) (= temp0 3))
					(and (> [local6 4] 2) (curPlyr spades:) (= temp0 4))
				)
				(self play: temp0)
			)
			(
				(or
					(and
						(= temp0 1)
						(curPlyr hasCard: 1 10)
						(curPlyr hasCard: temp0 9)
						(or
							(curPlyr hasCard: temp0 3850)
							(curPlyr hasCard: temp0 8)
						)
						(not [local0 temp0])
					)
					(and
						(= temp0 2)
						(curPlyr hasCard: 2 10)
						(curPlyr hasCard: temp0 9)
						(or
							(curPlyr hasCard: temp0 3850)
							(curPlyr hasCard: temp0 8)
						)
						(not [local0 temp0])
					)
					(and
						(= temp0 3)
						(curPlyr hasCard: 3 10)
						(curPlyr hasCard: temp0 9)
						(or
							(curPlyr hasCard: temp0 3850)
							(curPlyr hasCard: temp0 8)
						)
						(not [local0 temp0])
					)
					(and
						(= temp0 4)
						(curPlyr hasCard: 4 10)
						(curPlyr hasCard: temp0 9)
						(or
							(curPlyr hasCard: temp0 3850)
							(curPlyr hasCard: temp0 8)
						)
						(not [local0 temp0])
					)
				)
				(if (curPlyr hasCard: temp0 3850)
					(self play: temp0 11)
				else
					(self play: temp0 12)
				)
			)
			(
				(and
					(== (self checkOpponentsBid:) 3)
					(= temp0 (self checkForSuit:))
				)
				(switch temp0
					(4
						(if (> (curPlyr spades:) 3)
							(self play: temp0 9)
						else
							(self play: temp0)
						)
					)
					(1
						(if (> (curPlyr clubs:) 3)
							(self play: temp0 9)
						else
							(self play: temp0)
						)
					)
					(2
						(if (> (curPlyr diamonds:) 3)
							(self play: temp0 9)
						else
							(self play: temp0)
						)
					)
					(3
						(if (> (curPlyr hearts:) 3)
							(self play: temp0 9)
						else
							(self play: temp0)
						)
					)
				)
			)
			((and (== (self checkOpponentsBid:) 2) (self checkForSuit:))
				(= temp0 0)
				(= temp3 -1)
				(for ((= temp4 0)) (< temp4 4) ((++ temp4))
					(if
						(and
							(not [local0 temp4])
							(= temp2 [local12 temp4])
							(>= (curPlyr calcHCP: temp4) 9)
							(> temp2 temp3)
						)
						(= temp0 temp4)
						(= temp3 temp2)
					)
				)
				(if (not temp0)
					(= temp3 40)
					(for ((= temp4 0)) (< temp4 4) ((++ temp4))
						(if
							(and
								(not [local0 temp4])
								(= temp2 [local12 temp4])
								(< (curPlyr calcHCP: temp4) 9)
								(< temp2 temp3)
							)
							(= temp0 temp4)
							(= temp3 temp2)
						)
					)
				)
				(self play: temp0)
			)
			(else
				(self play: 7 9)
			)
		)
		(self verifiedCard: theCard)
	)

	(method (selfSuffCheck &tmp temp0)
		(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
			(if
				(and
					(>= [local12 temp0] 6)
					(== (self hasCard: temp0 13 12 11) 3)
				)
				(= suffSuit temp0)
				(return 1)
			)
		)
		(return 0)
	)

	(method (aceNotOfSuit param1 &tmp temp0 temp1)
		(if (curPlyr aces:)
			(for ((= temp0 0)) (< temp0 (curPlyr size:)) ((++ temp0))
				(if
					(and
						(== ((= temp1 (curPlyr at: temp0)) rank:) 14)
						(!= (temp1 suit:) param1)
					)
					(return 1)
				)
			)
		)
		(return 0)
	)

	(method (sideHCP param1 param2 &tmp temp0 temp1)
		(for ((= temp0 1)) (< temp0 5) ((++ temp0))
			(if (and (!= temp0 param1) (>= (curPlyr calcHCP: temp0) param2))
				(return temp0)
			)
		)
		(return 0)
	)

	(method (checkOpponentsBid &tmp temp0 temp1)
		(= temp1 0)
		(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
			(if [local0 temp0]
				(++ temp1)
			)
		)
		(return temp1)
	)

	(method (checkForSuit &tmp temp0)
		(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
			(if (and (not [local0 temp0]) [local12 temp0])
				(return temp0)
			)
		)
		(return 0)
	)
)

