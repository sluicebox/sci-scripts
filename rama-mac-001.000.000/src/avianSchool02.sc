;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6601)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)
(use Actor)

(public
	avianSchool02 0
)

(instance avianSchool02 of Location
	(properties)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(6600 ; avianSchool1
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(else
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25
				(switch picObj
					(faceE
						(leftEastMural init: global117)
						(rightEastMural init: global117)
					)
					(faceS
						(leftSouthMural init: global117)
						(rightSouthMural init: global117)
					)
					(faceW
						(leftWestMural init: global117)
						(rightWestMural init: global117)
					)
				)
			)
			(26
				(switch picObj
					(faceE
						(leftEastMural dispose:)
						(rightEastMural dispose:)
					)
					(faceS
						(leftSouthMural dispose:)
						(rightSouthMural dispose:)
					)
					(faceW
						(leftWestMural dispose:)
						(rightWestMural dispose:)
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
		picture 6603
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init:)
		(murals_270 init:)
		(desks_270 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 6605
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init:)
		(murals_180 init:)
		(desks_180 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 6604
		heading 45
		edgeN 0
		edgeS 0
	)

	(method (init)
		(doorExit init:)
		(gCurRoom exitN: doorExit)
		(super init:)
		(murals_45 init:)
		(doorNumbers_45 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(= picture
			(switch [global235 1]
				(0 6641)
				(1 6642)
				(3 6642)
				(else 6602)
			)
		)
		(northExitToCatWalk init:)
		(gCurRoom exitN: northExitToCatWalk)
		(super init:)
		(podium_225 init:)
		(projector_225 init:)
		(desks_225 init:)
	)
)

(instance defaultExit of ExitFeature ; UNUSED
	(properties)
)

(instance leftEastMural of View
	(properties
		x 53
		y 150
		view 6626
	)
)

(instance rightEastMural of View
	(properties
		x 513
		y 110
		view 6626
		cel 1
	)
)

(instance leftSouthMural of View
	(properties
		y 116
		view 6626
		cel 2
	)
)

(instance rightSouthMural of View
	(properties
		x 546
		y 79
		view 6626
		cel 3
	)
)

(instance leftWestMural of View
	(properties
		y 158
		view 6626
		cel 4
	)
)

(instance rightWestMural of View
	(properties
		x 420
		y 130
		view 6626
		cel 5
	)
)

(instance northExitToCatWalk of ExitFeature
	(properties
		nsLeft 234
		nsTop 105
		nsRight 375
		nsBottom 202
		nextRoom 6602
	)
)

(instance doorExit of ExitFeature
	(properties
		nsLeft 234
		nsTop 90
		nsRight 375
		nsBottom 202
		nextRoom 6600
	)
)

(instance podium_225 of Feature
	(properties
		noun 42
		nsLeft 265
		nsTop 59
		nsRight 332
		nsBottom 120
		x 298
		y 89
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance projector_225 of Feature
	(properties
		noun 40
		nsLeft 265
		nsTop 130
		nsRight 327
		nsBottom 184
		x 296
		y 157
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance desks_225 of Feature
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
					init: 7 154 61 161 44 189 15 252 -3 266
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 56 211 91 184 164 196 129 236 102 264 46 290 -4 289 -3 275 73 256 58 213 90 191
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 430 196 498 185 528 218 511 247 512 263 554 275 586 271 590 287 537 290 481 264 473 238 446 228 429 196 490 189
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 567 175 533 192 582 208 584 245 571 252 568 263 591 265 588 180
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
					init: 410 95 421 85 572 83 580 95 567 152 557 161 414 163 404 152
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: -4 40 89 55 98 67 81 151 68 162 4 165
					yourself:
				)
		)
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
					init: 122 279 180 249 212 256 192 286
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 214 251 249 286 284 277 287 237 276 228 243 229
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 319 218 292 244 328 264 339 264 356 225 351 218 324 217
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 398 211 364 233 383 250 399 248 421 217 420 214
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 545 204 435 228 405 245 343 290 405 296 453 233 505 222 563 214
					yourself:
				)
		)
	)
)

(instance murals_45 of Feature
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
					init: -3 34 40 43 55 60 59 150 41 167 2 167
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 548 41 528 59 530 142 545 161 589 161 588 37
					yourself:
				)
		)
	)
)

(instance doorNumbers_45 of Feature
	(properties
		noun 55
		nsLeft 275
		nsTop 82
		nsRight 316
		nsBottom 98
		x 295
		y 90
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance murals_270 of Feature
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
					init: 6 96 16 85 164 90 174 97 181 151 176 160 34 162 21 153
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 501 58 492 75 504 149 519 160 589 162 589 40
					yourself:
				)
		)
	)
)

(instance desks_270 of Feature
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
					init: 27 219 107 206 271 220 370 250 473 279 447 295 371 292 212 243 195 250 262 289 172 293 60 225
					yourself:
				)
		)
	)
)

