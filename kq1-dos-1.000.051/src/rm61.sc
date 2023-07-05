;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 61)
(include sci.sh)
(use Main)
(use rgClouds)
(use NewFeature)

(public
	rm61 0
)

(instance rm61 of cloudRoom
	(properties
		picture 61
		horizon 100
		north 58
		east 62
		west 60
	)

	(method (init)
		(super init:)
		(proc610_1
			(proc0_18 153 (gEgo x:) 105)
			(+ horizon 4)
			0
			0
			317
			(proc0_17 134 (gEgo y:) (+ horizon 2))
			3
			(proc0_17 181 (gEgo y:) (+ horizon 2))
			297
		)
		(gEgo init:)
		(proc0_1)
		(tree1 init:)
		(tree2 init:)
		(tree3 init:)
		(cloud1 init:)
		(cloud2 init:)
	)
)

(instance tree1 of NewFeature
	(properties
		x 123
		y 131
		noun 'ceder'
		nsTop 90
		nsLeft 105
		nsBottom 172
		nsRight 142
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These gigantic, weirdly-shaped trees tower over you.}
	)
)

(instance tree2 of NewFeature
	(properties
		x 125
		y 44
		noun 'ceder'
		nsTop -1
		nsLeft 13
		nsBottom 89
		nsRight 238
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These gigantic, weirdly-shaped trees tower over you.}
	)
)

(instance tree3 of NewFeature
	(properties
		x 278
		y 38
		noun 'ceder'
		nsTop -1
		nsLeft 238
		nsBottom 78
		nsRight 318
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These gigantic, weirdly-shaped trees tower over you.}
	)
)

(instance cloud1 of NewFeature
	(properties
		x 160
		y 181
		noun '/cloud'
		nsTop 174
		nsBottom 189
		nsRight 320
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The clouds drift over the edge of the land here, making it impossible to see where the land ends!  Though the clouds look very thick, it would be unwise to venture too far out into them.}
	)
)

(instance cloud2 of NewFeature
	(properties
		x 279
		y 157
		noun '/cloud'
		nsTop 141
		nsLeft 239
		nsBottom 174
		nsRight 320
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {The clouds drift over the edge of the land here, making it impossible to see where the land ends!  Though the clouds look very thick, it would be unwise to venture too far out into them.}
	)
)

