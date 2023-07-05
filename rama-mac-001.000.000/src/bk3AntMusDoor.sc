;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4205)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use Polygon)
(use Feature)
(use Actor)

(public
	bk3AntMusDoor 0
)

(instance bk3AntMusDoor of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(4222 ; bk3MusAntDoor
				(self addPicObj: faceAnteroom faceMuseum faceAnteroom)
			)
			(4204 ; bk3Anteroom
				(self addPicObj: faceMuseum faceAnteroom faceMuseum)
			)
			(else
				(self addPicObj: faceMuseum faceAnteroom faceMuseum)
			)
		)
	)
)

(instance faceAnteroom of CameraAngle
	(properties
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if
			(and
				(!= (proc70_9 41) 4008)
				(!= (proc70_9 42) 4008)
				(!= (proc70_9 43) 4008)
			)
			(= picture 4212)
			(jewel1 init:)
			(jewel2 init:)
			(jewel3 init:)
		else
			(= picture 4222)
		)
		(exitToAnteroom init:)
		(gCurRoom exitN: exitToAnteroom)
		(super init:)
		(ELEV_0 init:)
		(LMACHINE1_0 init:)
		(NUMERICDISP_0 init:)
	)
)

(instance faceMuseum of CameraAngle
	(properties
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 41)
			(= picture 4207)
			(exitToMuseum init:)
			(gCurRoom exitN: exitToMuseum)
		else
			(= picture 4221)
			(DOOR2MUSEUM_180 init:)
		)
		(super init:)
	)
)

(instance exitToMuseum of ExitFeature
	(properties
		nsLeft 243
		nsTop 58
		nsRight 348
		nsBottom 201
		nextRoom 4222
		exitStyle 256
	)
)

(instance exitToAnteroom of ExitFeature
	(properties
		nsLeft 204
		nsTop 98
		nsRight 385
		nsBottom 189
		nextRoom 4204
	)
)

(instance jewel1 of View
	(properties
		x 292
		y 151
		view 4205
	)

	(method (init)
		(if (IsFlag 42)
			(super init: global117 &rest)
		)
	)
)

(instance jewel2 of View
	(properties
		x 297
		y 151
		view 4205
	)

	(method (init)
		(if (IsFlag 43)
			(super init: global117 &rest)
		)
	)
)

(instance jewel3 of View
	(properties
		x 294
		y 148
		view 4205
	)

	(method (init)
		(if (IsFlag 44)
			(super init: global117 &rest)
		)
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
		noun 43
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
		noun 40
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
		nsLeft 256
		nsTop 86
		nsRight 336
		nsBottom 185
	)

	(method (init)
		(super init: &rest)
		(if
			(and
				(!= (proc70_9 41) 4008)
				(!= (proc70_9 42) 4008)
				(!= (proc70_9 43) 4008)
			)
			(= noun 61)
		else
			(= noun 21)
		)
		(self setHotspot: 144)
	)
)

