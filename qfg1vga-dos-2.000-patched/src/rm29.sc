;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29)
(include sci.sh)
(use Main)
(use n814)
(use Print)
(use Talker)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm29 0
	gargoyleTalker 1
)

(local
	[local0 41]
	local41
	local42
	local43
	local44
	local45
	local46
	local47
	[local48 3]
	local51
	local52
	local53
	local54
	local55
	local56
	local57
	local58
	local59
	local60
	local61
	local62
	local63
	[local64 60]
)

(procedure (localproc_0)
	(= local45 1)
	(= local47 1)
)

(instance rm29 of Rm
	(properties
		noun 3
		picture 29
		style 8
		horizon 157
		north 30
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(gMessager say: 3 2) ; MISSING MESSAGE
			)
			(51 ; openSpell
				(if local44
					(gMessager say: 3 51) ; "The door is already open."
				else
					(localproc_0)
				)
			)
			(50 ; detectMagicSpell
				(localproc_0)
			)
			(79 ; zapSpell
				(localproc_0)
			)
			(77 ; triggerSpell or Pickup Inventory
				(localproc_0)
			)
			(78 ; dazzleSpell
				(localproc_0)
			)
			(80 ; calmSpell
				(localproc_0)
			)
			(82 ; fetchSpell
				(localproc_0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(= global451 0)
		(= gUseSortedFeatures local51)
		(SetFlag 19)
		(super dispose:)
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 299 189 212 168 166 165 143 136 120 168 4 182 4 189 0 189
					yourself:
				)
		)
		(LoadMany rsSOUND 66 28)
		(LoadMany rsVIEW 29 530)
		(self setFeatures: mySky doorPost theWindow)
		(super init:)
		(gLongSong number: 114 loop: -1 init: play:)
		(= local51 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(= local52 gSpeed)
		(SL enable:)
		(gargoyle init: cycleSpeed: 2 stopUpd:)
		(theDoor cel: 0 posn: 113 118 init:)
		(= local53 (gTheIconBar at: 1))
		(gTheIconBar curIcon: local53)
		(gGame setCursor: (local53 cursor:) 1)
		(gEgo setScript: walkIn)
	)

	(method (doit)
		(cond
			((gEgo script:))
			((== (gEgo edgeHit:) 3)
				(gEgo setScript: egoExits)
			)
			(local47
				(= local47 0)
				(gargoyle setScript: 0)
				(self setScript: teleportOut)
			)
			((and local41 (== (gEgo edgeHit:) 3))
				(gCurRoom newRoom: 28)
			)
		)
		(super doit:)
	)
)

(instance mySky of Feature
	(properties
		noun 4
		onMeCheck 2
	)
)

(instance doorPost of Feature
	(properties
		noun 1
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(theDoor doVerb: theVerb &rest)
	)
)

(instance theWindow of Feature
	(properties
		noun 5
		onMeCheck 8
	)
)

(instance Magic of Prop
	(properties
		view 530
		cycleSpeed 2
	)
)

(instance theDoor of Prop
	(properties
		noun 1
		view 29
	)
)

(instance gargoyle of Actor
	(properties
		x 151
		y 60
		noun 2
		view 29
		loop 2
		cel 2
		signal 24576
	)

	(method (init)
		(= global451 129)
		(PalVary pvCHANGE_TARGET 129)
		(AssertPalette 29)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(gMessager say: 2 1) ; "The stone creature looks like it's bored. Wouldn't you be?"
			)
			(81 ; flameDartSpell
				(= local47 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance gargoyleTalker of Talker
	(properties
		x 10
		y 10
		view 1029
		talkWidth 260
		modeless 1
		textX 15
		textY 110
	)

	(method (init)
		(= global451 2029)
		(PalVary pvCHANGE_TARGET 2029)
		(AssertPalette 1029)
		(= font gUserFont)
		(super init: gargBust gargMouth &rest)
	)
)

(instance gargBust of Prop
	(properties
		view 1029
		signal 16384
	)
)

(instance gargMouth of Prop
	(properties
		nsTop 29
		nsLeft 33
		view 1029
		loop 1
		signal 16384
	)
)

(instance portFrame of View
	(properties
		x 30
		y 76
		view 29
		loop 1
		priority 4
		signal 16400
	)
)

(instance laffer of Prop
	(properties
		x 30
		y 76
		view 29
		loop 3
		priority 5
		signal 16400
		cycleSpeed 8
	)
)

(instance walkIn of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gEgo init: posn: 142 233)
				(HandsOff)
				(= ticks 60)
			)
			(1
				(EgoGait 0 0) ; walking
				(UseStamina 50)
				(cond
					((< [gEgoStats 15] 20) ; stamina
						(= local43 1)
					)
					((< [gEgoStats 15] 60) ; stamina
						(= local42 1)
					)
				)
				(cond
					(local43
						(gEgo
							cycleSpeed: 12
							moveSpeed: 12
							view: 515
							setLoop: 2
							setMotion: MoveTo 148 183 self
						)
					)
					(local42
						(gEgo
							cycleSpeed: 6
							moveSpeed: 6
							setMotion: MoveTo 148 183 self
						)
					)
					(else
						(gEgo setMotion: MoveTo 148 183 self)
					)
				)
			)
			(2
				(cond
					(local43
						(gEgo
							setLoop: 1
							cel: 0
							cycleSpeed: 6
							moveSpeed: 6
							setCycle: CT 4 1 self
						)
					)
					(local42
						(gEgo
							view: 515
							cycleSpeed: 6
							moveSpeed: 6
							setLoop: 0
							cel: 0
							setCycle: CT 2 Fwd
						)
						(= ticks 60)
					)
					(else
						(self cue:)
					)
				)
			)
			(3
				(if local43
					(gEgo setCycle: End)
					(hitGround play: 90)
					(= ticks 240)
				else
					(self cue:)
				)
			)
			(4
				(cond
					(local43
						(gEgo cycleSpeed: 6 setCycle: Beg)
						(= ticks 180)
					)
					(local42
						(gEgo cycleSpeed: 6 setCycle: End)
						(= ticks 120)
					)
					(else
						(self cue:)
					)
				)
			)
			(5
				(if local43
					(gEgo setLoop: 0 cel: 7 forceUpd:)
					(= ticks 6)
				else
					(self cue:)
				)
			)
			(6
				(NormalEgo 3)
				(= ticks 6)
			)
			(7
				(= local41 1)
				(= temp0 (Random 1 4))
				(cond
					((not (IsFlag 19))
						(gMessager say: 3 0 25 0 self) ; "You feel as though you have just scaled the Matterhorn in full armor. What a climb! You can see all of Spielburg valley from here."
					)
					(local43
						(gMessager say: 3 0 5 1 self) ; "Your body can't take too much more of this kind of mountaineering. At this point, you envy the gargoyle his job."
					)
					(local42
						(gMessager say: 3 0 23 1 self) ; "No matter how strong you feel at the bottom of the mountain, you're always more exhausted than the last time you reached the top."
					)
					(else
						(gMessager say: 3 0 26 temp0 self)
					)
				)
			)
			(8
				(HandsOff)
				(gargoyle cycleSpeed: 6 setCycle: Beg self)
			)
			(9
				(gEgo setSpeed: local52)
				(= ticks 90)
			)
			(10
				(cond
					((not (IsFlag 19))
						(gMessager say: 2 0 9 1 self) ; "STAND FAST!"
					)
					(gNight
						(gMessager say: 2 0 3 1 self) ; ""DO NOT DISTURB THE WIZARD AT REST!"
					)
					(local43
						(gMessager say: 2 0 5 1 self) ; "AND YOU WANT TO BE A HERO?!"
					)
					(local42
						(gMessager say: 2 0 23 1 self) ; "YOU DON'T GIVE UP EASILY, DO YOU?"
					)
					(else
						(gMessager say: 2 0 4 1 self) ; ""OH! YOU AGAIN!"
					)
				)
			)
			(11
				(cond
					((and gNight (not (IsFlag 19)))
						(gMessager say: 2 0 3 1 self) ; ""DO NOT DISTURB THE WIZARD AT REST!"
					)
					(gNight
						(rm29 setScript: teleportOut)
						(self dispose:)
					)
					(local43
						(gMessager say: 2 0 21 1 self) ; "CAN YOU HEAR ME? YOU HAVE THREE QUESTIONS."
					)
					((IsFlag 354)
						(gMessager say: 2 0 13 1 self) ; "HERE COME YOUR QUESTIONS:"
					)
					(else
						(SetFlag 354)
						(gMessager say: 2 0 11 1 self) ; "HE WHO WOULD THE WIZARD SEE FIRST MUST ANSWER QUESTIONS THREE:"
					)
				)
			)
			(12
				(if (and gNight (not (IsFlag 19)))
					(rm29 setScript: teleportOut)
				else
					(rm29 setScript: askName)
				)
				(self dispose:)
			)
		)
	)
)

(instance egoExits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo (gEgo x:) 245 self)
			)
			(1
				(gCurRoom newRoom: 28)
			)
		)
	)
)

(instance askName of Script
	(properties)

	(method (doit)
		(if (and (== state 6) (< (gEgo y:) 175))
			(= local47 1)
		)
		(super doit:)
	)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				0
				(= local54 (Random 2 9))
				(= local55 (Random 2 9))
				(= local56 (Random 2 9))
				(= local57 (Random 2 9))
				(gMessager say: 2 0 8 1 self) ; "WHAT IS YOUR NAME?"
			)
			(1
				1
				(self changeState: 5)
			)
			(2
				2
				(= local55 (Random 2 9))
				(self changeState: 5)
			)
			(3
				3
				(= local56 (Random 2 9))
				(self changeState: 5)
			)
			(4
				4
				(= local57 (Random 2 9))
				(self changeState: 5)
			)
			(5
				5
				(cond
					((== local55 local54)
						(self changeState: 2)
					)
					((or (== local56 local54) (== local56 local55))
						(self changeState: 3)
					)
					(
						(or
							(== local57 local54)
							(== local57 local55)
							(== local57 local56)
						)
						(self changeState: 4)
					)
					(else
						(self cue:)
					)
				)
			)
			(6
				6
				(if (> local54 8)
					(= temp0 60)
				else
					(= temp0 40)
				)
				(if (> local55 8)
					(= temp1 (+ temp0 40))
				else
					(= temp1 (+ temp0 20))
				)
				(if (> local56 8)
					(= temp2 (+ temp1 40))
				else
					(= temp2 (+ temp1 20))
				)
				(switch
					(if (== global428 0)
						(Print
							addButton: 0 2 0 8 10 0 0 29 ; "Unknown Hero"
							addButton: 1 2 0 8 local54 0 20 29
							addButton: 2 2 0 8 local55 0 temp0 29
							addButton: 3 2 0 8 local56 0 temp1 29
							addButton: 4 2 0 8 local57 0 temp2 29
							width: 170
							init:
						)
					else
						(Print
							addButton: 0 @global428 0 0
							addButton: 1 2 0 8 local54 0 20 29
							addButton: 2 2 0 8 local55 0 temp0 29
							addButton: 3 2 0 8 local56 0 temp1 29
							addButton: 4 2 0 8 local57 0 temp2 29
							width: 170
							init:
						)
					)
					(0
						(client setScript: askQuest)
						(self dispose:)
					)
					(1
						(= local58 local54)
						(self cue:)
					)
					(2
						(= local58 local55)
						(self cue:)
					)
					(3
						(= local58 local56)
						(self cue:)
					)
					(4
						(= local58 local57)
						(self cue:)
					)
				)
			)
			(7
				7
				(gMessager say: 2 0 7 local58 self)
			)
			(8
				8
				(client setScript: teleportOut)
				(self dispose:)
			)
		)
	)
)

(instance askQuest of Script
	(properties)

	(method (doit)
		(if (and (== state 6) (< (gEgo y:) 175))
			(= local47 1)
		)
		(super doit:)
	)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				0
				(gMessager say: 2 0 11 2 self) ; "WHAT IS YOUR QUEST?"
				(= local54 (Random 1 2))
				(if [gEgoStats 12] ; magic
					(= local55 3)
				else
					(= local55 (Random 4 9))
				)
				(= local56 (Random 4 9))
				(= local57 (Random 4 9))
				(= local58 (Random 4 9))
			)
			(1
				1
				(self changeState: 5)
			)
			(2
				2
				(= local56 (Random 4 9))
				(self changeState: 5)
			)
			(3
				3
				(= local57 (Random 4 9))
				(self changeState: 5)
			)
			(4
				4
				(= local58 (Random 4 9))
				(self changeState: 5)
			)
			(5
				5
				(cond
					((== local56 local55)
						(self changeState: 2)
					)
					((or (== local57 local56) (== local57 local55))
						(self changeState: 3)
					)
					(
						(or
							(== local58 local57)
							(== local58 local56)
							(== local58 local55)
						)
						(self changeState: 4)
					)
					(else
						(self cue:)
					)
				)
			)
			(6
				6
				(cond
					((> local55 7)
						(= temp0 68)
					)
					((> local55 6)
						(= temp0 51)
					)
					(else
						(= temp0 34)
					)
				)
				(cond
					((> local56 7)
						(= temp1 (+ temp0 51))
					)
					((> local56 6)
						(= temp1 (+ temp0 34))
					)
					(else
						(= temp1 (+ temp0 17))
					)
				)
				(cond
					((> local57 7)
						(= temp2 (+ temp1 51))
					)
					((> local57 6)
						(= temp2 (+ temp1 34))
					)
					(else
						(= temp2 (+ temp1 17))
					)
				)
				(switch
					(Print
						addButton: 0 2 0 12 local54 0 0 29
						addButton: 1 2 0 12 local55 0 17 29
						addButton: 2 2 0 12 local56 0 temp0 29
						addButton: 3 2 0 12 local57 0 temp1 29
						addButton: 4 2 0 12 local58 0 temp2 29
						width: 150
						init:
					)
					(0
						(client setScript: askRand)
						(self dispose:)
					)
					(1
						(if [gEgoStats 12] ; magic
							(client setScript: askRand)
							(self dispose:)
						else
							(= local54 local55)
							(self changeState: 7)
						)
					)
					(2
						(= local54 local56)
						(self changeState: 7)
					)
					(3
						(= local54 local57)
						(self changeState: 7)
					)
					(4
						(= local54 local58)
						(self changeState: 7)
					)
				)
			)
			(7
				7
				(gMessager say: 2 0 10 local54 self)
			)
			(8
				8
				(client setScript: teleportOut)
				(self dispose:)
			)
		)
	)
)

(instance askRand of Script
	(properties)

	(method (doit)
		(if (and (== state 1) (< (gEgo y:) 175))
			(= local47 1)
		)
		(super doit:)
	)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4)
		(switch (= state newState)
			(0
				0
				(= local62 (Random 1 7))
				(= local61 1)
				(switch (= local59 (Random 0 4))
					(0
						(= local54 1)
						(= local55 2)
						(= local56 3)
						(= local57 4)
					)
					(1
						(= local54 2)
						(= local55 3)
						(= local56 4)
						(= local57 0)
					)
					(2
						(= local54 3)
						(= local55 4)
						(= local56 0)
						(= local57 1)
					)
					(3
						(= local54 4)
						(= local55 0)
						(= local56 1)
						(= local57 2)
					)
					(4
						(= local54 0)
						(= local55 1)
						(= local56 2)
						(= local57 3)
					)
				)
				(switch local62
					(1
						(= local63 14)
						(= local61 2)
					)
					(2
						(= local63 15)
						(= local61 2)
					)
					(3
						(= local63 16)
					)
					(4
						(= local63 17)
					)
					(5
						(= local63 18)
					)
					(6
						(= local63 19)
						(= local61 2)
					)
					(7
						(= local63 20)
					)
				)
				(gMessager say: 2 0 local63 1 self)
			)
			(1
				1
				(cond
					((== local62 6)
						(switch local59
							(0
								(= temp0 0)
								(= temp1 20)
								(= temp2 40)
								(= temp3 60)
								(= temp4 100)
								(= local60 0)
							)
							(1
								(= temp0 40)
								(= temp1 60)
								(= temp2 80)
								(= temp3 100)
								(= temp4 0)
								(= local60 4)
							)
							(2
								(= temp0 60)
								(= temp1 80)
								(= temp2 100)
								(= temp3 0)
								(= temp4 20)
								(= local60 3)
							)
							(3
								(= temp0 80)
								(= temp1 100)
								(= temp2 0)
								(= temp3 20)
								(= temp4 40)
								(= local60 2)
							)
							(4
								(= temp0 100)
								(= temp1 0)
								(= temp2 20)
								(= temp3 40)
								(= temp4 60)
								(= local60 1)
							)
						)
					)
					((== local62 7)
						(switch local59
							(0
								(= temp0 0)
								(= temp1 20)
								(= temp2 40)
								(= temp3 60)
								(= temp4 80)
								(= local60 0)
							)
							(1
								(= temp0 20)
								(= temp1 40)
								(= temp2 60)
								(= temp3 80)
								(= temp4 0)
								(= local60 4)
							)
							(2
								(= temp0 40)
								(= temp1 60)
								(= temp2 80)
								(= temp3 0)
								(= temp4 20)
								(= local60 3)
							)
							(3
								(= temp0 60)
								(= temp1 80)
								(= temp2 0)
								(= temp3 20)
								(= temp4 40)
								(= local60 2)
							)
							(4
								(= temp0 80)
								(= temp1 0)
								(= temp2 20)
								(= temp3 40)
								(= temp4 60)
								(= local60 1)
							)
						)
					)
					(else
						(switch local59
							(0
								(= temp0 0)
								(= temp1 20)
								(= temp2 40)
								(= temp3 60)
								(= temp4 80)
								(= local60 0)
							)
							(1
								(= temp0 20)
								(= temp1 40)
								(= temp2 60)
								(= temp3 80)
								(= temp4 0)
								(= local60 4)
							)
							(2
								(= temp0 40)
								(= temp1 60)
								(= temp2 80)
								(= temp3 0)
								(= temp4 20)
								(= local60 3)
							)
							(3
								(= temp0 60)
								(= temp1 80)
								(= temp2 0)
								(= temp3 20)
								(= temp4 40)
								(= local60 2)
							)
							(4
								(= temp0 80)
								(= temp1 0)
								(= temp2 20)
								(= temp3 40)
								(= temp4 60)
								(= local60 1)
							)
						)
					)
				)
				(switch
					(Print
						addButton: 0 2 0 local63 2 0 temp0 29
						addButton: 1 2 0 local63 3 0 temp1 29
						addButton: 2 2 0 local63 4 0 temp2 29
						addButton: 3 2 0 local63 5 0 temp3 29
						addButton: 4 2 0 local63 6 0 temp4 29
						width: 170
						first: local60
						init:
					)
					(0
						(self changeState: 2)
					)
					(1
						(self changeState: 4)
					)
					(2
						(self changeState: 6)
					)
					(3
						(self changeState: 8)
					)
					(4
						(self changeState: 10)
					)
				)
			)
			(2
				2
				(gMessager say: 2 0 local63 7 self)
			)
			(3
				3
				(client setScript: letHimIn)
				(self dispose:)
			)
			(4
				4
				(gMessager say: 2 0 local63 8 self)
			)
			(5
				5
				(if (== local61 2)
					(client setScript: letHimIn)
				else
					(client setScript: teleportOut)
				)
				(self dispose:)
			)
			(6
				6
				(gMessager say: 2 0 local63 9 self)
			)
			(7
				7
				(client setScript: teleportOut)
				(self dispose:)
			)
			(8
				8
				(gMessager say: 2 0 local63 10 self)
			)
			(9
				9
				(client setScript: teleportOut)
				(self dispose:)
			)
			(10
				10
				(gMessager say: 2 0 local63 11 self)
			)
			(11
				11
				(client setScript: teleportOut)
				(self dispose:)
			)
		)
	)
)

(instance letHimIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 2 0 24 1 self) ; "THE WIZARD WILL SEE YOU NOW."
			)
			(1
				(gMessager say: 2 0 2 1 self) ; "GO DIRECTLY UP TO THE TOWER. DO NOT DALLY!"
			)
			(2
				(gargoyle cycleSpeed: 12 cel: 0 setCycle: End self)
			)
			(3
				(gargoyle cycleSpeed: 6 setCycle: Beg self)
			)
			(4
				(gargoyle cycleSpeed: 6 cel: 0 setCycle: End)
				(= local44 1)
				(doorOpenSound play:)
				(theDoor cycleSpeed: (* gHowFast 6) setCycle: End self)
			)
			(5
				(theDoor ignoreActors: stopUpd:)
				(HandsOn)
				(User canControl: 1 canInput: 1)
				(NormalEgo 3)
				(gargoyle setCycle: End self)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance teleportOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 30)
			)
			(1
				(switch (Random 0 6)
					(0
						(gMessager say: 2 0 22 1) ; "You blew it, bub."
						(= ticks 360)
					)
					(1
						(gMessager say: 2 0 22 2) ; "Sayonara, Sucker."
						(= ticks 360)
					)
					(2
						(gMessager say: 2 0 22 3) ; "Wrong way, Jose!"
						(= ticks 360)
					)
					(3
						(gMessager say: 2 0 22 4) ; "Hasta la vista, baby."
						(= ticks 360)
					)
					(4
						(gMessager say: 2 0 22 5) ; "Have a nice trip, see you in the fall!"
						(= ticks 420)
					)
					(5
						(gMessager say: 2 0 22 6) ; "Gotcha!"
						(= ticks 300)
					)
					(6
						(gMessager say: 2 0 22 7) ; "Scat, Brat."
						(= ticks 300)
					)
				)
			)
			(2
				(gargoyle setCycle: End self)
			)
			(3
				(gargoyle cycleSpeed: 1 setCycle: Beg self)
			)
			(4
				(portFrame init: stopUpd:)
				(laffer init: setCycle: Fwd)
				(gargoyle setCycle: Fwd)
				(Magic
					ignoreActors:
					setPri: (+ (gEgo priority:) 1)
					cycleSpeed: 2
					posn:
						(if
							(and
								(== (gEgo view:) 515)
								(== (gEgo loop:) 0)
							)
							(+ (gEgo x:) 5)
						else
							(gEgo x:)
						)
						(gEgo y:)
					init:
					setCycle: CT 5 1 self
				)
			)
			(5
				(teleportSound play:)
				(gEgo hide:)
				(Magic setCycle: CT 3 -1 self)
			)
			(6
				(Magic setCycle: End)
				(= ticks (Random 90 180))
			)
			(7
				(SetFlag 142)
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 400 -32761)
				(self cue:)
			)
			(8
				(gCurRoom newRoom: 28)
			)
		)
	)
)

(instance teleportSound of Sound
	(properties
		number 28
	)
)

(instance hitGround of Sound
	(properties
		number 66
	)
)

(instance doorOpenSound of Sound
	(properties
		number 89
	)
)

