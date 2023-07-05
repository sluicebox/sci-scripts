;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use Motion)
(use Game)
(use User)
(use Actor)

(public
	rm7 0
)

(local
	local0
	[local1 2]
	[local3 2] = [29 40]
	[local5 2] = [40 84]
)

(instance rm7 of Rm
	(properties
		picture 7
		horizon 65
		north 10
		east 6
		south 42
		west 8
	)

	(method (init)
		(Load rsVIEW 207)
		(self
			style:
				(switch gPrevRoomNum
					(north 5)
					(west 3)
					(east 2)
					(south 4)
				)
		)
		(super init:)
		(switch gPrevRoomNum
			(north
				(gEgo posn: (proc0_17 310 (gEgo x:) 194) 75)
			)
			(south
				(gEgo posn: 168 187)
			)
			(west
				(switch global130
					(0
						(if (< (gEgo y:) 95)
							(gEgo posn: 6 73)
						else
							(proc0_18 147 (gEgo y:) 72)
							(gEgo x: 4)
						)
					)
					(4
						(gEgo y: 100)
						(gEgo x: 4)
					)
				)
				(proc0_17 198 (gEgo y:) (+ horizon 4))
			)
			(east
				(gEgo
					posn: 314 (proc0_17 187 (proc0_18 143 (gEgo y:) 118) 67)
				)
			)
			(else
				(gEgo posn: 314 157)
			)
		)
		(gEgo init:)
		(if (not global130)
			(proc0_1)
		)
		(self setRegions: 603) ; waterReg
		(for
			((= local0 0))
			(< local0 (if (>= global101 1) 2 else 1))
			((++ local0))
			
			((= [local1 local0] (Clone Ripple))
				view: 207
				cycleSpeed: 1
				setPri: 0
				x: [local3 local0]
				y: [local5 local0]
				setLoop: local0
				ignoreActors: 1
				description: {waterfall}
				init:
				stopUpd:
			)
			(if (>= global101 1)
				([local1 local0] setCycle: Fwd)
			)
		)
		(waterfall1 init:)
		(waterfall init:)
		(smalltree1 init:)
		(smalltree2 init:)
		(lake1 init:)
		(lake2 init:)
		(tree1 init:)
		(tree2 init:)
		(tree3 init:)
		(bush init:)
		(rock1 init:)
		(rock2 init:)
		(rock3 init:)
		(rock4 init:)
		(rock5 init:)
	)

	(method (doit &tmp temp0)
		(cond
			((and script (not global130))
				(script doit:)
			)
			(
				(= temp0
					(switch ((User alterEgo:) edgeHit:)
						(1 north)
						(2 east)
						(3 south)
						(4 west)
					)
				)
				(self newRoom: temp0)
			)
			((and script global130)
				(script doit:)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((and (Said 'look,look>') (Said '[<at,around][/room,ceder]'))
				(Print 7 0) ; "A small, pleasant waterfall pours into a crystal clear lake."
			)
		)
	)
)

(instance tree1 of NewFeature
	(properties
		x 257
		y 11
		noun '/ceder'
		nsLeft 195
		nsBottom 23
		nsRight 320
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {A majestic old tree stands nearby.}
	)
)

(instance tree2 of NewFeature
	(properties
		x 270
		y 34
		noun '/ceder'
		nsTop 23
		nsLeft 221
		nsBottom 45
		nsRight 319
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {A majestic old tree stands nearby.}
	)
)

(instance tree3 of NewFeature
	(properties
		x 282
		y 90
		noun '/ceder'
		nsTop 46
		nsLeft 268
		nsBottom 135
		nsRight 297
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {A majestic old tree stands nearby.}
	)
)

(instance waterfall1 of NewFeature
	(properties
		x 44
		y 22
		noun '/waterfall'
		nsTop 3
		nsLeft 16
		nsBottom 41
		nsRight 73
		description {waterfall}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {A small spring bubbles up from the rocks here and splashes into the lake.}
	)
)

(instance waterfall of NewFeature
	(properties
		x 58
		y 59
		noun '/waterfall'
		nsTop 41
		nsLeft 25
		nsBottom 77
		nsRight 91
		description {waterfall}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {A small spring bubbles up from the rocks here and splashes into the lake.}
	)
)

(instance lake1 of NewFeature
	(properties
		x 47
		y 95
		noun '/lake,lake,water'
		nsTop 79
		nsBottom 111
		nsRight 95
		description {lake}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {This is a beautiful little lake.}
	)
)

(instance lake2 of NewFeature
	(properties
		x 32
		y 126
		noun '/lake,lake,water'
		nsTop 113
		nsBottom 139
		nsRight 65
		description {lake}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {This is a beautiful little lake.}
	)
)

(instance smalltree1 of NewFeature
	(properties
		x 52
		y 137
		noun '/ceder<little'
		nsTop 122
		nsLeft 36
		nsBottom 152
		nsRight 69
		description {small tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {This is just one of the many small trees adorning Daventry's countryside.}
	)
)

(instance smalltree2 of NewFeature
	(properties
		x 83
		y 147
		noun '/ceder<little'
		nsTop 135
		nsLeft 69
		nsBottom 159
		nsRight 97
		description {small tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {This is just one of the many small trees adorning Daventry's countryside.}
	)
)

(instance Ripple of Prop
	(properties)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((Said 'look,look/waterfall')
				(Print 7 1) ; "A small spring bubbles up from the rocks here and splashes into the lake."
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 7 1) ; "A small spring bubbles up from the rocks here and splashes into the lake."
			)
		)
	)
)

(instance bush of NewFeature
	(properties
		x 258
		y 180
		noun '/bush'
		nsTop 172
		nsLeft 196
		nsBottom 189
		nsRight 320
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {Pleasant little bushes grow around the spring-fed lake.}
	)
)

(instance rock1 of NewFeature
	(properties
		x 59
		y 36
		noun '/boulder'
		nsTop 8
		nsBottom 64
		nsRight 119
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {These rocks must lead to some sort of underground spring.  You remind yourself to explore their nooks and crannies sometime...when you don't have so much work to do!}
	)
)

(instance rock2 of NewFeature
	(properties
		x 148
		y 43
		noun '/boulder'
		nsTop 23
		nsLeft 119
		nsBottom 64
		nsRight 178
		description {rock2}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {These rocks must lead to some sort of underground spring.  You remind yourself to explore their nooks and crannies sometime...when you don't have so much work to do!}
	)
)

(instance rock3 of NewFeature
	(properties
		x 92
		y 121
		noun '/boulder'
		nsTop 113
		nsLeft 67
		nsBottom 129
		nsRight 118
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {These rocks must lead to some sort of underground spring.  You remind yourself to explore their nooks and crannies sometime...when you don't have so much work to do!}
	)
)

(instance rock4 of NewFeature
	(properties
		x 110
		y 74
		noun '/boulder'
		nsTop 65
		nsLeft 93
		nsBottom 83
		nsRight 128
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {These rocks must lead to some sort of underground spring.  You remind yourself to explore their nooks and crannies sometime...when you don't have so much work to do!}
	)
)

(instance rock5 of NewFeature
	(properties
		x 141
		y 96
		noun '/boulder'
		nsTop 92
		nsLeft 124
		nsBottom 101
		nsRight 158
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		lookStr {These rocks must lead to some sort of underground spring.  You remind yourself to explore their nooks and crannies sometime...when you don't have so much work to do!}
	)
)

