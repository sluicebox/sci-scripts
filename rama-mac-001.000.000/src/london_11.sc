;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3021)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use Polygon)
(use Feature)
(use Actor)

(public
	london_11 0
)

(instance london_11 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(3022 ; london_12
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(else
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 3246
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 3247
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 3245
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(eastExitToLondon10 init:)
		(super init:)
		(mantisDoor_90 init:)
		(door4Out_90 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 3244
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 100)
			(= picture 3259)
		)
		(northExitToLondon12 init:)
		(super init:)
		(mp_L31y init:)
		(biotDispDoor_0 init:)
		(pitPillars_0 init:)
		(trashCars_0 init:)
	)
)

(instance northExitToLondon12 of ExitFeature
	(properties
		nextRoom 3022
	)
)

(instance eastExitToLondon10 of ExitFeature
	(properties
		nextRoom 3020
	)
)

(instance mp_L31y of View
	(properties
		x 559
		y 279
		view 3200
	)

	(method (init)
		(if (== (proc70_9 74) 3021)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 74)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mantisDoor_90 of Feature
	(properties
		noun 18
		nsLeft 78
		nsTop 129
		nsRight 98
		nsBottom 148
		x 88
		y 138
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance door4Out_90 of Feature
	(properties
		noun 14
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 388 158 393 149 392 116 410 108 418 154 403 163
					yourself:
				)
		)
	)
)

(instance biotDispDoor_0 of Feature
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
					init: 153 158 153 133 169 116 184 138 197 158 180 165
					yourself:
				)
		)
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
					init: 235 113 347 104 349 89 364 92 362 128 390 155 219 148
					yourself:
				)
		)
	)
)

(instance trashCars_0 of Feature
	(properties
		noun 21
		nsLeft 197
		nsTop 148
		nsRight 311
		nsBottom 161
		x 254
		y 154
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

