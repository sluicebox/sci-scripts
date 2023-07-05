;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5301)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use Actor)

(public
	NY_Octospider_Plaza_1 0
)

(instance NY_Octospider_Plaza_1 of Location
	(properties
		noun 1
	)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(5302 ; NY_Octospider_Plaza_2
				(self addPicObj: faceSE faceSW faceNW faceNE faceSE)
			)
			(else
				(self addPicObj: faceNW faceNE faceSE faceSW faceNW)
			)
		)
	)
)

(instance faceSE of CameraAngle
	(properties
		picture 5301
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(blueLens init: global117)
		(super init:)
	)
)

(instance faceNE of CameraAngle
	(properties
		picture 5302
		heading 135
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init:)
	)
)

(instance faceNW of CameraAngle
	(properties
		picture 5303
		heading 45
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToNW init:)
		(gCurRoom exitN: exitToNW)
		(super init:)
	)
)

(instance faceSW of CameraAngle
	(properties
		picture 5304
		heading 315
		edgeN 0
		edgeS 0
	)
)

(instance exitToNW of ExitFeature
	(properties
		nsLeft 178
		nsTop 16
		nsRight 432
		nsBottom 271
		nextRoom 5302
	)
)

(instance blueLens of View
	(properties
		x 434
		y 260
		view 5300
		cel 2
	)

	(method (init)
		(if (!= (proc70_9 5) gCurRoomNum)
			(return)
		)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 5 0)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

