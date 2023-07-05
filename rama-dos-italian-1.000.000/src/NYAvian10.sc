;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5010)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use Polygon)
(use Feature)
(use Actor)

(public
	NYAvian10 0
)

(instance NYAvian10 of Location
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5009 ; NYAvian9
				(self addPicObj: faceSW faceNW faceNE faceSE faceSW)
			)
			(5015 ; NYAvian15
				(self addPicObj: faceNW faceNE faceSE faceSW faceNW)
			)
			(else
				(self addPicObj: faceSE faceSW faceNW faceNE faceSE)
			)
		)
	)
)

(instance faceNE of CameraAngle
	(properties
		heading 45
		picture 5044
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 5009 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(tetrahedron_45 init:)
		(sign_45 init:)
		(wallIcon_45 init:)
	)
)

(instance faceSE of CameraAngle
	(properties
		heading 135
		picture 5041
		edgeS 0
		edgeN 0
	)

	(method (init)
		(mazePiston init:)
		(mazeCard init:)
		(mazeLights init:)
		(defaultExit nextRoom: 5015 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(mazeIcon_135 init:)
		(mazeController_135 init:)
	)
)

(instance faceSW of CameraAngle
	(properties
		heading 225
		picture 5042
		edgeS 0
		edgeN 0
	)
)

(instance faceNW of CameraAngle
	(properties
		heading 315
		picture 5043
		edgeS 0
		edgeN 0
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance mazeCard of View
	(properties
		x 302
		y 187
		loop 13
		cel 6
		view 5002
	)

	(method (init)
		(if (not (== (proc70_9 47) 5016))
			(return)
		)
		(super init: global117 &rest)
	)
)

(instance mazePiston of View
	(properties
		x 290
		y 184
		loop 12
		view 5002
	)

	(method (init)
		(= cel global256)
		(super init: global117 &rest)
	)
)

(instance mazeLights of View
	(properties
		x 284
		y 182
		loop 13
		view 5002
	)

	(method (init)
		(if (not (== (proc70_9 47) 5016))
			(return)
		)
		(= cel global256)
		(super init: global117 &rest)
	)
)

(instance tetrahedron_45 of Feature
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
					init: 284 154 312 155 311 178 290 179
					yourself:
				)
		)
	)
)

(instance sign_45 of Feature
	(properties
		noun 3
		x 286
		y 113
		nsBottom 129
		nsLeft 275
		nsRight 298
		nsTop 98
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance wallIcon_45 of Feature
	(properties
		noun 22
		x 280
		y 24
		nsBottom 44
		nsLeft 266
		nsRight 295
		nsTop 4
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance mazeIcon_135 of Feature
	(properties
		noun 15
		x 295
		y 151
		nsBottom 163
		nsLeft 273
		nsRight 318
		nsTop 140
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance mazeController_135 of Feature
	(properties
		noun 36
		x 296
		y 189
		nsBottom 210
		nsLeft 274
		nsRight 319
		nsTop 168
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

