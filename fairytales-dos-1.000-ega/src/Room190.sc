;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 190)
(include sci.sh)
(use Main)
(use n010)
(use goGet)
(use Interface)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use Motion)
(use Actor)

(public
	Room190 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(procedure (localproc_0)
	(wall init:)
	(tree init:)
	(rock init:)
	(road init:)
	(bush init:)
	(mountain init:)
	(oldTree init:)
	(grass init:)
)

(instance Room190 of FRoom
	(properties
		lookStr {It feels nice to walk on the grass.}
		picture 190
		style 0
		horizon 52
		north 140
		east 200
		south 240
		west 180
		invX 90
		invY 112
		northX 132
		northY 56
		southX 180
		southY 170
		eastX 330
		eastY 83
		westY 65
	)

	(method (init)
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
					init: 0 -25 319 -26 319 65 182 66 155 59 159 47 115 46 103 56 77 52 0 56
					yourself:
				)
				((Polygon new:) type: PBarredAccess init: 45 88 45 78 68 78 67 91 yourself:)
				((Polygon new:) type: PBarredAccess init: 9 75 33 76 33 87 8 84 yourself:)
				((Polygon new:)
					type: PBarredAccess
					init: 0 112 74 112 79 134 84 144 119 144 129 173 0 173
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 193 173 205 149 261 147 262 128 221 133 206 127 199 124 182 123 173 120 155 120 155 93 319 91 319 173 194 173
					yourself:
				)
		)
		(lizzRock setPri: 8 ignoreActors: 1 init:)
		(localproc_0)
		(if
			(and
				(== global145 5)
				(or (== global144 gJackStory) (== global144 gBremenStory))
			)
			(= global140 2)
			(= local5 2)
			(self setRegions: 400) ; endGame
		)
	)

	(method (cue)
		(super cue:)
		(if (== local5 2)
			(self setScript: (ScriptID 400 1)) ; wyrmScript
		else
			(switch (gBremenStory state:)
				(8
					(= local2 ((gInventory at: 5) regActor:))
					(= local3 ((gInventory at: 7) regActor:))
					(= local4 ((gInventory at: 4) regActor:))
					(= local1 ((gInventory at: 6) regActor:))
					(gCurRoom setScript: enterWithBrems)
				)
			)
		)
	)

	(method (dispose)
		(if (== (gBremenStory state:) 8)
			(local3 setPri: -1)
		)
		(super dispose:)
	)
)

(instance enterWithBrems of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveFwd 60)
				(= cycles 1)
			)
			(1
				(local3
					view: 651
					setPri: 4
					normal: 0
					posn: (gCurRoom westX:) (gCurRoom westY:)
					init:
					ignoreActors: 1
					setCycle: Walk
					setMotion: NPFollow gEgo 40
				)
				(= cycles 1)
			)
			(2
				(gEgo setMotion: PolyPath 156 88 self)
			)
			(3
				(Face gEgo local3)
				(proc10_13 0 local4 gEgo self 1 190 0)
			)
			(4
				(proc10_13 0 local2 gEgo self 1 190 1)
			)
			(5
				(proc10_13 0 local1 gEgo -1 0 190 2)
				(proc10_13 0 local1 gEgo self 1 190 3)
			)
			(6
				(proc10_13 0 local3 gEgo self 1 190 4)
			)
			(7
				(proc10_13 0 gEgo local4 self 1 190 5)
			)
			(8
				(proc10_13 3 local4 gEgo self 1 190 6)
			)
			(9
				(proc10_13 3 local2 gEgo self 1 190 7)
			)
			(10
				(proc10_13 3 local1 gEgo self 1 190 8)
			)
			(11
				(proc10_13 2 local3 gEgo self 1 190 9)
			)
			(12
				(proc10_13 0 gEgo local2 self 1 190 10)
			)
			(13
				(proc10_13 3 local3 gEgo self 1 190 11)
			)
			(14
				(proc10_13 3 local1 gEgo self 1 190 12)
			)
			(15
				(proc10_13 3 local2 gEgo self 1 190 13)
			)
			(16
				(proc10_13 3 local4 gEgo self 1 190 14)
			)
			(17
				(gEgo setMotion: PolyPath 319 77 self)
			)
			(18
				(self dispose:)
			)
		)
	)
)

(instance moveLizzard of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 190 15 #time 5 #at -1 160 #dispose) ; "You see a newt."
				(cond
					((and (< 122 (gEgo x:) 268) (< 125 (gEgo y:) 130))
						(gEgo
							setMotion:
								PolyPath
								(gEgo x:)
								(- (gEgo y:) 10)
								self
						)
					)
					((and (< 122 (gEgo x:) 268) (< 129 (gEgo y:) 140))
						(gEgo
							setMotion:
								PolyPath
								(gEgo x:)
								(+ (gEgo y:) 12)
								self
						)
					)
					(else
						(= ticks 1)
					)
				)
			)
			(1
				(Face gEgo lizzRock)
				(lizzRock setCycle: CT 6 1 self)
			)
			(2
				(lizzard
					setCycle: Fwd
					posn: 154 132
					setLoop: 1
					cel: 0
					cycleSpeed: 2
					moveSpeed: 2
					init:
					setMotion: MoveTo 268 137 self
				)
				(lizzRock cel: 7)
			)
			(3
				(lizzard dispose:)
				(self dispose:)
			)
		)
	)
)

(instance lizzard of Actor
	(properties
		view 190
		signal 16384
	)
)

(instance lizzRock of Prop
	(properties
		x 142
		y 130
		description {Rock}
		lookStr {This is the rock of a newt.}
		view 190
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (and (not (gCurRoom script:)) (not (proc10_17 InvFriend)))
					(gCurRoom setScript: moveLizzard)
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
		x 49
		y 49
		description {Wall}
		sightAngle 90
		onMeCheck 2
		lookStr {You can see the town's wall.}
	)
)

(instance tree of Feature
	(properties
		x 251
		y 86
		description {Tree}
		sightAngle 90
		onMeCheck 4
		lookStr {It is cooler under the tree.}
	)
)

(instance rock of Feature
	(properties
		x 199
		y 89
		description {Rock}
		sightAngle 90
		onMeCheck 8
		lookStr {Most of the rocks here are bigger than you.}
	)
)

(instance road of Feature
	(properties
		x 118
		y 96
		description {Road}
		sightAngle 90
		onMeCheck 16
		lookStr {The road goes east and west.}
	)
)

(instance bush of Feature
	(properties
		x 221
		y 160
		description {Bush}
		sightAngle 90
		onMeCheck 32
		lookStr {This bush smells like a wet dog.}
	)
)

(instance mountain of Feature
	(properties
		x 148
		y 49
		description {Mountain}
		sightAngle 90
		onMeCheck 64
		lookStr {The mountain is very far away.}
	)
)

(instance oldTree of Feature
	(properties
		x 278
		y 150
		description {Tree}
		sightAngle 90
		onMeCheck 128
		lookStr {This tree was so old that it fell over.}
	)
)

(instance grass of Feature
	(properties
		x 128
		y 120
		description {Grass}
		sightAngle 90
		onMeCheck 256
		lookStr {It feels nice to walk on the grass.}
	)
)

