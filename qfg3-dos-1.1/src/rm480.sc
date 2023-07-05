;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 480)
(include sci.sh)
(use Main)
(use Teller)
(use OccasionalCycle)
(use PAvoider)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Rev)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm480 0
)

(local
	local0
	local1
	local2
	[local3 7] = [0 -30 -72 68 -41 28 999]
	[local10 2]
	[local12 6] = [0 2 -3 -4 9 999]
	[local18 5] = [0 5 6 -7 999]
	[local23 3] = [0 8 999]
	[local26 4] = [0 -4 -7 999]
	[local30 6] = [0 -75 -11 14 15 999]
	[local36 3] = [0 12 999]
	[local39 3] = [0 -11 999]
	[local42 6] = [0 -75 19 18 17 999]
	[local48 6] = [0 23 24 22 21 999]
	[local54 5] = [0 26 -27 29 999]
	[local59 3] = [0 28 999]
	[local62 3] = [0 -27 999]
	[local65 4]
	[local69 7] = [0 -31 -33 -35 39 40 999]
	[local76 3] = [0 32 999]
	[local79 3] = [0 34 999]
	[local82 3] = [0 -73 999]
	[local85 5] = [0 -31 -33 -35 999]
	[local90 5]
	[local95 5] = [0 -40 -76 -77 999]
	[local100 2]
	[local102 5] = [0 -23 -24 -78 999]
	[local107 2]
	[local109 6] = [0 45 46 47 28 999]
	[local115 6] = [0 57 58 -59 60 999]
	[local121 2]
)

(procedure (localproc_0)
	(gCurRoom
		addObstacle:
			((Polygon new:) type: PBarredAccess init: 57 141 4 141 14 118 69 118 yourself:)
	)
	(gEgo normalize: x: 173 y: 144 setScale: 200 setHeading: 0 init:)
	(switch global401
		(1
			(= [local65 0] @local12)
			(= [local65 1] @local18)
			(= [local65 2] @local23)
			(yesufuTeller init: (ScriptID 39 1) @local12 @local65 @local26) ; Yesufu
		)
		(3
			(= [local65 0] @local30)
			(= [local65 1] @local36)
			(yesufuTeller init: (ScriptID 39 1) @local30 @local65 @local39) ; Yesufu
		)
		(4
			(= [local65 0] @local42)
			(yesufuTeller init: (ScriptID 39 1) @local42 @local65) ; Yesufu
		)
	)
	((ScriptID 39 1) ; Yesufu
		view: 982
		loop: 0
		cel: 0
		x: 137
		y: 121
		noun: 6
		setScale: 200
		actions: yesufuTeller
		approachVerbs: 2 ; Talk
		ignoreActors: 1
		approachX: 109
		approachY: 137
		init:
	)
	(yesufuArm setPri: 8 setScale: 200 ignoreActors: 1 init:)
	(HandsOn)
)

(instance rm480 of Rm
	(properties
		noun 1
		picture 480
		vanishingY -300
	)

	(method (init)
		(HandsOff)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 160 293 154 264 157 235 157 190 150 167 143 110 143 110 110 198 110 230 116 266 109 235 104 209 106 151 102 159 96 206 96 208 91 137 88 85 87 0 87 0 0 319 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 247 189 266 185 311 184 319 189
					yourself:
				)
		)
		(awari approachVerbs: 4 init:) ; Do
		(cageDoor approachVerbs: 4 stopUpd: init:) ; Do
		(theCage approachVerbs: 4 init:) ; Do
		(fence init:)
		(tree1 init:)
		(tree2 init:)
		(rock1 init:)
		(rock2 init:)
		(mountain init:)
		(littleRock1 init:)
		(littleRock2 init:)
		(switch gHeroType
			(0 ; Fighter
				(if (and (not (IsFlag 29)) (IsFlag 64))
					(SetFlag 29)
				)
			)
			(1 ; Magic User
				(if
					(and
						(not (IsFlag 29))
						(or (gEgo has: 44) [gEgoStats 31]) ; theWood, summonStaffSpell
					)
					(SetFlag 29)
				)
			)
			(2 ; Thief
				(if (and (not (IsFlag 29)) (IsFlag 63))
					(SetFlag 29)
				)
			)
			(3 ; Paladin
				(if (and (not (IsFlag 29)) (IsFlag 64))
					(SetFlag 29)
				)
			)
		)
		(if (and (IsFlag 29) (not (IsFlag 65)))
			(gLongSong number: 480 setLoop: -1 play: 127)
			(if (not (IsFlag 62))
				(SetFlag 62)
				(= global400 (- gDay 1))
			)
			(= [local100 0] @local95)
			(johariTeller init: (ScriptID 36 1) @local95 @local100) ; Johari
			(if (IsFlag 38)
				((ScriptID 36 1) ; Johari
					view: 483
					setLoop: 0
					x: 33
					y: 127
					noun: 10
					actions: johariTeller
					approachVerbs: 1 30 12 43 26 ; Look, theBeads, theFineDagger, theLeopard, theDispell
					approachX: 24
					approachY: 146
					approachDist: 0
					setCycle: OccasionalCycle self 1 65 150
					init:
				)
				((ScriptID 36 0) x: 195 textY: 0 talkWidth: 130) ; johariTalker
			else
				((ScriptID 36 1) ; Johari
					view: 481
					loop: 1
					x: 33
					y: 132
					noun: 11
					approachVerbs: 1 30 12 43 26 ; Look, theBeads, theFineDagger, theLeopard, theDispell
					approachX: 24
					approachY: 146
					approachDist: 0
					actions: johariTeller
					setCycle: OccasionalCycle self 1 65 150
					init:
				)
				(johariHands init:)
			)
			(if
				(and
					(< global401 11)
					(IsFlag 29)
					(not (IsFlag 65))
					(or gNight (== global400 gDay))
					(not (IsFlag 129))
				)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 68 117 52 142 25 142 25 146 34 146 34 154 0 154 0 117
							yourself:
						)
				)
				(= [local107 0] @local102)
				(guardTeller init: guard @local102 @local107)
				(guard setScale: 200 init:)
				(if
					(and
						(< global401 5)
						(== global400 gDay)
						(not (IsFlag 38))
					)
					(= global401 5)
				)
			)
		)
		(cond
			((== gPrevRoomNum 490)
				(localproc_0)
			)
			((== gPrevRoomNum 485)
				(gEgo x: 24 y: 146 setHeading: 0 setMotion: 0)
				(if (IsFlag 129)
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 0 122 71 122 53 140 20 140 15 144 0 144
								yourself:
							)
					)
					(= [local121 0] @local109)
					(uhuraTeller init: (ScriptID 34 1) @local109 @local121) ; Uhura
					((ScriptID 34 1) ; Uhura
						view: 969
						loop: 0
						x: 7
						y: 141
						noun: 9
						setScale: 200
						stopUpd:
						init:
					)
				)
				(gCurRoom setScript: from485)
			)
			((and (== global392 4) (== global400 gDay) (not (IsFlag 65)))
				(= global401 10)
			)
			(
				(and
					(not (IsFlag 65))
					(== global392 4)
					(!= global400 gDay)
					(not gNight)
				)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 122 71 122 53 140 20 140 15 144 0 144
							yourself:
						)
				)
				(= global400 gDay)
				(= global401 9)
				(= [local121 0] @local115)
				(uhuraTeller init: (ScriptID 34 1) @local115 @local121) ; Uhura
				((ScriptID 34 1) ; Uhura
					view: 969
					loop: 0
					x: 7
					y: 141
					setScale: 200
					noun: 9
					stopUpd:
					init:
				)
				(gEgo setScript: uhuraGreet)
			)
			(
				(and
					(or (== global401 7) (== global401 8))
					(!= global400 gDay)
					(not gNight)
					(not (IsFlag 65))
				)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 95 133 59 133 53 141 4 141 14 118 95 118
							yourself:
						)
				)
				(= global400 gDay)
				(= global401 8)
				(= [local65 0] @local54)
				(= [local65 1] @local59)
				(yesufuTeller init: (ScriptID 39 1) @local54 @local65 @local62) ; Yesufu
				((ScriptID 39 1) ; Yesufu
					view: 989
					x: 80
					y: 130
					loop: 2
					noun: 6
					setScale: 200
					stopUpd:
					init:
				)
				(gEgo setScript: yesufuGreet)
			)
			(
				(and
					(== global401 5)
					(!= global400 gDay)
					(not gNight)
					(not (IsFlag 65))
					(not (IsFlag 38))
				)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 122 71 122 53 140 20 140 15 144 0 144
							yourself:
						)
				)
				(= global400 gDay)
				(= global401 6)
				(= [local121 0] @local109)
				(uhuraTeller init: (ScriptID 34 1) @local109 @local121) ; Uhura
				((ScriptID 34 1) ; Uhura
					view: 969
					x: 7
					y: 141
					noun: 9
					setScale: 200
					stopUpd:
					init:
				)
				(gEgo setScript: uhuraGreet)
			)
			(
				(and
					(IsFlag 29)
					(!= global400 gDay)
					(not gNight)
					(not (IsFlag 65))
					(not (IsFlag 38))
				)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 95 133 59 133 53 141 4 141 14 118 95 118
							yourself:
						)
				)
				(= global400 gDay)
				(= global401 5)
				(= [local65 0] @local48)
				(yesufuTeller init: (ScriptID 39 1) @local48 @local65) ; Yesufu
				((ScriptID 39 1) ; Yesufu
					x: 80
					y: 130
					noun: 6
					view: 989
					loop: 2
					setScale: 200
					stopUpd:
					init:
				)
				(gEgo setScript: yesufuGreet)
			)
			(
				(and
					(== global401 2)
					(!= global400 gDay)
					(not gNight)
					(not (IsFlag 29))
				)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 57 141 4 141 14 118 69 118
							yourself:
						)
				)
				(= global400 gDay)
				(= global401 3)
				(= [local65 0] @local30)
				(= [local65 1] @local36)
				(yesufuTeller init: (ScriptID 39 1) @local30 @local65 @local39) ; Yesufu
				((ScriptID 39 1) ; Yesufu
					view: 982
					loop: 0
					cel: 0
					x: 137
					y: 121
					setScale: 200
					noun: 6
					actions: yesufuTeller
					approachVerbs: 2 ; Talk
					ignoreActors: 1
					approachX: 109
					approachY: 137
					stopUpd:
					init:
				)
				(yesufuArm
					setPri: 8
					setScale: 200
					ignoreActors: 1
					stopUpd:
					init:
				)
				(gEgo setScript: yesufuGreet)
			)
			((and (== global401 1) (!= global400 gDay) (not gNight))
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 57 141 4 141 14 118 69 118
							yourself:
						)
				)
				(= global400 gDay)
				(= global401 2)
				(= [local90 0] @local69)
				(= [local90 1] @local76)
				(= [local90 2] @local79)
				(= [local90 3] @local82)
				(storyActions init: (ScriptID 53 1) @local69 @local90 @local85) ; StoryTeller
				((ScriptID 53 1) ; StoryTeller
					loop: 3
					cel: 0
					x: 160
					y: 142
					noun: 7
					actions: storyActions
					approachVerbs: 2 ; Talk
					approachX: 109
					approachY: 150
					setScale: 200
					stopUpd:
					init:
				)
				(gEgo setScript: storyTellGreet)
			)
			((and (not (IsFlag 62)) (not gNight))
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 57 141 4 141 14 118 69 118
							yourself:
						)
				)
				(= global400 gDay)
				(= [local65 0] @local12)
				(= [local65 1] @local18)
				(= [local65 2] @local23)
				(yesufuTeller init: (ScriptID 39 1) @local12 @local65 @local26) ; Yesufu
				((ScriptID 39 1) ; Yesufu
					view: 982
					loop: 0
					cel: 0
					x: 137
					y: 121
					noun: 6
					actions: yesufuTeller
					setScale: 200
					approachVerbs: 2 ; Talk
					approachX: 109
					approachY: 137
					ignoreActors: 1
					stopUpd:
					init:
				)
				(yesufuArm
					setPri: 8
					setScale: 200
					ignoreActors: 1
					stopUpd:
					init:
				)
				(gEgo setScript: yesufuGreet)
				(SetFlag 62)
				(= global401 1)
			)
			((and (!= global400 gDay) (not gNight) (not (IsFlag 29)))
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 57 141 4 141 14 118 69 118
							yourself:
						)
				)
				(= global400 gDay)
				(= global401 4)
				(= [local65 0] @local42)
				(yesufuTeller init: (ScriptID 39 1) @local42 @local65) ; Yesufu
				((ScriptID 39 1) ; Yesufu
					view: 982
					loop: 0
					cel: 0
					x: 137
					y: 121
					setScale: 200
					noun: 6
					actions: yesufuTeller
					approachVerbs: 2 ; Talk
					approachX: 109
					approachY: 137
					ignoreActors: 1
					stopUpd:
					init:
				)
				(yesufuArm
					ignoreActors: 1
					setScale: 200
					init:
					stopUpd:
					setPri: 8
				)
				(gEgo setScript: yesufuGreet)
			)
			((and (IsFlag 65) (== global401 10))
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 57 141 4 141 14 118 69 118
							yourself:
						)
				)
				(= global401 11)
			)
			(else
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 57 141 4 141 14 118 69 118
							yourself:
						)
				)
			)
		)
		(= [local10 0] @local3)
		(egoTeller init: gEgo @local3 @local10)
		(gEgo
			setScale: 200
			normalize:
			actions: egoTeller
			setAvoider: PAvoider
			noun: 8
			init:
		)
		(cond
			((== gPrevRoomNum 420)
				(gCurRoom setScript: enterFrSouth)
			)
			((== gPrevRoomNum 470)
				(gCurRoom setScript: enterFrWrest)
			)
			((== gPrevRoomNum 460)
				(gCurRoom setScript: enterFrSpear)
			)
			((OneOf gPrevRoomNum 485 490) 0)
			(else
				(gCurRoom setScript: enterFrSouth)
			)
		)
		(if
			(and
				(!= (gLongSong number:) 160)
				(not (and (IsFlag 29) (not (IsFlag 65))))
			)
			(gLongSong number: 160 setLoop: -1 play:)
		)
		(super init:)
	)

	(method (doit)
		(cond
			(script 0)
			((>= (gEgo y:) 183)
				(gCurRoom setScript: exitSouth)
			)
			((>= (gEgo x:) 315)
				(gCurRoom setScript: exitEast)
			)
			((<= (gEgo x:) 5)
				(gCurRoom setScript: exitWest)
			)
		)
		(super doit: &rest)
	)

	(method (cue)
		(if (== (gLongSong prevSignal:) -1)
			(gLongSong setLoop: -1 client: 0 changeTo: 160)
		)
	)

	(method (dispose)
		(LoadMany 0 39 36 34 53)
		(super dispose:)
	)
)

(instance uhuraGreet of Script
	(properties)

	(method (doit)
		(if (and (== state 1) (not (gEgo mover:)))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1)
			(2
				(HandsOff)
				(switch global401
					(6
						(gMessager say: 9 6 44 0 self) ; "Good day, Prince of Shapeir. Now I be standing guard over the prisoner to be certain that the Leopardman does not escape."
					)
					(9
						(gMessager say: 9 6 53 0 self) ; "Habari, hero of Shapeir. Already the rumor be spreading that you are now the husband of this Leopard Lady."
					)
				)
			)
			(3
				(if (and (not (gEgo has: 16)) (== global401 6)) ; theDispell
					(gMessager say: 9 6 51 0 self) ; "I have been thinking that there is much we could learn from this Leopardman if he would become a man again. Perhaps you can find something in Tarna that will break the spell."
				else
					(= cycles 1)
				)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance yesufuGreet of Script
	(properties)

	(method (doit)
		(if (and (== state 1) (not (gEgo mover:)))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1)
			(2
				(HandsOff)
				(switch global401
					(1
						(gMessager say: 6 6 1 0 self) ; "Welcome, Prince of Shapeir. Uhura be telling us that you soon here. I am Yesufu."
					)
					(3
						(gMessager say: 6 6 74 0 self) ; "Habari, Prince of Shapeir. Good to be seeing you again."
					)
					(4
						(gMessager say: 6 6 30 0 self) ; "Hujambo, Prince of Shapeir. Maybe we be playing Awari today?"
					)
					(5
						(gMessager say: 6 5 20 0 self) ; "Hello! Look at the prisoner the Warriors caught. Now maybe we can make the Leopardmen give back our Spear of Death."
					)
					(8
						(gMessager say: 6 6 79 0 self) ; "You did very well to be taking away the magic of the Leopard Lady. Now she be looking like a real person. She be looking very good."
					)
				)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance storyTellGreet of Script
	(properties)

	(method (doit)
		(if (and (== state 1) (not (gEgo mover:)))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1)
			(2
				(HandsOff)
				(gMessager say: 7 6 30 0 self) ; "Welcome, Prince of Shapeir. It be not often the Simbani have such a guest. I be the storyteller of the Simbani. I will be most interested in learning more about you and your adventures. I am certain they will make an interesting story."
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance goToGame of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 127)
				(gMessager say: 6 5 3 0 self) ; "This is the game of Awari. I will be happy to show you how it is played."
			)
			(1
				(gCurRoom newRoom: 490)
			)
		)
	)
)

(instance firstTimeEnter of Script ; UNUSED
	(properties)

	(method (doit)
		(if (and (== state 1) (not (gEgo mover:)))
			(self cue:)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1)
			(2
				(HandsOff)
			)
			(3
				(yesufuArm setCycle: End self)
			)
			(4
				(gMessager say: 6 6 1 0 self) ; "Welcome, Prince of Shapeir. Uhura be telling us that you soon here. I am Yesufu."
			)
			(5
				(yesufuArm setCycle: Beg self)
			)
			(6
				(yesufuArm stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance from485 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(cond
					((gCast contains: guard)
						(gMessager say: 2 6 50 0 self) ; "The guard makes a sound of surprise."
					)
					((gCast contains: (ScriptID 34 1)) ; Uhura
						(ClearFlag 129)
						(gMessager say: 9 6 50 0 self) ; "Pretty powerful magic you use there. So the Leopardman becomes a lady. Soon the unmarried men will be asking the Laibon for her bride price, you will see."
					)
				)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance releaseJohari of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 65)
				(gEgo view: 31 loop: 1 cel: 0 setCycle: End self)
			)
			(1
				(gEgo
					normalize:
					setCycle: Rev
					setLoop: 3
					setMotion:
						PolyPath
						(+ (gEgo x:) 10)
						(+ (gEgo y:) 10)
						self
				)
				(gLongSong2 number: 481 setLoop: 1 play: 127)
				(cageDoor setCycle: End)
			)
			(2
				(gLongSong setLoop: 1 changeTo: 485 gCurRoom)
				(gEgo setCycle: 0)
				((ScriptID 36 1) view: 484 setLoop: 0 cel: 0 setCycle: End self) ; Johari
			)
			(3
				((ScriptID 36 1) setLoop: 1 cel: 0 x: 47 setCycle: End self) ; Johari
			)
			(4
				((ScriptID 36 1) ; Johari
					setLoop: 2
					cel: 0
					x: 62
					y: 124
					setCycle: Fwd
					setPri: 8
					origStep: 808
					setMotion: MoveTo 112 96 self
				)
			)
			(5
				((ScriptID 36 1) setPri: 5 setMotion: MoveTo 118 93 self) ; Johari
			)
			(6
				((ScriptID 36 1) ; Johari
					setLoop: 3
					cel: 0
					x: 134
					y: 57
					setPri: -1
					setCycle: End self
				)
			)
			(7
				((ScriptID 36 1) dispose:) ; Johari
				(= cycles 5)
			)
			(8
				(gMessager say: 2 6 65 0 self) ; "The guard says something you can't understand, but you don't think it is flattering."
			)
			(9
				(gEgo normalize:)
				(= global401 10)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance exitSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath (gEgo x:) 210 self)
			)
			(1
				(gCurRoom newRoom: 420)
			)
		)
	)
)

(instance exitEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 325 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 470)
			)
		)
	)
)

(instance exitWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath -5 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 460)
			)
		)
	)
)

(instance enterFrSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo x: 160 y: 210 setMotion: PolyPath 160 180 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterFrWrest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo x: 320 y: 170 setMotion: PolyPath 300 170 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterFrSpear of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo x: -15 y: 170 setMotion: PolyPath 20 170 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance johariHands of Prop
	(properties
		x 33
		y 132
		view 481
		loop 3
		priority 10
		signal 16400
	)

	(method (doit)
		(self cel: ((ScriptID 36 1) cel:)) ; Johari
		(super doit: &rest)
	)
)

(instance tree1 of Feature
	(properties
		x 189
		y 22
		noun 12
		nsTop 1
		nsLeft 92
		nsBottom 43
		nsRight 287
		sightAngle 180
	)
)

(instance tree2 of Feature
	(properties
		x 205
		y 62
		noun 13
		nsTop 44
		nsLeft 118
		nsBottom 77
		nsRight 292
		sightAngle 180
	)
)

(instance rock1 of Feature
	(properties
		x 166
		y 125
		noun 14
		nsTop 114
		nsLeft 121
		nsBottom 142
		nsRight 212
		sightAngle 180
	)
)

(instance rock2 of Feature
	(properties
		x 261
		y 124
		noun 15
		nsTop 93
		nsLeft 204
		nsBottom 155
		nsRight 319
	)
)

(instance mountain of Feature
	(properties
		x 159
		y 32
		noun 16
		nsTop 22
		nsBottom 42
		nsRight 319
		sightAngle 180
	)
)

(instance littleRock1 of Feature
	(properties
		x 69
		y 145
		noun 17
		nsTop 142
		nsLeft 62
		nsBottom 149
		nsRight 76
		sightAngle 180
	)
)

(instance littleRock2 of Feature
	(properties
		x 227
		y 182
		noun 18
		nsTop 179
		nsLeft 219
		nsBottom 186
		nsRight 235
		sightAngle 180
	)
)

(instance theCage of Feature
	(properties
		x 48
		y 121
		noun 3
		nsTop 85
		nsLeft 12
		nsBottom 128
		nsRight 56
		sightAngle 40
		approachX 60
		approachY 150
	)

	(method (doVerb)
		(cageDoor doVerb: &rest)
	)
)

(instance cageDoor of Prop
	(properties
		x 48
		y 121
		noun 3
		sightAngle 40
		approachX 60
		approachY 150
		view 480
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((gCurRoom script:) 0)
					(
						(and
							(== global401 5)
							(not (IsFlag 65))
							(gCast contains: (ScriptID 39 1)) ; Yesufu
						)
						(gMessager say: 6 6 25) ; "The prisoner will be fed and watered in the evening. Do not bother him."
					)
					(
						(and
							(== global401 9)
							(not (IsFlag 65))
							(gCast contains: (ScriptID 34 1)) ; Uhura
						)
						(if (== global453 3)
							(gMessager say: 3 4 55) ; "Before you let this bride of yours out of this cage, maybe you better find a way to win her heart before she runs off."
						else
							(gMessager say: 3 4 56) ; "I do not think that will be a good idea just now. Maybe you should let the Leopard Lady get used to the idea that she is your bride before you let her go."
						)
					)
					(
						(and
							(IsFlag 38)
							(== global392 4)
							(> global401 5)
							(not (IsFlag 65))
						)
						(SetFlag 65)
						(gCurRoom setScript: releaseJohari)
					)
					(
						(and
							(gCast contains: guard)
							(gCast contains: (ScriptID 36 1)) ; Johari
						)
						(gMessager say: 3 4 83) ; "The guard will not let you open the cage now."
					)
					((not (gCast contains: (ScriptID 36 1))) ; Johari
						(gMessager say: 3 4 84) ; "You open and close the cage."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance awari of Feature
	(properties
		x 173
		y 128
		noun 4
		nsTop 117
		nsLeft 142
		nsBottom 133
		nsRight 204
		sightAngle 40
		approachX 173
		approachY 134
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if
					(and
						(gCast contains: (ScriptID 39 1)) ; Yesufu
						(OneOf global401 1 3 4)
					)
					(gCurRoom newRoom: 490)
				else
					(gMessager say: 4 4 82) ; "There is no one who wants to play Awari with you now."
				)
			)
			(24 ; theRations
				(SetFlag 161)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fence of Feature
	(properties
		x 144
		y 60
		noun 5
		nsTop 38
		nsBottom 85
		nsRight 224
		sightAngle 40
		approachX 144
		approachY 68
	)
)

(instance guard of View
	(properties
		x 14
		y 150
		noun 2
		view 482
	)
)

(instance yesufuArm of Prop
	(properties
		x 139
		y 107
		view 982
		loop 1
	)
)

(instance johariTeller of Teller
	(properties)

	(method (doChild)
		(if (IsFlag 38)
			(gMessager say: 10 5 63) ; "The Leopard Lady turns her head and ignores you."
		else
			(gMessager say: 11 5 63) ; "The prisoner snarls back at you."
		)
		(return 0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(30 ; theBeads
				(if (and (== global392 4) (IsFlag 38))
					(if (not (IsFlag 283))
						(gEgo solvePuzzle: 283 3 addHonor: 20)
						(++ global453)
					)
					(gEgo drop: 20 1) ; theBeads
					(gMessager say: 10 30 0) ; "The Leopard Lady holds the beads for a moment, smiles, then puts them away."
				else
					(gMessager say: 11 30 0) ; "The Leopardman looks at the beads, but will not take them now."
				)
			)
			(12 ; theFineDagger
				(if (and (== global392 4) (IsFlag 38))
					(if (not (IsFlag 284))
						(gEgo solvePuzzle: 284 3 addHonor: 20)
						(++ global453)
					)
					(gEgo drop: 2 1) ; theFineDagger
					(gMessager say: 10 12 0) ; "Do not think I will not use this on you someday. Still, it is a very nice gift."
				else
					(gMessager say: 11 12 0) ; "The guard will not let you give a weapon to the prisoner."
				)
			)
			(43 ; theLeopard
				(if (and (== global392 4) (IsFlag 38))
					(if (not (IsFlag 282))
						(gEgo solvePuzzle: 282 3 addHonor: 20)
						(++ global453)
					)
					(gEgo drop: 32) ; theLeopard
					(gMessager say: 10 43 0) ; "This is lovely. Do not think, though, that it will make me your wife."
				else
					(gMessager say: 11 43 0) ; "The Leopardman reaches for the sculpture, then draws back from you and snarls."
				)
			)
			(26 ; theDispell
				(cond
					((and (gCast contains: (ScriptID 39 1)) (== global401 5)) ; Yesufu
						(gMessager say: 6 6 25) ; "The prisoner will be fed and watered in the evening. Do not bother him."
					)
					(
						(and
							(or
								(and
									(== global401 5)
									(not (gCast contains: (ScriptID 39 1))) ; Yesufu
								)
								(== global401 6)
							)
							(not (IsFlag 38))
							(not (gCurRoom script:))
						)
						(SetFlag 38)
						(= global401 7)
						(if (gCast contains: (ScriptID 34 1)) ; Uhura
							(SetFlag 129)
						)
						(gEgo drop: 16 1 solvePuzzle: 281 15 addHonor: 40) ; theDispell
						(gCurRoom newRoom: 485)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(cond
					((and (> theVerb 10) (== global401 9)) ; Money
						(gMessager say: 19 6 80) ; "The Leopard Lady ignores your offering."
					)
					((and (> theVerb 10) (== global401 10)) ; Money
						(gMessager say: 10 0 64) ; "The Leopard Lady ignores what you tried to give her."
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
		)
	)
)

(instance yesufuTeller of Teller
	(properties)

	(method (showDialog)
		(super
			showDialog:
				14
				(== gBaseHeroType 0) ; Fighter
				18
				(== gBaseHeroType 0) ; Fighter
				8
				(== gBaseHeroType 0) ; Fighter
				-3
				(== global401 1)
				-75
				(or (== global401 3) (== global401 4))
		)
	)

	(method (doChild)
		(switch query
			(-75
				(if (IsFlag 127)
					(= query 16)
				else
					(= query 3)
					(gCurRoom setScript: goToGame)
					(return 0)
				)
			)
			(-3
				(if (IsFlag 127)
					(= query 16)
				else
					(gCurRoom setScript: goToGame)
					(return 0)
				)
			)
			(-7
				(if (== gBaseHeroType 0) ; Fighter
					(super doChild: &rest)
				else
					(return 1)
				)
			)
			(else
				(super doChild: &rest)
			)
		)
	)
)

(instance egoTeller of Teller
	(properties)

	(method (showDialog)
		(super
			showDialog:
				-30
				(and
					(not local2)
					(< global401 11)
					(or
						(gCast contains: (ScriptID 34 1)) ; Uhura
						(gCast contains: (ScriptID 39 1)) ; Yesufu
						(gCast contains: guard)
						(gCast contains: (ScriptID 53 1)) ; StoryTeller
					)
				)
				-72
				(and
					(< global401 11)
					(or
						(gCast contains: (ScriptID 34 1)) ; Uhura
						(gCast contains: (ScriptID 39 1)) ; Yesufu
						(gCast contains: guard)
						(gCast contains: (ScriptID 53 1)) ; StoryTeller
					)
				)
				68
				(and
					(gCast contains: (ScriptID 39 1)) ; Yesufu
					(or (== global401 1) (== global401 3))
				)
				-41
				(and
					(gCast contains: (ScriptID 53 1)) ; StoryTeller
					(not local0)
					(== global401 2)
				)
				28
				(and (== global401 9) (gCast contains: (ScriptID 34 1))) ; Uhura
		)
	)

	(method (doChild)
		(switch query
			(-30
				(cond
					((gCast contains: guard)
						(= query 69)
					)
					((gCast contains: (ScriptID 39 1)) ; Yesufu
						(gEgo addHonor: 3)
						(= query 66)
					)
					((gCast contains: (ScriptID 53 1)) ; StoryTeller
						(gEgo addHonor: 3)
						(= query 42)
					)
					((gCast contains: (ScriptID 34 1)) ; Uhura
						(= query 62)
					)
				)
				(= local2 1)
			)
			(-72
				(cond
					((gCast contains: guard)
						(= query 70)
					)
					((gCast contains: (ScriptID 39 1)) ; Yesufu
						(= query 67)
					)
					((gCast contains: (ScriptID 53 1)) ; StoryTeller
						(= query 43)
					)
					((gCast contains: (ScriptID 34 1)) ; Uhura
						(= query 61)
					)
				)
			)
			(-41
				(= local0 1)
				(gEgo addHonor: 10)
				(return 1)
			)
		)
	)
)

(instance storyActions of Teller
	(properties)

	(method (showDialog)
		(super showDialog: 39 (IsFlag 9) 40 (IsFlag 9))
	)

	(method (doChild)
		(if (== query -73)
			(switch gHeroType
				(0 ; Fighter
					(= query 36)
				)
				(3 ; Paladin
					(= query 36)
				)
				(1 ; Magic User
					(= query 37)
				)
				(2 ; Thief
					(= query 38)
				)
			)
		else
			(super doChild: &rest)
		)
	)
)

(instance guardTeller of Teller
	(properties)

	(method (doChild)
		(gMessager say: 2 5 63) ; "The guard shakes his head to say he doesn't understand you."
		(return 0)
	)
)

(instance uhuraTeller of Teller
	(properties)

	(method (showDialog)
		(super showDialog: -59 (< global453 3) 28 (== gPrevRoomNum 485))
	)

	(method (doChild)
		(if (== query -59)
			(gEgo solvePuzzle: 268 2)
			(return 1)
		)
	)
)

