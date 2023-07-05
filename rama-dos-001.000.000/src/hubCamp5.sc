;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1005)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	hubCamp5 0
)

(instance hubCamp5 of Location
	(properties
		noun 20
	)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(1008 ; hubCamp8
				(self addPicObj: faceS faceN faceS)
			)
			(else
				(self addPicObj: faceN faceS faceN)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 1051
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 80)
			(= picture 1151)
		)
		(super init: &rest)
		(exitToBoxes init:)
		(airlock_180 init:)
		(storage_180 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 1052
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 80)
			(= picture 1152)
		)
		(super init: &rest)
		(if (proc1111_24 80)
			(darkSky_0 init:)
		else
			(northHCyl_0 init:)
			(sea_0 init:)
			(lights_0 init:)
		)
		(storage_0 init:)
		(lockers_0 init:)
		(ladder init:)
	)
)

(instance exitToBoxes of ExitFeature
	(properties
		nsBottom 238
		nsLeft 269
		nsRight 453
		nsTop 109
		nextRoom 1001
	)
)

(instance ladder of Feature
	(properties
		noun 9
		case 2
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 2 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 187 120 255 118 264 240 197 234
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom exitStyle: 13)
				(gCurRoom newRoom: 1008) ; hubCamp8
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lockers_0 of Feature
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 -1 28 -2 113 259 97 286 1 286
					yourself:
				)
		)
	)
)

(instance darkSky_0 of Feature
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
					init: 28 2 448 3 385 241 104 235
					yourself:
				)
		)
	)
)

(instance storage_0 of Feature
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
					init: 405 289 387 250 437 51 586 118 588 286
					yourself:
				)
		)
	)
)

(instance airlock_180 of Feature
	(properties
		noun 6
		x 481
		y 100
		nsBottom 163
		nsLeft 447
		nsRight 516
		nsTop 38
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
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
					init: 6 185 87 169 190 213 216 286 3 283
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 290 220 289 162 394 63 438 65 443 220
					yourself:
				)
		)
	)
)

(instance lights_0 of Feature
	(properties
		noun 18
		x 295
		y 201
		nsBottom 237
		nsLeft 288
		nsRight 303
		nsTop 166
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance sea_0 of Feature
	(properties
		noun 16
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 151 2 193 64 294 97 380 70 444 0 521 2 494 52 428 56 421 120 356 154 266 160 260 118 194 116 180 129 108 67 74 2
					yourself:
				)
		)
	)
)

(instance northHCyl_0 of Feature
	(properties
		noun 17
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 146 1 440 1 396 62 308 98 233 85 168 35
					yourself:
				)
		)
	)
)

