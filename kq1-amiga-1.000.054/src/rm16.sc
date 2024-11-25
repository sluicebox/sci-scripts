;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use Game)
(use User)

(public
	rm16 0
)

(instance rm16 of Rm
	(properties
		picture 16
		horizon 51
		north 17
		east 9
		south 83
		west 15
	)

	(method (init)
		(self
			style:
				(switch gPrevRoomNum
					(north 5)
					(west 41)
					(east 2)
					(south 4)
				)
		)
		(super init:)
		(switch gPrevRoomNum
			(north
				(gEgo posn: (proc0_17 168 (gEgo x:) 93) (+ horizon 2))
			)
			(south
				(gEgo posn: 163 188)
			)
			(west
				(gEgo posn: 3 (proc0_17 113 (gEgo y:) (+ 2 horizon)))
			)
			(else
				(gEgo posn: 317 (proc0_17 152 (gEgo y:) (+ 2 horizon)))
			)
		)
		(tree1 init:)
		(tree init:)
		(tree2 init:)
		(tree3 init:)
		(flowers init:)
		(bush init:)
		(bush1 init:)
		(proc0_1)
		(gEgo init: illegalBits: $8400)
		(if (IsFlag 2)
			(gGoat illegalBits: $4406)
		)
		(self setRegions: 604) ; gardenReg
	)

	(method (doit &tmp temp0)
		(if
			(= temp0
				(switch ((User alterEgo:) edgeHit:)
					(EDGE_TOP north)
					(EDGE_RIGHT east)
					(EDGE_BOTTOM south)
					(EDGE_LEFT west)
				)
			)
			(gEgo illegalBits: $8000)
			(if (IsFlag 2)
				(gGoat illegalBits: $4000)
			)
			(self newRoom: temp0)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event))
			(
				(or
					(Said 'look,look/castle')
					(proc0_14 event 0 171 318 188)
					(proc0_14 event 284 154 316 170)
					(proc0_14 event 206 155 239 170)
					(proc0_14 event 126 156 160 171)
					(proc0_14 event 53 156 84 171)
					(proc0_14 event 0 157 15 172)
				)
				(SetFlag 49)
				(event claimed: 1)
				(Print 16 0) ; "From here, you can see the battlements of King Edward's castle overlooking the garden."
			)
		)
	)
)

(instance tree of NewFeature
	(properties
		x 63
		y 8
		noun '/ceder'
		nsTop -1
		nsBottom 18
		nsRight 127
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Lovely trees grow near the carrot patch.}
	)
)

(instance tree1 of NewFeature
	(properties
		x 32
		y 27
		noun '/ceder'
		nsTop 18
		nsBottom 37
		nsRight 64
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Lovely trees grow near the carrot patch.}
	)
)

(instance tree2 of NewFeature
	(properties
		x 222
		y 19
		noun '/ceder'
		nsTop -1
		nsLeft 171
		nsBottom 39
		nsRight 274
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Lovely trees grow near the carrot patch.}
	)
)

(instance tree3 of NewFeature
	(properties
		x 289
		y 96
		noun '/ceder'
		nsTop 76
		nsLeft 261
		nsBottom 116
		nsRight 318
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Lovely trees grow near the carrot patch.}
	)
)

(instance flowers of NewFeature
	(properties
		x 228
		y 80
		noun '/blossom'
		nsTop 76
		nsLeft 217
		nsBottom 85
		nsRight 240
		description {flower}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {A patch of pretty flowers has been planted near the garden, just for decoration.}
	)
)

(instance bush of NewFeature
	(properties
		x 39
		y 47
		noun '/bush'
		nsTop 37
		nsBottom 57
		nsRight 79
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {A copse of low bushes grows beneath the shade trees.}
	)
)

(instance bush1 of NewFeature
	(properties
		x 240
		y 47
		noun '/bush'
		nsTop 39
		nsLeft 179
		nsBottom 55
		nsRight 301
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {A copse of low bushes grows beneath the shade trees.}
	)
)

