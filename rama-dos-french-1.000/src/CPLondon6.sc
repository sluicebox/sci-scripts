;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2065)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	CPLondon6 0
)

(instance CPLondon6 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(SetFlag 51)
		(switch gPrevRoomNum
			(2000 ; cplains
				(self addPicObj: faceSE faceNW faceSE)
			)
			(else
				(self addPicObj: faceNW faceSE faceNW)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 2000) ; cplains
			(= exitStyle 13)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance faceSE of CameraAngle
	(properties
		heading 135
		picture 2314
		edgeS 0
		edgeN 0
	)

	(method (init)
		(fiveExit_135 init:)
		(super init: &rest)
		(london_135 init:)
	)
)

(instance faceNW of CameraAngle
	(properties
		heading 315
		picture 2315
		edgeS 0
		edgeN 0
	)

	(method (init)
		(cplainExit_315 init:)
		(super init: &rest)
		(sea_315 init:)
	)
)

(instance sea_315 of Feature
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
					init: 303 0 436 -1 435 25 446 54 422 62 409 46 385 38 343 45 332 51 314 23
					yourself:
				)
		)
	)
)

(instance london_135 of Feature
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
					init: 166 176 180 163 177 138 181 127 188 97 209 81 209 111 223 112 223 108 236 103 230 99 228 86 235 61 243 55 245 88 259 85 264 38 268 41 268 87 284 87 290 85 288 78 277 78 277 72 290 70 293 17 298 17 298 87 315 79 316 70 334 60 327 33 317 32 317 27 325 27 327 -2 334 -2 332 17 342 16 345 -2 351 -1 349 28 369 33 375 23 438 38 436 17 440 16 443 41 458 43 456 7 463 8 464 44 472 47 463 58 462 65 456 71 468 77 470 83 516 89 518 116 505 119 506 144 554 178 399 182 341 181 301 181
					yourself:
				)
		)
	)
)

(instance cplainExit_315 of ExitFeature
	(properties
		x 294
		y 162
		nsBottom 255
		nsLeft 51
		nsRight 537
		nsTop 70
		nextRoom 2000
	)
)

(instance fiveExit_135 of ExitFeature
	(properties
		x 311
		y 161
		nsBottom 237
		nsLeft 120
		nsRight 503
		nsTop 86
		nextRoom 2064
	)
)

