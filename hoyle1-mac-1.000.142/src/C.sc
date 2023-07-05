;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 105)
(include sci.sh)
(use Main)
(use room5)
(use n203)
(use n213)

(class C of c
	(properties
		points1 0
		points2 0
	)

	(method (update)
		(if erase
			(proc0_2 161 2 0 x y)
		else
			(proc0_2
				(if faceUp
					(+ 152 cardSuit)
				else
					(+ 290 global507)
				)
				loop
				(if faceUp cardRank else 0)
				x
				y
			)
		)
	)
)

(class CribbageComputerPlayer of Player
	(properties
		altrEgoX 0
		altrEgoY 0
		points 0
		bestCribCard1 0
		bestCribCard2 0
		opponentLowest 1
		encourageScoring 0
	)

	(method (init)
		(super init:)
		(altrEgo preInit: self)
		((= cardList (CardList new:)) add:)
		((= tempList (WL new:)) add:)
	)

	(method (strategy &tmp temp0)
		(= temp0 (proc213_0 self))
		(DisposeScript 213)
		(return temp0)
	)

	(procedure (localproc_0 param1 param2)
		(if (and (param2 rating:) (== (param2 cardRank:) param1))
			(param2 rating: 2)
			(return 1)
		)
		(return 0)
	)

	(method (findPrecedence &tmp temp0 temp1 temp2)
		(= temp2 4)
		(= temp0 0)
		(while (> temp2 0)
			(for ((= temp1 0)) (< temp1 (cardList size:)) ((++ temp1))
				(if (localproc_0 temp2 (cardList at: temp1))
					(++ temp0)
					(break 2)
				)
			)
			(-- temp2)
		)
		(if (not temp0)
			(for ((= temp2 8)) (> temp2 4) ((-- temp2))
				(for ((= temp1 0)) (< temp1 (cardList size:)) ((++ temp1))
					(if (localproc_0 temp2 (cardList at: temp1))
						(break 2)
					)
				)
			)
		)
	)

	(method (test2 param1 param2 &tmp temp0 temp1 temp2)
		(= temp1 (cardList at: param1))
		(= temp2 (cardList at: param2))
		(if
			(<=
				(+ (global390 count:) (self value: temp1) (self value: temp2))
				31
			)
			(global390 add: temp1)
			(if (= temp0 (global390 testPoints: temp2))
				(temp1 rating: (+ (temp1 rating:) temp0))
				(temp2 rating: (+ (temp2 rating:) temp0))
			)
			(global390 delete: temp1)
		)
	)

	(method (conditionsOK param1 param2 &tmp temp0 temp1)
		(= temp0 (global390 numActiveCards:))
		(= temp1 ((global390 at: (- (global390 size:) 1)) cardRank:))
		(return
			(and
				(>= temp0 2)
				(<= (+ param1 param2) 31)
				(!= param2 temp1)
				(>= param2 (- temp1 temp0))
				(<= param2 (+ temp1 temp0))
				(or (<= param2 6) (<= param2 (+ temp1 2)))
			)
		)
	)

	(method (clearRatings param1)
		(cardList eachElementDo: #rating (if argc param1 else 0))
	)

	(method (takeTurn)
		(proc0_8)
		(= global180 0)
		(= global184 playerNum)
		(switch (gCardRoom state:)
			(6
				(self chooseCardsForCrib:)
			)
			(8
				(gGame setCursor: 997)
				(cond
					((cardList size:)
						(proc0_1 (* global407 6))
						(if (> (+ (global390 count:) (self lowestRank:)) 31)
							(if (global390 go:)
								(if (== (global390 playerWhoGaveGo:) gPlayer0)
									(global390 giveAGo: self)
									(altrEgo say: 1017 0 0)
								)
							else
								(global390 giveAGo: self)
								(altrEgo say: 1003 0 0)
								(gGame setCursor: 999)
								(return)
							)
						else
							((= global173 (self strategy:)) erase: 1)
							(self clearRatings: removeCard: playCard:)
							(gGame setCursor: 999)
							(return)
						)
					)
					((== (global390 playerWhoGaveGo:) gPlayer0)
						(global390 giveAGo: self)
					)
				)
				(gGame setCursor: 999)
				(gCardRoom cue:)
			)
		)
	)

	(method (chooseCardsForCrib &tmp temp0)
		(self findCribCards:)
		(bestCribCard1 loop: 1)
		(bestCribCard2 loop: 1)
		(self reDrawHand:)
		(proc0_5)
		(proc0_1 (* global407 6))
		((ScriptID 206) init: self) ; cribToss
	)

	(method (value param1 &tmp temp0)
		(if
			(>
				(= temp0
					(if (IsObject param1)
						(param1 cardRank:)
					else
						param1
					)
				)
				10
			)
			(= temp0 10)
		)
		(return temp0)
	)

	(method (setRanks param1 &tmp temp0 temp1)
		(for ((= temp0 1)) (< temp0 14) ((++ temp0))
			(= [global390 temp0] 0)
			(for ((= temp1 0)) (< temp1 (param1 size:)) ((++ temp1))
				(+= [global390 temp0] (== ((param1 at: temp1) cardRank:) temp0))
			)
		)
	)

	(method (endHand)
		(cardList
			addAllToWorkingDeck:
			eachElementDo: #erase 1
			eachElementDo: #faceUp 0
			eachElementDo: #loop 0
			eachElementDo: #update
			empty: cardList
		)
	)

	(method (lowestRank &tmp temp0)
		(self setRanks: cardList)
		(for ((= temp0 1)) (< temp0 14) ((++ temp0))
			(if [global390 temp0]
				(self value: temp0)
				(return)
			)
		)
	)

	(method (playCard)
		(gSndEffect number: (proc0_6 playCardSound) playMaybe:)
		((proc5_3)
			init:
				(global173 x:)
				(global173 y:)
				(global390 nextX:)
				(global390 nextY: self)
				[global417 (- global406 1)]
				global390
				2
		)
	)

	(method (findADimCard &tmp temp0)
		(for ((= temp0 0)) (< temp0 (cardList size:)) ((++ temp0))
			(if ((cardList at: temp0) loop:)
				(cardList at: temp0)
				(return)
			)
		)
	)

	(method (takeCard)
		(= global184 playerNum)
		(self setBase:)
		(= global176 dealFaceUp)
		(gDeck getCard:)
		(global173 faceUp: dealFaceUp)
		(gSndEffect number: (proc0_6 takeCardSound) playMaybe:)
		((proc5_5)
			init:
				(gDeck dealX:)
				(gDeck dealY:)
				bX
				bY
				[global408 (- global405 1)]
		)
	)

	(method (cribCardPoints param1 param2)
		(return
			(if
				(or
					(== (param1 cardRank:) (param2 cardRank:))
					(== (+ (self value: param1) (self value: param2)) 15)
				)
				(if (!= (gPlayerList at: 0) self) -2 else 2)
			else
				0
			)
		)
	)

	(method (findCribCards)
		(proc203_0 self)
		(DisposeScript 203)
	)
)

