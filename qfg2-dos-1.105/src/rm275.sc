;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 275)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use Talker)
(use Flame)
(use Interface)
(use LoadMany)
(use Rev)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm275 0
)

(local
	battleOver
	killedHim
	eofGuy
	egoGuy
)

(instance rm275 of Rm
	(properties
		picture 2
		style 16
		horizon 80
	)

	(method (init)
		(LoadMany rsVIEW 80 272 273 141 358 294 275 270 83 145)
		(Load rsPIC 275)
		(LoadMany rsSCRIPT 969)
		(super init: &rest)
		(= gSpellChecker rm275Check)
		(self setScript: fightingScript)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((!= (event type:) evSAID))
			((Said 'look,look>')
				(cond
					((Said '/ceiling,up')
						(HighPrint 275 0) ; "The ceiling is covered in goldleaf."
					)
					((Said '/floor,down')
						(HighPrint 275 1) ; "The floor is paved with large tiles."
					)
					(
						(or
							(Said
								'search,look,look[<at,around][/room,area][/!*]'
							)
							(Said '/hall[<eof]')
						)
						(HighPrint 275 2) ; "It looks like a cross between your average fraternal organization meeting hall and a dungeon. The shackles give it a special flavor."
					)
					((Said '/fighter,fighter')
						(cond
							(killedHim
								(HighPrint 275 3) ; "You sure showed him who's boss! He's quite dead. Or is he? Something felt a little funny when you stabbed him."
							)
							(battleOver
								(HighPrint 275 4) ; "He's at your mercy. The voices urge you to show none."
							)
							(else
								(HighPrint 275 5) ; "Big little guy, isn't he?"
							)
						)
					)
				)
			)
		)
	)

	(method (notify which)
		(switch which
			(59
				(HighPrint 275 6) ; "You run away. No one tries to stop you."
				(= gWimpyHero 3)
				(self newRoom: 271)
			)
			(60
				(HighPrint 275 7) ; "You're so tired you can barely stand."
				(= [gEgoStats 17] 1) ; stamina
				(= gWimpyHero 4)
				(self newRoom: 271)
			)
			(61
				(EgoDead 1 275 8 #title {Proper Preparation Pays}) ; "Now *that* took some doing! You entered your fake initiation combat in such bad condition that your opponent managed to kill you with a wooden sword. Nice work. Take two aspirin, get some rest, and restore your game to a previous (and more alert) condition."
			)
			(57
				(= battleOver 1)
				(self setScript: doneScript)
			)
			(58
				(= battleOver 1)
				(self setScript: doneScript)
			)
		)
		(return 1)
	)
)

(instance fighter of Actor
	(properties
		x 175
		y 125
		description {the swordsman}
		lookStr {Walid, the swordsman, is not pleased.}
		view 272
		loop 1
		signal 16384
	)
)

(instance issur of Talker
	(properties
		x 15
		y 158
		noun '/man,issur,armorer'
		description {Issur}
		lookStr {The man talking to you is Issur, the blacksmith and weaponer.}
		view 141
		illegalBits 0
		tLoop 3
		talkSpeed 1
		said '[/issur,man,armorer]>'
		title {Issur:}
		back 14
	)

	(method (showText what)
		(super showText: what)
	)
)

(instance extra1 of Actor
	(properties
		x 17
		y 159
		noun '/man,spectator'
		description {the spectator}
		lookStr {Hassan used to be a Brigand.  Some still wonder.}
		view 358
		priority 11
		signal 16400
		illegalBits 0
	)
)

(instance extra2 of Actor
	(properties
		x 5
		y 154
		noun '/man,spectator'
		description {the spectator}
		lookStr {Saddam got off duty just to watch Walid beat up on you.}
		view 294
		priority 11
		signal 16400
		illegalBits 0
	)
)

(instance extra3 of Actor
	(properties
		y 162
		noun '/man,spectator'
		description {the spectator}
		lookStr {Hussein was hoping to see Mr. Big-Shot Walid get beaten.}
		view 294
		priority 11
		signal 16400
		illegalBits 0
	)
)

(instance shackles of PicView
	(properties
		x 210
		y 79
		noun '/chain,manacle'
		description {the shackles that bound you}
		lookStr {The shackles that bound you hang limply from the wall.}
		view 275
		loop 1
		cel 2
	)
)

(instance alleyDoor of PicView
	(properties
		x 125
		y 102
		noun '/door[<alley]'
		description {the door to the alley}
		lookStr {The door leads to the alley, you think.}
		view 275
	)
)

(instance flame1 of Flame
	(properties
		x 120
		y 60
		noun '/flame,fire,sconce'
		view 270
		loop 2
	)
)

(instance flame2 of Flame
	(properties
		x 163
		y 60
		noun '/flame,fire,sconce'
		view 270
		loop 2
		cel 1
	)
)

(instance leftDoorHalf of PicView
	(properties
		x 21
		y 164
		noun '/door'
		description {the door}
		lookStr {The door leads to another room, you think.}
		view 275
		loop 1
	)
)

(instance rightDoorHalf of PicView
	(properties
		x 34
		y 154
		noun '/door'
		description {the door}
		lookStr {The door leads to another room, you think.}
		view 275
		loop 1
		cel 1
	)
)

(instance stabEm of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= killedHim 1)
				(fighter view: 272 loop: 5 cel: 0)
				(gEgo
					view: 80
					loop: 10
					cel: 1
					palette: 1
					posn: (+ (gEgo x:) 20) (- (gEgo y:) 9)
				)
				(= cycles 2)
			)
			(1
				(gEgo cel: 0)
				(= cycles 2)
			)
			(2
				(gEgo view: 272 loop: 7 cel: 0 setCycle: End)
				(= cycles 15)
			)
			(3
				(gEgo cel: 1)
				(= cycles 10)
			)
			(4
				(gEgo cel: 2)
				(= cycles 15)
			)
			(5
				(gEgo cycleSpeed: 1 setCycle: Beg self)
			)
			(6
				(gEgo view: 80 loop: 10 cel: 0)
				(= cycles 2)
			)
			(7
				(gEgo cel: 1)
				(= cycles 2)
			)
			(8
				(issur init: setCycle: Walk setMotion: MoveTo 40 (issur y:))
				(gEgo
					view: 83
					loop: 0
					cel: 4
					posn: (- (gEgo x:) 20) (+ (gEgo y:) 9)
					setCycle: Beg self
				)
			)
			(9
				(gEgo view: 0)
				(NormalEgo)
				(issur view: 145 loop: 0)
				(Say issur self 275 9) ; "Now that's a REAL hero. Show no mercy to losers!"
			)
			(10
				(client setScript: member)
			)
		)
	)
)

(instance theTurkey of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 154) ; fNotKilledEOF
				(gEgo setCycle: Beg)
				(fighter view: 272 loop: 5 cel: 0)
				(issur
					init:
					setCycle: Walk
					setMotion: MoveTo 60 (issur y:) self
				)
			)
			(1
				(issur view: 145 loop: 0)
				(Say issur self 275 10) ; "What a turkey! Even when you win, you don't have the guts to finish the task. Never show mercy to an enemy."
			)
			(2
				(NormalEgo)
				(client setScript: member)
			)
		)
	)
)

(instance member of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(issur
					view: 141
					setCycle: Walk
					setMotion: MoveTo (- (gEgo x:) 15) (gEgo y:) self
				)
			)
			(1
				(issur loop: 2 cel: 0 setCycle: End self)
			)
			(2
				(gEgo posn: (+ (gEgo x:) 3) (- (gEgo y:) 2))
				(= cycles 2)
			)
			(3
				(issur loop: 0)
				(gEgo setHeading: 225 self)
			)
			(4
				(issur view: 145)
				(Say issur self 275 11) ; "Isn't that right, Walid?"
			)
			(5
				(fighter setCycle: End self)
			)
			(6
				(fighter
					loop: 6
					cel: 0
					posn: (fighter x:) (- (fighter y:) 6)
					setCycle: End self
				)
			)
			(7
				(HighPrint 275 12 25 3 80 {Walid}) ; "Dat's right, Boss!"
				(= seconds 2)
			)
			(8
				(extra1
					init:
					setCycle: Walk
					setMotion: MoveTo (+ (extra1 x:) 35) (extra1 y:)
				)
				(= cycles 5)
			)
			(9
				(extra2
					init:
					setCycle: Walk
					setMotion: MoveTo (+ (extra1 x:) 35) (- (extra1 y:) 10)
				)
				(= cycles 5)
			)
			(10
				(extra3
					init:
					setCycle: Walk
					setMotion: MoveTo (+ (extra1 x:) 31) (+ (extra1 y:) 10) self
				)
			)
			(11
				(extra1 view: 352 loop: 0 cel: 0)
				(extra2 view: 295 loop: 0 cel: 0)
				(extra3 view: 295 loop: 0 cel: 0)
				(Say issur self 275 13) ; "Your real sword is in the other room. You have been tested to prove your worthiness to join the Eternal Order of Fighters."
			)
			(12
				(extra3 view: 295 loop: 3 cel: 0)
				(if killedHim
					(Say issur self 275 14) ; "You have shown through your obedience, guts, and skill that you should now be one of the highest ranks of EOF. You are now a Brother Scorpion. Welcome to the club!"
				else
					(Say issur self 275 15) ; "You can fight, and you've got some guts, but you just can't obey a simple order. We figured we'd let you join EOF despite the fact that you failed. You are admitted to the beginning rank of our order. You are now a Brother Saurus. Welcome to EOF."
				)
			)
			(13
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 2)
				(= seconds 1)
			)
			(14
				(SolvePuzzle 664 7 0)
				(SkillUsed 14 50) ; honor
				(HighPrint 275 16) ; "You are shown the secret handshake, you learn the secret password: "Might is Right!", and you are given the secret membership token with your name, rank, and serial number engraved upon it."
				(HighPrint 275 17) ; "After you pay five dinars for membership fees, you are taken into the other room to celebrate."
				(Print 275 18) ; "The Next Morning....."
				(HighPrint 275 19) ; "You can't remember what the party afterwards was like and have no idea when or how you got to bed. You awake with a terrible headache and feel very sick. Somehow, this just isn't your idea of how a Hero should be."
				(if (< [gInvNum 2] 5) ; Dinar
					(= [gInvNum 2] 0) ; Dinar
				else
					(gEgo use: 2 5) ; Dinar
				)
				(gEgo get: 40) ; EOFToken
				(= cycles 4)
			)
			(15
				(= gDay 16)
				(if (OneOf gElementalState 1 3 5 7)
					(gCurRoom newRoom: 340)
				else
					(= gCurRoomNum 101) ; bedroom
					(FixTime 8 0)
					(gCurRoom newRoom: 100)
					(self dispose:)
				)
			)
		)
	)
)

(instance fightingScript of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 159) ; fPracticeFight
				(= cycles 2)
			)
			(1
				(gCurRoom drawPic: 275)
				(flame1 init: cycleSpeed: 1 setCycle: Fwd)
				(flame2 init: cycleSpeed: 1 setCycle: Rev)
				(InitAddToPics alleyDoor leftDoorHalf rightDoorHalf shackles)
				((= eofGuy (ScriptID 273 0)) barMessage: 0 posn: 145 145) ; badGuy
				((= egoGuy (ScriptID 32 0)) ; warrior
					barMessage: 0
					posn: 112 150
					setPri: 10
					opponent: eofGuy
					initCombat:
				)
				(fighter
					init:
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 145 145 self
				)
				(= gSpellChecker rm275Check)
			)
			(2
				(fighter dispose:)
				(eofGuy initCombat:)
				(self dispose:)
			)
		)
	)
)

(instance doneScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(eofGuy dispose:)
				(egoGuy dispose:)
				(fighter
					cel: 0
					setLoop: 4
					init:
					cycleSpeed: 1
					setCycle: End self
				)
				(NormalEgo)
				(gEgo view: 83 loop: 0 cel: 4 init: posn: 111 149)
				(fighter cycleSpeed: 0)
			)
			(1
				(DontTalk 0)
				(HighPrint 275 20 25 3) ; "The voices call to you, "Well done. Now finish him off!""
				(= cycles 10)
			)
			(2
				(LowPrint 275 21 25 3) ; "Kill Him!!"
				(= cycles 10)
			)
			(3
				(Print 275 21 #time 3 #at 20 100) ; "Kill Him!!"
				(= cycles 10)
			)
			(4
				(Print 275 21 #time 3 #at 280 100) ; "Kill Him!!"
				(= cycles 10)
			)
			(5
				(HighPrint 275 21 25 3) ; "Kill Him!!"
				(= cycles 10)
			)
			(6
				(= seconds 5)
			)
			(7
				(client setScript: theTurkey)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((!= (event type:) evSAID))
			((Said 'kill,attack,attack,yes')
				(SkillUsed 14 -20) ; honor
				(CantBePaladin)
				(client setScript: stabEm)
			)
			((or (Said 'no') (Said 'drop,(put<away)/weapon'))
				(SolvePuzzle 678 7 3)
				(SkillUsed 14 40) ; honor
				(client setScript: theTurkey)
			)
			((Said 'ask//!*')
				(Print 275 22) ; "There is no one who wants to chit-chat."
			)
		)
	)
)

(instance rm275Check of Code
	(properties)

	(method (doit)
		(HighPrint 275 23) ; "The EOF despises those who attack by any means other than sword-to-sword. You are immediately surrounded and thrown out of the Hall."
		(SkillUsed 14 -10) ; honor
		(= gWimpyHero 3)
		(gCurRoom newRoom: 271)
		(return 0)
	)
)

