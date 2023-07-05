;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 260)
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
	Room260 0
)

(local
	local0
	local1
	[local2 200]
)

(procedure (localproc_0)
	(rock init:)
	(tree1 init:)
	(tree2 init:)
	(grass init:)
	(flowers init:)
	(town init:)
	(road init:)
)

(instance Room260 of FRoom
	(properties
		lookStr {It is bright and sunny here.}
		picture 260
		style 0
		horizon 58
		north 210
		east 270
		south 310
		invX 249
		invY 105
		friendX 173
		friendY 124
		northX 150
		northY 9
		southX 198
		southY 180
		eastX 320
		eastY 143
	)

	(method (init)
		(if (> global225 0)
			(Load rsSOUND global225)
		)
		(switch (gBremenStory state:)
			(6
				(Load rsSOUND 9)
			)
		)
		(super init:)
		(musicClient init: hide:)
		(proc10_29)
		(gTheIconBar enable: show:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 159 98 156 114 141 137 139 160 141 173 0 173 0 -26 319 -26 319 119 303 114 288 113 270 103 226 71 150 54 149 0 28 0 77 62 123 62
					yourself:
				)
		)
		(localproc_0)
		(switch (gBremenStory state:)
			(6
				(Load rsVIEW 632)
				(Load rsVIEW 633)
				(Load rsSOUND 138)
				(gEgo doCode: egoDo260)
				(= local1 ((gInventory at: 7) regActor:))
				(dHead
					posn: 170 104
					setPri: 8
					cycleSpeed: 24
					setCycle: Fwd
					init:
				)
				(local1
					view: 630
					heading: 270
					posn: friendX friendY
					ignoreActors: 0
					normal: 0
					doCode: donkeyDo250
					selection: 0
					init:
				)
				(tail init: setPri: 8 setCycle: Fwd)
			)
		)
	)

	(method (cue)
		(super cue:)
		(switch (gBremenStory state:)
			(6
				(gCurRoom setScript: enterBeforeDonkey)
			)
		)
	)

	(method (dispose)
		(switch (gBremenStory state:)
			(6
				(if (gGlobalMusic handle:)
					(gGlobalMusic fade: 0 15 12 1)
				)
				(= global225 6)
			)
			(7
				(if (IsObject local1)
					(gEgo doCode: (gEgoTravCodeSet at: 3))
					(local1 selection: 0 doCode: (gFriendTravCodeSet at: 3))
				)
				(if (gGlobalMusic handle:)
					(gGlobalMusic fade: 0 15 12 1)
				)
				(= global225 37)
			)
		)
		(super dispose: &rest)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(not script)
				(== (gBremenStory state:) 6)
				(<= (gEgo distanceTo: local1) 25)
			)
			(gCurRoom setScript: freeDonkey)
		)
	)
)

(instance freeDonkey of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gEgo y:) (+ (local1 y:) 2))
					(gEgo setMotion: PolyPath 213 116 self)
				else
					(= cycles 1)
				)
			)
			(1
				(if (< (gEgo y:) (+ (local1 y:) 2))
					(gEgo setMotion: PolyPath 206 130 self)
				else
					(= cycles 1)
				)
			)
			(2
				(gEgo setMotion: PolyPath 150 130 self)
			)
			(3
				(gEgo selection: 0)
				(gBremenStory incState:)
				((local1 client:) moveTo: gEgo)
				(gTheIconBar curInvIcon: (gInventory at: 7) show:)
				(if (gGame script:)
					(gGame setScript: 0)
					(gGlobalMusic2 stop:)
				)
				(musicClient setScript: bremenMusic)
				(= cycles 1)
			)
			(4
				(dHead posn: 169 103 setLoop: 4)
				(rope posn: 129 95 init: ignoreActors: 1 setCycle: End self)
			)
			(5
				(tail dispose:)
				(dHead dispose:)
				(local1
					view: 632
					loop: 8
					setCel: 1
					xStep: 4
					setCycle: StopWalk
					setHeading: 270
					normal: 1
					setLoop: (ScriptID 92 1) ; donkLooper
					setMotion: NPFollow gEgo 40
				)
				(= cycles 30)
			)
			(6
				(proc10_13 0 local1 gEgo self 1 260 0)
			)
			(7
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

(instance donkeySound of Sound
	(properties
		flags 1
		number 138
	)
)

(instance enterBeforeDonkey of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(donkeySound play:)
				(proc10_13 3 local1 gEgo self 1 260 1)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance egoDo260 of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(cond
					((== (gBremenStory state:) 6)
						(switch (gEgo selection:)
							(0
								(proc10_13 2 gEgo local1 -1 1 260 2)
								(proc10_13 0 local1 gEgo -1 1 260 3)
								(proc10_13 1 gEgo local1 -1 1 260 4)
							)
							(1
								(proc10_13 0 gEgo local1 -1 1 260 5)
								(proc10_13 2 local1 gEgo -1 1 260 6)
								(proc10_13 1 gEgo local1 -1 1 260 7)
								(proc10_13 0 local1 gEgo -1 1 260 8)
							)
							(2
								(proc10_13 0 gEgo local1 -1 1 260 9)
								(proc10_13 0 local1 gEgo -1 1 260 10)
							)
							(else
								(proc10_13 0 gEgo local1 -1 1 260 11)
								(proc10_13 0 local1 gEgo -1 1 260 12)
								(proc10_13 2 gEgo local1 -1 1 260 13)
								(proc10_13 0 local1 gEgo -1 1 260 14)
							)
						)
					)
					((== (gBremenStory state:) 7)
						(switch (gEgo selection:)
							(0
								(proc10_13 0 gEgo local1 -1 1 260 15)
								(proc10_13 0 local1 gEgo -1 1 260 16)
							)
							(1
								(proc10_13 0 gEgo local1 -1 1 260 17)
								(proc10_13 0 local1 gEgo -1 1 260 18)
							)
							(2
								(proc10_13 3 gEgo local1 -1 1 260 19)
								(proc10_13 0 local1 gEgo -1 1 260 20)
							)
							(else
								(proc10_13 0 gEgo local1 -1 1 260 21)
								(proc10_13 0 local1 gEgo -1 1 260 22)
							)
						)
					)
				)
				(gEgo incSel:)
			)
		)
	)
)

(instance donkeyDo250 of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(cond
					((== (gBremenStory state:) 6)
						(switch (local1 selection:)
							(0
								(proc10_13 2 local1 gEgo -1 1 260 23)
							)
							(1
								(proc10_13 0 local1 gEgo -1 1 260 24)
							)
							(2
								(proc10_13 3 local1 gEgo -1 1 260 25)
							)
							(else
								(proc10_13 0 local1 gEgo -1 0 260 26)
								(proc10_13 0 local1 gEgo -1 1 260 27)
							)
						)
					)
					((== (gBremenStory state:) 7)
						(switch (local1 selection:)
							(0
								(proc10_13 3 local1 gEgo -1 1 260 28)
							)
							(1
								(proc10_13 3 local1 gEgo -1 1 260 29)
							)
							(2
								(proc10_13 0 local1 gEgo -1 1 260 30)
							)
							(else
								(proc10_13 0 local1 gEgo -1 1 260 31)
							)
						)
					)
				)
				(local1 incSel:)
			)
		)
	)
)

(instance tail of Prop
	(properties
		x 192
		y 98
		view 630
		loop 2
	)
)

(instance dHead of Prop
	(properties
		view 630
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (and (not (gCurRoom script:)) (gCast contains: dHead))
					(gCurRoom setScript: freeDonkey)
				)
			)
			(2 ; Look
				(local1 doVerb: theVerb)
			)
			(else
				(super doit: theVerb &rest)
			)
		)
	)
)

(instance rope of Prop
	(properties
		description {Rope}
		lookStr {This is a grass rope}
		view 630
		loop 3
		cycleSpeed 12
	)
)

(instance rock of Feature
	(properties
		x 49
		y 85
		description {Rock}
		sightAngle 90
		onMeCheck 2
		lookStr {The rock is too big to climb.}
	)
)

(instance tree1 of Feature
	(properties
		x 113
		y 92
		description {Tree}
		sightAngle 90
		onMeCheck 4
		lookStr {A pine tree grows here.}
	)
)

(instance tree2 of Feature
	(properties
		x 96
		y 42
		description {Tree}
		sightAngle 90
		onMeCheck 8
		lookStr {An oak tree grows here.}
	)
)

(instance grass of Feature
	(properties
		x 146
		y 42
		description {Grass}
		sightAngle 90
		onMeCheck 16
		lookStr {The grass grows tall.}
	)
)

(instance flowers of Feature
	(properties
		x 106
		y 144
		description {Flowers}
		sightAngle 90
		onMeCheck 32
		lookStr {The flowers grow by the road.}
	)
)

(instance town of Feature
	(properties
		x 82
		y 36
		description {Town}
		sightAngle 90
		onMeCheck 64
		lookStr {The wall of the town is over the hill.}
	)
)

(instance road of Feature
	(properties
		x 196
		y 125
		description {Road}
		sightAngle 90
		onMeCheck 128
		lookStr {This road leads north, east, and south.}
	)
)

(instance musicClient of Prop
	(properties
		x 252
		y 36
		view 270
		loop 1
		cel 1
	)
)

