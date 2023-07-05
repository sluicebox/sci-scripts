;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 330)
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
(use LoadMany)
(use StopWalk)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	Room330 0
)

(local
	local0
	local1
	[local2 32] = [0 -26 319 -26 319 173 0 173 0 160 204 161 216 156 203 146 185 137 164 137 126 137 120 135 83 135 59 138 30 138 0 140]
	[local34 200]
)

(procedure (localproc_0)
	(tree init:)
	(log init:)
	(rock init:)
	(wall init:)
	(gateL init:)
	(statue init:)
	(road init:)
	(grass init:)
	(sky init:)
	(hole init:)
)

(procedure (localproc_1 &tmp temp0 temp1 temp2)
	(if (gEgo has: 9)
		(return 0)
	)
	(= temp1 (gInventory size:))
	(for ((= temp0 0)) (< temp0 temp1) ((++ temp0))
		(= temp2 (gInventory at: temp0))
		(if (== (temp2 owner:) gEgo)
			(return temp2)
		)
	)
	(return 0)
)

(instance Room330 of FRoom
	(properties
		lookStr {Through the gate, you see a large house and garden.}
		picture 330
		style 0
		east 340
		west 320
		eastX 220
		eastY 145
		westX 10
		westY 143
	)

	(method (init)
		(if (> global225 0)
			(Load rsSOUND global225)
		)
		(if (gEgo has: 9)
			(Load rsSOUND 21)
		)
		(if (== (gBeautyStory state:) 4)
			(= local0 ((gInventory at: 8) regActor:))
			(self defeatEntrance: 1)
		)
		(if (or (== gPrevRoomNum 340) (== gPrevRoomNum 290))
			(self defeatEntrance: 1)
		)
		(if
			(and
				(not (proc10_17 InvFriend))
				(not (localproc_1))
				(== (gBeautyStory state:) 1)
			)
			(Load rsSOUND 51)
			(if (gGlobalMusic2 handle:)
				(gGlobalMusic2 fade: 0 15 12 1)
			)
		)
		(super init:)
		(proc10_29)
		(gTheIconBar enable: show:)
		(localproc_0)
		(if
			(or
				(OneOf (gBeautyStory state:) 0 3)
				(gBeautyStory done:)
				(and (proc10_17 InvFriend) (not (gCast contains: local0)))
				(and (localproc_1) (not (gCast contains: local0)))
			)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 0 319 0 319 173 0 173 0 160 234 164 240 137 164 137 126 137 120 135 83 135 59 138 30 138 0 140
						yourself:
					)
			)
			(gateR setPri: 10 cel: 0 ignoreActors: 1 stopUpd: init:)
		else
			(gCurRoom
				addObstacle:
					((= local1 (Polygon new:))
						type: PBarredAccess
						init: 0 -26 319 -26 319 173 0 173 0 160 204 161 216 156 203 146 246 127 215 126 208 135 174 134 162 140 128 140 120 135 83 135 59 138 30 138 0 140
						yourself:
					)
			)
			(gateR setPri: 11 cel: 1 stopUpd: init:)
		)
		(if (and (not (proc10_17 InvFriend)) (not (localproc_1)))
			(switch (gBeautyStory state:)
				(1
					(LoadMany rsVIEW 700 712 710 702 701 711)
					(if (gGame script:)
						(gGame setScript: 0)
						(gGlobalMusic2 stop:)
					)
					(gGlobalMusic number: 51 priority: 15 setLoop: -1 play:)
					(gEgo doCode: egoDo330)
					(fatherHead init: cycleSpeed: 24 setCycle: Osc 10)
					(Father posn: 152 140 18 ignoreActors: 1 stopUpd: init:)
					(fatherLegs ignoreActors: 1 stopUpd: init:)
				)
				(else 0)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script 0)
			(
				(and
					(== (gBeautyStory state:) 1)
					(not (proc10_17 InvFriend))
					(not (localproc_1))
					(== (gEgo onControl: 1) 16384)
				)
				(gCurRoom setScript: enterGate)
			)
		)
	)

	(method (cue)
		(super cue:)
		(if (and (not (proc10_17 InvFriend)) (not (localproc_1)))
			(switch (gBeautyStory state:)
				(1
					(if (IsFlag 6)
						(self setScript: enterRose)
					else
						(self setScript: enterBeforeRose)
					)
				)
			)
		)
	)

	(method (enterSpecial)
		(if (or (== gPrevRoomNum 340) (== gPrevRoomNum 290))
			(gCurRoom setScript: enterFromNorth self)
		else
			(gCurRoom setScript: enterWithBeauty)
		)
	)

	(method (dispose)
		(if (gGlobalMusic handle:)
			(gGlobalMusic fade: 0 15 12 1)
			(= global225 6)
		)
		(if (== (gEgo doCode:) egoDo330)
			(gEgo doCode: 0)
		)
		(if (== (gBeautyStory state:) 2)
			(gBeautyStory incState:)
		)
		(super dispose: &rest)
	)
)

(instance enterFromNorth of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(NormalEgo 5 global139)
				(if (== gPrevRoomNum 340)
					(gEgo
						posn: 228 131
						ignoreActors: 1
						init:
						setMotion: PolyPath 174 147 self
					)
				else
					(gEgo
						posn: 213 143
						init:
						setMotion: PolyPath 199 143 self
					)
				)
			)
			(1
				(gEgo ignoreActors: 0)
				(self dispose:)
			)
		)
	)
)

(instance enterWithBeauty of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local0
					setCycle: StopWalk
					ignoreActors: 1
					posn: (+ (gCurRoom westX:) 5) (gCurRoom westY:)
					init:
					setMotion: PolyPath 211 138 self
				)
				(NormalEgo 5 global139)
				(gEgo
					normal: 1
					setHeading: 90
					posn: (gCurRoom westX:) (gCurRoom westY:)
					init:
					setMotion: NPFollow local0 40
				)
			)
			(1
				(local0 setMotion: PolyPath 236 130 self)
			)
			(2
				(local0 setMotion: MoveTo 270 130 self)
			)
			(3
				(gCurRoom newRoom: 340)
				(self dispose:)
			)
		)
	)
)

(instance enterGate of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 260 120 self)
			)
			(1
				(gCurRoom newRoom: 340)
				(self dispose:)
			)
		)
	)
)

(instance enterRose of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 119 143 self)
			)
			(1
				(Face gEgo Father self)
			)
			(2
				(proc10_13 2 Father gEgo self 1 330 0)
			)
			(3
				(if (gEgo has: 9)
					(self setScript: returnRose self)
				else
					(proc10_13 3 gEgo Father -1 1 330 1)
					(gEgo selection: 1)
					(Father selection: 1)
					(proc10_13 3 Father gEgo -1 0 330 2)
					(proc10_13 3 Father gEgo self 1 330 3)
				)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance roseSound of Sound
	(properties
		flags 1
		number 114
	)
)

(instance returnRose of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gBeautyStory incState:)
				(= cycles 1)
			)
			(1
				((gInventory at: 9) owner: 0)
				(proc10_13 0 gEgo Father self 1 330 4)
			)
			(2
				(roseSound play:)
				(gTheIconBar curInvIcon: 0 show:)
				(proc10_13 0 Father gEgo self 1 330 5)
			)
			(3
				(if (gGame script:)
					(gGame setScript: 0)
					(gGlobalMusic2 stop:)
				)
				(gGlobalMusic number: 21 priority: 15 setLoop: -1 play:)
				(fatherHead dispose:)
				(fatherLegs dispose:)
				(Father view: 700 z: 0 loop: 2 cel: 0 setCycle: End)
				(Beast
					view: 712
					setLoop: 0
					cel: 0
					posn: 201 141
					init:
					setCycle: End self
				)
				(Face gEgo Beast)
			)
			(4
				(proc10_13 1 Beast Father self 1 330 6)
			)
			(5
				(Beast view: 710 loop: 0 cel: 0 setCycle: End self)
			)
			(6
				(proc10_13 1 Beast Father self 0 330 7)
			)
			(7
				(proc10_13 1 Beast Father self 0 330 8)
			)
			(8
				(proc10_13 1 Beast Father self 1 330 9)
			)
			(9
				(Beast setCycle: End self)
			)
			(10
				(proc10_13 3 Father Beast self 0 330 10)
			)
			(11
				(proc10_13 3 Father Beast self 1 330 11)
			)
			(12
				(proc10_13 1 Beast Father self 1 330 12)
			)
			(13
				(Beast setCycle: End self)
			)
			(14
				(proc10_13 3 Father Beast self 0 330 13)
			)
			(15
				(proc10_13 3 Father Beast self 1 330 14)
			)
			(16
				(proc10_13 1 Beast Father -1 0 330 15)
				(proc10_13 1 Beast Father self 1 330 16)
			)
			(17
				(proc10_13 3 Father Beast self 1 330 17)
			)
			(18
				(proc10_13 1 Beast Father self 1 330 18)
			)
			(19
				(Beast setCycle: End self)
			)
			(20
				(proc10_13 3 Father Beast self 1 330 19)
			)
			(21
				(gEgo setMotion: MoveTo 120 139 self)
			)
			(22
				(Face gEgo Beast)
				(Father
					view: 702
					setLoop: 1
					setCycle: Walk
					setMotion: PolyPath 0 157 self
				)
			)
			(23
				(gGlobalMusic number: 50 priority: 15 setLoop: -1 play:)
				(Father dispose:)
				(Beast loop: 1 cel: 0 setCycle: End self)
			)
			(24
				(Beast setCycle: Beg self)
			)
			(25
				(proc10_13
					0
					Beast
					gEgo
					self
					0
					(Format @local34 330 20 @global110) ; "Don't worry, %s, I won't hurt Beauty."
				)
			)
			(26
				(proc10_13 0 Beast gEgo self 0 330 21)
			)
			(27
				(proc10_13 0 Beast gEgo self 0 330 22)
			)
			(28
				(proc10_13 0 Beast gEgo self 1 330 23)
			)
			(29
				(Beast ignoreActors: 1 stopUpd:)
				(Memory memFREE (local1 points:))
				(local1 size: 16 points: @local2 dynamic: 0)
				(self dispose:)
			)
		)
	)
)

(instance enterBeforeRose of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 6)
				(gEgo setMotion: PolyPath 119 143 self)
			)
			(1
				(Face gEgo Father self)
			)
			(2
				(proc10_13 3 Father gEgo self 1 330 24)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance squirRun of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 180 self)
			)
			(1
				(squirrel setPri: 15 init: setCycle: CT 11 1 self)
			)
			(2
				(Print 330 25 #time 5 #at -1 100 #dispose) ; "You see a squirrel."
				(= ticks 240)
			)
			(3
				(squirrel setCycle: End self)
			)
			(4
				(squirrel cel: 0 x: 143 y: 152)
				(= cycles 1)
			)
			(5
				(squirrel dispose:)
				(self dispose:)
			)
		)
	)
)

(instance egoDo330 of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(switch (gBeautyStory state:)
					(1
						(switch (gEgo selection:)
							(0
								(proc10_13 2 gEgo Father -1 1 330 26)
								(proc10_13 3 Father gEgo -1 0 330 27)
								(proc10_13 3 Father gEgo -1 1 330 28)
								(proc10_13 3 gEgo Father -1 1 330 29)
								(proc10_13 3 Father gEgo -1 0 330 30)
								(proc10_13 3 Father gEgo -1 0 330 31)
								(proc10_13 3 Father gEgo -1 1 330 32)
							)
							(1
								(proc10_13 2 gEgo Father -1 1 330 33)
								(proc10_13 0 Father gEgo -1 0 330 34)
								(proc10_13 1 Father gEgo -1 0 330 35)
								(proc10_13 1 Father gEgo -1 1 330 36)
								(proc10_13 3 Father gEgo -1 1 330 37)
							)
							(2
								(proc10_13 0 gEgo Father -1 1 330 38)
								(proc10_13 0 Father gEgo -1 1 330 39)
								(proc10_13 2 gEgo Father -1 1 330 40)
								(proc10_13 0 Father gEgo -1 0 330 41)
								(proc10_13 3 Father gEgo -1 1 330 42)
							)
							(else
								(proc10_13 0 gEgo Father -1 1 330 43)
								(proc10_13 0 Father gEgo -1 1 330 44)
							)
						)
					)
					(2
						(switch (gEgo selection:)
							(0
								(proc10_13 0 gEgo Beast -1 1 330 45)
								(proc10_13 0 Beast gEgo -1 1 330 46)
							)
							(1
								(proc10_13 3 gEgo Beast -1 1 330 47)
								(proc10_13 1 Beast gEgo -1 1 330 48)
								(proc10_13 0 gEgo Beast -1 1 330 49)
								(proc10_13 3 Beast gEgo -1 0 330 50)
								(proc10_13 3 Beast gEgo -1 1 330 51)
							)
							(2
								(proc10_13 0 gEgo Beast -1 1 330 52)
								(proc10_13 0 Beast gEgo -1 0 330 53)
								(proc10_13 0 Beast gEgo -1 0 330 54)
								(proc10_13 0 Beast gEgo -1 1 330 55)
							)
							(else
								(proc10_13 0 gEgo Beast -1 1 330 56)
								(proc10_13 0 Beast gEgo -1 1 330 57)
								(proc10_13 0 gEgo Beast -1 1 330 58)
								(proc10_13
									0
									Beast
									Beast
									-1
									1
									(Format @local34 330 59 @global110) ; "Farewell, my friend %s."
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

(instance Father of Tactor
	(properties
		description {Beauty's Father}
		lookStr {It is Beauty's Father!}
		view 700
		talkerID 13
	)

	(method (setUp)
		((= talkerObj fatherTalkObj) setUp: fatherBust fatherEyes fatherMouth)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Do
				(switch (gBeautyStory state:)
					(1
						(switch (self selection:)
							(0
								(proc10_13 2 self gEgo -1 1 330 60)
							)
							(1
								(proc10_13 3 self gEgo -1 0 330 61)
								(proc10_13 3 self gEgo -1 1 330 62)
							)
							(2
								(proc10_13 3 self gEgo -1 1 330 63)
							)
							(else
								(proc10_13 0 self gEgo -1 1 330 44)
							)
						)
					)
				)
				(Father incSel:)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fatherTalkObj of TalkerObj
	(properties
		x -1
		y 97
		nsTop 10
		nsLeft 108
		view 701
	)
)

(instance fatherBust of View
	(properties
		nsTop 19
		nsLeft 37
		view 701
		loop 6
	)
)

(instance fatherEyes of Prop
	(properties
		nsTop 27
		nsLeft 39
		view 701
		loop 4
		cycleSpeed 36
	)
)

(instance fatherMouth of Prop
	(properties
		nsTop 34
		nsLeft 35
		view 701
		loop 2
		cycleSpeed 12
	)
)

(instance Beast of Tactor
	(properties
		description {Beast}
		lookStr {It is the Beast!}
		view 941
		talkerID 14
	)

	(method (setUp)
		((= talkerObj beastTalkObj) setUp: beastBust beastEyes beastMouth)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Do
				(switch (gBeautyStory state:)
					(2
						(switch (self selection:)
							(0
								(proc10_13 3 self gEgo -1 1 330 64)
							)
							(1
								(proc10_13 1 self gEgo -1 1 330 65)
							)
							(2
								(proc10_13 0 self gEgo -1 1 330 66)
							)
							(else
								(proc10_13 0 self gEgo -1 0 330 67)
								(proc10_13 0 self gEgo -1 1 330 68)
							)
						)
					)
				)
				(Beast incSel:)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
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

(instance fatherHead of Prop
	(properties
		x 150
		y 142
		z 40
		view 700
		loop 1
	)
)

(instance fatherLegs of Prop
	(properties
		x 150
		y 138
		view 700
		loop 3
	)
)

(instance squirrel of Prop
	(properties
		x 143
		y 152
		description {Squirrel}
		onMeCheck -32768
		lookStr {It is a pretty squirrel.}
		view 330
		loop 1
	)
)

(instance gateR of Prop
	(properties
		x 249
		y 135
		description {Gate}
		lookStr {The gate to the wall has spikes on it.}
		view 330
	)
)

(instance tree of Feature
	(properties
		x 36
		y 57
		description {Tree}
		sightAngle 90
		onMeCheck 2
		lookStr {A tall oak tree grows here.}
	)
)

(instance log of Feature
	(properties
		x 148
		y 151
		description {Log}
		sightAngle 90
		onMeCheck 4
		lookStr {This is the log from a fallen tree.}
	)
)

(instance rock of Feature
	(properties
		x 60
		y 130
		description {Rock}
		sightAngle 90
		onMeCheck 8
		lookStr {This rock has small holes in it.}
	)
)

(instance wall of Feature
	(properties
		x 120
		y 95
		description {Wall}
		sightAngle 90
		onMeCheck 16
		lookStr {The wall is made from stone and has spikes on the top.}
	)
)

(instance gateL of Feature
	(properties
		x 245
		y 136
		sightAngle 90
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(gateR doVerb: theVerb)
	)
)

(instance statue of Feature
	(properties
		x 160
		y 56
		description {Statue}
		sightAngle 90
		onMeCheck -32768
		lookStr {This is the stone statue of a large cat with wings.}
	)
)

(instance road of Feature
	(properties
		x 140
		y 160
		description {Road}
		sightAngle 90
		onMeCheck 128
		lookStr {The road goes west from here.}
	)
)

(instance grass of Feature
	(properties
		x 224
		y 160
		description {Grass}
		sightAngle 90
		onMeCheck 256
		lookStr {The grass grows tall.}
	)
)

(instance sky of Feature
	(properties
		x 204
		y 54
		description {Sky}
		sightAngle 90
		onMeCheck 512
		lookStr {The sky is bright}
	)
)

(instance hole of Feature
	(properties
		x 120
		y 140
		description {Hole}
		sightAngle 90
		onMeCheck 64
		lookStr {A squirrel lives in this hole.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(cond
					((squirrel script:) 0)
					(
						(and
							(OneOf (gBeautyStory state:) 1 2)
							(not (gBeautyStory done:))
							(not (localproc_1))
						)
						0
					)
					((not (proc10_17 InvFriend))
						(squirrel setScript: squirRun)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

