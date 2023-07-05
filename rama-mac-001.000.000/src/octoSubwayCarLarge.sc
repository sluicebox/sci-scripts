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
		picture 7929
		heading 270
		edgeN 0
		edgeS 0
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
		picture 7939
		heading 90
		edgeN 0
		edgeS 0
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
		nsLeft 40
		nsTop 144
		nsRight 179
		nsBottom 266
		nextRoom 7906
	)
)

(instance exitToSmallCar of ExitFeature
	(properties
		nsLeft 477
		nsTop 162
		nsRight 552
		nsBottom 219
		nextRoom 7908
	)
)

(instance exitToLargeCar of ExitFeature
	(properties
		nsLeft 178
		nsTop 16
		nsRight 432
		nsBottom 271
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

