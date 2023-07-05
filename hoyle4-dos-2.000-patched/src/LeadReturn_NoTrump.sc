;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 752)
(include sci.sh)
(use Main)
(use BridgeDefense)
(use Bid)
(use System)

(local
	[local0 6]
	[local6 5]
	[local11 13]
)

(procedure (localproc_0 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(= temp1 ((param1 partner:) location:))
	(= temp2 (param1 location:))
	(for ((= temp0 0)) (< temp0 6) ((++ temp0))
		(= [local0 temp0] 0)
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
		(= [local0 temp6] 3)
	else
		(= [local0 temp6] 1)
	)
	0
	(while (< temp0 (BidBox size:))
		(= temp5 (BidBox at: temp0))
		(= temp4 (temp5 location:))
		(cond
			((and (== [local0 (= temp6 (temp5 suit:))] 1) (== temp4 temp1))
				(= [local0 temp6] 2)
			)
			((and (== [local0 temp6] 3) (== temp4 temp2))
				(= [local0 temp6] 4)
			)
			((and (not [local0 temp6]) (not (temp5 artificial:)) (<= 1 temp6 4))
				(if (== temp4 temp2)
					(= [local0 temp6] 1)
				else
					(= [local0 temp6] 3)
				)
			)
		)
		(+= temp0 2)
	)
)

(class LeadReturn_NoTrump of BridgeDefense
	(properties
		suffSuit 0
	)

	(method (think param1 &tmp temp0 temp1 temp2 temp3 [temp4 3] temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 [temp21 5] temp26)
		(super think: &rest)
		(= temp20 (curPlyr RHO:))
		(= temp16 (self checkTopTricks: param1))
		(= temp10 (self checkLongTricks: 4))
		(= temp11 (self checkLongTricks: 1))
		(= temp12 (self checkLongTricks: 2))
		(= temp13 (self checkLongTricks: 3))
		(= temp15 (+ temp10 temp11 temp12 temp13))
		(= temp17 (gTrick tricksPlayed:))
		(= temp18 (self runningSuit: param1))
		(= temp19 (- (- 14 (- temp17 global433)) (+ global434 6)))
		(localproc_0 curPlyr)
		(for ((= temp14 1)) (<= temp14 4) ((++ temp14))
			(= [temp21 temp14] (curPlyr countSuit: temp14))
		)
		(cond
			((== (param1 size:) 1)
				(= theCard (param1 at: 0))
			)
			((>= temp16 temp19)
				(switch (= temp7 (Max topCl topDi topHt topSp))
					(topCl
						(self play: 1 12)
					)
					(topDi
						(self play: 2 12)
					)
					(topHt
						(self play: 3 12)
					)
					(topSp
						(self play: 4 12)
					)
				)
			)
			((and temp15 (>= temp15 temp19))
				(switch (= temp7 (Max temp11 temp12 temp13 temp10))
					(temp11
						(if topCl
							(self play: 1 12)
						)
					)
					(temp12
						(if topDi
							(self play: 2 12)
						)
					)
					(temp13
						(if topHt
							(self play: 3 12)
						)
					)
					(temp10
						(if topSp
							(self play: 4 12)
						)
					)
				)
			)
			(
				(or
					(and
						(= temp0 1)
						(= temp8 (param1 clubs:))
						(>=
							topCl
							(Max (global429 clubs:) (global431 clubs:))
						)
					)
					(and
						(= temp0 2)
						(= temp8 (param1 diamonds:))
						(>=
							topDi
							(Max
								(global429 diamonds:)
								(global431 diamonds:)
							)
						)
					)
					(and
						(= temp0 3)
						(= temp8 (param1 hearts:))
						(>=
							topHt
							(Max (global429 hearts:) (global431 hearts:))
						)
					)
					(and
						(= temp0 4)
						(= temp8 (param1 spades:))
						(>=
							topSp
							(Max (global429 spades:) (global431 spades:))
						)
					)
				)
				(self play: temp0 12)
			)
			(temp18
				(self play: temp18)
			)
			((self selfSuffCheck: curPlyr)
				(self play: (self suffSuit:) 12)
			)
			(
				(or
					(and (> [local0 1] 1) [temp21 1] (= temp0 1))
					(and (> [local0 2] 1) [temp21 2] (= temp0 2))
					(and (> [local0 3] 1) [temp21 3] (= temp0 3))
					(and (> [local0 4] 1) [temp21 4] (= temp0 4))
				)
				(if
					(or
						(< [temp21 temp0] 3)
						(and
							(param1 calcHonors: temp0 2)
							(> (pard countSuit: temp0) [temp21 temp0])
						)
					)
					(self play: temp0 12)
				else
					(self play: temp0)
				)
			)
			(
				(and
					(= temp0 (self partnerLead:))
					[temp21 temp0]
					(< [local0 temp0] 3)
				)
				(if (>= (param1 calcHonors: temp0 3) 2)
					(self play: temp0 12)
				else
					(self play: temp0)
				)
			)
			(
				(and
					(= temp0 (self partnerLead:))
					[temp21 temp0]
					(switch temp0
						(4
							(param1 spades:)
						)
						(1
							(param1 clubs:)
						)
						(2
							(param1 diamonds:)
						)
						(3
							(param1 hearts:)
						)
					)
				)
				(self play: temp0 12)
			)
			(
				(and
					(or
						(and (>= (global431 calcHonors: 1 4) 3) (= temp0 1))
						(and (>= (global431 calcHonors: 2 4) 3) (= temp0 2))
						(and (>= (global431 calcHonors: 3 4) 3) (= temp0 3))
						(and (>= (global431 calcHonors: 4 4) 3) (= temp0 4))
					)
					(= temp14 (self checkSideHCP: global431 temp0 2))
					(curPlyr countSuit: temp14)
				)
				(self play: temp14 12)
			)
			(
				(and
					(= temp3 (self makeContractMinusAce: global431))
					(or
						(and
							(!=
								(= temp0
									(self
										checkSideEntry: global431 temp3 2 14 13
									)
								)
								-1
							)
							(== (curPlyr calcHonors: temp0 2) 1)
							(>= (curPlyr countSuit: temp0) 2)
						)
						(and
							(!=
								(= temp0
									(self
										checkSideEntry: global431 temp3 3 13 12
									)
								)
								-1
							)
							(== (curPlyr calcHonors: temp0 3) 2)
							(>= (curPlyr countSuit: temp0) 3)
						)
					)
				)
				(self play: temp0 12)
			)
			(
				(and
					(== temp20 global431)
					(>= 1 (global431 calcHCP: 4) 0)
					(>= 4 (global431 spades:) 2)
					(not (curPlyr hasCard: 4 13))
					(> (self getNumSpots: curPlyr 4) 1)
					(not (curPlyr hasCard: 4 12))
					(> (self getNumSpots: curPlyr 4) 2)
				)
				(self play: 4)
			)
			(
				(and
					(== temp20 global431)
					(>= 1 (global431 calcHCP: 1) 0)
					(>= 4 (global431 clubs:) 2)
					(not (curPlyr hasCard: 1 13))
					(> (self getNumSpots: curPlyr 1) 1)
					(not (curPlyr hasCard: 1 12))
					(> (self getNumSpots: curPlyr 1) 2)
				)
				(self play: 1)
			)
			(
				(and
					(== temp20 global431)
					(>= 1 (global431 calcHCP: 2) 0)
					(>= 4 (global431 diamonds:) 2)
					(not (curPlyr hasCard: 2 13))
					(> (self getNumSpots: curPlyr 2) 1)
					(not (curPlyr hasCard: 2 12))
					(> (self getNumSpots: curPlyr 2) 2)
				)
				(self play: 2)
			)
			(
				(and
					(== temp20 global431)
					(>= 1 (global431 calcHCP: 3) 0)
					(>= 4 (global431 hearts:) 2)
					(not (curPlyr hasCard: 3 13))
					(> (self getNumSpots: curPlyr 3) 1)
					(not (curPlyr hasCard: 3 12))
					(> (self getNumSpots: curPlyr 3) 2)
				)
				(self play: 3)
			)
			(
				(and
					(== LHO global431)
					(>= (global431 calcHCP: 4) 4)
					(>= 4 (global431 countSuit: 4) 2)
					(not (curPlyr hasCard: 4 13))
					(>= (self getNumSpots: curPlyr 4) 1)
					(not (curPlyr hasCard: 4 12))
					(>= (self getNumSpots: curPlyr 4) 2)
				)
				(self play: 4)
			)
			(
				(and
					(== LHO global431)
					(>= (global431 calcHCP: 3) 4)
					(>= 4 (global431 countSuit: 3) 2)
					(not (curPlyr hasCard: 3 13))
					(>= (self getNumSpots: curPlyr 3) 1)
					(not (curPlyr hasCard: 3 12))
					(>= (self getNumSpots: curPlyr 3) 2)
				)
				(self play: 3)
			)
			(
				(and
					(== LHO global431)
					(>= (global431 calcHCP: 1) 4)
					(>= 4 (global431 countSuit: 1) 2)
					(not (curPlyr hasCard: 1 13))
					(>= (self getNumSpots: curPlyr 1) 1)
					(not (curPlyr hasCard: 1 12))
					(>= (self getNumSpots: curPlyr 1) 2)
				)
				(self play: 1)
			)
			(
				(and
					(== LHO global431)
					(>= (global431 calcHCP: 2) 4)
					(>= 4 (global431 countSuit: 2) 2)
					(not (curPlyr hasCard: 2 13))
					(>= (self getNumSpots: curPlyr 2) 1)
					(not (curPlyr hasCard: 2 12))
					(>= (self getNumSpots: curPlyr 2) 2)
				)
				(self play: 2)
			)
			(
				(and
					(or
						(and
							(>= (global431 calcHonors: 1 4) 2)
							(>= (global431 countSuit: 1) 3)
							(= temp0 1)
						)
						(and
							(>= (global431 calcHonors: 2 4) 2)
							(>= (global431 countSuit: 2) 3)
							(= temp0 2)
						)
						(and
							(>= (global431 calcHonors: 3 4) 2)
							(>= (global431 countSuit: 2) 3)
							(= temp0 3)
						)
						(and
							(>= (global431 calcHonors: 4 4) 2)
							(>= (global431 countSuit: 2) 3)
							(= temp0 4)
						)
					)
					(or
						(>= (= temp2 (curPlyr calcHonors: 6 1)) 2)
						(>= (Abs (- temp2 (curPlyr calcHonors: 6 2))) 2)
					)
				)
				(switch temp0
					(4
						(cond
							((global431 hasCard: 1 3853)
								(self play: 1)
							)
							((global431 hasCard: 2 3853)
								(self play: 2)
							)
							(else
								(self play: 3)
							)
						)
					)
					(1
						(cond
							((global431 hasCard: 4 3853)
								(self play: 4)
							)
							((global431 hasCard: 2 3853)
								(self play: 2)
							)
							(else
								(self play: 3)
							)
						)
					)
					(2
						(cond
							((global431 hasCard: 1 3853)
								(self play: 1)
							)
							((global431 hasCard: 4 3853)
								(self play: 4)
							)
							(else
								(self play: 3)
							)
						)
					)
					(3
						(cond
							((global431 hasCard: 1 3853)
								(self play: 1)
							)
							((global431 hasCard: 2 3853)
								(self play: 2)
							)
							(else
								(self play: 4)
							)
						)
					)
				)
			)
			(
				(or
					(and
						(== (global431 calcHonors: 1) (global431 countSuit: 1))
						(= temp1 (self getHighest: global431 1))
						(not (curPlyr hasCard: (= temp0 1) (| temp1 $0f00)))
					)
					(and
						(== (global431 calcHonors: 2) (global431 countSuit: 2))
						(= temp1 (self getHighest: global431 2))
						(not (curPlyr hasCard: (= temp0 2) (| temp1 $0f00)))
					)
					(and
						(== (global431 calcHonors: 3) (global431 countSuit: 3))
						(= temp1 (self getHighest: global431 3))
						(not (curPlyr hasCard: (= temp0 3) (| temp1 $0f00)))
					)
					(and
						(== (global431 calcHonors: 4) (global431 countSuit: 4))
						(= temp1 (self getHighest: global431 4))
						(not (curPlyr hasCard: (= temp0 4) (| temp1 $0f00)))
					)
				)
				(self play: temp0 12)
			)
			(
				(or
					(and
						(or
							(= temp26 (self gotSequence: curPlyr 1 10 2))
							(= temp26 (self gotSequence: curPlyr 1 0 2))
						)
						(= temp0 1)
					)
					(and
						(or
							(= temp26 (self gotSequence: curPlyr 3 10 2))
							(= temp26 (self gotSequence: curPlyr 3 0 2))
						)
						(= temp0 3)
					)
					(and
						(or
							(= temp26 (self gotSequence: curPlyr 2 10 2))
							(= temp26 (self gotSequence: curPlyr 2 0 2))
						)
						(= temp0 2)
					)
					(and
						(or
							(= temp26 (self gotSequence: curPlyr 4 10 2))
							(= temp26 (self gotSequence: curPlyr 4 0 2))
						)
						(= temp0 4)
					)
				)
				(if (== temp26 2)
					(self play: temp0 11)
				else
					(self play: temp0 12)
				)
			)
			(
				(and
					(== temp20 global431)
					(or
						(= temp0 (self checkForTwoHigher: global431 1))
						(= temp0 (self checkForTwoHigher: global431 2))
						(= temp0 (self checkForTwoHigher: global431 3))
						(= temp0 (self checkForTwoHigher: global431 4))
					)
				)
				(self play: temp0 11)
			)
			(
				(and
					(param1 clubs:)
					(or
						(> (global429 topCl:) 3)
						(and
							(>= (global429 topCl:) (param1 clubs:))
							(>= (global429 topCl:) ((param1 partner:) clubs:))
						)
					)
				)
				(self play: 1)
			)
			(
				(and
					(param1 diamonds:)
					(or
						(> (global429 topDi:) 3)
						(and
							(>= (global429 topDi:) (param1 diamonds:))
							(>=
								(global429 topDi:)
								((param1 partner:) diamonds:)
							)
						)
					)
				)
				(self play: 2)
			)
			(
				(and
					(param1 hearts:)
					(or
						(> (global429 topHt:) 3)
						(and
							(>= (global429 topHt:) (param1 hearts:))
							(>= (global429 topHt:) ((param1 partner:) hearts:))
						)
					)
				)
				(self play: 3)
			)
			(
				(and
					(param1 spades:)
					(or
						(> (global429 topSp:) 3)
						(and
							(>= (global429 topSp:) (param1 spades:))
							(>= (global429 topSp:) ((param1 partner:) spades:))
						)
					)
				)
				(self play: 4)
			)
			((= theCard (self checkOneTopThree:)))
			((= theCard (self checkKxQxx:)))
			(else
				(switch
					(Max
						(curPlyr clubs:)
						(curPlyr diamonds:)
						(curPlyr hearts:)
						(curPlyr spades:)
					)
					((curPlyr clubs:)
						(if
							(or
								(= temp26 (self gotSequence: curPlyr 1 10 2))
								(= temp26 (self gotSequence: curPlyr 1 0 2))
							)
							(if (== temp26 2)
								(self play: 1 11)
							else
								(self play: 1 12)
							)
						else
							(self play: 1)
						)
					)
					((curPlyr diamonds:)
						(if
							(or
								(= temp26 (self gotSequence: curPlyr 2 10 2))
								(= temp26 (self gotSequence: curPlyr 2 10 2))
							)
							(if (== temp26 2)
								(self play: 2 11)
							else
								(self play: 2 12)
							)
						else
							(self play: 2)
						)
					)
					((curPlyr hearts:)
						(if
							(or
								(= temp26 (self gotSequence: curPlyr 3 10 2))
								(= temp26 (self gotSequence: curPlyr 3 0 2))
							)
							(if (== temp26 2)
								(self play: 3 11)
							else
								(self play: 3 12)
							)
						else
							(self play: 3)
						)
					)
					((curPlyr spades:)
						(if
							(or
								(= temp26 (self gotSequence: curPlyr 4 10 2))
								(= temp26 (self gotSequence: curPlyr 4 0 2))
							)
							(if (== temp26 2)
								(self play: 4 11)
							else
								(self play: 4 12)
							)
						else
							(self play: 4)
						)
					)
				)
			)
		)
		(self verifiedCard: theCard)
	)

	(method (selfSuffCheck param1 &tmp temp0 temp1)
		(= [local6 2] (param1 diamonds:))
		(= [local6 1] (param1 clubs:))
		(= [local6 3] (param1 hearts:))
		(= [local6 4] (param1 spades:))
		(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
			(= temp1 0)
			(if (param1 hasCard: temp0 14)
				(++ temp1)
			)
			(if (param1 hasCard: temp0 13)
				(++ temp1)
			)
			(if (param1 hasCard: temp0 12)
				(++ temp1)
			)
			(if (param1 hasCard: temp0 11)
				(++ temp1)
			)
			(if (and (>= [local6 temp0] 6) (> temp1 2))
				(= suffSuit temp0)
				(return 1)
			)
		)
		(return 0)
	)

	(method (checkSideHCP param1 param2 param3 &tmp temp0)
		(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
			(if (and (!= temp0 param2) (>= (param1 calcHCP: temp0) param3))
				(return temp0)
			)
		)
		(return 0)
	)

	(method (checkForTwoHigher param1 param2 &tmp temp0 temp1 temp2 temp3)
		(= temp1 (self getHighest: param1 param2))
		(= temp3 (= temp0 0))
		(while (< temp0 (curPlyr size:))
			(= temp2 (curPlyr at: temp0))
			(if (and (== (temp2 suit:) param2) (> (temp2 rank:) temp1))
				(++ temp3)
			)
			(++ temp0)
		)
		(return (if (>= temp3 2) param2 else 0))
	)

	(method (getHighest param1 param2 &tmp temp0 temp1 temp2)
		(= temp1 (= temp0 0))
		(while (< temp0 (param1 size:))
			(= temp2 (param1 at: temp0))
			(if (and (== (temp2 suit:) param2) (> (temp2 rank:) temp1))
				(= temp1 (temp2 rank:))
			)
			(++ temp0)
		)
		(return temp1)
	)

	(method (makeContractMinusAce &tmp temp0 temp1 temp2)
		(= temp0 (+ global434 6))
		(if
			(and
				(>= (= temp1 (self checkTopTricks:)) temp0)
				(or
					(and (not topCl) (= temp2 1))
					(and (not topDi) (= temp2 2))
					(and (not topHt) (= temp2 3))
					(and (not topSp) (= temp2 4))
				)
			)
			(= temp2 0)
		)
		(return temp2)
	)

	(method (checkSideEntry param1 param2 param3 param4 &tmp temp0 temp1 temp2)
		(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
			(if (and (!= temp0 param2) (== (param1 countSuit: temp0) param3))
				(= temp1 argc)
				(for ((= temp2 0)) (- argc temp1) ((= temp2 (++ temp1)))
					(if (param1 hasCard: temp0 [param4 temp1])
						(return temp0)
					)
				)
			)
		)
		(return -1)
	)

	(method (getNumSpots param1 param2)
		(return (- (param1 countSuit: param2) (param1 calcHonors: param2)))
	)

	(method (getSideSuit param1 param2 param3 &tmp temp0)
		(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
			(if
				(and
					(not (OneOf temp0 param2 param3))
					(param1 countSuit: temp0)
				)
				(return temp0)
			)
		)
		(return -1)
	)

	(method (runningSuit param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(cond
			((== param1 global429)
				(= temp7 1)
				(= temp8 2)
			)
			((== param1 global431)
				(= temp7 2)
				(= temp8 1)
			)
			((== param1 (global429 LHO:))
				(= temp7 3)
				(= temp8 4)
			)
			(else
				(= temp7 4)
				(= temp8 3)
			)
		)
		(for ((= temp1 1)) (<= temp1 4) ((++ temp1))
			(for ((= temp0 0)) (< temp0 13) ((++ temp0))
				(switch temp1
					(4
						(= [local11 temp0] [global123 temp0])
						(= temp3 (global429 spades:))
						(= temp4 (global431 spades:))
						(= temp5 (param1 spades:))
						(= temp6 ((param1 partner:) spades:))
					)
					(1
						(= [local11 temp0] [global162 temp0])
						(= temp3 (global429 clubs:))
						(= temp4 (global431 clubs:))
						(= temp5 (param1 clubs:))
						(= temp6 ((param1 partner:) clubs:))
					)
					(2
						(= [local11 temp0] [global149 temp0])
						(= temp3 (global429 diamonds:))
						(= temp4 (global431 diamonds:))
						(= temp5 (param1 diamonds:))
						(= temp6 ((param1 partner:) diamonds:))
					)
					(3
						(= [local11 temp0] [global136 temp0])
						(= temp3 (global429 hearts:))
						(= temp4 (global431 hearts:))
						(= temp5 (param1 hearts:))
						(= temp6 ((param1 partner:) hearts:))
					)
				)
			)
			(cond
				(
					(and
						(or (== [local11 0] temp7) (== [local11 0] temp8))
						(or (== [local11 1] temp7) (== [local11 1] temp8))
						(or (== [local11 2] temp7) (== [local11 2] temp8))
					)
					(if
						(or
							(and
								(> temp6 temp5)
								(or
									(== [local11 1] temp8)
									(== [local11 2] temp8)
									(== [local11 3] temp8)
								)
							)
							(== [local11 1] [local11 2] [local11 3] temp7)
						)
						(return (self play: temp1 12))
					else
						(return (self play: temp1))
					)
				)
				(
					(and
						(== [local11 1] temp7)
						(== [local11 2] temp7)
						(< temp3 3)
						(< temp4 3)
					)
					(if
						(or
							(and
								(> temp6 temp5)
								(or
									(== [local11 1] temp8)
									(== [local11 2] temp8)
								)
							)
							(== [local11 1] [local11 2] temp8)
						)
						(return (self play: temp1 12))
					else
						(return (self play: temp1))
					)
				)
				((and (== [local11 1] temp7) (< temp3 2) (< temp4 2))
					(if (== [local11 1] temp7)
						(return (self play: temp1 12))
					else
						(return (self play: temp1))
					)
				)
			)
		)
		(return 0)
	)

	(method (checkOneTopThree &tmp temp0)
		(if
			(and
				(curPlyr spades:)
				(or (== [global123 1] 1) (== [global123 1] 2))
				(or (== [global123 2] 1) (== [global123 2] 2))
				(or (== [global123 3] 2) (== [global123 3] 1))
			)
			(if (== [global123 1] 1)
				(return (self play: 4 12))
			else
				(return (self play: 4))
			)
		)
		(if
			(and
				(curPlyr hearts:)
				(or (== [global136 1] 1) (== [global136 1] 2))
				(or (== [global136 2] 1) (== [global136 2] 2))
				(or (== [global136 3] 2) (== [global136 3] 1))
			)
			(if (== [global136 1] 1)
				(return (self play: 3 12))
			else
				(return (self play: 3))
			)
		)
		(if
			(and
				(curPlyr diamonds:)
				(or (== [global149 1] 1) (== [global149 1] 2))
				(or (== [global149 2] 1) (== [global149 2] 2))
				(or (== [global149 3] 2) (== [global149 3] 1))
			)
			(if (== [global149 1] 1)
				(return (self play: 2 12))
			else
				(return (self play: 2))
			)
		)
		(if
			(and
				(curPlyr clubs:)
				(or (== [global162 1] 1) (== [global162 1] 2))
				(or (== [global162 2] 1) (== [global162 2] 2))
				(or (== [global162 3] 2) (== [global162 3] 1))
			)
			(if (== [global162 1] 1)
				(return (self play: 1 12))
			else
				(return (self play: 1))
			)
		)
		(return 0)
	)

	(method (checkKxQxx &tmp temp0)
		(if
			(and
				(curPlyr spades:)
				(or
					(!= [global123 2] 1)
					(> (curPlyr spades:) 2)
					(and
						(> (curPlyr spades:) (global429 spades:))
						(> (curPlyr spades:) (global431 spades:))
					)
				)
				(or
					(!= [global123 3] 1)
					(> (curPlyr spades:) 3)
					(and
						(> (curPlyr spades:) (global429 spades:))
						(> (curPlyr spades:) (global431 spades:))
					)
				)
				(return (self play: 4))
			)
		)
		(if
			(and
				(curPlyr hearts:)
				(or
					(!= [global136 2] 1)
					(> (curPlyr hearts:) 2)
					(and
						(> (curPlyr hearts:) (global429 hearts:))
						(> (curPlyr hearts:) (global431 hearts:))
					)
				)
				(or
					(!= [global136 3] 1)
					(> (curPlyr hearts:) 3)
					(and
						(> (curPlyr hearts:) (global429 hearts:))
						(> (curPlyr hearts:) (global431 hearts:))
					)
				)
				(return (self play: 3))
			)
		)
		(if
			(and
				(curPlyr diamonds:)
				(or
					(!= [global149 2] 1)
					(> (curPlyr diamonds:) 2)
					(and
						(> (curPlyr diamonds:) (global429 diamonds:))
						(> (curPlyr diamonds:) (global431 diamonds:))
					)
				)
				(or
					(!= [global149 3] 1)
					(> (curPlyr diamonds:) 3)
					(and
						(> (curPlyr diamonds:) (global429 diamonds:))
						(> (curPlyr diamonds:) (global431 diamonds:))
					)
				)
				(return (self play: 2))
			)
		)
		(if
			(and
				(curPlyr clubs:)
				(or
					(!= [global162 2] 1)
					(> (curPlyr clubs:) 2)
					(and
						(> (curPlyr clubs:) (global429 clubs:))
						(> (curPlyr clubs:) (global431 clubs:))
					)
				)
				(or
					(!= [global162 3] 1)
					(> (curPlyr clubs:) 3)
					(and
						(> (curPlyr clubs:) (global429 clubs:))
						(> (curPlyr clubs:) (global431 clubs:))
					)
				)
				(return (self play: 1))
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
				(= temp1 (self topSp:))
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
				(= temp1 (self topCl:))
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
				(= temp1 (self topDi:))
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
				(= temp1 (self topHt:))
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

	(method (partnerLead &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 ((ScriptID 15 1) size:)) ((++ temp0)) ; discardList
			(= temp1 ((ScriptID 15 1) at: temp0)) ; discardList
			(if (== (((ScriptID 15 1) at: temp0) whoLedMe:) (curPlyr partner:)) ; discardList
				(return (((ScriptID 15 1) at: temp0) suit:)) ; discardList
			)
		)
		(return 0)
	)
)

