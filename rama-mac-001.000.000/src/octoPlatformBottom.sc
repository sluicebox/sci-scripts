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
		picture 7091
		heading 270
		edgeN 0
		edgeS 0
	)
)

(instance faceSE of CameraAngle
	(properties
		picture 7083
		heading 90
		edgeN 0
		edgeS 0
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
		nsLeft 317
		nsTop 170
		nsRight 419
		nsBottom 206
		nextRoom 7010
	)
)

(instance exitToTop of ExitFeature
	(properties
		nsLeft 174
		nsTop 99
		nsRight 295
		nsBottom 136
		nextRoom 7012
	)
)

(instance downRamp of Feature
	(properties
		noun 26
		case 3
		nsLeft 317
		nsTop 170
		nsRight 419
		nsBottom 206
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
		nsLeft 174
		nsTop 99
		nsRight 295
		nsBottom 136
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 144)
	)
)

