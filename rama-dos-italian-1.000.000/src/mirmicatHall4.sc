;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6513)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)

(public
	mirmicatHall4 0
)

(instance mirmicatHall4 of Location
	(properties
		noun 46
	)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(6511 ; mirmicatHall2
				(self addPicObj: faceW faceE faceW)
			)
			(else
				(self addPicObj: faceE faceW faceE)
			)
		)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 315
		picture 6554
		edgeS 0
		edgeN 0
	)

	(method (init)
		(feedingPoolExit init:)
		(gCurRoom exitN: feedingPoolExit)
		(super init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 135
		picture 6553
		edgeS 0
		edgeN 0
	)

	(method (init)
		(elevExit init:)
		(gCurRoom exitN: elevExit)
		(super init:)
	)
)

(instance feedingPoolExit of ExitFeature
	(properties
		nsBottom 200
		nsLeft 244
		nsRight 358
		nsTop 83
		nextRoom 6902
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
					init: 147 204 132 170 207 34 388 42 446 138 408 206
					yourself:
				)
		)
	)
)

