;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use n101)
(use n102)
(use Interface)
(use TargActor)
(use LoadMany)
(use Avoid)
(use Sound)
(use Save)
(use Motion)
(use Game)
(use Inventory)
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
	[local0 5] = [79 113 172 226 306]
	[local5 5] = [204 189 193 191 203]
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	[local19 11] = [17 44 17 251 101 183 283 316 102 244 169]
	[local30 11] = [47 155 134 186 47 145 124 212 161 51 55]
	[local41 5] = [-24 24 -17 17 -5]
	[local46 5] = [6 6 10 10 13]
)

(procedure (localproc_0 param1 param2 &tmp temp0)
	(= temp0 (gGame parseLang:))
	(gGame parseLang: 1)
	(param1 type: 128 claimed: 0)
	(Parse param2 param1)
	(User said: param1)
	(gGame parseLang: temp0)
)

(procedure (localproc_1 param1)
	(Print &rest #at -1 150 #width 300 #mode 1 #dispose #time param1)
)

(procedure (localproc_2 param1)
	(Print &rest #at 150 2 #width 0 #mode 1 #window kobWin #dispose #time param1)
)

(procedure (localproc_3 param1)
	(SetFlag 175)
	(SolvePuzzle 650 5)
	(LowPrint 15 0) ; "You add ten gold and sixty silver coins to your money pouch."
	(if param1
		(param1 dispose:)
	)
	(&= global282 $dfff)
	(gEgo illegalBits: global282 get: 2 10 get: 1 60) ; gold, silver
)

(procedure (proc15_1 param1)
	(if (and param1 (not (IsFlag 283)))
		(HandsOn)
	)
	(if global290
		(User canControl: 0)
		(if (gEgo has: 6) ; blade
			(gEgo view: 501 setLoop: global348)
		else
			(gEgo view: 512 setLoop: (* global348 5))
		)
		(gEgo setCel: 0 illegalBits: 0 cycleSpeed: 0)
	else
		(NormalEgo)
		(gEgo illegalBits: global282)
	)
)

(procedure (localproc_4 &tmp temp0 temp1)
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
							120
						)
						1
					)
					((< temp0 150) 3)
					((> temp0 240) 0)
					((> temp0 210) 2)
					(else 4)
				)
			)
			(kobold loop:)
		)
		(kobold setLoop: temp1)
	)
)

(procedure (localproc_5 param1 param2 param3)
	(if (CastSpell param1)
		(SetFlag 166)
		(proc15_6)
		(gEgo setScript: (ScriptID param2 param3))
	)
)

(procedure (localproc_6 param1 param2 param3)
	(cond
		((IsFlag 153)
			(LowPrint 15 1) ; "You don't have time for that."
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
	(if (not (TakeDamage param1))
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
				(ballSound play:)
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
							[local19 register]
							[local30 register]
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
								[local19 register]
								[local30 register]
								self
						)
					)
				)
			)
			(2
				(ballHits play:)
				(client
					setLoop: (if register 7 else 6)
					cel: 0
					setMotion: 0
					setCycle: End self
				)
				(if register
					(proc15_7 (if (gEgo has: 9) 15 else 20)) ; shield
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
		picture 15
		style 8
		west 14
	)

	(method (dispose)
		(SetFlag 5)
		(ClearFlag 216)
		(super dispose:)
	)

	(method (init)
		(= global290 (= global289 0))
		(if [gEgoStats 12] ; magic
			(LoadMany rsSCRIPT 110 113 114 115)
			(Load rsSOUND (SoundFX 33))
			(LoadMany rsVIEW 520 521 522 532)
		)
		(if (not (IsFlag 150))
			(Load rsSCRIPT 111)
			(Load rsSOUND (SoundFX 45))
			(Load rsSOUND (SoundFX 34))
			(LoadMany rsVIEW 513 175 176 178 502)
			(if (gEgo has: 6) ; blade
				(Load rsVIEW 501)
			else
				(Load rsVIEW 512)
				(Load rsVIEW 524)
			)
		)
		(if (not (IsFlag 151))
			(Load rsSOUND (SoundFX 36))
			(Load rsSOUND (SoundFX 62))
		)
		(Load rsVIEW 510)
		(SolvePuzzle 648 2)
		(SL enable:)
		(super init:)
		(gKeyHandler add: self)
		(gMouseHandler add: self)
		(EgoGait 0 0) ; walking
		(NormalEgo)
		(gEgo posn: 1 63 init:)
		(drip init: setScript: dripper)
		(dripper cycles: (Random 5 25))
		(if (not (IsFlag 165))
			(toadstools init: setPri: 9)
		)
		(if (not (IsFlag 151))
			(chest init: stopUpd:)
			(|= global282 $2000)
		)
		(if (not (IsFlag 147))
			(if global348
				(kobKey posn: 52 84)
			)
			(kobKey
				ignoreActors:
				setPri: (if global348 5 else 1)
				init:
				stopUpd:
			)
			(if (not (IsFlag 150))
				(kobKey hide:)
			)
		)
		(if (not (IsFlag 150))
			(|= global282 $4000)
			(kobold init:)
			(= gKobold kobold)
		)
		(gEgo illegalBits: global282)
		(self setScript: kobEnter)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(clr)
		(= temp0 (event type:))
		(cond
			((super handleEvent: event))
			((== temp0 evMOUSEBUTTON)
				(cond
					((and (gCast contains: kobKey) (MouseClaimed kobKey event 3))
						(localproc_0 event {look key})
					)
					(
						(and
							(gCast contains: treasure)
							(MouseClaimed treasure event 3)
						)
						(localproc_0 event {look coins})
					)
					((and (gCast contains: chest) (MouseClaimed chest event 3))
						(localproc_0 event {look chest})
					)
					(
						(and
							(gCast contains: toadstools)
							(MouseClaimed toadstools event 3)
						)
						(localproc_0 event {look mushroom})
					)
					((and (not (IsFlag 150)) (MouseClaimed kobold event 3))
						(localproc_0 event {look kobold})
					)
				)
			)
			((!= temp0 evSAID))
			((and (not (IsFlag 150)) (Said 'talk,talk,ask,awaken'))
				(LowPrint 15 2) ; "The Kobold seems more interested in frying you with Ball Lightning than in talking to you."
			)
			((Said 'nap,nap,rest,rest')
				(LowPrint 15 3) ; "You'd better not. This cave is not recommended by the Michelin Guide."
			)
			((Said 'search')
				(if (IsFlag 153)
					(LowPrint 15 4) ; "You don't have time for that now."
				else
					(gEgo setScript: searchCave)
				)
			)
			((Said 'get,get,grab,get/key[<kobold,brass,big,magic,glowing]')
				(cond
					((gCast contains: kobKey)
						(= temp1 0)
						(cond
							((> (gEgo distanceTo: kobKey) 40)
								(LowPrint 15 5) ; "You can't reach the key from here."
							)
							((IsFlag 150)
								(LowPrint 15 6) ; "You take the Kobold's glowing key."
								(= temp1 1)
							)
							((IsFlag 153)
								(LowPrint 15 7) ; "The Kobold won't let you near his key."
							)
							((TrySkill 8 35 0) ; stealth
								(LowPrint 15 8) ; "VERY carefully, you remove the key from around the Kobold's neck."
								(= temp1 1)
							)
							(else
								(LowPrint 15 9) ; "Uh oh. You weren't stealthy enough. You have awoken the Kobold."
								(proc15_6)
							)
						)
						(if temp1
							(gEgo get: 5) ; key
							(SetFlag 147)
							(SolvePuzzle 649 7)
							(kobKey dispose:)
						)
					)
					((gEgo has: 5) ; key
						(LowPrint 15 10) ; "You already have the key."
					)
					((gEgo pickUp: 5 1)
						(LowPrint 15 11) ; "You retrieve the dropped key."
					)
					(else
						(LowPrint 15 12) ; "The key is gone."
					)
				)
			)
			(
				(and
					(IsFlag 216)
					(Said 'get,get,grab,get,move,move/chest,box,trunk')
				)
				(LowPrint 15 13) ; "The chest is far too heavy to move."
			)
			((Said 'get,get/loot,alm,gold,silver')
				(cond
					(
						(and
							(< (gEgo distanceTo: chest) 25)
							(gCast contains: treasure)
						)
						(localproc_3 treasure)
					)
					((IsFlag 175)
						(LowPrint 15 14) ; "You've already taken the treasure."
					)
					((not (< (gEgo distanceTo: chest) 25))
						(LowPrint 15 15) ; "You are too far away to get the Kobold's treasure."
					)
					((not (IsFlag 151))
						(LowPrint 15 16) ; "You will have to open it first. The chest seems to be locked."
					)
					(else
						(localproc_3 0)
					)
				)
			)
			(
				(or
					(Said
						'use,turn,open,open,open,unlock/key,chest,box,trunk[/key]'
					)
					(Said 'put,fill<in/key/hasp,hasp,lock')
				)
				(if (and (IsFlag 216) (gCast contains: chest))
					(LowPrint 15 17) ; "The key doesn't fit in the chest. It must be for a different lock."
				else
					(LowPrint 15 18) ; "You don't see any locks here."
				)
			)
			(
				(or
					(Said
						'pick,lockpick/hasp,hasp,lock,keyhole,chest,box,trunk'
					)
					(Said 'use,fill/lockpick,(implement,kit<thief)')
				)
				(cond
					((or (not (IsFlag 216)) (not (gCast contains: chest)))
						(LowPrint 15 18) ; "You don't see any locks here."
					)
					((IsFlag 151)
						(LowPrint 15 19) ; "The chest is already open."
					)
					((not (< (gEgo distanceTo: chest) 25))
						(NotClose)
					)
					((not [gEgoStats 9]) ; pick locks
						(LowPrint 15 20) ; "You have no skill at picking locks."
					)
					(else
						(gEgo setScript: pickChest 0 0)
					)
				)
			)
			((Said 'force,break,pry/chest,box,trunk,hasp,hasp,lock,lid')
				(cond
					((or (not (IsFlag 216)) (not (gCast contains: chest)))
						(LowPrint 15 21) ; "You don't see a chest here."
					)
					((IsFlag 151)
						(LowPrint 15 19) ; "The chest is already open."
					)
					((not (< (gEgo distanceTo: chest) 25))
						(NotClose)
					)
					(else
						(gEgo setScript: pickChest 0 1)
					)
				)
			)
			(
				(and
					(gCast contains: toadstools)
					(Said 'get,get/toadstool,mushroom,food')
				)
				(if global290
					(LowPrint 15 22) ; "No time for that now!"
				else
					(LowPrint 15 23) ; "You pick up the Kobold's mushrooms and put them in your pack."
					(SetFlag 165)
					(SetFlag 148)
					(gEgo get: 30 6) ; magic mushroom
					(toadstools dispose:)
				)
			)
			((Said 'get,get/fungus')
				(LowPrint 15 24) ; "The fungus is slimy and firmly attached to the cave walls. You'd better leave it there."
			)
			((Said 'feel/chest,box,trunk')
				(localproc_0 event {look chest})
			)
			((Said 'look,look>')
				(cond
					((Said '/west,open,open,open,entrance')
						(LowPrint 15 25) ; "Looking back the way you came, you see a faint reflection of the distant sunlight from the cave entrance."
					)
					(
						(or
							(Said
								'/stalactite,stalagmite,boulder,ceiling,roof,floor,ground,formation'
							)
							(Said '<up,down')
						)
						(LowPrint 15 26) ; "The stalactites look much like the stalagmites, except that they go the other way."
					)
					((Said '[<at,around][/!*,cave,room,area,wall,fungus]')
						(LowPrint 15 27) ; "This part of the cavern is spacious and multi-leveled. Phosphorescent fungus illuminates the cavern with an unearthly glow."
						(if (not (IsFlag 150))
							(LowPrint 15 28) ; "On a rocky platform above the cave floor is a Kobold, one of the race of ugly, miserly creatures known for their skill in Magic."
						)
					)
					((and (gCast contains: kobKey) (Said '/key'))
						(LowPrint 15 29) ; "The Kobold's large, brass key glows slightly in the dark cavern."
					)
					((Said '/table,mushroom,toadstool,food')
						(if (gCast contains: toadstools)
							(HighPrint 15 30) ; "Some sort of food (mushrooms?) sits in a pile on the stone table. It looks almost edible... to a Kobold."
						else
							(LowPrint 15 31) ; "The Kobold's dinner table is now bare."
						)
					)
					((Said '/kobold,creature,man,wizard')
						(if (not (IsFlag 150))
							(LowPrint 15 32) ; "The strange creature is dressed in ragged clothes. It has large, pale eyes. It must have spent its entire life in these caves!"
							(if (not (IsFlag 147))
								(LowPrint 15 33) ; "A large, brass key hangs from a thong around the creature's neck."
							)
						else
							(LowPrint 15 34) ; "The Kobold has disappeared entirely. You are not sure whether you killed him, or whether he escaped by some sort of spell."
						)
					)
					(
						(or
							(Said '<in/chest,box,trunk')
							(Said '/loot,alm,gold,silver')
						)
						(cond
							((gCast contains: treasure)
								(LowPrint 15 35) ; "Where the chest was, you see numerous pieces of gold and silver."
							)
							((not (gCast contains: chest))
								(LowPrint 15 36) ; "There is no sign of any other treasure in the cavern."
							)
							((not (IsFlag 216))
								(LowPrint 15 37) ; "You don't *see* any treasure here."
							)
							((IsFlag 175)
								(LowPrint 15 38) ; "The chest is empty."
							)
							((IsFlag 151)
								(LowPrint 15 39) ; "The chest contains numerous pieces of gold and silver."
							)
							(else
								(LowPrint 15 40) ; "You will have to open the chest first. It seems to be locked."
							)
						)
					)
					((Said '/chest,box,trunk')
						(cond
							((not (gCast contains: chest))
								(LowPrint 15 41) ; "Nothing useful remains of the chest."
							)
							((IsFlag 216)
								(LowPrint 15 42) ; "You cannot see the chest, but it feels fairly large, and is too heavy to carry."
							)
							(else
								(LowPrint 15 43) ; "You don't *see* a treasure chest here."
							)
						)
					)
				)
			)
			((or (Said 'escape') (Said 'run[/!*]'))
				(LowPrint 15 44) ; "The damp floor is too slippery for you to run safely."
				(if (not (IsFlag 150))
					(LowPrint 15 45) ; "Just try to walk out of the cave while you still have time."
				)
				(if global290
					(self setScript: stopFight)
				)
			)
			((Said 'attack,attack,attack,kill,hit[/kobold,creature,man,wizard]')
				(cond
					(global290
						(LowPrint 15 46) ; "That's what you're doing. Keep going!"
					)
					((IsFlag 150)
						(LowPrint 15 47) ; "There are no monsters here to attack."
					)
					((not (or (gEgo has: 6) (gEgo has: 7))) ; blade, dagger
						(LowPrint 15 48) ; "How embarrassing. You don't have a weapon with which to fight!"
					)
					(else
						(self setScript: startFight)
					)
				)
			)
			((Said 'throw>')
				(cond
					(global290
						(event claimed: 1)
						(LowPrint 15 49) ; "You're too close to the Kobold for throwing to be practical."
					)
					((IsFlag 150))
					((Said '/dagger')
						(ThrowKnife kobold)
					)
					((Said '/boulder')
						(ThrowRock kobold)
					)
				)
			)
			((Said 'cast>')
				(if
					(and
						(= temp2 (SaidSpell event))
						global290
						(gEgo has: 9) ; shield
					)
					(LowPrint 15 50) ; "You cannot make the arcane gestures to cast spells while carrying your shield."
					(event claimed: 1)
					(= temp2 -1)
				)
				(switch temp2
					(-1)
					(0
						(event claimed: 0)
					)
					(20
						(if (not (IsFlag 150))
							(localproc_5 20 113 0)
						else
							(event claimed: 0)
						)
					)
					(23
						(if (not (IsFlag 150))
							(localproc_5 23 110 0)
						else
							(event claimed: 0)
						)
					)
					(22
						(localproc_5 22 114 0)
					)
					(21
						(event claimed: 0)
					)
					(global290
						(LowPrint 15 1) ; "You don't have time for that."
					)
					(18
						(localproc_6 18 113 1)
					)
					(17
						(if (and (not (IsFlag 151)) (gCast contains: chest))
							(localproc_6 17 115 0)
						else
							(LowPrint 15 51) ; "There's nothing to open here."
						)
					)
					(19
						(if (and (not (IsFlag 151)) (gCast contains: chest))
							(localproc_6 19 115 1)
						else
							(LowPrint 15 52) ; "There are no passive spells to trigger here."
						)
					)
					(24
						(if
							(and
								(not (IsFlag 150))
								(gCast contains: kobKey)
							)
							(localproc_6 24 114 1)
						else
							(LowPrint 15 53) ; "You don't need to cast Fetch -- everything here is in easy reach."
						)
					)
					(else
						(event claimed: 0)
					)
				)
			)
		)
	)
)

(instance kobKey of Act
	(properties
		y 85
		x 229
		view 178
		loop 6
		cel 12
		illegalBits 0
	)
)

(instance chest of Prop
	(properties
		y 173
		x 132
		view 15
		loop 1
	)

	(method (doit)
		(if (and (< (gEgo distanceTo: chest) 25) (not (IsFlag 216)))
			(LowPrint 15 54) ; "You just bumped into something on the floor. It feels like a large wooden chest, but you don't see anything there."
			(SetFlag 216)
		)
		(super doit:)
	)
)

(instance chestBlows of KScript
	(properties)

	(method (dispose)
		(if (>= state 1)
			(local18 dispose:)
		)
		(= local17 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setLoop: 2 cel: 0 cycleSpeed: 0 setCycle: CT 4 1 self)
			)
			(1
				(SetFlag 151)
				((= local18 (Sound new:))
					number: (SoundFX 62)
					priority: 15
					init:
					play:
				)
				(client setCycle: End)
				(proc15_6)
				(if (< (gEgo distanceTo: chest) 25)
					(= local17 1)
					(proc15_7 20)
				)
				(= cycles 10)
			)
			(2
				(= cycles 1)
				(if (< (gEgo distanceTo: chest) 25)
					(LowPrint 15 55) ; "Wow! The chest must have been booby-trapped. You can really feel the damage from the blast."
					(= cycles 5)
				)
			)
			(3
				(treasure init:)
				(proc15_1 1)
				(LookAt gEgo treasure)
				(client dispose:)
			)
		)
	)
)

(instance treasure of View
	(properties
		y 173
		x 132
		view 15
		loop 2
		cel 8
	)
)

(instance toadstools of View
	(properties
		y 117
		x 213
		view 15
		loop 3
	)
)

(instance drip of Prop
	(properties
		y 204
		x 79
		view 15
	)
)

(instance dripEndLoop of End
	(properties)
)

(instance dripper of KScript
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(1
				(= temp0 (Random 0 4))
				(drip posn: [local0 temp0] [local5 temp0] setCycle: dripEndLoop)
				(= state 0)
				(= cycles (Random 20 40))
			)
		)
	)
)

(instance kobWin of SysWindow
	(properties
		color 6
	)
)

(instance ballSound of Sound
	(properties
		number 34
		priority 2
	)
)

(instance ballHits of Sound
	(properties
		number 45
		priority 3
	)
)

(instance kobold of TargActor
	(properties
		y 85
		x 229
		view 175
		loop 6
		cycleSpeed 3
		illegalBits 0
		targDeltaY -15
	)

	(method (init)
		(ClearFlag 280)
		(ClearFlag 281)
		(ballSound number: (SoundFX 34) init:)
		(ballHits number: (SoundFX 45) init:)
		(if (gEgo knows: 23)
			(= global346 (+ 5 (/ [gEgoStats 23] 3))) ; flameDartSpell
		)
		(= global348 0)
		(super ignoreActors: posn: 229 85 setPri: 6 init:)
		(if (< global211 8)
			(kobWin color: 0 back: 15)
		)
		(if
			(or
				(not (IsFlag 5))
				(and (not gNight) (!= gDay global283))
			)
			(self setScript: kobAsleep)
		else
			(self setScript: kobAwake)
		)
		(= global332 15)
		(= global333 global343)
	)

	(method (dispose)
		(ClearFlag 153)
		(ballHits dispose:)
		(ballSound dispose:)
		(if local10
			(local10 dispose:)
		)
		(super dispose:)
	)

	(method (getHurt param1)
		(-= global343 param1)
		(self setScript: kobHurt)
	)
)

(instance kobDazzle of KScript
	(properties)

	(method (dispose)
		(= local11 (* register 5))
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
				(client view: 179 setCel: 0)
				(= cycles 10)
			)
			(1
				(kobold setCel: -1 cycleSpeed: 2 setCycle: CT 2 1)
				(= cycles 10)
			)
			(2
				(kobold setCel: 3)
				(= cycles 4)
			)
			(3
				(kobold setCel: 4)
				(= cycles 4)
			)
			(4
				(if (> (-- register) 0)
					(self changeState: 2)
				else
					(= cycles 5)
				)
			)
			(5
				(kobold setCel: 5)
				(= cycles 20)
			)
			(6
				(client setScript: kobAwake)
			)
		)
	)
)

(instance kobWakeUp of KScript
	(properties)

	(method (dispose)
		(if local10
			(local10 dispose:)
			(= local10 0)
			(client setCycle: 0)
		)
		(if global348
			(client posn: 52 84)
		else
			(client posn: 229 85)
		)
		(gContMusic stop:)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 153)
				(client setCycle: End)
				(= cycles 12)
			)
			(1
				(client setLoop: 7 setCycle: Fwd)
				(localproc_2 5 15 56) ; "You go! You no stay here!"
				(= seconds 3)
			)
			(2
				(client setScript: kobAwake)
			)
		)
	)
)

(instance kobAwake of KScript
	(properties)

	(method (doit)
		(localproc_4)
		(if (and (IsFlag 280) (== state 0))
			(ClearFlag 280)
			(self changeState: 3)
		)
		(super doit:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(SetFlag 153)
				(= global283 gDay)
				(client view: 175 cel: 0 setCycle: 0)
				(localproc_4)
				(if global348
					(client posn: 52 84)
				else
					(client posn: 229 85)
				)
				(cond
					(local11
						(client view: 179 setCel: 1)
						(= cycles (Random 25 50))
						(= local11 0)
					)
					((and (IsFlag 166) (not (IsFlag 281)))
						(= cycles (Random 5 15))
					)
					(global286
						(= cycles global286)
						(= global286 0)
					)
					(local12
						(= cycles local12)
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
					(local12
						(= local12 0)
						(client setScript: castTele)
					)
					(else
						(client view: 177 cycleSpeed: 0 setCycle: End self)
					)
				)
			)
			(2
				(= temp0 (client loop:))
				((Act new:)
					ignoreActors:
					illegalBits: 0
					view: 177
					setLoop: 5
					setStep: 24 16
					posn:
						(+ (client x:) [local41 temp0])
						(+ (client y:) [local46 temp0])
						20
					init:
					setCycle: Fwd
					setScript: (ballScript new:)
				)
				(= state -1)
				(client view: 175 cycleSpeed: 3 setCycle: End self)
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

(instance kobAsleep of KScript
	(properties)

	(method (doit)
		(if
			(and
				(< (gEgo distanceTo: client) 100)
				(or (!= gEgoGait 2) (< [gEgoStats 8] 20)) ; sneaking, stealth
			)
			(localproc_1 7 15 57) ; "Your foot slips on the wet cavern floor and makes a scuffing noise."
			(EgoGait 0 0) ; walking
			(client setScript: kobWakeUp)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global343 67)
				((= local10 (View new:))
					view: 175
					loop: 5
					cel: 0
					ignoreActors:
					posn: 229 85
					setPri: 6
					init:
				)
				(client
					posn: (local10 x:) (- (local10 y:) 17)
					setLoop: 6
					cycleSpeed: 1
				)
			)
		)
	)
)

(instance castRev of KScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (IsFlag 174))
					(SetFlag 174)
					(localproc_1 7 15 58) ; "The Kobold casts a spell with which you are not familiar."
				)
				(client view: 176 setLoop: 1 cel: 0 cycleSpeed: 1 setCycle: End)
				(= cycles 10)
			)
			(1
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
					cycleSpeed: 0
					setCycle: End self
				)
				(if global290
					(gCurRoom setScript: stopFight)
				)
			)
			(1
				(= global348 (- 1 global348))
				(if global289
					(NormalEgo)
					(gEgo illegalBits: 0)
					(startFight changeState: 1)
				)
				(if global348
					(client posn: 52 84)
				else
					(client posn: 229 85)
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
				(client
					view: 513
					setLoop: global348
					cel: 0
					illegalBits: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(1
				(cond
					((IsFlag 282)
						(EgoDead ; "Next time you swing at innocent inanimate objects, make sure you are strong enough to survive when they swing back at you!"
							15
							59
							80
							{Your plan seems to have backfired%j\b7\d0\c9 \cc\df\d7\dd\b6\de \b1\c0\de\c6 \c5\af\c0\c8}
							82
							15
							2
							6
						)
					)
					(local17
						(EgoDead 15 60 80 {Blast!%j\ca\de\b0\dd!} 82 15 2 6) ; "You could not withstand the force of the blast from the Kobold's magically protected chest."
					)
					(else
						(EgoDead ; "You are overcome by the power of the Kobold Wizard's magic. You need to either practice your skills more or plan a better attack strategy."
							15
							61
							80
							{You've been deep-fried%j\b7\d0\ca \c3\dd\cc\df\d7\c6 \bb\da\c3 \bc\cf\af\c0\d6}
							82
							532
							0
							1
						)
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
				(if (IsFlag 150)
					(self dispose:)
				else
					(if local10
						(local10 dispose:)
						(= local10 0)
						(if global348
							(client posn: 52 84)
						else
							(client posn: 229 85)
						)
					)
					(client view: 178 setCycle: 0 setMotion: 0)
					(localproc_4)
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
				(if (> global343 0)
					(= local12 3)
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
				(SetFlag 150)
				(ClearFlag 153)
				(gEgo setScript: 0)
				(gCurRoom setScript: 0)
				(&= global282 $bfff)
				(client
					view: 178
					setLoop: 5
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
				(if (not (IsFlag 147))
					(kobKey
						show:
						illegalBits: 0
						ignoreActors:
						view: 178
						posn: (kobold x:) (kobold y:)
						setLoop: 6
						cel: 0
						setPri: (if global348 5 else 1)
						cycleSpeed: 1
						setCycle: End
					)
				)
			)
			(1
				(= global332 (= global333 0))
				(if (or (== gHeroType 0) (== gHeroType 1)) ; Fighter, Magic User
					(SolvePuzzle 602 10)
				)
				(gContMusic number: 20 loop: -1 play:)
				(if global290
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
				(HandsOff)
				(if (not (IsFlag 5))
					(localproc_1 7 15 62) ; "This section of cave has an eerie quality."
				)
				(gEgo setMotion: MoveTo 65 63 self)
			)
			(1
				(gEgo setMotion: MoveTo 100 77 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoFighting of KScript
	(properties)

	(method (dispose)
		(gDirHandler delete: self)
		(gEgo setScript: 0 illegalBits: global282)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo has: 6) ; blade
					(= local13 0)
					(= local14 (= local15 1))
					(= local16 2)
				else
					(= local13 3)
					(= local14 (= local15 (= local16 4)))
				)
				(= global290 1)
				(gDirHandler addToFront: self)
				(self cue:)
			)
			(1
				(proc15_1 1)
				(= state 0)
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((super handleEvent: event))
			((and (== (event type:) $0040) (not (gEgo script:))) ; direction
				(HandsOff)
				(switch (event message:)
					(JOY_UP
						(gEgo setScript: (ScriptID 111 local13) self 0)
					)
					(JOY_LEFT
						(gEgo setScript: (ScriptID 111 local14) self 1)
					)
					(JOY_RIGHT
						(gEgo setScript: (ScriptID 111 local15) self 2)
					)
					(JOY_DOWN
						(gEgo setScript: (ScriptID 111 local16) self 3)
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

(instance pickChest of KScript
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 216)
				(gEgo
					view: 510
					setLoop: (if (< (chest x:) (gEgo x:)) 1 else 0)
					cel: 0
					cycleSpeed: 1
					setCycle: End
				)
				(= cycles 8)
			)
			(1
				(= temp0 (= temp1 1))
				(cond
					((and register (TrySkill 0 40 0)) ; strength
						(SetFlag 282)
						(LowPrint 15 63) ; "You pry at the sealed lid of the chest, and..."
					)
					(register
						(LowPrint 15 64) ; "You hack and pry at the chest, but you are not strong enough to force its lid."
						(= temp1 0)
					)
					((TrySkill 9 70 global189) ; pick locks
						(LowPrint 15 65) ; "You hear a very satisfying "Snick" as your pick catches the lock just right."
						(LowPrint 15 66) ; "Then you sense powerful magics dissipating around the lock, and your hands shake as you realize you have narrowly avoided some sort of Magical Doom."
						(= temp0 (= temp1 0))
						(SetFlag 151)
					)
					(else
						(LowPrint 15 67) ; "Your fingers shift slightly, and you feel an odd prickling sensation coming from the lock. You have a bad feeling about this."
					)
				)
				(if temp0
					(proc15_6)
				)
				(if temp1
					(chest setScript: chestBlows)
				else
					(proc15_1 1)
				)
				(self dispose:)
			)
		)
	)
)

(instance searchCave of KScript
	(properties)

	(method (dispose)
		(gEgo setAvoider: 0 setMotion: 0)
		(proc15_1 1)
		(super dispose:)
		(DisposeScript 985)
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
				(gEgo setAvoider: Avoid)
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
		(= global289 0)
		(super dispose:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= global289 1)
				(= global290 0)
				(HandsOff)
				(EgoGait 0 0) ; walking
				(gEgo illegalBits: 0)
				(if
					(<
						(= global344
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
					(= global344 5)
				)
				(= global345 (+ 9 (/ [gEgoStats 0] 10))) ; strength
				(if (gEgo has: 6) ; blade
					(+= global345 3)
				)
				(if (< (gEgo y:) 105)
					(self cue:)
				else
					(gEgo setMotion: MoveTo 160 (gEgo y:) self)
				)
			)
			(1
				(if global348
					(gEgo setMotion: MoveTo 111 96 self)
				else
					(gEgo setMotion: MoveTo 172 94 self)
				)
			)
			(2
				(= temp0 global348)
				(if (not (gEgo has: 6)) ; blade
					(+= temp0 2)
				)
				(gEgo
					view: 502
					setLoop: temp0
					cycleSpeed: 1
					setCycle: End self
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

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global290 0)
				(= temp0 global348)
				(if (not (gEgo has: 6)) ; blade
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
				(gEgo loop: global348)
				(if (not (IsFlag 150))
					(gEgo illegalBits: global282)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

