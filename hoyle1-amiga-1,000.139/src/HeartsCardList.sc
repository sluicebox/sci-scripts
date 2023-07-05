;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 103)
(include sci.sh)
(use Main)
(use room3)
(use n013)
(use n014)
(use n015)
(use n016)
(use n017)
(use n018)
(use n019)

(procedure (localproc_0 param1 param2 &tmp temp0)
	(for ((= temp0 0)) (< temp0 (param2 size:)) ((++ temp0))
		(if (== param1 (param2 at: temp0))
			(return param1)
		)
	)
	(= global771 global100)
	(cond
		(global276
			(for ((= temp0 0)) (< temp0 (param2 size:)) ((++ temp0))
				(if (== ((param2 at: temp0) cardSuit:) global170)
					(return (param2 at: temp0))
				)
			)
			(return (param2 at: 0))
		)
		(global773
			(return (param2 at: 0))
		)
		(else
			(for ((= temp0 0)) (< temp0 (param2 size:)) ((++ temp0))
				(if (!= ((param2 at: temp0) cardSuit:) 3)
					(return (param2 at: temp0))
				)
			)
		)
	)
	(return (param2 at: 0))
)

(class HeartsCardList of CardList
	(properties)

	(method (atRank param1)
		((self at: param1) cardRank:)
	)

	(method (atSuit param1)
		((self at: param1) cardSuit:)
	)

	(method (howManyOfSuit param1 &tmp temp0 temp1)
		(for ((= temp0 (= temp1 0))) (< temp0 size) ((++ temp0))
			(if (== (self atSuit: temp0) param1)
				(++ temp1)
			)
		)
		(return temp1)
	)

	(method (howManyOfRank param1 &tmp temp0 temp1)
		(for ((= temp0 (= temp1 0))) (< temp0 size) ((++ temp0))
			(if (== (self atRank: temp0) param1)
				(++ temp1)
			)
		)
		(return temp1)
	)

	(method (makeSuitList param1 &tmp temp0 temp1 temp2 temp3)
		((= temp3 (HeartsCardList new:)) add:)
		(for ((= temp2 2)) (< temp2 15) ((++ temp2))
			(if (== (= temp0 temp2) 14)
				(= temp0 1)
			)
			(for ((= temp1 0)) (< temp1 (self size:)) ((++ temp1))
				(if
					(and
						(== (self atRank: temp1) temp0)
						(== (self atSuit: temp1) param1)
					)
					(temp3 add: (self at: temp1))
					(break)
				)
			)
		)
		(= global307 (- (= global306 (temp3 size:)) 1))
		(return temp3)
	)

	(method (adjustList param1 param2)
		(if (not param1)
			(self addToFront: (self at: (- param2 1)))
		else
			(self addAfter: (self at: (- param1 1)) (self at: (- param2 1)))
		)
		(self
			delete:
				(self
					at:
						(if (< param1 param2)
							param2
						else
							(- param2 1)
						)
				)
		)
	)

	(method (hasCard param1 param2 &tmp temp0)
		(for ((= temp0 0)) (< temp0 (self size:)) ((++ temp0))
			(if
				(and
					(== ((self at: temp0) cardRank:) param1)
					(== ((self at: temp0) cardSuit:) param2)
				)
				(return temp0)
			)
		)
		(return -1)
	)
)

(class HeartsComputerPlayer of Player
	(properties
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
		lowSpades 0
		outOfSpades 0
		outOfClubs 0
		outOfDiamonds 0
		outOfHearts 0
		card1 -1
		card2 -1
		card3 -1
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
		showAtX 0
		showAtY 0
		altrEgoX 0
		altrEgoY 0
	)

	(method (setTakeAllPlayer &tmp temp0 temp1 temp2)
		(if (not sittingOut)
			(= global859 self)
			(proc17_2 0)
			(proc17_2 1)
			(proc17_2 2)
			(proc17_2 3)
			(if (proc17_0)
				(= takeAllPlayer self)
			else
				(= temp1 0)
				(if (gPlayer0 handPoints:)
					(++ temp1)
				)
				(if (gPlayer1 handPoints:)
					(++ temp1)
				)
				(if (gPlayer2 handPoints:)
					(++ temp1)
				)
				(if (gPlayer3 handPoints:)
					(++ temp1)
				)
				(if (> temp1 1)
					(= obvious 0)
				)
				(if (not obvious)
					(= takeAllPlayer (proc17_1))
				)
			)
			(DisposeScript 17)
			(switch skill
				(0
					(= takeAllPlayer 0)
				)
				(1
					(if (== takeAllPlayer self)
						(= takeAllPlayer 0)
					)
				)
			)
		)
	)

	(method (init)
		(super init:)
		(if (not sittingOut)
			((= cardList (HeartsCardList new:)) add:)
			((= tempList (HeartsCardList new:)) add:)
			(= skill ((self altrEgo:) heartsSkill:))
		)
	)

	(method (getSuitList param1)
		(= global310
			(switch param1
				(0 spadesList)
				(1 clubsList)
				(2 diamondsList)
				(3 heartsList)
			)
		)
		(= global307 (- (= global306 (global310 size:)) 1))
	)

	(method (playerOutOf param1 param2)
		(proc3_1 param2)
		(if (and (!= global270 self) global270)
			(global270 outOf: param1)
		)
	)

	(method (outOf param1)
		(if
			(switch param1
				(0 outOfSpades)
				(1 outOfClubs)
				(2 outOfDiamonds)
				(3 outOfHearts)
			)
			(return 1)
		else
			(return 0)
		)
	)

	(method (howManyHigher param1 param2 &tmp temp0 temp1 temp2)
		(= temp2 0)
		(if (== (= temp0 (+ param2 1)) 2)
			(= temp0 15)
		)
		(while (< temp0 15)
			(if (== (= temp1 temp0) 14)
				(= temp1 1)
			)
			(if (not (gDeck playedCard: temp1 param1))
				(++ temp2)
			)
			(++ temp0)
		)
		(return temp2)
	)

	(method (howManyLower param1 param2 &tmp temp0 temp1 temp2)
		(= temp1 0)
		(if (== param2 2)
			(return 0)
		)
		(for
			((= temp0
				(= temp2
					(if (== param2 1)
						13
					else
						(- param2 1)
					)
				)
			))
			(> temp0 1)
			((-- temp0))
			
			(if (not (gDeck playedCard: temp0 param1))
				(++ temp1)
			)
		)
		(if (and (== global448 3) (== param1 2))
			(-- temp1)
		)
		(return temp1)
	)

	(method (howManyHigherInHand param1 param2 &tmp temp0 temp1 temp2)
		(if (== param2 1)
			(return 0)
		)
		(self getSuitList: param1)
		(for ((= temp0 (= temp1 0))) (< temp0 global306) ((++ temp0))
			(if (== (= temp2 (global310 atRank: temp0)) 1)
				(= temp2 14)
			)
			(if (> temp2 param2)
				(++ temp1)
			)
		)
		(return temp1)
	)

	(method (showPoints param1)
		(if (not sittingOut)
			(gCommon showPoints: self param1)
		)
	)

	(method (addPoints)
		(+= gamePoints handPoints)
		(= handPoints 0)
	)

	(method (choosePassCards)
		(if sittingOut
			(gCardRoom cue:)
			(return)
		)
		(gGame setCursor: 997)
		(= global184 playerNum)
		(self makeLists:)
		(self pick3Cards:)
		(self disposeSuitLists:)
		(gCardRoom cue:)
	)

	(method (passCards)
		(gCommon passCards: self)
	)

	(method (adjustHand)
		(if sittingOut
			(return)
		)
		(self rePosition:)
	)

	(method (makeLists)
		(= spadesList (cardList makeSuitList: 0))
		(= clubsList (cardList makeSuitList: 1))
		(= diamondsList (cardList makeSuitList: 2))
		(= heartsList (cardList makeSuitList: 3))
	)

	(method (disposeSuitLists)
		(spadesList empty: dispose:)
		(clubsList empty: dispose:)
		(diamondsList empty: dispose:)
		(heartsList empty: dispose:)
	)

	(method (takeTurn &tmp temp0)
		(if sittingOut
			(gCardRoom cue:)
			(return)
		)
		(= global775 skill)
		(gGame setCursor: 997)
		(proc0_8)
		(= global448 (gCardRoom numActivePlayers:))
		(= global184 playerNum)
		(self makeLists:)
		(= lowSpades
			(- (- (- (spadesList size:) aceSpades) kingSpades) queenSpades)
		)
		(if (== global170 -1)
			(= global866 playerNum)
			(self playCard: (self thinkLead:))
		else
			(self playCard: (self thinkFollow:))
		)
	)

	(method (playCard param1 &tmp temp0 temp1 temp2)
		(= temp0 (param1 cardRank:))
		(if (== (= temp1 (param1 cardSuit:)) 3)
			(++ global169)
			(++ global449)
			(if (== temp0 1)
				(= [global250 0] -1)
			else
				(= [global250 temp0] -1)
			)
			(cond
				(
					(or
						(and (!= global170 3) (!= global170 -1))
						(and (== global170 3) (!= global172 playerNum))
					)
					(switch (Random 0 2)
						(0
							((self altrEgo:) sly: 1)
						)
						(1
							((self altrEgo:) smirk: 1)
						)
					)
				)
				(
					(and
						(!= takeAllPlayer self)
						(> global276 1)
						(== global170 3)
						(== global172 playerNum)
					)
					(switch (Random 0 4)
						(0
							((self altrEgo:) anger: 1)
						)
						(1
							((self altrEgo:) upset: 1)
						)
					)
				)
			)
		)
		(if (== temp1 0)
			(switch temp0
				(12
					(gIntroSong number: (Random 32 35) play:)
					(if (and (!= global172 playerNum) (not takeAllPlayer))
						(switch (Random 0 2)
							(0
								((self altrEgo:) sly: 1)
							)
							(1
								((self altrEgo:) bigSmile: 1)
							)
							(else
								((self altrEgo:) smile: 1)
							)
						)
					)
					(+= global169 13)
					(+= global449 13)
					(= global265 1)
					(= [global250 1] -1)
					(= queenSpades 0)
				)
				(13
					(= kingSpades 0)
				)
				(1
					(= aceSpades 0)
				)
			)
		)
		(if (!= temp1 global170)
			(switch global170
				(0
					(= outOfSpades 1)
				)
				(1
					(= outOfClubs 1)
				)
				(2
					(= outOfDiamonds 1)
				)
				(3
					(= outOfHearts 1)
				)
			)
		)
		(+= [global441 temp1] 1)
		(if (not global276)
			(proc18_0 self)
			(DisposeScript 18)
		)
		((gDeck workingDeck:) add: param1)
		(self disposeSuitLists:)
		(super playCard: param1)
	)

	(method (thinkFollow &tmp temp0 temp1)
		(proc16_0 self)
		(DisposeScript 16)
		(= temp1 (proc13_0 self))
		(= temp1 (localproc_0 temp1 cardList))
		(= global861 0)
		(DisposeScript 13)
		(if
			(and
				(or (> (temp1 cardRank:) global171) (== (temp1 cardRank:) 1))
				(== (temp1 cardSuit:) global170)
			)
			(if (== (= global171 (temp1 cardRank:)) 1)
				(= global171 14)
			)
			(= global172 playerNum)
		)
		(return temp1)
	)

	(method (thinkLead &tmp temp0 temp1)
		(= global172 playerNum)
		(if (!= global274 -1)
			(= global170 1)
			(= global171 2)
			(return global274)
		)
		(= temp1 (self getLeadCard:))
		(= temp1 (localproc_0 temp1 cardList))
		(= global861 0)
		(= global170 (temp1 cardSuit:))
		(if (== (= global171 (temp1 cardRank:)) 1)
			(= global171 14)
		)
		(return temp1)
	)

	(method (getLeadCard &tmp temp0)
		(proc19_0 self)
		(DisposeScript 19)
		(= temp0 (proc15_0 self))
		(DisposeScript 15)
		(return temp0)
	)

	(method (pick3Cards)
		(self countCards:)
		(proc14_0 self)
		(DisposeScript 14)
		(self eraseHand:)
		((cardList at: (- card1 1)) loop: 1)
		((cardList at: (- card2 1)) loop: 1)
		((cardList at: (- card3 1)) loop: 1)
		(self reDrawHand:)
		(gCommon playerToPassTo: self)
	)

	(method (countCards)
		(if sittingOut
			(return)
		)
		(for
			((= global264
				(= clubRankAve
					(= diamondRankAve
						(= queenSpades (= kingSpades (= aceSpades 0)))
					)
				)
			))
			(< global264 (cardList size:))
			((++ global264))
			
			(switch (cardList atSuit: global264)
				(0
					(switch (cardList atRank: global264)
						(12
							(++ queenSpades)
						)
						(13
							(++ kingSpades)
						)
						(1
							(++ aceSpades)
						)
					)
				)
				(1
					(+= clubRankAve (cardList atRank: global264))
					(if (== (cardList atRank: global264) 1)
						(+= clubRankAve 13)
					)
				)
				(2
					(+= diamondRankAve (cardList atRank: global264))
					(if (== (cardList atRank: global264) 1)
						(+= diamondRankAve 13)
					)
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

	(method (takeCard)
		(if sittingOut
			(gCardRoom cue:)
			(return)
		)
		(self setBase:)
		(= global176 dealFaceUp)
		(gDeck getCard:)
		(global173 faceUp: dealFaceUp)
		(gSndEffect number: (proc0_6 takeCardSound) playMaybe:)
		(gTheCardToss
			init:
				(gDeck dealX:)
				(gDeck dealY:)
				bX
				bY
				[global408 (- global405 1)]
		)
	)

	(method (find2Clubs)
		(if sittingOut
			(return)
		)
		(if (!= global274 -1)
			(return)
		)
		(for ((= global264 0)) (< global264 (cardList size:)) ((++ global264))
			(if
				(and
					(== (cardList atRank: global264) 2)
					(== (cardList atSuit: global264) 1)
				)
				(= global274 (cardList at: global264))
				(gCardRoom whoPlaysFirst: playerNum)
			)
		)
	)

	(method (mvCard)
		(if (!= global274 -1)
			(gTwoOfClubsLeads doit: 0)
		)
		(= place 97)
		(++ global276)
		(gSndEffect number: (proc0_6 playCardSound) playMaybe:)
		(gTheCardToss
			init: tmpx tmpy discardX discardY [global417 (- global406 1)]
		)
	)

	(method (eraseLosers param1 param2)
		(gCommon eraseLosers: self param1 param2 discardX discardY)
	)

	(method (eraseWinner param1 param2)
		(proc0_2 161 2 0 discardX discardY)
		(= global184 4)
		(gSndEffect number: (proc0_6 playCardSound) playMaybe:)
		(gTheCardToss
			init: discardX discardY param1 param2 [global417 (- global406 1)]
		)
	)

	(method (add26 param1)
		(if (and (not sittingOut) (!= (param1 playerNum:) playerNum))
			(= handPoints 26)
			(self addPoints:)
		else
			(= handPoints 0)
		)
	)
)

