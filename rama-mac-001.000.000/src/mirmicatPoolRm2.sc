;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6902)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	mirmicatPoolRm2 0
)

(instance mirmicatPoolRm2 of Location
	(properties
		noun 54
	)

	(method (init)
		(super init:)
		(faceUpNW down: faceNW)
		(faceNW up: faceUpNW)
		(switch gPrevRoomNum
			(6903 ; mirmicatPoolRm3
				(self addPicObj: faceSE faceSW faceNW faceN faceSE)
			)
			(6901 ; mirmicatPoolRm1
				(self addPicObj: faceSE faceSW faceNW faceN faceSE)
			)
			(6911 ; mirmicatPoolCloseUp
				(switch global164
					(0
						(self addPicObj: faceNW faceN faceSE faceSW faceNW)
					)
					(90
						(self addPicObj: faceSW faceNW faceN faceSE faceSW)
					)
					(270
						(self addPicObj: faceN faceSE faceSW faceNW faceN)
					)
				)
			)
			(else
				(self addPicObj: faceNW faceN faceSE faceSW faceNW)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 6902
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 6903 init:)
		(gCurRoom exitN: defaultExit)
		(super init:)
		(door_0 init:)
		(myrmSeats_0 init:)
		(pool_0 init:)
	)
)

(instance faceNW of CameraAngle
	(properties
		picture 6901
		heading 315
		edgeS 0
	)

	(method (init)
		(NWExit init:)
		(SWExit init:)
		(super init: &rest)
		(doors_315 init:)
		(walkway_315 init:)
		(myrmSeats_315 init:)
		(pool init:)
	)
)

(instance faceUpNW of CameraAngle
	(properties
		picture 6905
		heading 315
		edgeN 0
		edgeE 0
		edgeW 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance faceSE of CameraAngle
	(properties
		picture 6903
		heading 135
		edgeN 0
		edgeS 0
	)

	(method (init)
		(hallExit init:)
		(gCurRoom exitN: hallExit)
		(super init:)
	)
)

(instance faceSW of CameraAngle
	(properties
		picture 6904
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 6901 init:)
		(gCurRoom exitN: defaultExit)
		(super init:)
		(doors_225 init:)
		(ramp_225 init:)
		(myrmSeats_225 init:)
		(pool_225 init:)
	)
)

(instance pool of Feature
	(properties
		noun 49
		nsLeft 264
		nsTop 192
		nsRight 348
		nsBottom 252
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 2 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 66 224 166 186 277 185 329 184 415 192 493 207 522 239 474 267 344 277 183 279 91 255 69 222 92 212
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 6911) ; mirmicatPoolCloseUp
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hallExit of ExitFeature
	(properties
		nsLeft 220
		nsTop 62
		nsRight 393
		nsBottom 227
		nextRoom 6513
		exitStyle 256
	)
)

(instance defaultExit of ExitFeature
	(properties
		nsLeft 220
		nsTop 62
		nsRight 393
		nsBottom 227
		nextRoom 6903
	)
)

(instance SWExit of ExitFeature
	(properties
		nsLeft 8
		nsTop 91
		nsRight 93
		nsBottom 197
		nextRoom 6901
	)
)

(instance NWExit of ExitFeature
	(properties
		nsLeft 500
		nsTop 101
		nsRight 583
		nsBottom 203
		nextRoom 6903
	)
)

(instance emptyPool_315 of Feature ; UNUSED
	(properties
		noun 49
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 68 224 166 193 265 183 316 184 427 192 497 207 539 234 464 269 342 282 199 277 76 249 69 224
					yourself:
				)
		)
	)
)

(instance walkway_315 of Feature
	(properties
		noun 53
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 87 179 89 165 252 142 334 141 341 165 89 191
					yourself:
				)
		)
	)
)

(instance myrmSeats_315 of Feature
	(properties
		noun 24
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 103 183 342 168 344 158 360 156 396 167 402 157 438 169 512 162 501 202 394 188 314 183 198 188 147 193 92 200 104 187
					yourself:
				)
		)
	)
)

(instance doors_315 of Feature
	(properties
		noun 52
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 48 163 75 114 112 118 129 159
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 463 159 486 113 532 114 560 166
					yourself:
				)
		)
	)
)

(instance doors_225 of Feature
	(properties
		noun 52
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 305 149 329 103 358 104 376 149
					yourself:
				)
		)
	)
)

(instance myrmSeats_225 of Feature
	(properties
		noun 24
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 322 199 328 170 589 169 590 195 320 197
					yourself:
				)
		)
	)
)

(instance ramp_225 of Feature
	(properties
		noun 53
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 326 173 329 154 587 125 588 171 330 174
					yourself:
				)
		)
	)
)

(instance pool_225 of Feature
	(properties
		noun 49
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 309 291 281 227 327 200 409 190 505 190 563 193 588 195 589 291 310 294
					yourself:
				)
		)
	)
)

(instance door_0 of Feature
	(properties
		noun 52
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 202 154 227 109 267 109 284 155
					yourself:
				)
		)
	)
)

(instance myrmSeats_0 of Feature
	(properties
		noun 24
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 74 153 94 154 105 161 143 163 154 151 168 154 250 158 260 165 262 192 243 199 98 193 42 197 1 199 0 173 79 167
					yourself:
				)
		)
	)
)

(instance pool_0 of Feature
	(properties
		noun 49
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -2 199 90 194 135 192 229 198 298 212 326 248 315 287 298 294 -1 290
					yourself:
				)
		)
	)
)

