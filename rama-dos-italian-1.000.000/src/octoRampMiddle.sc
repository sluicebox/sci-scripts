;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7012)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Feature)

(public
	octoRampMiddle 0
)

(instance octoRampMiddle of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(7011 ; octoPlatformBottom
				(self addPicObj: faceTop faceBottom faceTop)
			)
			(7013 ; octoPlatformTop
				(self addPicObj: faceBottom faceTop faceBottom)
			)
			(else
				(self addPicObj: faceTop faceBottom faceTop)
			)
		)
	)
)

(instance faceTop of CameraAngle
	(properties
		heading 90
		picture 7085
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToTop init:)
		(gCurRoom exitN: exitToTop)
		(super init:)
		(upRamp init:)
	)
)

(instance faceBottom of CameraAngle
	(properties
		heading 270
		picture 7084
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToBottom init:)
		(gCurRoom exitN: exitToBottom)
		(super init:)
		(downRamp init:)
	)
)

(instance exitToTop of ExitFeature
	(properties
		nsBottom 148
		nsLeft 172
		nsRight 417
		nsTop 79
		nextRoom 7013
	)
)

(instance exitToBottom of ExitFeature
	(properties
		nsBottom 193
		nsLeft 175
		nsRight 417
		nsTop 122
		nextRoom 7011
	)
)

(instance downRamp of Feature
	(properties
		noun 26
		nsBottom 193
		nsLeft 176
		nsRight 417
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

