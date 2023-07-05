;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 322)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use TopWindow)
(use Talker)
(use Interface)
(use LoadMany)
(use Extra)
(use Save)
(use Motion)
(use Actor)
(use System)

(public
	rakeesh 0
	baby 1
)

(local
	[rakeeshGenList 33] = [46 47 48 49 50 51 52 53 54 55 56 57 59 45 60 61 62 45 63 64 65 66 67 68 69 70 71 80 74 75 76 77 78]
	[rakeeshSpecList 62] = [0 '//nature' 2 '//flame' 5 '//attack,battle' 6 '//leg,bandage,injury' 8 '//demon' 10 '//kingdom' 12 '//wizard' 14 '//choice' 15 '//people,lion' 16 '//tarna' 17 '//power,fighter' 19 '//will,soul' 20 '//philosopher' 21 '//forge,soulforge[<soul,about]' 23 '//paladin' 27 '//blade[<flaming,about]' 28 '//guildmaster' 30 '//simba,baby,baby' 32 '//magic<dark' 34 '//adventurer,adventure,adventuring' 35 '//ask' 36 '//hero' 37 '//ghoul' 38 '//dinosaur,(saurii<terror)' 39 '//griffin' 40 '//bandit' 41 '//(man<jackal),jackal' 42 '//scorpion' 43 '//poison,pill,cure,tail' 44 '//moose' 0 0]
	babyTimer
	babyTalk
	babyMessage
	oneKick
)

(instance baby of Prop
	(properties
		x 231
		y 113
		noun '/baby,simba'
		description {the baby Simba}
		view 168
		loop 11
		priority 7
		signal 16
		cycleSpeed 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (and (< (rakeeshBod loop:) 5) (gCast contains: rakeesh))
					(HighPrint 322 0) ; "The baby fearlessly plays with the Liontaur's tail."
				else
					(HighPrint 322 1) ; "The kid's hangin' loose."
				)
			)
			(9
				(if (not (IsFlag 71))
					(SetFlag 71)
					(= babyMessage 1)
					(baby setScript: babyTurns)
				else
					(HighPrint 322 2) ; "Don't bother. He only tries to show off."
				)
			)
			(7
				(HighPrint 322 3) ; "Rakeesh wouldn't appreciate it."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'grab,get/baby')
				(self doVerb: 7)
			)
			((Said 'hit/baby,simba')
				(cond
					((and (gEgo inRect: 210 114 300 125) (not oneKick))
						(= oneKick 1)
						(gEgo setScript: babyToss)
					)
					(oneKick
						(HighPrint 322 4) ; "Hero types don't do that sort of thing more than once."
					)
					(else
						(HighPrint 322 5) ; "Hero types don't do that sort of thing."
					)
				)
			)
			((Said 'ask/simba,baby')
				(if (not (IsFlag 71))
					(SetFlag 71)
					(= babyMessage 1)
					(baby setScript: babyTurns)
				else
					(HighPrint 322 2) ; "Don't bother. He only tries to show off."
				)
			)
		)
	)

	(method (init)
		(self setScript: welcomeBaby)
		(super init:)
	)
)

(instance rakeesh of Talker
	(properties
		x 195
		y 108
		z 30
		description {the Liontaur Rakeesh}
		lookStr {The leonine creature before you looks ferocious and kindly at the same time.}
		view 168
		loop 4
		priority 8
		signal 24592
		illegalBits 0
		tLoop 4
		talkSpeed 1
		myName '//rakeesh,lion,man,fighter'
		title {Rakeesh:}
		back 11
		msgFile 168
	)

	(method (init)
		(LoadMany rsVIEW 168 6)
		(super init:)
		(= tWindow TopWindow)
		(rakeeshHead init:)
		(rakeeshBod init:)
		(rakeeshTail init:)
		(if (and (not (gEgo has: 31)) (== gDay 13) (> gElementalState 6)) ; Soulforge
			(gCurRoom entranceScript: warningOfEarth)
		)
	)

	(method (showText what)
		(cond
			(
				(and
					(== what 27)
					(not (IsFlag 72))
					(== gOrigHeroType 0)
					(== gDay 13)
				)
				(SetFlag 72)
				(rakeeshBod setScript: tellOfSword)
			)
			((and (== what 5) (<= 5 gElementalState 6))
				(= what 3)
				(self showMany: 3 4)
			)
			(else
				(switch what
					(78
						(Say self msgFile 78 msgFile 35)
					)
					(0
						(self showMany: what 1)
					)
					(6
						(self showMany: what 7)
					)
					(8
						(self showMany: what 9)
					)
					(10
						(self showMany: what 11)
					)
					(12
						(self showMany: what 13)
					)
					(17
						(self showMany: what 18)
					)
					(21
						(self showMany: what 22)
					)
					(23
						(SolvePuzzle 660 3 0)
						(self showMany: what 26)
					)
					(28
						(self showMany: what 29)
					)
					(32
						(self showMany: what 33)
					)
					(57
						(self showMany: what 58)
					)
					(else
						(super showText: what &rest)
					)
				)
			)
		)
	)

	(method (atSpec which)
		(return [rakeeshSpecList which])
	)

	(method (atGen which)
		(return [rakeeshGenList which])
	)

	(method (doit)
		(cond
			((not babyTimer))
			((-- babyTimer))
			((not (baby loop:))
				(baby setScript: babyTurns)
			)
			(else
				(baby setScript: babyResumes)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (Said 'hello,greet') (Said '/hello,greet'))
				(Say self 322 6) ; "It is good to see you, young Hero. A nice day to be adventuring."
			)
			(
				(or
					(Said 'search,look,look[<at,around][/room,area][/!*]')
					(Said 'look,look/courtyard')
				)
				(HighPrint 322 7) ; "At the west end of the Plaza of the Fighters is the entrance to the local Guild Hall. Sitting near the entrance is a rather large Liontaur."
			)
			((Said 'thank[/rakeesh]')
				(if (and (IsFlag 72) (not (IsFlag 186)))
					(SetFlag 186)
					(SkillUsed 14 50) ; honor
				)
				(SayThanks rakeesh 322 8)
			)
			((Said 'greet[/rakeesh]')
				(Say rakeesh 322 9) ; "May you have a pleasant day as well."
			)
			((Said 'tell//self,spielburg')
				(Say rakeesh 322 10) ; "You have truly earned the title of Hero."
			)
			((Said 'tell//elemental[<earth]')
				(cond
					((!= gOrigHeroType 0)
						(if (> gElementalState 5)
							(Say rakeesh 322 11) ; "The Elemental of Earth was a difficult adversary. You showed yourself to be a great Hero."
						else
							(Say rakeesh 322 12) ; "The Elemental of Earth is a fearsome adversary."
						)
					)
					((< gElementalState 5)
						(Say rakeesh 322 13) ; "The Elemental of Earth would be a fearsome adversary to face."
					)
					((== gElementalState 5)
						(if (not (IsFlag 72))
							(SetFlag 72)
							(rakeeshBod setScript: tellOfSword)
						else
							(Say rakeesh 322 14) ; "Soulforge was given to you to deal with the Earth Elemental."
						)
					)
					((> gElementalState 5)
						(Say rakeesh 322 11) ; "The Elemental of Earth was a difficult adversary. You showed yourself to be a great Hero."
					)
				)
			)
			((Said 'attack')
				(Say rakeesh 322 15) ; "I am sorry, but I do not practice much anymore."
			)
			(
				(Said
					'get,get,get,borrow/(blade[<flaming]),(forge<soul),soulforge'
				)
				(if (and (== gDay 13) (== gOrigHeroType 0))
					(if (IsFlag 72)
						(Say rakeesh 322 16) ; "You have my sword, Hero."
					else
						(SetFlag 72)
						(rakeeshBod setScript: tellOfSword)
					)
				else
					(Say rakeesh 322 17) ; "I will keep my sword, thank you."
				)
			)
			((Said 'bargain')
				(HighPrint 322 18) ; "It is not wise to try to bargain with Rakeesh."
			)
			(
				(Said
					'give,hand,offer,replace/blade,(forge<soul),soulforge[/rakeesh,lion]'
				)
				(cond
					((not (gEgo has: 31)) ; Soulforge
						(HighPrint 322 19) ; "You do not have Rakeesh' sword."
					)
					((< gElementalState 6)
						(Say rakeesh 322 20) ; "Go and defeat the Earth Elemental before returning my sword."
					)
					((gEgo has: 31) ; Soulforge
						(SolvePuzzle 676 5 3)
						(gEgo setScript: egoGivesSword)
					)
					(else
						(DontHave)
					)
				)
			)
		)
	)

	(method (messages)
		(if (& (gEgo onControl: 1) $0800)
			(gEgo setPri: 9)
		)
		(if (rakeeshHead script:)
			(rakeeshHead cel: 0 setScript: 0)
		)
		(super messages: &rest)
	)

	(method (endTalk)
		(self setCel: 0)
		(gEgo setPri: -1)
		(super endTalk: &rest)
	)

	(method (onMe)
		(return (or (rakeeshHead onMe: &rest) (rakeeshBod onMe: &rest)))
	)
)

(instance rakeeshBod of Prop
	(properties
		x 196
		y 105
		view 168
		loop 1
		priority 7
		signal 16
	)
)

(instance rakeeshHead of Prop
	(properties
		x 196
		y 108
		z 30
		view 168
		loop 3
		priority 7
		signal 16
	)
)

(instance rakeeshTail of Extra
	(properties
		x 224
		y 89
		noun '/tail'
		description {the Liontaur's tail}
		view 168
		loop 2
		priority 7
		signal 16
		cycleType 1
		hesitation 20
		minPause 40
		maxPause 80
		minCycles 1
		maxCycles 3
	)

	(method (doVerb theVerb)
		(if (== theVerb 1)
			(if (gCast contains: baby)
				(HighPrint 322 21) ; "Imagine! Such a warrior's tail used as a playtoy for a baby!"
			else
				(HighPrint 322 22) ; "Rakeesh relaxes but his tail stays ever alert."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance babyTurns of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if babyMessage
					(HighPrint 322 23 80 {Hero}) ; "Goo goo ga ga goo."
				)
				(baby setCycle: Beg self)
			)
			(1
				(baby loop: 10 setCycle: CT 3 1 self)
			)
			(2
				(if babyMessage
					(= babyMessage 0)
					(Print 322 24 #title {Baby Simba} #at -1 25 #window babyWindow) ; "Poltergeists make up the principle types of spontaneous material manifestations."
					(= babyTimer 5)
				else
					(if (and (not (rakeesh cycler:)) (== (++ babyTalk) 4))
						(= babyTalk 0)
						(Print ; "Goo goo, Maa Fhimt."
							322
							25
							#time
							5
							#title
							{Baby Simba}
							#at
							220
							50
							#window
							babyWindow
							#dispose
						)
					)
					(baby loop: 11 setCycle: Fwd)
					(= babyTimer 50)
				)
				(self dispose:)
			)
		)
	)
)

(instance babyResumes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(baby loop: 10 cel: 3 setCycle: Beg self)
			)
			(1
				(baby loop: 0)
				(= babyTimer (Random 200 400))
				(client setScript: playWithTail)
			)
		)
	)
)

(instance rakeeshLooks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rakeeshHead setCycle: End self)
			)
			(1
				(= cycles 15)
			)
			(2
				(rakeeshHead setCycle: Beg self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance warningOfEarth of Script
	(properties)

	(method (init)
		(Say rakeesh self 322 26 322 27) ; "The Elemental of Earth will soon destroy the city. It seems that you will need to be a hero again."
		(self dispose:)
		(super init:)
	)
)

(instance tellOfSword of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gEgo distanceTo: rakeeshBod) 40)
					(gEgo setMotion: MoveTo 174 118 self)
				else
					(self cue:)
				)
			)
			(1
				(Face gEgo rakeeshBod)
				(Say rakeesh self 322 28) ; "You will need the magic of a flaming sword to defeat the Earth Elemental."
			)
			(2
				(rakeesh x: 194 z: 39)
				(rakeeshHead hide:)
				(rakeeshTail hide:)
				(rakeeshBod loop: 6 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(3
				(Say rakeesh self 322 29) ; "Permit me to loan you my sword, "Soulforge.""
			)
			(4
				(rakeeshBod loop: 7 cel: 0 setCycle: CT 7 1 self)
			)
			(5
				(rakeeshBod cel: 8)
				(flame init: setCycle: Fwd)
				(= cycles 15)
			)
			(6
				(flame dispose:)
				(rakeeshBod setCycle: End self)
			)
			(7
				(rakeesh x: 196)
				(Say rakeesh self 322 30 322 31 322 32) ; "When you are in battle against the Elemental, the flame of the sword will aid you."
			)
			(8
				(if (or (!= (gEgo x:) 174) (!= (gEgo y:) 118))
					(gEgo setMotion: MoveTo 174 118 self)
				else
					(self cue:)
				)
			)
			(9
				(gEgo view: 168 loop: 8 cel: 0 setCycle: CT 2 1 self)
			)
			(10
				(gEgo setCycle: End self get: 31) ; Soulforge
				(rakeeshBod loop: 5)
				(SolvePuzzle 661 7 0)
				(HighPrint 322 33 25 4) ; "You take the Flaming Sword."
				(rakeesh x: 195)
			)
			(11
				(NormalEgo)
				(Face gEgo rakeeshBod)
				(self dispose:)
			)
		)
	)
)

(instance welcomeBaby of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(baby setCycle: Fwd)
				(= seconds 3)
			)
			(1
				(Say rakeesh 322 34) ; "Good Day. A most pleasant one for those such as myself who like the heat, although most humans might find it hot. Simba here, is more like a lion. He is having a wonderful time."
				(client setScript: babyResumes)
			)
		)
	)
)

(instance playWithTail of Script
	(properties)

	(method (doit)
		(if
			(and
				(== (rakeeshTail cel:) 7)
				(< (baby loop:) 10)
				(not (rakeesh cycler:))
			)
			(baby setCycle: Beg)
			(if (Random 0 1)
				(rakeeshHead setScript: rakeeshLooks)
			)
		)
		(super doit:)
	)
)

(instance babyWindow of SysWindow
	(properties
		color 5
		back 14
	)
)

(instance flame of Prop
	(properties
		x 178
		y 105
		z 50
		view 168
		loop 12
		signal 16384
	)
)

(instance babyToss of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= babyTimer 0)
				(baby loop: 10 cel: 0 setCycle: End)
				(gEgo
					view: 22
					loop: 0
					cel: 0
					illegalBits: 0
					posn: (+ (gEgo x:) 3) (+ (gEgo y:) 8)
					setCycle: End
				)
				(= cycles 20)
			)
			(1
				(baby loop: 11 setCycle: Fwd)
				(HighPrint 322 35 80 {Baby Simba} 35 babyWindow 103) ; "Watch it buddy! I'm not getting hazardous duty pay on this gig, so don't mess with me. They don't pay me enough to put up with a lowlife like you. Cheeeeeezzzz!!"
				(= seconds 6)
			)
			(2
				(baby loop: 10 cel: 3 setCycle: Beg)
				(gEgo loop: 1 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(3
				(= babyTimer 100)
				(cls)
				(NormalEgo)
				(gEgo loop: 3)
				(self dispose:)
			)
		)
	)
)

(instance egoGivesSword of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion:
						MoveTo
						(- (rakeesh x:) 5)
						(+ (rakeesh y:) 12)
						self
				)
			)
			(1
				(Face gEgo rakeesh)
				(= cycles 2)
			)
			(2
				(HighPrint 322 36) ; "You hand the Flaming Sword back to Rakeesh."
				(= cycles 2)
			)
			(3
				(Say rakeesh self 322 37) ; "Thank You, It was a fine battle."
			)
			(4
				(gEgo use: 31) ; Soulforge
				(self dispose:)
			)
		)
	)
)

