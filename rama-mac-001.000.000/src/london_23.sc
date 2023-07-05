;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3043)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use Polygon)
(use Feature)
(use Actor)

(public
	london_23 0
)

(instance london_23 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(self addPicObj: faceNW faceNE faceSE faceSW faceNW)
	)
)

(instance faceSW of CameraAngle
	(properties
		picture 3243
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(drain_225 init:)
		(pipe_225 init:)
	)
)

(instance faceNW of CameraAngle
	(properties
		picture 3240
		heading 315
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance faceSE of CameraAngle
	(properties
		picture 3242
		heading 135
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(southEastExit init:)
		(mp_L32x init:)
		(drains_135 init:)
		(walkway_135 init:)
	)
)

(instance faceNE of CameraAngle
	(properties
		picture 3227
		heading 45
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(mp_B11y init:)
		(mp_L32y init:)
		(mp_B31x init:)
		(mp_NY_C init:)
		(drain_45 init:)
	)
)

(instance southEastExit of ExitFeature
	(properties
		nextRoom 3041
	)
)

(instance mp_B11y of View
	(properties
		x 393
		y 284
		view 3201
		loop 1
	)

	(method (init)
		(if (== (proc70_9 50) 3040)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 50)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mp_L32y of View
	(properties
		x 288
		y 135
		view 3201
		loop 1
		cel 2
	)

	(method (init)
		(if (== (proc70_9 77) 3040)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 77)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mp_B31x of View
	(properties
		x 398
		y 59
		view 3201
		loop 1
		cel 3
	)

	(method (init)
		(if (== (proc70_9 58) 3040)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 58)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mp_L32x of View
	(properties
		x 333
		y 262
		view 3201
		loop 3
	)

	(method (init)
		(if (== (proc70_9 76) 3040)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 76)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mp_NY_C of View
	(properties
		x 187
		y 196
		view 3201
		loop 1
		cel 1
	)

	(method (init)
		(if (== (proc70_9 85) 3040)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 85)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance drain_45 of Feature
	(properties
		noun 33
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 89 4 93 106 196 178 369 106 341 18 341 2
					yourself:
				)
		)
	)
)

(instance drains_135 of Feature
	(properties
		noun 33
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 72 179 76 163 87 141 92 140 102 160 108 175
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 280 158 287 143 299 157 293 162
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 452 177 450 163 463 141 470 139 491 165 493 182
					yourself:
				)
		)
	)
)

(instance pipe_225 of Feature
	(properties
		noun 15
		nsLeft 279
		nsTop 2
		nsRight 508
		nsBottom 198
		x 393
		y 100
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance drain_225 of Feature
	(properties
		noun 33
		nsLeft 76
		nsTop 148
		nsRight 95
		nsBottom 165
		x 85
		y 156
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance walkway_135 of Feature
	(properties
		noun 16
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 107 160 267 170 191 292 398 292 320 170 454 169 465 141 476 141 491 166 555 162 563 161 558 152 500 155 324 153 247 155 120 152 98 150
					yourself:
				)
		)
	)
)

