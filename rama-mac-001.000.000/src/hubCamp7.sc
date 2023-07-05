;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1007)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)

(public
	hubCamp7 0
)

(instance hubCamp7 of Location
	(properties
		noun 20
	)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(2004 ; baseCamp4
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(1020 ; hubCableCar
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 1071
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 80)
			(= picture 1171)
		)
		(super init: &rest)
		(exitToDoor init:)
		(gCurRoom exitN: exitToDoor)
		(airlock_180 init:)
		(storage_180 init:)
		(cots_180 init:)
		(computer_180 init:)
		(railing_180 init:)
		(gangplank_180 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 1073
		edgeN 0
		edgeS 0
	)

	(method (init)
		(cond
			((IsFlag 80)
				(= picture 1173)
			)
			((IsFlag 79)
				(= picture 1076)
			)
			(else
				(= picture 1073)
			)
		)
		(super init: &rest)
		(if (proc1111_24 80)
			(darkSky_0 init:)
		else
			(northHCyl_0 init:)
			(greatHorns_0 init:)
			(sea_0 init:)
			(newYork_0 init:)
			(lights_0 init:)
		)
		(railing_0 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 1072
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(cond
			((IsFlag 80)
				(= picture 1172)
			)
			((IsFlag 79)
				(= picture 1075)
			)
			(else
				(= picture 1072)
			)
		)
		(super init: &rest)
		(if (proc1111_24 80)
			(darkSky_270 init:)
		)
		(computer_270 init:)
		(dish_270 init:)
		(railing_270 init:)
		(if (not (IsFlag 79))
			(chairLift init:)
		)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 1074
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 80)
			(= picture 1174)
		)
		(super init: &rest)
		(if (proc1111_24 80)
			(darkSky_90 init:)
		)
		(storage_90 init:)
		(lockers_90 init:)
		(railing_90 init:)
	)
)

(instance exitToDoor of ExitFeature
	(properties
		nextRoom 1003
	)
)

(instance chairLift of Feature
	(properties
		noun 14
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 2 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 176 73 254 0 285 5 435 212 413 286 194 285 156 210
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 1020) ; hubCableCar
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dawningInRama of VMDMovie ; UNUSED
	(properties
		movieName 1100
		frameRate 10
		options 256
		endPic 61
	)
)

(instance darkSky_0 of Feature
	(properties
		noun 1
		nsLeft 2
		nsTop 3
		nsRight 587
		nsBottom 288
		x 294
		y 145
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance railing_0 of Feature
	(properties
		noun 13
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 176 285 183 232 221 205 410 200 535 289 402 288 401 219 232 225 225 288
					yourself:
				)
		)
	)
)

(instance darkSky_270 of Feature
	(properties
		noun 1
		nsLeft 349
		nsTop 3
		nsRight 585
		nsBottom 290
		x 467
		y 146
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance computer_270 of Feature
	(properties
		noun 5
		nsLeft 1
		nsTop 108
		nsRight 34
		nsBottom 169
		x 17
		y 138
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance dish_270 of Feature
	(properties
		noun 12
		nsLeft 86
		nsTop 131
		nsRight 131
		nsBottom 177
		x 108
		y 154
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance railing_270 of Feature
	(properties
		noun 13
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -1 198 130 203 136 286 -4 286
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 453 204 570 200 591 213 588 288 443 285 441 230
					yourself:
				)
		)
	)
)

(instance gangplank_180 of Feature
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
					init: 271 205 325 206 355 292 233 289
					yourself:
				)
		)
	)
)

(instance railing_180 of Feature
	(properties
		noun 13
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 119 282 268 153 271 209 237 287
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 327 210 330 162 481 287 359 290
					yourself:
				)
		)
	)
)

(instance computer_180 of Feature
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
					init: 430 104 586 105 590 205 427 170
					yourself:
				)
		)
	)
)

(instance cots_180 of Feature
	(properties
		noun 4
		nsLeft 244
		nsTop 138
		nsRight 395
		nsBottom 166
		x 319
		y 152
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
					init: 28 119 85 70 177 68 270 127 222 158 73 160 73 122
					yourself:
				)
		)
	)
)

(instance storage_180 of Feature
	(properties
		noun 7
		nsLeft 3
		nsTop 122
		nsRight 70
		nsBottom 170
		x 36
		y 146
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance darkSky_90 of Feature
	(properties
		noun 1
		nsTop 3
		nsRight 267
		nsBottom 196
		x 133
		y 99
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance railing_90 of Feature
	(properties
		noun 13
		nsLeft 2
		nsTop 203
		nsRight 588
		nsBottom 288
		x 295
		y 245
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance lockers_90 of Feature
	(properties
		noun 2
		nsLeft 369
		nsTop 113
		nsRight 408
		nsBottom 159
		x 388
		y 136
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
					init: 477 155 478 118 590 110 589 160
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
				((Polygon new:) type: PTotalAccess init: 41 5 53 1 194 78 181 89 yourself:)
				((Polygon new:)
					type: PTotalAccess
					init: 397 79 526 2 554 1 404 91
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 288 266 289 287 301 289 302 269
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 226 112 244 123 251 112 233 102
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 338 114 359 104 364 111 346 124
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
					init: 296 27 378 58 416 136 380 232 296 267 208 229 176 165 194 84 242 37
					yourself:
				)
		)
	)
)

(instance newYork_0 of Feature
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
					init: 206 91 249 60 219 100 204 146 195 146 199 112
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
					init: 250 120 234 91 279 68 334 76 359 99 338 117 362 116 368 113 373 166 351 202 239 200 216 160 222 116 246 122 251 118
					yourself:
				)
		)
	)
)

(instance greatHorns_0 of Feature
	(properties
		noun 15
		nsLeft 282
		nsTop 133
		nsRight 307
		nsBottom 156
		x 294
		y 144
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

