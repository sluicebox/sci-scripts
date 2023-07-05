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
		picture 7085
		heading 90
		edgeN 0
		edgeS 0
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
		picture 7084
		heading 270
		edgeN 0
		edgeS 0
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
		nsLeft 172
		nsTop 79
		nsRight 417
		nsBottom 148
		nextRoom 7013
	)
)

(instance exitToBottom of ExitFeature
	(properties
		nsLeft 175
		nsTop 122
		nsRight 417
		nsBottom 193
		nextRoom 7011
	)
)

(instance downRamp of Feature
	(properties
		noun 26
		case 3
		nsLeft 176
		nsTop 122
		nsRight 417
		nsBottom 193
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

