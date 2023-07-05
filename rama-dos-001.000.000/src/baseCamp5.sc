;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2005)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use Polygon)
(use Feature)
(use Actor)

(public
	baseCamp5 0
)

(instance baseCamp5 of Location
	(properties
		noun 13
	)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(2003 ; baseCamp3
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(else
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
		)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 2018
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(data_Cube_15 init:)
		(note_From_Nicole init:)
		(table init:)
		(decryptionCard init:)
		(computer_270 init:)
		(labEquip_270 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 2026
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(baseCamp4Exit init:)
		(storage_90 init:)
		(fridge_90 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 2019
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(baseCamp3Exit init:)
		(computer_0 init:)
		(lockers_0 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 2017
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(cableCar_180 init:)
	)
)

(instance baseCamp4Exit of ExitFeature
	(properties
		nextRoom 2004
	)
)

(instance baseCamp3Exit of ExitFeature
	(properties
		nsBottom 241
		nsLeft 353
		nsRight 558
		nsTop 85
		nextRoom 2003
	)
)

(instance data_Cube_15 of View
	(properties
		x 573
		y 215
		loop 7
		view 2102
	)

	(method (init)
		(if (== (proc70_9 28) 2009)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 28)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance note_From_Nicole of View
	(properties
		x 511
		y 230
		loop 8
		view 2102
	)

	(method (init)
		(if (== (proc70_9 82) 2009)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 82)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance decryptionCard of View
	(properties
		x 485
		y 221
		loop 6
		view 2102
	)

	(method (init)
		(if (== (proc70_9 31) 2005)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 31)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance table of Feature
	(properties
		nsBottom 228
		nsLeft 367
		nsRight 577
		nsTop 158
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 50)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(50
				(proc70_3)
				(proc70_10 31 2005)
				(decryptionCard init:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance computer_270 of Feature
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 75 287 56 144 106 69 206 68 229 89 236 276
					yourself:
				)
		)
	)
)

(instance labEquip_270 of Feature
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
					init: 398 164 439 163 442 102 496 98 500 144 519 149 520 168 500 196 429 196
					yourself:
				)
		)
	)
)

(instance computer_0 of Feature
	(properties
		noun 2
		x 247
		y 135
		nsBottom 195
		nsLeft 117
		nsRight 377
		nsTop 75
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
					init: 488 1 590 -1 591 213 479 129
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
					init: 2 199 61 161 73 101 116 76 299 74 357 93 385 111 380 208 109 218 58 275
					yourself:
				)
		)
	)
)

(instance fridge_90 of Feature
	(properties
		noun 11
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 474 201 480 94 563 93 577 123 521 122 515 206 492 219
					yourself:
				)
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
					init: 1 13 29 11 61 121 68 171 123 150 131 253 126 287 1 287
					yourself:
				)
		)
	)
)

