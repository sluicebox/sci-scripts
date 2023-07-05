;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4112)
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
	bk2Museum 0
)

(instance bk2Museum of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(4113 ; bk2MusElevDoor
				(self
					addPicObj:
						faceAnteroom
						faceNE
						faceSE
						faceElev
						faceSW
						faceNW
						faceAnteroom
				)
			)
			(4122 ; bk2MusAntDoor
				(self
					addPicObj:
						faceElev
						faceSW
						faceNW
						faceAnteroom
						faceNE
						faceSE
						faceElev
				)
			)
			(4124 ; bk2MusSWCU1
				(self
					addPicObj:
						faceSW
						faceNW
						faceAnteroom
						faceNE
						faceSE
						faceElev
						faceSW
				)
			)
			(4125 ; bk2MusSWCU2
				(self
					addPicObj:
						faceSW
						faceNW
						faceAnteroom
						faceNE
						faceSE
						faceElev
						faceSW
				)
			)
			(4126 ; bk2MusSWCU3
				(self
					addPicObj:
						faceSW
						faceNW
						faceAnteroom
						faceNE
						faceSE
						faceElev
						faceSW
				)
			)
			(4128 ; bk2MusNWCU1
				(self
					addPicObj:
						faceNW
						faceAnteroom
						faceNE
						faceSE
						faceElev
						faceSW
						faceNW
				)
			)
			(4129 ; bk2MusNWCU2
				(self
					addPicObj:
						faceNW
						faceAnteroom
						faceNE
						faceSE
						faceElev
						faceSW
						faceNW
				)
			)
			(4130 ; bk2MusNWCU3
				(self
					addPicObj:
						faceNW
						faceAnteroom
						faceNE
						faceSE
						faceElev
						faceSW
						faceNW
				)
			)
			(4119 ; bk2MusSECU1
				(self
					addPicObj:
						faceSE
						faceElev
						faceSW
						faceNW
						faceAnteroom
						faceNE
						faceSE
				)
			)
			(4120 ; bk2MusSECU2
				(self
					addPicObj:
						faceSE
						faceElev
						faceSW
						faceNW
						faceAnteroom
						faceNE
						faceSE
				)
			)
			(4121 ; bk2MusSECU3
				(self
					addPicObj:
						faceSE
						faceElev
						faceSW
						faceNW
						faceAnteroom
						faceNE
						faceSE
				)
			)
			(4136 ; bk2MusSECU4
				(self
					addPicObj:
						faceSE
						faceElev
						faceSW
						faceNW
						faceAnteroom
						faceNE
						faceSE
				)
			)
			(4115 ; bk2MusNECU1
				(self
					addPicObj:
						faceNE
						faceSE
						faceElev
						faceSW
						faceNW
						faceAnteroom
						faceNE
				)
			)
			(4116 ; bk2MusNECU2
				(self
					addPicObj:
						faceNE
						faceSE
						faceElev
						faceSW
						faceNW
						faceAnteroom
						faceNE
				)
			)
			(4117 ; bk2MusNECU3
				(self
					addPicObj:
						faceNE
						faceSE
						faceElev
						faceSW
						faceNW
						faceAnteroom
						faceNE
				)
			)
			(else
				(self
					addPicObj:
						faceAnteroom
						faceNE
						faceSE
						faceElev
						faceSW
						faceNW
						faceAnteroom
				)
			)
		)
	)
)

(instance faceNE of CameraAngle
	(properties
		picture 4130
		heading 45
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToNECU1 init:)
		(exitToNECU2 init:)
		(exitToNECU3 init:)
		(super init:)
	)
)

(instance faceElev of CameraAngle
	(properties
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 37)
			(if
				(and
					(!= (proc70_9 41) 4008)
					(!= (proc70_9 42) 4008)
					(!= (proc70_9 43) 4008)
				)
				(jewel1 init: global117)
				(jewel2 init: global117)
				(jewel3 init: global117)
				(= picture 4165)
			else
				(= picture 4169)
			)
		else
			(= picture 4125)
		)
		(super init:)
		(exitToElev init:)
		(gCurRoom exitN: exitToElev)
	)
)

(instance faceSE of CameraAngle
	(properties
		picture 4126
		heading 135
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToSECU1 init:)
		(exitToSECU2 init:)
		(exitToSECU3 init:)
		(exitToSECU4 init:)
		(super init:)
	)
)

(instance faceNW of CameraAngle
	(properties
		picture 4129
		heading 315
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToNWCU1 init:)
		(exitToNWCU2 init:)
		(exitToNWCU3 init:)
		(super init:)
	)
)

(instance faceSW of CameraAngle
	(properties
		picture 4127
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToSWCU1 init:)
		(exitToSWCU2 init:)
		(exitToSWCU3 init:)
		(super init:)
	)
)

(instance faceAnteroom of CameraAngle
	(properties
		picture 4128
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToAnteroom init:)
		(gCurRoom exitN: exitToAnteroom)
		(super init:)
	)
)

(instance exitToAnteroom of ExitFeature
	(properties
		nsLeft 204
		nsTop 98
		nsRight 385
		nsBottom 189
		nextRoom 4122
	)
)

(instance exitToElev of ExitFeature
	(properties
		nsLeft 204
		nsTop 98
		nsRight 385
		nsBottom 189
		nextRoom 4113
	)
)

(instance exitToNWCU1 of Feature
	(properties
		noun 34
		nsLeft 157
		nsTop 123
		nsRight 210
		nsBottom 187
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 4128) ; bk2MusNWCU1
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToNWCU2 of Feature
	(properties
		noun 35
		nsLeft 249
		nsTop 132
		nsRight 316
		nsBottom 184
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 4129) ; bk2MusNWCU2
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToNWCU3 of Feature
	(properties
		noun 36
		nsLeft 367
		nsTop 135
		nsRight 413
		nsBottom 189
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 4130) ; bk2MusNWCU3
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToSWCU1 of Feature
	(properties
		noun 37
		nsLeft 155
		nsTop 137
		nsRight 199
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
				(gCurRoom newRoom: 4124) ; bk2MusSWCU1
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToSWCU2 of Feature
	(properties
		noun 38
		nsLeft 248
		nsTop 136
		nsRight 325
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
				(gCurRoom newRoom: 4125) ; bk2MusSWCU2
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToSWCU3 of Feature
	(properties
		noun 39
		nsLeft 357
		nsTop 105
		nsRight 437
		nsBottom 183
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 4126) ; bk2MusSWCU3
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToSECU1 of Feature
	(properties
		noun 27
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self
			setHotspot: 2 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 199 101 208 101 219 110 215 114 222 125 237 150 228 147 224 153 215 149 216 163 221 175 220 190 206 190 199 166 193 164 204 137 205 117 200 101
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 4119) ; bk2MusSECU1
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToSECU2 of Feature
	(properties
		noun 28
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self
			setHotspot: 2 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 193 159 181 156 178 138 164 125 168 103 182 85 208 71 232 70 253 75 280 108 282 125 270 141 269 156 244 169 214 95 201 99 195 160
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 4120) ; bk2MusSECU2
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToSECU3 of Feature
	(properties
		noun 29
		nsLeft 332
		nsTop 134
		nsRight 375
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
				(gCurRoom newRoom: 4121) ; bk2MusSECU3
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToSECU4 of Feature
	(properties
		noun 30
		nsLeft 388
		nsTop 137
		nsRight 423
		nsBottom 194
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 4136) ; bk2MusSECU4
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToNECU1 of Feature
	(properties
		noun 31
		nsLeft 197
		nsTop 139
		nsRight 250
		nsBottom 187
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 4115) ; bk2MusNECU1
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToNECU2 of Feature
	(properties
		noun 32
		nsLeft 297
		nsTop 129
		nsRight 351
		nsBottom 183
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 4116) ; bk2MusNECU2
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToNECU3 of Feature
	(properties
		noun 33
		nsLeft 393
		nsTop 138
		nsRight 427
		nsBottom 180
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 4117) ; bk2MusNECU3
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance jewel1 of View
	(properties
		x 294
		y 149
		view 4105
		cel 2
	)

	(method (init)
		(if (IsFlag 42)
			(super init: global117 &rest)
		)
	)
)

(instance jewel2 of View
	(properties
		x 296
		y 149
		view 4105
		cel 1
	)

	(method (init)
		(if (IsFlag 43)
			(super init: global117 &rest)
		)
	)
)

(instance jewel3 of View
	(properties
		x 295
		y 147
		view 4105
	)

	(method (init)
		(if (IsFlag 44)
			(super init: global117 &rest)
		)
	)
)

