;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5411)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	NY_Subway_11 0
)

(instance NY_Subway_11 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(switch gPrevRoomNum
			(5410
				(self addPicObj: faceSubway faceRoom faceSubway)
			)
			(5412 ; NY_Subway_12
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
		picture 5412
		heading 45
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToSubway init:)
		(super init: &rest)
	)
)

(instance faceRoom of CameraAngle
	(properties
		picture 5409
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToPuzzleRm init:)
		(puzRoom init:)
		(machinery init:)
		(super init: &rest)
	)
)

(instance exitToPuzzleRm of ExitFeature
	(properties
		nsLeft 140
		nsTop 19
		nsRight 460
		nsBottom 278
		nextRoom 5404
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
				(gCurRoom exitStyle: 256 newRoom: 5412) ; NY_Subway_12
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance machinery of Feature
	(properties
		noun 19
		case 11
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

(instance puzRoom of Feature
	(properties
		noun 21
		nsLeft 141
		nsRight 459
		nsBottom 292
		x 300
		y 146
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

