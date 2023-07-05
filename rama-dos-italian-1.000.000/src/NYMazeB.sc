;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5501)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	NYMazeB 0
)

(instance NYMazeB of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5001 ; NYAvian1
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(5500 ; NYMazeA
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(else
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 5508
		edgeS 0
		edgeN 0
	)

	(method (init)
		(walls_0 init:)
		(super init: &rest)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 5506
		edgeS 0
		edgeN 0
	)

	(method (init)
		(walls_0 init:)
		(super init: &rest)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 5505
		edgeS 0
		edgeN 0
	)

	(method (init)
		(avianPExit init:)
		(walls_90 init:)
		(plaza_90 init:)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 142)
			(= picture 5610)
		else
			(= picture 5507)
		)
		(mazeAExit init:)
		(walls_270 init:)
		(ice_270 init:)
		(door_270 init:)
		(super init: &rest)
	)
)

(instance mazeAExit of ExitFeature
	(properties
		nsBottom 186
		nsLeft 266
		nsRight 325
		nsTop 143
		nextRoom 5500
	)
)

(instance avianPExit of ExitFeature
	(properties
		nsBottom 183
		nsLeft 256
		nsRight 341
		nsTop 54
		nextRoom 5001
	)
)

(instance walls_0 of Feature
	(properties
		noun 3
		x 294
		y 106
		nsBottom 212
		nsLeft 1
		nsRight 588
		nsTop 1
		case 4
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance walls_90 of Feature
	(properties
		noun 3
		case 4
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 2 589 0 589 200 400 185 370 185 336 180 254 180 212 186 197 185 0 205
					yourself:
				)
		)
	)
)

(instance plaza_90 of Feature
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
					init: 261 -1 329 0 333 46 330 57 329 67 332 81 328 127 333 144 331 155 333 181 255 180 258 136 262 128 263 110 258 98 261 92 261 66 259 61 264 57 265 39 257 32
					yourself:
				)
		)
	)
)

(instance walls_270 of Feature
	(properties
		noun 3
		case 4
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 0 591 0 592 206 403 188 360 188 339 183 256 183 232 189 184 189 1 205
					yourself:
				)
		)
	)
)

(instance ice_270 of Feature
	(properties
		noun 4
		x 295
		y 71
		nsBottom 143
		nsLeft 257
		nsRight 334
		nsTop -1
		case 4
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance door_270 of Feature
	(properties
		noun 2
		x 295
		y 164
		nsBottom 184
		nsLeft 255
		nsRight 336
		nsTop 145
		case 3
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

