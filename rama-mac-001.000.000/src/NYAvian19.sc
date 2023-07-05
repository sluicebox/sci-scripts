;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5019)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)

(public
	NYAvian19 0
)

(instance NYAvian19 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(else
				(self addPicObj: faceSE faceNW faceSE)
			)
		)
	)
)

(instance faceSE of CameraAngle
	(properties
		picture 5064
		heading 135
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 224)
			(= picture 5109)
		else
			(= picture 5064)
		)
		(super init: &rest)
	)
)

(instance faceNW of CameraAngle
	(properties
		picture 5065
		heading 315
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 5017 init:)
		(gCurRoom exitN: defaultExit)
		(if (IsFlag 224)
			(= picture 5110)
		else
			(= picture 5065)
		)
		(super init: &rest)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

