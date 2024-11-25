;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm22 0
)

(local
	work
	henchHere
	aSpudsSign1
	aSpudsSign2
	aSpudsSign3
	aBoat
	aHench
	aStars
)

(instance rm22 of Rm
	(properties
		picture 22
		horizon 127
		north 18
		south 25
		west 21
	)

	(method (init)
		(Load rsVIEW 252)
		(Load rsVIEW 235)
		(super init:)
		((View new:) view: 252 loop: 1 cel: 1 posn: 287 77 setPri: 4 addToPic:)
		((View new:)
			view: 252
			loop: 1
			cel: 2
			posn: 64 143
			setPri: 10
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 252
			loop: 1
			cel: 3
			posn: 188 152
			setPri: 0
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 252
			loop: 1
			posn: 284 89
			setPri: 5
			ignoreActors:
			addToPic:
		)
		((View new:) view: 235 posn: 63 149 setPri: 11 addToPic:)
		((View new:) view: 235 loop: 1 posn: 182 157 setPri: 11 addToPic:)
		((View new:) view: 252 loop: 2 posn: 54 85 setPri: 12 addToPic:)
		((= aSpudsSign1 (Prop new:))
			view: 252
			setLoop: 3
			setPri: 12
			posn: 32 84
			cycleSpeed: 4
			setCycle: Fwd
			init:
		)
		((= aSpudsSign2 (Prop new:))
			view: 252
			setLoop: 4
			setPri: 12
			posn: 77 84
			cycleSpeed: 4
			setCycle: Fwd
			init:
		)
		((= aSpudsSign3 (Prop new:))
			view: 252
			setLoop: 5
			setPri: 12
			posn: 54 94
			cycleSpeed: 4
			setCycle: Fwd
			init:
		)
		((= aBoat (Act new:))
			view: 252
			setLoop: 0
			setPri: 7
			illegalBits: 0
			ignoreActors:
			ignoreHorizon:
			posn: 249 107
			setCycle: Fwd
			init:
			moveSpeed: 1
			cycleSpeed: 1
			setStep: 1 1
			setScript: boatScript
		)
		(self setRegions: 200 setScript: rm22Script) ; rm200
		(if (gEgo has: 10) ; Onklunk
			(= henchHere 1)
			(rm22Script changeState: 1)
			(Load rsVIEW 102)
			(Load rsVIEW 234)
			(Load rsSOUND 106)
			(theSound init:)
			((= aHench (Act new:))
				view: 234
				posn: -11 175
				illegalBits: $8000
				setCycle: Walk
				init:
				hide:
			)
			((= aStars (Prop new:))
				view: 102
				setLoop: 6
				setCycle: Fwd
				setPri: 13
				ignoreActors:
				init:
				hide:
			)
		)
		(cond
			((== gPrevRoomNum 0)
				(gEgo posn: 302 188)
			)
			((== gPrevRoomNum 18)
				(gEgo posn: 258 129)
			)
			((== gPrevRoomNum 26)
				(gEgo posn: 302 188)
			)
		)
		(NormalEgo)
		(gEgo init:)
	)
)

(instance rm22Script of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (== state 3)
			(if (or (Said 'yes') (Said 'get/drink'))
				(if (< (gEgo y:) 162)
					(NotClose) ; "You're not close enough."
				else
					(Print 22 0) ; "Sure," you reply, "always time for a little nip with some seedy-looking stranger!"
					(self changeState: 4)
				)
			)
			(if (or (Said 'no') (Said 'barrel/drink'))
				(Print 22 1) ; "Thanks anyway, buster, but I'm on the wagon."
			)
			(if (Said 'talk/man')
				(if (Random 0 1)
					(Print 22 2) ; ""That's some breath you're packing, buddy," you say."
				else
					(Print 22 3) ; ""Do you have a license for that breath of yours?" you ask him."
				)
				(Print 22 4) ; "He ignores you, "How 'bout a little nip?""
			)
		)
		(if (Said 'bang,open/door')
			(Print 22 5) ; "The doors are barred shut, as this is a seedy part of town. In fact, you probably shouldn't be walking around here!"
		)
		(if (Said 'look>')
			(if (Said '/man')
				(if (not henchHere)
					(Print 22 6) ; "They're just a couple of guys who can't say no."
				else
					(Print 22 7) ; "He looks friendly enough, for a scum-sucking gutter snipe!"
				)
			)
			(if (Said '/door')
				(Print 22 8) ; "This place will remain closed until this game goes into night mode."
			)
			(if (Said '/barrel,carpet,freeway')
				(Print 22 9) ; "This part of town is not as well-maintained as it should be."
			)
			(if (Said '/cup')
				(Print 22 10) ; "There's nothing inside."
			)
			(if (Said '/lagoon,beach,water,lagoon')
				(Print 22 11) ; "The ocean waves, and the dock "piers" back at you."
			)
			(if (Said '/craft,boat')
				(Print 22 12) ; "Yep. That's what's out there!"
			)
			(if (Said '/sign')
				(Print 22 13) ; "Aren't you tired of seeing that dog everywhere!"
			)
			(if (Said '[/building,building,airport]')
				(Print 22 14) ; "You are now in a very seedy portion of the city."
				(Print 22 15) ; "In the distance you can see those famous L. A. landmarks: the "Queen Larry" and the "Loose Goose.""
			)
		)
		(if (Said '/door,bar')
			(Print 22 8) ; "This place will remain closed until this game goes into night mode."
		)
		(if (Said '/man>')
			(cond
				((Said 'talk/')
					(Print 22 16) ; "There's no need. These guys are too gone to hear you!"
				)
				((Said '(stair<over),pull,awaken/')
					(Print 22 17) ; "Why bother? This bar is off limits."
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(= seconds (Random 3 5))
			)
			(2
				(aHench show: setMotion: MoveTo 127 175 self)
				(theSound play:)
			)
			(3
				(aHench setLoop: (if (< (aHench x:) (gEgo x:)) 0 else 1))
				(Print 22 18 #draw) ; "Hey, sonny," says the old man, "wouldja like a hit ah the 'bird?"
			)
			(4
				(HandsOff)
				(= gCurrentStatus 1000)
				(if (< (aHench x:) (gEgo x:))
					(gEgo
						setAvoider: Avoid
						ignoreActors:
						setMotion:
							MoveTo
							(+ (aHench x:) 20)
							(+ 1 (aHench y:))
							self
					)
				else
					(gEgo
						setAvoider: Avoid
						ignoreActors:
						setMotion:
							MoveTo
							(- (aHench x:) 20)
							(+ 1 (aHench y:))
							self
					)
				)
			)
			(5
				(gEgo
					view: 102
					setLoop: (if (< (aHench x:) (gEgo x:)) 1 else 0)
					cel: 0
					setCycle: End self
				)
				(= work (if (< (aHench x:) (gEgo x:)) 0 else 1))
				(aHench setLoop: (+ 2 work) setCycle: End)
			)
			(6
				(aHench stopUpd:)
				(gEgo
					setLoop: (+ 2 (gEgo loop:))
					cel: 0
					setCycle: End self
				)
			)
			(7
				(= seconds 3)
			)
			(8
				(Print 22 19) ; "Say! This really hits the spot. Nothing like a good, hard, snort to perk up an adventurer's spirits."
				(= seconds 3)
			)
			(9
				(gEgo setCycle: CT 3 -1 self)
			)
			(10
				(gEgo setCycle: End self)
			)
			(11
				(Print 22 20) ; "A little more couldn't hurt..."
				(= seconds 3)
			)
			(12
				(gEgo
					setLoop: (+ 2 (gEgo loop:))
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(13
				(Print 22 21 #at -1 123) ; "(THUMP!)"
				(= seconds 3)
			)
			(14
				(if (== (gEgo loop:) 4)
					(= work (- (gEgo x:) 3))
				else
					(= work (+ (gEgo x:) 4))
				)
				(aStars posn: work (- (gEgo y:) 19) show:)
				(= seconds 5)
			)
			(15
				(Print 22 22) ; "Gotcha, you scurvy dog!" cries the cleverly disguised KGB agent. "Now, let's go to my place (and not for a drink)!"
				(Print 22 23) ; "These guys are playing for keeps, Larry. You'd better be more careful if you're going to hang onto your onklunk!"
				(= gCurrentStatus 23)
				(gCurRoom newRoom: 96)
			)
		)
	)
)

(instance boatScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 15))
			)
			(1
				(aBoat setMotion: MoveTo 333 107 self)
			)
			(2
				(aBoat hide:)
			)
		)
	)
)

(instance theSound of Sound
	(properties
		number 106
	)
)

