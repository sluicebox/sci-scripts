;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4)
(include sci.sh)
(use Main)
(use g)
(use Interface)
(use CursorCoords)
(use DisplayBox)
(use Motion)
(use Game)
(use Menu)
(use Actor)

(public
	room4 0
	proc4_2 2
)

(local
	[local0 20]
	[local20 30]
	local50
	local51
	local52
)

(procedure (proc4_2)
	(return pass1stTurn)
)

(procedure (localproc_0 param1 param2 param3 param4) ; UNUSED
	(return
		(and
			(<= param1 (global321 x:) param2)
			(<= param3 (global321 y:) param4)
		)
	)
)

(class GinRummyDeck of CardDeck
	(properties
		discardX 160
		discardY 76
		cursorX 131
		cursorY 102
		beginFlag 1
		origPutX 110
		origPutY 70
		putX 110
		putY 70
		upCardView 0
		upCardView2 0
		numDiscarded 1
		topCardX 160
		topCardY 76
		cel 0
	)

	(method (isCardInWorkingDeck param1 param2 &tmp temp0)
		(return
			(or
				(> (workingDeck hasCard: param1 param2) -1)
				(and
					upCardView
					(== (upCardView cardRank:) param1)
					(== (upCardView cardSuit:) param2)
				)
				(and
					upCardView2
					(== (upCardView2 cardRank:) param1)
					(== (upCardView2 cardSuit:) param2)
				)
			)
		)
	)

	(method (numInWorkingDeck param1 &tmp temp0 temp1)
		(for ((= temp0 (= temp1 0))) (< temp0 (workingDeck size:)) ((++ temp0))
			(+= temp1 (== ((workingDeck at: temp0) cardRank:) param1))
		)
		(if upCardView
			(+= temp1 (== (upCardView cardRank:) param1))
			(if upCardView2
				(+= temp1 (== (upCardView2 cardRank:) param1))
			)
		)
		(return temp1)
	)

	(method (reShuffle)
		(super reShuffle:)
		(theDeck eachElementDo: #erase 0)
	)

	(method (cue)
		(self setUpCardView:)
		(gCardRoom cue:)
	)

	(method (init &tmp temp0 [temp1 57])
		(super init:)
		(for ((= temp0 4)) (< temp0 56) ((++ temp0))
			(= [temp1 temp0] (Clone g))
			([temp1 temp0] cardRank: (/ temp0 4) cardSuit: (mod temp0 4))
		)
		(for ((= temp0 4)) (< temp0 56) ((++ temp0))
			(theDeck add: [temp1 temp0])
		)
		(self shuffle:)
		(global517 add: self)
		((= local52 (CursorCoords new:)) cursorX: 180 cursorY: 102)
		(global517 add: local52)
	)

	(method (erase)
		(self endHand: resetDealXY:)
		(proc0_2 172 0 5 (+ putX 6) (+ putY 6))
		(proc0_2 172 0 5 discardX discardY)
	)

	(method (showDeck param1 &tmp temp0)
		(if (> (= temp0 (* param1 2)) 6)
			(= temp0 6)
		)
		(proc0_2
			172
			0
			param1
			(= putX (+ origPutX temp0))
			(= putY (+ origPutY temp0))
		)
		(if (!= param1 5)
			(proc0_2 (+ 290 global507) 0 0 putX putY)
		)
	)

	(method (showUpCard)
		(self setTopCardCoords:)
		(proc0_2 172 0 cel topCardX topCardY)
		(proc0_2
			(+ 152 (upCardView cardSuit:))
			0
			(upCardView cardRank:)
			topCardX
			topCardY
		)
	)

	(method (turnUpCard)
		(self getCard:)
		(= global176 1)
		(= global184 99)
		(gSndEffect number: (proc0_6 100) playMaybe:)
		(cardToss
			init:
				putX
				putY
				discardX
				discardY
				(/ [global417 (- global406 1)] 2)
				self
		)
	)

	(method (getCard)
		(super getCard:)
		(if (< (theDeck size:) 12)
			(self showDeck: (- 4 (/ (+ (theDeck size:) 3) 4)))
		)
	)

	(method (getUpCard)
		(= global173 upCardView)
		(-- numDiscarded)
		(upCardView x: topCardX y: topCardY faceUp: 1 loop: 0 erase: 0)
		(if upCardView2
			(= upCardView upCardView2)
			(self showUpCard:)
		else
			(proc0_2 152 2 0 discardX discardY)
		)
		(= upCardView2 0)
	)

	(method (setUpCardView)
		(if upCardView2
			(upCardView2
				rating: 0
				inARun: 0
				group: 0
				bestGroup: 0
				ofAKind: 0
				playOff: 0
			)
			(workingDeck add: upCardView2)
		)
		(if (> numDiscarded 1)
			(= upCardView2 upCardView)
		)
		(++ numDiscarded)
		((= upCardView global173)
			x: topCardX
			y: topCardY
			faceUp: 1
			loop: 0
			erase: 0
		)
		(self showUpCard:)
	)

	(method (resetDealXY)
		(= dealX (= putX origPutX))
		(= dealY (= putY origPutY))
	)

	(method (endHand &tmp temp0)
		(self addAllToWorkingDeck: empty: self)
		(upCardView
			rating: 0
			inARun: 0
			group: 0
			bestGroup: 0
			ofAKind: 0
			playOff: 0
		)
		(workingDeck add: upCardView)
		(if (IsObject upCardView2)
			(upCardView2
				rating: 0
				inARun: 0
				group: 0
				bestGroup: 0
				ofAKind: 0
				playOff: 0
			)
			(workingDeck add: upCardView2)
		)
		(= numDiscarded 1)
		(= upCardView (= upCardView2 0))
	)

	(method (setTopCardCoords)
		(= cel (- 3 (/ (- numDiscarded 1) 4)))
		(if (< cel 0)
			(= cel 0)
		)
		(= topCardX (- discardX (- 6 (* cel 2))))
		(= topCardY (- discardY (- 6 (* cel 2))))
	)
)

(class GinRummyHumanPlayer of HumanPlayer
	(properties
		base1 70
		base2 0
		base3 0
		deadWoodBaseX 12
		deadWoodBaseY 0
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
		total 0
		handsWon 0
		bonus 0
		highestDeadWood 0
		highestDeadWoodCard 0
		passedOnCard 0
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
		(= temp0 gTheCursor)
		(if (not argc)
			(gGame setCursor: 996)
		)
		(if (not (cardList size:))
			(return)
		)
		(for ((= temp2 1)) (< temp2 14) ((++ temp2))
			(for ((= temp1 0)) (< temp1 4) ((++ temp1))
				(if (>= (= temp3 (cardList hasCard: temp2 [global311 temp1])) 0)
					(tempList add: (cardList at: temp3))
				)
			)
		)
		(cardList empty:)
		(for ((= temp3 0)) (< temp3 (tempList size:)) ((++ temp3))
			(cardList add: (tempList at: temp3))
			(if ((cardList at: temp3) loop:)
				(= place (= place2 (+ temp3 1)))
				(= place1 (- place2 1))
			)
		)
		(tempList empty:)
		(if (not argc)
			(self rePosition:)
		)
		(if (!= gTheCursor temp0)
			(gGame setCursor: temp0)
		)
	)

	(method (init)
		((= cardList (GinRummyCardList new:)) add:)
		((= tempList (WL new:)) add:)
		(= pickedUpCard 0)
	)

	(method (printPass &tmp temp0)
		(= global305 (Print 4 0 #at 136 123 #dispose)) ; "Pass"
		(= passedOnCard (gDeck upCardView:))
		(if (< (= global772 (* global407 25)) 60)
			(= global772 60)
		)
		(proc0_1 global772)
		(gModelessDialog dispose:)
	)

	(method (transferCard)
		(deck setUpCardView:)
		(cardList delete: global173)
	)

	(method (sortHandBySuit &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp0 gTheCursor)
		(if (not argc)
			(gGame setCursor: 996)
		)
		(if (not (cardList size:))
			(return)
		)
		(for ((= temp1 0)) (< temp1 4) ((++ temp1))
			(for ((= temp2 1)) (< temp2 14) ((++ temp2))
				(if (>= (= temp3 (cardList hasCard: temp2 [global311 temp1])) 0)
					(tempList add: (cardList at: temp3))
				)
			)
		)
		(cardList empty:)
		(for ((= temp3 0)) (< temp3 (tempList size:)) ((++ temp3))
			(cardList add: (tempList at: temp3))
			(if ((cardList at: temp3) loop:)
				(= place (= place2 (+ temp3 1)))
				(= place1 (- place2 1))
			)
		)
		(tempList empty:)
		(self rePosition:)
		(if (!= gTheCursor temp0)
			(gGame setCursor: temp0)
		)
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

	(method (playCard param1)
		((= global173 param1) erase: 1)
		(self removeCard:)
		(= global180 (= pickedUpCard 0))
		(gSndEffect number: (proc0_6 playCardSound) playMaybe:)
		(gTheCardToss
			init:
				(global173 x:)
				(global173 y:)
				(deck topCardX:)
				(deck topCardY:)
				[global417 (- global406 1)]
		)
	)

	(procedure (localproc_1 param1)
		(return
			(or
				(and (or (== global854 13) (== global854 20992)) (== param1 4))
				(== param1 1)
				(== param1 2)
			)
		)
	)

	(method (takeTurn)
		(= global184 playerNum)
		(if (and input global180)
			(cond
				(
					(and
						(localproc_1 global855)
						(!= global855 1)
						(sortObjRank doit: evtX evtY)
					)
					(self sortHandByRank:)
					(= input 0)
					(= global179 1)
					(self cue:)
				)
				(
					(and
						(localproc_1 global855)
						(!= global855 1)
						(sortObjSuit doit: evtX evtY)
					)
					(self sortHandBySuit:)
					(= input 0)
					(= global179 1)
					(self cue:)
				)
				(
					(and
						(localproc_1 global855)
						(!= global855 1)
						(knock doit: evtX evtY)
					)
					(if (== (cardList size:) (+ global174 1))
						(if (== (knock onOrOff:) 2)
							(knock init: 1)
							(= global426 0)
						else
							(knock init: 2)
							((player2 altrEgo:) say: 6)
							(= global426 self)
						)
					else
						(gSndEffect number: 36 play:)
						((player2 altrEgo:) say: 7)
					)
					(= place -1)
					(= input 0)
					(= global179 1)
					(self cue:)
				)
				(else
					(proc0_8)
					(= global180 0)
					(self handleInput:)
				)
			)
		else
			(if (gGoneTimer done:)
				(self playerSeemsToBeGone:)
			)
			(= global179 1)
			(self cue:)
		)
	)

	(method (findADimCard param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 (cardList size:)) ((++ temp0))
			(if ((cardList at: temp0) loop:)
				(return
					(if (and argc (== param1 1))
						temp0
					else
						(cardList at: temp0)
					)
				)
			)
		)
	)

	(method (takeCard)
		(= global184 playerNum)
		(self setBase:)
		(= global176 dealFaceUp)
		(deck getCard:)
		(global173 faceUp: dealFaceUp)
		(gSndEffect number: (proc0_6 takeCardSound) playMaybe:)
		(if (>= (cardRoom state:) 5)
			(gTheCardToss
				init:
					(deck putX:)
					(deck putY:)
					bX
					bY
					[global417 (- global406 1)]
			)
		else
			(gTheCardToss
				init:
					(deck dealX:)
					(deck dealY:)
					bX
					bY
					[global408 (- global405 1)]
			)
		)
	)

	(method (takeUpCard)
		(= global184 playerNum)
		(self setBase:)
		(= global176 dealFaceUp)
		(deck getUpCard:)
		(global173 faceUp: dealFaceUp)
		(= place 91)
		(gSndEffect number: (proc0_6 takeCardSound) playMaybe:)
		(gTheCardToss
			init:
				(deck topCardX:)
				(deck topCardY:)
				bX
				bY
				[global417 (- global406 1)]
		)
	)

	(method (howManyCardsDim &tmp temp0 temp1)
		(for ((= temp0 (= temp1 0))) (< temp0 (cardList size:)) ((++ temp0))
			(+= temp1 ((cardList at: temp0) loop:))
		)
		(return temp1)
	)

	(method (findRect param1 param2 param3 &tmp temp0)
		(= place -1)
		(if
			(and
				(= temp0 (<= param1 evtY (+ param1 43)))
				(<= param2 evtX (+ param2 35))
			)
			(= place 91)
		)
		(if (== param3 (gDeck topCardX:))
			(= param1 (gDeck topCardY:))
		)
		(if (and temp0 (<= param3 evtX (+ param3 35)))
			(= place 92)
		)
		(super findRect:)
	)

	(method (handleInput &tmp temp0 temp1)
		(if (gTheCardToss mover:)
			(return)
		)
		(= temp1 (self howManyCardsDim:))
		(= global179 1)
		(= place2 place)
		(self findRect: (deck putY:) (deck putX:) (deck topCardX:))
		(if (and (== global854 20992) (not temp1))
			(= global854 13)
		)
		(if (and (== global854 20992) (== (self findADimCard: 1) (- place 1)))
			(= place 92)
			(= global854 13)
		)
		(if (and (localproc_1 input) (!= input 1))
			(if (== place 91)
				(= global854 13)
				(if (< global187 2)
					(self printPass:)
					(= global180 (= input (= global179 0)))
					(cardRoom cue:)
					(return)
				)
				(cond
					((== (cardList size:) (+ global174 1))
						(gSndEffect number: 36 play:)
						((gPlayer2 altrEgo:) say: 8)
						(if (and (!= input 1) (self dimCardIsAt:))
							(= place (= place2 (self dimCardIsAt:)))
						)
						(= input 0)
						(cardRoom cue:)
						(return)
					)
					(temp1
						(gSndEffect number: 36 play:)
						((gPlayer2 altrEgo:) say: 9)
						(if (and (!= input 1) (self dimCardIsAt:))
							(= place (= place2 (self dimCardIsAt:)))
						)
						(= input 0)
						(cardRoom cue:)
						(return)
					)
					(else
						(self takeCard:)
						(= input (= global180 0))
						(if (== (knownCards size:) 10)
							(knownCards add: global173)
						)
						(gPlayer2 passedOnCard: 0)
						(return)
					)
				)
			)
			(if (== place 92)
				(= global854 13)
				(cond
					((== (cardList size:) (+ global174 1))
						(if temp1
							(knownCards delete: (= temp0 (self findADimCard:)))
							(self playCard: temp0)
							(global517 delete: temp0)
						else
							(gSndEffect number: 36 play:)
							((gPlayer2 altrEgo:) say: 8)
							(if (and (!= input 1) (self dimCardIsAt:))
								(= place (= place2 (self dimCardIsAt:)))
							)
							(= input 0)
							(cardRoom cue:)
							(return)
						)
					)
					(temp1
						(gSndEffect number: 36 play:)
						((gPlayer2 altrEgo:) say: 9)
						(if (and (!= input 1) (self dimCardIsAt:))
							(= place (= place2 (self dimCardIsAt:)))
						)
						(= input 0)
						(cardRoom cue:)
						(return)
					)
					((== (gDeck upCardView:) passedOnCard)
						(gSndEffect number: 36 play:)
						((gPlayer2 altrEgo:) say: 10)
						(if (and (!= input 1) (self dimCardIsAt:))
							(= place (= place2 (self dimCardIsAt:)))
						)
						(= input 0)
						(cardRoom cue:)
						(return)
					)
					(else
						(= global180 (= passedOnCard 0))
						(knownCards add: (gDeck upCardView:))
						(gPlayer2 passedOnCard: 0)
						(self takeUpCard:)
						(= global187 2)
						(if (pass1stTurn onOrOff:)
							(pass1stTurn onOrOff: 0)
							(deck showDeck: 0)
						)
						(= input 0)
						(return)
					)
				)
			)
		)
		(if (!= input 1)
			(if (== global854 13)
				(= place2 place)
			)
			(cond
				((and (> place 0) (<= place (cardList size:)) (== place2 place))
					(= global854 13)
					(if ((cardList at: (- place 1)) loop:)
						(self invertCard: (- place 1))
					else
						(if temp1
							(self invertCard: (self findADimCard: 1))
						)
						(self invertCard: (- place 1))
					)
				)
				(
					(and
						(<= 0 place (cardList size:))
						(<= 1 place2 (cardList size:))
						(or (!= global855 4) (== global854 20992))
					)
					(self adjustLists: place place2)
					(if temp1
						(= place (= place2 (self findADimCard: 1)))
						(++ place)
						(++ place2)
					)
					(self rePosition:)
				)
			)
		)
		(= input 0)
		(cardRoom cue:)
	)

	(method (dimCardIsAt &tmp temp0)
		(for ((= temp0 0)) (< temp0 (cardList size:)) ((++ temp0))
			(if ((cardList at: temp0) loop:)
				(return (+ temp0 1))
			)
		)
		(return 0)
	)
)

(instance room4 of Rm
	(properties)

	(method (init)
		(cardRoom init:)
	)

	(method (doit)
		(if (not (global300 windowUp:))
			(cardRoom doit:)
			(gGoneTimer doit:)
		)
		((player2 altrEgo:) doit:)
		(global300 doit:)
	)

	(method (handleEvent event param2 &tmp temp0)
		(if (== argc 2)
			(switch param2
				(1281
					(gGame setCursor: 997)
					((ScriptID 884) doit:) ; ginRummyRules
					(DisposeScript 884)
					(event claimed: 1)
					(return)
				)
				(1282
					(if
						(= temp0
							(Print
								(Format @global520 4 1 global511) ; "Set Game Limit (now %d)"
								#button
								{100}
								100
								#button
								{200}
								200
								#button
								{250}
								250
								#button
								{300}
								300
								#button
								{500}
								500
							)
						)
						(= global511 temp0)
						(SetMenu
							1282
							110
							(Format @local20 {Game Limit (now %d)} global511)
						)
					)
					(return)
				)
			)
		else
			(player0 handleEvent: event)
		)
	)

	(method (dispose)
		(if (global300 windowUp:)
			(global300 dispose:)
			(proc0_5)
		)
		(super dispose:)
	)
)

(instance cardRoom of CardRoom
	(properties
		numPlayers 2
	)

	(method (init)
		(AddMenu { Gin Rummy } {Rules `^r:Game Limit (now 0) `^l})
		(MenuBar draw:)
		(SetMenu 1282 110 (Format @local20 {Game Limit (now %3d)} global511))
		(proc0_7 130 899 406 407 408 403 405 404)
		(= global517 inList)
		(= global264 ScoreCard)
		(= gPlayer0 player0)
		(= gPlayer2 player2)
		(= gCardRoom cardRoom)
		(= global197 endThrow)
		(= gKnownCards knownCards)
		(= gDeck deck)
		(super init:)
		(= global174 10)
		(proc0_7 128 152 153 154 155 52 53 54 55 171 172)
		(proc0_7 132 100 101 102 103 104 105 32)
		(= global180 0)
		(= global775 ((gPlayer2 altrEgo:) ginSkill:))
	)

	(method (doit &tmp temp0 [temp1 30])
		(switch state
			(0
				(if (not global186)
					(++ global186)
					((player2 altrEgo:) init: player2)
				)
				(if
					(and
						((player2 altrEgo:) expressions:)
						(not (((player2 altrEgo:) expressions:) size:))
						(== (gIntroSong state:) 0)
					)
					(self cue:)
				)
			)
			(1
				(if (not global186)
					(++ global186)
					(if global508
						(= global508 0)
						(if (Print 4 2 #button {Yes} 1 #button {No} 0) ; "Reset Scores?"
							(gPlayer0 handsWon: 0 total: 0)
							(gPlayer2 handsWon: 0 total: 0)
							(SetMenu 1282 112 1)
						)
					)
					((gPlayerList at: currentPlayer) takeCard:)
				)
			)
			(2
				((gPlayerList at: currentPlayer) addCard:)
				(if (not ((gPlayerList at: currentPlayer) playerNum:))
					(gPlayer0 updateCursorCoords:)
				)
				(= global186 0)
				(self cue:)
			)
			(3
				(if (not global186)
					(++ global186)
					(deck showDeck: 0)
					(= global180 1)
					(self cue:)
				)
			)
			(4
				(if (not global186)
					(++ global186)
					(= global428 1)
					(deck turnUpCard:)
				)
			)
			(5
				(if (not global186)
					(++ global186)
					(cond
						((== (gPlayerList at: currentPlayer) player0)
							(if (!= gTheCursor 999)
								(gGame setCursor: 999)
							)
						)
						((!= gTheCursor 997)
							(gGame setCursor: 997)
						)
					)
					((gPlayerList at: currentPlayer) takeTurn:)
				)
			)
			(6
				(= global510 1)
				(proc0_1 (* global407 100))
				(self newDeal2:)
				(= state 11)
				(= global186 0)
			)
			(7
				(if (not global186)
					(++ global186)
					((global426 cardList:) caller: global426)
					(global426 createSuitLists: sortHandByRank:)
					((global426 cardList:)
						clearMarks:
						clearGroup:
						clearBestGroup:
						eachElementDo: #rating 0
						eachElementDo: #ofAKind 0
						findAllOfAKinds:
						markRuns:
					)
					(global426
						bestDeadWood: ((global426 cardList:) findBestGroup:)
						disposeSuitLists:
					)
					(= temp0 1)
					(if (== global426 player0)
						(cond
							((> (global426 bestDeadWood:) 10)
								(= temp0 (player2 shouldIAcceptKnock:))
								(= global305
									(Print
										(Format ; "Illegal Knock of %d"
											@temp1
											4
											3
											(global426 bestDeadWood:)
										)
										#at
										90
										123
										#dispose
									)
								)
							)
							((global426 bestDeadWood:)
								(= global305
									(Print
										(Format ; "KNOCKING with %d"
											@temp1
											4
											4
											(global426 bestDeadWood:)
										)
										#at
										95
										123
										#dispose
									)
								)
							)
							(else
								(= global305
									(Print (Format @temp1 4 5) #at 134 123 #dispose) ; "G I N !"
								)
								(gIntroSong number: 27 play:)
								(switch (Random 0 1)
									(0
										((gPlayer2 altrEgo:) upset: 1)
									)
									(else
										((gPlayer2 altrEgo:) shock: 1)
									)
								)
							)
						)
						(if (< (= global772 (* global407 25)) 60)
							(= global772 60)
						)
						(proc0_1 global772)
						(gModelessDialog dispose:)
					)
					(if temp0
						(self newDeal2:)
						(if
							(and
								(== global426 player0)
								(> (global426 bestDeadWood:) 10)
							)
							((player2 altrEgo:) say: 11)
						)
						((global426 cardList:) arrangeGroups: global426)
						(= global427
							(if (== global426 player0) player2 else player0)
						)
						(self cue:)
					else
						(for
							((= temp0 0))
							(< temp0 ((gPlayer0 cardList:) size:))
							((++ temp0))
							
							(knownCards add: ((gPlayer0 cardList:) at: temp0))
						)
						(gSndEffect number: 36 play:)
						((player2 altrEgo:) say: 12)
						(= global426 (= global186 0))
						(knock init: 1)
						(= state 5)
						(if (== ((deck theDeck:) size:) 2)
							(= state 6)
							(twoCardsLeft init: 1)
							(proc0_5)
						)
					)
				)
			)
			(8
				(if (not global186)
					(++ global186)
					(for ((= temp0 0)) (< temp0 10) ((++ temp0))
						(global517 delete: ((gPlayer0 cardList:) at: temp0))
					)
					((global426 cardList:) eachElementDo: #update)
				)
				(self cue:)
			)
			(9
				(if (not global186)
					(++ global186)
					((global427 cardList:) caller: global427)
					(global427 createSuitLists: sortHandByRank:)
					((global427 cardList:)
						clearMarks:
						clearGroup:
						clearBestGroup:
						eachElementDo: #rating 0
						eachElementDo: #ofAKind 0
						findAllOfAKinds:
						markRuns:
					)
					(global427
						bestDeadWood: ((global427 cardList:) findBestGroup:)
						disposeSuitLists:
					)
					((global427 cardList:) arrangeGroups: global427)
					(if (not (global426 bestDeadWood:))
						(global426 bonus: 25)
					)
					(if
						(or
							(not (global426 bestDeadWood:))
							(<
								(global426 bestDeadWood:)
								(global427 bestDeadWood:)
							)
						)
						(global426 handsWon: (+ (global426 handsWon:) 1))
						(= local51 global426)
					)
					(if
						(and
							(global426 bestDeadWood:)
							(<=
								(global427 bestDeadWood:)
								(global426 bestDeadWood:)
							)
						)
						(global427
							handsWon: (+ (global427 handsWon:) 1)
							bonus: 25
						)
						(gIntroSong
							number:
								(if (== global427 gPlayer2)
									((gPlayer2 altrEgo:) song:)
								else
									27
								)
							play:
						)
						(= local51 global427)
					)
					(self cue:)
				)
			)
			(10
				(if (not global186)
					(++ global186)
					((global427 cardList:) eachElementDo: #update)
					(self cue:)
				)
			)
			(11
				(if (not global186)
					(++ global186)
					(SetMenu 1282 112 0)
					(proc0_5)
					((ScriptID 404) display:) ; scoreObj
					(DisposeScript 404)
					(if
						(or
							(>= (gPlayer0 total:) global511)
							(>= (gPlayer2 total:) global511)
						)
						(if (not global509)
							((gPlayer2 altrEgo:) say: 15 1)
						else
							((gPlayer2 altrEgo:)
								say: (if (== global509 gPlayer0) 13 else 14) 1
							)
							(gIntroSong
								number:
									(if (== global509 gPlayer2)
										((gPlayer2 altrEgo:) song:)
									else
										27
									)
								play:
							)
						)
					)
					(if global509
						(gPlayer0 handsWon: (= global509 0) total: 0)
						(gPlayer2 handsWon: 0 total: 0)
						(SetMenu 1282 112 1)
					)
					(self cue:)
				)
			)
			(12
				(knownCards empty:)
				(self newDeal: cue:)
			)
			(13
				(= state 1)
			)
		)
	)

	(method (cue &tmp temp0)
		(switch state
			(2
				(if (> (++ currentPlayer) 1)
					(= currentPlayer 0)
				)
				(if (== (++ global175) (* global174 numPlayers))
					(++ state)
				else
					(= state 1)
				)
			)
			(4
				(sortObjRank init: 1)
				(sortObjSuit init: 1)
				(knock init: 1)
				(pass1stTurn init:)
				(= global186 (= global187 0))
				(++ state)
				(proc0_5)
			)
			(5
				(= global186 0)
				(= global180 1)
				(if global179
					(= global179 0)
				else
					(if (!= global187 2)
						(++ global187)
					)
					(if (and (== global187 2) (pass1stTurn onOrOff:))
						(pass1stTurn onOrOff: 0)
						(deck showDeck: 0)
					)
					(if (> (++ currentPlayer) 1)
						(= currentPlayer 0)
					)
					(if (== (gPlayerList at: currentPlayer) (gPlayerList at: 0))
						(++ global428)
					)
					(if ((gPlayerList at: currentPlayer) playerNum:)
						(= global180 0)
					else
						(player0 input: 0)
						(= global180 1)
					)
					(if (and (not global426) (== ((deck theDeck:) size:) 2))
						(++ state)
						(twoCardsLeft init: 1)
						(proc0_5)
					)
					(if global426
						(= state 7)
					)
				)
			)
			(else
				(= global186 0)
				(++ state)
			)
		)
	)

	(method (newDeal2)
		(knock init: 0)
		(sortObjSuit init: 0)
		(sortObjRank init: 0)
		(twoCardsLeft init: 0)
		(deck erase:)
		(proc0_5)
	)

	(method (removeViews)
		(player0 endHand:)
		(player2 endHand:)
	)

	(method (newDeal)
		(= global426 0)
		(self removeViews:)
		(deck reShuffle:)
		(if (and (not global510) (!= (gPlayerList at: 0) local51))
			(gPlayerList next:)
		)
		(= global510 0)
		(super newDeal2:)
	)
)

(instance endThrow of EndThrow
	(properties)
)

(instance deck of GinRummyDeck
	(properties)
)

(instance ginRummyEndThrow of EndThrow
	(properties)

	(method (cue)
		(= global182 (- (client x:) 17))
		(= global183 (- (client y:) 21))
		(client dispose:)
		(global173 x: global182 y: global183)
		(local50 cue:)
	)
)

(instance cardToss of Act
	(properties)

	(method (init param1 param2 param3 param4 param5 param6)
		(= local50 param6)
		(self
			view: (+ 290 global507)
			setLoop: 8
			setCel: 3
			setCycle: Fwd
			setStep: param5 param5
			setPri: 15
			posn: (+ param1 17) (+ param2 21)
			setScript: ginRummyEndThrow
			setMotion: MoveTo (+ param3 17) (+ param4 21) self
		)
		(super init:)
	)
)

(instance player0 of GinRummyHumanPlayer
	(properties
		dealFromX 130
		baseX 156
	)
)

(instance player2 of GinRummyComputerPlayer
	(properties
		playerNum 2
		dealFromX 130
		dealFromY -20
		overlapY 0
		baseX 156
		baseY 5
		altrEgo 14
		altrEgoX 78
		altrEgoY 42
	)
)

(instance sortObjRank of GO
	(properties
		x 224
		y 160
		view 159
		cursorX 260
		cursorY 169
	)

	(method (init param1)
		(proc0_2 view 0 (= onOrOff param1) x y)
		(if param1
			(global517 add: self)
		else
			(global517 delete: self)
		)
	)

	(method (doit param1 param2)
		(return
			(and
				(not global184)
				onOrOff
				(<= x param1 (+ x 71))
				(<= y param2 (+ y 12))
			)
		)
	)
)

(instance sortObjSuit of GO
	(properties
		x 20
		y 160
		view 159
		cursorX 57
		cursorY 169
	)

	(method (init param1)
		(proc0_2 view 0 (= onOrOff (* param1 2)) x y)
		(if param1
			(global517 add: self)
		else
			(global517 delete: self)
		)
	)

	(method (doit param1 param2)
		(return
			(and
				(not global184)
				onOrOff
				(<= x param1 (+ x 71))
				(<= y param2 (+ y 12))
			)
		)
	)
)

(instance knock of GO
	(properties
		x 58
		y 97
		view 159
		cursorX 79
		cursorY 106
	)

	(method (init param1)
		(proc0_2 view 1 (= onOrOff param1) x y)
		(if param1
			(global517 add: self)
		else
			(global517 delete: self)
		)
	)

	(method (doit param1 param2)
		(return
			(and
				(not global184)
				onOrOff
				(<= x param1 (+ x 34))
				(<= y param2 (+ y 12))
			)
		)
	)
)

(instance pass1stTurn of GO
	(properties
		view 171
	)

	(method (init)
		(proc0_2 view 0 (= onOrOff 2) (deck putX:) (deck putY:))
	)
)

(instance twoCardsLeft of GO
	(properties
		view 171
	)

	(method (init param1)
		(proc0_2 view 0 (= onOrOff param1) (+ (deck putX:) 22) (deck putY:))
	)
)

(instance knownCards of GinRummyCardList
	(properties)

	(method (add param1)
		(if (== (self hasCard: (param1 cardRank:) (param1 cardSuit:)) -1)
			(super add: param1)
		)
	)

	(method (delete param1)
		(if size
			(super delete: param1)
		)
	)
)

(instance inList of InputList
	(properties)
)

