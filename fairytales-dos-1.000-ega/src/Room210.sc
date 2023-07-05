;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 210)
(include sci.sh)
(use Main)
(use n010)
(use Tactor)
(use goGet)
(use Interface)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	Room210 0
)

(local
	[local0 200]
	local200
	local201
	[local202 12] = [132 118 149 123 225 123 207 126 185 128 167 129]
	[local214 8] = [0 0 0 0 0 0 0 1]
	local222 = 1
	[local223 6] = [{This dwarf is sad.} {This dwarf is crying.} {This dwarf has a tear in his eye.} {This dwarf looks mad.} {This dwarf looks at Snow White sadly.} {This dwarf has tears in his beard and on his face.}]
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 6) ((++ temp0))
		((= [local214 temp0] (dwarf new:))
			setLoop: temp0
			ignoreActors: 1
			posn: [local202 (* temp0 2)] [local202 (+ (* temp0 2) 1)]
			lookStr: [local223 temp0]
			init:
			cycleSpeed: 18
		)
	)
)

(procedure (localproc_1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 6) ((++ temp0))
		([local214 temp0] cycleSpeed: 6 view: 678)
		(Chief cycleSpeed: 6 setLoop: 1)
	)
)

(procedure (localproc_2)
	(tree init:)
	(grass init:)
	(rock init:)
	(wall init:)
	(mountain init:)
	(flower1 init:)
	(flower2 init:)
	(flower3 init:)
	(sky init:)
	(bushes init:)
)

(instance Room210 of FRoom
	(properties
		picture 210
		style 0
		east 220
		south 260
		invX 106
		invY 103
		southX 181
		southY 168
		eastX 311
		eastY 143
	)

	(method (init)
		(if (> global225 0)
			(Load rsSOUND global225)
		)
		(cond
			((OneOf (gSnowStory state:) 3 2 4)
				(if (gGame script:)
					(gGame setScript: 0)
					(gGlobalMusic2 stop:)
				)
				(Load rsSOUND 1)
			)
			((== (gSnowStory state:) 4)
				(Load rsSOUND 8)
			)
		)
		(super init:)
		(if (OneOf (gSnowStory state:) 3 2 4)
			(gGlobalMusic number: 1 priority: 15 setLoop: -1 play:)
		else
			(proc10_29)
		)
		(gTheIconBar enable: show:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 131 304 128 289 125 262 115 240 101 252 86 242 82 221 75 212 71 182 71 172 76 150 75 137 79 120 77 106 80 92 96 73 112 64 119 81 143 119 151 134 173 0 173 0 0 319 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 233 173 241 161 319 160 319 173
					yourself:
				)
		)
		(if (IsFlag 5)
			(ClearFlag 5)
		)
		(localproc_2)
		(if (OneOf (gSnowStory state:) 2 3 4)
			(gEgo doCode: egoDo210)
			(Chief posn: 145 85 cycleSpeed: 12 init:)
			(Snow_White
				setPri: 7
				view: 669
				setLoop: 0
				cel: 0
				posn: 192 86
				init:
			)
			(localproc_0)
			(coffin init:)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 120 120 121 88 144 81 222 81 231 89 226 102 237 125 196 134 167 133
						yourself:
					)
			)
		)
		(if (== (gSnowStory state:) 4)
			(= local200 ((gInventory at: 11) regActor:))
		)
		(if (> global229 16)
			(forestSound play:)
		)
	)

	(method (cue)
		(super cue:)
		(if (OneOf (gSnowStory state:) 2 3)
			(gCurRoom setScript: enterFoundDead)
		)
		(if (== (gSnowStory state:) 4)
			(gCurRoom setScript: enterWithPrince)
		)
	)

	(method (doit)
		(if
			(and
				(not script)
				(not local200)
				(not local201)
				(OneOf (gSnowStory state:) 2 3)
				(or (> (gEgo y:) 165) (> (gEgo x:) 305))
			)
			(gCurRoom setScript: encourage)
		else
			(super doit:)
		)
	)

	(method (dispose)
		(if (gGlobalMusic handle:)
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

(instance enterWithPrince of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSnowStory incState: done: 1)
				(++ global145)
				(= global144 gSnowStory)
				((gInventory at: 11) owner: 0)
				(local200 setMotion: 0)
				(gEgo setMotion: PolyPath 155 142 self)
			)
			(1
				(Face gEgo Snow_White)
				(Face local200 Snow_White)
				(proc10_28)
				(local200 setMotion: PolyPath 252 95 self)
			)
			(2
				(local200 setHeading: 270)
				(= ticks 60)
			)
			(3
				(proc10_13 2 local200 Snow_White self 1 210 0)
			)
			(4
				(Face gEgo Snow_White)
				(local200 ignoreActors: 1 setMotion: PolyPath 203 80 self)
			)
			(5
				(local200
					normal: 0
					view: 669
					description: {Prince}
					lookStr: {Prince Charming looks at Snow White.}
					setLoop: 2
					cel: 0
					posn: 191 85
				)
				(proc10_13 0 local200 Snow_White self 0 210 1)
			)
			(6
				(proc10_13 3 local200 Snow_White self 1 210 2)
			)
			(7
				(proc10_13 0 gEgo local200 self 1 210 3)
			)
			(8
				(proc10_13
					3
					local200
					gEgo
					self
					1
					(Format @local0 210 4 @global110) ; "%s, are you sure I must kiss her?"
				)
			)
			(9
				(proc10_13 2 gEgo local200 self 1 210 5)
			)
			(10
				(local200 setPri: 6 cycleSpeed: 12 setCycle: CT 4 1 self)
			)
			(11
				(local200 cycleSpeed: 18 setCycle: CT 6 1 self)
			)
			(12
				(= ticks 150)
			)
			(13
				(local200 setCycle: End self)
			)
			(14
				(local200 setCycle: CT 10 -1)
				(= ticks 30)
			)
			(15
				(local200 setCycle: CT 11 1)
				(= ticks 30)
			)
			(16
				(local200 setCycle: CT 10 -1)
				(= ticks 30)
			)
			(17
				(local200 setCycle: CT 11 1)
				(= ticks 30)
			)
			(18
				(Snow_White setCycle: End self)
			)
			(19
				(gGlobalMusic number: 8 priority: 15 setLoop: -1 play:)
				(= ticks 60)
			)
			(20
				(proc10_13 2 Snow_White local200 self 1 210 6)
			)
			(21
				(localproc_1)
				(= ticks 3)
			)
			(22
				(= ticks 240)
			)
			(23
				(proc10_13 0 local200 Snow_White self 0 210 7)
			)
			(24
				(proc10_13
					0
					local200
					Snow_White
					self
					0
					(Format @local0 210 8 @global110) ; "That is, %s helped me find you."
				)
			)
			(25
				(proc10_13 0 local200 Snow_White self 0 210 9)
			)
			(26
				(proc10_13 0 local200 Snow_White self 1 210 10)
			)
			(27
				(proc10_13 0 Snow_White local200 self 0 210 11)
			)
			(28
				(proc10_13 0 Snow_White local200 self 1 210 12)
			)
			(29
				(local200 hide:)
				(Snow_White setLoop: 1 setCel: 0 setCycle: End self)
			)
			(30
				(proc10_13
					0
					local200
					gEgo
					self
					1
					(Format @local0 210 13 @global110) ; "Thank you, %s, for all the help you have given us."
				)
			)
			(31
				(proc10_13 0 Snow_White gEgo self 1 210 14)
			)
			(32
				(self setScript: (ScriptID 91 2) self) ; DisplayEnd
			)
			(33
				(gEgo
					doCode: 0
					setMotion: PolyPath 319 (gCurRoom eastY:) self
				)
			)
			(34
				(= global142 0)
				(if (== global144 global143)
					(= global143 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance enterFoundDead of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= (gSnowStory state:) 3)
					(gSnowStory incState:)
				)
				(= cycles 1)
			)
			(1
				(proc10_13
					3
					Chief
					gEgo
					self
					1
					(Format @local0 210 15 @global110) ; "Oh, %s, Snow White ate a bite of an apple and now lies dead."
				)
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
				(gEgo setMotion: 0)
				(= cycles 1)
			)
			(1
				(= local201 1)
				(Face gEgo Chief)
				(= cycles 1)
			)
			(2
				(proc10_13 3 Chief gEgo self 1 210 16)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance egoDo210 of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(switch (gSnowStory state:)
					(3
						(switch (gEgo selection:)
							(0
								(proc10_13 3 gEgo Chief -1 1 210 17)
								(proc10_13 3 Chief gEgo -1 1 210 18)
							)
							(1
								(proc10_13 3 gEgo Chief -1 1 210 19)
								(proc10_13 3 Chief gEgo -1 1 210 20)
							)
							(2
								(proc10_13 3 gEgo Chief -1 1 210 21)
								(proc10_13 3 Chief gEgo -1 1 210 22)
							)
							(else
								(proc10_13 3 gEgo Chief -1 1 210 23)
								(proc10_13 3 Chief gEgo -1 1 210 24)
								(proc10_13 1 gEgo Chief -1 1 210 25)
								(proc10_13
									3
									Chief
									gEgo
									-1
									1
									(Format @local0 210 26 @global110) ; "Prince Silver may need your help, %s."
								)
							)
						)
					)
				)
				(gEgo incSel:)
			)
		)
	)
)

(instance Chief of Tactor
	(properties
		description {Dwarf}
		lookStr {This dwarf looks at you sadly.}
		view 675
		talkerID 17
	)

	(method (setUp)
		((= talkerObj dwarfTalkObj) setUp: dwarfBust dwarfEyes dwarfMouth)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(switch (gSnowStory state:)
					(3
						(switch (self selection:)
							(0
								(proc10_13 3 self gEgo -1 1 210 27)
							)
							(1
								(proc10_13 1 self gEgo -1 1 210 28)
							)
							(2
								(proc10_13 3 self gEgo -1 1 210 22)
							)
							(else
								(proc10_13 3 self gEgo -1 1 210 29)
							)
						)
					)
				)
				(self incSel:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit &tmp temp0)
		(if (== (Random 0 17) 7)
			(switch (Random 0 2)
				(0
					(self setCycle: Fwd)
				)
				(1
					(self setCycle: 0)
				)
				(2
					(self setCycle: Beg)
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

(instance Snow_White of Tactor
	(properties
		name {Snow White}
		description {Snow White}
		lookStr {Snow White looks like she is asleep.}
		view 669
		talkerID 15
	)

	(method (init)
		((= talkerObj snowTalkObj) setUp: snowBust snowEyes snowMouth)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(Print 210 30) ; "Snow White has nothing to say."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance snowTalkObj of TalkerObj
	(properties
		x -1
		y 97
		nsTop 10
		nsLeft 108
		view 671
	)
)

(instance snowBust of View
	(properties
		nsTop 22
		nsLeft 53
		view 671
		loop 6
	)
)

(instance snowEyes of Prop
	(properties
		nsTop 26
		nsLeft 54
		view 671
		loop 4
		cycleSpeed 36
	)
)

(instance snowMouth of Prop
	(properties
		nsTop 35
		nsLeft 47
		view 671
		loop 2
		cycleSpeed 12
	)
)

(instance coffin of Prop
	(properties
		x 189
		y 93
		description {Coffin}
		lookStr {The coffin is made of glass.}
		view 210
	)
)

(instance dwarf of Tactor
	(properties
		description {Dwarf}
		lookStr {This dwarf looks at you sadly.}
		view 677
		talkerID 17
	)

	(method (init)
		((= talkerObj dwarfTalkObj) setUp: dwarfBust dwarfEyes dwarfMouth)
		(super init: &rest)
	)

	(method (doit &tmp temp0)
		(if (and (IsObject [local214 5]) (== (Random 0 3) 2))
			(= temp0 (Random 0 5))
			(cond
				((or (== view 677) (< temp0 4))
					(switch (Random 0 2)
						(0
							([local214 temp0] setCycle: Fwd)
						)
						(1
							([local214 temp0] setCycle: 0)
						)
						(2
							([local214 temp0] setCycle: Beg)
						)
					)
				)
				(local222
					([local214 4] setCel: 0 setCycle: Osc)
					([local214 5] setCel: 0 setCycle: Osc)
					(= local222 0)
				)
			)
		)
		(super doit: &rest)
	)
)

(instance tree of Feature
	(properties
		x 44
		y 54
		description {Tree}
		sightAngle 90
		onMeCheck 2
		lookStr {The tree has brown bark.}
	)
)

(instance rock of Feature
	(properties
		x 42
		y 133
		description {Rock}
		sightAngle 90
		onMeCheck 4
		lookStr {This rock is very dark.}
	)
)

(instance wall of Feature
	(properties
		x 178
		y 61
		description {Wall}
		sightAngle 90
		onMeCheck 8
		lookStr {You can see the wall of the city from here.}
	)
)

(instance mountain of Feature
	(properties
		x 126
		y 56
		description {Mountain}
		sightAngle 90
		onMeCheck 16
		lookStr {The mountains seem far away.}
	)
)

(instance flower1 of Feature
	(properties
		x 275
		y 126
		description {Flowers}
		sightAngle 90
		onMeCheck 32
		lookStr {These flowers smell like ripe grapes.}
	)
)

(instance flower2 of Feature
	(properties
		x 115
		y 152
		description {Flowers}
		sightAngle 90
		onMeCheck 64
		lookStr {These flowers smell like pie.}
	)
)

(instance flower3 of Feature
	(properties
		x 18
		y 96
		description {Flowers}
		sightAngle 90
		onMeCheck 128
		lookStr {These flowers smell like cake.}
	)
)

(instance sky of Feature
	(properties
		x 203
		y 35
		description {Sky}
		sightAngle 90
		onMeCheck 256
		lookStr {The sky is clear.}
	)
)

(instance grass of Feature
	(properties
		x 158
		y 77
		description {Grass}
		sightAngle 90
		onMeCheck 512
		lookStr {This grass tickles your leg.}
	)
)

(instance bushes of Feature
	(properties
		x 158
		y 50
		description {Bushes}
		sightAngle 90
		onMeCheck 1024
		lookStr {The bushes are very green.}
	)
)

