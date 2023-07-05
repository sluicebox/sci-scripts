;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6600)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	avianSchool1 0
)

(instance avianSchool1 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(6601 ; avianSchool02
				(self addPicObj: faceNE faceSW faceNE)
			)
			(else
				(self addPicObj: faceSW faceNE faceSW)
			)
		)
	)
)

(instance faceNE of CameraAngle
	(properties
		picture 6601
		heading 45
		edgeN 0
		edgeS 0
	)

	(method (init)
		(southExitToTunnel init:)
		(gCurRoom exitN: southExitToTunnel)
		(super init:)
		(doorNumbers_45 init:)
	)
)

(instance faceSW of CameraAngle
	(properties
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(= picture
			(switch [global235 1]
				(0 6639)
				(1 6640)
				(3 6640)
				(else 6600)
			)
		)
		(northExitToCatWalk init:)
		(gCurRoom exitN: northExitToCatWalk)
		(super init:)
		(desks_225 init:)
		(podium_225 init:)
		(projector_225 init:)
	)
)

(instance southExitToTunnel of ExitFeature
	(properties
		nsLeft 178
		nsTop 16
		nsRight 432
		nsBottom 271
		nextRoom 6008
		exitStyle 13
	)
)

(instance northExitToCatWalk of ExitFeature
	(properties
		nsLeft 234
		nsTop 105
		nsRight 375
		nsBottom 202
		nextRoom 6601
	)
)

(instance doorNumbers_45 of Feature
	(properties
		noun 55
		nsLeft 252
		nsTop 9
		nsRight 273
		nsBottom 44
		x 262
		y 26
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance desks_225 of Feature
	(properties
		noun 41
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 62 186 107 184 126 161 95 158 67 177
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 81 198 128 164 145 165 136 205 103 216 82 202
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 188 166 173 183 147 211 166 222 195 212 226 172
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 365 171 407 164 430 212 401 217
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 435 168 453 211 476 215 508 205 458 167
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 472 159 520 179 514 197 478 190 468 165
					yourself:
				)
		)
	)
)

(instance podium_225 of Feature
	(properties
		noun 42
		nsLeft 263
		nsTop 84
		nsRight 326
		nsBottom 129
		x 294
		y 106
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance projector_225 of Feature
	(properties
		noun 40
		nsLeft 273
		nsTop 139
		nsRight 316
		nsBottom 174
		x 294
		y 156
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

