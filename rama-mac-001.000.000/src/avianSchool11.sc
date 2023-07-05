;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6610)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)
(use System)

(public
	avianSchool11 0
)

(instance avianSchool11 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(6607 ; avianSchool08
				(self addPicObj: faceW faceE faceW)
			)
			(else
				(self addPicObj: faceE faceW faceE)
			)
		)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 6638
		heading 315
		edgeN 0
		edgeS 0
	)

	(method (init)
		(rampExitE init:)
		(gCurRoom exitN: rampExitE)
		(super init:)
		(desks_315 init:)
		(ramp_315 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 6637
		heading 135
		edgeN 0
		edgeS 0
	)

	(method (init &tmp temp0)
		(= picture
			(switch (= temp0 [global235 1])
				(0 6657)
				(1 6658)
				(3 6658)
				(else 6637)
			)
		)
		(if (OneOf temp0 3 1)
			(rampExitW init:)
			(gCurRoom exitN: rampExitW)
		)
		(super init:)
		(podium_135 init:)
		(ramp_135 init:)
	)
)

(instance rampExitE of ExitFeature
	(properties
		nsLeft 198
		nsTop 20
		nsRight 449
		nsBottom 194
		nextRoom 6607
	)
)

(instance rampExitW of ExitFeature
	(properties
		nsLeft 193
		nsTop 0
		nsRight 441
		nsBottom 223
		nextRoom 6606
	)
)

(instance podium_135 of Feature
	(properties
		noun 42
		nsLeft 134
		nsRight 253
		nsBottom 66
		x 193
		y 33
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance ramp_135 of Feature
	(properties
		noun 44
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 252 70 350 70 351 200 395 291 215 292 253 203
					yourself:
				)
		)
	)
)

(instance ramp_315 of Feature
	(properties
		noun 44
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 233 190 345 189 397 280 180 276
					yourself:
				)
		)
	)
)

(instance desks_315 of Feature
	(properties
		noun 41
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 454 47 479 46 481 21 563 7 542 29 541 34 564 40 569 52 534 60 517 82 491 85 478 51 449 54
					yourself:
				)
		)
	)
)

