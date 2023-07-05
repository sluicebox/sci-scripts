;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5402)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	NY_Subway_2 0
)

(instance NY_Subway_2 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(switch gPrevRoomNum
			(5401 ; NY_Subway_1
				(self addPicObj: faceSubway faceRoom faceSubway)
			)
			(5403 ; NY_Subway_3
				(self addPicObj: faceRoom faceSubway faceRoom)
			)
			(else
				(self addPicObj: faceSubway faceRoom faceSubway)
			)
		)
	)
)

(instance faceSubway of CameraAngle
	(properties
		heading 90
		picture 5412
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToSubway init:)
		(super init: &rest)
	)
)

(instance faceRoom of CameraAngle
	(properties
		heading 270
		picture 5410
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToMantis init:)
		(machinery_270 init:)
		(fork_270 init:)
		(pent_270 init:)
		(super init: &rest)
	)
)

(instance exitToMantis of ExitFeature
	(properties
		nsBottom 278
		nsLeft 140
		nsRight 460
		nsTop 19
		nextRoom 5401
	)
)

(instance exitToSubway of Feature
	(properties
		noun 18
		case 8
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 269 57 327 57 326 129 339 130 340 150 325 154 363 271 324 279 268 278 246 220 247 180 263 180 270 156 258 156 258 131 271 129
					yourself:
				)
			setHotspot: 2 144
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom exitStyle: 256 newRoom: 5403) ; NY_Subway_3
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fork_270 of Feature
	(properties
		noun 29
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 311 112 321 111 322 133 321 150 319 152 319 168 326 173 327 178 317 179 306 179 306 174 310 169 314 168 313 150 311 150 309 131
					yourself:
				)
		)
	)
)

(instance pent_270 of Feature
	(properties
		noun 31
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 252 175 297 190 253 194 yourself:)
		)
	)
)

(instance machinery_270 of Feature
	(properties
		noun 19
		case 10
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 417 117 458 117 458 162 414 162
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 417 169 433 166 453 169 459 176 459 244 444 244 416 223
					yourself:
				)
		)
	)
)

