;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7013)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Feature)

(public
	octoPlatformTop 0
)

(instance octoPlatformTop of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(self addPicObj: faceSE faceNW faceSE)
	)
)

(instance faceSE of CameraAngle
	(properties
		heading 90
		picture 7092
		edgeS 0
		edgeN 0
	)
)

(instance faceNW of CameraAngle
	(properties
		heading 270
		picture 7086
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToTop init:)
		(exitToMiddle init:)
		(gCurRoom exitNE: exitToTop)
		(gCurRoom exitNW: exitToMiddle)
		(super init: &rest)
		(upRamp init:)
		(downRamp init:)
	)
)

(instance exitToTop of ExitFeature
	(properties
		nsBottom 155
		nsLeft 296
		nsRight 485
		nsTop 102
		nextRoom 7014
	)
)

(instance exitToMiddle of ExitFeature
	(properties
		nsBottom 214
		nsLeft 86
		nsRight 293
		nsTop 158
		nextRoom 7012
	)
)

(instance downRamp of Feature
	(properties
		noun 26
		nsBottom 214
		nsLeft 86
		nsRight 293
		nsTop 158
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
		nsBottom 160
		nsLeft 296
		nsRight 485
		nsTop 102
		case 4
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 144)
	)
)

