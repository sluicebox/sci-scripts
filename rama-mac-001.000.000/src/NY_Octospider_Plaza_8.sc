;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5308)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	NY_Octospider_Plaza_8 0
)

(instance NY_Octospider_Plaza_8 of Location
	(properties
		noun 1
	)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(5304 ; NY_Octospider_Plaza_4
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(5309 ; NY_Octospider_Plaza_9
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(5310 ; NY_Octospider_Plaza_10
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(5325 ; NY_Octospider_Plaza_25
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(else
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 5332
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToMaze init:)
		(exitToMuseum init:)
		(super init: &rest)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 5330
		heading 90
		edgeN 0
		edgeS 0
	)
)

(instance faceW of CameraAngle
	(properties
		picture 5331
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToRoom4 init:)
		(gCurRoom exitN: exitToRoom4)
		(super init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 5329
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 239)
			(= picture 5389)
		)
		(exitToRoom25 init:)
		(super init:)
		(octohedron_180 init:)
		(prismPuzzle_180 init:)
	)
)

(instance exitToRoom4 of ExitFeature
	(properties
		nsLeft 178
		nsTop 16
		nsRight 432
		nsBottom 271
		nextRoom 5304
	)
)

(instance exitToRoom25 of ExitFeature
	(properties
		nsLeft 178
		nsTop 16
		nsRight 432
		nsBottom 271
		nextRoom 5325
	)
)

(instance exitToMaze of ExitFeature
	(properties
		nextRoom 5309
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 275 142 361 142 361 204 275 204
					yourself:
				)
		)
	)
)

(instance exitToMuseum of ExitFeature
	(properties
		nextRoom 5310
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 449 142 565 142 565 204 449 204
					yourself:
				)
		)
	)
)

(instance octohedron_180 of Feature
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
					init: 110 163 173 -2 406 -1 471 164 423 165 426 208 469 210 468 244 459 257 431 280 404 290 183 291 157 283 126 260 114 244 114 212 157 211 155 166
					yourself:
				)
		)
	)
)

(instance prismPuzzle_180 of Feature
	(properties
		noun 15
		nsLeft 230
		nsTop 97
		nsRight 254
		nsBottom 119
		x 242
		y 108
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

