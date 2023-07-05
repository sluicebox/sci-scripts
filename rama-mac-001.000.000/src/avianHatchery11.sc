;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6811)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)
(use Actor)

(public
	avianHatchery11 0
)

(instance avianHatchery11 of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(self addPicObj: faceNE faceS faceNE)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25
				(switch picObj
					(faceS
						(northMural1 init: global117)
						(northMural2 init: global117)
					)
				)
			)
			(26
				(switch picObj
					(faceS
						(northMural1 dispose:)
						(northMural2 dispose:)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 6870
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 6810 init:)
		(gCurRoom exitN: defaultExit)
		(super init:)
		(murals_180 init:)
		(incubator_180 init:)
	)
)

(instance faceNE of CameraAngle
	(properties
		picture 6871
		heading 45
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init:)
		(incubator_45 init:)
	)
)

(instance defaultExit of ExitFeature
	(properties
		nsLeft 101
		nsTop 61
		nsRight 523
		nsBottom 245
	)
)

(instance northMural1 of View
	(properties
		y 130
		view 6811
	)
)

(instance northMural2 of View
	(properties
		x 535
		y 114
		view 6811
		cel 1
	)
)

(instance incubator_45 of Feature
	(properties
		noun 38
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 232 115 299 90 373 114 373 126 350 127 370 162 400 167 375 203 297 202 281 204 328 229 371 224 379 195 401 198 413 225 433 241 411 257 429 260 453 255 497 260 518 269 538 237 563 241 582 289 90 292 90 267 132 260 201 246 220 208 230 210 224 200 208 170 236 161 245 137 245 127 230 124 231 106
					yourself:
				)
		)
	)
)

(instance incubator_180 of Feature
	(properties
		noun 38
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 0 89 51 99 56 169 4 174 yourself:)
				((Polygon new:)
					type: PTotalAccess
					init: 103 108 145 114 143 159 100 167
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 513 70 510 122 594 122 589 69
					yourself:
				)
		)
	)
)

(instance murals_180 of Feature
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
					init: -3 87 52 96 53 171 -1 182 95 106 146 110 146 159 101 165 502 70 589 67 590 123 505 126
					yourself:
				)
		)
	)
)

