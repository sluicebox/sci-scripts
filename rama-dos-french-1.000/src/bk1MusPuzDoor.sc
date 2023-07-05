;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4022)
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
	bk1MusPuzDoor 0
)

(instance bk1MusPuzDoor of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(4005 ; bk1CountMusDoor
				(self addPicObj: faceMuseum facePuzzles faceMuseum)
			)
			(4012 ; bk1Museum
				(self addPicObj: facePuzzles faceMuseum facePuzzles)
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
		picture 4024
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (== (proc70_9 57) 4022)
			(matrixPiece init: global117)
		)
		(exitToPuzzles init:)
		(gCurRoom exitN: exitToPuzzles)
		(super init:)
		(door2Plains_180 init:)
	)
)

(instance faceMuseum of CameraAngle
	(properties
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 36)
			(= picture 4062)
		else
			(= picture 4023)
		)
		(super init:)
		(exitToMuseum init:)
		(gCurRoom exitN: exitToMuseum)
	)
)

(instance exitToMuseum of ExitFeature
	(properties
		nsBottom 201
		nsLeft 243
		nsRight 348
		nsTop 58
		nextRoom 4012
	)
)

(instance exitToPuzzles of ExitFeature
	(properties
		nsBottom 262
		nsLeft 138
		nsRight 446
		nsTop 89
		nextRoom 4005
		exitStyle 256
	)
)

(instance matrixPiece of View
	(properties
		x 486
		y 249
		view 4050
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 57)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance door2Plains_180 of Feature
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
					init: 241 170 249 139 274 118 295 110 322 120 340 136 350 168
					yourself:
				)
		)
	)
)

