;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 640)
(include sci.sh)
(use Main)
(use n026)
(use OccasionalCycle)
(use JumpX)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Rev)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm640 0
)

(local
	local0
	local1
	local2
	local3
	local4 = 1
	local5
	local6
	local7
	local8
	local9
	local10
)

(instance rm640 of Rm
	(properties
		noun 6
		picture 640
		vanishingY -100
	)

	(method (init)
		(LoadMany rsVIEW 31 2 43)
		(HandsOff)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 145 135 85 128 70 106 64 126 99 145 72 151 72 158 119 155 144 171 246 170 200 139 184 134
					yourself:
				)
		)
		(skull init:)
		(skulls init:)
		(table init:)
		(bed approachVerbs: 4 2 init:) ; Do, Talk
		(hole init:)
		(skin init:)
		(gEgo x: 78 y: 126 init: setScale: 135 normalize: changeGait: 2 0) ; sneaking
		(spear init:)
		(chest init:)
		(chief init: approachVerbs: 4 2 stopUpd:) ; Do, Talk
		(monkey init: approachVerbs: 29 4 2) ; theFruit, Do, Talk
		(spell init: setScale: 135 hide:)
		(masK init: approachVerbs: 4) ; Do
		(gWalkHandler addToFront: self)
		(super init: &rest)
		(gCurRoom setScript: enterHut)
		(gGame save: 1)
	)

	(method (doVerb theVerb)
		(if
			(and
				(== theVerb 3) ; Walk
				(or (!= (gEgo view:) 2) (<= (gEgo trySkill: 8 140) 0)) ; sneak
				(not local5)
			)
			(HandsOff)
			(= local5 1)
			(= local0 1)
			(= local8 1)
			(if local9
				(gEgo
					setMotion:
						PolyPath
						((User curEvent:) x:)
						((User curEvent:) y:)
				)
				(self setScript: egoWalk)
			else
				(= local9 1)
				(gEgo
					setMotion:
						PolyPath
						((User curEvent:) x:)
						((User curEvent:) y:)
				)
				(self setScript: chiefStir)
			)
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(LoadMany 0 57 13 939)
		(super dispose: &rest)
	)
)

(instance chiefStir of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(chief setCycle: Beg self)
				(gEgo setMotion: 0)
			)
			(1
				(gMessager say: 1 2 8 0 self) ; "Nice going. It turns out that the Chief is a light sleeper and all your tromping around has woken him."
			)
			(2
				(HandsOn)
				(= local5 0)
				(self dispose:)
			)
		)
	)
)

(instance castFetch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 130 140 self)
			)
			(1
				(Face gEgo chest self)
			)
			(2
				(gEgo view: 14 setLoop: 1 cel: 0 setCycle: End self)
			)
			(3
				(spell
					view: 21
					x: (- (gEgo x:) 5)
					y: (- (gEgo y:) 30)
					moveSpeed: 1
					cycleSpeed: 1
					setStep: 10 5
					setLoop: 7
					setCycle: Walk
					setMotion: MoveTo 67 137 self
					show:
				)
			)
			(4
				(spell setMotion: MoveTo (gEgo x:) (- (gEgo y:) 30) self)
			)
			(5
				(spell hide:)
				(= cycles 3)
			)
			(6
				(gEgo normalize: changeGait: 2 0) ; sneaking
				(if local10
					(gMessager say: 3 6 18 0 self) ; "You already got a dagger and 8 royals, and there is nothing left you want to take."
				else
					(= local10 1)
					(gMessager say: 3 4 0 0 self) ; "You find some strange-looking, glowing skulls, a necklace made from claws covered with a slimy, green goo, and a throwing dagger. There are also eight royals strung onto a necklace. You take the dagger and the royals."
				)
			)
			(7
				(gEgo get: 10 1) ; theDaggers
				(gEgo get: 0 8) ; theRoyals
				(= local10 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance noEscape of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 1 2 1 0 self) ; "Aren't you forgetting the thing you came in here for?"
			)
			(1
				(gEgo setMotion: PolyPath 80 129 self)
			)
			(2
				(HandsOn)
				(= local4 0)
				(self dispose:)
			)
		)
	)
)

(instance egoWalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(chief startUpd: setCycle: End self)
			)
			(1
				(= seconds 1)
			)
			(2
				(chief
					x: 249
					y: 176
					cel: 0
					setLoop: 1
					cycleSpeed: 10
					setCycle: CT 5 1 self
				)
			)
			(3
				(Palette palSET_INTENSITY 0 255 1000)
				(= cycles 2)
			)
			(4
				(Palette palSET_INTENSITY 0 255 100)
				(= cycles 1)
			)
			(5
				(spell dispose:)
				(gEgo view: 43 setLoop: 2 setCycle: End self)
			)
			(6
				(switch local8
					(1
						(EgoDead 8) ; "You've just learned a couple of basic rules of Thievery (a little too late) -- "Dumb moves are dead giveaways" and "Ya gotta use stealth if ya wanna get wealth"."
					)
					(2
						(EgoDead 9) ; "Ya hadn't oughta ignore an ape. It was a matter of, "Monkey see- monkey do ya in.""
					)
					(3
						(EgoDead 10) ; "That mask made you see red, and now you are dead."
					)
					(4
						(EgoDead 2) ; "My, the Chief is sure touchy."
					)
					(5
						(EgoDead 6) ; "Sounds like the chest is a snitch. Ya gotta be pretty slick to slide out of this situation and it looks like ya just slipped up."
					)
					(6
						(EgoDead 7) ; "Looks like you didn't pick a timely moment to discuss things with this man. Guess you just clocked out."
					)
					(7
						(EgoDead 14) ; "As you started to throw your dagger, you found yourself paralyzed by a spell. Then your arm bends back against your will and you find yourself slitting your own throat. What will those clever Wizards think of next?"
					)
				)
			)
		)
	)
)

(instance enterHut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 80 129 self)
			)
			(1
				(gEgo code: monkeyCheck)
				(= local0 1)
				(= local4 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance monkeyWay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(monkey cue:)
				(gEgo code: normCode)
				(= cycles 1)
			)
			(1
				(sFx number: 929 setLoop: -1 play:)
				(= seconds 10)
			)
			(2
				(if local2
					(self dispose:)
				else
					(HandsOff)
					(= local8 2)
					(gCurRoom setScript: egoWalk)
				)
			)
		)
	)
)

(instance monkeyOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(monkeyWay dispose:)
				(sFx number: 481 play:)
				(gMessager say: 7 6 15 0 self) ; "You open the cage and let the monkey go."
			)
			(1
				(monkey
					setLoop: 1
					setCycle: End
					cycleSpeed: 4
					moveSpeed: 2
					setMotion: JumpX (+ (monkey x:) 25) 12 self
				)
			)
			(2
				(monkey setCycle: 0 setMotion: JumpX -45 self)
			)
			(3
				(monkey
					setPri: 15
					cycleSpeed: 2
					setLoop: 3
					setCycle: Fwd
					setMotion: MoveTo (- (gEgo x:) 10) 91 self
				)
			)
			(4
				(monkey setPri: 2 setMotion: MoveTo 54 75 self)
			)
			(5
				(gEgo addHonor: 20)
				(monkey dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance castOpenMonkey of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(monkeyWay dispose:)
				(gEgo setMotion: PolyPath 192 153 self)
			)
			(1
				(Face gEgo monkey self)
			)
			(2
				(gEgo view: 15 setLoop: 3 setCycle: End self)
			)
			(3
				(monkey
					setLoop: 1
					setCycle: End
					cycleSpeed: 4
					moveSpeed: 2
					setMotion: JumpX (+ (monkey x:) 25) 12 self
				)
			)
			(4
				(monkey setCycle: 0 setMotion: JumpX -45 self)
			)
			(5
				(monkey
					setPri: 15
					cycleSpeed: 2
					setLoop: 3
					setCycle: Fwd
					setMotion: MoveTo (monkey x:) 91 self
				)
			)
			(6
				(monkey setPri: 2 setMotion: MoveTo 54 75 self)
			)
			(7
				(gEgo changeGait: 2 0 normalize:) ; sneaking
				(gEgo addHonor: 20)
				(monkey dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance turnChief of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(chief setCycle: End self)
			)
			(1
				(= seconds 2)
			)
			(2
				(chief setCycle: CT 0 -1 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance castOpenOnChest of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 130 140 self)
			)
			(1
				(Face gEgo chest self)
			)
			(2
				(gEgo view: 15 setLoop: 1 setCycle: End self)
			)
			(3
				(gEgo changeGait: 2 0 normalize:) ; sneaking
				(cond
					((not local6)
						(= local6 1)
						(if (not local3)
							(chief setScript: turnChief)
							(gMessager say: 3 6 5) ; "You hear a click of a lock opening and a slight squeak of the hinges."
						else
							(= cycles 1)
						)
					)
					((not local3)
						(= local8 5)
						(chest cel: 1)
						(gCurRoom setScript: egoBack)
					)
					(else
						(chest cel: 1)
						(= local7 1)
					)
				)
				(= cycles 5)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setCycle: Rev
					setLoop: 1
					setMotion: PolyPath (+ (gEgo x:) 15) (gEgo y:) self
				)
			)
			(1
				(gEgo normalize:)
				(gCurRoom setScript: egoWalk)
			)
		)
	)
)

(instance gripSpear of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 181 135 self)
			)
			(1
				(gEgo view: 31 loop: 0 setCycle: CT 2 1 self)
			)
			(2
				(gEgo setCycle: Beg self)
				(spear dispose:)
			)
			(3
				(gEgo
					view: 2
					setCycle: Walk
					changeGait: 2 0 ; sneaking
					get: 45 ; theMagicSpear
					addHonor: -50
					solvePuzzle: 304 10 4
				)
				(gMessager say: 1 6 13 0 self) ; "You carefully retrieve the Spear of Death."
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoTouch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 31 loop: 0 setCycle: End self)
				(gLongSong3 number: 641 play: setLoop: 1)
				(gCurRoom setScript: egoWalk)
			)
			(1
				(gEgo changeGait: 2 0 normalize:) ; sneaking
				(= cycles 1)
			)
			(2
				(gEgo
					setCycle: Rev
					setLoop: 0
					setMotion:
						MoveTo
						(- (gEgo x:) 25)
						(+ (gEgo y:) 5)
						self
				)
			)
			(3
				(gEgo normalize:)
				(= local8 3)
				(self dispose:)
			)
		)
	)
)

(instance openChest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 78 152 self)
			)
			(1
				(gMessager say: 3 6 2 0 self) ; "The lid of the chest does not open. You figure it might be locked."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance getChest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 78 152 self)
			)
			(1
				(gEgo
					view: 4
					loop: 1
					cel: 0
					setCycle: CT (if local10 1 else 3) 1 self
				)
				(if (not local7)
					(chest cel: 1)
				)
			)
			(2
				(if (not local3)
					(= local8 5)
					(gCurRoom setScript: egoBack)
				else
					(self cue:)
				)
			)
			(3
				(gEgo setCycle: CT 0 -1 self)
			)
			(4
				(gEgo normalize: changeGait: 2 0) ; sneaking
				(if local10
					(gMessager say: 3 6 18 0 self) ; "You already got a dagger and 8 royals, and there is nothing left you want to take."
				else
					(gMessager say: 3 4 0 0 self) ; "You find some strange-looking, glowing skulls, a necklace made from claws covered with a slimy, green goo, and a throwing dagger. There are also eight royals strung onto a necklace. You take the dagger and the royals."
				)
			)
			(5
				(gEgo get: 10 1) ; theDaggers
				(gEgo get: 0 8) ; theRoyals
				(= local10 1)
				(self dispose:)
			)
		)
	)
)

(instance pickLock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 78 152 self)
			)
			(1
				(Face gEgo chest)
				(= cycles (+ (gEgo cycleSpeed:) 5))
			)
			(2
				(cond
					((not local6)
						(gEgo useSkill: 9 200) ; pick locks
						(= local6 1)
						(if (not local3)
							(chief setScript: turnChief)
							(gMessager say: 3 6 3) ; "You hear a click as your pick tricks the lock, and a slight squeak of the hinges of the chest."
						else
							(gMessager say: 3 6 20) ; "You picked the lock on the chest."
						)
					)
					((not local3)
						(= local8 5)
						(gCurRoom setScript: egoBack)
					)
					(else
						(chest cel: 1)
						(= local7 1)
					)
				)
				(= cycles 5)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance oilChest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 78 152 self)
			)
			(1
				(gEgo view: 4 loop: 1 cel: 0 setCycle: CT 3 1 self)
			)
			(2
				(gEgo setCycle: CT 0 -1 self)
			)
			(3
				(gEgo changeGait: 2 0 normalize:) ; sneaking
				(gMessager say: 3 6 6 0 self) ; "You put oil on the hinges of the chest."
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance monkeyCheck of Code
	(properties)

	(method (doit)
		(cond
			((and (& (gEgo onControl:) $0010) (not local4))
				(= local4 1)
				(if (gEgo has: 45) ; theMagicSpear
					(gCurRoom newRoom: 630)
				else
					(gCurRoom setScript: noEscape)
				)
			)
			((and (> (gEgo x:) 110) (& local0 $0001) (not local2))
				(= local0 2)
				(monkey setScript: monkeyWay)
			)
		)
	)
)

(instance normCode of Code
	(properties)

	(method (doit)
		(if (and (& (gEgo onControl:) $0010) (not local4))
			(= local4 1)
			(if (gEgo has: 45) ; theMagicSpear
				(gCurRoom newRoom: 630)
			else
				(gCurRoom setScript: noEscape)
			)
		)
	)
)

(instance chief of Actor
	(properties
		x 258
		y 173
		z 30
		noun 14
		approachX 212
		approachY 146
		view 641
		signal 4096
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun 1 0) ; "You see a sleeping Leopardman."
			)
			(4 ; Do
				(= local8 4)
				(gEgo
					setLoop: 1
					setMotion: PolyPath (- (gEgo x:) 65) (gEgo y:)
				)
				(gCurRoom setScript: egoWalk)
			)
			(2 ; Talk
				(= local8 6)
				(gEgo
					setLoop: 1
					setMotion: PolyPath (- (gEgo x:) 65) (gEgo y:)
				)
				(gCurRoom setScript: egoWalk)
			)
			(20 ; theDaggers
				(= local8 7)
				(gCurRoom setScript: egoWalk)
			)
			(82 ; fetchSpell
				(= local8 4)
				(gCurRoom setScript: egoWalk)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance monkey of Actor
	(properties
		x 137
		y 91
		noun 15
		approachX 137
		approachY 133
		view 645
	)

	(method (cue)
		(self setCycle: OccasionalCycle self 1 10 50)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29 ; theFruit
				(= local2 1)
				(if (not local1)
					(= local1 1)
					(gEgo solvePuzzle: 302 5 4)
					(gMessager say: 7 6 16) ; "You give some of your fruit to the hungry monkey."
					(if (& local0 $0002)
						(monkey setCycle: 0)
					)
				)
			)
			(4 ; Do
				(= local2 1)
				(if (not (IsFlag 90))
					(SetFlag 90)
					(gEgo solvePuzzle: 303 5 4)
					(gCurRoom setScript: monkeyOut)
				else
					(super doVerb: theVerb)
				)
			)
			(75 ; openSpell
				(= local2 1)
				(if (not (IsFlag 90))
					(SetFlag 90)
					(gCurRoom setScript: castOpenMonkey)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance spell of Actor
	(properties
		x 240
		y 128
		view 21
		signal 16384
	)
)

(instance spear of Prop
	(properties
		x 193
		y 133
		noun 5
		approachX 196
		approachY 128
		view 640
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: gripSpear)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance chest of View
	(properties
		x 75
		y 138
		noun 3
		view 640
		priority 10
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not local6)
					(gCurRoom setScript: openChest)
				else
					(gCurRoom setScript: getChest)
				)
			)
			(75 ; openSpell
				(if local7
					(gMessager say: 1 6 11) ; "The chest is already unlocked."
				else
					(gCurRoom setScript: castOpenOnChest)
				)
			)
			(17 ; theToolkit
				(if local6
					(gMessager say: 1 6 19) ; "You don't need to pick an unlocked chest."
				else
					(gCurRoom setScript: pickLock)
				)
			)
			(35 ; theOil
				(if local7
					(gMessager say: 1 6 12) ; "You don't need to oil the chest once it has been opened."
				else
					(= local3 1)
					(gCurRoom setScript: oilChest)
				)
			)
			(82 ; fetchSpell
				(if local7
					(gCurRoom setScript: castFetch)
				else
					(gMessager say: 1 6 21) ; "You cannot fetch the chest."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance masK of Feature
	(properties
		x 229
		y 95
		noun 2
		onMeCheck 8
		approachX 206
		approachY 125
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(HandsOff)
				(gEgo setScript: egoTouch)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance skull of Feature
	(properties
		x 49
		y 80
		noun 8
		nsTop 66
		nsLeft 37
		nsBottom 95
		nsRight 61
	)
)

(instance skulls of Feature
	(properties
		x 90
		y 45
		noun 9
		nsTop 39
		nsLeft 80
		nsBottom 52
		nsRight 101
	)
)

(instance table of Feature
	(properties
		x 96
		y 161
		noun 10
		nsTop 153
		nsLeft 45
		nsBottom 169
		nsRight 148
	)
)

(instance bed of Feature
	(properties
		x 246
		y 145
		noun 11
		nsTop 134
		nsLeft 212
		nsBottom 156
		nsRight 281
		approachX 212
		approachY 146
	)

	(method (doVerb theVerb)
		(if (or (== theVerb 4) (== theVerb 2)) ; Do, Talk
			(chief doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance hole of Feature
	(properties
		x 182
		y 107
		noun 12
		nsTop 97
		nsLeft 165
		nsBottom 118
		nsRight 199
	)
)

(instance skin of Feature
	(properties
		x 218
		y 67
		noun 13
		nsTop 47
		nsLeft 182
		nsBottom 88
		nsRight 254
	)
)

(instance sFx of Sound
	(properties)
)

