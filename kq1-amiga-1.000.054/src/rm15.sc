;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use Game)
(use User)

(public
	rm15 0
)

(instance rm15 of Rm
	(properties
		picture 15
		horizon 51
		north 18
		east 16
		south 2
		west 14
	)

	(method (init)
		(self
			style:
				(switch gPrevRoomNum
					(north 5)
					(west 3)
					(east 40)
					(south 4)
				)
		)
		(super init:)
		(switch gPrevRoomNum
			(north
				(gEgo posn: (proc0_17 223 (gEgo x:) 153) (+ horizon 2))
			)
			(south
				(gEgo posn: 163 188)
			)
			(west
				(gEgo posn: 3 (proc0_17 148 (gEgo y:) (+ 2 horizon)))
			)
			(else
				(gEgo posn: 317 (proc0_17 113 (gEgo y:) (+ 2 horizon)))
			)
		)
		(bush init:)
		(bush1 init:)
		(bush2 init:)
		(bush3 init:)
		(tree init:)
		(tree1 init:)
		(tree2 init:)
		(tree3 init:)
		(flowers init:)
		(proc0_1)
		(gEgo init: illegalBits: -31744)
		(if (IsFlag 2)
			(gGoat illegalBits: 17414)
		)
		(self setRegions: 604) ; gardenReg
	)

	(method (doit &tmp temp0)
		(if
			(= temp0
				(switch ((User alterEgo:) edgeHit:)
					(1 north)
					(2 east)
					(3 south)
					(4 west)
				)
			)
			(gEgo illegalBits: -32768)
			(if (IsFlag 2)
				(gGoat illegalBits: 16384)
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
					(proc0_14 event 0 170 318 188)
					(proc0_14 event 304 157 320 174)
					(proc0_14 event 235 156 266 173)
					(proc0_14 event 159 156 193 172)
					(proc0_14 event 79 155 113 172)
					(proc0_14 event 4 154 36 171)
				)
				(SetFlag 49)
				(event claimed: 1)
				(Print 15 0) ; "From here, you can see the battlements of King Edward's castle overlooking the garden."
			)
		)
	)
)

(instance tree2 of NewFeature
	(properties
		x 60
		y 18
		noun '/ceder'
		nsTop -1
		nsBottom 38
		nsRight 120
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
		x 128
		y 4
		noun '/ceder'
		nsTop -1
		nsLeft 120
		nsBottom 9
		nsRight 136
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Lovely trees grow near the carrot patch.}
	)
)

(instance tree of NewFeature
	(properties
		x 15
		y 75
		noun '/ceder'
		nsTop 61
		nsBottom 89
		nsRight 30
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
		x 279
		y 24
		noun '/ceder'
		nsTop -1
		nsLeft 238
		nsBottom 50
		nsRight 320
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Lovely trees grow near the carrot patch.}
	)
)

(instance bush of NewFeature
	(properties
		x 79
		y 47
		noun '/bush'
		nsTop 40
		nsLeft 19
		nsBottom 54
		nsRight 139
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {A copse of low bushes grows beneath the shade trees.}
	)
)

(instance flowers of NewFeature
	(properties
		x 92
		y 80
		noun '/blossom'
		nsTop 75
		nsLeft 81
		nsBottom 85
		nsRight 104
		description {flower}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {A patch of pretty flowers has been planted near the garden, just for decoration.}
	)
)

(instance bush1 of NewFeature
	(properties
		x 281
		y 51
		noun '/bush'
		nsTop 46
		nsLeft 242
		nsBottom 57
		nsRight 320
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Some low, lush green bushes are growing at the base of the trees.}
	)
)

(instance bush2 of NewFeature
	(properties
		x 285
		y 43
		noun '/bush'
		nsTop 40
		nsLeft 251
		nsBottom 46
		nsRight 319
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Some low, lush green bushes are growing at the base of the trees.}
	)
)

(instance bush3 of NewFeature
	(properties
		x 297
		y 36
		noun '/bush'
		nsTop 33
		nsLeft 275
		nsBottom 40
		nsRight 320
		description {bush}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Some low, lush green bushes are growing at the base of the trees.}
	)
)

