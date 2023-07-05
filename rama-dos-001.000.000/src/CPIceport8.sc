;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2107)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Osc)
(use Polygon)
(use Feature)
(use Actor)

(public
	CPIceport8 0
)

(instance CPIceport8 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(2109 ; icemobileCU
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(2106 ; CPIceport7
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 2429
		edgeS 0
		edgeN 0
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 2430
		edgeS 0
		edgeN 0
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 2431
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 2106 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(self up: faceUp)
		(faceUp heading: heading down: self)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 2432
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 2109 init:)
		(if (IsFlag 72)
			(= picture 2436)
		)
		(super init: &rest)
		(if (== picture 2436)
			(nicole init: global117 setCycle: Osc -1)
		)
		(self up: faceUp)
		(faceUp heading: heading down: self)
		(pillar_270 init:)
		(icemobile_270 init:)
		(sea_270 init:)
	)
)

(instance faceUp of CameraAngle
	(properties
		picture 2433
		edgeW 0
		edgeE 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(sea_180_up init:)
		(lights_180_up init:)
		(pillar_180_up init:)
		(bomb_180_up init:)
	)
)

(instance nicole of Prop
	(properties
		x 241
		y 231
		view 2436
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance pillar_270 of Feature
	(properties
		noun 6
		x 177
		y 53
		nsBottom 87
		nsLeft 154
		nsRight 201
		nsTop 20
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance icemobile_270 of Feature
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
					init: 105 159 214 150 241 154 266 162 295 174 323 197 325 213 319 220 313 228 298 227 238 225 201 224 200 220 143 219 118 205 101 204 98 196 96 178
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(144
				(if (IsFlag 72)
					(gMessager say: 4 144 1 0 0 208) ; "Nicole is waiting for you."
				else
					(gMessager say: 4 144 2 0 0 208) ; "That is an vehicle made especially by the ISA for traveling on Ice."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sea_270 of Feature
	(properties
		noun 9
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 250 156 270 132 279 102 286 53 288 0 590 0 592 292 462 291 424 262 400 246 369 235 344 230 320 227 320 219 327 208 318 193 296 176 271 165
					yourself:
				)
		)
	)
)

(instance sea_180_up of Feature
	(properties
		noun 9
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 512 -1 591 -1 590 114 560 68 530 26
					yourself:
				)
		)
	)
)

(instance lights_180_up of Feature
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
					init: 309 95 423 -1 440 -2 319 99
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 282 119 294 109 296 117 287 125
					yourself:
				)
		)
	)
)

(instance pillar_180_up of Feature
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
					init: 286 162 283 144 285 131 292 131 297 109 308 97 323 99 337 106 345 115 364 163 362 198 359 209 340 215 299 206 292 202 291 166
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 414 220 416 207 419 198 429 184 445 190 455 194 462 207 473 232 474 258 468 261 458 262 451 259 446 223 435 215
					yourself:
				)
		)
	)
)

(instance bomb_180_up of Feature
	(properties
		noun 1
		x 279
		y 153
		nsBottom 162
		nsLeft 272
		nsRight 286
		nsTop 144
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

