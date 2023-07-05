;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 756)
(include sci.sh)
(use Main)
(use BridgeDefense)
(use Discard)
(use System)

(class FourthSeat_NoTrump of BridgeDefense
	(properties)

	(method (think &tmp [temp0 2] temp2 temp3 temp4 temp5)
		(super think:)
		(= temp5
			(- (- 14 (- (gTrick tricksPlayed:) global433)) (+ global434 6))
		)
		(= temp2 (gTrick suitLead:))
		(cond
			((not (= temp4 (curPlyr countSuit: temp2)))
				(= theCard (Discard think:))
			)
			(
				(or
					(== temp4 1)
					(not
						(curPlyr
							hasCard: temp2 (| (gTrick highOfSuitLead:) $0f00)
						)
					)
				)
				(self play: temp2)
			)
			((== ((gTrick highCard:) owner:) pard)
				(cond
					(
						(and
							(>= (self checkTopTricks:) temp5)
							(or (not (gTrick highTrump:)) (== temp2 trumps))
							(!= temp2 (gTrick trump:))
						)
						(= theCard
							(self
								getNextHigherCard:
									((gTrick highCard:) suit:)
									((gTrick highCard:) rank:)
							)
						)
					)
					(
						(and
							(or (not (gTrick highTrump:)) (== temp2 trumps))
							(or
								(and
									(== temp2 4)
									(>=
										(curPlyr topSp:)
										(Max
											(global429 spades:)
											(global431 spades:)
										)
									)
								)
								(and
									(== temp2 3)
									(>=
										(curPlyr topHt:)
										(Max
											(global429 hearts:)
											(global431 hearts:)
										)
									)
								)
								(and
									(== temp2 2)
									(>=
										(curPlyr topDi:)
										(Max
											(global429 diamonds:)
											(global431 diamonds:)
										)
									)
								)
								(and
									(== temp2 1)
									(>=
										(curPlyr topCl:)
										(Max
											(global429 clubs:)
											(global431 clubs:)
										)
									)
								)
							)
						)
						(self
							getNextHigherCard:
								((gTrick highCard:) suit:)
								((gTrick highCard:) rank:)
						)
					)
					(else
						(self play: temp2)
					)
				)
			)
			(
				(and
					(or (not (gTrick highTrump:)) (== trumps 5))
					(self getNextHigherCard: temp2 (gTrick highOfSuitLead:))
				))
			(
				(and
					(== trumps temp2)
					(self getNextHigherCard: temp2 (gTrick highTrump:))
				))
			(else
				(self play: temp2)
			)
		)
		(if (and temp4 (or (not theCard) (!= (theCard suit:) temp2)))
			(self play: temp2)
		)
		(self verifiedCard: theCard)
	)

	(method (getNextHigherCard param1 param2 &tmp temp0 temp1 temp2)
		(= temp1 20)
		(for ((= temp0 0)) (< temp0 (curPlyr size:)) ((++ temp0))
			(= temp2 (curPlyr at: temp0))
			(if
				(and
					(== (temp2 suit:) param1)
					(> (temp2 rank:) param2)
					(< (temp2 rank:) temp1)
				)
				(= temp1 (temp2 rank:))
				(= theCard temp2)
			)
		)
		(return (if (!= temp1 20) theCard else 0))
	)

	(method (getSide param1 param2 &tmp temp0)
		(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
			(if
				(and
					(!= temp0 (gTrick suitLead:))
					(>= (Eval curPlyr param1 temp0) param2)
				)
				(return temp0)
			)
		)
		(return -1)
	)

	(method (returnSuit param1)
		(return
			(switch param1
				(1 1)
				(0 4)
				(3 3)
				(2 2)
			)
		)
	)
)

