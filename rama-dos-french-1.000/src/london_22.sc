;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3042)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use Polygon)
(use Feature)
(use Actor)

(public
	london_22 0
)

(instance london_22 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(self addPicObj: faceSE faceSW faceNW faceNE faceSE)
	)
)

(instance faceSW of CameraAngle
	(properties
		heading 225
		picture 3227
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(mp_B21x init:)
		(mp_L31x init:)
		(mp_L11z init:)
		(mp_B31z init:)
		(mp_NY_F init:)
		(drain_225 init:)
	)
)

(instance faceNW of CameraAngle
	(properties
		heading 315
		picture 3236
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(northEastExit init:)
		(pipes_315 init:)
		(elevator_315 init:)
		(walkway_315 init:)
		(drains_315 init:)
	)
)

(instance faceSE of CameraAngle
	(properties
		heading 135
		picture 3237
		edgeS 0
		edgeN 0
	)
)

(instance faceNE of CameraAngle
	(properties
		heading 45
		picture 3239
		edgeS 0
		edgeN 0
	)
)

(instance mp_B21x of View
	(properties
		x 290
		y 275
		loop 2
		view 3201
	)

	(method (init)
		(if (== (proc70_9 52) 3040)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 52)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mp_L31x of View
	(properties
		x 282
		y 195
		loop 2
		cel 2
		view 3201
	)

	(method (init)
		(if (== (proc70_9 73) 3040)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 73)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mp_L11z of View
	(properties
		x 290
		y 91
		loop 2
		cel 3
		view 3201
	)

	(method (init)
		(if (== (proc70_9 66) 3040)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 66)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mp_B31z of View
	(properties
		x 207
		y 202
		loop 2
		cel 1
		view 3201
	)

	(method (init)
		(if (== (proc70_9 60) 3040)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 60)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mp_NY_F of View
	(properties
		x 294
		y 105
		loop 2
		cel 4
		view 3201
	)

	(method (init)
		(if (== (proc70_9 88) 3040)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 88)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance northEastExit of ExitFeature
	(properties
		nextRoom 3041
	)
)

(instance drain_225 of Feature
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
					init: 86 2 95 102 190 178 360 103 336 17 338 -2
					yourself:
				)
		)
	)
)

(instance drains_315 of Feature
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
					init: 95 180 96 164 109 143 117 137 126 142 138 162 137 179
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 296 157 305 143 311 143 318 156
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 428 176 427 163 439 145 444 137 460 143 466 162 467 174
					yourself:
				)
		)
	)
)

(instance pipes_315 of Feature
	(properties
		noun 15
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 187 6 172 154 259 162 261 110 261 48 261 2
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 307 3 296 111 296 154 327 161 374 154 371 107 370 55 370 6
					yourself:
				)
		)
	)
)

(instance elevator_315 of Feature
	(properties
		noun 17
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 441 147 445 125 451 106 459 106 475 107 485 110 493 122 492 153
					yourself:
				)
		)
	)
)

(instance walkway_315 of Feature
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
					init: 49 159 281 159 520 151 564 158 333 174 396 295 173 288 263 171
					yourself:
				)
		)
	)
)

