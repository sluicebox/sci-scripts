;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2082)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	CPBangkok3 0
)

(instance CPBangkok3 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(2000 ; cplains
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 2000) ; cplains
			(= exitStyle 13)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 3987
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(pod_0 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 3988
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 2000 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(sea_90 init:)
		(lights_90 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 3989
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(loc2Exit init:)
		(gCurRoom exitN: loc2Exit)
		(super init: &rest)
		(hubsite_180 init:)
		(rings_180 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 3990
		heading 315
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(bangkok_315 init:)
		(sea_315 init:)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance loc2Exit of ExitFeature
	(properties
		nsLeft 393
		nsTop 143
		nsRight 526
		nsBottom 206
		nextRoom 2081
	)
)

(instance pod_0 of Feature
	(properties
		noun 4
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 0 591 0 590 95 526 185 460 249 419 284 286 290 156 278 88 241 28 191 -1 158
					yourself:
				)
		)
	)
)

(instance sea_90 of Feature
	(properties
		noun 6
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -1 -2 129 -2 118 23 95 46 62 66 31 33 -1 17
					yourself:
				)
		)
	)
)

(instance lights_90 of Feature
	(properties
		noun 3
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 107 112 438 117 393 130 119 128
					yourself:
				)
		)
	)
)

(instance hubsite_180 of Feature
	(properties
		noun 10
		nsLeft 256
		nsTop -1
		nsRight 340
		nsBottom 59
		x 298
		y 29
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance bangkok_315 of Feature
	(properties
		noun 1
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 78 132 103 121 174 114 174 96 185 83 198 80 195 0 198 0 203 22 224 19 233 28 232 105 247 111 268 51 280 43 260 4 264 -1 383 -1 387 4 366 41 371 44 387 75 389 15 395 4 403 6 405 70 411 74 418 0 423 -1 423 32 432 29 438 32 440 79 449 86 461 4 465 4 461 88 473 90 484 99 485 111 560 121 579 130 582 184 565 194 480 201 334 201 187 201 100 194 78 185
					yourself:
				)
		)
	)
)

(instance sea_315 of Feature
	(properties
		noun 6
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 461 -2 591 -1 592 86 540 72 492 45 473 23
					yourself:
				)
		)
	)
)

(instance rings_180 of Feature
	(properties
		noun 9
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 38 132 60 134 67 149 54 156 55 193 52 198 36 196 28 173 29 153
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 99 133 121 133 124 162 117 172 117 189 112 203 100 203 93 184 92 152
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 157 133 176 133 176 200 156 201
					yourself:
				)
		)
	)
)

