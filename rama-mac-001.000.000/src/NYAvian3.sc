;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5003)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use Polygon)
(use Feature)
(use Actor)

(public
	NYAvian3 0
)

(instance NYAvian3 of Location
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(self addPicObj: faceNW faceNE faceSE faceSW faceNW)
	)
)

(instance faceNE of CameraAngle
	(properties
		picture 5013
		heading 45
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(pylons_45 init:)
	)
)

(instance faceSE of CameraAngle
	(properties
		picture 5012
		heading 135
		edgeN 0
		edgeS 0
	)

	(method (init)
		(loc2Exit init:)
		(super init: &rest)
		(sign_135 init:)
		(pylons_135 init:)
		(lowWall_135 init:)
		(tetrahedron_135 init:)
		(cntrlAlley_135 init:)
	)
)

(instance faceSW of CameraAngle
	(properties
		picture 5015
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(yellowLens init:)
		(super init: &rest)
	)
)

(instance faceNW of CameraAngle
	(properties
		picture 5014
		heading 315
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(avianDoors_315 init:)
	)
)

(instance loc2Exit of ExitFeature
	(properties
		nsLeft 199
		nsTop 82
		nsRight 540
		nsBottom 225
		nextRoom 5002
	)
)

(instance loc9Exit of ExitFeature ; UNUSED
	(properties
		nsLeft 476
		nsTop 144
		nsRight 540
		nsBottom 183
		nextRoom 5009
	)
)

(instance yellowLens of View
	(properties
		x 247
		y 237
		view 5002
		loop 5
	)

	(method (init)
		(if (== (proc70_9 123) 5003)
			(super init: global117 &rest)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 123)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance avianDoors_315 of Feature
	(properties
		noun 4
		nsLeft 347
		nsTop -1
		nsRight 417
		nsBottom 67
		x 382
		y 33
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance pylons_45 of Feature
	(properties
		noun 9
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 509 164 516 159 519 163 524 181 509 183
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 526 167 532 168 535 179 526 183 525 170
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 574 161 578 158 586 163 590 183 572 185 572 165
					yourself:
				)
		)
	)
)

(instance sign_135 of Feature
	(properties
		noun 3
		nsLeft 221
		nsTop 39
		nsRight 250
		nsBottom 79
		x 235
		y 59
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance pylons_135 of Feature
	(properties
		noun 9
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 377 162 381 159 387 181 377 181
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 430 155 438 159 441 155 445 184 432 186
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 477 158 482 156 487 160 488 181 478 182
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 281 166 294 166 298 180 284 180 281 168
					yourself:
				)
		)
	)
)

(instance lowWall_135 of Feature
	(properties
		noun 10
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 160 292 161 294 189 -2 190
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 300 172 374 172 374 179 300 179
					yourself:
				)
		)
	)
)

(instance tetrahedron_135 of Feature
	(properties
		noun 1
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 156 132 205 130 205 175 164 170 155 170
					yourself:
				)
		)
	)
)

(instance cntrlAlley_135 of Feature
	(properties
		noun 13
		nsLeft 481
		nsTop 75
		nsRight 518
		nsBottom 179
		x 499
		y 127
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

