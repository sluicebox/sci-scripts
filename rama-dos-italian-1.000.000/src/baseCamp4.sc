;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2004)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use Polygon)
(use Feature)
(use Actor)

(public
	baseCamp4 0
)

(instance baseCamp4 of Location
	(properties
		noun 13
	)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(2005 ; baseCamp5
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(2008 ; BCCableCar
				(self addPicObj: faceW faceN faceE faceS faceW)
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
		picture 2014
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(baseCamp5Exit init:)
		(computer_270 init:)
		(labEquipment_270 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 2025
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
		picture 2015
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(baseCamp3Exit init:)
		(cable init:)
		(door_0 init:)
		(lockers_0 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 2013
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(exitToHub init:)
		(cableCar_180 init:)
		(basket init:)
		(fridge init: setHotspot: 2 144)
	)
)

(instance baseCamp3Exit of ExitFeature
	(properties
		nsBottom 230
		nsLeft 135
		nsRight 313
		nsTop 67
		nextRoom 2003
	)
)

(instance baseCamp5Exit of ExitFeature
	(properties
		nsBottom 285
		nsLeft 250
		nsRight 520
		nsTop 70
		nextRoom 2005
	)
)

(instance basket of Feature
	(properties
		noun 5
		nsBottom 242
		nsLeft 155
		nsRight 249
		nsTop 188
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2 144 52)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 2007) ; baseCampBasket
			)
			(52
				(gCurRoom newRoom: 2007) ; baseCampBasket
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fridge of Feature
	(properties
		noun 11
		nsBottom 290
		nsLeft 4
		nsRight 106
		nsTop 183
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 2006) ; baseCampFridge
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exitToHub of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 478 290 490 203 459 29 428 159 431 233 447 291
					yourself:
				)
		)
		(super init:)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gCurRoom newRoom: 2008) ; BCCableCar
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lighter of View ; UNUSED
	(properties
		x 321
		y 220
		loop 4
		view 2110
	)

	(method (init)
		(if (== (proc70_9 9) 2004)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 9)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cable of View
	(properties
		x 254
		y 212
		loop 9
		view 2102
	)

	(method (init)
		(if (proc1111_24 95)
			(super init: global117)
		)
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
					init: 451 15 473 2 547 2 568 18 590 122 590 289 444 289 431 215 430 130
					yourself:
				)
		)
	)
)

(instance storage_90 of Feature
	(properties
		noun 5
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 21 87 90 45 355 45 438 80 489 103 482 175 463 252 63 252 15 184
					yourself:
				)
		)
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
					init: 5 0 226 90 228 229 150 288 5 288
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 353 95 412 22 409 286 372 288 352 225
					yourself:
				)
		)
	)
)

(instance door_0 of Feature
	(properties
		noun 1
		x 299
		y 156
		nsBottom 208
		nsLeft 278
		nsRight 321
		nsTop 105
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance computer_270 of Feature
	(properties
		noun 2
		x 208
		y 155
		nsBottom 243
		nsLeft 163
		nsRight 253
		nsTop 67
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance labEquipment_270 of Feature
	(properties
		noun 3
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 360 138 362 126 385 127 387 79 412 79 431 110 433 118 415 119 412 139
					yourself:
				)
		)
	)
)

