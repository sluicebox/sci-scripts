;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3026)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use VMDMovie)
(use Polygon)
(use Feature)
(use Actor)

(public
	london_16 0
)

(instance london_16 of Location
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
		picture 3223
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 3224
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(elevSensor init:)
		(super init:)
		(actuator_270 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 3222
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(eastExitToLondon13 init:)
		(super init:)
		(door_90 init:)
		(elevatorCntrl_90 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 3221
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init:)
		(matrixBox init: global117)
		(pipes_0 init:)
	)
)

(instance eastExitToLondon13 of ExitFeature
	(properties
		nextRoom 3023
		exitStyle 256
	)
)

(instance elevSensor of Feature
	(properties
		nsLeft 263
		nsTop 109
		nsRight 330
		nsBottom 180
	)

	(method (init)
		(super init:)
		(self setHotspot: 140)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(140
				(elevatorLight play:)
				(elevatorDown play:)
				(gCurRoom newRoom: 3033) ; london_18
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance elevatorDown of VMDMovie
	(properties
		movieName 3224
		frameRate 15
		endPic 3924
	)
)

(instance elevatorLight of VMDMovie
	(properties
		movieName 3223
		y 119
		frameRate 15
	)
)

(instance matrixBox of View
	(properties
		x 278
		y 181
		view 3221
	)

	(method (init)
		(if (== (proc70_9 48) 3004)
			(super init: global117)
		)
	)
)

(instance pipes_0 of Feature
	(properties
		noun 15
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 420 168 233 179 217 178 47 174 1 184 -2 145 59 146 62 139 43 89 24 39 40 41 43 55 46 65 121 80 146 95 182 24 322 48 343 62 442 65 421 133 418 167
					yourself:
				)
		)
	)
)

(instance door_90 of Feature
	(properties
		noun 18
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 229 182 246 81 242 65 283 66 284 39 297 37 305 66 339 64 338 79 352 181
					yourself:
				)
		)
	)
)

(instance elevatorCntrl_90 of Feature
	(properties
		noun 20
		nsLeft 62
		nsTop 100
		nsRight 180
		nsBottom 292
		x 121
		y 196
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance actuator_270 of Feature
	(properties
		noun 20
		nsLeft 251
		nsTop 101
		nsRight 341
		nsBottom 195
		x 296
		y 148
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

