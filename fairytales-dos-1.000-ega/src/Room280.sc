;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 280)
(include sci.sh)
(use Main)
(use n010)
(use goGet)
(use Interface)
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
	Room280 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0)
	(tree init:)
	(house init:)
	(wall init:)
	(spike init:)
	(road init:)
	(rock init:)
	(grass init:)
	(hole init:)
)

(instance Room280 of FRoom
	(properties
		lookStr {You are now just south of Bookwyrm's House}
		picture 280
		style 0
		horizon 59
		north 230
		west 270
		friendX 168
		friendY 109
		northX 227
		northY 78
		westX 6
		westY 150
	)

	(method (init)
		(if (> global225 0)
			(Load rsSOUND global225)
		)
		(if (== (gSnowStory state:) 3)
			(LoadMany rsSOUND 22 23)
		)
		(Load rsSOUND 149)
		(super init:)
		(proc10_29)
		(if (== (gSnowStory state:) 3)
			(gGlobalMusic number: 22 priority: 15 setLoop: -1 play:)
		)
		(gTheIconBar enable: show:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 140 293 140 306 120 314 111 314 96 299 81 237 55 236 0 319 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 188 0 189 63 210 76 210 89 224 103 211 120 189 105 164 112 178 143 84 144 57 136 52 139 22 139 16 135 0 137
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 173 0 163 80 165 112 169 131 166 159 171 319 167 319 173
					yourself:
				)
		)
		(localproc_0)
		(switch (gSnowStory state:)
			(3
				(gEgo doCode: egoDo280)
				(= local0 ((gInventory at: 11) regActor:))
				(local0
					view: 680
					setLoop: 0
					posn: friendX friendY
					doCode: princeDo280
					selection: 0
					normal: 0
					init:
				)
				(rope setLoop: 1 posn: (+ (local0 x:) 7) (local0 y:) init:)
			)
		)
		(if (> global229 16)
			(forestSound play:)
		)
	)

	(method (cue)
		(super cue:)
		(switch (gSnowStory state:)
			(3
				(gCurRoom setScript: enterAfterSnowDead)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script 0)
			((and (== (gSnowStory state:) 3) (not local1) (< (gEgo y:) 56))
				(gCurRoom setScript: pleaseUntie)
			)
		)
	)

	(method (dispose)
		(if
			(and
				(== (gSnowStory state:) 4)
				(!= (gEgo doCode:) (gEgoTravCodeSet at: 5))
			)
			(gEgo doCode: (gEgoTravCodeSet at: 5))
			(local0 doCode: (gFriendTravCodeSet at: 5))
		)
		(if (and (== (gSnowStory state:) 3) (== (gGlobalMusic number:) 22))
			(gGlobalMusic fade: 0 15 12 1)
			(= global225 6)
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

(instance pleaseUntie of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Face gEgo local0)
				(= local1 1)
				(= cycles 2)
			)
			(1
				(proc10_13 0 local0 gEgo -1 0 280 0)
				(proc10_13 0 local0 gEgo -1 0 280 1)
				(proc10_13 0 local0 gEgo self 1 280 2)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance ropeSound of Sound
	(properties
		flags 1
		number 155
	)
)

(instance freePrince of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSnowStory incState:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 176 116 self)
			)
			(2
				(gEgo setHeading: 0)
				(= ticks 30)
			)
			(3
				(gGlobalMusic fade:)
				(gGlobalMusic2 number: 23 priority: 15 setLoop: -1 play:)
				(ropeSound play:)
				(rope ignoreActors: 1 setCycle: End)
				(local0 setCycle: End self)
			)
			(4
				(gEgo selection: 0)
				(local0
					normal: 1
					view: 682
					selection: 0
					setLoop: -1
					setCycle: StopWalk
				)
				(= cycles 1)
			)
			(5
				(proc10_13 0 local0 gEgo -1 0 280 3)
				(proc10_13 0 local0 gEgo self 1 280 4)
			)
			(6
				((local0 client:) moveTo: gEgo)
				(gTheIconBar curInvIcon: (gInventory at: 11) show:)
				(gEgo setMotion: PolyPath 165 150 self)
			)
			(7
				(local0 setMotion: PolyPath 185 150 self)
			)
			(8
				(local0 setMotion: NPFollow gEgo 40)
				(= cycles 1)
			)
			(9
				(gCast delete: local0)
				(gCast delete: gEgo)
				(gCast addToFront: local0)
				(gCast addToFront: gEgo)
				(self dispose:)
			)
		)
	)
)

(instance enterAfterSnowDead of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc10_13 0 local0 gEgo self 1 280 5)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance batSound of Sound
	(properties
		flags 1
		number 149
	)
)

(instance batExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 280 6 #time 4 #at -1 160 #dispose) ; "You see a bat."
				(batSound play:)
				(bat
					x: 161
					y: 88
					z: 50
					xStep: 5
					setPri: 7
					init:
					setCycle: Fwd
					setMotion: MoveTo 330 88 self
				)
			)
			(1
				(bat dispose:)
				(self dispose:)
			)
		)
	)
)

(instance egoDo280 of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(switch (gSnowStory state:)
					(3
						(switch (gEgo selection:)
							(0
								(proc10_13 2 gEgo local0 -1 1 280 7)
								(proc10_13 2 local0 gEgo -1 0 280 8)
								(proc10_13 0 local0 gEgo -1 1 280 9)
							)
							(1
								(proc10_13 2 gEgo local0 -1 1 280 10)
								(proc10_13 0 local0 gEgo -1 0 280 11)
								(proc10_13 2 local0 gEgo -1 0 280 12)
								(proc10_13 0 local0 gEgo -1 0 280 13)
								(proc10_13 0 local0 gEgo -1 1 280 14)
							)
							(2
								(proc10_13 2 gEgo local0 -1 1 280 15)
								(proc10_13 0 local0 gEgo -1 0 280 16)
								(proc10_13 1 local0 gEgo -1 1 280 17)
								(proc10_13 0 gEgo local0 -1 1 280 18)
								(proc10_13 1 local0 gEgo -1 1 280 19)
							)
							(else
								(proc10_13 2 gEgo local0 -1 1 280 20)
								(proc10_13 0 local0 gEgo -1 0 280 21)
								(proc10_13 0 local0 gEgo -1 0 280 22)
								(proc10_13 0 local0 gEgo -1 0 280 23)
								(proc10_13 0 local0 gEgo -1 1 280 24)
							)
						)
					)
					(4
						(switch (gEgo selection:)
							(0
								(proc10_13 3 gEgo local0 -1 1 280 25)
								(proc10_13 0 local0 gEgo -1 1 280 26)
								(proc10_13 0 gEgo local0 -1 1 280 27)
								(proc10_13 2 local0 gEgo -1 1 280 28)
								(proc10_13 3 gEgo local0 -1 1 280 29)
								(proc10_13 1 local0 gEgo -1 1 280 30)
							)
							(1
								(proc10_13 3 gEgo local0 -1 1 280 31)
								(proc10_13 3 local0 gEgo -1 0 280 32)
								(proc10_13 3 local0 gEgo -1 1 280 33)
							)
							(2
								(proc10_13 0 gEgo local0 -1 1 280 34)
								(proc10_13 0 local0 gEgo -1 0 280 35)
								(proc10_13 0 local0 gEgo -1 0 280 36)
								(proc10_13 1 local0 gEgo -1 1 280 37)
							)
							(else
								(proc10_13 3 gEgo local0 -1 1 280 38)
								(proc10_13 0 local0 gEgo -1 0 280 39)
								(proc10_13 0 local0 gEgo -1 1 280 40)
							)
						)
					)
				)
				(gEgo incSel:)
			)
		)
	)
)

(instance princeDo280 of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(switch (gSnowStory state:)
					(3
						(switch (local0 selection:)
							(0
								(proc10_13 0 local0 gEgo -1 0 280 41)
								(proc10_13 0 local0 gEgo -1 1 280 42)
							)
							(1
								(proc10_13 0 local0 gEgo -1 0 280 43)
								(proc10_13 0 local0 gEgo -1 0 280 44)
								(proc10_13 0 local0 gEgo -1 1 280 45)
							)
							(2
								(proc10_13 3 local0 gEgo -1 1 280 46)
							)
							(else
								(proc10_13 0 local0 gEgo -1 0 280 47)
								(proc10_13 2 local0 gEgo -1 1 280 48)
							)
						)
					)
					(4
						(switch (local0 selection:)
							(0
								(proc10_13 2 local0 gEgo -1 0 280 49)
								(proc10_13 0 local0 gEgo -1 1 280 50)
							)
							(1
								(proc10_13 2 local0 gEgo -1 1 280 51)
							)
							(2
								(proc10_13 3 local0 gEgo -1 0 280 52)
								(proc10_13 1 local0 gEgo -1 1 280 53)
							)
							(else
								(proc10_13 3 local0 gEgo -1 0 280 54)
								(proc10_13 3 local0 gEgo -1 1 280 55)
							)
						)
					)
				)
				(local0 incSel:)
			)
		)
	)
)

(instance bat of Actor
	(properties
		description {Bat}
		lookStr {You see a small bat.}
		view 280
		signal 24576
	)
)

(instance rope of Prop
	(properties
		description {Rope}
		lookStr {This is a very strong rope.}
		view 680
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(cond
					((gCurRoom script:) 0)
					((and (== (gSnowStory state:) 3) (not local2))
						(= local2 1)
						(gCurRoom setScript: freePrince)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tree of Feature
	(properties
		x 148
		y 85
		description {Tree}
		sightAngle 90
		onMeCheck 2
		lookStr {This tree is old and very large.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(cond
					((gCurRoom script:) 0)
					((== (gSnowStory state:) 3)
						(if (not local2)
							(= local2 1)
							(gCurRoom setScript: freePrince)
						)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance house of Feature
	(properties
		x 210
		y 35
		description {House}
		sightAngle 90
		onMeCheck 4
		lookStr {You can see Bookwyrm's house.}
	)
)

(instance spike of Feature
	(properties
		x 262
		y 140
		description {Spike}
		sightAngle 90
		onMeCheck 8
		lookStr {This spike keeps people off the wall.}
	)
)

(instance road of Feature
	(properties
		x 189
		y 140
		description {Road}
		sightAngle 90
		onMeCheck 16
		lookStr {The road leads north and west from here.}
	)
)

(instance rock of Feature
	(properties
		x 114
		y 140
		description {Rock}
		sightAngle 90
		onMeCheck 32
		lookStr {This rock is gray.}
	)
)

(instance grass of Feature
	(properties
		x 61
		y 119
		description {Grass}
		sightAngle 90
		onMeCheck 64
		lookStr {The grass grows around the road.}
	)
)

(instance wall of Feature
	(properties
		x 296
		y 67
		description {Wall}
		sightAngle 90
		onMeCheck 1024
		lookStr {This wall is tall and has spikes on top.}
	)
)

(instance hole of Feature
	(properties
		x 152
		y 86
		z 51
		description {Hole}
		onMeCheck 2048
		lookStr {A bat lives in this hole.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (bat script:))
					(bat setScript: batExit)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

