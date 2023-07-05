;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7202)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)

(public
	octoMeenie3 0
)

(instance octoMeenie3 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(7200 ; octoMeenieAtrium
				(self addPicObj: facePit faceAtrium facePit)
			)
			(7203 ; octoMeenie4
				(self addPicObj: faceAtrium facePit faceAtrium)
			)
			(else
				(self addPicObj: faceAtrium facePit faceAtrium)
			)
		)
	)
)

(instance facePit of CameraAngle
	(properties
		picture 7206
		heading 45
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToPitDir init:)
		(gCurRoom exitN: exitToPitDir)
		(super init:)
	)
)

(instance faceAtrium of CameraAngle
	(properties
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 181)
			(= picture 7204)
		else
			(= picture 7205)
		)
		(exitToAtriumDir init:)
		(gCurRoom exitN: exitToAtriumDir)
		(super init:)
	)
)

(instance exitToPitDir of ExitFeature
	(properties
		nsLeft 57
		nsTop 134
		nsRight 360
		nsBottom 213
		nextRoom 7203
	)
)

(instance exitToAtriumDir of ExitFeature
	(properties
		nsLeft 192
		nsTop 129
		nsRight 397
		nsBottom 190
		nextRoom 7200
	)
)

