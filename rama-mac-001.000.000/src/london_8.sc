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
		picture 3116
		heading 180
		edgeN 0
		edgeS 0
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
		edgeN 0
		edgeS 0
	)

	(method (init)
		(northExitToLondon10 init:)
		(super init:)
		(door4_0 init:)
	)
)

(instance southExitToLondon7 of ExitFeature
	(properties
		nsLeft 176
		nsTop 89
		nsRight 442
		nsBottom 184
		nextRoom 3007
		exitStyle 256
	)
)

(instance northExitToLondon10 of ExitFeature
	(properties
		nsLeft 246
		nsTop 39
		nsRight 339
		nsBottom 118
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

