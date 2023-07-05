;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7907)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	octoSubwayCarLarge 0
)

(instance octoSubwayCarLarge of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(7908 ; octoSubwaySmall
				(self addPicObj: faceCar faceStation faceCar)
			)
			(7906 ; octoSubStation
				(self addPicObj: faceCar faceStation faceCar)
			)
			(else
				(self addPicObj: faceStation faceCar faceStation)
			)
		)
	)
)

(instance faceCar of CameraAngle
	(properties
		heading 270
		picture 7929
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToLargeCar init:)
		(gCurRoom exitN: exitToLargeCar)
		(super init: &rest)
		(LSUBWAY_270 init:)
	)
)

(instance faceStation of CameraAngle
	(properties
		heading 90
		picture 7939
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToStation init:)
		(gCurRoom exitNW: exitToStation)
		(exitToSmallCar init:)
		(gCurRoom exitNE: exitToSmallCar)
		(super init:)
	)
)

(instance exitToStation of ExitFeature
	(properties
		nsBottom 266
		nsLeft 40
		nsRight 179
		nsTop 144
		nextRoom 7906
	)
)

(instance exitToSmallCar of ExitFeature
	(properties
		nsBottom 219
		nsLeft 477
		nsRight 552
		nsTop 162
		nextRoom 7908
	)
)

(instance exitToLargeCar of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 7910
	)
)

(instance LSUBWAY_270 of Feature
	(properties
		noun 63
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 154 99 186 -1 481 2 483 113 430 227 305 284 190 226 156 98
					yourself:
				)
		)
	)
)

