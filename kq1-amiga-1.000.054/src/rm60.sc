;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 60)
(include sci.sh)
(use Main)
(use rgClouds)
(use NewFeature)

(public
	rm60 0
)

(instance rm60 of cloudRoom
	(properties
		picture 60
		horizon 103
		north 57
		east 61
	)

	(method (init)
		(super init:)
		(proc610_1
			(proc0_17 319 (proc0_18 229 (gEgo x:) 180) 60)
			(+ horizon 4)
			0
			0
			317
			(proc0_17 173 (gEgo y:) (+ horizon 2))
			0
			0
			308
		)
		(gEgo init:)
		(proc0_1)
		(cloud1 init:)
		(cloud2 init:)
		(cloud3 init:)
		(cloud4 init:)
		(tree1 init:)
		(tree2 init:)
	)
)

(instance tree1 of NewFeature
	(properties
		x 212
		y 114
		noun 'ceder'
		nsTop 70
		nsLeft 189
		nsBottom 158
		nsRight 236
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The colossal, weirdly-shaped trees loom far overhead.}
	)
)

(instance tree2 of NewFeature
	(properties
		x 159
		y 39
		noun 'ceder'
		nsTop -1
		nsBottom 79
		nsRight 318
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The colossal, weirdly-shaped trees loom far overhead.}
	)
)

(instance cloud1 of NewFeature
	(properties
		x 14
		y 115
		noun '/cloud'
		nsTop 41
		nsBottom 189
		nsRight 28
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The land trails off into the thick clouds here; though they look almost solid, you'd best be careful where you walk.}
	)
)

(instance cloud2 of NewFeature
	(properties
		x 49
		y 125
		noun '/cloud'
		nsTop 61
		nsLeft 28
		nsBottom 189
		nsRight 71
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The land trails off into the thick clouds here; though they look almost solid, you'd best be careful where you walk.}
	)
)

(instance cloud3 of NewFeature
	(properties
		x 92
		y 159
		noun '/cloud'
		nsTop 129
		nsLeft 72
		nsBottom 189
		nsRight 113
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The land trails off into the thick clouds here; though they look almost solid, you'd best be careful where you walk.}
	)
)

(instance cloud4 of NewFeature
	(properties
		x 216
		y 178
		noun '/cloud'
		nsTop 167
		nsLeft 113
		nsBottom 189
		nsRight 320
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The land trails off into the thick clouds here; though they look almost solid, you'd best be careful where you walk.}
	)
)

