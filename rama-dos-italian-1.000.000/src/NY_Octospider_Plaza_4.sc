;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5304)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	NY_Octospider_Plaza_4 0
)

(instance NY_Octospider_Plaza_4 of Location
	(properties
		noun 1
	)

	(method (init)
		(super init:)
		(faceN up: lookUpNE)
		(faceNE up: lookUpSE)
		(faceSE up: lookUpSW)
		(faceS up: lookUpNW)
		(faceSW up: lookUpNW)
		(faceNW up: lookUpNE)
		(switch gPrevRoomNum
			(5303 ; NY_Octospider_Plaza_3
				(self addPicObj: faceSW faceNW faceN faceNE faceSE faceS faceSW)
			)
			(5305 ; NY_Octospider_Plaza_5
				(self addPicObj: faceSE faceS faceSW faceNW faceN faceNE faceSE)
			)
			(5308 ; NY_Octospider_Plaza_8
				(self addPicObj: faceNW faceN faceNE faceSE faceS faceSW faceNW)
			)
			(5309 ; NY_Octospider_Plaza_9
				(self addPicObj: faceN faceNE faceSE faceS faceSW faceNW faceN)
			)
			(5310 ; NY_Octospider_Plaza_10
				(self addPicObj: faceNE faceSE faceS faceSW faceNW faceN faceNE)
			)
			(5312 ; NY_Octospider_Plaza_12
				(self addPicObj: faceS faceSW faceNW faceN faceNE faceSE faceS)
			)
			(else
				(self addPicObj: faceS faceSW faceNW faceN faceNE faceSE faceS)
			)
		)
	)
)

(instance faceSE of CameraAngle
	(properties
		heading 225
		picture 5315
		edgeS 0
	)

	(method (init)
		(if (IsFlag 239)
			(= picture 15302)
		)
		(exitToRoom8 init:)
		(super init:)
		(octohedron_225 init:)
		(maze_225 init:)
	)
)

(instance faceNE of CameraAngle
	(properties
		heading 135
		picture 5316
		edgeS 0
	)

	(method (init)
		(exitToRoom3 init:)
		(gCurRoom exitN: exitToRoom3)
		(super init:)
	)
)

(instance faceN of CameraAngle
	(properties
		heading 90
		picture 5317
		edgeS 0
	)

	(method (init)
		(exitToRoom12 init:)
		(gCurRoom exitN: exitToRoom12)
		(super init:)
	)
)

(instance faceNW of CameraAngle
	(properties
		heading 45
		picture 5318
		edgeS 0
	)

	(method (init)
		(exitToRoom5 init:)
		(gCurRoom exitN: exitToRoom5)
		(super init:)
	)
)

(instance faceSW of CameraAngle
	(properties
		heading 315
		picture 5313
		edgeS 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 270
		picture 5314
		edgeS 0
	)

	(method (init)
		(exitToRoom9 init:)
		(gCurRoom exitN: exitToRoom9)
		(super init:)
		(maze_270 init:)
	)
)

(instance exitToRoom3 of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 5303
	)
)

(instance exitToRoom5 of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 5305
	)
)

(instance exitToRoom8 of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 5308
	)
)

(instance exitToRoom9 of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 5309
	)
)

(instance exitToRoom12 of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 5312
	)
)

(instance lookUpNW of CameraAngle
	(properties
		picture 5296
		edgeW 0
		edgeE 0
		edgeN 0
	)

	(method (init)
		(= heading (gCurRoom heading:))
		(= down
			(switch heading
				(315 faceSW)
				(45 faceNW)
				(90 faceN)
				(135 faceNE)
				(225 faceSE)
				(270 faceS)
			)
		)
		(if (IsFlag 142)
			(= picture 5297)
		)
		(super init: &rest)
		(sea5296_up init:)
	)
)

(instance lookUpNE of CameraAngle
	(properties
		picture 5295
		edgeW 0
		edgeE 0
		edgeN 0
	)

	(method (init)
		(= heading (gCurRoom heading:))
		(= down
			(switch heading
				(315 faceSW)
				(45 faceNW)
				(90 faceN)
				(135 faceNE)
				(225 faceSE)
				(270 faceS)
			)
		)
		(if (IsFlag 142)
			(= picture 5298)
		)
		(super init: &rest)
		(sea5295_up init:)
	)
)

(instance lookUpSE of CameraAngle
	(properties
		picture 5399
		edgeW 0
		edgeE 0
		edgeN 0
	)

	(method (init)
		(= heading (gCurRoom heading:))
		(= down
			(switch heading
				(315 faceSW)
				(45 faceNW)
				(90 faceN)
				(135 faceNE)
				(225 faceSE)
				(270 faceS)
			)
		)
		(if (IsFlag 142)
			(= picture 5299)
		)
		(super init: &rest)
		(sea5399_up init:)
	)
)

(instance lookUpSW of CameraAngle
	(properties
		picture 5398
		edgeW 0
		edgeE 0
		edgeN 0
	)

	(method (init)
		(= heading (gCurRoom heading:))
		(= down
			(switch heading
				(315 faceSW)
				(45 faceNW)
				(90 faceN)
				(135 faceNE)
				(225 faceSE)
				(270 faceS)
			)
		)
		(if (IsFlag 142)
			(= picture 5300)
		)
		(super init: &rest)
		(sea5398_up init:)
	)
)

(instance octohedron_225 of Feature
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
					init: 231 138 270 135 285 175 285 181 251 182 241 175
					yourself:
				)
		)
	)
)

(instance maze_270 of Feature
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
					init: 199 -3 256 -3 255 179 195 179
					yourself:
				)
		)
	)
)

(instance maze_225 of Feature
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
					init: 536 -1 590 -2 592 180 545 180
					yourself:
				)
		)
	)
)

(instance sea5399_up of Feature
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
					init: 193 120 193 109 208 108 208 92 308 31 312 35 319 32 320 20 335 4 359 58 392 112 430 156 425 210 388 229 402 253 339 289 297 265 271 215 238 168
					yourself:
				)
		)
	)
)

(instance sea5398_up of Feature
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
					init: 304 27 354 32 373 65 396 54 433 116 408 164 366 183 320 215 268 263 253 263 251 249 236 248 176 149 179 144 176 139 165 137 147 120 158 120 201 99 255 67
					yourself:
				)
		)
	)
)

(instance sea5296_up of Feature
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
					init: 159 136 164 79 199 62 187 39 251 1 295 26 322 79 364 137 395 169 396 181 383 182 382 199 284 260 277 256 272 258 269 269 254 286 254 276 249 273 232 235 204 190 182 159 162 137
					yourself:
				)
		)
	)
)

(instance sea5295_up of Feature
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
					init: 181 127 241 95 284 62 320 25 337 26 338 40 353 39 415 140 411 145 415 151 423 153 445 170 384 193 330 226 285 262 235 259 218 224 192 236 156 174
					yourself:
				)
		)
	)
)

