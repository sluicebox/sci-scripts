;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 56)
(include sci.sh)
(use Main)
(use rgClouds)
(use NewFeature)
(use User)

(public
	rm56 0
)

(instance rm56 of cloudRoom
	(properties
		picture 56
		east 57
		west 72
	)

	(method (init)
		(super init:)
		(proc610_1
			0
			0
			0
			0
			315
			(proc0_17 178 (gEgo y:) 60)
			3
			(proc0_17 178 (gEgo y:) 128)
			309
		)
		(gEgo init:)
		(proc0_1)
		(cloud1 init:)
		(cloud2 init:)
		(cloud3 init:)
		(cloud4 init:)
		(cloud5 init:)
		(cloud6 init:)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			(
				(= temp0
					(switch ((User alterEgo:) edgeHit:)
						(1 north)
						(2 east)
						(3 south)
						(4
							(if (IsFlag 110) west else 82)
						)
					)
				)
				(self newRoom: temp0)
			)
		)
	)
)

(instance cloud1 of NewFeature
	(properties
		x 160
		y 179
		noun '/cloud'
		nsTop 170
		nsBottom 189
		nsRight 320
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Thick, puffy clouds can be found everywhere you look up here, as you might expect!}
	)
)

(instance cloud2 of NewFeature
	(properties
		x 100
		y 137
		noun '/cloud'
		nsTop 104
		nsBottom 170
		nsRight 200
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Thick, puffy clouds can be found everywhere you look up here, as you might expect!}
	)
)

(instance cloud3 of NewFeature
	(properties
		x 117
		y 81
		noun '/cloud'
		nsTop 58
		nsLeft 7
		nsBottom 104
		nsRight 228
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Thick, puffy clouds can be found everywhere you look up here, as you might expect!}
	)
)

(instance cloud4 of NewFeature
	(properties
		x 175
		y 48
		noun '/cloud'
		nsTop 34
		nsLeft 30
		nsBottom 63
		nsRight 320
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Thick, puffy clouds can be found everywhere you look up here, as you might expect!}
	)
)

(instance cloud5 of NewFeature
	(properties
		x 214
		y 28
		noun '/cloud'
		nsTop 22
		nsLeft 108
		nsBottom 34
		nsRight 320
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Thick, puffy clouds can be found everywhere you look up here, as you might expect!}
	)
)

(instance cloud6 of NewFeature
	(properties
		x 247
		y 5
		noun '/cloud'
		nsTop -1
		nsLeft 203
		nsBottom 12
		nsRight 291
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Thick, puffy clouds can be found everywhere you look up here, as you might expect!}
	)
)

