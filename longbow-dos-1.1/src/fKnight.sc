;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Main)
(use n013)
(use Wat)
(use verseScript)
(use rhEgo)
(use RTEyeCycle)
(use PChase)
(use PolyPath)
(use Polygon)
(use MoveFwd)
(use StopWalk)
(use Rev)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	fKnight 0
	fKnightEncounter 1
	horseBody 2
	horseHead 3
	theSword 4
)

(local
	[local0 9] = [60 0 2 4 19 30 23 20 29]
	[local9 9] = [-1 {The Horse} 32 0 0 0 0 0 0]
	[local18 5] = [0 10 12 5 6]
	[local23 5] = [0 5 4 8 2]
	local28
	local29 = 1
	local30
	local31
	local32
	local33
	local34
	local35
	local36
	local37
	local38
	local39
	local40
	[local41 6] = [1010 0 1 1 1 0]
	[local47 14] = [1010 7 2 1 1 2 1 2 1 3 4 1 3 0]
	[local61 6] = [1010 18 2 1 2 0]
	[local67 6] = [1010 21 2 1 2 0]
	[local73 6] = [1010 24 2 1 1 0]
	[local79 4] = [1010 27 1 0]
	[local83 5] = [1010 28 1 2 0]
	[local88 4] = [1010 30 1 0]
	[local92 5] = [1010 31 1 1 0]
	[local97 6] = [1010 44 1 2 1 0]
	[local103 5] = [1010 47 2 1 0]
	[local108 6] = [1010 49 2 1 2 0]
	[local114 9] = [1010 52 1 2 1 2 1 2 0]
	[local123 8] = [1010 58 1 0 1010 59 1 0]
	[local131 4] = [1010 60 1 0]
	[local135 4] = [1010 61 1 0]
	[local139 4] = [1010 62 1 0]
	[local143 4] = [1010 64 1 0]
	[local147 5] = [1010 65 1 1 0]
	[local152 9] = [1010 67 1 2 1 2 2 1 0]
	[local161 6] = [1010 73 1 2 1 0]
	[local167 5] = [1010 76 1 1 0]
	[local172 4] = [1010 41 1 0]
	[local176 4] = [1010 42 1 0]
	[local180 4] = [1010 79 1 0]
	[local184 4] = [1010 80 1 0]
	[local188 13] = [1010 82 2 1 1 2 1 2 1 2 1 1 0]
	[local201 4] = [1010 92 1 0]
	[local205 4] = [1010 93 1 0]
	[local209 4] = [1010 94 1 0]
	[local213 6] = [1010 95 2 1 2 0]
	[local219 6] = [1010 98 2 1 2 0]
	[local225 6] = [1010 101 2 1 2 0]
	[local231 6] = [1010 104 2 1 2 0]
	[local237 4] = [1010 107 1 0]
)

(instance fKnight of Actor
	(properties
		x 181
		y 105
		z 33
		view 121
		signal 16384
	)

	(method (init)
		(if (IsFlag 27)
			(= local30 1)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 167 77 203 77 206 74 244 74 245 84 228 94 214 99 203 103 150 103
						yourself:
					)
			)
		else
			(gSFX number: 126 loop: -1 play:)
			(= local28 (gGame egoMoveSpeed:))
			(horseHead init:)
			(horseBody init:)
			(if (and (IsFlag 38) (not (IsFlag 27)))
				(bigWill init: stopUpd:)
				(bigJohn init: stopUpd:)
				(bigTuck init: stopUpd:)
			)
		)
		(super init:)
	)

	(method (doit)
		(if (IsFlag 110)
			(ClearFlag 110)
			(if (not local30)
				(gCurRoom setScript: handCodeDelay)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb invItem)
		(cond
			((and local30 (!= theVerb 3)) ; Do
				(Say 1010 4) ; "He's thoroughly dead."
			)
			((and local39 (not (OneOf theVerb 10 2))) 0) ; Longbow, Look
			(else
				(switch theVerb
					(2 ; Look
						(Say 1010 3) ; "He's heavily armed and watches me suspiciously."
					)
					(5 ; Talk
						(if local36
							(gCurRoom setScript: yakItUp2)
						else
							(= local36 1)
							(gCurRoom setScript: yakItUp1)
						)
					)
					(10 ; Longbow
						(gCurRoom setScript: killHim)
					)
					(4 ; Inventory
						(switch invItem
							(1 ; horn
								(Converse 1 @local205 @local0 3) ; "I don't want your thieves' horn."
							)
							(0 ; bucks
								(if (= local31 (gMoney doit:))
									(Converse 1 @local209 @local0 3) ; "I can use the money, outlaw. I gambled all mine away last night."
								)
							)
							(2 ; halfHeart
								(Converse @local213 1 @local0) ; "Trying to bribe me, outlaw? For what, a pardon from the Queen?"
								(gEgo put: 2 fKnight) ; halfHeart
								(|= local32 $0001)
							)
							(14 ; amethyst
								(Converse @local219 1 @local0) ; "I hear an amethyst can keep a man from getting drunk."
								(gEgo put: 14 fKnight) ; amethyst
								(|= local32 $0002)
							)
							(10 ; fireRing
								(Converse @local225 1 @local0) ; "Nice bit of stone."
								(gEgo put: 10 fKnight) ; fireRing
								(if (== global115 2)
									(= global115 0)
								)
								(|= local32 $0004)
							)
							(18 ; waterRing
								(Converse @local231 1 @local0) ; "How'd you come by this?"
								(gEgo put: 18 fKnight) ; waterRing
								(if (== global115 1)
									(= global115 0)
								)
								(|= local32 $0008)
							)
							(else
								(Converse 1 @local237 @local0 3) ; "What do I want with that? If you have business with me, get on with it."
							)
						)
					)
					(3 ; Do
						(cond
							(local30
								(if local37
									(Say 1010 38) ; "His armour wouldn't fit me, even if I thought it might make a useful disguise."
								else
									(= local37 1)
									(gCurRoom setScript: searchHim)
								)
							)
							(local34
								(= local35 1)
								(gCurRoom setScript: robinDeath)
							)
							(else
								(= local34 1)
								(gCurRoom setScript: doWarning)
							)
						)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
		)
	)

	(method (dispose)
		(if (or local31 local32)
			(gPennies put:)
			(gHapennies put:)
			(gFarthings put:)
			(if (& local32 $0001)
				((gInventory at: 2) owner: 140) ; halfHeart
			)
			(if (& local32 $0002)
				((gInventory at: 14) owner: 140) ; amethyst
			)
			(if (& local32 $0004)
				((gInventory at: 10) owner: 140) ; fireRing
			)
			(if (& local32 $0008)
				((gInventory at: 18) owner: 140) ; waterRing
			)
		)
		(gSFX fade: 0 30 8 1)
		(gCurRoom notify:)
		(self setCycle: 0 setMotion: 0)
		(horseSound stop: dispose:)
		(if local40
			((ScriptID 19) dispose:) ; John
		)
		(horseHead dispose: delete:)
		(horseBody dispose: delete:)
		(theSword dispose: delete:)
		(super dispose:)
		(self delete:)
		(DisposeScript 10)
	)
)

(instance horseBody of Prop
	(properties
		x 184
		y 100
		view 121
		cel 2
		signal 16385
		cycleSpeed 18
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1010 5) ; "The knight has a skittish, but well-trained war-horse."
			)
			(3 ; Do
				(if local30
					(if local40
						(Converse 1 @local172 13 3) ; "I'll see to the horse, not to worry."
					else
						(Say 1010 40) ; "Little John can deal with the horse. He has a way with the beasts."
					)
				else
					(Converse 1 @local176 @local0 3) ; "Keep your hands off my horse, knave."
				)
			)
			(5 ; Talk
				(if local39
					0
				else
					(self setScript: nayTalk)
				)
			)
			(4 ; Inventory
				(Say 1010 43) ; "It's of no use to a horse."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance horseHead of Prop
	(properties
		x 174
		y 110
		z 42
		view 121
		cel 1
		signal 16385
		cycleSpeed 18
		detailLevel 2
	)

	(method (doit)
		(if
			(and
				(== cel 3)
				(not (Random 0 3))
				(not (horseSound handle:))
				(& signal $0002)
			)
			(horseSound play:)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1010 5) ; "The knight has a skittish, but well-trained war-horse."
			)
			(3 ; Do
				(if local30
					(if local40
						(Converse 1 @local172 13 3) ; "I'll see to the horse, not to worry."
					else
						(Say 1010 40) ; "Little John can deal with the horse. He has a way with the beasts."
					)
				else
					(Converse 1 @local176 @local0 3) ; "Keep your hands off my horse, knave."
				)
			)
			(5 ; Talk
				(if local39
					0
				else
					(self setScript: nayTalk)
				)
			)
			(10 ; Longbow
				(if local30
					(super doVerb: theVerb &rest)
				else
					(fKnight doVerb: theVerb invItem &rest)
				)
			)
			(4 ; Inventory
				(Say 1010 43) ; "It's of no use to a horse."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theSword of View
	(properties
		x 183
		y 28
		view 123
		signal 24576
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1010 6) ; "There lies the false Knight's sword."
			)
			(3 ; Do
				(Say 1010 39) ; "I've no desire to carry a traitor's sword. It may prove as false as he."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance nayTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Converse 1 @local131 1 2 self) ; "Horse, do you speak?"
			)
			(1
				(horseSound play:)
				(Converse 1 @local135 @local9 0 self) ; "Nay."
			)
			(2
				(Converse 1 @local139 1 2 self) ; "I thought not."
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fKnightEncounter of Script
	(properties)

	(method (dispose)
		(gTheIconBar disable: 5)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (IsFlag 38) (not (IsFlag 27)) (not (IsFlag 136)))
					(self setScript: willSez self)
				else
					(self cue:)
				)
			)
			(1
				(HandsOff)
				(Wat setScript: 0 section: 4)
				(if (not (gCast contains: fKnight))
					(fKnight init:)
				)
				(gEgo
					setLoop: 0
					heading: 90
					cel: 0
					posn: 149 93
					ignoreActors: 1
					init:
					actions: egoActions
					setCycle: Walk
					stopUpd:
				)
				(gEgoHead stopUpd:)
				(= ticks 30)
			)
			(2
				(Converse 4 @local47 1 2 @local0 3 13 2 14 3 self) ; "So you're the leader of this rabble. What's the meaning of this?"
			)
			(3
				(= ticks 60)
			)
			(4
				(bigJohn cel: 1)
				(bigWill cel: 1)
				(bigTuck cel: 1)
				(= ticks 18)
			)
			(5
				(bigJohn
					setLoop: 4
					setCycle: Walk
					setMotion: MoveTo -20 (bigJohn y:) self
				)
				(bigTuck
					setLoop: 5
					setCycle: Walk
					ignoreHorizon: 1
					setMotion: MoveTo (bigTuck x:) -2 self
				)
				(bigWill
					setLoop: 6
					setCycle: Walk
					setMotion: MoveTo 340 (bigWill y:) self
				)
			)
			(6)
			(7)
			(8
				(bigWill dispose:)
				(bigJohn dispose:)
				(bigTuck dispose:)
				(Converse 2 @local61 1 2 @local0 3 self) ; "Well, explain yourself or step aside. I've no time to waste on a common outlaw."
			)
			(9
				(horseHead view: 125 loop: 2 setScript: (horseMove new:))
				(horseBody view: 125 loop: 3 setScript: (horseMove new:))
				(fKnight view: 125 startUpd:)
				(HandsOn)
				(gTheIconBar disable: 5 0)
				(User canControl: 0)
				(SetFlag 27)
				(self dispose:)
			)
		)
	)
)

(instance willSez of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo (ScriptID 20)) ; Will
				(Face (ScriptID 20) gEgo) ; Will
				(= ticks 48)
			)
			(1
				(Converse 1 @local41 14 0 self) ; "Robin, I've been looking for you."
			)
			(2
				(= ticks 60)
			)
			(3
				(gEgo dispose:)
				((ScriptID 20) dispose:) ; Will
				(gTheIconBar disable:)
				(gCurRoom drawPic: 803 -32761)
				(= ticks 60)
			)
			(4
				(gCurRoom drawPic: 120 -32762)
				(gTheIconBar enable:)
				(self dispose:)
			)
		)
	)
)

(instance horseMove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks
					(if local39
						12
					else
						(Random 30 240)
					)
				)
			)
			(1
				(client
					setCel: (Random 0 (client lastCel:))
					setCycle: CT 0 (if (Random 0 1) 1 else -1) self
					checkDetail:
				)
			)
			(2
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance handCodeDelay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(if (not local33)
					(= local33 1)
					(Converse 2 @local67 1 2 @local0 3 self) ; "What were you doing with your hand?"
				else
					(= register 1)
					(Converse 2 @local73 2 2 @local0 3 self) ; "What's the meaning of that? Answer me!"
				)
			)
			(2
				(if register
					(= local39 1)
					(if (not (HaveMouse))
						(gGame setCursor: gTheCursor 1 183 41)
					)
					(client setScript: liftSword)
				else
					(if (IsFlag 67)
						(SetScore 50)
					)
					(self dispose:)
				)
			)
		)
	)
)

(instance liftSword of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOn)
				(gTheIconBar disable: 5 0 6 7)
				(SetIcon 4)
				(gGame setSpeed: global141)
				(fKnight setCycle: CT 3 1 self)
			)
			(1
				(= ticks 120)
			)
			(2
				(Converse 1 @local79 @local0 3 self) ; "Here's your answer!"
			)
			(3
				(= ticks 120)
			)
			(4
				(HandsOff)
				(robinDeath start: 3)
				(client setScript: robinDeath)
			)
		)
	)
)

(instance doWarning of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(gGame setSpeed: global141)
				(gEgo setMotion: MoveTo (+ (gEgo x:) 6) (gEgo y:) self)
			)
			(1
				(= ticks 18)
			)
			(2
				(Converse 2 @local83 1 2 @local0 3 self) ; "Come down from your horse and--"
			)
			(3
				(gEgo setCycle: Rev setMotion: MoveFwd -6 self)
			)
			(4
				(gEgo setCycle: Walk)
				(HandsOn)
				(gTheIconBar disable: 5 0)
				(self dispose:)
			)
		)
	)
)

(instance robinDeath of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo (+ (gEgo x:) 6) (gEgo y:) self)
			)
			(1
				(= ticks 18)
			)
			(2
				(Converse 1 @local88 1 2 self) ; "Come down from your horse or I'll--."
			)
			(3
				(fKnight
					cycleSpeed: 3
					setCycle: CT (- (fKnight lastCel:) 1) 1 self
				)
				(swordSound play:)
			)
			(4
				(gGame setSpeed: global141)
				(fKnight setCycle: End)
				(gEgo
					view: 792
					setLoop: 0
					setCel: 3
					cycleSpeed: 12
					setCycle: End self
				)
				(swordSound number: 907 play:)
			)
			(5
				(fKnight cycleSpeed: 6 setCycle: Beg self)
			)
			(6
				(swordSound dispose:)
				(if local35
					(Converse 1 @local92 @local0 3 self) ; "So much for empty threats."
				else
					(Converse 1 @local143 @local0 3 self) ; "Prince John will reward me well for this day's work!"
				)
			)
			(7
				(= gDeathNum 3)
				(horseHead setScript: 0)
				(horseBody setScript: 0)
				(gCurRoom newRoom: 170) ; robinDeath
			)
		)
	)
)

(instance killHim of Script
	(properties)

	(method (dispose)
		(shootSound dispose:)
		(super dispose: &rest)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(gGame setSpeed: global141)
				(gEgo view: 123 setLoop: 1 setCel: 0 setCycle: End self)
				(fKnight cycleSpeed: 12 setCycle: CT 3 1)
			)
			(1
				(shootSound play:)
				(fKnight
					setLoop: 1
					setCel: 0
					posn: 181 72 0
					setPri: 13
					cycleSpeed: global141
				)
				(= ticks (* global141 2))
			)
			(2
				(if local29
					(gSFX stop:)
					(shootSound number: 907 loop: 1 play:)
					(= local29 0)
				)
				(= temp0 (fKnight cel:))
				(fKnight
					setCel: (+ (fKnight cel:) 1)
					x: (+ (fKnight x:) [local18 temp0])
					y: (+ (fKnight y:) [local23 temp0])
				)
				(switch temp0
					(1
						(theSword init:)
					)
					(2
						(theSword setCel: 1 posn: 164 22)
					)
					(3
						(theSword setCel: 2 posn: 145 24)
					)
					(4
						(theSword posn: 125 55 stopUpd:)
					)
				)
				(= ticks (* global141 2))
			)
			(3
				(if (== (fKnight cel:) (fKnight lastCel:))
					(gEgo
						setLoop: 2
						setCel: 0
						cycleSpeed: 18
						setCycle: End self
					)
					(fKnight setPri: -1 stopUpd:)
					(horseHead
						y: (- (horseHead y:) 10)
						z: (- (horseHead z:) 10)
					)
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 167 77 203 77 206 74 244 74 245 84 228 94 214 99 203 103 150 103
								yourself:
							)
					)
					(= local30 1)
					(= local39 0)
				else
					(-= state 2)
					(self cue:)
				)
			)
			(4
				(= ticks 24)
			)
			(5
				(gSFX number: 128 loop: -1 play:)
				(gEgo setLoop: 1 setCel: 0 x: (+ (gEgo x:) 3))
				(= ticks 12)
			)
			(6
				(NormalEgo 0)
				(= ticks 12)
			)
			(7
				(Say 1010 63 self) ; "Every instinct I have told me this Knight was no Queen's man. But now I must prove that I was right."
			)
			(8
				(HandsOn)
				(SetScore 50)
				(gGame setSpeed: local28)
				(self dispose:)
			)
		)
	)
)

(instance searchHim of TScript
	(properties)

	(method (dispose)
		(super dispose: &rest)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 243 94 self)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(gEgo view: 7 setLoop: 0 setCel: 0 setCycle: CT 4 1 self)
			)
			(3
				(= ticks 24)
			)
			(4
				(gEgo setCel: (+ (gEgo cel:) 1))
				(= ticks 24)
			)
			(5
				(gEgo setCel: (- (gEgo cel:) 1))
				(= ticks 24)
			)
			(6
				(SetScore 50)
				(gEgo get: 9 setCycle: End self) ; message
			)
			(7
				(Say 1010 33 self) ; "He carried this letter, sealed with the imprint of the Prior's ring."
			)
			(8
				(Say 1010 34 self) ; "The letter reads:"
			)
			(9
				(NormalEgo 7)
				(Say 1010 35 self) ; "I have advised the Prince that we have succeeded in our mission. The cub is taken. The Lion is caged."
			)
			(10
				(Say 1010 36 self) ; "It's signed by the Prior of the Monastery and addressed to the Sheriff of Nottingham."
				(gEgo get: 9) ; message
			)
			(11
				(if (or local31 local32)
					(Say 1010 37 self) ; "Aside from this, I found only what I foolishly gave him before."
					(gPennies put:)
					(gHapennies put:)
					(gFarthings put:)
					(if (& local32 $0001)
						(gEgo get: 2) ; halfHeart
					)
					(if (& local32 $0002)
						(gEgo get: 14) ; amethyst
					)
					(if (& local32 $0004)
						(gEgo get: 10) ; fireRing
					)
					(if (& local32 $0008)
						(gEgo get: 18) ; waterRing
					)
					(= local32 (= local31 0))
				else
					(self cue:)
				)
			)
			(12
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance yakItUp1 of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(Converse 2 @local97 1 2 @local0 3 self) ; "Do you serve the Queen?"
			)
			(1
				(fKnight setCycle: CT 2 1 self)
			)
			(2
				(= ticks 30)
			)
			(3
				(Converse 2 @local103 1 2 @local0 3 self) ; "You dare to threaten me?"
			)
			(4
				(fKnight setCycle: Beg self)
			)
			(5
				(= ticks 30)
			)
			(6
				(Converse 2 @local108 1 2 @local0 3 self) ; "You should have said so at once. Turn everything over to me."
			)
			(7
				(HandsOn)
				(gTheIconBar disable: 5 0)
				(self dispose:)
			)
		)
	)
)

(instance yakItUp2 of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(Converse 2 @local114 1 2 @local0 3 self) ; "Have you no token, no message to prove you're the Queen's Knight?"
			)
			(1
				(Converse 1 @local123 2 2 self) ; "You false Knight! What have you done with the true messenger?!"
			)
			(2
				(= local39 1)
				(if (not (HaveMouse))
					(gGame setCursor: gTheCursor 1 183 41)
				)
				(client setScript: liftSword)
			)
		)
	)
)

(instance hereComesJohn of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (< 95 (gEgo y:) 145) (> (gEgo x:) 250))
					(gEgo setMotion: PolyPath 245 (gEgo y:))
				)
				((ScriptID 19) ; John
					actions: johnActions
					posn: 330 120
					init:
					setCycle: StopWalk 152
					setMotion: MoveTo 270 120 self
				)
			)
			(1
				(Face gEgo (ScriptID 19) self) ; John
			)
			(2
				(Converse 1 @local147 13 3 self) ; "I stayed within range of your horn, Master. What's happened here?"
			)
			(3
				(if (gEgo has: 9) ; message
					(Converse @local161 1 13 self) ; "He wasn't the Queen's man. He carried a written message to the Sheriff from the Prior, proof of their conspiracy with Prince John."
				else
					(Converse @local152 1 13 self) ; "I'm sure the man was false."
				)
			)
			(4
				(HandsOn)
				(= local40 1)
				(self dispose:)
			)
		)
	)
)

(instance showLetter of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 19) setMotion: PChase gEgo 35 self) ; John
				(Face gEgo (ScriptID 19)) ; John
			)
			(1
				(Converse @local188 1 13 self) ; "I cannot read, as you know. What's it say?"
			)
			(2
				(SetScore 50)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance johnActions of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				1
				(Say 1010 78) ; "'Tis Little John."
			)
			(3 ; Do
				1
				(Converse 1 @local180 13 3) ; "I'm here. What more do you want?"
			)
			(5 ; Talk
				1
				(Converse 1 @local184 13 3) ; "Leave this mess with me. I'll get him out of the road and see to the horse."
			)
			(10 ; Longbow
				1
				(Say 1010 81) ; "I'd be a fool to threaten my most trusted friend."
			)
			(4 ; Inventory
				(if (== invItem 9) ; message
					1
					(if local38
						(Converse 1 @local201 13 3) ; "It'll be safer in your keeping, Master."
					else
						(= local38 1)
						(gCurRoom setScript: showLetter)
					)
				)
			)
		)
	)
)

(instance localHorn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cond
					(local40
						(self setScript: (ScriptID 5 1) self) ; blowinIt
					)
					(local30
						(gEgo setMotion: PolyPath 160 140 self)
					)
					(else
						(gEgo
							view: 10
							setCel: 0
							setLoop: 0
							setCycle: End self
						)
					)
				)
			)
			(1
				(cond
					(local40
						(Converse 1 @local167 13 3 self) ; "The other men have spread out and may not hear your horn, Robin."
					)
					(local30
						(self setScript: (ScriptID 5 1) self) ; blowinIt
					)
					(else
						(robinDeath start: 3)
						(gCurRoom setScript: robinDeath)
						(self dispose:)
					)
				)
			)
			(2
				(if (and local30 (not local40))
					(gCurRoom setScript: hereComesJohn)
					(gEgo setHeading: 90)
					(self dispose:)
				else
					(HandsOn)
					(self dispose:)
				)
			)
		)
	)
)

(instance egoActions of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(return
			(cond
				(local39
					(super doVerb: theVerb &rest)
				)
				((and (== theVerb 4) (== invItem 1)) ; Inventory, horn
					(gEgo setScript: localHorn)
					1
				)
			)
		)
	)
)

(instance horseSound of Sound
	(properties
		flags 1
		number 913
	)
)

(instance shootSound of Sound
	(properties
		flags 1
		number 906
	)
)

(instance swordSound of Sound
	(properties
		flags 1
		number 934
	)
)

(instance bigJohn of Actor
	(properties
		x 115
		y 103
		view 121
		loop 1
	)
)

(instance bigTuck of Actor
	(properties
		x 230
		y 73
		view 121
		loop 2
	)
)

(instance bigWill of Actor
	(properties
		x 281
		y 116
		view 121
		loop 3
	)
)

