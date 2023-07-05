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
	local0
	local1
	local2
	local3
	[local4 6]
	[local10 7]
	[local17 6]
	local23
	local24
	local25
	local26
	local27
	local28
	local29
	local30
	local31
	local32
	local33
	local34
	[local35 80]
	[local115 80]
	local195
	local196
	local197
	local198
	local199
	local200
	local201
	local202
	local203
	local204
	local205
	local206
	local207
)

(procedure (localproc_0)
	(if local33
		(Display 250 8 dsRESTOREPIXELS local33)
	)
	(if local34
		(Display 250 8 dsRESTOREPIXELS local34)
	)
	(gLongSong2 number: 266 play:)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
	(if local206
		(Print 250 61) ; "This machine only contains $10,000.00; trust us, we'll mail you the rest."
	)
	(if (> local204 0)
		(Printf 250 62 local204) ; "You pocket your $%d.00 from the tray and wish you had won more."
	else
		(Print 250 7) ; "You sadly walk away, your turned-out pockets telling everyone of your gambling "problem.""
	)
	(gEgo z: 0 hide:)
	(deck dispose:)
	(= global158 local204)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
	(gCurRoom newRoom: 100)
)

(procedure (localproc_1 &tmp temp0)
	(if global159
		(return (= temp0 (GetNumber {card #})))
	else
		(= temp0 (Random 0 51))
		(if (== (deck at: temp0) -1)
			(= temp0 (localproc_1))
		else
			(deck delete: (deck at: temp0))
			(deck addAfter: (- temp0 1) -1)
			(return temp0)
		)
	)
)

(procedure (localproc_2)
	([local4 0] loop: (/ local195 13) cel: (mod local195 13))
	(Animate (gCast elements:) 0)
)

(procedure (localproc_3 param1)
	(return
		(cond
			((== (mod local3 13) 0)
				(switch param1
					(0
						(++ local23)
					)
					(1
						(++ local24)
					)
					(2
						(++ local25)
					)
				)
				11
			)
			((< (mod local3 13) 9)
				(+ (mod local3 13) 1)
			)
			(else 10)
		)
	)
)

(procedure (localproc_4 param1 param2)
	(gLongSong3 number: 250 play:)
	(switch param1
		(0
			((= [local4 local31] (Clone card))
				loop: (/ local3 13)
				cel: (mod local3 13)
				x: (+ 61 (* param2 33))
				y: 25
				init:
			)
		)
		(1
			((= [local10 local27] (Clone card))
				loop: (/ local3 13)
				cel: (mod local3 13)
				x: (+ 61 (* param2 33))
				y: 105
				init:
			)
		)
		(2
			((= [local17 local28] (Clone card))
				loop: (/ local3 13)
				cel: (mod local3 13)
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
			(* local32 local197)
			(if local201
				(* local32 local198)
			else
				0
			)
		)
	)
)

(procedure (localproc_6)
	(proc0_3)
	(if
		(>=
			(- (+ (localproc_5) (/ local32 2)) 1)
			(if (== (mod local204 2) 0)
				local204
			else
				(- local204 1)
			)
		)
		(return 0)
	else
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(gGame setCursor: 999 1)
		(Animate (gCast elements:) 0)
		(return (Print 250 63 #button {Yes} 1 #button {No} 0)) ; "Do you want insurance?"
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
	)
	(return (proc0_2))
)

(procedure (localproc_7 param1)
	(if (> param1 0)
		(if
			(or
				(and (== local1 21) (== local27 1))
				(and (== local2 21) (== local28 1))
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
		(if (< (+ local204 param1) 0)
			(= local204 10000)
			(= local206 1)
		else
			(+= local204 param1)
		)
	else
		(+= local204 param1)
	)
	(if (< local204 0)
		(= local204 0)
	)
	(if (> local204 10000)
		(= local204 10000)
		(= local206 1)
	)
	(localproc_11 2)
	(if (and (== local1 21) (== local27 1))
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
	(if (mod (= temp0 (/ (+ local32 100) 50)) 2)
		(return (- temp0 1))
	else
		(return temp0)
	)
)

(procedure (localproc_10)
	(= local29 1)
	(proc0_3)
	(if (>= local32 local204)
		(if (mod local32 2)
			(= local32 (- local204 1))
		else
			(= local32 local204)
		)
		(if (< local32 10)
			(= local32 10)
		)
		(localproc_11 1)
	)
)

(procedure (localproc_11 param1)
	(if (OneOf param1 0 1)
		(if local33
			(Display 250 8 dsRESTOREPIXELS local33)
		)
		(= local33
			(Display
				(Format @local35 250 64 local32) ; "$%d"
				dsCOORD
				120
				11
				dsCOLOR
				global123
				dsSAVEPIXELS
			)
		)
	)
	(if (OneOf param1 0 2)
		(if local34
			(Display 250 8 dsRESTOREPIXELS local34)
		)
		(= local34
			(Display
				(Format @local115 250 65 local204) ; "$%d"
				dsCOORD
				165
				11
				dsCOLOR
				global123
				dsSAVEPIXELS
			)
		)
	)
)

(instance rm250 of LLRoom
	(properties
		picture 250
		style 10
	)

	(method (init)
		(LoadMany rsVIEW 250 251)
		(LoadMany rsSOUND 250 251 252 266 260)
		(gLongSong3 loop: 1 vol: 127 flags: 1)
		(gLongSong2 loop: 1 vol: 127 flags: 1)
		(gEgo init: z: 1000 hide:)
		(super init:)
		(gTheIconBar disable: 3 6 7 4 0 5 curIcon: (gTheIconBar at: 2))
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
		(= local32 10)
		(= local204 global158)
		(self setScript: startScript)
		(proc0_31)
	)

	(method (newRoom)
		(super newRoom: &rest)
		(proc0_32 gWaitCursor)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Print 250 0) ; "The numbers at the top of the video blackjack machine indicate the size of your current bet and the total amount of credit you have in the machine."
				(Print 250 1) ; "For help, just look at the various buttons."
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Print 250 2) ; "Come on, pay off!"
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Print 250 3) ; "Click on a button instead of where you just clicked."
			)
			(6
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Print 250 4) ; "You gently kiss your machine to bring good luck."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)

	(method (doit)
		(if (GameIsRestarting)
			(localproc_11 0)
		)
		(cond
			(script 0)
			((and (>= local204 10000) (== local29 1))
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Print 250 5) ; "Congratulations, you've broken the house limit."
				(localproc_0)
			)
			((gEgo mover:)
				(localproc_0)
			)
			((mod local32 2)
				(if (> local32 9)
					(-- local32)
				)
				(localproc_11 1)
			)
			((and (< local204 10) (not (gCurRoom script:)) (not (proc0_6 104)))
				(proc0_7 104)
				(if (== local204 1)
					(= local207 {dollar})
				else
					(= local207 {dollars})
				)
				(if (> local204 0)
					(Printf 250 6 local204 local207) ; "You have only $%d %s left. You need a minimum of $10 dollars to play this machine. Sounds like it's time for a loan."
				else
					(Print 250 7) ; "You sadly walk away, your turned-out pockets telling everyone of your gambling "problem.""
				)
				(if local33
					(Display 250 8 dsRESTOREPIXELS local33)
				)
				(if local34
					(Display 250 8 dsRESTOREPIXELS local34)
				)
				(= global158 local204)
				(gCurRoom newRoom: 100)
				(proc0_8 104)
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
		view 250
		loop 6
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom setScript: dealEm)
			)
			(1
				(Print 250 9) ; "Click the Hand here to begin a new hand of blackjack."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance startScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 4)
			)
			(1
				(localproc_11 0)
				(= local29 1)
				(= cycles 1)
			)
			(2
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance dealEm of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(cond
					((== local29 0)
						(Print 250 10) ; "Please wait until this hand is over."
						(self dispose:)
					)
					((== local32 0)
						(Print 250 11) ; "You bet zero dollars, receive zero cards, and win zero dollars and zero cents."
						(Print 250 12) ; "You can play all night like this!"
						(self dispose:)
					)
					((> local32 local204)
						(Print 250 13) ; "You can't bet more than you have."
						(self dispose:)
					)
					(else
						(localproc_8 theDeal)
						(self cue:)
					)
				)
			)
			(1
				(proc0_2)
				(deck release:)
				(for ((= temp0 0)) (< temp0 52) ((++ temp0))
					(deck addToEnd: temp0)
				)
				(for ((= temp0 0)) (< temp0 6) ((++ temp0))
					(if (IsObject [local4 temp0])
						([local4 temp0] dispose:)
					)
					(if (IsObject [local10 temp0])
						([local10 temp0] dispose:)
					)
					(if (IsObject [local17 temp0])
						([local17 temp0] dispose:)
					)
				)
				(= local1 0)
				(= local24 0)
				(= local26 0)
				(= local2 0)
				(= local25 0)
				(= local203 0)
				(= local0 0)
				(= local23 0)
				(= local27 0)
				(= local28 1)
				(= local30 0)
				(= local31 0)
				(= local197 1)
				(= local198 1)
				(= local29 0)
				(= local202 0)
				(= local201 0)
				(= local199 (mod (= local3 (localproc_1)) 13))
				(+= local1 (localproc_3 1))
				(localproc_4 1 local27)
				(= cycles 10)
			)
			(2
				(= local195 (= local3 (localproc_1)))
				(+= local0 (localproc_3 0))
				((= [local4 local31] (Clone card)) view: 251 x: 61 y: 25 init:)
				(gLongSong3 number: 250 play:)
				(= cycles 10)
			)
			(3
				(++ local27)
				(= local200 (mod (= local3 (localproc_1)) 13))
				(+= local1 (localproc_3 1))
				(localproc_4 1 local27)
				(= cycles 10)
			)
			(4
				(++ local30)
				(++ local31)
				(= local196 (= local3 (localproc_1)))
				(+= local0 (localproc_3 0))
				(localproc_4 0 local31)
				(= cycles 1)
			)
			(5
				(if (== local1 21)
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(localproc_2)
					(Print 250 14) ; "You have Blackjack!"
					(if (== local0 21)
						(Print 250 15) ; "Unfortunately, so does the dealer, so this hand is a push."
						(localproc_10)
						(self dispose:)
					else
						(+= local204 (/ local32 2))
						(localproc_10)
						(gCurRoom setScript: egoWins)
					)
				else
					(self cue:)
				)
			)
			(6
				(if (== (mod local196 13) 0)
					(cond
						((localproc_6)
							(if (== local0 21)
								(localproc_2)
								(localproc_7 0)
								(if gModelessDialog
									(gModelessDialog dispose:)
								)
								(Print 250 16) ; "The dealer has Blackjack!"
								(localproc_10)
								(self dispose:)
							else
								(localproc_7 (- (/ local32 2)))
								(self cue:)
							)
						)
						((== local0 21)
							(localproc_2)
							(if gModelessDialog
								(gModelessDialog dispose:)
							)
							(Print 250 16) ; "The dealer has Blackjack!"
							(localproc_7 (- local32))
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
				(if (== local200 local199)
					(if (and (<= (* 2 local32) local204) (not local201))
						(proc0_3)
						(self dispose:)
					)
					(if (== local201 1)
						(if (== local199 0)
							(= local24 1)
							(= local25 1)
							(= local1 11)
							(= local2 11)
						else
							(= local2 (/= local1 2))
						)
						(= [local17 0] (Clone [local10 1]))
						([local10 1] dispose:)
						([local17 0] x: 61 y: 66 init:)
						(= local200 (mod (= local3 (localproc_1)) 13))
						(+= local1 (localproc_3 1))
						(localproc_4 1 local27)
						(self cue:)
					else
						(self cue:)
					)
				else
					(self cue:)
				)
			)
			(8
				(if (== local1 21)
					(= local3 (localproc_1))
					(+= local2 (localproc_3 2))
					(localproc_4 2 local28)
					(Animate (gCast elements:) 0)
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(Print 250 17) ; "Your first hand has Blackjack!"
					(Animate (gCast elements:) 0)
					(if (== local2 21)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 18) ; "Your split hand has Blackjack!"
						(gCurRoom setScript: splitStands)
						(self dispose:)
					else
						(proc0_3)
						(= local202 1)
						(self dispose:)
					)
				else
					(self cue:)
				)
			)
			(9
				(if (== local1 22)
					(= local1 12)
					(-- local24)
				)
				(if (== local2 21)
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(Print 250 18) ; "Your split hand has Blackjack!"
					(gCurRoom setScript: splitStands)
					(self dispose:)
				else
					(proc0_3)
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
		view 250
		loop 7
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (and local201 local202)
					(gCurRoom setScript: splitGetsHit)
				else
					(gCurRoom setScript: egoGetsHit)
				)
			)
			(1
				(Print 250 19) ; "Click the Hand here to get another card."
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
				(proc0_2)
				(++ local27)
				(cond
					((== local29 1)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 20) ; "First, click on Deal to start a new hand."
						(proc0_3)
						(self dispose:)
					)
					((and (not local201) (== local26 1))
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 21) ; "You busted."
						(proc0_3)
						(self dispose:)
					)
					(else
						(localproc_8 hitMe)
						(= local3 (localproc_1))
						(+= local1 (localproc_3 1))
						(localproc_4 1 local27)
						(= cycles 1)
					)
				)
			)
			(1
				(if (> local1 21)
					(cond
						(local24
							(-- local24)
							(-= local1 10)
						)
						((not local201)
							(if gModelessDialog
								(gModelessDialog dispose:)
							)
							(localproc_2)
							(Print 250 22) ; "You busted!"
							(proc0_2)
							(self setScript: dealerWins)
							(self dispose:)
						)
						(else
							(= local202 1)
							(if gModelessDialog
								(gModelessDialog dispose:)
							)
							(= local26 1)
							(= local3 (localproc_1))
							(+= local2 (localproc_3 2))
							(localproc_4 2 local28)
							(Animate (gCast elements:) 0)
							(if gModelessDialog
								(gModelessDialog dispose:)
							)
							(Print 250 23) ; "Your first hand busted."
							(= local202 1)
							(proc0_3)
							(self dispose:)
						)
					)
				)
				(self cue:)
			)
			(2
				(if (and (== local26 0) (== local27 5))
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(Print 250 24) ; "You have six cards whose total is not over 21!"
					(if (not local201)
						(localproc_2)
						(gCurRoom setScript: egoWins)
						(self dispose:)
					else
						(= local202 1)
						(= local3 (localproc_1))
						(+= local2 (localproc_3 2))
						(localproc_4 2 local28)
						(proc0_3)
						(self dispose:)
					)
				else
					(proc0_3)
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
				(proc0_2)
				(++ local28)
				(cond
					((== local29 1)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 20) ; "First, click on Deal to start a new hand."
						(proc0_3)
						(self dispose:)
					)
					((== local203 1)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 21) ; "You busted."
						(proc0_3)
						(self dispose:)
					)
					(else
						(localproc_8 hitMe)
						(= local3 (localproc_1))
						(+= local2 (localproc_3 2))
						(localproc_4 2 local28)
						(= cycles 1)
					)
				)
			)
			(1
				(if (> local2 21)
					(if local25
						(-- local25)
						(-= local2 10)
					else
						(= local203 1)
						(localproc_2)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 25) ; "Your split hand busted!"
						(gCurRoom setScript: splitStands)
						(self dispose:)
					)
				)
				(self cue:)
			)
			(2
				(if (and (== local203 0) (== local28 5))
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(localproc_2)
					(Print 250 26) ; "Your split hand has six cards!"
					(gCurRoom setScript: splitStands)
					(self dispose:)
				else
					(proc0_3)
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
		view 250
		loop 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if local201
					(if (not local202)
						(localproc_8 stand)
						(= local205 1)
						(= local202 1)
						(= local3 (localproc_1))
						(+= local2 (localproc_3 2))
						(localproc_4 2 local28)
						(Animate (gCast elements:) 0)
						(if (and (== local2 21) (== local28 1))
							(if gModelessDialog
								(gModelessDialog dispose:)
							)
							(localproc_2)
							(Print 250 18) ; "Your split hand has Blackjack!"
							(gCurRoom setScript: splitStands)
						)
					else
						(gCurRoom setScript: splitStands)
					)
				else
					(gCurRoom setScript: egoStands)
				)
			)
			(1
				(Print 250 27) ; "Click the Hand here when you want no more cards."
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
				(proc0_2)
				(if (== local29 1)
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(Print 250 20) ; "First, click on Deal to start a new hand."
					(proc0_3)
					(self dispose:)
				else
					(if (not local197)
						(localproc_8 stand)
					)
					(localproc_2)
					(if (and (> local1 21) local24)
						(-- local24)
						(-= local1 10)
					)
				)
				(self cue:)
			)
			(1
				(++ local30)
				(++ local31)
				(if (or (< local0 17) (and local23 (== local0 17)))
					(= local3 (localproc_1))
					(+= local0 (localproc_3 0))
					(localproc_4 0 local30)
					(self changeState: 1)
				else
					(= cycles 1)
				)
			)
			(2
				(if (> local0 21)
					(if local23
						(-- local23)
						(-= local0 10)
						(-- local30)
						(self changeState: 1)
					else
						(= cycles 1)
					)
				)
				(= cycles 1)
			)
			(3
				(cond
					((> local1 21)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(proc0_2)
						(Print 250 21) ; "You busted."
						(gCurRoom setScript: dealerWins)
					)
					((> local0 21)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 28) ; "The dealer busted!"
						(self setScript: egoWins)
						(self dispose:)
					)
					((== local0 local1)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 29) ; "It's a push."
					)
					((> local0 local1)
						(proc0_2)
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
				(proc0_2)
				(if (== local29 1)
					(= local205 0)
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(Print 250 20) ; "First, click on Deal to start a new hand."
					(proc0_3)
					(self dispose:)
				else
					(if (not local205)
						(localproc_8 stand)
						(= local205 0)
					)
					(localproc_2)
					(self cue:)
				)
			)
			(1
				(++ local30)
				(++ local31)
				(if (or (< local0 17) (and local23 (== local0 17)))
					(= local3 (localproc_1))
					(+= local0 (localproc_3 0))
					(localproc_4 0 local30)
					(self changeState: 1)
				else
					(= cycles 1)
				)
			)
			(2
				(if (> local0 21)
					(if local23
						(-- local23)
						(-= local0 10)
						(-- local30)
						(self changeState: 1)
					else
						(self cue:)
					)
				)
				(self cue:)
			)
			(3
				(cond
					((> local0 21)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 28) ; "The dealer busted!"
						(if (not local26)
							(if gModelessDialog
								(gModelessDialog dispose:)
							)
							(Print 250 30) ; "Your first hand wins!"
							(localproc_7 (* local32 local197))
						)
						(if (not local203)
							(if gModelessDialog
								(gModelessDialog dispose:)
							)
							(Print 250 31) ; "Your split hand wins!"
							(localproc_7 (* local32 local198))
						)
						(localproc_10)
						(self dispose:)
					)
					((and (== local27 5) (not local26))
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 30) ; "Your first hand wins!"
						(localproc_7 (* local32 local197))
					)
					((== local0 local1)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 32) ; "Your first hand is a push."
					)
					((> local0 local1)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 33) ; "The dealer's hand beats your first hand."
						(localproc_7 (- (* local32 local197)))
					)
					((and (== local1 21) (== local27 1))
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 30) ; "Your first hand wins!"
						(localproc_7 (+ local32 (/ local32 2)))
					)
					((not local26)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 30) ; "Your first hand wins!"
						(localproc_7 (* local32 local197))
					)
					(else
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 34) ; "Your first hand loses."
						(localproc_7 (- (* local32 local197)))
					)
				)
				(self cue:)
			)
			(4
				(cond
					((and (== local28 5) (not local203))
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 31) ; "Your split hand wins!"
						(localproc_7 (* local32 local198))
					)
					((== local0 local2)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 35) ; "Your split hand is a push."
					)
					((> local0 local2)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 36) ; "The dealer beats your split hand."
						(localproc_7 (- (* local32 local198)))
						(localproc_10)
						(self dispose:)
					)
					((and (== local2 21) (== local28 1))
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 31) ; "Your split hand wins!"
						(localproc_7 (+ local32 (/ local32 2)))
					)
					((not local203)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 31) ; "Your split hand wins!"
						(localproc_7 (* local32 local198))
					)
					(else
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 37) ; "Your split hand loses."
						(localproc_7 (- (* local32 local198)))
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
				(if (> local204 10)
					(Printf ; "You win $%d."
						250
						38
						(localproc_7 (* local32 local197))
						22
						3
						111
					)
				else
					(Printf 250 39 (localproc_7 (* local32 local197))) ; "You won $%d."
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
				(localproc_7 (- (* local32 local197)))
				(if (> local204 10)
					(Print 250 40 #time 3 #dispose) ; "The dealer wins!"
				else
					(Print 250 40) ; "The dealer wins!"
				)
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

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 250 41) ; "Click the Hand here to increase your bet. This button repeats automatically if you hold it down."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(if (self onMe: event)
			(cond
				(
					(or
						(< $0000 (event modifiers:) $0005) ; emCTRL | emRIGHT_SHIFT
						(!= ((gTheIconBar curIcon:) message:) 2)
					)
					(super handleEvent: event)
				)
				((== local29 0)
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(Print 250 42) ; "You must wait until this hand is over."
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
									((== local32 10000)
										(if gModelessDialog
											(gModelessDialog dispose:)
										)
										(Print 250 43) ; "This machine has a $10,000.00 limit."
										(break)
									)
									((< local204 (+ (localproc_9) local32 1))
										(if (mod local204 2)
											(= local32 (- local204 1))
										else
											(= local32 local204)
										)
										(localproc_11 1)
										(if gModelessDialog
											(gModelessDialog dispose:)
										)
										(Print 250 13) ; "You can't bet more than you have."
										(break)
									)
									((< local32 0)
										(if gModelessDialog
											(gModelessDialog dispose:)
										)
										(Print 250 44) ; "You must bet more than that!"
									)
									((mod local32 2)
										(if gModelessDialog
											(gModelessDialog dispose:)
										)
										(localproc_11 1)
									)
									(else
										(+= local32 (localproc_9))
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
									((== local32 10000)
										(if gModelessDialog
											(gModelessDialog dispose:)
										)
										(Print 250 43) ; "This machine has a $10,000.00 limit."
									)
									((< local204 (+ (localproc_9) local32 1))
										(if (mod local204 2)
											(= local32 (- local204 1))
										else
											(= local32 local204)
										)
										(localproc_11 1)
										(if gModelessDialog
											(gModelessDialog dispose:)
										)
										(Print 250 13) ; "You can't bet more than you have."
									)
									((< local32 0)
										(if gModelessDialog
											(gModelessDialog dispose:)
										)
										(Print 250 44) ; "You must bet more than that!"
									)
									((mod local32 2)
										(if gModelessDialog
											(gModelessDialog dispose:)
										)
										(-- local32)
										(localproc_11 1)
									)
									(else
										(+= local32 (localproc_9))
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

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 250 45) ; "Click the Hand here to decrease your bet. This button repeats automatically if you hold it down."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if (self onMe: event)
			(cond
				(
					(or
						(< $0000 (event modifiers:) emCTRL)
						(!= ((gTheIconBar curIcon:) message:) 2)
					)
					(super handleEvent: event)
				)
				((== local29 0)
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
								(while (< (GetTime) (+ 12 temp1))
								)
								(temp0 localize:)
								(if (> local32 11)
									(-= local32 (localproc_9))
									(localproc_11 1)
								else
									(if gModelessDialog
										(gModelessDialog dispose:)
									)
									(Printf 250 47 10) ; "The minimum bet in this machine is $%d.00."
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
								(if (> local32 11)
									(-= local32 (localproc_9))
									(localproc_11 1)
								else
									(if gModelessDialog
										(gModelessDialog dispose:)
									)
									(Printf 250 47 10) ; "The minimum bet in this machine is $%d.00."
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
		view 250
		loop 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 250 48) ; "Click the two arrows to increase or decrease your bet."
			)
			(2
				(Print 250 48) ; "Click the two arrows to increase or decrease your bet."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance surrender of View
	(properties
		x 27
		y 76
		view 250
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom setScript: surrenderScript)
			)
			(1
				(Print 250 49) ; "Click the Hand here to surrender your two cards and have half your bet refunded."
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
		view 250
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 250 50) ; "Click the Hand here when you have only two cards totaling 10 or 11. You will automatically receive only one more card and double your bet."
			)
			(2
				(cond
					(
						(>
							(+ (localproc_5) local32)
							(if (== (mod local204 2) 0)
								local204
							else
								(- local204 1)
							)
						)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 51) ; "You're a little short of funds at the moment, Larry."
					)
					((== local29 1)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 20) ; "First, click on Deal to start a new hand."
					)
					(local201
						(Print 250 52) ; "You can't double down when splitting!"
					)
					((and (< 9 (- local1 (* local24 10)) 12) (!= local202 1))
						(localproc_8 self)
						(= local197 2)
						(++ local27)
						(= local3 (localproc_1))
						(+= local1 (localproc_3 1))
						(localproc_4 1 local27)
						(gCurRoom setScript: egoStands)
					)
					(else
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 53) ; "You may only double when your hand contains two cards totaling 10 or 11."
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
		view 250
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 250 54) ; "Click the Hand here when you have only two matching cards and you want to split them into two hands, doubling your bet."
			)
			(2
				(if (and (== local200 local199) (not local29) (not local201))
					(localproc_8 theSplit)
					(proc0_2)
					(= local201 1)
					(dealEm start: 7)
					(gCurRoom setScript: dealEm)
				else
					(self doVerb: 1)
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
					((== local29 1)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 20) ; "First, click on Deal to start a new hand."
					)
					((and (== local27 1) (not local201))
						(localproc_8 surrender)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 55) ; "You surrender your cards and are refunded half of your bet."
						(localproc_7 (- (/ local32 2)))
						(localproc_10)
					)
					(else
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print 250 56) ; "It's too late now!"
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
		view 250
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 250 57) ; "Click the Hand here to learn this machine's current odds."
			)
			(2
				(localproc_8 odds)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Print 250 58 #at 15 -1 #width 280 #title {HOUSE RULES}) ; "This machine has a $10.00 minimum bet and a $10,000.00 limit. Bets must be a multiple of $2.00. Dealer must hit 16, and must stand on 17, unless he has an ace. Blackjack pays 3 to 2 odds. Any six cards under 22 wins."
				(Print 250 59 #at 15 -1 #width 280 #title {HOUSE RULES}) ; "Insurance bets are offered whenever the dealer shows an ace. They are half your bet and pay 2 to 1 odds. You may split a pair, double down or surrender whenever you have only two cards. You may double down if your two cards total 10 or 11 points."
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
		view 250
		loop 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 250 60) ; "Click the Hand here to stop playing this machine. Your winnings will be given to you automatically."
			)
			(2
				(if (== local29 0)
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

