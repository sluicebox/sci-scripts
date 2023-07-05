;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4005)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	bk1CountMusDoor 0
)

(instance bk1CountMusDoor of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(4022 ; bk1MusPuzDoor
				(self addPicObj: facePuzzles faceMuseum facePuzzles)
			)
			(4004 ; bk1CountRm
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
		heading 180
		picture 4022
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToPuzzles init:)
		(gCurRoom exitN: exitToPuzzles)
		(super init: &rest)
		(lMachine1_180 init:)
		(doorToPlains_180 init:)
		(display3_180 init:)
	)
)

(instance faceMuseum of CameraAngle
	(properties
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 39)
			(= picture 4054)
			(exitToMuseum init:)
			(gCurRoom exitN: exitToMuseum)
			(super init: &rest)
		else
			(= picture 4021)
			(super init: &rest)
			(door2Museam1_0 init:)
		)
	)
)

(instance exitToMuseum of ExitFeature
	(properties
		nsBottom 201
		nsLeft 243
		nsRight 348
		nsTop 58
		nextRoom 4022
		exitStyle 256
	)
)

(instance exitToPuzzles of ExitFeature
	(properties
		nsBottom 189
		nsLeft 204
		nsRight 385
		nsTop 98
		nextRoom 4004
	)
)

(instance doorToPlains_180 of Feature
	(properties
		noun 8
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 205 182 213 141 251 106 296 92 342 106 376 141 386 183
					yourself:
				)
		)
	)
)

(instance display3_180 of Feature
	(properties
		noun 6
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 22 107 49 106 126 120 124 170 25 183
					yourself:
				)
		)
	)
)

(instance lMachine1_180 of Feature
	(properties
		noun 9
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 485 161 512 129 547 127 552 171 573 205 562 220 506 215 505 177
					yourself:
				)
		)
	)
)

(instance door2Museam1_0 of Feature
	(properties
		noun 7
		nsBottom 289
		nsLeft 83
		nsRight 519
		nsTop 3
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

