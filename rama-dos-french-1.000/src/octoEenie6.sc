;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7105)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)

(public
	octoEenie6 0
)

(instance octoEenie6 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(7103 ; octoEenie4
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
		picture 7113
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
		picture 7112
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
		nsBottom 227
		nsLeft 242
		nsRight 541
		nsTop 130
		nextRoom 7106
	)
)

(instance exitToAtriumDir of ExitFeature
	(properties
		nsBottom 190
		nsLeft 193
		nsRight 391
		nsTop 131
		nextRoom 7103
	)
)

