;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5511)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	NYMazeL 0
)

(local
	local0
)

(instance NYMazeL of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5524 ; NYMazeZ
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(5512 ; NYMazeM
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(else
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 5558
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 5524 init:)
		(walls_0 init:)
		(super init: &rest)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 5556
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
		picture 5557
		edgeS 0
		edgeN 0
	)

	(method (init)
		(walls_90 init:)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 5659
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (OneOf global256 1 4)
			(= picture 5659)
		else
			(= picture 5559)
		)
		(defaultExit nextRoom: 5512 init:)
		(tuningFork init:)
		(walls_270 init:)
		(gate_270 init:)
		(super init: &rest)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance tuningFork of View
	(properties
		noun 11
		x 256
		y 260
		cel 3
		view 5000
	)

	(method (init)
		(if (== (proc70_9 121) 5512)
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
				(proc70_1 121)
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
		case 4
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 1 590 0 589 213 317 183 273 181 36 216 -1 214
					yourself:
				)
		)
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
					init: -1 0 591 0 590 214 489 202 -1 201
					yourself:
				)
		)
	)
)

(instance walls_180 of Feature
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
					init: 0 0 590 1 589 202 102 202 -1 214
					yourself:
				)
		)
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
					init: 2 3 591 1 589 233 531 229 332 184 258 183 -1 218
					yourself:
				)
		)
	)
)

(instance gate_270 of Feature
	(properties
		noun 10
		x 296
		y 168
		nsBottom 184
		nsLeft 266
		nsRight 327
		nsTop 153
		case 6
	)

	(method (init)
		(if (OneOf global256 1 4)
			(= case 5)
		else
			(= case 6)
		)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

