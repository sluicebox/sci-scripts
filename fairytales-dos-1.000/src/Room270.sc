;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 270)
(include sci.sh)
(use Main)
(use n010)
(use goGet)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	Room270 0
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0)
	(tree init:)
	(road init:)
	(branch init:)
	(grass init:)
	(stream init:)
	(bridge init:)
	(plants init:)
	(treeEyes init:)
)

(instance Room270 of FRoom
	(properties
		lookStr {You feel like someone is watching you.}
		picture 270
		style 0
		north 220
		east 280
		south 320
		west 260
		invX 222
		invY 144
		friendX 286
		friendY 37
		northX 160
		northY 93
		southX 180
		southY 180
		eastX 320
		eastY 167
		westY 121
	)

	(method (init)
		(if (> global225 0)
			(Load rsSOUND global225)
		)
		(Load rsSOUND 153)
		(switch (gBremenStory state:)
			(2
				(Load rsSOUND 9)
			)
		)
		(if (IsFlag 5)
			((gInventory at: 1) owner: 0)
		)
		(if (or (== (gBeautyStory state:) 4) (IsFlag 5) (== gPrevRoomNum 220))
			(self defeatEntrance: 1)
		)
		(super init:)
		(proc10_29)
		(gTheIconBar enable: show:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 173 0 157 71 148 165 158 185 173
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 272 173 250 165 319 165 319 173
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 104 0 0 319 0 319 148 259 142 217 135 201 133 183 126 165 122 165 112 185 112 188 105 174 94 193 92 191 2 142 2 148 90 137 104 122 100 104 103 85 103 58 106 45 107 37 105
					yourself:
				)
		)
		(localproc_0)
		(eyes1 init: hide:)
		(if
			(not
				(or
					(proc10_17 InvFriend)
					(== (gBremenStory state:) 2)
					(IsFlag 5)
				)
			)
			(eyes1 setPri: 15 setCycle: Fwd cycleSpeed: 66 show:)
			(eyes2 setPri: 15 setCycle: Fwd cycleSpeed: 78 init:)
			(SetFlag 13)
		)
		(switch (gBremenStory state:)
			(2
				(Load rsSOUND 124)
				(= local1 ((gInventory at: 5) regActor:))
				(gEgo doCode: egoDo270)
				(local1
					view: 640
					signal: 24576
					loop: 0
					cel: 0
					doCode: catDo270
					selection: 0
					normal: 0
					x: 250
					y: 38
					stopUpd:
					init:
				)
			)
		)
		(forestSound play:)
	)

	(method (doit)
		(super doit:)
		(cond
			((gCurRoom script:) 0)
			((== (gEgo onControl:) 256)
				(gCurRoom setScript: exitNorth)
			)
		)
		(if
			(and
				(IsFlag 13)
				(<
					(or (gEgo distanceTo: eyes2) (gEgo distanceTo: eyes1))
					125
				)
			)
			(eyes1 dispose:)
			(eyes2 dispose:)
			(ClearFlag 13)
		)
	)

	(method (dispose)
		(if (== (gBremenStory state:) 3)
			(if (gGlobalMusic handle:)
				(gGlobalMusic fade: 0 15 12 1)
			)
			(= global225 37)
		)
		(super dispose: &rest)
	)

	(method (enterSpecial)
		(cond
			((gEgo has: 8)
				(= local2 ((gInventory at: 8) regActor:))
				(gCurRoom setScript: enterWithBeauty self)
			)
			((and (== gPrevRoomNum 220) (IsFlag 5))
				(gBookEnd setScript: bookGloat)
			)
			(else
				(gCurRoom setScript: enterFromNorth self)
			)
		)
	)
)

(instance forestSound of Sound
	(properties
		flags 1
		number 153
		loop -1
	)
)

(instance enterFromNorth of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					posn: 165 110
					normal: 0
					setLoop: 2
					setPri: 5
					ignoreActors: 1
					setCycle: Fwd
					init:
					setMotion: MoveTo 165 95 self
				)
				(if (= local3 (proc10_17 InvFriend))
					(= local3 (local3 regActor:))
					(local3
						ignoreActors: 1
						x: 150
						y: 110
						setPri: 5
						setLoop: 2
						init:
						setCycle: Fwd
						setMotion: MoveTo 150 91
					)
				)
			)
			(1
				(gEgo setPri: -1 normal: 1 setMotion: PolyPath 160 130 self)
				(if local3
					(local3
						setLoop: -1
						ignoreActors: 0
						setPri: -1
						setCycle: StopWalk
					)
					(cond
						((== (gBremenStory state:) 1)
							(local3
								lookStr: {You see a rooster.}
								description: {Rooster}
								setMotion: NPFolRoos gEgo 40
							)
						)
						((== (gBremenStory state:) 7)
							(local3
								setLoop: (ScriptID 92 1) ; donkLooper
								setMotion: NPFollow gEgo 40
							)
						)
						(else
							(local3 setMotion: NPFollow gEgo 40)
						)
					)
				)
			)
			(2
				(NormalEgo 5 global139)
				(self dispose:)
			)
		)
	)
)

(instance exitNorth of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setPri: 5
					setLoop: 3
					setCycle: Fwd
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 20) self
					ignoreActors: 1
				)
			)
			(1
				(gCurRoom newRoom: 220)
			)
		)
	)
)

(instance enterWithBeauty of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local2
					setCycle: StopWalk
					posn: (gCurRoom northX:) (+ (gCurRoom northY:) 5)
					init:
					setMotion: PolyPath 160 120 self
				)
				(NormalEgo 5 global139)
				(gEgo
					normal: 1
					setHeading: 180
					posn: (gCurRoom northX:) (gCurRoom northY:)
					init:
					setMotion: NPFollow local2 40
				)
			)
			(1
				(proc10_13 0 local2 gEgo -1 0 270 0)
				(proc10_13 0 local2 gEgo self 1 270 1)
			)
			(2
				(local2 setMotion: PolyPath 165 130 self)
			)
			(3
				(proc10_13 2 gEgo local2 -1 1 270 2)
				(proc10_13 0 local2 gEgo -1 0 270 3)
				(proc10_13 0 local2 gEgo self 1 270 4)
			)
			(4
				(local2 setMotion: PolyPath 170 150 self)
			)
			(5
				(proc10_13 2 gEgo local2 -1 1 270 5)
				(proc10_13 0 local2 gEgo -1 0 270 6)
				(proc10_13 0 local2 gEgo self 1 270 7)
			)
			(6
				(local2 setMotion: PolyPath 175 160 self)
			)
			(7
				(proc10_13 0 local2 gEgo -1 0 270 8)
				(proc10_13 0 local2 gEgo -1 0 270 9)
				(proc10_13 0 local2 gEgo -1 0 270 10)
				(proc10_13 0 local2 gEgo -1 1 270 11)
				(proc10_13 2 gEgo local2 -1 1 270 12)
				(proc10_13 0 local2 gEgo -1 0 270 13)
				(proc10_13 0 local2 gEgo -1 0 270 14)
				(proc10_13 0 local2 gEgo -1 0 270 15)
				(proc10_13 0 local2 gEgo self 1 270 16)
			)
			(8
				(local2 setMotion: PolyPath 180 170 self)
			)
			(9
				(proc10_13 2 gEgo local2 -1 1 270 17)
				(proc10_13 0 local2 gEgo -1 0 270 18)
				(proc10_13 0 local2 gEgo self 1 270 19)
			)
			(10
				(local2 setMotion: PolyPath 190 180 self)
			)
			(11
				(gCurRoom newRoom: 320)
			)
		)
	)
)

(instance bookGloat of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 5)
				(gBookEnd setCycle: Walk setStep: 7 2 posn: 163 98 init:)
				(= cycles 1)
			)
			(1
				(gBookEnd setMotion: PolyPath 237 145 self)
			)
			(2
				((((gInventory at: 1) owner: gCurRoomNum) regView:)
					posn: (gCurRoom invX:) (gCurRoom invY:)
					init:
				)
				(= cycles 1)
			)
			(3
				(proc10_13 0 gBookEnd gBookEnd self 0 270 20)
			)
			(4
				(proc10_13 0 gBookEnd gBookEnd self 1 270 21)
			)
			(5
				(gBookEnd
					setMotion:
						PolyPath
						(+ (gCurRoom eastX:) 10)
						(gCurRoom eastY:)
						self
				)
			)
			(6
				(gBookEnd dispose:)
				(gCurRoom setScript: enterFromNorth)
				(self dispose:)
			)
		)
	)
)

(instance kittySound of Sound
	(properties
		flags 1
		number 124
	)
)

(instance findKitty of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 125 107 self)
			)
			(1
				(Face gEgo local1 self)
			)
			(2
				(if (gGame script:)
					(gGame setScript: 0)
					(gGlobalMusic2 stop:)
				)
				(eyes1 setScript: bremenMusic)
				(local1 loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(local1 x: 238 y: 53 loop: 1 cel: 0 setCycle: End self)
			)
			(4
				(local1 setPri: 7 x: 190 y: 91 cel: 0 setCycle: End self)
			)
			(5
				(local1
					setPri: -1
					posn: 166 115
					view: 642
					setMotion: PolyPath 160 110 self
				)
			)
			(6
				(gEgo doCode: (gEgoTravCodeSet at: 1))
				(local1 selection: 0 doCode: (gFriendTravCodeSet at: 1))
				((local1 client:) moveTo: gEgo)
				(gTheIconBar curInvIcon: (gInventory at: 5) show:)
				(local1
					ignoreActors: 0
					view: 642
					normal: 1
					setLoop: -1
					setCycle: StopWalk
					setMotion: NPFollow gEgo 40
				)
				(= cycles 1)
			)
			(7
				(kittySound play:)
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

(instance egoDo270 of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(if (or (== (gBremenStory state:) 2) (== (gBremenStory state:) 3))
					(switch (gEgo selection:)
						(0
							(proc10_13 2 gEgo local1 -1 1 270 22)
							(proc10_13 3 local1 gEgo -1 0 270 23)
							(proc10_13 3 local1 gEgo -1 1 270 24)
							(proc10_13 0 gEgo local1 -1 0 270 25)
							(proc10_13 0 gEgo local1 -1 1 270 26)
							(proc10_13 2 local1 gEgo -1 1 270 27)
							(proc10_13 0 gEgo local1 -1 1 270 28)
							(gBremenStory incState:)
							(gCurRoom setScript: findKitty)
						)
						(1
							(proc10_13 0 gEgo local1 -1 0 270 29)
							(proc10_13 0 gEgo local1 -1 1 270 30)
							(proc10_13 2 local1 gEgo -1 0 270 31)
							(proc10_13 3 local1 gEgo -1 1 270 32)
							(proc10_13 0 gEgo local1 -1 1 270 33)
							(proc10_13 3 gEgo local1 -1 1 270 34)
						)
						(2
							(proc10_13 0 gEgo local1 -1 1 270 35)
							(proc10_13 0 local1 gEgo -1 1 270 36)
						)
						(else
							(proc10_13 0 gEgo local1 -1 1 270 37)
							(proc10_13 3 local1 gEgo -1 1 270 38)
						)
					)
				)
				(gEgo incSel:)
			)
		)
	)
)

(instance catDo270 of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(if (or (== (gBremenStory state:) 2) (== (gBremenStory state:) 3))
					(switch (local1 selection:)
						(0
							(proc10_13 3 local1 gEgo -1 1 270 39)
						)
						(1
							(proc10_13 2 local1 gEgo -1 1 270 40)
						)
						(2
							(proc10_13 3 local1 gEgo -1 1 270 41)
						)
						(else
							(proc10_13 3 local1 gEgo -1 1 270 42)
						)
					)
				)
				(local1 incSel:)
			)
		)
	)
)

(instance eyes1 of Prop
	(properties
		x 252
		y 36
		description {Eyes}
		lookStr {You see the glowing eyes of something hiding.}
		view 270
		loop 1
		cel 1
	)
)

(instance eyes2 of Prop
	(properties
		x 288
		y 36
		view 270
		loop 1
		cel 1
	)

	(method (doVerb theVerb)
		(eyes1 doVerb: theVerb)
	)
)

(instance tree of Feature
	(properties
		x 83
		y 35
		description {Tree}
		sightAngle 90
		onMeCheck 2
		lookStr {The trees bend down over the road.}
	)
)

(instance branch of Feature
	(properties
		x 38
		y 35
		description {Branch}
		sightAngle 90
		onMeCheck 4
		lookStr {This branch is twisted.}
	)
)

(instance stream of Feature
	(properties
		x 139
		y 78
		description {Stream}
		sightAngle 90
		onMeCheck 8
		lookStr {The stream goes under the bridge.}
	)
)

(instance bridge of Feature
	(properties
		x 175
		y 79
		description {Bridge}
		sightAngle 90
		onMeCheck 16
		lookStr {The road goes over the bridge.}
	)
)

(instance grass of Feature
	(properties
		x 42
		y 81
		description {Grass}
		sightAngle 90
		onMeCheck 32
		lookStr {Grass grows all over.}
	)
)

(instance road of Feature
	(properties
		x 141
		y 127
		description {Road}
		sightAngle 90
		onMeCheck 64
		lookStr {The road goes north, east, south, and west from here.}
	)
)

(instance plants of Feature
	(properties
		x 71
		y 107
		description {Plant}
		sightAngle 90
		onMeCheck 128
		lookStr {These plants are spikes.}
	)
)

(instance treeEyes of Feature
	(properties
		x 274
		y 45
		description {Eyes}
		sightAngle 90
		onMeCheck 1024
		lookStr {You see the glowing eyes of something hiding.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (not (gCast contains: eyes1))
					(treeEyes
						description: {Holes}
						lookStr: {You see holes in the tree.}
					)
				)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

