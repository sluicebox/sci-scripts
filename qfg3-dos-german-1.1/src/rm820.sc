;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 820)
(include sci.sh)
(use Main)
(use TargFeature)
(use n026)
(use GloryTalker)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm820 0
	demonaTalker 1
)

(local
	local0 = 1
	local1 = 1
	local2
	local3
	local4
)

(instance rm820 of Rm
	(properties
		noun 3
		picture 820
		vanishingY -20
	)

	(method (init)
		(LoadMany rsVIEW 820 821 822)
		(gEgo x: 122 y: 41 setScale: 150 normalize:)
		(HandsOn)
		(super init:)
		(gLongSong number: 820 setLoop: -1 play: 127)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 225 36 218 43 148 36 37 70 32 81 9 82 3 92 3 186 115 186 83 173 57 152 51 134 56 115 68 95 52 87 73 74 88 79 140 56 187 62 236 66 282 71 316 58 316 50 231 44 237 38
					yourself:
				)
		)
		(brazier init:)
		(brazier2 init:)
		(brazier3 init:)
		(brazier4 init:)
		(doorWay init:)
		(stairs init:)
		(floor init:)
		(visage init:)
		(flame1 setCycle: Fwd init:)
		(flame2 setPri: 6 setCycle: Fwd init:)
		(flame3 setPri: 3 setCycle: Fwd init:)
		(flame4 setPri: 5 setCycle: Fwd init:)
		(door ignoreActors: 0 init:)
		(cond
			((not (== gPrevRoomNum 550)) ; combatRm
				(frac init: stopUpd:)
				(fric init: stopUpd:)
				(if (== gHeroType 2) ; Thief
					(gEgo code: thiefGaitChek)
				else
					(gEgo code: demonTurnChek)
				)
				(gCurRoom setScript: egoEnters)
			)
			((and (== gPrevRoomNum 550) (== global155 0)) ; combatRm
				(fric init: stopUpd:)
				(gCurRoom setScript: knockEmDead)
			)
			((and (== gPrevRoomNum 550) (not (== global155 0))) ; combatRm
				(fric x: 156 y: 67 view: 824 signal: 1 init:)
				(gEgo x: 212 y: 61 init: solvePuzzle: 335 7 9)
				(gCurRoom setScript: afterFight)
			)
			(else
				(gCurRoom setScript: egoEnters)
			)
		)
		(if (and (== gHeroType 3) (> (gEgo trySkill: 4 100) 0)) ; Paladin, luck
			(gMessager say: 1 6 1) ; "There is no place to run to get away from this Demon."
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(65 ; Rest
				(gMessager say: 1 6 9) ; "You can't sleep here. The Demons would slit you from guggle to zatch."
			)
			(80 ; calmSpell
				(self setScript: castCalm)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(gEgo code: 0)
		(if gList
			(gList eachElementDo: #dispose)
		)
		(UnLoad 128 820)
		(UnLoad 128 821)
		(UnLoad 128 822)
		(super dispose: &rest)
	)
)

(instance closeCombat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 2)
			)
			(1
				(= global156 320)
				(= global365 845)
				(gCurRoom newRoom: 550) ; combatRm
			)
		)
	)
)

(instance lubeLock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 230 40 self)
			)
			(1
				(gEgo solvePuzzle: 332 5 4)
				(gMessager say: 4 35 0 0 self) ; "You carefully lubricate the door hinges with some oil (just as it said to do in the last issue of the "Lockpicker's Log")."
			)
			(2
				(= local0 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance afterFight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(if (== global155 0)
					(EgoDead) ; "It's all over for now. Please try again."
				else
					(self cue:)
				)
			)
			(2
				(gLongSong2 number: 931 setLoop: 1 play: 127)
				(= local1 0)
				(= local0 0)
				(= local3 1)
			)
		)
	)
)

(instance demonsDissolve of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(fric dispose:)
				(DrawPic (gCurRoom picture:) 9)
				(= cycles 4)
			)
			(2
				(= local1 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance castCalm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(self setScript: (ScriptID 12 0) self) ; castAreaScript
			)
			(1
				(gMessager say: 3 80 0 0 self) ; "The Demons yawn and look stupid."
			)
			(2
				(= local1 0)
				(gEgo solvePuzzle: 333 6 2 code: 0)
				(self dispose:)
			)
		)
	)
)

(instance demonsTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fric setCycle: End self)
			)
			(1
				(gMessager say: 2 6 3 0 self) ; "Dis gets real boring, ya know dat, Frak?"
			)
			(2
				(fric setCycle: Beg self)
			)
			(3
				(frac setCycle: End self)
			)
			(4
				(frac setCycle: Beg)
				(self dispose:)
			)
		)
	)
)

(instance demonsTurn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 2 6 5 0 self) ; "Did dat sound like a noise ta you? It sounded like a noise ta me."
			)
			(1
				(fric loop: 2 setCycle: End)
				(frac loop: 3 setCycle: End self)
			)
			(2
				(gMessager say: 2 6 6 0 self) ; "Well, wadda ya know? It was da door! And looky, I gots a human to crush, kill, destroy. You go gets da guys while I gets de guts. It's clobberin' time!"
			)
			(3
				(= global365 845)
				(gCurRoom newRoom: 550) ; combatRm
			)
		)
	)
)

(instance tryToPickLock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 230 40 self)
			)
			(1
				(if local3
					(gMessager say: 4 17 12 0 self) ; "The door is already unlocked."
				else
					(gEgo useSkill: 9 200) ; pick locks
					(= local3 1)
					(gMessager say: 4 17 11) ; "You deftly pick the lock."
					(HandsOn)
					(self dispose:)
				)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance castOpenOnDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(proc0_14 235 20)
				(self setScript: (ScriptID 13 0) self) ; castOpenScript
			)
			(1
				(gEgo solvePuzzle: 334 4 2)
				(gMessager say: 4 75 0 0 self) ; "Your spell does the trick, you hear a click."
			)
			(2
				(= local3 1)
				(= local0 0)
				(HandsOn)
				(gEgo normalize:)
				(self dispose:)
			)
		)
	)
)

(instance hearNoise of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local2
					(gMessager say: 2 6 8 0 self) ; "Hey, watta ya doing there?"
				else
					(gMessager say: 2 6 7 0 self) ; "Boring. Boring. Boring. Dis job is da pits. Da prisoner never tries ta excape since da last time I beat it up, and nobody gets past da guards below ta get ta us. I tell ya, it's boring."
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance messWithDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 230 40 self)
			)
			(1
				(cond
					((== local1 1)
						(fric setScript: demonsTurn)
					)
					((== local3 0)
						(gMessager say: 4 4 10) ; "The door is locked."
						(HandsOn)
						(self dispose:)
					)
					((== local0 1)
						(fric setScript: demonsTurn)
					)
					(else
						(if (gCast contains: frac)
							(= local2 0)
							(self setScript: hearNoise self)
						)
						(= cycles 1)
					)
				)
			)
			(2
				(door setCycle: End self ignoreActors: 1)
				(gLongSong2 number: 821 setLoop: 1 play:)
			)
			(3
				(gEgo setMotion: MoveTo 230 30 self)
			)
			(4
				(if (not local4)
					(gEgo solvePuzzle: 331 5 4)
				)
				(gCurRoom newRoom: 830)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(secretDoor init: setCycle: End self)
				(gLongSong2 number: 8 setLoop: 1 play: 127)
			)
			(1
				(gEgo init: setMotion: MoveTo 129 51 self)
			)
			(2
				(fric setScript: demonsTalk self)
			)
			(3
				(secretDoor setCycle: Beg self)
			)
			(4
				(if (IsFlag 150)
					(gMessager say: 1 6 2 0 self) ; "You are filled with a sense of danger and a definite hint of Demonic presence."
				else
					(self cue:)
				)
			)
			(5
				(secretDoor dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance theyAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 2 6 4 0 self) ; "Hey, watta ya know? It's my lucky day. You go warn da guys about dis. I'll tear dis human to shreds!"
			)
			(1
				(= global365 845)
				(gCurRoom newRoom: 550) ; combatRm
			)
		)
	)
)

(instance knockEmDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 1)
			)
			(1
				(EgoDead) ; "It's all over for now. Please try again."
			)
		)
	)
)

(instance flame1 of Prop
	(properties
		x 20
		y 43
		view 820
		loop 2
		signal 16384
		detailLevel 3
	)
)

(instance flame2 of Prop
	(properties
		x 74
		y 53
		view 820
		loop 2
		cel 2
		signal 16384
		detailLevel 3
	)
)

(instance flame3 of Prop
	(properties
		x 157
		y 33
		view 820
		loop 2
		cel 1
		signal 16384
		detailLevel 3
	)
)

(instance flame4 of Prop
	(properties
		x 258
		y 44
		view 820
		loop 2
		cel 4
		signal 16384
		detailLevel 3
	)
)

(instance secretDoor of Prop
	(properties
		x 122
		y 42
		noun 12
		view 820
		signal 16384
	)
)

(instance door of Prop
	(properties
		x 222
		y 35
		noun 4
		view 820
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo setScript: messWithDoor)
			)
			(75 ; openSpell
				(gEgo setScript: castOpenOnDoor)
			)
			(35 ; theOil
				(gEgo setScript: lubeLock)
			)
			(17 ; theToolkit
				(gEgo setScript: tryToPickLock)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fric of TargProp
	(properties
		x 154
		y 103
		noun 2
		view 821
		signal 16384
	)

	(method (getHurt)
		(gCurRoom setScript: closeCombat)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (== gPrevRoomNum 550)) ; combatRm
					(gCurRoom setScript: theyAttack)
				else
					(gMessager say: 1 6 13) ; "Now, that's one dead demon!"
				)
			)
			(20 ; theDaggers
				(if (not (gCurRoom script:))
					(gCurRoom setScript: (ScriptID 32 0) 0 theVerb) ; project
				)
			)
			(81 ; flameDartSpell
				(if (not (gCurRoom script:))
					(gCurRoom setScript: (ScriptID 32 0) 0 theVerb) ; project
				)
			)
			(88 ; lightningBallSpell
				(if (not (gCurRoom script:))
					(gCurRoom setScript: (ScriptID 32 0) 0 theVerb) ; project
				)
			)
			(83 ; forceBoltSpell
				(if (not (gCurRoom script:))
					(gCurRoom setScript: (ScriptID 32 0) 0 theVerb) ; project
				)
			)
			(33 ; theRocks
				(if (not (gCurRoom script:))
					(gCurRoom setScript: (ScriptID 32 0) 0 theVerb) ; project
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance frac of TargProp
	(properties
		x 193
		y 110
		noun 13
		view 821
		loop 1
		signal 16384
	)

	(method (getHurt)
		(gCurRoom setScript: closeCombat)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (== gPrevRoomNum 550)) ; combatRm
					(gCurRoom setScript: theyAttack)
				else
					(gMessager say: 1 6 13) ; "Now, that's one dead demon!"
				)
			)
			(20 ; theDaggers
				(if (not (gCurRoom script:))
					(gCurRoom setScript: (ScriptID 32 0) 0 theVerb) ; project
				)
			)
			(81 ; flameDartSpell
				(if (not (gCurRoom script:))
					(gCurRoom setScript: (ScriptID 32 0) 0 theVerb) ; project
				)
			)
			(88 ; lightningBallSpell
				(if (not (gCurRoom script:))
					(gCurRoom setScript: (ScriptID 32 0) 0 theVerb) ; project
				)
			)
			(83 ; forceBoltSpell
				(if (not (gCurRoom script:))
					(gCurRoom setScript: (ScriptID 32 0) 0 theVerb) ; project
				)
			)
			(33 ; theRocks
				(if (not (gCurRoom script:))
					(gCurRoom setScript: (ScriptID 32 0) 0 theVerb) ; project
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance demonaTalker of GloryTalker
	(properties
		x 10
		y 10
		view 822
		loop 1
		talkWidth 260
		back 57
		textX 15
		textY 100
		backColor 42
	)

	(method (init)
		(super init: demonaBust demonaEyes demonaMouth &rest)
	)
)

(instance demonaMouth of Prop
	(properties
		nsTop 31
		nsLeft 60
		view 822
	)
)

(instance demonaEyes of Prop
	(properties
		nsTop 24
		nsLeft 49
		view 822
		loop 2
	)
)

(instance demonaBust of View
	(properties
		nsTop 14
		nsLeft 53
		view 822
		loop 3
	)
)

(instance brazier of Feature
	(properties
		x 23
		y 58
		noun 5
		nsTop 45
		nsLeft 14
		nsBottom 71
		nsRight 33
		sightAngle 180
	)
)

(instance brazier2 of Feature
	(properties
		x 76
		y 64
		noun 6
		nsTop 48
		nsLeft 67
		nsBottom 81
		nsRight 86
		sightAngle 180
	)
)

(instance brazier3 of Feature
	(properties
		x 158
		y 42
		noun 7
		nsTop 34
		nsLeft 149
		nsBottom 51
		nsRight 168
		sightAngle 180
	)
)

(instance brazier4 of Feature
	(properties
		x 260
		y 56
		noun 8
		nsTop 47
		nsLeft 251
		nsBottom 66
		nsRight 269
		sightAngle 180
	)
)

(instance doorWay of Feature
	(properties
		x 229
		y 21
		noun 9
		nsTop 1
		nsLeft 205
		nsBottom 41
		nsRight 254
		sightAngle 180
	)
)

(instance floor of Feature
	(properties
		x 189
		y 155
		noun 10
		nsTop 134
		nsLeft 148
		nsBottom 177
		nsRight 230
		sightAngle 180
	)
)

(instance stairs of Feature
	(properties
		x 44
		y 136
		noun 11
		nsTop 84
		nsBottom 189
		nsRight 88
		sightAngle 180
	)
)

(instance visage of Feature
	(properties
		x 291
		y 145
		noun 14
		nsTop 114
		nsLeft 270
		nsBottom 177
		nsRight 313
		sightAngle 180
	)
)

(instance thiefGaitChek of Code
	(properties)

	(method (doit)
		(if (== gEgoGait 2) ; sneaking
			(= local1 0)
		else
			(= local1 1)
		)
		(if
			(and
				(not (gCurRoom script:))
				(== local1 1)
				(gEgo inRect: 180 20 200 80)
			)
			(= local4 1)
			(gCurRoom setScript: demonsTurn)
		)
	)
)

(instance demonTurnChek of Code
	(properties)

	(method (doit)
		(if
			(and
				(not (gCurRoom script:))
				(== local1 1)
				(or
					(gEgo inRect: 180 20 200 80)
					(gEgo inRect: 0 80 135 189)
				)
			)
			(gCurRoom setScript: demonsTurn)
		)
	)
)

