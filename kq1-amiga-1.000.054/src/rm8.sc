;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use LoadMany)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm8 0
)

(instance rm8 of Rm
	(properties
		picture 8
		horizon 54
		north 9
		east 7
		south 41
		west 83
	)

	(method (init)
		(if (>= global101 1)
			(LoadMany rsVIEW 302 700)
		)
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
				(gEgo posn: 204 (+ horizon 4))
			)
			(south
				(gEgo posn: (proc0_17 315 (gEgo x:) 33) 186)
			)
			(west
				(gEgo posn: 37 (proc0_17 195 (gEgo y:) 96))
			)
			(east
				(if (and (== global130 0) (< (gEgo y:) 90))
					(gEgo y: 60)
				else
					(gEgo y: (proc0_17 198 (gEgo y:) 86))
				)
				(gEgo x: 317)
			)
			(else
				(gEgo posn: 3 137)
			)
		)
		(gEgo init:)
		(if (not global130)
			(proc0_1)
		)
		(self setRegions: 603) ; waterReg
		(bigtree1 init:)
		(bigtree2 init:)
		(smalltree1 init:)
		(lake1 init:)
		(lake2 init:)
		(lake3 init:)
		(underbrush init:)
		(bush init:)
		(rock1 init:)
		(rock2 init:)
		(rock3 init:)
		(rock4 init:)
		(rock5 init:)
		(if (>= global101 1)
			(fish init:)
			(ripple init: cycleSpeed: global101 setCycle: Fwd)
		)
	)

	(method (doit &tmp temp0)
		(cond
			((and script (not global130))
				(script doit:)
			)
			(
				(= temp0
					(switch ((User alterEgo:) edgeHit:)
						(EDGE_TOP north)
						(EDGE_RIGHT east)
						(EDGE_BOTTOM south)
						(EDGE_LEFT west)
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
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/room]')
						(Print 8 0) ; "This is a peaceful little lake, fed by a nearby waterfall."
					)
					((Said '/waterfall')
						(Print 8 1) ; "Flowing into this peaceful lake is a small waterfall."
					)
					((Said '/blossom')
						(Print 8 2) ; "The flowers are very beautiful."
					)
				)
			)
		)
	)
)

(instance ripple of Prop
	(properties
		x 185
		y 122
		view 700
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 8 3) ; "The sunlight glistens on the rippling water."
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
			((Said 'look,look/ripple')
				(self doVerb: 1)
			)
		)
	)
)

(instance fishJump of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fish
					posn: (Random 145 275) (Random 100 135)
					loop: (Random 0 1)
					setCycle: End self
				)
			)
			(1
				(fish stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance fish of Prop
	(properties
		view 302
	)

	(method (init)
		(self cycleSpeed: (if (>= global101 1) 1 else 0) ignoreActors: stopUpd:)
		(super init:)
	)

	(method (doit)
		(super doit:)
		(if (and (< (Random 1 100) 3) (not (fish script:)) (not global130))
			(fish setScript: fishJump)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (fish script:)
					(Print 8 4) ; "The fish are certainly getting their exercise today."
				else
					(Print 8 5) ; "There is no fish here to look at!"
				)
			)
			(7
				(Print 8 6) ; "You won't be needing any fish on your quest."
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
			((Said 'look,look/fish')
				(self doVerb: 1)
			)
			((Said 'get,get,capture/fish')
				(self doVerb: 7)
			)
		)
	)
)

(instance bigtree1 of NewFeature
	(properties
		x 101
		y 14
		noun '/ceder[<big]'
		nsLeft 2
		nsBottom 29
		nsRight 170
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {Graceful willows adorn the lake.}
	)
)

(instance bigtree2 of NewFeature
	(properties
		x 110
		y 43
		noun '/ceder[<big]'
		nsTop 29
		nsLeft 33
		nsBottom 58
		nsRight 170
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {Graceful willows adorn the lake.}
	)
)

(instance smalltree1 of NewFeature
	(properties
		x 274
		y 31
		noun '/ceder<little'
		nsTop 1
		nsLeft 240
		nsBottom 55
		nsRight 289
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {A small, ordinary tree juts up from between the rocks.}
	)
)

(instance lake1 of NewFeature
	(properties
		x 222
		y 108
		noun '/lake,lake,water'
		nsTop 73
		nsLeft 125
		nsBottom 143
		nsRight 319
		description {lake}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {This is a beautiful little lake.}
	)
)

(instance lake2 of NewFeature
	(properties
		x 109
		y 114
		noun '/lake,lake,water'
		nsTop 89
		nsLeft 94
		nsBottom 140
		nsRight 124
		description {lake}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {This is a beautiful little lake.}
	)
)

(instance lake3 of NewFeature
	(properties
		x 86
		y 111
		noun '/lake,lake,water'
		nsTop 101
		nsLeft 79
		nsBottom 122
		nsRight 94
		description {lake}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {This is a beautiful little lake.}
	)
)

(instance underbrush of NewFeature
	(properties
		x 88
		y 68
		noun '/underbrush,bury'
		nsTop 45
		nsBottom 91
		nsRight 176
		description {underbrush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {The underbrush around the trees is home to many small furry creatures, none of which concern you at the moment.}
	)
)

(instance bush of NewFeature
	(properties
		x 106
		y 151
		noun '/bush'
		nsTop 142
		nsLeft 79
		nsBottom 161
		nsRight 134
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {Small bushes thrive by the clear little lake.}
	)
)

(instance rock1 of NewFeature
	(properties
		x 291
		y 79
		noun '/boulder'
		nsTop 76
		nsLeft 262
		nsBottom 83
		nsRight 320
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {These rocks must lead to some sort of underground spring.__You remind yourself to explore their nooks and crannies sometime...when you don't have so much work to do!}
	)
)

(instance rock2 of NewFeature
	(properties
		x 277
		y 64
		noun '/boulder'
		nsTop 52
		nsLeft 234
		nsBottom 76
		nsRight 320
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {These rocks must lead to some sort of underground spring.__You remind yourself to explore their nooks and crannies sometime...when you don't have so much work to do!}
	)
)

(instance rock3 of NewFeature
	(properties
		x 281
		y 47
		noun '/boulder'
		nsTop 42
		nsLeft 243
		nsBottom 52
		nsRight 319
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {These rocks must lead to some sort of underground spring.__You remind yourself to explore their nooks and crannies sometime...when you don't have so much work to do!}
	)
)

(instance rock4 of NewFeature
	(properties
		x 311
		y 30
		noun '/boulder'
		nsTop 16
		nsLeft 303
		nsBottom 45
		nsRight 320
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {These rocks must lead to some sort of underground spring.__You remind yourself to explore their nooks and crannies sometime...when you don't have so much work to do!}
	)
)

(instance rock5 of NewFeature
	(properties
		x 285
		y 36
		noun '/boulder'
		nsTop 30
		nsLeft 280
		nsBottom 42
		nsRight 291
		description {rock}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {These rocks must lead to some sort of underground spring.__You remind yourself to explore their nooks and crannies sometime...when you don't have so much work to do!}
	)
)

