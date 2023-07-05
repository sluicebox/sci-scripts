;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7102)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)

(public
	octoEenie3 0
)

(instance octoEenie3 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(7103 ; octoEenie4
				(self addPicObj: faceAtrium facePit faceAtrium)
			)
			(else
				(self addPicObj: facePit faceAtrium facePit)
			)
		)
	)
)

(instance facePit of CameraAngle
	(properties
		heading 315
		picture 7106
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
		heading 135
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 180)
			(= picture 7128)
		else
			(= picture 7105)
		)
		(exitToAtriumDir init:)
		(gCurRoom exitN: exitToAtriumDir)
		(super init:)
	)
)

(instance exitToPitDir of ExitFeature
	(properties
		nsBottom 228
		nsLeft 232
		nsRight 510
		nsTop 130
		nextRoom 7103
	)
)

(instance exitToAtriumDir of ExitFeature
	(properties
		nsBottom 215
		nsLeft 147
		nsRight 464
		nsTop 119
		nextRoom 7100
	)
)

