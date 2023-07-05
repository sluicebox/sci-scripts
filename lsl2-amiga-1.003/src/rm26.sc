;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm26 0
)

(local
	work
	shipHere
)

(instance rm26 of Rm
	(properties
		horizon 5
		north 22
		east 27
		west 25
	)

	(method (init)
		(if (and (gEgo has: 3) (gEgo has: 10)) ; Cruise_Ticket, Onklunk
			(= shipHere 1)
			(gCurRoom drawPic: 126)
		else
			(gCurRoom drawPic: 26)
		)
		(Load rsVIEW 236)
		(super init:)
		(if shipHere
			(Load rsVIEW 237)
			(Load rsVIEW 7)
			(Load rsVIEW 3)
			(aPurser setPri: 9 init: stopUpd:)
			(aBird
				setLoop: 2
				setPri: 15
				setStep: 8 6
				illegalBits: 0
				init:
				setScript: birdScript
			)
			(aPoop
				setLoop: 5
				setPri: 12
				setStep: 4 4
				illegalBits: 0
				init:
				hide:
			)
			(aPoop2
				setLoop: 5
				setPri: 12
				setStep: 4 4
				illegalBits: 0
				init:
				hide:
			)
			(aWave
				setLoop: 0
				setPri: 10
				setCycle: Fwd
				cycleSpeed: 1
				isExtra: 1
				init:
			)
		)
		(aGate setLoop: 1 illegalBits: 0 setPri: 10 setStep: 1 1 stopUpd: init:)
		(NormalEgo)
		(gEgo posn: 1 150 init:)
		(self setRegions: 200 setScript: rm26Script) ; rm200
	)
)

(instance rm26Script of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if shipHere
			(cond
				(
					(or
						(Said 'look,finger,give/passport,ticket')
						(Said 'look,finger,give/man,agent/passport,ticket')
						(Said 'look,finger,give/passport,ticket/man,agent')
					)
					(cond
						((not (gEgo inRect: 175 144 211 158))
							(NotClose) ; "You're not close enough."
						)
						((gEgo has: 7) ; Passport
							(self changeState: 5)
						)
						(else
							(self changeState: 1)
						)
					)
				)
				((Said '/craft,boat')
					(Print 26 0) ; "It's so big that from this angle it is difficult to see it all. Perhaps you should "board her!""
				)
				((Said '/carpet')
					(Print 26 1) ; "It reaches from here all the way to the ship."
					(Print 26 2 #at -1 130) ; "(If it didn't, wouldn't it be a pain to board?)"
				)
				((Said '/chain')
					(Print 26 3) ; "Big links, eh?"
				)
				((Said 'look/door')
					(Print 26 4) ; "The man controls the electric gate."
				)
				((Said 'look/man')
					(Print 26 5) ; "He's either a member of the crew of that large ocean-going vessel parked immediately behind him, or dressed for an unusual party!"
				)
				((Said 'talk/man')
					(Print 26 6) ; "If you're going with us, you'd better get moving," says the man in the uniform. "Are you going to show me your ticket, or did you walk over here just to kabitz?"
				)
			)
		)
		(if (or (Said '//door') (Said '/door'))
			(Print 26 7) ; "This is an automatic opening, electric, remote-controlled gate that is presently locked."
			(Print 26 8 #at -1 130) ; "(And you can't open it.)"
		)
		(if (Said 'look>')
			(if (Said '/bird')
				(Print 26 9) ; "It would be best not to look up at THAT bird!"
			)
			(if (Said '/lagoon,beach,water,lagoon')
				(Print 26 10) ; "The ocean waves, and the dock "piers" back at you."
			)
			(if (Said '/door')
				(Print 26 11) ; "The electric gate is closed and locked. It is not under your control."
			)
			(if (Said '[/airport]')
				(Print 26 12) ; "The aroma of dead fish and diesel fumes makes you realize you're at the harbor."
				(if shipHere
					(Print 26 13) ; "There is a man standing here."
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(Print 26 14) ; "You snap to attention. "Sir! Request permission to come aboard, Sir!!""
				(aPurser setCycle: Fwd)
				(= seconds 3)
			)
			(2
				(Print 26 15) ; "Cut the crap, son," he replies with disgust, "I'm no Captain, I'm the purser. May I have your ticket and your passport, please?"
				(aPurser setCel: 0 stopUpd:)
				(= seconds 3)
			)
			(3
				(Print 26 16) ; "Uh, I don't have a passport," you respond. "They didn't say anything on the tv show about a passport!"
				(aPurser setCycle: Fwd)
				(= seconds 3)
			)
			(4
				(Print 26 17) ; "I'm sorry, young man, but I can not allow any passengers aboard without a passport!" he says, returning your ticket to you. "Come back when you get yours, but you'd better hurry: we're due to sail any minute now!"
				(aPurser setCel: 0 stopUpd:)
				(User canControl: 1 canInput: 1)
			)
			(5
				(HandsOff)
				(Print 26 18) ; "Hi!" you tell the purser. "Here's my ticket and my passport!"
				(aPurser setCycle: Fwd)
				(= seconds 3)
			)
			(6
				(Print 26 19) ; "Ok, you just made it! Let's take a look at that passport first."
				(Print 26 20 #icon 7 1 0) ; ""Whew, nice photo," he says sarcastically."
				(Print 26 21) ; "Now let's see if your ticket is in order..."
				(Print 26 22 #icon 3 0 0) ; "...ah, geesh, another freebie! When are those suits in marketing gonna realize these boats don't sail on wind power any more! Oops, I'm sorry; it's not your fault."
				(Print 26 23) ; "Regaining his composure, he continues, "your cabin will be on Deck F, cabin number 1. That'll be all the way below decks, and to the rear. This will give you an excellent opportunity to hear all the subtle inflections of our diesels.""
				(Print 26 24) ; ""You may enter now," he concludes."
				(gGame changeScore: 9)
				(aPurser setCel: 0 stopUpd:)
				(gEgo
					put: 3 -1 ; Cruise_Ticket
					illegalBits: 0
					setMotion: MoveTo 181 150 self
				)
			)
			(7
				(gEgo loop: 3)
				(aGate setMotion: MoveTo 218 146 self)
			)
			(8
				(gEgo setPri: 7 setMotion: MoveTo 182 144 self)
			)
			(9
				(aGate setMotion: MoveTo 188 146)
				(gEgo setMotion: MoveTo 179 121 self)
			)
			(10
				(gEgo setMotion: MoveTo 254 121 self)
			)
			(11
				(gEgo setMotion: MoveTo 318 94 self)
			)
			(12
				(gCurRoom newRoom: 27)
			)
		)
	)
)

(instance birdScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 3))
			)
			(1
				(aBird setCycle: End self)
			)
			(2
				(aBird setLoop: 3 setCycle: Fwd setMotion: MoveTo -12 49 self)
			)
			(3
				(= seconds (Random 4 8))
			)
			(4
				(if (not (gEgo inRect: 103 151 226 167))
					(= seconds 3)
					(-- state)
				else
					(aBird
						posn: 333 65
						setLoop: 3
						setCycle: Fwd
						setMotion: MoveTo (+ (gEgo x:) 20) 66 self
					)
				)
			)
			(5
				(aBird setMotion: MoveTo -12 66)
				(aPoop
					posn: (aBird x:) (aBird y:)
					setCel: 0
					show:
					setMotion: MoveTo (- (aBird x:) 24) (+ (gEgo y:) 8) self
				)
			)
			(6
				(aPoop setCycle: End self)
			)
			(7
				(aBird setMotion: MoveTo -12 66 self)
			)
			(8
				(= seconds 3)
			)
			(9
				(if (not (gEgo inRect: 103 151 226 167))
					(= seconds 3)
					(-- state)
				else
					(aBird
						posn: -12 21
						setLoop: 4
						setCycle: Fwd
						setMotion: MoveTo (- (gEgo x:) 20) 22 self
					)
				)
			)
			(10
				(aBird setMotion: MoveTo 333 22 self)
				(aPoop2
					posn: (aBird x:) (aBird y:)
					show:
					setMotion: MoveTo (+ 14 (aBird x:)) (+ (gEgo y:) 3) self
				)
			)
			(11
				(aPoop2 setCycle: End)
			)
			(12
				(aBird dispose:)
			)
		)
	)
)

(instance aBird of Act
	(properties
		y 48
		x 192
		view 236
		signal 16384
	)
)

(instance aPoop of Act
	(properties
		y 999
		x 999
		view 236
		signal 16384
	)
)

(instance aPoop2 of Act
	(properties
		y 999
		x 999
		view 236
		signal 16384
	)
)

(instance aWave of Prop
	(properties
		y 161
		x 296
		view 236
	)
)

(instance aPurser of Prop
	(properties
		y 146
		x 196
		view 237
		signal 16384
	)
)

(instance aGate of Act
	(properties
		y 146
		x 188
		view 236
		signal 16384
	)
)

