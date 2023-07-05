;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 730)
(include sci.sh)
(use Main)
(use Piles)
(use n726)
(use System)

(local
	[local0 13]
)

(class BridgeDefense of Code
	(properties
		curPlyr 0
		skill 0
		curPosn 0
		theCard 0
		topCl 0
		topDi 0
		topHt 0
		topSp 0
		trumps 0
		pard 0
		LHO 0
		trickSize 0
		theSuitLead 0
	)

	(method (init &tmp temp0)
		(for ((= temp0 0)) (< temp0 13) ((++ temp0))
			(= [local0 temp0] 0)
		)
		(super init:)
	)

	(method (dispose)
		(super dispose: &rest)
	)

	(method (verifiedCard param1 &tmp temp0)
		(if (not param1)
			(= temp0 (curPlyr at: (Random 0 (- (curPlyr size:) 1))))
		else
			(= temp0 param1)
		)
		(return temp0)
	)

	(method (checkTopTricks &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(= temp3 (= temp0 (= temp1 (= temp2 0))))
		(= trickSize (gTrick size:))
		(= theSuitLead (gTrick suitLead:))
		(= trumps (gTrick trump:))
		(= temp7 (global429 countSuit: trumps))
		(= temp8 (global431 countSuit: trumps))
		(if (== (curPlyr LHO:) global429)
			(= temp9 4)
		else
			(= temp9 3)
		)
		(for ((= temp6 1)) (<= temp6 4) ((++ temp6))
			(for ((= temp5 0)) (< temp5 13) ((++ temp5))
				(switch temp6
					(1
						(if (== [global162 temp5] temp9)
							(++ temp0)
						else
							(= temp5 13)
						)
					)
					(2
						(if (== [global149 temp5] temp9)
							(++ temp1)
						else
							(= temp5 13)
						)
					)
					(3
						(if (== [global136 temp5] temp9)
							(++ temp2)
						else
							(= temp5 13)
						)
					)
					(4
						(if (== [global123 temp5] temp9)
							(++ temp3)
						else
							(= temp5 13)
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
							(curPlyr
								hasCard:
									(gTrick suitLead:)
									(| (gTrick highOfSuitLead:) $0f00)
							)
						)
						(not
							((curPlyr partner:)
								hasCard:
									(gTrick suitLead:)
									(| (gTrick highOfSuitLead:) $0f00)
							)
						)
					)
					(and
						(> trickSize 1)
						(!= ((gTrick highCard:) owner:) curPlyr)
						(!= ((gTrick highCard:) owner:) (curPlyr partner:))
						(not
							(curPlyr
								hasCard:
									(gTrick suitLead:)
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
		(if (<= 1 trumps 4)
			(if
				(or
					(and (not (global429 clubs:)) temp7)
					(and (not (global431 clubs:)) temp8)
				)
				(= temp0 0)
			)
			(if
				(or
					(and (not (global429 diamonds:)) temp7)
					(and (not (global431 diamonds:)) temp8)
				)
				(= temp1 0)
			)
			(if
				(or
					(and (not (global429 hearts:)) temp7)
					(and (not (global431 hearts:)) temp8)
				)
				(= temp2 0)
			)
			(if
				(or
					(and (not (global429 spades:)) temp7)
					(and (not (global431 spades:)) temp8)
				)
				(= temp3 0)
			)
		)
		(if (> temp0 (Max ((curPlyr partner:) clubs:) (curPlyr clubs:)))
			(= temp0 (Max ((curPlyr partner:) clubs:) (curPlyr clubs:)))
		)
		(if
			(>
				temp1
				(Max ((curPlyr partner:) diamonds:) (curPlyr diamonds:))
			)
			(= temp1
				(Max ((curPlyr partner:) diamonds:) (curPlyr diamonds:))
			)
		)
		(if
			(>
				temp2
				(Max ((curPlyr partner:) hearts:) (curPlyr hearts:))
			)
			(= temp2
				(Max ((curPlyr partner:) hearts:) (curPlyr hearts:))
			)
		)
		(if
			(>
				temp3
				(Max ((curPlyr partner:) spades:) (curPlyr spades:))
			)
			(= temp3
				(Max ((curPlyr partner:) spades:) (curPlyr spades:))
			)
		)
		(self topCl: temp0)
		(self topDi: temp1)
		(self topHt: temp2)
		(self topSp: temp3)
		(return (+ temp0 temp1 temp2 temp3))
	)

	(method (runningSuit param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(proc726_0)
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
		(= temp1 1)
		(= temp9 0)
		(while (<= temp1 4)
			(if param2
				(= temp1 param2)
			)
			(for ((= temp0 0)) (< temp0 13) ((++ temp0))
				(if (or (== param1 global429) (== param1 global431))
					(= temp3 (global429 countSuit: temp1))
					(= temp4 (global431 countSuit: temp1))
					(= temp5 ((global429 LHO:) countSuit: temp1))
					(= temp6 ((global429 RHO:) countSuit: temp1))
				else
					(= temp5 (global429 countSuit: temp1))
					(= temp6 (global431 countSuit: temp1))
					(= temp3 ((global429 LHO:) countSuit: temp1))
					(= temp4 ((global429 RHO:) countSuit: temp1))
				)
				(switch temp1
					(4
						(= [local0 temp0] [global123 temp0])
					)
					(1
						(= [local0 temp0] [global162 temp0])
					)
					(2
						(= [local0 temp0] [global149 temp0])
					)
					(3
						(= [local0 temp0] [global136 temp0])
					)
				)
			)
			(cond
				(
					(and
						(or (== [local0 0] temp7) (== [local0 0] temp8))
						(or (== [local0 1] temp7) (== [local0 1] temp8))
						(or (== [local0 2] temp7) (== [local0 2] temp8))
					)
					(if
						(or
							(and
								(> temp6 temp5)
								(or
									(== [local0 1] temp8)
									(== [local0 2] temp8)
									(== [local0 3] temp8)
								)
							)
							(== [local0 1] [local0 2] [local0 3] temp7)
						)
						(= temp9 (self play: temp1 12))
					else
						(= temp9 (self play: temp1))
					)
				)
				(
					(and
						(== [local0 1] temp7)
						(== [local0 2] temp7)
						(< temp3 3)
						(< temp4 3)
						(!= param1 global429)
						(!= param1 global431)
					)
					(if
						(or
							(and
								(> temp6 temp5)
								(or (== [local0 1] temp8) (== [local0 2] temp8))
							)
							(== [local0 1] [local0 2] temp8)
						)
						(= temp9 (self play: temp1 12))
					else
						(= temp9 (self play: temp1))
					)
				)
				((and (== [local0 1] temp7) (< temp3 2) (< temp4 2))
					(if (== [local0 1] temp7)
						(= temp9 (self play: temp1 12))
					else
						(= temp9 (self play: temp1))
					)
				)
			)
			(if param2
				(= temp1 4)
			)
			(++ temp1)
		)
		(return temp9)
	)

	(method (gotSequence param1 param2 param3 param4 &tmp temp0 temp1)
		(= temp0 1)
		(if (< argc 4)
			(= param4 3)
		)
		(if (< argc 3)
			(= param3 14)
		)
		(if (not param3)
			(for ((= param3 11)) (<= param3 14) ((++ param3))
				(for ((= temp1 param3)) (> temp1 (- param3 param4)) ((-- temp1))
					(if (not (param1 hasCard: param2 temp1))
						(= temp0 0)
					)
				)
				(if (and temp0 (param1 hasCard: param2 (| param3 $0f00)))
					(= temp0 2)
				)
				(if temp0
					(= param3 14)
				)
			)
		else
			(for ((= temp1 param3)) (>= temp1 (- param3 param4)) ((-- temp1))
				(if (not (param1 hasCard: param2 temp1))
					(= temp0 0)
				)
			)
			(if (and temp0 (param1 hasCard: param2 (| param3 $0f00)))
				(= temp0 2)
			)
		)
		(return temp0)
	)

	(method (think param1 &tmp temp0 temp1)
		(= curPlyr
			(if argc
				param1
			else
				(Dealer curPlayer:)
			)
		)
		(= skill
			(switch (curPlyr location:)
				(3 global195)
				(4 gSkill)
				(1 global197)
				(2 global198)
			)
		)
		(= theCard 0)
		(= trumps (gTrick trump:))
		(= pard (curPlyr partner:))
		(= LHO (curPlyr LHO:))
		(proc726_0)
		(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
			(switch temp0
				(1
					(= temp1 (global117 atLocation: 3))
				)
				(2
					(= temp1 (global117 atLocation: 4))
				)
				(3
					(= temp1 (global117 atLocation: 1))
				)
				(4
					(= temp1 (global117 atLocation: 2))
				)
			)
			(temp1 clubs: (temp1 countSuit: 1))
			(temp1 diamonds: (temp1 countSuit: 2))
			(temp1 hearts: (temp1 countSuit: 3))
			(temp1 spades: (temp1 countSuit: 4))
		)
	)

	(method (hasCard param1 param2 &tmp temp0 temp1 temp2)
		(= temp1 0)
		(= temp2 (= temp0 0))
		(while (< temp0 (- argc 1))
			(if (curPlyr hasCard: param1 [param2 temp1])
				(++ temp2)
			)
			(if (< temp1 (- argc 2))
				(++ temp1)
			)
			(++ temp0)
		)
		(return temp2)
	)

	(method (beatTheirBest param1 param2 &tmp temp0 temp1 temp2 temp3 temp4)
		(= param2 0)
		(= temp2 50)
		(= temp1 0)
		(if (not param2)
			(= param2 trumps)
		)
		(for ((= temp0 0)) (<= temp0 (param1 size:)) ((++ temp0))
			(if
				(and
					(= temp4 (param1 at: temp0))
					(== param2 (temp4 suit:))
					(> (temp4 rank:) temp1)
				)
				(= temp1 (temp4 rank:))
			)
		)
		(for ((= temp0 0)) (<= temp0 (curPlyr size:)) ((++ temp0))
			(if
				(and
					(= temp4 (curPlyr at: temp0))
					(== param2 (temp4 suit:))
					(< temp1 (temp4 rank:) temp2)
				)
				(= temp2 (temp4 rank:))
				(= temp3 temp0)
			)
		)
		(if temp3
			(= theCard (curPlyr at: temp3))
		else
			(= theCard 0)
		)
		(return theCard)
	)

	(method (play param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(proc726_0)
		(= temp2 (= temp3 (= temp0 (= theCard 0))))
		(= temp1
			(if (>= 8 [param1 temp0] 7)
				(switch [param1 temp0]
					(7
						(curPlyr longSuit:)
					)
					(8
						(curPlyr strongSuit:)
					)
				)
			else
				[param1 temp0]
			)
		)
		(for ((= temp4 0)) (< temp4 (curPlyr size:)) ((++ temp4))
			(if (or (== temp1 6) (== ((curPlyr at: temp4) suit:) temp1))
				(sortedList add: (curPlyr at: temp4))
			)
		)
		(if (sortedList size:)
			(KList 22 (sortedList elements:) 767 0) ; Sort
		)
		(++ temp0)
		(cond
			((< argc temp0)
				(= temp6 0)
			)
			((== 12 [param1 temp0])
				(= temp6 (- (sortedList size:) 1))
			)
			((and (== 9 [param1 temp0]) (> (sortedList size:) 3))
				(= temp6 (- (sortedList size:) 4))
			)
			((and (== 10 [param1 temp0]) (> (sortedList size:) 2))
				(= temp6 (- (sortedList size:) 3))
			)
			((and (== 11 [param1 temp0]) (> (sortedList size:) 1))
				(= temp6 (- (sortedList size:) 2))
			)
			(else
				(= temp6 0)
			)
		)
		(= theCard 0)
		(if (sortedList size:)
			(= theCard (sortedList at: temp6))
			(sortedList release:)
		)
		(sortedList dispose:)
		(if (== temp1 6)
			(= temp7 theCard)
			(= theCard 0)
			(return temp7)
		)
	)

	(method (winCheap param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= LHO (curPlyr LHO:))
		(= temp0 (gTrick highOfSuitLead:))
		(= temp3 (= temp4 0))
		(= temp6 99)
		(for ((= temp1 0)) (< temp1 (LHO size:)) ((++ temp1))
			(= temp2 (LHO at: temp1))
			(if (and (== (temp2 suit:) param1) (> (temp2 rank:) temp0))
				(= temp4 (temp2 rank:))
			)
		)
		(if (> temp4 temp0)
			(= temp0 temp4)
		)
		(if (not (curPlyr hasCard: param1 (| temp0 $0f00)))
			(return 0)
		)
		(if (== trickSize 1)
			(= temp5 (pard hasCard: param1 (| temp0 $0f00)))
		else
			(= temp5 0)
		)
		(if
			(or
				temp4
				(!= (gTrick highPlayer:) pard)
				(and (== trickSize 1) (not temp5))
			)
			(for ((= temp1 0)) (< temp1 (curPlyr size:)) ((++ temp1))
				(= temp2 (curPlyr at: temp1))
				(if
					(and
						(== (temp2 suit:) param1)
						(> temp6 (temp2 rank:) temp0)
					)
					(= temp6 (temp2 rank:))
					(= temp3 temp2)
				)
			)
		)
		(if
			(and
				temp3
				(or
					(and
						(or (== param1 trumps) (== trickSize 1))
						(not (curPlyr hasCard: param1 (| temp0 $0f00)))
					)
					(and (gTrick highTrump:) (!= param1 trumps))
				)
			)
			(= temp3 0)
		)
		(return temp3)
	)
)

(instance workingList of List ; UNUSED
	(properties)
)

(instance sortedList of List
	(properties)
)

(instance descendingCode of Code ; UNUSED
	(properties)

	(method (doit param1)
		(param1 rank:)
	)
)

