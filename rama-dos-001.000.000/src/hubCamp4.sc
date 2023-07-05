;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1004)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)

(public
	hubCamp4 0
)

(instance hubCamp4 of Location
	(properties
		noun 20
	)

	(method (init)
		(super init:)
		(= plane global116)
		(self addPicObj: faceW faceE faceW)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 1041
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 80)
			(= picture 1141)
		)
		(super init: &rest)
		(computer init: setHotspot: 2)
		(computer_270 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 1042
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 80)
			(= picture 1142)
		)
		(super init: &rest)
		(exitToBoxes init:)
		(if (proc1111_24 80)
			(darkSky_90 init:)
		)
		(storage_90 init:)
		(lockers_90 init:)
		(gangplank_90 init:)
		(if (proc1111_24 92)
			(avianFlyby play:)
			(SetFlag 92)
		)
	)
)

(instance avianFlyby of VMDMovie
	(properties
		movieName 1200
	)
)

(instance exitToBoxes of ExitFeature
	(properties
		nsBottom 262
		nsLeft 235
		nsRight 448
		nsTop 93
		nextRoom 1003
	)
)

(instance computer of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 2
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 379 67 530 73 508 185 527 283 340 243 374 155
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (proc1111_24 94)
					((ScriptID 1013 0) init: hubCamp4 hubCamp4) ; hubComputer
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance computer_270 of Feature
	(properties
		noun 5
		nsBottom 284
		nsLeft 3
		nsRight 534
		nsTop 3
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 6 4 253 1 342 7 342 144 369 147 377 68 531 71 519 170 562 241 550 288 0 285
					yourself:
				)
		)
	)
)

(instance darkSky_90 of Feature
	(properties
		noun 1
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 2 0 218 1 210 148 2 151 yourself:)
		)
	)
)

(instance gangplank_90 of Feature
	(properties
		noun 3
		x 141
		y 201
		nsBottom 248
		nsLeft 3
		nsRight 280
		nsTop 154
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance lockers_90 of Feature
	(properties
		noun 2
		x 240
		y 136
		nsBottom 158
		nsLeft 228
		nsRight 252
		nsTop 114
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance storage_90 of Feature
	(properties
		noun 7
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 260 133 334 123 385 107 462 106 593 117 591 162 457 153 335 151 261 151
					yourself:
				)
		)
	)
)

