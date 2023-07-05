;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 104)
(include sci.sh)
(use Main)
(use room4)
(use Interface)
(use n403)
(use n405)
(use n406)
(use n407)
(use n408)

(local
	local0
	[local1 3]
	[local4 3]
	local7
)

(class g of c
	(properties
		rating 1
		inARun 0
		ofAKind 0
		group 0
		bestGroup 0
		playOff 0
		offRating 0
		defRating 0
		fourOrMoreInGroup 0
	)

	(method (update param1)
		(if (or erase (and (== argc 1) param1))
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

(class GinRummyCardList of CardList
	(properties
		caller 0
		opponent 0
		whoItIs 0
	)

	(method (arrangeGroups param1 &tmp [temp0 4])
		(if argc
			(= caller param1)
		)
		(proc403_0 self caller)
		(DisposeScript 403)
	)

	(procedure (localproc_0 param1 param2 param3 param4 param5)
		(whoItIs setDeadWoodOfAKinds: param1)
		(if (>= argc 3)
			(whoItIs setCardRating: param2 param3)
		)
		(if (>= argc 4)
			(whoItIs setCardRating: param4 param5)
		)
		(whoItIs calcRuns: countDeadWood:)
		(return (not global430))
	)

	(method (findBestGroup &tmp temp0 temp1 temp2 temp3)
		(self clearBestGroup:)
		(= global430 1000)
		(self countDeadWoodRuns:)
		(if (not global430)
			(return global430)
		)
		(= whoItIs self)
		(switch local0
			(1
				(if (== local4 3)
					(if (localproc_0 0)
						(return global430)
					)
				else
					(for ((= temp1 1)) (< temp1 5) ((++ temp1))
						(if (localproc_0 0 temp1 local1)
							(return global430)
						)
					)
					(if (localproc_0 0)
						(return global430)
					)
				)
			)
			(2
				(for ((= temp0 0)) (< temp0 2) ((++ temp0))
					(if (== [local4 temp0] 3)
						(if (localproc_0 [local1 temp0])
							(return global430)
						)
					else
						(for ((= temp1 1)) (< temp1 5) ((++ temp1))
							(if
								(localproc_0
									[local1 temp0]
									temp1
									[local1 temp0]
								)
								(return global430)
							)
						)
						(if (localproc_0 [local1 temp0])
							(return global430)
						)
					)
				)
				(cond
					((== (+ local4 [local4 1]) 7)
						(= temp3 (if (== local4 4) 0 else 1))
						(for ((= temp1 1)) (< temp1 5) ((++ temp1))
							(if (localproc_0 0 temp1 [local1 temp3])
								(return global430)
							)
						)
					)
					((== (+ local4 [local4 1]) 8)
						(for ((= temp1 1)) (< temp1 5) ((++ temp1))
							(for ((= temp2 1)) (< temp2 5) ((++ temp2))
								(if
									(localproc_0
										0
										temp1
										local1
										temp2
										[local1 1]
									)
									(return global430)
								)
							)
						)
						(for ((= temp0 0)) (< temp0 2) ((++ temp0))
							(for ((= temp1 1)) (< temp1 5) ((++ temp1))
								(if (localproc_0 0 temp1 [local1 temp0])
									(return global430)
								)
							)
						)
					)
				)
				(if (localproc_0 0)
					(return global430)
				)
			)
			(3
				(self countDeadWoodOfAKinds: 0)
			)
		)
		(caller bestDeadWood: global430)
		(return global430)
	)

	(method (markRuns &tmp [temp0 4])
		(proc405_0 self)
		(DisposeScript 405)
	)

	(method (findAllOfAKinds &tmp temp0 temp1)
		(= local0 0)
		(for ((= temp0 0)) (< temp0 (- size 2)) ((++ temp0))
			(if
				(and
					(==
						(= temp1 ((self at: temp0) cardRank:))
						((self at: (+ temp0 1)) cardRank:)
					)
					(== temp1 ((self at: (+ temp0 2)) cardRank:))
				)
				((self at: temp0) ofAKind: (+ temp1 100))
				((self at: (+ temp0 1)) ofAKind: (+ temp1 100))
				((self at: (+ temp0 2)) ofAKind: (+ temp1 100))
				(= [local4 local0] 3)
				(if
					(and
						(< temp0 (- size 3))
						(== temp1 ((self at: (+ temp0 3)) cardRank:))
					)
					((self at: (+ temp0 3))
						ofAKind: (+ temp1 100)
						fourOrMoreInGroup: 1
					)
					(++ temp0)
					(= [local4 local0] 4)
				)
				(+= temp0 2)
				(= [local1 local0] temp1)
				(++ local0)
			)
		)
	)

	(method (setGroups &tmp temp0 temp1 temp2 temp3)
		(for ((= temp1 (= temp2 (= temp3 0)))) (< temp1 size) ((++ temp1))
			(= temp0 (self at: temp1))
			(temp0 rating: (not (temp0 group:)))
			(temp0 bestGroup: (temp0 group:))
			(if (and (not (temp0 bestGroup:)) (> (self atValue: temp1) temp2))
				(= temp2 (self atValue: temp1))
				(= temp3 temp0)
			)
		)
		(caller highestDeadWood: temp2 highestDeadWoodCard: temp3)
	)

	(method (setCardRating param1 param2 &tmp temp0 temp1)
		(for ((= temp0 (= temp1 0))) (< temp0 size) ((++ temp0))
			(if (== ((self at: temp0) ofAKind:) (+ param2 100))
				(++ temp1)
				(if (== param1 temp1)
					((self at: temp0) rating: 1 group: 0)
					(return)
				)
			)
		)
	)

	(method (calcRuns &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp3 0)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(= temp2
				(switch temp0
					(0
						(caller spadesList:)
					)
					(1
						(caller clubsList:)
					)
					(2
						(caller diamondsList:)
					)
					(3
						(caller heartsList:)
					)
				)
			)
			(if (>= (temp2 size:) 3)
				(for ((= temp1 0)) (<= temp1 (- (temp2 size:) 3)) ((++ temp1))
					(cond
						(
							(and
								((temp2 at: temp1) rating:)
								((temp2 at: (+ temp1 1)) rating:)
								((temp2 at: (+ temp1 2)) rating:)
								(==
									(temp2 atRank: temp1)
									(- (temp2 atRank: (+ temp1 1)) 1)
								)
								(==
									(temp2 atRank: temp1)
									(- (temp2 atRank: (+ temp1 2)) 2)
								)
							)
							(= temp4 1)
							((temp2 at: temp1) rating: -1)
							((temp2 at: (+ temp1 1)) rating: -1)
							((temp2 at: (+ temp1 2)) rating: -1)
							((temp2 at: temp1)
								group: (+ ((temp2 at: temp1) inARun:) temp3)
							)
							((temp2 at: (+ temp1 1))
								group:
									(+ ((temp2 at: (+ temp1 1)) inARun:) temp3)
							)
							((temp2 at: (+ temp1 2))
								group:
									(+ ((temp2 at: (+ temp1 2)) inARun:) temp3)
							)
						)
						(temp4 ; UNINIT
							(+= temp3 10)
							(= temp4 0)
						)
					)
				)
			)
		)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(if (== ((self at: temp0) rating:) -1)
				((self at: temp0) rating: 0)
			)
		)
	)

	(method (tryToPlayOffCard param1 param2 &tmp temp0 [temp1 2] temp3)
		(if (param2 size:)
			(cond
				((> (= temp0 ((param2 at: 0) group:)) 100)
					(if
						(and
							(== (param1 cardRank:) ((param2 at: 0) cardRank:))
							(not (param1 group:))
						)
						(param1 playOff: param2)
					)
				)
				(
					(and
						temp0
						(== (param1 cardSuit:) ((param2 at: 0) cardSuit:))
						(not (param1 group:))
					)
					(if
						(or
							(==
								(+ (param1 cardRank:) 1)
								((param2 at: 0) cardRank:)
							)
							(==
								(- (param1 cardRank:) 1)
								((param2 at: (- (param2 size:) 1)) cardRank:)
							)
						)
						(param1 playOff: param2)
					)
					(if
						(or
							(and
								(==
									(+ (param1 cardRank:) 2)
									((param2 at: 0) cardRank:)
								)
								(>=
									(= temp3
										(self
											hasCard:
												(+ (param1 cardRank:) 1)
												(param1 cardSuit:)
										)
									)
									0
								)
								(< temp3 size)
								(not ((self at: temp3) group:))
							)
							(and
								(==
									(- (param1 cardRank:) 2)
									((param2 at: (- (param2 size:) 1))
										cardRank:
									)
								)
								(>=
									(= temp3
										(self
											hasCard:
												(- (param1 cardRank:) 1)
												(param1 cardSuit:)
										)
									)
									0
								)
								(< temp3 size)
								(not ((self at: temp3) group:))
							)
						)
						(param1 playOff: param2)
					)
				)
			)
		)
	)

	(method (countDeadWood &tmp temp0 temp1 temp2 temp3)
		(self eachElementDo: #playOff 0)
		(= opponent (if (== caller gPlayer0) gPlayer2 else gPlayer0))
		(= temp2 0)
		(for ((= temp1 0)) (< temp1 size) ((++ temp1))
			(if ((= temp0 (self at: temp1)) rating:)
				(if
					(and
						global426
						(!= global426 caller)
						(global426 bestDeadWood:)
					)
					(temp0 playOff: 0)
					(self
						tryToPlayOffCard: temp0 (opponent group1List:)
						tryToPlayOffCard: temp0 (opponent group2List:)
						tryToPlayOffCard: temp0 (opponent group3List:)
					)
					(if (not (temp0 playOff:))
						(+= temp2 (self atValue: temp1))
					)
				else
					(+= temp2 (self atValue: temp1))
				)
			)
		)
		(if (<= temp2 global430)
			(= global430 temp2)
			(self setGroups:)
		)
	)

	(method (countDeadWoodRuns &tmp temp0 temp1 temp2)
		(self clearGroup:)
		(for ((= temp1 0)) (< temp1 size) ((++ temp1))
			(= temp0 (self at: temp1))
			(temp0 rating: (== (temp0 inARun:) 0) group: (temp0 inARun:))
		)
		(self countDeadWood:)
	)

	(method (countDeadWoodOfAKinds &tmp temp0 temp1 temp2)
		(self clearGroup:)
		(for ((= temp1 0)) (< temp1 size) ((++ temp1))
			(= temp0 (self at: temp1))
			(temp0 rating: (== (temp0 ofAKind:) 0) group: (temp0 ofAKind:))
		)
		(self countDeadWood:)
	)

	(method (setDeadWoodOfAKinds param1 &tmp temp0 temp1 temp2)
		(self clearGroup:)
		(for ((= temp1 0)) (< temp1 size) ((++ temp1))
			((= temp0 (self at: temp1)) rating: 1)
			(cond
				((== param1 0)
					(if (temp0 ofAKind:)
						(temp0 rating: 0 group: (temp0 ofAKind:))
					)
				)
				((== (temp0 ofAKind:) (+ param1 100))
					(temp0 rating: 0 group: ((self at: temp1) ofAKind:))
				)
			)
		)
	)

	(method (atValue param1 &tmp temp0)
		(if (> (= temp0 ((self at: param1) cardRank:)) 10)
			(= temp0 10)
		)
		(return temp0)
	)

	(method (clearMarks)
		(self eachElementDo: #inARun 0)
	)

	(method (clearGroup)
		(self eachElementDo: #group 0 eachElementDo: #playOff 0)
	)

	(method (clearBestGroup)
		(self eachElementDo: #bestGroup 0)
	)

	(method (atRank param1)
		((self at: param1) cardRank:)
	)

	(method (atSuit param1)
		((self at: param1) cardSuit:)
	)

	(method (howManyOfSuit param1 &tmp temp0 temp1)
		(if size
			(for ((= temp0 (= temp1 0))) (< temp0 size) ((++ temp0))
				(if (== (self atSuit: temp0) param1)
					(++ temp1)
				)
			)
			(return temp1)
		)
	)

	(method (howManyOfRank param1 &tmp temp0 temp1)
		(if size
			(for ((= temp0 (= temp1 0))) (< temp0 size) ((++ temp0))
				(if (== (self atRank: temp0) param1)
					(++ temp1)
				)
			)
			(return temp1)
		)
	)

	(method (makeSuitList param1 &tmp temp0 temp1 temp2)
		(= temp2 (GinRummyCardList new:))
		(for ((= temp1 1)) (< temp1 14) ((++ temp1))
			(for ((= temp0 0)) (< temp0 size) ((++ temp0))
				(if
					(and
						(== (self atRank: temp0) temp1)
						(== (self atSuit: temp0) param1)
					)
					(temp2 add: (self at: temp0))
					(break)
				)
			)
		)
		(= global307 (- (= global306 (temp2 size:)) 1))
		(return temp2)
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
		(if (< 0 param1 14)
			(for ((= temp0 0)) (< temp0 size) ((++ temp0))
				(if
					(and
						(== ((self at: temp0) cardRank:) param1)
						(== ((self at: temp0) cardSuit:) param2)
					)
					(return temp0)
				)
			)
		)
		(return -1)
	)
)

(class GinRummyComputerPlayer of Player
	(properties
		altrEgoX 0
		altrEgoY 0
		base1 30
		base2 0
		base3 0
		base1GroupNum 0
		base2GroupNum 0
		base3GroupNum 0
		group1List 0
		group2List 0
		group3List 0
		deadWoodList 0
		spadesList 0
		clubsList 0
		diamondsList 0
		heartsList 0
		bestDeadWood 0
		deadWoodBaseX 270
		deadWoodBaseY 15
		total 0
		handsWon 0
		bonus 0
		highestDeadWood 0
		highestDeadWoodCard 0
		passedOnCard 0
	)

	(method (pickUpCard)
		(= global264 (proc408_0 self local7))
		(DisposeScript 408)
		(return global264)
	)

	(method (calcGroups &tmp temp0 temp1)
		(= temp0 (GinRummyCardList new:))
		(for ((= temp1 0)) (< temp1 (cardList size:)) ((++ temp1))
			(temp0 add: (cardList at: temp1))
		)
		(cardList
			caller: self
			opponent: gPlayer0
			clearMarks:
			clearGroup:
			clearBestGroup:
			eachElementDo: #rating 0
			eachElementDo: #ofAKind 0
			eachElementDo: #fourOrMoreInGroup 0
		)
		(self createSuitLists: sortHandByRank: 1)
		(cardList findAllOfAKinds: markRuns: findBestGroup:)
		(= bestDeadWood global430)
		(self disposeSuitLists: reOrderCardList: temp0)
		(temp0 empty: dispose:)
	)

	(method (makeSpecialList &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 (cardList size:)) ((++ temp0))
			(if (not ((cardList at: temp0) bestGroup:))
				(gGinRummyCardList add: (cardList at: temp0))
			)
		)
	)

	(method (filterSpecialList &tmp temp0 temp1)
		(= temp1 0)
		(for ((= temp0 0)) (< temp0 (gGinRummyCardList size:)) ((++ temp0))
			(if (< ((gGinRummyCardList at: temp0) defRating:) 20)
				(= temp1 1)
				(break)
			)
		)
		(if temp1
			(for ((= temp0 0)) (< temp0 (gGinRummyCardList size:)) ((++ temp0))
				(if (>= ((gGinRummyCardList at: temp0) defRating:) 20)
					(gGinRummyCardList delete: (cardList at: temp0))
				)
			)
		)
	)

	(method (discard &tmp [temp0 2] temp2 temp3 [temp4 20])
		(self calcGroups:)
		(if bestDeadWood
			(if (<= (- bestDeadWood highestDeadWood) local7)
				(= global426 self)
				(if (= temp3 (- bestDeadWood highestDeadWood))
					(= global305
						(Print (Format @temp4 104 0 temp3) #at 110 51 #dispose) ; "KNOCKING with %d"
					)
					(if (== (Random 0 2) 0)
						((gPlayer2 altrEgo:) smile: 1)
					)
				else
					(= global305 (Print 104 1 #at 125 51 #dispose)) ; "G I N !"
					((gPlayer2 altrEgo:) smile: 1)
					(gIntroSong number: ((gPlayer2 altrEgo:) song:) play:)
				)
				(proc0_1 (* global407 18))
				(gModelessDialog dispose:)
				(return highestDeadWoodCard)
			else
				(= gGinRummyCardList (GinRummyCardList new:))
				(self
					makeSpecialList:
					setOffensiveRating:
					setDefensiveRating:
					filterSpecialList:
				)
				(= temp2 (self chooseBestDiscard:))
				(gGinRummyCardList empty: dispose:)
				(return temp2)
			)
		else
			(= global426 self)
			(return (self chooseGinHandDiscard:))
		)
	)

	(method (setOffensiveRating)
		(proc406_0 self)
		(DisposeScript 406)
	)

	(method (setDefensiveRating)
		(proc407_0 self)
		(DisposeScript 407)
	)

	(method (reOrderCardList param1 &tmp temp0)
		(cardList empty:)
		(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
			(cardList add: (param1 at: temp0))
		)
	)

	(method (chooseBestDiscard &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp1 (gGinRummyCardList at: 0))
		(= temp2 (+ (temp1 offRating:) (temp1 defRating:)))
		(for ((= temp0 1)) (< temp0 (gGinRummyCardList size:)) ((++ temp0))
			(= temp4 (gGinRummyCardList at: temp0))
			(= temp3 (+ (temp4 offRating:) (temp4 defRating:)))
			(if (<= (temp4 offRating:) (temp1 offRating:))
				(cond
					((< (temp4 offRating:) (temp1 offRating:))
						(= temp1 temp4)
						(= temp2 temp3)
					)
					(
						(and
							(!= global775 0)
							(<= (temp4 defRating:) (temp1 defRating:))
						)
						(cond
							((< (temp4 defRating:) (temp1 defRating:))
								(= temp2 temp3)
								(= temp1 temp4)
							)
							(
								(and
									(== global775 2)
									(> (temp4 cardRank:) (temp1 cardRank:))
								)
								(= temp2 temp3)
								(= temp1 temp4)
							)
						)
					)
				)
			)
		)
		(return temp1)
	)

	(method (chooseGinHandDiscard &tmp temp0)
		(for ((= temp0 0)) (< temp0 (cardList size:)) ((++ temp0))
			(if ((cardList at: temp0) fourOrMoreInGroup:)
				(cardList at: temp0)
				(return)
			)
		)
		(cardList at: 0)
	)

	(method (shouldIAcceptKnock)
		(return (<= bestDeadWood (global426 bestDeadWood:)))
	)

	(method (createSuitLists)
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

	(method (sortHandByRank &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp4 gTheCursor)
		(if (cardList size:)
			(if (not argc)
				(gGame setCursor: 996)
			)
			(for ((= temp1 1)) (< temp1 14) ((++ temp1))
				(for ((= temp0 0)) (< temp0 4) ((++ temp0))
					(if
						(>=
							(= temp2
								(cardList hasCard: temp1 [global311 temp0])
							)
							0
						)
						(tempList add: (cardList at: temp2))
						(cardList delete: (cardList at: temp2))
					)
				)
			)
			(for ((= temp2 0)) (< temp2 (tempList size:)) ((++ temp2))
				(cardList add: (tempList at: temp2))
			)
			(tempList empty:)
			(if (not argc)
				(self rePosition:)
			)
			(if (!= gTheCursor temp4)
				(gGame setCursor: temp4)
			)
		)
	)

	(method (init)
		(super init:)
		(if (not sittingOut)
			((= cardList (GinRummyCardList new:)) add:)
			((= tempList (WL new:)) add:)
		)
	)

	(method (takeUpCard)
		(gPlayer0 passedOnCard: 0)
		(= global184 playerNum)
		(self setBase:)
		(= global176 dealFaceUp)
		(gDeck getUpCard:)
		(global173 faceUp: dealFaceUp)
		(= place 91)
		(gSndEffect number: (proc0_6 takeCardSound) playMaybe:)
		(if (> (Random 0 10) 7)
			((gPlayer2 altrEgo:) smirk: 1)
		)
		(gTheCardToss
			init:
				(gDeck topCardX:)
				(gDeck topCardY:)
				bX
				bY
				[global417 (- global406 1)]
		)
	)

	(method (takeCard)
		(gPlayer0 passedOnCard: 0)
		(= global184 playerNum)
		(self setBase:)
		(= global176 dealFaceUp)
		(gDeck getCard:)
		(global173 faceUp: dealFaceUp)
		(gSndEffect number: (proc0_6 takeCardSound) playMaybe:)
		(if (>= (gCardRoom state:) 5)
			(gTheCardToss
				init:
					(gDeck putX:)
					(gDeck putY:)
					bX
					bY
					[global417 (- global406 1)]
			)
		else
			(gTheCardToss
				init:
					(gDeck dealX:)
					(gDeck dealY:)
					bX
					bY
					[global408 (- global405 1)]
			)
		)
	)

	(method (takeTurn)
		(proc0_8)
		(if (== (cardList size:) 10)
			(proc0_1 (* global407 12))
		)
		(if (< (= local7 (- 10 (- global428 4))) 1)
			(= local7 1)
		)
		(if (> local7 10)
			(= local7 10)
		)
		(= global184 playerNum)
		(if (== (cardList size:) (+ global174 1))
			(proc0_5)
			(= global179 0)
			(= place 92)
			(cardList
				addAfter:
					(cardList at: (Random 0 9))
					(cardList at: (- (cardList size:) 1))
				delete: (cardList at: (- (cardList size:) 1))
			)
			(self playCard: (self discard:))
		else
			(= global179 1)
			(cond
				((self pickUpCard:)
					(= global187 2)
					(if ((proc4_2) onOrOff:)
						((proc4_2) onOrOff: 0)
						(gDeck showDeck: 0)
					)
					(= place 91)
					(self takeUpCard:)
				)
				((== global187 2)
					(= place 91)
					(self takeCard:)
				)
				(else
					(= global179 0)
					(proc0_1 (* global407 6))
					(if (and (== global187 1) ((proc4_2) onOrOff:))
						((proc4_2) onOrOff: 0)
						(gDeck showDeck: 0)
					)
					(proc0_5)
					((self altrEgo:) say: 5)
					(= passedOnCard (gDeck upCardView:))
					(gCardRoom cue:)
				)
			)
		)
	)

	(method (playCard param1)
		(= global173 param1)
		(global173 erase: 1)
		(self removeCard:)
		(= global180 0)
		(= pickedUpCard 0)
		(gSndEffect number: (proc0_6 playCardSound) playMaybe:)
		(gTheCardToss
			init:
				(global173 x:)
				(global173 y:)
				(gDeck topCardX:)
				(gDeck topCardY:)
				[global417 (- global406 1)]
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

	(method (transferCard)
		(gDeck setUpCardView:)
		(cardList delete: global173)
	)

	(method (endHand)
		(cardList
			addAllToWorkingDeck:
			eachElementDo: #erase 1
			eachElementDo: #faceUp 0
			eachElementDo: #loop 0
			eachElementDo: #rating 0
			eachElementDo: #inARun 0
			eachElementDo: #group 0
			eachElementDo: #bestGroup 0
			eachElementDo: #ofAKind 0
			eachElementDo: #playOff 0
			eachElementDo: #update
			empty:
		)
		(= bonus 0)
		(if group1List
			(group1List empty: dispose:)
		)
		(if group2List
			(group2List empty: dispose:)
		)
		(if group3List
			(group3List empty: dispose:)
		)
		(if deadWoodList
			(deadWoodList empty: dispose:)
		)
		(= group1List
			(= group2List (= group3List (= deadWoodList (= passedOnCard 0))))
		)
	)
)

