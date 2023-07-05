;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 310)
(include sci.sh)
(use Main)
(use n010)
(use Tactor)
(use goGet)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)

(public
	Room310 0
)

(local
	local0
	[local1 200]
	[local201 10] = [45 123 214 106 142 113 80 125 202 108]
	[local211 14] = [55 120 52 37 119 32 51 90 155 84 147 107 195 76]
	[local225 7]
	local232
)

(procedure (localproc_0)
	(house init:)
	(window1 approachVerbs: 2 init:) ; Look
	(barrel init:)
	(path init:)
	(jar init:)
	(shutter init:)
	(rock init:)
	(tree init:)
	(stump init:)
	(grass init:)
	(uWindow init:)
)

(procedure (localproc_1 &tmp temp0 temp1)
	(for ((= temp0 0)) (< temp0 5) ((++ temp0))
		((= temp1 (trash new:))
			ignoreActors: 1
			setPri: 0
			stopUpd:
			cel: temp0
			posn: [local201 (* temp0 2)] [local201 (+ (* temp0 2) 1)]
			init:
		)
	)
)

(procedure (localproc_2 &tmp temp0)
	(for ((= temp0 0)) (< temp0 7) ((++ temp0))
		((= [local225 temp0] (dwarf new:))
			illegalBits: 0
			ignoreActors: 1
			ignoreHorizon: 1
			cycleSpeed: 18
			setLoop: (+ temp0 1)
			init:
			posn: [local211 (* temp0 2)] [local211 (+ (* temp0 2) 1)]
		)
	)
	(= local232 [local225 0])
)

(instance Room310 of FRoom
	(properties
		lookStr {An odd house under a hill is here.}
		picture 310
		style 0
		horizon 48
		north 260
		east 320
		northX 245
		northY 43
		eastX 312
		eastY 135
	)

	(method (init)
		(if (== (gSnowStory state:) 1)
			(Load rsSOUND 14)
		)
		(if (> global225 0)
			(Load rsSOUND global225)
		)
		(super init:)
		(proc10_29)
		(gTheIconBar enable: show:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 90 153 106 167 134 168 188 169 319 168 319 173 28 173 0 173 0 171 0 0 319 0 319 127 302 117 297 79 268 56 240 42 212 41 215 53 248 82 260 94 253 111 229 115 192 117 152 119 131 118 119 114 91 117
					yourself:
				)
		)
		(localproc_0)
		(switch (gSnowStory state:)
			(0
				(door setLoop: 0 setCel: 0 init:)
				(localproc_1)
			)
			(1
				(cond
					((gGame script:)
						(gGame setScript: 0)
						(gGlobalMusic2 stop:)
					)
					((gGlobalMusic2 handle:)
						(gGlobalMusic2 stop:)
					)
				)
				(gGlobalMusic number: 14 priority: 15 setLoop: -1 play:)
				(= local0 ((gInventory at: 10) regActor:))
				(door setLoop: 0 setCel: 1 setPri: 7 ignoreActors: 1 init:)
				(localproc_2)
			)
			(else
				(door setLoop: 0 setCel: 0 init:)
			)
		)
	)

	(method (cue)
		(super cue:)
		(switch (gSnowStory state:)
			(1
				(gCurRoom setScript: enterWithSnow)
			)
		)
	)

	(method (dispose)
		(dwarf setCycle: 0)
		(if (gGlobalMusic handle:)
			(gGlobalMusic fade: 0 15 12 1)
			(= global225 6)
		)
		(super dispose: &rest)
	)
)

(instance enterWithSnow of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 270 130 self)
			)
			(1
				(Face gEgo local232)
				(gSnowStory incState:)
				((local0 client:) owner: 0)
				(local0 setMotion: PolyPath 205 136 self)
			)
			(2
				(= ticks 120)
			)
			(3
				(proc10_13 0 local0 gEgo self 0 310 0)
			)
			(4
				(proc10_13 0 local0 local232 self 1 310 1)
			)
			(5
				(proc10_13 2 local232 local0 self 0 310 2)
			)
			(6
				(proc10_13 3 local232 local0 self 1 310 3)
			)
			(7
				(proc10_13 0 local0 local232 self 0 310 4)
			)
			(8
				(proc10_13
					0
					local0
					local232
					self
					1
					(Format @local1 310 5 @global110) ; "First, I'd like you all to meet my new friend, %s."
				)
			)
			(9
				(proc10_13
					0
					local232
					gEgo
					self
					1
					(Format @local1 310 6 @global110) ; "Hello, %s!"
				)
			)
			(10
				(proc10_13
					0
					local0
					gEgo
					self
					0
					(Format @local1 310 7 @global110) ; "Thank you so much for your help, %s."
				)
			)
			(11
				(proc10_13 0 local0 gEgo self 1 310 8)
			)
			(12
				(gTheIconBar curInvIcon: 0 show:)
				(local0 setPri: 9 setMotion: MoveTo 107 106 self)
			)
			(13
				(Face local0 gEgo)
				(= cycles 2)
			)
			(14
				(proc10_13 0 local0 local0 self 1 310 9)
			)
			(15
				(proc10_22 310 10)
				(= cycles 10)
			)
			(16
				(local0
					setPri: 7
					normal: 0
					view: 670
					setLoop: 1
					cel: 0
					setCycle: End self
				)
			)
			(17
				(local0 dispose:)
				(= cycles 1)
			)
			(18
				(gEgo
					doCode: 0
					setMotion: PolyPath 319 (gCurRoom eastY:) self
				)
			)
			(19
				(self dispose:)
			)
		)
	)
)

(instance dwarf of Tactor
	(properties
		view 310
		talkerID 17
	)

	(method (setUp)
		((= talkerObj dwarfTalkObj) setUp: dwarfBust dwarfEyes dwarfMouth)
	)

	(method (doit &tmp temp0)
		(if (and (IsObject [local225 6]) (== (Random 0 3) 2))
			(= temp0 (Random 0 6))
			(switch (Random 0 2)
				(0
					([local225 temp0] setCycle: Fwd)
				)
				(1
					([local225 temp0] setCycle: 0)
				)
				(2
					([local225 temp0] setCycle: Beg)
				)
			)
		)
		(super doit: &rest)
	)
)

(instance dwarfTalkObj of TalkerObj
	(properties
		x -1
		y 97
		nsTop 10
		nsLeft 108
		view 676
	)
)

(instance dwarfBust of View
	(properties
		nsTop 26
		nsLeft 47
		view 676
		loop 6
	)
)

(instance dwarfEyes of Prop
	(properties
		nsTop 31
		nsLeft 52
		view 676
		loop 4
		cycleSpeed 36
	)
)

(instance dwarfMouth of Prop
	(properties
		nsTop 39
		nsLeft 43
		view 676
		loop 2
		cycleSpeed 12
	)
)

(instance trash of Prop
	(properties
		description {Trash}
		lookStr {The dwarves are very messy.}
		view 310
		loop 8
	)
)

(instance door of Prop
	(properties
		x 112
		y 103
		description {Door}
		lookStr {The door is locked.}
		view 310
	)
)

(instance shutter of Feature
	(properties
		x 144
		y 75
		description {Shutter}
		sightAngle 90
		onMeCheck 2
		lookStr {The shutter is used to close the window.}
	)
)

(instance window1 of Feature
	(properties
		x 55
		y 101
		description {Window}
		sightAngle 90
		onMeCheck 4
		approachX 126
		approachY 133
		lookStr {Through the window, you see seven chairs and seven beds.}
	)
)

(instance house of Feature
	(properties
		x 98
		y 77
		description {House}
		sightAngle 90
		onMeCheck 8
		lookStr {This house has been dug under the hill.}
	)
)

(instance barrel of Feature
	(properties
		x 204
		y 108
		description {Barrel}
		sightAngle 90
		onMeCheck 16
		lookStr {The barrel is here to hold rain water.}
	)
)

(instance path of Feature
	(properties
		x 207
		y 151
		description {Path}
		sightAngle 90
		onMeCheck 32
		lookStr {The path leads north and east from here.}
	)
)

(instance jar of Feature
	(properties
		x 187
		y 116
		description {Jar}
		sightAngle 90
		onMeCheck 64
		lookStr {The jar is made from clay.}
	)
)

(instance rock of Feature
	(properties
		x 178
		y 49
		description {Rock}
		sightAngle 90
		onMeCheck 128
		lookStr {There are many rocks around here.}
	)
)

(instance tree of Feature
	(properties
		x 13
		y 139
		description {Tree}
		sightAngle 90
		onMeCheck 256
		lookStr {The tree shades the ground.}
	)
)

(instance stump of Feature
	(properties
		x 184
		y 182
		description {Stump}
		sightAngle 90
		onMeCheck 512
		lookStr {This stump was once part of a tree.}
	)
)

(instance grass of Feature
	(properties
		x 169
		y 129
		description {Grass}
		sightAngle 90
		onMeCheck 1024
		lookStr {Grass grows on the hill over the house.}
	)
)

(instance uWindow of Feature
	(properties
		x 55
		y 80
		description {Window}
		sightAngle 90
		onMeCheck 16384
		lookStr {You see a window.}
	)
)

