;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5515)
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
	NYMazeP 0
)

(local
	local0
)

(instance NYMazeP of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5514 ; NYMazeO
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(5516 ; NYMazeQ
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 5574
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 5514 init:)
		(tuningFork init:)
		(walls_0 init:)
		(super init: &rest)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 5572
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(walls_180 init:)
		(super init: &rest)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 5573
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(walls_90 init:)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 5516 init:)
		(if (OneOf global256 3 4)
			(= picture 5675)
		else
			(= picture 5575)
		)
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
		x 142
		y 226
		view 5000
		cel 4
	)

	(method (init)
		(if (== (proc70_9 119) 5515)
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
				(proc70_1 119)
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
					init: 0 1 591 1 590 215 313 181 275 180 34 210 0 210
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
					init: 0 1 589 0 588 214 488 201 -2 201
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
					init: -2 0 589 1 589 200 103 200 -2 215
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
					init: 1 2 591 2 589 210 548 210 312 181 285 179 -1 213
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
					init: 290 1 302 1 300 49 291 49
					yourself:
				)
		)
	)
)

