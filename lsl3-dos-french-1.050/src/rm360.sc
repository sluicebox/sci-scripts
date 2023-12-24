;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 360)
(include sci.sh)
(use Main)
(use Door)
(use Interface)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	rm360 0
)

(local
	messageCount
)

(instance rm360 of Rm
	(properties
		picture 360
		horizon 111
		north 390
		east 365
		south 300
	)

	(method (init)
		(if (gEgo has: 9) ; Spa_Keycard
			(Load rsVIEW 715)
			(Load rsVIEW 9)
			(Load rsSOUND 11)
		)
		(super init:)
		(gAddToPics
			add: atpRightCardHole
			add: atpLeftCardHole
			add: atpRearCardHole
			add: atpFatCity
			add: atpBboard
			add: atpShelves
			add: atpSumtin
			add: atpBlender
			doit:
		)
		(aTanBoothDoor init:)
		(aStudioDoor init:)
		(aLockerDoor init:)
		(if (not gEgoIsPatti)
			(aRobin init:)
		)
		(self setLocales: 80 setScript: RoomScript)
		(NormalEgo)
		(cond
			((== gPrevRoomNum 390)
				(gEgo posn: 198 122 loop: 2)
				(aStudioDoor close: locked: 1)
				(if (== gEgoState 1)
					(HandsOff)
					(aBambi init:)
					(gEgo
						view: 720
						posn: 191 122
						illegalBits: 0
						ignoreActors:
					)
					(gMusic number: 399 loop: gBgMusicLoops play:)
					(RoomScript changeState: 11)
				)
			)
			((== gPrevRoomNum 370)
				(gEgo posn: 27 173)
				(aLockerDoor close: locked: 1)
			)
			((== gPrevRoomNum 365)
				(TheMenuBar draw: state: 1)
				(SL enable:)
				(gEgo loop: 1 posn: 294 177)
			)
			(else
				(gEgo posn: 159 186 loop: 3)
			)
		)
		(gEgo init:)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (!= gEgoState 1)
			(gEgo
				observeControl: (& (gEgo onControl:) $1000)
				ignoreControl: (& (gEgo onControl:) $0020)
			)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			(
				(or
					(Said 'use,drop/keycard,card')
					(Said 'drop,stick,drop/keycard,card/door,hole')
					(Said 'drop,stick,drop//keycard,card')
					(Said 'unbolt,open/door')
				)
				(cond
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((not (gEgo has: 9)) ; Spa_Keycard
						(Print 360 0) ; "The doors here are all controlled by a keycard given to members only. Since you're not a member, you can't get in."
					)
					(
						(and
							(not
								(& (gEgo onControl:) (aLockerDoor doorCtrl:))
							)
							(not
								(& (gEgo onControl:) (aStudioDoor doorCtrl:))
							)
							(not (& (gEgo onControl:) $0020))
						)
						(NotClose) ; "You're not close enough."
					)
					((& (gEgo onControl:) $0020)
						(Print 360 1) ; "Hey!" shouts the man behind the counter, "You can't go in there! The tanning booth is out of order."
						(Print 360 2) ; "We'll get it fixed Real Soon Now."
					)
					((& (gEgo onControl:) (aLockerDoor doorCtrl:))
						(RoomScript changeState: 1)
					)
					((& (gEgo onControl:) (aStudioDoor doorCtrl:))
						(RoomScript changeState: 7)
					)
				)
			)
			((Said '/club,exercise,class,bell,booth,aerobic')
				(Print 360 3) ; "Fat City's facilities are available to members only."
			)
			((Said '/bookcase,buffet')
				(Print 360 4) ; "There are many items behind the counter that are totally uninteresting to you!"
			)
			((Said '/blender')
				(Print 360 5) ; "You don't have time for a drink now!"
			)
			((Said '/blouse')
				(Print 360 6) ; "You'd rather order a "Leisure Suit Larry 3" T-shirt from Sierra. Just call Sierra to order one!"
			)
			((Said 'get,get/soap')
				(Print 360 7) ; "There is no soap available here. You must bring your own!"
			)
			((Said 'look,look>')
				(cond
					((Said '/door')
						(cond
							((& (gEgo onControl:) (aLockerDoor doorCtrl:))
								(Print 360 8) ; "A small sign on the door says, "Locker Room.""
							)
							((& (gEgo onControl:) (aStudioDoor doorCtrl:))
								(Print 360 9) ; "A small sign on the door says, "Aerobics Studio.""
							)
							((& (gEgo onControl:) $0020)
								(Print 360 10) ; "A small sign on the door says, "Tanning Booth.""
							)
							(else
								(Print 360 11) ; "There are four doors here, one on each wall."
							)
						)
					)
					((Said '/awning,board,board,note,art')
						(Print 360 12) ; "The bulletin board is filled with advertisements for products you find totally uninspiring."
					)
					((Said '/man,robin,attendant,man,attendant')
						(if (gCast contains: aRobin)
							(Print 360 13) ; "Behind the counter you see a man."
						else
							(Print 360 14) ; "You don't see anyone."
						)
					)
					((Said '/buffet,buffet<behind,back,back,back')
						(if (gCast contains: aRobin)
							(Print 360 15) ; "There's a handsome young man behind the counter."
						else
							(Print 360 16) ; "Looking behind the counter you see..."
							(Print 360 17) ; "...nothing."
						)
					)
					((Said '/buffet,buffet')
						(if gEgoIsPatti
							(Print 360 18) ; "You see a counter."
						else
							(Print 360 19) ; "Robin stands behind the counter, totally bored, patiently counting the minutes until his shift ends."
						)
					)
					((Said '/burn')
						(Print 360 20) ; "You wouldn't think they'd need those lights turned on with a skylight that large!"
					)
					((Said '/board,board,bulletin,note,awning')
						(Print 360 21) ; "There is a bulletin board here filled with totally boring announcements."
					)
					((Said '/announcement')
						(Print 360 22) ; "blah, blah, blah"
					)
					((Said '[/club,club,area]')
						(Print 360 23) ; "You are inside the lobby of "Fat City," the island's newest and brightest health spa."
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 0)
			)
			(1
				(HandsOff)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 60 160 self
				)
			)
			(2
				(gEgo view: 715 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(3
				(NormalEgo)
				(HandsOff)
				(if (not (TestFlag 33))
					(SetFlag 33) ; beenIn360
					(gGame changeScore: 3)
					(Print 360 24 #icon 9 0 0) ; "You insert Suzi's keycard into the slot. The door opens automatically."
				)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 12 171 self
				)
				(aLockerDoor locked: 0 force: 1 open:)
			)
			(4
				(gEgo setMotion: MoveTo 0 171 self)
			)
			(5
				(aLockerDoor force: 1 close:)
				(gSoundFX number: 11 loop: 1 play:)
				(gEgo setMotion: MoveTo -20 171 self)
			)
			(6
				(gCurRoom newRoom: 370)
			)
			(7
				(HandsOff)
				(Ok) ; "O.K."
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 217 124 self
				)
			)
			(8
				(gEgo view: 715 setCel: 0 setLoop: 2 setCycle: End self)
			)
			(9
				(if (not (TestFlag 34))
					(SetFlag 34) ; beenIn395
					(gGame changeScore: 3)
					(Print 360 24 #icon 9 0 0) ; "You insert Suzi's keycard into the slot. The door opens automatically."
				)
				(NormalEgo)
				(HandsOff)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 197 118 self
				)
				(aStudioDoor locked: 0 force: 1 open:)
			)
			(10
				(gEgo setMotion: MoveTo 197 0)
			)
			(11
				(= cycles 10)
			)
			(12
				(aBambi setMotion: MoveTo 225 165 self)
				(= cycles 5)
			)
			(13
				(gEgo setMotion: MoveTo 225 165 self)
			)
			(14
				(Print 360 25) ; "Oh, Larry, I'm so excited about this..."
				(Print 360 26) ; "...new video idea of yours!"
				(aBambi setMotion: MoveTo 294 176)
			)
			(15
				(gEgo setMotion: MoveTo 280 179 self)
			)
			(16
				(aBambi cycleSpeed: 3 setLoop: 3 cel: 0 setCycle: End self)
			)
			(17
				(gGame changeScore: 3)
				(= cycles 10)
			)
			(18
				(aBambi setCycle: Beg)
				(aTanBoothDoor setCycle: End self)
			)
			(19
				(aTanBoothDoor stopUpd:)
				(= cycles 20)
			)
			(20
				(Print 360 27) ; "Come on, Larry," says Bambi, "Let's do a little `blocking!'"
				(= cycles 10)
			)
			(21
				(aBambi
					cycleSpeed: 0
					setCycle: Walk
					setLoop: 0
					setMotion: MoveTo 316 175 self
				)
			)
			(22
				(gEgo setMotion: MoveTo 333 174)
			)
		)
	)
)

(instance aRobin of Act
	(properties
		y 105
		x 133
		view 362
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self
			ignoreHorizon:
			ignoreActors:
			setPri: 10
			setCycle: Walk
			setScript: ManScript
		)
	)
)

(instance ManScript of Script
	(properties)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'talk,talk/man,robin,attendant,man,attendant')
				(cond
					(gEgoIsPatti
						(Print 360 28) ; "Where?"
					)
					((not (& (gEgo onControl:) $0080))
						(NotClose) ; "You're not close enough."
					)
					(else
						(ManScript changeState: 6 register: (++ messageCount))
					)
				)
			)
			((Said 'ask>')
				(cond
					(gEgoIsPatti
						(Print 360 28) ; "Where?"
					)
					((not (& (gEgo onControl:) $0080))
						(NotClose) ; "You're not close enough."
					)
					((or (Said '/door') (Said '//door'))
						(Print 360 29) ; ""What's the story on these locked doors, buddy?" you ask the clerk"
						(ManScript changeState: 6 register: 102)
					)
					(
						(or
							(Said '/keycard,camp,key,membership,card')
							(Said 'enroll')
							(Said '//keycard,key,camp,membership,card')
						)
						(Print 360 30) ; ""How can I get a membership in this place?" you ask."
						(ManScript changeState: 6 register: 104)
					)
					((or (Said '/bambi,tape') (Said '//tape,bambi'))
						(Print 360 31) ; ""Is this where I buy a copy of Bambi's video?" you ask the clerk."
						(ManScript changeState: 6 register: 106)
					)
					((or (Said '/locker') (Said '//locker'))
						(Print 360 32) ; "Hey, Robin! Where's my locker?"
						(ManScript changeState: 6 register: 108)
					)
					((or (Said '/combination') (Said '//combination'))
						(Print 360 33) ; "Hey, Robin! What's the combination to my locker?"
						(ManScript changeState: 6 register: 107)
					)
					(else
						(ManScript changeState: 6 register: 103)
					)
				)
				(event claimed: 1)
			)
			((Said 'show,show/keycard')
				(cond
					((not (gEgo has: 9)) ; Spa_Keycard
						(DontHave) ; "You don't have it."
						(event claimed: 1)
					)
					((not (& (gEgo onControl:) $0080))
						(NotClose) ; "You're not close enough."
					)
					(else
						(Print 360 34 #icon 9 0 0) ; "Here's my membership card," you tell the attendant. "May I please have all the rights and privileges pertaining thereto?"
						(ManScript changeState: 6 register: 101)
					)
				)
			)
			((Said 'give')
				(if (& (gEgo onControl:) $0080)
					(ManScript changeState: 6 register: 105)
				else
					(NotClose) ; "You're not close enough."
				)
			)
			((Said '/man,robin,attendant,man,attendant')
				(Print 360 35) ; "He seems pleasant enough, but none too bright."
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 4 8))
			)
			(1
				(aRobin
					illegalBits: 0
					cycleSpeed: 0
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo (Random 101 155) 105 self
				)
			)
			(2
				(= seconds (Random 1 3))
			)
			(4
				(aRobin setLoop: 3)
				(= seconds (Random 4 8))
				(= state -1)
			)
			(6
				(HandsOff)
				(= seconds 0)
				(aRobin setMotion: 0 setLoop: 2 setCycle: Fwd)
				(= seconds 3)
			)
			(7
				(aRobin setCel: 0)
				(switch register
					(1
						(Print 360 36) ; "Hello," says Robin "New in town?"
					)
					(2
						(Print 360 37) ; ""You certainly have an interesting way with clothes," insults the man behind the counter."
					)
					(3
						(Print 360 38) ; "Robin looks bored. "Do you have nothing better to do than stand here talking to me?""
					)
					(4
						(cond
							((< gNewspaperState 3)
								(Print 360 39) ; "Have you heard the news?" says the receptionist. "Passionate Patti is coming to the casino lounge."
							)
							((== gNewspaperState 3)
								(Print 360 40) ; "By the way," says Robin. "Have you had Passionate Patti too?"
							)
							(else
								(Print 360 41) ; "I'm sorry, but I haven't seen Larry Laffer."
							)
						)
					)
					(101
						(Print 360 42) ; "Robin looks at you and says, "Excuse me. I didn't recognize you, Ms. Cheatem! Just insert your card in the slot beside the door you wish to enter. And, `Have a Nice Day,' ok?""
					)
					(102
						(Print 360 43) ; ""The doors are locked and only open by keycards given to each of our members," says the attendant behind the counter."
					)
					(103
						(Print 360 44) ; "Excuse me, sir," you say, "may I ask you a question?"
						(Print 360 45) ; "Certainly," Robin replies. "What is it?"
					)
					(104
						(Print 360 46) ; "Our membership roster is full right now, but we'll be starting a big campaign next fall," Robin replies. "I'll call you, ok?"
					)
					(105
						(Print 360 47) ; "Thank you anyway, but I'm just here for atmosphere!"
					)
					(106
						(Print 360 48) ; "Not yet," replies Robin. "She's having a hell of a time getting it made."
					)
					(107
						(Print 360 49) ; "Robin replies, "I'm sorry, but due to security reasons, I'm not allowed to give combinations. You should have made a note of it when you received your membership card.""
					)
					(108
						(Print 360 50) ; "People expect me to do everything around here!" Robin whines. "How do you expect me to remember if you can't?"
					)
					(else
						(Print 360 51) ; ""How may I help you?" asks the clerk."
						(= messageCount 4)
					)
				)
				(= register 0)
				(HandsOn)
				(self changeState: 0)
			)
		)
	)
)

(instance aBambi of Act
	(properties
		y 126
		x 200
		view 393
		loop 2
	)

	(method (init)
		(super init:)
		(self ignoreHorizon: ignoreActors: illegalBits: 0 setCycle: Walk)
	)
)

(instance aTanBoothDoor of Prop
	(properties
		y 163
		x 296
		view 360
		loop 1
		cycleSpeed 2
	)
)

(instance aStudioDoor of Door
	(properties
		y 117
		x 199
		view 360
		loop 2
		entranceTo 390
		locked 1
		doorCtrl 8
		roomCtrl 16
		doorBlock 8192
	)
)

(instance aLockerDoor of Door
	(properties
		y 172
		x 11
		view 360
		entranceTo 370
		locked 1
		roomCtrl 0
	)
)

(instance atpRightCardHole of PV
	(properties
		y 165
		x 314
		view 360
		loop 3
		priority 14
	)
)

(instance atpLeftCardHole of PV
	(properties
		y 143
		x 43
		view 360
		loop 3
		cel 1
		priority 11
	)
)

(instance atpRearCardHole of PV
	(properties
		y 103
		x 224
		view 360
		loop 3
		cel 2
		priority 8
	)
)

(instance atpFatCity of PV
	(properties
		y 40
		x 129
		view 360
		loop 4
		priority 0
	)
)

(instance atpBboard of PV
	(properties
		y 134
		x 277
		view 360
		loop 4
		cel 1
		priority 9
	)
)

(instance atpShelves of PV
	(properties
		y 104
		x 131
		view 360
		loop 4
		cel 2
		priority 6
	)
)

(instance atpSumtin of PV
	(properties
		y 93
		x 170
		view 360
		loop 4
		cel 3
		priority 8
	)
)

(instance atpBlender of PV
	(properties
		y 109
		x 91
		view 360
		loop 4
		cel 4
		priority 9
	)
)

