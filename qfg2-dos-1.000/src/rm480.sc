;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 480)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use Talker)
(use Full)
(use Interface)
(use MoveFwd)
(use LoadMany)
(use Timer)
(use Save)
(use Motion)
(use Game)
(use Actor)

(public
	rm480 0
)

(local
	[tempStr 50]
	[windowParams 40] = [{Kahla:} 1 15 0 0 {Layla:} 5 15 40 40 {Sulayma:} 2 15 80 20 {Nawar:} 12 1 220 30 {Budar:} 14 1 100 60 {Ruzhat:} 13 1 140 90 {Dunya:} 11 1 170 120 {Abu:} 15 0 0 160]
	[girlList 7]
	[servantGenList 38] = [8 9 10 7 7 7 7 7 7 11 7 12 13 7 14 15 16 7 7 7 7 7 17 18 19 7 7 7 7 7 20 7 21 7 7 7 7 7]
	[servantSpecList 16] = [0 '//ad<ad' 1 '//zayisha' 2 '//marry' 3 '//eunuch' 4 '//harem' 5 '//resistance,revolt,revolution' 6 '//forbidden' 0 0]
)

(procedure (WhoPrint who whoCares &tmp thisWin thisTitle [unused 2])
	(= thisWin (= thisTitle (* who 5)))
	(myWindow color: [windowParams (++ thisWin)] back: [windowParams (++ thisWin)])
	(Print
		&rest
		#title
		[windowParams thisTitle]
		#window
		myWindow
		#at
		[windowParams (++ thisWin)]
		[windowParams (++ thisWin)]
		#width
		130
		#mode
		1
		#dispose
		whoCares
		#time
		4
	)
)

(instance myWindow of SysWindow
	(properties)
)

(instance rm480 of Rm
	(properties
		picture 480
	)

	(method (init)
		(LoadMany rsVIEW 0 4 47 432 532 481 47)
		(Load rsTEXT 432)
		(Load rsSOUND 480)
		(= gNow (+ (* gDay 100) gTimeODay))
		(SolvePuzzle 713 3 2)
		(= gEgoGait 0) ; walking
		(NormalEgo)
		(super init:)
		(servant init:)
		(barli init: hide:)
		(kahla init:)
		(layla init:)
		(sulayma init:)
		(girl1 init:)
		(girl2 init:)
		(girl3 init:)
		(girl4 init:)
		(girl5 init:)
		(girl6 init:)
		(= [girlList 1] girl1)
		(= [girlList 2] girl2)
		(= [girlList 3] girl3)
		(= [girlList 4] girl4)
		(= [girlList 5] girl5)
		(= [girlList 6] girl6)
		(StartTimer aniTimer 2 4)
		(InitAddToPics vaseTable smallTable blueStand flowerStand pillows1 pillows2)
		(gCSound number: 480 loop: -1 priority: 0 playBed:)
		(self setScript: enterS)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((& (gEgo onControl: 1) $0200)
				(self setScript: byeS)
			)
			((& (gEgo onControl: 1) $1000)
				(self setScript: hurryS)
			)
		)
	)

	(method (dispose)
		(gTimers eachElementDo: #dispose eachElementDo: #delete)
		(gCSound stop:)
		(super dispose:)
	)

	(method (handleEvent event &tmp i)
		(cond
			((super handleEvent: event))
			((Said 'search,look,look[<at,around][/room,area][/!*]')
				(HighPrint 480 0) ; "It's a harem."
			)
		)
	)
)

(instance enterS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 481 loop: 0 cel: 0 x: 311 y: 80 init:)
				(= cycles 1)
			)
			(1
				(gEgo setPri: 9 cycleSpeed: 1 setCycle: End self)
			)
			(2
				(NormalEgo)
				(gEgo posn: 294 128 setMotion: MoveTo 270 128 self)
			)
			(3
				(Say servant self 480 1 480 2) ; "Welcome, Hero who aided Zayishah."
			)
			(4
				(servant setLoop: 4 setCel: 0 tLoop: 4)
				(self setScript: rCurtainS self 1)
			)
			(5
				(Say servant self 480 3 480 4 480 5) ; "The Dark One, Ad Avis, can be seen from the balcony off the next room. All are forbidden to watch what he is doing."
			)
			(6
				(self setScript: rCurtainS self 0)
			)
			(7
				(Say servant self 480 6) ; "This is the one who gave his clothes to Zayishah."
			)
			(8
				(WhoPrint 0 self 480 7) ; "How handsome he is."
			)
			(9
				(WhoPrint 1 self 480 8) ; "How strong his muscles are."
			)
			(10
				(WhoPrint 2 self 480 9) ; "Lucky Zayishah."
			)
			(11
				(WhoPrint 3 self 480 10) ; "If I had been her, clothes would not be the only things we exchanged in that room."
			)
			(12
				(WhoPrint 4 self 480 11) ; "If you had been her, you never would have left that room."
			)
			(13
				(WhoPrint 5 self 480 12) ; "How his hair shines like sunlight! His eyes, like starlight."
			)
			(14
				(WhoPrint 6 self 480 13) ; "Already, you moon for him."
			)
			(15
				(Say servant self 480 14) ; "You must go now, before Abu the Eunuch comes back."
			)
			(16
				(gEgo setPri: 9 setMotion: MoveTo 165 118 self)
			)
			(17
				(gEgo setPri: -1 setMotion: MoveTo 80 120 self)
			)
			(18
				(client setScript: graceS)
			)
		)
	)
)

(instance graceS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say servant self 480 15) ; "Wait! A guard comes! Hide quickly!"
			)
			(1
				(kahla setLoop: 2 cycleSpeed: 1 setCycle: End)
				(layla setLoop: 9 cycleSpeed: 1 setCycle: End)
				(sulayma setLoop: 6 cycleSpeed: 1 setCycle: End)
				(= cycles 12)
			)
			(2
				(gEgo view: 481 setLoop: 3 setCel: 0)
				(= cycles 8)
			)
			(3
				(gEgo setCycle: CT 2 1)
				(= cycles 12)
			)
			(4
				(gEgo setCycle: End)
				(= cycles 8)
			)
			(5
				(gEgo view: 0 setLoop: -1 setHeading: 90 self)
			)
			(6
				(gEgo view: 47 setLoop: 0 setCel: 0 setCycle: End self)
				(servant setLoop: 3 setCel: 0 tLoop: 3)
			)
			(7
				(barli show: setCycle: End self)
			)
			(8
				(Say barli self 480 16 480 17) ; "There is an uprising in the city and the people are trying to break down the gate!"
			)
			(9
				(WhoPrint 0 self 480 18) ; "A stranger?"
			)
			(10
				(WhoPrint 1 self 480 19) ; "In here?"
			)
			(11
				(WhoPrint 2 self 480 20) ; "Whatever would we do?"
			)
			(12
				(WhoPrint 3 self 480 21) ; "(I can think of several things.)"
			)
			(13
				(WhoPrint 4 self 480 22) ; "(Shhh.)"
			)
			(14
				(WhoPrint 5 self 480 23) ; "But you, Barli, you will protect us from strangers."
			)
			(15
				(WhoPrint 6 self 480 24) ; "No stranger could possibly get past you."
			)
			(16
				(Say barli self 480 25) ; "This is, of course, true. No one can get by me."
			)
			(17
				(Say servant self 480 26) ; "Then perhaps you should go back to your watch."
			)
			(18
				(WhoPrint 0 self 480 27) ; "We feel so safe."
			)
			(19
				(WhoPrint 1 self 480 28) ; "With you out there."
			)
			(20
				(WhoPrint 2 self 480 29) ; "No stranger would dare enter."
			)
			(21
				(WhoPrint 3 self 480 30) ; "(Enter what?)"
			)
			(22
				(WhoPrint 4 self 480 22) ; "(Shhh.)"
			)
			(23
				(WhoPrint 5 self 480 31) ; "Thank you for warning us."
			)
			(24
				(WhoPrint 6 self 480 32) ; "We will be very, very careful."
			)
			(25
				(Say barli self 480 33) ; "You know I will protect you."
			)
			(26
				(Say servant self 480 34) ; "Go, before some stranger tries to sneak up upon the battlements."
			)
			(27
				(Say barli self 480 35) ; "Who could do that? There are guards below!"
			)
			(28
				(Say servant self 480 36) ; "Go before Khaveen catches you away from your post."
			)
			(29
				(Say barli self 480 37) ; "Khaveen? Oh, my."
			)
			(30
				(barli setCycle: Beg self)
				(servant setLoop: 4 setCel: 0 tLoop: 4)
			)
			(31
				(barli hide:)
				(kahla setCycle: Beg)
				(layla setCycle: Beg)
				(sulayma setCycle: Beg)
				(gEgo setCycle: Beg self)
			)
			(32
				(NormalEgo)
				(gEgo setHeading: 90)
				(= cycles 8)
			)
			(33
				(client setScript: hideS)
			)
		)
	)
)

(instance hideS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say servant self 480 38) ; "Hero, go behind the curtain! Abu returns."
			)
			(1
				(self setScript: lCurtainS self 1)
			)
			(2
				(= cycles 2)
			)
			(3
				(self setScript: lCurtainS self 0)
			)
			(4
				(Say servant self 480 39) ; "Quickly, go to the doorway and sneak into the other room."
			)
			(5
				(WhoPrint 5 self 480 40) ; "Couldn't he stay longer?"
			)
			(6
				(WhoPrint 6 self 480 41) ; "He just got here."
			)
			(7
				(Say servant self 480 42) ; "Quiet. Go now, Hero, before we all get caught."
				(StartTimer guardTimer 60)
			)
			(8
				(self dispose:)
			)
		)
	)
)

(instance rCurtainS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (gEgo x:) 213)
					(gEgo setMotion: MoveTo 237 109 self)
				else
					(gEgo setMotion: MoveTo 189 109 self)
				)
			)
			(1
				(gEgo setMotion: MoveTo 213 111 self)
			)
			(2
				(gEgo posn: 198 90 view: 481 setLoop: 4 setCel: 0 setPri: 8)
				(= cycles 1)
			)
			(3
				(if register
					(abu
						init:
						x: 0
						setCycle: Walk
						setMotion: MoveTo 128 (abu y:) self
					)
				else
					(abu
						init:
						x: 284
						setCycle: Walk
						setMotion: MoveTo 231 (abu y:) self
					)
				)
			)
			(4
				(if register
					(abu setMotion: MoveTo 192 (abu y:) self)
				else
					(abu setMotion: MoveTo 160 (abu y:) self)
				)
				(gEgo setCycle: End)
				(= cycles 8)
			)
			(5
				(gEgo setCycle: Beg)
			)
			(6
				(if register
					(abu setMotion: MoveTo 284 (abu y:) self)
				else
					(abu setMotion: MoveTo 0 (abu y:) self)
				)
				(gEgo setCycle: End)
				(= cycles 8)
			)
			(7
				(gEgo setCycle: Beg)
			)
			(8
				(gEgo posn: 213 111 setLoop: 1 setPri: -1 setCycle: End self)
			)
			(9
				(NormalEgo)
				(gEgo
					illegalBits: 0
					x: (- (gEgo x:) 11)
					setMotion:
						MoveTo
						(- (gEgo x:) 20)
						(+ (gEgo y:) 5)
						self
				)
			)
			(10
				(abu dispose:)
				(gEgo illegalBits: -32768 setHeading: 180)
				(self dispose:)
			)
		)
	)
)

(instance lCurtainS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (gEgo x:) 213)
					(gEgo setMotion: MoveTo 167 109 self)
				else
					(gEgo setMotion: MoveTo 119 109 self)
				)
			)
			(1
				(gEgo setMotion: MoveTo 143 111 self)
			)
			(2
				(gEgo posn: 126 90 view: 481 setLoop: 4 setCel: 0 setPri: 8)
				(= cycles 1)
			)
			(3
				(if register
					(abu
						init:
						x: 0
						setCycle: Walk
						setMotion: MoveTo 128 (abu y:) self
					)
				else
					(abu
						init:
						x: 284
						setCycle: Walk
						setMotion: MoveTo 231 (abu y:) self
					)
				)
			)
			(4
				(if register
					(abu setMotion: MoveTo 192 (abu y:) self)
				else
					(abu setMotion: MoveTo 160 (abu y:) self)
				)
				(gEgo setCycle: End)
				(= cycles 8)
			)
			(5
				(if register
					(WhoPrint 0 0 480 43) ; "What a pretty smile."
				else
					(WhoPrint 3 0 480 44) ; "(And a tongue made for ...)"
				)
				(gEgo setCycle: Beg)
			)
			(6
				(if register
					(abu setMotion: MoveTo 284 (abu y:) self)
				else
					(abu setMotion: MoveTo 0 (abu y:) self)
				)
				(gEgo setCycle: End)
				(= cycles 8)
			)
			(7
				(if register
					(WhoPrint 1 0 480 45) ; "With teeth like Pearl."
				else
					(WhoPrint 4 0 480 46) ; "(Nawar!)"
				)
				(gEgo setCycle: Beg)
			)
			(8
				(gEgo posn: 143 111 setLoop: 1 setPri: -1 setCycle: End self)
			)
			(9
				(NormalEgo)
				(gEgo
					x: (- (gEgo x:) 11)
					setMotion:
						MoveTo
						(- (gEgo x:) 25)
						(+ (gEgo y:) 5)
						self
				)
			)
			(10
				(if register
					(WhoPrint 2 self 480 47) ; "And lips made for kissing."
				)
				(abu dispose:)
				(gEgo illegalBits: -32768 setHeading: 180)
				(self dispose:)
			)
		)
	)
)

(instance hurryS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say servant self 480 48) ; "Hurry, Hero!"
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(gEgo setMotion: MoveFwd 10 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance byeS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(WhoPrint 0 self 480 49) ; "Farewell."
			)
			(1
				(gEgo setHeading: 135 self)
			)
			(2
				(= cycles 8)
			)
			(3
				(gEgo
					setMotion:
						MoveTo
						(- (gEgo x:) 10)
						(+ (gEgo y:) 10)
						self
				)
			)
			(4
				(WhoPrint 1 self 480 50) ; "Good luck."
			)
			(5
				(WhoPrint 2 self 480 51) ; "Come back soon."
			)
			(6
				(WhoPrint 3 self 480 52) ; "Perhaps, later tonight?"
			)
			(7
				(WhoPrint 4 self 480 53) ; "And the next night, and the next?"
			)
			(8
				(gEgo setHeading: 135 self)
			)
			(9
				(= cycles 8)
			)
			(10
				(gEgo
					setMotion:
						MoveTo
						(- (gEgo x:) 10)
						(+ (gEgo y:) 10)
						self
				)
			)
			(11
				(WhoPrint 5 self 480 54) ; "Such stories we could tell you."
			)
			(12
				(WhoPrint 6 self 480 55) ; "Such tales we could make."
			)
			(13
				(WhoPrint 3 self 480 56) ; "Speaking of making tails..."
			)
			(14
				(WhoPrint 4 self 480 57) ; "Your mind is always on that end."
			)
			(15
				(WhoPrint 3 self 480 58) ; "If the means justify it."
			)
			(16
				(Say servant self 480 59) ; "Be careful. It is very dangerous out there. May fortune favor you, and may you go before you get caught!"
			)
			(17
				(gEgo view: 481 setLoop: 2 cycleSpeed: 1 setCycle: End self)
			)
			(18
				(gCurRoom newRoom: 530)
			)
		)
	)
)

(instance guardS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(abu
					posn: 0 133
					init:
					setCycle: Walk
					setMotion: MoveTo 29 133 self
				)
			)
			(1
				(WhoPrint 7 self 480 60) ; "Hey! You're not a harem girl, you're too ugly!"
			)
			(2
				(WhoPrint 7 self 480 61) ; "But then again, you are busted!"
			)
			(3
				(EgoDead 1 480 62 #title {Harem today, goon tomorrow}) ; "You were pressed for time, but only politicians can press the flesh and get away with it."
			)
		)
	)
)

(instance servant of Talker
	(properties
		x 217
		y 117
		description {Mayzun}
		lookStr {Mayzun in Zayishah's servant.}
		view 432
		illegalBits 0
		tLoop 3
		talkSpeed 1
		myName '//servant,mayzun,woman'
		title {Mayzun:}
		back 13
		msgFile 432
	)

	(method (atSpec which)
		(return [servantSpecList which])
	)

	(method (atGen which)
		(return [servantGenList which])
	)
)

(instance barli of Talker
	(properties
		x 309
		y 78
		description {Barli}
		lookStr {Barli looks like one tough Eunuch.}
		view 533
		priority 8
		signal 16400
		illegalBits 0
		tLoop 1
		talkSpeed 1
		myName '//barli,eunuch,man'
		title {Barli:}
		color 15
		back 8
	)
)

(instance abu of Actor
	(properties
		x 75
		y 93
		view 532
		signal 16384
		illegalBits 0
	)
)

(instance kahla of Prop
	(properties
		x 90
		y 132
		view 482
		loop 3
		signal 1
	)
)

(instance layla of Prop
	(properties
		x 105
		y 130
		view 482
		loop 9
		signal 1
	)
)

(instance sulayma of Prop
	(properties
		x 118
		y 128
		view 482
		loop 6
		signal 1
	)
)

(instance girl1 of Prop
	(properties
		x 226
		y 189
		view 483
		loop 4
		signal 1
		cycleSpeed 1
	)
)

(instance girl2 of Prop
	(properties
		x 258
		y 146
		view 483
		loop 5
		signal 1
		cycleSpeed 1
	)
)

(instance girl3 of Prop
	(properties
		x 194
		y 189
		view 483
		loop 3
		signal 1
		cycleSpeed 1
	)
)

(instance girl4 of Prop
	(properties
		x 171
		y 189
		view 483
		loop 2
		signal 1
		cycleSpeed 1
	)
)

(instance girl5 of Prop
	(properties
		x 138
		y 189
		view 483
		loop 1
		signal 1
		cycleSpeed 1
	)
)

(instance girl6 of Prop
	(properties
		x 77
		y 188
		view 483
		signal 1
		cycleSpeed 1
	)
)

(instance aniTimer of Timer
	(properties)

	(method (cue &tmp theGirl)
		(= theGirl [girlList (Random 1 6)])
		(theGirl setCycle: stopFullLoop 1)
		(StartTimer aniTimer 2 4)
	)
)

(instance stopFullLoop of Full
	(properties)

	(method (cycleDone)
		(super cycleDone:)
		(if completed
			(client stopUpd:)
		)
	)
)

(instance guardTimer of Timer
	(properties)

	(method (cue)
		(gCurRoom setScript: guardS)
	)
)

(instance vaseTable of PicView
	(properties
		x 161
		y 150
		view 480
		loop 2
	)
)

(instance smallTable of PicView
	(properties
		x 194
		y 153
		view 480
		loop 3
	)
)

(instance blueStand of PicView
	(properties
		x 312
		y 143
		view 480
		loop 5
	)
)

(instance flowerStand of PicView
	(properties
		x 182
		y 111
		view 480
		loop 1
	)
)

(instance pillows1 of PicView
	(properties
		x 252
		y 171
		view 480
		loop 4
	)
)

(instance pillows2 of PicView
	(properties
		x 76
		y 183
		view 480
		loop 6
	)
)

