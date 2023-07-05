;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6511)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Feature)

(public
	mirmicatHall2 0
)

(instance mirmicatHall2 of Location
	(properties
		noun 46
	)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(6510 ; mirmicatHall1
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(6513 ; mirmicatHall4
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(else
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 6555
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init:)
		(myrmHead_0 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 6558
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 6512 init:)
		(gCurRoom exitN: defaultExit)
		(super init:)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 6556
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 6513 init:)
		(gCurRoom exitN: defaultExit)
		(super init:)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 6557
		edgeS 0
		edgeN 0
	)

	(method (init)
		(ropeExit init: setHotspot: 2 144)
		(super init:)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance ropeExit of Feature
	(properties
		noun 45
		nsBottom 162
		nsLeft 336
		nsRight 351
		nsTop 17
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom exitStyle: 13)
				(gCurRoom newRoom: 6606) ; avianSchool07
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance myrmHead_0 of Feature
	(properties
		noun 27
		x 299
		y 101
		nsBottom 171
		nsLeft 227
		nsRight 371
		nsTop 31
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

