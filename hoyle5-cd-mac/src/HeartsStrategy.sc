;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 370)
(include sci.sh)
(use Main)
(use Piles)
(use heartsGame)
(use n301)
(use n302)
(use n303)
(use n304)
(use n305)
(use n306)
(use System)

(class HeartsStrategy of Code
	(properties
		skill 0
		takeAllPlayer 0
		suitRating 0
		highestSuitRating 0
		suitToLead 0
		numSpades 0
		numClubs 0
		numDiamonds 0
		numHearts 0
		heartsStrength 0
		spadesStrength 0
		clubsStrength 0
		diamondsStrength 0
		obvious 0
		moonDiscovered 0
		spadeDanger 0
		heartDanger 0
		spadesList 0
		clubsList 0
		diamondsList 0
		heartsList 0
		Card1 -1
		Card2 -1
		Card3 -1
		passToPlayer 0
		queenSpades 0
		kingSpades 0
		aceSpades 0
		clubRankAve 0
		diamondRankAve 0
		numPicks 0
		spadeType 0
		preference -1
		discardX 0
		discardY 0
		handPoints 0
		gamePoints 0
		showAtX 0
		showAtY 0
		altrEgo 0
		altrEgoX 0
		altrEgoY 0
		cardList 0
		lowSpades 0
		westPass1 0
		westPass2 0
		westPass3 0
		northPass1 0
		northPass2 0
		northPass3 0
		eastPass1 0
		eastPass2 0
		eastPass3 0
	)

	(method (thinkPass param1 &tmp temp0 temp1 [temp2 2] temp4 temp5)
		(= cardList param1)
		(= takeAllPlayer (cardList takeAllPlayer:))
		(= Card1 (= Card2 (= Card3 0)))
		(self countCards:)
		(cardList makeLists:)
		(= spadesList (cardList spadesList:))
		(= clubsList (cardList clubsList:))
		(= diamondsList (cardList diamondsList:))
		(= heartsList (cardList heartsList:))
		(proc303_0 self)
		(DisposeScript 303)
		(= temp5 0)
		(while (< (++ temp5) 2)
			(= temp4 0)
			(if (== Card1 Card2)
				(= temp4 1)
			)
			(if (== Card1 Card3)
				(= temp4 3)
			)
			(if (== Card2 Card3)
				(= temp4 2)
			)
			(if temp4
				(for ((= temp1 1)) (<= temp1 (param1 size:)) ((++ temp1))
					(if (not (OneOf temp1 Card1 Card2 Card3))
						(switch temp4
							(1
								(= Card1 temp1)
							)
							(2
								(= Card2 temp1)
							)
							(3
								(= Card3 temp1)
							)
						)
						(break)
					)
				)
			)
		)
		(switch (param1 location:)
			(4
				((param1 passList:)
					add:
						(= westPass1 ((param1 at: (- Card1 1)) hide: yourself:))
						(= westPass2 ((param1 at: (- Card2 1)) hide: yourself:))
						(= westPass3 ((param1 at: (- Card3 1)) hide: yourself:))
				)
			)
			(1
				((param1 passList:)
					add:
						(= northPass1
							((param1 at: (- Card1 1)) hide: yourself:)
						)
						(= northPass2
							((param1 at: (- Card2 1)) hide: yourself:)
						)
						(= northPass3
							((param1 at: (- Card3 1)) hide: yourself:)
						)
				)
			)
			(2
				((param1 passList:)
					add:
						(= eastPass1 ((param1 at: (- Card1 1)) hide: yourself:))
						(= eastPass2 ((param1 at: (- Card2 1)) hide: yourself:))
						(= eastPass3 ((param1 at: (- Card3 1)) hide: yourself:))
				)
			)
		)
		(for ((= temp1 0)) (< temp1 ((param1 passList:) size:)) ((++ temp1))
			(param1 eliminateCard: ((param1 passList:) at: temp1))
		)
	)

	(method (think param1 &tmp [temp0 6])
		(= takeAllPlayer (param1 takeAllPlayer:))
		(= skill [global195 (- (global117 indexOf: (Dealer curPlayer:)) 1)])
		(= cardList param1)
		(self countCards:)
		(cardList makeLists:)
		(= spadesList (cardList spadesList:))
		(= clubsList (cardList clubsList:))
		(= diamondsList (cardList diamondsList:))
		(= heartsList (cardList heartsList:))
		(= global527 4)
		(= lowSpades
			(-
				(- (- ((cardList spadesList:) size:) aceSpades) kingSpades)
				queenSpades
			)
		)
		(if (not (gTrick size:))
			(if global482
				(= global482 0)
				(if (== global233 0)
					(param1 hasCard: 2 1)
					(return)
				)
			)
			(self thinkLead: param1)
			(return)
		else
			(self thinkFollow: param1)
			(return)
		)
	)

	(method (setTakeAllPlayer param1 &tmp temp0 temp1 temp2)
		(= global501 self)
		(= cardList param1)
		(proc306_2 0)
		(proc306_2 1)
		(proc306_2 2)
		(proc306_2 3)
		(if (proc306_0)
			(= takeAllPlayer cardList)
		else
			(= temp1 0)
			(if ((global117 at: 0) tempTotal:)
				(++ temp1)
			)
			(if ((global117 at: 1) tempTotal:)
				(++ temp1)
			)
			(if ((global117 at: 2) tempTotal:)
				(++ temp1)
			)
			(if ((global117 at: 3) tempTotal:)
				(++ temp1)
			)
			(if (> temp1 1)
				(= obvious 0)
			)
			(if (not obvious)
				(= takeAllPlayer (proc306_1))
			)
		)
		(DisposeScript 306)
		(switch [global195 (- (global117 indexOf: cardList) 1)]
			(0
				(= takeAllPlayer 0)
			)
			(1
				(if (== takeAllPlayer cardList)
					(= takeAllPlayer 0)
				)
			)
		)
	)

	(method (thinkLead &tmp temp0 temp1)
		(= temp1 (self getLeadCard:))
		(= global502 0)
		(return temp1)
	)

	(method (thinkFollow &tmp temp0 temp1 temp2)
		(proc305_0 self)
		(DisposeScript 305)
		(= temp1 (proc304_0 self))
		(= global502 0)
		(DisposeScript 304)
		(return temp1)
	)

	(method (getLeadCard &tmp temp0)
		(proc302_0 self)
		(DisposeScript 302)
		(= temp0 (proc301_0 self))
		(DisposeScript 301)
		(return temp0)
	)

	(method (getSuitList param1)
		(= global507
			(switch param1
				(0
					(cardList spadesList:)
				)
				(1
					(cardList clubsList:)
				)
				(2
					(cardList diamondsList:)
				)
				(3
					(cardList heartsList:)
				)
			)
		)
		(= global504 (global507 size:))
		(= global505 (Max 0 (- global504 1)))
	)

	(method (howManyHigher param1 param2 &tmp temp0 temp1)
		(= temp0 (+ param2 1))
		(= temp1 0)
		(while (<= temp0 14)
			(if
				(and
					(not (gTrick playedCard: temp0 param1))
					(not (self beenPlayedBefore: temp0 param1))
				)
				(++ temp1)
			)
			(++ temp0)
		)
		(return temp1)
	)

	(method (howManyLower param1 param2 &tmp temp0 temp1)
		(= temp0 (- param2 1))
		(= temp1 0)
		(while (>= temp0 2)
			(if
				(and
					(not (gTrick playedCard: temp0 param1))
					(not (self beenPlayedBefore: temp0 param1))
				)
				(++ temp1)
			)
			(-- temp0)
		)
		(return temp1)
	)

	(method (beenPlayedBefore param1 param2 &tmp temp0)
		(for ((= temp0 0)) (< temp0 ((ScriptID 15 1) size:)) ((++ temp0)) ; discardList
			(if
				(and
					(== (((ScriptID 15 1) at: temp0) rank:) param1) ; discardList
					(== (((ScriptID 15 1) at: temp0) suit:) param2) ; discardList
				)
				(return 1)
			)
		)
		(return 0)
	)

	(method (howManyHigherInHand param1 param2 &tmp temp0 temp1 temp2)
		(= temp1 0)
		(if (!= param2 14)
			(self getSuitList: param1)
			(for ((= temp0 0)) (< temp0 global504) ((++ temp0))
				(if (> (= temp2 (global507 atRank: temp0)) param2)
					(++ temp1)
				)
			)
		)
		(return temp1)
	)

	(method (countCards &tmp temp0)
		(for
			((= temp0
				(= clubRankAve
					(= diamondRankAve
						(= queenSpades (= kingSpades (= aceSpades 0)))
					)
				)
			))
			(< temp0 (cardList size:))
			((++ temp0))
			
			(switch (cardList atSuit: temp0)
				(0
					(switch (cardList atRank: temp0)
						(12
							(++ queenSpades)
						)
						(13
							(++ kingSpades)
						)
						(14
							(++ aceSpades)
						)
					)
				)
				(1
					(+= clubRankAve (cardList atRank: temp0))
				)
				(2
					(+= diamondRankAve (cardList atRank: temp0))
				)
			)
		)
		(if (cardList howManyOfSuit: 1)
			(/= clubRankAve (cardList howManyOfSuit: 1))
		)
		(if (cardList howManyOfSuit: 2)
			(/= diamondRankAve (cardList howManyOfSuit: 2))
		)
	)

	(method (playerOutOf param1 param2)
		(proc300_2 param2)
		(if (and (!= global520 cardList) global520)
			(global520 outOf: param1)
		)
	)
)

