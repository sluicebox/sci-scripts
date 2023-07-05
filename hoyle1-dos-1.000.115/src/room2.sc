;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2)
(include sci.sh)
(use Main)
(use Interface)
(use CursorCoords)
(use Game)
(use Menu)
(use Actor)

(public
	room2 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
)

(procedure (localproc_0 param1 param2)
	(if (< argc 3)
		(cond
			((and (== (param1 cardRank:) 12) (== (param1 cardSuit:) 3))
				(gSndEffect number: 30 play:)
			)
			(param2
				(gSndEffect number: (Random 32 35) play:)
			)
			(else
				(gSndEffect number: 41 play:)
			)
		)
	)
	(proc0_1 20)
	(for ((= global264 0)) (< global264 3) ((++ global264))
		(proc0_2
			(+ (param1 cardSuit:) 352)
			(if (< (param1 cardRank:) 11)
				5
			else
				(- (param1 cardRank:) 9)
			)
			param2
			(param1 x:)
			(param1 y:)
		)
		(proc0_5)
		(proc0_1 20)
		(proc0_2
			(+ (param1 cardSuit:) 352)
			0
			(param1 cardRank:)
			(param1 x:)
			(param1 y:)
		)
		(proc0_5)
		(proc0_1 20)
	)
)

(procedure (localproc_1 param1)
	(gSndEffect number: 34 play:)
	(proc0_2 158 3 0 (param1 x:) (param1 y:))
	(proc0_5)
)

(class Deck of CardDeck
	(properties)

	(method (init &tmp temp0 [temp1 57])
		(super init:)
		(for ((= temp0 4)) (< temp0 56) ((++ temp0))
			(if (!= temp0 50)
				(= [temp1 temp0] (Clone c))
				([temp1 temp0] cardRank: (/ temp0 4) cardSuit: (mod temp0 4))
			)
		)
		(for ((= temp0 4)) (< temp0 56) ((++ temp0))
			(if (!= temp0 50)
				(theDeck add: [temp1 temp0])
			)
		)
		(self shuffle:)
	)
)

(class OldMaidComputerPlayer of Player
	(properties
		playFromID 0
		altrEgoX 0
		altrEgoY 0
	)

	(method (eraseLastPair)
		(proc0_2 161 2 0 ((cardList at: 0) x:) ((cardList at: 0) y:))
		(proc0_2 161 2 0 ((cardList at: 1) x:) ((cardList at: 1) y:))
	)

	(method (endGameMessage)
		(if (and (not sittingOut) (cardList size:))
			(altrEgo upset: say: 6 1)
		)
	)

	(method (init)
		(super init:)
		(if (not sittingOut)
			((= cardList (CardList new:)) add:)
			((= tempList (WL new:)) add:)
		)
	)

	(method (takeTurn)
		(if sittingOut
			(gCardRoom state: 10)
			(gCardRoom cue:)
			(return)
		)
		(gGame setCursor: 997)
		(proc0_8)
		(= global184 playerNum)
		(if (not ((playFromID cardList:) size:))
			(arrowPointAt doit: self)
			(altrEgo say: 5 1)
			(gCardRoom cue:)
			(return)
		)
		(= place (self think:))
		(self playCard:)
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

	(method (findPair)
		(if (and (not sittingOut) (> (cardList size:) 1))
			(for ((= local0 0)) (< local0 (cardList size:)) ((++ local0))
				(for
					((= local1 (+ local0 1)))
					(< local1 (cardList size:))
					((++ local1))
					
					(if
						(==
							((cardList at: local0) cardRank:)
							((cardList at: local1) cardRank:)
						)
						(cond
							((!= ((cardList at: local0) cardRank:) 12)
								(return 1)
							)
							(
								(and
									(< ((cardList at: local0) cardSuit:) 2)
									(< ((cardList at: local1) cardSuit:) 2)
								)
								(return 1)
							)
						)
					)
				)
			)
		)
		(= local0 -1)
		(return 0)
	)

	(method (invertPair)
		((cardList at: local0) faceUp: 1)
		((cardList at: local1) faceUp: 1)
		((cardList at: local0) loop: 1)
		((cardList at: local1) loop: 1)
		(self invertCard: local0 invertCard: local1)
	)

	(method (pairDispose)
		((cardList at: local1) loop: 0)
		((cardList at: local0) loop: 0)
		((deck workingDeck:) add: (cardList at: local1))
		((deck workingDeck:) add: (cardList at: local0))
		(if (== (cardList size:) 2)
			(self eraseLastPair:)
		)
		(if (== playerNum ((gPlayer0 playFromID:) playerNum:))
			(global517 delete: (cardList at: local1))
			(global517 delete: (cardList at: local0))
			(self updateCursorCoords:)
		)
		(cardList delete: (cardList at: local1))
		(cardList delete: (cardList at: local0))
		(gSndEffect
			number: (if (>= (gCardRoom state:) 8) 42 else 50)
			loop: (if (>= (gCardRoom state:) 8) 1 else 3)
			play:
		)
		(self rePosition:)
	)

	(method (think)
		(= place (Random 0 (- ((playFromID cardList:) size:) 1)))
	)

	(method (afterThrow)
		(if (not global185)
			(super afterThrow:)
		else
			((playFromID cardList:) delete: ((playFromID cardList:) at: place))
			(playFromID rePosition:)
			(self showRealCard:)
			(self addCard:)
			(self rePosition:)
			(if (not (self findPair:))
				(self mixUpHand:)
				(self rePosition:)
			)
			(gCardRoom cue:)
		)
	)

	(method (playCard)
		(= global173 ((playFromID cardList:) at: place))
		(global173 erase: 1)
		(global173 faceUp: dealFaceUp)
		(playFromID removeCard:)
		(self setBase:)
		(= global176 dealFaceUp)
		(= global184 playerNum)
		(if (global517 contains: global173)
			(global517 delete: global173)
		)
		(gSndEffect number: (proc0_6 playCardSound) playMaybe:)
		(gTheCardToss
			init:
				(global173 x:)
				(global173 y:)
				bX
				bY
				[global417 (- global406 1)]
		)
	)

	(method (mixUpHand &tmp temp0 temp1)
		(= temp1 (cardList size:))
		(for ((= global264 0)) (< global264 temp1) ((++ global264))
			(= temp0 (Random 0 (- (cardList size:) 1)))
			(tempList add: (cardList at: temp0))
			(cardList delete: (cardList at: temp0))
		)
		(for ((= global264 0)) (< global264 temp1) ((++ global264))
			(cardList add: (tempList at: global264))
		)
		(list empty: tempList)
	)

	(method (doOldMaid)
		(if sittingOut
			(return)
		)
		(if (cardList size:)
			(gIntroSong number: ((self altrEgo:) song:) play:)
			(altrEgo shock: 1 showExp: shock:)
			(proc0_5)
			(localproc_0 (cardList at: 0) 1)
			(= local3 self)
			(= local4 (altrEgo view:))
			(Load rsVIEW 7)
			(altrEgo
				erasePortrait:
				view: 7
				portrait: 1
				showExp:
				shock: 1
				showExp:
				shock:
			)
			(proc0_5)
			(localproc_1 (cardList at: 0))
		else
			(altrEgo bigSmile: 1 bigSmile: smile:)
		)
	)
)

(class OldMaidHumanPlayer of HumanPlayer
	(properties
		playFromID 0
	)

	(method (init)
		(super init:)
		(if (not sittingOut)
			((= cardList (CardList new:)) add:)
			((= tempList (WL new:)) add:)
		)
	)

	(method (printPass)
		(= global305 (Print 2 0 #at -1 125 #dispose)) ; "Pass"
		(proc0_1 (* global407 18))
		(gModelessDialog dispose:)
		(++ global187)
	)

	(method (eraseLastPair)
		(proc0_2 161 2 0 ((cardList at: 0) x:) ((cardList at: 0) y:))
		(proc0_2 161 2 0 ((cardList at: 1) x:) ((cardList at: 1) y:))
	)

	(method (endGameMessage)
		(if (and (not sittingOut) (cardList size:))
			((gPlayer2 altrEgo:) say: 7 1)
		)
	)

	(method (takeTurn)
		(if sittingOut
			(gCardRoom state: 10)
			(gCardRoom cue:)
			(return)
		)
		(if (!= gTheCursor 999)
			(gGame setCursor: 999)
		)
		(if (not ((playFromID cardList:) size:))
			(arrowPointAt doit: self)
			(self printPass: playerNum)
			(= global179 (= input 0))
			(gCardRoom cue:)
			(return)
		)
		(super takeTurn:)
	)

	(method (takeCard)
		(if sittingOut
			(= local0 -1)
			(gCardRoom cue:)
			(return)
		)
		(self setBase:)
		(= global176 dealFaceUp)
		(deck getCard:)
		(global173 faceUp: 1)
		(gSndEffect number: (proc0_6 takeCardSound) playMaybe:)
		(gTheCardToss
			init: (deck dealX:) (deck dealY:) bX bY [global408 (- global405 1)]
		)
	)

	(method (findPair)
		(if sittingOut
			(= local0 -1)
			(return (gCardRoom cue:))
		)
		(if (> (cardList size:) 1)
			(for ((= local0 0)) (< local0 (cardList size:)) ((++ local0))
				(for
					((= local1 (+ local0 1)))
					(< local1 (cardList size:))
					((++ local1))
					
					(if
						(==
							((cardList at: local0) cardRank:)
							((cardList at: local1) cardRank:)
						)
						(cond
							((!= ((cardList at: local0) cardRank:) 12)
								(return 1)
							)
							(
								(and
									(< ((cardList at: local0) cardSuit:) 2)
									(< ((cardList at: local1) cardSuit:) 2)
								)
								(return 1)
							)
						)
					)
				)
			)
		)
		(= local0 -1)
		(return 0)
	)

	(method (checkForAPair)
		(if (> (cardList size:) 1)
			(for ((= local0 0)) (< local0 (cardList size:)) ((++ local0))
				(for
					((= local1 (+ local0 1)))
					(< local1 (cardList size:))
					((++ local1))
					
					(if
						(==
							((cardList at: local0) cardRank:)
							((cardList at: local1) cardRank:)
						)
						(cond
							((!= ((cardList at: local0) cardRank:) 12)
								(return 1)
							)
							(
								(and
									(< ((cardList at: local0) cardSuit:) 2)
									(< ((cardList at: local1) cardSuit:) 2)
								)
								(return 1)
							)
						)
					)
				)
			)
		)
		(= local0 -1)
		(return 0)
	)

	(method (invertPair)
		(self invertCard: local0 invertCard: local1)
	)

	(method (pairDispose)
		((cardList at: local1) loop: 0)
		((cardList at: local0) loop: 0)
		((deck workingDeck:) add: (cardList at: local1))
		((deck workingDeck:) add: (cardList at: local0))
		(if (== (cardList size:) 2)
			(self eraseLastPair:)
		)
		(global517 delete: (cardList at: local1))
		(global517 delete: (cardList at: local0))
		(self updateCursorCoords:)
		(cardList delete: (cardList at: local1))
		(cardList delete: (cardList at: local0))
		(gSndEffect
			number: (if (>= (gCardRoom state:) 8) 42 else 50)
			loop: (if (>= (gCardRoom state:) 8) 1 else 3)
			play:
		)
		(self rePosition:)
	)

	(method (afterThrow)
		(if (not global185)
			(super afterThrow:)
		else
			((playFromID cardList:) delete: ((playFromID cardList:) at: place))
			(playFromID rePosition:)
			(self showRealCard:)
			(self addCard:)
			(self rePosition:)
			(if (not (self checkForAPair:))
				(= local0 -1)
				(self animateCard:)
			)
			(gCardRoom cue:)
		)
	)

	(method (playCard)
		(= global173 ((playFromID cardList:) at: place))
		(global173 erase: 1)
		(global173 faceUp: dealFaceUp)
		(playFromID removeCard:)
		(self setBase:)
		(= global176 dealFaceUp)
		(= global184 playerNum)
		(if (global517 contains: global173)
			(global517 delete: global173)
		)
		(gSndEffect number: (proc0_6 playCardSound) playMaybe:)
		(gTheCardToss
			init:
				(global173 x:)
				(global173 y:)
				bX
				bY
				[global417 (- global406 1)]
		)
	)

	(method (handleInput)
		(if (== input 2)
			(= global179 1)
			(= input 0)
			(gCardRoom cue:)
			(return)
		)
		(= global179 1)
		(= input 0)
		(switch pickedUpCard
			(3
				(self findChoice:)
				(if (>= place 0)
					(= global179 0)
					(self playCard:)
				else
					(for
						((= global264 0))
						(< global264 (cardList size:))
						((++ global264))
						
						(self
							setNS:
								((cardList at: global264) x:)
								((cardList at: global264) y:)
						)
						(if (!= global264 (- (cardList size:) 1))
							(= nsR (+ nsL overlapX))
						)
						(if (self inRect:)
							(= place global264)
							(= input 0)
							(++ pickedUpCard)
							(self invertCard: place)
							(gCardRoom cue:)
							(return)
						)
					)
					(gCardRoom cue:)
				)
			)
			(4
				(= place2 place)
				(self findChoice:)
				(if (>= place 0)
					(= global179 0)
					(= input 0)
					(-- pickedUpCard)
					(self invertCard: place2)
					(self playCard:)
					(return)
				)
				(for
					((= global264 0))
					(<= global264 (cardList size:))
					((++ global264))
					
					(= place global264)
					(self
						setNS:
							(if (== place 0)
								(- ((cardList at: global264) x:) overlapX)
							else
								((cardList at: (- global264 1)) x:)
							)
							((cardList at: 0) y:)
					)
					(if (!= global264 (cardList size:))
						(= nsR (+ nsL overlapX))
					)
					(if (self inRect:)
						(if (== (- place 1) place2)
							(= input 0)
							(-- pickedUpCard)
							(self invertCard: (- place 1))
							(gCardRoom cue:)
							(return)
						else
							(-- pickedUpCard)
							((cardList at: place2) loop: 0)
							(++ place2)
							(self adjustLists: place place2)
							(if (== place 0)
								(= place 1)
							)
							(self rePosition:)
							(if input
								(= place place2)
								(= input 0)
							)
							(gCardRoom cue:)
							(return)
						)
					)
					(= place place2)
				)
				(gCardRoom cue:)
			)
		)
	)

	(method (findChoice)
		(= place -1)
		(for
			((= global264 0))
			(< global264 ((playFromID cardList:) size:))
			((++ global264))
			
			(self
				setNS:
					(((playFromID cardList:) at: global264) x:)
					(((playFromID cardList:) at: global264) y:)
			)
			(if (!= global264 (- ((playFromID cardList:) size:) 1))
				(if (== playFromID player3)
					(= nsB (+ nsT (playFromID overlapY:)))
				else
					(= nsR (+ nsL (playFromID overlapX:)))
				)
			)
			(if (self inRect:)
				(= place global264)
			)
		)
	)

	(method (animateCard &tmp temp0 temp1)
		(= temp1 (cardList at: (- (cardList size:) 1)))
		(if (== (cardList size:) 1)
			(proc0_5)
			(localproc_0 temp1 0 1)
		else
			(if (self checkForAPair:)
				(= temp0 0)
			else
				(= temp0 1)
			)
			(proc0_5)
			(localproc_0 temp1 temp0)
		)
	)

	(method (doOldMaid)
		(if sittingOut
			(return)
		)
		(if (cardList size:)
			(gIntroSong number: 30 play:)
			(localproc_0 (cardList at: 0) 1)
			(localproc_1 (cardList at: 0))
			((= local8 (View new:)) view: 7 posn: 115 160 setPri: 14 init:)
		)
	)
)

(instance room2 of Rm
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
		(pressHereToRemovePair doit: local6 local7)
	)

	(method (handleEvent event param2)
		(if (== argc 2)
			(switch param2
				(1281
					(gGame setCursor: 997)
					((ScriptID 882) doit:) ; oldMaidRules
					(DisposeScript 882)
					(event claimed: 1)
					(return)
				)
			)
		else
			(if (or (== global855 2) (== global854 13) (== global854 20992))
				(= local6 (event x:))
				(= local7 (event y:))
			)
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
		(AddMenu { Old Maid } {Rules `^r})
		(MenuBar draw:)
		(= local3 (= local4 0))
		(= global517 inList)
		(= gPlayer0 player0)
		(= gPlayer1 player1)
		(= gPlayer2 player2)
		(= gPlayer3 player3)
		(= gDeck deck)
		(= gCardRoom cardRoom)
		(= global197 endThrow)
		(super init:)
		(Load rsVIEW 158)
		(Load rsVIEW 352)
		(Load rsVIEW 353)
		(Load rsVIEW 354)
		(Load rsVIEW 355)
		(Load rsVIEW 252)
		(Load rsVIEW 253)
		(Load rsVIEW 254)
		(Load rsVIEW 255)
		(Load rsVIEW 7)
		(Load rsSOUND 100)
		(Load rsSOUND 101)
		(Load rsSOUND 102)
		(Load rsSOUND 103)
		(Load rsSOUND 104)
		(Load rsSOUND 105)
		(Load rsSOUND 32)
		(Load rsSOUND 33)
		(Load rsSOUND 34)
		(Load rsSOUND 34)
		(Load rsSOUND 35)
		(Load rsSOUND 42)
		(Load rsSOUND 41)
		(Load rsSOUND 50)
		(if (== numActivePlayers 3)
			(chooseACardFrom init: 3)
			(= global174 17)
		else
			(chooseACardFrom init: 4)
			(= global174 13)
			((gPlayerList at: 0) oneLessCard: 1)
		)
		(player0 playFromID: (if (player3 sittingOut:) player2 else player3))
		(player1 playFromID: (if (player0 sittingOut:) player3 else player0))
		(player2 playFromID: (if (player1 sittingOut:) player0 else player1))
		(player3 playFromID: (if (player2 sittingOut:) player1 else player2))
	)

	(method (removeViews)
		(gPlayerList eachElementDo: #giveUpCards deck)
	)

	(method (newDeal)
		(player0 pickedUpCard: 0)
		((gPlayerList at: 0) oneLessCard: 0)
		(super newDeal:)
		(if (== numActivePlayers 4)
			((gPlayerList at: 0) oneLessCard: 1)
		)
		(self newDeal2:)
	)

	(method (doit)
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
					((gPlayerList at: currentPlayer) takeCard:)
				)
			)
			(4
				((gPlayerList at: currentPlayer) addCard:)
				(if
					(or
						(not ((gPlayerList at: currentPlayer) playerNum:))
						(==
							((gPlayerList at: currentPlayer) playerNum:)
							((gPlayer0 playFromID:) playerNum:)
						)
					)
					((gPlayerList at: currentPlayer) updateCursorCoords:)
				)
				(= global186 0)
				(self cue:)
			)
			(5
				(= currentPlayer 1)
				(arrowPointAt doit: (gPlayerList at: currentPlayer))
				(removingPairs doit: 1)
				(proc0_8)
				(= local5 (= counter 0))
				(= local8 0)
				(self cue:)
			)
			(6
				(if
					(or
						(not global186)
						(not ((gPlayerList at: currentPlayer) playerNum:))
					)
					(= global186 1)
					(if ((gPlayerList at: currentPlayer) playerNum:)
						((gPlayerList at: currentPlayer) findPair:)
					else
						(if (not (pressHereToRemovePair onOrOff:))
							(pressHereToRemovePair init: 1)
							(proc0_5)
						)
						((gPlayerList at: currentPlayer) findPair:)
						(if (and (>= local0 0) local5)
							(= local6 0)
							(= local7 0)
							((gPlayerList at: currentPlayer) invertPair:)
							(proc0_5)
							(proc0_1 (* global407 10))
						)
					)
					(if
						(and
							(>= local0 0)
							((gPlayerList at: currentPlayer) playerNum:)
						)
						((gPlayerList at: currentPlayer) invertPair:)
						(switch (++ counter)
							(2
								(((gPlayerList at: currentPlayer) altrEgo:)
									smirk: 1
								)
							)
							(3
								(((gPlayerList at: currentPlayer) altrEgo:)
									smile: 1
								)
							)
							(4
								(((gPlayerList at: currentPlayer) altrEgo:)
									bigSmile: 1
								)
							)
						)
						(proc0_5)
						(proc0_1 (* global407 10))
					)
					(cond
						(
							(and
								(>= local0 -1)
								((gPlayerList at: currentPlayer) playerNum:)
							)
							(self cue:)
						)
						((not ((gPlayerList at: currentPlayer) playerNum:))
							(cond
								((and local5 (>= local0 0))
									(= local5 0)
									(++ state)
								)
								((== local0 -1)
									(pressHereToRemovePair init: 0)
									(self cue:)
								)
							)
						)
					)
				)
			)
			(7
				((gPlayerList at: currentPlayer) pairDispose:)
				(= global186 0)
				(self cue:)
			)
			(8
				(if (not global186)
					(++ global186)
					(if (not ((gPlayerList at: currentPlayer) playerNum:))
						(chooseACardFrom doit: 1)
					)
					(proc0_5)
					((gPlayerList at: currentPlayer) takeTurn:)
				)
			)
			(9
				(cond
					(((gPlayerList at: currentPlayer) playerNum:)
						(if (>= local0 0)
							((gPlayerList at: currentPlayer) invertPair:)
							(if ((gPlayerList at: currentPlayer) playerNum:)
								(gSndEffect number: 41 play:)
								(((gPlayerList at: currentPlayer) altrEgo:)
									smile: 1
								)
							)
							(proc0_5)
							(proc0_1 (* global407 20))
						else
							(if
								(>
									(((gPlayerList at: currentPlayer) cardList:)
										size:
									)
									1
								)
								(gSndEffect number: (Random 32 35) play:)
								(((gPlayerList at: currentPlayer) altrEgo:)
									upset: 1
								)
							)
							(proc0_5)
						)
						(self cue:)
					)
					((>= local0 0)
						(if (not (pressHereToRemovePair onOrOff:))
							(pressHereToRemovePair init: 1)
							(proc0_5)
						)
						(if local5
							(= local5 0)
							(pressHereToRemovePair init: 0)
							((gPlayerList at: currentPlayer) animateCard:)
							(= local6 0)
							(= local7 0)
							((gPlayerList at: currentPlayer) invertPair:)
							(proc0_5)
							(proc0_1 (* global407 20))
							(self cue:)
						)
					)
					(else
						(= local6 0)
						(= local7 0)
						(self cue:)
					)
				)
			)
			(10
				(if (>= local0 0)
					((gPlayerList at: currentPlayer) pairDispose:)
				)
				(= global264 0)
				(= local0 0)
				(while (< global264 4)
					(if (not ((gPlayerList at: global264) sittingOut:))
						(+=
							local0
							(((gPlayerList at: global264) cardList:) size:)
						)
					)
					(++ global264)
				)
				(if (== local0 1)
					(chooseACardFrom doit: 0)
					(= global181 1)
				)
				(= local0 -1)
				(self cue:)
			)
			(11
				(gGame setCursor: 999)
				(arrowPointAt doit: 0)
				(gPlayerList eachElementDo: #flipCards)
				(gPlayerList eachElementDo: #doOldMaid)
				(proc0_1 (* global407 96))
				(self cue:)
			)
			(12
				(self cue:)
			)
			(13
				(gPlayerList eachElementDo: #endGameMessage)
				(self cue:)
			)
			(14
				(proc0_1 (* global407 60))
				(if local3
					((local3 altrEgo:) erasePortrait: view: local4 portrait: 1)
				)
				(= local3 0)
				(if local8
					(local8 dispose:)
					(= local8 0)
				)
				(proc0_5)
				(self cue:)
			)
			(15
				(self removeViews:)
				(self newDeal:)
				(self cue:)
			)
		)
	)

	(method (cue)
		(switch state
			(4
				(if ((deck theDeck:) size:)
					(++ currentPlayer)
					(if (> currentPlayer 3)
						(= currentPlayer 0)
					)
					(= state 3)
				else
					(++ state)
				)
			)
			(6
				(cond
					((== local0 -1)
						(= local0 -2)
						(= global186 0)
						(= global264 ((gPlayerList at: currentPlayer) playerNum:))
						(= counter 0)
						(++ currentPlayer)
						(if (> currentPlayer 3)
							(= currentPlayer 0)
						)
						(if (== ((gPlayerList at: currentPlayer) playerNum:) 1)
							(removingPairs doit: 0)
						)
						(if
							(or
								((gPlayerList at: currentPlayer) playerNum:)
								(not
									((gPlayerList at: currentPlayer) sittingOut:)
								)
							)
							(arrowPointAt doit: (gPlayerList at: currentPlayer))
						)
						(if (== currentPlayer 1)
							(removingPairs doit: 0)
							(arrowPointAt doit: (gPlayerList at: 0))
							(= state 8)
							(= global185 1)
							(= global179 0)
							(= global180 1)
							(= global186 0)
							(= local5 (= currentPlayer 0))
							(player0 pickedUpCard: 3)
							(arrowPointAt doit: (gPlayerList at: currentPlayer))
						)
						(if
							(and
								(not global264)
								((gPlayerList at: global264) sittingOut:)
							)
							(= local0 -3)
						)
					)
					((!= local0 -3)
						(++ state)
					)
				)
			)
			(7
				(= state 6)
			)
			(10
				(= global186 0)
				(if global181
					(++ state)
					(= global181 0)
					(return)
				)
				(= global180 1)
				(if global179
					(= global179 0)
				else
					(= lastPlayer currentPlayer)
					(if (> (++ currentPlayer) 3)
						(= currentPlayer 0)
					)
				)
				(if
					(and
						((gPlayerList at: currentPlayer) playerNum:)
						(not ((gPlayerList at: currentPlayer) sittingOut:))
					)
					(((gPlayerList at: currentPlayer) altrEgo:)
						clearExps:
						lookAt: lastPlayer
					)
					(arrowPointAt doit: (gPlayerList at: currentPlayer))
					(chooseACardFrom doit: 0)
					(proc0_5)
					(if
						(and
							((gPlayerList at: currentPlayer) playerNum:)
							(!= gTheCursor 997)
						)
						(gGame setCursor: 997)
					)
					(proc0_1 (* global407 24))
				)
				(if (not ((gPlayerList at: currentPlayer) playerNum:))
					(arrowPointAt doit: (gPlayerList at: currentPlayer))
				)
				(= state 8)
			)
			(11
				(chooseACardFrom doit: 0)
				(arrowPointAt doit: (gPlayerList at: currentPlayer))
				(++ state)
			)
			(15
				(= state 3)
			)
			(else
				(= global186 0)
				(++ state)
			)
		)
	)
)

(instance player0 of OldMaidHumanPlayer
	(properties)
)

(instance player1 of OldMaidComputerPlayer
	(properties
		playerNum 1
		dealFromX -20
		overlapX 0
		baseX 8
		altrEgo 18
		takeCardSound 101
		playCardSound 104
		altrEgoX 69
		altrEgoY 113
	)
)

(instance player2 of OldMaidComputerPlayer
	(properties
		playerNum 2
		dealFromY 0
		overlapY 0
		baseY 4
		altrEgo 19
		altrEgoX 77
		altrEgoY 37
	)
)

(instance player3 of OldMaidComputerPlayer
	(properties
		playerNum 3
		dealFromX 340
		overlapX 0
		baseX 277
		speakFrom 1
		altrEgo 15
		takeCardSound 102
		playCardSound 105
		altrEgoX 251
		altrEgoY 113
	)
)

(instance deck of Deck
	(properties)
)

(instance list of WL
	(properties)
)

(instance arrowPointAt of GO
	(properties
		x 160
		y 113
		view 158
	)

	(method (doit param1)
		(if (!= onOrOff param1)
			(proc0_2
				view
				1
				(if param1
					(param1 playerNum:)
				else
					4
				)
				x
				y
			)
			(= onOrOff param1)
		)
	)
)

(instance removingPairs of GO
	(properties
		x 160
		y 83
		view 158
	)

	(method (doit param1)
		(proc0_2 view 0 param1 x y)
	)
)

(instance chooseACardFrom of GO
	(properties
		status0 1
		x 240
		y 77
		view 158
	)

	(method (init param1)
		(if (== param1 3)
			(= x 160)
			(= y 101)
			(= status0 2)
		else
			(= x 240)
			(= y 77)
			(= status0 1)
		)
	)

	(method (doit param1)
		(if (!= onOrOff param1)
			(proc0_2 view 2 (* param1 status0) x y)
			(= onOrOff param1)
		)
	)
)

(instance endThrow of EndThrow
	(properties)
)

(instance inList of InputList
	(properties)
)

(instance pressHereToRemovePair of GO
	(properties
		x 160
		y 135
		view 158
		cursorX 161
		cursorY 133
	)

	(method (init param1)
		(= onOrOff param1)
		(proc0_2 view 4 onOrOff x y)
		(if onOrOff
			(global517 add: self)
		else
			(global517 delete: self)
		)
	)

	(method (doit param1 param2)
		(if onOrOff
			(++ special)
			(if (== special 10)
				(= special 0)
				(if (== onOrOff 1)
					(= onOrOff 2)
				else
					(= onOrOff 1)
				)
				(proc0_2 view 4 onOrOff x y)
			)
			(= local5
				(and (<= (- x 38) param1 (+ x 38)) (<= (- y 15) param2 y))
			)
		)
	)
)

