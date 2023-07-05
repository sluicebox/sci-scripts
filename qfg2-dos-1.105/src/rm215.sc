;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 215)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use TopWindow)
(use Talker)
(use ProjClient)
(use n065)
(use Interface)
(use Blk)
(use ForwardCounter)
(use LoadMany)
(use Wander)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	rm215 0
)

(local
	detectedBell
	tkedBell
	theBell
	[windowParams 6] = [{Erasmus:} 11 5 {Fenrus:} 5 11]
)

(procedure (FailedPretestP)
	(HighPrint 215 12) ; "You hear the voice of Erasmus echoing in this chamber."
	(WhoPrint 0 215 13) ; "The spells to cast and their proper order should be obvious. They are to me."
	(WhoPrint 1 215 14) ; "That's because you made up this test."
	(WhoPrint 0 215 15) ; "At any rate, Hero, you should take some time and think about the situation next time. Adieu."
	(gCurRoom setScript: zapEgoOutS)
)

(procedure (WhoPrint who &tmp thisWin thisTitle whichWindow)
	(= thisWin (= thisTitle (* who 3)))
	(= whichWindow (if (== who 1) MidWindow else TopWindow))
	(whichWindow color: [windowParams (++ thisWin)] back: [windowParams (++ thisWin)])
	(Print &rest #title [windowParams thisTitle] #width 300 #window whichWindow #mode 1)
)

(procedure (FindBell projectile)
	(return
		(cond
			((leftBell onMe: projectile) leftBell)
			((midBell onMe: projectile) midBell)
			((rightBell onMe: projectile) rightBell)
			(else 0)
		)
	)
)

(instance blackCage of Cage
	(properties
		top 48
		left 133
		bottom 50
		right 183
	)
)

(instance rm215 of Rm
	(properties
		picture 2
		style 15
	)

	(method (dispose)
		(DisposeScript 949)
		(HandsOn 1)
		(super dispose:)
	)

	(method (init)
		(LoadMany rsVIEW 211 212 213 214 183)
		(Load rsSCRIPT 970)
		(Load rsSOUND 19 17 31 215)
		(MenuBar hide:)
		(super init:)
		(leftBell init: stopUpd:)
		(midBell init: stopUpd:)
		(rightBell init: stopUpd:)
		(InitAddToPics bellStand)
		(gEgo
			view: 211
			loop: 0
			cel: 0
			posn: 159 189
			init:
			ignoreActors:
			stopUpd:
		)
		(= gSpellChecker gAllChecker)
		(self setScript: pretestS)
	)
)

(instance pretestS of ProjClient
	(properties)

	(method (changeState newState &tmp whichBell [str 100])
		(switch (= state newState)
			(0
				(HighPrint 215 0) ; "You find yourself in a strange place. For some reason, you cannot move your legs, although you see nothing constraining them. A strange feeling passes through you, as though someone were examining you closely."
				(HandsOn 1)
				(HandsOff)
				(= cycles 4)
			)
			(1
				(if (not (and [gEgoStats 20] [gEgoStats 21] [gEgoStats 26])) ; detectSpell, triggerSpell, fetchSpell
					(WhoPrint 0 215 1) ; "Ah, I see now that you are not magically prepared for this test. You need to go out in the world and learn a bit more before returning."
					(client setScript: zapEgoOutS)
				else
					(DontTalk 0)
				)
				(= theBell 0)
			)
			(2
				(DontTalk 1)
				(gEgo setLoop: 2 cycleSpeed: 2 setCycle: End self)
				(gMiscSound number: 19 priority: 10 loop: 0 play:)
			)
			(3
				(if (not detectedBell)
					(= detectedBell
						(if tkedBell
							(cond
								((!= tkedBell rightBell) rightBell)
								((!= tkedBell leftBell) midBell)
							)
						else
							(switch (Random 1 3)
								(1 leftBell)
								(2 midBell)
								(3 rightBell)
							)
						)
					)
				)
				(detectedBell setCycle: ForwardCounter 6 self)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo setLoop: 0)
				(detectedBell setCel: 0 stopUpd:)
				(DontTalk 0)
			)
			(6
				(DontTalk 1)
				(gEgo setLoop: 1 cycleSpeed: 2)
				(self setScript: (AimSpell new:) self)
			)
			(7
				(if (= whichBell (FindBell self))
					(= tkedBell whichBell)
				)
				(gEgo setCycle: End self)
			)
			(8
				(if tkedBell
					(gMiscSound number: 17 priority: 10 loop: 0 play:)
					(lassoFor
						posn: 184 158
						cycleSpeed: 3
						setLoop: 7
						cel: 0
						init:
						setCycle: End
						setStep: 8 8
						setMotion: MoveTo (tkedBell x:) (+ (tkedBell y:) 8) self
					)
				else
					(FailedPretestP)
				)
			)
			(9
				(tkedBell setLoop: 0 setCycle: Fwd setMotion: MoveTo 158 40 self)
				(lassoFor
					setLoop: 6
					cycleSpeed: 0
					posn: (- (tkedBell x:) 27) (+ (tkedBell y:) 17)
					setCycle: Fwd
				)
				(lassoBack
					posn: (- (tkedBell x:) 27) (+ (tkedBell y:) 2)
					setCycle: Fwd
					init:
				)
			)
			(10
				(tkedBell moveSpeed: 2 setMotion: MoveTo 158 73 self)
			)
			(11
				(tkedBell setCel: 0 stopUpd:)
				(lassoFor dispose:)
				(lassoBack dispose:)
				(gEgo setCycle: Beg self)
			)
			(12
				(gEgo setLoop: 0)
				(DontTalk 0)
			)
			(13
				(self setScript: (AimSpell new:) self)
				(DontTalk 1)
			)
			(14
				(if
					(and
						(= whichBell (FindBell self))
						(== whichBell tkedBell)
						(== tkedBell detectedBell)
					)
					(= theBell whichBell)
					(theBell setLoop: 2 cel: 0 setCycle: End self)
					(gEgo setLoop: 1 setCycle: End)
					(gMiscSound number: 31 priority: 10 loop: 0 play:)
					(switch theBell
						(leftBell
							(zapBellS register: midBell)
							(rightBell setScript: zapBellS)
						)
						(rightBell
							(zapBellS register: midBell)
							(leftBell setScript: zapBellS)
						)
						(else
							(zapBellS register: rightBell)
							(leftBell setScript: zapBellS)
						)
					)
				else
					(HighPrint 215 2) ; "Nothing happens."
					(FailedPretestP)
				)
			)
			(15
				(theBell setLoop: 3 cel: 0 setCycle: ForwardCounter 8 self)
				(gCSound number: 215 loop: 1 priority: 0 playBed:)
			)
			(16
				(theBell setLoop: 2 cel: 0 setCycle: End self)
				(gEgo setCycle: Beg)
			)
			(17
				(theBell
					setLoop: 4
					cel: 0
					cycleSpeed: 1
					setCycle: ForwardCounter 3 self
				)
				(gEgo setLoop: 0)
			)
			(18
				(SolvePuzzle 686 7 1)
				(theBell loop: 8)
				(fenrus init:)
				(erasmus init: setCycle: CT 2 1 self)
			)
			(19
				(erasmus setCel: 3 setMotion: MoveTo 85 26 self)
			)
			(20
				(erasmus
					view: 214
					posn: 59 33
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(21
				(erasmus setLoop: 1 cel: 0 setCycle: End self)
			)
			(22
				(black1 init: posn: 45 20 setMotion: MoveTo 45 63 self)
				(black2 init: posn: 89 20 setMotion: MoveTo 89 63)
			)
			(23
				(fenrus hide:)
				(theBell
					setLoop: 5
					cycleSpeed: 0
					setCycle: ForwardCounter 3 self
				)
				(erasmus hide:)
			)
			(24
				(theBell setLoop: 8 stopUpd:)
				(fenrus show: setCycle: CT 2 1 self)
			)
			(25
				(fenrus setCel: 3 setMotion: MoveTo 221 27 self)
			)
			(26
				(fenrus
					posn: 240 33
					view: 214
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(27
				(fenrus setLoop: 2 cel: 0 setCycle: End self)
			)
			(28
				(black1 init: posn: 225 20 setMotion: MoveTo 225 63 self)
				(black2 init: posn: 269 20 setMotion: MoveTo 269 63)
			)
			(29
				(fenrus dispose:)
				(black2 dispose:)
				(black1 hide:)
				(theBell
					view: 213
					setLoop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(30
				(sparkle
					view: 213
					loop: 1
					cel: 0
					posn: 154 76
					init:
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(31
				(theBell setCycle: Beg self)
				(erasmus view: 213 setLoop: 3 cel: 0 posn: 168 49 show:)
				(black1
					show:
					setStep: 1 1
					posn: 168 49
					setMotion: Wander
					observeBlocks: blackCage
				)
			)
			(32
				(sparkle dispose:)
				(= cycles 6)
			)
			(33
				(erasmus tLoop: 2)
				(Say
					erasmus
					self
					(Format
						@str
						{Very good, %s.  You have shown yourself very capable in figuring out the spells needed for the pretest.}
						@gUserName
					)
				)
			)
			(34
				(erasmus cel: 1 tLoop: 2)
				(Say erasmus self 215 3) ; "However, before you can be considered a true Wizard, you must pass the trial of Initiation which the wizards of WIT will give you."
			)
			(35
				(erasmus tLoop: 2)
				(Say erasmus self 215 4) ; "I warn you, this test will take all of your wits and magical skills in order to succeed. If you succeed, you will then face ...but I can say no more."
			)
			(36
				(WhoPrint 1 215 5) ; "Say no more."
				(erasmus tLoop: 2)
				(Say erasmus self 215 6) ; "So, Hero, good luck!"
			)
			(37
				(erasmus loop: 3 cel: 2)
				(= cycles 8)
			)
			(38
				(WhoPrint 1 215 7) ; "Promises, promises. You said you would say no more! (heh, heh)"
				(erasmus tLoop: 2)
				(Say erasmus self 215 8) ; "Oh, Fenrus!"
			)
			(39
				(WhoPrint 1 (Format @str {Good luck, %s.} @gUserName))
				(gCSound fade:)
				(gCurRoom newRoom: 210)
			)
		)
	)

	(method (handleEvent event &tmp aSpell)
		(cond
			((super handleEvent: event))
			((Said 'save[/game]')
				(HighPrint 215 9) ; "You find yourself trapped between a second and infinity. In this place, there is no time, and you cannot save it."
			)
			((and (Said 'cast>') (= aSpell (SaidSpell event)))
				(switch aSpell
					(20
						(self changeState: 2)
					)
					(26
						(if tkedBell
							(WhoPrint 0 215 10) ; "You may use that spell only once here. Try another."
						else
							(self changeState: 6)
						)
					)
					(21
						(self changeState: 13)
					)
					(else
						(event claimed: 1)
						(HighPrint 215 11) ; "As you begin to cast the spell..."
						(FailedPretestP)
					)
				)
			)
		)
	)
)

(instance zapEgoOutS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= [gEgoStats 17] 0) ; stamina
				(sparkle
					view: 183
					loop: 0
					cel: 0
					posn: (gEgo x:) (- (gEgo y:) 36)
					setCycle: End self
					init:
				)
			)
			(1
				(sparkle dispose:)
				(gEgo hide:)
				(= cycles 4)
			)
			(2
				(= gRoomExitDir 3)
				(gCurRoom newRoom: 229)
			)
		)
	)
)

(instance zapBellS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sparkle
					init:
					posn: (register x:) (register y:)
					cel: 0
					setCycle: End self
				)
			)
			(1
				(register view: 214 cel: 0 setLoop: 4 setCycle: End self)
			)
			(2
				(sparkle
					posn: (client x:) (client y:)
					cel: 0
					setCycle: End self
				)
			)
			(3
				(client view: 214 cel: 0 setLoop: 4 setCycle: End self)
			)
			(4
				(register hide:)
				(client hide:)
				(sparkle dispose:)
				(self dispose:)
			)
		)
	)
)

(instance leftBell of Actor
	(properties
		x 89
		y 103
		noun '/bell'
		description {any of the bells}
		lookStr {If it looks like a bell, and it sounds like a bell, it's a bell.}
		view 212
		loop 1
		priority 10
		signal 16400
	)
)

(instance midBell of Actor
	(properties
		x 159
		y 129
		noun '/bell'
		description {any of the bells}
		lookStr {Ask not for whom the bell tolls...it tolls for YOU.}
		view 212
		loop 1
		priority 10
		signal 16400
	)
)

(instance rightBell of Actor
	(properties
		x 229
		y 103
		noun '/bell'
		description {any of the bells}
		lookStr {She was the belle of the ball 'til someone tolled on her.}
		view 212
		loop 1
		priority 10
		signal 16400
	)
)

(instance bellStand of PicView
	(properties
		x 158
		y 127
		noun '/stand[<bell]'
		description {the bell stand}
		lookStr {It's not real obvious at first what this does, but it's intricately carved.}
		view 214
		loop 3
		priority 8
		signal 16400
	)
)

(instance lassoFor of Actor
	(properties
		view 214
		loop 6
		priority 13
		signal 16400
	)
)

(instance lassoBack of Actor
	(properties
		view 214
		loop 5
		priority 9
		signal 16400
	)

	(method (doit)
		(lassoFor x: (- (tkedBell x:) 27))
		(lassoFor y: (+ (tkedBell y:) 17))
		(= x (- (tkedBell x:) 27))
		(= y (+ (tkedBell y:) 2))
		(super doit:)
	)
)

(instance erasmus of Talker
	(properties
		x 152
		y 80
		noun '/erasmus,wizard,mage,man'
		description {Erasmus}
		lookStr {It ain't Fenrus.}
		yStep 9
		view 212
		loop 6
		priority 2
		signal 22544
		xStep 9
		talkSpeed 0
		title {Erasmus:}
		color 11
		back 5
	)

	(method (init)
		(super init: &rest)
		(= tWindow MidWindow)
	)
)

(instance fenrus of Actor
	(properties
		x 166
		y 80
		noun '/fenrus,fenrus,fenrus,familiar,firework'
		description {Fenrus}
		lookStr {It ain't Erasmus.}
		yStep 9
		view 212
		loop 7
		priority 2
		signal 22544
		xStep 9
	)
)

(instance black1 of Actor
	(properties
		x 106
		y 66
		yStep 4
		view 213
		loop 4
		priority 14
		signal 22544
	)
)

(instance black2 of Actor
	(properties
		x 226
		y 66
		yStep 4
		view 213
		loop 4
		priority 14
		signal 22544
	)
)

(instance sparkle of Prop
	(properties
		view 183
		priority 15
		signal 16400
	)
)

