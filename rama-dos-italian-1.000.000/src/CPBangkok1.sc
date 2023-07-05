;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2080)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	CPBangkok1 0
)

(instance CPBangkok1 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(2081 ; CPBangkok2
				(self addPicObj: faceS faceN faceS)
			)
			(else
				(self addPicObj: faceN faceS faceN)
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
		picture 3980
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 2081 init:)
		(gCurRoom exitN: defaultExit)
		(if (IsFlag 34)
			(= picture 3991)
		else
			(= picture 3980)
		)
		(super init: &rest)
		(bangkok_0 init:)
		(sea_0 init:)
		(newyork_0 init:)
		(lights_0 init:)
		(pod_0 init:)
		(door_0 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 3981
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 2000 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(hubSite_180 init:)
	)
)

(instance defaultExit of ExitFeature
	(properties)
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
					init: 137 192 137 160 161 156 182 154 184 143 194 138 193 91 211 81 225 99 235 88 252 82 252 72 230 53 241 45 251 57 259 47 262 1 275 0 278 45 288 58 299 46 309 56 285 76 289 82 302 86 318 99 332 82 345 94 343 136 349 140 355 148 351 157 387 159 396 162 396 192
					yourself:
				)
		)
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
					init: 52 1 201 0 192 37 193 67 207 97 234 125 230 139 192 127 131 93 92 57 67 26
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 338 138 362 123 387 93 399 60 401 30 392 1 541 1 510 44 473 81 434 109 395 128 350 141
					yourself:
				)
		)
	)
)

(instance newyork_0 of Feature
	(properties
		noun 8
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 343 138 363 128 378 119 394 106 406 99 408 102 396 116 381 125 367 133 349 139
					yourself:
				)
		)
	)
)

(instance lights_0 of Feature
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
					init: 201 9 237 53 232 66 196 26
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 329 45 346 1 370 1 341 56
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 393 130 504 114 482 134 356 141
					yourself:
				)
		)
	)
)

(instance pod_0 of Feature
	(properties
		noun 4
		x 435
		y 178
		nsBottom 185
		nsLeft 422
		nsRight 449
		nsTop 171
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance door_0 of Feature
	(properties
		noun 2
		x 274
		y 186
		nsBottom 194
		nsLeft 257
		nsRight 291
		nsTop 178
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance hubSite_180 of Feature
	(properties
		noun 10
		x 299
		y 29
		nsBottom 60
		nsLeft 258
		nsRight 341
		nsTop -1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

