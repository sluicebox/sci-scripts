;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8000)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Feature)

(public
	HumanRamp 0
)

(instance HumanRamp of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(8010 ; HumanWheelRm
				(self addPicObj: faceS faceN faceS)
			)
			(5209 ; humanPlazaRm9
				(self addPicObj: faceN faceS faceN)
			)
			(else
				(self addPicObj: faceN faceS faceN)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		heading 270
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 155)
			(= picture 8071)
		else
			(= picture 8000)
		)
		(defaultExit nextRoom: 8010 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(stairsDown_0 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 90
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 5209 init:)
		(gCurRoom exitN: defaultExit)
		(if (IsFlag 157)
			(= picture 8070)
		else
			(= picture 8001)
		)
		(super init: &rest)
		(stairsUp_180 init:)
	)
)

(instance stairsDown_0 of Feature
	(properties
		noun 2
		nsBottom 268
		nsLeft 229
		nsRight 360
		nsTop 91
		case 1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance stairsUp_180 of Feature
	(properties
		noun 2
		nsBottom 172
		nsLeft 266
		nsRight 345
		nsTop 61
		case 2
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance defaultExit of ExitFeature
	(properties
		exitStyle 256
	)
)

