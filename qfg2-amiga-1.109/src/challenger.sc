;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 321)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use n003)
(use HandsOffScript)
(use TopWindow)
(use Talker)
(use Interface)
(use LoadMany)
(use Rev)
(use Avoid)
(use Motion)
(use Actor)
(use System)

(public
	challenger 0
)

(local
	[challengerGenList 33] = [1 2 3 0 0 0 4 0 0 0 0 5 6 0 7 8 9 0 10 11 12 0 13 14 15 16 0 0 0 17 18 0 19]
	[challengerSpecList 10] = [52 '//challenge,offer' 54 '//bet,bet' 56 '//dinar' 57 '//wind' 0 0]
	[downDeltaX 6] = [2 1 0 3 3 3]
	[downDeltaY 6] = [18 4 4 11 4 32]
	[upDeltaX 6] = [1 -2 -2 1 3 -2]
	[upDeltaY 6] = [-41 -3 -14 3 -4 -17]
	[LdeltaX 4] = [-5 -6 -1 -2]
	[LdeltaY 4] = [12 16 20 30]
	[RdeltaX 5] = [2 6 3 16 5]
	[RdeltaXS 5]
	[RdeltaY 5] = [10 11 8 11 20]
	Index
	challengeStatus
	challengeTimer
	fallTimer
	whichChallenge
	theCheck = 1
	centered
	stepCount
	sideKeys
	jumpIncr = 5
	egosInTheRoom
	showedEm
	probAdj
	justStarting
	challengedOnGround
	holdCounter
	[str 100]
	[rmnString 100]
)

(procedure (TryProb incSkill &tmp chance margin difficulty)
	(= difficulty (+ (* gArcadeLevel -10) 20))
	(if (< (= chance (+ (- [gEgoStats 2] 40) difficulty probAdj)) 5) ; agility
		(= chance 5)
	)
	(if (> chance 95)
		(= chance 95)
	)
	(if (< (= margin (- chance (Random 1 100))) 0)
		(= margin 0)
		(= incSkill 1)
	)
	(SkillUsed 2 incSkill) ; agility
	(return margin)
)

(procedure (TellRules &tmp c b)
	(= c (instWin color:))
	(= b (instWin back:))
	(Print ; "Left Arrow . . try to step forward Right Arrow . hold your position Up Arrow . . . correct by leaning right Down Arrow . . correct by leaning left"
		321
		0
		35
		instWin
		80
		{Instructions:}
		28
		c
		29
		b
		67
		0
		-1
		30
		0
		103
		70
		230
	)
)

(procedure (checkBalance) ; UNUSED
	(cond
		((> justStarting 6))
		((TryProb 0)
			(if (> centered 0)
				(-- centered)
			else
				(++ centered)
			)
		)
		((< centered 0)
			(-- centered)
		)
		(else
			(++ centered)
		)
	)
)

(procedure (StraightAndLevel)
	(gEgo view: 285 setLoop: 3 cel: 0 setPri: 11 cycleSpeed: 1 setCycle: Fwd)
)

(procedure (FallingRight)
	(gEgo view: 285 setLoop: 2 cel: 0 setPri: 11 cycleSpeed: 1 setCycle: Fwd)
	(= fallTimer (- 21 (* 3 gArcadeLevel)))
)

(procedure (FallingLeft)
	(gEgo view: 285 setLoop: 1 cel: 0 setPri: 11 cycleSpeed: 1 setCycle: Fwd)
	(= fallTimer (- 21 (* 3 gArcadeLevel)))
)

(procedure (HoldPosition)
	(gEgo view: 285 loop: 4 cel: 0 setPri: 11 cycleSpeed: 1 setCycle: Fwd)
	(= sideKeys 0)
)

(procedure (CorrectLeft &tmp margin)
	(cond
		((> (= margin (TryProb 8)) 10)
			(= centered 0)
			(= sideKeys 0)
			(StraightAndLevel)
		)
		((or margin (< (Random 1 100) 25))
			(= centered 0)
			(FallingLeft)
		)
	)
)

(procedure (CorrectRight &tmp margin)
	(cond
		((> (= margin (TryProb 8)) 10)
			(= centered 0)
			(= sideKeys 0)
			(StraightAndLevel)
		)
		((or margin (< (Random 1 100) 25))
			(= centered 0)
			(FallingRight)
		)
	)
)

(procedure (CanEgoStep)
	(cond
		((or (> justStarting 6) (TryProb 12))
			(gEgo setScript: stepForward)
		)
		((Random 0 1)
			(= sideKeys 1)
			(FallingLeft)
		)
		(else
			(= sideKeys 1)
			(FallingRight)
		)
	)
)

(procedure (RestartIt)
	(= challengeStatus 0)
	(= theCheck 0)
	(= stepCount 0)
)

(instance instWin of BotWindow
	(properties
		color 14
		back 8
	)
)

(instance challenger of Talker
	(properties
		x 268
		y 71
		description {the tightrope challenger}
		lookStr {The man is built just like an acrobat.}
		view 325
		priority 11
		signal 24592
		illegalBits 0
		tLoop -1
		talkSpeed 1
		myName '//challenger,man,acrobat,agi'
		title {Challenger:}
		back 11
		msgFile 325
	)

	(method (init &tmp i)
		(LoadMany rsVIEW 285 325 320 6)
		(Load rsSCRIPT 969)
		(InitAddToPics pillarOne pillarTwo ropeTight)
		(ropeOne init: stopUpd:)
		(ropeTwo init: stopUpd:)
		(chMouth init:)
		(super init:)
		(for ((= i 0)) (< i (Random 2 6)) ((++ i))
			(InitAddToPics
				((watcher new:)
					view: (Random 351 353)
					x: (Random 1 (- (gEgo x:) 15))
					y: (+ (* (Random 1 12) 2) 200)
					palette: (Random 1 4)
				)
			)
		)
		(for ((= i 0)) (< i (Random 2 6)) ((++ i))
			(InitAddToPics
				((watcher new:)
					view: (Random 351 353)
					x: (Random (+ (gEgo x:) 15) 300)
					y: (+ (* (Random 1 12) 2) 200)
					palette: (Random 1 4)
				)
			)
		)
		(= tWindow BotWindow)
		(cond
			((<= gDay 4)
				(= probAdj 0)
			)
			((and (>= gDay 16) (not (IsFlag 15))) ; fTightrope
				(= probAdj 5)
			)
			(else
				(= probAdj -10)
			)
		)
	)

	(method (atSpec which)
		(return [challengerSpecList which])
	)

	(method (atGen which)
		(return [challengerGenList which])
	)

	(method (messages)
		(= state -1)
		(self setLoop: 0 cel: 0 setCycle: End self)
		(chMouth setCycle: Fwd)
		(super messages: &rest)
	)

	(method (endTalk)
		(self setCycle: Beg)
		(chMouth setCycle: 0 cel: 0)
		(super endTalk:)
	)

	(method (doit)
		(if (and (not egosInTheRoom) (== (gCurRoom inOut:) 3))
			(= egosInTheRoom 1)
			(cond
				((== gDay 8)
					(if (== 1 gEnter320)
						(self setScript: eighthDay)
					else
						(Say
							challenger
							(challenger msgFile:)
							(+ 32 (mod (+ 1 gEnter320) 3))
						)
					)
				)
				((or (== gDay 11) (== gDay 16))
					(Say
						challenger
						(challenger msgFile:)
						(+ 36 (mod gEnter320 4))
					)
				)
				((not (IsFlag 160)) ; fFirstTime320
					(self setScript: chooseOff)
				)
				((IsFlag 14) ; fTightropeWin
					(if (== 1 gEnter320)
						(Say challenger (challenger msgFile:) 40)
					else
						(Say
							challenger
							(challenger msgFile:)
							(+ 40 (mod (+ 1 gEnter320) 3))
						)
					)
				)
				((or (== gDay 2) (== gDay 4))
					(cond
						((IsFlag 15) ; fTightrope
							(Say
								challenger
								(challenger msgFile:)
								(+ 27 (mod gEnter320 3))
							)
						)
						((and (== 1 gEnter320) (not (== gDay 4)))
							(self setScript: chooseOff)
						)
						(else
							(Say
								challenger
								(challenger msgFile:)
								(+ 24 (mod (+ 1 gEnter320) 3))
							)
						)
					)
				)
			)
		)
		(if (and (not (& (gEgo illegalBits:) $2000)) (!= challengeStatus 3))
			(gEgo illegalBits: (| (gEgo illegalBits:) $2000))
		)
		(if
			(and
				(<= (gEgo x:) 97)
				(<= (gEgo y:) 63)
				(== challengeStatus 3)
				(gCurRoom script:)
			)
			(gCurRoom setScript: 0)
			(gEgo setScript: cominDown)
			(if (< (challenger x:) 160)
				(challenger setScript: stepAside)
			)
		)
		(if
			(and
				(not (gEgo script:))
				(<= (gEgo y:) 92)
				(< (gEgo priority:) 8)
			)
			(gCurRoom newRoom: 160)
		)
		(cond
			((gEgo script:))
			((not challengeTimer))
			((-- challengeTimer))
			((== whichChallenge 0)
				(if (< (gEgo y:) 188)
					(self setScript: askingEgo)
				)
			)
			((== whichChallenge 1)
				(self setScript: itsEasy)
			)
			((== whichChallenge 2)
				(Say challenger 321 1) ; "Is there no one of courage among you? Will no one take my challenge?"
			)
		)
		(cond
			((not fallTimer))
			((-- fallTimer))
			((== (gEgo loop:) 1)
				(gEgo setScript: crashAndBurn 0 0)
			)
			((== (gEgo loop:) 2)
				(gEgo setScript: crashAndBurn 0 1)
			)
		)
		(cond
			((< centered -2)
				(= centered 0)
				(FallingLeft)
			)
			((> centered 2)
				(= centered 0)
				(FallingRight)
			)
		)
		(super doit:)
	)

	(method (handleEvent event &tmp rc moneyPot)
		(cond
			((super handleEvent: event))
			(
				(or
					(Said 'search,look,look[<at,around][/room,area][/!*]')
					(Said 'look,look/courtyard')
				)
				(HighPrint 321 2) ; "A tightrope walker and his equipment take center stage in the Plaza today."
			)
			((Said 'climb,climb[<up][/rope]')
				(cond
					((>= gTightWinCount 3)
						(Say challenger 321 3) ; "No more, Effendi. I have lost too much money on you."
					)
					((< challengeStatus 1)
						(Say challenger 321 4) ; "First, Effendi, you must wager with me!"
					)
					((== challengeStatus 2)
						(self setScript: cominUp)
					)
					(else
						(Say challenger 321 5) ; "Effendi, first your dinar."
					)
				)
			)
			(
				(or
					(Said 'yes')
					(Said 'make,get,place/bet,bet,challenge')
					(Said 'bet')
					(Said 'challenge/man')
				)
				(= challengeTimer 0)
				(cond
					((not (TrySkill 16 70)) ; health
						(Say challenger self 321 6) ; "Rest, recover before you seek to cross the rope again.  You might do yourself an injury, and I cannot permit a brave man to harm himself for my gain."
					)
					((>= gTightWinCount 3)
						(Say challenger 321 7) ; "I have lost all the money I can lose."
					)
					((== challengeStatus 2)
						(if (== gDay 8)
							(Say challenger 321 8) ; "Yes, yes. Climb up and win the ten dinars"
						else
							(Say challenger 321 9) ; "Yes, yes. Climb up and win the five dinars"
						)
					)
					((and (< challengeStatus 1) (< (challenger y:) 90))
						(= challengeStatus 1)
						(= theCheck 1)
						(gEgo setScript: comeOnDown)
					)
					(else
						(Say challenger 321 10) ; "Well then, Effendi, where is your dinar?"
					)
				)
			)
			(
				(Said
					'give,pay,bet/dinar,alm,(cent<100),challenger,man,acrobat,agi'
				)
				(= challengeTimer 0)
				(cond
					((== (= rc (CheckFunds 100)) 0)
						(HighPrint 321 11) ; "You don't have one to give."
					)
					((== rc 1)
						(Say challenger 321 12) ; "I only accept the coin of Shapeir, my friend."
					)
					((>= gTightWinCount 3)
						(Say challenger 321 13) ; "We'll wager no more. I have lost all the money I can lose."
					)
					((== challengeStatus 2)
						(= moneyPot (if (== gDay 8) {ten} else {five}))
						(Say challenger (Format @rmnString 321 14 moneyPot)) ; "But Effendi, I have your dinar. But climb up and cross the rope, and %s dinars are yours."
					)
					((and (< (challenger y:) 110) (IsFlag 15) (!= challengeStatus 2)) ; fTightrope
						(= challengeStatus 2)
						(Say challenger 321 15) ; "So, Effendi, let us see if you can walk the rope again."
					)
					((not (< (challenger y:) 110))
						(SetFlag 15) ; fTightrope
						(= challengeStatus 2)
						(GiveMoney 100)
						(self setScript: showEmHow)
					)
					(else
						(Say challenger 321 16) ; "Did you wish to wager, Effendi?"
					)
				)
			)
			((Said 'no')
				(= challengeTimer 0)
				(cond
					((== challengeStatus 2)
						(Say challenger 321 17) ; "Effendi, you must not turn away now that we have wagered. Climb the rope!"
					)
					(theCheck
						(if (< (challenger x:) 160)
							(Say challenger 321 1) ; "Is there no one of courage among you? Will no one take my challenge?"
						else
							(self setScript: itsEasy)
						)
					)
					((or (< (challenger y:) 110) challengedOnGround)
						(Say challenger 321 1) ; "Is there no one of courage among you? Will no one take my challenge?"
						(= challengedOnGround 0)
					)
					(else
						(Say challenger 321 18) ; "I know not. Of what do you speak, Effendi?"
					)
				)
			)
		)
	)
)

(instance chMouth of Prop
	(properties
		z 36
		view 325
		loop 9
		signal 24576
		cycleSpeed 1
	)

	(method (doit)
		(self
			x: (challenger x:)
			y: (challenger y:)
			setPri: (+ (challenger priority:) 1)
		)
		(super doit:)
	)
)

(instance watcher of PicView
	(properties
		loop 3
	)
)

(instance pillarOne of PicView
	(properties
		x 85
		y 127
		noun '/platform'
		description {the tightrope platform}
		lookStr {It is a high platform, part of a portable tightrope setup.}
		view 320
		loop 1
		signal 16384
	)
)

(instance pillarTwo of PicView
	(properties
		x 262
		y 138
		noun '/platform'
		description {the tightrope platform}
		lookStr {It is a high platform, part of a portable tightrope setup.}
		view 320
		loop 2
		signal 16384
	)
)

(instance ropeTight of PicView
	(properties
		x 173
		y 135
		z 65
		noun '/tightrope,rope[<tight]'
		description {the tightrope}
		lookStr {It is a rope, stretched tight between two platforms.}
		view 320
		cel 2
		signal 16384
	)

	(method (handleEvent event)
		(if (Said 'climb,climb')
			(event claimed: 0)
		else
			(super handleEvent: event)
		)
	)
)

(instance ropeOne of Prop
	(properties
		x 87
		y 61
		noun '/rope'
		description {the rope to the platform}
		lookStr {It is a sturdy-looking rope, hanging from the platform.}
		view 320
		loop 6
		priority 9
		signal 16
	)

	(method (handleEvent event)
		(if (Said 'climb,climb')
			(event claimed: 0)
		else
			(super handleEvent: event)
		)
	)

	(method (cue)
		(super cue:)
		(gEgo setHeading: 0)
	)
)

(instance ropeTwo of Prop
	(properties
		x 259
		y 72
		noun '/rope'
		description {the rope to the platform}
		lookStr {It is a sturdy-looking rope, hanging from the platform.}
		view 320
		loop 6
		priority 10
		signal 16
	)

	(method (handleEvent event)
		(if (Said 'climb,climb')
			(event claimed: 0)
		else
			(super handleEvent: event)
		)
	)
)

(instance eighthDay of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say challenger self (challenger msgFile:) 32)
			)
			(1
				(Say challenger self (challenger msgFile:) 33)
				(self dispose:)
			)
		)
	)
)

(instance chooseOff of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(challenger caller: self setPri: 9 showMany: 20 23)
			)
			(1
				(challenger setLoop: 0 cel: 0 setPri: -1)
				(= challengeTimer 50)
				(= whichChallenge 0)
				(= theCheck 0)
				(self dispose:)
			)
		)
	)
)

(instance itsEasy of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: walkIt self)
			)
			(1
				(Say challenger self 321 19 321 20) ; "It is such a simple thing, to walk this rope. Surely you have the skill."
			)
			(2
				(= challengeTimer 50)
				(= whichChallenge 2)
				(= theCheck 1)
				(self dispose:)
			)
		)
	)
)

(instance comeOnDown of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (challenger y:) 110)
					(self setScript: theBigJump self)
				else
					(self cue:)
				)
			)
			(1
				(challenger ignoreActors: 0 illegalBits: $8000)
				(NormalEgo)
				(gEgo
					setAvoider: Avoid
					setCycle: gEgoStopWalk 4
					setMotion:
						MoveTo
						(challenger x:)
						(+ (challenger y:) 20)
						self
				)
			)
			(2
				(challenger illegalBits: 0)
				(gEgo loop: 3)
				(Say challenger self 321 21) ; "You have but to give me a dinar, and you will gain five, if you walk the rope."
			)
			(3
				(if (== gDay 8)
					(Say challenger self 321 22) ; "And since there is a wind today, I will give you an additional five dinars when you cross to the other side."
				)
				(self dispose:)
			)
		)
	)
)

(instance showEmHow of HandsOffScript
	(properties)

	(method (doit)
		(if (and (== state 2) (== (challenger cel:) 0))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState &tmp onLeft)
		(switch (= state newState)
			(0
				(challenger ignoreActors: 0 illegalBits: $8000 stopUpd:)
				(= cycles 2)
			)
			(1
				(gEgo
					illegalBits: $8000
					setAvoider: Avoid
					setMotion:
						MoveTo
						(challenger x:)
						(+ (challenger y:) 20)
						self
				)
			)
			(2
				(challenger illegalBits: 0)
				(= challengeTimer 0)
				(gEgo loop: 3)
				(Say challenger self 321 23) ; "You are most brave. Now let us see if you are skilled as well."
			)
			(3 0)
			(4
				(if showedEm
					(self changeState: 20)
				else
					(cond
						((< (challenger x:) 132)
							(= onLeft 1)
						)
						((> (challenger x:) 140)
							(= onLeft 0)
						)
						(else
							(self cue:)
						)
					)
					(challenger
						ignoreActors: 1
						setLoop: (if onLeft 7 else 8)
						cel: 0
						setCycle: Walk
						setMotion: MoveTo 230 136 self
					)
				)
			)
			(5
				(challenger setCycle: 0 setLoop: 7 setPri: 11 cel: 4)
				(= cycles 1)
			)
			(6
				(challenger illegalBits: 0 posn: 235 136 setLoop: 1 cel: 0)
				(gEgo setMotion: MoveTo 160 150 ropeOne)
				(= cycles 1)
			)
			(7
				(challenger posn: 242 135 cel: 1)
				(= cycles 1)
			)
			(8
				(ropeTwo setLoop: 3 setCycle: Fwd)
				(challenger posn: 244 134 cel: 2)
				(= cycles 1)
			)
			(9
				(challenger posn: 253 127 cel: 3)
				(= cycles 1)
			)
			(10
				(challenger posn: 260 125 cel: 4)
				(= cycles 1)
			)
			(11
				(challenger setLoop: 2 cel: 0 posn: 261 92)
				(= cycles 1)
			)
			(12
				(challenger cel: 1 posn: 262 90)
				(= cycles 1)
			)
			(13
				(challenger cel: 3 posn: 267 71)
				(= cycles 1)
			)
			(14
				(challenger
					setLoop: 3
					cel: 0
					posn: 266 72
					cycleSpeed: 1
					setCycle: CT 4 1 self
				)
			)
			(15
				(challenger setCycle: End self)
				(ropeTwo setCycle: 0 setLoop: 6 cel: 0)
			)
			(16
				(= cycles 2)
			)
			(17
				(self setScript: walkIt self)
			)
			(18
				(= showedEm 1)
				(self setScript: theBigJump self)
			)
			(19
				(Say challenger self 321 24) ; "It is so simple, even you could do it! You have but to climb the rope."
			)
			(20
				(self dispose:)
			)
		)
	)
)

(instance cominUp of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= Index 0)
				(++ gTightropeTried)
				(gEgo setAvoider: Avoid setMotion: MoveTo 263 150 self)
			)
			(1
				(gEgo setPri: 11 setMotion: MoveTo 263 148 self)
			)
			(2
				(gEgo
					view: 6
					setLoop: 0
					cel: 0
					x: (+ (gEgo x:) [upDeltaX Index])
					y: (+ (gEgo y:) [upDeltaY Index])
				)
				(= challengeStatus 3)
				(= cycles 2)
			)
			(3
				(if (== (++ Index) 1)
					(ropeTwo setLoop: 3 setCycle: Fwd)
				)
				(gEgo
					cel: Index
					x: (+ (gEgo x:) [upDeltaX Index])
					y: (+ (gEgo y:) [upDeltaY Index])
				)
				(= cycles 1)
			)
			(4
				(if (< Index 4)
					(self changeState: 3)
				else
					(self cue:)
				)
			)
			(5
				(gEgo
					setLoop: 1
					cel: 0
					posn: 264 71
					cycleSpeed: 1
					setCycle: CT 2 1 self
				)
			)
			(6
				(gEgo setCycle: End self)
				(ropeTwo setCycle: 0 setLoop: 6 cel: 0)
			)
			(7
				(= Index 0)
				(self dispose:)
				(TellRules)
				(gCurRoom setScript: tightropeWalk)
			)
		)
	)
)

(instance cominDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= Index 0)
				(gEgo
					setStep: 2 2
					illegalBits: 0
					setLoop: 0
					cycleSpeed: 0
					setCycle: gEgoStopWalk 4
					setMotion: MoveTo 78 62 self
				)
			)
			(1
				(gEgo
					view: 6
					setLoop: 1
					cel: 7
					setPri: 12
					posn: 82 61
					cycleSpeed: 1
					setCycle: Beg self
				)
				(++ gTightWinCount)
			)
			(2
				(ropeOne setLoop: 3 setCycle: Fwd)
				(gEgo
					setLoop: 0
					cel: 4
					x: (+ (gEgo x:) [downDeltaX Index])
					y: (+ (gEgo y:) [downDeltaY Index])
				)
				(= cycles 2)
			)
			(3
				(++ Index)
				(gEgo
					cel: (- (gEgo cel:) 1)
					x: (+ (gEgo x:) [downDeltaX Index])
					y: (+ (gEgo y:) [downDeltaY Index])
				)
				(= cycles 1)
			)
			(4
				(if (< Index 4)
					(self changeState: 3)
				else
					(++ Index)
					(self cue:)
				)
			)
			(5
				(gEgo
					view: 0
					illegalBits: 0
					setLoop: 7
					cel: 1
					x: (+ (gEgo x:) [downDeltaX Index])
					y: (+ (gEgo y:) [downDeltaY Index])
				)
				(= cycles 2)
			)
			(6
				(gEgo
					setPri: -1
					cycleSpeed: 0
					setCycle: Rev
					setMotion: MoveTo (+ (gEgo x:) 9) (+ (gEgo y:) 6) self
				)
			)
			(7
				(gEgo setLoop: -1)
				(NormalEgo)
				(Face gEgo challenger)
				(= cycles 3)
			)
			(8
				(ropeOne setCycle: 0 setLoop: 6 cel: 0)
				(gEgo
					setMotion:
						MoveTo
						(challenger x:)
						(+ (challenger y:) 15)
						self
				)
			)
			(9
				(Face gEgo challenger)
				(= cycles 3)
			)
			(10
				(if (== gDay 8)
					(LowPrint 321 25) ; "You collect your 10 Dinars."
				else
					(LowPrint 321 26) ; "You collect your 5 Dinars."
				)
				(= cycles 1)
			)
			(11
				(if (< gTightWinCount 3)
					(SolvePuzzle 707 5 2)
					(Say
						challenger
						self
						(challenger msgFile:)
						(+ (mod gTightropeTried 4) 40)
					)
					(= challengedOnGround 1)
				else
					(Say challenger self 321 27) ; "We seem to have an expert among us."
				)
				(HandsOn)
				(challenger ignoreActors: 0)
				(= challengeStatus 4)
				(RestartIt)
				(if (== gDay 8)
					(gEgo get: 2 11) ; Dinar
				else
					(gEgo get: 2 6) ; Dinar
				)
				(self dispose:)
			)
		)
	)
)

(instance askingEgo of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(challenger caller: self showMany: 30 31)
			)
			(1
				(challenger setLoop: 0 cel: 0 setPri: -1)
				(= challengeTimer 50)
				(= whichChallenge 1)
				(self dispose:)
			)
		)
	)
)

(instance stepAside of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(challenger
					illegalBits: $8000
					setLoop: 7
					cel: 0
					setCycle: Rev
					setMotion:
						MoveTo
						(+ (challenger x:) 40)
						(- (challenger y:) 20)
						self
				)
			)
			(1
				(challenger setCycle: 0 setLoop: 0 cel: 0)
				(self dispose:)
			)
		)
	)
)

(instance tightropeWalk of HandsOffScript
	(properties)

	(method (init)
		(super init: &rest)
		(gDirectionHandler add: self)
		(= sideKeys 0)
		(= justStarting 10)
	)

	(method (dispose)
		(= fallTimer 0)
		(gDirectionHandler delete: self)
		(super dispose: &rest)
	)

	(method (handleEvent event &tmp theLoop)
		(if (super handleEvent: event)
			(return 1)
		)
		(switch (event type:)
			($0040 ; direction
				(event claimed: 1)
				(if (!= (gEgo script:) stepForward)
					(switch (event message:)
						(JOY_UP
							(if (== (gEgo loop:) 2)
								(gEgo setScript: crashAndBurn 0 1)
							else
								(CorrectRight)
							)
						)
						(JOY_DOWN
							(if (== (gEgo loop:) 1)
								(gEgo setScript: crashAndBurn 0 0)
							else
								(CorrectLeft)
							)
						)
						(JOY_RIGHT
							(if
								(or
									(not (= theLoop (gEgo loop:)))
									(> theLoop 2)
									(TryProb 5)
									(< (++ holdCounter) 3)
								)
								(HoldPosition)
							)
						)
						(JOY_LEFT
							(if (not sideKeys)
								(CanEgoStep)
							)
						)
					)
				)
			)
		)
	)
)

(instance crashAndBurn of Script
	(properties)

	(method (changeState newState &tmp theX theY)
		(switch (= state newState)
			(0
				(= Index 0)
				(HandsOff)
				(gCurRoom setScript: 0)
				(= centered 0)
				(gEgo
					view: 6
					setLoop: (if register 4 else 2)
					illegalBits: 0
					setPri: (if register 9 else 10)
					cel: 0
					setCycle: CT (if register 3 else 2) 1
				)
				(= cycles (if register 4 else 3))
			)
			(1
				(if register
					(if (> (gEgo x:) 240)
						(= theX [RdeltaXS Index])
					else
						(= theX [RdeltaX Index])
					)
					(= theY [RdeltaY Index])
				else
					(= theX [LdeltaX Index])
					(= theY [LdeltaY Index])
				)
				(gEgo
					cel: (+ (gEgo cel:) 1)
					x: (+ (gEgo x:) theX)
					y: (+ (gEgo y:) theY)
				)
				(++ Index)
				(= cycles 1)
			)
			(2
				(if (< Index (+ register 4))
					(self changeState: 1)
				else
					(= Index 0)
					(self cue:)
				)
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(cls)
				(= seconds 2)
			)
			(5
				(gEgo
					setLoop: (if register 5 else 3)
					cel: 0
					setCycle: End self
				)
			)
			(6
				(gEgo setLoop: -1)
				(NormalEgo)
				(Face gEgo challenger)
				(cond
					((== gArcadeLevel 1)
						(Say challenger self 321 28) ; "It appears you are not yet skilled enough to make me pay, but with practice you will surely be as agile as I."
					)
					((> (+ 44 (mod gTightropeTried 5)) 4)
						(Say
							challenger
							self
							(challenger msgFile:)
							(+ 48 (mod gTightropeTried 5))
						)
					)
					(else
						(Say
							challenger
							self
							(challenger msgFile:)
							(+ 44 (mod gTightropeTried 5))
						)
					)
				)
			)
			(7
				(if (not (TakeDamage 15))
					(EgoDead ; "Gee, you didn't even reach the end of your rope."
						1
						321
						29
						#title
						{In circuses (and beach movies) they use a net}
					)
				)
				(RestartIt)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance stepForward of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> stepCount 2)
					(= stepCount 0)
					(gEgo posn: (gEgo x:) (- (gEgo y:) 1))
				)
				(gEgo
					view: 285
					loop: 0
					cel: 0
					setPri: 11
					cycleSpeed: 1
					setCycle: End
					setMotion: MoveTo (- (gEgo x:) 5) (gEgo y:) self
				)
				(++ stepCount)
			)
			(1
				(StraightAndLevel)
				(if justStarting
					(-- justStarting)
				)
				(= cycles 3)
				(= holdCounter 0)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance theBigJump of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(challenger
					setLoop: 6
					yStep: jumpIncr
					cel: 0
					setPri: (if (< (challenger x:) 160) 9 else 11)
				)
				(= cycles 2)
			)
			(1
				(challenger
					setMotion:
						MoveTo
						(challenger x:)
						(- (challenger y:) (* jumpIncr 2))
					setCycle: CT 2 1 self
				)
			)
			(2
				(if
					(or
						(and
							(< (challenger x:) 160)
							(gEgo inRect: 67 125 90 157)
						)
						(and
							(> (challenger x:) 160)
							(gEgo inRect: 243 137 280 157)
						)
					)
					(NormalEgo)
					(gEgo
						setLoop: 3
						setCycle: gEgoStopWalk 4
						setMotion: MoveTo 268 173
					)
				)
				(challenger setCycle: CT 3 1 self)
			)
			(3
				(challenger
					setMotion:
						MoveTo
						(challenger x:)
						(+ (challenger y:) (* jumpIncr 5))
					setCycle: CT 8 1 self
				)
			)
			(4
				(if (and (== (gEgo x:) 160) (== (gEgo y:) 150))
					(gEgo setHeading: 270)
				)
				(challenger y: (+ (challenger y:) 17) cel: 3)
				(= cycles 1)
			)
			(5
				(= jumpIncr 7)
				(challenger
					yStep: 7
					setMotion:
						MoveTo
						(challenger x:)
						(+ (challenger y:) (* jumpIncr 5))
					setCycle: CT 8 1 self
				)
			)
			(6
				(challenger
					setPri: -1
					ignoreActors: 0
					y: (+ (challenger y:) 15)
					setCycle: CT 12 1 self
				)
			)
			(7
				(gEgo view: 0 setLoop: -1 illegalBits: $8000)
				(NormalEgo)
				(= cycles 10)
			)
			(8
				(challenger setCycle: End self)
			)
			(9
				(challenger illegalBits: $8000 setLoop: 0 cel: 0)
				(self dispose:)
			)
		)
	)
)

(instance walkIt of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(challenger
					setLoop: 4
					cel: 0
					setPri: 10
					cycleSpeed: 0
					xStep: 4
					y: 74
					setCycle: Fwd
					setMotion: MoveTo 114 61 self
				)
			)
			(1
				(if (< (+ 70 (challenger y:)) (gEgo y:))
					(gEgo setHeading: 315)
				else
					(gEgo setHeading: 225)
				)
				(challenger setLoop: 5 cel: 0 x: 111 setCycle: CT 2 1 self)
			)
			(2
				(challenger cel: 3 x: 104)
				(= cycles 1)
			)
			(3
				(challenger cel: 4 x: 101)
				(= cycles 1)
			)
			(4
				(challenger cel: 5)
				(= cycles 1)
			)
			(5
				(challenger cel: 6 x: 97)
				(= cycles 1)
			)
			(6
				(challenger cel: 7 x: 87)
				(= cycles 1)
			)
			(7
				(= cycles 12)
			)
			(8
				(self dispose:)
			)
		)
	)
)

