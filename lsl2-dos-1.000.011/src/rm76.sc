;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 76)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm76 0
)

(local
	aPedaler
	aBearer
	aBigEgo
	aBigScreen
	aDrummer
	aKalalau
	aChief
	aMouth
)

(instance rm76 of Rm
	(properties
		picture 76
		horizon 37
		north 79
		east 77
	)

	(method (init)
		(super init:)
		(NormalEgo)
		(self setScript: rm76Script)
		(if gForceAtest
			(= gIslandStatus 2)
		)
		(if (!= gIslandStatus 2)
			(self setRegions: 700) ; rm700
		else
			(= gCurrentStatus 11)
			(rm76Script changeState: 1)
			(Load rsVIEW 194)
			(Load rsVIEW 195)
			(Load rsVIEW 704)
			(Load rsVIEW 707)
			(Load rsVIEW 710)
			(Load rsVIEW 714)
			(Load rsSOUND 114)
			(theSound init:)
			((View new:)
				view: 707
				ignoreActors:
				loop: 6
				cel: 3
				posn: 208 94
				setPri: 5
				addToPic:
			)
			((View new:)
				view: 707
				ignoreActors:
				loop: 6
				cel: 2
				posn: 190 97
				addToPic:
			)
			((View new:)
				view: 707
				ignoreActors:
				loop: 6
				cel: 1
				posn: 224 97
				addToPic:
			)
			((View new:)
				view: 714
				ignoreActors:
				loop: 2
				cel: 1
				posn: 144 89
				addToPic:
			)
			((View new:)
				view: 714
				ignoreActors:
				loop: 3
				cel: 0
				posn: 272 91
				addToPic:
			)
			((View new:)
				view: 714
				ignoreActors:
				loop: 3
				cel: 1
				posn: 229 87
				addToPic:
			)
			((View new:)
				view: 714
				ignoreActors:
				loop: 2
				cel: 0
				posn: 190 83
				addToPic:
			)
			((= aBigEgo (Prop new:))
				view: 195
				ignoreActors:
				setLoop: 0
				setPri: 15
				posn: 275 1040
				setCycle: Fwd
				init:
			)
			((= aBigScreen (Prop new:))
				view: 195
				ignoreActors:
				setLoop: 1
				setPri: 15
				posn: 275 1040
				setCycle: Fwd
				init:
			)
			((= aDrummer (Prop new:))
				view: 714
				ignoreActors:
				setLoop: 0
				posn: 92 161
				stopUpd:
				init:
			)
			((= aPedaler (Prop new:))
				view: 707
				ignoreActors:
				setLoop: 7
				posn: 177 99
				stopUpd:
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
				posn: -21 87
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
			((= aBearer (Act new:))
				view: 707
				ignoreActors:
				illegalBits: 0
				setLoop: 5
				setCycle: Walk
				posn: 233 96
				stopUpd:
				init:
			)
			((= aKalalau (Act new:))
				view: 704
				loop: 1
				ignoreActors:
				illegalBits: 0
				posn: 300 132
				setCycle: Walk
				init:
			)
		)
		(cond
			((== gPrevRoomNum 79)
				(gEgo posn: 197 41)
			)
			((== gPrevRoomNum 77)
				(gEgo posn: 306 126)
			)
			(else
				(gEgo posn: 306 126)
			)
		)
		(gEgo init:)
	)
)

(instance rm76Script of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/door')
				(Print 76 0) ; "All the doors here are closed. The natives enjoy their privacy. Leave them alone."
			)
			(if (Said '[/airport,angeles,hut]')
				(Print 76 1) ; "The chief's hut is grand, but only in comparision to the other huts."
				(Print 76 2) ; "In the background, you can hear strains of old Olivia Newton-John tapes."
			)
		)
		(if
			(or
				(Said '(board<in),(disembark<in),climb,board/stair,hut')
				(Said 'look/cup')
				(Said 'bang,open/door')
			)
			(Print 76 3) ; "It would be better if you stayed out."
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(= cycles 3)
			)
			(2
				(HandsOff)
				(gEgo setMotion: MoveTo 145 126 self)
				(aKalalau setMotion: MoveTo 138 132)
				(= cycles 10)
			)
			(3
				(Print 76 4 #draw) ; "All of the village is gathered for this profound occasion. You and your beloved stride across the compound to wait the arrival of the chief."
			)
			(4
				(Print 76 5) ; "Oh, Daddy!" shouts Kalalau, "please come out. There is someone here I would like you to meet!"
				(aKalalau setCel: 255 stopUpd:)
				(gEgo stopUpd:)
				(aChief setMotion: MoveTo 81 91 self)
			)
			(5
				(Print 76 6) ; "Father, this is Larry; Larry Laffer," says Kalalau. "We are in love, and wish to marry!"
				(aChief stopUpd:)
				(aMouth posn: (+ (aChief x:) -1) (+ (aChief y:) -26))
				(= seconds 3)
			)
			(6
				(aMouth hide:)
				(Print 76 7 #draw) ; "So you want to marry my daughter?" says Chief Keneewauwau, staring straight to the back of your skull. "No one is worthy of her hand, unless he can prove himself a real man!"
				(= seconds 3)
			)
			(7
				(Print 76 8) ; "Oh, I'll do anything for the woman I love, sir," you tell him. "No sacrifice is too great!"
				(aMouth show:)
				(= seconds 3)
			)
			(8
				(aMouth hide:)
				(Print 76 9 #draw) ; "So be it," he says softly. Then in a more commanding tone, "Enter the sacrificial hut and bring forth the Sacred Peesea!"
				(Print 76 10 #at -1 152) ; "(villagers go ooooooh)"
				(= seconds 3)
			)
			(9
				(aBearer setLoop: 4 setMotion: MoveTo 444 96 self)
				(aDrummer setCycle: Fwd)
				(theSound play:)
			)
			(10
				(aBearer setLoop: 1 setMotion: MoveTo 221 96 self)
			)
			(11
				(aBearer setLoop: 3 cel: 0 setCycle: CT 7 1 self)
			)
			(12
				((View new:)
					view: 707
					ignoreActors:
					loop: 6
					posn: 207 82
					setPri: 5
					addToPic:
				)
				(aBearer setCycle: End self)
			)
			(13
				(aBearer setLoop: 4 setMotion: MoveTo 233 96 self)
			)
			(14
				(aBearer setLoop: 5 forceUpd: stopUpd:)
				(aMouth show:)
				(= cycles 20)
			)
			(15
				(Print 76 11) ; "Young man, sit before the Mighty Peesea! Prove your manhood by becoming its master and you will pass part one of this initiation to our tribe!"
				(aMouth hide:)
				(= seconds 3)
			)
			(16
				(Print 76 12) ; ""But what is it I'm supposed to do?" you ask."
				(aMouth show:)
				(= seconds 3)
			)
			(17
				(Print 76 13) ; "Write a short program," he commands. "Any subject or topic, any length..."
				(Print 76 14) ; "No problem," you think, "any good adventurer could do that!"
				(Print 76 15) ; ""...as long as it's in assembly language!" he smiles, confident in the certainty of your failure!"
				(Print 76 16 #at -1 152) ; "(villagers gasp)"
				(aMouth hide:)
				(= cycles 20)
			)
			(18
				(gEgo setMotion: MoveTo 206 100 self)
				(aKalalau setLoop: 3)
				(= cycles 10)
			)
			(19
				(Print 76 17) ; "With your heart in your throat you approach their sacred relic. "Is it least significant byte first?" you wonder."
			)
			(20
				(gEgo
					view: 194
					posn: 206 100
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(21
				(gEgo stopUpd:)
				(aPedaler setCycle: Fwd)
				(= seconds 3)
			)
			(22
				(aBigEgo posn: 275 40)
				(aBigScreen posn: 275 40 cel: 0 setCycle: End self)
				(= cycles 10)
			)
			(23
				(aBigScreen setLoop: 2 setCycle: Fwd)
				(cls)
				(Print 76 18 #at -1 152 #dispose) ; "INT   21 JB   0103"
				(= cycles (Random 20 30))
			)
			(24
				(cls)
				(Print 76 19 #at -1 152 #dispose) ; "MOV   AH,4D INT   21 CS:"
				(= cycles (Random 20 30))
			)
			(25
				(cls)
				(Print 76 20 #at -1 152 #dispose) ; "MOV   [0BEA],AX JMP   02B2 JMP   1451"
				(= cycles (Random 20 30))
			)
			(26
				(cls)
				(Print 76 21 #at -1 152 #dispose) ; "CS: TEST  BYTE PTR [0C59],01 JZ   0150"
				(= cycles (Random 20 30))
			)
			(27
				(cls)
				(Print 76 22 #at -1 140 #dispose) ; "CS: TEST  BYTE PTR [0C59],02 JZ   014F IRET"
				(= cycles (Random 20 30))
			)
			(28
				(cls)
				(Print 76 18 #at -1 152 #dispose) ; "INT   21 JB   0103"
				(= cycles (Random 20 30))
			)
			(29
				(cls)
				(Print 76 23 #at -1 140 #dispose) ; "TEST  BYTE PTR [0C59],04 JZ   0169 CMP   AH,01 JA   014F"
				(= cycles (Random 20 30))
			)
			(30
				(cls)
				(= seconds 3)
			)
			(31
				(aBigScreen dispose:)
				(aBigEgo dispose:)
				(aPedaler stopUpd:)
				(gEgo setCycle: Beg self)
			)
			(32
				(gEgo
					view: 100
					setCycle: Walk
					setLoop: -1
					loop: 1
					cycleSpeed: 0
				)
				(aDrummer stopUpd:)
				(theSound stop:)
				(= cycles 15)
			)
			(33
				(Print 76 24) ; ""Ok, all ready for Quality Assurance," you announce."
				(aMouth show:)
				(= seconds 3)
			)
			(34
				(Print 76 25) ; ""What did you write?" asks Chief Keneewauwau."
				(aMouth hide:)
				(= seconds 3)
			)
			(35
				(Print 76 26) ; ""A complete, multitasking, multiuser operating system that only runs on 8088 CPUs," you respond."
				(aMouth show:)
				(= seconds 3)
			)
			(36
				(Print 76 27) ; ""Excellent. And do you have a name for this product?" asks Chief Keneewauwau."
				(aMouth hide:)
				(= seconds 3)
			)
			(37
				(Print 76 28) ; "Why, Eunuchs, of course!"
				(aMouth show:)
				(= seconds 3)
			)
			(38
				(Print 76 29) ; "Perfect," says the Chief Keneewauwau, "I'll tighten up your code later. Now follow me, and I'll lead you to the secret path: the way known only to card-carrying villagers, the path that will lead you to the sacred burial grounds of our ancestors, the one and only way to the top of Nontoonyt Volcano."
				(Print 76 30) ; "Rid this island of the evil Dr. Nonookee and Kalalau will be your wife!"
				(Print 76 31 #at -1 152) ; "(villagers go aaaahhhh)"
				(aMouth hide:)
				(aChief setMotion: MoveTo 119 127 self)
			)
			(39
				(aChief setPri: -1 setMotion: MoveTo 251 103 self)
			)
			(40
				(Print 76 32) ; "Please, walk this way."
				(aChief setMotion: MoveTo 251 95 self)
				(gEgo setMotion: MoveTo 240 100)
			)
			(41
				(gCurRoom newRoom: 79)
			)
		)
	)
)

(instance theSound of Sound
	(properties
		number 114
		loop -1
	)
)

