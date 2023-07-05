;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7206)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)

(public
	octoMeenie7 0
)

(instance octoMeenie7 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(7205 ; octoMeenie6
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
		heading 315
		picture 7214
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 184)
			(= picture 7215)
		else
			(= picture 7214)
		)
		(exitToMuseumDir init:)
		(gCurRoom exitNW: exitToMuseumDir)
		(exitToPitDir init:)
		(gCurRoom exitNE: exitToPitDir)
		(super init:)
	)
)

(instance faceAtrium of CameraAngle
	(properties
		heading 135
		picture 7213
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToAtriumDir init:)
		(gCurRoom exitN: exitToAtriumDir)
		(super init:)
	)
)

(instance exitToMuseumDir of ExitFeature
	(properties
		nsBottom 200
		nsLeft 80
		nsRight 170
		nsTop 133
		nextRoom 7208
	)

	(method (doVerb theVerb)
		(if (== theVerb 9)
			(= global164 270)
		)
		(super doVerb: theVerb)
	)
)

(instance exitToPitDir of ExitFeature
	(properties
		nsBottom 192
		nsLeft 226
		nsRight 389
		nsTop 139
		nextRoom 7208
	)

	(method (doVerb theVerb)
		(if (== theVerb 9)
			(= global164 0)
		)
		(super doVerb: theVerb)
	)
)

(instance exitToAtriumDir of ExitFeature
	(properties
		nsBottom 225
		nsLeft 240
		nsRight 530
		nsTop 130
		nextRoom 7205
	)
)

