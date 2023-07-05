;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 156)
(include sci.sh)
(use Main)
(use KeyMouse)
(use eRS)
(use Talker)
(use Actor)
(use System)

(public
	rm156 0
)

(local
	local0
	local1
	local2
	local3
	[local4 35]
	[local39 35]
	[local74 10]
	[local84 10]
	[local94 10]
)

(class Card of View
	(properties
		view 501
		value 0
		suit 0
		rank 0
		discard 1
		order 0
	)

	(method (addKeyMouse)
		((KeyMouse objList:) add: self)
	)

	(method (deleteKeyMouse)
		((KeyMouse objList:) delete: self)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 0)
		)
		(event localize:)
		(if
			(and
				(self onMe: event)
				(not (& signal $0008))
				(or
					(and (& (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
					(& (event type:) evMOUSEBUTTON)
				)
			)
			(event claimed: 1)
			(if (self discardMax:)
				(gMessager say: 1 0 1) ; "You are only allowed to discard 3 cards unless you keep an ace."
				(return 1)
			)
			((= temp0 (List new:)) add: self)
			(displayNewCardsList change: (self flip:) updateAll:)
			(Animate (temp0 elements:) 0)
			(temp0 eachElementDo: #delete release: dispose: &rest)
			(return 1)
		)
		(event claimed:)
	)

	(method (discardMax &tmp temp0 temp1)
		(if discard
			(return 0)
		)
		(for ((= temp0 0)) (< temp0 (hand1 size:)) ((++ temp0))
			(if
				(and
					(!= (= temp1 (hand1 at: temp0)) self)
					(== (temp1 rank:) 12)
					(not (temp1 discard:))
				)
				(return 0)
			)
		)
		(return (>= (displayNewCardsList currentValue:) 3))
	)

	(method (matchSuit param1)
		(return (== suit param1))
	)

	(method (throwAway)
		(= discard (not discard))
	)

	(method (flip)
		(self throwAway: setCard: forceUpd:)
		(return (- (* discard 2) 1))
	)

	(method (make)
		(= suit (/ value 13))
		(= rank (mod value 13))
	)

	(method (position param1 param2)
		(self posn: (+ (param1 initX:) (* param2 25)) (param1 initY:))
	)

	(method (setCard)
		(if discard
			(= loop (= cel 0))
		else
			(= loop (+ suit 1))
			(= cel rank)
		)
	)

	(method (reset)
		(= discard 1)
		(self setCard: forceUpd: hide:)
	)

	(method (set)
		(= discard 0)
		(self setCard: show: forceUpd:)
	)
)

(class Hand of List
	(properties
		handRank 0
		initX 0
		initY 0
		good 0
		sortHand 0
		spades 0
		clubs 0
		diamonds 0
		hearts 0
		bet 0
		totalBet 0
		haveBet 0
		requiredBet 0
		gotCards 0
		haveAnte 0
		handName 0
	)

	(method (init)
		(super init:)
		(= sortHand (Hand new:))
	)

	(method (getNewCards &tmp temp0)
		(self evaluate:)
		(= temp0 (self markHand:))
		(gLongSong number: 561 loop: temp0 flags: -1 play:)
		(self newCards: temp0 gotCards: 1)
	)

	(method (checkAnte param1 &tmp temp0)
		(if
			(and
				(not (param1 claimed:))
				(& (param1 type:) $0004)
				(!= (param1 message:) 13)
			)
			(return 0)
		)
		(if (not haveAnte)
			(param1 claimed: 1)
			(for ((= temp0 0)) (< temp0 4) ((++ temp0))
				(anteButton flash:)
				(Wait 6)
			)
			(gMessager say: 1 0 2) ; "You still have to ante."
			(return 0)
		)
		(return 1)
	)

	(method (checkBet param1 &tmp temp0)
		(if (not (self checkAnte: param1))
			(return 0)
		)
		(if (not haveBet)
			(param1 claimed: 1)
			(for ((= temp0 0)) (< temp0 4) ((++ temp0))
				((chipsPanel okButton:) flash:)
				(Wait 6)
			)
			(gMessager say: 1 0 3) ; "You still have a bet to make."
			(return 0)
		)
		(return 1)
	)

	(method (computerBet param1 param2)
		(self evaluate:)
		(if (== handRank 0)
			(self evaluateMore:)
		)
		(if (and (== (gamePlay state:) 1) (>= 3 handRank 8))
			(= bet (Max (allHands currentBet:) 3))
		else
			(= param2 (allHands betOnce:))
			(switch handRank
				(1
					(if (>= ((sortHand at: 0) rank:) 9)
						(= bet (+ 1 (Random 0 3)))
					else
						(= bet (+ -3 (Random 3)))
					)
				)
				(2
					(= bet (+ 3 (Random 0 3)))
				)
				(3
					(= bet (+ 3 (Random 0 3)))
				)
				(4
					(= bet (+ 6 (Random 0 3)))
				)
				(5
					(= bet (+ 6 (Random 0 3)))
				)
				(6
					(= bet (+ 9 (Random 0 3)))
				)
				(7
					(= bet (+ 12 (Random 0 3)))
				)
				(8
					(= bet (+ 12 (Random 0 3)))
				)
				(0
					(= bet 0)
				)
				(10
					(if param2
						(= bet 0)
					else
						(= bet (+ 0 (Random 0 3)))
					)
				)
				(9
					(= bet 0)
				)
				(12
					(if param2
						(= bet 0)
					else
						(= bet (+ 0 (Random 0 3)))
					)
				)
				(11
					(= bet 0)
				)
				(13
					(if param2
						(= bet 0)
					else
						(= bet (+ 0 (Random 0 3)))
					)
				)
			)
		)
		(if (> bet 15)
			(= bet (Min 15 global203))
		)
		(if (< bet 0)
			(= bet 0)
		)
		(cond
			((> (allHands currentBet:) (+ bet 3))
				(= param2
					(/
						(Max (/ (/ (- (allHands currentBet:) bet) 2) 3))
						local3
					)
				)
				(if (or (Random 0 param2) (== handRank 0))
					(self fold:)
				else
					(self call:)
				)
			)
			((not bet)
				(self call:)
			)
			((< bet (allHands currentBet:))
				(self call:)
			)
		)
	)

	(method (makeHandBet param1 &tmp temp0)
		(if good
			(cond
				((!= self hand1)
					(if (not haveBet)
						(self computerBet:)
					else
						(return 1)
					)
				)
				(haveBet
					(if param1
						(if (< bet requiredBet)
							(Message msgGET 156 1 0 39 1 @local39) ; "You must bet at least %d chip%s."
							(= local74 0)
							(if (!= requiredBet 1)
								(Message msgGET 156 1 0 37 1 @local74) ; "s"
							)
							(Format @local4 @local39 requiredBet @local74)
							(proc157_0 @local4)
							(return (= haveBet 0))
						)
						(displayChipsList locked: 1)
						(playerChipsList change: (- bet) updateAll:)
						(if (!= (displayChipsList currentValue:) bet)
							(displayChipsList set: bet updateAll:)
						)
					)
				)
				(else
					(return 0)
				)
			)
			(if (and (or (!= self hand1) param1) bet)
				(= requiredBet 0)
				(+= totalBet bet)
				(allHands putInPot: bet)
				(= haveBet 1)
				(self checkRaise:)
				(Message msgGET 156 1 0 40 1 @local39) ; "%s %s bet %d chip%s."
				(if (== self hand1)
					(Message msgGET 156 1 0 41 1 @local74) ; "have"
				else
					(Message msgGET 156 1 0 42 1 @local74) ; "has"
				)
				(Message msgGET 156 1 0 handName 1 @local84)
				(= local94 0)
				(if (!= bet 1)
					(Message msgGET 156 1 0 37 1 @local94) ; "s"
				)
				(Format @local4 @local39 @local84 @local74 bet @local94)
				(proc157_0 @local4)
			)
		)
		(return 1)
	)

	(method (giveAnte &tmp temp0)
		(+= totalBet (= temp0 (allHands ante:)))
		(allHands putInPot: temp0)
		(= haveAnte 1)
		(if (== self hand1)
			(playerChipsList change: (- temp0) updateAll:)
		)
		(Message msgGET 156 1 0 44 1 @local39) ; "%s %s anted up %d chip%s."
		(if (== self hand1)
			(Message msgGET 156 1 0 41 1 @local74) ; "have"
		else
			(Message msgGET 156 1 0 42 1 @local74) ; "has"
		)
		(Message msgGET 156 1 0 handName 1 @local84)
		(= local94 0)
		(if (!= temp0 1)
			(Message msgGET 156 1 0 37 1 @local94) ; "s"
		)
		(Format @local4 @local39 @local84 @local74 temp0 @local94)
		(proc157_0 @local4)
	)

	(method (resetBet param1)
		(if (and good (!= self param1))
			(if param1
				(= requiredBet (- (allHands currentBet:) bet))
			else
				(= requiredBet (allHands currentBet:))
				(= bet 0)
			)
			(= haveBet 0)
		)
	)

	(method (checkRaise &tmp temp0)
		(if (> bet (allHands currentBet:))
			(= temp0 (- bet (allHands currentBet:)))
			(Message msgGET 156 1 0 45 1 @local39) ; "%s %s raised %d chip%s."
			(if (== self hand1)
				(Message msgGET 156 1 0 41 1 @local74) ; "have"
			else
				(Message msgGET 156 1 0 42 1 @local74) ; "has"
			)
			(Message msgGET 156 1 0 handName 1 @local84)
			(= local94 0)
			(if (!= temp0 1)
				(Message msgGET 156 1 0 37 1 @local94) ; "s"
			)
			(Format @local4 @local39 @local84 @local74 temp0 @local94)
			(proc157_0 @local4)
			(allHands currentBet: bet eachElementDo: #resetBet self)
			(if (!= self hand1)
				(displayChipsList clear:)
			)
		)
	)

	(method (call)
		(= haveBet 1)
		(= bet requiredBet)
		(Message msgGET 156 1 0 handName 1 @local84)
		(= local74 0)
		(if (!= self hand1)
			(Message msgGET 156 1 0 37 1 @local74) ; "s"
		)
		(Message msgGET 156 1 0 36 1 @local39) ; "%s call%s."
		(Format @local4 @local39 @local84 @local74)
		(proc157_0 @local4)
	)

	(method (pass)
		(if (allHands currentBet:)
			(Message msgGET 156 1 0 31 1 @local39) ; "You can not pass since there is already a bet of %d chip%s placed."
			(= local74 0)
			(if (!= (allHands currentBet:) 1)
				(Message msgGET 156 1 0 37 1 @local74) ; "s"
			)
			(Format @local4 @local39 requiredBet @local74)
			(proc157_0 @local4)
			(return 0)
		else
			(Message msgGET 156 1 0 handName 1 @local84)
			(= local74 0)
			(if (!= self hand1)
				(Message msgGET 156 1 0 43 1 @local74) ; "es"
			)
			(Message msgGET 156 1 0 32 1 @local39) ; "%s pass%s."
			(Format @local4 @local39 @local84 @local74)
			(proc157_0 @local4)
		)
		(= bet 0)
		(return (= haveBet 1))
	)

	(method (fold)
		(= good (= bet 0))
		(= haveBet 1)
		(if (!= self hand1)
			(self eachElementDo: #hide)
			(Animate (self elements:) 0)
		)
		(Message msgGET 156 1 0 handName 1 @local84)
		(= local74 0)
		(if (!= self hand1)
			(Message msgGET 156 1 0 37 1 @local74) ; "s"
		)
		(Message msgGET 156 1 0 33 1 @local39) ; "%s fold%s."
		(Format @local4 @local39 @local84 @local74)
		(proc157_0 @local4)
	)

	(method (resetHand param1)
		(if (or good param1)
			(= good 1)
			(= spades
				(= clubs
					(= diamonds
						(= hearts
							(= haveBet
								(= gotCards
									(= haveAnte
										(= totalBet (= bet (= requiredBet 0)))
									)
								)
							)
						)
					)
				)
			)
		)
	)

	(method (initHand)
		(self makeHand:)
	)

	(method (countSuits param1)
		(switch param1
			(0
				(++ spades)
			)
			(1
				(++ clubs)
			)
			(2
				(++ diamonds)
			)
			(3
				(++ hearts)
			)
		)
	)

	(method (makeHand &tmp temp0 temp1)
		(if (== self hand1)
			(self eachElementDo: #deleteKeyMouse)
		)
		(self eachElementDo: #delete release: resetHand: 1)
		(for ((= temp0 0)) (< temp0 5) ((++ temp0))
			(self add: (= temp1 (theDeck deal:)))
			(temp1 position: self temp0 order: temp0)
			(self countSuits: (temp1 suit:))
		)
		(if (== self hand1)
			(self eachElementDo: #addKeyMouse)
		)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 0)
		)
		(if (not (self checkBet: event))
			(return 0)
		)
		(if (theDeck dealFirst: event)
			(self eachElementDo: #handleEvent event)
		)
		(if (not (event claimed:))
			(for ((= temp0 0)) (< temp0 4) ((++ temp0))
				(okNewCardsButton flash:)
				(Wait 6)
			)
			(event claimed: 1)
			(gMessager say: 1 0 4) ; "Please discard your unwanted cards now."
		)
	)

	(method (dealHand)
		(if (not haveAnte)
			(gLongSong number: 561 loop: 1 flags: -1 play:)
			(self eachElementDo: #reset)
			(Animate (self elements:) 0)
			(self makeHand: flipHand: 1)
		)
	)

	(method (flipHand param1)
		(if (and param1 (== self hand1))
			(self eachElementDo: #flip)
		)
		(self displayHand:)
	)

	(method (displayHand &tmp [temp0 2])
		(self eachElementDo: #show)
		(Animate (self elements:) 0)
	)

	(method (newCards param1 &tmp temp0 temp1 temp2 temp3)
		(if good
			((= temp3 (List new:)) add:)
			(for ((= temp0 0)) (< temp0 5) ((++ temp0))
				(if ((= temp1 (self at: temp0)) discard:)
					(self addAfter: temp1 (= temp2 (theDeck deal:)))
					(temp3 add: temp1)
					(temp1 hide: forceUpd:)
					(self delete: temp1)
					(temp2 position: self temp0)
					(if (== self hand1)
						(temp2 flip: addKeyMouse:)
						(temp1 deleteKeyMouse:)
					)
				)
			)
			(temp3 eachElementDo: #hide)
			(Animate (temp3 elements:) 0)
			(temp3 eachElementDo: #delete release: dispose: &rest)
			(self bet: (hand1 bet:))
			(Message msgGET 156 1 0 handName 1 @local84)
			(= local94 0)
			(if (!= self hand1)
				(Message msgGET 156 1 0 37 1 @local94) ; "s"
			)
			(= local74 0)
			(if (!= param1 1)
				(Message msgGET 156 1 0 37 1 @local74) ; "s"
			)
			(Message msgGET 156 1 0 34 1 @local39) ; "%s take%s %d card%s."
			(Format @local4 @local39 @local84 @local94 param1 @local74)
			(proc157_0 @local4)
			(self displayHand:)
			(displayNewCardsList set: 0 updateAll:)
		)
	)

	(method (switchCard param1 param2 &tmp temp0)
		(self delete: (= temp0 (self at: param2)))
		(self addAfter: param1 temp0)
		(self delete: param1)
		(if param2
			(self addAfter: (self at: (- param2 1)) param1)
		else
			(self addToFront: param1)
		)
	)

	(method (typeSort param1 &tmp temp0 temp1 temp2)
		(switch param1
			(1
				(for ((= temp0 1)) (< temp0 4) ((++ temp0))
					(if
						(==
							((= temp1 (self at: temp0)) rank:)
							((= temp2 (self at: (+ temp0 1))) rank:)
						)
						(self switchCard: temp1 0)
						(self switchCard: temp2 1)
						(break)
					)
				)
			)
			(2
				(= temp1 (self at: 2))
				(if (== ((self at: 1) rank:) (temp1 rank:))
					(self switchCard: temp1 0)
				)
				(= temp1 (self at: 4))
				(if (== ((self at: 3) rank:) (temp1 rank:))
					(self switchCard: temp1 2)
				)
			)
			(3
				(= temp1 (self at: 0))
				(= temp2 (self at: 2))
				(if (!= (temp2 rank:) (temp1 rank:))
					(self switchCard: temp1 3)
				)
				(= temp1 (self at: 1))
				(if (!= (temp2 rank:) (temp1 rank:))
					(self switchCard: temp1 4)
				)
			)
			(7
				(= temp1 (self at: 0))
				(if (!= ((self at: 2) rank:) (temp1 rank:))
					(self switchCard: temp1 4)
				)
			)
			(6
				(self typeSort: 3)
			)
		)
	)

	(method (tie param1 param2 &tmp temp0 temp1 temp2)
		(if good
			(if (or (== param1 0) (== param1 5))
				(for ((= temp0 0)) (< temp0 5) ((++ temp0))
					(cond
						(
							(>
								(= temp1 (((self sortHand:) at: temp0) rank:))
								(= temp2 (((param2 sortHand:) at: temp0) rank:))
							)
							(return self)
						)
						((> temp2 temp1)
							(return param2)
						)
					)
				)
				(tieList add: self param2)
				(return self)
			)
			(if (or (== param1 4) (== param1 8))
				(cond
					(
						(>
							(= temp1 (((self sortHand:) at: 1) rank:))
							(= temp2 (((param2 sortHand:) at: 1) rank:))
						)
						(return self)
					)
					((> temp2 temp1)
						(return param2)
					)
				)
				(tieList add: self param2)
				(return self)
			)
			(if (or (== param1 3) (== param1 7) (== param1 6))
				(if
					(>
						(= temp1 (((self sortHand:) at: 2) rank:))
						(= temp2 (((param2 sortHand:) at: 2) rank:))
					)
					(return self)
				else
					(return param2)
				)
			)
			(if (or (== param1 1) (== param1 2))
				(for ((= temp0 1)) (< temp0 5) ((++ temp0))
					(cond
						(
							(>
								(= temp1 (((self sortHand:) at: temp0) rank:))
								(= temp2 (((param2 sortHand:) at: temp0) rank:))
							)
							(return self)
						)
						((> temp2 temp1)
							(return param2)
						)
					)
				)
				(tieList add: self param2)
				(return self)
			)
			(return self)
		)
		(return param2)
	)

	(method (showHand &tmp temp0)
		(if good
			(self eachElementDo: #set displayHand:)
			(= temp0 (self evaluate:))
			(self printRank:)
			(return temp0)
		)
	)

	(method (evaluate &tmp temp0 temp1 temp2 temp3 temp4)
		(if good
			(sortHand eachElementDo: #delete release: dispose: &rest)
			(= sortHand (Hand new:))
			(Sorts self sortHand sortCode)
			(= temp0 (sortHand at: 0))
			(= temp1 (sortHand at: 1))
			(= temp2 (sortHand at: 2))
			(= temp3 (sortHand at: 3))
			(= temp4 (sortHand at: 4))
			(= handRank 0)
			(if
				(==
					(temp0 suit:)
					(temp1 suit:)
					(temp2 suit:)
					(temp3 suit:)
					(temp4 suit:)
				)
				(= handRank 5)
			)
			(if
				(and
					(==
						(temp1 rank:)
						(+ (temp2 rank:) 1)
						(+ (temp3 rank:) 2)
						(+ (temp4 rank:) 3)
					)
					(or
						(== (temp0 rank:) (+ (temp1 rank:) 1))
						(== 0 (temp4 rank:) (- (temp0 rank:) 12))
					)
				)
				(if (== handRank 5)
					(= handRank 8)
				else
					(= handRank 4)
				)
			)
			(if
				(or
					(== (temp0 rank:) (temp1 rank:) (temp2 rank:) (temp3 rank:))
					(== (temp1 rank:) (temp2 rank:) (temp3 rank:) (temp4 rank:))
				)
				(= handRank 7)
			)
			(if
				(and
					(or
						(== (temp0 rank:) (temp1 rank:) (temp2 rank:))
						(== (temp1 rank:) (temp2 rank:) (temp3 rank:))
						(== (temp2 rank:) (temp3 rank:) (temp4 rank:))
					)
					(== handRank 0)
				)
				(= handRank 3)
			)
			(if
				(or
					(and
						(== (temp1 rank:) (temp2 rank:))
						(== (temp3 rank:) (temp4 rank:))
					)
					(and
						(== (temp0 rank:) (temp1 rank:))
						(== (temp2 rank:) (temp3 rank:))
					)
					(and
						(== (temp0 rank:) (temp1 rank:))
						(== (temp3 rank:) (temp4 rank:))
					)
				)
				(cond
					((== handRank 3)
						(= handRank 6)
					)
					((== handRank 0)
						(= handRank 2)
					)
				)
			)
			(if
				(and
					(or
						(== (temp0 rank:) (temp1 rank:))
						(== (temp1 rank:) (temp2 rank:))
						(== (temp2 rank:) (temp3 rank:))
						(== (temp3 rank:) (temp4 rank:))
					)
					(== handRank 0)
				)
				(= handRank 1)
			)
			(sortHand typeSort: handRank)
			(return handRank)
		)
		(return 0)
	)

	(method (printRank)
		(if good
			(Message msgGET 156 1 0 handName 1 @local94)
			(Message msgGET 156 1 0 46 1 @local39) ; "%s : %s"
			(switch handRank
				(1
					(Message msgGET 156 1 0 9 1 @local74) ; "One Pair"
				)
				(2
					(Message msgGET 156 1 0 27 1 @local74) ; "Two Pairs"
				)
				(3
					(Message msgGET 156 1 0 29 1 @local74) ; "Three of a Kind"
				)
				(4
					(Message msgGET 156 1 0 26 1 @local74) ; "Straight"
				)
				(5
					(Message msgGET 156 1 0 23 1 @local74) ; "Flush"
				)
				(6
					(Message msgGET 156 1 0 24 1 @local74) ; "Full House"
				)
				(7
					(Message msgGET 156 1 0 25 1 @local74) ; "Four of a Kind"
				)
				(8
					(Message msgGET 156 1 0 28 1 @local74) ; "Straight Flush"
				)
				(else
					(Message msgGET 156 1 0 30 1 @local74) ; "High Card"
				)
			)
			(Format @local4 @local39 @local94 @local74)
			(proc157_0 @local4)
		)
	)

	(method (returnNonSuit param1 &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 5) ((++ temp0))
			(if (not ((= temp1 (self at: temp0)) matchSuit: param1))
				(temp1 order:)
				(return)
			)
		)
	)

	(method (fourCardEval param1 param2)
		(if (!= handRank 0)
			(if (!= (param2 suit:) 0)
				(if (== handRank 10)
					(= handRank 12)
				else
					(= handRank 11)
				)
			else
				(= handRank 13)
			)
		else
			(= handRank 13)
		)
		(self at: (sortHand returnNonSuit: param1))
	)

	(method (evaluateMore &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp0 (sortHand at: 0))
		(= temp1 (sortHand at: 1))
		(= temp2 (sortHand at: 2))
		(= temp3 (sortHand at: 3))
		(= temp4 (sortHand at: 4))
		(= temp5 0)
		(if (== (temp1 rank:) (+ (temp2 rank:) 1) (+ (temp3 rank:) 2))
			(if
				(or
					(== (temp0 rank:) (+ (temp1 rank:) 1))
					(== 1 (temp3 rank:) (- (temp0 rank:) 11))
				)
				(= handRank 10)
				(= temp5 temp4)
			)
			(if (== (temp3 rank:) (+ (temp4 rank:) 1))
				(= handRank 10)
				(= temp5 temp0)
			)
		)
		(if
			(==
				(temp1 rank:)
				(+ (temp2 rank:) 1)
				(+ (temp3 rank:) 2)
				(+ (temp4 rank:) 3)
			)
			(= handRank 9)
			(= temp5 temp0)
		)
		(if
			(and
				(== (temp2 rank:) (+ (temp3 rank:) 1) (+ (temp4 rank:) 2))
				(or
					(== (temp0 rank:) (+ (temp2 rank:) 1))
					(== 2 (temp2 rank:) (- (temp0 rank:) 10))
				)
			)
			(= handRank 9)
			(= temp5 temp0)
		)
		(if
			(and
				(or
					(== (temp0 rank:) (+ (temp1 rank:) 1))
					(== 3 (temp1 rank:) (- (temp0 rank:) 9))
				)
				(or
					(== (temp1 rank:) (+ (temp3 rank:) 1) (+ (temp4 rank:) 2))
					(== (temp1 rank:) (+ (temp2 rank:) 1) (+ (temp4 rank:) 2))
					(== (temp1 rank:) (+ (temp2 rank:) 1) (+ (temp3 rank:) 2))
				)
			)
			(= handRank 9)
			(= temp5 temp0)
		)
		(if (== spades 4)
			(= temp5 (self fourCardEval: 0 temp5))
		)
		(if (== clubs 4)
			(= temp5 (self fourCardEval: 1 temp5))
		)
		(if (== diamonds 4)
			(= temp5 (self fourCardEval: 2 temp5))
		)
		(if (== hearts 4)
			(= temp5 (self fourCardEval: 3 temp5))
		)
		(return temp5)
	)

	(method (markHand &tmp temp0 temp1 temp2 temp3)
		(if good
			(if (== self hand1)
				(for ((= temp0 (= temp1 0))) (< temp0 5) ((++ temp0))
					(if (not ((self at: temp0) discard:))
						(++ temp1)
					)
				)
			else
				(switch handRank
					(0
						(if (= temp2 (self evaluateMore:))
							(= temp1 4)
							(for ((= temp0 0)) (< temp0 5) ((++ temp0))
								(if (!= temp2 (= temp3 (self at: temp0)))
									(temp3 throwAway:)
								)
							)
						else
							(= temp1 2)
							(if (== (sortHand at: 0) 12)
								(< (sortHand at: 1) 9)
								(-- temp1)
							)
						)
					)
					(1
						(= temp1 2)
					)
					(2
						(= temp1 4)
					)
					(3
						(= temp1 3)
					)
					(7
						(= temp1 4)
					)
					(else
						(= temp1 5)
					)
				)
				(if (<= handRank 8)
					(for ((= temp0 0)) (< temp0 temp1) ((++ temp0))
						((self at: ((sortHand at: temp0) order:)) throwAway:)
					)
				)
			)
			(return (- 5 temp1))
		)
	)
)

(class HandList of List
	(properties
		ante 0
		currentBet 0
		pot 0
		allBet 0
		betOnce 0
	)

	(method (switchDealer &tmp temp0)
		(displayChipsList clear:)
		(self delete: (= temp0 (self at: 0)))
		(self add: temp0)
		(theDeck able: 1)
		(Wait 60)
		(gamePlay init:)
	)

	(method (putInPot param1)
		(+= pot param1)
		(if param1
			(gLongSong number: 563 loop: 1 flags: -1 play:)
		)
		(bankDisplay currentValue: pot updateAll:)
	)

	(method (makeBets &tmp temp0 temp1)
		(if (self winner:)
			(return)
		)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(if
				(and
					(==
						(-
							((self at: temp0) requiredBet:)
							(allHands currentBet:)
						)
						0
					)
					(not ((self at: temp0) makeHandBet: 0))
				)
				(return)
			)
		)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(if (not ((self at: temp0) makeHandBet: 0))
				(return)
			)
		)
		(= allBet 1)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(if (not ((self at: temp0) haveBet:))
				(= allBet 0)
			)
		)
		(if allBet
			(if (self winner:)
				(return)
			)
			(= betOnce 1)
			(gamePlay cue:)
		else
			(gamePlay state: (- (gamePlay state:) 1) cue:)
		)
	)

	(method (resetAll)
		(self resetHands: 1 pot: 0 betOnce: 0 currentBet: 0)
	)

	(method (resetHands param1)
		(displayChipsList clear:)
		(= allBet 0)
		(self eachElementDo: #resetBet 0)
		(if param1
			(self eachElementDo: #resetHand 1)
		)
	)

	(method (dealHands &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(if (!= (= temp1 (local0 at: temp0)) hand1)
				(temp1 dealHand:)
			)
		)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(cond
				((== (= temp1 (local0 at: temp0)) hand1)
					(if (not (hand1 haveAnte:))
						(= local0 hand1First)
						(return)
					)
				)
				((not (temp1 haveAnte:))
					(temp1 giveAnte:)
				)
			)
		)
		(gamePlay cue:)
	)

	(method (getNewHands &tmp temp0 temp1 temp2)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(if (and ((= temp1 (self at: temp0)) good:) (not (temp1 gotCards:)))
				(if (== temp1 hand1)
					(return)
				)
				(temp1 getNewCards:)
			)
		)
		(gamePlay cue:)
	)

	(method (winner &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(for ((= temp0 (= temp5 0))) (< temp0 size) ((++ temp0))
			(if ((self at: temp0) good:)
				(= temp6 (self at: temp0))
				(++ temp5)
			)
		)
		(cond
			((<= temp5 1)
				(Message msgGET 156 1 0 (temp6 handName:) 1 @local84)
				(Message msgGET 156 1 0 35 1 @local39) ; "%s win%s."
				(= local74 0)
				(if (!= self hand1)
					(Message msgGET 156 1 0 37 1 @local74) ; "s"
				)
				(Format @local4 @local39 @local84 @local74)
				(proc157_0 @local4)
				(if (== temp6 hand1)
					(playerChipsList change: pot updateAll:)
					(++ local2)
				)
				(self switchDealer:)
				(return 1)
			)
			((and betOnce allBet)
				(tieList eachElementDo: #delete release:)
				(= temp0 0)
				(= temp1 0)
				(while (< temp0 size)
					(if ((self at: temp0) good:)
						(= temp2 (self at: temp0))
						(= temp1 (temp2 showHand:))
						(break)
					)
					(++ temp0)
				)
				(++ temp0)
				(while (< temp0 size)
					(cond
						(
							(>
								(= temp3 ((= temp4 (self at: temp0)) showHand:))
								temp1
							)
							(tieList eachElementDo: #delete release:)
							(= temp1 temp3)
							(= temp2 temp4)
						)
						((and (temp4 good:) (== temp3 temp1))
							(= temp1 temp3)
							(= temp2 (temp2 tie: temp3 temp4))
						)
					)
					(++ temp0)
				)
				(if (tieList size:)
					(gMessager say: 1 0 22) ; "This hand is a tie between"
					(for ((= temp0 0)) (< temp0 (tieList size:)) ((++ temp0))
						(gMessager say: 1 0 (temp6 handName:))
					)
					(if (tieList contains: hand1)
						(playerChipsList
							change: (/ pot (tieList size:))
							updateAll:
						)
						(++ local2)
					)
				else
					(gMessager say: 1 0 13) ; "The winner is"
					(gMessager say: 1 0 (temp2 handName:))
					(if (== hand1 temp2)
						(playerChipsList change: pot updateAll:)
						(++ local2)
					)
				)
				(self switchDealer:)
				(return 1)
			)
		)
		(return 0)
	)
)

(class Deck of List
	(properties
		able 1
	)

	(method (init &tmp temp0 temp1)
		(super init:)
		(for ((= temp0 0)) (< temp0 52) ((++ temp0))
			(self add: (= temp1 (Card new:)))
			(temp1 value: temp0 hide: make:)
		)
	)

	(method (dealFirst param1 &tmp temp0)
		(if
			(and
				(not (param1 claimed:))
				(& (param1 type:) $0004)
				(!= (param1 message:) 13)
			)
			(return 0)
		)
		(if (theDeck able:)
			(for ((= temp0 0)) (< temp0 4) ((++ temp0))
				(dealButton flash:)
				(Wait 6)
			)
			(gMessager say: 1 0 14) ; "Please deal the cards first."
			(param1 claimed: 1)
			(return 0)
		)
		(return 1)
	)

	(method (deal &tmp temp0)
		(self delete: (= temp0 (NodeValue (self first:))) add: temp0)
		(return temp0)
	)

	(method (shuffle &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if able
			(gLongSong number: 562 loop: 3 flags: -1 play:)
			(= local0 allHands)
			(if local1
				(= local3
					(+ (/ (Max 0 (- (/ (* local2 100) local1) 25)) 10) 1)
				)
			else
				(= local3 1)
			)
			(++ local1)
			(allHands resetAll:)
			(for ((= temp1 (= able 0))) (< temp1 2) ((++ temp1))
				(for ((= temp0 0)) (< temp0 52) ((++ temp0))
					(= temp4 ((= temp3 (self at: (Random 0 51))) value:))
					(temp3 value: ((= temp2 (self at: temp0)) value:))
					(temp2 value: temp4)
				)
			)
			(self eachElementDo: #make)
			(allHands dealHands:)
			(return 1)
		else
			(if (hand1 haveAnte:)
				(gMessager say: 1 0 15) ; "You can not deal the cards right now."
			)
			(return 0)
		)
	)
)

(class Button of View
	(properties
		prevSignal 0
		message 0
		betButton 0
		betMsg 0
	)

	(method (addKeyMouse)
		((KeyMouse objList:) add: self)
	)

	(method (init)
		(super init:)
		(self addKeyMouse:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 0)
		)
		(event localize:)
		(if (self onMe: event)
			(if (and betButton (hand1 haveBet:))
				(gMessager say: 1 0 betMsg)
				(event claimed: 1)
				(return 0)
			)
			(cond
				((and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
					(event claimed: 1)
					(self flash:)
					(return 1)
				)
				((& (event type:) evMOUSEBUTTON)
					(event claimed: 1)
					(self track:)
					(return)
				)
			)
		)
		(return 0)
	)

	(method (track &tmp temp0 temp1 temp2 temp3)
		(self prevSignal: signal startUpd:)
		(= cel 1)
		((= temp3 (List new:)) add: self)
		(Animate (temp3 elements:) 0)
		(while (!= evMOUSERELEASE ((= temp1 (Event new:)) type:))
			(temp1 localize:)
			(if (!= cel (= temp2 (self onMe: temp1)))
				(= cel temp2)
				(Animate (temp3 elements:) 0)
			)
			(temp1 dispose: &rest)
		)
		(temp1 dispose: &rest)
		(= temp0 cel)
		(= cel 0)
		(Animate (temp3 elements:) 0)
		(temp3 eachElementDo: #delete release: dispose: &rest)
		(self signal: (& prevSignal $fffb) stopUpd:)
		(return temp0)
	)

	(method (flash &tmp temp0)
		(self startUpd:)
		(= cel 1)
		((= temp0 (List new:)) add: self)
		(Animate (temp0 elements:) 1)
		(Wait 1)
		(Wait 10)
		(= cel 0)
		(Animate (temp0 elements:) 1)
		(temp0 eachElementDo: #delete release: dispose: &rest)
		(self stopUpd:)
	)
)

(class ADisplay of List
	(properties
		maxValue 0
		minValue 0
		currentValue 0
		digits 0
		initX 0
		initY 0
		locked 0
		lockedMsg 0
	)

	(method (init &tmp temp0 temp1 temp2)
		(super init:)
		(for ((= temp0 0)) (< temp0 digits) ((++ temp0))
			(self add: (= temp1 (displayDigit new:)))
			(= temp2 (- (- digits temp0) 1))
			(temp1 posn: (+ initX (* temp2 5)) initY)
		)
		(self update:)
	)

	(method (updateAll)
		(self update: show:)
	)

	(method (update &tmp temp0 temp1)
		(= temp1 currentValue)
		(for ((= temp0 0)) (< temp0 digits) ((++ temp0))
			((self at: temp0) setCel: (mod temp1 10))
			(/= temp1 10)
		)
	)

	(method (show)
		(Animate (self elements:) 0)
	)

	(method (set param1)
		(= currentValue param1)
	)

	(method (change param1 &tmp temp0)
		(if locked
			(return 0)
		)
		(= temp0 currentValue)
		(+= currentValue param1)
		(cond
			((< currentValue minValue)
				(= currentValue minValue)
			)
			((> currentValue maxValue)
				(= currentValue maxValue)
			)
		)
		(return (!= temp0 currentValue))
	)

	(method (clear)
		(self set: 0 locked: 0 updateAll:)
	)

	(method (decrease)
		(self change: -1)
	)

	(method (increase)
		(self change: 1)
	)
)

(class Panel of Obj
	(properties
		upButton 0
		downButton 0
		okButton 0
		displayList 0
	)

	(method (init)
		(super init:)
		(upButton init:)
		(downButton init:)
		(okButton init:)
		(displayList init:)
	)

	(method (display param1)
		(if (displayList locked:)
			(gMessager say: 1 0 (displayList lockedMsg:))
		else
			(gMessager say: 1 0 (param1 message:))
		)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 0)
		)
		(if (and (upButton handleEvent: event) (hand1 checkAnte: event))
			(if (displayList increase:)
				(displayList updateAll:)
			else
				(self display: upButton)
			)
		)
		(if (and (downButton handleEvent: event) (hand1 checkAnte: event))
			(if (displayList decrease:)
				(displayList updateAll:)
			else
				(self display: downButton)
			)
		)
		(if (and (okButton handleEvent: event) (hand1 checkAnte: event))
			(if (not (displayList locked:))
				(cond
					((not (= temp0 (displayList currentValue:)))
						(if (not (hand1 pass:))
							(return)
						)
					)
					((== temp0 (allHands currentBet:))
						(hand1 call: makeHandBet: 1)
					)
					(else
						(hand1 bet: temp0 haveBet: 1)
						(if (not (hand1 makeHandBet: 1))
							(return)
						)
					)
				)
				(allHands makeBets:)
			else
				(self display: okButton)
			)
		)
		(event claimed:)
	)
)

(instance rm156 of PQRoom
	(properties
		picture 156
	)

	(method (init)
		(if global108
			(= global108 0)
			(= global251 1)
		)
		(SetFlag 1)
		(gGameControls disable: 3)
		(gGameControls disable: 4)
		(proc157_1)
		(ScriptID 157)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(Load rsVIEW 500)
		(Load rsVIEW 501)
		(theKeyMouseList add:)
		(KeyMouse init: setList: theKeyMouseList)
		(Narrator y: 130)
		(anteButton init:)
		(foldButton init:)
		(callButton init:)
		(dealButton init:)
		(okNewCardsButton init:)
		(chipsPanel init:)
		(theDeck init:)
		(displayNewCardsList init:)
		(playerChipsList init:)
		(bankDisplay init:)
		((chipsPanel displayList:) maxValue: global203)
		(playerChipsList currentValue: global202 update:)
		(allHands ante: global204)
		(allHands
			add: hand1 hand2 hand3 hand4
			init:
			eachElementDo: #init
			eachElementDo: #initHand
		)
		(hand1First add: hand1 hand2 hand3 hand4 init:)
		(HandsOn)
		(gTheIconBar disable: 0 4 5 3 1)
		(gTheIconBar curIcon: (gTheIconBar at: 2))
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
		(super init:)
		(Animate (gCast elements:) 0)
		((chipsPanel displayList:) show:)
		(displayNewCardsList show:)
		(playerChipsList show:)
		(bankDisplay show:)
		(allHands eachElementDo: #displayHand)
		(self setScript: gamePlay)
	)

	(method (dispose)
		((hand1 sortHand:) release:)
		(hand1 release:)
		((hand2 sortHand:) release:)
		(hand2 release:)
		((hand3 sortHand:) release:)
		(hand3 release:)
		((hand4 sortHand:) release:)
		(hand4 release:)
		((KeyMouse objList:) release:)
		(allHands release:)
		(hand1First release:)
		(tieList release:)
		(theDeck
			eachElementDo: #dispose &rest
			eachElementDo: #delete &rest
			release:
			dispose: &rest
		)
		((hand1 sortHand:) dispose: &rest)
		(hand1 dispose: &rest)
		((hand2 sortHand:) dispose: &rest)
		(hand2 dispose: &rest)
		((hand3 sortHand:) dispose: &rest)
		(hand3 dispose: &rest)
		((hand4 sortHand:) dispose: &rest)
		(hand4 dispose: &rest)
		(allHands dispose: &rest)
		(hand1First dispose: &rest)
		(tieList dispose: &rest)
		(displayNewCardsList
			eachElementDo: #dispose &rest
			eachElementDo: #delete
			release:
			dispose: &rest
		)
		(playerChipsList
			eachElementDo: #dispose &rest
			eachElementDo: #delete
			release:
			dispose: &rest
		)
		(bankDisplay
			eachElementDo: #dispose &rest
			eachElementDo: #delete
			release:
			dispose: &rest
		)
		((chipsPanel displayList:)
			eachElementDo: #dispose &rest
			eachElementDo: #delete
			release:
			dispose: &rest
		)
		(chipsPanel dispose: &rest)
		(displayDigit dispose: &rest)
		(gDirectionHandler delete: KeyMouse)
		((KeyMouse objList:)
			eachElementDo: #dispose &rest
			eachElementDo: #delete
			release:
			dispose: &rest
		)
		(theKeyMouseList dispose: &rest)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(DisposeScript 157)
		(ClearFlag 1)
		(gGameControls enable: 3)
		(gGameControls enable: 4)
		(super dispose:)
		(proc157_2)
	)

	(method (doit &tmp temp0)
		(if script 0)
		(super doit:)
	)

	(method (handleEvent event)
		(if (not (& (event type:) evMOUSERELEASE))
			(if (and (dealButton handleEvent: event) (theDeck shuffle:))
				(hand1 dealHand: giveAnte:)
				(allHands dealHands:)
			)
			(if (theDeck dealFirst: event)
				(if (anteButton handleEvent: event)
					(if (not (hand1 haveAnte:))
						(hand1 dealHand: giveAnte:)
						(allHands dealHands:)
					else
						(gMessager say: 1 0 16) ; "You can not ante at this time."
					)
				)
				(if (hand1 checkAnte: event)
					(if (foldButton handleEvent: event)
						(if (not (hand1 haveBet:))
							(hand1 fold: flipHand:)
							(allHands makeBets:)
						else
							(gMessager say: 1 0 17) ; "You can not fold at this time."
						)
					)
					(if (callButton handleEvent: event)
						(if (not (hand1 haveBet:))
							(hand1 call: makeHandBet: 1)
							(allHands makeBets:)
						else
							(gMessager say: 1 0 17) ; "You can not fold at this time."
						)
					)
					(if
						(and
							(okNewCardsButton handleEvent: event)
							(hand1 checkBet: event)
						)
						(hand1 getNewCards:)
						(allHands getNewHands:)
					)
					(chipsPanel handleEvent: event)
					(hand1 handleEvent: event)
				)
			)
		)
		(super handleEvent: event)
	)
)

(instance gamePlay of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(cond
					(
						(>=
							(= temp1
								(- global202 (playerChipsList currentValue:))
							)
							global200
						)
						(= global202 temp1)
						(= global209 2)
						(gMessager say: 1 0 19 1 self) ; "You lose."
					)
					((>= (- temp1) global201)
						(= global202 temp1)
						(= global209 3)
						(gMessager say: 1 0 20 1 self) ; "You win!"
					)
					((!= (allHands at: 0) hand1)
						(theDeck shuffle:)
					)
					(else
						(gMessager say: 1 0 21) ; "It is your turn to deal now."
					)
				)
				(gGame setCursor: 609)
			)
			(1
				(if (or (== global209 3) (== global209 2))
					(gCurRoom newRoom: gPrevRoomNum)
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(2
				(allHands makeBets:)
			)
			(3
				(allHands getNewHands:)
			)
			(4
				(allHands currentBet: 0 resetHands: 0)
				(= cycles 1)
			)
			(5
				(allHands makeBets:)
			)
			(6
				(allHands switchDealer:)
			)
		)
	)
)

(instance theDeck of Deck
	(properties)
)

(instance allHands of HandList
	(properties)
)

(instance hand1First of HandList
	(properties)
)

(instance tieList of Set
	(properties)
)

(instance theKeyMouseList of Set
	(properties)
)

(instance hand1 of Hand
	(properties
		initX 100
		initY 156
		handName 6
	)
)

(instance hand2 of Hand
	(properties
		initX 100
		initY 8
		handName 7
	)
)

(instance hand3 of Hand
	(properties
		initX 100
		initY 41
		handName 12
	)
)

(instance hand4 of Hand
	(properties
		initX 100
		initY 74
		handName 11
	)
)

(instance anteButton of Button
	(properties
		x 17
		y 118
		view 500
	)
)

(instance foldButton of Button
	(properties
		x 16
		y 137
		view 500
		loop 1
		betButton 1
		betMsg 17
	)
)

(instance callButton of Button
	(properties
		x 289
		y 119
		view 500
		loop 2
		betButton 1
		betMsg 18
	)
)

(instance dealButton of Button
	(properties
		x 280
		y 137
		view 500
		loop 3
	)
)

(instance upChipsButton of Button
	(properties
		x 261
		y 178
		view 500
		loop 5
		message 8
		betButton 1
		betMsg 5
	)
)

(instance downChipsButton of Button
	(properties
		x 279
		y 178
		view 500
		loop 6
		message 10
		betButton 1
		betMsg 5
	)
)

(instance okChipsButton of Button
	(properties
		x 297
		y 178
		view 500
		loop 7
		betButton 1
		betMsg 5
	)
)

(instance displayChipsList of ADisplay
	(properties
		digits 3
		initX 298
		initY 162
		lockedMsg 5
	)
)

(instance okNewCardsButton of Button
	(properties
		x 229
		y 178
		view 500
		loop 7
	)
)

(instance displayNewCardsList of ADisplay
	(properties
		maxValue 5
		digits 1
		initX 230
		initY 117
	)
)

(instance playerChipsList of ADisplay
	(properties
		maxValue 9999
		digits 4
		initX 26
		initY 162
	)
)

(instance bankDisplay of ADisplay
	(properties
		maxValue 9999
		digits 4
		initX 139
		initY 117
	)
)

(instance chipsPanel of Panel
	(properties)

	(method (init)
		(= upButton upChipsButton)
		(= downButton downChipsButton)
		(= okButton okChipsButton)
		(= displayList displayChipsList)
		(super init:)
	)
)

(instance displayDigit of View
	(properties
		view 500
		loop 4
	)
)

(instance sortCode of Code
	(properties)

	(method (doit param1)
		(return (- (param1 rank:)))
	)
)

