;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4105)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	bk2AntMusDoor 0
)

(instance bk2AntMusDoor of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(4122 ; bk2MusAntDoor
				(self addPicObj: facePuzzles faceMuseum facePuzzles)
			)
			(4104 ; bk2Anteroom
				(self addPicObj: faceMuseum facePuzzles faceMuseum)
			)
			(else
				(self addPicObj: faceMuseum facePuzzles faceMuseum)
			)
		)
	)
)

(instance facePuzzles of CameraAngle
	(properties
		picture 4122
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToPuzzles init:)
		(gCurRoom exitN: exitToPuzzles)
		(super init:)
		(ELEV_0 init:)
		(LMACHINE1_0 init:)
		(NUMERICDISP_0 init:)
	)
)

(instance faceMuseum of CameraAngle
	(properties
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 40)
			(exitToMuseum init:)
			(gCurRoom exitN: exitToMuseum)
			(= picture 4116)
			(super init:)
		else
			(= picture 4121)
			(super init:)
			(DOOR2MUSEUM_180 init:)
		)
	)
)

(instance exitToMuseum of ExitFeature
	(properties
		nsLeft 243
		nsTop 58
		nsRight 348
		nsBottom 201
		nextRoom 4122
		exitStyle 256
	)
)

(instance exitToPuzzles of ExitFeature
	(properties
		nsLeft 204
		nsTop 98
		nsRight 385
		nsBottom 189
		nextRoom 4104
	)
)

(instance DOOR2MUSEUM_180 of Feature
	(properties
		noun 7
		nsLeft 167
		nsRight 426
		nsBottom 284
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance NUMERICDISP_0 of Feature
	(properties
		noun 25
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 16 100 141 123 138 171 12 186
					yourself:
				)
		)
	)
)

(instance LMACHINE1_0 of Feature
	(properties
		noun 22
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 476 160 509 128 589 120 587 243 484 210
					yourself:
				)
		)
	)
)

(instance ELEV_0 of Feature
	(properties
		noun 21
		nsLeft 256
		nsTop 86
		nsRight 336
		nsBottom 185
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

