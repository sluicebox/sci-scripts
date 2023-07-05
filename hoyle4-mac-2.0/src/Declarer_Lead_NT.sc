;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 732)
(include sci.sh)
(use Main)
(use BridgeStrategyPlay)
(use System)

(local
	[local0 39]
	local39
	local40
	local41
	local42
	local43
	local44
	local45
	local46
	local47
	local48
	[local49 5]
	[local54 5]
)

(class Declarer_Lead_NT of BridgeStrategyPlay
	(properties)

	(method (think param1 &tmp temp0 temp1 temp2 [temp3 2] temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 [temp14 3] temp17 temp18 temp19 temp20)
		(if (not [local0 0])
			(self init:)
		)
		(= local41 (= local43 (= local45 (= local47 0))))
		(= local42 (= local44 (= local46 (= local48 0))))
		(= LHO (param1 LHO:))
		(= RHO (param1 RHO:))
		(= local40 0)
		(= temp5 (gTrick tricksPlayed:))
		(= temp6 (- (+ global434 6) global433))
		(= temp7 (- (- 7 global434) (- temp5 global433)))
		(= trumps (gTrick trump:))
		(= temp17 (LHO countSuit: trumps))
		(= temp18 (RHO countSuit: trumps))
		(self makePlan: 0)
		(= local41 (global429 clubs:))
		(= local43 (global429 diamonds:))
		(= local45 (global429 hearts:))
		(= local47 (global429 spades:))
		(= local42 (global431 clubs:))
		(= local44 (global431 diamonds:))
		(= local46 (global431 hearts:))
		(= local48 (global431 spades:))
		(self setCurPlyr:)
		(if (== curPlyr global429)
			(= temp10 local41)
			(= temp11 local43)
			(= temp12 local45)
			(= temp13 local47)
			(= temp19 (global429 countSuit: trumps))
			(= temp20 (global431 countSuit: trumps))
		else
			(= temp10 local42)
			(= temp11 local44)
			(= temp12 local46)
			(= temp13 local48)
			(= temp19 (global431 countSuit: trumps))
			(= temp20 (global429 countSuit: trumps))
		)
		(if
			(and
				(>= (self checkTopTricks:) temp6)
				(!= trumps 5)
				(or temp17 temp18)
				(>= (Max temp19 temp20) (/ (+ 1 temp17 temp18) 2))
				(or
					(not temp19)
					(not temp20)
					(> (+ temp17 temp18) 1)
					(proc710_0 0 trumps)
				)
			)
			(switch trumps
				(1
					(if (and (!= plan 10) (!= plan 14) (< plan 23) temp19)
						(self setPlan: 22)
					)
				)
				(2
					(if (and (!= plan 11) (!= plan 15) (< plan 24) temp19)
						(self setPlan: 22)
					)
				)
				(3
					(if (and (!= plan 12) (!= plan 16) (< plan 25) temp19)
						(self setPlan: 22)
					)
				)
				(4
					(if (and (!= plan 13) (!= plan 17) (< plan 26) temp19)
						(self setPlan: 22)
					)
				)
			)
		)
		(if (not plan)
			(self makePlan: 1)
		)
		(if plan
			(cond
				((== plan 1)
					(= local40 (self checkCashTop:))
				)
				((== plan 22)
					(= local40 (self checkSplitTops: trumps))
				)
				((== plan 31)
					(= local40 (self bottomCard: 1))
				)
				((== plan 32)
					(= local40 (self bottomCard: 2))
				)
				((== plan 33)
					(= local40 (self bottomCard: 3))
				)
				((== plan 34)
					(= local40 (self bottomCard: 4))
				)
				((and (== plan 23) temp10)
					(= local40 (self checkSplitTops: 1))
				)
				((and (== plan 24) temp11)
					(= local40 (self checkSplitTops: 2))
				)
				((and (== plan 25) temp12)
					(= local40 (self checkSplitTops: 3))
				)
				((and (== plan 26) temp13)
					(= local40 (self checkSplitTops: 4))
				)
				((and (== plan 27) temp10)
					(= local40 (self checkSplitTops: 1))
				)
				((and (== plan 28) temp11)
					(= local40 (self checkSplitTops: 2))
				)
				((and (== plan 29) temp12)
					(= local40 (self checkSplitTops: 3))
				)
				((and (== plan 30) temp13)
					(= local40 (self checkSplitTops: 4))
				)
				((and (== plan 2) temp10)
					(= local40 (self checkSplitTops: 1))
				)
				((and (== plan 3) temp11)
					(= local40 (self checkSplitTops: 2))
				)
				((and (== plan 4) temp12)
					(= local40 (self checkSplitTops: 3))
				)
				((and (== plan 5) temp13)
					(= local40 (self checkSplitTops: 4))
				)
				((and (== plan 6) temp10)
					(= local40 (self checkSplitTops: 1))
				)
				((and (== plan 7) temp11)
					(= local40 (self checkSplitTops: 2))
				)
				((and (== plan 8) temp12)
					(= local40 (self checkSplitTops: 3))
				)
				((and (== plan 9) temp13)
					(= local40 (self checkSplitTops: 4))
				)
				((and (== plan 10) temp10 (== curPlyr global431))
					(if
						(or
							(not (= local40 (proc710_0 14 1)))
							(!= (local40 owner:) global431)
						)
						(= local40 (self bottomCard: 1))
					)
				)
				((and (== plan 11) temp11 (== curPlyr global431))
					(if
						(or
							(not (= local40 (proc710_0 14 2)))
							(!= (local40 owner:) global431)
						)
						(= local40 (self bottomCard: 2))
					)
				)
				((and (== plan 12) temp12 (== curPlyr global431))
					(if
						(or
							(not (= local40 (proc710_0 14 3)))
							(!= (local40 owner:) global431)
						)
						(= local40 (self bottomCard: 3))
					)
				)
				((and (== plan 13) temp13 (== curPlyr global431))
					(if
						(or
							(not (= local40 (proc710_0 14 4)))
							(!= (local40 owner:) global431)
						)
						(= local40 (self bottomCard: 4))
					)
				)
				((and (== plan 14) temp10 (== curPlyr global429))
					(if
						(or
							(not (= local40 (proc710_0 14 1)))
							(!= (local40 owner:) global429)
						)
						(= local40 (self bottomCard: 1))
					)
				)
				((and (== plan 15) temp11 (== curPlyr global429))
					(if
						(or
							(not (= local40 (proc710_0 14 2)))
							(!= (local40 owner:) global429)
						)
						(= local40 (self bottomCard: 2))
					)
				)
				((and (== plan 16) temp12 (== curPlyr global429))
					(if
						(or
							(not (= local40 (proc710_0 14 3)))
							(!= (local40 owner:) global429)
						)
						(= local40 (self bottomCard: 3))
					)
				)
				((and (== plan 17) temp13 (== curPlyr global429))
					(if
						(or
							(not (= local40 (proc710_0 14 4)))
							(!= (local40 owner:) global429)
						)
						(= local40 (self bottomCard: 4))
					)
				)
				((and (== plan 18) (= temp9 (self gotAnEntry: 1)))
					(= local40 (self checkSplitTops: temp9))
				)
				((and (== plan 19) (= temp9 (self gotAnEntry: 2)))
					(= local40 (self checkSplitTops: temp9))
				)
				((and (== plan 20) (= temp9 (self gotAnEntry: 3)))
					(= local40 (self checkSplitTops: temp9))
				)
				((and (== plan 21) (= temp9 (self gotAnEntry: 4)))
					(= local40 (self checkSplitTops: temp9))
				)
				(
					(and
						(!= trumps 5)
						temp19
						(>= (Max temp19 temp20) (Max temp17 temp18))
					)
					(= local40 (self checkSplitTops: trumps))
				)
			)
		)
		(for ((= temp1 1)) (<= temp1 4) ((++ temp1))
			(= [local49 temp1] (proc710_0 12 temp1))
			(if
				(and
					(curPlyr countSuit: temp1)
					(or (!= trumps temp1) temp17 temp18)
				)
				(= [local54 temp1]
					(+
						(global429 countSuit: temp1)
						(global431 countSuit: temp1)
					)
				)
			)
		)
		(for ((= temp1 1)) (<= temp1 4) ((++ temp1))
			(for ((= temp2 0)) (< temp2 13) ((++ temp2))
				(if
					(and
						[local54 temp1]
						(==
							0
							(switch temp1
								(1 [global162 temp2])
								(2 [global162 temp2])
								(3 [global162 temp2])
								(4 [global162 temp2])
							)
						)
					)
					(-= [local54 temp1] (- temp2 [local54 temp1]))
					(= temp2 13)
				)
			)
		)
		(if
			(and
				(not temp17)
				(not temp18)
				(!= trumps 5)
				(or
					(and (!= local41 local42) (!= trumps 1))
					(and (!= local43 local44) (!= trumps 2))
					(and (!= local45 local46) (!= trumps 3))
					(and (!= local47 local48) (!= trumps 4))
				)
			)
			(= [local54 trumps] 0)
		)
		(cond
			(local40)
			(
				(and
					(!= trumps 5)
					(or temp17 temp18)
					temp19
					(>= (Max temp19 temp20) (Max temp17 temp18))
				)
				(= local40 (self checkSplitTops: trumps))
			)
			(
				(and
					temp10
					(= local40 (proc710_0 14 1))
					(== (local40 owner:) curPlyr)
				))
			(
				(and
					temp11
					(= local40 (proc710_0 14 2))
					(== (local40 owner:) curPlyr)
				))
			(
				(and
					temp12
					(= local40 (proc710_0 14 3))
					(== (local40 owner:) curPlyr)
				))
			(
				(and
					temp13
					(= local40 (proc710_0 14 4))
					(== (local40 owner:) curPlyr)
				))
			((and temp10 (proc710_0 7 1) (or (!= trumps 1) temp17 temp18))
				(= local40 (self checkSplitTops: 1))
			)
			((and temp11 (proc710_0 7 2) (or (!= trumps 2) temp17 temp18))
				(= local40 (self checkSplitTops: 2))
			)
			((and temp12 (proc710_0 7 3) (or (!= trumps 3) temp17 temp18))
				(= local40 (self checkSplitTops: 3))
			)
			((and temp13 (proc710_0 7 4) (or (!= trumps 4) temp17 temp18))
				(= local40 (self checkSplitTops: 4))
			)
			((and temp10 (proc710_0 4 1) (or (!= trumps 1) temp17 temp18))
				(= local40 (self checkSplitTops: 1))
			)
			((and temp11 (proc710_0 4 2) (or (!= trumps 2) temp17 temp18))
				(= local40 (self checkSplitTops: 2))
			)
			((and temp12 (proc710_0 4 3) (or (!= trumps 1) temp17 temp18))
				(= local40 (self checkSplitTops: 3))
			)
			((and temp13 (proc710_0 4 4) (or (!= trumps 4) temp17 temp18))
				(= local40 (self checkSplitTops: 4))
			)
			(
				(and
					temp10
					(== curPlyr global429)
					(>= [local49 1] 11)
					(or (!= trumps 1) temp17 temp18)
				)
				(= local40 (self bottomCard: 1))
			)
			(
				(and
					temp11
					(== curPlyr global429)
					(>= [local49 2] 11)
					(or (!= trumps 2) temp17 temp18)
				)
				(= local40 (self bottomCard: 2))
			)
			(
				(and
					temp12
					(== curPlyr global429)
					(>= [local49 3] 11)
					(or (!= trumps 3) temp17 temp18)
				)
				(= local40 (self bottomCard: 3))
			)
			(
				(and
					temp13
					(== curPlyr global429)
					(>= [local49 4] 11)
					(or (!= trumps 4) temp17 temp18)
				)
				(= local40 (self bottomCard: 4))
			)
			(
				(and
					temp10
					(== curPlyr global431)
					(<= [local49 1] 15)
					(or (!= trumps 1) temp17 temp18)
				)
				(= local40 (self bottomCard: 1))
			)
			(
				(and
					temp11
					(== curPlyr global431)
					(<= [local49 2] 15)
					(or (!= trumps 2) temp17 temp18)
				)
				(= local40 (self bottomCard: 2))
			)
			(
				(and
					temp12
					(== curPlyr global431)
					(<= [local49 3] 15)
					(or (!= trumps 3) temp17 temp18)
				)
				(= local40 (self bottomCard: 3))
			)
			(
				(and
					temp13
					(== curPlyr global431)
					(<= [local49 4] 15)
					(or (!= trumps 4) temp17 temp18)
				)
				(= local40 (self bottomCard: 4))
			)
			(
				(and
					temp10
					(>= [local54 1] [local54 2])
					(>= [local54 1] [local54 3])
					(>= [local54 1] [local54 4])
					(> [local54 1] 0)
					(or (!= trumps 1) temp17 temp18)
				)
				(= local40 (self checkSplitTops: 1))
			)
			(
				(and
					temp11
					(>= [local54 2] [local54 1])
					(>= [local54 2] [local54 3])
					(>= [local54 2] [local54 4])
					(> [local54 2] 0)
					(or (!= trumps 2) temp17 temp18)
				)
				(= local40 (self checkSplitTops: 2))
			)
			(
				(and
					temp12
					(>= [local54 3] [local54 2])
					(>= [local54 3] [local54 1])
					(>= [local54 3] [local54 4])
					(> [local54 3] 0)
					(or (!= trumps 3) temp17 temp18)
				)
				(= local40 (self checkSplitTops: 3))
			)
			(
				(and
					temp13
					(>= [local54 4] [local54 2])
					(>= [local54 4] [local54 3])
					(>= [local54 4] [local54 1])
					(> [local54 4] 0)
					(or (!= trumps 4) temp17 temp18)
				)
				(= local40 (self checkSplitTops: 4))
			)
			(
				(and
					temp10
					(>= [local54 1] [local54 2])
					(>= [local54 1] [local54 3])
					(>= [local54 1] [local54 4])
				)
				(= local40 (self checkSplitTops: 1))
			)
			(
				(and
					temp11
					(>= [local54 2] [local54 1])
					(>= [local54 2] [local54 3])
					(>= [local54 2] [local54 4])
				)
				(= local40 (self checkSplitTops: 2))
			)
			(
				(and
					temp12
					(>= [local54 3] [local54 2])
					(>= [local54 3] [local54 1])
					(>= [local54 3] [local54 4])
				)
				(= local40 (self checkSplitTops: 3))
			)
			(
				(and
					temp13
					(>= [local54 4] [local54 2])
					(>= [local54 4] [local54 3])
					(>= [local54 4] [local54 1])
				)
				(= local40 (self checkSplitTops: 4))
			)
			((and temp10 (or (!= trumps 1) temp17 temp18))
				(= local40 (self checkSplitTops: 1))
			)
			((and temp11 (or (!= trumps 2) temp17 temp18))
				(= local40 (self checkSplitTops: 2))
			)
			((and temp12 (or (!= trumps 3) temp17 temp18))
				(= local40 (self checkSplitTops: 3))
			)
			((and temp13 (or (!= trumps 4) temp17 temp18))
				(= local40 (self checkSplitTops: 4))
			)
			(temp10
				(= local40 (self checkSplitTops: 1))
			)
			(temp11
				(= local40 (self checkSplitTops: 2))
			)
			(temp12
				(= local40 (self checkSplitTops: 3))
			)
			(temp13
				(= local40 (self checkSplitTops: 4))
			)
		)
		(self verifiedCard: local40)
	)

	(method (checkCashTop &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= local41 (= local43 (= local45 (= local47 0))))
		(= local42 (= local44 (= local46 (= local48 0))))
		(for ((= temp1 1)) (<= temp1 4) ((++ temp1))
			(= temp0 0)
			(= temp4 0)
			(= temp5 0)
			(while (< temp0 13)
				(cond
					(
						(or
							(>
								(= temp2
									(switch temp1
										(1 [global162 temp0])
										(2 [global149 temp0])
										(3 [global136 temp0])
										(4 [global123 temp0])
									)
								)
								2
							)
							(not temp2)
						)
						(= temp0 13)
					)
					((== temp2 1)
						(switch temp1
							(1
								(++ local41)
							)
							(2
								(++ local43)
							)
							(3
								(++ local45)
							)
							(4
								(++ local47)
							)
						)
					)
					(else
						(switch temp1
							(1
								(++ local42)
							)
							(2
								(++ local44)
							)
							(3
								(++ local46)
							)
							(4
								(++ local48)
							)
						)
					)
				)
				(++ temp0)
			)
		)
		(= temp4 (+ local41 local43 local45 local47))
		(= temp5 (+ local42 local44 local46 local48))
		(if (= local40 (self checkOneNoRun:))
			(return)
		)
	)

	(method (checkOneNoRun param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(if (== curPlyr global431)
			(= temp4 (+ local42 local44 local46 local48))
		else
			(= temp4 (+ local41 local43 local45 local47))
		)
		(for ((= temp1 0)) (< temp1 4) ((++ temp1))
			(= temp0 1)
			(= local39 0)
			(while (<= temp0 4)
				(switch temp0
					(1
						(if (== curPlyr global431)
							(= temp2 local42)
							(= temp3 local41)
						else
							(= temp2 local41)
							(= temp3 local42)
						)
					)
					(2
						(if (== curPlyr global431)
							(= temp2 local44)
							(= temp3 local43)
						else
							(= temp2 local43)
							(= temp3 local44)
						)
					)
					(3
						(if (== curPlyr global431)
							(= temp2 local46)
							(= temp3 local45)
						else
							(= temp2 local45)
							(= temp3 local46)
						)
					)
					(4
						(if (== curPlyr global431)
							(= temp2 local48)
							(= temp3 local47)
						else
							(= temp2 local47)
							(= temp3 local48)
						)
					)
				)
				(= local40 0)
				(cond
					(
						(and
							(== param1 0)
							(== temp2 temp4)
							(not (pard countSuit: temp0))
						)
						(= local40 (self topCard: temp0))
						(= temp0 4)
						(= temp1 4)
					)
					(
						(and
							(== param1 1)
							(or
								(and temp2 (not temp3))
								(and
									temp3
									(not temp2)
									(curPlyr countSuit: temp0)
								)
							)
							(>= temp2 ((global429 LHO:) countSuit: temp0))
							(>= temp2 ((global429 RHO:) countSuit: temp0))
						)
						(= local40 (self topCard: temp0))
						(= temp0 4)
						(= temp1 4)
					)
					(
						(and
							(== param1 2)
							temp2
							temp3
							(>= temp2 ((global429 LHO:) countSuit: temp0))
							(>= temp2 ((global429 RHO:) countSuit: temp0))
						)
						(= local40 (self topCard: temp0))
						(= temp0 4)
						(= temp1 4)
					)
					((and (== param1 3) temp2 temp3)
						(= local40 (self bottomCard: temp0))
						(= temp0 4)
						(= temp1 4)
					)
					(
						(or
							(and (> temp2 1) (not temp3))
							(and (> temp3 1) (not temp2))
						)
						(if temp2
							(= local40 (self topCard: temp0))
						else
							(= local40 (self bottomCard: temp0))
						)
						(= temp0 4)
						(= temp1 4)
					)
					((or temp2 temp3)
						(if temp2
							(= local40 (self topCard: temp0))
						else
							(= local40 (self bottomCard: temp0))
						)
						(= temp0 4)
						(= temp1 4)
					)
					(else
						(= local40 0)
					)
				)
				(++ temp0)
			)
		)
		(return local40)
	)
)

