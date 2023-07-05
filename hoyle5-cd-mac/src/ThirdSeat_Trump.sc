;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 750)
(include sci.sh)
(use Main)
(use SortArray)
(use BridgeDefense)
(use Discard)
(use SecondSeat_Trump)
(use ThirdSeat_NoTrump)
(use System)

(class ThirdSeat_Trump of BridgeDefense
	(properties)

	(method (think &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 [temp7 13] temp20)
		(super think: &rest)
		(= temp5 (gTrick suitLead:))
		(for ((= temp0 0)) (< temp0 13) ((++ temp0))
			(= [temp7 temp0]
				(switch trumps
					(1 [global162 temp0])
					(2 [global149 temp0])
					(3 [global136 temp0])
					(4 [global123 temp0])
				)
			)
		)
		(= temp20
			(switch trumps
				(1
					(curPlyr clubs:)
				)
				(2
					(curPlyr diamonds:)
				)
				(3
					(curPlyr hearts:)
				)
				(4
					(curPlyr spades:)
				)
			)
		)
		(if (== LHO global429)
			(= temp4 4)
		else
			(= temp4 3)
		)
		(cond
			((curPlyr countSuit: temp5)
				(= theCard (ThirdSeat_NoTrump think: curPlyr))
			)
			(
				(or
					(not temp20)
					(and
						(gTrick highTrump:)
						(!= trumps temp5)
						(or
							(== (gTrick highPlayer:) pard)
							(not
								(curPlyr
									hasCard:
										trumps
										(| (gTrick highTrump:) $0f00)
								)
							)
						)
					)
					(and
						(or
							(== LHO global431)
							(== skill 2)
							(and
								(== skill 1)
								(> (gTrick highOfSuitLead:) 11)
							)
						)
						(== (gTrick highPlayer:) pard)
						(!= trumps temp5)
						(or
							(and
								(not
									(LHO
										hasCard:
											temp5
											(|
												(gTrick highOfSuitLead:)
												$0f00
											)
									)
								)
								(LHO countSuit: temp5)
							)
							(and
								(not (LHO countSuit: temp5))
								(LHO countSuit: trumps)
								(>
									(self highestTrump: LHO)
									(self highestTrump: curPlyr)
								)
							)
						)
					)
				)
				(= theCard (Discard think:))
			)
			(
				(and
					(= temp1 (self highestTrump: curPlyr))
					(OneOf temp1 12 11 10)
					(= temp2 (self origNumOfTrump: curPlyr))
					(== (+ (- 12 temp1) 3) temp2)
					(not (self playedTrump: curPlyr))
					(not (self partnerPlayedTrumpHigher: curPlyr))
				)
				(if
					(or
						(not (SortArray isCurrent: (gTrick highCard:)))
						(and
							(== LHO global431)
							(==
								(global431 calcHonors:)
								(global431 countSuit: temp5)
							)
						)
					)
					(if
						(or
							(and
								(== LHO global431)
								(not (global431 countSuit: temp5))
							)
							(and
								(== LHO global429)
								(not (global429 countSuit: temp5))
								(global429 countSuit: trumps)
								(pard
									hasCard:
										temp5
										(| ((gTrick highCard:) rank:) $0f00)
								)
							)
						)
						(if
							(or
								(and
									(= temp3 (self highestTrump: curPlyr))
									(not
										(global431
											hasCard: trumps (| temp3 $0f00)
										)
									)
									(= temp3 12)
								)
								(and
									(self gotSequence: curPlyr trumps 0 3)
									(= temp3 9)
								)
								(and
									(self gotSequence: curPlyr trumps 0 2)
									(not
										(self gotSequence: global431 trumps 0 2)
									)
									(= temp3 10)
								)
								(and
									(self gotSequence: curPlyr trumps 0 1)
									(not
										(self gotSequence: global431 trumps 0 1)
									)
									(= temp3 11)
								)
							)
							(self play: trumps temp3)
						else
							(= theCard (Discard think:))
						)
					else
						(self winCheap: trumps)
					)
				else
					(self winCheap: trumps)
				)
			)
			(
				(or
					(and
						(== LHO global431)
						(not (global431 countSuit: temp5))
						(global431 countSuit: trumps)
					)
					(and
						(== LHO global429)
						(not (global429 countSuit: temp5))
						(global429 countSuit: trumps)
						(or
							(== pard (gTrick highPlayer:))
							(gTrick highTrump:)
						)
					)
				)
				(cond
					((not (self beatTheirBest: LHO trumps))
						(= theCard (Discard think:))
					)
					(
						(and
							(not
								(or
									(and (== temp20 1) (== [temp7 0] temp4))
									(and
										(== temp20 2)
										(== [temp7 1] temp4)
										(!= [temp7 0] temp4)
									)
									(and
										(== temp20 3)
										(== [temp7 2] temp4)
										(!= [temp7 1] temp4)
										(!= [temp7 0] temp4)
									)
									(and
										(== temp20 4)
										(== [temp7 3] temp4)
										(!= [temp7 0] temp4)
										(!= [temp7 1] temp4)
										(!= [temp7 2] temp4)
									)
								)
							)
							(= theCard (self beatTheirBest: LHO trumps))
						))
					(else
						(= theCard (Discard think:))
					)
				)
			)
			(else
				(self winCheap: trumps)
			)
		)
		(if
			(and
				(curPlyr countSuit: temp5)
				(or (not theCard) (!= (theCard suit:) temp5))
			)
			(self play: temp5)
		)
		(= temp1 (self verifiedCard: theCard))
	)

	(method (highestTrump param1 &tmp temp0 temp1 temp2)
		(= temp1 0)
		(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
			(if
				(and
					(= temp2 (param1 at: temp0))
					(== (temp2 suit:) trumps)
					(> (temp2 rank:) temp1)
				)
				(= temp1 (temp2 rank:))
			)
		)
		(return temp1)
	)

	(method (origNumOfTrump param1 &tmp temp0 temp1)
		(= temp1 0)
		(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
			(if (== ((param1 at: temp0) suit:) trumps)
				(++ temp1)
			)
		)
		(for ((= temp0 0)) (< temp0 ((param1 playedList:) size:)) ((++ temp0))
			(if (== (((param1 playedList:) at: temp0) suit:) trumps)
				(++ temp1)
			)
		)
	)

	(method (playedTrump param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 ((param1 playedList:) size:)) ((++ temp0))
			(if (== (((param1 playedList:) at: temp0) suit:) trumps)
				(return 1)
			)
		)
		(return 0)
	)

	(method (partnerPlayedTrumpHigher param1 &tmp temp0 temp1 temp2 temp3)
		(= temp2 (param1 partner:))
		(SecondSeat_Trump play: (gTrick trump:) 12)
		(= temp1 (SecondSeat_Trump theCard:))
		(SecondSeat_Trump theCard: 0)
		(for ((= temp0 0)) (< temp0 (temp2 size:)) ((++ temp0))
			(= temp3 (temp2 at: temp0))
			(if (and (== (temp3 suit:) trumps) (> (temp3 rank:) temp1))
				(return 1)
			)
		)
		(return 0)
	)
)

