;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5307)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use Actor)

(public
	NY_Octospider_Plaza_7 0
)

(instance NY_Octospider_Plaza_7 of Location
	(properties
		noun 1
	)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(5306 ; NY_Octospider_Plaza_6
				(self addPicObj: faceSW faceNW faceNE faceSE faceSW)
			)
			(else
				(self addPicObj: faceNE faceSE faceSW faceNW faceNE)
			)
		)
	)
)

(instance faceNE of CameraAngle
	(properties
		picture 5328
		heading 135
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToRoom6 init:)
		(gCurRoom exitN: exitToRoom6)
		(cond
			((IsFlag 241)
				(= picture 5388)
			)
			((IsFlag 240)
				(= picture 5388)
			)
		)
		(super init:)
	)
)

(instance faceSW of CameraAngle
	(properties
		picture 5327
		heading 315
		edgeN 0
		edgeS 0
	)

	(method (init)
		(videoCam init: global117)
		(super init:)
	)
)

(instance faceSE of CameraAngle
	(properties
		picture 5383
		heading 225
		edgeN 0
		edgeS 0
	)
)

(instance faceNW of CameraAngle
	(properties
		picture 5384
		heading 45
		edgeN 0
		edgeS 0
	)
)

(instance exitToRoom6 of ExitFeature
	(properties
		nsLeft 178
		nsTop 16
		nsRight 432
		nsBottom 271
		nextRoom 5306
	)
)

(instance videoCam of View
	(properties
		x 172
		y 268
		view 5300
		cel 4
	)

	(method (init)
		(if (!= (proc70_9 122) gCurRoomNum)
			(return)
		)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 122 0)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

