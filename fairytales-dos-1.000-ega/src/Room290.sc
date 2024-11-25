;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 290)
(include sci.sh)
(use Main)
(use n010)
(use Tactor)
(use goGet)
(use PAvoider)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use DPath)
(use Sound)
(use Motion)
(use Actor)

(public
	Room290 0
)

(local
	local0
	[local1 134] = [229 173 229 162 270 162 259 132 279 132 296 168 250 168 250 171 317 171 285 119 248 119 254 141 113 142 107 152 145 152 142 159 80 159 93 140 76 140 61 162 81 162 77 166 18 166 62 115 35 114 66 86 77 86 86 96 104 109 89 133 227 133 212 77 206 73 189 70 183 71 182 80 155 84 134 81 121 76 107 76 91 78 62 79 84 58 229 58 247 109 290 106 310 76 299 59 287 60 273 59 260 52 64 53 3 92 3 126 44 126 7 164 6 170 159 170 160 156 207 156 210 161 174 161 174 173 0 173 0 0 319 0 319 173]
	[local135 200]
)

(procedure (localproc_0)
	(giraffe init:)
	(snake init:)
	(cat init:)
	(rabbit init:)
	(bear init:)
	(goose init:)
	(plant init:)
	(mouse init:)
	(fountain init:)
	(flowers init:)
	(roseBush init:)
	(grass init:)
	(hedge init:)
	(wall init:)
)

(instance Room290 of FRoom
	(properties
		lookStr {This place is a maze of hedges.}
		picture 295
		style 0
		invX 280
		invY 46
	)

	(method (init)
		(self defeatEntrance: 1)
		(super init:)
		(gTheIconBar enable: show:)
		(gCurRoom
			addObstacle:
				((Polygon new:) type: PBarredAccess size: 67 dynamic: 0 points: @local1)
		)
		(localproc_0)
		(old ignoreActors: 1 stopUpd: init:)
		(switch (gBeautyStory state:)
			(4
				(Load rsPIC 290)
				(LoadMany rsVIEW 691 711 713 690)
				(LoadMany rsSOUND 112 137)
				(self setScript: enterWithBeauty)
			)
		)
	)

	(method (enterSpecial)
		(gCurRoom setScript: enterEgo)
	)

	(method (doit)
		(super doit:)
		(cond
			((gCurRoom script:) 0)
			((and (>= (gEgo y:) 162) (<= 183 (gEgo x:) 220))
				(self newRoom: 340)
			)
		)
	)

	(method (dispose)
		(gEgo illegalBits: $8000)
		(if (and (== global144 gBeautyStory) (gGlobalMusic handle:))
			(gGlobalMusic fade: 0 15 12 1)
			(= global225 6)
		)
		(DisposeScript 964)
		(super dispose: &rest)
	)
)

(instance enterEgo of HandsOffScript
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(NormalEgo 5 global139)
				(gEgo posn: 216 185 illegalBits: 0 init:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: PolyPath 216 160 self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance enterWithBeauty of HandsOffScript
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gGame setCursor: gTheCursor 1 300 150)
				(Beast posn: 175 95 ignoreActors: 1 init:)
				(beastHand init:)
				(= local0 ((gInventory at: 8) regActor:))
				(local0
					setLoop: -1
					normal: 1
					setHeading: 0
					setMotion: 0
					setAvoider: 0
					setCycle: StopWalk
					posn: 192 170
					init:
				)
				(= cycles 1)
			)
			(2
				(proc10_28)
				(gEgo setMotion: MoveTo 214 142 self)
			)
			(3
				(gEgo setMotion: MoveTo 128 142 self)
			)
			(4
				(Face gEgo Beast)
				(proc10_13 2 local0 Beast self 0 290 0)
			)
			(5
				(proc10_13 3 local0 Beast self 1 290 1)
				(local0 doCode: 0)
			)
			(6
				(local0
					cycleSpeed: 3
					moveSpeed: 3
					ignoreActors: 1
					setMotion:
						DPath
						216
						170
						216
						148
						152
						148
						152
						170
						10
						170
						36
						146
						42
						139
						59
						117
						17
						117
						49
						85
						80
						85
						148
						95
						self
				)
			)
			(7
				(Face local0 Beast)
				(= cycles 3)
			)
			(8
				(local0
					posn: 175 95
					view: 690
					loop: 0
					cel: 0
					normal: 0
					setCycle: CT 3 1 self
				)
			)
			(9
				(beastHand dispose:)
				(local0 setCycle: End self)
			)
			(10
				(= ticks 60)
			)
			(11
				(proc10_13 3 local0 Beast -1 1 290 2)
				(proc10_13 3 local0 Beast -1 0 290 3)
				(proc10_13 3 local0 Beast -1 0 290 4)
				(proc10_13 3 local0 Beast -1 1 290 5)
				(proc10_13 3 Beast local0 -1 1 290 6)
				(proc10_13 0 local0 Beast -1 1 290 7)
				(proc10_13 2 Beast local0 -1 1 290 8)
				(proc10_13 0 local0 Beast self 1 290 9)
			)
			(12
				(local0 loop: 1 cel: 0 setCycle: End)
				(gGlobalMusic2 number: 137 flags: 1 setLoop: 1 play:)
				(Beast setCycle: End self)
			)
			(13
				(gGlobalMusic number: 16 priority: 15 setLoop: -1 play:)
				(gCurRoom drawPic: 290 0)
				(water setCycle: Fwd init:)
				(waterSound play:)
				(= ticks 120)
			)
			(14
				((= temp0 (beastTalkObj)) view: 713)
				((temp0 bust:) nsLeft: 39 nsTop: 28 view: 713)
				((temp0 eyes:) nsLeft: 41 nsTop: 36 view: 713)
				((temp0 mouth:) nsLeft: 41 nsTop: 49 view: 713)
				(proc10_13 2 local0 Beast -1 1 290 10)
				(proc10_13 0 Beast local0 -1 0 290 11)
				(proc10_13 0 Beast local0 -1 0 290 12)
				(proc10_13 0 Beast local0 self 1 290 13)
			)
			(15
				(Beast hide:)
				(local0 loop: 2 cel: 0 setCycle: End)
				(= ticks 120)
			)
			(16
				(proc10_13
					0
					Beast
					gEgo
					-1
					1
					(Format @local135 290 14 @global110) ; "%s, thank you for your friendship and help."
				)
				(proc10_13
					0
					local0
					gEgo
					self
					1
					(Format @local135 290 15 @global110) ; "Thank you so very much, %s."
				)
			)
			(17
				(= ticks 60)
			)
			(18
				(self setScript: (ScriptID 91 2) self) ; DisplayEnd
			)
			(19
				((gInventory at: 8) owner: 0)
				(gBeautyStory incState:)
				(gBeautyStory done: 1)
				(++ global145)
				(= global144 gBeautyStory)
				(gEgo setMotion: MoveTo 214 142 self)
			)
			(20
				(gEgo
					doCode: 0
					setAvoider: PAvoider
					setMotion: MoveTo 214 160 self
				)
			)
			(21
				(= global142 0)
				(if (== global144 global143)
					(= global143 0)
				)
				(Beast dispose:)
				(local0 dispose:)
				(gCurRoom newRoom: 330)
			)
		)
	)
)

(instance waterSound of Sound
	(properties
		flags 1
		number 112
		loop -1
	)
)

(instance Beast of Tactor
	(properties
		description {It is the Beast!}
		view 714
		talkerID 14
	)

	(method (setUp)
		((= talkerObj beastTalkObj) setUp: beastBust beastEyes beastMouth)
	)
)

(instance beastTalkObj of TalkerObj
	(properties
		x -1
		y 97
		nsTop 10
		nsLeft 108
		view 711
	)
)

(instance beastBust of View
	(properties
		nsTop 22
		nsLeft 50
		view 711
		loop 6
	)
)

(instance beastEyes of Prop
	(properties
		nsTop 26
		nsLeft 53
		view 711
		loop 4
		cycleSpeed 36
	)
)

(instance beastMouth of Prop
	(properties
		nsTop 38
		nsLeft 60
		view 711
		loop 2
		cycleSpeed 12
	)
)

(instance beastHand of View
	(properties
		x 175
		y 95
		view 714
		loop 1
	)
)

(instance old of View
	(properties
		x 152
		y 52
		view 290
	)

	(method (doVerb theVerb)
		(fountain doVerb: theVerb)
	)
)

(instance water of Prop
	(properties
		x 153
		y 72
		view 290
		loop 1
	)
)

(instance giraffe of Feature
	(properties
		x 34
		y 53
		description {Giraffe}
		sightAngle 90
		onMeCheck 2
		lookStr {Here is a giraffe made from plants.}
	)
)

(instance snake of Feature
	(properties
		x 237
		y 109
		description {Snake}
		sightAngle 90
		onMeCheck 4
		lookStr {This plant was made to grow in the shape of a snake.}
	)
)

(instance cat of Feature
	(properties
		x 79
		y 40
		description {Cat}
		sightAngle 90
		onMeCheck 8
		lookStr {A cat made of plants looks down at the fountain.}
	)
)

(instance rabbit of Feature
	(properties
		x 118
		y 140
		description {Rabbit}
		sightAngle 90
		onMeCheck 16
		lookStr {This rabbit grows from leaves of the hedge.}
	)
)

(instance bear of Feature
	(properties
		x 69
		y 107
		description {Bear}
		sightAngle 90
		onMeCheck 32
		lookStr {This bear is made from leaves.}
	)
)

(instance goose of Feature
	(properties
		x 26
		y 100
		description {Goose}
		sightAngle 90
		onMeCheck 64
		lookStr {This goose looks like it can fly.}
	)
)

(instance plant of Feature
	(properties
		x 216
		y 35
		description {Plant}
		sightAngle 90
		onMeCheck 128
		lookStr {This plant looks like a fox with wings.}
	)
)

(instance mouse of Feature
	(properties
		x 305
		y 35
		description {Mouse}
		sightAngle 90
		onMeCheck 256
		lookStr {Here is a giant mouse made of plants.}
	)
)

(instance fountain of Feature
	(properties
		x 152
		y 94
		description {Fountain}
		sightAngle 90
		onMeCheck 512
		lookStr {This fountain has water in it.}
	)
)

(instance flowers of Feature
	(properties
		x 115
		y 78
		description {Flowers}
		sightAngle 90
		onMeCheck 1024
		lookStr {These flowers smell like apples.}
	)
)

(instance roseBush of Feature
	(properties
		x 277
		y 55
		description {Rose bush}
		sightAngle 90
		onMeCheck 2048
		lookStr {Here is a rose bush.}
	)
)

(instance grass of Feature
	(properties
		x 136
		y 112
		description {Grass}
		sightAngle 90
		onMeCheck 16384
		lookStr {The grass is fun to walk on.}
	)
)

(instance wall of Feature
	(properties
		x 189
		y 35
		description {Wall}
		sightAngle 90
		onMeCheck 8192
		lookStr {There is the wall that goes around this area.}
	)
)

(instance hedge of Feature
	(properties
		x 151
		y 134
		description {Hedge}
		sightAngle 90
		onMeCheck 4096
		lookStr {A hedge is a wall made of plants.}
	)
)

