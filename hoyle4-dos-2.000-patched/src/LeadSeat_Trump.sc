;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 748)
(include sci.sh)
(use Main)
(use n709)
(use n726)
(use BridgeDefense)
(use Bid)
(use System)

(public
	LeadSeat_Trump 0
)

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

(procedure (localproc_2 param1 &tmp temp0)
	(return
		(switch (= temp0 (param1 countSuit: (gTrick trump:)))
			(1
				(not (LeadSeat_Trump hasCard: (gTrick trump:) 14 13 12))
			)
			(2
				(not (param1 hasCard: (gTrick trump:) 13))
			)
			(3
				(not (param1 hasCard: (gTrick trump:) 12))
			)
		)
	)
)

(procedure (localproc_3 param1 param2 &tmp temp0) ; UNUSED
	(= temp0 (if (> argc 2) [param2 1] else 5))
	(return (- (param1 countSuit: param2) (param1 calcHonors: param2 temp0)))
)

(procedure (localproc_4 param1 param2 param3 &tmp temp0 temp1)
	(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
		(= temp1 (param1 at: temp0))
		(if (and (== (temp1 suit:) param2) (== (temp1 rank:) param3))
			(return temp1)
		)
	)
)

(procedure (localproc_5 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
	(LeadSeat_Trump play: param2 12)
	(= temp1 (LeadSeat_Trump theCard:))
	(LeadSeat_Trump play: param2 11)
	(= temp2 (LeadSeat_Trump theCard:))
	(LeadSeat_Trump theCard: 0)
	(return (and (== temp1 param3) (== temp2 param4)))
)

(class LeadSeat_Trump of BridgeDefense
	(properties)

	(method (think &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13)
		(super think: &rest)
		(localproc_0)
		(localproc_1 curPlyr)
		(= temp0 0)
		(= temp6 (curPlyr RHO:))
		(= temp11 (self checkTopTricks:))
		(= temp7 (gTrick tricksPlayed:))
		(= temp5 (self runningSuit: curPlyr))
		(= temp4 (- (- 14 (- temp7 global433)) (+ global434 6)))
		(= temp12 (curPlyr countSuit: trumps))
		(proc726_0)
		(for ((= temp3 1)) (<= temp3 4) ((++ temp3))
			(= [local12 temp3] (curPlyr countSuit: temp3))
		)
		(switch trumps
			(1
				(= temp8 topCl)
				(= temp9 (Max topDi topHt topSp))
			)
			(2
				(= temp8 topDi)
				(= temp9 (Max topCl topHt topSp))
				(= topDi 0)
			)
			(3
				(= temp8 topHt)
				(= temp9 (Max topDi topCl topSp))
				(= topHt 0)
			)
			(4
				(= temp8 topSp)
				(= temp9 (Max topDi topHt topCl))
				(= topSp 0)
			)
		)
		(switch temp9
			(topCl
				(= temp10 1)
			)
			(2
				topDi
				(= temp10 2)
			)
			(3
				topHt
				(= temp10 3)
			)
			(4
				topSp
				(= temp10 4)
			)
		)
		(switch trumps
			(1
				(= topCl temp8)
			)
			(2
				(= topDi temp8)
			)
			(3
				(= topHt temp8)
			)
			(4
				(= topSp temp8)
			)
		)
		(cond
			(
				(or
					(and
						(not [local0 1])
						(curPlyr hasCard: 1 14)
						(curPlyr hasCard: 1 13)
						(= temp0 1)
					)
					(and
						(not [local0 2])
						(curPlyr hasCard: 2 14)
						(curPlyr hasCard: 2 13)
						(= temp0 2)
					)
					(and
						(not [local0 3])
						(curPlyr hasCard: 3 14)
						(curPlyr hasCard: 3 13)
						(= temp0 3)
					)
					(and
						(not [local0 4])
						(curPlyr hasCard: 4 14)
						(curPlyr hasCard: 4 13)
						(= temp0 4)
					)
				)
				(self play: temp0 11)
			)
			(
				(or
					(and
						(not [local0 1])
						(curPlyr hasCard: 1 13)
						(curPlyr hasCard: 1 12)
						(or (curPlyr hasCard: 1 11) (curPlyr hasCard: 1 10))
						(= temp0 1)
					)
					(and
						(not [local0 2])
						(curPlyr hasCard: 2 13)
						(curPlyr hasCard: 2 12)
						(or (curPlyr hasCard: 2 11) (curPlyr hasCard: 2 10))
						(= temp0 2)
					)
					(and
						(not [local0 3])
						(curPlyr hasCard: 3 13)
						(curPlyr hasCard: 3 12)
						(or (curPlyr hasCard: 3 11) (curPlyr hasCard: 3 10))
						(= temp0 3)
					)
					(and
						(not [local0 4])
						(curPlyr hasCard: 4 13)
						(curPlyr hasCard: 4 12)
						(or (curPlyr hasCard: 4 11) (curPlyr hasCard: 4 10))
						(= temp0 4)
					)
				)
				(self play: temp0 12)
			)
			(
				(and
					(or
						(and (> [local6 1] 2) (== [local12 1] 1) (= temp0 1))
						(and (> [local6 2] 2) (== [local12 2] 1) (= temp0 2))
						(and (> [local6 3] 2) (== [local12 3] 1) (= temp0 3))
						(and (> [local6 4] 2) (== [local12 4] 1) (= temp0 4))
					)
					(localproc_2 curPlyr)
				)
				(self play: temp0)
			)
			(
				(or
					(and
						(> [local6 1] 2)
						(==
							(curPlyr hasCard: 1 3851 1)
							(== [local12 1] 2)
							(= temp0 1)
						)
					)
					(and
						(> [local6 2] 2)
						(==
							(curPlyr hasCard: 2 3851 1)
							(== [local12 2] 2)
							(= temp0 2)
						)
					)
					(and
						(> [local6 3] 2)
						(==
							(curPlyr hasCard: 3 3851 1)
							(== [local12 3] 2)
							(= temp0 3)
						)
					)
					(and
						(> [local6 4] 2)
						(==
							(curPlyr hasCard: 4 3851 1)
							(== [local12 4] 2)
							(= temp0 4)
						)
					)
				)
				(self play: temp0 12)
			)
			(
				(or
					(and
						(> [local6 1] 2)
						(==
							(curPlyr hasCard: 1 3852 1)
							(>= [local12 1] 3)
							(= temp0 1)
						)
					)
					(and
						(> [local6 2] 2)
						(==
							(curPlyr hasCard: 2 3852 1)
							(>= [local12 2] 3)
							(= temp0 2)
						)
					)
					(and
						(> [local6 3] 2)
						(==
							(curPlyr hasCard: 3 3852 1)
							(>= [local12 3] 3)
							(= temp0 3)
						)
					)
					(and
						(> [local6 4] 2)
						(==
							(curPlyr hasCard: 4 3852 1)
							(>= [local12 4] 3)
							(= temp0 4)
						)
					)
				)
				(self play: temp0 9)
			)
			(
				(or
					(and
						(not [local0 1])
						(self hasCard: 1 12)
						(self hasCard: 1 11)
						(self hasCard: 1 10)
						(= temp0 1)
					)
					(and
						(not [local0 2])
						(self hasCard: 2 12)
						(self hasCard: 2 11)
						(self hasCard: 2 10)
						(= temp0 2)
					)
					(and
						(not [local0 3])
						(self hasCard: 3 12)
						(self hasCard: 3 11)
						(self hasCard: 3 10)
						(= temp0 3)
					)
					(and
						(not [local0 4])
						(self hasCard: 4 12)
						(self hasCard: 4 11)
						(self hasCard: 4 10)
						(= temp0 4)
					)
				)
				(= theCard (localproc_4 curPlyr temp0 12))
			)
			((<= temp4 temp8)
				(self play: trumps 12)
			)
			(
				(and
					(<= temp4 temp11)
					(or
						temp8
						(not temp12)
						(> temp12 2)
						(and
							(not (self hasCard: trumps 13))
							(not (self hasCard: trumps 12))
						)
					)
				)
				(if temp12
					(if temp8
						(self play: trumps 12)
					else
						(self play: trumps)
					)
				else
					(self play: temp10 12)
				)
			)
			(
				(and
					(>= skill 1)
					(pard countSuit: trumps)
					(or
						(and
							(!= trumps 1)
							(not (pard countSuit: 1))
							(curPlyr clubs:)
							(= temp0 1)
						)
						(and
							(!= trumps 2)
							(not (pard countSuit: 2))
							(curPlyr diamonds:)
							(= temp0 2)
						)
						(and
							(!= trumps 3)
							(not (pard countSuit: 3))
							(curPlyr hearts:)
							(= temp0 3)
						)
						(and
							(!= trumps 4)
							(not (pard countSuit: 4))
							(curPlyr spades:)
							(= temp0 4)
						)
					)
				)
				(self play: temp0)
			)
			(
				(and
					(or
						(and
							(== (curPlyr hearts:) 1)
							(not (curPlyr hasCard: 3 13))
							(not (curPlyr hasCard: 3 12))
							(= temp0 3)
						)
						(and
							(== (curPlyr clubs:) 1)
							(not (curPlyr hasCard: 1 13))
							(not (curPlyr hasCard: 1 12))
							(= temp0 1)
						)
						(and
							(== (curPlyr diamonds:) 1)
							(not (curPlyr hasCard: 2 13))
							(not (curPlyr hasCard: 2 12))
							(= temp0 2)
						)
						(and
							(== (curPlyr spades:) 1)
							(not (curPlyr hasCard: 4 13))
							(not (curPlyr hasCard: 4 12))
							(= temp0 4)
						)
					)
					(>= temp12 2)
				)
				(self play: temp0)
			)
			(
				(or
					(and (> [local6 1] 2) (== [local12 1] 2) (= temp0 1))
					(and (> [local6 2] 2) (== [local12 2] 2) (= temp0 2))
					(and (> [local6 3] 2) (== [local12 3] 2) (= temp0 3))
					(and (> [local6 4] 2) (== [local12 4] 2) (= temp0 4))
				)
				(self play: temp0 12)
			)
			(
				(or
					(and (> [local6 1] 2) (> [local12 1] 2) (= temp0 1))
					(and (> [local6 2] 2) (> [local12 2] 2) (= temp0 2))
					(and (> [local6 3] 2) (> [local12 3] 2) (= temp0 3))
					(and (> [local6 4] 2) (> [local12 4] 2) (= temp0 4))
				)
				(if (or (curPlyr hasCard: temp0 11) (curPlyr hasCard: temp0 10))
					(self play: temp0 12)
				else
					(self play: temp0 9)
				)
			)
			((and (>= temp11 temp4) temp12)
				(if (or (!= (curPlyr hasCard: trumps 3852) 1) (> temp12 2))
					(if (and (curPlyr hasCard: trumps 3852) (> temp12 2))
						(self play: trumps)
					else
						(self play: trumps 12)
					)
				else
					(self play: temp10 12)
				)
			)
			((or (>= 0 temp12 1) (>= temp12 4))
				(if
					(or
						(curPlyr raisedSuit:)
						(and
							(> [local6 1] 1)
							(>= (curPlyr clubs:) 3)
							(= temp0 1)
						)
						(and
							(> [local6 2] 1)
							(>= (curPlyr diamonds:) 3)
							(= temp0 2)
						)
						(and
							(> [local6 3] 1)
							(>= (curPlyr hearts:) 3)
							(= temp0 3)
						)
						(and
							(> [local6 4] 1)
							(>= (curPlyr spades:) 3)
							(= temp0 4)
						)
					)
					(if
						(or
							(= temp13 (self gotSequence: curPlyr temp0 10 2))
							(= temp13 (self gotSequence: curPlyr temp0 0 2))
						)
						(if (== temp13 2)
							(self play: temp0 11)
						else
							(self play: temp0 12)
						)
					else
						(self play: temp0 9)
					)
				else
					(= temp0 (curPlyr longSuit:))
					(if
						(and
							(or
								(= temp13
									(self gotSequence: curPlyr temp0 10 2)
								)
								(= temp13 (self gotSequence: curPlyr temp0 0 2))
							)
							(!= temp0 trumps)
						)
						(if (== temp13 2)
							(self play: temp0 11)
						else
							(self play: temp0 12)
						)
					else
						(self play: temp0 9)
					)
				)
			)
			(
				(or
					(and (== [local6 1] 2) [local12 1] (= temp0 1))
					(and (== [local6 2] 2) [local12 2] (= temp0 2))
					(and (== [local6 3] 2) [local12 3] (= temp0 3))
					(and (== [local6 4] 2) [local12 4] (= temp0 4))
				)
				(if
					(or
						(= temp13 (self gotSequence: curPlyr temp0 10 2))
						(= temp13 (self gotSequence: curPlyr temp0 0 2))
					)
					(if (== temp13 2)
						(self play: temp0 11)
					else
						(self play: temp0 12)
					)
				else
					(self play: temp0)
				)
			)
			(
				(or
					(and
						(not [local0 1])
						(== (curPlyr clubs:) 2)
						(curPlyr hasCard: 1 14)
						(curPlyr hasCard: 1 13)
						(= temp0 1)
					)
					(and
						(not [local0 2])
						(== (curPlyr diamonds:) 2)
						(curPlyr hasCard: 2 14)
						(curPlyr hasCard: 2 13)
						(= temp0 2)
					)
					(and
						(not [local0 3])
						(== (curPlyr hearts:) 2)
						(curPlyr hasCard: 3 14)
						(curPlyr hasCard: 3 13)
						(= temp0 3)
					)
					(and
						(not [local0 4])
						(== (curPlyr spades:) 2)
						(curPlyr hasCard: 4 14)
						(curPlyr hasCard: 4 13)
						(= temp0 4)
					)
				)
				(self play: temp0 12)
			)
			(
				(or
					(and
						(not [local0 1])
						(== (curPlyr countSuit: 1) 2)
						(curPlyr hasCard: 1 14)
						(not (curPlyr hasCard: 1 12))
						(not (curPlyr hasCard: 1 11))
						(= temp0 1)
					)
					(and
						(not [local0 2])
						(== (curPlyr countSuit: 2) 2)
						(curPlyr hasCard: 2 14)
						(not (curPlyr hasCard: 2 12))
						(not (curPlyr hasCard: 2 11))
						(= temp0 2)
					)
					(and
						(not [local0 3])
						(== (curPlyr countSuit: 3) 2)
						(curPlyr hasCard: 3 14)
						(not (curPlyr hasCard: 3 12))
						(not (curPlyr hasCard: 3 11))
						(= temp0 3)
					)
					(and
						(not [local0 4])
						(== (curPlyr countSuit: 4) 2)
						(curPlyr hasCard: 4 14)
						(not (curPlyr hasCard: 4 12))
						(not (curPlyr hasCard: 4 11))
						(= temp0 4)
					)
				)
				(self play: temp0 12)
			)
			(
				(or
					(and
						(not [local0 1])
						(== [global162 1] 3)
						(== [global162 2] 3)
						(= temp0 1)
					)
					(and
						(not [local0 2])
						(== [global149 1] 3)
						(== [global149 2] 3)
						(= temp0 2)
					)
					(and
						(not [local0 3])
						(== [global136 1] 3)
						(== [global136 2] 3)
						(= temp0 3)
					)
					(and
						(not [local0 4])
						(== [global123 1] 3)
						(== [global123 2] 3)
						(= temp0 4)
					)
				)
				(self play: temp0 12)
			)
			(
				(or
					(and
						(not [local0 1])
						(== [global162 3] 3)
						(== [global162 2] 3)
						(!= [global162 0] 3)
						(= temp0 1)
					)
					(and
						(not [local0 2])
						(== [global149 3] 3)
						(== [global149 2] 3)
						(!= [global149 0] 3)
						(= temp0 2)
					)
					(and
						(not [local0 3])
						(== [global136 3] 3)
						(== [global136 2] 3)
						(!= [global136 0] 3)
						(= temp0 3)
					)
					(and
						(not [local0 4])
						(== [global123 3] 3)
						(== [global123 2] 3)
						(!= [global123 0] 3)
						(= temp0 4)
					)
				)
				(self play: temp0 12)
			)
			(
				(and
					(pard countSuit: trumps)
					(or
						(and
							(!= trumps 1)
							(not (pard countSuit: 1))
							(curPlyr clubs:)
							(= temp0 1)
						)
						(and
							(!= trumps 2)
							(not (pard countSuit: 2))
							(curPlyr diamonds:)
							(= temp0 2)
						)
						(and
							(!= trumps 3)
							(not (pard countSuit: 3))
							(curPlyr hearts:)
							(= temp0 3)
						)
						(and
							(!= trumps 4)
							(not (pard countSuit: 4))
							(curPlyr spades:)
							(= temp0 4)
						)
					)
				)
				(self play: temp0)
			)
			(
				(or
					(and
						(== [local0 1] 2)
						(!= [global162 1] 3)
						(!= [global162 2] 3)
						(!= [global162 0] 3)
						(curPlyr countSuit: 1)
						(= temp0 1)
					)
					(and
						(== [local0 2] 2)
						(!= [global149 1] 3)
						(!= [global149 2] 3)
						(!= [global149 0] 3)
						(curPlyr countSuit: 2)
						(= temp0 2)
					)
					(and
						(== [local0 3] 2)
						(!= [global136 1] 3)
						(!= [global136 2] 3)
						(!= [global136 0] 3)
						(curPlyr countSuit: 3)
						(= temp0 3)
					)
					(and
						(== [local0 4] 2)
						(!= [global123 1] 3)
						(!= [global123 2] 3)
						(!= [global123 0] 3)
						(curPlyr countSuit: 4)
						(= temp0 4)
					)
				)
				(if (== (curPlyr countSuit: temp0) 2)
					(self play: temp0 12)
				else
					(self play: temp0)
				)
			)
			(
				(or
					(and
						(== [local0 1] 2)
						(!= [global162 0] 3)
						(!= [global162 1] [global162 2])
						(or (== [global162 1] 3) (== [global162 2] 3))
						(= temp0 1)
					)
					(and
						(== [local0 2] 2)
						(!= [global149 0] 3)
						(!= [global149 1] [global149 2])
						(or (== [global149 1] 3) (== [global149 2] 3))
						(= temp0 2)
					)
					(and
						(== [local0 3] 2)
						(!= [global136 0] 3)
						(!= [global136 3] [global136 2])
						(or (== [global136 3] 3) (== [global136 2] 3))
						(= temp0 3)
					)
					(and
						(== [local0 4] 2)
						(!= [global123 0] 3)
						(!= [global123 3] [global123 2])
						(or (== [global123 3] 3) (== [global123 2] 3))
						(= temp0 4)
					)
				)
				(self play: temp0 11)
			)
			(
				(or
					(and
						(!= trumps 1)
						(== (curPlyr clubs:) 1)
						(not (curPlyr hasCard: 1 13))
						(not (curPlyr hasCard: 1 12))
						(= temp0 1)
					)
					(and
						(!= trumps 2)
						(== (curPlyr diamonds:) 1)
						(not (curPlyr hasCard: 2 13))
						(not (curPlyr hasCard: 2 12))
						(= temp0 2)
					)
					(and
						(!= trumps 3)
						(== (curPlyr hearts:) 1)
						(not (curPlyr hasCard: 3 13))
						(not (curPlyr hasCard: 3 12))
						(= temp0 3)
					)
					(and
						(!= trumps 4)
						(== (curPlyr spades:) 1)
						(not (curPlyr hasCard: 4 13))
						(not (curPlyr hasCard: 4 12))
						(= temp0 4)
					)
				)
				(self play: temp0)
			)
			(
				(or
					(and
						(or
							(= temp13 (self gotSequence: curPlyr 1 10 2))
							(= temp13 (self gotSequence: curPlyr 1 0 2))
						)
						(= temp0 1)
					)
					(and
						(or
							(= temp13 (self gotSequence: curPlyr 2 10 2))
							(= temp13 (self gotSequence: curPlyr 2 0 2))
						)
						(= temp0 2)
					)
					(and
						(or
							(= temp13 (self gotSequence: curPlyr 3 10 2))
							(= temp13 (self gotSequence: curPlyr 3 0 2))
						)
						(= temp0 3)
					)
					(and
						(or
							(= temp13 (self gotSequence: curPlyr 4 10 2))
							(= temp13 (self gotSequence: curPlyr 4 0 2))
						)
						(= temp0 4)
					)
				)
				(if (== temp13 2)
					(self play: temp0 11)
				else
					(self play: temp0 12)
				)
			)
			(
				(or
					(and
						(== [local0 1] 2)
						(!= [global162 0] 3)
						(!= [global162 1] 3)
						(!= [global162 2] 3)
						(!= [global162 3] 3)
						(== (curPlyr clubs:) 2)
						(= temp0 1)
					)
					(and
						(== [local0 2] 2)
						(!= [global149 0] 3)
						(!= [global149 1] 3)
						(!= [global149 2] 3)
						(!= [global149 3] 3)
						(== (curPlyr diamonds:) 2)
						(= temp0 2)
					)
					(and
						(== [local0 3] 2)
						(!= [global136 0] 3)
						(!= [global136 1] 3)
						(!= [global136 2] 3)
						(!= [global136 3] 3)
						(== (curPlyr hearts:) 2)
						(= temp0 3)
					)
					(and
						(== [local0 4] 2)
						(!= [global123 0] 3)
						(!= [global123 1] 3)
						(!= [global123 2] 3)
						(!= [global123 3] 3)
						(== (curPlyr spades:) 2)
						(= temp0 4)
					)
				)
				(self play: temp0 12)
			)
			(
				(or
					(and
						(> (curPlyr clubs:) 2)
						(== [local0 1] 0)
						(== [global162 4] 3)
						(or (== [global162 1] 3) (== [global162 2] 3))
						(!= [global162 0] 3)
						(= temp0 1)
					)
					(and
						(> (curPlyr diamonds:) 2)
						(== [local0 2] 0)
						(== [global149 4] 3)
						(or (== [global149 1] 3) (== [global149 2] 3))
						(!= [global149 0] 3)
						(= temp0 2)
					)
					(and
						(> (curPlyr hearts:) 2)
						(== [local0 3] 0)
						(== [global136 4] 3)
						(or (== [global136 1] 3) (== [global136 2] 3))
						(!= [global136 0] 3)
						(= temp0 3)
					)
					(and
						(> (curPlyr spades:) 2)
						(== [local0 4] 0)
						(== [global123 4] 3)
						(or (== [global123 1] 3) (== [global123 2] 3))
						(!= [global123 0] 3)
						(= temp0 4)
					)
				)
				(self play: temp0)
			)
			(
				(or
					(and
						(> (curPlyr clubs:) 3)
						(== [local0 1] 0)
						(!= [global162 0] 3)
						(!= [global162 1] 3)
						(!= [global162 2] 3)
						(!= [global162 3] 3)
						(= temp0 1)
					)
					(and
						(> (curPlyr diamonds:) 3)
						(== [local0 2] 0)
						(!= [global149 0] 3)
						(!= [global149 1] 3)
						(!= [global149 2] 3)
						(!= [global149 3] 3)
						(= temp0 2)
					)
					(and
						(> (curPlyr hearts:) 3)
						(== [local0 3] 0)
						(!= [global136 0] 3)
						(!= [global136 1] 3)
						(!= [global136 2] 3)
						(!= [global136 3] 3)
						(= temp0 3)
					)
					(and
						(> (curPlyr spades:) 3)
						(== [local0 4] 0)
						(!= [global123 0] 3)
						(!= [global123 1] 3)
						(!= [global123 2] 3)
						(!= [global123 3] 3)
						(= temp0 4)
					)
				)
				(self play: temp0)
			)
			(
				(or
					(and
						(> (curPlyr clubs:) 3)
						(== [local0 1] 0)
						(!= [global162 0] 3)
						(or (== [global162 1] 3) (== [global162 2] 3))
						(= temp0 1)
					)
					(and
						(> (curPlyr diamonds:) 3)
						(== [local0 2] 0)
						(!= [global149 0] 3)
						(or (== [global149 1] 3) (== [global149 2] 3))
						(= temp0 2)
					)
					(and
						(> (curPlyr hearts:) 2)
						(== [local0 3] 0)
						(!= [global136 0] 3)
						(or (== [global136 1] 3) (== [global136 2] 3))
						(= temp0 3)
					)
					(and
						(> (curPlyr spades:) 2)
						(== [local0 4] 0)
						(!= [global123 0] 3)
						(or (== [global123 1] 3) (== [global123 2] 3))
						(= temp0 4)
					)
				)
				(self play: temp0)
			)
			(
				(and
					temp12
					(or
						(not (curPlyr calcHonors: trumps))
						(and
							(== (curPlyr calcHonors: trumps) 1)
							(curPlyr hasCard: trumps 10)
						)
					)
				)
				(self play: trumps)
			)
			(
				(or
					(and
						(> (curPlyr clubs:) 2)
						(!= [global162 0] 3)
						(!= [global162 1] 3)
						(!= [global162 2] 3)
						(!= [global162 3] 3)
						(= temp0 1)
					)
					(and
						(> (curPlyr diamonds:) 2)
						(!= [global149 0] 3)
						(!= [global149 1] 3)
						(!= [global149 2] 3)
						(!= [global149 3] 3)
						(= temp0 2)
					)
					(and
						(> (curPlyr hearts:) 2)
						(!= [global136 0] 3)
						(!= [global136 1] 3)
						(!= [global136 2] 3)
						(!= [global136 3] 3)
						(= temp0 3)
					)
					(and
						(> (curPlyr spades:) 2)
						(!= [global123 0] 3)
						(!= [global123 1] 3)
						(!= [global123 2] 3)
						(!= [global123 3] 3)
						(= temp0 4)
					)
				)
				(self play: temp0 9)
			)
			(
				(or
					(and
						(== (curPlyr clubs:) 2)
						(== [local0 1] 2)
						(!= [global162 0] 3)
						(!= [global162 1] 3)
						(!= [global162 2] 3)
						(= temp0 1)
					)
					(and
						(== (curPlyr diamonds:) 2)
						(== [local0 2] 2)
						(!= [global149 0] 3)
						(!= [global149 1] 3)
						(!= [global149 2] 3)
						(= temp0 2)
					)
					(and
						(== (curPlyr hearts:) 2)
						(== [local0 3] 2)
						(!= [global136 0] 3)
						(!= [global136 1] 3)
						(!= [global136 2] 3)
						(= temp0 3)
					)
					(and
						(> (curPlyr spades:) 2)
						(== [local0 4] 0)
						(!= [global123 0] 3)
						(!= [global123 1] 3)
						(!= [global123 2] 3)
						(= temp0 4)
					)
				)
				(self play: temp0 12)
			)
			(
				(or
					(and
						(== (curPlyr clubs:) 2)
						(!= [global162 0] 3)
						(!= [global162 1] 3)
						(!= [global162 2] 3)
						(= temp0 1)
					)
					(and
						(== (curPlyr diamonds:) 2)
						(!= [global149 0] 3)
						(!= [global149 1] 3)
						(!= [global149 2] 3)
						(= temp0 2)
					)
					(and
						(== (curPlyr hearts:) 2)
						(!= [global136 0] 3)
						(!= [global136 1] 3)
						(!= [global136 2] 3)
						(= temp0 3)
					)
					(and
						(> (curPlyr spades:) 2)
						(!= [global123 0] 3)
						(!= [global123 1] 3)
						(!= [global123 2] 3)
						(= temp0 4)
					)
				)
				(self play: temp0 12)
			)
			(
				(or
					(and
						(curPlyr hasCard: 1 14)
						(not (curPlyr hasCard: 1 12))
						(not (curPlyr hasCard: 1 11))
						(= temp0 1)
					)
					(and
						(curPlyr hasCard: 2 14)
						(not (curPlyr hasCard: 2 12))
						(not (curPlyr hasCard: 2 11))
						(= temp0 2)
					)
					(and
						(curPlyr hasCard: 3 14)
						(not (curPlyr hasCard: 3 12))
						(not (curPlyr hasCard: 3 11))
						(= temp0 3)
					)
					(and
						(curPlyr hasCard: 4 14)
						(not (curPlyr hasCard: 4 12))
						(not (curPlyr hasCard: 4 11))
						(= temp0 4)
					)
				)
				(= theCard (localproc_4 curPlyr temp0 14))
			)
			(
				(or
					(and (== [global162 1] 3) (== [global162 2] 3) (= temp0 1))
					(and (== [global149 1] 3) (== [global149 2] 3) (= temp0 2))
					(and (== [global136 1] 3) (== [global136 2] 3) (= temp0 3))
					(and (== [global123 1] 3) (== [global123 2] 3) (= temp0 4))
				)
				(self play: temp0 12)
			)
			(
				(or
					(and
						(== [global162 3] 3)
						(== [global162 2] 3)
						(!= [global162 0] 3)
						(= temp0 1)
					)
					(and
						(== [global149 3] 3)
						(== [global149 2] 3)
						(!= [global149 0] 3)
						(= temp0 2)
					)
					(and
						(== [global136 3] 3)
						(== [global136 2] 3)
						(!= [global136 0] 3)
						(= temp0 3)
					)
					(and
						(== [global123 3] 3)
						(== [global123 2] 3)
						(!= [global123 0] 3)
						(= temp0 4)
					)
				)
				(self play: temp0 12)
			)
			(
				(or
					(and
						(>= (curPlyr hearts:) 4)
						(not (localproc_5 curPlyr 3 14 11))
						(not (localproc_5 curPlyr 3 13 11))
						(not (localproc_5 curPlyr 3 14 12))
					)
					(and
						(>= (curPlyr diamonds:) 4)
						(not (localproc_5 curPlyr 2 14 11))
						(not (localproc_5 curPlyr 2 13 11))
						(not (localproc_5 curPlyr 2 14 12))
					)
					(and
						(>= (curPlyr clubs:) 4)
						(not (localproc_5 curPlyr 1 14 11))
						(not (localproc_5 curPlyr 1 13 11))
						(not (localproc_5 curPlyr 1 14 12))
					)
					(and
						(>= (curPlyr spades:) 4)
						(not (localproc_5 curPlyr 4 14 11))
						(not (localproc_5 curPlyr 4 13 11))
						(not (localproc_5 curPlyr 4 14 12))
					)
				)
				(self play: temp0 9)
			)
			(
				(or
					(and
						(not (proc709_2 1 (curPlyr RHO:)))
						(>= (curPlyr countSuit: 1) 4)
						(or
							(localproc_5 curPlyr 1 14 12)
							(localproc_5 curPlyr 1 14 11)
						)
						(= temp0 1)
					)
					(and
						(not (proc709_2 2 (curPlyr RHO:)))
						(>= (curPlyr countSuit: 2) 4)
						(or
							(localproc_5 curPlyr 2 14 12)
							(localproc_5 curPlyr 2 14 11)
						)
						(= temp0 2)
					)
					(and
						(not (proc709_2 3 (curPlyr RHO:)))
						(>= (curPlyr countSuit: 3) 4)
						(or
							(localproc_5 curPlyr 3 14 12)
							(localproc_5 curPlyr 3 14 11)
						)
						(= temp0 3)
					)
					(and
						(not (proc709_2 4 (curPlyr RHO:)))
						(>= (curPlyr countSuit: 4) 4)
						(or
							(localproc_5 curPlyr 4 14 12)
							(localproc_5 curPlyr 4 14 11)
						)
						(= temp0 4)
					)
				)
				(self play: temp0 12)
			)
			(else
				(for ((= temp3 1)) (<= temp3 4) ((++ temp3))
					(if
						(and
							(>= (curPlyr countSuit: temp3) 4)
							(< (= temp1 (curPlyr calcHCP: temp3)) temp2) ; UNINIT
						)
						(= temp2 temp1)
						(= temp0 temp3)
					)
				)
				(self play: temp0 9)
			)
		)
		(self verifiedCard: theCard)
	)
)

