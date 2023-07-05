;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2002)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	baseCamp2 0
)

(instance baseCamp2 of Location
	(properties
		noun 13
	)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(2003 ; baseCamp3
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(else
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
		)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 2006
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(storage_270 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 2008
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(storage_90 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 2007
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(FrameOut)
		(centralPlainExit init:)
		(door_0 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 2005
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(baseCamp3Exit init:)
		(lockers_180 init:)
		(cableCar_180 init:)
	)
)

(instance baseCamp3Exit of ExitFeature
	(properties
		nextRoom 2003
	)
)

(instance centralPlainExit of ExitFeature
	(properties
		nextRoom 2001
		exitStyle 256
	)
)

(instance door_0 of Feature
	(properties
		noun 1
		x 290
		y 144
		nsBottom 288
		nsLeft 208
		nsRight 373
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance storage_270 of Feature
	(properties
		noun 5
		x 274
		y 257
		nsBottom 288
		nsLeft 141
		nsRight 407
		nsTop 227
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance lockers_180 of Feature
	(properties
		noun 6
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 4 1 101 -3 192 46 199 236 163 285 5 285
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 394 47 500 -1 584 0 584 287 443 287 386 239
					yourself:
				)
		)
	)
)

(instance cableCar_180 of Feature
	(properties
		noun 12
		x 294
		y 137
		nsBottom 195
		nsLeft 261
		nsRight 327
		nsTop 79
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance storage_90 of Feature
	(properties
		noun 5
		x 298
		y 242
		nsBottom 286
		nsLeft 163
		nsRight 434
		nsTop 198
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

