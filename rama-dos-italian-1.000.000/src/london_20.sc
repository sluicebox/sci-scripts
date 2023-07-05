;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3040)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use Polygon)
(use Feature)
(use Actor)

(public
	london_20 0
)

(instance london_20 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(3033 ; london_18
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(else
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 3227
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init:)
		(mp_B21y init:)
		(mp_B11z init:)
		(mp_L22z init:)
		(mp_CP_B init:)
		(drains_180 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 3228
		edgeS 0
		edgeN 0
	)

	(method (init)
		(westExitToLondon21 init:)
		(super init:)
		(walkway_270 init:)
		(drains_270 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 3226
		edgeS 0
		edgeN 0
	)
)

(instance faceN of CameraAngle
	(properties
		picture 3225
		edgeS 0
		edgeN 0
	)

	(method (init)
		(northExitToLondon18 init:)
		(super init:)
		(elevator_0 init:)
	)
)

(instance westExitToLondon21 of ExitFeature
	(properties
		nextRoom 3041
	)
)

(instance northExitToLondon18 of ExitFeature
	(properties
		nextRoom 3033
		exitStyle 256
	)
)

(instance mp_B21y of View
	(properties
		x 249
		y 139
		cel 1
		view 3201
	)

	(method (init)
		(if (== (proc70_9 53) 3040)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 53)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mp_B11z of View
	(properties
		x 354
		y 81
		cel 2
		view 3201
	)

	(method (init)
		(if (== (proc70_9 51) 3040)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 51)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mp_L22z of View
	(properties
		x 380
		y 124
		cel 3
		view 3201
	)

	(method (init)
		(if (== (proc70_9 72) 3040)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 72)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mp_CP_B of View
	(properties
		x 270
		y 255
		view 3201
	)

	(method (init)
		(if (== (proc70_9 11) 3040)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 11)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance drains_180 of Feature
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
					init: 64 0 195 184 367 106 338 12 338 1
					yourself:
				)
		)
	)
)

(instance drains_270 of Feature
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
					init: 133 145 121 166 123 178 155 177 150 163 143 142
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 284 144 275 157 295 157 293 144
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 484 143 468 164 468 178 510 182 506 162 489 141
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 563 150 578 149 578 169 555 166
					yourself:
				)
		)
	)
)

(instance walkway_270 of Feature
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
					init: 31 160 120 164 131 144 142 140 158 167 265 168 198 280 196 292 390 283 312 171 465 164 483 140 503 167 558 158 543 151 321 156 271 156 152 155 71 152
					yourself:
				)
		)
	)
)

(instance elevator_0 of Feature
	(properties
		noun 17
		x 291
		y 128
		nsBottom 257
		nsLeft 157
		nsRight 425
		nsTop -1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

