;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 220)
(include sci.sh)
(use Main)
(use n010)
(use goGet)
(use Interface)
(use PAvoider)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	Room220 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	[local9 200]
)

(procedure (localproc_0)
	(bridge init:)
	(tree1 init:)
	(tree2 init:)
	(rock init:)
	(wall init:)
	(bush init:)
	(flower init:)
	(mountain init:)
	(sky init:)
	(gate init:)
	(grass init:)
)

(instance Room220 of FRoom
	(properties
		lookStr {You can see the town to the north.}
		picture 220
		style 0
		horizon 80
		north 170
		east 230
		south 270
		west 210
		invX 102
		invY 135
		friendX 150
		friendY 126
		northX 185
		northY 83
		southX 190
		southY 169
		eastX 313
		eastY 125
		westX 5
		westY 136
	)

	(method (init)
		(if (> global225 0)
			(Load rsSOUND global225)
		)
		(if (and (== (gBeautyStory state:) 3) (not (proc10_17 InvFriend)))
			(Load rsSOUND 49)
		)
		(= local6 (proc10_17 InvFriend))
		(if (== gPrevRoomNum 170)
			(self defeatEntrance: 1)
		)
		(super init:)
		(proc10_29)
		(gTheIconBar enable: show:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 173 0 160 111 160 112 173
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 228 173 228 161 319 161 319 173
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 141 82 183 84 195 94 216 125 182 128 165 106 108 101 112 128 103 133 93 138 61 131 15 130 0 124 0 0 143 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 193 0 319 0 319 91 311 96 283 106 272 105 259 104 261 111 262 125 242 126 217 101 192 81
					yourself:
				)
		)
		(localproc_0)
		(if (= local6 (proc10_17 InvFriend))
			(= local6 (local6 regActor:))
		)
		(cond
			((IsFlag 5) 0)
			((== (gBeautyStory state:) 3) 0)
			((and (== (gBremenStory state:) 0) (!= global145 0)) 0)
			((not (proc10_17 InvFriend))
				(Load rsSOUND 150)
				(frog cycleSpeed: 3 moveSpeed: 3 setCycle: Walk init:)
			)
		)
		(cond
			(
				(and
					(== global145 5)
					(or (== global144 gCindStory) (== global144 gSnowStory))
				)
				(= global140 2)
				(= local8 2)
				(self setRegions: 400) ; endGame
			)
			((and (!= global145 0) (not (proc10_18)) (== (gBremenStory state:) 0))
				(gBremenStory selectCode: bremenSelect)
				(gEgo doCode: egoDo220brem)
				(LoadMany rsSOUND 19 125)
				(= local3 ((gInventory at: 4) regActor:))
				(local3
					posn: friendX friendY
					view: 635
					loop: 2
					cel: 0
					doCode: roostDo220
					selection: 0
					lookStr: {You see a rooster.}
					description: {Rooster}
					init:
				)
			)
			((and (== (gBeautyStory state:) 3) (not (proc10_17 InvFriend)))
				(gEgo doCode: egoDo220beaut)
				(= local4 ((gInventory at: 8) regActor:))
				(local4
					view: 692
					setLoop: -1
					setCycle: StopWalk
					normal: 1
					posn: friendX friendY
					doCode: beautyDo220
					selection: 0
					init:
				)
			)
		)
		(if (and (not (IsFlag 3)) (IsFlag 5))
			(gBookEnd init: setScript: escape)
		)
		(stLeft setCycle: Fwd setPri: 5 init: ignoreActors: 1)
		(stRight setCycle: Fwd setPri: 5 init: ignoreActors: 1)
		(forestSound play:)
	)

	(method (enterSpecial)
		(if local6
			(self setScript: friendFirst self)
		else
			(self setScript: enterEgo self)
		)
	)

	(method (cue)
		(super cue:)
		(cond
			((== local8 2)
				(self setScript: (ScriptID 400 1)) ; wyrmScript
			)
			((IsFlag 5) 0)
			((and (not (proc10_18)) (!= global145 0) (== (gBremenStory state:) 0))
				(gCurRoom setScript: enterBeforeStory)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script 0)
			((not (IsFlag 5)) 0)
			((IsFlag 3) 0)
			((not (gEgo mover:)) 0)
			((<= (Abs (- (gEgo heading:) 180)) 55)
				(gCurRoom setScript: bookChase self)
			)
		)
		(cond
			(script 0)
			((and (== (gEgo onControl:) 4) (not (gCurRoom script:)))
				(gCurRoom setScript: crossBridge)
			)
		)
		(cond
			((not (gCast contains: local3)) 0)
			(script 0)
			((gBeautyStory inProgress:) 0)
			(local5 0)
			(
				(and
					(not (gBremenStory selected:))
					(or
						(< (gEgo x:) 15)
						(> (gEgo y:) 160)
						(and (< 188 (gEgo x:) 248) (< (gEgo y:) 125))
						(> (gEgo x:) 308)
					)
				)
				(gCurRoom setScript: encourage)
			)
		)
		(cond
			((frog script:) 0)
			((IsFlag 5) 0)
			((== (gBeautyStory state:) 3) 0)
			((and (== (gBremenStory state:) 0) (!= global145 0)) 0)
			((proc10_17 InvFriend) 0)
			((and (gCast contains: frog) (< (gEgo distanceTo: frog) 40))
				(frog setScript: frogJump)
			)
		)
	)

	(method (dispose)
		(if (and (== (gBeautyStory state:) 3) (gCast contains: local4))
			(gEgo doCode: 0)
			(local4 doCode: 0)
		)
		(if defeatEntrance
			(self defeatEntrance: 0)
		)
		(if (IsFlag 5)
			(SetFlag 3)
		)
		(gBremenStory selectCode: 0)
		(if (gGlobalMusic handle:)
			(gGlobalMusic fade: 0 15 12 1)
			(= global225 37)
		)
		(super dispose: &rest)
	)
)

(instance forestSound of Sound
	(properties
		flags 1
		number 153
		loop -1
	)
)

(instance enterEgo of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(NormalEgo 5 global139)
				(gEgo
					setCycle: StopWalk
					setLoop: -1
					posn: 188 90
					setHeading: 180
					init:
				)
				(= cycles 1)
			)
			(1
				(gEgo setScript: crossBridge self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance escape of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gBookEnd
					setCycle: Walk
					posn: 195 150
					setMotion: PolyPath 195 200 self
				)
			)
			(1
				(gBookEnd dispose:)
				(self dispose:)
			)
		)
	)
)

(instance bookChase of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 195 180 self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance friendFirst of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((local6 regActor:)
					setHeading: 180
					posn: (+ (gCurRoom northX:) 15) (+ (gCurRoom northY:) 5)
					setCycle: StopWalk
					init:
					setMotion:
						PolyPath
						(+ (gCurRoom northX:) 20)
						(+ (gCurRoom northY:) 60)
						self
				)
				(NormalEgo 5 global139)
				(gEgo
					setHeading: 180
					posn: (gCurRoom northX:) (gCurRoom northY:)
					init:
				)
			)
			(1
				(gEgo
					setMotion:
						PolyPath
						(+ (gCurRoom northX:) 5)
						(+ (gCurRoom northY:) 5)
						self
				)
			)
			(2
				(local6 setMotion: NPFollow gEgo 40)
				(self dispose:)
			)
		)
	)
)

(instance frogJump of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(frogSound play:)
				(cond
					((and (<= (frog x:) 165) (< (frog y:) 132))
						(frog setMotion: PolyPath 89 110 self)
					)
					((and (>= (frog x:) 255) (< (frog y:) 132))
						(frog setMotion: PolyPath 320 120 self)
					)
					((and (< 165 (frog x:) 255) (< (frog y:) 132))
						(if (< (gEgo x:) (frog x:))
							(frog
								setMotion:
									PolyPath
									(+ (frog x:) 30)
									(frog y:)
									self
							)
						else
							(frog
								setMotion:
									PolyPath
									(- (frog x:) 30)
									(frog y:)
									self
							)
						)
					)
					(else
						(switch
							(= local1
								(/
									(GetAngle
										(frog x:)
										(frog y:)
										(gEgo x:)
										(gEgo y:)
									)
									90
								)
							)
							(0
								(frog
									setMotion:
										PolyPath
										(frog x:)
										(+ (frog y:) 16)
										self
								)
							)
							(1
								(frog
									setMotion:
										PolyPath
										(- (frog x:) 30)
										(frog y:)
										self
								)
							)
							(2
								(frog
									setMotion:
										PolyPath
										(frog x:)
										(- (frog y:) 16)
										self
								)
							)
							(3
								(frog
									setMotion:
										PolyPath
										(+ (frog x:) 30)
										(frog y:)
										self
								)
							)
						)
					)
				)
			)
			(1
				(frogSound play:)
				(cond
					((< (frog x:) 10)
						(frog setMotion: MoveTo (- (frog x:) 30) (frog y:) self)
					)
					((> (frog x:) 310)
						(frog setMotion: MoveTo (+ (frog x:) 30) (frog y:) self)
					)
					((> (frog y:) 160)
						(frog
							setMotion: PolyPath (frog x:) (+ (frog y:) 25) self
						)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(if
					(or
						(< (frog x:) 0)
						(< (frog y:) 115)
						(> (frog x:) 320)
						(> (frog y:) 180)
					)
					(frog dispose:)
				)
				(self dispose:)
			)
		)
	)
)

(instance enterLookingBeauty of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalMusic2 number: 49 priority: 15 setLoop: -1 play:)
				((local4 client:) moveTo: gEgo)
				(gTheIconBar curInvIcon: (gInventory at: 8) show:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 220 150 self)
			)
			(2
				(gEgo
					normal: 0
					ignoreActors: 0
					setCycle: Walk
					setAvoider: 0
					setMotion: NPFollow local4 40
				)
				(local4 setAvoider: PAvoider setMotion: PolyPath 180 170 self)
			)
			(3
				(ClearFlag 5)
				(gBeautyStory incState:)
				(gCurRoom newRoom: 270)
			)
		)
	)
)

(instance crossBridge of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local6
					(= local7 (local6 mover:))
					(local6 mover: 0)
				)
				(if (> 105 (gEgo y:) 85)
					(gEgo ignoreActors: 0 setMotion: PolyPath 220 130 self)
					(if local6
						(local6
							setMotion:
								PolyPath
								(+ (gCurRoom northX:) 20)
								(+ (gCurRoom northY:) 60)
						)
					)
				else
					(gEgo ignoreActors: 0 setMotion: PolyPath 185 85 self)
					(if local6
						(local6 setMotion: 0)
					)
				)
			)
			(1
				(if local6
					(local6 setMotion: 0)
					(local6 mover: local7)
				)
				(if (< (gEgo y:) 88)
					(gCurRoom newRoom: 170)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance egoGetWater of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 140 107 self)
			)
			(1
				(gEgo
					view: (+ 70 global139)
					setLoop: 1
					cel: 0
					setCycle: End self
				)
			)
			(2
				(Print 220 0) ; "The water tastes like cherries here."
				(NormalEgo 5 global139)
				(self dispose:)
			)
		)
	)
)

(instance storySelect of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local2 1)
				(gBremenStory selected: 1 incState:)
				(= global143 gBremenStory)
				(if (gGame script:)
					(gGame setScript: 0)
					(gGlobalMusic2 stop:)
				)
				(stLeft setScript: bremenMusic)
				(self setScript: (ScriptID 91 1) self) ; DisplayStart
			)
			(1
				(proc10_13 0 local3 gEgo self 0 220 1)
			)
			(2
				(proc10_13 0 local3 gEgo self 1 220 2)
			)
			(3
				((local3 client:) moveTo: gEgo)
				(gTheIconBar curInvIcon: (gInventory at: 4) show:)
				(gEgo doCode: (gEgoTravCodeSet at: 0))
				(local3
					view: 634
					setLoop: -1
					setStep: 2 2
					setCycle: StopWalk
					doCode: (gFriendTravCodeSet at: 0)
					setMotion: NPFolRoos gEgo 40
				)
				(= local6 local3)
				(= cycles 1)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance bremenMusic of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and local0 (== (gGlobalMusic prevSignal:) -1))
			(= local0 0)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalMusic number: 19 priority: 15 setLoop: 1 play:)
				(= local0 1)
			)
			(1
				(= global225 0)
				(gGlobalMusic stop:)
				(gGlobalMusic2 number: 37 setLoop: -1 play: self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance encourage of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local5 1)
				(gEgo setMotion: 0)
				(= cycles 1)
			)
			(1
				(Face gEgo local3)
				(= cycles 1)
			)
			(2
				(proc10_13 3 local3 gEgo self 1 220 3)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance roostSound of Sound
	(properties
		flags 1
		number 125
	)
)

(instance enterBeforeStory of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roostSound play:)
				(local3 setCycle: End self)
			)
			(1
				(local3 setCycle: Beg self)
			)
			(2
				(local3
					setLoop: 0
					cel: 0
					setCycle: CT 7 1
					setStep: 2 2
					setMotion: MoveTo 164 126 self
				)
			)
			(3
				(roostSound play:)
				(local3 setCycle: End self)
			)
			(4
				(local3 setLoop: 3 setCycle: End self)
			)
			(5
				(local3 setCycle: Beg self)
			)
			(6
				(local3
					setLoop: 1
					cel: 0
					setStep: 2 2
					setCycle: CT 7 1
					setMotion: MoveTo 150 126 self
				)
			)
			(7
				(local3 setCycle: End self)
			)
			(8
				(proc10_13 1 local3 gEgo self 1 220 4)
			)
			(9
				(local3 ignoreActors: 0)
				(self dispose:)
			)
		)
	)
)

(instance bremenSelect of Code
	(properties)

	(method (doit)
		(gCurRoom setScript: storySelect)
	)
)

(instance egoDo220brem of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(switch (gBremenStory state:)
					(0
						(switch (gEgo selection:)
							(0
								(proc10_13 0 gEgo local3 -1 1 220 5)
								(proc10_13 3 local3 gEgo -1 0 220 6)
								(proc10_13 3 local3 gEgo -1 0 220 7)
								(proc10_13 3 local3 gEgo -1 1 220 8)
							)
							(1
								(proc10_13 3 gEgo local3 -1 1 220 9)
								(proc10_13 1 local3 gEgo -1 0 220 10)
								(proc10_13 1 local3 gEgo -1 1 220 11)
								(proc10_13 0 gEgo local3 -1 1 220 12)
								(proc10_13 1 local3 gEgo -1 1 220 13)
							)
							(2
								(proc10_13 0 gEgo local3 -1 1 220 14)
								(proc10_13 0 local3 gEgo -1 1 220 15)
								(proc10_13 0 local3 gEgo -1 1 220 16)
								(proc10_13 0 local3 gEgo -1 1 220 17)
							)
							(else
								(proc10_13 0 gEgo local3 -1 1 220 18)
								(proc10_13 0 local3 gEgo -1 1 220 19)
							)
						)
					)
				)
				(gEgo incSel:)
			)
		)
	)
)

(instance roostDo220 of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(switch (gBremenStory state:)
					(0
						(switch (local3 selection:)
							(0
								(proc10_13 3 local3 gEgo -1 1 220 20)
							)
							(1
								(proc10_13 3 local3 gEgo -1 0 220 21)
								(proc10_13 3 local3 gEgo -1 0 220 22)
								(proc10_13 3 local3 gEgo -1 1 220 23)
							)
							(2
								(proc10_13 3 local3 gEgo -1 1 220 24)
							)
							(else
								(proc10_13 0 local3 gEgo -1 1 220 25)
								(proc10_13 0 local3 gEgo -1 1 220 26)
							)
						)
					)
				)
				(local3 incSel:)
			)
		)
	)
)

(instance egoDo220beaut of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(gEgo setScript: egoDo220beautScr)
			)
		)
	)
)

(instance egoDo220beautScr of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc10_13 2 gEgo local4 -1 1 220 27)
				(proc10_13 3 local4 gEgo -1 0 220 28)
				(proc10_13 2 local4 gEgo -1 0 220 29)
				(proc10_13 2 local4 gEgo -1 1 220 30)
				(proc10_13 0 gEgo local4 self 1 220 31)
			)
			(1
				(gCurRoom setScript: enterLookingBeauty)
			)
		)
	)
)

(instance beautyDo220 of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(switch (gBeautyStory state:)
					(3
						(switch (local4 selection:)
							(0
								(proc10_13 3 local4 gEgo -1 0 220 32)
								(proc10_13 3 local4 gEgo -1 0 220 33)
								(proc10_13 3 local4 gEgo -1 1 220 34)
							)
							(1
								(proc10_13 3 local4 gEgo -1 1 220 35)
							)
							(2
								(proc10_13 3 local4 gEgo -1 0 220 36)
								(proc10_13 3 local4 gEgo -1 1 220 37)
							)
							(else
								(proc10_13 3 local4 gEgo -1 0 220 38)
								(proc10_13 3 local4 gEgo -1 0 220 39)
								(proc10_13 3 local4 gEgo -1 1 220 40)
							)
						)
					)
				)
				(local4 incSel:)
			)
		)
	)
)

(instance frogSound of Sound
	(properties
		flags 1
		number 150
	)
)

(instance frog of Actor
	(properties
		x 165
		y 140
		description {Frog}
		lookStr {The frog can hop fast.}
		view 225
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (frog script:))
					(frog setScript: frogJump)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stLeft of Prop
	(properties
		x 138
		y 107
		description {Stream}
		lookStr {The stream flows under the bridge.}
		view 220
		priority 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (gEgo script:))
					(gEgo setScript: egoGetWater)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stRight of Prop
	(properties
		x 275
		y 99
		view 220
		loop 1
	)

	(method (doVerb theVerb)
		(stLeft doVerb: theVerb)
	)
)

(instance bridge of Feature
	(properties
		x 201
		y 117
		description {Bridge}
		sightAngle 90
		onMeCheck 4
		lookStr {The bridge is over the stream.}
	)
)

(instance tree1 of Feature
	(properties
		x 23
		y 84
		description {Tree}
		sightAngle 90
		onMeCheck 8
		lookStr {This tree is an oak.}
	)
)

(instance tree2 of Feature
	(properties
		x 100
		y 82
		description {Tree}
		sightAngle 90
		onMeCheck 16
		lookStr {This tree grows tall.}
	)
)

(instance rock of Feature
	(properties
		x 91
		y 110
		description {Rock}
		sightAngle 90
		onMeCheck 32
		lookStr {The rock is hard to move.}
	)
)

(instance wall of Feature
	(properties
		x 161
		y 69
		description {Wall}
		sightAngle 90
		onMeCheck 64
		lookStr {There is the wall that goes around the town.}
	)
)

(instance bush of Feature
	(properties
		x 252
		y 160
		description {Bush}
		sightAngle 90
		onMeCheck 128
		lookStr {This bush grows near rocks.}
	)
)

(instance flower of Feature
	(properties
		x 114
		y 150
		description {Flower}
		sightAngle 90
		onMeCheck 512
		lookStr {The flowers smell like an old fish.}
	)
)

(instance mountain of Feature
	(properties
		x 216
		y 59
		description {Mountain}
		sightAngle 90
		onMeCheck 1024
		lookStr {The mountain is beyond the town.}
	)
)

(instance sky of Feature
	(properties
		x 173
		y 48
		description {Sky}
		sightAngle 90
		onMeCheck 2048
		lookStr {The sky is bright.}
	)
)

(instance gate of Feature
	(properties
		x 186
		y 68
		description {Gate}
		sightAngle 90
		onMeCheck 4096
		lookStr {This is the gate to the town.}
	)
)

(instance grass of Feature
	(properties
		x 148
		y 150
		description {Grass}
		sightAngle 90
		onMeCheck 8192
		lookStr {The grass is cool here.}
	)
)

