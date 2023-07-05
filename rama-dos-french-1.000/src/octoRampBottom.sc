;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7010)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Feature)

(public
	octoRampBottom 0
)

(instance octoRampBottom of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(7000 ; octoAtriumRamp
				(self addPicObj: facePlatform faceAtrium facePlatform)
			)
			(7011 ; octoPlatformBottom
				(self addPicObj: faceAtrium facePlatform faceAtrium)
			)
			(else
				(self addPicObj: facePlatform faceAtrium facePlatform)
			)
		)
	)
)

(instance facePlatform of CameraAngle
	(properties
		heading 270
		picture 7081
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToPlatform init:)
		(gCurRoom exitN: exitToPlatform)
		(super init:)
		(upRamp init:)
	)
)

(instance faceAtrium of CameraAngle
	(properties
		heading 90
		picture 7082
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToAtrium init:)
		(gCurRoom exitN: exitToAtrium)
		(super init:)
		(entToAtrium init:)
	)
)

(instance exitToAtrium of ExitFeature
	(properties
		nsBottom 194
		nsLeft 174
		nsRight 420
		nsTop 125
		nextRoom 7000
		exitStyle 256
	)
)

(instance exitToPlatform of ExitFeature
	(properties
		nsBottom 149
		nsLeft 181
		nsRight 420
		nsTop 79
		nextRoom 7011
	)
)

(instance upRamp of Feature
	(properties
		noun 26
		nsBottom 149
		nsLeft 181
		nsRight 420
		nsTop 79
		case 4
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 144)
	)
)

(instance entToAtrium of Feature
	(properties
		noun 15
		nsBottom 194
		nsLeft 174
		nsRight 420
		nsTop 125
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 144)
	)
)

