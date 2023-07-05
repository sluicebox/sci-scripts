;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1002)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	hubCamp2 0
)

(instance hubCamp2 of Location
	(properties
		noun 20
	)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(1001 ; hubCamp1
				(switch global164
					(90
						(self addPicObj: faceW faceN faceE faceS faceW)
					)
					(else
						(self addPicObj: faceN faceE faceS faceW faceN)
					)
				)
			)
			(1006 ; hubCamp6
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(1000 ; hubCamp0
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 1021
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 80)
			(= picture 1121)
		)
		(super init: &rest)
		(exitToDoor init:)
		(gCurRoom exitN: exitToDoor)
		(airlock_180 init:)
		(storage_180 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 1023
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 80)
			(= picture 1123)
		)
		(super init: &rest)
		(locker1 init:)
		(locker2 init:)
		(locker3 init:)
		(locker4 init:)
		(if (proc1111_24 80)
			(darkSky_0 init:)
		else
			(lights_0 init:)
		)
		(lockers_0 init:)
		(richardsLock_0 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 1022
		edgeS 0
		edgeN 0
	)

	(method (init)
		(cond
			((IsFlag 80)
				(= picture 1122)
			)
			((IsFlag 79)
				(= picture 1037)
			)
			(else
				(= picture 1022)
			)
		)
		(super init: &rest)
		(exitToEdge init:)
		(if (proc1111_24 80)
			(darkSky_270 init:)
		)
		(computer_270 init:)
		(if (proc1111_24 79)
			(cableCar_270 init:)
		)
		(gangplank_270 init:)
		(cots_270 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 1024
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 80)
			(= picture 1124)
		)
		(super init: &rest)
		(exitToBoxes init:)
		(gCurRoom exitN: exitToBoxes)
		(if (proc1111_24 80)
			(darkSky_90 init:)
		)
		(storage_90 init:)
	)
)

(instance exitToEdge of ExitFeature
	(properties
		nextRoom 1006
	)
)

(instance exitToBoxes of ExitFeature
	(properties
		nsBottom 265
		nsLeft 163
		nsRight 369
		nsTop 129
		nextRoom 1001
	)
)

(instance exitToDoor of ExitFeature
	(properties
		nsBottom 168
		nsLeft 255
		nsRight 463
		nsTop 68
		nextRoom 1000
	)
)

(instance locker1 of Feature
	(properties
		nsBottom 103
		nsLeft 284
		nsRight 357
		nsTop 25
	)

	(method (init)
		(super init:)
		(if (IsFlag 86)
			(self setHotspot: 2)
		else
			(self setHotspot: 2 115)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 1010) ; hubCampLocker1
			)
			(115
				(gCurRoom newRoom: 1010) ; hubCampLocker1
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance locker2 of Feature
	(properties
		nsBottom 194
		nsLeft 286
		nsRight 362
		nsTop 118
	)

	(method (init)
		(super init:)
		(if (IsFlag 87)
			(self setHotspot: 2)
		else
			(self setHotspot: 2 65)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 1011) ; hubCampLocker2
			)
			(65
				(gCurRoom newRoom: 1011) ; hubCampLocker2
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance locker3 of Feature
	(properties
		nsBottom 284
		nsLeft 195
		nsRight 275
		nsTop 204
	)

	(method (init)
		(super init:)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 1012) ; hubCampLocker3
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance locker4 of Feature
	(properties
		nsBottom 192
		nsLeft 378
		nsRight 446
		nsTop 117
	)

	(method (init)
		(super init:)
		(if (IsFlag 88)
			(self setHotspot: 2)
		else
			(self setHotspot: 2 37)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 1016) ; hubCampLocker4
			)
			(37
				(gCurRoom newRoom: 1016) ; hubCampLocker4
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance darkSky_0 of Feature
	(properties
		noun 1
		x 91
		y 128
		nsBottom 254
		nsLeft 1
		nsRight 182
		nsTop 3
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance lockers_0 of Feature
	(properties
		noun 2
		x 366
		y 154
		nsBottom 288
		nsLeft 187
		nsRight 546
		nsTop 21
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance darkSky_270 of Feature
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
					init: 399 4 586 6 586 278 386 165
					yourself:
				)
		)
	)
)

(instance gangplank_270 of Feature
	(properties
		noun 3
		x 441
		y 149
		nsBottom 164
		nsLeft 298
		nsRight 585
		nsTop 134
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance computer_270 of Feature
	(properties
		noun 5
		x 235
		y 123
		nsBottom 143
		nsLeft 159
		nsRight 311
		nsTop 103
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance cots_270 of Feature
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
					init: 4 136 136 118 136 153 3 166
					yourself:
				)
		)
	)
)

(instance storage_180 of Feature
	(properties
		noun 7
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 139 156 136 160 57 224 54 273 108 275 171 167 272 0 277
					yourself:
				)
		)
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
					init: 282 171 282 110 251 76 282 47 448 43 518 83 516 135 471 167
					yourself:
				)
		)
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
					init: 6 -1 183 6 166 143 47 139 8 204
					yourself:
				)
		)
	)
)

(instance storage_90 of Feature
	(properties
		noun 7
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 21 260 18 189 47 141 142 139 280 213 276 245
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 386 245 454 182 514 147 589 156 587 286 483 291
					yourself:
				)
		)
	)
)

(instance cableCar_270 of Feature
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
					init: 454 117 475 91 503 89 506 154 475 162 455 139
					yourself:
				)
		)
	)
)

(instance lights_0 of Feature
	(properties
		noun 18
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 65 1 183 72 175 89 38 10
					yourself:
				)
		)
	)
)

(instance richardsLock_0 of Feature
	(properties
		noun 21
		x 233
		y 249
		nsBottom 263
		nsLeft 225
		nsRight 242
		nsTop 236
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

