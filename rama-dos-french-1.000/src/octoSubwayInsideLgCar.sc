;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7910)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	octoSubwayInsideLgCar 0
)

(instance octoSubwayInsideLgCar of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(7907 ; octoSubwayCarLarge
				(self addPicObj: faceCar faceStation faceCar)
			)
			(else
				(self addPicObj: faceStation faceCar faceStation)
			)
		)
	)
)

(instance faceCar of CameraAngle
	(properties
		heading 270
		picture 7940
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(LSUBWAY_270 init:)
		(SCARF_270 init:)
		(doorLatch init:)
	)
)

(instance faceStation of CameraAngle
	(properties
		heading 90
		picture 7941
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToStation init:)
		(gCurRoom exitN: exitToStation)
		(super init:)
		(EXITSTATION_90 init:)
		(SCARF_90 init:)
	)
)

(instance exitToStation of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 7907
	)
)

(instance LSUBWAY_270 of Feature
	(properties
		noun 63
		nsBottom 272
		nsLeft 59
		nsRight 448
		nsTop 39
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance SCARF_270 of Feature
	(properties
		noun 65
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 455 64 454 76 447 88 449 137 457 165 467 165 468 132 462 82 466 75 464 70 458 65
					yourself:
				)
		)
	)
)

(instance EXITSTATION_90 of Feature
	(properties
		noun 69
		nsBottom 262
		nsLeft 173
		nsRight 401
		nsTop 88
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance SCARF_90 of Feature
	(properties
		noun 65
		nsBottom 195
		nsLeft 27
		nsRight 60
		nsTop 33
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance doorLatch of Feature
	(properties
		nsBottom 245
		nsLeft 266
		nsRight 318
		nsTop 215
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
			)
			(2
				(proc1111_31 31)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

