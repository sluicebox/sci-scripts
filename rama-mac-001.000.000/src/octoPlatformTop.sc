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
		picture 7092
		heading 90
		edgeN 0
		edgeS 0
	)
)

(instance faceNW of CameraAngle
	(properties
		picture 7086
		heading 270
		edgeN 0
		edgeS 0
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
		nsLeft 296
		nsTop 102
		nsRight 485
		nsBottom 155
		nextRoom 7014
	)
)

(instance exitToMiddle of ExitFeature
	(properties
		nsLeft 86
		nsTop 158
		nsRight 293
		nsBottom 214
		nextRoom 7012
	)
)

(instance downRamp of Feature
	(properties
		noun 26
		case 3
		nsLeft 86
		nsTop 158
		nsRight 293
		nsBottom 214
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
		nsLeft 296
		nsTop 102
		nsRight 485
		nsBottom 160
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 144)
	)
)

