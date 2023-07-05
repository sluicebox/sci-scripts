;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3020)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use Polygon)
(use Feature)

(public
	london_10 0
)

(instance london_10 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(if (== (proc70_9 34) -1)
			(proc70_10 34 2006)
		)
		(switch gPrevRoomNum
			(3008 ; london_8
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(3021 ; london_11
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(3027 ; london_17
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(else
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 3203
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(southExitToLondon8 init:)
		(super init:)
		(door4Out_180 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 3204
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 100)
			(= picture 3204)
		)
		(westExitToLondon11 init:)
		(super init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 3202
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(eastExitToLondon15 init:)
		(super init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 3201
		edgeN 0
		edgeS 0
	)

	(method (init)
		(northExitToLondon17 init:)
		(super init:)
		(pit_0 init:)
	)
)

(instance southExitToLondon8 of ExitFeature
	(properties
		nsLeft 176
		nsTop 6
		nsRight 426
		nsBottom 252
		nextRoom 3008
		exitStyle 256
	)
)

(instance northExitToLondon17 of ExitFeature
	(properties
		nsLeft 185
		nsTop 57
		nsRight 413
		nsBottom 220
		nextRoom 3027
	)
)

(instance eastExitToLondon15 of ExitFeature
	(properties
		nextRoom 3025
	)
)

(instance westExitToLondon11 of ExitFeature
	(properties
		nextRoom 3021
	)
)

(instance pit_0 of Feature
	(properties
		noun 13
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 5 159 296 153 589 162 585 201 485 196 465 206 388 198 328 183 238 185 204 194 80 202 73 193 1 199
					yourself:
				)
		)
	)
)

(instance door4Out_180 of Feature
	(properties
		noun 14
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 122 250 131 210 145 195 160 0 428 -1 439 197 456 215 460 253
					yourself:
				)
		)
	)
)

