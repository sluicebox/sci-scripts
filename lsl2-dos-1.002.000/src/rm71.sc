;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 71)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm71 0
)

(local
	stickHere
	aBigEgo
	aBigEgoFace
	aStick
	aSwarm
)

(instance theSound of Sound
	(properties)
)

(instance rm71 of Rm
	(properties
		picture 71
		horizon 5
		south 72
	)

	(method (init)
		(Load rsVIEW 105)
		(Load rsVIEW 173)
		(Load rsVIEW 702)
		(super init:)
		((= aSwarm (Act new:))
			view: 702
			setLoop: 0
			setCel: 0
			setPri: 14
			setCycle: Walk
			posn: 148 109
			illegalBits: 0
			ignoreActors:
			init:
		)
		(self setRegions: 700 setScript: rm71Script) ; rm700
		(if ((gInventory at: 28) ownedBy: gCurRoomNum) ; Stout_Stick
			(= stickHere 1)
			(Load rsVIEW 721)
			((= aStick (View new:))
				view: 721
				posn: 216 71
				ignoreActors:
				stopUpd:
				init:
			)
		)
		(if (== gPrevRoomNum 72)
			(theSound number: 3 init:)
			(NormalEgo)
			(gEgo posn: 142 185 init:)
		else
			(Load rsVIEW 171)
			(Load rsVIEW 110)
			(Load rsVIEW 114)
			(Load rsSOUND 1)
			(Load rsSOUND 2)
			(theSound number: 1 loop: 1 play:)
			((= aBigEgo (View new:))
				view: 110
				ignoreActors:
				setPri: 14
				posn: 243 1080
				init:
			)
			((= aBigEgoFace (Prop new:))
				view: 114
				ignoreActors:
				setPri: 15
				posn: 243 1080
				setCycle: Fwd
				init:
			)
			((gInventory at: 18) moveTo: -1) ; Soap
			(gEgo
				put: 10 -1 ; Onklunk
				put: 17 -1 ; Knife
				put: 7 -1 ; Passport
				put: 24 -1 ; Parachute
				put: 6 -1 ; Wad_O__Dough
				ignoreHorizon:
				illegalBits: 0
				view: 171
				setLoop: 0
				setCycle: Fwd
				setStep: 1 12
				setPri: 10
				posn: 193 -129
				init:
			)
			(HandsOff)
			(rm71Script changeState: 1)
			(= gCurrentStatus 12)
		)
	)
)

(instance rm71Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== state 2)
			(ShakeScreen 1 (Random 1 3))
		)
		(if (and (& (gEgo onControl:) $4000) (== gCurrentStatus 0))
			(self changeState: 7)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look<down')
			(Print 71 0) ; "The jungle floor is shrouded in darkness and covered with a viscous substance that you presume passes for dirt around here."
			(if stickHere
				(Print 71 1) ; "There is a stout stick lying under the tree. You feel fortunate you did not land on it!"
			)
		)
		(if (Said 'look>')
			(if (Said '/carpet,dirt')
				(Print 71 0) ; "The jungle floor is shrouded in darkness and covered with a viscous substance that you presume passes for dirt around here."
				(if stickHere
					(Print 71 1) ; "There is a stout stick lying under the tree. You feel fortunate you did not land on it!"
				)
			)
			(if (Said '/path')
				(Print 71 2) ; "There might be a way out of here near that bush."
			)
			(if (and stickHere (Said '/stick'))
				(Print 71 1) ; "There is a stout stick lying under the tree. You feel fortunate you did not land on it!"
			)
			(if (Said '/ear,art,lip')
				(Print 71 3) ; "It looks like a prehistoric Al Lowe!"
			)
			(if (Said '/bush')
				(Print 71 4) ; "There are some bees resting on that bush over there."
			)
			(if (Said '/bee')
				(Print 71 5) ; "The swarm of bees are just resting on a branch of a bush. You remember reading something about a new strain of bees from this area."
			)
			(if (Said '[/forest,palm,landscape,airport]')
				(Print 71 6) ; "It's like a jungle in here."
				(Print 71 7) ; "Could that be because you're stranded in the middle of a jungle on a tropical island?!"
				(Print 71 8) ; "The ground here is unusually spongy."
			)
		)
		(if (Said '(get<up),get/stick')
			(cond
				((!= gCurrentStatus 0)
					(NotNow) ; "Not now!"
				)
				((not stickHere)
					(AlreadyTook) ; "You already took it."
				)
				((not (gEgo inRect: 205 6 226 82))
					(NotClose) ; "You're not close enough."
				)
				(else
					(Ok) ; "Ok."
					(= stickHere 0)
					(gEgo get: 28) ; Stout_Stick
					(aStick hide:)
					(gGame changeScore: 4)
					(Print 71 9 #draw) ; "You can never tell when a nice, stout stick like this one will come in handy!"
				)
			)
		)
		(if
			(or
				(Said 'hit,caress,apply/bush,branch,bee/stick')
				(Said 'lagoon,burn,hit,get/bee,branch,bush,honey')
			)
			(Print 71 10) ; "You must be joking!"
		)
		(if
			(or
				(Said 'drain,burn,drop,apply/rejuvenator')
				(Said 'caress,lagoon,dig/carpet,hole,dirt,stick')
				(Said 'burn/bush')
			)
			(Print 71 11) ; "That wouldn't help."
		)
		(if (Said 'hop,(stair<over)')
			(Print 71 12) ; "Jumping won't help you now."
		)
		(if (Said 'crawl,(board<below)')
			(Print 71 13) ; "Good idea."
			(cond
				((& (gEgo onControl:) $0002)
					(self changeState: 16)
				)
				((& (gEgo onControl:) $0004)
					(self changeState: 20)
				)
				(else
					(Print 71 14) ; "But first, move a little closer to the bush."
				)
			)
		)
		(if (Said '/branch')
			(Print 71 15) ; "The trees can't help you here."
		)
		(if (Said 'climb/palm')
			(Print 71 16) ; "Nah, you'd just wind up out on a limb again!"
		)
		(if (Said 'climb')
			(Print 71 17) ; "That won't help here."
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(gEgo setMotion: MoveTo 193 80 self)
			)
			(2
				(gEgo
					setMotion: 0
					setStep: 3 2
					setLoop: 1
					cel: 0
					setCycle: End self
				)
			)
			(3
				(Print 71 18 #draw) ; "Unghhh!"
				(= seconds 3)
			)
			(4
				(aBigEgo posn: 143 80 stopUpd:)
				(aBigEgoFace posn: 143 80)
				(theSound dispose:)
				(theSound number: 2 play:)
				(= seconds 5)
			)
			(5
				(aBigEgoFace dispose:)
				(aBigEgo dispose:)
				(theSound dispose:)
				(gEgo setLoop: 2 cel: 0 setCycle: End self cycleSpeed: 2)
			)
			(6
				(Print 71 19 #draw) ; "A fall like that would be enough to break the average man's onklunk! Careful examination of yours reveals severe damage: the delicate instrument was smashed by the fall! You discard it here without learning of its dangerous cargo, nor realizing you have inadvertently kept the world's most valuable secret from falling into enemy hands!"
				(NormalEgo 2)
				(theSound number: 3 loop: -1)
			)
			(7
				(= gCurrentStatus 1000)
				(HandsOff)
				(gEgo illegalBits: 0)
				(Print 71 20) ; "Oops! You just brushed a bush containing a resting swarm of killer bees. You are frozen in fear! Could the rumors of their incredible strength really be true?"
				(aSwarm show: setCycle: End self)
				(theSound play:)
			)
			(8
				(aSwarm setLoop: 1 cel: 0 posn: 106 106 setCycle: CT 2 1 self)
			)
			(9
				(aSwarm setCycle: End self)
				(gEgo
					view: 173
					setLoop: 0
					cel: 0
					posn: 98 120
					setPri: 11
					setCycle: Fwd
				)
			)
			(10
				(aSwarm dispose:)
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
			)
			(11
				(gEgo setLoop: 2 setCycle: Fwd)
				(= seconds 3)
			)
			(12
				(gEgo setMotion: MoveTo 195 39 self)
			)
			(13
				(Print 71 21) ; "Yep."
				(gEgo setPri: 9 setMotion: MoveTo 333 3 self)
			)
			(14
				(Print 71 22) ; "Perhaps you'll enjoy your new life as the Queen Bee's personal love slave..."
				(= seconds 3)
			)
			(15
				(Print 71 23) ; "...nah. No way!"
				(theSound dispose:)
				(= gCurrentStatus 1001)
			)
			(16
				(Print 71 24) ; "You carefully lower yourself to the slimy ground and attempt to make your way past the dangerous swarm of killer bees!"
				(= gCurrentStatus 1012)
				(HandsOff)
				(gEgo
					illegalBits: 0
					view: 105
					setLoop: 2
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(17
				(gEgo
					moveSpeed: 1
					setLoop: 0
					setCycle: Walk
					setStep: 1 1
					setMotion: MoveTo 92 157 self
				)
			)
			(18
				(gEgo setLoop: 2 setCel: 255 setCycle: Beg self)
			)
			(19
				(NormalEgo 2)
				(if (> (++ gPastBees) 1)
					(Print 71 25 #draw) ; "You made it. Again!"
				else
					(Print 71 26 #draw) ; "You successfully avoid the dangerous killer bees."
					(gGame changeScore: 6)
				)
			)
			(20
				(Print 71 27 #draw) ; "Once again, you lower yourself to the jungle floor and hope you can slide your way below the dangerous swarm of killer bees!"
				(= gCurrentStatus 1012)
				(HandsOff)
				(gEgo
					illegalBits: 0
					view: 105
					setLoop: 3
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(21
				(gEgo
					moveSpeed: 1
					setLoop: 1
					setCycle: Walk
					setStep: 1 1
					setMotion: MoveTo 94 145 self
				)
			)
			(22
				(gEgo setLoop: 3 setCel: 255 setCycle: Beg self)
			)
			(23
				(NormalEgo 3)
				(Print 71 28 #draw) ; "He walks!"
				(Print 71 29) ; "He talks!"
				(Print 71 30) ; "He wriggles on his belly like a reptile!"
			)
		)
	)
)

