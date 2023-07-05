;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5414)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	NY_Subway_14 0
)

(instance NY_Subway_14 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(switch gPrevRoomNum
			(5417 ; NY_Subway_17
				(self addPicObj: faceSubway faceMoatSub faceSubway)
			)
			(5413 ; NY_Subway_13
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
		picture 5433
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToSubway init:)
		(chair init:)
		(super init: &rest)
	)
)

(instance faceMoatSub of CameraAngle
	(properties
		picture 5434
		heading 45
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToMoatSubway init:)
		(super init: &rest)
	)
)

(instance exitToMoatSubway of Feature
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
					init: 261 1 330 1 355 68 369 186 399 274 339 286 248 284 215 192 212 129
					yourself:
				)
			setHotspot: 2 144
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 5417) ; NY_Subway_17
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance exitToSubway of ExitFeature
	(properties
		nsLeft 189
		nsTop 15
		nsRight 393
		nsBottom 279
		nextRoom 5413
	)
)

(instance chair of Feature
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
			setHotspot: 144
		)
	)
)

