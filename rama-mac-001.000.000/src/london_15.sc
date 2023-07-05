;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3025)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	london_15 0
)

(instance london_15 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(3024 ; london_14
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(else
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 3209
		heading 180
		edgeN 0
		edgeS 0
	)
)

(instance faceW of CameraAngle
	(properties
		picture 3210
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 100)
			(= picture 3955)
		)
		(westExitToLondon10 init:)
		(super init:)
		(door4Out_270 init:)
		(bDispDoor_270 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 3208
		heading 90
		edgeN 0
		edgeS 0
	)
)

(instance faceN of CameraAngle
	(properties
		picture 3207
		edgeN 0
		edgeS 0
	)

	(method (init)
		(northExitToLondon14 init:)
		(super init:)
		(pitPillars_0 init:)
		(mantisDoor_0 init:)
	)
)

(instance westExitToLondon10 of ExitFeature
	(properties
		nextRoom 3020
	)
)

(instance northExitToLondon14 of ExitFeature
	(properties
		nextRoom 3024
	)
)

(instance pitPillars_0 of Feature
	(properties
		noun 15
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 131 149 150 98 346 118 366 155 254 156 256 164 126 172
					yourself:
				)
		)
	)
)

(instance mantisDoor_0 of Feature
	(properties
		noun 18
		nsLeft 398
		nsTop 116
		nsRight 420
		nsBottom 157
		x 409
		y 136
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance door4Out_270 of Feature
	(properties
		noun 14
		nsLeft 179
		nsTop 114
		nsRight 196
		nsBottom 159
		x 187
		y 136
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance bDispDoor_270 of Feature
	(properties
		noun 19
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 445 148 455 138 473 136 485 150
					yourself:
				)
		)
	)
)

