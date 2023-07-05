;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4212)
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
	bk3Museum 0
)

(instance bk3Museum of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(4222 ; bk3MusAntDoor
				(self
					addPicObj:
						faceElev
						faceNE
						faceSE
						faceAnteroom
						faceSW
						faceNW
						faceElev
				)
			)
			(4224 ; bk3MusSWCU1
				(self
					addPicObj:
						faceSW
						faceNW
						faceElev
						faceNE
						faceSE
						faceAnteroom
						faceSW
				)
			)
			(4225 ; bk3MusSWCU2
				(self
					addPicObj:
						faceSW
						faceNW
						faceElev
						faceNE
						faceSE
						faceAnteroom
						faceSW
				)
			)
			(4226 ; bk3MusSWCU3
				(self
					addPicObj:
						faceSW
						faceNW
						faceElev
						faceNE
						faceSE
						faceAnteroom
						faceSW
				)
			)
			(4228 ; bk3MusNWCU1
				(self
					addPicObj:
						faceNW
						faceElev
						faceNE
						faceSE
						faceAnteroom
						faceSW
						faceNW
				)
			)
			(4229 ; bk3MusNWCU2
				(self
					addPicObj:
						faceNW
						faceElev
						faceNE
						faceSE
						faceAnteroom
						faceSW
						faceNW
				)
			)
			(4230 ; bk3MusNWCU3
				(self
					addPicObj:
						faceNW
						faceElev
						faceNE
						faceSE
						faceAnteroom
						faceSW
						faceNW
				)
			)
			(4219 ; bk3MusSECU1
				(self
					addPicObj:
						faceSE
						faceAnteroom
						faceSW
						faceNW
						faceElev
						faceNE
						faceSE
				)
			)
			(4220 ; bk3MusSECU2
				(self
					addPicObj:
						faceSE
						faceAnteroom
						faceSW
						faceNW
						faceElev
						faceNE
						faceSE
				)
			)
			(4221 ; bk3MusSECU3
				(self
					addPicObj:
						faceSE
						faceAnteroom
						faceSW
						faceNW
						faceElev
						faceNE
						faceSE
				)
			)
			(4215 ; bk3MusNECU1
				(self
					addPicObj:
						faceNE
						faceSE
						faceAnteroom
						faceSW
						faceNW
						faceElev
						faceNE
				)
			)
			(4216 ; bk3MusNECU2
				(self
					addPicObj:
						faceNE
						faceSE
						faceAnteroom
						faceSW
						faceNW
						faceElev
						faceNE
				)
			)
			(4217 ; bk3MusNECU3
				(self
					addPicObj:
						faceNE
						faceSE
						faceAnteroom
						faceSW
						faceNW
						faceElev
						faceNE
				)
			)
			(4213 ; bk3MusDeadEnd
				(self
					addPicObj:
						faceElev
						faceNE
						faceSE
						faceAnteroom
						faceSW
						faceNW
						faceElev
				)
			)
			(else
				(self
					addPicObj:
						faceElev
						faceNE
						faceSE
						faceAnteroom
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
		picture 4226
		heading 45
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init:)
		(exitToNECU1 init:)
		(exitToNECU2 init:)
		(exitToNECU3 init:)
	)
)

(instance faceElev of CameraAngle
	(properties
		picture 4225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToDeadEnd init:)
		(gCurRoom exitN: exitToDeadEnd)
		(super init:)
	)
)

(instance faceSE of CameraAngle
	(properties
		picture 4227
		heading 135
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init:)
		(exitToSECU1 init:)
		(exitToSECU2 init:)
		(exitToSECU3 init:)
	)
)

(instance faceNW of CameraAngle
	(properties
		picture 4230
		heading 315
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (== (proc70_9 99) 4212)
			(key2 init: global117)
		)
		(exitToNWCU1 init:)
		(exitToNWCU2 init:)
		(exitToNWCU3 init:)
		(super init:)
		(if (proc1111_24 45)
			(proc1111_31 7)
			(SetFlag 45)
		)
	)
)

(instance faceSW of CameraAngle
	(properties
		picture 4229
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (== (proc70_9 99) 4212)
			(key1 init: global117)
		)
		(exitToSWCU1 init:)
		(exitToSWCU2 init:)
		(exitToSWCU3 init:)
		(super init:)
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
			(= picture 4261)
			(jewel1 init: global117)
		else
			(= picture 4228)
		)
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
		nextRoom 4222
	)
)

(instance exitToDeadEnd of ExitFeature
	(properties
		nsLeft 204
		nsTop 98
		nsRight 385
		nsBottom 189
		nextRoom 4213
	)
)

(instance exitToNWCU1 of Feature
	(properties
		noun 44
		nsLeft 157
		nsTop 90
		nsRight 300
		nsBottom 191
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 4228) ; bk3MusNWCU1
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToNWCU2 of Feature
	(properties
		noun 45
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self
			setHotspot: 2 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 343 152 428 148 428 180 416 178 409 161 401 158 395 167 390 181 342 183
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 4229) ; bk3MusNWCU2
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToNWCU3 of Feature
	(properties
		noun 46
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self
			setHotspot: 2 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 390 185 394 181 395 170 396 164 401 159 410 165 406 169 412 183 416 186 406 189
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 4230) ; bk3MusNWCU3
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToSWCU1 of Feature
	(properties
		noun 47
		nsLeft 182
		nsTop 127
		nsRight 266
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
				(gCurRoom newRoom: 4224) ; bk3MusSWCU1
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToSWCU2 of Feature
	(properties
		noun 48
		nsLeft 294
		nsTop 125
		nsRight 355
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
				(gCurRoom newRoom: 4225) ; bk3MusSWCU2
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToSWCU3 of Feature
	(properties
		noun 49
		nsLeft 391
		nsTop 131
		nsRight 428
		nsBottom 181
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 4226) ; bk3MusSWCU3
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToSECU1 of Feature
	(properties
		noun 50
		nsLeft 149
		nsTop 131
		nsRight 205
		nsBottom 188
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 4219) ; bk3MusSECU1
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToSECU2 of Feature
	(properties
		noun 51
		nsLeft 237
		nsTop 135
		nsRight 332
		nsBottom 190
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 4220) ; bk3MusSECU2
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToSECU3 of Feature
	(properties
		noun 52
		nsLeft 351
		nsTop 118
		nsRight 425
		nsBottom 196
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 4221) ; bk3MusSECU3
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToNECU1 of Feature
	(properties
		noun 53
		nsLeft 153
		nsTop 137
		nsRight 207
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
				(gCurRoom newRoom: 4215) ; bk3MusNECU1
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToNECU2 of Feature
	(properties
		noun 54
		nsLeft 252
		nsTop 134
		nsRight 330
		nsBottom 188
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 4216) ; bk3MusNECU2
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToNECU3 of Feature
	(properties
		noun 55
		nsLeft 357
		nsTop 108
		nsRight 438
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
				(gCurRoom newRoom: 4217) ; bk3MusNECU3
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance key1 of View
	(properties
		x 415
		y 201
		view 4250
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 99)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance key2 of View
	(properties
		x 78
		y 218
		view 4250
		cel 1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 99)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance jewel1 of View
	(properties
		x 295
		y 148
		view 4206
		loop 1
	)

	(method (init)
		(if (or (IsFlag 42) (IsFlag 43) (IsFlag 44))
			(super init: global117 &rest)
		)
	)
)

