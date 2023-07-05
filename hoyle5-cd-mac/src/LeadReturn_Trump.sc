;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 747)
(include sci.sh)
(use Main)
(use n726)
(use BridgeDefense)
(use bidBoxWindow)
(use LeadReturn_NoTrump)
(use System)

(public
	LeadReturn_Trump 0
)

(local
	[local0 6]
	local6
	local7
	local8
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

(procedure (localproc_1 param1 param2)
	(return
		(switch local8
			(1
				(not
					(or
						(param1 hasCard: param2 14)
						(param1 hasCard: param2 13)
						(param1 hasCard: param2 12)
					)
				)
			)
			(2
				(not
					(or (param1 hasCard: param2 12) (param1 hasCard: param2 13))
				)
			)
			(3
				(not (param1 hasCard: param2 12))
			)
		)
	)
)

(procedure (localproc_2 param1 param2 &tmp temp0) ; UNUSED
	(= temp0 (if (> argc 2) [param2 1] else 5))
	(return (- (param1 countSuit: param2) (param1 calcHonors: param2 temp0)))
)

(procedure (localproc_3 param1 param2 param3 &tmp temp0 temp1) ; UNUSED
	(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
		(= temp1 (param1 at: temp0))
		(if (and (== (temp1 suit:) param2) (== (temp1 rank:) param3))
			(return temp1)
		)
	)
)

(procedure (localproc_4 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3) ; UNUSED
	(LeadReturn_Trump play: param2 12)
	(= temp1 (LeadReturn_Trump theCard:))
	(LeadReturn_Trump play: param2 11)
	(= temp2 (LeadReturn_Trump theCard:))
	(LeadReturn_Trump theCard: 0)
	(return (and (== temp1 param3) (== temp2 param4)))
)

(class LeadReturn_Trump of BridgeDefense
	(properties)

	(method (think &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 [temp13 5])
		(super think: &rest)
		(localproc_0 curPlyr)
		(= temp10 0)
		(= temp2 (if (== LHO global431) global429 else global431))
		(= temp9 (self checkTopTricks:))
		(= temp3 (gTrick tricksPlayed:))
		(= temp11 (self runningSuit: curPlyr))
		(= temp1 (- (- 14 (- temp3 global433)) (+ global434 6)))
		(for ((= temp0 1)) (< temp0 4) ((++ temp0))
			(= [temp13 temp0] (curPlyr countSuit: temp0))
		)
		(= local8 [temp13 trumps])
		(= local6 (global429 countSuit: trumps))
		(= local7 (global431 countSuit: trumps))
		(proc726_0)
		(= temp5 0)
		(if (== global429 LHO)
			(= temp12 4)
		else
			(= temp12 3)
		)
		(switch trumps
			(1
				(= temp4 topCl)
				(= temp7 (Max topDi topHt topSp))
				(= topCl 0)
			)
			(2
				(= temp4 topDi)
				(= temp7 (Max topCl topHt topSp))
				(= topDi 0)
			)
			(3
				(= temp4 topHt)
				(= temp7 (Max topDi topCl topSp))
				(= topHt 0)
			)
			(4
				(= temp4 topSp)
				(= temp7 (Max topDi topHt topCl))
				(= topSp 0)
			)
		)
		(switch temp7
			(topCl
				(= temp8 1)
			)
			(topDi
				(= temp8 2)
			)
			(topHt
				(= temp8 3)
			)
			(topSp
				(= temp8 4)
			)
		)
		(switch trumps
			(1
				(= topCl temp4)
			)
			(2
				(= topDi temp4)
			)
			(3
				(= topHt temp4)
			)
			(4
				(= topSp temp4)
			)
		)
		(cond
			(
				(and
					(not local8)
					(not (global429 countSuit: trumps))
					(not (global431 countSuit: trumps))
					(not (pard countSuit: trumps))
				)
				(= theCard (LeadReturn_NoTrump think: curPlyr))
			)
			(
				(and
					temp4
					(>= temp4 (global429 countSuit: trumps))
					(>= temp4 (global431 countSuit: trumps))
					(>= temp9 temp1)
				)
				(self play: trumps 12)
			)
			(
				(and
					(pard countSuit: trumps)
					(or
						(and
							(!= trumps 1)
							(not (pard countSuit: 1))
							(or (LHO countSuit: 1) (temp2 countSuit: 1))
							[temp13 1]
							(= temp10 1)
						)
						(and
							(!= trumps 2)
							(not (pard countSuit: 2))
							(or (LHO countSuit: 2) (temp2 countSuit: 2))
							[temp13 2]
							(= temp10 2)
						)
						(and
							(!= trumps 3)
							(not (pard countSuit: 3))
							(or (LHO countSuit: 3) (temp2 countSuit: 3))
							[temp13 3]
							(= temp10 3)
						)
						(and
							(!= trumps 4)
							(not (pard countSuit: 4))
							(or (LHO countSuit: 4) (temp2 countSuit: 4))
							[temp13 4]
							(= temp10 4)
						)
					)
				)
				(self play: temp10)
			)
			((and (>= temp9 temp1) temp9)
				(if temp4
					(self play: trumps 12)
				else
					(self play: temp8 12)
				)
			)
			((= temp10 (self check805:))
				(self play: temp10 12)
			)
			(
				(or
					(and
						(> [local0 1] 2)
						[temp13 1]
						(or
							(not local6)
							(not local7)
							(global429 clubs:)
							(global431 clubs:)
						)
						(= temp10 1)
						topCl
						(= temp5 12)
					)
					(and
						(> [local0 2] 2)
						[temp13 2]
						(or
							(not local6)
							(not local7)
							(global429 diamonds:)
							(global431 diamonds:)
						)
						(= temp10 2)
						topDi
						(= temp5 12)
					)
					(and
						(> [local0 3] 2)
						[temp13 3]
						(or
							(not local6)
							(not local7)
							(global429 hearts:)
							(global431 hearts:)
						)
						(= temp10 3)
						topHt
						(= temp5 12)
					)
					(and
						(> [local0 4] 2)
						[temp13 4]
						(or
							(not local6)
							(not local7)
							(global429 spades:)
							(global431 spades:)
						)
						(= temp10 4)
						topSp
						(= temp5 12)
					)
				)
				(if (== temp5 12)
					(self play: temp10 12)
				else
					(self play: temp10)
				)
			)
			(
				(and
					local8
					(localproc_1 curPlyr trumps)
					(or
						(and
							(!= trumps 1)
							(> topCl 1)
							(or
								(and
									(not (global429 clubs:))
									(global431 clubs:)
									(== local6 1)
								)
								(and
									(not (global431 clubs:))
									(global429 clubs:)
									(== local7 1)
								)
							)
							(= temp10 1)
						)
						(and
							(!= trumps 2)
							(> topDi 1)
							(or
								(and
									(not (global429 diamonds:))
									(global431 diamonds:)
									(== local6 1)
								)
								(and
									(not (global431 diamonds:))
									(global429 diamonds:)
									(== local7 1)
								)
							)
							(= temp10 2)
						)
						(and
							(!= trumps 3)
							(> topCl 1)
							(or
								(and
									(not (global429 hearts:))
									(global431 hearts:)
									(== local6 1)
								)
								(and
									(not (global431 hearts:))
									(global429 hearts:)
									(== local7 1)
								)
							)
							(= temp10 3)
						)
						(and
							(!= trumps 4)
							(> topCl 1)
							(or
								(and
									(not (global429 spades:))
									(global431 spades:)
									(== local6 1)
								)
								(and
									(not (global431 spades:))
									(global429 spades:)
									(== local7 1)
								)
							)
							(= temp10 4)
						)
					)
				)
				(self play: trumps)
			)
			((= temp10 (self check808:))
				(self play: temp10)
			)
			(0)
			(0)
			((and (== local8 1) (not (pard countSuit: trumps)) local6 local7)
				(self play: trumps)
			)
			(
				(or
					(and
						(> topCl 1)
						(or (> (global429 clubs:) 1) (not local6))
						(or (> (global431 clubs:) 1) (not local7))
						(= temp10 1)
					)
					(and
						(> topDi 1)
						(or (> (global429 diamonds:) 1) (not local6))
						(or (> (global431 diamonds:) 1) (not local7))
						(= temp10 2)
					)
					(and
						(> topHt 1)
						(or (> (global429 hearts:) 1) (not local6))
						(or (> (global431 hearts:) 1) (not local7))
						(= temp10 3)
					)
					(and
						(> topSp 1)
						(or (> (global429 spades:) 1) (not local6))
						(or (> (global431 spades:) 1) (not local7))
						(= temp10 4)
					)
				)
				(self play: temp10 12)
			)
			((= temp10 (self check808: 1))
				(self play: temp10)
			)
			(
				(or
					(and
						(or
							(= temp6 (self gotSequence: curPlyr 1 10 2))
							(= temp6 (self gotSequence: curPlyr 1 0 2))
						)
						(= temp10 1)
					)
					(and
						(or
							(= temp6 (self gotSequence: curPlyr 2 10 2))
							(= temp6 (self gotSequence: curPlyr 2 0 2))
						)
						(= temp10 2)
					)
					(and
						(or
							(= temp6 (self gotSequence: curPlyr 3 10 2))
							(= temp6 (self gotSequence: curPlyr 3 0 2))
						)
						(= temp10 3)
					)
					(and
						(or
							(= temp6 (self gotSequence: curPlyr 4 10 2))
							(= temp6 (self gotSequence: curPlyr 4 0 2))
						)
						(= temp10 4)
					)
				)
				(if (== temp6 2)
					(self play: temp10 11)
				else
					(self play: temp10 12)
				)
			)
			(0)
			(0)
			(0)
			(
				(or
					(and
						(== [global162 0] temp12)
						(== [global162 1] temp12)
						(or (LHO clubs:) (temp2 clubs:) (not local7))
						(= temp10 1)
					)
					(and
						(== [global149 0] temp12)
						(== [global149 1] temp12)
						(or (LHO diamonds:) (temp2 diamonds:) (not local7))
						(= temp10 2)
					)
					(and
						(== [global136 0] temp12)
						(== [global136 1] temp12)
						(or (LHO hearts:) (temp2 hearts:) (not local7))
						(= temp10 3)
					)
					(and
						(== [global123 0] temp12)
						(== [global123 1] temp12)
						(or (LHO spades:) (temp2 spades:) (not local7))
						(= temp10 4)
					)
				)
				(self play: temp10 12)
			)
			(
				(or
					(and
						(> [global162 0] 2)
						(> [global162 1] 2)
						(> [global162 2] 2)
						(or
							(= temp5
								(or
									(== [global162 0] temp12)
									(== [global162 1] temp12)
									(== [global162 2] temp12)
								)
							)
							1
						)
						(or (LHO clubs:) (temp2 clubs:) (not local7))
						(= temp10 1)
					)
					(and
						(> [global149 0] 2)
						(> [global149 1] 2)
						(> [global149 2] 2)
						(or
							(= temp5
								(or
									(== [global149 0] temp12)
									(== [global149 1] temp12)
									(== [global149 2] temp12)
								)
							)
							1
						)
						(or (LHO diamonds:) (temp2 diamonds:) (not local7))
						(= temp10 2)
					)
					(and
						(> [global136 0] 2)
						(> [global136 1] 2)
						(> [global136 2] 2)
						(or
							(= temp5
								(or
									(== [global136 0] temp12)
									(== [global136 1] temp12)
									(== [global136 2] temp12)
								)
							)
							1
						)
						(or (LHO hearts:) (temp2 hearts:) (not local7))
						(= temp10 3)
					)
					(and
						(> [global123 0] 2)
						(> [global123 1] 2)
						(> [global123 2] 2)
						(or
							(= temp5
								(or
									(== [global123 0] temp12)
									(== [global123 1] temp12)
									(== [global123 2] temp12)
								)
							)
							1
						)
						(or (LHO spades:) (temp2 spades:) (not local7))
						(= temp10 4)
					)
				)
				(if temp5
					(self play: temp10 12)
				else
					(self play: temp10)
				)
			)
			(
				(or
					(and
						(== [global162 0] temp12)
						(LHO clubs:)
						(temp2 clubs:)
						(= temp10 1)
					)
					(and
						(== [global149 0] temp12)
						(LHO diamonds:)
						(temp2 diamonds:)
						(= temp10 2)
					)
					(and
						(== [global136 0] temp12)
						(LHO hearts:)
						(temp2 hearts:)
						(= temp10 3)
					)
					(and
						(== [global123 0] temp12)
						(LHO spades:)
						(temp2 spades:)
						(= temp10 4)
					)
				)
				(self play: temp10 12)
			)
			(
				(or
					(and
						(> [global162 0] 2)
						(> [global162 1] 2)
						(or (LHO clubs:) (temp2 clubs:) (not local7))
						(or
							(= temp5
								(or
									(== [global162 0] temp12)
									(== [global162 1] temp12)
								)
							)
							1
						)
						(= temp10 1)
					)
					(and
						(> [global149 0] 2)
						(> [global149 1] 2)
						(or (LHO diamonds:) (temp2 diamonds:) (not local7))
						(or
							(= temp5
								(or
									(== [global149 0] temp12)
									(== [global149 1] temp12)
								)
							)
							1
						)
						(= temp10 2)
					)
					(and
						(> [global136 0] 2)
						(> [global136 1] 2)
						(or (LHO hearts:) (temp2 hearts:) (not local7))
						(or
							(= temp5
								(or
									(== [global136 0] temp12)
									(== [global136 1] temp12)
								)
							)
							1
						)
						(= temp10 3)
					)
					(and
						(> [global123 0] 2)
						(> [global123 1] 2)
						(or (LHO spades:) (temp2 spades:) (not local7))
						(or
							(= temp5
								(or
									(== [global123 0] temp12)
									(== [global123 1] temp12)
								)
							)
							1
						)
						(= temp10 4)
					)
				)
				(if temp5
					(self play: temp10 12)
				else
					(self play: temp10)
				)
			)
			((and (== temp2 global431) (= temp10 (self check8021:)))
				(if (pard countSuit: temp10)
					(self play: temp10 11)
				else
					(self play: temp10)
				)
			)
			(
				(or
					(and
						(== [global162 0] 2)
						(!= [global149 0] 2)
						(!= [global136 0] 2)
						(!= [global123 0] 2)
						(or
							(and [temp13 2] (!= trumps 2) (= temp10 2))
							(and [temp13 3] (!= trumps 3) (= temp10 3))
							(and [temp13 4] (!= trumps 4) (= temp10 4))
						)
					)
					(and
						(!= [global162 0] 2)
						(== [global149 0] 2)
						(!= [global136 0] 2)
						(!= [global123 0] 2)
						(or
							(and [temp13 1] (!= trumps 1) (= temp10 1))
							(and [temp13 3] (!= trumps 3) (= temp10 3))
							(and [temp13 4] (!= trumps 4) (= temp10 4))
						)
					)
					(and
						(!= [global162 0] 2)
						(!= [global149 0] 2)
						(== [global136 0] 2)
						(!= [global123 0] 2)
						(or
							(and [temp13 2] (!= trumps 2) (= temp10 2))
							(and [temp13 1] (!= trumps 1) (= temp10 1))
							(and [temp13 4] (!= trumps 4) (= temp10 4))
						)
					)
					(and
						(!= [global162 0] 2)
						(!= [global149 0] 2)
						(!= [global136 0] 2)
						(== [global123 0] 2)
						(or
							(and [temp13 2] (!= trumps 2) (= temp10 2))
							(and [temp13 3] (!= trumps 3) (= temp10 3))
							(and [temp13 1] (!= trumps 1) (= temp10 1))
						)
					)
				)
				(self play: temp10)
			)
			(
				(or
					(and
						[temp13 1]
						(<= 1 [global162 0] 2)
						(<= 1 [global162 1] 2)
						(<= 1 [global162 2] 2)
						(= temp10 1)
					)
					(and
						[temp13 2]
						(<= 1 [global149 0] 2)
						(<= 1 [global149 1] 2)
						(<= 1 [global149 2] 2)
						(= temp10 2)
					)
					(and
						[temp13 3]
						(<= 1 [global136 0] 2)
						(<= 1 [global136 1] 2)
						(<= 1 [global136 2] 2)
						(= temp10 3)
					)
					(and
						[temp13 4]
						(<= 1 [global123 0] 2)
						(<= 1 [global123 1] 2)
						(<= 1 [global123 2] 2)
						(= temp10 4)
					)
				)
				(self play: temp10)
			)
			(
				(or
					(and
						(< (global429 clubs:) 3)
						(< (global431 clubs:) 3)
						[temp13 1]
						(= temp10 1)
					)
					(and
						(< (global429 diamonds:) 3)
						(< (global431 diamonds:) 3)
						[temp13 2]
						(= temp10 2)
					)
					(and
						(< (global429 hearts:) 3)
						(< (global431 hearts:) 3)
						[temp13 3]
						(= temp10 3)
					)
					(and
						(< (global429 spades:) 3)
						(< (global431 spades:) 3)
						[temp13 4]
						(= temp10 4)
					)
				)
				(self play: temp10)
			)
			(else
				(= temp10 (self check8028:))
				(if
					(or
						(= temp6 (self gotSequence: curPlyr temp10 10 2))
						(= temp6 (self gotSequence: curPlyr temp10 0 2))
					)
					(if (== temp6 2)
						(self play: temp10 11)
					else
						(self play: temp10 12)
					)
				else
					(self play: temp10)
				)
			)
		)
		(self verifiedCard: theCard)
	)

	(method (check805 &tmp temp0)
		(= temp0 0)
		(if (>= local8 (- (Max local6 local7) 1))
			(or
				(and
					(!= trumps 1)
					(> topCl 1)
					(or
						(and
							(>= local6 local7)
							(not (global429 clubs:))
							(global431 clubs:)
						)
						(and
							(>= local7 local6)
							(not (global431 clubs:))
							(global429 clubs:)
						)
					)
					(= temp0 1)
				)
				(and
					(!= trumps 2)
					(> topDi 1)
					(or
						(and
							(>= local6 local7)
							(not (global429 diamonds:))
							(global431 diamonds:)
						)
						(and
							(>= local7 local6)
							(not (global431 diamonds:))
							(global429 diamonds:)
						)
					)
					(= temp0 2)
				)
				(and
					(!= trumps 3)
					(> topHt 1)
					(or
						(and
							(>= local6 local7)
							(not (global429 hearts:))
							(global431 hearts:)
						)
						(and
							(>= local7 local6)
							(not (global431 hearts:))
							(global429 hearts:)
						)
					)
					(= temp0 3)
				)
				(and
					(!= trumps 4)
					(> topSp 1)
					(or
						(and
							(>= local6 local7)
							(not (global429 spades:))
							(global431 spades:)
						)
						(and
							(>= local7 local6)
							(not (global431 spades:))
							(global429 spades:)
						)
					)
					(= temp0 4)
				)
			)
		)
		(return temp0)
	)

	(method (check808 param1 &tmp temp0 temp1 temp2)
		(for ((= temp0 0)) (< temp0 ((ScriptID 15 1) size:)) ((++ temp0)) ; discardList
			(= temp1 ((ScriptID 15 1) at: temp0)) ; discardList
			(= temp2 (temp1 suit:))
			(if
				(and
					(== (temp1 whoLedMe:) pard)
					(curPlyr countSuit: temp2)
					(or (pard countSuit: temp2) (pard countSuit: trumps))
					(or
						(global431 countSuit: temp2)
						(not local7)
						(> local7 local6)
					)
					(or
						(global429 countSuit: temp2)
						(not local6)
						(> local6 local7)
						param1
					)
				)
				(= temp1 temp2)
				(= temp0 999)
			)
		)
		(if (!= temp1 temp2)
			(= temp2 0)
		)
		(return temp2)
	)

	(method (check8021 &tmp temp0 temp1 temp2 temp3 temp4 [temp5 13])
		(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
			(for ((= temp1 0)) (< temp1 13) ((++ temp1))
				(= [temp5 temp1]
					(switch temp0
						(1 [global162 temp1])
						(2 [global149 temp1])
						(3 [global136 temp1])
						(4 [global123 temp1])
					)
				)
			)
			(= temp1 0)
			(= temp3 0)
			(= temp4 0)
			(while (< temp1 13)
				(cond
					((== [temp5 temp1] 2)
						(= temp1 13)
						(if (and (> temp3 1) (pard countSuit: temp0))
							(= temp4 temp0)
							(= temp0 4)
						)
					)
					((== [temp5 temp1] 4)
						(++ temp3)
					)
				)
				(++ temp1)
			)
		)
		(return temp4)
	)

	(method (check8028 &tmp temp0 temp1 temp2 [temp3 5] [temp8 5])
		(= [temp3 1] (Max (global429 clubs:) (global431 clubs:)))
		(= [temp3 2] (Max (global429 diamonds:) (global431 diamonds:)))
		(= [temp3 3] (Max (global429 hearts:) (global431 hearts:)))
		(= [temp3 4] (Max (global429 spades:) (global431 spades:)))
		(= [temp8 1] (curPlyr clubs:))
		(= [temp8 2] (curPlyr diamonds:))
		(= [temp8 3] (curPlyr hearts:))
		(= [temp8 4] (curPlyr spades:))
		(= temp1 0)
		(= temp2 13)
		(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
			(if (and [temp8 temp0] (< [temp3 temp0] temp2))
				(= temp2 [temp3 temp0])
				(= temp1 temp0)
			)
		)
		(return temp1)
	)
)

