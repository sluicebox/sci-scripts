;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3)
(include sci.sh)
(use Main)
(use n018)
(use HeartsCardList)
(use Interface)
(use CursorCoords)
(use DisplayBox)
(use Game)
(use Menu)
(use System)

(public
	room3 0
	proc3_1 1
)

(local
	local0
)

(procedure (localproc_0 param1 &tmp temp0)
	(= temp0
		(switch param1
			(0 player0)
			(1 player1)
			(2 player2)
			(3 player3)
			(else 0)
		)
	)
	(if (temp0 sittingOut:)
		(= temp0 0)
	)
	(return temp0)
)

(procedure (proc3_1 param1)
	(= global270 (localproc_0 param1))
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

(class Deck of CardDeck
	(properties
		redBacks 1
	)

	(method (init &tmp temp0 [temp1 57])
		(super init:)
		(for ((= temp0 4)) (< temp0 56) ((++ temp0))
			(if (or (== (gCardRoom numActivePlayers:) 4) (!= temp0 10))
				(= [temp1 temp0] (Clone c))
				([temp1 temp0] cardRank: (/ temp0 4) cardSuit: (mod temp0 4))
			)
		)
		(for ((= temp0 4)) (< temp0 56) ((++ temp0))
			(if (or (== (gCardRoom numActivePlayers:) 4) (!= temp0 10))
				(theDeck add: [temp1 temp0])
			)
		)
		(self shuffle:)
	)

	(method (playedCard param1 param2 &tmp temp0)
		(for ((= temp0 0)) (< temp0 (workingDeck size:)) ((++ temp0))
			(if
				(and
					(== ((workingDeck at: temp0) cardRank:) param1)
					(== ((workingDeck at: temp0) cardSuit:) param2)
				)
				(return 1)
			)
		)
		(return 0)
	)

	(method (remaining param1 &tmp temp0 temp1 temp2)
		(= temp2 0)
		(if (and (== (gCardRoom numActivePlayers:) 3) (== param1 2))
			(++ temp2)
		)
		(= temp0 (= temp1 0))
		(while (< temp1 (workingDeck size:))
			(if (== ((workingDeck at: temp1) cardSuit:) param1)
				(++ temp0)
			)
			(++ temp1)
		)
		(return (- (- 13 temp0) temp2))
	)

	(method (anyHigherRemaining param1 param2 &tmp temp0 temp1 temp2)
		(= temp2 0)
		(if (and (== (gCardRoom numActivePlayers:) 3) (== param1 2))
			(++ temp2)
		)
		(= temp0 (= temp1 0))
		(while (< temp1 (workingDeck size:))
			(if
				(and
					(== ((workingDeck at: temp1) cardSuit:) param1)
					(or
						(> ((workingDeck at: temp1) cardRank:) param2)
						(== ((workingDeck at: temp1) cardRank:) 1)
					)
				)
				(++ temp0)
			)
			(++ temp1)
		)
		(return (- (- 14 (+ param2 temp0)) temp2))
	)
)

(class HeartsCommon of Obj
	(properties)

	(method (showPoints param1 param2 &tmp temp0 temp1)
		(= temp0 0)
		(for ((= global264 2)) (< global264 16) ((++ global264))
			(if
				(==
					[global250 (= temp1 (mod global264 14))]
					(param1 playerNum:)
				)
				(self display: temp1 (param1 playerNum:) temp0 param2)
				(++ temp0)
			)
		)
	)

	(method (display param1 param2 param3 param4 &tmp temp0 temp1)
		(switch param2
			(0
				(= temp0 (+ (player0 showAtX:) (* param3 7)))
				(= temp1 (player0 showAtY:))
			)
			(1
				(= temp1 (+ (player1 showAtY:) (* param3 7)))
				(= temp0 (player1 showAtX:))
			)
			(2
				(= temp0 (+ (player2 showAtX:) (* param3 7)))
				(= temp1 (player2 showAtY:))
			)
			(3
				(= temp1 (+ (player3 showAtY:) (* param3 7)))
				(= temp0 (player3 showAtX:))
			)
		)
		(if (not param4)
			(proc0_2 161 2 0 temp0 temp1)
		else
			(proc0_2
				(if (!= param1 1) 155 else 152)
				0
				(if (!= param1 1)
					(if param1 param1 else 1)
				else
					12
				)
				temp0
				temp1
			)
		)
	)

	(method (eraseLosers param1 param2 param3 param4 param5)
		(if (param1 sittingOut:)
			(gCardRoom cue:)
			(return)
		)
		(if (!= global172 (param1 playerNum:))
			(proc0_2 161 2 0 param4 param5)
			(= global184 4)
			(gSndEffect number: (proc0_6 (param1 playCardSound:)) playMaybe:)
			(gTheCardToss
				init: param4 param5 param2 param3 [global417 (- global406 1)]
			)
		else
			(gCardRoom cue:)
		)
	)

	(method (playerToPassTo param1 &tmp temp0 temp1 temp2)
		(if (> (= temp0 (= temp1 (gCardRoom passDir:))) 1)
			(= temp0 (- 5 temp0))
		)
		(switch (= temp2 (mod (+ temp0 (param1 playerNum:)) 4))
			(0
				(if (player0 sittingOut:)
					(if (== temp1 1)
						(= temp2 player1)
					else
						(= temp2 player3)
					)
				else
					(= temp2 player0)
				)
			)
			(1
				(if (player1 sittingOut:)
					(if (== temp1 1)
						(= temp2 player2)
					else
						(= temp2 player0)
					)
				else
					(= temp2 player1)
				)
			)
			(2
				(if (player2 sittingOut:)
					(if (== temp1 1)
						(= temp2 player3)
					else
						(= temp2 player1)
					)
				else
					(= temp2 player2)
				)
			)
			(3
				(if (player3 sittingOut:)
					(if (== temp1 1)
						(= temp2 player0)
					else
						(= temp2 player2)
					)
				else
					(= temp2 player3)
				)
			)
		)
		(param1 passToPlayer: temp2)
	)

	(method (passCards param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(if (param1 sittingOut:)
			(return)
		)
		(= temp0 (param1 card1:))
		(= temp1 (param1 card2:))
		(= temp2 (param1 card3:))
		(for ((= global264 0)) (< global264 2) ((++ global264))
			(if (> temp0 temp1)
				(= temp3 temp0)
				(= temp0 temp1)
				(= temp1 temp3)
			)
			(if (> temp1 temp2)
				(= temp3 temp1)
				(= temp1 temp2)
				(= temp2 temp3)
			)
		)
		(= temp3 ((param1 cardList:) at: (- (param1 card1:) 1)))
		(= temp4 ((param1 cardList:) at: (- (param1 card2:) 1)))
		(= temp5 ((param1 cardList:) at: (- (param1 card3:) 1)))
		(= temp6 ((param1 passToPlayer:) dealFaceUp:))
		(= temp8 ((param1 passToPlayer:) cardList:))
		(= temp7 (param1 cardList:))
		(temp3 loop: 0 faceUp: temp6)
		(temp4 loop: 0 faceUp: temp6)
		(temp5 loop: 0 faceUp: temp6)
		(temp8 add: temp3)
		(temp8 add: temp4)
		(temp8 add: temp5)
		(temp7 delete: temp3)
		(temp7 delete: temp4)
		(temp7 delete: temp5)
		(if (== param1 gPlayer0)
			(global517 delete: temp3 temp4 temp5)
		)
	)
)

(class HeartsHumanPlayer of HumanPlayer
	(properties
		card1 -1
		card2 -1
		card3 -1
		passToPlayer 0
		discardX 0
		discardY 0
		handPoints 0
		showAtX 0
		showAtY 0
		outOfSpades 0
		outOfClubs 0
		outOfDiamonds 0
		outOfHearts 0
	)

	(method (dimCardIsAt &tmp temp0)
		(for ((= temp0 0)) (< temp0 (cardList size:)) ((++ temp0))
			(if ((cardList at: temp0) loop:)
				(return (+ temp0 1))
			)
		)
		(return 0)
	)

	(method (numDimCards &tmp temp0 temp1)
		(for ((= temp0 (= temp1 0))) (< temp0 (cardList size:)) ((++ temp0))
			(+= temp1 ((cardList at: temp0) loop:))
		)
		(return temp1)
	)

	(method (findRect param1 param2)
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
		(super findRect:)
	)

	(method (init)
		(super init:)
		(if (not sittingOut)
			((= cardList (HeartsCardList new:)) add:)
			((= tempList (HeartsCardList new:)) add:)
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

	(method (showPoints param1)
		(if (not sittingOut)
			(common showPoints: self param1)
		)
	)

	(method (addPoints)
		(+= gamePoints handPoints)
		(= handPoints 0)
	)

	(method (playCard param1 &tmp temp0 temp1)
		(= temp0 (cardList atRank: param1))
		(if (== (= temp1 (cardList atSuit: param1)) 3)
			(++ global169)
			(++ global449)
			(if (== temp0 1)
				(= [global250 0] -1)
			else
				(= [global250 temp0] -1)
			)
		)
		(if (and (not temp1) (== temp0 12))
			(+= global169 13)
			(+= global449 13)
			(= global265 1)
			(= [global250 1] -1)
			(gIntroSong number: (Random 32 35) play:)
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
		((deck workingDeck:) add: (cardList at: param1))
		(super playCard: (cardList at: param1))
	)

	(method (countCards))

	(method (handleInput &tmp temp0)
		(cardList setSize:)
		(= global179 1)
		(= place2 place)
		(self findRect: discardY discardX)
		(if (== global854 20992)
			(if (not (self dimCardIsAt:))
				(= global854 13)
			)
			(if (and (self numDimCards:) (== (self dimCardIsAt:) place))
				(= place 91)
				(= global854 13)
			)
		)
		(if (and (localproc_1 input) (!= input 1))
			(if (== place 91)
				(= global854 13)
				(if (== pickedUpCard 1)
					(= global179 0)
					(= pickedUpCard (= input 0))
					(if (== global170 -1)
						(if
							(and
								(not global275)
								(or (!= global272 1) (!= global271 2))
							)
							(gSndEffect number: 36 play:)
							(proc0_3 8)
							(= global179 (= pickedUpCard 1))
							(if (and (self dimCardIsAt:) (!= input 1))
								(= place (= place2 (self dimCardIsAt:)))
								(= place1 (- place 1))
							)
							(gCardRoom cue:)
							(return)
						)
						(if
							(and
								(== global272 3)
								(== (deck remaining: 3) 13)
								(!= global308 (cardList howManyOfSuit: 3))
							)
							(= pickedUpCard 1)
							(gSndEffect number: 36 play:)
							(proc0_3 9)
							(= global179 1)
							(if (and (self dimCardIsAt:) (!= input 1))
								(= place (= place2 (self dimCardIsAt:)))
								(= place1 (- place 1))
							)
							(gCardRoom cue:)
							(return)
						else
							(= global170 global272)
							(= global172 0)
							(if (== (= global171 global271) 1)
								(= global171 14)
							)
						)
					else
						(if
							(and
								(!= global272 global170)
								(cardList howManyOfSuit: global170)
							)
							(gSndEffect number: 36 play:)
							(proc0_3 10)
							(= global179 (= pickedUpCard 1))
							(if (and (self dimCardIsAt:) (!= input 1))
								(= place (= place2 (self dimCardIsAt:)))
								(= place1 (- place 1))
							)
							(gCardRoom cue:)
							(return)
						)
						(if
							(and
								(or (> global271 global171) (== global271 1))
								(== global272 global170)
							)
							(if (== (= global171 global271) 1)
								(= global171 14)
							)
							(= global172 0)
							(= place (self dimCardIsAt:))
							(= place1 (- place 1))
						)
					)
					(playACard status0: 0)
					(= place2 (+ place1 1))
					(self playCard: place1)
					(global517 delete: (cardList at: place1) playACard)
					(if (and (self dimCardIsAt:) (!= input 1))
						(= place (= place1 (= place2 (self dimCardIsAt:))))
					)
					(return)
				else
					(gSndEffect number: 36 play:)
					(proc0_3 11)
				)
				(= place -1)
			)
			(if (== global854 13)
				(= place2 place)
			)
			(cond
				((and (> place 0) (<= place global308) (== place2 place))
					(= global854 13)
					(if ((cardList at: (- place 1)) loop:)
						(-- pickedUpCard)
						(self invertCard: (- place 1))
						(= place1 -1)
					else
						(if pickedUpCard
							(-- pickedUpCard)
							(self invertCard: place1)
						)
						(++ pickedUpCard)
						(self invertCard: (- place 1))
						(= place1 (- place 1))
						(= global272 (cardList atSuit: place1))
						(= global271 (cardList atRank: place1))
					)
				)
				(
					(and
						(or
							(and (!= global854 20992) (>= place 0))
							(and (== global854 20992) (>= place 0))
						)
						(<= place global308)
						(<= 1 place2 global308)
					)
					(self adjustLists: place place2)
					(self rePosition:)
					(for
						((= global264 0))
						(< global264 global308)
						((++ global264))
						
						(if ((cardList at: global264) loop:)
							(= place1 global264)
							(= place (+ place1 1))
							(= place2 place)
						)
					)
				)
			)
		)
		(if (and (self dimCardIsAt:) (!= input 1))
			(= place (= place2 (self dimCardIsAt:)))
			(= place1 (- place 1))
		)
		(= input 0)
		(gCardRoom cue:)
	)

	(method (sortHand &tmp temp0 temp1 temp2 temp3)
		(if (<= (cardList size:) 1)
			(return)
		)
		(gGame setCursor: 996)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(for ((= temp1 2)) (< temp1 15) ((++ temp1))
				(= temp3 (if (== temp1 14) 1 else temp1))
				(if (>= (= temp2 (cardList hasCard: temp3 [global311 temp0])) 0)
					(tempList add: (cardList at: temp2))
				)
			)
		)
		(cardList empty:)
		(for ((= temp2 0)) (< temp2 (tempList size:)) ((++ temp2))
			(cardList add: (tempList at: temp2))
			(if ((tempList at: temp2) loop:)
				(= place (= place1 (= place2 (+ temp2 1))))
				(= place1 (- place2 1))
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
		(if (not global276)
			(= global866 playerNum)
		)
		(playACard doit:)
		(if (and input global180)
			(if (and (localproc_1 input) (!= input 1) (sortObj doit: evtX evtY))
				(self sortHand:)
				(= input 0)
				(= global179 1)
				(self cue:)
			else
				(proc0_8)
				(= global180 0)
				(= global184 playerNum)
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

	(method (choosePassCards)
		(if sittingOut
			(self cue:)
			(return)
		)
		(if (!= gTheCursor 999)
			(gGame setCursor: 999)
		)
		(= global184 playerNum)
		(if (and input global180)
			(if (and (localproc_1 input) (!= input 1) (sortObj doit: evtX evtY))
				(self sortHand:)
				(= input 0)
				(= global179 1)
				(self cue:)
			else
				(proc0_8)
				(= global180 0)
				(self handleInputPass:)
			)
		else
			(if (gGoneTimer done:)
				(self playerSeemsToBeGone:)
			)
			(= global179 1)
			(self cue:)
		)
	)

	(method (passCards)
		(common passCards: self)
	)

	(method (adjustHand)
		(if sittingOut
			(return)
		)
		(self rePosition:)
		(global517
			add:
				(cardList at: (- (cardList size:) 1))
				(cardList at: (- (cardList size:) 2))
				(cardList at: (- (cardList size:) 3))
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

	(method (findThe3Cards &tmp temp0)
		(= global264 0)
		(= temp0 0)
		(while (< global264 (cardList size:))
			(if ((cardList at: global264) loop:)
				(switch (++ temp0)
					(1
						(= card1 (+ global264 1))
					)
					(2
						(= card2 (+ global264 1))
					)
					(3
						(= card3 (+ global264 1))
					)
				)
			)
			(++ global264)
		)
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
			init: (deck dealX:) (deck dealY:) bX bY [global408 (- global405 1)]
		)
	)

	(method (handleInputPass)
		(= global179 1)
		(= place2 place)
		(self findRect: (passTo y:) (passTo x:))
		(if
			(and
				(== global854 20992)
				(or
					(not (self dimCardIsAt:))
					(== (self dimCardIsAt:) place)
					(>= (self numDimCards:) 2)
				)
			)
			(= global854 13)
		)
		(if (and (localproc_1 input) (!= input 1))
			(if (== place 91)
				(if (== global855 4)
					(= global854 13)
				)
				(if (== pickedUpCard 3)
					(self findThe3Cards:)
					(common playerToPassTo: self)
					(= global179 0)
					(passTo doit: 0)
					(choose3 doit: 0)
					(= input 0)
					(= place1 -1)
					(gCardRoom cue:)
					(return)
				else
					(gSndEffect number: 36 play:)
					(proc0_3 12)
				)
				(= place -1)
			)
			(if (and (== global855 4) (== global854 13))
				(= place2 place)
			)
			(if
				(and
					(!= global854 20992)
					(>= global308 place2 1)
					(== pickedUpCard 3)
					(not ((cardList at: (- place2 1)) loop:))
					(== place2 place)
				)
				(gSndEffect number: 36 play:)
				(proc0_3 13)
				(= place -1)
			)
			(cond
				(
					(and
						(!= global854 20992)
						(>= global308 place 1)
						(or (== global854 13) (== place2 place))
					)
					(if ((cardList at: (- place 1)) loop:)
						(-- pickedUpCard)
						(passTo doit: 2)
						(self invertCard: (- place 1))
					else
						(++ pickedUpCard)
						(if (== pickedUpCard 3)
							(passTo doit: 1)
						)
						(self invertCard: (- place 1))
					)
				)
				(
					(or
						(and
							(== global854 20992)
							(== (self numDimCards:) 1)
							(= place2 (self dimCardIsAt:))
							(<= 0 place global308)
						)
						(and
							(== global855 2)
							(>= global308 place 0)
							(<= 1 place2 global308)
						)
					)
					(self adjustLists: place place2)
					(self rePosition:)
				)
			)
		)
		(if (and (self dimCardIsAt:) (!= input 1) (== pickedUpCard 1))
			(= place (= place2 (self dimCardIsAt:)))
			(= place1 (- place 1))
		)
		(= input 0)
		(gCardRoom cue:)
	)

	(method (mvCard)
		(= place 97)
		(if (!= global274 -1)
			(twoOfClubsLeads doit: 0)
		)
		(++ global276)
		(gSndEffect number: (proc0_6 playCardSound) playMaybe:)
		(gTheCardToss
			init: tmpx tmpy discardX discardY [global417 (- global406 1)]
		)
	)

	(method (eraseLosers param1 param2)
		(common eraseLosers: self param1 param2 discardX discardY)
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

(instance room3 of Rm
	(properties)

	(method (init)
		(cardRoom init:)
	)

	(method (doit)
		(gGoneTimer doit:)
		(if (not (global300 windowUp:))
			(gCardRoom doit:)
		)
		(if
			(and
				(> (Abs (gPlayer1 altrEgo:)) 1000)
				(not (gPlayer1 sittingOut:))
			)
			((player1 altrEgo:) doit:)
		)
		(if
			(and
				(> (Abs (gPlayer2 altrEgo:)) 1000)
				(not (gPlayer2 sittingOut:))
			)
			((player2 altrEgo:) doit:)
		)
		(if
			(and
				(> (Abs (gPlayer3 altrEgo:)) 1000)
				(not (gPlayer3 sittingOut:))
			)
			((player3 altrEgo:) doit:)
		)
		(global300 doit:)
	)

	(method (handleEvent event param2)
		(if (== argc 2)
			(switch param2
				(1537
					(gGame setCursor: 997)
					((ScriptID 883) doit:) ; heartsRules
					(DisposeScript 883)
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
	(properties
		passDir 1
	)

	(method (init &tmp temp0)
		(= temp0 (Graph grGET_COLOURS))
		(if (== 2 temp0)
			(Load rsVIEW 801)
		else
			(Load rsVIEW 800)
		)
		(AddMenu { Hearts } {Rules `#0})
		(MenuBar draw:)
		(proc0_7 130 899 13 14 15 16 17 18 19)
		(proc0_7 128 152 153 154 155 52 53 54 55 164 162)
		(= global517 inList)
		(= global264 ScoreCard)
		(= global239 0)
		(= gPlayer0 player0)
		(= gPlayer1 player1)
		(= gPlayer2 player2)
		(= gPlayer3 player3)
		(= gDeck deck)
		(= gCardRoom cardRoom)
		(= global197 endThrow)
		(= gCommon common)
		(= gTwoOfClubsLeads twoOfClubsLeads)
		(super init:)
		(if (== numActivePlayers 3)
			(= global174 17)
		else
			(= global174 13)
		)
	)

	(method (whoPlaysFirst param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(if (== ((gPlayerList at: temp0) playerNum:) param1)
				(= currentPlayer temp0)
			)
		)
	)

	(method (removeViews)
		(gPlayerList eachElementDo: #giveUpCards deck)
	)

	(method (newDeal)
		(super newDeal:)
		(self newDeal2:)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(switch state
			(0
				(if (not (gPlayer1 sittingOut:))
					(if (not global186)
						(++ global186)
						((player1 altrEgo:) init: player1)
					)
					(if
						(and
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
					(if gDebugOn
						(gPlayer1 dealFaceUp: 1)
						(gPlayer2 dealFaceUp: 1)
						(gPlayer3 dealFaceUp: 1)
					)
					(if
						(and
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
						(if (Print 3 0 #button {Yes} 1 #button {No} 0) ; "Reset Scores?"
							(gPlayerList eachElementDo: #gamePoints 0)
						)
					)
					((gPlayerList at: currentPlayer) takeCard:)
				)
			)
			(4
				((gPlayerList at: currentPlayer) addCard:)
				(if (not ((gPlayerList at: currentPlayer) playerNum:))
					(gPlayer0 updateCursorCoords:)
				)
				(= global186 (= local0 0))
				(proc0_8)
				(self cue:)
			)
			(5
				(if (not global186)
					(++ global186)
					((gPlayerList at: currentPlayer) choosePassCards:)
				)
			)
			(6
				(gPlayerList eachElementDo: #passCards)
				(self cue:)
			)
			(7
				(gPlayer1 adjustHand:)
				(self cue:)
			)
			(8
				(gPlayer2 adjustHand:)
				(self cue:)
			)
			(9
				(gPlayer3 adjustHand:)
				(self cue:)
			)
			(10
				(gPlayer0 adjustHand:)
				(twoOfClubsLeads doit: 1)
				(passingThe3Cards doit: 0)
				(self cue:)
			)
			(11
				(if (not global186)
					(++ global186)
					(gPlayerList eachElementDo: #countCards)
					(gPlayerList eachElementDo: #find2Clubs)
					(self handInit:)
					(= global169 (= global449 0))
					(= global172 0)
					(self cue:)
				)
				(gPlayer1 setTakeAllPlayer:)
				(gPlayer2 setTakeAllPlayer:)
				(gPlayer3 setTakeAllPlayer:)
			)
			(12
				(if
					(and
						(not ((gPlayerList at: currentPlayer) playerNum:))
						(not global240)
					)
					(if
						(or
							(== (player0 input:) 1)
							(and (== global854 13) (== (player0 input:) 4))
						)
						(return)
					else
						(player0 input: 0)
						(++ global240)
					)
				)
				(if (not global186)
					(++ global186)
					((gPlayerList at: currentPlayer) takeTurn:)
				)
			)
			(13
				(if (not global186)
					(++ global186)
					(if (not global447)
						(proc0_1 (* (- global407 1) 36))
					)
					(proc3_1 global172)
					(= temp0 (global270 discardX:))
					(= temp1 (global270 discardY:))
					((gPlayerList at: currentPlayer) eraseLosers: temp0 temp1)
				)
			)
			(14
				(if (not global186)
					(++ global186)
					(proc3_1 global172)
					(switch global172
						(0
							(= temp2 143)
							(= temp3 275)
						)
						(1
							(= temp2 -80)
							(= temp3 72)
						)
						(2
							(= temp2 143)
							(= temp3 -80)
						)
						(3
							(= temp2 400)
							(= temp3 72)
						)
					)
					(global270 eraseWinner: temp2 temp3)
					(global270
						handPoints: (+ (global270 handPoints:) global169)
					)
					(for ((= global264 0)) (< global264 14) ((++ global264))
						(if (== [global250 global264] -1)
							(= [global250 global264] global172)
						)
					)
					(if (== (global270 handPoints:) 26)
						(= local0 global270)
					)
				)
			)
			(15
				(gGame setCursor: 999)
				(sortObj init: 0)
				(if local0
					(gPlayerList eachElementDo: #add26 local0)
					(if (!= local0 gPlayer0)
						(gIntroSong number: ((local0 altrEgo:) song:) play:)
					else
						(gIntroSong number: 27 play:)
					)
				)
				(= local0 0)
				(gPlayerList eachElementDo: #showPoints 1)
				(gPlayer1 obvious: 0)
				(gPlayer2 obvious: 0)
				(gPlayer3 obvious: 0)
				(self cue:)
			)
			(16
				(++ global239)
				(if (not (gPlayer1 sittingOut:))
					((gPlayer1 altrEgo:) clearExps: noExp:)
				)
				(if (not (gPlayer2 sittingOut:))
					((gPlayer2 altrEgo:) clearExps: noExp:)
				)
				(if (not (gPlayer3 sittingOut:))
					((gPlayer3 altrEgo:) clearExps: noExp:)
				)
				(proc0_5)
				(gPlayerList eachElementDo: #addPoints)
				(scoreObj display:)
				(cond
					(global509
						(if (!= global509 gPlayer0)
							((global509 altrEgo:) say: 5 1)
							(gIntroSong
								number: ((global509 altrEgo:) song:)
								play:
							)
						else
							(proc0_3 6 1)
							(gIntroSong number: 27 play:)
						)
						(gPlayerList eachElementDo: #gamePoints 0)
						(= global509 0)
						(= passDir 1)
					)
					(
						(or
							(>= (gPlayer0 gamePoints:) 100)
							(>= (gPlayer1 gamePoints:) 100)
							(>= (gPlayer2 gamePoints:) 100)
							(>= (gPlayer3 gamePoints:) 100)
						)
						(proc0_3 7 1)
					)
				)
				(self cue:)
			)
			(17
				(gPlayerList eachElementDo: #showPoints 0)
				(self cue:)
			)
			(18
				(++ passDir)
				(if (> passDir (- numActivePlayers 1))
					(= passDir 0)
				)
				(self newDeal:)
				(self cue:)
			)
		)
	)

	(method (cue &tmp temp0)
		(switch state
			(4
				(++ currentPlayer)
				(if (> currentPlayer 3)
					(= currentPlayer 0)
				)
				(if (not ((deck theDeck:) size:))
					(= global185 1)
					(= global179 0)
					(= global180 1)
					(sortObj init: 1)
					(= counter 0)
					(if passDir
						(passTo doit: 2)
						(++ state)
					else
						(= state 6)
						(self cue:)
					)
				else
					(= state 3)
				)
			)
			(5
				(= global186 0)
				(= global180 1)
				(if global179
					(= global179 0)
				else
					(++ counter)
					(if (== counter 4)
						(++ state)
						(passingThe3Cards doit: 1)
					else
						(++ currentPlayer)
						(if (> currentPlayer 3)
							(= currentPlayer 0)
						)
						(if
							(and
								(not ((gPlayerList at: currentPlayer) playerNum:))
								(not (player0 sittingOut:))
							)
							(choose3 doit: 1)
						)
					)
				)
			)
			(11
				(= global441 (= global442 (= global443 (= global444 0))))
				(= global186 (= global276 (= global240 (= global275 0))))
				(player0 pickedUpCard: 0)
				(++ state)
			)
			(12
				(proc0_5)
				(= global186 (= global447 0))
				(if (!= global276 numActivePlayers)
					(= global180 1)
					(if global179
						(= global179 0)
					else
						(++ currentPlayer)
						(if (> currentPlayer 3)
							(proc0_8)
							(= currentPlayer 0)
						)
					)
				else
					(for ((= global264 0)) (< global264 4) ((++ global264))
						(if
							(==
								((gPlayerList at: global264) playerNum:)
								global172
							)
							(= currentPlayer global264)
							(break)
						)
					)
					(cond
						((>= global169 2)
							(if (!= (= temp0 (localproc_0 global172)) gPlayer0)
								(switch (Random 0 2)
									(0
										((temp0 altrEgo:) anger: 1)
									)
									(1
										((temp0 altrEgo:) shock: 1)
									)
									(2
										((temp0 altrEgo:) upset: 1)
									)
								)
							)
							(if (>= global169 13)
								(proc0_4 378 global172)
							)
						)
						((== global169 1)
							(for
								((= global264 0))
								(< global264 numActivePlayers)
								((++ global264))
								
								(if
									(and
										(!= global264 global172)
										(= temp0 (localproc_0 global264))
										(!= temp0 gPlayer0)
									)
									(switch (Random 0 8)
										(0
											((temp0 altrEgo:) smile: 1)
										)
										(1
											((temp0 altrEgo:) smirk: 1)
										)
										(2
											((temp0 altrEgo:) sly: 1)
										)
									)
								)
							)
						)
					)
					(= global441 (= global442 (= global443 (= global444 0))))
					(= global276 (= global180 0))
					(++ state)
				)
			)
			(13
				(++ global447)
				(= global186 0)
				(++ currentPlayer)
				(if (> currentPlayer 3)
					(= currentPlayer 0)
				)
				(if (== global447 4)
					(++ state)
				)
			)
			(14
				(= global186 0)
				(if (== (++ global275) global174)
					(++ state)
					(= global186 -1)
				else
					(= global170 -1)
					(= global180 1)
					(= global179 (= global169 (= global240 (= global447 0))))
					(gPlayer1 setTakeAllPlayer:)
					(gPlayer2 setTakeAllPlayer:)
					(gPlayer3 setTakeAllPlayer:)
					(= state 12)
				)
			)
			(18
				(= global184 0)
				(= state 3)
			)
			(else
				(++ state)
				(= global186 0)
			)
		)
	)

	(method (handInit)
		(for ((= global264 0)) (< global264 14) ((++ global264))
			(= [global250 global264] 0)
			(if (< global264 4)
				(proc3_1 global264)
				(if global270
					(global270 outOfSpades: 0)
					(global270 outOfClubs: 0)
					(global270 outOfDiamonds: 0)
					(global270 outOfHearts: 0)
				)
			)
		)
		(= global171 (= global265 0))
		(= global172 (= global170 -1))
	)
)

(instance player0 of HeartsHumanPlayer
	(properties
		discardX 143
		discardY 97
		showAtX 113
		showAtY 143
	)
)

(instance player1 of HeartsComputerPlayer
	(properties
		playerNum 1
		dealFromX -20
		overlapX 0
		baseX 8
		altrEgo 4
		takeCardSound 101
		playCardSound 104
		discardX 105
		discardY 73
		showAtX 9
		showAtY 17
		altrEgoX 64
		altrEgoY 108
	)
)

(instance player2 of HeartsComputerPlayer
	(properties
		playerNum 2
		dealFromY 0
		overlapY 0
		baseY 4
		altrEgo 5
		discardX 143
		discardY 51
		showAtX 113
		showAtY 4
		altrEgoX 100
		altrEgoY 37
	)
)

(instance player3 of HeartsComputerPlayer
	(properties
		playerNum 3
		dealFromX 340
		overlapX 0
		baseX 277
		speakFrom 1
		altrEgo 16
		takeCardSound 102
		playCardSound 105
		discardX 181
		discardY 73
		showAtX 277
		showAtY 17
		altrEgoX 256
		altrEgoY 108
	)
)

(instance deck of Deck
	(properties
		origPutX 1
	)
)

(instance passTo of GO
	(properties
		x 93
		y 97
		view 164
		cursorX 113
		cursorY 105
	)

	(method (doit param1)
		(proc0_2
			view
			param1
			(if param1
				(gCardRoom passDir:)
			else
				0
			)
			x
			y
		)
		(if param1
			(global517 add: self)
		else
			(global517 delete: self)
		)
	)
)

(instance choose3 of GO
	(properties
		x 180
		y 131
		view 164
	)

	(method (doit param1)
		(proc0_2 view 3 (if param1 0 else 2) x y)
	)
)

(instance passingThe3Cards of GO
	(properties
		x 160
		y 138
		view 164
	)

	(method (doit param1)
		(proc0_2 view 3 (- 2 param1) x y)
	)
)

(instance twoOfClubsLeads of GO
	(properties
		x 143
		y 50
		view 164
	)

	(method (doit param1)
		(= global274 -1)
		(proc0_2 view 0 param1 x y)
	)
)

(instance playACard of GO
	(properties
		view 164
		cursorX 167
		cursorY 112
	)

	(method (doit)
		(if (and (not (global300 windowUp:)) (not status0))
			(++ status0)
			(proc0_2
				view
				0
				(if global276 2 else 3)
				(player0 discardX:)
				(player0 discardY:)
			)
			(global517 add: self)
			(proc0_5)
		)
	)
)

(instance common of HeartsCommon
	(properties)
)

(instance endThrow of EndThrow
	(properties)
)

(instance scoreObj of ScoreCard
	(properties
		y 75
		title {HEARTS SCORECARD}
	)

	(method (display &tmp [temp0 200] temp200 temp201 temp202 temp203)
		(= global199 (Format @temp0 3 1)) ; "Position Name  Points  ------------------------"
		(if (not (gPlayer1 sittingOut:))
			(StrCat global199 { Left______})
			(StrCat global199 ((gPlayer1 altrEgo:) name:))
			(StrCat global199 (Format @global520 3 2 (gPlayer1 gamePoints:))) ; "%3d"
			(StrCat global199 {\n})
		)
		(if (not (gPlayer2 sittingOut:))
			(StrCat global199 { Top_______})
			(StrCat global199 ((gPlayer2 altrEgo:) name:))
			(StrCat global199 (Format @global520 3 2 (gPlayer2 gamePoints:))) ; "%3d"
			(StrCat global199 {\n})
		)
		(if (not (gPlayer3 sittingOut:))
			(StrCat global199 { Right_____})
			(StrCat global199 ((gPlayer3 altrEgo:) name:))
			(StrCat global199 (Format @global520 3 2 (gPlayer3 gamePoints:))) ; "%3d"
			(StrCat global199 {\n})
		)
		(if (not (gPlayer0 sittingOut:))
			(StrCat global199 { Bottom____})
			(StrCat global199 @global138)
			(StrCat global199 (Format @global520 3 2 (gPlayer0 gamePoints:))) ; "%3d"
			(StrCat global199 {\n})
		)
		(= global305 (Print global199 #font sFont #title title #at x y #dispose))
		(proc0_1 12000)
		(gModelessDialog dispose:)
		(= temp200 (gPlayer0 gamePoints:))
		(= temp201 (gPlayer1 gamePoints:))
		(= temp202 (gPlayer2 gamePoints:))
		(= temp203 (gPlayer3 gamePoints:))
		(if
			(or
				(and (not (gPlayer0 sittingOut:)) (>= temp200 100))
				(and (not (gPlayer1 sittingOut:)) (>= temp201 100))
				(and (not (gPlayer2 sittingOut:)) (>= temp202 100))
				(and (not (gPlayer3 sittingOut:)) (>= temp203 100))
			)
			(if (gPlayer0 sittingOut:)
				(= temp200 999)
			)
			(if (gPlayer1 sittingOut:)
				(= temp201 999)
			)
			(if (gPlayer2 sittingOut:)
				(= temp202 999)
			)
			(if (gPlayer3 sittingOut:)
				(= temp203 999)
			)
			(if
				(and
					(< temp200 temp201)
					(< temp200 temp202)
					(< temp200 temp203)
				)
				(= global509 gPlayer0)
			)
			(if
				(and
					(< temp201 temp202)
					(< temp201 temp203)
					(< temp201 temp200)
				)
				(= global509 gPlayer1)
			)
			(if
				(and
					(< temp202 temp203)
					(< temp202 temp200)
					(< temp202 temp201)
				)
				(= global509 gPlayer2)
			)
			(if
				(and
					(< temp203 temp200)
					(< temp203 temp201)
					(< temp203 temp202)
				)
				(= global509 gPlayer3)
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
		(proc0_2 view 0 (= onOrOff param1) x y)
		(if onOrOff
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
				(<= x param1 (+ x 27))
				(<= y param2 (+ y 12))
			)
		)
	)
)

(instance inList of InputList
	(properties)
)

