;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 84)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Jump)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm84 0
)

(local
	[local0 480] = [0 0 0 6 0 0 0 0 0 0 0 0 0 0 0 0 0 7 0 0 999 997 1 4 0 0 1 12 {rm84} 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 10 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
)

(instance rm84 of Rm
	(properties
		picture 84
	)

	(method (init)
		(Load rsVIEW 197)
		(Load rsVIEW 817)
		(Load rsVIEW 818)
		(Load rsVIEW 831)
		(Load rsVIEW 832)
		(Load rsVIEW 833)
		(Load rsVIEW 834)
		(Load rsVIEW 835)
		(Load rsVIEW 198)
		(Load rsSOUND 104)
		(Load rsSOUND 112)
		(Load rsSOUND 10)
		(theMusic init:)
		(Load rsSCRIPT 991)
		(super init:)
		(self setScript: rm84Script)
		((View new:) view: 817 ignoreActors: posn: 190 116 addToPic:)
		((View new:)
			view: 817
			ignoreActors:
			loop: 0
			cel: 1
			posn: 216 72
			setPri: 0
			addToPic:
		)
		((View new:)
			view: 817
			ignoreActors:
			loop: 0
			cel: 2
			posn: 103 71
			setPri: 0
			addToPic:
		)
		((View new:)
			view: 817
			ignoreActors:
			loop: 0
			cel: 3
			posn: 21 176
			setPri: 15
			addToPic:
		)
		((View new:) view: 817 ignoreActors: cel: 4 posn: 60 109 addToPic:)
		(aFlames ignoreActors: setPri: 11 init: stopUpd:)
		(aComputerWest ignoreActors: init: stopUpd:)
		(aComputerEast ignoreActors: init: stopUpd:)
		(aLaser ignoreActors: setPri: 2 init: stopUpd:)
		(aLaserFire ignoreActors: setPri: 3 init:)
		(aTrapdoor ignoreActors: setPri: 15 init: stopUpd:)
		(aHench0 ignoreActors: init: stopUpd:)
		(aHench1 ignoreActors: init: stopUpd:)
		(aHench2 ignoreActors: init: stopUpd:)
		(aHench3 ignoreActors: init: stopUpd:)
		(aPatty ignoreActors: setCycle: Fwd setPri: 10 cycleSpeed: 2 init:)
		(aPiano setLoop: 8 ignoreActors: setPri: 9 init: stopUpd:)
		(aColumn setLoop: 7 ignoreActors: init: stopUpd:)
		(aChandelier setLoop: 0 ignoreActors: setPri: 11 init: stopUpd:)
		(aBullet ignoreActors: setLoop: 6 setPri: 15 init:)
		(aNo ignoreActors: init: stopUpd:)
		(= gCurrentStatus 22)
		(HandsOff)
		(gEgo
			view: 197
			ignoreActors:
			illegalBits: 0
			setLoop: 0
			posn: 0 120
			setCycle: Fwd
			setPri: 8
			setStep: 10 10
			init:
		)
	)
)

(instance aFlames of Prop
	(properties
		y 130
		x 34
		view 835
	)
)

(instance aComputerWest of Prop
	(properties
		y 80
		x 81
		view 817
		loop 2
	)
)

(instance aComputerEast of Prop
	(properties
		y 80
		x 236
		view 817
		loop 3
	)
)

(instance aLaser of Prop
	(properties
		y 44
		x 151
		view 817
		loop 4
	)
)

(instance aLaserFire of Prop
	(properties
		y 1040
		x 161
		view 817
		loop 5
	)
)

(instance aTrapdoor of Prop
	(properties
		y 184
		x 294
		view 817
		loop 1
	)
)

(instance aHench0 of Prop
	(properties
		y 112
		x 154
		view 833
	)
)

(instance aHench1 of Prop
	(properties
		y 107
		x 168
		view 833
		loop 1
	)
)

(instance aHench2 of Prop
	(properties
		y 103
		x 184
		view 833
		loop 2
	)
)

(instance aHench3 of Prop
	(properties
		y 99
		x 198
		view 833
		loop 3
	)
)

(instance aPatty of Prop
	(properties
		y 121
		x 206
		view 831
	)
)

(instance aPiano of Act
	(properties
		y 124
		x 234
		yStep 8
		view 817
		xStep 8
	)
)

(instance aColumn of Act
	(properties
		y 25
		x 230
		yStep 10
		view 817
		xStep 10
	)
)

(instance aChandelier of Act
	(properties
		y 39
		x 204
		yStep 10
		view 817
		cel 5
		xStep 10
	)
)

(instance aBullet of Act
	(properties
		y 999
		x 999
		yStep 22
		view 817
		illegalBits 0
		xStep 22
	)
)

(instance aNo of Act
	(properties
		y 129
		x 86
		view 818
	)
)

(instance rm84Script of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(Print 84 0 #at -1 15 #width 280) ; "As you plummet through the darkness of the elevator shaft, the evil Dr. Nonookee is enjoying another blissful evening at home, singing jazz standards with his backup singers, the Henchettes, at his personal piano bar..."
				(theMusic play: self)
				(Print 84 1 #at -1 20 #dispose) ; "Peelings..."
				(= seconds 30)
			)
			(2
				(= seconds 0)
				(cls)
				(Print 84 2 #at -1 20 #dispose) ; "Nothing more than..."
				(= seconds 30)
			)
			(3
				(= seconds 0)
				(cls)
				(Print 84 1 #at -1 20 #dispose) ; "Peelings..."
				(= cycles 20)
			)
			(4
				(= seconds 0)
				(cls)
				(= seconds 30)
			)
			(5
				(= seconds 0)
				(theMusic dispose:)
				(Print 84 3 #at -1 15 #width 280) ; "Suddenly, you explode from the elevator shaft onto the scene..."
				(theMusic number: 112 loop: -1 play:)
				(gEgo setMotion: MoveTo 155 121 self)
				(aPatty setLoop: 1 stopUpd:)
			)
			(6
				(gEgo setMotion: MoveTo 162 94 self)
			)
			(7
				(gEgo
					setLoop: 1
					setCel: 0
					setCycle: End
					setStep: 2 12
					setMotion: MoveTo 172 35 self
				)
			)
			(8
				(aChandelier hide:)
				(gEgo
					posn: 204 39
					setLoop: 2
					setCel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(9
				(gEgo setLoop: 3 setCel: 0 setCycle: Fwd)
				(= cycles 24)
			)
			(10
				(aChandelier show: addToPic:)
				(gEgo
					setPri: -1
					setLoop: 4
					setCel: 0
					setCycle: Fwd
					cycleSpeed: 0
					posn: 195 51
					setStep: 11 11
					setMotion: MoveTo 198 80 self
				)
			)
			(11
				(gEgo
					posn: 196 71
					setStep: 3 2
					setLoop: 5
					setCel: 0
					setCycle: End self
				)
			)
			(12
				(gEgo posn: 198 83 setLoop: 6 setCel: 0 setCycle: End self)
			)
			(13
				(Print 84 4 #at -1 15 #width 280 #draw) ; "Staggering to your feet, you inadvertently slap a fast low-five on that hand extending from the wall. Oh, oh! You've discovered the secret activator for the fortress' Peacemaker Self-Defense Control Panel!"
				(aComputerEast setCycle: End)
				(gEgo
					view: 198
					posn: 211 83
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(14
				(Print 84 5 #at -1 15 #width 280 #draw) ; "Struggling to regain your balance, you fall onto the "Auto-Fire" button."
				(aComputerWest setCycle: End self)
			)
			(15
				(Print 84 6 #at -1 20 #draw) ; ""STOP!" screams Dr. Nonookee."
				(Print 84 7 #at -1 152) ; "(But, it's too late!)"
				(aComputerEast addToPic:)
				(aComputerWest addToPic:)
				(gEgo
					setLoop: 1
					setStep: 2 2
					setCycle: Walk
					setMotion: MoveTo 111 94
				)
				(aLaser setCycle: End self)
			)
			(16
				(aLaser addToPic:)
				(aLaserFire posn: 161 39 setCycle: End)
				(aBullet posn: 162 41 setCel: 0 setMotion: MoveTo 277 48 self)
			)
			(17
				(aBullet setCycle: End self)
			)
			(18
				(aLaserFire cel: 0 setCycle: End)
				(aBullet posn: 162 41 setCel: 0 setMotion: MoveTo 160 4 self)
			)
			(19
				(aBullet setCycle: End self)
			)
			(20
				(aLaserFire cel: 0 setCycle: End)
				(aBullet posn: 162 41 setCel: 0 setMotion: MoveTo 218 78 self)
			)
			(21
				(aBullet setCycle: End self)
			)
			(22
				(aLaserFire cel: 0 setCycle: End)
				(aBullet posn: 162 41 setCel: 0 setMotion: MoveTo 283 157 self)
			)
			(23
				(aBullet setCycle: End self)
			)
			(24
				(aTrapdoor setCycle: End)
				(aLaserFire cel: 0 setCycle: End)
				(aBullet posn: 162 41 setCel: 0 setMotion: MoveTo 119 181 self)
			)
			(25
				(aBullet setCycle: End self)
			)
			(26
				(aTrapdoor dispose:)
				(aLaserFire cel: 0 setCycle: End)
				(aBullet posn: 162 41 setCel: 0 setMotion: MoveTo 33 88 self)
			)
			(27
				(aBullet setCycle: End self)
			)
			(28
				(aLaserFire cel: 0 setCycle: End)
				(aBullet posn: 162 41 setCel: 0 setMotion: MoveTo 250 10 self)
			)
			(29
				(aBullet setCycle: End self)
			)
			(30
				(aLaserFire cel: 0 setCycle: End)
				(aBullet posn: 162 41 setCel: 0 setMotion: MoveTo 157 116 self)
			)
			(31
				(aBullet setCycle: End self)
			)
			(32
				(aLaserFire cel: 0 setCycle: End)
				(aBullet posn: 162 41 setCel: 0 setMotion: MoveTo 31 110 self)
			)
			(33
				(aBullet setCycle: End self)
			)
			(34
				(aLaserFire cel: 0 setCycle: End)
				(aBullet posn: 162 41 setCel: 0 setMotion: MoveTo 117 15 self)
			)
			(35
				(aBullet setCycle: End self)
			)
			(36
				(aLaserFire cel: 0 setCycle: End)
				(aBullet posn: 162 41 setCel: 0 setMotion: MoveTo 148 5 self)
			)
			(37
				(aBullet setCycle: End self)
			)
			(38
				(aLaserFire cel: 0 setCycle: End)
				(aBullet posn: 162 41 setCel: 0 setMotion: MoveTo 221 22 self)
			)
			(39
				(aBullet setCycle: End self)
			)
			(40
				(Print 84 8 #at -1 15 #width 280) ; "A laser beam strikes the large, Italian marble column near the grand piano!"
				(aLaserFire posn: 999 999)
				(aBullet dispose:)
				(gEgo stopUpd:)
				(aColumn setCycle: End setMotion: JumpTo 255 83 self)
			)
			(41
				(ShakeScreen 1 ssUPDOWN)
				(aPiano setPri: 10 setMotion: JumpTo 86 140 self)
			)
			(42
				(aNo view: 834 setLoop: 0 setCel: 0 setPri: 1 posn: 86 131)
				(aPiano setPri: 2 setCycle: End self)
				(theMusic dispose:)
				(theMusic number: 10 loop: 1 play:)
				(ShakeScreen 3 ssLEFTRIGHT)
			)
			(43
				(aPiano addToPic:)
				(= seconds 3)
			)
			(44
				(gGame changeScore: 30)
				(Print 84 9 #at -1 15 #width 280) ; "You did it! You did it, Larry!! You destroyed the evil Dr. Nonookee!!"
				(= seconds 4)
			)
			(45
				(aNo setCycle: End self)
				(theMusic number: 16 loop: -1 play:)
			)
			(46
				(aNo
					setLoop: 1
					setPri: 14
					moveSpeed: 3
					setStep: 1 1
					setCycle: Fwd
					setMotion: MoveTo 89 112 self
				)
			)
			(47
				(aFlames setCycle: End self)
			)
			(48
				(aNo dispose:)
				(theMusic stop:)
				(aFlames setLoop: 1 setCel: 0 setCycle: End self)
			)
			(49
				(aFlames dispose:)
				(= seconds 3)
			)
			(50
				(gEgo view: 100 setLoop: 0 setStep: 3 2 setLoop: -1)
				(= seconds 2)
			)
			(51
				(Print 84 10 #at -1 15 #width 280) ; "Remembering that Dr. Nonookee kidnapped and hypnotized the island's innocent native women, you realize you must break his spell before they can return to the village. "Snap out of it, girls! He's gone forever! Never again will you be forced to do his evil deeds. You are free to return to your native selves.""
				(Print 84 11 #at -1 15 #width 280) ; "On the count of three, you will awaken refreshed and able to remember everything that's happened to you."
				(= seconds 2)
			)
			(52
				(Print 84 12 #at -1 15 #width 280) ; ""One, two, THREE," you shout, snapping your fingers."
				(= seconds 3)
			)
			(53
				(Print 84 13 #at -1 15 #width 280) ; "Freed at last from the hypnotic trance of the evil Doctor, the women liberate themselves, resuming their native ways."
				(aLaserFire
					setPri: 14
					posn: (- (aHench0 x:) 2) (- (aHench0 y:) 31)
					setCel: 0
					setCycle: End self
				)
			)
			(54
				(aLaserFire posn: 999 999)
				(aHench0 cycleSpeed: 2 setCycle: End self)
			)
			(55
				(aHench0 stopUpd:)
				(aLaserFire
					posn: (- (aHench1 x:) 2) (- (aHench1 y:) 32)
					setCel: 0
					setCycle: End self
				)
			)
			(56
				(aLaserFire posn: 999 999)
				(aHench1 cycleSpeed: 2 setCycle: End self)
			)
			(57
				(aHench1 stopUpd:)
				(aLaserFire
					posn: (- (aHench2 x:) 2) (- (aHench2 y:) 30)
					setCel: 0
					setCycle: End self
				)
			)
			(58
				(aLaserFire posn: 999 999)
				(aHench2 cycleSpeed: 2 setCycle: End self)
			)
			(59
				(aHench2 stopUpd:)
				(aLaserFire
					posn: (- (aHench3 x:) 2) (- (aHench3 y:) 32)
					setCel: 0
					setCycle: End self
				)
			)
			(60
				(aLaserFire posn: 999 999)
				(aHench3 cycleSpeed: 2 setCycle: End self)
			)
			(61
				(aHench3 stopUpd:)
				(Print 84 14 #at -1 15 #width 280) ; "Huzzah! Huzzah!!" they shout. "It's Larry; Larry Laffer -- OUR HERO!"
				(Print 84 15 #at -1 15 #width 280) ; "You interrupt their celebration with, "It's nice of you to say so, but we must leave here immediately. I had to force the elevator door by dropping a bomb into the volcano and I'm afraid it may erupt at any moment! Where's the radio-telephone?""
				(Print 84 16 #at -1 20) ; "It's right behind you!"
				(Print 84 17 #at -1 20) ; "Oh," you counter. "I knew that."
				(gEgo setLoop: -1 setMotion: MoveTo 79 110 self)
			)
			(62
				(gEgo loop: 1 forceUpd:)
				(= seconds 3)
			)
			(63
				(Print 84 18 #at -1 15 #width 280) ; "You grab the telephone and press the big "talk" button..."
				(Print 84 19 #at -1 15 #width 280) ; "MAYDAY! MAYDAY! This is the Big Laffer calling. Kin I git a copy offn any good buddy?"
				(Print 84 20 #at -1 152) ; "(You often slip back into the 70's without even trying!)"
				(Print 84 21 #at -1 15 #width 280) ; "Catching yourself, you continue, "I'm inside Nontoonyt Island's volcano; in a fortress hollowed out of solid rock and filled with beautiful, over-sexed women recently stripped to the waist; I've just killed a maniacal, power-hungry, money-grubbing scientist who was trying to grab my onklunk; a few minutes ago, I dropped a homemade bomb into a crevice that will cause the volcano to erupt!""
				(Print 84 22 #at -1 152) ; "(Do you realize how stupid you sound?)"
				(Print 84 23 #at -1 20) ; "Is anybody listening? Over."
				(= seconds 3)
			)
			(64
				(Print 84 24 #at -1 20) ; "Hiss."
				(Print 84 25 #at -1 20) ; "Crackle."
				(Print 84 26 #at -1 20) ; "Pop."
				(= seconds 3)
			)
			(65
				(Print 84 24 #at -1 20) ; "Hiss."
				(Print 84 25 #at -1 20) ; "Crackle."
				(Print 84 26 #at -1 20) ; "Pop."
				(Print 84 27 #at -1 152) ; "(You almost receive a breakfast cereal commercial.)"
				(= seconds 3)
			)
			(66
				(Print 84 28 #at -1 15 #width 280) ; "Roger, Big Laffer. We copy. What kind of help do you need? Over."
				(= seconds 3)
			)
			(67
				(Print 84 29 #at -1 15 #width 280) ; "Hey, who is this? Are you nearby? Can you come immediately? Over."
				(= seconds 3)
			)
			(68
				(Print 84 30 #at -1 15 #width 280) ; "This is Duane Barker of 'Software Illustrated' magazine. We're right below you on the beach at Nontoonyt Island, shooting our annual swimsuit issue! We'll be glad to fly up in our helicopter to rescue you!"
				(Print 84 31 #at -1 15 #width 280) ; "Is there any way you could create some sort of signal to let me know where you are? Over."
				(= seconds 3)
			)
			(69
				(Print 84 32 #at -1 15 #width 280) ; "You glance at the large computer panel to your right. "How about if I have some palm trees emit a cloud of fog to surround the island, then turn off the island's main waterfall, and open a gigantic hanger door in the side of the volcano? Over.""
				(= seconds 3)
			)
			(70
				(Print 84 33 #at -1 15 #width 280) ; "Yeah, I guess that ought to do it," he replies. "See you in two minutes. Over and out."
				(Print 84 34 #at -1 20) ; "Over and out, good buddy."
				(= cycles 20)
			)
			(71
				(gEgo setLoop: -1 setMotion: MoveTo 93 (gEgo y:) self)
			)
			(72
				(gEgo setMotion: MoveTo 93 92 self)
			)
			(73
				(gEgo setMotion: MoveTo 89 92 self)
			)
			(74
				(Print 84 35 #at -1 15 #width 280) ; "You have a little trouble deciphering the control panel for the island's camouflage system. "Anybody know how to work this fog machine?" you ask."
				(Print 84 36 #at -1 15 #width 280) ; "Oh, what the hell; pushing everything at least once couldn't hurt!"
				(= seconds 3)
			)
			(75
				(Print 84 37 #at -1 15 #width 280) ; "Oh, great hero of our island," says one of the women, "come over here. Allow us to give you a proper, triumphant return to our people!"
				(= cycles 20)
			)
			(76
				(gEgo setMotion: MoveTo 133 100 self)
			)
			(77
				(aHench0 dispose:)
				(aHench1 dispose:)
				(aHench2 dispose:)
				(aHench3 dispose:)
				(gEgo
					view: 832
					setLoop: 0
					setStep: 2 2
					setPri: 14
					posn: 176 112
					setMotion: MoveTo 124 130 self
				)
			)
			(78
				(gEgo setLoop: 1 setMotion: MoveTo 333 214 self)
				(aPatty setLoop: 2)
				(Print 84 38 #at -1 15 #width 280 #draw) ; ""Say, aren't you coming with us?" you ask the pianist."
				(Print 84 39 #at -1 15 #width 280) ; "Of course not," she replies, "I don't really have a part here, I'm just the piano player. But, allow me to introduce myself...."
				(Print 84 40 #at -1 15 #width 280) ; "My name is Patty," she says, "'Polyester Patty,' the internationally-renowned recording artist and queen of the women's singles scene. You'll want to watch for me in 'Leisure Suit Larry III!!'"
				(= cycles 12)
			)
			(79
				(Print 84 41 #at -1 152) ; "(You ignore this blatant plug.)"
				(Print 84 42 #at -1 20) ; "Come on girls," you command, "to the chopper... and my destiny!"
			)
			(80
				(Print 84 43) ; "Hey, watch out!"
				(Print 84 44) ; "Clumsy!!"
				(Print 84 45) ; "You dropped him!!!"
				(= seconds 3)
			)
			(81
				(Print 84 46) ; "Meanwhile, outside..."
				(= gIslandStatus 100)
				(gCurRoom newRoom: 92)
			)
		)
	)
)

(instance theMusic of Sound
	(properties
		number 104
	)
)

