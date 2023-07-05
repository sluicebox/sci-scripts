;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 130)
(include sci.sh)
(use Main)
(use n010)
(use Tactor)
(use goGet)
(use Interface)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	Room130 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0)
	(house init:)
	(roof init:)
	(window1 init:)
	(door init:)
	(wall init:)
	(fence init:)
	(road init:)
	(mountain init:)
	(sky init:)
	(garden init:)
)

(instance Room130 of FRoom
	(properties
		lookStr {From here you can see Jack's house.}
		picture 130
		style 0
		west 120
		westY 156
	)

	(method (doit)
		(super doit:)
		(cond
			(script 0)
			(local1 0)
			((and (not (gJackStory selected:)) (< (gEgo x:) 15))
				(gCurRoom setScript: encourage)
			)
		)
	)

	(method (init)
		(cond
			((== (gJackStory state:) 0 1)
				(Load rsSOUND 24)
			)
			((gEgo has: 2)
				(if (gGame script:)
					(gGame setScript: 0)
				)
				(LoadMany rsSOUND 20 24 113 136)
			)
			((> global225 0)
				(Load rsSOUND global225)
			)
		)
		(super init:)
		(if (== (gJackStory state:) 1)
			(if (gGame script:)
				(gGame setScript: 0)
				(gGlobalMusic2 stop:)
			)
			(gGlobalMusic number: 24 priority: 15 setLoop: -1 play:)
		else
			(proc10_29)
		)
		(if (OneOf (gJackStory state:) 2 3)
			(stalk cel: 14 stopUpd: init:)
		)
		(gTheIconBar enable: show:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 173 0 173 0 163 167 161 216 129 229 122 296 110 291 104 274 100 273 105 257 105 206 120 181 123 110 111 23 144 0 145
					yourself:
				)
		)
		(localproc_0)
		(if (OneOf (gJackStory state:) 0 1)
			(jack
				view: 620
				ignoreActors: 0
				setPri: 7
				posn: 186 119
				selection: 0
				init:
			)
			(jHead
				ignoreActors: 1
				setPri: 8
				setLoop: 1
				cel: 0
				posn: (+ (jack x:) 10) (- (jack y:) 10)
				cycleSpeed: 24
				init:
			)
		)
	)

	(method (cue)
		(super cue:)
		(switch (gJackStory state:)
			(0
				(gEgo doCode: egoDo130)
				(gJackStory selectCode: jackSelect)
				(gEgo selection: 0)
				(jack selection: 0)
				(self setScript: moveEgoCloser)
			)
			(1
				(gEgo doCode: egoDo130)
				(self setScript: enterAfterStory)
			)
			(2
				(window1 lookStr: {The house is dark and no one is inside.})
			)
			(3
				(window1 lookStr: {The house is dark and no one is inside.})
			)
			(4
				(window1 lookStr: {The house is dark and no one is inside.})
			)
		)
	)

	(method (dispose)
		(gJackStory selectCode: 0)
		(if (gGlobalMusic handle:)
			(gGlobalMusic fade: 0 15 12 1)
			(= global225 6)
		)
		(super dispose:)
	)
)

(instance moveEgoCloser of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 144 126 self)
			)
			(1
				(jHead setCycle: End self)
			)
			(2
				(jHead stopUpd:)
				(jack stopUpd:)
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
				(= local1 1)
				(gEgo setMotion: 0)
				(Face gEgo jack)
				(= cycles 1)
			)
			(1
				(proc10_13 3 jack gEgo self 1 130 0)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance enterAfterStory of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(jHead setCycle: End self)
			)
			(1
				(gEgo setMotion: PolyPath 125 133 self)
			)
			(2
				(proc10_13 0 jack gEgo self 1 130 1)
			)
			(3
				(if (gEgo has: 2)
					(self setScript: returnBeans self)
				else
					(proc10_13 3 gEgo jack -1 1 130 2)
					(proc10_13 3 jack gEgo self 1 130 3)
				)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance returnBeans of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gJackStory incState:)
				(= cycles 1)
			)
			(1
				(gGlobalMusic number: 20 priority: 15 setLoop: -1 play:)
				(= ticks 1)
			)
			(2
				(proc10_13 0 gEgo jack self 1 130 4)
			)
			(3
				((gInventory at: 2) owner: 0)
				(gEgo setMotion: PolyPath 158 114 self)
			)
			(4
				(Face gEgo jack self)
			)
			(5
				(gTheIconBar curInvIcon: 0 show:)
				(jHead dispose:)
				(jack view: 622 setPri: -1 setLoop: 0 cel: 0 setCycle: End self)
			)
			(6
				(gGlobalMusic2 number: 113 setLoop: 1 flags: 1 play:)
				(jack setLoop: 1 cel: 0 setCycle: CT 5 1 self)
			)
			(7
				(proc10_13 0 jack gEgo self 1 130 5)
			)
			(8
				(jack setCycle: End self)
			)
			(9
				(proc10_13 0 jack gEgo self 1 130 6)
			)
			(10
				(Face gEgo stalk self)
			)
			(11
				(jack
					xStep: 8
					setLoop: 2
					cel: 0
					setCycle: Walk
					setMotion: PolyPath 292 107 self
				)
			)
			(12
				(jack
					setPri: 15
					setLoop: 3
					cel: 0
					relPosn: jack 1 -42
					setCycle: End self
				)
			)
			(13
				(jack setLoop: 4 cel: 0 setCycle: CT 2 1 self)
			)
			(14
				(jack setPri: 3 setCycle: End self)
			)
			(15
				(stalkS play:)
				(proc10_13 0 jack gEgo self 1 130 7)
			)
			(16
				(stalk init: setCycle: End self)
			)
			(17
				(stalkS stop:)
				(= ticks 90)
			)
			(18
				(jack
					cycleSpeed: 12
					setLoop: 5
					cel: 0
					posn: (stalk x:) (stalk y:)
					setCycle: End self
				)
			)
			(19
				(proc10_13 0 jack gEgo -1 0 130 8)
				(proc10_13 0 jack gEgo self 1 130 9)
			)
			(20
				(window1 lookStr: {The house is dark and no one is inside.})
				(stalk stopUpd:)
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
				(gEgo selection: 0)
				(jack selection: 0)
				(= local0 1)
				(gJackStory selected: 1 incState:)
				(= global143 gJackStory)
				(proc10_19 (gInventory at: 2))
				(if (gGame script:)
					(gGame setScript: 0)
					(gGlobalMusic2 stop:)
				)
				(gGlobalMusic number: 24 priority: 15 setLoop: -1 play:)
				(self setScript: (ScriptID 91 1) self) ; DisplayStart
			)
			(1
				(proc10_13 0 jack gEgo -1 0 130 10)
				(proc10_13 3 jack gEgo self 1 130 11)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance jackSelect of Code
	(properties)

	(method (doit)
		(gCurRoom setScript: storySelect)
	)
)

(instance egoDo130 of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(switch (gJackStory state:)
					(0
						(if local1
							(proc10_13 2 gEgo jack -1 1 130 12)
							(proc10_13 0 jack gEgo -1 1 130 13)
						else
							(switch (gEgo selection:)
								(0
									(proc10_13 3 gEgo jack -1 1 130 14)
									(proc10_13 3 jack gEgo -1 1 130 15)
								)
								(1
									(proc10_13 2 gEgo jack -1 1 130 16)
									(proc10_13 0 jack gEgo -1 0 130 17)
									(proc10_13 0 jack gEgo -1 1 130 18)
								)
								(2
									(proc10_13 2 gEgo jack -1 1 130 19)
									(proc10_13 3 jack gEgo -1 1 130 20)
								)
								(else
									(proc10_13 0 gEgo jack -1 1 130 21)
									(proc10_13 3 jack gEgo -1 1 130 22)
								)
							)
						)
					)
					(1
						(if (and (not (gEgo has: 2)) (not local0))
							(proc10_13 3 gEgo jack -1 1 130 2)
							(proc10_13 3 jack gEgo -1 1 130 3)
						else
							(gEgo incSel:)
						)
						(switch (gEgo selection:)
							(1
								(proc10_13 2 gEgo jack -1 1 130 23)
								(proc10_13 1 jack gEgo -1 0 130 24)
								(proc10_13 1 jack gEgo -1 1 130 25)
							)
							(2
								(proc10_13 2 gEgo jack -1 1 130 26)
								(proc10_13 0 jack gEgo -1 1 130 27)
							)
							(3
								(proc10_13 0 gEgo jack -1 1 130 28)
								(proc10_13 0 jack gEgo -1 1 130 29)
							)
							(else
								(proc10_13 0 gEgo jack -1 1 130 30)
								(proc10_13 0 jack gEgo -1 1 130 31)
							)
						)
					)
				)
				(gEgo incSel:)
			)
		)
	)
)

(instance stalk of Prop
	(properties
		x 284
		y 8
		description {Beanstalk}
		lookStr {The beanstalk grows over the wall.}
		view 130
	)
)

(instance jHead of Prop
	(properties
		view 620
	)

	(method (doVerb theVerb)
		(jack doVerb: theVerb)
	)
)

(instance jack of Tactor
	(properties
		description {Jack}
		lookStr {There is a young boy here.}
		talkerID 5
	)

	(method (setUp)
		((= talkerObj jackTalkObj) setUp: jackBust jackEyes jackMouth)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(switch (gJackStory state:)
					(0
						(if local1
							(proc10_13 3 jack gEgo -1 1 130 32)
						else
							(switch (jack selection:)
								(0
									(jHead setCycle: End)
									(proc10_13 3 self gEgo -1 1 130 33)
									(proc10_13 3 self gEgo -1 1 130 34)
									(proc10_13 3 self gEgo -1 1 130 35)
									(proc10_13 3 self gEgo -1 1 130 36)
								)
								(1
									(proc10_13 3 self gEgo -1 1 130 37)
								)
								(2
									(proc10_13 3 self gEgo -1 1 130 38)
								)
								(else
									(proc10_13 3 self gEgo -1 1 130 39)
								)
							)
						)
					)
					(1
						(switch (jack selection:)
							(0
								(proc10_13 3 self gEgo -1 1 130 40)
							)
							(1
								(proc10_13 3 self gEgo -1 1 130 41)
							)
							(2
								(proc10_13 0 self gEgo -1 1 130 42)
							)
							(else
								(proc10_13 2 self gEgo -1 1 130 43)
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
)

(instance jackTalkObj of TalkerObj
	(properties
		x -1
		y 97
		nsTop 10
		nsLeft 108
		view 621
	)
)

(instance jackBust of View
	(properties
		nsTop 27
		nsLeft 40
		view 621
		loop 6
	)
)

(instance jackEyes of Prop
	(properties
		nsTop 31
		nsLeft 42
		view 621
		loop 4
		cycleSpeed 36
	)
)

(instance jackMouth of Prop
	(properties
		nsTop 38
		nsLeft 39
		view 621
		loop 2
		cycleSpeed 12
	)
)

(instance house of Feature
	(properties
		x 149
		y 76
		description {House}
		sightAngle 90
		onMeCheck 2
		lookStr {Jack lives with his mother in this house.}
	)
)

(instance roof of Feature
	(properties
		x 183
		y 35
		description {Roof}
		sightAngle 90
		onMeCheck 4
		lookStr {The roof of this house is made of straw.}
	)
)

(instance window1 of Feature
	(properties
		x 116
		y 100
		description {Window}
		sightAngle 90
		onMeCheck 8
		lookStr {Jack's mom is sewing clothes.}
	)
)

(instance door of Feature
	(properties
		x 151
		y 110
		description {Door}
		sightAngle 90
		onMeCheck 16
		lookStr {The door is locked.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (OneOf (gJackStory state:) 0 1)
					(Print 130 44 #title {Mom}) ; "Go play in the yard, Jack. I am doing my work now."
				else
					(Print 130 45) ; "No one is home now."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wall of Feature
	(properties
		x 56
		y 91
		description {Wall}
		sightAngle 90
		onMeCheck 32
		lookStr {The wall is very high and too hard for you to climb.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(Print 130 46) ; "The wall is too high for you to climb."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fence of Feature
	(properties
		x 195
		y 150
		description {Fence}
		sightAngle 90
		onMeCheck 64
		lookStr {The fence is made of wood.}
	)
)

(instance road of Feature
	(properties
		x 108
		y 150
		description {Road}
		sightAngle 90
		onMeCheck 128
		lookStr {The road leads west.}
	)
)

(instance mountain of Feature
	(properties
		x 266
		y 35
		description {Mountain}
		sightAngle 90
		onMeCheck 256
		lookStr {The mountain is very tall.}
	)
)

(instance sky of Feature
	(properties
		x 62
		y 35
		description {Sky}
		sightAngle 90
		onMeCheck 512
		lookStr {The sky is clear.}
	)
)

(instance garden of Feature
	(properties
		x 271
		y 150
		description {Garden}
		sightAngle 90
		onMeCheck 1024
		lookStr {The garden has just been planted with seeds.}
	)
)

(instance stalkS of Sound
	(properties
		flags 1
		number 136
		loop -1
	)
)

