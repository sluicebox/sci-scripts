;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4204)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use Feature)
(use Actor)

(public
	bk3Anteroom 0
)

(instance bk3Anteroom of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(= global269 3)
		(switch gPrevRoomNum
			(4131 ; bkElev2
				(self
					addPicObj:
						faceMuseum
						faceScreens
						faceElev
						facePuzzles
						faceMuseum
				)
			)
			(4205 ; bk3AntMusDoor
				(self
					addPicObj:
						faceElev
						facePuzzles
						faceMuseum
						faceScreens
						faceElev
				)
			)
			(4209 ; bk3Screen1
				(self
					addPicObj:
						faceScreens
						faceElev
						facePuzzles
						faceMuseum
						faceScreens
				)
			)
			(4010 ; bkScreen2
				(self
					addPicObj:
						faceScreens
						faceElev
						facePuzzles
						faceMuseum
						faceScreens
				)
			)
			(4211 ; bk3Screen3
				(self
					addPicObj:
						faceScreens
						faceElev
						facePuzzles
						faceMuseum
						faceScreens
				)
			)
			(else
				(self
					addPicObj:
						facePuzzles
						faceMuseum
						faceScreens
						faceElev
						facePuzzles
				)
			)
		)
	)
)

(instance facePuzzles of CameraAngle
	(properties
		heading 270
		picture 4202
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToPuzzle1 init:)
		(gCurRoom exitNW: exitToPuzzle1)
		(exitToPuzzle2 init:)
		(gCurRoom exitN: exitToPuzzle2)
		(exitToPuzzle3 init:)
		(gCurRoom exitNE: exitToPuzzle3)
		(super init:)
	)
)

(instance faceMuseum of CameraAngle
	(properties
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 41)
			(= picture 4217)
		else
			(= picture 4218)
			(DOOR2MUSEUM init:)
		)
		(super init:)
		(exitToMuseum init:)
		(gCurRoom exitN: exitToMuseum)
	)
)

(instance faceScreens of CameraAngle
	(properties
		heading 90
		picture 4219
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToScreen1 init:)
		(gCurRoom exitNW: exitToScreen1)
		(exitToScreen2 init:)
		(gCurRoom exitN: exitToScreen2)
		(exitToScreen3 init:)
		(gCurRoom exitNE: exitToScreen3)
		(super init:)
	)
)

(instance faceElev of CameraAngle
	(properties
		heading 180
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if
			(and
				(!= (proc70_9 41) 4008)
				(!= (proc70_9 42) 4008)
				(!= (proc70_9 43) 4008)
			)
			(= picture 4201)
			(jewel1 init:)
			(jewel2 init:)
			(jewel3 init:)
			(JEWEL_ELEV init:)
		else
			(= picture 4220)
			(ELEV2 init:)
		)
		(exitToElev init:)
		(gCurRoom exitN: exitToElev)
		(super init:)
	)
)

(instance exitToElev of ExitFeature
	(properties
		nsBottom 203
		nsLeft 142
		nsRight 456
		nsTop 62
		nextRoom 4131
		exitStyle 256
	)
)

(instance exitToMuseum of ExitFeature
	(properties
		nsBottom 201
		nsLeft 243
		nsRight 348
		nsTop 58
		nextRoom 4205
	)
)

(instance exitToPuzzle1 of Feature
	(properties
		noun 40
		nsBottom 249
		nsLeft 41
		nsRight 148
		nsTop 125
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom exitStyle: 256 newRoom: 4006) ; bkRepetition
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToPuzzle2 of Feature
	(properties
		noun 40
		nsBottom 262
		nsLeft 256
		nsRight 333
		nsTop 127
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom exitStyle: 256 newRoom: 4007) ; bkRecognition
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToPuzzle3 of Feature
	(properties
		noun 40
		nsBottom 265
		nsLeft 437
		nsRight 540
		nsTop 129
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom exitStyle: 256 newRoom: 4008) ; bkManipulation
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToScreen1 of Feature
	(properties
		noun 41
		nsBottom 184
		nsLeft 11
		nsRight 126
		nsTop 105
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom exitStyle: 256 newRoom: 4209) ; bk3Screen1
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToScreen2 of Feature
	(properties
		noun 42
		nsBottom 183
		nsLeft 178
		nsRight 336
		nsTop 105
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom exitStyle: 256 newRoom: 4010) ; bkScreen2
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToScreen3 of Feature
	(properties
		noun 43
		nsBottom 186
		nsLeft 398
		nsRight 583
		nsTop 106
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom exitStyle: 256 newRoom: 4211) ; bk3Screen3
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance jewel1 of View
	(properties
		x 291
		y 153
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
		y 153
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
		y 150
		view 4205
	)

	(method (init)
		(if (IsFlag 44)
			(super init: global117 &rest)
		)
	)
)

(instance ELEV2 of Feature
	(properties
		noun 21
		nsBottom 201
		nsLeft 229
		nsRight 362
		nsTop 54
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance JEWEL_ELEV of Feature
	(properties
		noun 61
		nsBottom 201
		nsLeft 229
		nsRight 362
		nsTop 54
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance DOOR2MUSEUM of Feature
	(properties
		noun 7
		nsBottom 214
		nsLeft 237
		nsRight 371
		nsTop 44
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

