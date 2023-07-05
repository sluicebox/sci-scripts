;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2081)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	CPBangkok2 0
)

(instance CPBangkok2 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(4000 ; bkPorch
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(2082 ; CPBangkok3
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 3982
		edgeN 0
		edgeS 0
	)

	(method (init)
		(locPorchExit init:)
		(loc3Exit init:)
		(if (IsFlag 34)
			(= picture 3992)
		else
			(= picture 3982)
		)
		(super init: &rest)
		(bangkok_0 init:)
		(door_0 init:)
		(pod_0 init:)
		(sea_0 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 3983
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(spikes_90 init:)
		(spikes_90 init:)
		(sea_90 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 3984
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 2080 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(hubSite_180 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 3985
		heading 315
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(sea_315 init:)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance locPorchExit of ExitFeature
	(properties
		nsLeft 153
		nsTop 100
		nsRight 316
		nsBottom 199
		nextRoom 4000
	)
)

(instance loc3Exit of ExitFeature
	(properties
		nsLeft 504
		nsTop 128
		nsRight 586
		nsBottom 191
		nextRoom 2082
	)
)

(instance bangkok_0 of Feature
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
					init: 1 108 76 103 98 67 98 3 111 0 122 31 134 28 138 1 152 1 161 36 175 52 197 36 177 1 312 0 290 39 314 54 329 40 331 7 342 6 347 37 357 35 363 2 369 1 367 73 374 73 382 13 387 13 383 77 403 109 451 115 500 128 506 195 454 199 326 203 144 202 1 199
					yourself:
				)
		)
	)
)

(instance door_0 of Feature
	(properties
		noun 2
		nsLeft 187
		nsTop 170
		nsRight 280
		nsBottom 209
		x 233
		y 189
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance pod_0 of Feature
	(properties
		noun 4
		nsLeft 527
		nsTop 153
		nsRight 578
		nsBottom 183
		x 552
		y 168
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance sea_0 of Feature
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
					init: 51 1 177 0 193 26 193 39 164 100 153 102 103 70 72 33
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 389 91 400 57 400 23 392 1 541 0 517 36 482 76 429 112
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
					init: 463 -2 593 -2 594 77 561 77 523 63 494 44 473 21
					yourself:
				)
		)
	)
)

(instance hubSite_180 of Feature
	(properties
		noun 10
		nsLeft 257
		nsTop -1
		nsRight 339
		nsBottom 62
		x 298
		y 30
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance spikes_90 of Feature
	(properties
		noun 7
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 173 96 178 61 181 100 yourself:)
				((Polygon new:) type: PTotalAccess init: 194 205 208 90 214 178 yourself:)
				((Polygon new:) type: PTotalAccess init: 343 144 351 55 360 150 yourself:)
				((Polygon new:) type: PTotalAccess init: 374 237 383 83 400 237 yourself:)
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
					init: -1 0 130 -1 118 23 92 46 53 68 -3 70
					yourself:
				)
		)
	)
)

