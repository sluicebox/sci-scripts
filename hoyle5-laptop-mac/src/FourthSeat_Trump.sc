;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 751)
(include sci.sh)
(use Main)
(use BridgeDefense)
(use Discard)
(use FourthSeat_NoTrump)

(class FourthSeat_Trump of BridgeDefense
	(properties)

	(method (think &tmp temp0)
		(super think:)
		(= temp0 (gTrick highPlayer:))
		(cond
			((curPlyr countSuit: (gTrick suitLead:))
				(= theCard (FourthSeat_NoTrump think:))
			)
			(
				(or
					(not (curPlyr countSuit: trumps))
					(and
						(gTrick highTrump:)
						(!= trumps (gTrick suitLead:))
						(not
							(curPlyr
								hasCard: trumps (| (gTrick highTrump:) $0f00)
							)
						)
					)
				)
				(= theCard (Discard think:))
			)
			(
				(and
					(gTrick highTrump:)
					(!= temp0 pard)
					(curPlyr countSuit: trumps)
					(self getNextHigherCard: trumps (gTrick highTrump:))
				))
			(
				(and
					(not (gTrick highTrump:))
					(!= temp0 pard)
					(curPlyr countSuit: trumps)
				)
				(self play: trumps)
			)
			(else
				(= theCard (Discard think:))
			)
		)
		(self verifiedCard: theCard)
	)

	(method (getNextHigherCard param1 param2 &tmp temp0 temp1 temp2 temp3)
		(= temp1 20)
		(for ((= temp0 0)) (< temp0 (curPlyr size:)) ((++ temp0))
			(= temp3 (curPlyr at: temp0))
			(if
				(and
					(== (temp3 suit:) param1)
					(> (temp3 rank:) param2)
					(< (temp3 rank:) temp1)
				)
				(= temp1 (temp3 rank:))
				(= theCard temp3)
			)
		)
		(return (if (!= temp1 20) temp1 else 0))
	)
)

