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
		picture 4002
		heading 270
		edgeN 0
		edgeS 0
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
		edgeN 0
		edgeS 0
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
		picture 4019
		heading 90
		edgeN 0
		edgeS 0
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
		picture 4020
		heading 180
		edgeN 0
		edgeS 0
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
		nsLeft 142
		nsTop 62
		nsRight 456
		nsBottom 203
		nextRoom 4000
		exitStyle 256
	)
)

(instance exitToMuseum of ExitFeature
	(properties
		nsLeft 243
		nsTop 58
		nsRight 348
		nsBottom 201
		nextRoom 4005
	)
)

(instance exitToPuzzle1 of Feature
	(properties
		noun 9
		nsLeft 41
		nsTop 125
		nsRight 148
		nsBottom 249
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
		nsLeft 256
		nsTop 127
		nsRight 333
		nsBottom 262
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
		nsLeft 437
		nsTop 129
		nsRight 540
		nsBottom 265
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
		nsLeft 11
		nsTop 105
		nsRight 126
		nsBottom 184
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
		nsLeft 178
		nsTop 105
		nsRight 336
		nsBottom 183
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
		nsLeft 398
		nsTop 106
		nsRight 583
		nsBottom 186
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

