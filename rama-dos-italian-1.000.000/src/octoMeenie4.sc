;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7203)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)

(public
	octoMeenie4 0
)

(instance octoMeenie4 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(7202 ; octoMeenie3
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
		picture 7208
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
		picture 7207
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
		nsBottom 192
		nsLeft 199
		nsRight 388
		nsTop 139
		nextRoom 7205
	)
)

(instance exitToAtriumDir of ExitFeature
	(properties
		nsBottom 229
		nsLeft 242
		nsRight 528
		nsTop 130
		nextRoom 7202
	)
)

