;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5021)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Feature)

(public
	NYAvian21 0
)

(instance NYAvian21 of Location
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(faceSW up: faceUp)
		(faceUp down: faceSW)
		(switch gPrevRoomNum
			(5017 ; NYAvian17
				(self addPicObj: faceSW faceNW faceNE faceSE faceSW)
			)
			(else
				(self addPicObj: faceSE faceSW faceNW faceNE faceSE)
			)
		)
	)
)

(instance faceNE of CameraAngle
	(properties
		picture 5068
		heading 45
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance faceSE of CameraAngle
	(properties
		picture 5072
		heading 135
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance faceSW of CameraAngle
	(properties
		picture 5070
		heading 225
		edgeS 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance faceNW of CameraAngle
	(properties
		picture 5069
		heading 315
		edgeN 0
		edgeS 0
	)

	(method (init)
		(switch ((ScriptID 201 0) curAPRampPosition:) ; newYorkRegion
			(1
				(= picture 5122)
			)
			(2
				(= picture 5121)
			)
			(3
				(= picture 5069)
			)
			(4
				(= picture 5120)
			)
			(5
				(= picture 5119)
			)
		)
		(defaultExit nextRoom: 5023 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(ramp_315 init:)
		(tuningFork_315 init:)
	)
)

(instance faceUp of CameraAngle
	(properties
		picture 5071
		heading 225
		edgeN 0
		edgeE 0
		edgeW 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance ramp_315 of Feature
	(properties
		noun 23
		nsLeft -1
		nsTop 116
		nsRight 190
		nsBottom 225
		x 94
		y 170
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance tuningFork_315 of Feature
	(properties
		noun 26
		nsLeft 189
		nsTop 157
		nsRight 218
		nsBottom 188
		x 203
		y 172
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

