;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 735)
(include sci.sh)
(use Main)
(use BridgeStrategyPlay)
(use n726)
(use Discard)

(local
	local0
	local1
)

(class Declarer_Fourth_NT of BridgeStrategyPlay
	(properties)

	(method (think param1 &tmp temp0 temp1 temp2 [temp3 2] temp5 temp6 temp7 [temp8 9])
		(= local1 0)
		(= temp5 (gTrick tricksPlayed:))
		(= theSuitLead (gTrick suitLead:))
		(= trumps (gTrick trump:))
		(self setCurPlyr:)
		(cond
			((not (= local1 (curPlyr countSuit: theSuitLead)))
				(cond
					(
						(or
							(== trumps 5)
							(not (curPlyr countSuit: trumps))
							(== (gTrick highPlayer:) pard)
						)
						(= local1 (Discard think:))
						(proc726_0)
					)
					((not (gTrick highTrump:))
						(= local1 (self bottomCard: trumps))
					)
					(else
						(= local1
							(self trumpCheap: trumps (gTrick highTrump:))
						)
					)
				)
			)
			(
				(or
					(== local1 1)
					(not
						(curPlyr
							hasCard:
								theSuitLead
								(| (gTrick highOfSuitLead:) $0f00)
						)
					)
				)
				(= local1 (self bottomCard: theSuitLead))
			)
			(else
				(= local1 0)
				(= temp6 (- (+ global434 6) global433))
				(= temp1 (- global433 temp5))
				(= temp7 (- (= temp2 (- 7 global434)) temp1))
				(= temp7 (- (- 7 global434) (- temp5 global433)))
				(self makePlan: 0)
			)
		)
		(cond
			(local1)
			((and (== plan 31) (== theSuitLead 1))
				(= local1 (self winCheap: 1))
				(self setPlan: 22)
			)
			((and (== plan 32) (== theSuitLead 2))
				(= local1 (self winCheap: 2))
				(self setPlan: 22)
			)
			((and (== plan 33) (== theSuitLead 3))
				(= local1 (self winCheap: 3))
				(self setPlan: 22)
			)
			((and (== plan 34) (== theSuitLead 4))
				(= local1 (self winCheap: 4))
				(self setPlan: 22)
			)
			((== (gTrick highPlayer:) pard)
				(= local1 (self bottomCard: theSuitLead))
			)
			(
				(and
					(or (== trumps 5) (not (pard countSuit: trumps)))
					(= local1 (self checkHoldUp: param1 theSuitLead))
				)
				(= local1 (self bottomCard: theSuitLead))
			)
			(else
				(= local1 (self winCheap: theSuitLead))
			)
		)
		(if
			(and
				(curPlyr countSuit: theSuitLead)
				(or (not local1) (!= (local1 suit:) theSuitLead))
			)
			(= local1 (self checkSplitTops: theSuitLead))
		)
		(if (not local1)
			(= local1 (self checkSplitTops: theSuitLead))
		)
		(self verifiedCard: local1)
	)

	(method (trumpCheap &tmp temp0 temp1 temp2 temp3 temp4)
		(if (not (= temp3 (gTrick highTrump:)))
			(self bottomCard: trumps)
			(return)
		)
		(= temp0 0)
		(= temp2 99)
		(while (< temp0 (curPlyr size:))
			(= temp1 (curPlyr at: temp0))
			(if (and (== (temp1 suit:) trumps) (> temp2 (temp1 rank:) temp3))
				(= temp4 temp0)
				(= temp2 (temp1 rank:))
			)
			(++ temp0)
		)
		(if (!= temp2 99)
			(curPlyr at: temp4)
			(return)
		else
			(Discard think:)
			(return)
		)
	)

	(method (winCheap param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp2 (gTrick highOfSuitLead:))
		(= temp0 0)
		(= temp4 99)
		(while (< temp0 (curPlyr size:))
			(= temp1 (curPlyr at: temp0))
			(if (and (== (temp1 suit:) param1) (> temp4 (temp1 rank:) temp2))
				(= temp3 temp0)
				(= temp4 (temp1 rank:))
			)
			(++ temp0)
		)
		(if (!= temp4 99)
			(curPlyr at: temp3)
			(return)
		else
			(self bottomCard: param1)
			(return)
		)
	)
)

