;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7205)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)

(public
	octoMeenie6 0
)

(instance octoMeenie6 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(7203 ; octoMeenie4
				(self addPicObj: facePit faceAtrium facePit)
			)
			(else
				(self addPicObj: faceAtrium facePit faceAtrium)
			)
		)
	)
)

(instance facePit of CameraAngle
	(properties
		picture 7212
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToPitDir init:)
		(gCurRoom exitN: exitToPitDir)
		(super init:)
	)
)

(instance faceAtrium of CameraAngle
	(properties
		heading 180
		picture 7211
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToAtriumDir init:)
		(gCurRoom exitN: exitToAtriumDir)
		(super init:)
	)
)

(instance exitToPitDir of ExitFeature
	(properties
		nsBottom 213
		nsLeft 59
		nsRight 353
		nsTop 137
		nextRoom 7206
	)
)

(instance exitToAtriumDir of ExitFeature
	(properties
		nsBottom 187
		nsLeft 205
		nsRight 397
		nsTop 135
		nextRoom 7203
	)
)

