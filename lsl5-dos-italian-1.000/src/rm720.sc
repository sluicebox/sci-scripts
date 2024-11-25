;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 720)
(include sci.sh)
(use Main)
(use eRS)
(use Sound)
(use User)
(use Actor)
(use System)

(public
	rm720 0
)

(local
	oldSpeed
	handsPlayed
	[drop 5]
	[nTally 15]
	[sTally 4]
	[payoff 10] = [0 1 2 3 4 5 10 20 50 -1]
	theHand
	winnings
	theBet
	credits
	paid
	nextCard
	holdOK
	dealOK
	wUnders
	bUnders
	cUnders
)

(procedure (NewDeck &tmp i theVal theSuit [str 4])
	(for ((= i 0)) (< i 5) ((++ i))
		(= [drop i] 1)
	)
	(for ((= i 0)) (< i 15) ((++ i))
		(= [nTally i] (* i 10))
	)
	(for ((= i 0)) (< i 4) ((++ i))
		(= [sTally i] (* i 10))
	)
	(hand eachElementDo: #dispose eachElementDo: #perform clearCode)
	(deck eachElementDo: #perform clearCode)
	(= nextCard 0)
	(for ((= i 0)) (< i 10) ((++ i))
		(= theVal (= theSuit 0))
		(while (deck firstTrue: #perform uniqueCode theVal theSuit)
			(= theVal (Random 2 14))
			(= theSuit (Random 0 3))
		)
		((deck at: i) view: 722 loop: theSuit cel: theVal)
	)
)

(procedure (DealCard which &tmp oldCard newCard)
	(= oldCard (hand at: which))
	(= newCard (deck at: nextCard))
	(dealSound play:)
	(oldCard
		view: 722
		setLoop: (newCard loop:)
		setCel: (newCard cel:)
		x: (+ 55 (* which 44))
		y: 50
		init:
	)
	(++ nextCard)
)

(procedure (TallyHand &tmp i loCard hiCard xCard consecutive)
	(for ((= i 0)) (< i 5) ((++ i))
		(++ [nTally ((hand at: i) cel:)])
		(++ [sTally ((hand at: i) loop:)])
	)
	(SortTallies)
	(switch (mod [nTally 0] 10)
		(4
			(= theHand 7)
		)
		(3
			(if (== (mod [nTally 1] 10) 2)
				(= theHand 6)
			else
				(= theHand 3)
			)
		)
		(2
			(cond
				((== (mod [nTally 1] 10) 2)
					(= theHand 2)
				)
				((>= (/ [nTally 0] 10) 11)
					(= theHand 1)
				)
				(else
					(= theHand 0)
				)
			)
		)
		(else
			(Sort hand sortHand sortCode)
			(= loCard ((sortHand at: 0) cel:))
			(= hiCard ((sortHand at: 4) cel:))
			(= xCard ((sortHand at: 3) cel:))
			(sortHand release: dispose:)
			(if (and (== hiCard 14) (== loCard 2) (== xCard 5))
				(= consecutive 1)
			else
				(= consecutive (if (== (- hiCard loCard) 4) 1 else 0))
			)
			(cond
				((== (mod [sTally 0] 10) 5)
					(cond
						((not consecutive)
							(= theHand 5)
						)
						((== loCard 10)
							(= theHand 9)
						)
						(else
							(= theHand 8)
						)
					)
				)
				(consecutive
					(= theHand 4)
				)
				(else
					(= theHand 0)
				)
			)
		)
	)
)

(procedure (SortTallies &tmp i j foo [str 100])
	(for ((= i 0)) (< i 14) ((++ i))
		(for ((= j (+ i 1))) (< j 15) ((++ j))
			(if (> (mod [nTally j] 10) (mod [nTally i] 10))
				(= foo [nTally i])
				(= [nTally i] [nTally j])
				(= [nTally j] foo)
			)
		)
	)
	(for ((= i 0)) (< i 3) ((++ i))
		(for ((= j (+ i 1))) (< j 4) ((++ j))
			(if (> (mod [sTally j] 10) (mod [sTally i] 10))
				(= foo [sTally i])
				(= [sTally i] [sTally j])
				(= [sTally j] foo)
			)
		)
	)
)

(procedure (PayBet)
	(-= credits theBet)
	(= paid 1)
	(DisplayStats)
)

(procedure (DisplayStats &tmp [str 50])
	(Display 720 2 dsCOORD 60 25 dsFONT gSmallFont dsCOLOR gColWhite dsBACKGROUND gColBlack) ; "Win:$       Bet:$       Credits:$"
	(Display 720 3 dsRESTOREPIXELS wUnders)
	(Format @str 720 4 winnings) ; "%d"
	(= wUnders
		(Display
			@str
			dsCOORD
			(proc0_28 80 80 80 96 80)
			25
			dsFONT
			gSmallFont
			dsCOLOR
			gColWhite
			dsBACKGROUND
			gColBlack
		)
	)
	(Display 720 3 dsRESTOREPIXELS bUnders)
	(Format @str 720 5 theBet) ; "%d"
	(= bUnders
		(Display
			@str
			dsCOORD
			(proc0_28 153 153 153 171 153)
			25
			dsFONT
			gSmallFont
			dsCOLOR
			gColWhite
			dsBACKGROUND
			gColBlack
		)
	)
	(Display 720 3 dsRESTOREPIXELS cUnders)
	(Format @str 720 5 credits) ; "%d"
	(= cUnders
		(Display
			@str
			dsCOORD
			(proc0_28 242 242 242 247 242)
			25
			dsFONT
			gSmallFont
			dsCOLOR
			gColWhite
			dsBACKGROUND
			gColBlack
		)
	)
)

(procedure (CountScore whichSound)
	(whichSound setLoop: -1 play:)
	(User canInput: 0)
	(while winnings
		(DisplayStats)
		(if (> winnings 10)
			(-= winnings 10)
			(+= credits 10)
		else
			(-- winnings)
			(++ credits)
		)
		(Wait 0)
		(Wait 10)
	)
	(whichSound setLoop: 1)
	(User canInput: 1)
)

(instance rm720 of LLRoom
	(properties
		picture 720
	)

	(method (init)
		(SetupExit 1)
		(HandsOn)
		(gTheIconBar disable: 3 6 7 curIcon: (gTheIconBar at: 2))
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
		(super init:)
		(= oldSpeed gSpeed)
		(= gSpeed 6)
		(incBet init: stopUpd:)
		(decBet init: stopUpd:)
		(cashout init:)
		(hold1 init:)
		(hold2 init:)
		(hold3 init:)
		(hold4 init:)
		(hold5 init:)
		(deal init:)
		(deck
			add:
				cardD0
				cardD1
				cardD2
				cardD3
				cardD4
				cardD5
				cardD6
				cardD7
				cardD8
				cardD9
		)
		(hand add: cardH0 cardH1 cardH2 cardH3 cardH4)
		(= credits gSilvDollars)
		(= gSilvDollars 0)
		(if credits
			(= theBet 1)
		)
		(gEgo put: 17 0) ; Silver_Dollar
		(DisplayStats)
		(self setScript: sPlayPoker)
	)

	(method (doVerb theVerb &tmp [str 450])
		(switch theVerb
			(2 ; Look
				(Format @str 720 0 gPokerJackpot gPokerJackpot) ; "Video Poker Odds  Progressive Royal Flush  $%d  Straight Flush      50 to 1  4 of a Kind        20 to 1  Full House        10 to 1  Flush           5 to 1  Straight          4 to 1  3 of a Kind        3 to 1  2 Pair           2 to 1  Pair, Jacks or Better   1 to 1"
				(TPrint
					@str
					#title
					{Welcome to Tramp's Casino}
					#font
					gMonoFont
					#at
					-1
					15
					#width
					260
				)
			)
			(1 ; Walk
				(cashout doVerb: 3)
			)
			(else
				(TPrint 720 1) ; "Click on a button instead of where you just clicked."
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (GameIsRestarting)
			(DisplayStats)
		)
	)

	(method (dispose)
		(hand dispose:)
		(deck dispose:)
		(sortHand dispose:)
		(gTheIconBar enable: 0 3 6 7)
		(= gSpeed oldSpeed)
		(super dispose:)
	)
)

(instance deck of Set
	(properties)
)

(instance hand of Set
	(properties)
)

(instance sortHand of Set
	(properties)
)

(instance sortCode of Code
	(properties)

	(method (doit theObj &tmp theCel)
		(if (not (= theCel (theObj cel:)))
			(= theCel 13)
		)
		(return theCel)
	)
)

(instance clearCode of Code
	(properties)

	(method (doit theObj)
		(theObj view: 722 setLoop: 0 setCel: 0)
	)
)

(instance cardH0 of View
	(properties)
)

(instance cardH1 of View
	(properties)
)

(instance cardH2 of View
	(properties)
)

(instance cardH3 of View
	(properties)
)

(instance cardH4 of View
	(properties)
)

(instance cardD0 of View
	(properties)
)

(instance cardD1 of View
	(properties)
)

(instance cardD2 of View
	(properties)
)

(instance cardD3 of View
	(properties)
)

(instance cardD4 of View
	(properties)
)

(instance cardD5 of View
	(properties)
)

(instance cardD6 of View
	(properties)
)

(instance cardD7 of View
	(properties)
)

(instance cardD8 of View
	(properties)
)

(instance cardD9 of View
	(properties)
)

(instance uniqueCode of Code
	(properties)

	(method (doit theObj v s)
		(return (and (== (theObj loop:) s) (== (theObj cel:) v)))
	)
)

(instance incBet of Prop
	(properties
		x 132
		y 176
		description {the Increase button}
		lookStr {Click the Hand here to increase your bet.}
		view 720
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp evt ticks)
		(if (self onMe: event)
			(if
				(and
					(== (event type:) evMOUSEBUTTON)
					(not (event modifiers:))
					(== gTheCursor 2)
				)
				(while
					(and
						(!= ((= evt (Event new:)) type:) evMOUSERELEASE)
						(self onMe: evt)
					)
					(= ticks (GetTime))
					(while (< (GetTime) (+ 7 ticks))
					)
					(self doVerb: 3)
					(evt dispose:)
				)
				(evt dispose:)
				(event claimed: 1)
			else
				(super handleEvent: event)
			)
		else
			(super handleEvent: event)
		)
	)

	(method (doVerb theVerb invItem &tmp [str 10])
		(switch theVerb
			(3 ; Do
				(if dealOK
					(if (< theBet 100)
						(cond
							(paid
								(TPrint 720 6) ; "It's too late now to change your bet!"
							)
							((< theBet credits)
								(buttonSound play:)
								(++ theBet)
								(= winnings 0)
								(DisplayStats)
							)
							(else
								(TPrint 720 7) ; "You can't bet more than your credits."
							)
						)
					else
						(TPrint 720 8) ; "The Tramp Casino poker machines are limited to bets of $100."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance decBet of Prop
	(properties
		x 175
		y 172
		description {the Decrease button}
		lookStr {Click the Hand here to decrease your bet.}
		view 720
		loop 1
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp evt ticks)
		(if (self onMe: event)
			(if
				(and
					(== (event type:) evMOUSEBUTTON)
					(not (event modifiers:))
					(== gTheCursor 2)
				)
				(while
					(and
						(!= ((= evt (Event new:)) type:) evMOUSERELEASE)
						(self onMe: evt)
					)
					(= ticks (GetTime))
					(while (< (GetTime) (+ 7 ticks))
					)
					(self doVerb: 3)
					(evt dispose:)
				)
				(evt dispose:)
				(event claimed: 1)
			else
				(super handleEvent: event)
			)
		else
			(super handleEvent: event)
		)
	)

	(method (doVerb theVerb invItem &tmp [str 10])
		(switch theVerb
			(3 ; Do
				(if dealOK
					(cond
						(paid
							(TPrint 720 9) ; "It's too late now to change your bet!"
						)
						((> theBet 1)
							(buttonSound play:)
							(if (and (not (-- theBet)) gModelessDialog)
								(gModelessDialog dispose:)
							)
							(= winnings 0)
							(DisplayStats)
						)
						(else
							(TPrint 720 10) ; "You must bet something!"
						)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance cashout of View
	(properties
		x 287
		y 151
		description {the Cash Out button}
		lookStr {Click the Hand here to stop playing this machine. Your winnings will be given to you automatically.}
		view 720
		loop 2
	)

	(method (init)
		(= view (proc0_28 720 720 720 7201 720))
		(super init: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(buttonSound play:)
				(if (and dealOK (not (& ((gTheIconBar at: 8) signal:) $0004)))
					(self setCel: 1)
					(if credits
						(gTheMusic2 number: 723 loop: 1 flags: 1 play:)
						(TPrint 720 11) ; "You take your money from the tray."
						(= gSilvDollars credits)
						(gEgo get: 17) ; Silver_Dollar
					)
					(SetupExit 0)
					(gCurRoom newRoom: 710)
				else
					(TPrint 720 12) ; "First, finish this hand."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance deal of View
	(properties
		x 29
		y 151
		description {the Deal button}
		sightAngle 40
		lookStr {Click the Hand here to begin a new hand of poker.}
		view 720
		loop 3
	)

	(method (init)
		(= view (proc0_28 720 720 720 7201 720))
		(super init: &rest)
	)

	(method (doVerb theVerb invItem &tmp i)
		(switch theVerb
			(3 ; Do
				(if dealOK
					(buttonSound play:)
					(DisplayStats)
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(if theBet
						(if (not paid)
							(++ gPokerJackpot)
							(PayBet)
						)
						(self setCel: 1)
						(= dealOK 0)
						(= holdOK 0)
						(sPlayPoker cue:)
					else
						(TPrint 720 13) ; "You have no money and pretend to play the game, assuming that the other gamblers standing around you won't notice. You win zero dollars and have zero fun!"
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance hold1 of View
	(properties
		x 68
		y 151
		description {the Hold Card 1 button}
		sightAngle 40
		lookStr {Click the Hand here to hold card #1.}
		view 720
		loop 4
	)

	(method (init)
		(= view (proc0_28 720 720 720 7201 720))
		(super init: &rest)
	)

	(method (onMe &tmp theCard)
		(= theCard (hand at: 0))
		(return
			(or
				(super onMe: &rest)
				(and
					(IsObject theCard)
					(gCast contains: theCard)
					(theCard onMe: &rest)
				)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if holdOK
					(buttonSound play:)
					(if cel
						(= [drop 0] 1)
						(self setCel: 0)
					else
						(= [drop 0] 0)
						(self setCel: 1)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance hold2 of View
	(properties
		x 114
		y 151
		description {the Hold Card 2 button}
		sightAngle 40
		lookStr {Click the Hand here to hold card #2.}
		view 720
		loop 4
	)

	(method (init)
		(= view (proc0_28 720 720 720 7201 720))
		(super init: &rest)
	)

	(method (onMe &tmp theCard)
		(= theCard (hand at: 1))
		(return
			(or
				(super onMe: &rest)
				(and
					(IsObject theCard)
					(gCast contains: theCard)
					(theCard onMe: &rest)
				)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if holdOK
					(buttonSound play:)
					(if cel
						(= [drop 1] 1)
						(self setCel: 0)
					else
						(= [drop 1] 0)
						(self setCel: 1)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance hold3 of View
	(properties
		x 159
		y 151
		description {the Hold Card 3 button}
		sightAngle 40
		lookStr {Click the Hand here to hold card #3.}
		view 720
		loop 4
	)

	(method (init)
		(= view (proc0_28 720 720 720 7201 720))
		(super init: &rest)
	)

	(method (onMe &tmp theCard)
		(= theCard (hand at: 2))
		(return
			(or
				(super onMe: &rest)
				(and
					(IsObject theCard)
					(gCast contains: theCard)
					(theCard onMe: &rest)
				)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if holdOK
					(buttonSound play:)
					(if cel
						(= [drop 2] 1)
						(self setCel: 0)
					else
						(= [drop 2] 0)
						(self setCel: 1)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance hold4 of View
	(properties
		x 203
		y 151
		description {the Hold Card 4 button}
		sightAngle 40
		lookStr {Click the Hand here to hold card #4.}
		view 720
		loop 4
	)

	(method (onMe &tmp theCard)
		(= theCard (hand at: 3))
		(return
			(or
				(super onMe: &rest)
				(and
					(IsObject theCard)
					(gCast contains: theCard)
					(theCard onMe: &rest)
				)
			)
		)
	)

	(method (init)
		(= view (proc0_28 720 720 720 7201 720))
		(super init: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if holdOK
					(buttonSound play:)
					(if cel
						(= [drop 3] 1)
						(self setCel: 0)
					else
						(= [drop 3] 0)
						(self setCel: 1)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance hold5 of View
	(properties
		x 246
		y 151
		description {the Hold Card 5 button}
		sightAngle 40
		lookStr {Click the Hand here to hold card #5.}
		view 720
		loop 4
	)

	(method (init)
		(= view (proc0_28 720 720 720 7201 720))
		(super init: &rest)
	)

	(method (onMe &tmp theCard)
		(= theCard (hand at: 4))
		(return
			(or
				(super onMe: &rest)
				(and
					(IsObject theCard)
					(gCast contains: theCard)
					(theCard onMe: &rest)
				)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if holdOK
					(buttonSound play:)
					(if cel
						(= [drop 4] 1)
						(self setCel: 0)
					else
						(= [drop 4] 0)
						(self setCel: 1)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance dealSound of Sound
	(properties
		number 721
	)
)

(instance buttonSound of Sound
	(properties
		number 722
	)
)

(instance cashOutSound of Sound ; UNUSED
	(properties
		number 723
	)
)

(instance winSound of Sound
	(properties
		number 724
		loop -1
	)
)

(instance bigWinSound of Sound ; UNUSED
	(properties
		number 724
		loop -1
	)
)

(instance loseSound of Sound
	(properties
		flags 1
		number 726
	)
)

(instance sPlayPoker of Script
	(properties)

	(method (changeState newState &tmp i [str 50])
		(switch (= state newState)
			(0
				(= dealOK 1)
				(gTheIconBar enable: 8)
			)
			(1
				(NewDeck)
				(gTheIconBar disable: 8)
				(= cycles 2)
			)
			(2
				(DealCard register)
				(= cycles 4)
			)
			(3
				(if (< (++ register) 5)
					(-= state 2)
				)
				(= cycles 1)
			)
			(4
				(deal setCel: 0)
				(hold1 setCel: 0)
				(hold2 setCel: 0)
				(hold3 setCel: 0)
				(hold4 setCel: 0)
				(hold5 setCel: 0)
				(= dealOK 1)
				(= holdOK 1)
			)
			(5
				(for ((= i 0)) (< i 5) ((++ i))
					(if [drop i]
						((hand at: i) dispose:)
					)
				)
				(= register 0)
				(= cycles 2)
			)
			(6
				(if [drop register]
					(DealCard register)
					(= cycles 4)
				else
					(self cue:)
				)
			)
			(7
				(if (< (++ register) 5)
					(-= state 2)
				)
				(= cycles 1)
			)
			(8
				(deal setCel: 0)
				(hold1 setCel: 0)
				(hold2 setCel: 0)
				(hold3 setCel: 0)
				(hold4 setCel: 0)
				(hold5 setCel: 0)
				(++ handsPlayed)
				(TallyHand)
				(if (== theHand 9)
					(Format @str 720 14 gPokerJackpot gPokerJackpot) ; "P R O G R E S S I V E J A C K P O T  ! !  You win %d dollars!"
					(TPrint
						@str
						#width
						200
						#title
						{Another Lucky Winner}
						#font
						gBigFont
						#mode
						1
					)
					(= gSilvDollars gPokerJackpot)
					(= gPokerJackpot 1000)
					(gEgo get: 17) ; Silver_Dollar
					(SetupExit 0)
					(gCurRoom newRoom: 710)
				else
					(= winnings (* theBet [payoff theHand]))
					(DisplayStats)
					(= cycles 5)
				)
			)
			(9
				(if winnings
					(CountScore winSound)
				else
					(loseSound play:)
				)
				(= cycles 1)
			)
			(10
				(if (> theBet credits)
					(= theBet credits)
				)
				(DisplayStats)
				(if credits
					(= paid (= register 0))
					(self init:)
				else
					(TPrint 720 15) ; "You sadly walk away, your turned-out pockets telling everyone of your gambling "problem.""
					(gTheIconBar enable: 8)
					(SetupExit 0)
					(gCurRoom newRoom: 710)
				)
			)
		)
	)
)

