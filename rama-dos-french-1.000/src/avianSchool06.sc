;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6605)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)
(use Actor)

(public
	avianSchool06 0
)

(instance avianSchool06 of Location
	(properties)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(6602 ; avianSchool03
				(self addPicObj: faceN faceE faceSE faceW faceN)
			)
			(else
				(self addPicObj: faceE faceSE faceW faceN faceE)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25
				(switch picObj
					(faceW
						(westMural init: global117)
					)
					(faceSE
						(rightSouthEastMural init: global117)
						(leftSouthEastMural init: global117)
					)
				)
			)
			(26
				(switch picObj
					(faceW
						(westMural dispose:)
					)
					(faceSE
						(rightSouthEastMural dispose:)
						(leftSouthEastMural dispose:)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 225
		picture 6619
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init:)
		(podium_225 init:)
	)
)

(instance faceSE of CameraAngle
	(properties
		picture 6620
		edgeS 0
		edgeN 0
	)

	(method (init)
		(projectorExit init:)
		(gCurRoom exitN: projectorExit)
		(super init:)
		(murals_0 init:)
		(projector_0 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 90
		picture 6621
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 6604 init:)
		(gCurRoom exitN: defaultExit)
		(super init:)
		(mural_90 init:)
		(desks_90 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		heading 180
		picture 6618
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init:)
		(desks_180 init:)
	)
)

(instance westMural of View
	(properties
		x 141
		y 114
		loop 1
		cel 8
		view 6626
	)
)

(instance rightSouthEastMural of View
	(properties
		x 438
		y 178
		loop 1
		cel 7
		view 6626
	)
)

(instance leftSouthEastMural of View
	(properties
		x 146
		y 187
		loop 1
		cel 6
		view 6626
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance projectorExit of ExitFeature
	(properties
		nsBottom 212
		nsLeft 160
		nsRight 359
		nsTop 87
		nextRoom 6602
	)
)

(instance podium_225 of Feature
	(properties
		noun 42
		x 423
		y 85
		nsBottom 132
		nsLeft 351
		nsRight 495
		nsTop 39
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance desks_180 of Feature
	(properties
		noun 41
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 224 241 278 212 343 212 337 265 287 285 235 290 191 289
					yourself:
				)
		)
	)
)

(instance mural_90 of Feature
	(properties
		noun 14
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 120 66 131 50 360 30 374 49 383 161 369 178 164 173 135 157
					yourself:
				)
		)
	)
)

(instance desks_90 of Feature
	(properties
		noun 41
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 11 268 54 267 42 292 yourself:)
				((Polygon new:)
					type: PTotalAccess
					init: 120 262 192 260 224 288 130 288
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 254 272 330 272 328 292 254 293
					yourself:
				)
		)
	)
)

(instance projector_0 of Feature
	(properties
		noun 40
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 172 125 215 119 252 128 284 132 290 141 312 158 302 194 276 198 255 194 244 169 229 154 184 134 178 131
					yourself:
				)
		)
	)
)

(instance murals_0 of Feature
	(properties
		noun 14
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 425 111 428 105 538 99 545 105 549 148 541 158 504 156 436 154 429 151
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 120 105 126 99 229 105 235 110 234 124 201 118 169 125 136 124 122 102
					yourself:
				)
		)
	)
)

