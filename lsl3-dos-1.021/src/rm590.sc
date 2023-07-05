;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 590)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm590 0
)

(local
	[string 88]
	[string2 22]
)

(instance rm590 of Rm
	(properties
		picture 590
	)

	(method (init)
		(Load rsVIEW 586)
		(Load rsVIEW 593)
		(Load rsVIEW 594)
		(Load rsSOUND 4)
		(Load rsSOUND 6)
		(Load rsSOUND 486)
		(Load rsPIC 99)
		(super init:)
		(gAddToPics add: atpRope doit:)
		(aLarry init:)
		(aCageBack init:)
		(aCageFront init:)
		(self setScript: RoomScript style: 7)
		((Inv at: 17) view: 33) ; Dress
		(= gNormalEgoView 801)
		(NormalEgo 0 592)
		(gEgo
			ignoreActors:
			illegalBits: 0
			setLoop: 0
			cel: 0
			setPri: 6
			posn: 174 110
			init:
		)
		(HandsOff)
	)
)

(instance RoomScript of Script
	(properties)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((or (Said 'draw,make/door') (Said 'draw,use/marker'))
				(if (not (gEgo has: 18)) ; Magic_Marker
					(Print 590 0) ; "You have nothing with which to aid your escape."
				else
					(self changeState: 23)
				)
			)
			((Said 'throw,make,use/magic,spell')
				(if (gEgo has: 18) ; Magic_Marker
					(Print 590 1) ; "Yes, that could work. But how?"
				else
					(Print 590 2) ; "Yes, that's the idea. But where could you find something magical?"
				)
			)
			((Said 'unfasten,grab,cut/hemp,bamboo')
				(Print 590 3) ; "You can't. The cage withstands your every attempt to escape."
			)
			((Said 'throw')
				(Print 590 4) ; "Throwing things won't help!"
			)
			((Said 'use')
				(Print 590 5) ; "What good would that do? You're trapped inside an unbreakable fortress of bamboo!"
			)
			((Said 'get')
				(Print 590 6) ; "There's nothing within reach that will help you."
			)
			((or (Said 'enjoy') (Said '/enjoy'))
				(Print 590 7) ; "You two will love each other until death; which appears to be only a few more minutes!"
			)
			((Said 'bend/bar')
				(Print 590 8) ; "You can't. You're only a weak piano player!"
			)
			((Said 'hit')
				(Print 590 9) ; "As hard as you hit the cage, it will not give!"
			)
			((Said 'throw,pull/cage')
				(Print 590 10) ; "It's just too massive. You'll need more than ordinary means to escape this cage!"
			)
			((Said 'look>')
				(cond
					((Said '/hemp')
						(Print 590 11) ; "A crude yet effective rope suspends the cage above the village cookpot."
					)
					((Said '/man,larry')
						(Print 590 12) ; "He's with you again. You've succeeded in your quest. But how will you ever honeymoon together?"
					)
					((and (gCast contains: aDoctor) (Said '/cannibal'))
						(Print 590 13) ; "How nice! She's invited you over for dinner!"
					)
					((Said '/camp')
						(Print 590 14) ; "In the distance, the villagers are preparing to have you for dinner -- literally!"
					)
					((Said '/cage,bar')
						(Print 590 15) ; "The cage is made of bamboo and leather with a door to the rear that is securely tied shut."
					)
					((Said '/dope')
						(Print 590 16) ; "Peering between the bamboo poles you see your future coming to a short boil."
					)
					((Said '/bamboo,cage')
						(Print 590 17) ; "This cage is so strong you'll never break out!"
					)
					((Said '[/area]')
						(Print 590 18) ; "At last, you are again with your Larry; but under such circumstances?!"
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: End)
				(aLarry setCycle: End)
				(= seconds 2)
			)
			(1
				(Print 590 19 #at 10 10 #width 140 #dispose) ; "LARRY! IT'S YOU!!"
				(Print 590 20 #at 170 10 #width 140) ; "PATTI! IT'S YOU!!"
				(cls)
				(gEgo setLoop: 1 setCycle: Fwd)
				(aLarry setLoop: 1 setCycle: Fwd)
				(= seconds 3)
			)
			(2
				(Print 590 21 #at 10 10 #width 140 #dispose) ; "Oh, Larry! I've missed you so!!"
				(Print 590 22 #at 170 10 #width 140) ; "Oh, Patti! I've missed you so!!"
				(cls)
				(gEgo setLoop: 2 cel: 0 setCycle: End self)
				(aLarry setLoop: 2 cel: 0 setCycle: End self)
			)
			(3)
			(4
				(gEgo view: 593 setLoop: 1 cel: 0 setCycle: End)
				(aLarry hide:)
				(= seconds 4)
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(gEgo view: 592 setLoop: 2 setCel: 255 setCycle: Beg self)
				(aLarry
					view: 591
					setLoop: 2
					setCel: 255
					setCycle: Beg self
					show:
				)
			)
			(7)
			(8
				(gEgo setLoop: 1 setCycle: Fwd)
				(aLarry setLoop: 1 setCycle: Fwd)
				(= seconds 3)
			)
			(9
				(gEgo setCel: 0)
				(aLarry setCel: 0)
				(gMusic fade:)
				(Print 590 23 #at 10 5 #width 290) ; "Oh, Larry, I just couldn't believe you left! You can't believe how it felt: to have finally found a perfect match and then to have you disappear into thin air! I awakened to an empty bed, rushed to the balcony, and saw you disappear through that horrible bamboo forest, so I started out after you. And I found you!! We're together again, at last, and this time, to stay!"
				(gMusic number: 486 loop: -1 play:)
				(Print 590 24 #at -1 10) ; "But, tell me, Larry: why did you go? Whatever caused you to leave like that?"
				(Print 590 25 #at 10 5 #width 290) ; "You. You did, Patti. After the most fantastic night of my life, just as I was drifting away into a blissful sleep, I heard you murmur one word, `Arnold!' Why, Patti? If I'm so special, why would you speak someone else's name? Weren't you thinking of him while we made love?"
				(Print 590 26 #at 10 5 #width 290) ; "Oh, Larry, you wonderful, fragile fool! I was thinking of him because I was trying to figure out how to tell him I was going to leave him for you!!"
				(Print 590 27 #at 10 5 #width 290) ; "Patti! I am a fool. But what's the difference? At last we understand: we both feel the same for each other. We'll be together for the rest of our lives!"
				(Print 590 28 #at 10 5 #width 290) ; "Speaking of which, you did come here to rescue me, didn't you? You do have some sort of plan, don't you? You didn't travel all this way just so you could join me for dinner -- in their stomachs, did you?!!"
				(Print 590 29 #at -1 10) ; "Er, uh, well, just a minute," you stall, "I'm sure I'll think of something!"
				(Print 590 30 #at -1 10) ; "You'd better think fast," Larry responds, "I think these gals have got something cooking... and it's gonna be us!"
				(User canInput: 1)
				(= seconds 15)
			)
			(10
				(gMusic number: 6 loop: -1 play:)
				(aDoctor init: setCycle: End self)
			)
			(11
				(aDoctor cycleSpeed: 0 setLoop: 2 setCycle: Fwd)
				(= cycles 33)
			)
			(12
				(Print 590 31 #at -1 10) ; "LARRY! LOOK!!" you cry. "What's that witch doctor doing?!"
				(= cycles 33)
			)
			(13
				(aDoctor setLoop: 1)
				(= cycles 33)
			)
			(14
				(aDoctor setLoop: 2)
				(aBubblesFront init:)
				(= cycles 33)
			)
			(15
				(HandsOff)
				(Print 590 32 #at -1 10) ; "That's it! We're finished!!"
				(gEgo
					view: 593
					cycleSpeed: 3
					setLoop: 2
					cel: 0
					setCycle: End self
				)
				(aLarry hide:)
			)
			(16
				(aBubblesFront setLoop: 3)
				(= seconds 3)
			)
			(17
				(aBubblesFront setLoop: 5)
				(aBubblesRear init:)
				(gEgo view: 593 setLoop: 3 cel: 0 setCycle: End self)
			)
			(18
				(gEgo posn: 164 114 setLoop: 0 setPri: 13)
				(aCageFront hide:)
				(aCageBack hide:)
				(= seconds 3)
			)
			(19
				(aLarry
					posn: 163 53
					view: 590
					setLoop: 6
					setMotion: MoveTo 163 199
					setPri: 14
					show:
				)
				(gEgo cycleSpeed: 0 setMotion: MoveTo 164 161 self)
			)
			(20
				(gEgo setMotion: MoveTo 164 231)
				(aDoctor setLoop: 0 setCel: 255 cycleSpeed: 1 setCycle: Beg)
				(= seconds 5)
			)
			(21
				(aDoctor hide:)
				(gGame setScript: (ScriptID 40)) ; DyingScript
				((ScriptID 40) ; DyingScript
					caller: 595
					register: (Format @string 590 33) ; "Mark my words, Patti: sometimes you must fight magic with magic!"
					next: (Format @string2 590 34) ; "Boy, are you two stewed!"
				)
			)
			(22)
			(23
				(HandsOff)
				(Ok) ; "O.K."
				(gGame changeScore: 500)
				(Print 590 35 #at 10 5 #width 290) ; "Larry, I don't know if this will work or not, but the only thing I can think of is this `Magic' marking pen I picked up back at the lounge. Let me see if I can draw us a way out of this mess!"
				(aLarry loop: 1 cel: 0 stopUpd:)
				(= cycles (= seconds 0))
				(gEgo
					cycleSpeed: 1
					view: 594
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(24
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
			)
			(25
				(gEgo setLoop: 2 cel: 0 setCycle: End self)
			)
			(26
				(aBubblesFront
					init:
					view: 594
					setLoop: 5
					cel: 0
					cycleSpeed: 0
					setPri: 8
					posn: 169 72
					setCycle: Fwd
				)
				(gEgo setCycle: Beg self)
			)
			(27
				(gEgo setLoop: 3 cel: 0 setCycle: End self)
			)
			(28
				(aBubblesRear
					init:
					view: 594
					setLoop: 6
					cel: 0
					cycleSpeed: 1
					setPri: 5
					posn: 169 72
					setCycle: End self
				)
				(gEgo setCycle: Beg self)
			)
			(29)
			(30
				(aBubblesRear stopUpd:)
				(gEgo setLoop: 1 setCel: 255 setCycle: Beg)
				(= seconds 3)
			)
			(31
				(Print 590 36 #at 10 5 #width 290) ; "PATTI! You did it. At least, you did something. What is that? A magic door?"
				(Print 590 37 #at 10 5 #width 290) ; "I don't know, Larry, but from the looks of things hereabouts, I don't want to stay around here. Come on, let's get out of here!"
				(= cycles 22)
			)
			(32
				(Print 590 38 #at 10 5 #width 290) ; "I'm right behind you, honey," Larry responds. "See you on the other side!"
				(= cycles 22)
			)
			(33
				(gEgo hide:)
				(aBubblesRear
					cycleSpeed: 1
					setLoop: 4
					cel: 0
					setCycle: End self
				)
			)
			(34
				(Format @string 590 39 gExpletive) ; "%s"
				(Print @string #at -1 10)
				(gSoundFX number: 4 loop: 1 play:)
				(Print 590 40 #at -1 10) ; "PATTI!"
				(= cycles 11)
			)
			(35
				(aLarry
					cycleSpeed: 0
					moveSpeed: 0
					view: 594
					setLoop: 7
					cel: 0
					setCycle: Fwd
					setStep: 2 2
					setPri: 10
					posn: 188 104
					setMotion: MoveTo 156 104 self
				)
			)
			(36
				(aLarry hide:)
				(aBubblesRear view: 594 setLoop: 8 cel: 0 setCycle: End self)
			)
			(37
				(gMusic stop:)
				(gSoundFX number: 4 loop: 1 play:)
				(aBubblesRear setLoop: 6 setCel: 255 setCycle: Beg self)
			)
			(38
				(aBubblesFront hide:)
				(= cycles 22)
			)
			(39
				(gCurRoom drawPic: 99 6)
				(gCast eachElementDo: #hide)
				(= seconds 3)
			)
			(40
				(gCurRoom newRoom: 600)
			)
		)
	)
)

(instance atpRope of PV
	(properties
		y 53
		x 163
		view 590
		loop 6
		priority 2
		signal 16384
	)
)

(instance aCageFront of View
	(properties
		y 114
		x 164
		view 590
		loop 1
	)

	(method (init)
		(super init:)
		(self setPri: 12 ignoreActors: stopUpd:)
	)
)

(instance aCageBack of View
	(properties
		y 114
		x 164
		view 590
	)

	(method (init)
		(super init:)
		(self ignoreActors: setPri: 4 stopUpd:)
	)
)

(instance aBubblesFront of Prop
	(properties
		y 160
		x 203
		view 590
		loop 2
	)

	(method (init)
		(super init:)
		(self setPri: 15 setCycle: Fwd ignoreActors:)
	)
)

(instance aBubblesRear of Prop
	(properties
		y 160
		x 203
		view 590
		loop 4
	)

	(method (init)
		(super init:)
		(self setPri: 9 setCycle: Fwd ignoreActors:)
	)
)

(instance aLarry of Act
	(properties
		y 110
		x 173
		view 591
	)

	(method (init)
		(super init:)
		(self setPri: 10 illegalBits: 0 ignoreActors:)
	)
)

(instance aDoctor of Prop
	(properties
		y 72
		x 288
		view 586
		cycleSpeed 1
	)
)

