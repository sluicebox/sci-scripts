;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7015)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use SoundManager)
(use Feature)

(public
	octoRampGate 0
)

(instance octoRampGate of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(7014 ; octoRampTop
				(self addPicObj: faceGate faceRamp faceGate)
			)
			(else
				(SoundManager fadeMusic: 0 20 8 1 0 playMusic: 0 -1 7150)
				(self addPicObj: faceRamp faceGate faceRamp)
			)
		)
	)
)

(instance faceGate of CameraAngle
	(properties
		heading 270
		picture 7089
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToGate init:)
		(gCurRoom exitN: exitToGate)
		(super init:)
		(gateToPlaza init:)
	)
)

(instance faceRamp of CameraAngle
	(properties
		heading 90
		picture 7090
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToRamp init:)
		(gCurRoom exitN: exitToRamp)
		(super init:)
		(downRamp init:)
	)
)

(instance exitToGate of ExitFeature
	(properties
		nsBottom 241
		nsLeft 181
		nsRight 393
		nsTop 53
		nextRoom 5327
	)
)

(instance gateToPlaza of Feature
	(properties
		noun 12
		nsBottom 241
		nsLeft 181
		nsRight 393
		nsTop 53
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 144)
	)
)

(instance exitToRamp of ExitFeature
	(properties
		nsBottom 193
		nsLeft 176
		nsRight 417
		nsTop 122
		nextRoom 7014
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

