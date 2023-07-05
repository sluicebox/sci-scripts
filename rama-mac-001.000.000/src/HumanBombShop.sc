;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8110)
(include sci.sh)
(use Main)
(use Location)
(use VidmailChoices)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	HumanBombShop 0
)

(instance HumanBombShop of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(8030 ; HumanMainHall2
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(8100 ; HumanCistern
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(8120 ; HumanBench
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(8115 ; HumanBombCloseUp
				(self addPicObj: faceN faceE faceS faceW faceN)
				(if (and (IsFlag 157) (not (proc55_5 45)))
					(proc55_3 45)
				)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 8016
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(bombExit init:)
		(super init: &rest)
		(BOMB_0 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 8017
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 8030 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 8018
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 8120 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(FURNITURE_90 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 8019
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 8100 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(CRANE_270 init:)
		(MIRROR_270 init:)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance bombExit of Feature
	(properties
		nsLeft 88
		nsTop 142
		nsRight 431
		nsBottom 382
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 8115) ; HumanBombCloseUp
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance BOMB_0 of Feature
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
					init: 156 205 324 144 413 146 433 279 243 286 161 212
					yourself:
				)
		)
	)
)

(instance FURNITURE_90 of Feature
	(properties
		noun 11
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -3 182 129 148 135 100 245 110 248 194 193 201 192 251 168 261 60 264 3 283
					yourself:
				)
		)
	)
)

(instance CRANE_270 of Feature
	(properties
		noun 9
		case 3
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 210 23 95 159 58 163 2 282 2 353 106 293 142 283 200 134 229 1 217
					yourself:
				)
		)
	)
)

(instance MIRROR_270 of Feature
	(properties
		noun 7
		nsLeft 498
		nsTop 35
		nsRight 591
		nsBottom 199
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

