;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 746)
(include sci.sh)
(use Main)
(use Piles)
(use SortArray)
(use n726)
(use BridgeDefense)
(use System)

(local
	local0
	local1
	[local2 5]
	[local7 5]
	[local12 5]
	[local17 5]
	[local22 5]
)

(class Discard of BridgeDefense
	(properties
		oneHigh 0
		twoHigh 0
		threeHigh 0
		fourHigh 0
	)

	(method (init &tmp temp0)
		(for ((= temp0 0)) (< temp0 5) ((++ temp0))
			(= [local2 temp0] 0)
			(= [local7 temp0] 0)
			(= [local12 temp0] 0)
			(= [local17 temp0] 0)
			(= [local22 temp0] 0)
		)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
	)

	(method (think &tmp temp0 [temp1 2] temp3 temp4)
		(= curPlyr (Dealer curPlayer:))
		(= temp3 (curPlyr size:))
		(super think: &rest)
		(= theCard 0)
		(for ((= temp4 1)) (<= temp4 4) ((++ temp4))
			(= [local2 temp4] 0)
			(= [local7 temp4] 0)
			(= [local12 temp4] (global429 countSuit: temp4))
			(= [local17 temp4] (global431 countSuit: temp4))
			(cond
				((== curPlyr global429)
					(= [local22 temp4] [local12 temp4])
				)
				((== curPlyr global431)
					(= [local22 temp4] [local17 temp4])
				)
				(else
					(= [local22 temp4] (curPlyr countSuit: temp4))
				)
			)
		)
		(cond
			((== curPlyr (global429 LHO:))
				(= local0 3)
				(= local1 4)
			)
			((== curPlyr (global429 RHO:))
				(= local0 4)
				(= local1 3)
			)
			((== curPlyr global429)
				(= local0 1)
				(= local1 2)
			)
			(else
				(= local0 2)
				(= local1 1)
			)
		)
		(if (or (== curPlyr global429) (== curPlyr global431))
			(self checkTopTricks:)
		)
		(if (or (== curPlyr global429) (== curPlyr global431))
			(if
				(and
					[local7 1]
					(== [local7 1] (Max [local12 1] [local17 1]))
					(or
						(and (== curPlyr global429) (> [local12 1] [local17 1]))
						(and (== curPlyr global431) (> [local17 1] [local12 1]))
					)
				)
				(= [local2 1] 1)
			)
			(if
				(and
					[local7 2]
					(== [local7 2] (Max [local12 2] [local17 2]))
					(or
						(and (== curPlyr global429) (> [local12 2] [local17 2]))
						(and (== curPlyr global431) (> [local17 2] [local12 2]))
					)
				)
				(= [local2 2] 1)
			)
			(if
				(and
					[local7 3]
					(== [local7 3] (Max [local12 3] [local17 3]))
					(or
						(and (== curPlyr global429) (> [local12 3] [local17 3]))
						(and (== curPlyr global431) (> [local17 3] [local12 3]))
					)
				)
				(= [local2 3] 1)
			)
			(if
				(and
					[local7 4]
					(== [local7 4] (Max [local12 4] [local17 4]))
					(or
						(and (== curPlyr global429) (> [local12 4] [local17 4]))
						(and (== curPlyr global431) (> [local17 4] [local12 4]))
					)
				)
				(= [local2 4] 1)
			)
			(if (!= trumps 5)
				(= [local2 trumps] 1)
			)
		)
		(cond
			(
				(or
					(and (== temp3 (curPlyr clubs:)) (= temp0 1))
					(and (== temp3 (curPlyr diamonds:)) (= temp0 2))
					(and (== temp3 (curPlyr hearts:)) (= temp0 3))
					(and (== temp3 (curPlyr spades:)) (= temp0 4))
				)
				(self play: temp0)
			)
			((!= (= temp0 (self doFirstCheck:)) -1)
				(cond
					((self gotSequence: curPlyr temp0 14 2)
						(self play: temp0 12)
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
						(if
							(or
								(curPlyr hasCard: temp0 14)
								(curPlyr hasCard: temp0 13)
							)
							(self play: temp0 11)
						else
							(self play: temp0 12)
						)
					)
					((self gotSequence: curPlyr temp0 10 2)
						(cond
							(
								(or
									(and
										(curPlyr hasCard: temp0 14)
										(curPlyr hasCard: temp0 13)
									)
									(and
										(curPlyr hasCard: temp0 14)
										(curPlyr hasCard: temp0 12)
									)
									(and
										(curPlyr hasCard: temp0 12)
										(curPlyr hasCard: temp0 13)
									)
								)
								(self play: temp0 10)
							)
							(
								(or
									(curPlyr hasCard: temp0 14)
									(curPlyr hasCard: temp0 13)
									(curPlyr hasCard: temp0 12)
								)
								(self play: temp0 11)
							)
							(else
								(self play: temp0 12)
							)
						)
					)
				)
			)
			(
				(and
					(!= (gTrick trump:) 5)
					(curPlyr countSuit: trumps)
					(or
						(and
							(== (curPlyr clubs:) 1)
							(!= trumps 1)
							(or (pard stops: 1) (self hasTopCards: 1))
							(= temp0 1)
							(not [local2 1])
						)
						(and
							(== (curPlyr diamonds:) 1)
							(!= trumps 2)
							(or (pard stops: 2) (self hasTopCards: 2))
							(= temp0 2)
							(not [local2 2])
						)
						(and
							(== (curPlyr hearts:) 1)
							(!= trumps 3)
							(or (pard stops: 3) (self hasTopCards: 3))
							(= temp0 3)
							(not [local2 3])
						)
						(and
							(== (curPlyr spades:) 1)
							(!= trumps 4)
							(or (pard stops: 4) (self hasTopCards: 4))
							(= temp0 4)
							(not [local2 4])
						)
					)
				)
				(self play: temp0)
			)
			((= temp0 (self isBlocked:))
				(self play: temp0 12)
			)
			(
				(or
					(and
						(!= trumps 1)
						(self checkTopCards: 1 [local22 1])
						(= temp0 1)
					)
					(and
						(!= trumps 2)
						(self checkTopCards: 2 [local22 2])
						(= temp0 2)
					)
					(and
						(!= trumps 3)
						(self checkTopCards: 3 [local22 3])
						(= temp0 3)
					)
					(and
						(!= trumps 4)
						(self checkTopCards: 4 [local22 4])
						(= temp0 4)
					)
				)
				(self play: temp0)
			)
			(
				(and
					(= temp0 (self runningSuit: pard))
					(> (curPlyr countSuit: temp0) 2)
					(!= trumps temp0)
				)
				(self play: temp0 12)
			)
			(
				(and
					(= temp0 (self runningSuit: pard))
					(> (curPlyr countSuit: temp0) 1)
					(!= trumps temp0)
				)
				(self play: temp0 12)
			)
			(
				(or
					(and
						(not [local2 1])
						[local22 1]
						(self checkSuitSize: 1)
						(= temp0 1)
					)
					(and
						(not [local2 2])
						[local22 2]
						(self checkSuitSize: 2)
						(= temp0 2)
					)
					(and
						(not [local2 3])
						[local22 3]
						(self checkSuitSize: 3)
						(= temp0 3)
					)
					(and
						(not [local2 4])
						[local22 4]
						(self checkSuitSize: 4)
						(= temp0 4)
					)
				)
				(self play: temp0)
			)
			((and (!= curPlyr global431) (!= (= temp0 (self doCheck: 2 2)) -1))
				(self play: temp0)
			)
			((and (!= curPlyr global431) (!= (= temp0 (self doCheck: 1 1)) -1))
				(self play: temp0)
			)
			(
				(and
					(== curPlyr global429)
					(or
						(and
							(> [local17 1] [local12 1])
							(>=
								[local17 1]
								(/
									(+
										1
										(LHO countSuit: 1)
										((curPlyr RHO:) countSuit: 1)
									)
									2
								)
							)
							(= temp0 1)
							(not [local2 1])
							(< (curPlyr calcHonors: temp0 4) [local12 temp0])
						)
						(and
							(> [local17 2] [local12 2])
							(>=
								[local17 2]
								(/
									(+
										1
										(LHO countSuit: 2)
										((curPlyr RHO:) countSuit: 2)
									)
									2
								)
							)
							(= temp0 2)
							(not [local2 2])
							(< (curPlyr calcHonors: temp0 4) [local12 temp0])
						)
						(and
							(> [local17 3] [local12 3])
							(>=
								[local17 3]
								(/
									(+
										1
										(LHO countSuit: 3)
										((curPlyr RHO:) countSuit: 3)
									)
									2
								)
							)
							(= temp0 3)
							(not [local2 3])
							(< (curPlyr calcHonors: temp0 4) [local12 temp0])
						)
						(and
							(> [local17 4] [local12 4])
							(>=
								[local17 4]
								(/
									(+
										1
										(LHO countSuit: 4)
										((curPlyr RHO:) countSuit: 4)
									)
									2
								)
							)
							(= temp0 4)
							(not [local2 4])
							(< (curPlyr calcHonors: temp0 4) [local12 temp0])
						)
					)
				)
				(self play: temp0)
			)
			(
				(and
					(== curPlyr global431)
					(or
						(and
							(> [local12 1] [local17 1])
							(>=
								[local12 1]
								(/
									(+
										1
										(LHO countSuit: 1)
										((curPlyr RHO:) countSuit: 1)
									)
									2
								)
							)
							(= temp0 1)
							(not [local2 1])
							(< (curPlyr calcHonors: temp0 4) [local17 temp0])
						)
						(and
							(> [local12 2] [local17 2])
							(>=
								[local12 2]
								(/
									(+
										1
										(LHO countSuit: 2)
										((curPlyr RHO:) countSuit: 2)
									)
									2
								)
							)
							(= temp0 2)
							(not [local2 2])
							(< (curPlyr calcHonors: temp0 4) [local17 temp0])
						)
						(and
							(> [local12 3] [local17 3])
							(>=
								[local12 3]
								(/
									(+
										1
										(LHO countSuit: 3)
										((curPlyr RHO:) countSuit: 3)
									)
									2
								)
							)
							(= temp0 3)
							(not [local2 3])
							(< (curPlyr calcHonors: temp0 4) [local17 temp0])
						)
						(and
							(> [local12 4] [local17 4])
							(>=
								[local12 4]
								(/
									(+
										1
										(LHO countSuit: 4)
										((curPlyr RHO:) countSuit: 4)
									)
									2
								)
							)
							(= temp0 4)
							(not [local2 4])
							(< (curPlyr calcHonors: temp0 4) [local17 temp0])
						)
					)
				)
				(self play: temp0)
			)
			(
				(and
					(== curPlyr global429)
					(or
						(and
							(>= [local17 1] [local12 1])
							(= temp0 1)
							(not [local2 1])
							(< (curPlyr calcHonors: temp0 4) [local12 temp0])
							(<=
								(curPlyr calcHonors: temp0 5)
								(global431 calcHonors: temp0 5)
							)
							(not (curPlyr stops: temp0))
						)
						(and
							(>= [local17 2] [local12 2])
							(= temp0 2)
							(not [local2 2])
							(< (curPlyr calcHonors: temp0 4) [local12 temp0])
							(<=
								(curPlyr calcHonors: temp0 5)
								(global431 calcHonors: temp0 5)
							)
							(not (curPlyr stops: temp0))
						)
						(and
							(>= [local17 3] [local12 3])
							(!= trumps 3)
							(= temp0 3)
							(not [local2 3])
							(< (curPlyr calcHonors: temp0 4) [local12 temp0])
							(<=
								(curPlyr calcHonors: temp0 5)
								(global431 calcHonors: temp0 5)
							)
							(not (curPlyr stops: temp0))
						)
						(and
							(>= [local17 4] [local12 4])
							(!= trumps 4)
							(= temp0 4)
							(not [local2 4])
							(< (curPlyr calcHonors: temp0 4) [local12 temp0])
							(<=
								(curPlyr calcHonors: temp0 5)
								(global431 calcHonors: temp0 5)
							)
							(not (curPlyr stops: temp0))
						)
					)
				)
				(self play: temp0)
			)
			(
				(and
					(== curPlyr global431)
					(or
						(and
							(>= [local12 1] [local17 1])
							(= temp0 1)
							(not [local2 1])
							(< (curPlyr calcHonors: temp0 4) [local17 temp0])
							(<=
								(curPlyr calcHonors: temp0 5)
								(global429 calcHonors: temp0 5)
							)
							(not (curPlyr stops: temp0))
						)
						(and
							(>= [local12 2] [local17 2])
							(= temp0 2)
							(not [local2 2])
							(< (curPlyr calcHonors: temp0 4) [local17 temp0])
							(<=
								(curPlyr calcHonors: temp0 5)
								(global429 calcHonors: temp0 5)
							)
							(not (curPlyr stops: temp0))
						)
						(and
							(>= [local12 3] [local17 3])
							(= temp0 3)
							(not [local2 3])
							(< (curPlyr calcHonors: temp0 4) [local17 temp0])
							(<=
								(curPlyr calcHonors: temp0 5)
								(global429 calcHonors: temp0 5)
							)
							(not (curPlyr stops: temp0))
						)
						(and
							(>= [local12 4] [local17 4])
							(= temp0 4)
							(not [local2 4])
							(< (curPlyr calcHonors: temp0 4) [local17 temp0])
							(<=
								(curPlyr calcHonors: temp0 5)
								(global429 calcHonors: temp0 5)
							)
							(not (curPlyr stops: temp0))
						)
					)
				)
				(self play: temp0)
			)
			((= temp0 (self check12016:))
				(self play: temp0)
			)
		)
		(self verifiedCard: theCard)
	)

	(method (setFourHighest param1)
		(= oneHigh (SortArray nHighest: param1 1))
		(= twoHigh (SortArray nHighest: param1 2))
		(= threeHigh (SortArray nHighest: param1 3))
		(= fourHigh (SortArray nHighest: param1 4))
	)

	(method (doFirstCheck &tmp temp0 temp1 temp2 temp3)
		(= temp3 -1)
		(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
			(= temp2
				(+ (global429 countSuit: temp0) (global431 countSuit: temp0))
			)
			(if
				(and
					(self gotSequence: curPlyr temp0 0 3)
					(!= curPlyr global429)
					(!= curPlyr global431)
					(!= trumps temp0)
					(= temp1 (curPlyr countSuit: temp0))
					(> temp1 temp2)
				)
				(= temp3 temp0)
				(= temp0 4)
			)
		)
		(return temp3)
	)

	(method (doCheck param1 param2 &tmp temp0 temp1 [temp2 5] temp7)
		(switch local0
			(1
				(= temp7 4)
			)
			(3
				(= temp7 1)
			)
			(4
				(= temp7 3)
			)
		)
		(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
			(if (!= trumps temp0)
				(for ((= temp1 0)) (<= temp1 4) ((++ temp1))
					(= [temp2 temp1]
						(switch temp0
							(1 [global162 temp1])
							(2 [global149 temp1])
							(3 [global136 temp1])
							(4 [global123 temp1])
						)
					)
				)
				(if
					(and
						(not [local2 temp0])
						(== [temp2 param1] local0)
						(> (curPlyr countSuit: temp0) param2)
						(or
							(== [temp2 0] temp7)
							(and (== param1 2) (== [temp2 1] temp7))
						)
					)
					(return temp0)
				)
			)
		)
		(return -1)
	)

	(method (checkTopCards param1 param2 &tmp temp0 temp1 [temp2 13])
		(= temp1 1)
		(proc726_0)
		(if
			(or
				(and
					(> param2 ((curPlyr LHO:) countSuit: param1))
					(> param2 ((curPlyr RHO:) countSuit: param1))
				)
				(== trumps param1)
				(not [local22 param1])
				[local2 param1]
			)
			(return 0)
		)
		(cond
			((== curPlyr global429)
				(= local0 1)
			)
			((== curPlyr global431)
				(= local0 2)
			)
			((== LHO global429)
				(= local0 4)
			)
			(else
				(= local0 3)
			)
		)
		(for ((= temp0 0)) (< temp0 13) ((++ temp0))
			(= [temp2 temp0]
				(switch param1
					(1 [global162 temp0])
					(2 [global149 temp0])
					(3 [global136 temp0])
					(4 [global123 temp0])
				)
			)
		)
		(if
			(or
				(== [temp2 0] local0)
				(and (== [temp2 1] local0) (> param2 1))
				(and (== [temp2 2] local0) (> param2 2))
				(and (== [temp2 3] local0) (> param2 3))
				(and
					(== [temp2 4] local0)
					(or (> param2 4) (== (global431 countSuit: param1) 4))
				)
			)
			(= temp1 0)
		)
		(return temp1)
	)

	(method (checkSuitSize param1 &tmp temp0 temp1 temp2)
		(= temp2 (curPlyr countSuit: param1))
		(= temp0 ((curPlyr LHO:) countSuit: param1))
		(= temp1 ((curPlyr RHO:) countSuit: param1))
		(cond
			(
				(and
					(!= trumps param1)
					(or (== curPlyr global429) (== curPlyr global431))
				)
				(return
					(and
						(< temp2 temp0)
						(< temp2 temp1)
						(curPlyr countSuit: trumps)
					)
				)
			)
			(
				(and
					(or
						(== trumps 5)
						(not
							(+
								((curPlyr LHO:) countSuit: trumps)
								((curPlyr RHO:) countSuit: trumps)
							)
						)
					)
					(or (== curPlyr global429) (== curPlyr global431))
					(or
						(pard stops: param1)
						(and
							(not (curPlyr stops: param1))
							(>=
								(pard countSuit: param1)
								(curPlyr countSuit: param1)
							)
						)
						(and (!= trumps 5) (pard countSuit: trumps))
					)
				)
				(return (and (< temp2 temp0) (< temp2 temp1)))
			)
			(else
				(return (and (> temp2 temp0) (> temp2 temp1)))
			)
		)
	)

	(method (hasTopCards param1 &tmp temp0 [temp1 13])
		(for ((= temp0 0)) (< temp0 13) ((++ temp0))
			(= [temp1 temp0]
				(switch param1
					(1 [global162 temp0])
					(2 [global149 temp0])
					(3 [global136 temp0])
					(4 [global123 temp0])
				)
			)
		)
		(for
			((= temp0 0))
			(<
				temp0
				(Max
					(curPlyr countSuit: param1)
					(pard countSuit: param1)
				)
			)
			((++ temp0))
			
			(if
				(or
					(and
						(or (== curPlyr global429) (== curPlyr global431))
						(> [temp1 temp0] 2)
					)
					(and
						(!= curPlyr global429)
						(!= curPlyr global431)
						(< [temp1 temp0] 3)
					)
				)
				(return 0)
			)
		)
		(return 1)
	)

	(method (checkTopTricks &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10)
		(= temp3 (= temp0 (= temp1 (= temp2 0))))
		(= temp4 (= temp5 (= temp6 (= temp7 0))))
		(= theSuitLead (gTrick suitLead:))
		(= trickSize (gTrick size:))
		(for ((= temp10 1)) (<= temp10 4) ((++ temp10))
			(for ((= temp9 0)) (< temp9 13) ((++ temp9))
				(switch temp10
					(1
						(if (and (< [global162 temp9] 3) [global162 temp9])
							(++ temp0)
						else
							(= temp9 13)
						)
					)
					(2
						(if (and (< [global149 temp9] 3) [global149 temp9])
							(++ temp1)
						else
							(= temp9 13)
						)
					)
					(3
						(if (and (< [global136 temp9] 3) [global136 temp9])
							(++ temp2)
						else
							(= temp9 13)
						)
					)
					(4
						(if (and (< [global123 temp9] 3) [global123 temp9])
							(++ temp3)
						else
							(= temp9 13)
						)
					)
				)
			)
		)
		(if
			(and
				trickSize
				(or
					(and
						(== trickSize 1)
						(not
							(global431
								hasCard:
									theSuitLead
									(| (gTrick highOfSuitLead:) $0f00)
							)
						)
						(not
							(global429
								hasCard:
									theSuitLead
									(| (gTrick highOfSuitLead:) $0f00)
							)
						)
					)
					(and
						(> trickSize 1)
						(!= ((gTrick highCard:) owner:) global429)
						(!= ((gTrick highCard:) owner:) global431)
						(not
							(curPlyr
								hasCard:
									theSuitLead
									(| (gTrick highOfSuitLead:) $0f00)
							)
						)
					)
				)
			)
			(switch theSuitLead
				(1
					(= temp0 0)
				)
				(2
					(= temp1 0)
				)
				(3
					(= temp2 0)
				)
				(4
					(= temp3 0)
				)
			)
		)
		(if (> temp0 (Max (global431 clubs:) (global429 clubs:)))
			(= temp0 (Max (global431 clubs:) (global429 clubs:)))
		)
		(if (> temp1 (Max (global431 diamonds:) (global429 diamonds:)))
			(= temp1 (Max (global431 diamonds:) (global429 diamonds:)))
		)
		(if (> temp2 (Max (global431 hearts:) (global429 hearts:)))
			(= temp2 (Max (global431 hearts:) (global429 hearts:)))
		)
		(if (> temp3 (Max (global431 spades:) (global429 spades:)))
			(= temp3 (Max (global431 spades:) (global429 spades:)))
		)
		(= [local7 1] temp0)
		(= [local7 2] temp1)
		(= [local7 3] temp2)
		(= [local7 4] temp3)
	)

	(method (isBlocked &tmp temp0 temp1 temp2 [temp3 13])
		(= temp0 1)
		(= temp2 0)
		(while (<= temp0 4)
			(for ((= temp1 0)) (< temp1 13) ((++ temp1))
				(= [temp3 temp1]
					(switch temp0
						(1 [global162 temp1])
						(2 [global149 temp1])
						(3 [global136 temp1])
						(else [global123 temp1])
					)
				)
			)
			(if
				(and
					(< (curPlyr countSuit: temp0) (pard countSuit: temp0))
					(== [temp3 0] local0)
					(== [temp3 1] local1)
					(== [temp3 2] local1)
					(or
						(== [temp3 3] local1)
						(and
							(< ((curPlyr LHO:) countSuit: temp0) 3)
							(< ((curPlyr RHO:) countSuit: temp0) 3)
							(<= (curPlyr countSuit: temp0) 2)
						)
					)
				)
				(= temp2 temp0)
				(= temp0 4)
			)
			(++ temp0)
		)
		(return temp2)
	)

	(method (check12014 &tmp temp0 temp1)
		(= temp1 0)
		(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
			(if
				(and
					(!= trumps temp0)
					(== (self runningSuit: (curPlyr LHO:) temp0) 0)
					(== (self runningSuit: (curPlyr RHO:) temp0) 0)
				)
				(= temp1 temp0)
				(= temp0 4)
			)
		)
		(return temp1)
	)

	(method (check12016 &tmp temp0 temp1 [temp2 5] [temp7 5] temp12 temp13 temp14 temp15)
		(for ((= temp1 1)) (<= temp1 4) ((++ temp1))
			(= [temp7 temp1] (= [temp2 temp1] 0))
			(for ((= temp0 0)) (< temp0 13) ((++ temp0))
				(cond
					(
						(==
							(= temp12
								(switch temp1
									(1 [global162 temp0])
									(2 [global149 temp0])
									(3 [global136 temp0])
									(4 [global123 temp0])
								)
							)
							local0
						)
						(++ [temp7 temp1])
						(++ [temp2 temp1])
					)
					((== temp12 local1)
						(++ [temp2 temp1])
					)
					(else
						(= temp0 13)
					)
				)
			)
		)
		(if
			(or
				(and
					(!= trumps 1)
					(< [temp7 1] (curPlyr clubs:))
					(< [temp2 1] (Max (curPlyr clubs:) (pard clubs:)))
					(not (self checkTopCards: 1 [local22 1]))
					(not [local2 1])
					(= temp13 1)
				)
				(and
					(!= trumps 2)
					(< [temp7 2] (curPlyr diamonds:))
					(<
						[temp2 2]
						(Max (curPlyr diamonds:) (pard diamonds:))
					)
					(not (self checkTopCards: 2 [local22 2]))
					(not [local2 2])
					(= temp13 2)
				)
				(and
					(!= trumps 3)
					(< [temp7 3] (curPlyr hearts:))
					(< [temp2 3] (Max (curPlyr hearts:) (pard hearts:)))
					(not (self checkTopCards: 3 [local22 3]))
					(not [local2 3])
					(= temp13 3)
				)
				(and
					(!= trumps 4)
					(< [temp7 4] (curPlyr spades:))
					(< [temp2 4] (Max (curPlyr spades:) (pard spades:)))
					(not [local2 4])
					(not (self checkTopCards: 4 [local22 4]))
					(= temp13 4)
				)
			)
			(return temp13)
		)
		(if
			(or
				(and
					(!= trumps 1)
					(curPlyr clubs:)
					(< [temp2 1] (Max (curPlyr clubs:) (pard clubs:)))
					(not [local2 1])
					(= temp13 1)
				)
				(and
					(!= trumps 2)
					(curPlyr diamonds:)
					(<
						[temp2 2]
						(Max (curPlyr diamonds:) (pard diamonds:))
					)
					(= temp13 2)
					(not [local2 2])
				)
				(and
					(!= trumps 3)
					(curPlyr hearts:)
					(< [temp2 3] (Max (curPlyr hearts:) (pard hearts:)))
					(= temp13 3)
					(not [local2 3])
				)
				(and
					(!= trumps 4)
					(curPlyr spades:)
					(< [temp2 4] (Max (curPlyr spades:) (pard spades:)))
					(= temp13 4)
					(not [local2 4])
				)
			)
			(return temp13)
		)
		(if
			(or
				(and
					(!= trumps 1)
					(curPlyr clubs:)
					(< [temp2 1] (Max (curPlyr clubs:) (pard clubs:)))
					(= temp13 1)
				)
				(and
					(!= trumps 2)
					(curPlyr diamonds:)
					(<
						[temp2 2]
						(Max (curPlyr diamonds:) (pard diamonds:))
					)
					(= temp13 2)
				)
				(and
					(!= trumps 3)
					(curPlyr hearts:)
					(< [temp2 3] (Max (curPlyr hearts:) (pard hearts:)))
					(= temp13 3)
				)
				(and
					(!= trumps 4)
					(curPlyr spades:)
					(< [temp2 4] (Max (curPlyr spades:) (pard spades:)))
					(= temp13 4)
				)
			)
			(return temp13)
		)
		(if
			(or
				(and
					(!= trumps 1)
					(curPlyr clubs:)
					(> [temp2 1] (Max (curPlyr clubs:) (pard clubs:)))
					(= temp13 1)
				)
				(and
					(!= trumps 2)
					(curPlyr diamonds:)
					(>
						[temp2 2]
						(Max (curPlyr diamonds:) (pard diamonds:))
					)
					(= temp13 2)
				)
				(and
					(!= trumps 3)
					(curPlyr hearts:)
					(> [temp2 3] (Max (curPlyr hearts:) (pard hearts:)))
					(= temp13 3)
				)
				(and
					(!= trumps 4)
					(curPlyr spades:)
					(> [temp2 4] (Max (curPlyr spades:) (pard spades:)))
					(= temp13 4)
				)
			)
			(return temp13)
		)
		(for ((= temp1 1)) (<= temp1 4) ((++ temp1))
			(for ((= temp0 0)) (< temp0 [temp2 temp1]) ((++ temp0))
				(if
					(==
						(= temp12
							(switch temp1
								(1 [global162 temp0])
								(2 [global149 temp0])
								(3 [global136 temp0])
								(4 [global123 temp0])
							)
						)
						local1
					)
					(= temp0 (= [temp2 temp1] 99))
				)
			)
		)
		(if
			(or
				(and
					(!= trumps 1)
					(curPlyr clubs:)
					(== [temp2 1] 99)
					(= temp13 1)
				)
				(and
					(!= trumps 2)
					(curPlyr diamonds:)
					(== [temp2 2] 99)
					(= temp13 2)
				)
				(and
					(!= trumps 3)
					(curPlyr hearts:)
					(== [temp2 3] 99)
					(= temp13 3)
				)
				(and
					(!= trumps 4)
					(curPlyr spades:)
					(== [temp2 4] 99)
					(= temp13 4)
				)
			)
			(return temp13)
		)
		(= temp13 0)
		(if (curPlyr clubs:)
			(= [temp2 1]
				(Max ((curPlyr LHO:) clubs:) ((curPlyr RHO:) clubs:))
			)
		else
			(= [temp2 1] 99)
		)
		(if (curPlyr diamonds:)
			(= [temp2 2]
				(Max
					((curPlyr LHO:) diamonds:)
					((curPlyr RHO:) diamonds:)
				)
			)
		else
			(= [temp2 2] 99)
		)
		(if (curPlyr hearts:)
			(= [temp2 3]
				(Max ((curPlyr LHO:) hearts:) ((curPlyr RHO:) hearts:))
			)
		else
			(= [temp2 3] 99)
		)
		(if (curPlyr spades:)
			(= [temp2 4]
				(Max ((curPlyr LHO:) spades:) ((curPlyr RHO:) spades:))
			)
		else
			(= [temp2 4] 99)
		)
		(if (!= trumps 5)
			(= temp14 ((curPlyr LHO:) countSuit: trumps))
			(= temp15 ((curPlyr RHO:) countSuit: trumps))
		else
			(= temp15 (= temp14 0))
		)
		(if
			(or
				(and
					(!= trumps 1)
					(< [temp2 1] 99)
					(<= [temp2 1] [temp2 2])
					(<= [temp2 1] [temp2 3])
					(<= [temp2 1] [temp2 4])
					(= temp13 1)
				)
				(and
					(!= trumps 2)
					(< [temp2 2] 99)
					(<= [temp2 2] [temp2 1])
					(<= [temp2 2] [temp2 3])
					(<= [temp2 2] [temp2 4])
					(= temp13 2)
				)
				(and
					(!= trumps 3)
					(< [temp2 3] 99)
					(<= [temp2 3] [temp2 2])
					(<= [temp2 3] [temp2 1])
					(<= [temp2 3] [temp2 4])
					(= temp13 3)
				)
				(and
					(!= trumps 4)
					(< [temp2 4] 99)
					(<= [temp2 4] [temp2 2])
					(<= [temp2 4] [temp2 3])
					(<= [temp2 4] [temp2 1])
					(= temp13 4)
				)
			)
			(return temp13)
		)
		(return 0)
	)
)

