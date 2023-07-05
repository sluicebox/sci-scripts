;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3033)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use VMDMovie)
(use Feature)

(public
	london_18 0
)

(instance london_18 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(3040 ; london_20
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(else
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 3960
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init:)
		(southExitToLondon20 init:)
		(drain_180 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 3924
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init:)
		(elevSensor init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 3952
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 3951
		edgeS 0
		edgeN 0
	)
)

(instance southExitToLondon20 of ExitFeature
	(properties
		nextRoom 3040
		exitStyle 256
	)
)

(instance elevSensor of Feature
	(properties
		nsBottom 180
		nsLeft 263
		nsRight 330
		nsTop 109
	)

	(method (init)
		(super init:)
		(self setHotspot: 140 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(140
				(elevatorLight play:)
				(elevatorUp play:)
				(gCurRoom newRoom: 3026) ; london_16
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance elevatorUp of VMDMovie
	(properties
		movieName 3225
		frameRate 15
		endPic 3224
	)
)

(instance elevatorLight of VMDMovie
	(properties
		y 119
		movieName 3223
		frameRate 15
	)
)

(instance actuator_270 of Feature ; UNUSED
	(properties
		noun 20
		x 292
		y 146
		nsBottom 197
		nsLeft 240
		nsRight 344
		nsTop 95
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance drain_180 of Feature
	(properties
		noun 33
		x 283
		y 138
		nsBottom 175
		nsLeft 251
		nsRight 316
		nsTop 101
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

