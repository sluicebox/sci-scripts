;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 52)
(include sci.sh)
(use Main)
(use Interface)
(use Extra)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm52 0
)

(local
	work
	aGreenAgent
	activeLine
	agentHere
)

(instance theSound of Sound
	(properties
		number 5
		loop -1
	)
)

(instance rm52 of Rm
	(properties
		picture 52
		horizon 5
		east 53
		south 50
		west 51
	)

	(method (init)
		(Load rsVIEW 508)
		(Load rsVIEW 509)
		(super init:)
		(gAddToPics
			add:
				aLcomputer
				aCcomputer
				aRcomputer
				aCounter1
				aCounter2
				aMonitor1
				aMonitor2
				aMonitor3
				aMonitor4
				aCustomsSign
				aPlants
				aRaisins
				aTicket1
				aTicket2
				aTicket3
				aTicket4
				aTicket5
			doit:
		)
		(cond
			((== gPrevRoomNum 53)
				(gEgo posn: 273 127)
			)
			((== gPrevRoomNum 50)
				(gEgo posn: 133 184)
			)
			((== gPrevRoomNum 0)
				(gEgo posn: 133 184)
			)
		)
		(self setRegions: 500 setScript: rm52Script) ; rm500
		(if ((gInventory at: 23) ownedBy: gCurRoomNum) ; Airline_Ticket
			(= agentHere 1)
		)
		(if (< gBombStatus 2)
			(Load rsVIEW 510)
			(Load rsVIEW 608)
			(aBlueAgent init:)
			((= aGreenAgent (Extra new:)) view: 509 setLoop: 2 posn: 167 92 init:)
			(aCyanAgent init:)
			(aBlueLine posn: 109 140 cycleSpeed: 1 setPri: 10 stopUpd: init:)
			(aGreenLine posn: 151 140 cycleSpeed: 1 setPri: 10 stopUpd: init:)
			(aCyanLine posn: 197 140 setPri: 10 cycleSpeed: 1 stopUpd: init:)
			(if (< gBombStatus 1)
				(NormalEgo)
				(gEgo observeControl: 16384)
				(aCustomer
					posn: 161 227
					setCycle: Walk
					setStep: 3 2
					illegalBits: 0
					init:
					setScript: ticketScript
				)
			else
				(Load rsSOUND 5)
				(theSound play:)
				(= gCurrentStatus 7)
				(HandsOff)
				(rm52Script changeState: 1)
			)
		else
			(if (== gBombStatus 2)
				(= gBombStatus 3)
				(HandsOff)
				(gEgo
					view: 155
					setLoop: 2
					cel: 0
					cycleSpeed: 2
					posn: 159 186
					setStep: 3 2
				)
				(rm52Script changeState: 6)
			else
				(NormalEgo)
			)
			(if agentHere
				((= aGreenAgent (Prop new:))
					view: 509
					setLoop: 2
					setCel: 0
					posn: 167 92
					stopUpd:
					init:
				)
			)
		)
		(gEgo init:)
	)
)

(instance rm52Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (gEgo inRect: 279 100 333 137)
			(gCurRoom newRoom: 53)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/man,children')
				(cond
					(aBlueLine
						(Print 52 0) ; "The men are too busy waiting in line to talk to you."
					)
					(agentHere
						(Print 52 1) ; "He looks like he's ready to help you. What do you want?"
					)
					(else
						(Print 52 2) ; "This is where you bought your ticket. Shouldn't you be hurrying toward your plane?"
					)
				)
			)
			(if (and agentHere (Said '/woman,agent'))
				(Print 52 3) ; "Perhaps you might want to purchase an airline ticket."
			)
			(if (Said '/computer,schedule')
				(Print 52 4) ; "Every single flight is listed as "ON TIME!""
				(Print 52 5 #at -1 130) ; "(Obviously, this is a fantasy game!)"
			)
			(if (Said '/raisin,(art<raisin)')
				(Print 52 6) ; "The delicate interplay of colored light is fascinating."
				(Print 52 7 #at -1 130) ; "(Oh, did you mean that colored light sculpture?)"
			)
			(if (Said '/cup,art')
				(Print 52 6) ; "The delicate interplay of colored light is fascinating."
				(Print 52 8 #at -1 130) ; "(Oh, did you mean that raisin poster?)"
			)
			(if (Said '[/airport,buffet]')
				(cond
					(aBlueLine
						(Print 52 9) ; "There are three ticket agents with lines of customers queued before them. Perhaps you should stand in line?"
					)
					(agentHere
						(Print 52 10) ; "Since you cleared away the crowds, you are all alone with the sole remaining ticket agent."
					)
					(else
						(Print 52 2) ; "This is where you bought your ticket. Shouldn't you be hurrying toward your plane?"
					)
				)
			)
		)
		(if (or (Said 'talk/woman,agent') (Said 'get,buy/ticket'))
			(cond
				((not agentHere)
					(Print 52 11) ; "Where?"
				)
				((!= gBombStatus 3)
					(Print 52 12) ; "Hey," shouts a man waiting in line, "who do you think you are? Stand in line like everyone else!"
				)
				((not ((gInventory at: 23) ownedBy: gCurRoomNum)) ; Airline_Ticket
					(Print 52 13) ; "Sorry, but I'm all out of tickets."
				)
				((not (gEgo inRect: 154 118 181 129))
					(NotClose) ; "You're not close enough."
				)
				(else
					(self changeState: 9)
				)
			)
		)
		(if (Said 'talk/man,children')
			(cond
				((not agentHere)
					(Print 52 11) ; "Where?"
				)
				((!= gBombStatus 3)
					(Print (Format @gString 52 14 gLaffer)) ; "Hi," you say to the men in line, "%s"
					(if (> gFilthLevel 10)
						(Print 52 15) ; "Back of the line, butthole!"
					else
						(Print 52 16) ; "Back of the line, buddy!"
					)
				)
				((gEgo inRect: 154 118 181 129)
					(Print (Format @gString 52 17 gLaffer)) ; ""Hello," you say to the ticket agent. %s"
					(Print 52 18) ; ""Would you care to buy a ticket?" says the clerk, obviously unimpressed."
				)
				(else
					(NotClose) ; "You're not close enough."
				)
			)
		)
		(if (and (!= gBombStatus 3) (Said '/line'))
			(Print 52 19) ; "This is just like the grocery store: no matter which line you stand in, it's always the slowest."
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(gEgo setMotion: MoveTo 255 129 self)
			)
			(2
				(Print 52 20) ; "LOOK OUT, I'VE GOT A BOMB!" you shout, "Get out of here -- QUICK!!"
				(Print 52 21 #at -1 130) ; "(That was certainly subtle, Larry. You wouldn't want to create a panic!)"
				(= seconds 9)
			)
			(3
				(Print 52 22) ; "It seems you're the only one panicked around here, Larry!"
				(Print 52 23 #at -1 15 #width 280) ; "Ignoring their apathy you vow, "I'll rush this outside and throw it safely over those cliffs, protecting these innocent bystanders from harm while making myself a hero in the process!""
				(Print 52 24 #at -1 15 #width 280) ; "Fame and recognition will surely follow; I'll write a titillating, best-selling autobiography in which I reveal everything, guaranteeing appearances on "Donahue" and "Carson," and a seven-figure movie deal, signed over a power lunch at Spago's in spite of the protestations of my agent and attorneys, which will go on to make me even richer and more famous, before retiring to a quiet, unassuming life as a gentleman farmer in the foothills of eastern Madera County."
				(Print 52 25 #at -1 130) ; "(Or, then again, maybe not!)"
				(gEgo ignoreControl: 16384 setMotion: MoveTo 184 178 self)
			)
			(4
				(Print 52 26) ; "Hurry, Larry, it sounds like it's about to go off!!"
				(gEgo setMotion: MoveTo 159 188 self)
			)
			(5
				(gEgo put: 22 -1) ; Suitcase
				(gCurRoom newRoom: 152)
			)
			(6
				(= seconds 5)
			)
			(7
				(gGame changeScore: 15)
				(Print 52 27) ; "That was certainly ONE way to clear out a crowd!"
				(Print 52 28) ; "But now look at your suit!"
				(gEgo setCycle: End self)
			)
			(8
				(Print 52 29 #draw) ; "Oh, well, at least no one was hurt; but why did they all run away from a little firecracker like that?"
				(NormalEgo 2)
			)
			(9
				(HandsOff)
				(gEgo loop: 3)
				(Print 52 30 #draw) ; ""May I please purchase a ticket on the next available flight," you tell the agent."
				(aGreenAgent setCycle: Fwd)
				(= seconds 3)
			)
			(10
				(Print 52 31 #at -1 20) ; ""Your destination, Sir?" he asks."
				(aGreenAgent setCel: 0)
				(= seconds 3)
			)
			(11
				(Print 52 32) ; ""Anywhere but here!" you respond."
				(aGreenAgent setCycle: Fwd)
				(= seconds 3)
			)
			(12
				(Print 52 33 #at -1 20) ; "You're in luck," says the ticket agent, "we have exactly one seat available in the next two weeks and it's on the next departing flight."
				(Print 52 34) ; "I'll take it," you blurt. "Say, if you have no seats available, why were all those men in line?"
				(Print 52 35 #at -1 20) ; "They were waiting for the keys to the restroom!"
				(aGreenAgent setCel: 0)
				(= seconds 3)
			)
			(13
				(Print 52 36) ; "You presume that explains their sudden departure following the loud noise!"
				(= seconds 3)
			)
			(14
				(aGreenAgent setCycle: Fwd)
				(= seconds 3)
			)
			(15
				(Print 52 37 #at -1 20) ; "Would you prefer smoking or non-smoking?"
				(Print 52 38) ; "Non."
				(Print 52 39 #at -1 20) ; "Aisle or window?"
				(Print 52 40) ; "Aisle."
				(Print 52 41 #at -1 20) ; "Any carry-on baggage?"
				(Print 52 42) ; "None."
				(Print 52 43 #at -1 20) ; "Luggage to check through?"
				(Print 52 44) ; "No."
				(Print 52 45 #at -1 20) ; "Will you require a bassinet?"
				(Print 52 44) ; "No."
				(Print 52 46 #at -1 20) ; "Traveling with children or elderly?"
				(Print 52 44) ; "No."
				(Print 52 47 #at -1 20) ; "Bringing a pet?"
				(Print 52 44) ; "No."
				(Print 52 48 #at -1 20) ; "Do you have a passport or visa?"
				(Print 52 49) ; "Passport."
				(Print 52 50 #at -1 20) ; "Care for baggage insurance?"
				(Print 52 44) ; "No."
				(Print 52 51 #at -1 20) ; "First class, business class or coach?"
				(Print 52 52) ; "You said there was only one seat."
				(Print 52 53 #at -1 20) ; "Will you be staying 14 to 21 days?"
				(Print 52 54) ; "Forever."
				(Print 52 55 #at -1 20) ; "Are you a member of any frequent flyer programs?"
				(Print 52 44) ; "No."
				(Print 52 56 #at -1 20) ; "Will you be bringing a laptop computer on-board?"
				(Print 52 44) ; "No."
				(Print 52 57 #at -1 20) ; "Would you like a pillow?"
				(Print 52 58) ; "Yes."
				(Print 52 59 #at -1 20) ; "Blanket?"
				(Print 52 44) ; "No."
				(Print 52 60 #at -1 20) ; "Movie?"
				(Print 52 44) ; "No."
				(Print 52 61 #at -1 20) ; "Stereo headphones?"
				(Print 52 62) ; "I suppose."
				(Print 52 63 #at -1 20) ; "Drinking or non-drinking?"
				(Print 52 64) ; "Drinking."
				(Print 52 65 #at -1 20) ; "Cash or credit card?"
				(Print 52 66) ; "Cash."
				(Print 52 67 #at -1 20) ; "Telephone privileges in flight?"
				(Print 52 44) ; "No."
				(Print 52 68 #at -1 20) ; "Kosher or Mexican?"
				(Print 52 69) ; "Armenian!"
				(Print 52 70 #at -1 20 #time 4) ; "3-1/2 inch or 5-1/4 inch?"
				(Print 52 71 #at -1 20 #time 3) ; "8-bit or 16-bit?"
				(Print 52 72 #at -1 20 #time 2 #dispose) ; "Stewardess fondling or non-fondling?"
				(if (> gFilthLevel 4)
					(Print 52 73) ; "JUST GIVE ME THE DAMN TICKET!!"
				else
					(Print 52 74) ; "JUST GIVE ME THE GOL-DARNED, DAB-NATTED, GOLLY-GEE-WHIZ-BANGED TICKET!!"
				)
				(aGreenAgent setCel: 0)
				(= seconds 3)
			)
			(16
				(aGreenAgent setCycle: Fwd)
				(= seconds 3)
			)
			(17
				(Print 52 75 #at -1 15 #width 280) ; "Boy, are you Americanos touchy!" he snarls, "Ok, here's your ticket: one adult, ultra-saver, non-smoking, window, Deluxe-Business Class, Express, APEX, excursion, Gold Label, y-fare, non-refundable, maxifare ticket for Calwa, with pillow, blanket, movie, and stereo headphones."
				(Print 52 76 #at -1 20) ; "Your flight is scheduled to depart from Gate #1 in exactly one minute."
				(Print (Format @gString 52 77 gTritePhrase) #at -1 20) ; "Too bad you spent so much time here; you might have made it!" concludes the agent, "%s"
				(aGreenAgent setCel: 0 stopUpd:)
				(gEgo get: 23) ; Airline_Ticket
				(gGame changeScore: 5)
				(NormalEgo 3)
				(SetRgTimer 4 5 10)
			)
		)
	)
)

(instance ticketScript of Script
	(properties)

	(method (changeState newState &tmp done)
		(switch (= state newState)
			(0
				(= seconds (Random 2 5))
			)
			(1
				(aCustomer posn: 161 227 show: setMotion: MoveTo 161 165 self)
			)
			(2
				(= done 0)
				(while (not done)
					(switch (++ activeLine)
						(1
							(if (not (& (gEgo onControl:) $0002))
								(self changeState: 9)
								(= done 1)
							)
						)
						(2
							(if (not (& (gEgo onControl:) $0004))
								(self changeState: 3)
								(= done 1)
							)
						)
						(3
							(if (not (& (gEgo onControl:) $0008))
								(self changeState: 15)
								(= done 1)
							)
						)
						(else
							(= activeLine 0)
						)
					)
				)
			)
			(3
				(aCustomer setMotion: MoveTo 161 148 self)
			)
			(4
				(aCustomer loop: 3)
				(= seconds 3)
			)
			(5
				(if (& (gEgo onControl:) $0004)
					(-- state)
					(= cycles 10)
				else
					(aCustomer posn: 164 124 setMotion: MoveTo 177 124 self)
					(aGreenLine cel: 0 setCycle: End)
				)
			)
			(6
				(aCustomer setMotion: MoveTo 177 153 self)
			)
			(7
				(aGreenLine stopUpd:)
				(aCustomer setMotion: MoveTo 220 153 self)
			)
			(8
				(aCustomer setMotion: MoveTo 282 128 self)
				(= state 19)
			)
			(9
				(aCustomer setMotion: MoveTo 119 148 self)
			)
			(10
				(aCustomer loop: 3)
				(= seconds 3)
			)
			(11
				(if (& (gEgo onControl:) $0002)
					(-- state)
					(= cycles 10)
				else
					(aCustomer posn: 122 124 setMotion: MoveTo 135 124 self)
					(aBlueLine cel: 0 setCycle: End)
				)
			)
			(12
				(aCustomer setMotion: MoveTo 135 153 self)
			)
			(13
				(aBlueLine stopUpd:)
				(aCustomer setMotion: MoveTo 220 153 self)
			)
			(14
				(aCustomer setMotion: MoveTo 282 128 self)
				(= state 19)
			)
			(15
				(aCustomer setMotion: MoveTo 207 148 self)
			)
			(16
				(aCustomer loop: 3)
				(= seconds 3)
			)
			(17
				(if (& (gEgo onControl:) $0008)
					(-- state)
					(= cycles 10)
				else
					(aCustomer posn: 210 124 setMotion: MoveTo 223 124 self)
					(aCyanLine cel: 0 setCycle: End)
				)
			)
			(18
				(aCustomer setMotion: MoveTo 282 128 self)
				(= state 19)
			)
			(20
				(aCustomer hide:)
				(self changeState: 0)
			)
		)
	)
)

(instance aLcomputer of PV
	(properties
		y 98
		x 105
		view 508
		cel 1
		priority 8
	)
)

(instance aCcomputer of PV
	(properties
		y 98
		x 157
		view 508
		cel 1
		priority 8
	)
)

(instance aRcomputer of PV
	(properties
		y 98
		x 210
		view 508
		priority 8
	)
)

(instance aCounter1 of PV
	(properties
		y 98
		x 131
		view 508
		cel 2
		priority 8
	)
)

(instance aCounter2 of PV
	(properties
		y 98
		x 185
		view 508
		cel 3
		priority 8
	)
)

(instance aMonitor1 of PV
	(properties
		y 63
		x 128
		view 508
		loop 1
		priority 5
	)
)

(instance aMonitor2 of PV
	(properties
		y 63
		x 149
		view 508
		loop 1
		priority 4
	)
)

(instance aMonitor3 of PV
	(properties
		y 63
		x 171
		view 508
		loop 1
		priority 3
	)
)

(instance aMonitor4 of PV
	(properties
		y 63
		x 192
		view 508
		loop 1
		priority 2
	)
)

(instance aCustomsSign of PV
	(properties
		y 61
		x 249
		view 508
		loop 1
		cel 1
		priority 10
	)
)

(instance aPlants of PV
	(properties
		y 53
		x 247
		view 508
		loop 1
		cel 3
		priority 11
	)
)

(instance aRaisins of PV
	(properties
		y 147
		x 295
		view 508
		loop 1
		cel 2
		priority 10
	)
)

(instance aTicket1 of PV
	(properties
		y 102
		x 92
		view 508
		loop 2
		priority 8
	)
)

(instance aTicket2 of PV
	(properties
		y 102
		x 125
		view 508
		loop 2
		priority 8
	)
)

(instance aTicket3 of PV
	(properties
		y 102
		x 157
		view 508
		loop 2
		priority 8
	)
)

(instance aTicket4 of PV
	(properties
		y 102
		x 189
		view 508
		loop 2
		priority 8
	)
)

(instance aTicket5 of PV
	(properties
		y 102
		x 221
		view 508
		loop 2
		priority 8
	)
)

(instance aBlueAgent of Extra
	(properties
		y 93
		x 116
		view 509
	)
)

(instance aCyanAgent of Extra
	(properties
		y 94
		x 194
		view 509
		loop 1
	)
)

(instance aBlueLine of Prop
	(properties
		view 510
		cel 4
	)
)

(instance aGreenLine of Prop
	(properties
		view 510
		loop 1
		cel 4
	)
)

(instance aCyanLine of Prop
	(properties
		view 510
		cel 4
	)
)

(instance aCustomer of Act
	(properties
		view 608
	)
)

