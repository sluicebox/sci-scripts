;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 733)
(include sci.sh)
(use Main)
(use BridgeStrategyPlay)
(use SortArray)
(use Discard)

(local
	local0
	local1
	local2
	local3
)

(class Declarer_Second_NT of BridgeStrategyPlay
	(properties)

	(method (think param1 &tmp [temp0 5] temp5 [temp6 9] temp15)
		(= local1 0)
		(= temp5 (gTrick tricksPlayed:))
		(= theSuitLead (gTrick suitLead:))
		(= trumps (gTrick trump:))
		(= local2 (- (+ global434 6) global433))
		(= local3 (- (- 7 global434) (- temp5 global433)))
		(self setCurPlyr:)
		(= temp15
			(switch (curPlyr location:)
				(3 global195)
				(4 global196)
				(1 global197)
				(2 global198)
			)
		)
		(cond
			((not (= local1 (curPlyr countSuit: theSuitLead)))
				(if
					(or
						(== trumps 5)
						(not (curPlyr countSuit: trumps))
						(self partnerGotAce:)
					)
					(= local1 (Discard think:))
				else
					(= local1 (self bottomCard: trumps))
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
			)
		)
		(if (not local1)
			(self makePlan: 0)
		)
		(if (and (not plan) (not local1))
			(self makePlan: 1)
		)
		(cond
			(local1)
			(
				(and
					(= local1 (self checkHoldUp: param1 theSuitLead))
					(= local1 (self bottomCard: theSuitLead))
				))
			((and (== temp15 2) (= local1 (self winCheap: theSuitLead))))
			((== plan 1)
				(= local1 (self checkSplitTops: theSuitLead))
			)
			((== plan 31)
				(= local1 (self bottomCard: 1))
			)
			((== plan 32)
				(= local1 (self bottomCard: 2))
			)
			((== plan 33)
				(= local1 (self bottomCard: 3))
			)
			((== plan 34)
				(= local1 (self bottomCard: 4))
			)
			((and (== plan 2) (== theSuitLead 1))
				(= local1 (self checkSplitTops: 1))
			)
			((and (== plan 3) (== theSuitLead 2))
				(= local1 (self checkSplitTops: 2))
			)
			((and (== plan 4) (== theSuitLead 3))
				(= local1 (self checkSplitTops: 3))
			)
			((and (== plan 5) (== theSuitLead 4))
				(= local1 (self checkSplitTops: 4))
			)
			((and (== plan 6) (== theSuitLead 1))
				(= local1 (self checkSplitTops: 1))
			)
			((and (== plan 7) (== theSuitLead 2))
				(= local1 (self checkSplitTops: 2))
			)
			((and (== plan 8) (== theSuitLead 3))
				(= local1 (self checkSplitTops: 3))
			)
			((and (== plan 9) (== theSuitLead 4))
				(= local1 (self checkSplitTops: 4))
			)
			((and (== plan 10) (== theSuitLead 1))
				(= local1 (self checkFinCard: 1))
			)
			((and (== plan 11) (== theSuitLead 2))
				(= local1 (self checkFinCard: 2))
			)
			((and (== plan 12) (== theSuitLead 3))
				(= local1 (self checkFinCard: 3))
			)
			((and (== plan 13) (== theSuitLead 4))
				(= local1 (self checkFinCard: 4))
			)
			((and (== plan 14) (== theSuitLead 1))
				(= local1 (self checkFinCard: 1))
			)
			((and (== plan 15) (== theSuitLead 2))
				(= local1 (self checkFinCard: 2))
			)
			((and (== plan 16) (== theSuitLead 3))
				(= local1 (self checkFinCard: 3))
			)
			((and (== plan 17) (== theSuitLead 4))
				(= local1 (self checkFinCard: 4))
			)
			(
				(and
					(if (== curPlyr global429)
						(< 0 (proc710_0 12 theSuitLead) 15)
					else
						(> (proc710_0 12 theSuitLead) 11)
					)
					(= local1 (self checkFinCard: theSuitLead))
					(or
						(pard
							hasCard: theSuitLead (| (gTrick highCard:) $0f00)
						)
						local3
						(>
							((self checkFinCard: theSuitLead) rank:)
							(gTrick highOfSuitLead:)
						)
					)
				))
			(
				(and
					(self haveIGotAce:)
					(or
						(not (pard countSuit: theSuitLead))
						(not
							(pard
								hasCard:
									theSuitLead
									(| (gTrick highOfSuitLead:) $0f00)
							)
						)
					)
				)
				(= local1 (self topCard: theSuitLead))
			)
		)
		(if
			(and
				(curPlyr countSuit: theSuitLead)
				(or
					(not local1)
					(not (IsObject local1))
					(!= (local1 suit:) theSuitLead)
				)
			)
			(= local1 (self checkSplitTops: theSuitLead))
		)
		(if
			(and
				local1
				(IsObject local1)
				(pard countSuit: theSuitLead)
				(curPlyr countSuit: theSuitLead)
				(self pardMustCover: local1)
			)
			(= local1 (self bottomCard: theSuitLead))
		)
		(self verifiedCard: local1)
	)

	(method (pardMustCover param1 &tmp temp0 temp1 temp2)
		(= temp2 1)
		(for ((= temp0 0)) (< temp0 (pard size:)) ((++ temp0))
			(= temp1 (pard at: temp0))
			(if
				(and
					(== (temp1 suit:) theSuitLead)
					(>
						(-
							(SortArray isCurrent: temp1)
							(SortArray isCurrent: param1)
						)
						1
					)
				)
				(= temp2 0)
			)
		)
		(return temp2)
	)

	(method (haveIGotAce &tmp temp0)
		(if (== curPlyr global429)
			(= temp0 1)
		else
			(= temp0 2)
		)
		(if
			(==
				temp0
				(switch theSuitLead
					(1 [global162 0])
					(2 [global149 0])
					(3 [global136 0])
					(4 [global123 0])
				)
			)
			(return 1)
		else
			(return 0)
		)
	)

	(method (partnerGotAce &tmp temp0)
		(if (== curPlyr global429)
			(= temp0 2)
		else
			(= temp0 1)
		)
		(if
			(==
				temp0
				(switch theSuitLead
					(1 [global162 0])
					(2 [global149 0])
					(3 [global136 0])
					(4 [global123 0])
				)
			)
			(= temp0 1)
		else
			(= temp0 0)
		)
		(return temp0)
	)
)

