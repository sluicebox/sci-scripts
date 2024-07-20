;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 749)
(include sci.sh)
(use Main)
(use BridgeDefense)
(use Discard)
(use SecondSeat_NoTrump)

(class SecondSeat_Trump of BridgeDefense
	(properties)

	(method (think &tmp temp0 temp1 temp2 temp3 temp4 [temp5 13] temp18)
		(super think: &rest)
		(= temp2 (gTrick suitLead:))
		(for ((= temp0 0)) (< temp0 13) ((++ temp0))
			(= [temp5 temp0]
				(switch trumps
					(1 [global162 temp0])
					(2 [global149 temp0])
					(3 [global136 temp0])
					(4 [global123 temp0])
				)
			)
		)
		(= temp18
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
			((curPlyr countSuit: temp2)
				(= theCard (SecondSeat_NoTrump think: curPlyr))
			)
			((not (curPlyr countSuit: trumps))
				(= theCard (Discard think:))
			)
			((LHO countSuit: temp2)
				(self play: trumps)
			)
			(
				(or
					(and
						(== LHO global431)
						(not (global431 countSuit: temp2))
						(global431 countSuit: trumps)
					)
					(and
						(== LHO global429)
						(not (global429 countSuit: temp2))
						(global429 countSuit: trumps)
						((curPlyr partner:)
							hasCard:
								temp2
								(| ((gTrick highCard:) rank:) $0f00)
						)
					)
				)
				(cond
					(0 1)
					(
						(and
							(not
								(or
									(and (== temp18 1) (== [temp5 0] temp4))
									(and
										(== temp18 2)
										(== [temp5 1] temp4)
										(!= [temp5 0] temp4)
									)
									(and
										(== temp18 3)
										(== [temp5 2] temp4)
										(!= [temp5 1] temp4)
										(!= [temp5 0] temp4)
									)
									(and
										(== temp18 4)
										(== [temp5 3] temp4)
										(!= [temp5 0] temp4)
										(!= [temp5 1] temp4)
										(!= [temp5 2] temp4)
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
			(
				(and
					(> (curPlyr size:) temp18)
					(or
						(and (== temp18 1) (== [temp5 0] temp4))
						(and
							(== temp18 2)
							(== [temp5 1] temp4)
							(!= [temp5 0] temp4)
						)
						(and
							(== temp18 3)
							(== [temp5 2] temp4)
							(!= [temp5 1] temp4)
							(!= [temp5 0] temp4)
						)
						(and
							(== temp18 4)
							(== [temp5 3] temp4)
							(!= [temp5 0] temp4)
							(!= [temp5 1] temp4)
							(!= [temp5 2] temp4)
						)
						(not (self beatTheirBest: LHO trumps))
					)
				)
				(= theCard (Discard think:))
			)
			(else
				(self play: trumps)
			)
		)
		(self verifiedCard: theCard)
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

	(method (highestTrump param1 &tmp temp0 temp1 temp2)
		(= temp1 0)
		(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
			(= temp2 (param1 at: temp0))
			(if (and (== (temp2 suit:) trumps) (> (temp2 rank:) temp1))
				(= temp1 (temp2 rank:))
			)
		)
		(if (> argc 1)
			(for
				((= temp0 0))
				(< temp0 ((param1 playedList:) size:))
				((++ temp0))
				
				(= temp2 ((param1 playedList:) at: temp0))
				(if (and (== (temp2 suit:) trumps) (> (temp2 rank:) temp1))
					(= temp1 (temp2 rank:))
				)
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
)

