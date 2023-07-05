;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7014)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Feature)

(public
	octoRampTop 0
)

(instance octoRampTop of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(7013 ; octoPlatformTop
				(self addPicObj: faceGate facePlatform faceGate)
			)
			(7015 ; octoRampGate
				(self addPicObj: facePlatform faceGate facePlatform)
			)
			(else
				(self addPicObj: faceGate facePlatform faceGate)
			)
		)
	)
)

(instance faceGate of CameraAngle
	(properties
		heading 270
		picture 7087
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToNine init:)
		(gCurRoom exitN: exitToNine)
		(super init:)
		(upRamp init:)
	)
)

(instance facePlatform of CameraAngle
	(properties
		heading 90
		picture 7088
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToPlatform init:)
		(gCurRoom exitN: exitToPlatform)
		(super init:)
		(downRamp init:)
	)
)

(instance exitToPlatform of ExitFeature
	(properties
		nsBottom 195
		nsLeft 175
		nsRight 418
		nsTop 122
		nextRoom 7013
	)
)

(instance exitToNine of ExitFeature
	(properties
		nsBottom 150
		nsLeft 172
		nsRight 421
		nsTop 79
		nextRoom 7015
	)
)

(instance downRamp of Feature
	(properties
		noun 26
		nsBottom 195
		nsLeft 175
		nsRight 418
		nsTop 122
		case 3
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 144)
	)
)

(instance upRamp of Feature
	(properties
		noun 26
		nsBottom 148
		nsLeft 172
		nsRight 417
		nsTop 79
		case 4
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 144)
	)
)

