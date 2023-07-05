;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 460)
(include sci.sh)
(use Main)
(use eRS)
(use Talker)
(use ForwardCounter)
(use LoadMany)
(use StopWalk)
(use Grooper)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm460 0
)

(local
	cycleColors
)

(instance rm460 of LLRoom
	(properties
		picture 460
	)

	(method (init)
		(LoadMany rsPIC 470 465 1)
		(LoadMany rsVIEW 460 461 462 470 471 551 467 570 466 1465 1466)
		(LoadMany rsSOUND 470 464 461 462 463 465 466)
		(LoadMany rsFONT gNiceFont)
		(quayle init:)
		(desmond init:)
		(larry init: setCycle: Walk)
		(bigg init:)
		(pattiChair init:)
		(patDaisChair init:)
		(desDaisChair init:)
		(marilyn init:)
		(roger init:)
		(humphrey init:)
		(sleeper init: stopUpd:)
		(gEgo
			init:
			normalize: 462
			get: 13 ; Credit_Cards
			setCycle: 0
			setLoop: 4
			setCel: 0
			cycleSpeed: 5
			moveSpeed: 5
			posn: 131 127
			actions: pattiActions
		)
		(gTheMusic number: 460 flags: 1 setLoop: -1 play:)
		(dinnerFX flags: 1 loop: -1 play:)
		(super init:)
		(SetFFRoom 480)
		(HandsOff)
		(gCurRoom setScript: sCartoon)
	)
)

(instance sCartoon of Script
	(properties)

	(method (doit)
		(super doit:)
		(if cycleColors
			(Palette palANIMATE 243 255 -1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(TPrint 460 0 108 self 67 -1 28) ; "What an honor for you, Patti! Just look at all the dignitaries here to hear you perform."
			)
			(2
				(= ticks 30)
			)
			(3
				(TPrint 460 1 108 self 67 -1 185) ; "(Well, you presume that's why they're here.)"
			)
			(4
				(= ticks 30)
			)
			(5
				(TPrint 460 2 108 self 67 -1 15 70 280) ; "You are seated at the table closest to the door, near the piano you are to perform upon after dinner. Inspector Desmond sits across from you, chatting with the woman beside him."
			)
			(6
				(= ticks 30)
			)
			(7
				(TPrint 460 3 108 self 67 -1 15 70 280) ; "You carry on a meaningless dialogue with the two men beside you. What a shame the President was too busy to be here, though. You feel sure he would have loved to meet you!"
			)
			(8
				(= ticks 30)
			)
			(9
				(larry setMotion: MoveTo 300 157 self)
			)
			(10
				(TPrint 460 4 67 -1 15 70 280) ; "A voice rings out from just outside the doorway, "Ladies and Gentlemen, our Guest of Honor this evening, fresh from his heroic rescue of an airplane filled with U. S. citizens, including our Vice President's Mommy, Mr. Larry, Larry Laffer!""
				(TPrint 460 5 67 -1 185) ; "What!" you think. "Larry? MY Larry Laffer?"
				(larry setMotion: MoveTo 247 157 self)
			)
			(11
				(dinnerFX stop:)
				(gTheMusic pause: 1)
				(gTheMusic2 number: 470 flags: 1 setLoop: -1 play:)
				(Say gEgo 460 6 67 -1 28) ; "Larry!" you shout. "It's you!!"
				(TPrint 460 7 80 {Larry} 67 -1 185) ; "Patti!" Larry shouts. "It's you!!"
				(= cycles 1)
			)
			(12
				(larry
					setLoop: sGroop
					cycleSpeed: 4
					moveSpeed: 4
					setStep: 5 3
					setCycle: StopWalk -1
					setMotion: MoveTo 168 142 self
				)
				(= cycles 4)
			)
			(13
				(gEgo
					setPri: 10
					setCycle: CT (- (gEgo lastCel:) 1) 1 self
				)
			)
			(14
				(gEgo
					normalize:
					loop: 4
					posn: 129 130
					setPri: 10
					cycleSpeed: 4
					moveSpeed: 4
					setMotion: MoveTo 153 142
				)
			)
			(15
				(gEgo hide:)
				(pattiChair hide:)
				(desmond hide:)
				(patDaisChair hide:)
				(desDaisChair hide:)
				(quayle hide:)
				(bigg hide:)
				(larry hide:)
				(marilyn hide:)
				(roger hide:)
				(humphrey hide:)
				(sleeper hide:)
				(heart init:)
				(larryHead init:)
				(pattiHead init:)
				(pattiLeg init:)
				(gCurRoom drawPic: 470)
				(= cycles 2)
			)
			(16
				(= cycleColors 1)
				(= seconds 3)
			)
			(17
				(pattiLeg setCel: (pattiLeg lastCel:))
				(pattiHead setCycle: ForwardCounter 4)
				(Say gEgo 460 8 108 self 67 -1 185) ; ""Oh, Larry! I've missed you so!!" You whisper in his ear."
			)
			(18
				(= ticks 30)
			)
			(19
				(pattiHead setCycle: 0)
				(larryHead setCycle: ForwardCounter 5)
				(TPrint 460 9 80 {Larry} 108 self 67 -1 185) ; "What happened to you, Patti?" Larry sighs. "The last I remember, we were together on a deck overlooking a lake! Where did you go? Hell, where did I go?!"
			)
			(20
				(= ticks 30)
			)
			(21
				(larryHead setCycle: 0)
				(pattiHead setCycle: ForwardCounter 5)
				(Say gEgo 460 10 108 self 67 -1 185) ; "Oh, you sweet dear. You really don't remember a thing, do you? It's a long story that perhaps I'll tell you some day, but right now, all that matters is that we're together again!"
			)
			(22
				(= ticks 30)
			)
			(23
				(pattiHead setCycle: 0)
				(larryHead setCycle: ForwardCounter 5)
				(TPrint 460 11 80 {Larry} 108 self 67 -1 185) ; "Uh, say Patti," Larry says, "Since I had a little trouble finding a date for tonight, why don't you join me on the dais? We can talk about old times."
			)
			(24
				(= ticks 30)
			)
			(25
				(larryHead setCycle: 0)
				(pattiHead setCycle: ForwardCounter 3)
				(Say gEgo 460 12 108 self 67 -1 185) ; "Why, Larry! That would be wonderful."
			)
			(26
				(= ticks 30)
			)
			(27
				(pattiHead setCycle: 0)
				(pattiLeg dispose:)
				(= seconds 3)
			)
			(28
				(heart dispose:)
				(larryHead dispose:)
				(pattiHead dispose:)
				(quayle show:)
				(bigg show:)
				(gEgo show: cycleSpeed: 6 moveSpeed: 6)
				(desmond
					show:
					cycleSpeed: 6
					moveSpeed: 6
					setLoop: 3
					setCel: 0
					posn: 238 132
				)
				(larry show: cycleSpeed: 6 moveSpeed: 6)
				(pattiChair show:)
				(pattiChair init:)
				(desmondChair init:)
				(patDaisChair show:)
				(desDaisChair show:)
				(marilyn show:)
				(roger show:)
				(humphrey show:)
				(sleeper show:)
				(= cycleColors 0)
				(gCurRoom drawPic: 460)
				(gTheMusic2 fade: 0 15 12 1 self)
			)
			(29
				(dinnerFX play:)
				(gTheMusic pause: 0)
				(= seconds 3)
			)
			(30
				(Say gEgo 460 13 67 -1 28) ; "Come on, Inspector Desmond," you say, "we're gonna sit at the head table!"
				(larry setHeading: 90 self)
			)
			(31
				(desmond
					setLoop: 4
					setCycle: Walk
					setMotion: MoveTo 194 147 self
				)
			)
			(32
				(TPrint 460 14 80 {Larry} 67 -1 28) ; "Uh, Patti, er, well, I meant..." Larry stutters, then finally gives up. "Hi, Inspector. My name is Larry; Larry Laffer."
				(TPrint ; ""Charmed," grunts Desmond."
					460
					15
					67
					-1
					185
					80
					{Inspector Desmond}
				)
				(desmond setMotion: MoveTo 165 147 self)
			)
			(33
				(larry setHeading: 135 self)
			)
			(34
				(larry setHeading: 270)
				(gEgo cycleSpeed: 6 moveSpeed: 6 setMotion: MoveTo -10 142)
				(desmond setMotion: MoveTo -10 147)
				(= ticks 120)
			)
			(35
				(larry setStep: 3 2 setMotion: MoveTo -10 139 self)
			)
			(36
				(= seconds 5)
			)
			(37
				(gEgo
					view: 462
					setLoop: 5
					setCycle: Walk
					x: -10
					y: 87
					setPri: 3
					setMotion: MoveTo 102 87 self
				)
				(desDaisChair setPri: 4)
				(= ticks 90)
			)
			(38
				(desmond setScript: sDesmondSits)
			)
			(39
				(gEgo
					setLoop: 6
					setCel: 0
					setCycle: 0
					setMotion: MoveTo 103 95 self
				)
			)
			(40
				(gEgo
					setLoop: 1
					setCel: 0
					setPri: 5
					cycleSpeed: 12
					x: 101
					y: 71
				)
				(= cycles 1)
			)
			(41
				(larry
					view: 551
					loop: 0
					setPri: 4
					x: -10
					y: 82
					setCycle: Walk
					setMotion: MoveTo 26 82 self
				)
			)
			(42
				(= ticks 60)
			)
			(43
				(larry view: 461 setLoop: 6 setCel: 2)
				(= ticks 45)
			)
			(44
				(larry setCycle: CT 1 1 self)
			)
			(45
				(= ticks 45)
			)
			(46
				(larry setCycle: CT 2 -1 self)
			)
			(47
				((larry looper:) dispose:)
				(= ticks 45)
			)
			(48
				(larry view: 551 setLoop: 0 setLoop: -1 setCycle: Walk)
				(= cycles 1)
			)
			(49
				(TPrint 460 16 67 15 -1 70 280 80 {Larry}) ; "Uh, excuse me, Patti. Would you two scoot over a little so your guest of honor can sit down, too?"
				(= seconds 2)
			)
			(50
				(patDaisChair
					setLoop: 0
					setCel: 2
					setMotion: MoveTo (+ (patDaisChair x:) 3) (patDaisChair y:)
				)
				(gEgo setMotion: MoveTo 105 72 self)
			)
			(51
				(= cycles 3)
			)
			(52
				(desDaisChair
					setLoop: 0
					setCel: 2
					setMotion: MoveTo (+ (desDaisChair x:) 4) (desDaisChair y:)
				)
				(desmond setMotion: MoveTo 81 71 self)
			)
			(53
				(= cycles 5)
			)
			(54
				(patDaisChair
					setMotion: MoveTo (+ (patDaisChair x:) 4) (patDaisChair y:)
				)
				(gEgo setMotion: MoveTo 108 72 self)
			)
			(55
				(patDaisChair stopUpd:)
				(= cycles 3)
			)
			(56
				(desDaisChair
					setMotion: MoveTo (+ (desDaisChair x:) 3) (desDaisChair y:)
				)
				(desmond setMotion: MoveTo 86 71 self)
			)
			(57
				(desDaisChair stopUpd:)
				(gEgo setScript: sTalkDesmond)
				(ssguy init: setCycle: Walk setMotion: MoveTo 49 81 self)
			)
			(58
				(ssguy setLoop: 1 cycleSpeed: 10 setCycle: CT 5 1 self)
				(TPrint 460 17) ; "From nowhere, a Secret Service man appears with a folding chair."
			)
			(59
				(chairBack init:)
				(= cycles 1)
			)
			(60
				(ssguy setLoop: 1 setCycle: End self)
			)
			(61
				(ssguy
					setLoop: 2
					setCycle: Walk
					cycleSpeed: 6
					setPri: 0
					setMotion: MoveTo -50 81
				)
				(larry setMotion: MoveTo 64 82 self)
			)
			(62
				(roger startUpd:)
				(humphrey startUpd:)
				(larry setHeading: 180 self)
			)
			(63
				(larry
					loop: 2
					setCel: 0
					setCycle: 0
					setMotion: MoveTo 63 86 self
				)
			)
			(64
				(larry
					view: 461
					setLoop: 0
					setCel: 0
					setPri: 5
					cycleSpeed: 10
					x: 62
					y: 74
				)
				(= seconds 3)
			)
			(65
				(ssguy dispose:)
				(larry setCycle: End self)
			)
			(66
				(TPrint 460 18 67 15 -1 70 280 80 {Larry}) ; "You know, Mr. Vice President," Larry says, "you've always been a secret hero of mine! In fact, the Vice Presidency is one office to which I have always aspired to!"
				(= seconds 3)
			)
			(67
				(TPrint 460 19 80 {Mr. Vice President}) ; "Mr. Laffer," responds the Vice President, "has anyone ever mentioned to you that we look alike?"
				(TPrint 460 20 80 {Larry}) ; "Oh, of course. And am I proud!"
				(larry setCycle: Beg self)
			)
			(68
				(= seconds 3)
			)
			(69
				(larry setLoop: 1 setCycle: End self)
			)
			(70
				(= seconds 3)
			)
			(71
				(larry setCycle: Beg self)
			)
			(72
				(sTalkDesmond dispose:)
				(= seconds 3)
			)
			(73
				(bigg setCycle: End self)
			)
			(74
				(gEgo setLoop: 0 setCycle: End self)
			)
			(75
				(TPrint 460 21 67 -1 185) ; "Before you can talk to Larry or Desmond, you realize the large burly gentleman to your left is already speaking to you."
				(= cycles 1)
			)
			(76
				(gEgo hide:)
				(pattiChair hide:)
				(desmondChair hide:)
				(desmond hide:)
				(patDaisChair hide:)
				(desDaisChair hide:)
				(quayle hide:)
				(bigg hide:)
				(larry hide:)
				(marilyn hide:)
				(roger hide:)
				(humphrey hide:)
				(sleeper hide:)
				(chairBack hide:)
				(gCurRoom drawPic: 465)
				(dinnerFX stop:)
				(gTheMusic number: 465 play:)
				(= seconds 3)
			)
			(77
				(Say Mr__Bigg_IEr_Capoccia 460 22 108 139 self) ; "...and it's fortunate that you're here this evening as I'm only in town for a short time. Yes, I'm testifying tomorrow on Capitol Hill at the Senate hearings on pornography in the entertainment industry."
			)
			(78
				(Say You_ITu 460 23 108 139 self) ; ""Oh, really?" you say, feigning interest."
			)
			(79
				(Say Mr__Bigg_IEr_Capoccia 460 24 139 self) ; ""You've heard of me, then?" he swells up noticeably."
			)
			(80
				(Say Mr__Bigg_IEr_Capoccia 460 25 108 139 self) ; "Yes, my job is simple: tomorrow I intend to convince Congress to create tough, anti-pornography legislation tough enough to make the airwaves "Beaver" clean again, just like they were back in the Fifties!"
			)
			(81
				(= seconds 3)
			)
			(82
				(TPrint 460 26 67 -1 15 70 280) ; "You love these dinners and being seated next to people who feel their sole mission is to impress you with themselves!"
				(TPrint 460 27 67 -1 185) ; "(Especially a man who's breath is enough to curdle hairspray!)"
				(= seconds 3)
			)
			(83
				(Say Mr__Bigg_IEr_Capoccia 460 28 67 -1 185 108 139 self) ; "Allow me to introduce myself," he says, "I'm Mr. Bigg, a major West Coast corporate leader."
			)
			(84
				(Say You_ITu 460 29 108 139 self) ; ""My name is Passionate Patti," you reply."
			)
			(85
				(Say Mr__Bigg_IEr_Capoccia 460 30 67 -1 185 108 139 self) ; ""And I bet I can guess how you earned that name," he grins."
			)
			(86
				(= seconds 3)
			)
			(87
				(TPrint 460 31 67 -1 15 70 280) ; "What an obnoxious creep! Now he's humming at you. Some familiar song. A love song? Who does he think he's impressing?"
				(TPrint 460 32 67 -1 28) ; "What is that song," you think. "It sounds so familiar."
				(= seconds 3)
			)
			(88
				(TPrint 460 33 67 -1 185) ; "Realizing you are still unimpressed, Bigg digs in deeper."
				(Say Mr__Bigg_IEr_Capoccia 460 34 108 139 self) ; "You know, Patti (may I call you Patti?), I find you a very sexy woman. In fact, I've been looking for just such a woman for a new position I recently created."
			)
			(89
				(TPrint 460 35 67 -1 185) ; "Between phrases, he continues to hum that melody."
				(= seconds 3)
			)
			(90
				(Say Mr__Bigg_IEr_Capoccia 460 36 139 self) ; "Patti, you seem like a woman interested in quick success. Why don't you be the hostess of my new TV show?"
			)
			(91
				(Say Mr__Bigg_IEr_Capoccia 460 37 108 139 self) ; "For months I've had minions out hunting for the sexiest woman in America. But tonight, I've discovered her myself! Just say the word, Babe, and the gig is yours!"
			)
			(92
				(TPrint 460 38 67 -1 15 70 280 108 self) ; "At the mention of "sexiest woman in America," Larry's head jerks toward Bigg, his attention riveted on your conversation."
			)
			(93
				(= ticks 30)
			)
			(94
				(Say You_ITu 460 39 108 139 self) ; "Really, Mr. Bigg, your offer is not interest..."
			)
			(95
				(Say Mr__Bigg_IEr_Capoccia 460 40 67 -1 185 108 139 self) ; "Bigg interrupts you. "Oh, Patti! Stop being so formal. Please. Call me `Julius.'""
			)
			(96
				(= seconds 3)
			)
			(97
				(TPrint 460 41 67 -1 28) ; ""JULIUS!" you think, your mind racing!"
				(= seconds 3)
			)
			(98
				(gEgo show:)
				(pattiChair show:)
				(desmondChair show:)
				(desmond show:)
				(patDaisChair show:)
				(desDaisChair show:)
				(quayle show:)
				(bigg show:)
				(larry show:)
				(marilyn show:)
				(roger show:)
				(humphrey show:)
				(sleeper show:)
				(chairBack show:)
				(gCurRoom drawPic: 460)
				(gTheMusic number: 463 play:)
				(= ticks 60)
			)
			(99
				(gEgo setCycle: Beg)
				(bigg setCycle: Beg self)
			)
			(100
				(larry setLoop: 2 setCycle: End self)
			)
			(101
				(= seconds 2)
			)
			(102
				(TPrint 460 42 80 {Larry} 67 -1 185 70 280) ; "Patti, something's wrong," says Larry. "He's offering you the job as hostess of `America's Sexiest Home Videos!' But he has nothing to do with that show! I should know, I do! I was sent by the producer to find... Say, wait a minute. Could he be the money behind the show...?"
				(Say gEgo 460 43) ; "JULIUS!" you cry, suddenly putting everything together! "Desmond! Arrest this man!!"
				(TPrint 460 44 80 {Mr. Bigg}) ; ""WHAT?!" shouts Bigg."
				(Say gEgo 460 45 67 -1 185 70 280) ; "You scoundrel! You've been humming the love theme that I wrote for the soundtrack of `Larry 4!' That song was never published and the recording was never released! There's no way you could know it unless you played Larry 4!"
				(Say gEgo 460 46 67 -1 185 70 280) ; "Of course, I see it all now. Bigg, you're the man who hired me to create the music, then erased the floppies to keep from paying me! You're the reason my poor Larry has amnesia! You're the man behind K-RAP and des Rever Records! Julius Bigg--you're the man I've been following this entire game!""
				(TPrint 460 47 80 {Mr. Bigg}) ; "You're so smart, Patti!" screams Bigg, "let's see you deduce your way out of this!"
				(TPrint 460 48) ; "And leaping to his feet, he pulls a revolver and aims it directly at you!"
				(bigg setLoop: 1 setPri: 3 setCycle: End self)
			)
			(103
				(gTheMusic number: 466 play:)
				(TPrint 460 49 80 {Mr. Bigg}) ; ""Everybody stay away or I'll shoot!" shouts Bigg."
				(TPrint 460 50 80 {Larry}) ; "Larry cries out, "I'll save you, Sir!""
				(= cycles 1)
			)
			(104
				(marilyn setCycle: CT 8 1 self)
			)
			(105
				(pie init:)
				(marilyn setCycle: End self)
			)
			(106
				(larry
					setLoop: 3
					setCel: 0
					cycleSpeed: 10
					setCycle: CT 2 1 self
				)
			)
			(107
				(quayle hide:)
				(pie setPri: 5)
				(larry setCycle: End self)
			)
			(108
				(marilyn setLoop: 0 setCel: 0 setCycle: End self)
				(pieInFace play:)
			)
			(109
				(HandsOn)
				(User canControl: 0)
				(= seconds 6)
			)
			(110
				(TPrint 460 51) ; "Do something, Patti!"
				(= seconds 6)
			)
			(111
				(gCurRoom setScript: sCartoon2)
				(self dispose:)
			)
		)
	)
)

(instance sCartoon2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(TPrint 460 52) ; ""It's a good thing I wore that F.B.I. bra!" you think, touching your elbows behind your back."
				(gEgo
					setLoop: 7
					cycleSpeed: 5
					setCel: 0
					setPri: 4
					setCycle: End self
				)
			)
			(1
				(= ticks 30)
			)
			(2
				(fireBra play:)
				(gEgo
					setLoop: 2
					cycleSpeed: 6
					setCel: 0
					setCycle: CT 2 1 self
				)
			)
			(3
				(bigg setLoop: 2 setCycle: End)
				(= cycles 5)
			)
			(4
				(fireBra play:)
				(gEgo setCycle: CT 5 1 self)
			)
			(5
				(gTheMusic number: 461 setLoop: 1 play:)
				(gEgo setLoop: 3 setCel: 0 cycleSpeed: 10 setCycle: End self)
			)
			(6
				(= ticks 180)
			)
			(7
				(bigg hide:)
				(desmond
					x: 140
					y: 74
					setPri: 0
					setLoop: 1
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(8
				(desmond setLoop: 2 setCel: 0 setCycle: End self)
			)
			(9
				(= ticks 180)
			)
			(10
				(desmond cycleSpeed: 6 setMotion: MoveTo (gEgo x:) 74 self)
			)
			(11
				(TPrint 460 53 80 {Inspector Desmond}) ; "Congratulations, Patti!" says Desmond. "You've saved the Vice President's life! We'll haul this guy down to headquarters right now!"
				(TPrint 460 54 80 {Inspector Desmond}) ; "He whispers to you under his breath, "There goes our weekend together, Patti! I'll be stuck at the office filing paperwork on this low-life for days!""
				(desmond cycleSpeed: 5 setMotion: MoveTo -50 74)
				(gEgo setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 4) self)
			)
			(12
				(gEgo setLoop: 1 x: 108 y: 72 setPri: 5 setCel: 0)
				(gTheMusic fade:)
				(= ticks 240)
			)
			(13
				(gTheMusic number: 462 setVol: 127 setLoop: -1 play:)
				(larry setLoop: 4 setCel: 0 setCycle: End self)
			)
			(14
				(larry setLoop: 5 setCel: 0 setCycle: End self)
			)
			(15
				(pie setPri: 6)
				(larry setLoop: 0 setCel: 0 x: 62 y: 74)
				(quayle
					show:
					setLoop: 1
					setCel: 0
					x: 42
					y: 72
					setCycle: End self
				)
			)
			(16
				(TPrint 460 55 80 {Larry}) ; ""I'm sorry I shoved your face in that custard pie, Mr. Vice President!" Larry says."
				(quayle setLoop: 2 setCel: 0 posn: 38 71 setCycle: End self)
			)
			(17
				(= seconds 3)
			)
			(18
				(larry setLoop: 1 setCel: 0 setCycle: End self)
			)
			(19
				(Say gEgo 460 56) ; "You turn to Larry and say, "So... it looks like I'm free for the weekend. How about you?""
				(= ticks 90)
			)
			(20
				(quayle
					setLoop: 5
					setCel: 0
					posn: 42 72
					cycleSpeed: 11
					setCycle: End self
				)
			)
			(21
				(= ticks 60)
			)
			(22
				(quayle setCycle: Beg self)
			)
			(23
				(quayle
					setLoop: 3
					setCel: 0
					posn: 38 71
					cycleSpeed: 6
					setCycle: ForwardCounter 2 self
				)
			)
			(24
				(TPrint ; "Assuming you are talking to him, the Vice President whispers carefully, so as not to let his wife overhear, "Er, uh, well, yes. Perhaps I could set up a little excursion to Camp David...""
					460
					57
					67
					15
					-1
					70
					280
					80
					{Mr. Vice President}
				)
				(= cycles 1)
			)
			(25
				(larry setCycle: Beg self)
			)
			(26
				(larry setLoop: 0 setCycle: End self)
			)
			(27
				(TPrint 460 58 80 {Larry}) ; "Larry presumes the Vice President is being magnanimous. "Gee, thanks!" he says in a loud voice, "and I hope you and the missus get a chance to come along, too."
				(= seconds 2)
			)
			(28
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 1 6)
				(CenterDisplay 1 gColLGreen 460 59)
				(= seconds 3)
			)
			(29
				(gCurRoom newRoom: 480)
				(self dispose:)
			)
		)
	)
)

(instance sDesmondSits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(desmond
					setLoop: 5
					x: -10
					y: 84
					setPri: 4
					setMotion: MoveTo 76 84 self
				)
			)
			(1
				(desmond
					setLoop: 6
					setCel: 0
					setCycle: 0
					setMotion: MoveTo 76 95 self
				)
				(desDaisChair setPri: 1)
			)
			(2
				(desmond setLoop: 0 setCel: 0 x: 76 y: 70 stopUpd:)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sTalkDesmond of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(desmond setCycle: End self)
				(gEgo setCycle: End)
			)
			(2
				(= seconds 4)
			)
			(3
				(gEgo setCycle: Beg)
				(desmond setCycle: Beg self)
			)
			(4
				(self changeState: 0)
			)
		)
	)

	(method (dispose)
		(if (desmond cel:)
			(desmond setCycle: Beg)
		)
		(if (gEgo cel:)
			(gEgo setCycle: Beg)
		)
		(super dispose: &rest)
	)
)

(instance sRogerSleeps of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roger setCel: 0 setCycle: ForwardCounter 1 self)
			)
			(1
				(= seconds (Random 3 5))
			)
			(2
				(self changeState: 0)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sHumphreyDrinks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(humphrey setCel: 0 setCycle: ForwardCounter 1 self)
			)
			(1
				(= seconds (Random 4 6))
			)
			(2
				(self changeState: 0)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sSleeperSleeps of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sleeper setCel: 0 setCycle: ForwardCounter 1 self)
			)
			(1
				(= seconds 3)
			)
			(2
				(self changeState: 0)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance larry of Actor
	(properties
		x 320
		y 157
		description {Larry Laffer}
		view 550
		loop 1
		signal 16385
		cycleSpeed 5
		moveSpeed 5
	)
)

(instance sGroop of Grooper
	(properties)
)

(instance pattiActions of Actions
	(properties)

	(method (doVerb theVerb invItem)
		(if
			(or
				(and (== theVerb 4) (== invItem 13)) ; Inventory, Credit_Cards
				(and (== theVerb 3) (IsFlag 35)) ; Do
			)
			(Points 100)
			(gCurRoom setScript: sCartoon2)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance desmond of Actor
	(properties
		x 225
		y 127
		description {Desmond}
		view 464
		loop 3
		cel 1
		signal 16385
	)
)

(instance desmondChair of View
	(properties
		x 236
		y 127
		description {the chair}
		view 460
		cel 1
		signal 16385
	)
)

(instance pattiChair of View
	(properties
		x 120
		y 127
		description {the chair}
		view 460
		signal 16385
	)
)

(instance roger of Prop
	(properties
		x 139
		y 144
		description {Roger}
		view 460
		loop 1
		priority 14
		signal 16400
		cycleSpeed 24
		detailLevel 1
	)

	(method (init)
		(super init:)
		(self setScript: sRogerSleeps)
	)
)

(instance humphrey of Prop
	(properties
		x 139
		y 101
		description {Humphrey}
		view 460
		loop 3
		priority 10
		signal 16400
		cycleSpeed 12
		detailLevel 2
	)

	(method (init)
		(super init:)
		(self setScript: sHumphreyDrinks)
	)
)

(instance sleeper of Prop
	(properties
		x 224
		y 169
		description {the sleeping guest}
		view 460
		loop 2
		priority 14
		signal 16400
		cycleSpeed 24
		detailLevel 3
	)
)

(instance ssguy of Actor
	(properties
		x -50
		y 81
		description {the Secret Service man}
		view 466
		priority 4
		signal 16401
	)
)

(instance quayle of Prop
	(properties
		x 40
		y 74
		description {the Vice President}
		view 463
		priority 5
		signal 17
	)

	(method (init)
		(self setCycle: Fwd)
		(super init: &rest)
	)
)

(instance bigg of Prop
	(properties
		x 140
		y 74
		description {Mr. Bigg}
		view 465
		priority 5
		signal 16401
		cycleSpeed 10
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(13 ; Credit_Cards
						(Points 100)
						(gCurRoom setScript: sCartoon2)
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance pattiHead of Prop
	(properties
		x 158
		y 74
		view 471
		priority 5
		signal 16
	)
)

(instance larryHead of Prop
	(properties
		x 176
		y 84
		view 471
		loop 1
		priority 5
		signal 16
	)
)

(instance heart of Prop
	(properties
		x 176
		y 132
		view 470
		signal 16
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance pattiLeg of Prop
	(properties
		x 132
		y 149
		view 471
		loop 2
	)
)

(instance chairBack of Actor
	(properties
		x 61
		y 71
		description {the chair}
		view 460
		cel 3
		signal 16385
	)
)

(instance desDaisChair of Actor
	(properties
		x 75
		y 70
		description {the chair}
		view 460
		cel 2
		signal 16385
	)
)

(instance patDaisChair of Actor
	(properties
		x 101
		y 70
		description {the chair}
		view 460
		cel 2
		signal 16385
	)
)

(instance marilyn of Prop
	(properties
		x 14
		y 75
		description {Marilyn Quayle}
		view 467
		loop 1
		priority 5
		signal 16401
		cycleSpeed 10
	)
)

(instance pie of View
	(properties
		x 37
		y 74
		description {the pie}
		view 463
		loop 4
		priority 6
		signal 16401
	)
)

(instance dinnerFX of Sound
	(properties
		number 467
	)
)

(instance pieInFace of Sound
	(properties
		number 464
		priority 15
	)
)

(instance fireBra of Sound
	(properties
		number 434
	)
)

(instance Mr__Bigg_IEr_Capoccia of Talker
	(properties
		name {Mr. Bigg}
		x 20
		y 185
		nsTop 60
		nsLeft 150
		view 1466
		loop 3
		talkWidth 280
	)

	(method (init)
		(= mouth biggMouth)
		(super init: &rest)
	)
)

(instance biggMouth of Prop
	(properties
		nsTop 8
		nsLeft 6
		view 1466
		cycleSpeed 5
	)
)

(instance You_ITu of Talker
	(properties
		name {You}
		x 20
		y 5
		nsTop 70
		nsLeft 100
		view 1465
		loop 3
		talkWidth 160
	)

	(method (init)
		(= mouth pattiMouth)
		(= eyes pattiEyes)
		(super init: &rest)
	)
)

(instance pattiMouth of Prop
	(properties
		nsTop 9
		nsLeft 4
		view 1465
		cycleSpeed 5
	)
)

(instance pattiEyes of Prop
	(properties
		nsTop 1
		nsLeft 8
		view 1465
		loop 2
		cycleSpeed 5
	)
)

