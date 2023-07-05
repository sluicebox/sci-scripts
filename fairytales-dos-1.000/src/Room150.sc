;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 150)
(include sci.sh)
(use Main)
(use n010)
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
	Room150 0
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0)
	(tree init:)
	(log init:)
	(rock init:)
	(pond init:)
	(mountain init:)
	(sky init:)
	(grass init:)
	(apple1 init:)
	(fence init:)
	(pickApple init:)
)

(instance Room150 of FRoom
	(properties
		lookStr {Apple trees grow around here.}
		picture 150
		style 0
		south 200
		west 140
		invX 237
		invY 156
		southX 186
		southY 171
		westX 5
		westY 164
	)

	(method (init &tmp temp0)
		(if (> global225 0)
			(Load rsSOUND global225)
		)
		(LoadMany rsSOUND 110 111 113 123)
		(super init:)
		(proc10_29)
		(gTheIconBar enable: show:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 173 211 173 213 156 314 156 314 130 271 129 270 114 203 110 200 104 164 102 160 93 136 92 97 100 84 113 133 116 144 127 116 137 79 140 0 146
					yourself:
				)
		)
		(localproc_0)
		(= local0 (Random 15 50))
		(fish init: hide:)
		(apple setPri: 15 stopUpd: init:)
		(leftFall setCycle: Fwd init:)
		(waterfallS play:)
		(rightFall setCycle: Fwd init:)
		(waterMove ignoreActors: 1 setCycle: Fwd init:)
		(if (and (== global145 5) (== global144 gJackStory))
			(= global140 2)
			(= local3 2)
			(self setRegions: 400) ; endGame
		)
	)

	(method (cue)
		(super cue:)
		(if (== local3 2)
			(self setScript: (ScriptID 400 1)) ; wyrmScript
		)
	)

	(method (doit)
		(super doit:)
		(= local1 (GetTime 1)) ; SysTime12
		(if (!= local2 local1)
			(= local1 local2)
			(if (not (-- local0))
				(fish setScript: fishJump)
				(= local0 (Random 90 170))
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance fishJump of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fishS number: 111 play:)
				(fish show: setCycle: CT 6 1 self)
			)
			(1
				(fishS number: 110 play:)
				(fish setCycle: End self)
			)
			(2
				(fish hide:)
				(self dispose:)
			)
		)
	)
)

(instance egoGetWater of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 195 107 self)
			)
			(1
				(gEgo normal: 0)
				(= cycles 1)
			)
			(2
				(gEgo
					view: (+ 70 global139)
					setLoop: 1
					cel: 0
					setCycle: End self
				)
			)
			(3
				(Print 150 0) ; "You take a drink from the pond. The water tastes like grape soda."
				(gEgo normal: 1)
				(NormalEgo 5 global139)
				(self dispose:)
			)
		)
	)
)

(instance getApple of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 156 123 self)
			)
			(1
				(gEgo normal: 0)
				(= cycles 1)
			)
			(2
				(gEgo
					view: (+ 50 global139)
					setLoop: 0
					cel: 0
					setCycle: CT 3 1 self
				)
			)
			(3
				(pickAppleS play:)
				(apple dispose:)
				(gEgo setCycle: End self)
			)
			(4
				(Print 150 1) ; "You pick a ripe apple from the tree. It tastes crisp and sweet."
				(gEgo normal: 1)
				(NormalEgo 5 global139)
				(self dispose:)
			)
		)
	)
)

(instance pickApple of Feature
	(properties
		x 140
		y 66
		description {Tree}
		sightAngle 90
		onMeCheck 1024
		lookStr {The trees here have ripe apples.}
	)

	(method (doVerb theVerb invItem)
		(if
			(and
				(== theVerb 5) ; Do
				(gCast contains: apple)
				(not (gCurRoom script:))
			)
			(gCurRoom setScript: getApple)
		else
			(super doVerb: theVerb invItem &rest)
		)
	)
)

(instance apple1 of Feature
	(properties
		x 99
		y 69
		description {Apple}
		sightAngle 90
		onMeCheck 2
		lookStr {This is a bright red apple.}
	)

	(method (doVerb theVerb invItem)
		(pickApple doVerb: theVerb invItem)
	)
)

(instance tree of Feature
	(properties
		x 53
		y 77
		description {Tree}
		sightAngle 90
		onMeCheck 4
		lookStr {The trees here have ripe apples.}
	)
)

(instance log of Feature
	(properties
		x 14
		y 120
		description {Log}
		sightAngle 90
		onMeCheck 8
		lookStr {This log is from an old tree.}
	)
)

(instance rock of Feature
	(properties
		x 292
		y 70
		description {Rock}
		sightAngle 90
		onMeCheck 16
		lookStr {The rocks are large.}
	)
)

(instance pond of Feature
	(properties
		x 204
		y 108
		description {Pond}
		sightAngle 90
		onMeCheck 32
		lookStr {The water in the pond looks cool.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (gEgo script:))
					(gEgo setScript: egoGetWater)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fence of Feature
	(properties
		x 190
		y 80
		description {Fence}
		sightAngle 90
		onMeCheck 128
		lookStr {The fence is on the other side of the pond.}
	)
)

(instance mountain of Feature
	(properties
		x 279
		y 35
		description {Mountain}
		sightAngle 90
		onMeCheck 256
		lookStr {The mountains are far from here.}
	)
)

(instance sky of Feature
	(properties
		x 268
		y 35
		description {Sky}
		sightAngle 90
		onMeCheck 512
		lookStr {The sky is a lovely color.}
	)
)

(instance grass of Feature
	(properties
		x 169
		y 120
		description {Grass}
		sightAngle 90
		onMeCheck 2048
		lookStr {The grass is a lovely color.}
	)
)

(instance fish of Prop
	(properties
		x 220
		y 109
		z 15
		description {Fish}
		lookStr {The fish jumps in the pond.}
		view 150
		loop 1
		cel 3
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(Print 150 2) ; "The fish is too far away to catch."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance apple of Prop
	(properties
		x 147
		y 82
		description {Apple}
		lookStr {This is a bright red apple.}
		view 150
	)

	(method (doVerb theVerb invItem)
		(pickApple doVerb: theVerb invItem)
	)
)

(instance leftFall of Prop
	(properties
		x 273
		y 110
		description {Waterfall}
		sightAngle 90
		lookStr {The waterfall flows off the rocks.}
		view 150
		loop 2
	)
)

(instance rightFall of Prop
	(properties
		x 294
		y 66
		view 150
		loop 3
	)

	(method (doVerb theVerb)
		(leftFall doVerb: theVerb)
	)
)

(instance waterMove of Prop
	(properties
		x 246
		y 79
		view 150
		loop 4
	)

	(method (doVerb theVerb)
		(pond doVerb: theVerb)
	)
)

(instance fishS of Sound
	(properties
		flags 1
	)
)

(instance waterfallS of Sound
	(properties
		flags 1
		number 123
		loop -1
	)
)

(instance pickAppleS of Sound
	(properties
		flags 1
		number 157
	)
)

