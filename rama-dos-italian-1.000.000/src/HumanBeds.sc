;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8130)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	HumanBeds 0
)

(instance HumanBeds of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(8050 ; HumanMainHall4
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(8120 ; HumanBench
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		heading 270
		picture 8024
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(BENCH_0 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 90
		picture 8025
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 8050 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 8026
		edgeS 0
		edgeN 0
	)
)

(instance faceW of CameraAngle
	(properties
		heading 180
		picture 8027
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 8120 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(CRANE_270 init:)
		(FURNITURE_270 init:)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance BENCH_0 of Feature
	(properties
		noun 11
		nsBottom 287
		nsLeft 175
		nsRight 576
		nsTop 39
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance CRANE_270 of Feature
	(properties
		noun 9
		case 3
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 182 125 253 106 262 34 288 35 322 121 280 171 171 177
					yourself:
				)
		)
	)
)

(instance FURNITURE_270 of Feature
	(properties
		noun 11
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 407 161 510 157 594 186 586 284 401 247 406 161
					yourself:
				)
		)
	)
)

