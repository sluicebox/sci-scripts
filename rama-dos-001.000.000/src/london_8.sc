;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3008)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	london_8 0
)

(instance london_8 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(3020 ; london_10
				(self addPicObj: faceS faceN faceS)
			)
			(else
				(self addPicObj: faceN faceS faceN)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 3116
		edgeS 0
		edgeN 0
	)

	(method (init)
		(southExitToLondon7 init:)
		(super init:)
		(door3Out_180 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 3115
		edgeS 0
		edgeN 0
	)

	(method (init)
		(northExitToLondon10 init:)
		(super init:)
		(door4_0 init:)
	)
)

(instance southExitToLondon7 of ExitFeature
	(properties
		nsBottom 184
		nsLeft 176
		nsRight 442
		nsTop 89
		nextRoom 3007
		exitStyle 256
	)
)

(instance northExitToLondon10 of ExitFeature
	(properties
		nsBottom 118
		nsLeft 246
		nsRight 339
		nsTop 39
		nextRoom 3020
		exitStyle 256
	)
)

(instance door4_0 of Feature
	(properties
		noun 12
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 242 60 271 40 316 38 345 63 341 113 247 112
					yourself:
				)
		)
	)
)

(instance door3Out_180 of Feature
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
					init: 213 161 236 122 273 105 323 101 353 120 378 162
					yourself:
				)
		)
	)
)

