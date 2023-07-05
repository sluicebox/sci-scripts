;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 250)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use LoadMany)
(use Sound)
(use Actor)
(use System)

(public
	rm250 0
)

(local
	dealerTotal
	egoTotal
	splitTotal
	cardNum
	[dealerCards 6]
	[egoCards 7]
	[splitCards 6]
	dealersAces
	egosAces
	splitsAces
	egoBusted
	egoCardInc
	splitCardInc
	handOver
	dealerCardInc
	dealersCard
	bet
	status1
	status2
	[str 80]
	[str1 80]
	dealersFirstCard
	dealerShowCard
	egoDoublingDown
	splitDoublingDown
	egosFirstCard
	egosSecondCard
	splitting
	egoHandDone
	splitBusted
	machineDollars
	dontBlink
	brokeHouse
)

(procedure (localproc_0)
	(gTheMusic2 number: 266 play:)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
	(if brokeHouse
		(Print 250 55) ; "This machine only contains $10,000.00; trust us, we'll mail you the rest."
	)
	(Printf 250 56 machineDollars machineDollars) ; "You pocket your $%d.00 from the tray and wish you had won more."
	(gEgo z: 0 hide:)
	(deck dispose:)
	(= gLarryDollars machineDollars)
	(gCast eachElementDo: #dispose)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
	(gCurRoom newRoom: 310)
)

(procedure (localproc_1 &tmp temp0)
	(= temp0 (Random 0 51))
	(if (== (deck at: temp0) -1)
		(= temp0 (localproc_1))
	else
		(deck delete: (deck at: temp0))
		(deck addAfter: (- temp0 1) -1)
		(return temp0)
	)
)

(procedure (localproc_2)
	([dealerCards 0] loop: (/ dealersFirstCard 13) cel: (mod dealersFirstCard 13))
	(Animate (gCast elements:) 0)
)

(procedure (localproc_3 param1)
	(return
		(cond
			((== (mod cardNum 13) 0)
				(switch param1
					(0
						(++ dealersAces)
					)
					(1
						(++ egosAces)
					)
					(2
						(++ splitsAces)
					)
				)
				11
			)
			((< (mod cardNum 13) 9)
				(+ (mod cardNum 13) 1)
			)
			(else 10)
		)
	)
)

(procedure (localproc_4 param1 param2)
	(gTheMusic3 number: 250 play:)
	(switch param1
		(0
			((= [dealerCards dealersCard] (Clone card))
				loop: (/ cardNum 13)
				cel: (mod cardNum 13)
				x: (+ 61 (* param2 33))
				y: 25
				init:
			)
		)
		(1
			((= [egoCards egoCardInc] (Clone card))
				loop: (/ cardNum 13)
				cel: (mod cardNum 13)
				x: (+ 61 (* param2 33))
				y: 105
				init:
			)
		)
		(2
			((= [splitCards splitCardInc] (Clone card))
				loop: (/ cardNum 13)
				cel: (mod cardNum 13)
				x: (+ 61 (* param2 33))
				y: 66
				init:
			)
		)
	)
)

(procedure (localproc_5)
	(return
		(+
			(* bet egoDoublingDown)
			(if splitting
				(* bet splitDoublingDown)
			else
				0
			)
		)
	)
)

(procedure (localproc_6)
	(HandsOn)
	(if
		(>=
			(- (+ (localproc_5) (/ bet 2)) 1)
			(if (== (mod machineDollars 2) 0)
				machineDollars
			else
				(- machineDollars 1)
			)
		)
		(return 0)
	else
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(gGame setCursor: 999 1)
		(Animate (gCast elements:) 0)
		(return (Print 250 57 #button {Yes} 1 #button {No} 0)) ; "Do you want insurance?"
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
	)
	(return (HandsOff))
)

(procedure (localproc_7 param1)
	(if (> param1 0)
		(if
			(or
				(and (== egoTotal 21) (== egoCardInc 1))
				(and (== splitTotal 21) (== splitCardInc 1))
			)
			(soundFX number: 253 play:)
		else
			(soundFX number: 252 play:)
		)
	)
	(if (< param1 0)
		(soundFX number: 251 play:)
	)
	(if (> param1 0)
		(if (< (+ machineDollars param1) 0)
			(= machineDollars 10000)
			(= brokeHouse 1)
		else
			(+= machineDollars param1)
		)
	else
		(+= machineDollars param1)
	)
	(if (< machineDollars 0)
		(= machineDollars 0)
	)
	(if (> machineDollars 10000)
		(= machineDollars 10000)
		(= brokeHouse 1)
	)
	(localproc_12 1)
	(if (and (== egoTotal 21) (== egoCardInc 1))
		(return (+ param1 (/ param1 2)))
	else
		(return param1)
	)
)

(procedure (localproc_8 param1)
	(soundFX number: 260 play:)
	(param1 setCel: 1)
	(Animate (gCast elements:) 0)
	(param1 setCel: 0)
	(Animate (gCast elements:) 0)
)

(procedure (localproc_9 &tmp temp0)
	(if (mod (= temp0 (/ (+ bet 100) 50)) 2)
		(return (- temp0 1))
	else
		(return temp0)
	)
)

(procedure (localproc_10)
	(= handOver 1)
	(HandsOn)
	(if (>= bet machineDollars)
		(if (mod bet 2)
			(= bet (- machineDollars 1))
		else
			(= bet machineDollars)
		)
		(if (< bet 10)
			(= bet 10)
		)
		(localproc_11 1)
	)
)

(procedure (localproc_11 param1)
	(if (== param1 1)
		(Display 250 58 dsRESTOREPIXELS status1)
	)
	(= status1
		(Display (Format @str 250 59 bet) dsCOORD 120 11 dsCOLOR gColBlack dsSAVEPIXELS) ; "$%d"
	)
)

(procedure (localproc_12 param1)
	(if (== param1 1)
		(Display 250 58 dsRESTOREPIXELS status2)
	)
	(= status2
		(Display (Format @str1 250 59 machineDollars) dsCOORD 165 11 dsCOLOR gColBlack dsSAVEPIXELS) ; "$%d"
	)
)

(instance rm250 of LLRoom
	(properties
		picture 250
		style 0
	)

	(method (init)
		(LoadMany rsVIEW 250 251)
		(LoadMany rsSOUND 250 251 252 266 260)
		(gTheMusic3 loop: 1 vol: 127 flags: 1)
		(gTheMusic2 loop: 1 vol: 127 flags: 1)
		(gEgo init: z: 1000 hide:)
		(super init:)
		(theDouble init: stopUpd:)
		(theSplit init: stopUpd:)
		(theDeal init: stopUpd:)
		(hitMe init: stopUpd:)
		(stand init: stopUpd:)
		(changeBet init: stopUpd:)
		(surrender init: stopUpd:)
		(odds init: stopUpd:)
		(cashout init: stopUpd:)
		(increase init: stopUpd:)
		(decrease init: stopUpd:)
		(= bet 10)
		(= machineDollars gLarryDollars)
		(localproc_11 0)
		(localproc_12 0)
		(= handOver 1)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Print 250 0) ; "The numbers at the top of the video blackjack machine indicate the size of your current bet and the total amount of credit you have in the machine."
				(Print 250 1) ; "For help, just look at the various buttons."
			)
			(5 ; Talk
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Print 250 2) ; "Come on, dammit, pay off!"
			)
			(3 ; Do
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Print 250 3) ; "Click on a button instead of where you just clicked."
			)
			(10 ; Zipper
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Print 250 4) ; ""Screw you, machine!" you shout, never one to be intimidated by mere machinery."
			)
			(11 ; Taste/Smell
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Print 250 5) ; "You gently kiss your machine to bring good luck."
			)
			(4 ; Inventory
				(switch invItem
					(11 ; pocketKnife
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 6) ; "You carefully slip the pocketknife into the hole in the back of the machine, twist the odds screw, and hope no one saw you."
					)
					(14 ; hammer
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 7) ; "Good idea! You smash the video blackjack machine with your hammer, causing hundreds of dollars to spill out, which you gladly catch and put in your pockets."
						(Print 250 8) ; "Bad idea! The security guard handles you indelicately as he escorts you to the local jail!"
						(Death 103 0 1)
						(Format @gYourPart 250 9) ; "...maybe with good behavior?"
						(GameOver 250 10)
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)

	(method (doit)
		(if (GameIsRestarting)
			(localproc_11 0)
			(localproc_12 0)
		)
		(cond
			(script)
			((and (>= machineDollars 10000) (== handOver 1))
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Print 250 11) ; "Congratulations, Larry! You've broken the house limit."
				(localproc_0)
			)
			((gEgo mover:)
				(localproc_0)
			)
		)
		(super doit:)
	)
)

(instance card of View
	(properties
		view 251
		loop 4
		cel 4
		priority 14
		signal 16
	)
)

(instance deck of List
	(properties)
)

(instance theDeal of View
	(properties
		x 29
		y 184
		description {the Deal button}
		lookStr {Click the Hand here to begin a new hand of blackjack.}
		view 250
		loop 6
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: dealEm)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dealEm of Script
	(properties)

	(method (changeState newState &tmp i)
		(switch (= state newState)
			(0
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(cond
					((== handOver 0)
						(Print 250 12) ; "Please wait until this hand is over."
						(self dispose:)
					)
					((== bet 0)
						(Print 250 13) ; "You bet zero dollars, receive zero cards, and win zero dollars and zero cents."
						(Print 250 14) ; "You can play all night like this!"
						(self dispose:)
					)
					((> bet machineDollars)
						(Print 250 15) ; "You can't bet more than you have."
						(self dispose:)
					)
					(else
						(localproc_8 theDeal)
						(self cue:)
					)
				)
			)
			(1
				(HandsOff)
				(deck release:)
				(for ((= i 0)) (< i 52) ((++ i))
					(deck addToEnd: i)
				)
				(for ((= i 0)) (< i 6) ((++ i))
					(if (IsObject [dealerCards i])
						([dealerCards i] dispose:)
					)
					(if (IsObject [egoCards i])
						([egoCards i] dispose:)
						(= [egoCards i] 0)
					)
					(if (IsObject [splitCards i])
						([splitCards i] dispose:)
					)
				)
				(= egoTotal 0)
				(= egosAces 0)
				(= egoBusted 0)
				(= splitTotal 0)
				(= splitsAces 0)
				(= splitBusted 0)
				(= dealerTotal 0)
				(= dealersAces 0)
				(= egoCardInc 0)
				(= splitCardInc 1)
				(= dealerCardInc 0)
				(= dealersCard 0)
				(= egoDoublingDown 1)
				(= splitDoublingDown 1)
				(= handOver 0)
				(= egoHandDone 0)
				(= splitting 0)
				(= egosFirstCard (mod (= cardNum (localproc_1)) 13))
				(+= egoTotal (localproc_3 1))
				(localproc_4 1 egoCardInc)
				(= cycles 10)
			)
			(2
				(= dealersFirstCard (= cardNum (localproc_1)))
				(+= dealerTotal (localproc_3 0))
				((= [dealerCards dealersCard] (Clone card)) view: 251 x: 61 y: 25 init:)
				(gTheMusic3 number: 250 play:)
				(= cycles 10)
			)
			(3
				(++ egoCardInc)
				(= egosSecondCard (mod (= cardNum (localproc_1)) 13))
				(+= egoTotal (localproc_3 1))
				(localproc_4 1 egoCardInc)
				(= cycles 10)
			)
			(4
				(++ dealerCardInc)
				(++ dealersCard)
				(= dealerShowCard (= cardNum (localproc_1)))
				(+= dealerTotal (localproc_3 0))
				(localproc_4 0 dealersCard)
				(= cycles 1)
			)
			(5
				(if (== egoTotal 21)
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(Print 250 16) ; "You have Blackjack!"
					(localproc_2)
					(if (== dealerTotal 21)
						(Print 250 17) ; "Unfortunately, so does the dealer, so this hand is a push."
						(localproc_10)
						(self dispose:)
					else
						(+= machineDollars (/ bet 2))
						(localproc_10)
						(gCurRoom setScript: egoWins)
					)
				else
					(self cue:)
				)
			)
			(6
				(if (== (mod dealerShowCard 13) 0)
					(cond
						((localproc_6)
							(if (== dealerTotal 21)
								(localproc_2)
								(localproc_7 0)
								(if gModelessDialog
									(gModelessDialog dispose:)
								)
								(Print 250 18) ; "The dealer has Blackjack!"
								(localproc_10)
								(self dispose:)
							else
								(localproc_7 (- (/ bet 2)))
								(self cue:)
							)
						)
						((== dealerTotal 21)
							(localproc_2)
							(if gModelessDialog
								(gModelessDialog dispose:)
							)
							(Print 250 18) ; "The dealer has Blackjack!"
							(localproc_7 (- bet))
							(localproc_10)
							(self dispose:)
						)
						(else
							(self cue:)
						)
					)
				else
					(self cue:)
				)
			)
			(7
				(self start: 0)
				(if (== egosSecondCard egosFirstCard)
					(not splitting)
					(HandsOn)
					(self dispose:)
					(if (== splitting 1)
						(if (== egosFirstCard 0)
							(= egosAces 1)
							(= splitsAces 1)
							(= egoTotal 11)
							(= splitTotal 11)
						else
							(= splitTotal (/= egoTotal 2))
						)
						(= [splitCards 0] (Clone [egoCards 1]))
						([egoCards 1] dispose:)
						([splitCards 0] x: 61 y: 66 init:)
						(= egosSecondCard (mod (= cardNum (localproc_1)) 13))
						(+= egoTotal (localproc_3 1))
						(localproc_4 1 egoCardInc)
						(self cue:)
					else
						(self cue:)
					)
				else
					(self cue:)
				)
			)
			(8
				(if (== egoTotal 21)
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(Print 250 19) ; "Your first hand has Blackjack!"
					(= cardNum (localproc_1))
					(+= splitTotal (localproc_3 2))
					(localproc_4 2 splitCardInc)
					(Animate (gCast elements:) 0)
					(if (== splitTotal 21)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 20) ; "Your split hand has Blackjack!"
						(gCurRoom setScript: splitStands)
						(self dispose:)
					else
						(HandsOn)
						(= egoHandDone 1)
						(self dispose:)
					)
				else
					(self cue:)
				)
			)
			(9
				(if (== egoTotal 22)
					(= egoTotal 12)
					(-- egosAces)
				)
				(if (== splitTotal 21)
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(Print 250 20) ; "Your split hand has Blackjack!"
					(gCurRoom setScript: splitStands)
					(self dispose:)
				else
					(HandsOn)
					(self dispose:)
				)
			)
		)
	)
)

(instance hitMe of View
	(properties
		x 100
		y 186
		description {the Hit button}
		lookStr {Click the Hand here to get another card.}
		view 250
		loop 7
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if (and splitting egoHandDone)
					(gCurRoom setScript: splitGetsHit)
				else
					(gCurRoom setScript: egoGetsHit)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance egoGetsHit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(++ egoCardInc)
				(cond
					((== handOver 1)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 21) ; "First, click on Deal to start a new hand."
						(HandsOn)
						(self dispose:)
					)
					((and (not splitting) (== egoBusted 1))
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 22) ; "You busted."
						(HandsOn)
						(self dispose:)
					)
					(else
						(localproc_8 hitMe)
						(= cardNum (localproc_1))
						(+= egoTotal (localproc_3 1))
						(localproc_4 1 egoCardInc)
						(= cycles 1)
					)
				)
			)
			(1
				(if (> egoTotal 21)
					(cond
						(egosAces
							(-- egosAces)
							(-= egoTotal 10)
						)
						((not splitting)
							(if gModelessDialog
								(gModelessDialog dispose:)
							)
							(Print 250 23) ; "You busted!"
							(localproc_2)
							(HandsOff)
							(self setScript: dealerWins)
							(self dispose:)
						)
						(else
							(= egoHandDone 1)
							(if gModelessDialog
								(gModelessDialog dispose:)
							)
							(Print 250 24) ; "Your first hand busted."
							(= egoBusted 1)
							(= cardNum (localproc_1))
							(+= splitTotal (localproc_3 2))
							(localproc_4 2 splitCardInc)
							(Animate (gCast elements:) 0)
							(= egoHandDone 1)
							(HandsOn)
							(self dispose:)
						)
					)
				)
				(self cue:)
			)
			(2
				(if (and (== egoBusted 0) (== egoCardInc 5))
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(Print 250 25) ; "You have six cards whose total is not over 21!"
					(if (not splitting)
						(localproc_2)
						(gCurRoom setScript: egoWins)
						(self dispose:)
					else
						(= egoHandDone 1)
						(= cardNum (localproc_1))
						(+= splitTotal (localproc_3 2))
						(localproc_4 2 splitCardInc)
						(HandsOn)
						(self dispose:)
					)
				else
					(HandsOn)
					(self dispose:)
				)
			)
		)
	)
)

(instance splitGetsHit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(++ splitCardInc)
				(cond
					((== handOver 1)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 21) ; "First, click on Deal to start a new hand."
						(HandsOn)
						(self dispose:)
					)
					((== splitBusted 1)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 22) ; "You busted."
						(HandsOn)
						(self dispose:)
					)
					(else
						(localproc_8 hitMe)
						(= cardNum (localproc_1))
						(+= splitTotal (localproc_3 2))
						(localproc_4 2 splitCardInc)
						(= cycles 1)
					)
				)
			)
			(1
				(if (> splitTotal 21)
					(if splitsAces
						(-- splitsAces)
						(-= splitTotal 10)
					else
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 26) ; "Your split hand busted!"
						(= splitBusted 1)
						(localproc_2)
						(gCurRoom setScript: splitStands)
						(self dispose:)
					)
				)
				(self cue:)
			)
			(2
				(if (and (== splitBusted 0) (== splitCardInc 5))
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(Print 250 27) ; "Your split hand has six cards!"
					(localproc_2)
					(gCurRoom setScript: splitStands)
					(self dispose:)
				else
					(HandsOn)
					(self dispose:)
				)
			)
		)
	)
)

(instance stand of View
	(properties
		x 219
		y 184
		description {the Stand button}
		lookStr {Click the Hand here when you want no more cards.}
		view 250
		loop 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if splitting
					(if (not egoHandDone)
						(localproc_8 stand)
						(= dontBlink 1)
						(= egoHandDone 1)
						(= cardNum (localproc_1))
						(+= splitTotal (localproc_3 2))
						(localproc_4 2 splitCardInc)
						(Animate (gCast elements:) 0)
						(if (and (== splitTotal 21) (== splitCardInc 1))
							(if gModelessDialog
								(gModelessDialog dispose:)
							)
							(Print 250 20) ; "Your split hand has Blackjack!"
							(localproc_2)
							(gCurRoom setScript: splitStands)
						)
					else
						(gCurRoom setScript: splitStands)
					)
				else
					(gCurRoom setScript: egoStands)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance egoStands of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== handOver 1)
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(Print 250 21) ; "First, click on Deal to start a new hand."
					(HandsOn)
					(self dispose:)
				else
					(if (not egoDoublingDown)
						(localproc_8 stand)
					)
					(localproc_2)
					(if (and (> egoTotal 21) egosAces)
						(-- egosAces)
						(-= egoTotal 10)
					)
				)
				(self cue:)
			)
			(1
				(++ dealerCardInc)
				(++ dealersCard)
				(if (or (< dealerTotal 17) (and dealersAces (== dealerTotal 17)))
					(= cardNum (localproc_1))
					(+= dealerTotal (localproc_3 0))
					(localproc_4 0 dealerCardInc)
					(self changeState: 1)
				else
					(= cycles 1)
				)
			)
			(2
				(if (> dealerTotal 21)
					(if dealersAces
						(-- dealersAces)
						(-= dealerTotal 10)
						(-- dealerCardInc)
						(self changeState: 1)
					else
						(= cycles 1)
					)
				)
				(= cycles 1)
			)
			(3
				(cond
					((> egoTotal 21)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(HandsOff)
						(Print 250 22) ; "You busted."
						(gCurRoom setScript: dealerWins)
					)
					((> dealerTotal 21)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 28) ; "The dealer busted!"
						(self setScript: egoWins)
						(self dispose:)
					)
					((== dealerTotal egoTotal)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 29) ; "It's a push."
					)
					((> dealerTotal egoTotal)
						(HandsOff)
						(self setScript: dealerWins)
						(self dispose:)
					)
					(else
						(self setScript: egoWins)
						(self dispose:)
					)
				)
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance splitStands of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== handOver 1)
					(= dontBlink 0)
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(Print 250 21) ; "First, click on Deal to start a new hand."
					(HandsOn)
					(self dispose:)
				else
					(if (not dontBlink)
						(localproc_8 stand)
						(= dontBlink 0)
					)
					(localproc_2)
					(self cue:)
				)
			)
			(1
				(if (and (> egoTotal 21) (> splitTotal 21))
					(self changeState: 3)
				else
					(++ dealerCardInc)
					(++ dealersCard)
					(if (or (< dealerTotal 17) (and dealersAces (== dealerTotal 17)))
						(= cardNum (localproc_1))
						(+= dealerTotal (localproc_3 0))
						(localproc_4 0 dealerCardInc)
						(self changeState: 1)
					else
						(= cycles 1)
					)
				)
			)
			(2
				(if (> dealerTotal 21)
					(if dealersAces
						(-- dealersAces)
						(-= dealerTotal 10)
						(-- dealerCardInc)
						(self changeState: 1)
					else
						(self cue:)
					)
				)
				(self cue:)
			)
			(3
				(cond
					((> dealerTotal 21)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 28) ; "The dealer busted!"
						(if (not egoBusted)
							(if gModelessDialog
								(gModelessDialog dispose:)
							)
							(Print 250 30) ; "Your first hand wins!"
							(localproc_7 (* bet egoDoublingDown))
						)
						(if (not splitBusted)
							(if gModelessDialog
								(gModelessDialog dispose:)
							)
							(Print 250 31) ; "Your split hand wins!"
							(localproc_7 (* bet splitDoublingDown))
						)
						(localproc_10)
						(self dispose:)
					)
					((and (== egoCardInc 5) (not egoBusted))
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 30) ; "Your first hand wins!"
						(localproc_7 (* bet egoDoublingDown))
					)
					((== dealerTotal egoTotal)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 32) ; "Your first hand is a push."
					)
					((> dealerTotal egoTotal)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 33) ; "The dealer's hand beats your first hand."
						(localproc_7 (- (* bet egoDoublingDown)))
					)
					((and (== egoTotal 21) (== egoCardInc 1))
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 30) ; "Your first hand wins!"
						(localproc_7 (+ bet (/ bet 2)))
					)
					((not egoBusted)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 30) ; "Your first hand wins!"
						(localproc_7 (* bet egoDoublingDown))
					)
					(else
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 34) ; "Your first hand loses."
						(localproc_7 (- (* bet egoDoublingDown)))
					)
				)
				(self cue:)
			)
			(4
				(cond
					((and (== splitCardInc 5) (not splitBusted))
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 31) ; "Your split hand wins!"
						(localproc_7 (+ bet (/ bet 2)))
					)
					((== dealerTotal splitTotal)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 35) ; "Your split hand is a push."
					)
					((> dealerTotal splitTotal)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 36) ; "The dealer beats your split hand."
						(localproc_7 (- (* bet splitDoublingDown)))
						(localproc_10)
						(self dispose:)
					)
					((and (== splitTotal 21) (== splitCardInc 1))
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 31) ; "Your split hand wins!"
						(localproc_7 (+ bet (/ bet 2)))
					)
					((not splitBusted)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 31) ; "Your split hand wins!"
						(localproc_7 (* bet splitDoublingDown))
					)
					(else
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 37) ; "Your split hand loses."
						(localproc_7 (- (* bet splitDoublingDown)))
					)
				)
				(self cue:)
			)
			(5
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance egoWins of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(if (== (gGame printLang:) 1)
					(Printf ; "You win $%d."
						250
						38
						(localproc_7 (* bet egoDoublingDown))
						25
						3
						105
					)
				else
					(Printf ; "Tu ganas $%d."
						250
						39
						(localproc_7 (* bet egoDoublingDown))
						25
						3
						105
					)
				)
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance dealerWins of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(localproc_7 (- (* bet egoDoublingDown)))
				(Print 250 40 #time 3 #dispose) ; "The dealer wins!"
				(localproc_10)
				(self dispose:)
			)
		)
	)
)

(instance increase of View
	(properties
		x 158
		y 161
		description {the Increase button}
		lookStr {Click the Hand here to increase your bet. This button repeats automatically if you hold it down.}
		view 250
		loop 8
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3)
		(if (self onMe: event)
			(cond
				(
					(or
						(< $0000 (event modifiers:) $0005) ; emCTRL | emRIGHT_SHIFT
						(!= ((gTheIconBar curIcon:) message:) 3)
					)
					(super handleEvent: event)
				)
				((== handOver 0)
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(Print 250 41) ; "You must wait until this hand is over."
					(event claimed: 1)
					(return)
				)
				(else
					(switch (event type:)
						(evMOUSEBUTTON
							(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
								(= temp1 (GetTime))
								(if temp2 ; UNINIT
									(while (< (GetTime) (+ 7 temp1))
									)
								)
								(= temp2 1)
								(temp0 localize:)
								(cond
									((== bet 10000)
										(if gModelessDialog
											(gModelessDialog dispose:)
										)
										(Print 250 42) ; "This machine has a $10,000.00 limit."
										(break)
									)
									((< machineDollars 10)
										(Print 250 43) ; "You don't have any more money!"
										(break)
									)
									((< machineDollars (+ (localproc_9) bet 1))
										(if (mod machineDollars 2)
											(= bet (- machineDollars 1))
										else
											(= bet machineDollars)
										)
										(localproc_11 1)
										(if gModelessDialog
											(gModelessDialog dispose:)
										)
										(Print 250 15) ; "You can't bet more than you have."
										(break)
									)
									((< bet 0)
										(if gModelessDialog
											(gModelessDialog dispose:)
										)
										(Print 250 44) ; "You must bet more than that!"
									)
									((mod bet 2)
										(if gModelessDialog
											(gModelessDialog dispose:)
										)
										(Print 250 45) ; "Please bet an even number of dollars (2, 4, 6, etc.). This machine doesn't pay half-dollars."
										(-- bet)
										(localproc_11 1)
									)
									(else
										(= temp3 (localproc_9))
										(+= bet temp3)
										(localproc_11 1)
									)
								)
								(temp0 dispose:)
							)
							(temp0 dispose:)
							(event claimed: 1)
							(return)
						)
						(evKEYBOARD
							(if (== (event message:) KEY_RETURN)
								(cond
									((== bet 10000)
										(if gModelessDialog
											(gModelessDialog dispose:)
										)
										(Print 250 42) ; "This machine has a $10,000.00 limit."
									)
									((< machineDollars (+ (localproc_9) bet 1))
										(if (mod machineDollars 2)
											(= bet (- machineDollars 1))
										else
											(= bet machineDollars)
										)
										(localproc_11 1)
										(if gModelessDialog
											(gModelessDialog dispose:)
										)
										(Print 250 15) ; "You can't bet more than you have."
									)
									((< bet 0)
										(if gModelessDialog
											(gModelessDialog dispose:)
										)
										(Print 250 44) ; "You must bet more than that!"
									)
									((mod bet 2)
										(if gModelessDialog
											(gModelessDialog dispose:)
										)
										(Print 250 45) ; "Please bet an even number of dollars (2, 4, 6, etc.). This machine doesn't pay half-dollars."
										(-- bet)
										(localproc_11 1)
									)
									(else
										(= temp3 (localproc_9))
										(+= bet temp3)
										(localproc_11 1)
									)
								)
								(event claimed: 1)
								(return)
							)
						)
					)
				)
			)
		)
	)
)

(instance decrease of View
	(properties
		x 157
		y 186
		description {the Decrease button}
		lookStr {Click the Hand here to decrease your bet. This button repeats automatically if you hold it down.}
		view 250
		loop 9
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(if (self onMe: event)
			(cond
				(
					(or
						(< $0000 (event modifiers:) emCTRL)
						(!= ((gTheIconBar curIcon:) message:) 3)
					)
					(super handleEvent: event)
				)
				((== handOver 0)
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(Print 250 46) ; "Wait until this hand is over."
					(event claimed: 1)
					(return)
				)
				(else
					(switch (event type:)
						(evMOUSEBUTTON
							(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
								(= temp1 (GetTime))
								(while (< (GetTime) (+ 7 temp1))
								)
								(temp0 localize:)
								(if (> bet 11)
									(= temp2 (localproc_9))
									(-= bet temp2)
									(localproc_11 1)
								else
									(if gModelessDialog
										(gModelessDialog dispose:)
									)
									(Printf 250 47 10 10) ; "The minimum bet in this machine is $%d.00."
									(break)
								)
								(temp0 dispose:)
							)
							(temp0 dispose:)
							(event claimed: 1)
							(return)
						)
						(evKEYBOARD
							(if (== (event message:) KEY_RETURN)
								(if (> bet 11)
									(= temp2 (localproc_9))
									(-= bet temp2)
									(localproc_11 1)
								else
									(if gModelessDialog
										(gModelessDialog dispose:)
									)
									(Printf 250 47 10 10) ; "The minimum bet in this machine is $%d.00."
								)
								(event claimed: 1)
								(return)
							)
						)
					)
				)
			)
		)
	)
)

(instance changeBet of View
	(properties
		x 157
		y 174
		description {the Change Bet button}
		lookStr {Click the two arrows to increase or decrease your bet.}
		view 250
		loop 10
	)
)

(instance surrender of View
	(properties
		x 27
		y 76
		description {the Surrender button}
		lookStr {Click the Hand here to surrender your cards and have half your bet refunded.}
		view 250
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: surrenderScript)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theDouble of View
	(properties
		x 291
		y 72
		description {the Double Down button}
		lookStr {Click the Hand only here when you have two cards totaling 10 or 11. You will automatically receive only one more card and double your bet.}
		view 250
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(cond
					(
						(>
							(+ (localproc_5) bet)
							(if (== (mod machineDollars 2) 0)
								machineDollars
							else
								(- machineDollars 1)
							)
						)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 48) ; "You're a little short of funds at the moment, Larry."
					)
					((== handOver 1)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 21) ; "First, click on Deal to start a new hand."
					)
					(splitting
						(Print 250 49) ; "You can't double down when splitting!"
					)
					(
						(and
							(< 9 (- egoTotal (* egosAces 10)) 12)
							(!= egoHandDone 1)
							(== [egoCards 3] 0)
						)
						(localproc_8 self)
						(= egoDoublingDown 2)
						(++ egoCardInc)
						(= cardNum (localproc_1))
						(+= egoTotal (localproc_3 1))
						(localproc_4 1 egoCardInc)
						(gCurRoom setScript: egoStands)
					)
					(else
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 50) ; "You may only double when your hand contains two cards totaling 10 or 11."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theSplit of View
	(properties
		x 292
		y 104
		description {the Split button}
		lookStr {Click the Hand here when you have only two matching cards and you want to split them into two hands, doubling your bet.}
		view 250
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if
					(and
						(== egosSecondCard egosFirstCard)
						(<= (* 2 bet) machineDollars)
						(not handOver)
						(not splitting)
					)
					(localproc_8 theSplit)
					(HandsOff)
					(= splitting 1)
					(dealEm start: 7)
					(gCurRoom setScript: dealEm)
				else
					(self doVerb: 2)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance surrenderScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((== handOver 1)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 21) ; "First, click on Deal to start a new hand."
					)
					((and (== egoCardInc 1) (not splitting))
						(localproc_8 surrender)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 51) ; "You surrender your cards and are refunded half of your bet."
						(localproc_7 (- (/ bet 2)))
						(localproc_10)
					)
					(else
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 52) ; "It's too late now!"
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance odds of View
	(properties
		x 26
		y 106
		description {the Odds button}
		lookStr {Click the Hand here to learn this machine's current odds.}
		view 250
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(localproc_8 odds)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Print ; "This machine has a $10.00 minimum bet and a $10,000.00 limit. Bets must be a multiple of $2.00. Dealer must hit 16, and must stand on 17, unless he has an ace. Blackjack pays 3 to 2 odds. Any six cards under 22 wins."
					250
					53
					#at
					15
					-1
					#width
					280
					#title
					{HOUSE RULES}
				)
				(Print ; "Insurance bets are offered whenever the dealer shows an ace. They are half your bet, and pay 2 to 1 odds. You may split a pair or surrender whenever you have only two cards. You may double down if your cards total 10 or 11 points."
					250
					54
					#at
					15
					-1
					#width
					280
					#title
					{HOUSE RULES}
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cashout of View
	(properties
		x 284
		y 185
		description {the Cash Out button}
		lookStr {Click the Hand here to stop playing this machine. Your winnings will be given to you automatically.}
		view 250
		loop 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if (== handOver 0)
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(Print 250 46) ; "Wait until this hand is over."
				else
					(localproc_8 cashout)
					(localproc_0)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance soundFX of Sound
	(properties
		flags 1
	)
)

