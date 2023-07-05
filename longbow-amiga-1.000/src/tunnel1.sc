;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 560)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use rhEgo)
(use RTEyeCycle)
(use PChase)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	tunnel1 0
)

(local
	[local0 2]
	[local2 5] = [1560 1 2 1 0]
	[local7 9] = [1560 3 2 4 1 1 3 1 0]
	[local16 7] = [1560 9 1 1 2 1 0]
	[local23 6] = [1560 13 1 1 2 0]
	[local29 4] = [1560 16 1 0]
	[local33 9] = [1560 42 1 2 1 1 2 1 0]
	[local42 6] = [1560 39 1 2 1 0]
	[local48 3] = [-1 {Hal} 11]
	[local51 3] = [-1 {Hob} 12]
	[local54 3] = [-1 {Dicken} 13]
)

(procedure (localproc_0)
	(SetMessageColor 11)
	(Say &rest 80 {Hal})
)

(procedure (localproc_1)
	(SetMessageColor 12)
	(Say &rest 80 {Hob})
)

(procedure (localproc_2)
	(SetMessageColor 13)
	(Say &rest 80 {Dicken})
)

(instance tunnel1 of Rm
	(properties
		picture 560
		style -32758
		north 561
		east 562
	)

	(method (init)
		(super init:)
		(DoSound sndGLOBAL_REVERB 20)
		(gTheIconBar disable: 5)
		(SetIcon 0)
		(if (and (OneOf gDay 5 6) (or (IsFlag 125) (IsFlag 56)))
			(gGame setCursor: 0 1 10 25)
			(sonHal heading: 225 loop: 2 posn: 100 155 init:)
			(sonHob heading: 180 loop: 2 posn: 130 155 init:)
			(sonDicken heading: 270 loop: 2 posn: 190 155 init:)
		)
		(switch gPrevRoomNum
			(562 ; tunnel3
				(if
					(and
						(OneOf gDay 5 6)
						(or (IsFlag 125) (IsFlag 56))
						(IsFlag 114)
					)
					(NormalEgo)
					(gEgo
						setHeading: 0
						posn: 160 171
						ignoreControl: 1
						ignoreHorizon: 0
						init:
					)
					(HandsOff)
					(ClearFlag 114)
					(self setScript: comeFromEstWithSons)
				else
					(NormalEgo)
					(gEgo
						setHeading: 270
						posn: 283 161
						ignoreControl: 1
						ignoreHorizon: 0
						init:
					)
					(gGame setCursor: 0 1 10 25)
				)
			)
			(561 ; tunnel2
				(NormalEgo)
				(gEgo posn: 22 160 ignoreControl: 1 ignoreHorizon: 0 init:)
				(gGame setCursor: 0 1 10 25)
			)
			(550
				(cond
					((not (IsFlag 107))
						(NormalEgo)
						(HandsOff)
						(gEgo
							posn: 11 170
							ignoreControl: 1
							ignoreHorizon: 0
							init:
						)
						(gEgo setScript: firstInFrom550)
					)
					((OneOf gDay 5 6)
						(if (or (IsFlag 125) (IsFlag 56))
							(NormalEgo)
							(gEgo
								posn: 22 160
								ignoreControl: 1
								ignoreHorizon: 0
								init:
							)
							(gCurRoom setScript: withSon5B6A)
						else
							(NormalEgo)
							(gEgo
								loop: 0
								posn: 11 160
								ignoreControl: 1
								ignoreHorizon: 0
								init:
							)
							(gGame setCursor: 0 1 10 25)
						)
					)
					(else
						(NormalEgo)
						(gEgo
							loop: 0
							posn: 11 160
							ignoreControl: 1
							ignoreHorizon: 0
							init:
							setMotion: MoveTo 100 167 self
						)
					)
				)
			)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 73 158 209 158 209 153 73 153
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 24 148 0 154 0 186 202 186 276 186 319 146 211 151 211 160 66 160 66 151 40 151 24 121 14 121
					yourself:
				)
		)
		(AddToFeatures tunnelWall caskArea eastTunlWay westTunlWay tunnelFloor)
		(if (!= (gRgnMusic number:) 560)
			(gRgnMusic number: 560 loop: -1 play:)
		)
		(HandsOn)
	)

	(method (dispose)
		(DoSound sndGLOBAL_REVERB 0)
		(super dispose: &rest)
	)

	(method (doit)
		(cond
			((gCurRoom script:) 0)
			((< (gEgo x:) 10)
				(if (and (== gDisguiseNum 5) (or (IsFlag 125) (IsFlag 56))) ; abbey monk
					(cond
						((not (IsFlag 108))
							(gCurRoom setScript: caskClikFirst)
						)
						((IsFlag 108)
							(gCurRoom setScript: caskClikSecond)
						)
						(else
							(gCurRoom newRoom: 550)
						)
					)
				else
					(gCurRoom newRoom: 550)
				)
			)
			((> (gEgo x:) 290)
				(HandsOff)
				(gCurRoom newRoom: 562) ; tunnel3
			)
			((< (gEgo y:) 140)
				(HandsOff)
				(gCurRoom newRoom: 561) ; tunnel2
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Longbow
				(if (== gDay 10)
					(Say 1560 25 1) ; "Loosing an arrow into the tunnel would serve little purpose, save perhaps to lose it."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sonHal of Actor
	(properties
		x 109
		y 160
		view 434
		signal 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1560 51 1) ; "They're good, brave lads, all three."
			)
			(5 ; Talk
				(localproc_0 1560 26 self) ; "We should speak in whispers, or not at all."
				(SetMessageColor 0)
			)
			(3 ; Do
				(Say 1560 50 self) ; "The boys have nothing I need."
				(SetMessageColor 0)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(localproc_0 1560 27 self) ; "We could never repay what we owe you now. I couldn't accept any more."
						(SetMessageColor 0)
					)
					(2 ; halfHeart
						(localproc_0 1560 28 self) ; "You've freed us from the dungeon, Robin.  We're too deeply in your debt to accept gifts."
						(SetMessageColor 0)
					)
					(14 ; amethyst
						(localproc_0 1560 28 self) ; "You've freed us from the dungeon, Robin.  We're too deeply in your debt to accept gifts."
						(SetMessageColor 0)
					)
					(12 ; puzzleBox
						(localproc_0 1560 29 self) ; "Nay, I could not take it."
						(SetMessageColor 0)
					)
					(18 ; waterRing
						(localproc_0 1560 30 self) ; "Please, I owe you too much to take gifts."
						(SetMessageColor 0)
					)
					(10 ; fireRing
						(localproc_0 1560 30 self) ; "Please, I owe you too much to take gifts."
						(SetMessageColor 0)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sonHob of Actor
	(properties
		x 161
		y 169
		view 434
		loop 1
		cel 1
		signal 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1560 51 1) ; "They're good, brave lads, all three."
			)
			(5 ; Talk
				(localproc_1 1560 31 self) ; "'Ods Blood, I'll be glad to see sunshine again."
				(SetMessageColor 0)
			)
			(3 ; Do
				(Say 1560 50 self) ; "The boys have nothing I need."
				(SetMessageColor 0)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(localproc_1 1560 32 self) ; "Nay, you've done enough for us."
						(SetMessageColor 0)
					)
					(2 ; halfHeart
						(localproc_1 1560 33 self) ; "I couldn't accept it."
						(SetMessageColor 0)
					)
					(14 ; amethyst
						(localproc_1 1560 33 self) ; "I couldn't accept it."
						(SetMessageColor 0)
					)
					(12 ; puzzleBox
						(localproc_1 1560 34 self) ; "I've no idea how to open such a thing."
						(SetMessageColor 0)
					)
					(18 ; waterRing
						(localproc_1 1560 35 self) ; "This is too fine for me. I owe you too much already."
						(SetMessageColor 0)
					)
					(10 ; fireRing
						(localproc_1 1560 35 self) ; "This is too fine for me. I owe you too much already."
						(SetMessageColor 0)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sonDicken of Actor
	(properties
		y 173
		view 434
		cel 1
		signal 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1560 51 1) ; "They're good, brave lads, all three."
			)
			(5 ; Talk
				(localproc_2 1560 36 self) ; "Wait'll I tell Mum about all this!"
				(SetMessageColor 0)
			)
			(3 ; Do
				(Say 1560 50 self) ; "The boys have nothing I need."
				(SetMessageColor 0)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(localproc_2 1560 37 self) ; "Thank you, but Hal will wallop me if I take it."
						(SetMessageColor 0)
					)
					(2 ; halfHeart
						(localproc_2 1560 38 self) ; "Thank you, but Mum would wallop me for taking something I haven't earned."
						(SetMessageColor 0)
					)
					(14 ; amethyst
						(localproc_2 1560 38 self) ; "Thank you, but Mum would wallop me for taking something I haven't earned."
						(SetMessageColor 0)
					)
					(12 ; puzzleBox
						(gCurRoom setScript: dickenPuzBoxTalk)
					)
					(18 ; waterRing
						(gCurRoom setScript: waterOrFireRingTalk)
					)
					(10 ; fireRing
						(gCurRoom setScript: waterOrFireRingTalk)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cannotUsePuzbox of SpecialDoVerb ; UNUSED
	(properties)

	(method (doVerb theVerb invItem)
		(if (== theVerb 4) ; Inventory
			(switch invItem
				(1 ; horn
					(Say 1560 49 self) ; "I dare not wind my horn here."
					(SetMessageColor 0)
				)
			)
		)
	)
)

(instance firstInFrom550 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(HandsOff)
				(SetFlag 107)
				(gEgo ignoreActors: 1 show: setMotion: MoveTo 100 160 self)
			)
			(2
				(SetMessageColor 0)
				(SayModeless 1560 0 self) ; "The tunnel from the cask leads up into this larger tunnel which forks in two directions."
			)
			(3
				(HandsOn)
				(SetIcon 0)
				(gGame setCursor: 0 1 10 25)
				(self dispose:)
			)
		)
	)
)

(instance withSon5B6A of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Converse 2 @local2 9 0 @local51 1 self) ; "What now, Robin?"
			)
			(1
				(gGame setCursor: 0 1 10 25)
				(self dispose:)
			)
		)
	)
)

(instance comeFromEstWithSons of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Converse 4 @local7 9 0 @local48 1 @local51 2 @local54 4 self) ; "What happened in the Abbey?"
			)
			(1
				(HandsOn)
				(gGame setCursor: 0 1 10 25)
				(self dispose:)
			)
		)
	)
)

(instance caskArea of Feature
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 0 124 16 125 30 147 26 163 0 167
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1560 17 1) ; "A smaller tunnel leads to the secret entrance in the cask."
			)
			(3 ; Do
				(if (or (IsFlag 125) (IsFlag 56))
					(gCurRoom setScript: caskConvToSon)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tunnelFloor of Feature
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 16 122 31 122 46 142 48 148 62 150 93 155 139 155 165 147 208 152 253 149 276 149 289 150 280 162 249 157 211 163 200 170 176 172 159 183 150 170 132 166 113 162 81 174 76 165 45 160 22 165
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1560 48 1) ; "The floor of the tunnel is worn sandstone."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance caskConvToSon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Converse 2 @local16 9 0 @local48 1 self) ; "Mark you this third tunnel."
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance caskClikFirst of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 108)
				(gEgo setMotion: PolyPath 0 173 self)
			)
			(1
				(gEgo hide:)
				(= cycles 95)
			)
			(2
				(gEgo loop: 0 show:)
				(= cycles 6)
			)
			(3
				(gEgo setMotion: PolyPath 90 160 self)
			)
			(4
				(Converse 2 @local23 9 0 @local48 1 self) ; "There's no one in the cellar, though I hear some music."
			)
			(5
				(sonHob setHeading: 270)
				(sonDicken setHeading: 270)
				(gEgo setHeading: 270)
				(= ticks 6)
			)
			(6
				(sonHob setCycle: SyncWalk setMotion: PFollow sonHal 40)
				(sonDicken setCycle: SyncWalk setMotion: PFollow sonHal 80)
				(sonHal setCycle: Walk setMotion: MoveTo 5 155 self)
				(gEgo setCycle: SyncWalk setMotion: PFollow sonHal 15)
			)
			(7
				(HandsOn)
				(gCurRoom newRoom: 550)
				(self dispose:)
			)
		)
	)
)

(instance caskClikSecond of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 109)
				(gEgo setMotion: PolyPath 0 173 self)
			)
			(1
				(gEgo hide:)
				(= cycles 95)
			)
			(2
				(gEgo loop: 0 show:)
				(= cycles 6)
			)
			(3
				(gEgo setMotion: PolyPath 90 165 self)
			)
			(4
				(Converse 1 @local29 9 0 self) ; "This way, lads. The cellar is still empty."
			)
			(5
				(sonHob setHeading: 270)
				(sonDicken setHeading: 270)
				(gEgo setHeading: 270)
				(= ticks 6)
			)
			(6
				(sonHob setCycle: SyncWalk setMotion: PFollow sonHal 40)
				(sonDicken setCycle: SyncWalk setMotion: PFollow sonHal 80)
				(sonHal setCycle: Walk setMotion: MoveTo 5 155 self)
				(gEgo setCycle: SyncWalk setMotion: PFollow sonHal 15)
			)
			(7
				(HandsOn)
				(gCurRoom newRoom: 550)
				(self dispose:)
			)
		)
	)
)

(instance eastTunlWay of Feature
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 277 147 280 123 280 108 281 98 278 89 277 80 281 72 290 72 295 68 305 69 304 76 305 80 303 88 305 94 310 104 308 117 312 121 303 125 295 141 292 149
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (not (IsFlag 105))
					(Say 1560 20) ; "It seems to go on straight until it vanishes into darkness."
					(Say 1560 21 1) ; "By my reckoning, it must run to the east beneath the streets of Nottingham town itself."
				else
					(Say 1560 22 1) ; "This branching leads to the Abbey."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance westTunlWay of Feature
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 14 120 15 79 11 74 12 62 20 51 30 61 34 63 33 79 35 84 35 91 38 98 34 104 33 118
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (not (IsFlag 106))
					(Say 1560 18 1) ; "It climbs steeply upwards, probably somewhere up into the castle atop this bluff."
				else
					(Say 1560 19 1) ; "This branching leads up to the castle dungeon."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tunnelWall of Feature
	(properties)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 319 189 0 189 0 168 39 161 54 162 75 166 81 176 98 168 118 164 130 170 139 170 151 175 156 187 188 172 202 173 215 165 230 161 255 158 282 164 293 151 300 132 313 122 310 114 312 108 305 90 306 81 305 67 294 68 279 71 275 86 279 95 277 146 221 147 163 140 159 147 72 146 35 120 34 108 38 96 35 83 35 63 29 59 21 51 11 60 13 79 13 124 0 123 0 0 319 0
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Say 1560 23 1) ; "The sandstone is soft and crumbles easily."
			)
			(2 ; Look
				(Say 1560 24 1) ; "Sandstone, of course."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance waterOrFireRingTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Converse 2 @local33 @local54 0 @local48 1 self) ; "I like rings--"
			)
			(1
				(SetMessageColor 0)
				(self dispose:)
			)
		)
	)
)

(instance dickenPuzBoxTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Converse 2 @local42 @local54 0 @local48 1 self) ; "What a wondrous box! Hal,  may I?"
			)
			(1
				(SetMessageColor 0)
				(self dispose:)
			)
		)
	)
)

