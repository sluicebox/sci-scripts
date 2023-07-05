;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50)
(include sci.sh)
(use Main)
(use Door)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm50 0
)

(local
	currentHench
	seenMessage
	henchStatus
	aDoor
	aRadar
	aHench1
	aHench2
)

(instance theSound of Sound
	(properties
		number 117
		loop -1
	)
)

(instance rm50 of Rm
	(properties
		picture 50
		horizon 1
	)

	(method (init)
		(Load rsVIEW 500)
		(Load rsVIEW 501)
		(Load rsVIEW 502)
		(super init:)
		((View new:) view: 500 loop: 0 cel: 0 posn: 155 62 setPri: 2 addToPic:)
		((View new:) view: 500 loop: 0 cel: 1 posn: 11 63 setPri: 3 addToPic:)
		((View new:) view: 500 loop: 0 cel: 2 posn: 308 62 setPri: 2 addToPic:)
		((= aRadar (Prop new:))
			view: 500
			setLoop: 2
			setPri: 0
			posn: 285 2
			cycleSpeed: 1
			setCycle: Fwd
			isExtra: 1
			init:
		)
		(= currentHench 0)
		(if (== gForceAtest 1)
			(= gCurrentEgoView 151)
		)
		(NormalEgo)
		(if (== gPrevRoomNum 52)
			(gEgo posn: 159 121)
		else
			(gEgo posn: 159 185)
		)
		(gEgo init:)
		((= aDoor (AutoDoor new:))
			view: 500
			setLoop: 1
			posn: 160 122
			setPri: 8
			entranceTo: 52
			doorCtrl: 2
			doorBlock: 16384
			roomCtrl: 4
			msgLook:
				{Inside you see lines of businessmen waiting to buy tickets.}
			init:
		)
		(self setRegions: 500 setScript: rm50Script) ; rm500
		(if (== gCurrentEgoView 151)
			(= gCurrentStatus 1000)
			(= henchStatus 0)
			(= currentHench 1)
			((= aHench1 (Act new:))
				view: 501
				loop: 2
				posn: 22 164
				illegalBits: -32768
				setStep: 4 3
				init:
				setAvoider: (Avoid new:)
			)
			((= aHench2 (Act new:))
				view: 502
				loop: 2
				posn: 298 164
				illegalBits: -32768
				setStep: 4 3
				stopUpd:
				init:
				setAvoider: (Avoid new:)
			)
		else
			((View new:) view: 501 loop: 2 posn: 22 164 addToPic:)
			((View new:) view: 502 loop: 2 posn: 298 164 addToPic:)
			(if (!= gConfusedKrishnas 1)
				(= henchStatus 0)
				(= currentHench 2)
				(Load rsVIEW 503)
				(Load rsVIEW 504)
				(Load rsVIEW 20)
				(Load rsSOUND 117)
				(theSound play:)
				((= aHench1 (Act new:))
					view: 503
					setLoop: 2
					posn: 141 125
					illegalBits: -32768
					setCycle: Fwd
					init:
					setAvoider: (Avoid new:)
				)
				((= aHench2 (Act new:))
					view: 504
					setLoop: 2
					posn: 181 125
					illegalBits: -32768
					setCycle: Fwd
					init:
					setAvoider: (Avoid new:)
				)
				(aBigFace
					view: 503
					setLoop: 6
					posn: 160 1054
					setPri: 15
					setCycle: Fwd
					init:
				)
			)
		)
		(if currentHench
			(aDoor locked: 1)
		)
	)
)

(instance rm50Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((and (== henchStatus 0) (== currentHench 1) (> 180 (gEgo y:)))
				(= henchStatus 1)
				(aHench1 setScript: (copScript new:))
				(aHench2 setScript: (copScript new:))
				(Print 50 0 #at -1 20) ; "HALT," cries the military policeman, "or I'll shoot!!"
			)
			((and (== henchStatus 0) (== currentHench 2) (& (gEgo onControl:) $0002))
				(= henchStatus 1)
				(aHench1 setScript: (krishnaScript new:))
				(aHench2 setScript: (krishnaScript new:))
			)
			((& (gEgo onControl:) $0008)
				(if (== seenMessage 0)
					(= seenMessage 1)
					(Print 50 1) ; "Have you forgotten your vow already? You swore you'd never go that way again!"
				)
			)
			(else
				(= seenMessage 0)
			)
		)
	)

	(method (handleEvent event &tmp obj)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'look>')
				(cond
					((Said '/man')
						(cond
							((== currentHench 2)
								(Print 50 2) ; "There are several men here: two airport security guards and two "other.""
							)
							((== currentHench 1)
								(Print 50 3) ; "These airport policemen look capable of almost anything... except intelligent thought!"
							)
							(else
								(Print 50 4) ; "The guards are as silent as statues."
							)
						)
					)
					((Said '/cult,different')
						(if (== currentHench 2)
							(aBigFace posn: 160 54)
							(Timer setReal: aBigFace 5)
							(HandsOff)
						else
							(Print 50 5) ; "Where?"
						)
					)
					((Said '/cop')
						(if (== currentHench 1)
							(Print 50 3) ; "These airport policemen look capable of almost anything... except intelligent thought!"
						else
							(Print 50 4) ; "The guards are as silent as statues."
						)
					)
					((Said '[/airport,building]')
						(Print 50 6) ; "At last, you've reach the resort airport, and... what a disappointment."
						(Print 50 7) ; "There are two security guards patrolling here."
						(if (!= gConfusedKrishnas 1)
							(Print 50 8) ; "Near the door, there are two men wearing robes."
						)
					)
				)
			)
			((Said 'talk>')
				(cond
					((Said '/man')
						(cond
							((== currentHench 2)
								(Print 50 2) ; "There are several men here: two airport security guards and two "other.""
							)
							((== currentHench 1)
								(Print 50 3) ; "These airport policemen look capable of almost anything... except intelligent thought!"
							)
							(else
								(Print 50 4) ; "The guards are as silent as statues."
							)
						)
					)
					((Said '/cult,different')
						(if (== currentHench 2)
							(Print 50 9) ; "Hey, flower child," you shout, "don't you love my long hair?"
							(Print 50 10) ; "They respond, "Hmmmmmmmmmmmmm.""
						else
							(Print 50 5) ; "Where?"
						)
					)
					((Said '/cop')
						(cond
							((== currentHench 1)
								(Print 50 11) ; "Oh, officer!" you yell. "How do you like men in bikinis?"
							)
							(
								(or
									(gEgo inRect: 9 156 46 183)
									(gEgo inRect: 273 156 312 183)
								)
								(Print 50 12) ; "Say, can you tell me how to buy an airline ticket?" you ask him. "Does that line never end?"
								(Print 50 13) ; "Believing this to be an audition for duty at Buckingham Palace, he stares back at you with no response."
							)
							(else
								(NotClose) ; "You're not close enough."
							)
						)
					)
				)
			)
			((Said 'wear,alter,(get<off),drain,(drop<on)/job,bra,bra,bikini')
				(Print 50 14) ; "You can't change here! You should have thought of that earlier."
			)
			((Said 'play/music,onklunk')
				(Print 50 15) ; ""Want to hear a favorite from the Peruvian Top 40?" you ask them."
				(Print 50 16) ; "Evidently not, as there is no response!"
			)
			((Said 'give,throw,bribe,finger,drop,buy,buy,drop>')
				(= obj (gInventory saidMe:))
				(cond
					((!= gCurrentStatus 0)
						(NotNow) ; "Not now!"
					)
					(
						(or
							(not obj)
							(not (gEgo has: (gInventory indexOf: obj)))
						)
						(event claimed: 0)
					)
					(
						(and
							(!= gConfusedKrishnas 1)
							(< 25 (gEgo distanceTo: aHench1))
							(< 25 (gEgo distanceTo: aHench2))
						)
						(NotClose) ; "You're not close enough."
					)
					((== (gInventory indexOf: obj) 6)
						(Print 50 17) ; "They're not interested in your money. Be more creative."
					)
					((!= (gInventory indexOf: obj) 20)
						(Print 50 18) ; "They're not interested in that."
					)
					(else
						(Ok) ; "Ok."
						(self changeState: 2)
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (++ gTimesInRm50) 1)
					(= cycles 5)
				else
					(= seconds (Random 3 12))
				)
			)
			(1
				(switch gTimesInRm50
					(1
						(Print 50 19) ; "Boy are you happy to have made it past those cliffs. You swear never to return THAT way!"
					)
					(2
						(Print 50 20) ; ""Mr. Skirvin. White courtesy phone, please," says the PA announcer."
					)
					(3
						(Print 50 21) ; ""Paging Ms. Borucki; Ms. Bonnie Barucki, please," booms over the PA system."
					)
					(4
						(Print 50 22) ; "Mr. Herring; your prescription is ready!"
					)
					(else
						(Print 50 23) ; "The white zone is for passenger loading and unloading only."
					)
				)
			)
			(2
				(= currentHench 0)
				(= henchStatus 4)
				(= gConfusedKrishnas 1)
				(theSound stop:)
				(aHench1 setCel: 0)
				(aHench2 setCel: 0)
				(HandsOff)
				(Print 50 24 #at -1 20 #draw #icon 20 0 0) ; "Here, my little flower child," you tell the KGBishna, "make love, not money!!"
				(gEgo put: 20 -1) ; Flower
				(= seconds 3)
			)
			(3
				(aHench1
					illegalBits: 0
					setCycle: Walk
					setLoop: 5
					setMotion: MoveTo 333 (aHench1 y:)
				)
				(aHench2
					illegalBits: 0
					setCycle: Walk
					setLoop: 5
					setMotion: MoveTo 333 (aHench2 y:) self
				)
				(Print 50 25 #icon 504 2 0 #at -1 20 #draw #dispose) ; "This so confuses the KGBishna agents that they stumble off towards the native rental car agencies, contemplating the beauty of a single flower and their navels!"
				(gGame changeScore: 7)
				(aDoor locked: 0)
			)
			(4
				(cls)
				(Print 50 26 #at -1 152 #draw) ; "(Nice going, Larry. You've succeeded in bypassing the KGBers again!)"
				(User canControl: 1 canInput: 1)
			)
		)
	)
)

(instance copScript of Script
	(properties)

	(method (changeState newState &tmp tmpX tmpY)
		(switch (= state newState)
			(0
				(client
					setLoop: -1
					setMotion: Chase gEgo 11 self
					setCycle: Walk
				)
				(HandsOff)
			)
			(1
				(if (== henchStatus 1)
					(Print 50 27 #at -1 20) ; "All right, you pervert!" cries the MP. "We've got laws against people like you! We don't want no cross- dressers hanging around our airport!"
					(= gCurrentStatus 1000)
					(= henchStatus 2)
					(= tmpY (- (gEgo y:) 1))
					(if (< (gEgo x:) (client x:))
						(= tmpX (+ (gEgo x:) 19))
					else
						(= tmpX (- (gEgo x:) 19))
					)
					(client ignoreActors: posn: tmpX tmpY)
					(gEgo
						setMotion: 0
						setLoop: (if (> tmpX (gEgo x:)) 0 else 1)
						ignoreActors:
						stopUpd:
					)
					(= seconds 3)
				)
			)
			(2
				(Print 50 28) ; "Next time, you'd better dress a little more formally for a visit to the airport, Larry!"
				(= gCurrentStatus 1001)
			)
		)
	)
)

(instance krishnaScript of Script
	(properties)

	(method (changeState newState &tmp tmpX tmpY)
		(switch (= state newState)
			(0
				(client
					setLoop: -1
					setMotion: Chase gEgo 11 self
					setCycle: Walk
				)
				(HandsOff)
			)
			(1
				(if (== henchStatus 1)
					(= gCurrentStatus 1000)
					(= henchStatus 2)
					(HandsOff)
					(= tmpY (- (gEgo y:) 2))
					(if (< (gEgo x:) (client x:))
						(= tmpX (+ (gEgo x:) 9))
					else
						(= tmpX (- (gEgo x:) 9))
					)
					(client
						loop: (+ 3 (client loop:))
						cel: 0
						ignoreActors:
						posn: tmpX tmpY
						setCycle: End self
						setStep: 4 3
					)
					(gEgo
						setLoop: (if (> tmpX (gEgo x:)) 0 else 1)
						stopUpd:
					)
					(Print 50 29 #at -1 20 #draw) ; "Hmmmmmmmmmmmmmmm," chants the strangely dressed KGB agent, "have we got a cult for you!!"
				)
			)
			(2
				(Print 50 30 #draw) ; "If only you could offer them some token of peace and beauty!"
				(Print 50 31 #at -1 20 #draw) ; "Once again you've allowed the KGB agents to recognize and capture you. Now we'll run by their place to see some of the fun things that you'll get to enjoy..."
				(= gCurrentStatus 23)
				(gCurRoom newRoom: 96)
			)
		)
	)
)

(instance aBigFace of Prop
	(properties)

	(method (cue)
		(Print 50 32 #draw) ; "You find women sexy."
		(Print 50 33 #at -1 152) ; "(But what is this?!)"
		(self posn: 160 1054)
		(HandsOn)
	)
)

