;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 600)
(include sci.sh)
(use Main)
(use Teller)
(use PChase)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm600 0
)

(local
	[local0 6] = [0 7 -6 -14 -9 999]
	[local6 7] = [0 2 11 12 16 17 999]
	[local13 6]
	[local19 5]
	local24
	local25
	local26 = 180
	[local27 2]
	local29
	local30
	local31
)

(procedure (localproc_0)
	(if (< local26 126)
		(return 5)
	else
		(return (- 20 (/ (- 190 local26) 4)))
	)
)

(instance rm600 of Rm
	(properties
		noun 4
		picture 600
		vanishingY 75
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 1 319 2 319 151 247 137 229 139 208 130 152 129 140 127 0 120
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 16 140 77 149 154 174 154 189 0 189
					yourself:
				)
		)
		((ScriptID 36 0) x: 200 y: 2 textX: -175 textY: 150) ; johariTalker
		(= [local13 0] @local0)
		(= [local19 0] @local6)
		(gate init:)
		(gLongSong number: 600 setLoop: -1 play: 127)
		(switch gPrevRoomNum
			(620
				(gEgo
					view: 0
					x: 309
					y: 175
					loop: 3
					cel: 0
					init:
					setScale: 195
				)
				(joHari
					x: 290
					y: 175
					signal: 16384
					noun: 1
					init:
					moveSpeed: (gEgo moveSpeed:)
					cycleSpeed: (gEgo cycleSpeed:)
					origStep: (gEgo origStep:)
					setScale: 195
					setCycle: Walk
				)
				(super init:)
				(gCurRoom setScript: eventThree)
			)
			(650
				(gWalkHandler addToFront: self)
				(egoTell init: gEgo @local0 @local13)
				(johariTell init: joHari @local6 @local19)
				(gEgo
					x: 175
					y: 185
					code: checkSouth
					noun: 2
					signal: 16384
					init:
					normalize: 3
					setScale: 195
				)
				(joHari
					x: 200
					y: 180
					noun: 1
					origStep: (gEgo origStep:)
					actions: johariTell
					init:
					moveSpeed: (gEgo moveSpeed:)
					cycleSpeed: (gEgo cycleSpeed:)
					setScale: 195
					setCycle: joHariStop 974
				)
				(super init:)
				(gCurRoom setScript: eventFour)
			)
			(else
				(if (and (== gPrevRoomNum 170) (IsFlag 88))
					(ClearFlag 88)
					(gWalkHandler addToFront: self)
					(egoTell init: egoPic @local0 @local13)
					(johariTell init: johariPic @local6 @local19)
					(egoPic init:)
					(johariPic init:)
					(kissView init:)
					(gEgo view: 0 loop: 3 cel: 0 init: setScale: 195 hide:)
					(joHari
						signal: 16384
						init:
						moveSpeed: (gEgo moveSpeed:)
						cycleSpeed: (gEgo cycleSpeed:)
						setScale: 195
						setCycle: Walk
						hide:
					)
					(= local29 1)
					(super init:)
					(HandsOn)
					(gCurRoom setScript: eventOne)
				else
					(gEgo
						view: 0
						x: 190
						y: 180
						code: checkSouth
						loop: 3
						cel: 0
						noun: 2
						init:
						setStep: 2 2
						setScale: 195
					)
					(super init:)
					(gCurRoom setScript: eventFive)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(cond
					((== gPrevRoomNum 650)
						(= local25 ((gUser curEvent:) x:))
						(= local26 ((gUser curEvent:) y:))
						(gEgo setMotion: PolyPath local25 local26 joHari)
						(joHari setMotion: PFollow gEgo 12)
					)
					(local24
						(gCurRoom setScript: kissing)
					)
					(else
						(gMessager say: 2 5 6 2) ; "Hey, where do you think you are going, fool?"
						(= local24 1)
					)
				)
			)
			(74 ; Sleep
				(if (== gPrevRoomNum 650)
					(gMessager say: 3 6 25) ; "This certainly isn't a safe place to sleep."
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(DisposeScript 36)
		(super dispose: &rest)
	)
)

(instance eventOne of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(gMessager say: 1 2 1 0 self) ; "You can see my village from here. It will be dark soon, and we can watch my people do the Change ritual. No outsider is allowed to see it and live, so do not tell anyone what you will see here."
			)
			(2
				(switch gHeroType
					(1 ; Magic User
						(gMessager say: 1 2 10 0 self) ; "I sure hope you are as good at magic as you say you are. My people are very good at magic and you are going to have to be better, if you want to convince my people of anything."
					)
					(2 ; Thief
						(gMessager say: 1 2 3 0 self) ; "You say you are good at sneaking in and out of places. You better be very good if you think you can get the Spear of Death from my village."
					)
					(else
						(if (gEgo has: 46) ; theMagicDrum
							(gMessager say: 1 2 4 0 self) ; "When we do enter the village, give the Drum of Magic to my father. Then maybe he will give you the Spear of Death if you ask him for it."
						else
							(self dispose:)
						)
					)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance eventTwo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(kissView dispose:)
				(johariPic dispose:)
				(egoPic dispose:)
				(PalVary pvINIT 600 0)
				(= seconds 2)
			)
			(1
				(DrawPic 600 10)
				(gate show:)
				(= seconds 2)
			)
			(2
				(if (!= (PalVary pvGET_CURRENT_STEP) 64)
					(SetFlag 31)
					(SetFlag 81)
					(= gClock 3200)
				)
				(gMessager say: 1 2 8 0 self) ; "The time has come for the Change ritual. Come quietly and we will go to a secret looking position I know about where we can watch."
			)
			(3
				(gEgo
					x: 200
					y: 280
					show:
					setStep: 2 2
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 200 200 self
				)
				(joHari
					x: 170
					y: 280
					show:
					setCycle: Walk
					setMotion: MoveTo 170 200 self
				)
			)
			(4 0)
			(5
				(gMessager say: 1 2 15 0 self) ; "Over here we will be out of sight and can watch what goes on in the ritual."
			)
			(6
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 90) (gEgo y:) self
				)
				(joHari setMotion: MoveTo (+ (joHari x:) 100) (joHari y:) self)
			)
			(7 0)
			(8
				(gCurRoom newRoom: 620)
			)
		)
	)
)

(instance eventThree of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 170 (+ (gate y:) 30) self)
				(joHari setMotion: MoveTo 165 (+ (gate y:) 23) self)
			)
			(1 0)
			(2
				(gMessager say: 1 2 18 0 self) ; "Come on. Now we can go into the village."
			)
			(3
				(if (== gHeroType 1) ; Magic User
					(gMessager say: 1 6 2 0 self) ; "After the ritual, we will be able to enter the village. If you want to earn the respect of my people and maybe get the Spear of Death, you will need to show how well you can use magic. You will need to compete in a magical duel."
				else
					(self cue:)
				)
			)
			(4
				(if (gEgo has: 46) ; theMagicDrum
					(gMessager say: 1 2 20 0 self) ; "We can give the Drum of Magic to my father and then maybe talk him into peace."
				else
					(self cue:)
				)
			)
			(5
				(joHari setMotion: MoveTo 148 (+ (gate y:) 5) self)
				(gEgo setMotion: MoveTo 152 (+ (gate y:) 10) self)
			)
			(6 0)
			(7
				(gMessager say: 1 2 21 0 self) ; "You! Open up. I am Johari, and this is my prisoner."
			)
			(8
				(gate setMotion: MoveTo (- (gate x:) 15) (gate y:) self)
				(gLongSong2 number: 602 play: 127)
			)
			(9
				(gEgo setMotion: MoveTo 147 (- (gate y:) 2) self)
				(joHari setMotion: MoveTo 143 (- (gate y:) 4) self)
			)
			(10
				(gCurRoom newRoom: 620)
			)
		)
	)
)

(instance eventFour of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(gMessager say: 1 6 22 0 self) ; "You should try the contest again. I think you can beat the old Shaman. All you need to do is correctly counter his spells and you'll make him so mad the Shaman will make a mistake and you can win. No problem."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance eventFive of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 147 (+ (gate y:) 5) self)
			)
			(1
				(gMessager say: 3 2 21 0 self) ; "The guards open the gate for you to enter."
			)
			(2
				(gate setMotion: MoveTo (- (gate x:) 15) (gate y:) self)
				(gLongSong2 number: 602 play: 127)
			)
			(3
				(gEgo setMotion: MoveTo 145 120 self)
			)
			(4
				(if (and (== gPrevRoomNum 170) (gEgo has: 46)) ; theMagicDrum
					(gCurRoom newRoom: 620)
				else
					(gCurRoom newRoom: 650)
				)
			)
		)
	)
)

(instance kissing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(kissView setLoop: 0 setCycle: End self)
			)
			(1
				(= seconds 3)
			)
			(2
				(kissView cel: 0 setLoop: 1 cycleSpeed: 10 setCycle: End self)
			)
			(3
				(sFx number: 603 play:)
				(= seconds 2)
			)
			(4
				(gEgo solvePuzzle: 297 3)
				(DrawPic 0 10)
				(gCast eachElementDo: #hide)
				(= seconds 1)
			)
			(5
				(gCurRoom setScript: eventTwo)
			)
		)
	)
)

(instance toVillage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 200 210 self)
			)
			(1
				(gCurRoom newRoom: 170)
			)
		)
	)
)

(instance toRm650 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo code: 0 setMotion: MoveTo 147 127 self)
				(joHari signal: 16384 setMotion: MoveTo 143 132 self)
			)
			(1 0)
			(2
				(gate setMotion: MoveTo 130 (gate y:) self)
				(gLongSong2 number: 602 play:)
			)
			(3
				(gEgo setMotion: MoveTo 147 (- (gate y:) 3) self)
				(joHari setMotion: MoveTo 143 (- (gate y:) 2) self)
			)
			(4 0)
			(5
				(gCurRoom newRoom: 650)
			)
		)
	)
)

(instance toLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo code: 0)
				(gMessager say: 1 6 23 0 self) ; "I will be waiting here for your return. Then you can win the contest with the Shaman."
			)
			(1
				(gCurRoom newRoom: 170)
			)
		)
	)
)

(instance checkSouth of Code
	(properties)

	(method (doit)
		(cond
			((> (gEgo y:) 185)
				(gCurRoom setScript: toLeave)
			)
			((& (gEgo onControl:) $0008)
				(gate dispose:)
				(gCurRoom newRoom: 650)
			)
		)
	)
)

(instance johariPic of Feature
	(properties
		x 50
		y 160
		noun 1
		onMeCheck 2
	)
)

(instance egoPic of Feature
	(properties
		x 75
		y 160
		noun 2
		onMeCheck 4
	)
)

(instance kissView of Actor
	(properties
		x 125
		y 159
		z -30
		view 601
		priority 15
		signal 4112
	)
)

(instance joHari of Actor
	(properties
		x 170
		y 280
		view 975
		loop 3
	)

	(method (cue)
		(gEgo normalize:)
	)

	(method (doit)
		(super doit: &rest)
		(if (and (IsObject (self mover:)) ((self mover:) isMemberOf: PFollow))
			((self mover:) distance: (localproc_0))
			(self moveSpeed: (gEgo moveSpeed:))
			(self cycleSpeed: (gEgo cycleSpeed:))
		)
	)
)

(instance gate of Actor
	(properties
		x 146
		y 126
		view 600
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== gPrevRoomNum 650)
					(gCurRoom setScript: toRm650)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance egoTell of Teller
	(properties)

	(method (showDialog)
		(super showDialog: -14 local29 -9 local29) ; "Tell about Shapeir", "Tell about romance"
	)

	(method (doChild param1)
		(switch param1
			(-6 ; "Say Good-bye"
				(cond
					(local29
						(if local24
							(gCurRoom setScript: kissing)
							(return 0)
						else
							(= local24 1)
						)
					)
					((== gPrevRoomNum 650)
						(gCurRoom setScript: toVillage)
						(return 0)
					)
					(else
						(return 1)
					)
				)
			)
			(-14 ; "Tell about Shapeir"
				(if local24
					(gCurRoom setScript: kissing)
				else
					(= local24 1)
					(gMessager say: 2 5 6 2) ; "Hey, where do you think you are going, fool?"
				)
				(return 0)
			)
			(-9 ; "Tell about romance"
				(gEgo addHonor: 10)
				(= local24 1)
			)
		)
	)
)

(instance johariTell of Teller
	(properties)

	(method (showDialog)
		(super
			showDialog:
				11
				local29
				12
				local29
				16
				(== gPrevRoomNum 650)
				17
				(== gPrevRoomNum 650)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (!= gPrevRoomNum 650)
					(if local24
						(gCurRoom setScript: kissing)
					else
						(gMessager say: 1 2 13) ; "Just what is it you are trying to do?"
						(= local24 1)
					)
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

(instance joHariStop of Fwd
	(properties)

	(method (init param1 param2)
		(if argc
			(= local31 ((= client param1) view:))
			(if (>= argc 2)
				(= local30 param2)
			)
		)
		(super init: client)
		(self doit:)
	)

	(method (dispose)
		(if (== (client view:) local30)
			(client view: local31)
		)
		(super dispose:)
	)

	(method (doit &tmp temp0 temp1)
		(if (client isStopped:)
			(cond
				(
					(and
						(== local30 -1)
						(!= (client loop:) (- (NumLoops client) 1))
					)
					(= temp0 (client loop:))
					(= temp1 (client mover:))
					(super doit:)
					(client loop: (- (NumLoops client) 1) setCel: temp0)
				)
				((and (!= local30 -1) (== (client view:) local31))
					(client view: local30 loop: (gEgo loop:))
					(= temp1 (client mover:))
					(super doit:)
				)
				((!= local30 -1)
					(super doit:)
				)
			)
		else
			(switch local30
				((client view:)
					(client view: local31)
				)
				(-1
					(client setLoop: -1 setCel: -1)
				)
			)
			(super doit:)
		)
	)
)

(instance sFx of Sound
	(properties)
)

