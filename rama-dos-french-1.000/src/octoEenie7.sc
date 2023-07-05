;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7106)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)

(public
	octoEenie7 0
)

(instance octoEenie7 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(7105 ; octoEenie6
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
		heading 45
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 193)
			(= picture 7129)
		else
			(= picture 7115)
		)
		(exitToPitDir init:)
		(gCurRoom exitNW: exitToPitDir)
		(exitToAbacusDir init:)
		(gCurRoom exitNE: exitToAbacusDir)
		(super init:)
	)
)

(instance faceAtrium of CameraAngle
	(properties
		heading 225
		picture 7114
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
		nsBottom 190
		nsLeft 200
		nsRight 377
		nsTop 133
		nextRoom 7108
	)

	(method (doVerb theVerb)
		(if (== theVerb 9)
			(= global164 90)
		)
		(super doVerb: theVerb)
	)
)

(instance exitToAbacusDir of ExitFeature
	(properties
		nsBottom 235
		nsLeft 431
		nsRight 501
		nsTop 139
		nextRoom 7108
	)

	(method (doVerb theVerb)
		(if (== theVerb 9)
			(= global164 270)
		)
		(super doVerb: theVerb)
	)
)

(instance exitToAtriumDir of ExitFeature
	(properties
		nsBottom 212
		nsLeft 40
		nsRight 353
		nsTop 134
		nextRoom 7105
	)
)

