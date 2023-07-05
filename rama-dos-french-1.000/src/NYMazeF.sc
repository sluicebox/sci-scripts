;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5505)
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
	NYMazeF 0
)

(local
	local0
)

(instance NYMazeF of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5504 ; NYMazeE
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(5507 ; NYMazeH
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 5523
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
		picture 5521
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 5504 init:)
		(walls_180 init:)
		(sky_180 init:)
		(super init: &rest)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 5622
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (OneOf global256 0 4)
			(= picture 5622)
		else
			(= picture 5522)
		)
		(defaultExit nextRoom: 5507 init:)
		(tuningFork init:)
		(walls_90 init:)
		(sky_90 init:)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 5524
		edgeS 0
		edgeN 0
	)

	(method (init)
		(walls_270 init:)
		(super init: &rest)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance tuningFork of View
	(properties
		noun 11
		x 149
		y 267
		cel 1
		view 5000
	)

	(method (init)
		(if (== (proc70_9 118) 5505)
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
				(proc70_1 118)
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
					init: 1 2 590 1 589 203 99 202 0 216
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
					init: 1 1 590 0 590 210 554 210 313 182 280 181 0 215
					yourself:
				)
		)
	)
)

(instance sky_90 of Feature
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
					init: 290 0 303 0 298 104 294 104
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
					init: 0 0 591 0 590 214 302 178 288 179 37 210 0 210
					yourself:
				)
		)
	)
)

(instance sky_180 of Feature
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
					init: 291 1 302 1 300 58 292 57
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
					init: 1 2 590 0 590 218 479 200 -1 201
					yourself:
				)
		)
	)
)

