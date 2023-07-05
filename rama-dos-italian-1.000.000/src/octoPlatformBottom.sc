;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7011)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Feature)

(public
	octoPlatformBottom 0
)

(instance octoPlatformBottom of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(self addPicObj: faceNW faceSE faceNW)
	)
)

(instance faceNW of CameraAngle
	(properties
		heading 270
		picture 7091
		edgeS 0
		edgeN 0
	)
)

(instance faceSE of CameraAngle
	(properties
		heading 90
		picture 7083
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToBottom init:)
		(gCurRoom exitNW: exitToBottom)
		(upRamp init:)
		(downRamp init:)
		(exitToTop init:)
		(gCurRoom exitNE: exitToTop)
		(super init:)
	)
)

(instance exitToBottom of ExitFeature
	(properties
		nsBottom 206
		nsLeft 317
		nsRight 419
		nsTop 170
		nextRoom 7010
	)
)

(instance exitToTop of ExitFeature
	(properties
		nsBottom 136
		nsLeft 174
		nsRight 295
		nsTop 99
		nextRoom 7012
	)
)

(instance downRamp of Feature
	(properties
		noun 26
		nsBottom 206
		nsLeft 317
		nsRight 419
		nsTop 170
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
		nsBottom 136
		nsLeft 174
		nsRight 295
		nsTop 99
		case 4
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 144)
	)
)

