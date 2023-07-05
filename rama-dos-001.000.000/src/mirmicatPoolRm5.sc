;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6905)
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
	mirmicatPoolRm5 0
)

(instance mirmicatPoolRm5 of Location
	(properties
		noun 54
	)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(6904 ; mirmicatPoolRm4
				(self addPicObj: faceSW faceNW faceNE faceSE faceSW)
			)
			(else
				(self addPicObj: faceNE faceSE faceSW faceNW faceNE)
			)
		)
	)
)

(instance faceNE of CameraAngle
	(properties
		heading 45
		picture 6933
		edgeS 0
		edgeN 0
	)

	(method (init)
		(door_45 init:)
		(cond
			((and (not (IsFlag 144)) (not (IsFlag 145)))
				(= picture 6933)
				(pool_45 noun: 50 init:)
			)
			((and (IsFlag 144) (not (IsFlag 145)))
				(= picture 6978)
				(pool_45 noun: 49 init:)
			)
			((and (not (IsFlag 144)) (IsFlag 145))
				(= picture 6933)
				(pool_45 noun: 50 init:)
			)
			(else
				(= picture 6978)
				(pool_45 noun: 49 init:)
			)
		)
		(doorExitN init:)
		(gCurRoom exitN: doorExitN)
		(super init:)
	)
)

(instance faceSE of CameraAngle
	(properties
		heading 135
		picture 6931
		edgeS 0
		edgeN 0
	)

	(method (init)
		(ramp_135 init:)
		(myrmSeats_135 init:)
		(cond
			((and (not (IsFlag 144)) (not (IsFlag 145)))
				(= picture 6931)
				(rightPool_135 noun: 50 init:)
				(leftPool_135 noun: 50 init:)
			)
			((and (IsFlag 144) (not (IsFlag 145)))
				(= picture 6992)
				(rightPool_135 noun: 50 init:)
				(leftPool_135 noun: 49 init:)
			)
			((and (not (IsFlag 144)) (IsFlag 145))
				(= picture 6993)
				(rightPool_135 noun: 50 init:)
				(leftPool_135 noun: 49 init:)
			)
			(else
				(= picture 6976)
				(rightPool_135 noun: 49 init:)
				(leftPool_135 noun: 49 init:)
			)
		)
		(super init: &rest)
	)
)

(instance faceSW of CameraAngle
	(properties
		heading 225
		picture 6932
		edgeS 0
		edgeN 0
	)

	(method (init)
		(door_225 init:)
		(cond
			((and (not (IsFlag 144)) (not (IsFlag 145)))
				(= picture 6932)
				(pool_225 noun: 50 init:)
			)
			((and (IsFlag 144) (not (IsFlag 145)))
				(= picture 6932)
				(pool_225 noun: 50 init:)
			)
			((and (not (IsFlag 144)) (IsFlag 145))
				(= picture 6977)
				(pool_225 noun: 49 init:)
			)
			(else
				(= picture 6977)
				(pool_225 noun: 49 init:)
			)
		)
		(doorExitS init:)
		(gCurRoom exitN: doorExitS)
		(super init:)
		(if (== (proc70_9 36) 6911)
			(humanKey init: global117)
		)
		(myrmSeat_225 init:)
	)
)

(instance faceNW of CameraAngle
	(properties
		heading 315
		picture 6969
		edgeS 0
		edgeN 0
	)
)

(instance doorExitN of ExitFeature
	(properties
		nsBottom 191
		nsLeft 214
		nsRight 354
		nsTop 88
		nextRoom 6904
	)
)

(instance doorExitS of ExitFeature
	(properties
		nsBottom 191
		nsLeft 214
		nsRight 354
		nsTop 88
		nextRoom 6906
	)
)

(instance humanKey of View
	(properties
		x 81
		y 208
		cel 4
		view 6903
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
					init: 222 178 247 102 295 101 329 185
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
					init: 1 199 86 190 166 189 209 193 232 198 251 212 229 240 139 256 63 257 36 246 25 245 1 257 -1 271
					yourself:
				)
		)
	)
)

(instance myrmSeat_225 of Feature
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
					init: 5 287 5 255 27 245 41 249 50 260 115 266 112 290
					yourself:
				)
		)
	)
)

(instance rightPool_135 of Feature
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
					init: 468 203 509 200 560 200 588 201 592 253 576 235 549 240 549 253 535 244 509 233 497 221 490 216 475 221 475 228 468 218 475 206 495 202
					yourself:
				)
		)
	)
)

(instance leftPool_135 of Feature
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
					init: 0 199 33 200 73 200 89 201 103 205 98 221 87 230 57 237 38 246 26 247 3 242
					yourself:
				)
		)
	)
)

(instance ramp_135 of Feature
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
					init: 215 195 216 153 230 146 268 149 320 148 468 165 469 175 466 186 358 192 324 200 294 200 249 200 218 198
					yourself:
				)
		)
	)
)

(instance myrmSeats_135 of Feature
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
					init: 6 178 122 165 207 164 210 190 339 191 365 178 487 174 567 185 448 205 464 236 476 221 499 226 504 235 530 246 539 257 550 266 551 243 574 238 591 254 590 290 -2 285 0 246 23 240 27 252 52 247 62 234 71 229 80 225 89 219 105 220 113 203 139 209 145 201 127 198 109 199 85 199 54 198 14 195 -1 190 0 184
					yourself:
				)
		)
	)
)

(instance door_45 of Feature
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
					init: 216 192 252 98 315 97 339 177
					yourself:
				)
		)
	)
)

(instance pool_45 of Feature
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
					init: 317 198 387 193 471 189 556 198 591 199 587 279 526 280 458 272 381 253 327 230 316 212 329 191
					yourself:
				)
		)
	)
)

