;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4012)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	bk1Museum 0
)

(instance bk1Museum of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(4022 ; bk1MusPuzDoor
				(self
					addPicObj:
						faceElev
						faceNE
						faceSE
						facePuzzles
						faceSW
						faceNW
						faceElev
				)
			)
			(4013 ; bk1MusElevDoor
				(self
					addPicObj:
						facePuzzles
						faceSW
						faceNW
						faceElev
						faceNE
						faceSE
						facePuzzles
				)
			)
			(4024 ; bk1MusSWCU1
				(self
					addPicObj:
						faceSW
						faceNW
						faceElev
						faceNE
						faceSE
						facePuzzles
						faceSW
				)
			)
			(4025 ; bk1MusSWCU2
				(self
					addPicObj:
						faceSW
						faceNW
						faceElev
						faceNE
						faceSE
						facePuzzles
						faceSW
				)
			)
			(4026 ; bk1MusSWCU3
				(self
					addPicObj:
						faceSW
						faceNW
						faceElev
						faceNE
						faceSE
						facePuzzles
						faceSW
				)
			)
			(4028 ; bk1MusNWCU1
				(self
					addPicObj:
						faceNW
						faceElev
						faceNE
						faceSE
						facePuzzles
						faceSW
						faceNW
				)
			)
			(4029 ; bk1MusNWCU2
				(self
					addPicObj:
						faceNW
						faceElev
						faceNE
						faceSE
						facePuzzles
						faceSW
						faceNW
				)
			)
			(4019 ; bk1MusSECU1
				(self
					addPicObj:
						faceSE
						facePuzzles
						faceSW
						faceNW
						faceElev
						faceNE
						faceSE
				)
			)
			(4020 ; bk1MusSECU2
				(self
					addPicObj:
						faceSE
						facePuzzles
						faceSW
						faceNW
						faceElev
						faceNE
						faceSE
				)
			)
			(4021 ; bk1MusSECU3
				(self
					addPicObj:
						faceSE
						facePuzzles
						faceSW
						faceNW
						faceElev
						faceNE
						faceSE
				)
			)
			(4015 ; bk1MusNECU1
				(self
					addPicObj:
						faceNE
						faceSE
						facePuzzles
						faceSW
						faceNW
						faceElev
						faceNE
				)
			)
			(4016 ; bk1MusNECU2
				(self
					addPicObj:
						faceNE
						faceSE
						facePuzzles
						faceSW
						faceNW
						faceElev
						faceNE
				)
			)
			(4017 ; bk1MusNECU3
				(self
					addPicObj:
						faceNE
						faceSE
						facePuzzles
						faceSW
						faceNW
						faceElev
						faceNE
				)
			)
			(else
				(self
					addPicObj:
						faceElev
						faceNE
						faceSE
						facePuzzles
						faceSW
						faceNW
						faceElev
				)
			)
		)
	)
)

(instance faceNE of CameraAngle
	(properties
		picture 4027
		heading 45
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToHelmet init:)
		(exitToRocket init:)
		(exitToGlobe init:)
		(super init:)
	)
)

(instance faceElev of CameraAngle
	(properties
		picture 4025
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 36)
			(= picture 4061)
		else
			(= picture 4025)
		)
		(super init:)
		(exitToElev init:)
		(gCurRoom exitN: exitToElev)
		(elev1_0 init:)
	)
)

(instance faceSE of CameraAngle
	(properties
		picture 4029
		heading 135
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToLight init:)
		(exitToChair init:)
		(exitToTool init:)
		(super init:)
	)
)

(instance faceNW of CameraAngle
	(properties
		picture 4026
		heading 315
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToMan init:)
		(exitToWoman init:)
		(super init:)
	)
)

(instance faceSW of CameraAngle
	(properties
		picture 4030
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToGuitar init:)
		(exitToFrame init:)
		(exitToHolo init:)
		(super init:)
	)
)

(instance facePuzzles of CameraAngle
	(properties
		picture 4028
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToPuzzles init:)
		(gCurRoom exitN: exitToPuzzles)
		(super init:)
		(door2CntOut_180 init:)
	)
)

(instance exitToPuzzles of ExitFeature
	(properties
		nsLeft 204
		nsTop 98
		nsRight 385
		nsBottom 189
		nextRoom 4022
	)
)

(instance exitToElev of ExitFeature
	(properties
		nsLeft 204
		nsTop 98
		nsRight 385
		nsBottom 189
		nextRoom 4013
	)
)

(instance exitToMan of Feature
	(properties
		noun 10
		nsLeft 194
		nsTop 86
		nsRight 246
		nsBottom 182
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 4028) ; bk1MusNWCU1
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToWoman of Feature
	(properties
		noun 11
		nsLeft 326
		nsTop 86
		nsRight 387
		nsBottom 182
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 4029) ; bk1MusNWCU2
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToGuitar of Feature
	(properties
		noun 12
		nsLeft 193
		nsTop 120
		nsRight 253
		nsBottom 182
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 4024) ; bk1MusSWCU1
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToFrame of Feature
	(properties
		noun 13
		nsLeft 298
		nsTop 125
		nsRight 350
		nsBottom 178
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 4025) ; bk1MusSWCU2
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToHolo of Feature
	(properties
		noun 14
		nsLeft 389
		nsTop 138
		nsRight 431
		nsBottom 177
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 4026) ; bk1MusSWCU3
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToLight of Feature
	(properties
		noun 15
		nsLeft 158
		nsTop 145
		nsRight 206
		nsBottom 186
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 4019) ; bk1MusSECU1
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToChair of Feature
	(properties
		noun 16
		nsLeft 252
		nsTop 135
		nsRight 309
		nsBottom 184
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 144 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 4020) ; bk1MusSECU2
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToTool of Feature
	(properties
		noun 17
		nsLeft 363
		nsTop 139
		nsRight 418
		nsBottom 184
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 144 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 4021) ; bk1MusSECU3
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToHelmet of Feature
	(properties
		noun 18
		nsLeft 155
		nsTop 137
		nsRight 196
		nsBottom 189
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 144 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 4015) ; bk1MusNECU1
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToRocket of Feature
	(properties
		noun 19
		nsLeft 251
		nsTop 136
		nsRight 325
		nsBottom 189
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 144 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 4016) ; bk1MusNECU2
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToGlobe of Feature
	(properties
		noun 20
		nsLeft 361
		nsTop 107
		nsRight 428
		nsBottom 186
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 144 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 4017) ; bk1MusNECU3
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance elev1_0 of Feature
	(properties
		noun 21
		nsLeft 262
		nsTop 99
		nsRight 332
		nsBottom 170
		x 297
		y 134
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance door2CntOut_180 of Feature
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
					init: 251 172 262 89 325 90 337 171
					yourself:
				)
		)
	)
)

