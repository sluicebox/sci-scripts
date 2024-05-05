;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 57)
(include sci.sh)
(use Main)
(use rgClouds)
(use NewFeature)

(public
	rm57 0
)

(instance rm57 of cloudRoom
	(properties
		picture 57
		east 58
		south 60
		west 56
	)

	(method (init)
		(super init:)
		(proc610_1
			0
			0
			(proc0_17 268 (gEgo x:) 3)
			187
			313
			(proc0_17 188 (gEgo y:) 77)
			3
			(proc0_18 172 (proc0_17 189 (gEgo y:) 92) 135)
			298
		)
		(gEgo init:)
		(proc0_1)
		(tree1 init:)
		(tree2 init:)
		(tree3 init:)
		(tree4 init:)
		(tree5 init:)
		(cloud init:)
	)
)

(instance tree1 of NewFeature
	(properties
		x 159
		y 30
		noun 'ceder'
		nsBottom 61
		nsRight 319
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These weirdly-shaped trees tower over you.}
	)
)

(instance tree2 of NewFeature
	(properties
		x 98
		y 83
		noun 'ceder'
		nsTop 61
		nsLeft 82
		nsBottom 106
		nsRight 115
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These weirdly-shaped trees tower over you.}
	)
)

(instance tree3 of NewFeature
	(properties
		x 203
		y 102
		noun 'ceder'
		nsTop 61
		nsLeft 184
		nsBottom 143
		nsRight 222
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These weirdly-shaped trees tower over you.}
	)
)

(instance tree4 of NewFeature
	(properties
		x 38
		y 112
		noun 'ceder'
		nsTop 62
		nsLeft 9
		nsBottom 162
		nsRight 67
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These weirdly-shaped trees tower over you.}
	)
)

(instance tree5 of NewFeature
	(properties
		x 310
		y 124
		noun 'ceder'
		nsTop 61
		nsLeft 303
		nsBottom 188
		nsRight 318
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {These weirdly-shaped trees tower over you.}
	)
)

(instance cloud of NewFeature
	(properties
		x 160
		y 42
		noun '/cloud'
		nsTop 8
		nsBottom 77
		nsRight 320
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 369
		contClick 371
		lookStr {Clouds rim the land here.__Wispy towards the edges, they appear to grow thicker in the distance.}
	)
)

