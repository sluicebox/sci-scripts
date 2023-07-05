;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5302)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use Actor)

(public
	NY_Octospider_Plaza_2 0
)

(instance NY_Octospider_Plaza_2 of Location
	(properties
		noun 1
	)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(5301 ; NY_Octospider_Plaza_1
				(self addPicObj: faceNW faceNE faceSE faceSW faceNW)
			)
			(5303 ; NY_Octospider_Plaza_3
				(self addPicObj: faceNE faceSE faceSW faceNW faceNE)
			)
			(else
				(self addPicObj: faceSE faceSW faceNW faceNE faceSE)
			)
		)
	)
)

(instance faceSE of CameraAngle
	(properties
		heading 225
		picture 5306
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToRoom1 init:)
		(gCurRoom exitN: exitToRoom1)
		(super init:)
	)
)

(instance faceNE of CameraAngle
	(properties
		heading 135
		picture 5307
		edgeS 0
		edgeN 0
	)
)

(instance faceNW of CameraAngle
	(properties
		heading 45
		picture 5308
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(tetraGG init: global117)
	)
)

(instance faceSW of CameraAngle
	(properties
		heading 315
		picture 5305
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToRoom3 init:)
		(gCurRoom exitN: exitToRoom3)
		(super init:)
	)
)

(instance exitToRoom3 of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 5303
	)
)

(instance exitToRoom1 of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 5301
	)
)

(instance tetraGG of View
	(properties
		x 564
		y 255
		view 5300
	)

	(method (init)
		(if (!= (proc70_9 95) gCurRoomNum)
			(return)
		)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 95 0)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

