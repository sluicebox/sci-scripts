;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5518)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use SoundManager)
(use n1111)
(use Polygon)
(use Feature)
(use Actor)

(public
	NYMazeS 0
)

(local
	local0
)

(instance NYMazeS of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5517 ; NYMazeR
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(5309 ; NY_Octospider_Plaza_9
				(SoundManager playMusic: 0 -1 3020)
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(else
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
		)
	)

	(method (dispose)
		(if (== picObj faceE)
			(SoundManager fadeMusic: 0 20 10 1 0)
		)
		(super dispose: &rest)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 5598
		edgeN 0
		edgeS 0
	)

	(method (init)
		(walls_0 init:)
		(super init: &rest)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 5596
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 5517 init:)
		(walls_180 init:)
		(super init: &rest)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 5599
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 5309 init:)
		(walls_90 init:)
		(plaza_90 init:)
		(tuningFork init:)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 5597
		heading 270
		edgeN 0
		edgeS 0
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
		x 55
		y 272
		view 5000
		cel 5
	)

	(method (init)
		(if (== (proc70_9 117) 5518)
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
				(proc70_1 117)
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
					init: 1 2 591 2 588 205 101 201 0 214
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
					init: 1 3 591 2 590 208 550 210 319 181 277 181 -1 213
					yourself:
				)
		)
	)
)

(instance plaza_90 of Feature
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
					init: 281 1 315 0 318 183 283 181
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
					init: 1 2 591 1 590 213 321 181 275 180 35 211 -1 208
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
					init: -1 1 591 2 591 215 489 202 0 202
					yourself:
				)
		)
	)
)

