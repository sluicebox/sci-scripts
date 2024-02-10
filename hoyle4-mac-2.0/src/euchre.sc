;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 800)
(include sci.sh)
(use Main)
(use KeyMouse)
(use Piles)
(use Character)
(use Trick)
(use EScore)
(use EuchreStrategy)
(use Print)
(use TrickBox)
(use File)
(use System)

(public
	euchre 0
	proc800_1 1
	discardPile 2
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0 &tmp temp0)
	(if (!= (Deck size:) 24)
		(= global282 24)
		(for ((= temp0 (- (Deck size:) 1))) (>= temp0 0) ((-- temp0))
			(if (< ((Deck at: temp0) rank:) 9)
				(extraCards add: (Deck at: temp0))
				(Deck delete: (Deck at: temp0))
			)
		)
		(Deck topCard: 23)
	)
)

(procedure (localproc_1 &tmp temp0) ; UNUSED
	(if (!= (Deck size:) 32)
		(for ((= temp0 0)) (< temp0 (extraCards size:)) ((++ temp0))
			(Deck add: (extraCards at: temp0))
		)
		(extraCards release:)
		(Deck topCard: 31)
	)
)

(procedure (proc800_1)
	(proc0_8 1097)
	((ScriptID 880 0) init:) ; scoreEuchre
	(DisposeScript 880)
	(proc0_8 0)
)

(class EuchreTrick of Trick
	(properties
		spadesLed 0
		clubsLed 0
		diamondsLed 0
		heartsLed 0
	)

	(method (add param1 &tmp temp0 temp1 temp2)
		(if (not argc)
			(super add:)
		else
			(super add: param1)
			(= temp0 (and (== (param1 rank:) 11) (== (param1 suit:) global287)))
			(= temp1
				(and
					(== (param1 rank:) 11)
					(== (param1 suit:) (gTrick trump:))
				)
			)
			(= temp2 (param1 rank:))
			(if temp0
				(= temp2 15)
			)
			(if temp1
				(= temp2 16)
			)
			(cond
				((== size 1)
					(= suitLead (param1 suit:))
					(if temp0
						(= suitLead (gTrick trump:))
					)
					(if (== suitLead (gTrick trump:))
						(= highTrump temp2)
					)
					(= highOfSuitLead temp2)
					(switch suitLead
						(0
							(if (not spadesLed)
								(= spadesLed (Dealer curPlayer:))
							)
						)
						(1
							(if (not clubsLed)
								(= clubsLed (Dealer curPlayer:))
							)
						)
						(2
							(if (not diamondsLed)
								(= diamondsLed (Dealer curPlayer:))
							)
						)
						(3
							(if (not heartsLed)
								(= heartsLed (Dealer curPlayer:))
							)
						)
					)
					(= highPlayer (Dealer curPlayer:))
					(= highCard param1)
				)
				((or (== (param1 suit:) (gTrick trump:)) temp0)
					(if (!= suitLead trump)
						(switch suitLead
							(0
								((Dealer curPlayer:) outOfSpades: 1)
							)
							(1
								((Dealer curPlayer:) outOfClubs: 1)
							)
							(2
								((Dealer curPlayer:) outOfDiamonds: 1)
							)
							(3
								((Dealer curPlayer:) outOfHearts: 1)
							)
						)
					)
					(if (> temp2 highTrump)
						(= highTrump temp2)
						(if (== suitLead (gTrick trump:))
							(= highOfSuitLead temp2)
						)
						(= highPlayer (Dealer curPlayer:))
						(= highCard param1)
					)
				)
				(else
					(if
						(and
							(not highTrump)
							(== (param1 suit:) suitLead)
							(> temp2 highOfSuitLead)
						)
						(= highOfSuitLead temp2)
						(= highPlayer (Dealer curPlayer:))
						(= highCard param1)
					)
					(if (!= (param1 suit:) suitLead)
						(switch suitLead
							(0
								((Dealer curPlayer:) outOfSpades: 1)
							)
							(1
								((Dealer curPlayer:) outOfClubs: 1)
							)
							(2
								((Dealer curPlayer:) outOfDiamonds: 1)
							)
							(3
								((Dealer curPlayer:) outOfHearts: 1)
							)
						)
						(if
							(and
								(>=
									(switch ((Dealer curPlayer:) location:)
										(2 global196)
										(4 global197)
										(1 global198)
									)
									1
								)
								(!= highPlayer ((Dealer curPlayer:) partner:))
								(!= suitLead trump)
							)
							((Dealer curPlayer:) outOfTrump: 1)
						)
					)
					(if (== suitLead trump)
						((Dealer curPlayer:) outOfTrump: 1)
					)
				)
			)
		)
	)

	(method (validPlay param1 param2 &tmp temp0)
		(if
			(or
				(== suitLead -1)
				(and
					(== (param1 suit:) suitLead)
					(or (!= (param1 rank:) 11) (!= (param1 suit:) global287))
				)
				(and
					(== suitLead (gTrick trump:))
					(== (param1 rank:) 11)
					(== (param1 suit:) global287)
				)
			)
			(return 1)
		else
			(for ((= temp0 0)) (< temp0 (param2 size:)) ((++ temp0))
				(if
					(or
						(and
							(== ((param2 at: temp0) suit:) suitLead)
							(or
								(!= ((param2 at: temp0) rank:) 11)
								(!= ((param2 at: temp0) suit:) global287)
							)
						)
						(and
							(== suitLead (gTrick trump:))
							(== ((param2 at: temp0) rank:) 11)
							(== ((param2 at: temp0) suit:) global287)
						)
					)
					(gSound play: 905)
					(Print addText: 19 43 0 1 init:) ; "You must follow suit."
					(return 0)
				)
			)
		)
		(return 1)
	)
)

(class EuchreHand of Hand
	(properties
		pointsTaken 0
		finalRating 0
		bestSuitRated 0
		rightOpponent 0
		leftOpponent 0
		outOfTrump 0
		outOfSpades 0
		outOfClubs 0
		outOfDiamonds 0
		outOfHearts 0
		choice 0
		route 0
	)

	(method (init)
		(= outOfHearts
			(= outOfDiamonds (= outOfClubs (= outOfSpades (= outOfTrump 0))))
		)
	)

	(method (flip param1)
		(if argc
			(if (!= faceUp param1)
				(self eachElementDo: #flip param1)
			)
		else
			(self eachElementDo: #flip (if faceUp 0 else 1))
		)
	)

	(method (enterKey param1 param2)
		(= global458 param1)
		(cond
			((== (roomScript state:) 10)
				(self moveCard: discardPile self)
				(RedrawCast)
				(KeyMouse
					setCursor:
						(if param2
							param2
						else
							(self at: 0)
						)
				)
			)
			((gTrick validPlay: param1 self)
				(self moveCard: gTrick)
				(RedrawCast)
				(if size
					(KeyMouse
						setCursor:
							(if param2
								param2
							else
								(self at: 0)
							)
					)
				)
			)
		)
	)

	(method (thinkDiscard)
		(if (= global458 (EuchreStrategy thinkDiscard: self))
			(self moveCard: discardPile roomScript)
		)
	)

	(method (think &tmp temp0)
		(= global458 (EuchreStrategy think: self))
		(self moveCard: gTrick)
		(= gCrazy8sHand 0)
	)

	(method (bid &tmp temp0)
		(EuchreStrategy bid: self (discardPile upCard:))
		(DisposeScript 870)
	)

	(method (cue param1)
		(super cue:)
		(if (and argc param1)
			(return)
		)
		((ScriptID 15 6) setCycle: 0) ; littleCard
		(if (== (roomScript state:) 10)
			(discardPile setCard: global458)
		else
			(gTrick setCard: global458)
		)
		(= global395 0)
	)

	(method (couldPlay param1 &tmp temp0 temp1 temp2)
		(for ((= temp0 (= temp1 0))) (< temp0 size) ((++ temp0))
			(= temp2
				(and
					(== ((self at: temp0) rank:) 11)
					(== ((self at: temp0) suit:) global287)
				)
			)
			(cond
				((== param1 global287)
					(if (and (== ((self at: temp0) suit:) param1) (not temp2))
						((self at: temp0) valid: 1)
						(++ temp1)
					else
						((self at: temp0) valid: 0)
					)
				)
				((== param1 (gTrick trump:))
					(if (or (== ((self at: temp0) suit:) param1) temp2)
						((self at: temp0) valid: 1)
						(++ temp1)
					else
						((self at: temp0) valid: 0)
					)
				)
				((== ((self at: temp0) suit:) param1)
					((self at: temp0) valid: 1)
					(++ temp1)
				)
				(else
					((self at: temp0) valid: 0)
				)
			)
		)
		(return temp1)
	)

	(method (sort param1 &tmp temp0 temp1)
		(if (or faceUp (and argc param1))
			(= temp0 0)
			(for ((= temp1 0)) (< temp1 size) ((++ temp1))
				(if
					(and
						(== ((self at: temp1) rank:) 11)
						(== ((self at: temp1) suit:) global287)
					)
					(= temp0 (self at: temp1))
					(break)
				)
			)
			(switch global394
				(3
					(if temp0
						(temp0 suit: (gTrick trump:))
					)
					(Sorts self (ScriptID 15 5) (ScriptID 15 3)) ; sortedList, ascendingBySuitCode
					(if temp0
						(temp0 suit: global287)
					)
				)
				(4
					(if temp0
						(temp0 suit: (gTrick trump:))
					)
					(Sorts self (ScriptID 15 5) (ScriptID 15 4)) ; sortedList, descendingBySuitCode
					(if temp0
						(temp0 suit: global287)
					)
				)
				(else
					(return)
				)
			)
			(self update:)
		)
	)

	(method (update &tmp temp0)
		(self release:)
		(for ((= temp0 0)) (< temp0 ((ScriptID 15 5) size:)) ((++ temp0)) ; sortedList
			(self add: ((ScriptID 15 5) at: temp0)) ; sortedList
		)
		((ScriptID 15 5) release: dispose:) ; sortedList
		(if gCrazy8sSortCode
			(gCrazy8sSortCode doit: self)
		)
		(self posn:)
	)
)

(instance hand1 of EuchreHand
	(properties
		x 95
		y 155
		handNumber 3
		faceUp 1
		centerX 160
		centerY 175
	)
)

(instance hand2 of EuchreHand
	(properties
		x 3
		y 30
		handDirection 2
		type 1
		handNumber 2
		location 4
		centerX 25
		centerY 100
	)
)

(instance hand3 of EuchreHand
	(properties
		x 95
		y 3
		type 1
		handNumber 1
		location 1
		centerX 160
		centerY 25
	)
)

(instance hand4 of EuchreHand
	(properties
		x 280
		y 30
		handDirection 2
		type 1
		handNumber 4
		location 2
		centerX 295
		centerY 100
	)
)

(instance euchre of HoyleRoom
	(properties
		style 10
	)

	(method (init)
		(= picture (+ 901 global385))
		(Load rsVIEW 50)
		(Load rsVIEW 51)
		(Load rsVIEW 52)
		(Load rsVIEW 53)
		(Load rsVIEW (+ 54 global384))
		(= local0 0)
		((= gEuchre_opt euchre_opt) doit:)
		(if global462
			(gChar1 view: global463 active: 1 loop: global466)
			((gChar1 face:) view: global463)
			(gChar2 view: global464 active: 1 loop: global467)
			((gChar2 face:) view: global464)
			(gChar3 view: global465 active: 1 loop: global468)
			((gChar3 face:) view: global465)
			(= global196 global469)
			(= global197 global470)
			(= global198 global471)
		)
		(super init:)
		(gGame setCursor: 999)
		(PicNotValid 1)
		(Piles add:)
		(Deck init: Card 1)
		(extraCards add:)
		(= global193 800)
		((= global117 theHands) add: hand1 hand2 hand3 hand4)
		(= gAddToTricksWon addToTricksWon)
		(hand1 partner: hand3 rightOpponent: hand4 leftOpponent: hand2)
		(hand3 partner: hand1 rightOpponent: hand2 leftOpponent: hand4)
		(hand2 partner: hand4 rightOpponent: hand1 leftOpponent: hand3)
		(hand4 partner: hand2 rightOpponent: hand3 leftOpponent: hand1)
		(hand1 add: owner: 0)
		(hand2 add: owner: gChar1)
		(hand3 add: owner: gChar2)
		(hand4 add: owner: gChar3)
		((ScriptID 15 1) add:) ; discardList
		(discardPile client: hand1)
		(= global419 theStock)
		(global419 client: hand1 theDiscardPile: discardPile)
		(EuchreTrick init:)
		(gTrick add: init: trump: -1)
		(handleEventList add:)
		(= global394 global281)
		(= [global390 0] 2)
		(= [global390 1] 1)
		(= [global390 2] 3)
		(= [global390 3] 0)
		(Dealer cardsToDeal: 5 cardsAtATime: 3)
		(Deck rankAces: 14)
		(gChar1 posn: 68 115 show: init:)
		(gChar2 posn: 95 39 show: init:)
		(gChar3 posn: 250 115 show: init:)
		(Characters init:)
		((gChar1 face:) view: (gChar1 view:))
		((gChar2 face:) view: (gChar2 view:))
		((gChar3 face:) view: (gChar3 view:))
		(Deck shuffle:)
		(gEuchre_opt doit: 3)
		(KeyMouse setList: gTheKeyMouseList)
		(self setScript: roomScript)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(handleEventList handleEvent: event)
	)

	(method (doit)
		(super doit:)
		(Dealer doit:)
		(if global290
			(= global290 0)
			(global117 eachElementDo: #sort)
			(Animate (gCast elements:) 1)
			(HandsOn)
		)
		(if global388
			(= global388 0)
			(if (gDelayCast size:)
				(Animate (gDelayCast elements:) 0)
			)
		)
	)

	(method (dispose &tmp temp0)
		(= global395 0)
		(= global458 0)
		(= global419 0)
		(KeyMouse release:)
		(gTrick numCardsInATrick: 4)
		(= gAddToTricksWon 0)
		(gTrick release: dispose:)
		((ScriptID 15 1) release: dispose:) ; discardList
		(for ((= temp0 0)) (< temp0 (Piles size:)) ((++ temp0))
			(if ((Piles at: temp0) respondsTo: #release)
				((Piles at: temp0) release:)
			)
		)
		(Piles eachElementDo: #dispose release: dispose:)
		(Dealer dispose:)
		(global117
			eachElementDo: #release
			eachElementDo: #dispose
			release:
			dispose:
		)
		(handleEventList release: dispose:)
		(extraCards release: dispose:)
		(Deck dispose:)
		(DisposeScript 802)
		(DisposeScript 702)
		(DisposeScript 880)
		(DisposeScript 870)
		(DisposeScript 940)
		(DisposeScript 941)
		(DisposeScript 9)
		(super dispose:)
	)

	(method (beforeNewPic)
		(if (TrickBox active:)
			(TrickBox save:)
		)
		(super beforeNewPic:)
		(return 1)
	)

	(method (afterNewPic)
		(if (TrickBox active:)
			(TrickBox restore:)
		)
		(super afterNewPic:)
	)
)

(instance theHands of List
	(properties)
)

(instance handleEventList of EventHandler
	(properties)
)

(instance euchre_opt of File
	(properties
		name {euchre.opt}
	)

	(method (doit param1 &tmp [temp0 20] [temp20 10])
		(cond
			((and argc (== param1 3))
				(if (self open: 2)
					(self
						writeString:
							(Format ; "%d%2d%2d%2d%2d%2d%d%d%d%d%d%d%d"
								@temp0
								800
								0
								global281
								global282
								global283
								(gChar1 view:)
								(gChar2 view:)
								(gChar3 view:)
								(gChar1 loop:)
								(gChar2 loop:)
								(gChar3 loop:)
								global196
								global197
								global198
								global288
							)
						close:
					)
					(return 1)
				else
					(return 0)
				)
			)
			((self open: 1)
				(= global281 (ReadNumber (self readString: @temp20 2)))
				(= global282 (ReadNumber (self readString: @temp20 3)))
				(= global283 (ReadNumber (self readString: @temp20 3)))
				(= global463 (ReadNumber (self readString: @temp20 3)))
				(= global464 (ReadNumber (self readString: @temp20 3)))
				(= global465 (ReadNumber (self readString: @temp20 3)))
				(= global466 (ReadNumber (self readString: @temp20 2)))
				(= global467 (ReadNumber (self readString: @temp20 2)))
				(= global468 (ReadNumber (self readString: @temp20 2)))
				(= global469 (ReadNumber (self readString: @temp20 2)))
				(= global470 (ReadNumber (self readString: @temp20 2)))
				(= global471 (ReadNumber (self readString: @temp20 2)))
				(= global288 (ReadNumber (self readString: @temp20 2)))
				(self close:)
				(return 0)
			)
			(else
				(= global281 3)
				(= global282 24)
				(= global283 5)
				(= global463 11)
				(= global464 16)
				(= global465 13)
				(= global466 2)
				(= global467 2)
				(= global468 2)
				(= global469 2)
				(= global470 2)
				(= global471 2)
				(= global288 0)
				(= local0 1)
				(return 0)
			)
		)
	)
)

(instance roomScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 5] temp5 temp6 temp7)
		(switch (= state newState)
			(0
				(Wait 1)
				(= ticks 1)
			)
			(1
				(PicNotValid 0)
				(if local0
					(RedrawCast)
					(HandsOn)
					(gGameControls hide:)
					(= local1 (gSystemWindow back:))
					(gSystemWindow back: 53)
					((ScriptID 890 0) init:) ; optionEuchre
					(gSystemWindow back: local1)
					(HandsOff)
				)
				(gSong fade:)
				(= ticks 1)
			)
			(2
				(= ticks 1)
				(Dealer init: hand1 hand2 hand3 hand4)
			)
			(3
				(EScore gameInit:)
				(global117
					eachElementDo: #total 0
					eachElementDo: #prevTotal 0
					eachElementDo: #handTotal 0
					eachElementDo: #tempTotal 0
				)
				(= global402 0)
				(= ticks 1)
			)
			(4
				(global117 eachElementDo: #init)
				(gTrick spadesLed: 0 clubsLed: 0 diamondsLed: 0 heartsLed: 0)
				(= global431 (= global284 0))
				(= global286 1)
				(localproc_0)
				(hand1 pointsTaken: 0)
				(hand2 pointsTaken: 0)
				(hand3 pointsTaken: 0)
				(hand4 pointsTaken: 0)
				(gTrick
					tricksPlayed: 0
					numCardsInATrick: 4
					northPlayer: hand3
					southPlayer: hand1
					eastPlayer: hand4
					westPlayer: hand2
				)
				(= global287 -1)
				(HandsOff)
				(Dealer playDirection: 0 deal: self)
				(Piles delete: gTrick add: discardPile)
			)
			(5
				(hand1 sort:)
				(= ticks 1)
			)
			(6
				(gSound play: 503)
				(Deck eachElementDo: #valid 0)
				(EScore handInit:)
				(Arrow x: 260 y: 20 init:)
				(global419 init:)
				(HandsOff)
				(handleEventList add: hand1 hand2 hand3 hand4 discardPile)
				(= ticks 20)
			)
			(7
				(discardPile init:)
				(= temp5 (Deck getCard:))
				(discardPile setCard: temp5 1 0)
				(temp5 init:)
				(= global285 (temp5 suit:))
				(= ticks 20)
			)
			(8
				(if (== ((Dealer curPlayer:) type:) 1)
					((Dealer curPlayer:) bid:)
					(= temp7 ((Dealer curPlayer:) owner:))
					(switch global425
						(-1
							(gSound play: 703)
							(if temp7
								(temp7 say: 1000 1 0 0 14)
							)
						)
						(5
							(cond
								((== (Dealer curPlayer:) (Dealer dealer:))
									(gSound play: 801)
									(if temp7
										(temp7 say: 1000 1 0 23 19)
									)
								)
								(
									(==
										((Dealer curPlayer:) partner:)
										(Dealer dealer:)
									)
									(gSound play: 801)
									(if temp7
										(temp7 say: 1000 1 0 0 18)
									)
								)
								(else
									(gSound play: 801)
									(if temp7
										(temp7 say: 1000 1 0 0 18)
									)
								)
							)
						)
						(0
							(gSound play: 912)
							(if temp7
								(temp7 say: 1000 1 0 0 8)
							)
						)
						(1
							(gSound play: 912)
							(if temp7
								(temp7 say: 1000 1 0 0 2)
							)
						)
						(2
							(gSound play: 912)
							(if temp7
								(temp7 say: 1000 1 0 0 4)
							)
						)
						(3
							(gSound play: 912)
							(if temp7
								(temp7 say: 1000 1 0 0 6)
							)
						)
					)
				else
					(HandsOn)
					((ScriptID 801 0) init:) ; bidEuchre
					(DisposeScript 801)
					(if (OneOf global425 0 1 2 3 5)
						(gSound play: 912)
					)
				)
				(cond
					((== global425 -1)
						(if (== (Dealer curPlayer:) (Dealer dealer:))
							(if (== (++ global286) 2)
								(handleEventList delete: discardPile)
								(discardPile endHand:)
							)
							(if (== global286 3)
								(Piles delete: discardPile add: gTrick)
								(global419 endHand:)
								(= state 15)
							)
						)
					)
					((<= 0 global425 3)
						(gTrick trump: global425)
						(= global429 (Dealer curPlayer:))
						(= state 12)
					)
					((== global425 5)
						(gTrick trump: global285)
						(= global429 (Dealer curPlayer:))
						(= state 9)
						((discardPile upCard:) hide:)
						(if
							(and
								global284
								(== (Dealer dealer:) (global429 partner:))
							)
							(= state 10)
							(= ticks 1)
						else
							(discardPile getCard: (Dealer dealer:) self)
						)
					)
				)
				(if global284
					(gSound2 play: 802)
					(if (and (global429 owner:) (!= (global429 type:) 0))
						((global429 owner:) say: 1000 1 0 0 21)
					)
					(gTrick numCardsInATrick: 3)
					(= global431 (global429 partner:))
					(global431 endHand:)
				else
					(gTrick numCardsInATrick: 4)
				)
				(= global287
					(switch (gTrick trump:)
						(0 1)
						(1 0)
						(2 3)
						(3 2)
					)
				)
				(if (!= global425 5)
					(= ticks
						(if (== ((Dealer curPlayer:) type:) 1)
							(* global386 5)
						else
							1
						)
					)
				)
			)
			(9
				(Dealer nextToPlay:)
				(-= state 2)
				(= ticks
					(if (== ((Dealer curPlayer:) type:) 1)
						(* global386 5)
					else
						1
					)
				)
			)
			(10
				(Dealer nextToPlay: (Dealer dealer:))
				(if (== ((Dealer dealer:) type:) 1)
					((Dealer dealer:) thinkDiscard:)
				else
					((Dealer dealer:) eachElementDo: #addKeyMouse)
					(HandsOn)
				)
			)
			(11
				(= ticks 10)
			)
			(12
				((Dealer dealer:) cue: 1)
				(if (discardPile upCard:)
					((discardPile upCard:) flip: 0)
				)
				(= ticks 30)
			)
			(13
				(hand1 eachElementDo: #addKeyMouse)
				(TrickBox init: (EScore weTricksWon:) (EScore theyTricksWon:))
				(global117 eachElementDo: #sort)
				(Piles delete: discardPile add: gTrick)
				(global419 endHand:)
				(handleEventList delete: discardPile)
				(discardPile endHand:)
				(Dealer nextToPlay: (Dealer dealer:))
				(Dealer nextToPlay:)
				(if global431
					(Dealer nextToPlay: global429)
					(Dealer nextToPlay:)
				)
				(= global395 0)
				(= ticks 1)
			)
			(14
				(gTrick leader: (Dealer curPlayer:))
				(= global112 (gTrick leader:))
				(= global113 (global112 leftOpponent:))
				(= global114 (global113 leftOpponent:))
				(= global115 (global114 leftOpponent:))
				(if (== global431 (Dealer curPlayer:))
					(Dealer nextToPlay:)
				)
				(if (== ((Dealer curPlayer:) type:) 1)
					((Dealer curPlayer:) think:)
				else
					(HandsOn)
				)
			)
			(15
				(Dealer
					nextToPlay:
						(if (gTrick size:)
							0
						else
							(gTrick leader:)
						)
				)
				(if (and global459 (not (gTrick size:)))
					(= ticks 1)
				else
					(= ticks
						(if (== ((Dealer curPlayer:) type:) 1)
							(* global386 5)
						else
							1
						)
					)
					(if (!= (gTrick tricksPlayed:) 5)
						(-= state 2)
					)
				)
			)
			(16
				(= ticks 1)
			)
			(17
				(HandsOn)
				(Arrow endHand:)
				(handleEventList delete: hand1 hand2 hand3 hand4)
				(= ticks 1)
			)
			(18
				(= local3 1)
				(if (!= global286 3)
					(cond
						(
							(= temp6
								(or
									(== (global429 location:) 1)
									(== (global429 location:) 3)
								)
							)
							(cond
								((== (EScore weTricksWon:) 5)
									(if global284
										(switch (Random 1 3)
											(2
												(gChar1
													say:
														1000
														1
														23
														0
														(Random 4 5)
														466
												)
											)
											(3
												(gChar2
													say:
														1000
														1
														23
														0
														(Random 1 2)
														464
												)
											)
											(4
												(gChar3
													say:
														1000
														1
														23
														0
														(Random 4 5)
														466
												)
											)
										)
										(= local3 0)
									)
									(EScore addScore: 0 (if global284 4 else 2))
								)
								((>= (EScore weTricksWon:) 3)
									(EScore addScore: 0 1)
								)
								(else
									(= local3 0)
									(switch (Random 1 6)
										(2
											(gChar1
												say:
													1000
													1
													23
													0
													(Random 1 2)
													464
											)
										)
										(3
											(gChar2
												say:
													1000
													1
													23
													0
													(Random 3 5)
													466
											)
										)
										(4
											(gChar3
												say:
													1000
													1
													23
													0
													(Random 1 2)
													464
											)
										)
										(else
											(= local3 1)
										)
									)
									(EScore addScore: 1 2)
								)
							)
						)
						((== (EScore theyTricksWon:) 5)
							(if global284
								(switch (Random 2 4)
									(2
										(gChar1
											say: 1000 1 23 0 (Random 1 2) 464
										)
									)
									(3
										(gChar2
											say: 1000 1 23 0 (Random 4 5) 466
										)
									)
									(4
										(gChar3
											say: 1000 1 23 0 (Random 1 2) 464
										)
									)
								)
								(= local3 0)
							)
							(EScore addScore: 1 (if global284 4 else 2))
						)
						((>= (EScore theyTricksWon:) 3)
							(EScore addScore: 1 1)
						)
						(else
							(= local3 0)
							(switch (Random 1 6)
								(2
									(gChar1
										say: 1000 1 23 0 (Random 3 5) 466
									)
								)
								(3
									(gChar2
										say: 1000 1 23 0 (Random 1 2) 464
									)
								)
								(4
									(gChar3
										say: 1000 1 23 0 (Random 3 5) 466
									)
								)
								(else
									(= local3 1)
								)
							)
							(EScore addScore: 0 2)
						)
					)
					(TrickBox erase:)
					(if
						(and
							(or
								(>= (EScore wePoints:) global283)
								(>= (EScore theyPoints:) global283)
							)
							local3
						)
						(cond
							((>= (EScore wePoints:) global283)
								(gChar2 say: 1000 1 23 0 (Random 1 2) 464)
							)
							((Random 0 1)
								(gChar1 say: 1000 1 23 0 (Random 1 2) 464)
							)
							(else
								(gChar3 say: 1000 1 23 0 (Random 1 2) 464)
							)
						)
					)
					(proc800_1)
				)
				(global117 eachElementDo: #endHand)
				(= ticks 1)
			)
			(19
				((ScriptID 15 1) release:) ; discardList
				(if
					(and
						(< (EScore wePoints:) global283)
						(< (EScore theyPoints:) global283)
					)
					(= state 3)
					(Deck shuffle:)
					(Dealer rotate: cardsToDeal: 5)
				)
				(= ticks 1)
			)
			(20
				((ScriptID 930 0) init: 870) ; yesNo
				(DisposeScript 930)
				(if global461
					(= state 2)
					(Deck shuffle:)
					(Dealer rotate: cardsToDeal: 5)
				)
				(= ticks 1)
			)
			(21
				(= gNewRoomNum 975) ; chooseGame
			)
		)
	)
)

(instance addToTricksWon of Code
	(properties)

	(method (doit param1)
		(switch param1
			((gTrick northPlayer:)
				(EScore weTricksWon: (+ (EScore weTricksWon:) 1))
				(TrickBox
					increment: 0 (EScore weTricksWon:) (EScore theyTricksWon:)
				)
				(cond
					((OneOf global429 hand2 hand4)
						(if (and global284 (== (EScore weTricksWon:) 1))
							(= global253 1109)
						)
						(if (== (EScore weTricksWon:) 3)
							(= global253 1109)
						)
					)
					((== (EScore weTricksWon:) 5)
						(if global284
							(= global253 803)
						else
							(= global253 402)
						)
					)
				)
			)
			((gTrick southPlayer:)
				(EScore weTricksWon: (+ (EScore weTricksWon:) 1))
				(TrickBox
					increment: 0 (EScore weTricksWon:) (EScore theyTricksWon:)
				)
				(cond
					((OneOf global429 hand2 hand4)
						(if (and global284 (== (EScore weTricksWon:) 1))
							(= global253 1109)
						)
						(if (== (EScore weTricksWon:) 3)
							(gChar1 say: 1000 1 23 0 (Random 4 5) 466)
							(= global253 1109)
						)
					)
					((== (EScore weTricksWon:) 5)
						(if global284
							(= global253 803)
						else
							(= global253 402)
						)
					)
				)
			)
			((gTrick eastPlayer:)
				(EScore theyTricksWon: (+ (EScore theyTricksWon:) 1))
				(TrickBox
					increment: 1 (EScore weTricksWon:) (EScore theyTricksWon:)
				)
				(cond
					((OneOf global429 hand1 hand3)
						(if (and global284 (== (EScore theyTricksWon:) 1))
							(= global253 1109)
						)
						(if (== (EScore theyTricksWon:) 3)
							(= global253 1109)
						)
					)
					((== (EScore theyTricksWon:) 5)
						(if global284
							(= global253 803)
						else
							(= global253 402)
						)
					)
				)
			)
			((gTrick westPlayer:)
				(EScore theyTricksWon: (+ (EScore theyTricksWon:) 1))
				(TrickBox
					increment: 1 (EScore weTricksWon:) (EScore theyTricksWon:)
				)
				(cond
					((OneOf global429 hand1 hand3)
						(if (and global284 (== (EScore theyTricksWon:) 1))
							(= global253 1109)
						)
						(if (== (EScore theyTricksWon:) 3)
							(= global253 1109)
						)
					)
					((== (EScore theyTricksWon:) 5)
						(if global284
							(= global253 803)
						else
							(= global253 402)
						)
					)
				)
			)
		)
	)
)

(instance extraCards of List
	(properties)
)

(instance theStock of Stock
	(properties
		active 0
	)

	(method (init)
		(switch ((Dealer dealer:) location:)
			(1
				(= x 142)
				(= y 51)
			)
			(3
				(= x 142)
				(= y 104)
			)
			(2
				(= x 182)
				(= y 77)
			)
			(4
				(= x 100)
				(= y 77)
			)
		)
		(= loop 2)
		(super init:)
	)
)

(instance discardPile of DiscardPile
	(properties
		emptyLoop 6
	)

	(method (handleEvent)
		(return 1)
	)

	(method (init)
		(switch ((Dealer dealer:) location:)
			(1
				(= x 143)
				(= y 52)
			)
			(3
				(= x 143)
				(= y 105)
			)
			(2
				(= x 183)
				(= y 78)
			)
			(4
				(= x 101)
				(= y 78)
			)
		)
		(super init:)
	)

	(method (setCard param1 param2 param3 &tmp temp0)
		(if upCard
			(upCard hide:)
		)
		(= associatedObj (= upCard param1))
		(= global549 upCard)
		(param1
			flip: (if (and (>= argc 2) param2) param2 else 1)
			setLoop: 0
			setPri: 2
			stopUpd:
			show:
			forceUpd:
			deleteKeyMouse:
		)
		((ScriptID 15 1) add: param1) ; discardList
		(self adjust:)
		(= global116 0)
		(if (or (<= argc 2) param3)
			(roomScript cue:)
		)
	)
)

