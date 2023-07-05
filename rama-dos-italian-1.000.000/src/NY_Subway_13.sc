;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5413)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	NY_Subway_13 0
)

(instance NY_Subway_13 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(switch gPrevRoomNum
			(5414 ; NY_Subway_14
				(self addPicObj: faceSubway faceMoatSub faceSubway)
			)
			(5416 ; NY_Subway_16
				(self addPicObj: faceMoatSub faceSubway faceMoatSub)
			)
			(else
				(self addPicObj: faceSubway faceMoatSub faceSubway)
			)
		)
	)
)

(instance faceSubway of CameraAngle
	(properties
		heading 225
		picture 5431
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToSubway init:)
		(super init: &rest)
	)
)

(instance faceMoatSub of CameraAngle
	(properties
		heading 45
		picture 5432
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToMoatSubway init:)
		(chair init:)
		(super init: &rest)
	)
)

(instance exitToMoatSubway of ExitFeature
	(properties
		nsBottom 279
		nsLeft 189
		nsRight 393
		nsTop 15
		nextRoom 5414
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
					init: 260 6 329 6 354 68 352 115 370 188 398 273 337 285 248 286 215 192 213 127
					yourself:
				)
			setHotspot: 2 144
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 5416) ; NY_Subway_16
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance chair of Feature
	(properties
		noun 18
		case 9
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
			setHotspot: 144
		)
	)
)

