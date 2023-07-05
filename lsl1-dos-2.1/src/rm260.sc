;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 260)
(include sci.sh)
(use Main)
(use Interface)
(use Blk)
(use LoadMany)
(use Wander)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm260 0
)

(local
	bet
	status1
	status2
	[str 80]
	machineDollars
	[display1 7]
	blewIt
	overLimit
)

(procedure (BackToRoom)
	(= gLarryDollars machineDollars)
	(gTheMusic2 number: 266 loop: 1 play:)
	(gCurRoom newRoom: 310)
)

(procedure (ChangeDollars amount)
	(if (> amount 0)
		(if (< (+ machineDollars amount) 0)
			(= machineDollars 10000)
		else
			(+= machineDollars amount)
		)
	else
		(= machineDollars 10000)
	)
	(if (< machineDollars 0)
		(= machineDollars 0)
	)
	(if (> machineDollars 10000)
		(= machineDollars 10000)
		(= overLimit 1)
	)
	(Display 260 20 dsRESTOREPIXELS status2)
	(= status2
		(Display (Format @str 260 1 machineDollars) dsCOORD 165 34 dsCOLOR gColDRed dsSAVEPIXELS) ; "%5d"
	)
)

(procedure (BlinkIt obj)
	(gTheMusic3 number: 260 play:)
	(obj setCel: 1)
	(Animate (gCast elements:) 0)
	(obj setCel: 0)
	(Animate (gCast elements:) 0)
	(obj stopUpd:)
)

(procedure (BetSize &tmp theSize)
	(if (mod (= theSize (/ (+ bet 100) 50)) 2)
		(return (- theSize 1))
	else
		(return theSize)
	)
)

(instance rm260 of Rm
	(properties
		picture 260
		style 0
	)

	(method (init &tmp i)
		(Load rsSCRIPT 941)
		(Load rsVIEW 260)
		(LoadMany rsSOUND 260 261 262 263 264 265 266)
		(gTheMusic2 loop: 1 vol: 127 flags: 1)
		(gTheMusic3 loop: 1 vol: 127 flags: 1)
		(gEgo init: z: 1000 hide:)
		(super init:)
		(playButton init: stopUpd:)
		(increaseButton init: stopUpd:)
		(decreaseButton init: stopUpd:)
		(oddsButton init: stopUpd:)
		(cashOutButton init: stopUpd:)
		(wheelLeft cycleSpeed: 0 init: stopUpd:)
		(wheelCenter cycleSpeed: 0 init: stopUpd:)
		(wheelRight cycleSpeed: 0 init: stopUpd:)
		(= bet 10)
		(= machineDollars gLarryDollars)
		(= status1
			(Display (Format @str 260 0 bet) dsCOORD 105 36 dsCOLOR gColDRed dsSAVEPIXELS) ; "%d"
		)
		(= status2
			(Display (Format @str 260 1 machineDollars) dsCOORD 165 34 dsCOLOR gColDRed dsSAVEPIXELS) ; "%5d"
		)
		(leftTank init:)
		(rightTank init:)
		(for ((= i 0)) (< i (+ 4 global101)) ((++ i))
			((circle new:)
				moveSpeed: global101
				init:
				cel: i
				setPri: i
				x: (Random 1 36)
				y: (Random 71 249)
				observeBlocks: leftTank
				setMotion: Wander
			)
		)
		(for ((= i 12)) (> i (- 9 global101)) ((-- i))
			((circle new:)
				moveSpeed: global101
				init:
				cel: i
				setPri: i
				x: (Random 302 318)
				y: (Random 66 249)
				observeBlocks: rightTank
				setMotion: Wander
			)
		)
		(stripe0 cycleSpeed: global101 setPri: 14 init: stopUpd:)
		(stripe1 cycleSpeed: global101 setPri: 14 init: stopUpd:)
		(stripe2 cycleSpeed: global101 setPri: 14 init: stopUpd:)
		(stripe3 cycleSpeed: global101 setPri: 14 init: stopUpd:)
		(stripe4 cycleSpeed: global101 setPri: 14 init: stopUpd:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 260 2) ; "The numbers at the top of the slot machine indicate the size of your current bet and the total amount of credit you have in the machine."
				(Print 260 3) ; "For help, just Look at the various buttons."
			)
			(5 ; Talk
				(Print 260 4) ; "Come on, dammit, loosen up or I'll find another machine that will!"
			)
			(3 ; Do
				(Print 260 5) ; "Click on a button instead of where you just clicked."
			)
			(10 ; Zipper
				(Print 260 6) ; "Careful or you'll jam the coin slot!"
			)
			(11 ; Taste/Smell
				(Print 260 7) ; "You gently kiss your machine to bring good luck."
			)
			(4 ; Inventory
				(switch invItem
					(11 ; pocketKnife
						(Print 260 8) ; "You carefully slip the pocketknife into that special little hole in the back of every slot machine, twist the odds screw, and hope no one saw you."
						(Print 260 9) ; "Now you'll SURELY get lucky, Larry!"
					)
					(14 ; hammer
						(Print 260 10) ; "Wildly wielding your left-handed hammer, you smash the slot machine into a zillion pieces. "Why, of course no one here at the casino will care," you think."
						(Print 260 11 #at -1 140) ; "(You think wrong!)"
						(Death 103 0 1)
						(Format @gYourPart 260 12) ; "You animal!"
						(GameOver 260 13)
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
			(= status1
				(Display
					(Format @str 260 0 bet) ; "%d"
					dsCOORD
					105
					36
					dsCOLOR
					gColDRed
					dsSAVEPIXELS
				)
			)
			(= status2
				(Display
					(Format @str 260 1 machineDollars) ; "%5d"
					dsCOORD
					165
					34
					dsCOLOR
					gColDRed
					dsSAVEPIXELS
				)
			)
		)
		(cond
			(script)
			((>= machineDollars 10000)
				(HandsOff)
				(gCurRoom setScript: sWin)
			)
			((gEgo mover:)
				(BackToRoom)
			)
		)
		(super doit:)
	)
)

(instance sWin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheMusic3 number: 265 play: self)
				(Print 260 14 #dispose) ; "Congratulations, Larry! You have broken the house limit."
			)
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(if overLimit
					(Print 260 15) ; "This machine only contains $10,000.00; trust us, we'll mail you the rest."
				)
				(BackToRoom)
			)
		)
	)
)

(instance playButton of Prop
	(properties
		x 164
		y 189
		description {the Play button}
		lookStr {Click the Hand here to begin play.}
		view 260
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(cond
					((< machineDollars bet)
						(Print 260 16) ; "You don't have enough money!"
					)
					((== bet 0)
						(Print 260 17) ; "You insert zero dollars, and pretend to push the button."
						(Print 260 18) ; "You win zero dollars!"
						(Print 260 19 #at -1 140) ; "(You are so easily amused!)"
					)
					(else
						(BlinkIt playButton)
						(HandsOff)
						(gCurRoom setScript: spinEm)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance spinEm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheMusic2 setLoop: -1 number: 261 play:)
				(HandsOff)
				(Display 260 20 dsRESTOREPIXELS status2)
				(= status2
					(Display
						(Format @str 260 1 (-= machineDollars bet)) ; "%5d"
						dsCOORD
						165
						34
						dsCOLOR
						gColDRed
						dsSAVEPIXELS
					)
				)
				(wheelLeft setCel: (Random 0 7) setCycle: Fwd)
				(wheelCenter setCel: (Random 0 7) setCycle: Fwd)
				(wheelRight setCel: (Random 0 7) setCycle: Fwd)
				(= seconds 3)
			)
			(1
				(wheelLeft
					setCycle:
						CT
						(if gDebugging
							6
						else
							(* 2 (Random 0 3))
						)
						1
						wheelLeft
				)
				(= seconds 2)
			)
			(2
				(wheelCenter
					setCycle:
						CT
						(if gDebugging
							6
						else
							(* 2 (Random 0 3))
						)
						1
						wheelCenter
				)
				(= seconds 2)
			)
			(3
				(wheelRight
					setCycle:
						CT
						(if gDebugging
							6
						else
							(* 2 (Random 0 3))
						)
						1
						self
				)
			)
			(4
				(= blewIt 0)
				(gTheMusic2 number: 262 setLoop: 1 play:)
				(gTheMusic3 setLoop: -1)
				(cond
					((== (wheelLeft cel:) 0)
						(if (== (wheelCenter cel:) 0)
							(if (== (wheelRight cel:) 0)
								(gTheMusic3 number: 264 play:)
								(if (> bet 8000)
									(ChangeDollars 10000)
								else
									(ChangeDollars (* 4 bet))
								)
								(= seconds 5)
							else
								(gTheMusic3 number: 263 play:)
								(ChangeDollars (* 2 bet))
								(= seconds 3)
							)
						else
							(gTheMusic3 number: 263 play:)
							(ChangeDollars bet)
							(= seconds 2)
						)
					)
					((== (wheelLeft cel:) (wheelCenter cel:) 2)
						(if (== (wheelRight cel:) 2)
							(gTheMusic3 number: 264 play:)
							(if (> bet 8000)
								(ChangeDollars 10000)
							else
								(ChangeDollars (* 4 bet))
							)
							(= seconds 5)
						else
							(gTheMusic3 number: 263 play:)
							(ChangeDollars (* 2 bet))
							(= seconds 3)
						)
					)
					((== (wheelLeft cel:) (wheelCenter cel:) 4)
						(if (== (wheelRight cel:) 4)
							(gTheMusic3 number: 264 play:)
							(if (> bet 6400)
								(ChangeDollars 10000)
							else
								(ChangeDollars (* 5 bet))
							)
							(= seconds 6)
						else
							(gTheMusic3 number: 263 play:)
							(ChangeDollars (* 3 bet))
							(= seconds 4)
						)
					)
					(
						(==
							(wheelLeft cel:)
							(wheelCenter cel:)
							(wheelRight cel:)
							6
						)
						(gTheMusic3 number: 264 play: self)
						(jackpotSign cycleSpeed: global101 init: setCycle: Fwd)
						(if (> bet 4500)
							(ChangeDollars 10000)
						else
							(ChangeDollars (* 7 bet))
						)
						(= seconds 8)
					)
					(else
						(= blewIt (= cycles 1))
					)
				)
				(if (not blewIt)
					(stripe0 setCycle: End stripe1)
				)
			)
			(5
				(stripe0 setCel: 0 stopUpd:)
				(stripe1 setCel: 0 stopUpd:)
				(stripe2 setCel: 0 stopUpd:)
				(stripe3 setCel: 0 stopUpd:)
				(stripe4 setCel: 0 stopUpd:)
				(gTheMusic3 setLoop: 1 stop:)
				(if (IsObject jackpotSign)
					(jackpotSign dispose:)
				)
				(if (> bet machineDollars)
					(if (> machineDollars 9)
						(= bet machineDollars)
					else
						(= bet 10)
					)
					(Display 260 20 dsRESTOREPIXELS status1)
					(= status1
						(Display
							(Format @str 260 0 bet) ; "%d"
							dsCOORD
							105
							36
							dsCOLOR
							gColDRed
							dsSAVEPIXELS
						)
					)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance increaseButton of Prop
	(properties
		x 146
		y 164
		description {the Increase button}
		lookStr {Click the Hand here to increase the amount of your bet.}
		view 260
		loop 2
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

	(method (handleEvent event &tmp event ticks)
		(if (and (self onMe: event) (!= (gCurRoom script:) spinEm)) ; UNINIT
			(if
				(or
					(< $0000 (event modifiers:) $0005) ; UNINIT, emCTRL | emRIGHT_SHIFT
					(!= ((gTheIconBar curIcon:) message:) 3)
				)
				(super handleEvent: event) ; UNINIT
			else
				(switch (event type:) ; UNINIT
					(evMOUSEBUTTON
						(while (!= ((= event (Event new:)) type:) evMOUSERELEASE)
							(= ticks (GetTime))
							(while (< (GetTime) (+ 10 ticks))
							)
							(event localize:)
							(cond
								((== bet 10000)
									(Print 260 21) ; "This machine has a $10,000.00 limit."
									(break)
								)
								((< machineDollars 10)
									(Print 260 22) ; "You don't have any more money!"
									(break)
								)
								((< machineDollars (+ (BetSize) bet 1))
									(if (mod machineDollars 2)
										(= bet (- machineDollars 1))
									else
										(= bet machineDollars)
									)
									(Display 260 20 dsRESTOREPIXELS status1)
									(= status1
										(Display
											(Format @str 260 0 bet) ; "%d"
											dsCOORD
											105
											36
											dsCOLOR
											gColDRed
											dsSAVEPIXELS
										)
									)
									(Print 260 22) ; "You don't have any more money!"
									(break)
								)
								(else
									(gTheMusic3 number: 260 play:)
									(+= bet (BetSize))
									(Display 260 20 dsRESTOREPIXELS status1)
									(= status1
										(Display
											(Format @str 260 0 bet) ; "%d"
											dsCOORD
											105
											36
											dsCOLOR
											gColDRed
											dsSAVEPIXELS
										)
									)
								)
							)
							(event dispose:)
						)
						(event dispose:)
						(event claimed: 1)
						(return)
					)
					(evKEYBOARD
						(if (== (event message:) KEY_RETURN) ; UNINIT
							(cond
								((== bet 10000)
									(Print 260 21) ; "This machine has a $10,000.00 limit."
								)
								((< machineDollars (+ (BetSize) bet 1))
									(if (mod machineDollars 2)
										(= bet (- machineDollars 1))
									else
										(= bet machineDollars)
									)
									(Display 260 20 dsRESTOREPIXELS status1)
									(= status1
										(Display
											(Format @str 260 0 bet) ; "%d"
											dsCOORD
											105
											36
											dsCOLOR
											gColDRed
											dsSAVEPIXELS
										)
									)
									(Print 260 22) ; "You don't have any more money!"
								)
								(else
									(+= bet (BetSize))
									(gTheMusic3 number: 260 play:)
									(Display 260 20 dsRESTOREPIXELS status1)
									(= status1
										(Display
											(Format @str 260 0 bet) ; "%d"
											dsCOORD
											105
											36
											dsCOLOR
											gColDRed
											dsSAVEPIXELS
										)
									)
								)
							)
							(event claimed: 1) ; UNINIT
							(return)
						)
					)
				)
			)
		)
	)
)

(instance decreaseButton of Prop
	(properties
		x 183
		y 164
		description {the Decrease button}
		lookStr {Click the Hand here to decrease the amount of your bet.}
		view 260
		loop 5
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

	(method (handleEvent event &tmp event ticks)
		(if (and (self onMe: event) (!= (gCurRoom script:) spinEm)) ; UNINIT
			(if
				(or
					(< $0000 (event modifiers:) emCTRL) ; UNINIT
					(!= ((gTheIconBar curIcon:) message:) 3)
				)
				(super handleEvent: event) ; UNINIT
			else
				(switch (event type:) ; UNINIT
					(evMOUSEBUTTON
						(while (!= ((= event (Event new:)) type:) evMOUSERELEASE)
							(= ticks (GetTime))
							(while (< (GetTime) (+ 10 ticks))
							)
							(event localize:)
							(if (> bet 10)
								(gTheMusic3 number: 260 play:)
								(if (< (-= bet (BetSize)) 10)
									(= bet 10)
								)
								(Display 260 20 dsRESTOREPIXELS status1)
								(= status1
									(Display
										(Format @str 260 0 bet) ; "%d"
										dsCOORD
										105
										36
										dsCOLOR
										gColDRed
										dsSAVEPIXELS
									)
								)
							else
								(Printf 260 23 10) ; "This machine's minimum bet is $%d.00."
								(break)
							)
							(event dispose:)
						)
						(event dispose:)
						(event claimed: 1)
						(return)
					)
					(evKEYBOARD
						(if (== (event message:) KEY_RETURN) ; UNINIT
							(if (> bet 10)
								(if (< (-= bet (BetSize)) 10)
									(= bet 10)
								)
								(gTheMusic3 number: 260 play:)
								(Display 260 20 dsRESTOREPIXELS status1)
								(= status1
									(Display
										(Format @str 260 0 bet) ; "%d"
										dsCOORD
										105
										36
										dsCOLOR
										gColDRed
										dsSAVEPIXELS
									)
								)
							else
								(Printf 260 24 10) ; "You can't bet less than $%d.00."
							)
							(event claimed: 1) ; UNINIT
							(return)
						)
					)
				)
			)
		)
	)
)

(instance oddsButton of Prop
	(properties
		x 193
		y 145
		description {the Odds button}
		lookStr {Click the Hand here to learn this machine's odds.}
		view 260
		loop 4
	)

	(method (cue)
		(super cue:)
		(Print 260 25 #width 200 #at -1 30) ; "PAYOFF  RESULTS  1 Cherry  2 Cherry Cherry  4 Cherry Cherry Cherry  2 Bell  Bell  4 Bell  Bell  Bell  3 Seven  Seven  5 Seven  Seven  Seven  7 Bar   Bar  Bar"
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(gTheMusic3 number: 260 play:)
				(self setCycle: Beg self)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cashOutButton of Prop
	(properties
		x 135
		y 144
		description {the Cash Out button}
		lookStr {Click the Hand here to stop playing. All the money you've deposited in the machine will be returned to you.}
		view 260
		loop 1
	)

	(method (cue)
		(super cue:)
		(BackToRoom)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(self setCycle: Beg self)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wheelLeft of Prop
	(properties
		x 115
		y 92
		description {the left tumbler}
		lookStr {You hope this will soon match the other two.}
		view 260
	)

	(method (cue)
		(super cue:)
		(gTheMusic3 number: 262 loop: 1 play:)
	)
)

(instance wheelCenter of Prop
	(properties
		x 159
		y 89
		description {the center tumbler}
		lookStr {You hope this will soon match the other two.}
		view 260
	)

	(method (cue)
		(super cue:)
		(gTheMusic3 number: 262 loop: 1 play:)
	)
)

(instance wheelRight of Prop
	(properties
		x 204
		y 88
		description {the right tumbler}
		lookStr {You hope this will soon match the other two.}
		view 260
	)
)

(instance circle of Actor
	(properties
		description {those cute little circles}
		lookStr {You must be bored to be staring at these things!}
		yStep 1
		view 260
		loop 7
		signal 22528
		illegalBits 0
		xStep 1
	)

	(method (doit)
		(super doit: &rest)
		(if (self isBlocked:)
			(self setMotion: Wander)
		)
	)
)

(instance leftTank of Cage
	(properties
		top 70
		left -10
		bottom 210
		right 47
	)
)

(instance rightTank of Cage
	(properties
		top 65
		left 281
		bottom 230
		right 339
	)
)

(instance jackpotSign of Prop
	(properties
		x 159
		y 84
		view 260
		loop 6
		priority 15
		signal 16400
	)
)

(instance stripe0 of Prop
	(properties
		x 129
		y 115
		description {the light}
		view 260
		loop 8
		signal 16384
		detailLevel 2
	)

	(method (cue)
		(super cue:)
		(stripe4 setCel: 0)
		(self setCycle: End stripe1)
	)
)

(instance stripe1 of Prop
	(properties
		x 147
		y 134
		description {the light}
		view 260
		loop 9
		signal 16384
		detailLevel 2
	)

	(method (cue)
		(super cue:)
		(stripe0 setCel: 0)
		(self setCycle: End stripe2)
	)
)

(instance stripe2 of Prop
	(properties
		x 163
		y 154
		description {the light}
		view 260
		loop 10
		signal 16384
		detailLevel 2
	)

	(method (cue)
		(super cue:)
		(stripe1 setCel: 0)
		(self setCycle: End stripe3)
	)
)

(instance stripe3 of Prop
	(properties
		x 180
		y 133
		description {the light}
		view 260
		loop 11
		signal 16384
		detailLevel 2
	)

	(method (cue)
		(super cue:)
		(stripe2 setCel: 0)
		(self setCycle: End stripe4)
	)
)

(instance stripe4 of Prop
	(properties
		x 195
		y 108
		description {the light}
		view 260
		loop 12
		signal 16384
		detailLevel 2
	)

	(method (cue)
		(super cue:)
		(stripe3 setCel: 0)
		(self setCycle: End stripe0)
	)
)

