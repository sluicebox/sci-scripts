;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3060)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use SoundManager)
(use Polygon)
(use Feature)

(public
	london_30 0
)

(instance london_30 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(3062 ; london_32
				(self addPicObj: faceE faceW faceE)
			)
			(else
				(SoundManager fadeMusic: 0 20 8 1 0 playMusic: 0 -1 3020)
				(self addPicObj: faceW faceE faceW)
			)
		)
	)

	(method (dispose)
		(if (== picObj faceE)
			(SoundManager fadeMusic: 0 20 8 1 0 playMusic: 0 -1 3010 3000)
		)
		(super dispose: &rest)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 3327
		edgeS 0
		edgeN 0
	)

	(method (init)
		(eastExitToLondon12 init:)
		(super init:)
		(biotDispDoorOut_90 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 3326
		edgeS 0
		edgeN 0
	)

	(method (init)
		(westExitToLondon32 init:)
		(super init:)
		(biotDDoor2_270 init:)
	)
)

(instance eastExitToLondon12 of ExitFeature
	(properties
		nsBottom 184
		nsLeft 157
		nsRight 436
		nsTop 65
		nextRoom 3022
		exitStyle 256
	)
)

(instance westExitToLondon32 of ExitFeature
	(properties
		nsBottom 177
		nsLeft 213
		nsRight 375
		nsTop 81
		nextRoom 3062
		exitStyle 256
	)
)

(instance biotDispDoorOut_90 of Feature
	(properties
		noun 22
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 215 160 235 118 282 93 310 99 357 117 382 163
					yourself:
				)
		)
	)
)

(instance biotDDoor2_270 of Feature
	(properties
		noun 23
		x 296
		y 121
		nsBottom 138
		nsLeft 279
		nsRight 314
		nsTop 104
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

