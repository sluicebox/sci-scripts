;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6903)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	mirmicatPoolRm3 0
)

(instance mirmicatPoolRm3 of Location
	(properties
		noun 54
	)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(6904 ; mirmicatPoolRm4
				(self addPicObj: faceSE faceSW faceNW faceNE faceSE)
			)
			(else
				(self addPicObj: faceNW faceNE faceSE faceSW faceNW)
			)
		)
	)
)

(instance faceNW of CameraAngle
	(properties
		picture 6952
		heading 315
		edgeN 0
		edgeS 0
	)

	(method (init)
		(door_315 init:)
		(cond
			((and (not (IsFlag 144)) (not (IsFlag 145)))
				(= picture 6952)
				(pool_315 noun: 50 init:)
			)
			((and (IsFlag 144) (not (IsFlag 145)))
				(= picture 6982)
				(pool_315 noun: 49 init:)
			)
			((and (not (IsFlag 144)) (IsFlag 145))
				(= picture 6952)
				(pool_315 noun: 50 init:)
			)
			(else
				(= picture 6982)
				(pool_315 noun: 49 init:)
			)
		)
		(doorExitN init:)
		(gCurRoom exitN: doorExitN)
		(super init:)
		(myrmSeat_315 init:)
	)
)

(instance faceSE of CameraAngle
	(properties
		picture 6953
		heading 135
		edgeN 0
		edgeS 0
	)

	(method (init)
		(doorExitS init:)
		(gCurRoom exitN: doorExitS)
		(super init:)
		(pool_135 init:)
	)
)

(instance faceSW of CameraAngle
	(properties
		picture 6951
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(cond
			((and (not (IsFlag 144)) (not (IsFlag 145)))
				(= picture 6951)
				(pool_225 noun: 50 init:)
			)
			((and (IsFlag 144) (not (IsFlag 145)))
				(= picture 6981)
				(pool_225 noun: 49 init:)
			)
			((and (not (IsFlag 144)) (IsFlag 145))
				(= picture 6951)
				(pool_225 noun: 50 init:)
			)
			(else
				(= picture 6981)
				(pool_225 noun: 49 init:)
			)
		)
		(super init: &rest)
		(door_225 init:)
		(ramp_225 init:)
		(myrmSeats_225 init:)
		(leftPool_225 init:)
	)
)

(instance faceNE of CameraAngle
	(properties
		picture 6970
		heading 45
		edgeN 0
		edgeS 0
	)
)

(instance doorExitN of ExitFeature
	(properties
		nsLeft 214
		nsTop 88
		nsRight 354
		nsBottom 191
		nextRoom 6904
	)
)

(instance doorExitS of ExitFeature
	(properties
		nsLeft 214
		nsTop 88
		nsRight 354
		nsBottom 191
		nextRoom 6902
	)
)

(instance door_315 of Feature
	(properties
		noun 52
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 233 182 278 91 328 92 365 194
					yourself:
				)
		)
	)
)

(instance pool_315 of Feature
	(properties
		noun 50
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 199 126 186 255 191 300 209 220 247 64 266 -5 266
					yourself:
				)
		)
	)
)

(instance myrmSeat_315 of Feature
	(properties
		noun 24
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 62 277 64 247 87 240 108 254 155 266 161 285 128 292 -1 292 -2 263 39 268 39 279 63 280
					yourself:
				)
		)
	)
)

(instance pool_225 of Feature
	(properties
		noun 49
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 482 200 573 193 590 196 590 265 566 260 481 236 462 210
					yourself:
				)
		)
	)
)

(instance leftPool_225 of Feature
	(properties
		noun 49
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 199 47 198 130 203 130 228 77 247 1 254
					yourself:
				)
		)
	)
)

(instance door_225 of Feature
	(properties
		noun 52
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 261 151 279 122 315 123 327 150
					yourself:
				)
		)
	)
)

(instance ramp_225 of Feature
	(properties
		noun 53
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 90 169 239 155 273 155 346 154 362 202 259 208 181 192 110 185 103 183
					yourself:
				)
		)
	)
)

(instance myrmSeats_225 of Feature
	(properties
		noun 24
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 12 186 104 176 241 189 315 196 367 189 362 179 374 170 408 159 577 185 461 200 470 218 517 230 566 263 589 288 2 287 -1 260 47 236 114 219 151 197 49 191 4 192 4 183 67 180
					yourself:
				)
		)
	)
)

(instance pool_135 of Feature
	(properties
		noun 49
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 319 151 522 186 592 187 591 281 427 259 315 213 305 191
					yourself:
				)
		)
	)
)

