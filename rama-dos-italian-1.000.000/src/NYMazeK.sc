;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5510)
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
	NYMazeK 0
)

(local
	local0
)

(instance NYMazeK of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5521 ; NYMazeW
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(5509 ; NYMazeJ
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(else
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 5539
		edgeS 0
		edgeN 0
	)

	(method (init)
		(walls_0 init:)
		(super init: &rest)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 5537
		edgeS 0
		edgeN 0
	)

	(method (init)
		(walls_180 init:)
		(super init: &rest)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 5538
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 5521 init:)
		(walls_90 init:)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 5540
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 5509 init:)
		(tuningFork init:)
		(walls_270 init:)
		(sky_270 init:)
		(super init: &rest)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance tuningFork of View
	(properties
		noun 11
		x 528
		y 271
		cel 2
		view 5000
	)

	(method (init)
		(if (== (proc70_9 120) 5509)
			(super init: global117 &rest)
			(self setHotspot: 2 144)
			(if (not local0)
				(= local0 1)
				(proc1111_31 8)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 120)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance walls_0 of Feature
	(properties
		noun 3
		x 295
		y 106
		nsBottom 212
		nsLeft 1
		nsRight 589
		nsTop 1
		case 4
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance walls_90 of Feature
	(properties
		noun 3
		case 4
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 2 589 1 591 216 313 182 277 184 0 219
					yourself:
				)
		)
	)
)

(instance walls_180 of Feature
	(properties
		noun 3
		x 295
		y 105
		nsBottom 210
		nsLeft 1
		nsRight 590
		nsTop 1
		case 4
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance walls_270 of Feature
	(properties
		noun 3
		case 4
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 2 591 1 588 216 306 181 283 181 -2 215
					yourself:
				)
		)
	)
)

(instance sky_270 of Feature
	(properties
		noun 4
		case 4
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 290 1 303 0 300 82 293 81
					yourself:
				)
		)
	)
)

