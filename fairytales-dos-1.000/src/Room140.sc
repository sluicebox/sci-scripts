;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 140)
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
	Room140 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0)
	(wall init:)
	(tree init:)
	(hill init:)
	(mountain init:)
	(cliff init:)
	(rock init:)
	(flower init:)
	(grass init:)
)

(instance Room140 of FRoom
	(properties
		lookStr {From here you can see far away.}
		picture 140
		style 0
		east 150
		south 190
		southX 180
		southY 162
		eastX 320
		eastY 149
	)

	(method (init)
		(cond
			((gEgo has: 3)
				(if (gGame script:)
					(gGame setScript: 0)
					(gGlobalMusic2 stop:)
				)
				(LoadMany rsVIEW 624 625 627 628)
				(LoadMany rsSOUND 3 25 4 114 132 133 134 135)
			)
			((OneOf (gJackStory state:) 2 3)
				(if (gGame script:)
					(gGame setScript: 0)
					(gGlobalMusic2 stop:)
				)
				(Load rsSOUND 3)
			)
		)
		(super init:)
		(if (or (gEgo has: 3) (OneOf (gJackStory state:) 2 3))
			(gGlobalMusic number: 3 priority: 15 setLoop: -1 play:)
		)
		(gTheIconBar enable: show:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 173 0 0 319 0 319 147 309 145 302 148 294 143 247 133 234 138 226 130 216 132 196 133 183 117 167 113 154 112 135 97 121 94 50 84 48 90 36 93 31 106 9 100 6 117 76 167 148 167 153 173
					yourself:
				)
		)
		(localproc_0)
		(if (OneOf (gJackStory state:) 2 3)
			(if (proc10_17 InvFriend)
				(= local0 (gEgo doCode:))
			)
			(gEgo doCode: egoDo140)
			(jack
				view: 623
				setLoop: 0
				selection: 0
				posn: 77 124
				setCycle: Fwd
				init:
			)
			(stalk ignoreActors: 0 stopUpd: init:)
		)
	)

	(method (cue)
		(super cue:)
		(switch (gJackStory state:)
			(2
				(gCurRoom setScript: enterBeansRet)
			)
			(3
				(self setScript: enterAxeGone)
			)
		)
	)

	(method (dispose)
		(if (and (OneOf (gJackStory state:) 2 3) (proc10_17 InvFriend))
			(gEgo doCode: local0)
		)
		(if (gGlobalMusic handle:)
			(gGlobalMusic fade: 0 15 12 1)
			(= global225 6)
		)
		(super dispose: &rest)
	)
)

(instance enterAxeGone of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Face gEgo jack)
				(= ticks 120)
			)
			(1
				(proc10_13 2 jack gEgo self 1 140 0)
			)
			(2
				(jack setCycle: CT 12 1 self)
			)
			(3
				(proc10_13 2 jack gEgo self 1 140 1)
			)
			(4
				(jack setCycle: CT 3 1)
				(if (gEgo has: 3)
					(self setScript: returnAxe self)
				else
					(proc10_13 3 gEgo jack -1 1 140 2)
					(proc10_13 2 jack gEgo self 1 140 3)
					(jack setCycle: Fwd)
				)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance returnAxe of HandsOffScript
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and local2 (== (gGlobalMusic prevSignal:) -1))
			(= local2 0)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gJackStory incState:)
				(gJackStory done: 1)
				(++ global145)
				(= global144 gJackStory)
				(= cycles 1)
			)
			(1
				(proc10_13 0 gEgo jack self 1 140 4)
			)
			(2
				(gEgo setMotion: PolyPath 90 130 self)
			)
			(3
				(gGlobalMusic2 number: 114 setLoop: 1 flags: 1 play:)
				(gGlobalMusic fade: 64 15 12 0)
				(gTheIconBar curInvIcon: 0 show:)
				((gInventory at: 3) owner: 0)
				(proc10_13 0 jack gEgo self 1 140 5)
				(proc10_28)
			)
			(4
				(gEgo setMotion: PolyPath 110 150)
				(gGlobalMusic number: 25 priority: 15 setLoop: 1 play:)
				(jack view: 624 setLoop: 0 cel: 0 setCycle: End self)
			)
			(5
				(= local2 1)
			)
			(6
				(jack
					view: 626
					setLoop: 0
					cycleSpeed: 12
					cel: 0
					setCycle: CT 3 1 self
				)
			)
			(7
				(ShakeScreen 2 ssUPDOWN)
				(chopS play:)
				(chip
					posn: (- (jack x:) 22) (- (jack y:) 28)
					setPri: 8
					cel: 0
					init:
				)
				(jack setCycle: End self)
			)
			(8
				(jack setCycle: CT 3 1 self)
			)
			(9
				(ShakeScreen 4 ssUPDOWN)
				(chopS play:)
				(chip cel: 1)
				(jack setCycle: End self)
			)
			(10
				(jack setCycle: CT 3 1 self)
			)
			(11
				(ShakeScreen 4 ssUPDOWN)
				(chopS play:)
				(chip cel: 2)
				(jack setCycle: End self)
			)
			(12
				(giantS number: 133 setLoop: -1 play:)
				(jack view: 627 setLoop: 0 cel: 0 setCycle: End self)
			)
			(13
				(giant
					ignoreActors: 1
					setLoop: 0
					cel: 0
					posn: 200 24
					setCycle: Fwd
					init:
				)
				(Face gEgo giant)
				(= cycles 1)
			)
			(14
				(giant yStep: 5 setMotion: MoveTo 200 72 self)
			)
			(15
				(giantS number: 134 setLoop: 1 play:)
				(gGlobalMusic number: 4 priority: 15 setLoop: -1 play:)
				(ShakeScreen 8 ssUPDOWN)
				(giant setLoop: 1 cel: 0 setCycle: End self)
			)
			(16
				(giantHole setCycle: End self init:)
			)
			(17
				(giantS number: 135 setLoop: 1 play:)
				(giantEyes setCycle: Fwd init: setPri: 10)
				(= cycles 15)
			)
			(18
				(jack view: 628 setLoop: 0 cel: 0 setCycle: End self)
			)
			(19
				(proc10_13 0 jack gEgo -1 1 140 6)
				(proc10_13 0 jack gEgo self 1 140 7)
			)
			(20
				(self setScript: (ScriptID 91 2) self) ; DisplayEnd
			)
			(21
				(gJackStory done: 1)
				(gEgo setMotion: PolyPath 319 (gCurRoom eastY:) self)
			)
			(22
				(= global142 0)
				(if (== global143 gJackStory)
					(= global143 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance enterBeansRet of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 1)
				(proc10_19 (gInventory at: 3))
				(= cycles 120)
			)
			(1
				(proc10_13 2 jack gEgo self 1 140 0)
			)
			(2
				(gJackStory incState:)
				(self dispose:)
			)
		)
	)
)

(instance egoDo140 of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(switch (gJackStory state:)
					(3
						(if local1
							(switch (gEgo selection:)
								(0
									(proc10_13 2 gEgo jack -1 1 140 8)
									(proc10_13 0 jack gEgo -1 0 140 9)
									(proc10_13 0 jack gEgo -1 0 140 10)
									(proc10_13 0 jack gEgo -1 0 140 11)
									(proc10_13 0 jack gEgo -1 0 140 12)
									(proc10_13 0 jack gEgo -1 0 140 13)
									(proc10_13 1 jack gEgo -1 0 140 14)
									(proc10_13 3 jack gEgo -1 1 140 15)
								)
								(1
									(proc10_13 2 gEgo jack -1 1 140 16)
									(proc10_13 1 jack gEgo -1 0 140 17)
									(proc10_13 3 jack gEgo -1 1 140 18)
								)
								(2
									(proc10_13 2 gEgo jack -1 1 140 19)
									(proc10_13 3 jack gEgo -1 1 140 20)
								)
								(else
									(proc10_13 0 gEgo jack -1 1 140 21)
									(proc10_13 0 jack gEgo -1 1 140 22)
								)
							)
						else
							(proc10_13 0 gEgo jack -1 1 140 21)
							(proc10_13 2 jack gEgo -1 1 140 23)
						)
					)
				)
				(gEgo incSel:)
			)
		)
	)
)

(instance stalk of View
	(properties
		x 60
		y 114
		description {Stalk}
		lookStr {This is a giant beanstalk.}
		view 140
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(Print 140 24) ; "You find the beanstalk is much too big to climb."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance chip of Prop
	(properties
		view 629
	)
)

(instance giantEyes of Prop
	(properties
		x 179
		y 62
		view 625
		loop 3
	)
)

(instance giantHole of Prop
	(properties
		x 200
		y 72
		view 625
		loop 2
	)
)

(instance giant of Actor
	(properties
		view 625
	)
)

(instance jack of Tactor
	(properties
		description {Jack}
		lookStr {You see Jack.}
		talkerID 5
	)

	(method (setUp)
		((= talkerObj jackTalkObj) setUp: jackBust jackEyes jackMouth)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(switch (gJackStory state:)
					(3
						(if local1
							(switch (self selection:)
								(0
									(proc10_13 3 self gEgo -1 1 140 25)
								)
								(1
									(proc10_13 3 self gEgo -1 1 140 26)
								)
								(2
									(proc10_13 3 self gEgo -1 1 140 27)
								)
								(else
									(proc10_13 0 self gEgo -1 1 140 28)
								)
							)
						else
							(proc10_13 2 self gEgo -1 1 140 29)
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

(instance wall of Feature
	(properties
		x 39
		y 140
		description {Wall}
		sightAngle 90
		onMeCheck 2
		lookStr {This is part of the wall that goes around the town.}
	)
)

(instance tree of Feature
	(properties
		x 123
		y 35
		description {Tree}
		sightAngle 90
		onMeCheck 4
		lookStr {The trees are old and very tall.}
	)
)

(instance hill of Feature
	(properties
		x 169
		y 70
		description {Hill}
		sightAngle 90
		onMeCheck 8
		lookStr {The hills are near the mountains.}
	)
)

(instance mountain of Feature
	(properties
		x 173
		y 35
		description {Mountain}
		sightAngle 90
		onMeCheck 16
		lookStr {The mountains are on the far side of the hills.}
	)
)

(instance cliff of Feature
	(properties
		x 74
		y 90
		description {Cliff}
		sightAngle 90
		onMeCheck 32
		lookStr {The sides of the cliffs are steep.}
	)
)

(instance rock of Feature
	(properties
		x 287
		y 120
		description {Rock}
		sightAngle 90
		onMeCheck 64
		lookStr {This rock is very big.}
	)
)

(instance flower of Feature
	(properties
		x 205
		y 119
		description {Flowers}
		sightAngle 90
		onMeCheck 128
		lookStr {The flowers here smell like bubble gum.}
	)
)

(instance grass of Feature
	(properties
		x 157
		y 103
		description {Grass}
		sightAngle 90
		onMeCheck 256
		lookStr {The grass is green.}
	)
)

(instance chopS of Sound
	(properties
		flags 1
		number 132
	)
)

(instance giantS of Sound
	(properties
		flags 1
		number 133
		loop -1
	)
)

