;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1001)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	hubCamp1 0
)

(instance hubCamp1 of Location
	(properties
		noun 20
	)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(1005 ; hubCamp5
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(1002 ; hubCamp2
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 1011
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 80)
			(= picture 1111)
		)
		(super init: &rest)
		(airlock_180 init:)
		(storage_180 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 1013
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 80)
			(= picture 1113)
		)
		(super init: &rest)
		(exitToLadder init:)
		(gCurRoom exitN: exitToLadder)
		(exitToLockers2 init:)
		(gCurRoom exitNW: exitToLockers2)
		(if (proc1111_24 80)
			(darkSky_0 init:)
		else
			(northHCyl_0 init:)
			(greatHorns_0 init:)
			(sea_0 init:)
			(lights_0 init:)
		)
		(ladder_0 init:)
		(lockers_0 init:)
		(storage_0 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 1012
		edgeS 0
		edgeN 0
	)

	(method (init)
		(cond
			((IsFlag 80)
				(= picture 1112)
			)
			((IsFlag 79)
				(= picture 1015)
			)
			(else
				(= picture 1012)
			)
		)
		(super init: &rest)
		(exitToLockers init:)
		(gCurRoom exitN: exitToLockers)
		(if (proc1111_24 80)
			(darkSky_270 init:)
		)
		(if (proc1111_24 79)
			(cableCar_270 init:)
		)
		(computer_270 init:)
		(gangplank_270 init:)
		(cots_270 init:)
		(lockers_270 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 1014
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 80)
			(= picture 1114)
		)
		(super init: &rest)
		(if (proc1111_24 80)
			(darkSky_90 init:)
		)
		(storage_90 init:)
	)
)

(instance exitToLockers of ExitFeature
	(properties
		nextRoom 1002
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9
				(= global164 90)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToLockers2 of ExitFeature
	(properties
		nsBottom 262
		nsLeft 6
		nsRight 152
		nsTop 82
		nextRoom 1002
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9
				(= global164 180)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToLadder of ExitFeature
	(properties
		nsBottom 228
		nsLeft 206
		nsRight 318
		nsTop 110
		nextRoom 1005
	)
)

(instance lockers_0 of Feature
	(properties
		noun 2
		x 99
		y 164
		nsBottom 247
		nsLeft -1
		nsRight 200
		nsTop 82
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance ladder_0 of Feature
	(properties
		noun 9
		x 268
		y 191
		nsBottom 222
		nsLeft 253
		nsRight 284
		nsTop 161
		case 2
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
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
					init: 338 218 351 112 433 115 590 284 387 286
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
					init: -1 1 591 2 587 211 423 125 349 131 339 218 282 220 285 160 244 159 245 216 219 214 208 93 8 84
					yourself:
				)
		)
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
					init: 384 1 585 1 587 92 556 94 533 227 383 149
					yourself:
				)
		)
	)
)

(instance gangplank_270 of Feature
	(properties
		noun 3
		x 433
		y 141
		nsBottom 156
		nsLeft 315
		nsRight 552
		nsTop 126
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance computer_270 of Feature
	(properties
		noun 5
		x 244
		y 119
		nsBottom 141
		nsLeft 174
		nsRight 315
		nsTop 97
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance lockers_270 of Feature
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
					init: 544 286 561 91 588 91 591 290
					yourself:
				)
		)
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
					init: 4 131 144 113 161 148 7 163
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
					init: 138 284 165 239 297 233 294 74 380 35 454 32 447 150 527 162 531 255 550 288
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
					init: 448 36 532 41 589 102 568 174 539 174 520 156 442 144
					yourself:
				)
		)
	)
)

(instance darkSky_90 of Feature
	(properties
		noun 1
		x 90
		y 90
		nsBottom 183
		nsRight 181
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
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
					init: 1 148 204 254 278 158 384 154 512 273 588 210
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 300 79 587 84 585 145 293 136
					yourself:
				)
		)
	)
)

(instance cableCar_270 of Feature
	(properties
		noun 14
		x 476
		y 123
		nsBottom 154
		nsLeft 453
		nsRight 499
		nsTop 92
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
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
				((Polygon new:) type: PTotalAccess init: 60 1 188 72 164 76 37 2 yourself:)
				((Polygon new:)
					type: PTotalAccess
					init: 396 79 522 0 552 2 410 90
					yourself:
				)
		)
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
					init: 197 76 231 42 305 26 367 50 403 89 416 131 372 127 328 73 279 68 228 107
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
					init: 224 106 260 74 307 65 351 91 372 127 342 128 342 209 313 219 289 220 285 165 245 161 245 205 222 174 216 139
					yourself:
				)
		)
	)
)

(instance greatHorns_0 of Feature
	(properties
		noun 15
		x 298
		y 143
		nsBottom 156
		nsLeft 285
		nsRight 312
		nsTop 131
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

