;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6512)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)

(public
	mirmicatHall3 0
)

(instance mirmicatHall3 of Location
	(properties
		noun 46
	)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(6511 ; mirmicatHall2
				(self addPicObj: faceE faceW faceE)
			)
			(else
				(self addPicObj: faceW faceE faceW)
			)
		)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 45
		picture 6551
		edgeS 0
		edgeN 0
	)

	(method (init)
		(sessileExit init:)
		(gCurRoom exitN: sessileExit)
		(super init:)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 225
		picture 6552
		edgeS 0
		edgeN 0
	)

	(method (init)
		(elevExit init:)
		(gCurRoom exitN: elevExit)
		(super init:)
	)
)

(instance sessileExit of ExitFeature
	(properties
		nsBottom 258
		nsLeft 220
		nsRight 377
		nsTop 79
		nextRoom 6500
		exitStyle 256
	)
)

(instance elevExit of ExitFeature
	(properties
		nextRoom 6511
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 181 232 196 79 370 73 430 210 402 225
					yourself:
				)
		)
	)
)

