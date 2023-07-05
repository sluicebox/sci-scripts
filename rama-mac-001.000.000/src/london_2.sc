;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3002)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	london_2 0
)

(instance london_2 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(3003 ; london_3
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
		picture 3007
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(southExitToPorch init:)
		(super init:)
		(door1_180 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 3006
		edgeN 0
		edgeS 0
	)

	(method (init)
		(northExitToLondon3 init:)
		(super init:)
		(door2_0 init:)
	)
)

(instance southExitToPorch of ExitFeature
	(properties
		nextRoom 3001
		exitStyle 256
	)
)

(instance northExitToLondon3 of ExitFeature
	(properties
		nextRoom 3003
		exitStyle 256
	)
)

(instance door2_0 of Feature
	(properties
		noun 5
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 281 98 293 90 341 90 332 107 341 118 335 172 287 172 282 123
					yourself:
				)
		)
	)
)

(instance door1_180 of Feature
	(properties
		noun 6
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 215 156 227 122 280 99 311 98 356 121 375 160
					yourself:
				)
		)
	)
)

