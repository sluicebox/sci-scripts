;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 78)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm78 0
)

(local
	aWoodchopper
	pauseCycles
	aHulaHooper
	aDancer
	aPhotographer
	aDrummer
	aPedaler
	aDoctor
	aChief
	aMouth
	aKalalau
	aCameraman
	aCupidWest
	aCupidEast
	aHeart
	aFlash
)

(instance rm78 of Rm
	(properties
		picture 78
		horizon 5
		west 77
	)

	(method (init)
		(if (== gIslandStatus 105)
			(self style: 8)
		)
		(super init:)
		(NormalEgo)
		(gEgo posn: 9 134 init:)
		(self setScript: rm78Script)
		(if gForceAtest
			(= gIslandStatus 105)
		)
		(if (!= gIslandStatus 105)
			(self setRegions: 700) ; rm700
			(Load rsVIEW 716)
			((= aWoodchopper (Prop new:))
				view: 716
				posn: 55 103
				cycleSpeed: 1
				init:
				setScript: woodScript
			)
		else
			(HandsOff)
			(rm78Script changeState: 1)
			(Load rsVIEW 833)
			(Load rsVIEW 212)
			(Load rsVIEW 711)
			(Load rsVIEW 710)
			(Load rsVIEW 714)
			(Load rsVIEW 713)
			(Load rsVIEW 707)
			(Load rsVIEW 704)
			(Load rsVIEW 706)
			(Load rsVIEW 822)
			(Load rsVIEW 823)
			(Load rsSOUND 111)
			(theSound init:)
			((View new:)
				view: 833
				ignoreActors:
				loop: 0
				setCel: 255
				posn: 90 123
				addToPic:
			)
			((View new:)
				view: 833
				ignoreActors:
				loop: 1
				setCel: 255
				posn: 105 120
				addToPic:
			)
			((View new:)
				view: 833
				ignoreActors:
				loop: 2
				setCel: 255
				posn: 120 117
				addToPic:
			)
			((View new:)
				view: 833
				ignoreActors:
				loop: 3
				setCel: 255
				posn: 135 114
				addToPic:
			)
			((View new:)
				view: 714
				ignoreActors:
				loop: 3
				cel: 1
				posn: 67 106
				addToPic:
			)
			((View new:)
				view: 714
				ignoreActors:
				loop: 2
				cel: 1
				posn: 206 117
				addToPic:
			)
			((View new:)
				view: 714
				ignoreActors:
				loop: 3
				cel: 0
				posn: 16 109
				addToPic:
			)
			((= aDrummer (Prop new:))
				view: 714
				ignoreActors:
				setLoop: 1
				posn: 233 146
				stopUpd:
				init:
			)
			((= aPedaler (Prop new:))
				view: 707
				ignoreActors:
				setLoop: 7
				posn: 212 164
				stopUpd:
				init:
			)
			((= aDoctor (Act new:))
				view: 711
				loop: 3
				posn: 159 172
				setPri: 14
				setCycle: Walk
				illegalBits: 0
				stopUpd:
				init:
			)
			((= aHulaHooper (Act new:))
				view: 823
				ignoreActors:
				illegalBits: 0
				setLoop: 0
				setCycle: Walk
				setStep: 1 1
				posn: 146 129
				stopUpd:
				init:
			)
			((= aDancer (Act new:))
				view: 823
				ignoreActors:
				illegalBits: 0
				setLoop: 1
				setCycle: Walk
				setStep: 2 1
				posn: 118 145
				stopUpd:
				init:
			)
			((= aKalalau (Act new:))
				view: 704
				loop: 1
				ignoreActors:
				illegalBits: 0
				posn: -28 142
				setCycle: Walk
				setStep: 3 2
				cycleSpeed: 1
				moveSpeed: 1
				init:
			)
			((= aChief (Act new:))
				view: 710
				ignoreActors:
				illegalBits: 0
				setPri: 9
				setCycle: Walk
				cycleSpeed: 1
				moveSpeed: 1
				posn: -22 138
				init:
			)
			((= aMouth (Prop new:))
				view: 710
				ignoreActors:
				setLoop: 4
				setPri: 10
				posn: 999 999
				setCycle: Fwd
				init:
			)
			((= aCameraman (Act new:))
				view: 212
				ignoreActors:
				illegalBits: 0
				loop: 0
				cel: 0
				posn: 99 180
				moveSpeed: 2
				cycleSpeed: 2
				setCycle: Walk
				setStep: 3 2
				init:
				setScript: minicamScript
			)
			((= aPhotographer (Act new:))
				view: 823
				ignoreActors:
				illegalBits: 0
				setLoop: 2
				setCel: 5
				setCycle: Walk
				setPri: 13
				posn: 56 170
				stopUpd:
				init:
			)
		)
	)
)

(instance rm78Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(!= gIslandStatus 105)
				(== (gEgo loop:) 3)
				(== 6 (aWoodchopper cel:))
				(gEgo inRect: 34 100 43 107)
				(== gCurrentStatus 0)
			)
			(self changeState: 47)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/man,children')
				(Print 78 0) ; "He seems to be slowing down, doesn't he?"
			)
			(if (Said '/door')
				(Print 78 1) ; "All the doors here are closed. The natives enjoy their privacy. Leave them alone."
			)
			(if (Said '[/airport,angeles,hut]')
				(Print 78 2) ; "This must be the witch doctor's hut."
				(Print 78 3) ; "A native man chops wood near his hut."
			)
		)
		(if
			(or
				(Said '(board<in),(disembark<in),climb,board/stair,hut')
				(Said 'look/cup')
				(Said 'bang,open/door')
			)
			(Print 78 4) ; "It would be better if you stayed out."
		)
		(if (Said 'talk/man,children')
			(if (gEgo inRect: 0 0 91 120)
				(Print 78 5) ; "Grunt."
				(Print 78 6 #at -1 152) ; "(Not very talkative, this one!)"
			else
				(NotClose) ; "You're not close enough."
			)
		)
		(if (Said '/man,children')
			(Print 78 7) ; "You'd better not get too close to this guy!"
		)
		(if (Said '/axe')
			(Print 78 8) ; "It's his axe. Leave it alone."
		)
		(if (Said '/log')
			(Print 78 9) ; "It's his wood. Boy! You try to take everything that's not nailed down!"
		)
	)

	(method (changeState newState &tmp i)
		(switch (= state newState)
			(1
				(= cycles 2)
			)
			(2
				(Print 78 10) ; "The entire village has turned out for the wedding of their princess, Kalalau, to the white-suited stranger."
				(= cycles 20)
			)
			(3
				(theSound play:)
				(Print 78 11) ; "The drummer begins his special, stylized rendition of the theme from Wagner's "Lonegrin.""
				(aDrummer setCycle: Fwd)
				(aHulaHooper setMotion: MoveTo 222 123 self)
				(aDancer setMotion: MoveTo 46 111 self)
			)
			(5
				(Print 78 12) ; "The witch doctor is waiting; you move into position to await the entrance of your betrothed."
				(aHulaHooper setLoop: 5 cel: 0 stopUpd:)
				(aDancer cel: 0 stopUpd:)
				(gEgo setMotion: MoveTo 163 134 self)
			)
			(6
				(gEgo setLoop: 2 stopUpd:)
				(= seconds 3)
			)
			(7
				(Print 78 13) ; "In comes your beloved Kalalau on the arm of her father."
				(= seconds 3)
			)
			(8
				(aKalalau setMotion: MoveTo 182 152 self)
				(aChief setMotion: MoveTo 100 138 self)
				(aPedaler setCycle: Fwd)
				(minicamScript changeState: 5)
			)
			(10
				(aKalalau setLoop: 1)
				(gEgo setMotion: MoveTo 165 152 self)
			)
			(11
				(aKalalau hide:)
				(gEgo view: 822 setLoop: 0 cel: 0 posn: 172 152)
				(Print 78 14 #draw) ; "Who gives this woman to marry this man?"
				(aChief stopUpd:)
				(aMouth posn: (+ (aChief x:) -1) (+ (aChief y:) -25))
				(= seconds 3)
			)
			(12
				(aMouth posn: 666 666)
				(= aFlash aMouth)
				(= aCupidEast aChief)
				(gEgo stopUpd:)
				(Print 78 15 #draw) ; ""That'd be me," says Chief Keneewauwau."
				(AddActorToPic aChief)
				(aCupidEast posn: 888 888)
				(= seconds 3)
			)
			(13
				(Print 78 16) ; "Very well." Turning to you, the witch doctor asks, "And, do you have a ring?"
				(minicamScript changeState: 3)
				(= seconds 3)
			)
			(14
				(Print 78 17) ; "You know, there was a ring in The Land of the Lounge Lizards," you tell him, "but I never thought to bring it along here!"
				(= seconds 3)
			)
			(15
				(Print 78 18) ; "Never mind. Let's begin."
				(theSound stop:)
				(AddActorToPic aDrummer)
				(= aHeart aDrummer)
				(aHeart posn: 777 777)
				(Print 78 19) ; "Following the traditions of our peoples, you must now spin in a circle until you are dizzy and throw up."
				(= seconds 3)
			)
			(16
				(gEgo cycleSpeed: 2 setCycle: End self)
			)
			(17
				(gEgo cycleSpeed: 6 setLoop: 1 setCel: 0 setCycle: Fwd)
				(= cycles 12)
			)
			(18
				(if (= i (gEgo cycleSpeed:))
					(-- i)
					(gEgo cycleSpeed: i)
					(-- state)
				)
				(= cycles 8)
			)
			(19
				(= seconds 6)
			)
			(20
				(if (< (= i (gEgo cycleSpeed:)) 8)
					(++ i)
					(gEgo cycleSpeed: i)
					(-- state)
				)
				(= cycles 8)
			)
			(21
				(gEgo setLoop: 2)
				(Print 78 20) ; "Now smash this wedding cake into your beloved's face."
				(= cycles 10)
			)
			(22
				(gEgo cycleSpeed: 2 setLoop: 6 setCycle: End self)
			)
			(23
				(= cycles 20)
			)
			(24
				(Print 78 21) ; "And finally, moonwalk across this dirt compound!"
				(= cycles 22)
			)
			(25
				(Print 78 22 #at -1 152) ; "(Is this really necessary?)"
				(= cycles 22)
			)
			(26
				(aKalalau
					show:
					setLoop: 0
					cycleSpeed: 0
					moveSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 62 152
				)
				(gEgo
					view: 100
					setLoop: 0
					cycleSpeed: 0
					moveSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 45 152 self
				)
			)
			(27
				(aKalalau setLoop: 1 setMotion: MoveTo 189 152)
				(gEgo setLoop: 1 setMotion: MoveTo 172 152 self)
			)
			(28
				(gEgo setLoop: 0)
				(Print 78 23 #draw) ; "You may kiss the bride!"
				(= cycles 10)
			)
			(29
				(aKalalau hide:)
				(gEgo
					view: 706
					setLoop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(30
				(= seconds 5)
			)
			(31
				(Print 78 24 #at -1 152) ; "(villagers go aaaaahhh)"
				(gEgo setCycle: Beg self)
			)
			(32
				(gEgo view: 822 setLoop: 2 cycleSpeed: 0 setCycle: Walk)
				(= seconds 3)
			)
			(33
				(Print 78 25) ; "Now, Larry, we'd like to welcome you to our family. Look at it this way: you now have a villageful of in-laws!"
				(AddActorToPic aPedaler)
				(= aCupidWest aPedaler)
				(aCupidWest posn: 999 999)
				(aPhotographer setMotion: MoveTo 132 160 self)
			)
			(34
				(aPhotographer setLoop: 3 cel: 0 setCycle: End self)
			)
			(35
				(aDoctor view: 713 setLoop: 1 setCycle: Fwd)
				(= cycles 50)
			)
			(36
				(aHeart
					view: 822
					loop: 3
					posn: 170 139
					cel: 0
					cycleSpeed: 2
					setPri: 13
					setCycle: End self
				)
			)
			(37
				(aDoctor view: 711 setLoop: 3 setCycle: Walk stopUpd:)
				(aCupidWest view: 822 setLoop: 4 posn: 154 106 setCycle: Fwd)
				(aCupidEast view: 822 setLoop: 5 posn: 186 106 setCycle: Fwd)
				(= cycles 30)
			)
			(38
				(aFlash
					view: 823
					setLoop: 4
					setPri: 12
					cel: 0
					posn: (+ (aPhotographer x:) 5) (- (aPhotographer y:) 35)
					cycleSpeed: 0
					setCycle: End self
				)
			)
			(39
				(aFlash dispose:)
				(aPhotographer setCycle: Beg self)
			)
			(40
				(= cycles 10)
			)
			(41
				(aHeart setCycle: Beg self)
				(aCupidWest dispose:)
				(aCupidEast dispose:)
			)
			(42
				(aHeart dispose:)
				(= seconds 3)
			)
			(43
				(Print 78 26) ; "Larry, my son, at this time, I would like to give you a special wedding present in my hut."
				(Print 78 27) ; "Please, walk this way."
				(aKalalau setLoop: 1 show:)
				(gEgo view: 100 setPri: -1 setLoop: -1 loop: 2 posn: 165 152)
				(aDoctor setPri: -1 setMotion: MoveTo 150 152 self)
			)
			(44
				(aDoctor setMotion: MoveTo 165 116 self)
				(= cycles 5)
			)
			(45
				(Print 78 28) ; "You think, "If I walked that way, I'd be a maitre'd!""
				(gEgo setMotion: MoveTo 171 120)
			)
			(46
				(gCurRoom newRoom: 178)
			)
			(47
				(HandsOff)
				(= gCurrentStatus 1000)
				(aWoodchopper setScript: 0 setCel: 255 stopUpd:)
				(Print 78 29 #draw) ; "OW!"
				(Print 78 30) ; "You scream in anguish as the woodchopper misses the log, and removes your foot!"
				(= seconds 3)
			)
			(48
				(= gCurrentStatus 1001)
				(Print 78 31) ; "Next time, better leave this guy alone!"
			)
		)
	)
)

(instance woodScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 8)
			)
			(1
				(aWoodchopper setCycle: End self)
			)
			(2
				(= cycles (++ pauseCycles))
				(= state 0)
			)
		)
	)
)

(instance minicamScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(aCameraman loop: 2 setCycle: End self)
			)
			(2
				(aCameraman stopUpd:)
			)
			(3
				(aCameraman setCycle: Beg self)
			)
			(4
				(aCameraman setCycle: Walk setMotion: MoveTo 180 180 self)
				(= state 0)
			)
			(5
				(aCameraman setCycle: Beg self)
			)
			(6
				(aCameraman setCycle: Walk setMotion: MoveTo 120 180 self)
				(= state 0)
			)
		)
	)
)

(instance theSound of Sound
	(properties
		number 111
		loop -1
	)
)

