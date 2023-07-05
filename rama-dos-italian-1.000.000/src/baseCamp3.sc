;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2003)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)

(public
	baseCamp3 0
)

(instance baseCamp3 of Location
	(properties
		noun 13
	)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(2002 ; baseCamp2
				(self addPicObj: faceS faceN faceS)
			)
			(else
				(self addPicObj: faceN faceS faceN)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 2011
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (proc1111_24 95)
			(= showBlack 1)
			(= picture 38910)
		else
			(= picture 2011)
		)
		(super init: &rest)
		(baseCamp2Exit init:)
		(lockers_0 init:)
		(door_0 init:)
		(if (proc1111_24 95)
			(SetFlag 95)
			(gCurRoom drawPic: 38910)
			(FrameOut)
			(Irena_Getting_Cable play:)
		)
	)

	(method (dispose)
		(super dispose:)
		(= showBlack 0)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 2009
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(baseCamp4Exit init:)
		(baseCamp5Exit init:)
		(cableCar_180 init:)
		(storage_180 init:)
		(lockers_180_1 init:)
		(lockers_180_2 init:)
	)
)

(instance baseCamp4Exit of ExitFeature
	(properties
		nsBottom 229
		nsLeft 94
		nsRight 206
		nsTop 94
		nextRoom 2004
	)
)

(instance baseCamp5Exit of ExitFeature
	(properties
		nsBottom 257
		nsLeft 405
		nsRight 526
		nsTop 96
		nextRoom 2005
	)
)

(instance baseCamp2Exit of ExitFeature
	(properties
		nsBottom 246
		nsLeft 209
		nsRight 371
		nsTop 78
		nextRoom 2002
	)
)

(instance Irena_Getting_Cable of VMDMovie
	(properties
		movieName 38911
		endPic 38919
	)
)

(instance door_0 of Feature
	(properties
		noun 1
		x 291
		y 161
		nsBottom 243
		nsLeft 267
		nsRight 315
		nsTop 79
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance lockers_0 of Feature
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
					init: 0 0 169 54 168 280 154 289 4 289
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 415 54 526 -1 586 0 590 289 431 289 408 280
					yourself:
				)
		)
	)
)

(instance lockers_180_1 of Feature
	(properties
		noun 6
		x 40
		y 144
		nsBottom 289
		nsLeft -2
		nsRight 82
		nsTop -1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance lockers_180_2 of Feature
	(properties
		noun 6
		x 541
		y 146
		nsBottom 288
		nsLeft 497
		nsRight 586
		nsTop 4
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance cableCar_180 of Feature
	(properties
		noun 12
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 240 69 303 68 351 148 353 198 332 260 233 266
					yourself:
				)
		)
	)
)

(instance storage_180 of Feature
	(properties
		noun 5
		x 147
		y 168
		nsBottom 184
		nsLeft 98
		nsRight 196
		nsTop 153
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

