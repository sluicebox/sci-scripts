;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 440)
(include sci.sh)
(use Main)
(use Teller)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm440 0
)

(local
	local0 = 150
	local1 = 130
	local2
	local3
	local4
	local5
	local6
	local7
	[local8 12] = [0 -16 17 97 -43 96 50 94 78 93 81 999]
	[local20 2]
	[local22 6] = [0 1 -2 4 -5 999]
	[local28 3] = [0 3 999]
	[local31 4] = [0 -6 98 999]
	[local35 5] = [0 -7 8 3 999]
	[local40 3] = [0 9 999]
	[local43 6] = [0 -2 -5 -6 -7 999]
	[local49 7]
	[local56 6] = [0 11 18 19 20 999]
	[local62 2]
	[local64 7] = [0 1 10 -4 11 12 999]
	[local71 8] = [0 -26 -28 -31 33 34 -24 999]
	[local79 3] = [0 27 999]
	[local82 4] = [0 29 30 999]
	[local86 3] = [0 32 999]
	[local89 3] = [0 25 999]
	[local92 6] = [0 -26 -28 -31 -24 999]
	[local98 8] = [0 -35 99 37 38 39 40 999]
	[local106 4] = [0 42 41 999]
	[local110 3] = [0 -35 999]
	[local113 6] = [0 100 49 3 -45 999]
	[local119 5] = [0 46 48 47 999]
	[local124 3] = [0 -45 999]
	[local127 8] = [0 -50 58 57 59 60 61 999]
	[local135 4] = [0 56 -53 999]
	[local139 4] = [0 54 55 999]
	[local143 4] = [0 -50 -53 999]
	[local147 5] = [0 -63 -65 68 999]
	[local152 3] = [0 64 999]
	[local155 4] = [0 66 67 999]
	[local159 4] = [0 -63 -65 999]
	[local163 6] = [0 76 -72 70 71 999]
	[local169 4] = [0 73 -74 999]
	[local173 5] = [0 -75 2 79 999]
	[local178 4] = [0 -72 -74 999]
	[local182 6] = [0 80 81 82 83 999]
	[local188 5] = [0 85 86 87 999]
	[local193 6] = [0 89 92 91 90 999]
	[local199 6]
)

(procedure (localproc_0 param1)
	(return (* 2 (/ (+ (* param1 800) (- local7 1)) local7)))
)

(instance rm440 of Rm
	(properties
		noun 8
		picture 440
	)

	(method (init)
		(HandsOff)
		(gWalkHandler addToFront: gCurRoom)
		(if (== gPrevRoomNum 450)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 37 189 129 188 128 129 196 129 227 146 246 155 279 155 279 111 231 119 215 118 195 106 152 106 110 123 37 123
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 37 189 126 189 126 128 191 128 219 140 227 156 279 156 279 112 244 119 227 121 186 109 159 105 131 105 113 87 37 102
						yourself:
					)
			)
		)
		(fire setCycle: Fwd init:)
		(firePlace init:)
		(shield init:)
		(pot init:)
		(rightBench init:)
		(wallSkin init:)
		(mat approachVerbs: 4 init:) ; Do
		(gLongSong setLoop: -1 changeTo: 440)
		(gLongSong3 number: 913 setLoop: -1 play: 127)
		(super init:)
		(= [local20 0] @local8)
		(egoActions init: gEgo @local8 @local20)
		(cond
			((and (IsFlag 74) (< global402 10) (!= gDay global470))
				(gCurRoom setScript: eventTen)
			)
			((and (IsFlag 65) (or (< global402 9) (== global402 10)))
				(gCurRoom setScript: eventNine)
			)
			((and (IsFlag 16) (< global402 8))
				(gCurRoom setScript: eventEight)
			)
			((and (IsFlag 38) (< global402 7))
				(gCurRoom setScript: eventSeven)
			)
			((== global402 5)
				(gCurRoom setScript: eventSix)
			)
			((and (IsFlag 29) (< global402 5))
				(gCurRoom setScript: eventFive)
			)
			((== gPrevRoomNum 450)
				(gCurRoom setScript: eventOne)
			)
			((== global402 1)
				(gCurRoom setScript: eventTwo)
			)
			((== global402 2)
				(gCurRoom setScript: eventThree)
			)
			((== global402 3)
				(gCurRoom setScript: eventFour)
			)
			(else
				(gEgo
					normalize:
					x: 110
					y: 150
					actions: egoActions
					setScale:
					scaleX: 156
					scaleY: 156
					noun: 4
					init:
				)
				(= [local199 0] @local71)
				(= [local199 1] @local79)
				(= [local199 2] @local82)
				(= [local199 3] @local86)
				(= [local199 4] @local89)
				(uhuraTell init: (ScriptID 34 1) @local71 @local199 @local92) ; Uhura
				((ScriptID 34 1) ; Uhura
					view: 433
					loop: 2
					cel: 0
					x: 192
					y: 92
					setScale:
					scaleX: 156
					scaleY: 156
					noun: 2
					init:
				)
				(uhuraHead setScale: scaleX: 160 scaleY: 160 init:)
				(simba
					setScale:
					scaleX: 156
					scaleY: 156
					x: 220
					y: 94
					loop: 5
					cel: 1
					noun: 5
					init:
				)
				(HandsOn)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(74 ; Sleep
				(self setScript: goToBed)
			)
			(3 ; Walk
				(egoActions doVerb: 3)
			)
			(4 ; Do
				(egoActions doVerb: 4)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(cond
			((and (GameIsRestarting) (== (gEgo view:) 40))
				(= local2 1)
			)
			((self script:) 0)
			((and (gEgo mover:) (== (gEgo view:) 40))
				(if (IsObject (gEgo looper:))
					((gEgo looper:) dispose:)
				)
				(gEgo setMotion: 0 setScript: egoGetUp)
			)
			((and (< (gEgo x:) 140) (> (gEgo y:) 155))
				(if (== gPrevRoomNum 450)
					(gCurRoom setScript: egoLeaves)
				else
					(gCurRoom setScript: exitRoom)
				)
			)
		)
		(cond
			((uhuraHead cycler:) 0)
			((and (== (Random 1 200) 50) (gCast contains: uhuraHead))
				(if (== (uhuraHead cel:) 0)
					(uhuraHead setCycle: End)
				else
					(uhuraHead setCycle: Beg)
				)
			)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(gWalkHandler delete: gCurRoom)
		(if (uhuraHead cycler:)
			((uhuraHead cycler:) dispose:)
		)
		(gLongSong3 stop:)
		(UnLoad 128 425)
		(UnLoad 128 433)
		(LoadMany 0 34 35 949)
		(super dispose:)
	)
)

(instance rakeeshTell of Teller
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(= local3 1)
				(++ local4)
				(super doVerb: theVerb &rest)
			)
			(1 ; Look
				(= local3 1)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance uhuraTell of Teller
	(properties)

	(method (showDialog)
		(super
			showDialog:
				-72
				(< global453 3)
				75
				(< global453 3)
				79
				(== gBaseHeroType 0) ; Fighter
		)
	)

	(method (doChild)
		(if (or (== query -74) (== query -101))
			(gEgo solvePuzzle: 268 2)
		)
		(if (== query -75)
			(gEgo solvePuzzle: 268 2)
		)
		(if (== query -4) ; "Spear"
			(gEgo solvePuzzle: 267 2)
			(return 1)
		)
		(return
			(cond
				((and (== query -74) (== gHeroType 0)) ; Fighter
					(super doChild: query)
					(= query -101)
				)
				((< query 0)
					(super doChild: query)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(= local3 1)
				(++ local4)
				(super doVerb: theVerb &rest)
			)
			(1 ; Look
				(= local3 1)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance egoActions of Teller
	(properties)

	(method (showDialog)
		(super
			showDialog:
				-16
				(== global402 1)
				17
				(== global402 1)
				97
				(!= global402 1)
				-43
				(!= global402 1)
				96
				(or
					(== global402 2)
					(== global402 3)
					(== global402 4)
					(== global402 6)
				)
				50 ; "Prisoner"
				(== global402 5)
				94
				(== global402 7)
				78
				(== global402 8)
				93
				(== global402 9)
				81 ; "Drum"
				(== global402 10)
		)
	)

	(method (doChild)
		(switch query
			(-16
				(gMessager say: 4 5 16) ; "You say good-bye to everyone."
				(gCurRoom setScript: egoLeaves)
				(return 0)
			)
			(-43
				(gCurRoom setScript: goodNightEgo)
				(return 0)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(cond
					((gCurRoom script:) 0)
					((== (gEgo view:) 40)
						(HandsOff)
						(= local0 ((User curEvent:) x:))
						(= local1 ((User curEvent:) y:))
						(gCurRoom setScript: egoGetUp)
					)
				)
			)
			(2 ; Talk
				(if (== gPrevRoomNum 450)
					(= local3 1)
				)
				(super doVerb: 2)
			)
			(4 ; Do
				(cond
					((== gPrevRoomNum 450) 0)
					((gCurRoom script:) 0)
					((== local2 1) 0)
					(else
						(gCurRoom setScript: sitDown)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance simbaTeller of Teller
	(properties)
)

(instance goodNightEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 4 5 43 0 self) ; "You say good night to Uhura."
			)
			(1
				(if local2
					(= local0 120)
					(= local1 180)
					(HandsOff)
					(self setScript: egoGetUp self)
				else
					(gEgo setMotion: PolyPath 120 180 self)
				)
			)
			(2
				(gCurRoom newRoom: 420)
			)
		)
	)
)

(instance goToBed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 15 6 102 0 self) ; "This is not a good place to sleep. People may start to gossip about you and Uhura."
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance eventTen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(simba
					setScale:
					scaleX: 156
					scaleY: 156
					x: 220
					y: 94
					loop: 5
					cel: 1
					noun: 5
					init:
				)
				(= global402 10)
				(= [local199 0] @local193)
				(uhuraTell init: (ScriptID 34 1) @local193 @local199) ; Uhura
				(self setScript: enterRoom self)
			)
			(1
				(gMessager say: 2 6 88 0 self) ; "Have you heard the news, hero? Someone has taken the drum of the Leopardmen away from the Laibon's hut."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance eventNine of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= [local62 0] @local56)
				(simbaTeller init: simba @local56 @local62)
				(simba setScale: scaleX: 156 scaleY: 156 noun: 5 init:)
				(= global402 9)
				(= [local199 0] @local188)
				(uhuraTell init: (ScriptID 34 1) @local188 @local199) ; Uhura
				(self setScript: enterRoom self)
			)
			(1
				(gMessager say: 2 6 84 0 self) ; "Poli, hero. I did not think the Leopard Lady would run from you so fast. Maybe you should be giving her more gifts, but then, maybe not. Maybe she just want to go home."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance eventEight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= [local62 0] @local56)
				(simbaTeller init: simba @local56 @local62)
				(simba
					setScale:
					scaleX: 156
					scaleY: 156
					x: 142
					y: 105
					noun: 5
					init:
				)
				(= global402 8)
				(= [local199 0] @local182)
				(uhuraTell init: (ScriptID 34 1) @local182 @local199) ; Uhura
				(self setScript: enterRoom self)
			)
			(1
				(gMessager say: 2 6 77 0 self) ; "Welcome, Warrior of the Simbani. You did very well today."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance eventSeven of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(simba
					setScale:
					scaleX: 156
					scaleY: 156
					x: 210
					y: 94
					loop: 5
					cel: 1
					noun: 5
					init:
				)
				(= global402 7)
				(= [local199 0] @local163)
				(= [local199 1] @local169)
				(= [local199 2] @local173)
				(uhuraTell init: (ScriptID 34 1) @local163 @local199 @local178) ; Uhura
				(self setScript: enterRoom self)
			)
			(1
				(gMessager say: 2 6 69 0 self) ; "So, breaker of magic, you turn the Leopardman into a woman. Now there be no more talk of beating the prisoner. Now there be talk of marrying the prisoner."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance eventSix of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(simba
					setScale:
					scaleX: 156
					scaleY: 156
					x: 210
					y: 94
					loop: 5
					cel: 1
					noun: 5
					init:
				)
				(= [local199 0] @local147)
				(= [local199 1] @local152)
				(= [local199 2] @local155)
				(uhuraTell init: (ScriptID 34 1) @local147 @local199 @local159) ; Uhura
				(++ global402)
				(self setScript: enterRoom self)
			)
			(1
				(gMessager say: 2 6 62 0 self) ; "I be most troubled, young hero. Unless you be doing something soon, I do not think we be having a prisoner much longer."
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
				(= [local62 0] @local56)
				(simbaTeller init: simba @local56 @local62)
				(simba setScale: scaleX: 156 scaleY: 156 noun: 5 init:)
				(= global402 5)
				(= [local199 0] @local127)
				(= [local199 1] @local135)
				(= [local199 2] @local139)
				(uhuraTell init: (ScriptID 34 1) @local127 @local199 @local143) ; Uhura
				(self setScript: enterRoom self)
			)
			(1
				(gMessager say: 2 6 52 0 self) ; "Welcome again, speaker of peace. Maybe you be here to speak about the prisoner? The Leopardman be caught good."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance eventFour of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(simba
					setScale:
					scaleX: 156
					scaleY: 156
					x: 210
					y: 94
					loop: 5
					cel: 1
					noun: 5
					init:
				)
				(= [local199 0] @local113)
				(= [local199 1] @local119)
				(uhuraTell init: (ScriptID 34 1) @local113 @local199 @local124) ; Uhura
				(self setScript: enterRoom self)
			)
			(1
				(gMessager say: 2 6 44 0 self) ; "Hello, hero friend. There be plenty talk of war with the Warriors. They be thinking it be very good thing to fight the Leopardmen."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance eventThree of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= [local62 0] @local56)
				(simbaTeller init: simba @local56 @local62)
				(simba setScale: scaleX: 156 scaleY: 156 noun: 5 init:)
				(++ global402)
				(= [local199 0] @local98)
				(= [local199 1] @local106)
				(uhuraTell init: (ScriptID 34 1) @local98 @local199 @local110) ; Uhura
				(self setScript: enterRoom self)
			)
			(1
				(gMessager say: 2 6 36 0 self) ; "So hero of the Katta, you be seeing many new things and people. Maybe you learn more about them here."
			)
			(2
				(HandsOn)
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
				(HandsOff)
				(simba
					setScale:
					scaleX: 156
					scaleY: 156
					x: 210
					y: 94
					loop: 5
					cel: 1
					noun: 5
					init:
				)
				(= [local199 0] @local71)
				(= [local199 1] @local79)
				(= [local199 2] @local82)
				(= [local199 3] @local86)
				(= [local199 4] @local89)
				(uhuraTell init: (ScriptID 34 1) @local71 @local199 @local92) ; Uhura
				(++ global402)
				(self setScript: enterRoom self)
			)
			(1
				(gMessager say: 2 6 23 0 self) ; "How do you be liking our village? It be not large, for it holds but a few families this time of year. Next season we move to a larger village and more families will be joining us."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance exitRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: PolyPath (gEgo x:) (+ (gEgo y:) 40) self
				)
			)
			(1
				(gCurRoom newRoom: 420)
			)
		)
	)
)

(instance egoLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo (ScriptID 34 1) self) ; Uhura
			)
			(1
				(gMessager say: 2 6 21 0 self) ; "You be right hero of Shapeir, we be sitting too much. We should go out to the village."
			)
			(2
				(if (uhuraHead cycler:)
					((uhuraHead cycler:) dispose:)
				)
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 0 9)
				(= cycles 3)
			)
			(3
				(gMessager say: 6 6 14 0 self) ; "The Simbani celebrate your arrival with meat, milk, and dancing. It is late when you finally make it back to your hut."
			)
			(4
				(gCurRoom newRoom: 430)
			)
		)
	)
)

(instance uhuraSpeaks of Script
	(properties)

	(method (doit)
		(if (and (== state 1) (not (IsObject gFastCast)))
			(= cycles 1)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo (ScriptID 34 1) self) ; Uhura
			)
			(1 0)
			(2
				(= cycles 18)
			)
			(3
				(gMessager say: 2 6 22 0 self) ; "It be time we be sitting too much. Maybe we go out to the village."
			)
			(4
				(if (uhuraHead cycler:)
					((uhuraHead cycler:) dispose:)
				)
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 0 9)
				(= cycles 6)
			)
			(5
				(gMessager say: 6 6 14 0 self) ; "The Simbani celebrate your arrival with meat, milk, and dancing. It is late when you finally make it back to your hut."
			)
			(6
				(gCurRoom newRoom: 430)
			)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					normalize:
					x: 110
					y: 180
					actions: egoActions
					setScale:
					scaleX: 156
					scaleY: 156
					setMotion: PolyPath 110 150 self
					noun: 4
					init:
				)
				((ScriptID 34 1) ; Uhura
					view: 433
					loop: 2
					cel: 0
					x: 192
					y: 92
					setScale:
					scaleX: 156
					scaleY: 156
					noun: 2
					init:
				)
				(uhuraHead setScale: scaleX: 160 scaleY: 160 init:)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance eventOne of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= [local49 0] @local22)
				(= [local49 1] @local28)
				(= [local49 2] @local31)
				(= [local49 3] @local35)
				(= [local49 4] @local40)
				(rakeeshTell init: (ScriptID 35 1) @local22 @local49 @local43) ; Rakeesh
				((ScriptID 34 0) ; uhuraTalker
					x: 196
					y: 10
					textX: -175
					textY: 3
					talkWidth: 140
				)
				(if (gEgo looper:)
					((gEgo looper:) dispose:)
					(gEgo looper: 0)
				)
				(gEgo
					view: 40
					setLoop: 1
					x: 240
					y: 135
					setCycle: 0
					setCel: 255
					actions: egoActions
					setScale:
					scaleX: 156
					scaleY: 156
					init:
					noun: 4
				)
				(= local2 1)
				((ScriptID 35 1) ; Rakeesh
					view: 432
					setScale:
					scaleX: 128
					scaleY: 128
					loop: 3
					cel: 0
					x: 87
					y: 105
					setPri: 4
					noun: 1
					ignoreActors: 1
					signal: (| ((ScriptID 35 1) signal:) $1000) ; Rakeesh
					init:
					stopUpd:
				)
				(= [local62 0] @local56)
				(simbaTeller init: simba @local56 @local62)
				(simba
					setScale:
					scaleX: 156
					scaleY: 156
					x: 109
					y: 109
					setStep: 2 1
					noun: 5
					init:
				)
				(= [local199 0] @local64)
				(uhuraTell init: (ScriptID 34 1) @local64 @local199) ; Uhura
				((ScriptID 34 1) ; Uhura
					view: 433
					loop: 2
					cel: 0
					x: 192
					y: 92
					setScale:
					scaleX: 156
					scaleY: 156
					noun: 2
					init:
				)
				(uhuraHead setScale: scaleX: 160 scaleY: 160 init:)
				(self setScript: checkTime self)
			)
			(1
				(gEgo setScript: timeEgo)
				(++ global402)
				(gMessager say: 1 6 1 0 self) ; "It is good to be back in your own hut again, is it not Uhura?"
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance checkTime of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local6 (GetTime))
				(= cycles 1)
			)
			(1
				(= cycles 5)
			)
			(2
				(= local7 (- (= temp0 (GetTime)) local6))
				(= ticks 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sitDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (gEgo looper:)
					((gEgo looper:) dispose:)
					(gEgo looper: 0)
				)
				(gEgo
					view: 40
					setLoop:
						(if (>= (gEgo x:) ((ScriptID 34 1) x:)) 1 else 0) ; Uhura
					setCycle: End self
				)
				(= local3 (= local2 1))
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoGetUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local3 1)
				(gEgo setCel: (gEgo lastCel:) setCycle: Beg self)
			)
			(1
				(= local2 0)
				(HandsOn)
				(gEgo view: 0 normalize: setMotion: PolyPath local0 local1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance timeEgo of Script
	(properties)

	(method (doit)
		(if (or (gEgo mover:) local3)
			(if (>= local4 10)
				(= local3 0)
				(= cycles 1)
			else
				(= local3 0)
				(= cycles (localproc_0 10))
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (localproc_0 10))
			)
			(1
				(gCurRoom setScript: uhuraSpeaks)
			)
		)
	)
)

(instance firePlace of Feature
	(properties
		x 172
		y 140
		noun 9
		nsTop 132
		nsLeft 155
		nsBottom 149
		nsRight 189
		sightAngle 180
	)
)

(instance shield of Feature
	(properties
		x 235
		y 46
		noun 10
		nsTop 25
		nsLeft 223
		nsBottom 68
		nsRight 248
		sightAngle 180
	)
)

(instance pot of Feature
	(properties
		x 252
		y 147
		noun 11
		nsTop 136
		nsLeft 234
		nsBottom 159
		nsRight 270
		sightAngle 180
	)
)

(instance leftBench of Feature ; UNUSED
	(properties
		x 85
		y 96
		nsTop 81
		nsLeft 31
		nsBottom 112
		nsRight 140
		sightAngle 180
	)
)

(instance rightBench of Feature
	(properties
		x 227
		y 90
		noun 13
		nsTop 81
		nsLeft 172
		nsBottom 114
		nsRight 283
		sightAngle 180
	)
)

(instance wallSkin of Feature
	(properties
		x 79
		y 51
		noun 14
		nsTop 25
		nsLeft 32
		nsBottom 77
		nsRight 127
		sightAngle 180
	)
)

(instance mat of Feature
	(properties
		x 87
		y 95
		noun 12
		sightAngle 40
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((gEgo script:) 0)
					((== global402 1) 0)
					((== (gEgo view:) 40) 0)
					(else
						(gEgo setScript: sitDown)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance uhuraHead of Prop
	(properties
		x 192
		y 64
		noun 2
		view 433
		signal 16384
		detailLevel 3
	)
)

(instance fire of Prop
	(properties
		x 171
		y 141
		noun 3
		view 423
		priority 15
		signal 16400
	)
)

(instance simba of Actor
	(properties
		x 189
		y 111
		noun 5
		view 425
		loop 4
		cel 3
		signal 8192
		detailLevel 3
	)
)

