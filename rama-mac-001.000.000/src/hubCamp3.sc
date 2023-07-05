;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1003)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	hubCamp3 0
)

(instance hubCamp3 of Location
	(properties
		noun 20
	)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(1006 ; hubCamp6
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(1004 ; hubCamp4
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(1000 ; hubCamp0
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(else
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 1031
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 80)
			(= picture 1131)
		)
		(super init: &rest)
		(exitToDoor init:)
		(airlock_180 init:)
		(storage_180 init:)
		(cots_180 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 1033
		edgeN 0
		edgeS 0
	)

	(method (init)
		(cond
			((IsFlag 80)
				(= picture 1133)
			)
			((IsFlag 79)
				(= picture 1038)
			)
			(else
				(= picture 1033)
			)
		)
		(super init: &rest)
		(exitToRamp init:)
		(exitToEdge init:)
		(if (proc1111_24 79)
			(cableCar_0 init:)
		)
		(gangplank_0 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 1032
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 80)
			(= picture 1132)
		)
		(super init: &rest)
		(exitToComputer init:)
		(computer_270 init:)
		(dish_270 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 1034
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 80)
			(= picture 1134)
		)
		(super init: &rest)
		(exitToEdgeW init:)
		(if (proc1111_24 80)
			(darkSky_90 init:)
		)
		(storage_90 init:)
		(lockers_90 init:)
	)
)

(instance exitToDoor of ExitFeature
	(properties
		nsLeft 134
		nsTop 81
		nsRight 311
		nsBottom 180
		nextRoom 1000
	)
)

(instance exitToComputer of ExitFeature
	(properties
		nsLeft 335
		nsTop 58
		nsRight 499
		nsBottom 217
		nextRoom 1004
	)
)

(instance exitToRamp of ExitFeature
	(properties
		nextRoom 1007
	)
)

(instance exitToEdgeW of ExitFeature
	(properties
		nsLeft 142
		nsTop 110
		nsRight 347
		nsBottom 241
		nextRoom 1006
	)
)

(instance exitToEdge of ExitFeature
	(properties
		nsLeft 483
		nsTop 146
		nsRight 553
		nsBottom 273
		nextRoom 1006
	)
)

(instance gangplank_0 of Feature
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
					init: 295 180 341 180 406 248 397 328 191 331 207 245 295 179
					yourself:
				)
		)
	)
)

(instance computer_270 of Feature
	(properties
		noun 5
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 126 124 234 125 234 224 130 219
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 274 129 368 129 365 222 276 220
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 405 127 449 127 487 142 492 208 445 229 407 224
					yourself:
				)
		)
	)
)

(instance dish_270 of Feature
	(properties
		noun 12
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 538 217 561 174 591 181 577 221
					yourself:
				)
		)
	)
)

(instance cots_180 of Feature
	(properties
		noun 4
		nsLeft 338
		nsTop 144
		nsRight 518
		nsBottom 187
		x 428
		y 165
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance airlock_180 of Feature
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
					init: 141 156 192 109 285 104 355 158 341 207 185 200 178 160
					yourself:
				)
		)
	)
)

(instance storage_180 of Feature
	(properties
		noun 7
		nsLeft 1
		nsTop 117
		nsRight 148
		nsBottom 170
		x 74
		y 143
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance darkSky_90 of Feature
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
					init: 31 43 262 42 253 170 225 166 225 218 33 283
					yourself:
				)
		)
	)
)

(instance lockers_90 of Feature
	(properties
		noun 2
		nsLeft 205
		nsTop 131
		nsRight 239
		nsBottom 181
		x 222
		y 156
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance storage_90 of Feature
	(properties
		noun 7
		nsLeft 334
		nsTop 132
		nsRight 508
		nsBottom 178
		x 421
		y 155
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance cableCar_0 of Feature
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
					init: 244 124 284 126 287 192 226 225 222 167
					yourself:
				)
		)
	)
)

