;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use dartScript)
(use TargActor)
(use n814)
(use Print)
(use Polygon)
(use Feature)
(use LoadMany)
(use Window)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm15 0
	proc15_1 1
	chest 2
	kobKey 3
	kobDazzle 4
	chestBlows 5
	proc15_6 6
	proc15_7 7
	egoFighting 8
)

(local
	[local0 3] = [299 306 317]
	[local3 3] = [71 92 125]
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	[local15 5] = [-24 30 -21 27 3]
	[local20 5] = [-11 -11 -11 -11 -23]
	[local25 11] = [52 88 35 258 122 196 303 316 140 270 211]
	[local36 11] = [12 113 96 146 -2 87 63 92 160 5 36]
	local47
	local48
	local49
	local50
	local51
	local52
	local53
	local54
	local55
	local56
	local57
)

(procedure (localproc_0)
	(SetFlag 175)
	(SolvePuzzle 650 5)
	(gMessager say: 9 0 25) ; "You add ten gold and sixty silver coins to your money pouch."
	(if (IsObject treasure)
		(treasure dispose:)
	)
	(&= global260 $dfff)
	(= local57 2)
	(NormalEgo)
	(if (== gEgoGait 2) ; sneaking
		(EgoGait 2) ; sneaking
	else
		(EgoGait 0) ; walking
	)
	(gEgo illegalBits: global260 setScript: getItCued)
)

(procedure (proc15_1 param1)
	(if (and param1 (not (IsFlag 283)))
		(HandsOn)
	)
	(if global268
		(User canControl: 0)
		(if (gEgo has: 2) ; sword
			(gEgo view: 501 setLoop: global286)
		else
			(gEgo view: 512 setLoop: (* global286 5))
		)
		(gEgo setCel: 0 illegalBits: 0 cycleSpeed: 6)
	else
		(NormalEgo)
		(gEgo illegalBits: global260)
	)
)

(procedure (localproc_1 &tmp temp0 temp1)
	(if
		(!=
			(= temp1
				(cond
					(
						(<
							(= temp0
								(GetAngle
									(kobold x:)
									(kobold y:)
									(gEgo x:)
									(gEgo y:)
								)
							)
							110
						)
						1
					)
					((< temp0 160) 3)
					((> temp0 250) 0)
					((> temp0 220) 2)
					(else 4)
				)
			)
			(kobold loop:)
		)
		(kobold setLoop: temp1)
	)
)

(procedure (localproc_2 param1 param2 param3)
	(if (CastSpell param1)
		(SetFlag 166)
		(proc15_6)
		(gEgo setScript: (ScriptID param2 param3))
	)
)

(procedure (localproc_3 param1 param2 param3)
	(cond
		((IsFlag 153)
			(gMessager say: 9 0 18) ; "You don't have time for that."
		)
		((CastSpell param1)
			(gEgo setScript: (ScriptID param2 param3))
		)
	)
)

(procedure (proc15_6)
	(if
		(and
			(not (IsFlag 153))
			(not (IsFlag 150))
			(!= (kobold script:) kobWakeUp)
		)
		(kobold setScript: kobWakeUp)
		(return 1)
	else
		(return 0)
	)
)

(procedure (proc15_7 param1)
	(if (and (not (TakeDamage param1)) (not local56))
		(= local56 1)
		(= local50 0)
		(gEgo setScript: egoDies)
	)
)

(class KScript of Script
	(properties)

	(method (cue)
		(if client
			(super cue:)
		)
	)
)

(class ballScript of KScript
	(properties)

	(method (doit)
		(cond
			((IsFlag 150)
				(client dispose:)
			)
			((and (< state 2) (not (client inRect: 10 30 310 200)))
				(= register 0)
				(self changeState: 2)
			)
			(else
				(super doit:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ballSound number: 2034 play:)
				(if
					(>=
						(-
							(- 100 (/ [gEgoStats 2] 2)) ; agility
							(/ (gEgo distanceTo: kobold) 5)
						)
						(Random100)
					)
					(client setMotion: MoveTo (gEgo x:) (gEgo y:) self)
				else
					(= register (Random 0 2))
					(client
						setMotion:
							MoveTo
							[local25 register]
							[local36 register]
							self
					)
				)
			)
			(1
				(cond
					((< (gEgo distanceTo: client) 20)
						(= register 1)
						(self cue:)
					)
					((>= (+= register (Random 1 4)) 11)
						(= register 0)
						(self cue:)
					)
					(else
						(= state 0)
						(client
							setMotion:
								MoveTo
								[local25 register]
								[local36 register]
								self
						)
					)
				)
			)
			(2
				(ballSound number: 2045 play:)
				(client
					setLoop: (if register 7 else 6)
					cel: 0
					setMotion: 0
					setCycle: End self
				)
				(if register
					(proc15_7 (if (gEgo has: 5) 15 else 20)) ; shield
				)
			)
			(3
				(client dispose:)
			)
		)
	)
)

(instance rm15 of Rm
	(properties
		noun 9
		picture 15
		style 8
		west 14
	)

	(method (dispose)
		(SetFlag 5)
		(ClearFlag 281)
		(ClearFlag 216)
		(= global425 0)
		(DisposeScript 111)
		(super dispose:)
	)

	(method (init &tmp [temp0 50])
		(= local55 0)
		(= global425 (| (|= global425 $0008) $0002))
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 57 99 56 111 62 99 96 91 102 5 102 6 162 68 162 67 147 107 148 115 148 119 152 136 165 185 169 309 169 313 89 240 89 216 77 184 77 147 68 144 63 148 57 78 39 81 32 67 29 0 29 0 56
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 261 98 279 114 260 136 208 136 182 123 184 102 202 99
					yourself:
				)
		)
		(Load rsSCRIPT 111)
		(= global268 (= global267 0))
		(if [gEgoStats 12] ; magic
			(Load rsSOUND 2033)
			(LoadMany rsVIEW 520 521 522 532)
		)
		(= local50 0)
		(if (IsFlag 147)
			(= local49 1)
		else
			(= local49 0)
		)
		(if (not (IsFlag 150))
			(LoadMany rsSOUND 2045 2034)
			(LoadMany rsVIEW 513 175 176 178 502 510)
			(if (gEgo has: 2) ; sword
				(Load rsVIEW 501)
			else
				(LoadMany rsVIEW 512 524)
			)
		)
		(if (not (IsFlag 151))
			(LoadMany rsSOUND 2062)
		)
		(SolvePuzzle 648 2)
		(SL enable:)
		(super init:)
		(gKeyDownHandler add: self)
		(gMouseDownHandler add: self)
		(EgoGait 0 0) ; walking
		(NormalEgo)
		(gEgo posn: 15 46 init:)
		(bigDrip init: setScript: dripper)
		(if (not (IsFlag 165))
			(toadstools init: setPri: 9 approachVerbs: 4) ; Do
			(toadstools1 init: setPri: 9 approachVerbs: 4) ; Do
			(toadstools2 init: setPri: 9 approachVerbs: 4) ; Do
		else
			(table init: setOnMeCheck: 1 8)
		)
		(stalagmites init: setOnMeCheck: 1 4)
		(sunLight init: setOnMeCheck: 1 16)
		(if (not (IsFlag 151))
			(chest init: approachVerbs: 17 stopUpd:) ; lockPick
			(ClearFlag 175)
			(|= global260 $2000)
		)
		(if (not (IsFlag 147))
			(if global286
				(kobKey posn: 52 84)
			)
			(kobKey ignoreActors: setPri: 5 init: approachVerbs: 4 stopUpd:) ; Do
			(if (not (IsFlag 150))
				(kobKey posn: 500 500)
			)
		)
		(if (not (IsFlag 150))
			(kobold init:)
			(= gKobold kobold)
		)
		(gEgo illegalBits: global260)
		(self setScript: kobEnter)
	)

	(method (doit)
		(if (and (< (gEgo x:) 35) (< (gEgo y:) 60) local55)
			(gEgo setMotion: 0)
			(gCurRoom newRoom: 14)
		)
		(super doit: &rest)
	)

	(method (cue)
		(cond
			((== local53 0)
				(if (not (IsFlag 147))
					(gMessager say: 7 1 17) ; "A large, brass key hangs from a thong around the creature's neck."
				)
			)
			((not (IsFlag 150))
				(gMessager say: 9 1 0 2) ; "On a rocky platform above the cave floor is a Kobold, one of the race of ugly, miserly creatures known for their skill in Magic."
			)
		)
	)

	(method (doVerb theVerb invItem &tmp temp0 temp1 temp2)
		(switch theVerb
			(81 ; flameDartSpell
				(= temp0 ((= temp2 (Event new:)) x:))
				(= temp1 (+ (temp2 y:) 25))
				(temp2 dispose:)
				(CastDart 0 0 temp0 temp1)
				(SetFlag 166)
			)
			(1 ; Look
				(= local53 1)
				(gMessager say: 9 1 0 1 gCurRoom) ; "This part of the cavern is spacious and multi-leveled. Phosphorescent fungus illuminates the cavern with an unearthly glow."
			)
			(50 ; detectMagicSpell
				(localproc_3 18 111 1)
				(return 1)
			)
			(51 ; openSpell
				(if (and (not (IsFlag 151)) (gCast contains: chest))
					(if (gEgo mover:)
						(gEgo setMotion: 0)
					)
					(localproc_3 17 111 2)
				else
					(gMessager say: 9 51 0) ; "There's nothing to open here."
				)
				(return 1)
			)
			(77 ; triggerSpell or Pickup Inventory
				(if (and (not (IsFlag 151)) (gCast contains: chest))
					(if (gEgo mover:)
						(gEgo setMotion: 0)
					)
					(localproc_3 19 111 3)
				else
					(gMessager say: 9 77 0) ; "There are no passive spells to trigger here."
				)
				(return 1)
			)
			(82 ; fetchSpell
				(if (and (not (IsFlag 150)) (gCast contains: kobKey))
					(localproc_3 24 111 5)
				else
					(gCurRoom setScript: unknown_15_1)
				)
				(return 1)
			)
			(78 ; dazzleSpell
				(if (not (IsFlag 150))
					(localproc_2 20 111 0)
				)
				(return 1)
			)
			(80 ; calmSpell
				(localproc_2 22 111 4)
				(return 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance unknown_15_1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gMessager say: 9 82 0 1 self) ; "You don't need to cast Fetch -- everything here is in easy reach."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance stalagmites of Feature
	(properties
		x 319
		y 189
		noun 10
		nsBottom 189
		nsRight 319
	)
)

(instance sunLight of Feature
	(properties
		x 319
		y 189
		noun 11
		nsBottom 189
		nsRight 319
	)
)

(instance fungus of Feature ; UNUSED
	(properties
		x 319
		y 189
		noun 5
		nsBottom 189
		nsRight 319
		onMeCheck 1028
	)
)

(instance table of Feature
	(properties
		x 319
		y 189
		noun 12
		nsBottom 189
		nsRight 319
	)
)

(instance kobKey of Actor
	(properties
		x 229
		y 85
		noun 6
		view 178
		loop 6
		cel 12
		illegalBits 0
	)

	(method (cue)
		(gEgo get: 16) ; brassKey
		(kobKey dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= local49 1)
				(SetFlag 147)
				(SolvePuzzle 649 7)
				(gMessager say: 6 0 0 1 self) ; "You retrieve the dropped key."
			)
			(1 ; Look
				(gMessager say: 6 1) ; "You see a large, brass key lying on the ground. A faint glow emanates from the key."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance chest of Prop
	(properties
		x 132
		y 173
		noun 2
		approachX 132
		approachY 160
		view 15
	)

	(method (doit)
		(if (and (< (gEgo distanceTo: chest) 15) (not (IsFlag 216)))
			(gMessager say: 2 0 0) ; "You just bumped into something on the floor. It feels like a large wooden chest, but you don't see anything there."
			(SetFlag 216)
			(self setScript: unknown_15_8)
		)
		(super doit:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(12 ; sword
				(cond
					((IsFlag 151)
						(gMessager say: 2 17 1) ; "You've already unlocked the chest."
					)
					((not (< (gEgo distanceTo: chest) 80))
						(gMessager say: 2 17 3) ; "You're not close enough."
					)
					(else
						(gEgo setScript: pickChest 0 1)
					)
				)
			)
			(16 ; dagger
				(cond
					((IsFlag 151)
						(gMessager say: 2 17 1) ; "You've already unlocked the chest."
					)
					((not (< (gEgo distanceTo: chest) 80))
						(gMessager say: 2 17 3) ; "You're not close enough."
					)
					(else
						(gEgo setScript: pickChest 0 1)
					)
				)
			)
			(4 ; Do
				(cond
					(
						(and
							(< (gEgo distanceTo: chest) 80)
							(gCast contains: treasure)
						)
						(localproc_0 treasure)
					)
					((IsFlag 175)
						(gMessager say: 2 4 2) ; "You've already taken the treasure."
					)
					((not (< (gEgo distanceTo: chest) 80))
						(gMessager say: 2 4 3) ; "You are too far away to get the Kobold's treasure."
					)
					((not (IsFlag 151))
						(gMessager say: 2 4 1) ; "You will have to open it first. The chest seems to be locked."
					)
					(else
						(localproc_0 0)
					)
				)
			)
			(17 ; lockPick
				(cond
					((or (not (IsFlag 216)) (not (gCast contains: chest)))
						(gMessager say: 2 17 5) ; "You don't see any locks here."
					)
					((IsFlag 151)
						(gMessager say: 2 17 1) ; "You've already unlocked the chest."
					)
					((not (< (gEgo distanceTo: chest) 80))
						(gMessager say: 2 17 3) ; "You're not close enough."
					)
					((not [gEgoStats 9]) ; pick locks
						(gMessager say: 2 17 4) ; "You have no skill at picking locks."
					)
					(else
						(gEgo setScript: pickChest 0 0)
					)
				)
			)
			(26 ; brassKey
				(if (and (IsFlag 216) (gCast contains: chest))
					(gMessager say: 2 26 0) ; "The key doesn't fit in the chest. It must be for a different lock."
				)
			)
			(1 ; Look
				(cond
					((gCast contains: treasure)
						(gMessager say: 2 1 8) ; "Where the chest was, you see numerous pieces of gold and silver."
					)
					((not (gCast contains: chest))
						(gMessager say: 2 1 7) ; "There is no sign of any other treasure in the cavern."
					)
					((not (IsFlag 216))
						(gMessager say: 2 1 5) ; "You don't *see* any treasure here."
					)
					((IsFlag 175)
						(gMessager say: 2 1 2) ; "The chest is now empty. Funny thing, that."
					)
					((IsFlag 151)
						(gMessager say: 2 1 1) ; "The chest is now empty. Funny thing, that."
					)
					(else
						(gMessager say: 2 1 6) ; "You will have to open the chest first. It seems to be locked."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance unknown_15_8 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(chest setCycle: End self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance chestBlows of KScript
	(properties)

	(method (dispose)
		(if (>= state 1)
			(local14 dispose:)
		)
		(= local13 0)
		(NormalEgo)
		(EgoGait)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client loop: 1 cel: 0 cycleSpeed: 12 setCycle: End self)
				((= local14 (Sound new:)) number: 2062 priority: 15 init: play:)
				(if register
					(= register 0)
					(gEgo setLoop: 2)
				else
					(gEgo setLoop: (if (mod (gEgo loop:) 2) 3 else 2))
				)
				(gEgo
					view: 513
					loop: (if (mod (gEgo loop:) 2) 3 else 2)
					cel: 0
					setCycle: End self
				)
			)
			(1
				(SetFlag 151)
				(proc15_6)
				(if (< (gEgo distanceTo: chest) 80)
					(= local13 1)
					(proc15_7 20)
				)
			)
			(2
				(= cycles 1)
				(if (< (gEgo distanceTo: chest) 80)
					(gMessager say: 9 0 3) ; "Wow! The chest must have been booby-trapped. You can really feel the damage from the blast."
					(= cycles 5)
				)
			)
			(3
				(treasure init:)
				(proc15_1 1)
				(Face gEgo treasure)
				(client dispose:)
			)
		)
	)
)

(instance treasure of View
	(properties
		x 132
		y 173
		approachX 128
		approachY 172
		view 15
		loop 1
		cel 6
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (< (gEgo distanceTo: chest) 80)
				(localproc_0 treasure)
				(NormalEgo)
			else
				(gMessager say: 2 4 3) ; "You are too far away to get the Kobold's treasure."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance toadstools1 of View
	(properties
		x 233
		y 111
		approachX 224
		approachY 131
		view 15
		loop 2
	)

	(method (doVerb theVerb)
		(toadstools doVerb: theVerb)
	)
)

(instance toadstools2 of View
	(properties
		x 242
		y 111
		approachX 224
		approachY 131
		view 15
		loop 2
	)

	(method (doVerb theVerb)
		(toadstools doVerb: theVerb)
	)
)

(instance toadstools of View
	(properties
		x 224
		y 111
		noun 13
		approachX 224
		approachY 131
		view 15
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 13 1) ; "Some sort of food (mushrooms?) sits in a pile on the stone table. It looks almost edible... to a Kobold."
			)
			(4 ; Do
				(cond
					(global268
						(gMessager say: 13 4 27) ; "No time for that now!"
					)
					((< (gEgo distanceTo: toadstools) 50)
						(gMessager say: 13 4 28) ; "You pick up the Kobold's mushrooms and put them in your pack."
						(SetFlag 165)
						(SetFlag 148)
						(toadstools hide: stopUpd:)
						(toadstools1 hide: stopUpd:)
						(toadstools2 hide: stopUpd:)
						(= local57 1)
						(gEgo setScript: getItCued)
					)
					(else
						(gMessager say: 2 17 3 1) ; "You're not close enough."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bigDrip of Prop
	(properties
		view 15
		loop 3
	)
)

(instance dripper of KScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (Random 0 2))
				(if (< register 2)
					(bigDrip
						posn: [local0 register] [local3 register]
						setCycle: End self
					)
				)
			)
			(1
				(if (< register 3)
					(bigDrip posn: 500 500 stopUpd:)
				)
				(= state -1)
				(= cycles (Random 20 40))
			)
		)
	)
)

(instance kobWin of SysWindow ; UNUSED
	(properties
		color 6
	)
)

(instance ballSound of Sound
	(properties
		number 2034
		priority 2
	)
)

(instance kobold of TargActor
	(properties
		x 261
		y 61
		noun 7
		view 175
		loop 6
		cycleSpeed 24
		illegalBits 0
		targDeltaY -15
	)

	(method (init)
		(ClearFlag 280)
		(ClearFlag 281)
		(ballSound init:)
		(if (IsFlag 147)
			(self setLoop: 5)
		)
		(if (gEgo knows: 23)
			(= global285 (+ 5 (/ [gEgoStats 23] 3))) ; flameDartSpell
		)
		(= global286 0)
		(self ignoreActors: posn: 256 68)
		(super init:)
		(= global280 global282)
		(if
			(or
				(not (IsFlag 5))
				(and (not gNight) (!= gDay global261))
			)
			(= global282 67)
		else
			(SetFlag 153)
			(self setScript: kobAwake)
		)
	)

	(method (doit &tmp [temp0 50])
		(if
			(and
				(not (IsFlag 153))
				(not (IsFlag 150))
				(< (gEgo distanceTo: self) 100)
				(or (!= gEgoGait 2) (< [gEgoStats 8] 20)) ; sneaking, stealth
			)
			(SetFlag 153)
			(Message msgGET 15 7 0 0 1 @temp0) ; "Your foot slips on the wet cavern floor and makes a scuffing noise."
			(Print addText: @temp0 init:)
			(EgoGait 0 0) ; walking
			(self setScript: kobWakeUp)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(= local53 0)
				(gMessager say: 7 1 0 0 gCurRoom) ; "The strange creature is dressed in ragged clothes. It has large, pale eyes. It must have spent its entire life in these caves!"
			)
			(2 ; Talk
				(cond
					((not (IsFlag 153))
						(proc15_6)
					)
					((not (IsFlag 150))
						(gMessager say: 7 57) ; "The Kobold seems more interested in frying you with Ball Lightning than in talking to you."
					)
				)
			)
			(4 ; Do
				(if (not local49)
					(cond
						((> (gEgo distanceTo: kobold) 40)
							(gMessager say: 7 4 14) ; "You can't reach the key from here."
						)
						((IsFlag 150)
							(gMessager say: 7 4 11) ; "You take the Kobold's glowing key."
							(= local49 1)
							(= local57 3)
							(gEgo setScript: getItCued)
							(SetFlag 147)
							(SolvePuzzle 649 7)
							(kobKey dispose:)
						)
						((IsFlag 153)
							(gMessager say: 7 4 15) ; "The Kobold won't let you near his key."
						)
						((TrySkill 8 35 0) ; stealth
							(gMessager say: 7 4 16) ; "VERY carefully, you remove the key from around the Kobold's neck."
							(= local49 1)
							(= local57 3)
							(self setLoop: 5)
							(gEgo setScript: getItCued)
							(SetFlag 147)
							(SolvePuzzle 649 7)
							(kobKey dispose:)
						)
						(else
							(gMessager say: 7 4 13) ; "Uh oh. You weren't stealthy enough. You have awoken the Kobold."
							(proc15_6)
						)
					)
				)
			)
			(16 ; dagger
				(cond
					(global268
						(gMessager say: 7 16 12) ; "That's what you're doing. Keep going!"
					)
					((IsFlag 150)
						(gMessager say: 7 16 11) ; "There are no monsters here to attack."
					)
					(else
						(proc15_6)
						(if (not local56)
							(pointBox setPri: 15 setLoop: 2 init: stopUpd:)
							(gCurRoom setScript: startFight)
						)
					)
				)
			)
			(12 ; sword
				(cond
					(global268
						(gMessager say: 7 12 12) ; "That's what you're doing. Keep going!"
					)
					((IsFlag 150)
						(gMessager say: 7 12 11) ; "There are no monsters here to attack."
					)
					(else
						(proc15_6)
						(if (not local56)
							(pointBox setPri: 15 setLoop: 2 init: stopUpd:)
							(gCurRoom setScript: startFight)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(ClearFlag 153)
		(ballSound dispose:)
		(super dispose:)
	)

	(method (getHurt param1)
		(-= global282 param1)
		(if (not (or (== script kobHurt) (== script kobDies)))
			(self setScript: kobHurt)
		)
	)
)

(instance kobDazzle of KScript
	(properties)

	(method (dispose)
		(= local7 (* register 5))
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SkillUsed 20 5) ; dazzleSpell
				(= register (/ (+ 5 [gEgoStats 20]) 10)) ; dazzleSpell
				(if (> register 6)
					(= register 6)
				)
				(client
					view: 179
					setCel: 0
					cycleSpeed: 18
					setCycle: CT 1 1 self
				)
			)
			(1
				(kobold setCycle: CT 4 1 self)
			)
			(2
				(= ticks 18)
			)
			(3
				(if (> (-- register) 0)
					(kobold setCel: 1)
					(= state 0)
					(= ticks 18)
				else
					(kobold setCycle: End self)
				)
			)
			(4
				(client setScript: kobAwake)
			)
		)
	)
)

(instance kobWakeUp of KScript
	(properties)

	(method (dispose)
		(if global286
			(client posn: 62 80)
		else
			(client posn: 256 68)
		)
		(super dispose:)
	)

	(method (changeState newState &tmp [temp0 40])
		(switch (= state newState)
			(0
				(SetFlag 153)
				(client setLoop: 5 setCycle: End self)
			)
			(1
				(localproc_1)
				(= ticks 1)
			)
			(2
				(gMessager say: 9 0 26 1 self) ; "You go! You no stay here!"
			)
			(3
				(client setScript: kobAwake)
			)
		)
	)
)

(instance kobAwake of KScript
	(properties)

	(method (doit)
		(localproc_1)
		(if (and (IsFlag 280) (== state 0))
			(ClearFlag 280)
			(self changeState: 3)
		)
		(super doit:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= global261 gDay)
				(client view: 175 cel: 0 setCycle: 0)
				(localproc_1)
				(if global286
					(client posn: 62 80)
				else
					(client posn: 256 68)
				)
				(cond
					(local7
						(= cycles (Random 25 50))
						(= local7 0)
					)
					((and (IsFlag 166) (not (IsFlag 281)))
						(= cycles (Random 5 15))
					)
					(global264
						(= cycles global264)
						(= global264 0)
					)
					(local8
						(= cycles local8)
					)
					(else
						(= cycles (Random 25 50))
					)
				)
			)
			(1
				(client view: 175)
				(cond
					((and (IsFlag 166) (not (IsFlag 281)))
						(client setScript: castRev)
					)
					(local8
						(= local8 0)
						(client setScript: castTele)
					)
					(else
						(client view: 177 cycleSpeed: 18 setCycle: CT 3 1 self)
					)
				)
			)
			(2
				(= temp0 (client loop:))
				((Actor new:)
					ignoreActors:
					illegalBits: 0
					view: 177
					setLoop: 5
					setStep: 24 16
					posn:
						(+ (client x:) [local15 temp0])
						(+ (client y:) [local20 temp0])
						20
					init:
					setCycle: Fwd
					setScript: (ballScript new:)
				)
				(= state -1)
				(client view: 175 cycleSpeed: 24 setCycle: End self)
			)
			(3
				(client view: 178 setCel: 0)
				(= cycles 2)
			)
			(4
				(client setCel: 1)
				(= cycles 2)
			)
			(5
				(client view: 175 cel: 0 setCel: -1 forceUpd:)
				(= state 0)
				(= cycles 5)
			)
		)
	)
)

(instance castRev of KScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					view: 176
					setLoop: 1
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(1
				(if (not (IsFlag 174))
					(SetFlag 174)
					(gMessager say: 9 0 24) ; "The Kobold casts a spell with which you are not familiar."
				)
				(SetFlag 281)
				(client setScript: kobAwake)
			)
		)
	)
)

(instance castTele of KScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					view: 176
					setLoop: 0
					cel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(1
				(= global286 (- 1 global286))
				(if local50
					(NormalEgo)
					(gEgo illegalBits: 0)
					(gCurRoom setScript: startFight)
				)
				(if global286
					(client posn: 62 80)
				else
					(client posn: 256 68)
				)
				(client setCycle: Beg self)
			)
			(2
				(client setScript: kobAwake)
			)
		)
	)
)

(instance egoDies of KScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= [gEgoStats 14] 0) ; health
				(pointBox dispose:)
				(client
					view: 513
					setLoop: global286
					cel: 0
					illegalBits: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(1
				(cond
					((IsFlag 282)
						(EgoDead 96 97) ; "Next time you swing at innocent inanimate objects, make sure you are strong enough to survive when they swing back at you!"
					)
					(local13
						(EgoDead 37 38) ; "You could not withstand the force of the blast from the Kobold's magically protected chest."
					)
					(else
						(EgoDead 132 133) ; "You are overcome by the power of the Kobold Wizard's magic. You need either to practice your skills or to plan a better attack strategy."
					)
				)
			)
		)
	)
)

(instance kobHurt of KScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 153)
				(if (IsFlag 150)
					(self dispose:)
				else
					(if local6
						(local6 dispose:)
						(= local6 0)
						(if global286
							(client posn: 62 80)
						else
							(client posn: 256 68)
						)
					)
					(client view: 178 setCycle: 0 setMotion: 0)
					(localproc_1)
					(client setCel: 2)
					(= cycles 5)
				)
			)
			(1
				(client setCel: 3)
				(= cycles 3)
			)
			(2
				(client setCel: -1)
				(if (> global282 0)
					(= local8 3)
					(client setScript: kobAwake)
				else
					(client setScript: kobDies)
				)
			)
		)
	)
)

(instance kobDies of KScript
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(pointBox dispose:)
				(SetFlag 150)
				(ClearFlag 153)
				(ClearFlag 281)
				(gEgo setScript: 0)
				(gCurRoom setScript: 0)
				(&= global260 $bfff)
				(client
					view: 178
					setLoop: 5
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
				(if (not (IsFlag 147))
					(kobKey
						illegalBits: 0
						ignoreActors:
						view: 178
						posn: (kobold x:) (kobold y:)
						approachX: (kobold x:)
						approachY: (kobold y:)
						setLoop: 7
						cel: 0
						setPri: 5
						cycleSpeed: 12
						setCycle: CT 4 1 self
					)
				)
			)
			(1
				(= global279 (= global280 0))
				(if (or (== gHeroType 0) (== gHeroType 1)) ; Fighter, Magic User
					(SolvePuzzle 602 10)
				)
				(gLongSong number: 20 loop: -1 play:)
				(if global268
					(gCurRoom setScript: stopFight)
				else
					(HandsOn)
					(gCurRoom setScript: 0)
				)
				(client dispose:)
			)
		)
	)
)

(instance kobEnter of KScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Platform 0 4 3 -1)
				(= cycles 1)
			)
			(1
				(HandsOff)
				(= cycles 1)
			)
			(2
				(gEgo setMotion: MoveTo 107 55 self)
			)
			(3
				(= local55 1)
				(if (not (IsFlag 5))
					(gMessager say: 9 0 20 1 self) ; "This section of cave has an eerie quality. You see a kobold resting on a ledge across from you."
				else
					(= cycles 1)
				)
			)
			(4
				(Platform 0 4 2 -1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoFighting of KScript
	(properties)

	(method (dispose)
		(= local50 0)
		(gDirectionHandler delete: self)
		(gEgo setScript: 0 illegalBits: global260)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local50 1)
				(if (gEgo has: 2) ; sword
					(= local9 swBlow)
					(= local10 (= local11 swDodge))
					(= local12 swParry)
				else
					(= local9 knStab)
					(= local10 (= local11 (= local12 knDodge)))
				)
				(= global268 1)
				(gDirectionHandler addToFront: self)
				(self cue:)
			)
			(1
				(proc15_1 1)
				(= state 0)
			)
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(if local50
			(cond
				((== (event type:) evMOUSEBUTTON)
					(= temp1 (event x:))
					(cond
						((< (= temp2 (event y:)) 144)
							(cond
								((> temp1 285)
									(if (not local54)
										(gEgo setScript: local9 self 0)
									else
										1
									)
								)
								((< temp1 265)
									(if (not local54)
										(gEgo setScript: local11 self 2)
									else
										1
									)
								)
							)
						)
						((> temp2 159)
							(cond
								((> temp1 285)
									(if (not local54)
										(gEgo setScript: local10 self 1)
									else
										1
									)
								)
								((< temp1 265)
									(if (not local54)
										(gEgo setScript: local12 self 3)
									else
										1
									)
								)
							)
						)
					)
					(event claimed: 1)
				)
				((and (<= JOY_UP (event message:) JOY_UPLEFT) (not (gEgo script:)))
					(HandsOff)
					(switch (event message:)
						(JOY_UPRIGHT
							(gEgo setScript: local9 self 0)
						)
						(JOY_DOWNRIGHT
							(gEgo setScript: local10 self 1)
						)
						(JOY_UPLEFT
							(gEgo setScript: local11 self 2)
						)
						(JOY_DOWNLEFT
							(gEgo setScript: local12 self 3)
						)
						(else
							(HandsOn)
							(User canControl: 0)
						)
					)
				)
			)
		)
	)
)

(instance pickChest of KScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 216)
				(gEgo
					view: 510
					setLoop: (if (< (+ (chest x:) 14) (gEgo x:)) 1 else 0)
					cel: 0
					setCycle: End self
				)
			)
			(1
				(= local51 (= local52 1))
				(cond
					((and register (TrySkill 0 40 0)) ; strength
						(SetFlag 282)
						(gMessager say: 9 0 19 0 self) ; "You pry at the sealed lid of the chest, and..."
					)
					(register
						(gMessager say: 9 0 23 0 self) ; "You hack and pry at the chest, but you are not strong enough to force its lid."
						(= local52 0)
					)
					((TrySkill 9 70 global175) ; pick locks
						(gMessager say: 9 0 21) ; "You hear a very satisfying "Snick" as your pick catches the lock just right."
						(= local51 (= local52 0))
						(chest cycleSpeed: 12 setCycle: CT 3 1 self)
						(SetFlag 151)
					)
					(else
						(gMessager say: 9 0 22 0 self) ; "Your fingers shift slightly, and you feel an odd prickling sensation coming from the lock. You have a bad feeling about this."
					)
				)
			)
			(2
				(if local51
					(proc15_6)
				)
				(if local52
					(chest setScript: chestBlows)
				else
					(proc15_1 1)
				)
				(self dispose:)
			)
		)
	)
)

(instance searchCave of KScript ; UNUSED
	(properties)

	(method (dispose)
		(gEgo setAvoider: 0 setMotion: 0)
		(proc15_1 1)
		(super dispose:)
		(DisposeScript 982)
	)

	(method (doit)
		(if (IsFlag 153)
			(self dispose:)
		else
			(super doit:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (< (gEgo x:) 160)
					(= register 0)
					(gEgo setMotion: MoveTo 37 128 self)
				else
					(= register 1)
					(gEgo setMotion: MoveTo 302 158 self)
				)
			)
			(1
				(= seconds 3)
			)
			(2
				(if register
					(gEgo setMotion: MoveTo 37 128 self)
				else
					(gEgo setMotion: MoveTo 302 158 self)
				)
			)
			(3
				(= seconds 2)
			)
			(4
				(gEgo setMotion: MoveTo 132 163 self)
			)
			(5
				(= seconds 2)
			)
			(6
				(proc15_1 1)
				(self dispose:)
			)
		)
	)
)

(instance startFight of KScript
	(properties)

	(method (dispose)
		(= global267 0)
		(super dispose:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= register 0)
				(HandsOff)
				(EgoGait 0 0) ; walking
				(gEgo illegalBits: 0)
				(if global268
					(self cue:)
				else
					(= global267 1)
					(= global268 0)
					(if
						(<
							(= global283
								(-
									(/
										(+
											(* [gEgoStats 5] 8) ; weapon-use
											(* [gEgoStats 2] 4) ; agility
											(* [gEgoStats 0] 2) ; strength
											[gEgoStats 1] ; intelligence
											[gEgoStats 4] ; luck
										)
										16
									)
									20
								)
							)
							5
						)
						(= global283 5)
					)
					(= global284 (+ 9 (/ [gEgoStats 0] 10))) ; strength
					(if (gEgo has: 2) ; sword
						(+= global284 3)
					)
					(if (< (gEgo y:) 105)
						(self cue:)
					else
						(gEgo setMotion: MoveTo 160 (gEgo y:) self)
					)
				)
			)
			(1
				(if (and global268 (gEgo has: 2)) ; sword
					((gEgo cycler:) vWalking: 501 vStopped: 501)
					(gEgo setLoop: (if global286 10 else 11))
				)
				(if global286
					(gEgo setMotion: MoveTo 130 81 self)
				else
					(gEgo setMotion: MoveTo 198 92 self)
				)
			)
			(2
				(= temp0 global286)
				(if (not (gEgo has: 2)) ; sword
					(+= temp0 2)
				)
				(if global268
					(gEgo setCycle: 0)
					(= ticks 12)
				else
					(gEgo
						view: 502
						setLoop: temp0
						cycleSpeed: 12
						setCycle: End self
					)
				)
			)
			(3
				(client setScript: egoFighting)
			)
		)
	)
)

(instance stopFight of KScript
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global268 0)
				(= temp0 global286)
				(if (not (gEgo has: 2)) ; sword
					(+= temp0 2)
				)
				(gEgo
					view: 502
					setLoop: temp0
					cel: (gEgo lastCel:)
					setCycle: Beg self
				)
			)
			(1
				(NormalEgo)
				(gEgo loop: global286)
				(if (not (IsFlag 150))
					(gEgo illegalBits: global260)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance swBlow of KScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local47 global286)
				(gEgo cel: 0 setLoop: (+ global286 2) setCycle: End self)
			)
			(1
				(if (and (== global286 local47) (>= global283 (Random100)))
					(gKobold getHurt: global284)
				)
				(= ticks 12)
			)
			(2
				(gEgo cel: 0 setLoop: global286)
				(self dispose:)
			)
		)
	)
)

(instance swDodge of KScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: global286 setCel: register)
				(= cycles 10)
			)
			(1
				(gEgo setCel: 0)
				(self dispose:)
			)
		)
	)
)

(instance swParry of KScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: (+ global286 8) setCel: 0)
				(= cycles 8)
			)
			(1
				(gEgo setLoop: global286)
				(self dispose:)
			)
		)
	)
)

(instance knStab of KScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local47 global286)
				(gEgo setLoop: (if global286 5 else 0))
				(gEgo setCel: -1 cel: 0 setCycle: CT 4 1 self)
			)
			(1
				(if (and (== global286 local47) (>= global283 (Random100)))
					(gKobold getHurt: global284)
				)
				(= cycles 4)
			)
			(2
				(gEgo setCycle: End self)
				(= cycles register)
			)
			(3
				(gEgo setCel: 0)
				(self dispose:)
			)
		)
	)
)

(instance knDodge of KScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setLoop:
						(if global286
							(+ register 5)
						else
							register
						)
					setCel: 0
				)
				(= cycles 10)
			)
			(1
				(gEgo setLoop: (if global286 5 else 0))
				(self dispose:)
			)
		)
	)
)

(class inputBox of View
	(properties
		oldX 0
		oldY 0
		relX 280
		relY 155
		first 1
		leftBor 260
		rightBor 303
		topBor 130
		botBor 175
		value 0
	)

	(method (dispose)
		(gGame setCursor: gNormalCursor 1)
		(gTheIconBar enable:)
		(super dispose:)
	)

	(method (init)
		(gTheIconBar disable:)
		(gGame setCursor: gNormalCursor 1 280 155)
		(self setPri: 14 ignoreActors:)
		(super init: &rest)
	)
)

(instance pointBox of inputBox
	(properties
		x 303
		y 175
		view 945
		loop 2
	)
)

(instance getItCued of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 60)
			)
			(1
				(switch local57
					(1
						(gEgo get: 30 6) ; mushroom
					)
					(2
						(gEgo get: 38 10 get: 0 60) ; gold, silver
					)
					(3
						(gEgo get: 16) ; brassKey
					)
				)
				(self cue:)
			)
			(2
				(self dispose:)
			)
		)
	)
)

