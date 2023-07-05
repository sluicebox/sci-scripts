;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4004)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	bk1CountRm 0
)

(instance bk1CountRm of Location
	(properties)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(= style 256)
		(= global269 1)
		(switch gPrevRoomNum
			(4003 ; bkPuzPorchDoor
				(self
					addPicObj:
						faceMuseum
						faceScreens
						facePorch
						facePuzzles
						faceMuseum
				)
			)
			(4002 ; bkPorchDoor
				(self
					addPicObj:
						faceMuseum
						faceScreens
						facePorch
						facePuzzles
						faceMuseum
				)
			)
			(4000 ; bkPorch
				(self
					addPicObj:
						faceMuseum
						faceScreens
						facePorch
						facePuzzles
						faceMuseum
				)
			)
			(4005 ; bk1CountMusDoor
				(self
					addPicObj:
						facePorch
						facePuzzles
						faceMuseum
						faceScreens
						facePorch
				)
			)
			(4009 ; bk1Screen1
				(self
					addPicObj:
						faceScreens
						facePorch
						facePuzzles
						faceMuseum
						faceScreens
				)
			)
			(4010 ; bkScreen2
				(self
					addPicObj:
						faceScreens
						facePorch
						facePuzzles
						faceMuseum
						faceScreens
				)
			)
			(4011 ; bk1Screen3
				(self
					addPicObj:
						faceScreens
						facePorch
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
						facePorch
						facePuzzles
				)
			)
		)
	)
)

(instance facePuzzles of CameraAngle
	(properties
		heading 270
		picture 4002
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
		(super init: &rest)
	)
)

(instance faceMuseum of CameraAngle
	(properties
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 39)
			(= picture 4017)
		else
			(= picture 4018)
			(door2Museam_0 init:)
		)
		(exitToMuseum init:)
		(gCurRoom exitN: exitToMuseum)
		(super init:)
	)
)

(instance faceScreens of CameraAngle
	(properties
		heading 90
		picture 4019
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

(instance facePorch of CameraAngle
	(properties
		heading 180
		picture 4020
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToPorch init:)
		(gCurRoom exitN: exitToPorch)
		(super init:)
		(doorToPlains_180 init:)
	)
)

(instance exitToPorch of ExitFeature
	(properties
		nsBottom 203
		nsLeft 142
		nsRight 456
		nsTop 62
		nextRoom 4000
		exitStyle 256
	)
)

(instance exitToMuseum of ExitFeature
	(properties
		nsBottom 201
		nsLeft 243
		nsRight 348
		nsTop 58
		nextRoom 4005
	)
)

(instance exitToPuzzle1 of Feature
	(properties
		noun 9
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
		noun 9
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
		noun 9
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
		noun 4
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
				(gCurRoom exitStyle: 256 newRoom: 4009) ; bk1Screen1
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToScreen2 of Feature
	(properties
		noun 5
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
		noun 6
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
				(gCurRoom exitStyle: 256 newRoom: 4011) ; bk1Screen3
			)
			(else
				(super doVerb: theVerb)
			)
		)
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
					init: 167 196 193 119 243 83 293 68 362 86 406 129 426 198
					yourself:
				)
		)
	)
)

(instance door2Museam_0 of Feature
	(properties
		noun 7
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 186 213 191 183 200 61 216 21 209 0 382 1 375 22 390 94 393 93 396 181 404 214
					yourself:
				)
		)
	)
)

