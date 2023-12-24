;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 610)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use TopWindow)
(use Talker)
(use TargActor)
(use Interface)
(use LoadMany)
(use Path)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm610 0
)

(local
	thisControl
	glintMsg = 1
	seeMsg = 1
	[lowPoints 12] = [134 110 88 104 72 99 52 88 39 87 -32768 -32768]
	[highPoints 20] = [58 93 80 94 110 92 150 87 165 83 168 79 159 73 135 63 130 62 -32768 -32768]
	[downHighPoints 16] = [159 73 168 79 165 83 150 87 110 92 80 94 58 93 -32768 -32768]
	[downLowPoints 12] = [39 87 52 88 72 99 88 104 134 110 -32768 -32768]
	[djGenList 38] = [1 2 3 4 5 6 7 8 9 0 10 0 0 0 11 0 12 0 13 0 0 0 0 0 14 0 0 0 0 0 15 0 16 0 0 0 0 0]
	[djSpecList 24] = [17 '//teleport,leaving,escape' 18 '//iblis,statue' 19 '//ability,ability' 20 '//health,injury' 21 '//bendaoud,prophet' 22 '//ring' 23 '//prediction' 25 '//wish' 26 '//master,lord,boss' 27 '//city,grave' 28 '//job,purpose,goal,replace' 0 0]
	rock2
	rock3
	rock4
	rock5
	rock6
	rock7
	rocky
	rockCnt
	[rocks 15] = [0 267 87 5 250 88 3 244 76 0 244 65 5 262 71]
	healthWish
	wishCnt
	badWish
	warned
	whichSkill
	waitForSkill
	[wished 20]
)

(procedure (RocksDontMove)
	(BluePrint 610 58) ; "Your spell doesn't even begin to move the rocks blocking the doorway. They are too large."
	(if (gCast contains: dj)
		(Say dj 610 59) ; "Um.. Master? I know I'm pretty useless and all that, but maybe I could help you escape somehow."
	)
)

(procedure (GreenPrint)
	(loWindow color: 10 back: 0)
	(Print &rest #window loWindow)
)

(procedure (BluePrint)
	(hiWindow color: 9 back: 0)
	(Print &rest #window hiWindow)
)

(procedure (MoveRocks)
	(if (or (> [gEgoStats 0] 140) [wished 0]) ; strength
		(BluePrint 610 60) ; "Even with your great strength, it would be impossible to move all of those rocks. You had better find another way to escape."
	else
		(BluePrint 610 61) ; "It would take years to clear away all of those rocks from the door."
	)
)

(instance rm610 of Rm
	(properties
		picture 610
		style 1
	)

	(method (dispose)
		(gCSound fade:)
		(DisposeScript 983)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(if (not script)
			(switch (= thisControl (gEgo onControl: 1))
				(16
					(self setScript: climbDownS)
				)
				(2
					(self setScript: climbUpS)
				)
			)
		)
	)

	(method (init)
		(LoadMany rsVIEW 610 613 615 183 47 32 615 22 612 586)
		(Load rsTEXT 615)
		(Load rsSOUND 12 15 16 34)
		(SolvePuzzle 640 5)
		(SetFlag 116) ; fLightOn
		(= gEgoGait 4) ; holdingLamp
		(NormalEgo)
		(gEgo loop: 5 posn: 244 120 init:)
		(= gSpellChecker gAllChecker)
		(= global61 0)
		(super init:)
		(floorShine init:)
		(dr init:)
		(iblis init: stopUpd:)
		((= rock2 (rock new:)) cel: 1 posn: 240 47 init:)
		((= rock3 (rock new:)) cel: 2 posn: 239 58 init:)
		((= rock4 (rock new:)) cel: 4 posn: 283 59 init:)
		((= rock5 (rock new:)) cel: 3 posn: 259 57 init:)
		((= rock6 (rock new:)) cel: 5 posn: 280 68 init:)
		((= rock7 (rock new:)) cel: 6 posn: 232 74 init:)
		(rock2 stopUpd:)
		(rock3 stopUpd:)
		(rock4 stopUpd:)
		(rock5 stopUpd:)
		(rock6 stopUpd:)
		(rock7 stopUpd:)
		(rock init:)
		(rock stopUpd:)
		(self setScript: comeIn)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(or
					(Said 'search,look,look[<at,around][/room,area][/!*]')
					(Said 'look,look/cave')
				)
				(BluePrint 610 0) ; "The structure in the center of the room is now dark, and a huge pile of boulders block the only door to the cavern."
			)
			((Said 'force,move,open,open/door,boulder')
				(MoveRocks)
			)
			((Said 'put,drop,extinguish/lamp,light')
				(BluePrint 610 1) ; "If you did that, you would be lost in the dark."
			)
			((Said 'cast')
				(event claimed: 0)
			)
			((gCast contains: dj)
				(event claimed: 1)
				(Say dj 610 2) ; "Was that supposed to be a wish, Master? The correct way to make a wish is to say: "Wish for ..."."
			)
			((Said '/statue,iblis')
				(BluePrint 610 3) ; "The statue of Ibis is no longer here. It has been taken by Ad Avis."
			)
			((Said 'walk')
				(HighPrint 610 4) ; "Go ahead. Just do it."
			)
			((Said 'run,sneak')
				(HighPrint 610 5) ; "You are better off walking."
			)
		)
	)
)

(instance comeIn of HandsOffScript
	(properties)

	(method (changeState newState)
		(if (< 22 newState 29)
			(ShakeScreen 2 ssLEFTRIGHT)
		)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 232 124 self)
			)
			(1
				(dr setCycle: Beg self)
			)
			(2
				(GreenPrint 610 6) ; "A glow illuminates this chamber. It flows from an object high atop the strange structure before you."
				(GreenPrint 610 7) ; "At the sight of the glowing object you feel irresistibly drawn forward."
				(gEgo
					setPri: 4
					moveSpeed: 1
					cycleSpeed: 1
					setMotion: MoveTo 176 116 self
				)
			)
			(3
				(GreenPrint 610 8) ; "Your feet seem to move with a will of their own."
				(floorShine dispose:)
				(gEgo setLoop: 5 setMotion: lowPath self setCycle: Fwd)
			)
			(4
				(NormalEgo)
				(gEgo setPri: 8 illegalBits: 0 setMotion: highPath self)
			)
			(5
				(GreenPrint 610 9) ; "As you draw near, you see that the object is a statue made of crystal. A dark, shapeless form stirs within it."
				(GreenPrint 610 10) ; "The crystal's cool glow is numbing. You feel compelled to pick it up, but as you reach out..."
				(gEgo view: 47 loop: 1 cel: 0)
				(sparkle init: setCycle: End)
				(= cycles 8)
			)
			(6
				(sparkle dispose:)
				(RedrawCast)
				(GreenPrint 610 11) ; "You are suddenly unable to move."
				(gSpareSound number: 34 loop: 0 vol: 60 play:)
				(adAvis
					init:
					setLoop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(7
				(adAvis setLoop: 1 cel: 0 setCycle: End self)
			)
			(8
				(iblis dispose:)
				(adAvis setLoop: 2 cel: 0 setCycle: End self)
			)
			(9
				(Say adAvis self 610 12 610 13) ; "Fool! Some hero you are! A pawn of the very man you sought to destroy."
			)
			(10
				(adAvis setLoop: 4 cel: 0 setCycle: CT 2 1 self)
			)
			(11
				(adAvis cel: 1)
				(= cycles 10)
			)
			(12
				(adAvis setCycle: Beg self)
			)
			(13
				(adAvis talkSpeed: 2)
				(Say adAvis self 610 14) ; "Do you know how long I have awaited this moment? Seventy years! Seventy years I have served the Dark Master while watching for the stars to align. Seventy years I have spent learning the magic that controls men's minds and waiting for a fool to fulfill the prophecy for me."
			)
			(14
				(adAvis setLoop: 2 cel: 255 setCycle: CT 1 -1 self)
			)
			(15
				(= cycles 8)
			)
			(16
				(adAvis setCycle: End self)
			)
			(17
				(adAvis talkSpeed: 1)
				(Say adAvis self 610 15 610 16) ; "Tonight, as the moon arises between the Scorpion's Claws and the Dragon's Teeth, I shall begin the ritual that shall make me the Master! I will control Iblis, and thus control the world."
			)
			(18
				(adAvis setLoop: 4 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(19
				(whamo init: setCycle: Fwd setMotion: MoveTo 264 43 whamo)
				(adAvis cel: 1 setCycle: Beg)
			)
			(20
				(whamo view: 32 loop: 5 cel: 0 setCycle: CT 2 1 self)
			)
			(21
				(ShakeScreen 1 5) ; ssUPDOWN | $0004
				(gEgo view: 22 setLoop: 0 cel: 0 setStep: 2 2 setCycle: End)
				(whamo setCycle: End self)
			)
			(22
				(whamo dispose:)
				(rock2 startUpd:)
				(rock3 startUpd:)
				(rock4 startUpd:)
				(rock5 startUpd:)
				(rock6 startUpd:)
				(rock7 startUpd:)
				(rock setPri: 4 setMotion: MoveTo 255 114 self)
			)
			(23
				(addToPile init: rock)
				(rock2 setPri: 4 setMotion: MoveTo 233 112 self)
			)
			(24
				(addToPile2 init: rock2)
				(rock3 setPri: 4 setMotion: MoveTo 242 100 self)
			)
			(25
				(dr
					lookStr:
						{The door is blocked by tons of rocks -- apparently for good.}
				)
				(addToPile3 init: rock3)
				(rock4 setPri: 4 setMotion: MoveTo 268 123 self)
			)
			(26
				(addToPile4 init: rock4)
				(rock5 setPri: 4 setMotion: MoveTo 270 114 self)
			)
			(27
				(addToPile5 init: rock5)
				(rock6 setPri: 4 setMotion: MoveTo 263 101 self)
			)
			(28
				(addToPile6 init: rock6)
				(rock7 setPri: 4 setMotion: MoveTo 239 87 self)
			)
			(29
				(addToPile7 init: rock7)
				(Say adAvis self 610 17) ; "Farewell, Hero!"
			)
			(30
				(adAvis setLoop: 4 cel: 0 setCycle: End self)
			)
			(31
				(whamo
					view: 615
					loop: 5
					posn: 107 31
					init:
					setCycle: Fwd
					setMotion: MoveTo 264 24 whamo
				)
				(adAvis cel: 1 setCycle: Beg)
			)
			(32
				(whamo view: 32 loop: 5 cel: 0 setCycle: End self)
			)
			(33
				(ShakeScreen 2 ssLEFTRIGHT)
				(whamo dispose:)
				(adAvis setLoop: 6 cel: 0 setCycle: End self)
			)
			(34
				(= global61 1)
				(gCurRoom drawPic: 610)
				(gAddToPics
					add:
						addToPile
						addToPile2
						addToPile3
						addToPile4
						addToPile5
						addToPile6
						addToPile7
					eachElementDo: #palette 2
					doit:
				)
				(dr palette: 2 forceUpd:)
				(adAvis setLoop: 0 cel: 4 setCycle: Beg self)
			)
			(35
				(rock palette: 2)
				(= cycles 4)
			)
			(36
				(rock setScript: moreRockS self)
			)
			(37
				(= cycles 18)
			)
			(38
				(gEgo setLoop: 1 cel: 0 cycleSpeed: 3 setCycle: End self)
			)
			(39
				(NormalEgo)
				(floorShine init:)
				(gEgo setPri: 8 loop: 3 cel: 2 heading: 0)
				(adAvis dispose:)
				(ring init:)
				(self dispose:)
			)
		)
	)
)

(instance moreRockS of HandsOffScript
	(properties)

	(method (changeState newState)
		(if newState
			(ShakeScreen 2 ssUPDOWN)
		)
		(switch (= state newState)
			(0
				((= rocky (rock new:))
					init:
					setPri: 4
					setStep: 3 18
					cel: [rocks rockCnt]
					posn: [rocks (++ rockCnt)] -10
					setMotion:
						MoveTo
						[rocks rockCnt]
						[rocks (++ rockCnt)]
						self
				)
			)
			(1
				(gSpareSound number: 12 loop: 1 vol: 70 play:)
				(rocky stopUpd:)
				(if (< (++ rockCnt) 13)
					(self changeState: 0)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance climbUpS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setPri: 4 setMotion: lowPath self)
			)
			(1
				(gEgo setPri: 8 setMotion: highPath self)
			)
			(2
				(NormalEgo)
				(gEgo setPri: 8)
				(self dispose:)
			)
		)
	)
)

(instance climbDownS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setPri: 8 setMotion: downHighPath self)
			)
			(1
				(gEgo setPri: 4 setMotion: downLowPath self)
			)
			(2
				(gEgo setMotion: MoveTo 206 123 self)
			)
			(3
				(NormalEgo)
				(gEgo setPri: 4)
				(self dispose:)
			)
		)
	)
)

(instance djComesS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 212 150 self)
			)
			(1
				(gEgo setHeading: 135 self)
			)
			(2
				(gEgo
					view: 612
					setLoop: 0
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(3
				(SolvePuzzle 639 7)
				(ring dispose:)
				(gEgo
					get: 44 ; Ring
					setLoop: 4
					cel: 0
					cycleSpeed: 3
					setCycle: CT 2 1 self
				)
			)
			(4
				(BluePrint 610 18) ; "You pick up the ring and read the inscription, "He Who Waits Behind." As you put it on your finger, you twist it a bit to see its design."
				(gEgo setCycle: CT 8 1 self)
			)
			(5
				(dj init: posn: 237 119 setCycle: End self)
			)
			(6
				(gEgo cycleSpeed: 1 setCycle: End)
				(dj
					setLoop: 2
					cycleSpeed: 2
					setCycle: Fwd
					posn: 245 114
					setMotion: MoveTo 252 102
				)
				(= cycles 14)
			)
			(7
				(Say dj self 610 19) ; "I may grant you three wishes, Oh Master of the Ring. What is your first wish?"
			)
			(8
				(DontTalk 0)
				(self dispose:)
			)
		)
	)
)

(instance healedS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= healthWish 1)
				(Say dj self 610 20) ; "By my will, may you be well in all ways!"
			)
			(1
				(BluePrint 610 21) ; "You feel a warm glow spreading throughout your body."
				(= [gEgoStats 16] (MaxHealth)) ; health
				(= [gEgoStats 18] (MaxMana)) ; mana
				(= [gEgoStats 17] (MaxStamina)) ; stamina
				(ClearFlag 7) ; fWornOut
				(= cycles 8)
			)
			(2
				(Say dj self 610 22) ; "I did it! My spell worked!"
			)
			(3
				(switch (++ wishCnt)
					(1
						(Say dj self 610 23) ; "What is your next wish, Oh Master of the Ring?"
					)
					(2
						(Say dj self 610 24) ; "You have but one wish left. Choose carefully, Master."
					)
					(else
						(EgoDead ; "You've wished away your three wishes, Oh Master of the Ring. Enjoy your stay at Hotel Iblis. It will be a long one, no doubt."
							1
							610
							25
							#title
							{C'mon.  Just One More Little Wish...}
						)
					)
				)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance skillS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say dj self 610 26) ; "By my Power, may you have the skill of ten men!"
			)
			(1
				(BluePrint 610 27) ; "You suddenly feel much more skilled."
				(= cycles 8)
			)
			(2
				(Say dj self 610 28) ; "Gee, it's so nice when my magic actually works."
			)
			(3
				(switch (++ wishCnt)
					(1
						(Say dj self 610 23) ; "What is your next wish, Oh Master of the Ring?"
					)
					(2
						(Say dj self 610 24) ; "You have but one wish left. Choose carefully, Master."
					)
					(else
						(EgoDead ; "You've wished away your three wishes, Oh Master of the Ring. Enjoy your stay at Hotel Iblis. It will be a long one, no doubt."
							1
							610
							25
							#title
							{C'mon.  Just One More Little Wish...}
						)
					)
				)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance nothingS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (++ badWish)
					(1
						(Say dj self 610 29) ; "Well, I'll try, Master of the Ring. Here goes. By my Magic, may it be done!"
					)
					(2
						(Say dj self 610 30) ; "Very well. By my Word, so be it!"
					)
					(3
						(Say dj self 610 31) ; "I think I know that one. By the Ring, Do your Thing!"
					)
					(else
						(Say dj self 610 32) ; "By the Way, Make my Day!."
					)
				)
			)
			(1
				(switch badWish
					(1
						(BluePrint 610 33) ; "There is a quiet pause while nothing happens."
						(Say dj self 610 34) ; "I guess I can't grant you that wish. Sorry."
					)
					(2
						(BluePrint 610 35) ; "There is another moment of silence."
						(Say dj self 610 36) ; "I'm afraid I don't know that wish either, Master. What else would you like?"
					)
					(3
						(BluePrint 610 37) ; "The only sound is your own groan."
						(Say dj self 610 38) ; "Well, Master, you can always try again. I'll get it right sometime."
					)
					(else
						(BluePrint 610 39) ; "This time, the Djinni sighs."
						(Say dj self 610 40) ; "Master, I'm sorry. I guess I can only grant you Health, Prowess, and then Teleport you to Iblis."
					)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance zapOutS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(Say dj self 610 41) ; "There will be no safety for anyone until Iblis is returned, Master. We must hurry and bring him back!"
				else
					(self cue:)
				)
			)
			(1
				(Say dj self 610 42) ; "In the name of Suleiman bin Daoud, the Binder, and by my Power as He Who Waits Behind: Take us to Iblis!"
			)
			(2
				(sparkle
					init:
					cel: 0
					posn: 202 120
					cycleSpeed: 1
					setCycle: CT 2 1 self
				)
			)
			(3
				(sparkle setCycle: End)
				(gEgo dispose:)
				(floorShine dispose:)
				(dj setLoop: 6 cel: 0 setCycle: End self)
			)
			(4
				(dj hide:)
				(sparkle
					posn: (- (dj x:) 14) (- (dj y:) 26)
					cel: 0
					setCycle: End self
				)
			)
			(5
				(= gEgoGait 0) ; walking
				(SetFlag 96) ; fTeleFromIblis
				(gCurRoom newRoom: 460)
			)
		)
	)
)

(instance dr of TargActor
	(properties
		x 243
		y 105
		noun '/door'
		description {the door}
		lookStr {The door is very old.  And ancient, very ancient.}
		view 610
		cel 1
		priority 2
		signal 16
		illegalBits 0
	)

	(method (openMe)
		(RocksDontMove)
		(return 0)
	)

	(method (fetchMe)
		(RocksDontMove)
		(return 0)
	)

	(method (hurtMe)
		(RocksDontMove)
		(return 1)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2)
			(MoveRocks)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance iblis of View
	(properties
		x 110
		y 35
		view 613
		priority 8
		signal 16400
	)
)

(instance myWin of BotWindow
	(properties)
)

(instance ring of TargActor
	(properties
		x 222
		y 154
		z 27
		noun '/ring,flash,glimmer'
		description {flash}
		view 612
		loop 5
		priority 15
		signal 16400
		cycleSpeed 1
		illegalBits 0
	)

	(method (doit &tmp theAngle)
		(super doit:)
		(cond
			(cel)
			((== thisControl 4)
				(if
					(>
						(= theAngle
							(Abs
								(-
									(GetAngle (gEgo x:) (gEgo y:) x y)
									(gEgo heading:)
								)
							)
						)
						180
					)
					(= theAngle (- 360 theAngle))
				)
				(if (<= theAngle 75)
					(self setCycle: CT 0 1 self)
				)
			)
			((== thisControl 256)
				(self setCycle: CT 0 1 self)
			)
		)
	)

	(method (cue &tmp tmpEvnt)
		(self setCycle: CT 0 1)
		(cond
			((not seeMsg))
			((and glintMsg (> (gEgo distanceTo: ring) 24))
				(gEgo setMotion: 0)
				(Face gEgo self)
				(= glintMsg 0)
				(BluePrint 610 43) ; "Something flashes in the darkness."
			)
			((<= (gEgo distanceTo: ring) 24)
				(gEgo setMotion: 0)
				(Face gEgo self)
				(= seeMsg 0)
				(BluePrint 610 44) ; "You see a small, golden ring around the tip of a stalagmite (or is it a stalactite?)."
			)
		)
		(super cue:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (== thisControl 256)
					(Face gEgo self)
					(BluePrint 610 44) ; "You see a small, golden ring around the tip of a stalagmite (or is it a stalactite?)."
				else
					(BluePrint 610 43) ; "Something flashes in the darkness."
				)
				(self setCycle: CT 0 1)
			)
			(7
				(if (== thisControl 256)
					(gCurRoom setScript: djComesS)
				else
					(NotClose)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (detectMe)
		(BluePrint 610 45) ; "There is still a source of magic in this room."
	)
)

(instance dj of Talker
	(properties
		description {the djinni}
		lookStr {Do you mind if I'm smoke?}
		yStep 1
		view 612
		loop 1
		priority 12
		signal 18448
		cycleSpeed 2
		illegalBits 0
		xStep 1
		tLoop 3
		talkSpeed 1
		myName '//djinn'
		title {Djinni:}
		color 1
		back 13
		msgFile 615
	)

	(method (init)
		(gCast addToFront: self)
		(super init: &rest)
		(= tWindow myWin)
	)

	(method (openMe)
		(RocksDontMove)
	)

	(method (hurtMe)
		(Say self 610 46) ; "Oh Ho Ho, Master! That tickles."
	)

	(method (fetchMe)
		(Say self 610 47) ; "Master, I am a djinni. If you want to play fetch, maybe you should get a dog."
		(return 0)
	)

	(method (detectMe)
		(BluePrint 610 48) ; "The djinn is composed entirely of magic, but all other sources of magic in this room are now gone."
	)

	(method (calmMe)
		(BluePrint 610 49) ; "No thank you, Master. I've been sleeping for one thousand and one years already."
	)

	(method (atSpec which)
		(return [djSpecList which])
	)

	(method (atGen which)
		(return [djGenList which])
	)

	(method (showText what)
		(if (== what 25)
			(SolvePuzzle 638 7)
		)
		(super showText: what &rest)
	)

	(method (messages args)
		(super messages: args &rest)
		(self setMotion: MoveTo 262 86)
	)

	(method (endTalk)
		(super endTalk:)
		(self setMotion: MoveTo 252 99)
	)

	(method (handleEvent event &tmp [tmpStr 60])
		(cond
			((super handleEvent: event))
			((and waitForSkill (== (event type:) evSAID) (not (Said 'wish>')))
				(if
					(or
						(Said
							'/strength,intelligence,agility,vitality,luck,attack,weapon,parry,dodge,stealth,lockpick,throw,climb,climb,magic,communication,honor'
						)
						(Said 'throw,lockpick,dodge,climb,climb,parry,attack')
					)
					(= waitForSkill 0)
					(Parse (Format @tmpStr 610 50 (User inputLineAddr:)) event) ; "wish for %s"
					(event type: evSAID)
					(event claimed: 0)
					(User said: event)
				else
					(LowPrint 610 51) ; "You need to choose a skill or ability that is within the means of your character."
					(event claimed: 1)
				)
			)
			((Said 'wish//healing,health')
				(if healthWish
					(Say dj 610 52) ; "But, Master, I have already granted you that wish."
				else
					(gCurRoom setScript: healedS)
				)
			)
			(
				(or
					(Said
						'wish//strength,intelligence,agility,vitality,luck,attack,weapon,parry,dodge,stealth,lockpick,throw,climb,climb,magic,communication,honor>'
					)
					(Said
						'wish//ability<strength,intelligence,agility,vitality,luck,attack,weapon,parry,dodge,stealth,lockpick,throw,climb,climb,magic,magical,communication,honor>'
					)
					(Said 'throw,lockpick,dodge,climb,climb,parry,attack>')
				)
				(cond
					(
						(==
							(= whichSkill
								(cond
									(
										(or
											(Said '//strength')
											(Said '//ability<strength')
										)
										0
									)
									(
										(or
											(Said '//intelligence')
											(Said '//ability<intelligence')
										)
										1
									)
									(
										(or
											(Said '//agility')
											(Said '//ability<agility')
										)
										2
									)
									(
										(or
											(Said '//vitality')
											(Said '//ability<vitality')
										)
										3
									)
									(
										(or
											(Said '//luck')
											(Said '//ability<luck')
										)
										4
									)
									(
										(or
											(Said '//weapon,attack')
											(Said '//ability<weapon,attack')
											(Said 'attack')
										)
										5
									)
									(
										(or
											(Said '//parry')
											(Said '//ability<parry')
											(Said 'parry')
										)
										6
									)
									(
										(or
											(Said '//dodge')
											(Said '//ability<dodge')
											(Said 'dodge')
										)
										7
									)
									(
										(or
											(Said '//stealth')
											(Said '//ability<stealth')
										)
										8
									)
									(
										(or
											(Said '//lockpick')
											(Said '/ability/<lockpick')
											(Said 'lockpick')
										)
										9
									)
									(
										(or
											(Said '//throw')
											(Said '//ability<throw')
											(Said 'throw')
										)
										10
									)
									(
										(or
											(Said '//climb,climb')
											(Said '//ability<climb,climb')
										)
										11
									)
									(
										(or
											(Said '//magic')
											(Said '//ability<magic,magical')
										)
										12
									)
									(
										(or
											(Said '//communication')
											(Said '//ability<communication')
										)
										13
									)
									(
										(or
											(Said '//honor')
											(Said '//ability<honor')
										)
										14
									)
								)
							)
							14
						)
						(Say dj 610 53) ; "I am sorry, Master, but honor is the one thing I cannot grant you. You must earn that yourself."
					)
					([wished whichSkill]
						(Say dj 610 52) ; "But, Master, I have already granted you that wish."
					)
					(else
						(= [wished whichSkill] 1)
						(+= [gEgoStats whichSkill] 50)
						(gCurRoom setScript: skillS)
					)
				)
			)
			((Said 'wish//ability,ability')
				(Say dj 610 54) ; "Which skill or attribute do you want to increase?"
				(= waitForSkill 1)
			)
			(
				(or
					(Said
						'wish//done,done,teleport,teleportation,teleportation,teleportation'
					)
					(Said 'teleport,done')
					(Said 'get,get<out')
					(Said 'wish//safety,escape>')
					(Said 'escape>')
				)
				(if (or warned (== wishCnt 2))
					(if (not (event claimed:))
						(zapOutS register: 1)
						(event claimed: 1)
					)
					(gCurRoom setScript: zapOutS)
				else
					(Say dj 610 55 610 56) ; "Well, I can kind of grant you that wish, but it has two problems. First, I can only teleport you to where Iblis is now, and second, its the last wish I can grant. You'll have to make all of your other wishes first."
					(= warned 1)
					(event claimed: 1)
				)
			)
			((Said 'wish//iblis')
				(Say dj 610 57) ; "Oh, I'm sorry, Master, but I can't do that. My magic has no effect on Iblis."
			)
			((Said 'wish')
				(gCurRoom setScript: nothingS)
			)
		)
	)
)

(instance adAvis of Talker
	(properties
		x 93
		y 56
		view 615
		loop 7
		priority 8
		signal 16400
		illegalBits 0
		tLoop 3
		talkSpeed 1
		myName '//ad,man'
		title {Ad Avis:}
		color 13
		back 0
	)

	(method (init)
		(super init: &rest)
		(= tWindow myWin)
	)
)

(instance whamo of Actor
	(properties
		x 107
		y 31
		yStep 5
		view 615
		loop 5
		priority 7
		signal 18448
		illegalBits 0
		xStep 16
	)

	(method (cue)
		(gMiscSound number: 16 loop: 1 play:)
		(comeIn cue: &rest)
	)

	(method (init)
		(gMiscSound number: 15 loop: 1 play:)
		(super init: &rest)
	)
)

(instance sparkle of Prop
	(properties
		x 133
		y 31
		view 615
		loop 7
		priority 12
		signal 16
	)
)

(instance floorShine of Actor
	(properties
		view 586
		signal 22544
		illegalBits 0
	)

	(method (doit)
		(self setPri: (- (gEgo priority:) 1))
		(switch (gEgo loop:)
			(0
				(self posn: (+ (gEgo x:) 10) (+ (gEgo y:) 5))
			)
			(1
				(self posn: (- (gEgo x:) 10) (+ (gEgo y:) 5))
			)
			(2
				(self posn: (gEgo x:) (+ (gEgo y:) 5))
			)
			(3
				(self posn: (gEgo x:) (- (gEgo y:) 5))
			)
			(4
				(self posn: (+ (gEgo x:) 12) (gEgo y:))
			)
			(5
				(self posn: (- (gEgo x:) 20) (+ (gEgo y:) 5))
			)
			(6
				(self posn: (+ (gEgo x:) 12) (gEgo y:))
			)
			(else
				(self posn: (- (gEgo x:) 20) (+ (gEgo y:) 5))
			)
		)
		(super doit:)
	)
)

(instance rock of Actor
	(properties
		x 260
		y 45
		noun '/boulder,boulder,brick'
		description {the boulder}
		lookStr {Large boulders surround the door.}
		yStep 15
		view 610
		loop 1
		priority 3
		signal 30736
		illegalBits 0
		xStep 4
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 5 7)
			(MoveRocks)
		else
			(super doVerb: theVerb)
		)
	)
)

(class AddToPile of PicView
	(properties
		view 610
		loop 1
	)

	(method (init obj)
		(gSpareSound number: 12 loop: 1 play:)
		(= cel (obj cel:))
		(= x (obj x:))
		(= y (obj y:))
		(= priority (obj priority:))
		(gAddToPics add: self doit:)
		(obj dispose:)
	)
)

(instance addToPile of AddToPile
	(properties)
)

(instance addToPile2 of AddToPile
	(properties)
)

(instance addToPile3 of AddToPile
	(properties)
)

(instance addToPile4 of AddToPile
	(properties)
)

(instance addToPile5 of AddToPile
	(properties)
)

(instance addToPile6 of AddToPile
	(properties)
)

(instance addToPile7 of AddToPile
	(properties)
)

(instance lowPath of Path
	(properties)

	(method (at nth)
		(return [lowPoints nth])
	)
)

(instance highPath of Path
	(properties)

	(method (at nth)
		(return [highPoints nth])
	)
)

(instance downHighPath of Path
	(properties)

	(method (at nth)
		(return [downHighPoints nth])
	)
)

(instance downLowPath of Path
	(properties)

	(method (at nth)
		(return [downLowPoints nth])
	)
)

(instance loWindow of BotWindow
	(properties)
)

(instance hiWindow of TopWindow
	(properties)
)

