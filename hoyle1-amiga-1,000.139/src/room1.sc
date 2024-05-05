;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use Interface)
(use CursorCoords)
(use Tmrs)
(use DisplayBox)
(use Game)
(use Menu)

(public
	room1 0
)

(local
	local0
	local1
	local2
	local3
	local4 = -1
	[local5 21]
)

(procedure (localproc_0 param1 &tmp temp0 temp1)
	(for ((= temp1 (= temp0 0))) (< temp1 argc) ((++ temp1))
		(if (>= [param1 temp1] temp0)
			(= temp0 [param1 temp1])
		)
	)
	(return temp0)
)

(class Crazy8sCardList of CardList
	(properties)

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

(class Deck of CardDeck
	(properties
		discardX 168
		discardY 80
		cursorX 133
		cursorY 104
		beginFlag 1
		origPutX 113
		origPutY 74
		putX 113
		putY 74
		upCardView 0
		curs1 0
		curs2 0
		curs3 0
		curs4 0
	)

	(method (init &tmp temp0 [temp1 57])
		(super init:)
		(for ((= temp0 4)) (< temp0 56) ((++ temp0))
			(= [temp1 temp0] (Clone c))
			([temp1 temp0] cardRank: (/ temp0 4) cardSuit: (mod temp0 4))
		)
		(for ((= temp0 4)) (< temp0 56) ((++ temp0))
			(theDeck add: [temp1 temp0])
		)
		(self shuffle:)
		(global517 add: self)
	)

	(method (resetDealXY)
		(= putX origPutX)
		(= putY origPutY)
		(= dealX putX)
		(= dealY putY)
	)

	(method (showDeck param1 &tmp temp0)
		(if (> (= temp0 (* param1 2)) 6)
			(= temp0 6)
		)
		(= putX (+ origPutX temp0))
		(= putY (+ origPutY temp0))
		(proc0_2 172 0 param1 putX putY)
		(if (!= param1 5)
			(if (== param1 4)
				(proc0_2 172 0 4 putX putY)
			else
				(proc0_2 (+ 290 global507) 0 0 putX putY)
			)
		)
	)

	(method (turnUpCard)
		(self getCard:)
		(= global176 1)
		(= global184 99)
		(gSndEffect number: (proc0_6 100) playMaybe:)
		(gTheCardToss
			init: putX putY discardX discardY (/ [global417 (- global406 1)] 2)
		)
	)

	(method (getCard)
		(super getCard:)
		(if (< (theDeck size:) 12)
			(self showDeck: (- 4 (/ (+ (theDeck size:) 3) 4)))
		)
	)

	(method (setUpCardView)
		(if (and upCardView (== (upCardView cardRank:) 8))
			(self chooseSuitOff:)
		)
		(if upCardView
			(workingDeck add: upCardView)
			(global517 delete: upCardView)
		)
		(= upCardView global173)
		(global517 add: upCardView)
		(upCardView cursorX: (+ discardX 20) cursorY: cursorY)
		(= global177 (upCardView cardRank:))
		(= global178 (upCardView cardSuit:))
		(upCardView x: discardX y: discardY faceUp: 1 loop: 0 erase: 0)
		(self plotCard: upCardView 0)
		(cond
			(beginFlag
				(= beginFlag 0)
			)
			((== (upCardView cardRank:) 8)
				(if global184
					(self chooseSuitOn: (+ local0 1))
					(= global178 local0)
					(proc0_5)
				else
					(self chooseSuitOn: 0)
				)
			)
		)
	)

	(method (chooseSuitOn param1)
		(if (or local1 beginFlag)
			(return)
		)
		(proc0_2 156 0 param1 160 67)
		(if (and (not global184) (not (global517 contains: curs1)))
			((= curs1 (CursorCoords new:)) cursorX: 142 cursorY: 59)
			((= curs2 (CursorCoords new:)) cursorX: 154 cursorY: 59)
			((= curs3 (CursorCoords new:)) cursorX: 166 cursorY: 59)
			((= curs4 (CursorCoords new:)) cursorX: 178 cursorY: 59)
			(global517 add: curs1 curs2 curs3 curs4)
		)
	)

	(method (chooseSuitOff)
		(proc0_2 156 1 0 160 67)
		(if (global517 contains: curs1)
			(global517 delete: curs1)
			(curs1 dispose:)
		)
		(if (global517 contains: curs2)
			(global517 delete: curs2)
			(curs2 dispose:)
		)
		(if (global517 contains: curs3)
			(global517 delete: curs3)
			(curs3 dispose:)
		)
		(if (global517 contains: curs4)
			(global517 delete: curs4)
			(curs4 dispose:)
		)
		(= curs1 (= curs2 (= curs3 (= curs4 0))))
	)
)

(class Crazy8sComputerPlayer of Player
	(properties
		totalPlayable 0
		numEights 0
		numRanks 0
		numSuits 0
		cardNumS 0
		cardNumR 0
		cardNum 0
		cardsLeft 0
		altrEgoX 0
		altrEgoY 0
		cardsTaken 0
		points 0
	)

	(method (init)
		(super init:)
		(if (not sittingOut)
			(= cardList (Crazy8sCardList new:))
			(= tempList (WL new:))
			(= skill ((self altrEgo:) crazy8sSkill:))
		)
	)

	(method (takeTurn)
		(= global184 playerNum)
		(if sittingOut
			(gCardRoom cue:)
			(return)
		)
		(proc0_8)
		(if (!= gTheCursor 997)
			(gGame setCursor: 997)
		)
		(= cardsLeft (deck aCardToGet:))
		(= place (self think:))
		(= place1 (+ place 1))
		(if (== place -1)
			(= place 91)
			(if cardsLeft
				(if (== (cardList size:) 20)
					(++ global187)
					(altrEgo say: 5)
					(= local3 1)
					(gCardRoom cue:)
				else
					(= global179 1)
					(++ cardsTaken)
					(switch cardsTaken
						(1
							((self altrEgo:) upset: 1)
							(proc0_4 373 playerNum)
						)
						(2
							((self altrEgo:) upset: 1)
							(proc0_4 374 playerNum)
						)
						(3
							((self altrEgo:) shock: 1)
							(proc0_4 371 playerNum)
						)
						(else
							((self altrEgo:) anger: 1)
							(proc0_4 371 playerNum)
							(if (== cardsTaken 5)
								(gIntroSong number: (Random 32 35) play:)
							)
						)
					)
					(self takeCard:)
				)
			else
				(++ global187)
				(altrEgo say: 5)
				(= local3 1)
				(gCardRoom cue:)
			)
		else
			(if
				(and
					(== (cardList size:) 1)
					(== ((cardList at: 0) cardRank:) 8)
				)
				(= local1 1)
			)
			(= global187 0)
			(= cardsTaken 0)
			(altrEgo clearExps: noExp:)
			(if (== ((cardList at: place) cardRank:) 8)
				(= local4 playerNum)
			)
			(self playCard: (cardList at: place))
		)
	)

	(method (setUpArrays)
		(for ((= global264 0)) (<= global264 13) ((++ global264))
			(= [global146 global264] 0)
			(if (< global264 4)
				(= [global160 global264] 0)
			)
		)
		(for ((= global264 0)) (< global264 (cardList size:)) ((++ global264))
			(if ((cardList at: global264) cardRank:)
				(++ [global160 ((cardList at: global264) cardSuit:)])
				(++ [global146 ((cardList at: global264) cardRank:)])
			)
		)
	)

	(method (countCards &tmp temp0)
		(for ((= temp0 0)) (< temp0 (cardList size:)) ((++ temp0))
			(= [local5 temp0] 0)
			(if (== ((cardList at: temp0) cardRank:) 8)
				(++ totalPlayable)
				(++ numEights)
				(= cardNum temp0)
				(= [local5 cardNum] 8)
			else
				(if (== ((cardList at: temp0) cardRank:) global177)
					(++ totalPlayable)
					(++ numRanks)
					(= cardNum (= cardNumR temp0))
					(= [local5 cardNum] 2)
				)
				(if (== ((cardList at: temp0) cardSuit:) global178)
					(++ totalPlayable)
					(++ numSuits)
					(= cardNum (= cardNumS temp0))
					(= [local5 cardNum] 1)
				)
			)
		)
	)

	(method (chooseEights &tmp temp0 temp1 temp2 temp3)
		(= temp0 0)
		(= temp1 0)
		(= temp2 (Random 1 numEights))
		(while (!= temp1 temp2)
			(if (== [local5 temp0] 8)
				(++ temp1)
				(= temp3 temp0)
			)
			(++ temp0)
		)
		(= local0 (self choose8Suit:))
		(return temp3)
	)

	(method (think &tmp temp0 temp1 temp2)
		(= local0 -1)
		(= numEights
			(= cardNum
				(= cardNumR
					(= cardNumS (= numSuits (= numRanks (= totalPlayable 0))))
				)
			)
		)
		(self countCards:)
		(self setUpArrays:)
		(if (not totalPlayable)
			(return -1)
		)
		(if (== numEights totalPlayable)
			(return (self chooseEights:))
		)
		(cond
			((== skill 0)
				(= temp1 0)
				(= temp2 (- (cardList size:) 1))
				(while 1
					(if [local5 (= temp0 (Random 0 temp2))]
						(break)
					)
					(if (> (++ temp1) 20)
						(= temp0 -1)
						(for ((= temp1 0)) (<= temp1 temp2) ((++ temp1))
							(if [local5 temp1]
								(= temp0 temp1)
								(break)
							)
						)
						(break)
					)
				)
				(if (and (>= temp0 0) (== [local5 temp0] 8))
					(self chooseEights:)
				)
				(return temp0)
			)
			((== skill 1)
				(cond
					((and (> numRanks 0) (== (Random 0 1) 1))
						(return (self chooseRanks:))
					)
					((and (> numSuits 0) (== (Random 0 1) 1))
						(return (self chooseSuits:))
					)
					(else 0)
				)
			)
			(else
				(if (> numRanks numSuits)
					(return (self chooseRanks:))
				)
				(if (> numSuits numRanks)
					(return (self chooseSuits:))
				)
			)
		)
		(return (self testDuplication:))
	)

	(method (testDuplication &tmp temp0 temp1 temp2 temp3)
		(= temp2 -1)
		(= temp1 -1)
		(for ((= temp0 0)) (< temp0 (cardList size:)) ((++ temp0))
			(= temp3 ((cardList at: temp0) cardRank:))
			(if
				(and
					[local5 temp0]
					(!= [local5 temp0] 8)
					(> [global146 temp3] temp2)
				)
				(= temp2 [global146 temp3])
				(= temp1 temp0)
			)
		)
		(return temp1)
	)

	(method (transferCard)
		(= global173 (cardList at: (- place1 1)))
		(deck setUpCardView:)
		(cardList delete: (cardList at: (- place1 1)))
	)

	(method (takeCard)
		(if sittingOut
			(gCardRoom cue:)
			(return)
		)
		(if (>= (gCardRoom state:) 7)
			(proc0_1 (* global407 12))
		)
		(self setBase:)
		(= global176 dealFaceUp)
		(deck getCard:)
		(global173 faceUp: dealFaceUp)
		(gSndEffect number: (proc0_6 takeCardSound) playMaybe:)
		(gTheCardToss
			init:
				(deck dealX:)
				(deck dealY:)
				bX
				bY
				(if (>= (cardRoom state:) 7)
					[global417 (- global406 1)]
				else
					[global408 (- global405 1)]
				)
		)
	)

	(method (choose8Suit &tmp temp0 temp1 temp2 temp3)
		(for ((= temp2 0)) (< temp2 (cardList size:)) ((++ temp2))
			(if (== ((cardList at: temp2) cardRank:) 8)
				(-- [global160 ((cardList at: temp2) cardSuit:)])
			)
		)
		(= temp3 (= temp1 0))
		(= temp1 0)
		(for ((= temp0 1)) (< temp0 4) ((++ temp0))
			(if (> [global160 temp0] [global160 global329])
				(= temp3 temp1)
				(= temp1 temp0)
			)
		)
		(if
			(and
				(== skill 2)
				temp3
				(Random 0 1)
				(> [global160 temp3] 0)
				(<= (cardList size:) 3)
			)
			(= temp1 temp3)
		)
		(return temp1)
	)

	(method (chooseSuits &tmp temp0 temp1)
		(if (== numSuits 1)
			(return cardNumS)
		)
		(= temp1 -1)
		(for ((= temp0 0)) (< temp0 (cardList size:)) ((++ temp0))
			(if (== [local5 temp0] 1)
				(cond
					((== temp1 -1)
						(= temp1 temp0)
					)
					(
						(>
							[global146 ((cardList at: temp0) cardRank:)]
							[global146 ((cardList at: temp1) cardRank:)]
						)
						(= temp1 temp0)
					)
				)
			)
		)
		(return temp1)
	)

	(method (chooseRanks &tmp temp0 temp1)
		(if (== numRanks 1)
			(return cardNumR)
		)
		(= temp1 -1)
		(for ((= temp0 0)) (< temp0 (cardList size:)) ((++ temp0))
			(if (== [local5 temp0] 2)
				(cond
					((== temp1 -1)
						(= temp1 temp0)
					)
					(
						(>
							[global160 ((cardList at: temp0) cardSuit:)]
							[global160 ((cardList at: temp1) cardSuit:)]
						)
						(= temp1 temp0)
					)
				)
			)
		)
		(return temp1)
	)

	(method (setPoints &tmp temp0 temp1)
		(= points 0)
		(if sittingOut
			(return)
		)
		(if (cardList size:)
			(for ((= temp0 0)) (< temp0 (cardList size:)) ((++ temp0))
				(cond
					((== (= temp1 ((cardList at: temp0) cardRank:)) 8)
						(+= points 50)
					)
					((>= temp1 10)
						(+= points 10)
					)
					(else
						(+= points temp1)
					)
				)
			)
		)
		(cond
			((not points)
				(cardRoom winner: self)
			)
			((or (not global317) (< points global317))
				(= global317 points)
			)
		)
	)
)

(class Crazy8sHumanPlayer of HumanPlayer
	(properties
		cycProp 0
		mustChooseASuit 0
		cardsTaken 0
		points 0
	)

	(method (init)
		(super init:)
		(if (not sittingOut)
			(= cardList (Crazy8sCardList new:))
			(= tempList (WL new:))
		)
	)

	(method (sortHand &tmp temp0 temp1 temp2)
		(if (not (cardList size:))
			(return)
		)
		(gGame setCursor: 996)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(for ((= temp1 1)) (< temp1 14) ((++ temp1))
				(if (>= (= temp2 (cardList hasCard: temp1 [global311 temp0])) 0)
					(if (== temp1 8)
						(tempList addToFront: (cardList at: temp2))
					else
						(tempList add: (cardList at: temp2))
					)
				)
			)
		)
		(cardList empty:)
		(for ((= temp2 0)) (< temp2 (tempList size:)) ((++ temp2))
			(cardList add: (tempList at: temp2))
			(if ((cardList at: temp2) loop:)
				(= place (= place1 (= place2 (+ temp2 1))))
			)
		)
		(tempList empty:)
		(self rePosition:)
		(gGame setCursor: 999)
	)

	(method (takeTurn)
		(if sittingOut
			(cardRoom cue:)
			(return)
		)
		(= global184 playerNum)
		(if (!= gTheCursor 999)
			(gGame setCursor: 999)
		)
		(if (and input global180)
			(if
				(and
					(or
						(and
							(== input 4)
							(or (== global854 13) (== global854 20992))
						)
						(== input 2)
					)
					(sortObj doit: evtX evtY)
				)
				(self sortHand:)
				(proc0_8)
				(= input 0)
				(= global179 1)
				(self cue:)
			else
				(proc0_8)
				(= global180 0)
				(self handleInput:)
			)
		else
			(if (gGoneTimer done:)
				(self playerSeemsToBeGone:)
			)
			(= global179 1)
			(self cue:)
		)
	)

	(method (printPass &tmp temp0)
		(= global305 (Print 1 0 #at -1 125 #dispose)) ; "Pass"
		(proc0_1 (* global407 18))
		(gModelessDialog dispose:)
		(++ global187)
	)

	(method (takeCard)
		(if sittingOut
			(gCardRoom cue:)
			(return)
		)
		(self setBase:)
		(= global176 dealFaceUp)
		(deck getCard:)
		(global173 faceUp: dealFaceUp)
		(gSndEffect number: (proc0_6 takeCardSound) playMaybe:)
		(gTheCardToss
			init:
				(deck dealX:)
				(deck dealY:)
				bX
				bY
				(if (>= (cardRoom state:) 7)
					[global417 (- global406 1)]
				else
					[global408 (- global405 1)]
				)
		)
	)

	(method (transferCard)
		(= global173 (cardList at: (- place1 1)))
		(deck setUpCardView:)
		(cardList delete: (cardList at: (- place1 1)))
		(= place1 0)
	)

	(method (rePosition)
		(super rePosition:)
		(if (and (== global177 8) (not local4) (== place 92))
			(= mustChooseASuit 1)
			(= cycProp 0)
			(proc0_8)
		)
	)

	(method (findRect param1 param2 param3)
		(= place -1)
		(if
			(and
				(>= evtY param1)
				(< evtY (+ param1 43))
				(>= evtX param2)
				(< evtX (+ param2 35))
			)
			(= place 91)
		)
		(if (== param3 (gDeck discardX:))
			(= param1 (gDeck discardY:))
		)
		(if
			(and
				(>= evtY param1)
				(< evtY (+ param1 43))
				(>= evtX param3)
				(< evtX (+ param3 35))
			)
			(= place 92)
		)
		(super findRect:)
	)

	(method (handleInput)
		(if (gTheCardToss mover:)
			(return)
		)
		(= global179 1)
		(= place2 place)
		(self findRect: (deck putY:) (deck putX:) (deck discardX:))
		(if (and (== global854 20992) (not (self dimCardIsAt:)))
			(= global854 13)
		)
		(if (and (== global854 20992) (== (self dimCardIsAt:) place))
			(= place 92)
			(= global854 13)
		)
		(if
			(or
				(and (== input 4) (or (== global854 13) (== global854 20992)))
				(== input 2)
			)
			(if (== place 91)
				(= global854 13)
				(if (and (> place1 0) ((cardList at: (- place1 1)) loop:))
					(-- pickedUpCard)
					(self invertCard: (- place1 1))
					(= place1 0)
				)
				(if (deck aCardToGet:)
					(if (< (cardList size:) 20)
						(= global180 0)
						(++ cardsTaken)
						(switch cardsTaken
							(1
								(proc0_4 373 playerNum)
							)
							(2
								(proc0_4 374 playerNum)
							)
							(3
								(proc0_4 371 playerNum)
							)
							(else
								(proc0_4 372 playerNum)
								(if (== cardsTaken 5)
									(gIntroSong number: (Random 32 35) play:)
								)
							)
						)
						(self takeCard:)
						(= input 0)
						(return)
					else
						(switch
							(Print ; "There Is a 20 Card Limit ! Do You Want To PLAY A CARD or PASS?"
								1
								1
								#at
								-1
								93
								#mode
								1
								#button
								{ PLAY }
								1
								#button
								{ PASS }
								2
							)
							(1
								(= global180 0)
								(= input 0)
								(self cue:)
								(return)
							)
							(2
								(self printPass: playerNum)
								(= global179 0)
							)
						)
					)
				else
					(self printPass: playerNum)
					(= global179 0)
				)
			)
			(if (== place 92)
				(= global854 13)
				(if place1
					(if
						(and
							(!= ((cardList at: (- place1 1)) cardRank:) 8)
							(!=
								((cardList at: (- place1 1)) cardRank:)
								global177
							)
							(!=
								((cardList at: (- place1 1)) cardSuit:)
								global178
							)
						)
						(if (and (self dimCardIsAt:) (!= input 1))
							(= place (= place1 (= place2 (self dimCardIsAt:))))
						)
						(gSndEffect number: 36 play:)
						(proc0_3 15 1)
						(= input 0)
						(gCardRoom cue:)
						(return)
					else
						(if
							(and
								(== (cardList size:) 1)
								(== ((cardList at: 0) cardRank:) 8)
							)
							(= local1 1)
						)
						(= global187 (= pickedUpCard 0))
						(= cardsTaken 0)
						(if (== ((cardList at: (- place1 1)) cardRank:) 8)
							(= local4 playerNum)
						)
						(self playCard: (cardList at: (- place1 1)))
						(global517 delete: (cardList at: (- place1 1)))
						(= input 0)
						(gCardRoom cue:)
						(return)
					)
				else
					(gSndEffect number: 36 play:)
					(proc0_3 14 1)
				)
			)
			(if (== global854 13)
				(= place2 place)
			)
			(cond
				((and (> place 0) (<= place (cardList size:)) (== place2 place))
					(= global854 13)
					(if ((cardList at: (- place 1)) loop:)
						(-- pickedUpCard)
						(= place1 0)
						(self invertCard: (- place 1))
					else
						(if pickedUpCard
							(-- pickedUpCard)
							(self invertCard: (- place1 1))
						)
						(++ pickedUpCard)
						(= place1 place)
						(self invertCard: (- place1 1))
					)
				)
				(
					(and
						(or
							(and (!= global854 20992) (>= place 0))
							(and (== global854 20992) (> place 0))
						)
						(<= place (cardList size:))
						(<= 1 place2 (cardList size:))
					)
					(self adjustLists: place place2)
					(if (self dimCardIsAt:)
						(= place (= place1 (= place2 (self dimCardIsAt:))))
					)
					(self rePosition:)
				)
			)
		)
		(if (and (self dimCardIsAt:) (!= input 1))
			(= place (= place1 (= place2 (self dimCardIsAt:))))
		)
		(= input 0)
		(gCardRoom cue:)
	)

	(method (dimCardIsAt &tmp temp0)
		(for ((= temp0 0)) (< temp0 (cardList size:)) ((++ temp0))
			(if ((cardList at: temp0) loop:)
				(return (+ temp0 1))
			)
		)
		(return 0)
	)

	(method (chooseASuit &tmp temp0)
		(= temp0 0)
		(if
			(or
				(== input 2)
				(and (== input 4) (or (== global854 13) (== global854 20992)))
			)
			(= nsL 131)
			(= nsR 189)
			(= nsT 49)
			(= nsB 67)
			(if (self inRect:)
				(cond
					((<= evtX (+ nsL 14))
						(= place 1)
					)
					((<= evtX (+ nsL 26))
						(= place 2)
					)
					((<= evtX (+ nsL 39))
						(= place 3)
					)
					(else
						(= place 4)
					)
				)
				(= cycProp -1)
				(= global178 (- place 1))
				(= mustChooseASuit 0)
				(deck chooseSuitOn: place)
				(proc0_5)
				(gGame setCursor: 997)
				(proc0_1 (* global407 12))
				(= local4 -1)
			else
				(gSndEffect number: 36 play:)
				(proc0_3 13 1)
				(++ temp0)
			)
			(= input 0)
		)
		(Wait 5)
		(if temp0
			(return)
		)
		(if (gGoneTimer done:)
			(gSndEffect number: 36 play:)
			(proc0_3 13 1)
			(gGoneTimer setSeconds: 15)
			(return)
		)
		(if (>= cycProp 0)
			(++ cycProp)
		)
		(if (== cycProp 20)
			(= cycProp 0)
		)
		(if (>= cycProp 0)
			(deck chooseSuitOn: (if (> cycProp 5) 0 else cycProp))
		)
	)

	(method (setPoints &tmp temp0 temp1)
		(= points 0)
		(if sittingOut
			(return)
		)
		(if (cardList size:)
			(for ((= temp0 0)) (< temp0 (cardList size:)) ((++ temp0))
				(cond
					((== (= temp1 ((cardList at: temp0) cardRank:)) 8)
						(+= points 50)
					)
					((>= temp1 10)
						(+= points 10)
					)
					(else
						(+= points temp1)
					)
				)
			)
		)
		(cond
			((not points)
				(cardRoom winner: self)
			)
			((or (not global317) (< points global317))
				(= global317 points)
			)
		)
	)
)

(instance room1 of Rm
	(properties)

	(method (init)
		(cardRoom init:)
	)

	(method (doit)
		(gGoneTimer doit:)
		(cond
			((not (timer1 done:))
				(timer1 doit:)
			)
			((not (global300 windowUp:))
				(gCardRoom doit:)
			)
		)
		(if
			(and
				(> (Abs (gPlayer1 altrEgo:)) 1000)
				(not (gPlayer1 sittingOut:))
			)
			((gPlayer1 altrEgo:) doit:)
		)
		(if
			(and
				(> (Abs (gPlayer2 altrEgo:)) 1000)
				(not (gPlayer2 sittingOut:))
			)
			((gPlayer2 altrEgo:) doit:)
		)
		(if
			(and
				(> (Abs (gPlayer3 altrEgo:)) 1000)
				(not (gPlayer3 sittingOut:))
			)
			((gPlayer3 altrEgo:) doit:)
		)
		(global300 doit:)
	)

	(method (handleEvent event param2)
		(if (== argc 2)
			(switch param2
				(1281
					(gGame setCursor: 997)
					((ScriptID 881) doit:) ; crazy8sRules
					(DisposeScript 881)
					(event claimed: 1)
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
	(properties)

	(method (init)
		(AddMenu { Crazy Eights } {Rules `^r})
		(MenuBar draw:)
		(= global517 inList)
		(= global264 ScoreCard)
		(= gPlayer0 player0)
		(= gPlayer1 player1)
		(= gPlayer2 player2)
		(= gPlayer3 player3)
		(= gDeck deck)
		(= gCardRoom cardRoom)
		(= global197 endThrow)
		(super init:)
		(if (> numActivePlayers 2)
			(= global174 5)
		else
			(= global174 7)
		)
		(Load rsVIEW 152)
		(Load rsVIEW 153)
		(Load rsVIEW 154)
		(Load rsVIEW 155)
		(Load rsVIEW 52)
		(Load rsVIEW 53)
		(Load rsVIEW 54)
		(Load rsVIEW 55)
		(Load rsVIEW 156)
		(Load rsVIEW 162)
		(Load rsSOUND 100)
		(Load rsSOUND 101)
		(Load rsSOUND 102)
		(Load rsSOUND 103)
		(Load rsSOUND 104)
		(Load rsSOUND 105)
		(Load rsSOUND 27)
		(Load rsSOUND 36)
		(Load rsSOUND 32)
		(Load rsSOUND 33)
		(Load rsSOUND 34)
		(Load rsSOUND 35)
	)

	(method (doit &tmp temp0 temp1)
		(switch state
			(0
				(if (not (gPlayer1 sittingOut:))
					(if (not global186)
						(++ global186)
						((player1 altrEgo:) init: player1)
					)
					(if
						(and
							((player1 altrEgo:) expressions:)
							(not (((player1 altrEgo:) expressions:) size:))
							(== (gIntroSong state:) 0)
						)
						(self cue:)
					)
				else
					(self cue:)
				)
			)
			(1
				(if (not (gPlayer2 sittingOut:))
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
				else
					(self cue:)
				)
			)
			(2
				(if (not (gPlayer3 sittingOut:))
					(if (not global186)
						(++ global186)
						((player3 altrEgo:) init: player3)
					)
					(if
						(and
							((player3 altrEgo:) expressions:)
							(not (((player3 altrEgo:) expressions:) size:))
							(== (gIntroSong state:) 0)
						)
						(self cue:)
					)
				else
					(self cue:)
				)
			)
			(3
				(if (not global186)
					(++ global186)
					(if global508
						(= global508 0)
						(if (Print 1 2 #button {Yes} 1 #button {No} 0) ; "Reset Scores?"
							(gPlayerList eachElementDo: #gamePoints 0)
						)
					)
					(gSndEffect
						number:
							(proc0_6
								((gPlayerList at: currentPlayer) takeCardSound:)
							)
						playMaybe:
					)
					((gPlayerList at: currentPlayer) takeCard:)
				)
			)
			(4
				((gPlayerList at: currentPlayer) addCard:)
				(if (not ((gPlayerList at: currentPlayer) playerNum:))
					(gPlayer0 updateCursorCoords:)
				)
				(= global186 0)
				(self cue:)
			)
			(5
				(if (not global186)
					(++ global186)
					(deck showDeck: 0)
					(deck turnUpCard: endThrow)
				)
			)
			(6
				(= global185 1)
				(deck setUpCardView:)
				(deck resetDealXY:)
				(= global179 0)
				(= global180 1)
				(= global186 0)
				(= global317 (= winner 0))
				(= local1 0)
				(= global187 0)
				(proc0_5)
				(gGame setCursor: 997)
				(proc0_8)
				(proc0_1 (* global407 24))
				(self cue:)
			)
			(7
				(cond
					((player0 mustChooseASuit:)
						(player0 chooseASuit:)
					)
					((== global187 numActivePlayers)
						(= global181 1)
						(self cue:)
					)
					((not global186)
						(++ global186)
						(= local3 0)
						((gPlayerList at: currentPlayer) takeTurn:)
					)
				)
			)
			(8
				(if (and (== global184 3) (not (gPlayer0 sittingOut:)))
					(self cue:)
				else
					(if
						(and
							((gPlayerList at: currentPlayer) playerNum:)
							(!= gTheCursor 997)
							(not (gPlayer0 mustChooseASuit:))
						)
						(gGame setCursor: 997)
					)
					(if (not ((gPlayerList at: currentPlayer) sittingOut:))
						(proc0_1 (* global407 24))
					)
					(self cue:)
				)
			)
			(9
				(switch global184
					(1
						((player1 altrEgo:) say: (+ 6 local0))
					)
					(2
						((player2 altrEgo:) say: (+ 6 local0))
					)
					(3
						((player3 altrEgo:) say: (+ 6 local0))
					)
				)
				(self cue:)
			)
			(10
				(sortObj init: 0)
				(gPlayerList eachElementDo: #flipCards)
				(gPlayerList eachElementDo: #setPoints)
				(self cue:)
			)
			(11
				(proc0_5)
				(if winner
					(= local2
						(/
							(= local2
								(+
									(gPlayer0 points:)
									(gPlayer1 points:)
									(gPlayer2 points:)
									(gPlayer3 points:)
								)
							)
							(- numActivePlayers 1)
						)
					)
					(winner gamePoints: (+ (winner gamePoints:) local2))
					(if (!= winner gPlayer0)
						((winner altrEgo:) say: 10 1 bigSmile: 1 bigSmile:)
						(gIntroSong number: ((winner altrEgo:) song:) play:)
					else
						(proc0_3 11 1)
						(gIntroSong number: 27 play:)
					)
					(proc0_4 377 (winner playerNum:))
				else
					(= temp1 0)
					(= local2 0)
					(if (== (gPlayer0 points:) global317)
						(++ temp1)
						(= winner gPlayer0)
					else
						(+= local2 (gPlayer0 points:))
					)
					(if (== (gPlayer1 points:) global317)
						(++ temp1)
						(= winner gPlayer1)
					else
						(+= local2 (gPlayer1 points:))
					)
					(if (== (gPlayer2 points:) global317)
						(++ temp1)
						(= winner gPlayer2)
					else
						(+= local2 (gPlayer2 points:))
					)
					(if (== (gPlayer3 points:) global317)
						(++ temp1)
						(= winner gPlayer3)
					else
						(+= local2 (gPlayer3 points:))
					)
					(if
						(<
							(= local2
								(/
									(/
										(- local2 (* global317 temp1))
										(- numActivePlayers temp1)
									)
									temp1
								)
							)
							0
						)
						(= local2 0)
					)
					(if (== (gPlayer0 points:) global317)
						(gPlayer0
							gamePoints: (+ (gPlayer0 gamePoints:) local2)
						)
					)
					(if (== (gPlayer1 points:) global317)
						(gPlayer1
							gamePoints: (+ (gPlayer1 gamePoints:) local2)
						)
					)
					(if (== (gPlayer2 points:) global317)
						(gPlayer2
							gamePoints: (+ (gPlayer2 gamePoints:) local2)
						)
					)
					(if (== (gPlayer3 points:) global317)
						(gPlayer3
							gamePoints: (+ (gPlayer3 gamePoints:) local2)
						)
					)
					(if (>= temp1 2)
						(Printf 1 3 temp1 local2) ; "There was a tie between %d players. All winners receive %d points."
						(= winner 0)
					)
					(if winner
						(if (!= winner gPlayer0)
							((winner altrEgo:) say: 10 1 bigSmile: 1 bigSmile:)
							(gIntroSong number: ((winner altrEgo:) song:) play:)
						else
							(proc0_3 11 1)
							(gIntroSong number: 27 play:)
						)
						(proc0_4 377 (winner playerNum:))
					)
				)
				(self cue:)
			)
			(12
				(if (not (gPlayer1 sittingOut:))
					((gPlayer1 altrEgo:) clearExps: noExp:)
				)
				(if (not (gPlayer2 sittingOut:))
					((gPlayer2 altrEgo:) clearExps: noExp:)
				)
				(if (not (gPlayer3 sittingOut:))
					((gPlayer3 altrEgo:) clearExps: noExp:)
				)
				(self cue:)
			)
			(13
				(if ((gPlayer0 cardList:) size:)
					(for
						((= temp0 0))
						(< temp0 ((gPlayer0 cardList:) size:))
						((++ temp0))
						
						(global517 delete: ((gPlayer0 cardList:) at: temp0))
					)
				)
				(proc0_1 30)
				(scoreObj display:)
				(if global509
					(if (!= global509 gPlayer0)
						((global509 altrEgo:) say: 16 1)
						(gIntroSong number: ((global509 altrEgo:) song:) play:)
					else
						(proc0_3 17 1)
						(proc0_4 377 (global509 playerNum:))
						(gIntroSong number: 27 play:)
					)
					(gPlayerList eachElementDo: #gamePoints 0)
					(= global509 0)
				)
				(self cue:)
			)
			(14
				(self newDeal:)
				(self cue:)
			)
		)
	)

	(method (cue &tmp temp0)
		(switch state
			(0
				(= global186 0)
				(++ state)
			)
			(1
				(= global186 0)
				(++ state)
			)
			(2
				(= global186 0)
				(++ state)
			)
			(3
				(++ state)
			)
			(4
				(++ currentPlayer)
				(if (> currentPlayer 3)
					(= currentPlayer 0)
				)
				(if (== (++ global175) (* global174 numPlayers))
					(++ state)
				else
					(= state 3)
				)
			)
			(5
				(++ state)
			)
			(6
				(player0 input: 0)
				(sortObj init: 1)
				(++ state)
			)
			(7
				(proc0_5)
				(if global181
					(= global181 0)
					(+= state 3)
				else
					(= global186 0)
					(= global180 1)
					(if global179
						(= global179 0)
					else
						(= temp0
							(switch global184
								(0
									(gPlayer0 sittingOut:)
								)
								(1
									(gPlayer1 sittingOut:)
								)
								(2
									(gPlayer2 sittingOut:)
								)
								(3
									(gPlayer3 sittingOut:)
								)
							)
						)
						(if
							(and
								(not local3)
								(not temp0)
								global184
								(== ((deck upCardView:) cardRank:) 8)
							)
							(+= state 2)
						)
						(++ currentPlayer)
						(if (> currentPlayer 3)
							(proc0_8)
							(= currentPlayer 0)
							(player0 input: 0)
						)
						(if
							(and
								currentPlayer
								(or
									(!= ((deck upCardView:) cardRank:) 8)
									(!= currentPlayer 1)
								)
							)
							(proc0_5)
						)
						(if (!= state 9)
							(++ state)
						)
					)
				)
			)
			(8
				(= state 7)
			)
			(9
				(= state 7)
			)
			(10
				(++ state)
			)
			(11
				(++ state)
			)
			(12
				(++ state)
			)
			(13
				(++ state)
			)
			(14
				(= state 3)
			)
		)
	)

	(method (removeViews)
		(deck showDeck: 5)
		(gPlayerList eachElementDo: #giveUpCards)
		((deck upCardView:) erase: 4)
		(deck plotCard: (deck upCardView:) 5)
		(deck chooseSuitOff:)
		(deck upCardView: 0)
	)

	(method (newDeal)
		(super newDeal:)
		(self newDeal2:)
		(deck beginFlag: 1)
		(player0 mustChooseASuit: 0)
	)
)

(instance endThrow of EndThrow
	(properties)

	(method (cue)
		(super cue:)
		(if (== global184 99)
			(gCardRoom cue:)
		)
	)
)

(instance player0 of Crazy8sHumanPlayer
	(properties
		dealFromY 180
	)
)

(instance player1 of Crazy8sComputerPlayer
	(properties
		playerNum 1
		dealFromX -20
		overlapX 0
		baseX 6
		takeCardSound 101
		playCardSound 104
		altrEgoX 64
		altrEgoY 108
	)
)

(instance player2 of Crazy8sComputerPlayer
	(properties
		playerNum 2
		dealFromY 0
		overlapY 0
		baseY 4
		altrEgoX 100
		altrEgoY 37
	)
)

(instance player3 of Crazy8sComputerPlayer
	(properties
		playerNum 3
		dealFromX 340
		overlapX 0
		baseX 279
		speakFrom 1
		takeCardSound 102
		playCardSound 105
		altrEgoX 256
		altrEgoY 108
	)
)

(instance deck of Deck
	(properties
		origPutX 1
		origPutY 113
		putX 74
		putY 113
		cursorZ 74
	)
)

(instance timer1 of Dly
	(properties)
)

(instance scoreObj of ScoreCard
	(properties
		y 62
		title {CRAZY EIGHTS SCORECARD}
	)

	(method (display &tmp [temp0 200] temp200 temp201 temp202 temp203 temp204)
		(gGame setCursor: 999)
		(= global199 (Format @temp0 1 4)) ; "Position Name  Points  ------------------------"
		(if (not (gPlayer1 sittingOut:))
			(StrCat global199 { West______})
			(StrCat global199 ((gPlayer1 altrEgo:) name:))
			(StrCat global199 (Format @global520 1 5 (gPlayer1 gamePoints:))) ; "%3d"
			(StrCat global199 {\n})
		)
		(if (not (gPlayer2 sittingOut:))
			(StrCat global199 { North_____})
			(StrCat global199 ((gPlayer2 altrEgo:) name:))
			(StrCat global199 (Format @global520 1 5 (gPlayer2 gamePoints:))) ; "%3d"
			(StrCat global199 {\n})
		)
		(if (not (gPlayer3 sittingOut:))
			(StrCat global199 { East______})
			(StrCat global199 ((gPlayer3 altrEgo:) name:))
			(StrCat global199 (Format @global520 1 5 (gPlayer3 gamePoints:))) ; "%3d"
			(StrCat global199 {\n})
		)
		(if (not (gPlayer0 sittingOut:))
			(StrCat global199 { South_____})
			(StrCat global199 @global138)
			(StrCat global199 (Format @global520 1 5 (gPlayer0 gamePoints:))) ; "%3d"
			(StrCat global199 {\n})
		)
		(StrCat global199 { ------------------------})
		(StrCat global199 {\n})
		(if (== global448 2)
			(StrCat global199 (Format @global520 1 6 local2)) ; "Points This Hand: %d"
		else
			(StrCat global199 (Format @global520 1 7 local2)) ; "Average Pts. This Hand: %d"
		)
		(StrCat global199 {\n})
		(= global305 (Print global199 #font sFont #title title #at x y #dispose))
		(proc0_1 12600)
		(gModelessDialog dispose:)
		(= temp200 (gPlayer0 gamePoints:))
		(= temp201 (gPlayer1 gamePoints:))
		(= temp202 (gPlayer2 gamePoints:))
		(= temp203 (gPlayer3 gamePoints:))
		(if (>= (= temp204 (localproc_0 temp200 temp201 temp202 temp203)) 100)
			(= global509
				(switch temp204
					(temp200 gPlayer0)
					(temp201 gPlayer1)
					(temp202 gPlayer2)
					(temp203 gPlayer3)
				)
			)
		)
	)
)

(instance sortObj of GO
	(properties
		x 248
		y 160
		view 162
		cursorX 260
		cursorY 170
	)

	(method (init param1)
		(= onOrOff param1)
		(proc0_2 view 0 onOrOff x y)
		(if onOrOff
			(global517 add: self)
		else
			(global517 delete: self)
		)
	)

	(method (doit param1 param2)
		(if global184
			(return 0)
		)
		(if (and onOrOff (<= x param1 (+ x 27)) (<= y param2 (+ y 12)))
			(return 1)
		)
		(return 0)
	)
)

(instance inList of InputList
	(properties)
)

