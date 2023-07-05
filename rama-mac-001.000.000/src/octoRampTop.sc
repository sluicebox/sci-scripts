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
		picture 7087
		heading 270
		edgeN 0
		edgeS 0
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
		picture 7088
		heading 90
		edgeN 0
		edgeS 0
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
		nsLeft 175
		nsTop 122
		nsRight 418
		nsBottom 195
		nextRoom 7013
	)
)

(instance exitToNine of ExitFeature
	(properties
		nsLeft 172
		nsTop 79
		nsRight 421
		nsBottom 150
		nextRoom 7015
	)
)

(instance downRamp of Feature
	(properties
		noun 26
		case 3
		nsLeft 175
		nsTop 122
		nsRight 418
		nsBottom 195
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
		case 4
		nsLeft 172
		nsTop 79
		nsRight 417
		nsBottom 148
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 144)
	)
)

